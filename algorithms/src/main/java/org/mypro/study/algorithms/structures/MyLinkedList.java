package org.mypro.study.algorithms.structures;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hew 链表
 * 单向链表
 * 双向链表
 * 循环链表
 */
public class MyLinkedList {

	public static void main(String[] args) {
		
		List<String> list = new LinkedList<String>();
		
		list.add("1");
		list.add("2");
		list.add("3");
		//
		for(String i : list) {
			System.out.println(i);
		}
		
		list.get(1);
	}
}
