package org.mypro.study.designpatterns.structured.adapter;

/**
 * 类适配 使用 泛化/继承 关系
 * 
 * @author hew
 * @time 2021年1月20日 上午9:51:08
 */
public class ClassAdapter extends RealService implements Target {

	/** 
	 * 
	 */
	@Override
	public int add(int a, int b, int c) {
		return add(a, b) + c;
	}

}
