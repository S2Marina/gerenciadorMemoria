package tpac;

public class MyMonitor {
	static volatile int v = 0;

	public synchronized static void incV() {
		for (int i = 1; i <= 5000; i++) {
			v++;
			System.out.println(v);
		}
	}

	public static void raceIncV() {
		for (int i = 1; i <= 5000; i++) {
			v++;
			System.out.println(v);
		}
	}

	public synchronized static void decV() {
		for (int i = 1; i <= 5000; i++) {
			v--;
			System.out.println(v);
		}
	}

	public static void raceDecV() {
		for (int i = 1; i <= 5000; i++) {
			v--;
			System.out.println(v);
		}
	}
}
