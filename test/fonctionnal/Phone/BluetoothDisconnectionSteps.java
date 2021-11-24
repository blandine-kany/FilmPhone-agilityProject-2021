package Phone;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import packagePhone.Phone;
import packagePhone.WirelessHeadphone;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BluetoothDisconnectionSteps {
    private Phone muskphone;
    private WirelessHeadphone muskpods;

    @Given("wireless headphone is connected")
    public void wireless_headphone_is_connected() {
        Phone muskphone = new Phone();
        WirelessHeadphone muskpods = new WirelessHeadphone();
        this.muskpods = muskpods;
        this.muskphone = muskphone;
        muskpods.setIsAvailable(true);
        muskphone.setBluetoothAvailability(true);
        muskphone.connect(muskpods);
    }

    @When("user disconnect wireless headphone")
    public void user_disconnect_wireless_headphone() {
        WirelessHeadphone muskpods = new WirelessHeadphone();
        this.muskpods = muskpods;
        muskphone.disconnect(muskpods);
    }

    @Then("user : success message")
    public void user_success_message() {
        assertEquals("Wireless Headphone disconnected", muskphone.getSuccessMessage());
    }

}
