package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetCountService {

//	@Autowired
//	RedisDao redisDao ;
	
	public int countTweets()
	{
		return 3 ;
	}
}
