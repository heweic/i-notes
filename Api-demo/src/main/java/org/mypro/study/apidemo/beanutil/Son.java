package org.mypro.study.apidemo.beanutil;

import java.util.ArrayList;
import java.util.List;

public class Son extends Father implements Cloneable {

	private String head;

	private List<Toys> toys = new ArrayList<Toys>();

	public Son() {
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public List<Toys> getToys() {
		return toys;
	}

	public void setToys(List<Toys> toys) {
		this.toys = toys;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
	
	

}
