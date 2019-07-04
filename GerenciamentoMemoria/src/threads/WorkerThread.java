package tpac;

public class WorkerThread extends Thread {

    private String command;

    public WorkerThread(String s){
        this.command=s;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName()+ " Start. Command = " + command);
        processCommand();
        System.out.println(Thread.currentThread().getName()+ " End.");
    }

    public void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}