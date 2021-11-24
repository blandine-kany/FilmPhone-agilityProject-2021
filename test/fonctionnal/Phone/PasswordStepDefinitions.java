package Phone;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import packagePhone.Phone;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PasswordStepDefinitions {

    private Phone muskphone;

    @Given("User wants to change his password")
    public void user_wants_to_change_his_password() {
        Phone muskphone = new Phone();
        this.muskphone = muskphone;
    }

    @When("User enters pass1dutout and newpassword")
    public void user_enters_pass1dutout_and_newpassword() {
        muskphone.changePassword("pass1dutout", "newpassword");
    }

    @Then("password is updated")
    public void password_is_updated() {
        assertEquals("Success : Password updated", this.muskphone.getSuccessMessage());
    }

    @When("User enters pass1 and newpassword")
    public void user_enters_pass1_and_newpassword() {
        muskphone.changePassword("pass1", "newpassword");
    }

    @Then("password isnt updated because isnt valid")
    public void password_isnt_updated_because_isnt_valid() {
        assertEquals("Error : Wrong Password", this.muskphone.getErrorMessage());
    }

}
