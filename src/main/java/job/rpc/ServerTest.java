package job.rpc;

import job.rpc.server.Server;
import job.rpc.server.impl.ServerImpl;
import job.rpc.service.HelloService;
import job.rpc.service.impl.HelloServiceImpl;

import java.io.IOException;

public class ServerTest {

    public static void main(String[] args) throws IOException {
        Server server = new ServerImpl(9999);
//        将helloService helloserviceImpl
        server.register(HelloService.class, HelloServiceImpl.class);
        server.start();
    }
}
