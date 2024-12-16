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

    @FindBy(xpath = "//a[contains(text(),'Job Titles')]")
    private WebElement jobTitlesOption;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addJobTitleBtn;

    public AdminPage clickJobDrd() {
        actionMethods.clickElement(jobDrd);
        LoggerUtility.infoLog("The User click on Job Dropdown");
        waitMethods.waitFor(350);
        return this;
    }

    public AdminPage selectJobTitlesOption(){
        actionMethods.clickJSElement(jobTitlesOption);
        LoggerUtility.infoLog("Job Titles option is selected from the dropdown menu");
        waitMethods.waitFor(250);
        return this;
    }

    public AdminPage pressAddNewJobTitle(){
        actionMethods.clickElement(addJobTitleBtn);
        LoggerUtility.infoLog("Press Add button for a new Job Title");
        waitMethods.waitFor(250);
        return this;
    }


}
