package org.mypro.study.algorithms.structures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hew
 * 
 * 数组
 */
public class MyArray {

	
	public static void main(String[] args) {
		//基本数组
		
		int[] nums = new int[3];
		
		nums[0] = 1;
		nums[1] =2;
		nums[2] = 3;
		
		for(int i = 0 ; i < nums.length ; i ++ ) {
			System.out.println(nums[i]);
		}
		//动态数组 Array
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		for(Integer i : list) {
			System.out.println(i);
		}
		
	}
}
