package org.mypro.study.apidemo.beanutil;

public class Toys {

	private String name;

	private String size;

	
	
	public Toys(String name, String size) {
		super();
		this.name = name;
		this.size = size;
	}

	public Toys() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
