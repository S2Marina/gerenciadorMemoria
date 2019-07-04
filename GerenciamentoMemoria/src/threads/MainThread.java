package tpac;

public class MainThread {

	public static void main(String args[]) {
		Incrementer i = new Incrementer();
		Decrementer d = new Decrementer();
		i.start();
		d.start();
	
	}

}
