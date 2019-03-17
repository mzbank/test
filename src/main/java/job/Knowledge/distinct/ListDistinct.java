package job.Knowledge.distinct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDistinct {

    /**
     * 为什么使用 hashcode
     * String 类型的 hashcode 方法
     * 为什么大部分 hashcode 方法使用 31
     * HashMapImpl 的 hash 算法的实现原理（为什么右移 16 位，为什么要使用 ^ 位异或）
     * HashMapImpl 为什么使用 & 与运算代替模运算？
     * HashMapImpl 的容量为什么建议是 2的幂次方？
     * 我们自定义 HashMapImpl 容量最好是多少？
     */

    public void listDisc() {
        System.out.println("方法一：");
        List<Integer> num = new ArrayList<Integer>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                num.add(j);
            }
        }
//        创建一个临时列表存放去重后的数据
        List<Integer> temp = new ArrayList<Integer>();
        for (Integer i : num) {
            if (!temp.contains(i)) {
                temp.add(i);
            }
        }
        System.out.println("去重前：");
        for (Integer i : num) {

            System.out.print(i + " ");

        }
        System.out.println();
        System.out.println("去重后： ");
        for (Integer i : temp) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void dist2() {
        System.out.println("方法二：使用iterator的remove方法");
        /**
         * 使用it
         *
         * */
        List<Integer> nums = new ArrayList<Integer>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                nums.add(j);
            }
        }
        System.out.println("去重前： " +" ");
        for (Integer i : nums) {
            System.out.print(i +" ");
        }
        System.out.println();
        List<Integer> temp = new ArrayList<Integer>();
        Iterator<Integer> iterator = nums.iterator();
        while (iterator.hasNext()) {
            int t = iterator.next();
            if (temp.contains(t)){
                iterator.remove();
            }else {
                temp.add(t);
            }
        }
        System.out.println("去重后： "  +" ");

        for (Integer i :temp) {
            System.out.print(i +" ");
        }
    }
}
