package spring.mvc.sample;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring.mvc.bean.SampleBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-context.xml","classpath:mvc-config.xml"})
public class SampleTest {

	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void test() {
		//Implement
		
		SampleBean sampleBean = applicationContext.getBean("sampleBean", SampleBean.class);
		Assert.assertNotNull(sampleBean);
		
		sampleBean = (SampleBean)applicationContext.getBean("sampleBean");
		Assert.assertNotNull(sampleBean);
		
		Assert.assertEquals(sampleBean.getSampleId(), 4);
		Assert.assertEquals(sampleBean.getSampleText(), "sampletext");
		
	}

}
