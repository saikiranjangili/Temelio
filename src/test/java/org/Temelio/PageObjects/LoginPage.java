package org.Temelio.PageObjects;

import org.Temelio.Utilities.ReadConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage {

    private static final String loginEmail = ReadConfig.loginData().get("Email");
    private static final String loginPassword = ReadConfig.loginData().get("Password");
    private static final String title = ReadConfig.loginData().get("TitleofPage");
    @FindBy(xpath = "//input[@inputmode='email']")
    WebElement username;
    @FindBy(xpath = "//input[@id='password']")
    WebElement password;
    @FindBy(xpath = "//div[@class='cf772ffae']/button[@type='submit']")
    WebElement btnsubmit;
    @FindBy(xpath = "//a[contains(.,'Forgot password?')]")
    WebElement forgotpassword;
    @FindBy(xpath = "//a[contains(.,'Sign up')]")
    WebElement signup;
    @FindBy(xpath = "//div[@class='css-r6z5ec']//a/span[contains(text(),'Logout')]")
    WebElement Logout;
    WebDriver driver;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void login() {
        username.sendKeys(loginEmail);
        password.sendKeys(loginPassword);
        btnsubmit.click();
        Assert.assertEquals(driver.getTitle(), title);

    }


}
