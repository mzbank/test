package job.thread.contact;

public class Question implements Runnable {

    ThreadContact contact;

    public Question(ThreadContact contact) {
        this.contact = contact;
//        new Thread(this).start();
    }

    String[] msg = {"hi","how are you ?", "let's go to swing ?"};

    @Override
    public void run() {

        for (int i = 0; i < msg.length; i++) {
            contact.Ask(msg[i]);
        }

    }
}
