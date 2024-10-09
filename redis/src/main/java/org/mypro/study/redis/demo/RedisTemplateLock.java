package org.mypro.study.redis.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author hew 使用redisTemplate实现的锁
 */
public class RedisTemplateLock  implements RedisLock{
	
	
	private String key ;
	private String id;
	private RedisTemplate<String, Object> redisTemplate;
	
	//private 

	public RedisTemplateLock(String key, String id, RedisTemplate<String, Object> redisTemplate) {
		super();
		this.key = key;
		this.id = id;
		this.redisTemplate = redisTemplate;
	}

	@Override
	public boolean tryLock() throws InterruptedException {
		boolean rs = redisTemplate.opsForValue().setIfAbsent(key + id, id, 10, TimeUnit.SECONDS);
		//仅仅做演示，实际项目中不能这样使用
		
		while(!rs) {
			Thread.sleep(1000);
			rs = redisTemplate.opsForValue().setIfAbsent(key + id, id, 10, TimeUnit.SECONDS);
			//拿锁失败，休眠后尝试再拿取，适合的分布式场景中建议使用RedissonClient实现
		}
		
		//
		return rs;
	}

	@Override
	public void unlock() {
		String currentValue = (String) redisTemplate.opsForValue().get(key +id);
		if(currentValue.equals(currentValue)) {
			redisTemplate.delete(key+id);
		}
		
	}

}
