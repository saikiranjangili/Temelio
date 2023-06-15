package org.Temelio.testCases;

import com.aventstack.extentreports.Status;
import org.Temelio.PageObjects.LoginPage;
import org.Temelio.Utilities.Reports;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Reports.class)
public class TC_LoginTest_001 extends BaseClass {
    WebDriver driver;

    @Test
    public void LoginTest() {
        logger.log(Status.INFO, "The Test addTeamMember is started");
        driver = getDriver();
        driver.get(baseUrl);
        LoginPage lp = new LoginPage(driver);
        lp.login();

        logger.log(Status.INFO, "The Login is successful");

    }
    @AfterTest
    public void teardown() {
        driver.quit();
        logger.log(Status.INFO, "Browser is closed");
    }

}
