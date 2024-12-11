package sharedData;

import Utilities.LoggerUtility;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Hooks extends SharedData {

    public String testClassName;

    @BeforeMethod
    public void prepareEnvironment(){
        testClassName = this.getClass().getSimpleName();

        setUpDriver();
        LoggerUtility.startTest(testClassName);
    }

    @AfterMethod
    public void clearEnvironment(ITestResult result){
        if (!result.isSuccess()){
            LoggerUtility.errorLog(result.getThrowable().getMessage());
        }
        quitDriver();
        LoggerUtility.finishTest(testClassName);
    }
}