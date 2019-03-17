package job.thread.contact;

public class ThreadContact {

    public boolean flag = false;

    public synchronized void Ask(String msg){
        if (flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag = true;
        notify();
    }

    public synchronized void Reply(String msg){
        if (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(msg);
        flag = false;
        notify();
    }

    public static void main(String[] args) {

        ThreadContact contact = new ThreadContact();

        Question question = new Question(contact);
        Answer answer = new Answer(contact);
       new Thread(question).start();
       new Thread(answer).start();
    }
}
