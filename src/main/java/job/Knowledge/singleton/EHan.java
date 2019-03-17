package job.Knowledge.singleton;

public class EHan {
/**
 * 私有构造方法
 * */
    private EHan(){

    }
    /**
     * 私有静态引用指向自己的实例
     * */
    private static EHan eHan = new EHan();
    /**
     *以自己实例为返回值的公有静态方法
     * */
    public static EHan getInstance(){
        return eHan;
    }
}
