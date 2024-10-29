package org.mypro.study.algorithms.search;

import java.util.ArrayList;
import java.util.List;

public class Hanota {

	public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {

		doRemove(A.size(), A, B, C);

	}

	public void doRemove(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
		if (n == 1) {
			moveOne(A, C);
			return;
		}
		//
		doRemove(n - 1, A, C, B);
		//
		moveOne(A, C);
		//
		doRemove(n - 1, B, A, C);
	}

	private void moveOne(List<Integer> from, List<Integer> to) {
		System.out.println("将:" + from.get(from.size() - 1) +"移动到" + to.hashCode());
		to.add(from.remove(from.size() - 1));
	}
	
	
	public static void main(String[] args) {
		Hanota hanota = new Hanota();
		
		List<Integer> sources = new ArrayList<Integer>();
		
		sources.add(3);
		sources.add(2);
		sources.add(1);
		
		List<Integer> target = new ArrayList<Integer>();
		
		hanota.hanota(sources, new ArrayList<Integer>(), target);
		
		System.out.println("");
	}
}
