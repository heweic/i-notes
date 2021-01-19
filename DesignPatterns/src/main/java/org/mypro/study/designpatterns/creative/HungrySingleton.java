package org.mypro.study.designpatterns.creative;

/**
 * 单例-饿汉模式
 * @author hew
 * @time 2021年1月19日 上午10:26:32
 */
public class HungrySingleton {

	private static final HungrySingleton HUNGRY_SINGLETON = new HungrySingleton();

	private HungrySingleton() {
	}

	public HungrySingleton getInstance() {
		return HUNGRY_SINGLETON;
	}
}
