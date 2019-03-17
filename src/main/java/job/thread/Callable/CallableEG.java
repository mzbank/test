package job.thread.Callable;

import java.util.concurrent.Callable;

public class CallableEG implements Callable<Long> {
    private int number;
    public CallableEG(int number){
        this.number = number;
    }

    @Override
    public Long call() throws Exception {

//        java Callable 可以返回由线程计算后的结果
//        runnable 只能运行线程
        /*
        *callable 对象返回future对象，该对象监控线程运行状态，
        * 线程执行结束后 ，从callable
        * 中检索结果
        * */

        return factorial();
    }
    private Long factorial(){

        long result = 1;
        while (number != 0 ){
            result = number * result;
            number --;
        }
        return result;
    }

}
