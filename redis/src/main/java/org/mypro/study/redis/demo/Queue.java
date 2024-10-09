package org.mypro.study.redis.demo;

import java.util.UUID;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mypro.study.redis.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

/**
 * @author redis 实现简单队列应用场景
 * 
 * 
 *         一个线程添加任务，一个线程消费任务
 */
//@Component
public class Queue implements ApplicationRunner {

	private static Log log = LogFactory.getLog(Queue.class);
	private Object lock = new Object();
	private volatile boolean isRun = false;

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Autowired
	private RedisMessageListenerContainer container;

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
		// 启动添加任务线程

		new Thread(new Producer()).start();

		// 注册监听器
		container.addMessageListener(new Consumer(), channelTopic);

	}

	private String queueName = "test_queue";
	private ChannelTopic channelTopic = new ChannelTopic(queueName);

	class Consumer implements MessageListener {

		@Override
		public void onMessage(Message message, byte[] pattern) {
			log.info("收到队列消息:" + new String(message.getBody()));
		}

	}

	class Producer implements Runnable {

		@Override
		public void run() {

			for (int i = 0; i < 10; i++) {
				User user = new User();
				user.setAge(i);
				user.setId(UUID.randomUUID().toString());
				user.setName(UUID.randomUUID().toString());

				redisTemplate.convertAndSend(channelTopic.getTopic(), new Gson().toJson(user));

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
