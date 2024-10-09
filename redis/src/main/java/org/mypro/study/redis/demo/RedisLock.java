package org.mypro.study.redis.demo;

/**
 * @author hew
 * 自定义redis分布式锁接口
 * 
 */
public interface RedisLock {

	/**
	 * 尝试加锁
	 * @return
	 * @throws InterruptedException
	 */
	 boolean tryLock()throws InterruptedException;
	 
	 /**
	  * 释放锁
	  */
	 void unlock();
}
