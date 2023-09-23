package com.test.blaze.stepdefinitions;

import com.test.blaze.pages.BlazeCartPage;
import com.test.blaze.pages.BlazeMainPage;
import com.test.blaze.pages.BlazeOrderPage;
import com.test.blaze.pages.BlazeProductPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class BlazeOrderStepDef {

    WebDriver driver = DriverHelper.getDriver();
    BlazeMainPage blazeMainPage = new BlazeMainPage(driver);
    BlazeProductPage blazeProductPage = new BlazeProductPage(driver);
    BlazeCartPage blazeCartPage = new BlazeCartPage(driver);
    BlazeOrderPage blazeOrderPage = new BlazeOrderPage(driver);

    @Given("User chooses the product option {string} from mainPage")
    public void user_chooses_the_product_option_from_main_page(String category) {
        blazeMainPage.chooseCategory(category);
    }

    @When("User chooses the product type {string} from the list")
    public void user_chooses_the_product_type_from_the_list(String item) throws InterruptedException {
        blazeProductPage.chooseProduct(item);
    }

    @Then("User validates {string},{string} and {string} of them item")
    public void user_validates_and_of_them_item(String expectedHeader, String expectedPrice, String expectedDesc) {
        blazeProductPage.validateProductInformation(expectedHeader, expectedPrice, expectedDesc);
    }

    @Then("User clicks Add to cart button and validate {string} from JS alert")
    public void user_clicks_add_to_cart_button_and_validate_from_js_alert(String expectedJSMessage) throws InterruptedException {
        blazeProductPage.clickAddToCart(driver, expectedJSMessage);
    }

    @Then("User clicks global cart button and Place Order button")
    public void user_clicks_global_cart_button_and_place_order_button() {
        blazeMainPage.clickGlobalCartButton();
        blazeCartPage.clickPlaceOrderButton();
    }

    @Then("User provides {string},{string},{string},{string},{string},{string} to order Page")
    public void user_provides_to_order_page(String name, String country, String city, String creditCard, String month, String year) throws InterruptedException {
        blazeOrderPage.provideCustomerInfo(name, country, city, creditCard, month, year);
    }

    @Then("User clicks Purchase button and validates the {string}")
    public void user_clicks_purchase_button_and_validates_the(String thankYouMessage) {
        blazeOrderPage.clickPurchaseButtonAndValidate(thankYouMessage);
    }

    @Given("User chooses the product option from mainPage")
    public void user_chooses_the_product_option_from_main_page(DataTable dataTable) {
        List<String> category = dataTable.asList(); //Phones
        blazeMainPage.chooseCategory(category.get(0));
    }

    @When("User chooses the product type from the list")
    public void user_chooses_the_product_type_from_the_list(DataTable dataTable) throws InterruptedException {
        List<String> productType = dataTable.asList();
        blazeProductPage.chooseProduct(productType.get(0));
    }

    @Then("User validates data of the item")
    public void user_validates_data_of_the_item(DataTable dataTable) {
        Map<String, String> allDataInformation = dataTable.asMap();
        blazeProductPage.validateProductInformation(
                allDataInformation.get("header"),
                allDataInformation.get("price"),
                allDataInformation.get("description"));
    }

    @Then("User clicks Add to cart button and validates message from JS Alert")
    public void user_clicks_add_to_cart_button_and_validates_message_from_js_alert(DataTable dataTable) throws InterruptedException {
    List<String> JSMessage=dataTable.asList();
    blazeProductPage.clickAddToCart(driver,JSMessage.get(0));
    }

    @Then("User provides data")
    public void user_provides_data(DataTable dataTable) throws InterruptedException {
        Map<String,String> customerData=dataTable.asMap();
    blazeOrderPage.provideCustomerInfo(
            customerData.get("name"),
            customerData.get("country"),
            customerData.get("city"),
            customerData.get("creditCard"),
            customerData.get("month"),
            customerData.get("year"));
    }

    @Then("User clicks Purchase button and validates the message")
    public void user_clicks_purchase_button_and_validates_the_message(DataTable dataTable) {
        List<String> successMessage=dataTable.asList();
        blazeOrderPage.clickPurchaseButtonAndValidate(successMessage.get(0));
    }


}
