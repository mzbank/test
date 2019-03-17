package job.reflect.Base;

public class Base {

    static int num= 1;

    static {
        System.out.println("base " + num);
    }
}

class test{
    public static void main(String[] args) throws ClassNotFoundException {
//        不会初始化代码快
        Class clazz1 = Base.class;
        System.out.println("----");

//        会初始化代码快
        Class<?> clazz2 = Class.forName("job.reflect.Base.Base");
    }
}