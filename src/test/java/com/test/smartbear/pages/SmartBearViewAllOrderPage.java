package com.test.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class SmartBearViewAllOrderPage {

    public SmartBearViewAllOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//tr[2]//td")
    List<WebElement> allData;

    public void validateAllInformationFromTable(String customerName, String product, String quantity, String street,
                                                String city, String state, String zip, String cartType, String cardNumber,
                                                String expireDate){
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDateTime now=LocalDateTime.now().plusDays(1);
        System.out.println(now);
        String currentDate=dtf.format(now);
        System.out.println(currentDate);
        List<String> expectedInfo= Arrays.asList("",customerName,product,quantity,currentDate,street,city,state,zip,cartType
        ,cardNumber,expireDate,"");
        for(int i=1;i<allData.size()-1;i++){
            Assert.assertEquals(expectedInfo.get(i), BrowserUtils.getText(allData.get(i)));
        }
    }
}
