package pages;

import Utilities.LoggerUtility;
import modelObject.LoginModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePages{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[1]/div[1]/div[2]/input[1]")
    private WebElement emailInput;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[2]/div[1]/div[2]/input[1]")
    private WebElement passInput;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[3]/button[1]")
    private WebElement loginBtn;

    @FindBy(xpath = "//header/div[1]/div[1]/span[1]/h6[1]")
    private WebElement homePage;

    public void validLogin(LoginModel testData) {
        actionMethods.typeText(emailInput, testData.getUsername());
        LoggerUtility.infoLog("The User fill the username");
        actionMethods.typeText(passInput, testData.getPassword());
        LoggerUtility.infoLog("The User fill the Password");
        actionMethods.clickElement(loginBtn);
        LoggerUtility.infoLog("The User click on Login button");
    }
    public void verifyLoginSuccessfull(){

}
}
