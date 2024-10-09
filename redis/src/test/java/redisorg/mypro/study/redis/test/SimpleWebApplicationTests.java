package redisorg.mypro.study.redis.test;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import com.google.gson.Gson;

@SpringBootTest
class SimpleWebApplicationTests {

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Test
	void contextLoads() {

		try {
			//redisTemplate.opsForValue().set("test", "test");
			//System.out.println(redisTemplate.opsForValue().get("test"));
			
			redisTemplate.opsForSet().add("index", 1);
			redisTemplate.opsForSet().add("index", 2);
			redisTemplate.opsForSet().add("index", 3);
			
			Set<Object> set = redisTemplate.opsForSet().members("index");
			
			//redisTemplate.opsfor
			
			System.out.println(new Gson().toJson(set));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
