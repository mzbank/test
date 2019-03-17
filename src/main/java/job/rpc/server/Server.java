package job.rpc.server;

import java.io.IOException;

public interface Server {
//    启动
    void start() throws IOException;
//    关闭
    void end();
//    注册服务
    void register(Class service, Class serviceImpl);
}
