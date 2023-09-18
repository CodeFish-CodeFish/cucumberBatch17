package com.test.weborder.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebOrderMainPage {

    public WebOrderMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//label[@for='GroupOrder']")
    WebElement groupOrderBox;

    @FindBy(xpath = "//button[.='Next']")
    WebElement nextButton;

    public void clickGroupOrderBox(){
        groupOrderBox.click();
    }

    public void clickNextButton(){
        nextButton.click();
    }

}
