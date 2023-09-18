package com.test.google.pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleMainPage {

    public GoogleMainPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//textarea[@name='q']")
    WebElement searchBar;

    @FindBy(xpath = "//a//h3")
    List<WebElement> allLinks;

    @FindBy(xpath = "//div[@id='result-stats']")
    WebElement searchResult;// About 27,600,000 results (0.61 seconds)

    @FindBy(tagName = "nobr")
    WebElement timingPart;

    public void searchItem(String searchItem) throws InterruptedException {
        searchBar.sendKeys(searchItem, Keys.ENTER);
        Thread.sleep(3000);
    }

    public int allLinks(){
        return allLinks.size();
    }

    public double SearchResult(){
        String[] allResults= searchResult.getText().trim().split(" ");
       // About 27,600,000 results (0.61 seconds)
        return Double.parseDouble(allResults[1].replace(",",""));
    }

    public double getTime(){
        //(0.78 seconds)
        String[] time=timingPart.getText().trim().split(" ");//(0.78    ,   seconds)
        return Double.parseDouble(time[0].replace("(",""));//0.78
    }



}
