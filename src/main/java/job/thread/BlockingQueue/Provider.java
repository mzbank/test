package job.thread.BlockingQueue;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Provider implements Runnable{

    BlockingQueue<Integer> queue;

    public Provider(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {


        try {
                for (int i = 0; i < 50; i++) {
                    Random random = new Random();
                    int time = random.nextInt(1000);
                    Thread.sleep(time);
                    queue.put(time);
                    System.out.println("睡眠时间是: " + time);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
        }
    }
}
