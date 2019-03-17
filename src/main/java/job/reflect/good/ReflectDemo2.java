package job.reflect.good;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo2 {
//获取方法
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
//        Class 入口
//        Class<?> perClazz = Class.forName("job.reflect.good.Person");
//       获取所有公共方法(1.本类、父类、接口中所有的方法 2.符合访问修饰符的规律)
//        Method[] methods = perClazz.getMethods();
//        for (Method method: methods) {
//            System.out.println(method);
//        }
//        demo2();
//        demo3();
//        demo4();
//        demo5();
        demo9();
    }
//    获取所有接口
    public static void demo2() throws ClassNotFoundException {
        Class<?> perClazz = Class.forName("job.reflect.good.Person");
        Class<?>[] interfaces = perClazz.getInterfaces();
        for (Class<?> inteface: interfaces) {
            System.out.println(inteface);
        }
    }
//    获取所有父类
    public static void demo3() throws ClassNotFoundException {
        Class<?> perClazz = Class.forName("job.reflect.good.Person");

        Class<?> superclass = perClazz.getSuperclass();
        System.out.println(superclass);
    }
//    获取所有构造方法
    public static void demo4() throws ClassNotFoundException {
        Class<?> perClazz = Class.forName("job.reflect.good.Person");
        Constructor<?>[] constructors = perClazz.getConstructors();
        for (Constructor<?> constructor: constructors) {
            System.out.println(constructor);
        }
    }
//    获取所有的属性
    public static void demo5(){
        try {
            Class<?> perClazz = Class.forName("job.reflect.good.Person");
            Field[] fields = perClazz.getFields();
            for (Field field:fields) {
                System.out.println(field);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//    获取所有方法
    public static void demo6(){
        try {
            Class<?> perClazz = Class.forName("job.reflect.good.Person");
            Method[] methods = perClazz.getDeclaredMethods();
            for (Method method:methods) {
                System.out.println(method);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//    获取公共属性
    public static void demo8(){
        try {
            Class<?> perClazz = Class.forName("job.reflect.good.Person");
            Field[] fields = perClazz.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//    获取所有属性
    public static void demo7(){
        try {
            Class<?> perClazz = Class.forName("job.reflect.good.Person");
            Field[] declaredFields = perClazz.getDeclaredFields();
            for (Field field : declaredFields) {
                System.out.println(field);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//    获取对象实例
    public static void demo9() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName("job.reflect.good.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Person instance = (Person)perClazz.newInstance();
        Field id = perClazz.getDeclaredField("id");
//        private 只有本类可以访问
//        解决访问权限的问题修改属性访问权限instance.setAccessible(true)

        id.setAccessible(true);
        id.set(instance,1);
//操作方法
        System.out.println(instance.getId());
        Method method = perClazz.getDeclaredMethod("privateMethod2", String.class);
        method.setAccessible(true);
        method.invoke(instance, "zvl");

    }
//    获取构造方法
    public static void demo10() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName("job.reflect.good.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Constructor<?> constructor = perClazz.getDeclaredConstructor(String.class);
        Person zcl = (Person)constructor.newInstance("zcl");
        System.out.println(zcl);
    }
}
