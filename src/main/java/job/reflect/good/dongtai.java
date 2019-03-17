package job.reflect.good;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

public class dongtai {

    public static void dongtai01() throws IOException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
//动态代理
        Properties prop = new Properties();
        prop.load(new FileReader("class.txt"));

        String classname = prop.getProperty("classname");
        String methodname = prop.getProperty("methodname");
        Class<?> perClazz = null;
        try {
            perClazz = Class.forName(classname);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method method = perClazz.getMethod(methodname);
        method.invoke(perClazz.newInstance());
    }
//    越过泛型检查

    public static void dongtai02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2324);
        list.add(23);
        list.add(454);
//        list.add("zs");
        Class<?> listClazz = list.getClass();
        Method method = listClazz.getMethod("add", Object.class);
        method.invoke(list, "zs...");
        System.out.println(list);

    }
    public static void demo01() throws NoSuchMethodException, IllegalAccessException, NoSuchFieldException {
        Person person = new Person();
        Student student = new Student();
        PropertyUtil.setProperty(person, "name", "zs...");
        PropertyUtil.setProperty(person, "age", 18);
        PropertyUtil.setProperty(student, "socre", 98);
        System.out.println(person.getAge() +"," +person.getName());
        System.out.println(student.getSocre());
    }
}
