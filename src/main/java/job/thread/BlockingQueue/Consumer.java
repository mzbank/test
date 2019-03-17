package job.thread.BlockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            try {
                System.out.println("我拿到你的睡眠时间： " + queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
