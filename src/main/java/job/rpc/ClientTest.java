package job.rpc;

import job.rpc.client.Client;
import job.rpc.service.HelloService;

import java.net.InetSocketAddress;

public class ClientTest {
    public static void main(String[] args) throws ClassNotFoundException {
        HelloService service = Client.getRemoteProxyObj(Class.forName("job.rpc.service"), new InetSocketAddress("127.0.0.1",9999));
        System.out.println(service.say("zs"));
    }
}
