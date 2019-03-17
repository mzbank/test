package job.Knowledge.distinct;

import java.util.HashSet;
import java.util.Set;

/**
 * 数组去重
 * */
public class TupleDist {

    public Object[] tupledis(Object[] obj){
        System.out.println("方法一：传入一个数据 返回去重后的数组");
        Object[] temobj = new Object[obj.length];
        int t = 0;
        for (int i = 0; i < obj.length; i++) {
            boolean isTrue = true;
            for (int j = i+1; j < obj.length; j++) {
                if (obj[i] == obj[j]){
                    isTrue =false;
                    break;
                }
            }
            if (isTrue){
                temobj[t] = obj[i];
                t++;
            }

        }
        Object[] newobj = new Object[t];
        System.arraycopy(temobj,0,newobj,0,t);
        return newobj;
    }
    public Object[] objdist2(Object[] obj){

        System.out.println("方法二：使用hashSet去重");
        Set set = new HashSet();
        for (int i = 0; i < obj.length; i++) {
            set.add(obj[i]);
        }

        return set.toArray();
    }
}
