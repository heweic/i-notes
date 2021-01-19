package org.mypro.study.designpatterns.structured.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {

	public void preHandle() {
		System.out.println("preHandle");
	}

	public void postHandle() {
		System.out.println("postHandle");
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("执行方法:  " + method.getName());
		preHandle();

		Object rs = proxy.invokeSuper(obj, args);

		postHandle();

		return rs;
	}

}
