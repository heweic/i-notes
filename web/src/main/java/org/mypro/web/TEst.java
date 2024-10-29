package org.mypro.web;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class TEst {
	private Semaphore hy = new Semaphore(2);
	private Semaphore ox = new Semaphore(1);
	private CyclicBarrier br = new CyclicBarrier(3);

	public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		hy.acquire();
		try {
			br.await();
			releaseHydrogen.run();
		} finally {
			hy.release();
		}

	}

	public void oxygen(Runnable releaseOxygen) throws InterruptedException {
		ox.acquire();
		try {
			br.await();
			releaseOxygen.run();
		}catch (Exception e) {
			
		} finally {
			ox.release();
		}
	}
}
