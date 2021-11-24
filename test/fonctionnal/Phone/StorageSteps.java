package Phone;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import packagePhone.MobileApp;
import packagePhone.Phone;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StorageSteps {

	private Phone muskphone = new Phone();
	private MobileApp starlink = new MobileApp();
	private MobileApp bigapp = new MobileApp();

	@Given("User wants to install starlink")
	public void user_wants_to_install_starlink() {
		this.muskphone = muskphone;
		this.starlink = starlink;
		starlink.setAppName("starlink");
		starlink.setAppSize(10.00);
	}

	@When("User install starlink")
	public void user_install_starlink() {
		muskphone.checkStorage(starlink);
	}

	@And("phone storage is sufficient")
	public void phone_storage_is_sufficient() {
		muskphone.install(starlink);
	}

	@Then("App is installed")
	public void app_is_installed() {
		assertEquals("App starlink is installed", muskphone.getSuccessMessage());
	}

	@Given("User wants to install bigapp")
	public void user_wants_to_install_bigapp() {
		this.muskphone = muskphone;
		this.bigapp = bigapp;
		bigapp.setAppName("bigapp");
		bigapp.setAppSize(190.00);
	}

	@When("User install bigapp")
	public void user_install_bigapp() {
		muskphone.checkStorage(bigapp);
	}

	@And("phone storage is not sufficient")
	public void phone_storage_is_not_sufficient() {
		muskphone.install(bigapp);
	}

	@Then("App is not installed")
	public void app_is_not_installed() {
		assertEquals("App bigapp not installed", muskphone.getErrorMessage());
	}

	/*
	 * @Given("User wants to install a mobile app") public void
	 * user_wants_to_install_a_mobile_app() { this.muskphone = muskphone;
	 * this.starlink = starlink; starlink.setAppName("starlink"); }
	 * 
	 * @When("User install a mobile app") public void user_install_a_mobile_app() {
	 * muskphone.checkStorage(starlink); }
	 * 
	 * @And("phone storage is sufficient") public void
	 * phone_storage_is_sufficient(){ muskphone.install(starlink); }
	 * 
	 * @Then("App is installed") public void app_is_installed() {
	 * assertEquals("App starlink is installed",this.muskphone.getSuccessMessage());
	 * 
	 * }
	 * 
	 * @And("phone storage is not sufficient") public void
	 * phone_storage_is_not_sufficient() {
	 * 
	 * }
	 * 
	 * @Then("App is not installed") public void app_is_not_installed() {
	 * assertEquals("App messages not installed",this.muskphone.getErrorMessage());
	 * }
	 */

}
