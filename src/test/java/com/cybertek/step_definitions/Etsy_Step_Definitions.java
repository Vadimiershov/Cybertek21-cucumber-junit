package com.cybertek.step_definitions;

import com.cybertek.pages.Etsy_HomePage;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Etsy_Step_Definitions {

    Etsy_HomePage etsy_homePage = new Etsy_HomePage();

    @Given("User is on Etsy home page")
    public void user_is_on_etsy_home_page() {
        Driver.getDriver().get("https://www.etsy.com");
    }

    @Then("User sees title as expected {string}")
    public void user_sees_title_as_expected(String expectedTitle) {
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("actual title is different from expected",actualTitle,expectedTitle);
    }

    @When("User types {string} in the search box")
    public void user_types_in_the_search_box(String searchInput) {
        etsy_homePage.searchInput.sendKeys(searchInput);
    }

    @When("User clicks search button")
    public void user_clicks_search_button() {
        etsy_homePage.searchButton.click();
    }

    @Then("User sees {string} is in the title")
    public void user_sees_is_in_the_title(String expectedTitle) {
       String actualTitle = Driver.getDriver().getTitle();
       Assert.assertTrue(actualTitle.contains(expectedTitle));
    }





}
