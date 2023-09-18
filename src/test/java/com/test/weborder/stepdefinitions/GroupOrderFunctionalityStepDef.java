package com.test.weborder.stepdefinitions;

import com.test.weborder.pages.WebOrderGroupOrderPage;
import com.test.weborder.pages.WebOrderLoginPage;
import com.test.weborder.pages.WebOrderMainPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

public class GroupOrderFunctionalityStepDef {

    WebDriver driver= DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage=new WebOrderLoginPage(driver);
    WebOrderMainPage webOrderMainPage=new WebOrderMainPage(driver);
    WebOrderGroupOrderPage webOrderGroupOrderPage=new WebOrderGroupOrderPage(driver);
    @When("User clicks GroupOrder Button then Next Button")
    public void user_clicks_group_order_button_then_next_button() {
    webOrderMainPage.clickGroupOrderBox();
    webOrderMainPage.clickNextButton();
    }
    @When("User provides note {string} to Invitees box")
    public void user_provides_note_to_invitees_box(String note) {
    webOrderGroupOrderPage.sendInviteesNote(note);
    }
    @When("User provides gmail {string},{string} to Invite List")
    public void user_provides_gmail_to_invite_list(String gmail1, String gmail2) {
    webOrderGroupOrderPage.sendInviteList(gmail1,gmail2);
    }
    @When("User chooses the location {string} and validates {string}")
    public void user_chooses_the_location_and_validates(String location, String expectedAddress) {
    webOrderGroupOrderPage.chooseLocation(location,expectedAddress);
    }
    @When("User clicks Create Group Order button")
    public void user_clicks_create_group_order_button() {
    webOrderGroupOrderPage.clickCreateGroupOrderButton();
    }
    @Then("User validates the header {string} and {string} from description")
    public void user_validates_the_header_and_from_description(String expectedHeader, String expectedDescription) throws InterruptedException {
    webOrderGroupOrderPage.orderValidation(expectedHeader,expectedDescription);
    }
}
