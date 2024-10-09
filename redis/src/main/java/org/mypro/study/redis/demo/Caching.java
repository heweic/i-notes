package org.mypro.study.redis.demo;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mypro.study.redis.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 使用redis 作为缓存，减少数据访问
 * 
 * @author hew
 * 
 *         演示缓存的读写
 */
//@Component
public class Caching implements ApplicationListener<ApplicationEvent> {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private static User demoUser;
	private static String demoUserId;
	static {

		demoUserId = UUID.randomUUID().toString().replaceAll("-", "");

		//
		demoUser = new User();
		demoUser.setId(demoUserId);
		demoUser.setName("张三");
		demoUser.setAge(31);
	}

	/**
	 * 
	 */
	public synchronized void doLoadCache() {

		if (redisTemplate.opsForValue().get(demoUser.getId()) == null) {
			redisTemplate.opsForValue().set(demoUser.getId(), demoUser);
		}
	}

	public User visitUser(String id) {
		User user;
		//
		user = (User) redisTemplate.opsForValue().get(id);
		//
		return user;
	}

	private Thread loadThread = null;
	private Thread vistThread = null;

	private Object lock = new Object();

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		// TODO Auto-generated method stub
		synchronized (lock) {
			if (loadThread == null) {
				loadThread = new Thread(new LoadCache(this));
				loadThread.start();
			}
			if (vistThread == null) {
				vistThread = new Thread(new VisitUser(this));
				vistThread.start();
			}
		}
	}

	/**
	 * @author hew 定时访问User ，并Log
	 */
	class VisitUser implements Runnable {

		private static Log log = LogFactory.getLog(VisitUser.class);
		private Caching caching;

		public VisitUser(Caching caching) {
			super();
			this.caching = caching;
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000 * 3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				User user = caching.visitUser(demoUserId);

				log.info(user);

			}

		}

	}

	/**
	 * @author hew 执行缓存加载任务
	 */
	class LoadCache implements Runnable {
		private static Log log = LogFactory.getLog(LoadCache.class);
		private Caching caching;

		public LoadCache(Caching caching) {
			super();
			this.caching = caching;
		}

		@Override
		public void run() {
			while (true) {
				log.info("判断User是否在redis中");
				caching.doLoadCache();
				try {
					Thread.sleep(1000 * 10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}

}
