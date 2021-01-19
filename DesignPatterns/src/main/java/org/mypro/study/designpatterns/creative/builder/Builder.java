package org.mypro.study.designpatterns.creative.builder;

/**
 * 抽象建造者
 * 
 * @author hew
 * @time 2021年1月19日 上午11:52:16
 */
public abstract class Builder {

	protected Product product = new Product();

	public abstract void buildPart1();

	public abstract void buildPart2();

	public abstract void buildPart3();

	public Product getResult() {
		return product;
	}

}
