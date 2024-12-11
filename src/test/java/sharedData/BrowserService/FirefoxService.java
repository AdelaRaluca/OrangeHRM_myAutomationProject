package sharedData.BrowserService;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.time.Duration;

public class FirefoxService implements BrowserService{
    private WebDriver driver;

    @Override
    public void openBrowser() {
        FirefoxOptions options = prepareOptions();
        driver = new FirefoxDriver(options);
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Override
    public FirefoxOptions prepareOptions() {
        boolean ciCd = Boolean.parseBoolean(System.getProperty("ciCd"));

        FirefoxOptions options = new FirefoxOptions();

        // Run in headless mode for CI/CD if specified
        if (ciCd) {
            options.addArguments("--headless"); // Corrected headless argument
        }

        // Browser settings
        options.addArguments("--width=1920");
        options.addArguments("--height=1080");
        // Accept untrusted certificates
        options.setAcceptInsecureCerts(true);
        // Set Firefox profile preferences
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("network.proxy.type", 0); // Use no proxy settings
        // Attach profile to options
        options.setProfile(profile);

        // Return the configured options
        return options;
    }

    public WebDriver getDriver() {
        return driver;
    }
}