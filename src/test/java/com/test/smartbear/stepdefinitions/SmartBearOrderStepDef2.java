package com.test.smartbear.stepdefinitions;

import com.test.smartbear.pages.SmartBearLoginPage;
import com.test.smartbear.pages.SmartBearMainPage;
import com.test.smartbear.pages.SmartBearOrderPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class SmartBearOrderStepDef2 {

    WebDriver driver= DriverHelper.getDriver();
    SmartBearLoginPage smartBearLoginPage=new SmartBearLoginPage(driver);
    SmartBearMainPage smartBearMainPage=new SmartBearMainPage(driver);
    SmartBearOrderPage smartBearOrderPage=new SmartBearOrderPage(driver);

    @When("User clicks OrderButton and provides the product and quantity for product information")
    public void user_clicks_order_button_and_provides_the_product_and_quantity_for_product_information(DataTable dataTable) throws InterruptedException {
     Map<String,String> productInformation=dataTable.asMap();
       smartBearMainPage.clickOrderButton();
       smartBearOrderPage.provideProductInformation(productInformation.get("product"),
                                                    productInformation.get("quantity"));
    }
    @When("User provides data for address information")
    public void user_provides_data_for_address_information(DataTable dataTable) throws InterruptedException {
    Map<String,String> addressInformation=dataTable.asMap();
    smartBearOrderPage.provideAddressInformation(
            addressInformation.get("customerName"),
            addressInformation.get("street"),
            addressInformation.get("city"),
            addressInformation.get("state"),
            addressInformation.get("zipCode"));
    }
    @When("User provides data for payment information")
    public void user_provides_data_for_payment_information(DataTable dataTable) throws InterruptedException {
    Map<String,String> paymentInformation=dataTable.asMap();
    smartBearOrderPage.providePaymentInformation(
            paymentInformation.get("cardType"),
            paymentInformation.get("cardNumber"),
            paymentInformation.get("expireDate"));
    }

    @Then("User clicks process button and validate the message")
    public void user_clicks_process_button_and_validate_the_message(DataTable dataTable) {
        smartBearOrderPage.clickProcessButton();
        List<String> expectedMessage=dataTable.asList();
        Assert.assertEquals(expectedMessage.get(0),smartBearOrderPage.successMessage());
    }

}
