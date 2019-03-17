package job.rpc.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Client {
//    获取代表服务端的动态代理对象
//    serviceName 请求服务的接口
    public static <T> T getRemoteProxyObj(Class serviceInterface, InetSocketAddress addr){
/**
 * a.类加载器，需要代理那个类
 * b.需要代理的对象，具备哪些方法 -- 接口
 * c.但继承多实现
 * */
        return (T)Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class<?>[]{serviceInterface}, new InvocationHandler() {
//
// proxy 需要代理的对象 method 那个方法 args 参数列表

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) {
                ObjectOutputStream outputStream  = null;
                ObjectInputStream input = null;
//                客户端向服务端发送请求
                Socket socket = new Socket();
                try {
                    socket.connect(addr);
                    outputStream  = new ObjectOutputStream(socket.getOutputStream());//发送：序列化流(对象流)
//                接口名、方法名、
                    outputStream.writeUTF(serviceInterface.getName());
                    outputStream.writeUTF(method.getName());
// 方法参数、方法参数类型
                    outputStream.writeObject(method.getParameterTypes());
                    outputStream.writeObject(args);
//                等待服务处理
//                服务端处理后的结果
                    input = new ObjectInputStream(socket.getInputStream());

                    return input.readObject();

                }catch (Exception e){
                    e.printStackTrace();
                    return null;
                }finally {
                    try {

                        if (outputStream != null)outputStream.close();
                        if (input != null)input.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }) ;
    }
}