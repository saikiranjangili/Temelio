package org.Temelio.testCases;

import com.aventstack.extentreports.Status;
import org.Temelio.PageObjects.AdminPage;
import org.Temelio.PageObjects.LoginPage;
import org.Temelio.Utilities.Reports;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(Reports.class)
public class TC_Budget_005_Test extends BaseClass {
    WebDriver driver = getDriver();

    @Test
    public void EditBudget() throws InterruptedException {
        logger.log(Status.INFO, "The Test Add FoundationTag is started");
        driver.get(baseUrl);
        LoginPage lp = new LoginPage(driver);
        lp.login();
        logger.log(Status.INFO, "The Login is succesful");
        logger.log(Status.INFO, "The Login is successful");
        logger.log(Status.PASS, "Started editing the budget  and budget catogory");

        AdminPage ad = new AdminPage(driver);
        ad.clickEdit();
        ad.Budget();
        logger.log(Status.INFO, "The Budget is modified according to the catogory");
        logger.log(Status.PASS, "The Test is sucessfull");

        driver.quit();
        logger.log(Status.INFO, "Browser is closed");
    }


}
