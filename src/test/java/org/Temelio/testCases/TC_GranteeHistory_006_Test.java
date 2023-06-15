package org.Temelio.testCases;

import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.Temelio.PageObjects.ContactsPage;
import org.Temelio.PageObjects.LoginPage;
import org.Temelio.Utilities.Reports;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

@Listeners(Reports.class)
public class TC_GranteeHistory_006 extends BaseClass {
    WebDriver driver =getDriver();
    @Test
    public void EditGrateeHistory() throws AWTException, InterruptedException, IOException {
        logger.log(Status.INFO, "The Test addFoundationTag is started");

        logger.log(Status.INFO, "The Login is successful");
        ContactsPage cp = new ContactsPage(driver);
        cp.organizationPage();
        logger.log(Status.INFO, "Organization Page opened");
        cp.editGranteeHistory();
        logger.log(Status.INFO, "Grantee history details opened");
        cp.editPayment();
        logger.log(Status.INFO, "Payment Schedule done");
        cp.editActivities();
        logger.log(Status.INFO, "Viewed the Acitivites");
        cp.editDocuments();
        logger.log(Status.INFO, "Documents viewed and uploaded");

    }
}
