package job.singleton;

import java.io.IOException;

public class SingleMain {

    public static void main(String[] args) throws IOException {

        Singleton s = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s == s2);
//        Runtime 类就是单例实现的

        Runtime runtime = Runtime.getRuntime();
//        runtime.exec("shutdown -s -t 3000");
        runtime.exec("shutdown -a");
    }
}

