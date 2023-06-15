package org.Temelio.testCases;

import com.aventstack.extentreports.Status;
import org.Temelio.PageObjects.AdminPage;
import org.Temelio.Utilities.Reports;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Reports.class)
public class TC_AddFoundationTags_003 extends BaseClass {

    WebDriver driver = getDriver();

    @Test
    public void addFoundationTags() {
        logger.log(Status.INFO, "The Test addFoundationTag is started");

        logger.log(Status.INFO, "The Login is successful");

        logger.log(Status.INFO, "The started adding a Foundation Tag");
        AdminPage ad = new AdminPage(driver);
        ad.clickEdit();
        ad.addFoundationTags();
        logger.log(Status.INFO, "The Foundation Tag added successfully");

        logger.log(Status.PASS, "The Test is sucessfull");


    }
}
