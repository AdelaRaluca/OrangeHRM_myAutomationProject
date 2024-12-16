package sharedData;

import Utilities.ExtentUtilities.ExtentManager;
import Utilities.ExtentUtilities.ExtentTestManager;
import Utilities.LoggerUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import listeners.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

@Listeners(TestListener.class)
public class Hooks extends SharedData {

    public String testClassName;
    protected ExtentTestManager test;
    protected ExtentReports extent;
    protected TestListener testListener;
    protected WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void extentSetup() {
        extent = ExtentManager.createExtentReports();
    }

    @BeforeClass(alwaysRun = true)
    public void prepareEnvironment() {
        testClassName = this.getClass().getSimpleName();

        setUpDriver();
//        testListener = new TestListener();
//        testListener.setTestClassName(testClassName);
//        testListener.setDriver(driver);
        LoggerUtility.startTest(testClassName);
    }
    @BeforeMethod
    public void startExtent(Method method) {
        Test test = method.getAnnotation(Test.class);
        ExtentTestManager.startTest(method.getName(), test.description());
        ExtentTestManager.getTest().assignAuthor("General_status");
    }

    @AfterMethod
    public void afterEachTestMethod(ITestResult result) {
        for (String group : result.getMethod().getGroups()) {
            ExtentTestManager.getTest().assignCategory(group);
        }

        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                ExtentTestManager.getTest().log(Status.PASS, "Test Passed");
                break;
            case ITestResult.FAILURE:
                ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());
                break;
            case ITestResult.SKIP:
                break;
            default:
                ExtentTestManager.getTest().log(Status.WARNING, "Test status unknown");
        }
    }

    @AfterClass
    public void clearEnvironment() {
//        if (!result.isSuccess()) {
//            LoggerUtility.errorLog(result.getThrowable().getMessage());
//        }
        quitDriver();
        LoggerUtility.finishTest(testClassName);
    }

    @AfterSuite(alwaysRun = true)
    public void generateReport() {
        if (null != extent) {
            extent.flush();
        }
    }
}