package job.Knowledge.distinct;

import org.apache.log4j.Logger;

public class Test {

    private static Logger logger = Logger.getLogger(Test.class);
    public static void main(String[] args) {
        ListDistinct distinct= new ListDistinct();
        distinct.listDisc();
        logger.info("我是log4j !!!!");
        distinct.dist2();

        System.out.println("数组去重");

        TupleDist  dist= new TupleDist();
        Object[] objects = {11,23,434,555,666,555,33,23,11};
        System.out.println("第一种方法去重结果：");
        Object[] newobj = dist.tupledis(objects);
        for (int i = 0; i < newobj.length; i++) {
            System.out.print(newobj[i]+ "  ");
        }

        System.out.println();
        System.out.println("set方法去重结果");
        Object[] newobj2 = dist.objdist2(objects);
        for (int i = 0; i < newobj2.length; i++) {
            System.out.print(newobj2[i]+"  ");
        }
    }
}
