package com.lynda.javatraining.threads;

public class Main {

	public static void main(String[] args) {
	
		int iterations = 3;
		
		//MyThread thread = new MyThread();
		//thread.start();
	//	MyRunnable runnable = new  MyRunnable();
		Thread thred2 = new Thread(new MyRunnable());
		thred2.start();
		try {
			for (int i = 0; i < iterations; i++) {
				System.out.println("from main process");
				Thread.sleep(2500);
			}
		} catch (InterruptedException e) {
			System.err.println(e);
		}
		thred2.interrupt();
		System.out.println("Calleed intrerrupt()");
		
	}

}
