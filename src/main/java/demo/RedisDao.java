//package demo;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//
//@Component
//public class RedisDao {
//
//	private StringRedisTemplate template;
//
//    @Autowired
//    public RedisDao(StringRedisTemplate template) {
//        this.template = template;
//    }
//    
//    public int doSomethingWithRedis()
//    {
//    	template.dump("9:54:00") ;
//    	template.convertAndSend("chat", "Hello from Redis!");
//    	return 0 ;
//    }
//}
