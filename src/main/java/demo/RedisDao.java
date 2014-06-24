package demo;

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisDao {

	private static Date now = new Date(12345678) ;
	
	@Autowired
	RedisTemplate<String, Cachable> redisTemplate;

    
    public int putDummyData()
    {
    	//Date now = new Date() ;
    	Date oneMinuteAgo = new Date(now.getTime() - 60000) ;
    	redisTemplate.opsForHash().put(String.valueOf(now.getTime()), "#abc", 5);
    	redisTemplate.opsForHash().put(String.valueOf(now.getTime()), "#def", 6);
    	redisTemplate.opsForHash().put(String.valueOf(now.getTime()), "#ghi", 7);

    	redisTemplate.opsForHash().put(String.valueOf(oneMinuteAgo.getTime()), "#abc", 15);
    	redisTemplate.opsForHash().put(String.valueOf(oneMinuteAgo.getTime()), "#def", 16);
    	redisTemplate.opsForHash().put(String.valueOf(oneMinuteAgo.getTime()), "#ghi", 17);

    	return 0 ;
    }
    
    public HashSet<String> getSomethingWithRedis()
    {
//    	Object obj = redisTemplate.opsForHash().get("12345678", "#abc");
    	Object obj = redisTemplate.opsForHash().keys("12345678");
    	return (HashSet<String>)obj ;
    }
}
