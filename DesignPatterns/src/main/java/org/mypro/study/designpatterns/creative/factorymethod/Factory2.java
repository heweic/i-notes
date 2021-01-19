package org.mypro.study.designpatterns.creative.factorymethod;

public class Factory2  implements AbstractFactory {

	@Override
	public Product newProduct() {
		return new Product2();
	}

}


