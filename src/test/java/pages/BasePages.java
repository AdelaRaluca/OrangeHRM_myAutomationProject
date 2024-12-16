package pages;

import helpers.ActionMethods;
import helpers.WaitMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePages {
    protected WebDriver driver;
    protected ActionMethods actionMethods;
    protected WaitMethods waitMethods;
    protected AdminPage adminPage;
    protected AddJobTitlePage addJobTitlePage;

    public BasePages(WebDriver driver) {
        this.driver = driver;
        actionMethods = new ActionMethods(this.driver);
        waitMethods = new WaitMethods(this.driver);
//        adminPage = new AdminPage(this.driver);
//        addJobTitlePage = new AddJobTitlePage(this.driver);
        PageFactory.initElements(this.driver, this);
    }
}

