package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service ("userService")
public class UserService implements demo.Service<User> {

	@Autowired
	RedisTemplate<String, Cachable> redisTemplate;

	@Override
	public void put(User user) {
		redisTemplate.opsForHash().put(user.getObjectKey(), user.getKey(), user);
	}

	@Override
	public void delete(User key) {
		redisTemplate.opsForHash().delete(key.getObjectKey(), key.getKey());
	}

	@Override
	public User get(User key) {
		return (User) redisTemplate.opsForHash().get(key.getObjectKey(), key.getKey());
	}
}
