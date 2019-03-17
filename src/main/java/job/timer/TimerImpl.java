package job.timer;

import java.util.Date;
import java.util.Timer;

public class TimerImpl {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        timer.schedule(new Task(), new Date(119, 3, 16, 19, 11, 30));
        while (true) {
            Thread.sleep(1000);
            System.out.println(new Date());
        }
    }
}
