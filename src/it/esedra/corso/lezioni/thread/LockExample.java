package it.esedra.corso.lezioni.thread;

import java.util.concurrent.locks.*;
import java.util.concurrent.*;

public class LockExample implements Runnable {
	private int numeroIntero;
	private Lock lock;

	public static void main(String[] args) {
		LockExample le = new LockExample(3);
		LockExample le2 = new LockExample(2);

		Thread t1 = new Thread(le, "Le");
		Thread t2 = new Thread(le, "Le2");

		t1.start();
		t2.start();
	}

	public LockExample(int numeroIntero) {
		this.numeroIntero = numeroIntero;
		this.lock = new ReentrantLock();
	}

	@Override
	public void run() {
		try {
			if (lock.tryLock(5, TimeUnit.SECONDS)) {
				numeroIntero++;
				System.out.println("In lock " + numeroIntero + " " + Thread.currentThread().getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		System.out.println("Out lock " + numeroIntero + " " + Thread.currentThread().getName());
	}
}