package job.thread.contact;

public class Answer implements Runnable {

    ThreadContact contact;

    public Answer(ThreadContact contact) {
        this.contact = contact;
//        new Thread(this).start();
    }

    String[] msg = {"hi", "l'm fine!", "ok"};

    @Override
    public void run() {
        for (int i = 0; i < msg.length; i++) {
            contact.Reply(msg[i]);
        }
    }
}
