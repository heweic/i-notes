package org.mypro.study.apidemo.future;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

	public static void main(String[] args) {

		CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("异步..");
		});
		System.out.println("----------");

		try {
			completableFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//

		
		
		HashMap map = new HashMap<String, String>();
		
		map.put("123", new Object());
		//(n - 1) & hash
		
		String key = "123";
		
		int hash = hash(key);
		
		System.out.println(hash("123"));
		
		System.out.println(hash("123"));
		
		
	}
	
	 static final int hash(Object key) {
	        int h;
	        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	    }
}
