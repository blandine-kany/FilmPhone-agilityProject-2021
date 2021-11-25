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

public class CreateAdsStepDef {

    private List<MovingPicture> movingPictureList;
    private List<MovingPicture> movingPictureList2;
    private Scenario scenario;
    private Scenario scenario2;
    private Phone phone;
    private Phone phone2;

    @Given("a scenario which is titled {string}")
    public void a_scenario_which_is_titled(String scenarioTitle) {
        this.scenario = new Scenario(scenarioTitle);
        this.movingPictureList = new ArrayList<>();
    }

    @Given("a phone named {string}")
    public void a_phone_named(String phoneName) {
        this.phone = new Phone();
        this.phone.setName(phoneName);
    }

    @Given("the scenario contains an advertising film named {string} and {string} as director")
    public void the_scenario_contains_an_advertising_film_named_and_as_director(String adTitle, String adDirector) {
        this.movingPictureList.add(new AdvertisingFilm(adTitle, adDirector, this.phone));
    }

    @When("the phone brand demands the creation of a film for a given scenario")
    public void the_phone_brand_demands_the_creation_of_a_film_for_a_given_scenario() {
        MovingPictureIterator movingPictureIterator = new MovingPictureIterator(this.movingPictureList);
        while (movingPictureIterator.hasNext()) {
            this.scenario.addFilm(movingPictureIterator.currentItem());
            movingPictureIterator.next();
        }
    }

    @Then("the production for the advertising film starts and the system updates the scenario information \\(number of ads for the scenario: {int}).")
    public void the_production_for_the_advertising_film_starts_and_the_system_updates_the_scenario_information_number_of_ads_for_the_scenario(int result) {
        MovingPictureIterator movingPictureIterator = new MovingPictureIterator(this.scenario.getListOfFilms());
        while (movingPictureIterator.hasNext()) {
            movingPictureIterator.currentItem().startProduction();
            movingPictureIterator.next();
        }
        assertTrue(this.scenario.getListOfFilms().size() > 0);
        assertEquals(Integer.valueOf(result), this.scenario.getListOfFilms().size());

    }

    @Given("a second scenario which is titled {string}")
    public void a_second_scenario_which_is_titled(String scenarioTitle) {
        this.scenario2 = new Scenario(scenarioTitle);
        this.movingPictureList2 = new ArrayList<>();
    }

    @Given("a second phone named {string}")
    public void a_second_phone_named(String phoneName) {
        this.phone2 = new Phone();
        this.phone2.setName(phoneName);
    }

    @Given("the first scenario contains an advertising film named {string} with {string} as director for the first phone")
    public void the_first_scenario_contains_an_advertising_film_named_with_as_director_for_the_first_phone(String adTitle, String adDirector) {
        the_scenario_contains_an_advertising_film_named_and_as_director(adTitle, adDirector);
    }

    @Given("the second scenario contains an advertising film named {string} with {string} as director for the second phone")
    public void the_second_scenario_contains_an_advertising_film_named_with_as_director_for_the_second_phone(String adTitle, String adDirector) {
        this.movingPictureList2.add(new AdvertisingFilm(adTitle, adDirector, this.phone2));
    }

    @When("the phone brand demands the creation of the films for the scenarios")
    public void the_phone_brand_demands_the_creation_of_the_films_for_the_scenarios() {
        MovingPictureIterator movingPictureIterator = new MovingPictureIterator(this.movingPictureList);
        while (movingPictureIterator.hasNext()) {
            this.scenario.addFilm(movingPictureIterator.currentItem());
            movingPictureIterator.next();
        }

        movingPictureIterator = new MovingPictureIterator(this.movingPictureList2);
        while (movingPictureIterator.hasNext()) {
            this.scenario2.addFilm(movingPictureIterator.currentItem());
            movingPictureIterator.next();

        }
    }

    @Then("the production for the advertising film starts and the system updates the scenario information \\(number of ads for the scenarios: {int} {int})")
    public void the_production_for_the_advertising_film_starts_and_the_system_updates_the_scenario_information_number_of_ads_for_the_scenarios(int result1, int result2) {
        MovingPictureIterator movingPictureIterator = new MovingPictureIterator(this.scenario.getListOfFilms());
        while (movingPictureIterator.hasNext()) {
            movingPictureIterator.currentItem().startProduction();
            movingPictureIterator.next();
        }

        movingPictureIterator = new MovingPictureIterator(this.scenario2.getListOfFilms());
        while (movingPictureIterator.hasNext()) {
            movingPictureIterator.currentItem().startProduction();
            movingPictureIterator.next();
        }

        assertTrue(this.scenario.getListOfFilms().size() > 0);
        assertEquals(Integer.valueOf(result1), this.scenario.getListOfFilms().size());

        assertTrue(this.scenario2.getListOfFilms().size() > 0);
        assertEquals(Integer.valueOf(result2), this.scenario2.getListOfFilms().size());
    }


}
