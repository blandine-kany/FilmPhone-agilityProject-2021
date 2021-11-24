package Phone;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import packagePhone.Phone;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneBatterySteps {

    private Phone muskphone1 = new Phone();

    @Given("phone has battery power")
    public void phone_has_battery_power() {
        muskphone1 = new Phone();
    }

    @When("phone is used")
    public void phone_is_used() {
        muskphone1.setIsTurnedOn(true);
    }

    @Then("phone loose battery")
    public void phone_loose_battery() {
        assertEquals("Phone battery : 99", muskphone1.isDischarging());
    }

    @Given("user wants to charge a phone")
    public void user_wants_to_charge_a_phone() {
        muskphone1 = new Phone();
    }

    @When("user plug a charger")
    public void user_plug_a_charger() {

    }

    @Then("phone gains battery")
    public void phone_gains_battery() {
        assertEquals("Battery is full", muskphone1.isCharging());
    }

}
