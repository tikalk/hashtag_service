package demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@ImportResource("classpath:applicationContextEvyatar.xml")
public class Application {

	
	@Bean
    JedisConnectionFactory connectionFactory() {
        return new JedisConnectionFactory();
    }
	
	@Bean
    StringRedisTemplate template(JedisConnectionFactory connectionFactory) {
        return new StringRedisTemplate(connectionFactory);
    }
	
    public static void main(String[] args) {
        //SpringApplication.run(Application.class, args);
    	ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

    	
    	// redis
//    	StringRedisTemplate template = ctx.getBean(StringRedisTemplate.class);
//        template.convertAndSend("chat", "Hello from Redis!");
        
        
        @SuppressWarnings("unchecked")
		Service<User> userService = (Service<User>)ctx.getBean("userService");
        
        User user1 = new User("user1ID", "User 1");
        User user2 = new User("user2ID", "User 2");
        
        System.out.println("==== getting objects from redis ====");
        System.out.println("User is not in redis yet: " + userService.get(user1));
        System.out.println("User is not in redis yet: " + userService.get(user2));
        
//        System.out.println("==== putting objects into redis ====");
//        userService.put(user1);
//        userService.put(user2);
//        
//        System.out.println("==== getting objects from redis ====");
//        System.out.println("User should be in redis yet: " + userService.get(user1));
//        System.out.println("User should be in redis yet: " + userService.get(user2));        
    }
}
