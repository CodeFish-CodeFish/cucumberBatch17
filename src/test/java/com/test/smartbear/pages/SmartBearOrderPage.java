package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class SmartBearOrderPage {

    public SmartBearOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement product;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement customerName;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    WebElement state;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zip;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_0")
    WebElement visaCard;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_1")
    WebElement masterCard;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_2")
    WebElement americanExpress;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expireDate;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;

    @FindBy(tagName = "strong")
    WebElement successMessage;

    public void provideProductInformation(String product,String quantity) throws InterruptedException {
        BrowserUtils.selectBy(this.product,product,"value");
        Thread.sleep(1000);
        this.quantity.sendKeys(quantity);
    }

    public void provideAddressInformation(String customerName,String street,String city,String state,String zipCode) throws InterruptedException {
        this.customerName.sendKeys(customerName);Thread.sleep(1000);
        this.street.sendKeys(street);Thread.sleep(1000);
        this.city.sendKeys(city);Thread.sleep(1000);
        this.state.sendKeys(state);Thread.sleep(1000);
        this.zip.sendKeys(zipCode);Thread.sleep(1000);
    }

    public void providePaymentInformation(String cardType,String cardNumber,String expireDate) throws InterruptedException {
        chooseCartType(cardType);Thread.sleep(1000);
        this.cardNumber.sendKeys(cardNumber);Thread.sleep(1000);
        this.expireDate.sendKeys(expireDate);Thread.sleep(1000);
    }

    public void clickProcessButton(){
        processButton.click();
    }

    public String successMessage(){
        return BrowserUtils.getText(successMessage);
    }

    public void chooseCartType(String cardType){
        cardType=cardType.toUpperCase();

        switch (cardType){

            case "VISA":
                visaCard.click();
                break;
            case "MASTERCARD":
                masterCard.click();
                break;
            case "AMERICAN EXPRESS":
                americanExpress.click();
                break;
            default:
                System.out.println("Please provide correct cardType");
                Assert.fail();
        }
    }











}
