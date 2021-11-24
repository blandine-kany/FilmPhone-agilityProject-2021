package Phone;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import packagePhone.Phone;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimSteps {
    private Phone muskphone;

    @Given("user wants to add a sim")
    public void user_wants_to_add_a_sim() {
        Phone muskphone = new Phone();
        this.muskphone = muskphone;
    }

    @When("user insert sim")
    public void user_insert_sim() {
        muskphone.setSim(true);
    }

    @Then("user receive succes")
    public void user_receive_succes() {
        assertEquals("Sim is inserted ", this.muskphone.getSuccessMessage());
    }
}
