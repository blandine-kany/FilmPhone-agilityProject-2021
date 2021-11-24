package Phone;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import packagePhone.Phone;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Bluetooth {
    private Phone muskphone;

    @Given("bluetooth is on")
    public void bluetooth_is_on() {
        Phone muskphone = new Phone();
        this.muskphone = muskphone;
        muskphone.setBluetoothOn(true);
    }

    @When("user turns off bluetooth")
    public void user_turns_off_bluetooth() {
        muskphone.setBluetoothOn(false);
    }

    @When("user turns on bluetooth")
    public void user_turns_on_bluetooth() {
        muskphone.setBluetoothOn(true);
    }

    @Given("bluetooth is off")
    public void bluetooth_is_off() {
        Phone muskphone = new Phone();
        this.muskphone = muskphone;
        muskphone.setBluetoothOn(false);
    }

    @Then("user receive successmessage")
    public void user_receive_a_successmessage() {
        assertEquals("Success : bluetooth changes states", muskphone.getSuccessMessage());
    }

    @Then("user receive errormessage")
    public void user_receive_a_errormessage() {
        assertEquals("Error : bluetooth is already in this state", muskphone.getErrorMessage());
    }
}
