package demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisDao {

	private static Date now = new Date(12345678) ;
	
	@Autowired
	RedisTemplate<String, Cachable> redisTemplate;

    
//    public int putDummyData()
//    {
//    	//Date now = new Date() ;
//    	Date oneMinuteAgo = new Date(now.getTime() - 60000) ;
//    	redisTemplate.opsForHash().put(String.valueOf(now.getTime()), "#abc", 5);
//    	redisTemplate.opsForHash().put(String.valueOf(now.getTime()), "#def", 6);
//    	redisTemplate.opsForHash().put(String.valueOf(now.getTime()), "#ghi", 7);
//
//    	redisTemplate.opsForHash().put(String.valueOf(oneMinuteAgo.getTime()), "#abc", 15);
//    	redisTemplate.opsForHash().put(String.valueOf(oneMinuteAgo.getTime()), "#def", 16);
//    	redisTemplate.opsForHash().put(String.valueOf(oneMinuteAgo.getTime()), "#ghi", 17);
//
//    	return 0 ;
//    }
    
    public List<Map<Long, Map<Object, Object>>> getSomethingWithRedis()
    {
    	List<Map<Long, Map<Object, Object>>> list = new ArrayList<>();
//    	long key1 = now.getTime() ;
//    	long key2 = now.getTime() - 60000 ;
    	
//    	Object obj = redisTemplate.opsForHash().get("12345678", "#abc");
    	//Object obj = redisTemplate.opsForHash().keys("12345678");
    	
    	Set<String> allKeys = redisTemplate.keys("*") ;
    	
    	if (allKeys.isEmpty())
    	{
    		return list ;
    	}
    	
    	SortedSet<String> sorted = new TreeSet<>(allKeys) ;
    	String[] arr = sorted.toArray(new String[]{}) ;
    	
    	//Set<String> allKeys = redisTemplate.randomKey() ;
    	//Object obj1 = redisTemplate.opsForHash().keys(Long.toString(key1));
    	//Object obj2 = redisTemplate.opsForHash().keys(Long.toString(key2));
    	
    	//List<Map<Long, Map<Object, Object>>> list = new ArrayList<>();
    	//Map<Long, Map<Object, Object>> y = new HashMap<>() ;

//    	for (int i = 0 ; i < 5 ; i++)
//    	{
//    		String key = redisTemplate.randomKey() ;
//        	y.put(Long.parseLong(key), redisTemplate.opsForHash().entries(key)) ;
//    		
//    	}

//    	int counter = 0 ;
//    	for (String key : allKeys)
//    	{
//    		Map<Long, Map<Object, Object>> y = new HashMap<>() ;
//        	y.put(Long.parseLong(key), redisTemplate.opsForHash().entries(key)) ;
//        	list.add(y) ;
//        	counter ++ ;
//        	if (counter > 5) break ;
//    	}

    	for (int i = 0 ; i<5 ; i++)
    	{
    		Map<Long, Map<Object, Object>> y = new HashMap<>() ;
    		Map<Object, Object> entries = redisTemplate.opsForHash().entries(arr[i]) ;
    		//SortedSet<Object> sortedHashtags = new TreeSet<>(entries.keySet()) ;
    		Map<Object, Object> entriesSortedByKey = new TreeMap<>(entries) ;
        	y.put(Long.parseLong(arr[i]), entriesSortedByKey) ;
        	list.add(y) ;
    	}
//    	y.put(key1, redisTemplate.opsForHash().entries(Long.toString(key1))) ;
//    	y.put(key2, redisTemplate.opsForHash().entries(Long.toString(key2))) ;
    	
    	return list;
    }
}
