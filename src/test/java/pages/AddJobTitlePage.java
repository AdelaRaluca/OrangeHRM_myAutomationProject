package pages;

import Utilities.LoggerUtility;
import modelObject.AddJobTitleModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddJobTitlePage extends BasePages {

    public AddJobTitlePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[2]/input[1]")
    private WebElement jobTitleInput;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/div[1]/div[2]/textarea[1]")
    private WebElement jobDescriptionInput;

    @FindBy(xpath = "//div[contains(text(),'Browse')]")
    private WebElement uploadJobSpecificationFileBtn;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[4]/div[1]/div[2]/textarea[1]")
    private WebElement noteInput;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[5]/button[2]")
    private WebElement saveJobTitleBtn;

    public void addJobTitle(AddJobTitleModel addNewJobData) {
        actionMethods.typeText(jobTitleInput,addNewJobData.getJobTitleInput());
        waitMethods.waitFor(400);
        LoggerUtility.infoLog("Add the new job title");
        actionMethods.typeText(jobDescriptionInput,addNewJobData.getJobDescriptionInput());
        waitMethods.waitFor(400);
        LoggerUtility.infoLog("Add description for the newly job added");
        actionMethods.sendKeys(uploadJobSpecificationFileBtn,addNewJobData.getJobDescriptionInput());
        waitMethods.waitFor(400);
        LoggerUtility.infoLog("Add Job Specification for the newly job added");
        actionMethods.typeText(noteInput, addNewJobData.getNoteInput());
        waitMethods.waitFor(350);
        actionMethods.clickJSElement(saveJobTitleBtn);
        LoggerUtility.infoLog("Save the newly job title");
        waitMethods.waitFor(400);
    }
}
