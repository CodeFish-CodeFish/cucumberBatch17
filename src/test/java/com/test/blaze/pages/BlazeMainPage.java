package com.test.blaze.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class BlazeMainPage {

    public BlazeMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@id='itemc']")
    List<WebElement> allCategories;

    @FindBy(css = "#cartur")
    WebElement globalCartButton;

    public void chooseCategory(String category){
        boolean flag=false;
        for(WebElement categry:allCategories){
            if(BrowserUtils.getText(categry).equals(category)){
               categry.click();
               flag=true;
               break;
            }
        }
        if(!flag){
            Assert.fail("the category is not matching");
        }
    }

    public void clickGlobalCartButton(){
        globalCartButton.click();
    }
}


