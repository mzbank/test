package job.rpc.server.impl;

import job.rpc.server.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerImpl implements Server {

    private static HashMap<String, Class> ServiceRegister = new HashMap<>();
    private static int port ;
//    连接池：连接池中存放多个连接对象，每个对象都可以处理一个客户端请求
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    private static boolean isRunning = false;//服务器是否启动


    public ServerImpl(int port){
        this.port = port;
    }
//    服务段开启服务
    @Override
    public void start() {
        ServerSocket server = null;
        try {
            server = new ServerSocket();
            server.bind(new InetSocketAddress(port));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        开启多线程并发
        isRunning = true;
        while (true){

            Socket socket = null;
            System.out.println("server start ....");
            //        等待客户端连接
            try {
                socket = server.accept();
            }catch (Exception e){
                e.printStackTrace();
            }
            executor.execute(new ServiceTask(socket));
        }
    }

    @Override
    public void end() {

        isRunning = false;
        executor.shutdown();
    }

//    注册服务 通过map将服务注册到注册中心
    @Override
    public void register(Class service, Class serviceImpl) {

        ServiceRegister.put(service.getName(), serviceImpl);

    }

    class ServiceTask implements Runnable{

        Socket socket;
        public ServiceTask(Socket socket){
            this.socket = socket;
        }
        public ServiceTask(){

        }

        @Override
        public void run() {//线程所做的事情
            ObjectInputStream input = null;
            ObjectOutputStream output = null;
            try {

//        接受客户端请求并处理
                input = new ObjectInputStream(socket.getInputStream());
//        序列化流对发送数据的顺序严格要求,需要按发送的顺序逐个接受
                String serviceName = input.readUTF();
                String methodName = input.readUTF();
                Class[] parameterTypes =(Class[])input.readObject();
                Object[] argsTypes =(Object[])input.readObject();
//        根据客户端请求找到具体接口
                Class ServiceClass = ServiceRegister.get(serviceName);//HelloService
                Method method = ServiceClass.getMethod(methodName, parameterTypes);
                Object result = method.invoke(ServiceClass.newInstance(), argsTypes);

//        向客户端将方法执行完毕的返回值传给客户端
                output = new ObjectOutputStream(socket.getOutputStream());
                output.writeObject(result);
            }catch (Exception e){
                e.printStackTrace();
            }
            finally {
                try {

                    if (output != null)output.close();
                    if (input != null)input.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        }

}
