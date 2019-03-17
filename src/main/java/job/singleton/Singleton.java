package job.singleton;

//饿汉模式
public class Singleton {

    private Singleton(){

    }
    private static Singleton instance = new Singleton();

    public static Singleton getInstance(){
        return instance;
    }
}
//懒汉模式
class LazySingleton{

    private static LazySingleton singleton;

    private LazySingleton(){

    }
    public static synchronized LazySingleton getInstance(){
        if (singleton == null){
            singleton = new LazySingleton();
        }
        return singleton;
    }
}