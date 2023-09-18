package com.test.google.stepdefinitions;

import com.test.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class SearchStepDefParameter {
    WebDriver driver= DriverHelper.getDriver();
    GoogleMainPage googleMainPage=new GoogleMainPage(driver);

    @Given("User navigates to the {string}")
    public void user_navigates_to_the(String website) {
    driver.get(website);
    }
    @When("User searches for {string}")
    public void user_searches_for(String item) throws InterruptedException {
     googleMainPage.searchItem(item);
    }
    @Then("User validates first page returns more than {int} links")
    public void user_validates_first_page_returns_more_than_links(int expectedNumber) {
        Assert.assertTrue(googleMainPage.SearchResult()>expectedNumber);
    }

    @Then("User validates the result is less than {double}")
    public void user_validates_the_result_is_less_than(double expectedAmount) {
     Assert.assertTrue(googleMainPage.SearchResult()<expectedAmount);
    }

    @Then("User validates the search time is less than {double} second")
    public void user_validates_the_search_time_is_less_than_second(double expectedSec) {
        Assert.assertTrue(googleMainPage.getTime()<expectedSec);
    }
}
