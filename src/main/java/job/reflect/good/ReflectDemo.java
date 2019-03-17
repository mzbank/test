package job.reflect.good;

public class ReflectDemo {
    /**
     * 获取反射对象三种方法(反射入口) Class 1.Class.ForName()
     *
     * */
    public static void main(String[] args) {
//        第一种方法 Class.ForName()
        try {
            Class<?> perClazz = Class.forName("job.reflect.good.Person");
            System.out.println(perClazz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        第二种方法 类名.class
        Class<?> perClazz2 = Person.class;
        System.out.println(perClazz2);
        //    第三种方法 对象.getClass()
        Person person = new Person();
        Class<?> perClazz3 = person.getClass();
    }


}
