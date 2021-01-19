package org.mypro.study.designpatterns.creative.builder;

/**
 * 待建造bean, 实例化较复杂
 * 
 * @author hew
 * @time 2021年1月19日 上午11:50:40
 */
public class Product {

	private String part1;
	private String part2;
	private String part3;

	public Product() {
	}

	public String getPart1() {
		return part1;
	}

	public void setPart1(String part1) {
		this.part1 = part1;
	}

	public String getPart2() {
		return part2;
	}

	public void setPart2(String part2) {
		this.part2 = part2;
	}

	public String getPart3() {
		return part3;
	}

	public void setPart3(String part3) {
		this.part3 = part3;
	}

}
