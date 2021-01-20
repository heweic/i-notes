package org.mypro.study.designpatterns.structured.adapter;

/**
 * 对象适配， 使用聚合关系
 * 
 * @author hew
 * @time 2021年1月20日 上午9:55:03
 */
public class ObjectAdapter implements Target {

	private RealService realService = new RealService();

	@Override
	public int add(int a, int b, int c) {

		return realService.add(a, b) + c;
	}

}
