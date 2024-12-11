package authenticationTests;

import modelObject.LoginModel;
import org.testng.annotations.Test;
import pages.LoginPage;
import sharedData.Hooks;

public class AuthenticationTest extends Hooks {

    @Test(description = "Login with valid credentials")
    public void validAuth(){
        LoginModel testData = new LoginModel("src/main/resources/inputData/LoginResource.json");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage
                .validLogin(testData);
    }

}
