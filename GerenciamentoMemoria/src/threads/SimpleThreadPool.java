package tpac;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Thread worker = new WorkerThread("" + (i + 1));
            executor.execute(worker);
          }
        executor.shutdown();
        
        while (!executor.isTerminated()) {
        }
        if (executor.isTerminated()) {
        	 System.out.println("Finished all threads");
        }
    }
}