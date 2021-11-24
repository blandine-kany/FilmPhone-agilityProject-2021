package Phone;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import packagePhone.Phone;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnOffSteps {
	private Phone muskphone;

	@Given("phone is on")
	public void phone_is_on() {
		Phone muskphone = new Phone();
		this.muskphone = muskphone;
		muskphone.setIsTurnedOn(true);
	}

	@When("user turns off phone")
	public void user_turns_off_phone() {
		muskphone.setIsTurnedOn(false);
	}

	@Then("user receive a successmessage")
	public void user_receive_a_successmessage() {
		assertEquals("Success : phone changes states", muskphone.getSuccessMessage());
	}

	@When("user turns on phone")
	public void user_turns_on_phone() {
		muskphone.setIsTurnedOn(true);
	}

	@Then("user receive a errormessage")
	public void user_receive_a_errormessage() {
		assertEquals("Error : phone is already in this state", muskphone.getErrorMessage());
	}

	@Given("phone is off")
	public void phone_is_off() {
		Phone muskphone = new Phone();
		this.muskphone = muskphone;
		muskphone.setIsTurnedOn(false);
	}

}
