package Phone;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import packagePhone.Phone;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginSteps {

    private Phone muskphone1;

    @Given("user is on muskphone1")
    public void user_is_on_muskphone1() {
        muskphone1 = new Phone();
    }

    @When("user enters pass1 on phone")
    public void user_enters_pass1_on_phone() {
        muskphone1.setPassword("pass1");
    }

    @Then("user false")
    public void user_false() {
        assertEquals(false, muskphone1.getIsConnected());
    }

    @When("user enters pass1dutout on phone")
    public void user_enters_pass1dutout_on_phone() {
        muskphone1.setPassword("pass1dutout");
    }

    @Then("user true")
    public void user_true() {
        assertEquals(true, muskphone1.getIsConnected());
    }

}
