package spring.mvc.dependency.injection;

public class WordpressPostService implements PostService {

	@Override
	public boolean publishPost(String content) {
		// Wordpress Post Service
		System.out.println("WordpressPostService: " + content);
		return true;
	}
	
}
