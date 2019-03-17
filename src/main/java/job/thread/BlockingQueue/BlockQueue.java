package job.thread.BlockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockQueue {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        Provider provider = new Provider(queue);
        Consumer consumer = new Consumer(queue);
        new Thread(provider).start();
        new Thread(consumer).start();
    }
}
