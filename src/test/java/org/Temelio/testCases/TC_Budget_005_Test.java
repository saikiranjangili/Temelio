package org.Temelio.testCases;

import com.aventstack.extentreports.Status;
import org.Temelio.PageObjects.AdminPage;
import org.Temelio.Utilities.Reports;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(Reports.class)
public class TC_Budget_005 extends BaseClass {
    WebDriver driver = getDriver();
    @Test
    public void EditBudget() throws InterruptedException {
        logger.log(Status.INFO, "The Test addFoundationTag is started");

        logger.log(Status.INFO, "The Login is successful");

        AdminPage ad = new AdminPage(driver);
        ad.clickEdit();
        ad.Budget();


    }

}
