package com.test.blaze.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class BlazeOrderPage {

    public BlazeOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#name")
    WebElement name;

    @FindBy(css = "#country")
    WebElement country;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#card")
    WebElement creditCard;

    @FindBy(css = "#month")
    WebElement month;

    @FindBy(css = "#year")
    WebElement year;

    @FindBy(xpath = "//button[contains(@onclick,'purchaseOrder')]")
    WebElement purchase;

    @FindBy(xpath = "//h2[contains(text(),'Thank you')]")
    WebElement successMessage;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;

    public void provideCustomerInfo(String name,String country,String city,String creditCard,
                                    String month,String year) throws InterruptedException {
        Thread.sleep(1000);
        this.name.sendKeys(name);
        Thread.sleep(1000);
        this.country.sendKeys(country);
        Thread.sleep(1000);
        this.city.sendKeys(city);
        Thread.sleep(1000);
        this.creditCard.sendKeys(creditCard);
        Thread.sleep(1000);
        this.month.sendKeys(month);
        Thread.sleep(1000);
        this.year.sendKeys(year);
        Thread.sleep(1000);
    }

    public void clickPurchaseButtonAndValidate(String expectedMessage){
        purchase.click();
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(successMessage));
        okButton.click();
    }


}
