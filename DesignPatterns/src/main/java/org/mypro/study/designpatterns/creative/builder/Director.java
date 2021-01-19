package org.mypro.study.designpatterns.creative.builder;

/**
 * 指挥者，调用 builder 创建bean
 * 
 * @author hew
 * @time 2021年1月19日 上午11:55:24
 */
public class Director {

	private Builder builder;

	public Director(Builder builder) {
		super();
		this.builder = builder;
	}

	public Product construct() {
		//
		builder.buildPart1();
		builder.buildPart2();
		builder.buildPart3();
		//
		return builder.getResult();
	}
}
