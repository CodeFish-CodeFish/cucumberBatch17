package com.test.google.stepdefinitions;

import com.test.google.pages.GoogleMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SearchStepDef {

    WebDriver driver;
    @Given("User navigates to the Google")
    public void user_navigates_to_the_google() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
    }
    @When("User searches for CodeFish")
    public void user_searches_for_code_fish() throws InterruptedException {
        GoogleMainPage googleMainPage=new GoogleMainPage(driver);
        googleMainPage.searchItem("CodeFish");
    }
    @Then("User validates first page returns more than five links")
    public void user_validates_first_page_returns_more_than_five_links() {
        GoogleMainPage googleMainPage=new GoogleMainPage(driver);
        Assert.assertTrue(googleMainPage.allLinks()>5);
    }

    @When("User searches for Kyrgyz Food in USA")
    public void user_searches_for_kyrgyz_food_in_usa() throws InterruptedException {
      GoogleMainPage googleMainPage=new GoogleMainPage(driver);
      googleMainPage.searchItem("Kyrgyz Food in USA");
    }
    @Then("User validates the result is less than thirty millions")
    public void user_validates_the_result_is_less_than_thirty_millions() {
    GoogleMainPage googleMainPage=new GoogleMainPage(driver);
    Assert.assertTrue(googleMainPage.SearchResult()<30000000);
    }

    @When("User searches for Turkish Baklava")
    public void user_searches_for_turkish_baklava() throws InterruptedException {
      GoogleMainPage googleMainPage=new GoogleMainPage(driver);
      googleMainPage.searchItem("Turkish Baklava");
    }
    @Then("User validates the search time is less than one sec")
    public void user_validates_the_search_time_is_less_than_one_sec() {
    GoogleMainPage googleMainPage=new GoogleMainPage(driver);
    Assert.assertTrue(googleMainPage.getTime()<1.0);
    }
}
