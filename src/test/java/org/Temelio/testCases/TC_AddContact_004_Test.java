package org.Temelio.testCases;

import com.aventstack.extentreports.Status;
import org.Temelio.PageObjects.ContactsPage;
import org.Temelio.Utilities.Reports;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Reports.class)
public class TC_AddContact_004_Test extends BaseClass {
    WebDriver driver = getDriver();

    @Test
    public void addContact() throws InterruptedException {

        logger.log(Status.INFO, "The Test addContact is started");

        logger.log(Status.INFO, "The Login is successful");
        logger.log(Status.INFO, "The started adding a contact Tag");
        ContactsPage cp = new ContactsPage(driver);
        cp.addContact();
        logger.log(Status.INFO, "The Contact added successfully");

        logger.log(Status.PASS, "The Test is sucessfull");

    }
}
