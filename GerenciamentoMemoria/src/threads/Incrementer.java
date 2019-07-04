package tpac;

public class Incrementer extends Thread {

	public void run() {
		/*
		 * try{ Thread.currentThread().join(); }catch (Exception e){
		 * System.out.println("Join Failed!"); }
		 */
		MyMonitor.incV();
		//MyMonitor.raceIncV();
	}

}
