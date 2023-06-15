package org.Temelio.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.Temelio.Utilities.ExcelUtilities;
import org.Temelio.Utilities.ReadConfig;
import org.Temelio.Utilities.Reports;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Listeners;

import java.time.Duration;

@Listeners(Reports.class)
public class BaseClass extends Reports {

    public static WebDriver driver;
    public static ExcelUtilities xl = new ExcelUtilities();
    static String browser = ReadConfig.loginData().get("Browser");
    public String baseUrl = ReadConfig.loginData().get("LoginURL");

    public static WebDriver getDriver() {

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));

        return driver;
    }


}
