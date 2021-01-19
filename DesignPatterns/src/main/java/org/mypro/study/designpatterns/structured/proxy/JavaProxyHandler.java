package org.mypro.study.designpatterns.structured.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * JAVA 动态代理
 * 
 * @author hew
 * @time 2021年1月19日 下午3:17:51
 */
public class JavaProxyHandler implements InvocationHandler {

	private Handler handler;

	public JavaProxyHandler(Handler handler) {
		this.handler = handler;
	}

	public void preHandle() {
		System.out.println("preHandle");
	}

	public void postHandle() {
		System.out.println("postHandle");
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println(proxy.getClass() + "  " + method.getName());
		preHandle();
		Object rs = method.invoke(handler, args);
		postHandle();
		return rs;
	}

}
