package pages;

import Utilities.LoggerUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends BasePages {

    public AdminPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//nav/ul/li[2]/span")
    private WebElement jobDrd;

    public void clickJobDrd(){
        actionMethods.clickElement(jobDrd);
        LoggerUtility.infoLog("The User click on Job Dropdown");
        waitMethods.waitFor(350);
    }

}
