package com.test.facebook.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class FacebookAccountPage {

    public FacebookAccountPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(partialLinkText = "new account")
    WebElement createNewAccountButton;

    @FindBy(name = "firstname")
    WebElement firstName;

    @FindBy(name = "lastname")
    WebElement lastName;

    @FindBy(name = "reg_email__")
    WebElement email;

    @FindBy(name = "reg_email_confirmation__")
    WebElement confirmEmail;

    @FindBy(name = "reg_passwd__")
    WebElement password;

    @FindBy(css = "#month")
    WebElement month;

    @FindBy(css = "#day")
    WebElement day;

    @FindBy(css = "#year")
    WebElement year;

    @FindBy(xpath = "//label[.='Female']")
    WebElement femaleButton;

    @FindBy(xpath = "//label[.='Male']")
    WebElement maleButton;

    @FindBy(name = "websubmit")
    WebElement signUpButton;


    public void clickCreateAccountButton(){
        createNewAccountButton.click();
    }

    public void provideCustomerInformation(String firstName,String lastName,String email,String password) throws InterruptedException {
        Thread.sleep(1000);
        this.firstName.sendKeys(firstName);
        Thread.sleep(1000);
        this.lastName.sendKeys(lastName);
        Thread.sleep(1000);
        this.email.sendKeys(email);
        Thread.sleep(1000);
        this.confirmEmail.sendKeys(email);
        Thread.sleep(1000);
        this.password.sendKeys(password);
        Thread.sleep(1000);
    }

    public void chooseBirthDay(String month,String day,String year) throws InterruptedException {
        BrowserUtils.selectBy(this.month,month,"text");
        Thread.sleep(1000);
        BrowserUtils.selectBy(this.day,day,"value");
        Thread.sleep(1000);
        BrowserUtils.selectBy(this.year,year,"value");
        Thread.sleep(1000);
    }

    public void chooseGender(String expectedGender){
        if(expectedGender.equalsIgnoreCase("Female")){
            femaleButton.click();
        }else{
            maleButton.click();
        }
    }
    public void clickSignUpButton(){
        signUpButton.click();
    }
}
