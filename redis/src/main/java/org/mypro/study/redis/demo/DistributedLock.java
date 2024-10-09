package org.mypro.study.redis.demo;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @author hew 在分布式常见开发中，用锁保证并发编程的原子操作
 * 
 *         使用多个线程模拟分布式环境，对同一个变量执行累加操作
 */
//@Component
public class DistributedLock implements ApplicationListener<ApplicationEvent> {

	private static Log log = LogFactory.getLog(DistributedLock.class);
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
//

	private Thread t1 = null;
	private Thread t2 = null;

	private Object lock = new Object();
	private volatile boolean isRun = false;

	//
	private int count;

	private RedisLock redisLock;

	@Override
	public void onApplicationEvent(ApplicationEvent event) {

		// 防止重复执行
		synchronized (lock) {
			if (isRun) {
				log.info("注意：重复执行");
				return;
			}
			isRun = true;
		}

		//

		redisLock = new RedisTemplateLock("123", "123", redisTemplate);

		//

		log.info("重置计数:");
		count = 0;

		t1 = new Thread(new Add(), "addThread-1");

		t1.start();
		log.info("模拟启动分布式进程1");
		isRun = true;

		t2 = new Thread(new Add(), "addThread-2");
		t2.start();
		log.info("模拟启动分布式进程2");
		isRun = true;

		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			// t2.start();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("模拟分布式结果:" + count + "获取锁失败次数:" + faildCount.get());

	}

	private AtomicInteger faildCount = new AtomicInteger(0);

	class Add implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {

				try {
					if (redisLock.tryLock()) {
						log.info("获得锁");
						count++;
					} else {
						faildCount.incrementAndGet();
						log.info("获取锁失败");
					}

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					log.info("释放锁");
					redisLock.unlock();
				}

			}

		}

	}

}
