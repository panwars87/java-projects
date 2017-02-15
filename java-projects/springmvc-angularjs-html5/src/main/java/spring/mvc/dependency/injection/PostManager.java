package spring.mvc.dependency.injection;

public class PostManager {
			
	private PostService postService;
	private boolean enabled;
	
	public PostManager(){}
	
	//constructor injection
	public PostManager(PostService postService, boolean enableService) {
		this.enabled = enableService;
		this.postService = postService;
	}

	public PostService getPostService() {
		return postService;
	}

	//setter injection will be used
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	
	public boolean isServiceAvailable () {
		return enabled;
	}	
	
	//setter injection will be used
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean publish(String content) {
		if(enabled == true)
		return postService.publishPost(content);
		else 
		return false;		
		
	}
		
}
