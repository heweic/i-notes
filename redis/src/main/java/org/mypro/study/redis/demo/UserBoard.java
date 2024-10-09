package org.mypro.study.redis.demo;

import java.util.Random;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mypro.study.redis.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

/**
 * @author hew 使用redis Set数据结构功能实现实时统计排行榜
 */
@Component
public class UserBoard implements ApplicationRunner {
	private static Log log = LogFactory.getLog(UserBoard.class);
	private Object lock = new Object();
	private volatile boolean isRun = false;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	private static String key = "user_board";
	
	private static int maxCount = 3;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// 防止重复执行
		synchronized (lock) {
			if (isRun) {
				log.info("注意：重复执行");
				return;
			}
			isRun = true;
		}
		
		new Thread(new printUserSocre()).start();
		new Thread(new RandomChangeScore()).start();

	}

	/**
	 * 定时打印排行榜分数
	 */
	class printUserSocre implements Runnable {

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000 * 5);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//
				Set<Object> users = redisTemplate.opsForZSet().reverseRange(key, 0, maxCount - 1);
				
				
				log.info("查询排行榜");
				for (Object user : users) {
					log.info(new Gson().toJson(user) + "分数：" + redisTemplate.opsForZSet().score(key, user));
				}

			}

		}

	}

	/**
	 * 随机改变玩家分数
	 */
	class RandomChangeScore implements Runnable {

		private int count = 0;
		
		private String[]  ids;

		@Override
		public void run() {
			ids = new String[maxCount];

			//
			redisTemplate.delete(key);

			while (true) {
				//
				if (count < maxCount) {
					// 填充数据
					User user = new User();

					user.setId("name-" + count);
					user.setScore(new Random().nextInt(100));

					ids[count] = user.getId();
					//log.info("添加:" + user.getId() + "分数:" + user.getScore());
					redisTemplate.opsForZSet().add(key, user.getId(), user.getScore());

					count++;
				} else {
					// 随机修改数据
					
					int randomIndex = new Random().nextInt(maxCount);
					int randomSocre = new Random().nextInt(100);
					
				//	log.info("修改:" +ids[randomIndex] + "分数:" + randomSocre);
					redisTemplate.opsForZSet().add(key, ids[randomIndex], randomSocre);
				}
				//
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
