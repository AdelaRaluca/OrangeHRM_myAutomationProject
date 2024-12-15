package Utilities.ExtentUtilities;

import Utilities.LoggerUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;

public class ExtentManager {
    private static final String REPORT_CONFIG_PATH = "src/main/resources/extentReportConfig";
    private static ExtentReports extentReports;
    private static final LocalDate CURRENT_DATE = LocalDate.now();

    @SneakyThrows
    public static synchronized ExtentReports createExtentReports() {
        LoggerUtility.infoLog("GENERATE EXTENT REPORT");
        if (extentReports == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter("./test-output/extent-report.html")
                    .viewConfigurer()
                    .viewOrder()
                    .as(new ViewName[]{
                            ViewName.TEST,
                            ViewName.DASHBOARD,
                            ViewName.CATEGORY
                    })
                    .apply();

            // Load custom configuration file
            try {
                reporter.loadXMLConfig(getDefaultCustomConfigFile());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // Create ExtentReports instance and attach reporter
            extentReports = new ExtentReports();
            extentReports.attachReporter(reporter);

            // Add system information
            extentReports.setSystemInfo("Author", System.getProperty("user.name"));
            extentReports.setSystemInfo("Date", CURRENT_DATE.toString());
            extentReports.setSystemInfo("Browser", System.getProperty("browser"));
        }
        return extentReports;
    }

//Retrieves the current ExtentReports instance
    public static synchronized ExtentReports getExtentReports() {
        return extentReports;
    }

    //return configuration file
    private static File getDefaultCustomConfigFile() {
        LoggerUtility.infoLog(REPORT_CONFIG_PATH);
        LoggerUtility.warnLog("If extentReportConfig.xml file is not set, the report will use the default configuration!");
        InputStream reportConfigAsStream = ExtentManager.class.getResourceAsStream("/extentReportConfig.xml");
        Assert.assertNotNull(reportConfigAsStream, "The extentReportConfig.xml file is not found in the classpath.");

        File configFile;
        try {
            configFile = File.createTempFile("extentReportConfig", ".xml");
            FileUtils.copyInputStreamToFile(reportConfigAsStream, configFile);
        } catch (IOException e) {
            throw new RuntimeException("The report configuration file is not found in path " + REPORT_CONFIG_PATH, e);
        }
        return configFile;
    }
}

