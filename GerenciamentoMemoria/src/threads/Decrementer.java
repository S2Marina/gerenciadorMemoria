package tpac;

public class Decrementer extends Thread {

	public void run() {
		/*
		 * try{ Thread.currentThread().join(); }catch (Exception e){
		 * System.out.println("Join Failed!"); }
		 */
		MyMonitor.decV();
		//MyMonitor.raceDecV();
	}

}
