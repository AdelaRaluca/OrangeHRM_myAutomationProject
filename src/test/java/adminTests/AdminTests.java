package adminTests;

import modelObject.AddJobTitleModel;
import modelObject.LoginModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import pages.AddJobTitlePage;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import sharedData.Hooks;

public class AdminTests extends Hooks {

    private static final Logger log = LoggerFactory.getLogger(AdminTests.class);

    @Test(description="Add a new Job in Admin/Job")
    public void addNewJobTitle(){
        LoginModel testData = new LoginModel("src/main/resources/inputData/LoginResource.json");
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        AdminPage adminPage = new AdminPage(getDriver());
        AddJobTitleModel addNewJobData = new AddJobTitleModel("src/main/resources/inputData/jobAddTitleData.json");
        AddJobTitlePage addJobTitlePage = new AddJobTitlePage(getDriver());

        loginPage
                .validLogin(testData);
        homePage
                .pressAdminBtn()
                .clickJobDrd()
                .selectJobTitlesOption()
                .pressAddNewJobTitle();
       addJobTitlePage
               .addJobTitle(addNewJobData);

    }
}

