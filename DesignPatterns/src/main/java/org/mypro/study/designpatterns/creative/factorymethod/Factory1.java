package org.mypro.study.designpatterns.creative.factorymethod;

public class Factory1 implements AbstractFactory {

	@Override
	public Product newProduct() {
		return new Product1();
	}

}


