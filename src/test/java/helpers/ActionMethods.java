package helpers;

import Utilities.LoggerUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ActionMethods {
    public WebDriver driver;
    public WaitMethods waitMethods;
    public ActionMethods actionMethods;

    public ActionMethods(WebDriver driver){
        this.driver=driver;
    }

    public void clickElement(WebElement element) {
        element.click();
    }

    public void clickJSElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }
    public void selectDropdownElement(WebElement element, String text) {
        waitMethods.waitVisibleElement(element);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public String getSelectedDropdownOption(WebElement dropdown) {
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }

    public String getTextOfElement(WebElement element){
        LoggerUtility.infoLog("Get text from element locate at " + element);
        waitMethods.waitVisibleElement(element);
        return element.getText();
    }

    public void clearTheText(WebElement elem) {
        waitMethods.waitVisibleElement(elem);
        elem.clear();
//        LoggerUtility.infoLog("Cleared text content for element " + elem);
    }

    public void typeText(WebElement elem, String text) {
//        LoggerUtility.infoLog(String.format("Sending %s to element %s", text, elem));
        clearTheText(elem);
        elem.sendKeys(text);
//        LoggerUtility.infoLog(String.format("Sent text %s to element %s", text, elem));
    }

    public void sendKeys(Keys enter) {
    }
}
