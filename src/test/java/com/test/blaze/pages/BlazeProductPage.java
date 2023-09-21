package com.test.blaze.pages;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class BlazeProductPage {

    public BlazeProductPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".hrefch")
    List<WebElement> allProducts;

    @FindBy(xpath = "//h2")
    WebElement header;

    @FindBy(xpath = "//h3")
    WebElement price;

    @FindBy(xpath = "//div[@id='more-information']")
    WebElement description;

    @FindBy(linkText = "Add to cart")
    WebElement addToCartButton;



    public void chooseProduct(String product) throws InterruptedException {
        Thread.sleep(2000);
        for(WebElement item:allProducts){
            if(BrowserUtils.getText(item).equals(product)){
                item.click();
                return;
            }
        }
        Assert.fail("There is no matching item on the list");
    }

    public void validateProductInformation(String expectedHeader,String expectedPrice,String expectedDesc){
        Assert.assertEquals(expectedHeader,BrowserUtils.getText(header));
        Assert.assertEquals(expectedPrice,BrowserUtils.getText(price));
        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDesc));
    }

    public void clickAddToCart(WebDriver driver,String expectedMessage) throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(1000);
        Alert alert=driver.switchTo().alert();
        Assert.assertEquals(expectedMessage,alert.getText().trim());
        alert.accept();
    }

}
