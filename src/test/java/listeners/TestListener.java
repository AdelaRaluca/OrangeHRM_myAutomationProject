package listeners;

import Utilities.ExtentUtilities.ExtentTestManager;
import Utilities.LoggerUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    public WebDriver driver;

    public TestListener(WebDriver driver) {
        this.driver=driver;

    }

    public void setDriver(WebDriver driver){
    this.driver = driver;
}

    @Override
    public void onTestStart(ITestResult result) {
        LoggerUtility.infoLog("Test Started: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        LoggerUtility.infoLog("Test Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        LoggerUtility.warnLog("Test Failed: " + result.getName());

        if (driver != null) {
            try {
                // Take a base64 screenshot for extent reports
                String base64Screenshot =
                        "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

                // Log failure and attach screenshot to the extent report
                ExtentTestManager.getTest().log(Status.FAIL, "Test Failed",
                        ExtentTestManager.getTest()
                                .addScreenCaptureFromBase64String(base64Screenshot)
                                .getModel()
                                .getMedia()
                                .get(0));
            } catch (Exception e) {
                LoggerUtility.errorLog("Error capturing screenshot: " + e.getMessage());
            }
        } else {
            LoggerUtility.errorLog("Driver is null. Unable to capture screenshot.");
        }
    }

    @Override
    public void onStart(ITestContext context) {
        LoggerUtility.infoLog("**** STARTING TEST SUITE ****");
    }

    @Override
    public void onFinish(ITestContext context) {
        LoggerUtility.infoLog("**** FINISHING TEST SUITE ****");
        LoggerUtility.infoLog("Total Tests Run: " +
                (context.getPassedTests().size() + context.getFailedTests().size()));
    }
}
