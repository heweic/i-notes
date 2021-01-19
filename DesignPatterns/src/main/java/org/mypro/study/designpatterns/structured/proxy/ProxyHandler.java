package org.mypro.study.designpatterns.structured.proxy;

/**
 * 
 * 静态代理
 * 
 * @author hew
 * @time 2021年1月19日 下午3:06:25
 */
public class ProxyHandler implements Handler {

	private Handler handler = new DefaultHandler();

	public void preHandle() {
		System.out.println("preHandle");
	}

	public void postHandle() {
		System.out.println("postHandle");
	}

	@Override
	public void handle() {

		preHandle();
		//
		handler.handle();
		//
		postHandle();
	}

	@Override
	public void test() {
		handler.test();
	}

}
