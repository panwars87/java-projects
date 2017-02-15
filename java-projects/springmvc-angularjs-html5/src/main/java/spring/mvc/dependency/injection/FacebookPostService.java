package spring.mvc.dependency.injection;

public class FacebookPostService implements PostService {

	@Override
	public boolean publishPost(String content) {
		// Facebook post service
		System.out.println("FacebookPostService: " + content);
		return true;
	}

	

}
