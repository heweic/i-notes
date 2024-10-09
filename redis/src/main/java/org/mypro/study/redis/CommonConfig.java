package org.mypro.study.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Configuration
public class CommonConfig {

	@Bean
	Gson gson() {
		return new GsonBuilder().setPrettyPrinting().create();
	}

	@Bean
	RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);

		// 设置 key 的序列化器
		template.setKeySerializer(new StringRedisSerializer());
		// 设置 value 的序列化器
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		//

		return template;
	}

	@Bean
	RedisMessageListenerContainer redisMessageListenerContainer(RedisConnectionFactory redisConnectionFactory) {
		RedisMessageListenerContainer container = new RedisMessageListenerContainer();
		//
		container.setConnectionFactory(redisConnectionFactory);
		//
		return container;
	}
}
