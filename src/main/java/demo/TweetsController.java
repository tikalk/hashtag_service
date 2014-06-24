package demo;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TweetsController extends SocialController {

	@Autowired
	TweetCountService tweetCountService ; 
	
//	@RequestMapping("/lastTweets/minutes/{numberOfMinutesBackward}")
//	public String countTweets(@PathVariable int numberOfMinutesBackward) {
//		return "123:" + numberOfMinutesBackward ;
//	}
	
//	@RequestMapping("/lastTweets/minutes/{numberOfMinutesBackward}")
//	public String countTweets(@PathVariable int numberOfMinutesBackward) {
//		String response = "[{\"9:54:00\":{\"tweets\":{\"#abc\":59,\"#WWW\":51,\"#swd\":49,\"#qas\":39,\"#def\":7}}},{\"9:53:00\":{\"tweets\":{\"#abc\":59,\"#WWW\":51,\"#swd\":39,\"#qas\":29,\"#def\":7}}},{\"9:52\":{\"tweets\":{\"#abc\":59,\"#WWW\":51,\"#swd\":49,\"#qas\":39,\"#def\":7}}},{\"9:51\":{\"tweets\":{\"#abc\":59,\"#WWW\":51,\"#swd\":49,\"#qas\":39,\"#def\":7}}}]" ;				
//		return response ;
//	}
	
	@RequestMapping("/lastTweets/minutes/{numberOfMinutesBackward}")
	@Produces(MediaType.APPLICATION_JSON)
	public Object countTweets(
			@PathParam("numberOfMinutesBackward")
			Integer numberOfMinutesBackward) {
		//Object dummy = tweetCountService.countTweets() ;
//		System.out.println(dummy);
//		return dummy ;
		String response = //"[{\"9:54:00\":{\"tweets\":{\"#abc\":59,\"#WWW\":51,\"#swd\":49,\"#qas\":39,\"#def\":7}}},{\"9:53:00\":{\"tweets\":{\"#abc\":59,\"#WWW\":51,\"#swd\":39,\"#qas\":29,\"#def\":7}}},{\"9:52\":{\"tweets\":{\"#abc\":59,\"#WWW\":51,\"#swd\":49,\"#qas\":39,\"#def\":7}}},{\"9:51\":{\"tweets\":{\"#abc\":59,\"#WWW\":51,\"#swd\":49,\"#qas\":39,\"#def\":7}}}]" ;
		"[{\"1403608360901\":{\"#def\":5,\"#abc\":53}},{\"1403608300901\":{\"#def\":5,\"#abc\":53}},{\"1403608240901\":{\"#def\":5,\"#abc\":53}},{\"1403608360901\":{\"#def\":5,\"#abc\":53}}]" ;
		return response ;
	}

	
	@RequestMapping("/lastTweets/seconds/{numberOfSecondsBackward}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Map<Long, Map<String, Integer>>> countTweets2(
			@PathParam("numberOfSecondsBackward")
			Integer numberOfSecondsBackward) {
		Map<String, Integer> x = new HashMap<>() ;
		x.put("#abc", 53);
		x.put("#def", 5);
		Map<Long, Map<String, Integer>> y = new HashMap<>() ;
		y.put((new Date()).getTime(), x) ;
		List<Map<Long, Map<String, Integer>>> ret = new ArrayList<>() ;
		ret.add(y) ;
		ret.add(y) ;
		ret.add(y) ;
		ret.add(y) ;
		return ret ;
	}

}
