package sharedData.BrowserService;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

@Getter
public class ChromeService implements BrowserService {
    private WebDriver driver;

    @Override
    public void openBrowser() {
        ChromeOptions options = prepareOptions();
        driver = new ChromeDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Override
    public ChromeOptions prepareOptions() {
        boolean ciCd = Boolean.parseBoolean(System.getProperty("ciCd"));

        ChromeOptions options = new ChromeOptions();
        if (ciCd) {
            options.addArguments("--headless=new"); // Run in headless mode for CI
        }
        options.addArguments("--no-sandbox"); // Required for GitHub Actions
        options.addArguments("--disable-dev-shm-usage"); // Prevents memory issues
        options.addArguments("--window-size=1920,1080"); // Set a default window size
//        options.setCapability("browserName", "Chrome");
        return options;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
