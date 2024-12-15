package pages;

import Utilities.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends  BasePages{

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//header/div[1]/div[1]/span[1]/h6[1]")
    private WebElement dashboardLogo;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]")
    private WebElement adminBtn;

    public void pressAdminBtn(){
    actionMethods.clickElement(adminBtn);
        LoggerUtility.infoLog("The User click on Admin Menu Option");
    waitMethods.waitFor(350);
}

    public void verifyCurrentPageIsHomePage(){
        waitMethods.waitVisibleElement(dashboardLogo);
        Assert.assertTrue(true, String.valueOf(dashboardLogo.isDisplayed()));
    }
}
