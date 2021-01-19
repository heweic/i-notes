package org.mypro.study.designpatterns.creative;

/**
 * 
 * 单例-懒汉模式
 * 
 * @author hew
 * @time 2021年1月19日 上午10:22:17
 */
public class LazySingleton {

	private static volatile LazySingleton bean;

	//
	private LazySingleton() {
	}

	/**
	 * 
	 * 
	 * @return
	 */
	public synchronized static LazySingleton getSingletonBean() {
		if (null == bean) {
			bean = new LazySingleton();
		}

		return bean;
	}
}
