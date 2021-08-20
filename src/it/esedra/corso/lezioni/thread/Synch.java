package it.esedra.corso.lezioni.thread;

class CallMe {
	private int x = 0;

	synchronized void call(String msg) {
		System.out.print("[" + msg);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}

		System.out.println("]");
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
}

class Caller implements Runnable {
	private String msg;
	private CallMe target;

	public Caller(CallMe t, String s) {
		target = t;
		msg = s;
		new Thread(this).start();
	}

	public void run() {
		synchronized (target) {
			target.call(msg);
		}
	}
}

public class Synch {
	public static void main(String args[]) {
		CallMe target = new CallMe();
		new Caller(target, "Hello");
		new Caller(target, "Synchronized");
		new Caller(target, "World");
	}
}