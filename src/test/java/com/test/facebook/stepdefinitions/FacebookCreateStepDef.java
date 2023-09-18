package com.test.facebook.stepdefinitions;

import com.test.facebook.pages.FacebookAccountPage;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class FacebookCreateStepDef {
    WebDriver driver= DriverHelper.getDriver();
    FacebookAccountPage facebookAccountPage=new FacebookAccountPage(driver);
    @When("User clicks the Create New Account button")
    public void user_clicks_the_create_new_account_button() {
       facebookAccountPage.clickCreateAccountButton();
    }
    @When("User provides {string},{string},{string} and {string} to the sign up form")
    public void user_provides_and_to_the_sign_up_form(String firstName, String lastName, String email, String password) throws InterruptedException {
    facebookAccountPage.provideCustomerInformation(firstName,lastName,email,password);
    }
    @When("User chooses the {string},{string} and {string} for Birth Day")
    public void user_chooses_the_and_for_birth_day(String month, String day, String year) throws InterruptedException {
    facebookAccountPage.chooseBirthDay(month,day,year);
    }
    @When("User chooses the {string} and click Sign Up button")
    public void user_chooses_the_and_click_sign_up_button(String gender) {
    facebookAccountPage.chooseGender(gender);
    facebookAccountPage.clickSignUpButton();
    }

}
