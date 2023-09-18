package com.test.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class WebOrderGroupOrderPage {

    public WebOrderGroupOrderPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#InviteNote")
    WebElement inviteesNote;

    @FindBy(css = "#InviteList")
    WebElement inviteList;

    @FindBy(css = "#ConfirmAddressID")
    WebElement location;

    @FindBy(css = "#addressPreview")
    WebElement address;

    @FindBy(css = "#createGroupOrder")
    WebElement createGroupOrderButton;

    @FindBy(tagName = "h1")
    WebElement header;

    @FindBy(xpath = "//p[contains(text(),'Your group order is now pending')]")
    WebElement description;

  public void sendInviteesNote(String note){
      inviteesNote.sendKeys(note);
  }

  public void sendInviteList(String gmail1,String gmail2){
      inviteList.sendKeys(gmail1+" , "+gmail2);
  }

  public void chooseLocation(String location,String expectedAddress){
      BrowserUtils.selectBy(this.location,location,"text");
      Assert.assertTrue(BrowserUtils.getText(address).contains(expectedAddress));
  }

  public void clickCreateGroupOrderButton(){
      createGroupOrderButton.click();
  }

  public void orderValidation(String expectedHeader,String expectedDescription) throws InterruptedException {
      Thread.sleep(2000);
      Assert.assertEquals(expectedHeader,BrowserUtils.getText(header));
      Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDescription));
  }






}
