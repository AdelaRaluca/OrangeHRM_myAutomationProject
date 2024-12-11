package sharedData;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import sharedData.BrowserService.ChromeService;
import sharedData.BrowserService.EdgeService;
import sharedData.BrowserService.FirefoxService;

@Getter
public class SharedData {

    private WebDriver driver;

    public void setUpDriver() {
        String browser = System.getProperty("browser");

        switch (browser) {
            case "edge":
                EdgeService edgeService = new EdgeService();
                edgeService.openBrowser();
                driver = edgeService.getDriver();
                break;
            case "chrome":
                ChromeService chromeService = new ChromeService();
                chromeService.openBrowser();
                driver = chromeService.getDriver();
                break;
            case "firefox":
                FirefoxService firefoxService = new FirefoxService();
                firefoxService.openBrowser();
                driver = firefoxService.getDriver();
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}