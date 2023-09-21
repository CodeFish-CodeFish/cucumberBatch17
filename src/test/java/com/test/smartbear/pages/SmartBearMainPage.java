package com.test.smartbear.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearMainPage {

    public SmartBearMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(linkText = "Order")
    WebElement orderButton;

    @FindBy(partialLinkText = "View all")
    WebElement viewAllOrderButton;

    public void clickOrderButton(){
        orderButton.click();
    }

    public void clickViewAllOrderButton(){
        viewAllOrderButton.click();
    }
}
