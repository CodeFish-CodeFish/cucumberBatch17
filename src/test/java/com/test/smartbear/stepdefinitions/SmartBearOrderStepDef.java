package com.test.smartbear.stepdefinitions;

import com.test.smartbear.pages.SmartBearLoginPage;
import com.test.smartbear.pages.SmartBearMainPage;
import com.test.smartbear.pages.SmartBearOrderPage;
import com.test.smartbear.pages.SmartBearViewAllOrderPage;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class SmartBearOrderStepDef {
    WebDriver driver= DriverHelper.getDriver();
    SmartBearLoginPage smartBearLoginPage=new SmartBearLoginPage(driver);
    SmartBearMainPage smartBearMainPage=new SmartBearMainPage(driver);
    SmartBearOrderPage smartBearOrderPage=new SmartBearOrderPage(driver);

    SmartBearViewAllOrderPage smartBearViewAllOrderPage=new SmartBearViewAllOrderPage(driver);
    @Given("User provides username and password for SmartBear LoginPage")
    public void user_provides_username_and_password_for_smart_bear_login_page() {
    smartBearLoginPage.login(ConfigReader.readProperty("smartbearusername"),
                             ConfigReader.readProperty("smartbearpassword"));
    }
    @When("User clicks OrderButton and provides the {string} and {string} for product information")
    public void user_clicks_order_button_and_provides_the_and_for_product_information(String product, String quantity) throws InterruptedException {
    smartBearMainPage.clickOrderButton();
    smartBearOrderPage.provideProductInformation(product,quantity);
    }
    @When("User provides {string},{string},{string},{string},{string} for address information")
    public void user_provides_for_address_information(String customerName, String street, String city, String state, String zip) throws InterruptedException {
    smartBearOrderPage.provideAddressInformation(customerName,street,city,state,zip);
    }
    @When("User provides {string},{string},{string} for payment information")
    public void user_provides_for_payment_information(String cartType, String cardNumber, String expireDate) throws InterruptedException {
    smartBearOrderPage.providePaymentInformation(cartType,cardNumber,expireDate);
    }
    @Then("User clicks process button and validate {string}")
    public void user_clicks_process_button_and_validate(String expectedMessage) {
    smartBearOrderPage.clickProcessButton();
        Assert.assertEquals(expectedMessage,smartBearOrderPage.successMessage());
    }
    @Then("User clicks View Order button")
    public void user_clicks_view_order_button() {
    smartBearMainPage.clickViewAllOrderButton();
    }
    @Then("User validates all information {string},{string},{string},{string},{string},{string},{string},{string},{string},{string} from table")
    public void user_validates_all_information_from_table(String customerName, String product, String quantity, String street, String city, String state, String zip, String cartType, String cardNumber, String expireDate) {
    smartBearViewAllOrderPage.validateAllInformationFromTable(customerName,product,quantity,street,city,state,zip,cartType,cardNumber,expireDate);
    }
}
