package helpers;

import Utilities.LoggerUtility;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitMethods {
    public WebDriver driver;

    public WaitMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitVisibleElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitVisibleList(List<WebElement> List) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(List));
    }
    public void waitFor(int intervalMs) {
        try {
            LoggerUtility.infoLog("Waiting for {} ms");
            Thread.sleep(intervalMs);
        } catch (InterruptedException | StaleElementReferenceException e) {
            LoggerUtility.errorLog(e.getLocalizedMessage());
            Thread.currentThread().interrupt();
        }
    }

}
