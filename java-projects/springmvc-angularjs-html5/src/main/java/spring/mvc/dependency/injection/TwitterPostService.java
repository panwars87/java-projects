package spring.mvc.dependency.injection;

public class TwitterPostService implements PostService {

	@Override
	public boolean publishPost(String content) {
		
		System.out.println("TwitterPostService: " + content);
		return true;
	}

}
