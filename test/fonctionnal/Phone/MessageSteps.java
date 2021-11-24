package Phone;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import packagePhone.Phone;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageSteps {
	private Phone muskphone1;
	private Phone muskphone2;

	@Given("user wants to send message to an other phone")
	public void user_wants_to_send_message_to_an_other_phone() {
		Phone muskphone1 = new Phone();
		this.muskphone1 = muskphone1;
		Phone muskphone2 = new Phone();
		this.muskphone2 = muskphone2;
	}

	@When("user sends it")
	public void user_sends_it() {
		muskphone1.sendMessage("slt", muskphone2);
	}

	@Then("message is sent")
	public void message_is_sent() {
		assertEquals("Message sent", this.muskphone1.getSuccessMessage());
	}

	@And("second phone has received message")
	public void second_phone_has_received_message() {
		assertEquals("slt", this.muskphone2.getMessage());
	}
}
