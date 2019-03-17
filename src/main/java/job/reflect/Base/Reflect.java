package job.reflect.Base;

public class Reflect {

    /**java 反射创建的三种方式
     *
     *1.对象获取 --> 对象.getClass方法
     *
     *2.全类名获取 --> Class.forName(全类名)
     *
     *3.类名获取 --> 类名.class
     *
     * */
    public static void main(String[] args) {

        System.out.println(Rf.name);
    }
}
class Rf{
    public static String name = "next week I will get a job !";

    static {
        System.out.println("我是静态代码块");
    }

    public Rf() {

        System.out.println("构造 方法 ！");
    }
}