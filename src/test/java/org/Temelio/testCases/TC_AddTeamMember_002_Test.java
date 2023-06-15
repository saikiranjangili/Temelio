package org.Temelio.testCases;


import com.aventstack.extentreports.Status;
import org.Temelio.PageObjects.AdminPage;
import org.Temelio.PageObjects.LoginPage;
import org.Temelio.Utilities.Reports;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Reports.class)
public class TC_AddTeamMember_002_Test extends BaseClass {
    WebDriver driver = getDriver();

    @Test
    public void addTeamMember() {

        logger.log(Status.INFO, "The Test Add Team Member is started");
        driver.get(baseUrl);
        LoginPage lp = new LoginPage(driver);
        lp.login();
        logger.log(Status.INFO,"The Login is succesful");
        logger.log(Status.INFO, "The started adding a team member");

        AdminPage ad = new AdminPage(driver);
        ad.clickEdit();
        ad.AddTeamMember();

        logger.log(Status.INFO, "The team member added successfully");

        logger.log(Status.PASS, "The Test is sucessfull");

        driver.quit();
        logger.log(Status.INFO, "Browser is closed");

    }


}
