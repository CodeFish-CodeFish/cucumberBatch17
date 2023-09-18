package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.WebOrderLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class WebOrderLoginStepDef {

    WebDriver driver= DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage=new WebOrderLoginPage(driver);

    @When("User provides {string} and {string} and click login button")
    public void user_provides_and_and_click_login_button(String username, String password) {
    webOrderLoginPage.login(username,password);
    }
    @Then("User validates the {string} and {string} from Login Page")
    public void user_validates_the_from_login_page(String expectedMessage,String expectedColor) {
    webOrderLoginPage.errorMessageAndColor(expectedMessage,expectedColor);
    }
    @Then("User validates the {string} from the WebOrderMain Page")
    public void user_validates_the_from_the_web_order_main_page(String expectedTitle) {
        Assert.assertEquals(expectedTitle,driver.getTitle());
    }

    @When("User provides username and password and click login button")
    public void user_provides_username_and_password_and_click_login_button() {
       webOrderLoginPage.login(ConfigReader.readProperty("weborderusername"),
               ConfigReader.readProperty("weborderpassword"));
    }


}
