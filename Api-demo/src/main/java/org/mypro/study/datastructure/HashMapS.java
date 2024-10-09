package org.mypro.study.datastructure;

import java.util.HashMap;

public class HashMapS {

	public static void main(String[] args) {
		
		
		String key = "123";
		
		HashMap map = new HashMap<String, String>();

		
		System.out.println(hash(key));
		
		/**
		 * n为数组长度，通过resize方式不断调整大小
		 * 通过公式 (n - 1) & hash计算元素封装桶的位置，
		 * 当出现元素index冲突时，采取链表或红黑树解决冲突
		 * 时间复杂度 O(1) O(n) O(logn)
		 */
		map.put(key, new Object());
		// 
		
		System.out.println(map.get(key));

		

		int hash = hash(key);
		
		System.out.println(15 & hash);

		System.out.println(hash("123"));

		System.out.println(hash("123"));
	}

	static final int hash(Object key) {
		int h;
		return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
	}
}
