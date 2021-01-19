package org.mypro.study.designpatterns.creative.builder;

public class DefaultBuilder extends Builder {

	@Override
	public void buildPart1() {
		product.setPart1("部分1");
		
	}

	@Override
	public void buildPart2() {
		product.setPart2("部分2");
		
	}

	@Override
	public void buildPart3() {
		product.setPart3("部分3");
	}

}


