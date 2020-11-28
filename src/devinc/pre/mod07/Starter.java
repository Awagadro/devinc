package devinc.pre.mod07;

public class Starter {
	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			new MyThread("T-" + i);
		}

	}
}
