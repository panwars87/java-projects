package com.test.cucumber;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


/**
 * @author spanwar
 *
 */
public class UserSteps {
	
	User user = new User();
	
	@Given("^that the (.*) is given a task to clear (.*) certification exam$")
	public void certificationName(String name, String certification) throws Throwable{
		user.setName(name);
		user.setCertification(certification);
	}

	@When("^(.*) got (\\d+) marks in exam$")
	public void gotMarks(String name, int marks) throws Throwable{
		user.setMarks(marks);
		user.setName(name);
	}
	
	@Then("^(.*) is known as (.*) certified$")
	public void certifiedYes(String name, String certification) throws Throwable{
		assertThat(name, is(user.getName()));
		assertThat(user.getCertification(), equalTo("Java"));
		assertThat(user.getResult(), is(true));
	}
}
