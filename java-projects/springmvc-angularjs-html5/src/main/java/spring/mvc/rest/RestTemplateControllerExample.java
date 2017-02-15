package spring.mvc.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import spring.mvc.bean.PostJSON;

@RestController //will add automatically the @ResponseBody annotation to all methods
public class RestTemplateControllerExample {
	
	  @Autowired
	  private RestTemplate restTemplate;	 
	  
	  //JSON http://jsonplaceholder.typicode.com/ free JSON service
	  @RequestMapping(value = "/posts", method = RequestMethod.GET)
	  public List<PostJSON> getPosts() {

		  //JSON http://jsonplaceholder.typicode.com/posts
		  ResponseEntity<PostJSON[]> response = restTemplate.getForEntity(
			        "http://jsonplaceholder.typicode.com/posts",
			        PostJSON[].class);

		  System.out.println("@RestTemplateControllerExample getPosts return response: " + response);
		  return Arrays.asList(response.getBody());
	  }
	  
	  //JSON http://jsonplaceholder.typicode.com/ free JSON service
	  @RequestMapping(value = "/posts/{postId}", method = RequestMethod.GET)
	  public PostJSON getPostByID(
			  @PathVariable(value="postId") String postId) {

		  //JSON http://jsonplaceholder.typicode.com/posts/postId
		  ResponseEntity<PostJSON> response = restTemplate.getForEntity(
			        "http://jsonplaceholder.typicode.com/posts/{postId}",
			        PostJSON.class,postId);

		  System.out.println("@RestTemplateControllerExample getPostByID return response: " + response);
		  return response.getBody();
	  }
	  
	  //JSON Deletes a post
	  @RequestMapping(value = "/posts/{postId}", method = RequestMethod.DELETE)
	  @ResponseStatus(value = HttpStatus.OK)
	  public void deletePostByID(@PathVariable(value="postId") String postId) {
		  System.out.println("@RestTemplateControllerExample deletePostByID is called");

	  }

	  //JSON SAVES a post
	  @RequestMapping(value = "/savePost", method = RequestMethod.POST)
	  @ResponseStatus(value = HttpStatus.OK)
	  public void savePost(@RequestBody PostJSON postJSON) {

		  System.out.println("savePost postJSON.getUserId(): " + postJSON.getUserId());
		  System.out.println("savePost postJSON.getTitle(): " + postJSON.getTitle());
		  System.out.println("savePost postJSON.getId(): " + postJSON.getId());
		  System.out.println("savePost postJSON.getBody(): " + postJSON.getBody());
		  System.out.println("@RestTemplateControllerExample savePost is called");		
	  }
	  
	  @RequestMapping(value = "/responseStatusError", method = RequestMethod.GET)	 
	  public String responseStatusError() throws Exception {		  
		  //responseStatusError
		  System.out.println("@RestTemplateControllerExample responseStatusError");
		  throw new Exception("@RestTemplateControllerExample responseStatusError exception");		
	 }
	 
	  @ExceptionHandler
	  @ResponseStatus(value = HttpStatus.FORBIDDEN,reason="FORBIDDEN ACCESS (PROVIDE YOUR CUSTOM REASON HERE)")
	  public void handleException(Exception ex) {
		    System.out.println("@RestTemplateControllerExample handleException");
		  	System.out.println(ex);
	  }
	  	 

}
