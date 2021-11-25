package Scenario;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import packageFilm.AdvertisingFilm;
import packageFilm.MovingPicture;
import packageFilm.MovingPictureIterator;
import packageFilm.Scenario;
import packagePhone.Phone;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnePhoneDifferentAdsStepDef {

    private Phone phone;
    private Scenario scenario;
    private List<MovingPicture> movingPictureList;

    @Given("a unique scenario which is titled {string}")
    public void a_unique_scenario_which_is_titled(String scenarioTitle) {
        this.scenario = new Scenario(scenarioTitle);
        this.movingPictureList = new ArrayList<>();
    }

    @Given("a soon to be released phone named {string}")
    public void a_soon_to_be_released_phone_named(String phoneName) {
        this.phone = new Phone();
        this.phone.setName(phoneName);
    }

    @Given("a list of advertising films")
    public void a_list_of_advertising_films() {
        this.movingPictureList = new ArrayList<>();
    }

    @Given("the list contains an advertising film named {string} and {string} as director")
    public void the_list_contains_an_advertising_film_named_and_as_director(String adTitle, String adDirector) {
        this.movingPictureList.add(new AdvertisingFilm(adTitle, adDirector, new Phone()));
    }

    @When("the phone brand demands the creation of various advertising films for a given scenario and phone")
    public void the_phone_brand_demands_the_creation_of_various_advertising_films_for_a_given_scenario_and_phone() {
        MovingPictureIterator movingPictureIterator = new MovingPictureIterator(this.movingPictureList);
        while (movingPictureIterator.hasNext()) {
            this.scenario.addFilm(movingPictureIterator.currentItem());
            movingPictureIterator.next();
        }
        this.scenario.oneProductDifferentAds(this.phone);
    }

    @Then("the production for the advertising films starts and the system updates the scenario information \\(number of ads for the scenario: {int}).")
    public void the_production_for_the_advertising_films_starts_and_the_system_updates_the_scenario_information_number_of_ads_for_the_scenario(int result) {
        MovingPictureIterator movingPictureIterator = new MovingPictureIterator(this.scenario.getListOfFilms());
        while (movingPictureIterator.hasNext()) {
            movingPictureIterator.currentItem().startProduction();
            movingPictureIterator.next();
        }
        assertTrue(this.scenario.getListOfFilms().size() > 0);
        assertEquals(Integer.valueOf(result), this.scenario.getListOfFilms().size());
    }

}
