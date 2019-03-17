package job.reflect.good;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements myInterface,myinteface2{

    private int id;
    private String name;
    private int age;


    public Person(String name) {
        this.name = name;
    }

    @Override
    public void interfaceMethod() {
        System.out.println("interfaceMethod ...");
    }

    public static void staticMethod(){
        System.out.println("static Method ...");
    }

    private void privateMethod(){
        System.out.println("private Method ...");
    }
    private void privateMethod2(String name){
        System.out.println("private Method ..." + name);
    }

    @Override
    public void myinterface2() {
        System.out.println("myinterface2 Method...");
    }
    /**
     * 反射的概念
     * 在程序运行过程中
     * 对于任意一个类 都能知道这个类的所有属性和方法
     * 对于任意一个类 都能够调用它的任意方法和属性
     *
     * 反射提供的功能
     * 在运行时判断任意一个对象所属的类
     * 在运行时构造任意一个类的对象
     * 在运行时判断任意一个类所具有的成员变量和方法
     * 在运行时调用任意一个对象的方法
     * 生成动态代理
     *
     * */

}
