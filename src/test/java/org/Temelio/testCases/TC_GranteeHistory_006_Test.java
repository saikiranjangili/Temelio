package org.Temelio.testCases;

import com.aventstack.extentreports.Status;
import org.Temelio.PageObjects.ContactsPage;
import org.Temelio.PageObjects.LoginPage;
import org.Temelio.Utilities.Reports;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.awt.*;


@Listeners(Reports.class)
public class TC_GranteeHistory_006_Test extends BaseClass {
    WebDriver driver = getDriver();

    @Test
    public void EditGrateeHistory() throws AWTException, InterruptedException {

        logger.log(Status.INFO, "The Test Grantee History  is started");
        driver.get(baseUrl);
        LoginPage lp = new LoginPage(driver);
        lp.login();
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

        logger.log(Status.PASS, "The Test is sucessfull");

        driver.quit();
        logger.log(Status.INFO, "Browser is closed");

    }

}
