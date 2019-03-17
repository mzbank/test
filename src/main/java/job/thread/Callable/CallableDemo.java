package job.thread.Callable;

import java.util.concurrent.Callable;

public class CallableDemo {

    public static void main(String[] args) {
        simpleDemo simpleDemo1 = new simpleDemo(4);
        Integer intege = null;
        try {
            intege = simpleDemo1.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(intege);

    }
    private static class simpleDemo implements Callable<Integer>{

        private int num;

        private simpleDemo(int num){
            this.num = num;
        }
        @Override
        public Integer call() throws Exception {
            int result = 1;
            while (num != 0){

                result = result * num;
                num --;
            }
            return result;
        }
    }
}
