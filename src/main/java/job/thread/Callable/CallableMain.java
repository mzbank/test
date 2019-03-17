package job.thread.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableMain {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Long> factorial10 = executor.submit(new CallableEG(10));
        Future<Long> factorial20 = executor.submit(new CallableEG(20));

        Long result10 = null;
        Long result20 = null;
        try {
            result10 = factorial10.get();
            result20 = factorial20.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(result10);
        System.out.println(result20);
    }
}