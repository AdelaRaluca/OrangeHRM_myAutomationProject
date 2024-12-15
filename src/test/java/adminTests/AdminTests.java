package adminTests;

import modelObject.LoginModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import sharedData.Hooks;

public class AdminTests extends Hooks {

    private static final Logger log = LoggerFactory.getLogger(AdminTests.class);

    @Test(description="Add a new Job in Admin/Job")
    public void goToAdminPage(){
        LoginModel testData = new LoginModel("src/main/resources/inputData/LoginResource.json");
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AdminPage adminPage = new AdminPage(getDriver());

        loginPage
                .validLogin(testData);
        homePage
                .pressAdminBtn();
        adminPage
                .clickJobDrd();
    }
}

