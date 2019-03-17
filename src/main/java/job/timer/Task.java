package job.timer;

import java.util.TimerTask;

public class Task extends TimerTask {

    @Override
    public void run() {
        System.out.println("起床背单词");
    }
}
