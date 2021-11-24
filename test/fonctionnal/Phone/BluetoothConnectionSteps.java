package Phone;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import packagePhone.Phone;
import packagePhone.WirelessHeadphone;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BluetoothConnectionSteps {
    private WirelessHeadphone muskpods;
    private Phone muskphone;

    @Given("wireless headphone is available")
    public void wireless_headphone_is_available() {
        WirelessHeadphone muskpods = new WirelessHeadphone();
        this.muskpods = muskpods;
        muskpods.setIsAvailable(true);
    }

    @And("phone is : available")
    public void phone_is_available() {
        Phone muskphone = new Phone();
        this.muskphone = muskphone;
        muskphone.setBluetoothAvailability(true);
    }

    @When("user connect wireless headphone")
    public void user_connect_wireless_headphone() {
        muskphone.connect(muskpods);
    }

    @Then("user message : successmessage")
    public void user_message_successmessage() {
        assertEquals("Wireless Headphone connected", muskphone.getSuccessMessage());
    }

    @And("phone is : notavailable")
    public void phone_is_notavailable() {
        Phone muskphone = new Phone();
        this.muskphone = muskphone;
        muskphone.setBluetoothAvailability(false);
    }

    @Then("user message : errormessage")
    public void user_message_errormessage() {
        assertEquals("Wireless Headphone not connected", muskphone.getErrorMessage());
    }

    @Given("wireless headphone is notavailable")
    public void wireless_headphone_is_notavailable() {
        WirelessHeadphone muskpods = new WirelessHeadphone();
        this.muskpods = muskpods;
        muskpods.setIsAvailable(false);
    }

}
