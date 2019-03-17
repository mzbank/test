package job.rpc.service.impl;

import job.rpc.service.HelloService;

public class HelloServiceImpl implements HelloService {
    @Override
    public String say(String name) {
       return  "hillo" + name;
    }
}
