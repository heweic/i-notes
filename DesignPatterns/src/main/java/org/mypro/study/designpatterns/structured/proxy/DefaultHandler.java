package org.mypro.study.designpatterns.structured.proxy;

public class DefaultHandler implements Handler {

	@Override
	public void handle() {
		System.out.println("real ....");
	}

	@Override
	public void test() {
		System.out.println("test method..");
	}

}


