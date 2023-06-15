package org.Temelio.PageObjects;

import junit.framework.Assert;
import org.Temelio.Utilities.JavaUtils;
import org.Temelio.Utilities.ReadConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class AdminPage {
    private static final String displayName = ReadConfig.admindata().get("DisplayName");
    private static final String userEmail = ReadConfig.admindata().get("useremail");
    private static final String titleOfMember = ReadConfig.admindata().get("titleofMemeber");
    private static final String accessType = ReadConfig.admindata().get("accessType");
    private static final String totalbudgetAmount = ReadConfig.admindata().get("budgetamount");
    private static final String foundationTag = ReadConfig.admindata().get("foundatinTag");
    private static final String title = ReadConfig.loginData().get("TitleofPage");
    private static final String bdgtcatAmountt = ReadConfig.loginData().get("bdgtamount");
    private static final String budgetCatogory = ReadConfig.loginData().get("bdgtcatogory");
    @FindBy(xpath = "//button[@id='menu-button-:Rcplhf6H1:']")
    WebElement btnArrow;
    @FindBy(xpath = "//a[@id='menu-list-:Rcplhf6H1:-menuitem-:r0:']")
    WebElement AdminSettings;
    @FindBy(xpath = "//button[normalize-space()='Edit']")
    WebElement btnEdit;
    @FindBy(xpath = "//button[contains(.,'Add Team Member +')]")
    WebElement AddTeamMember;
    // @FindBy(xpath="//input[@id='field-:r3g:']")
    @FindBy(xpath = "(//div[@class='chakra-modal__overlay css-ux9z30']//input)[1]")
    WebElement DisplayName;
    @FindBy(xpath = "(//div[@class='chakra-modal__overlay css-ux9z30']//input)[2]")
    WebElement useremail;
    @FindBy(xpath = "(//div[@class='chakra-modal__overlay css-ux9z30']//input)[3]")
    WebElement Title;
    @FindBy(xpath = "//div[@class='chakra-modal__overlay css-ux9z30']//div[@class='chakra-select__wrapper css-42b2qy']/select")
    WebElement AccessType;
    @FindBy(xpath = "//div[@class='chakra-modal__overlay css-ux9z30']//footer/button[.='Add']")
    WebElement btnadd;
    @FindBy(xpath = "//div[@class='chakra-modal__overlay css-ux9z30']//footer/button[.='Cancel']")
    WebElement btncancel;
    @FindBy(xpath = "//input[@placeholder='Tag name...']")
    WebElement FoundationTag;
    @FindBy(xpath = "//div[@class='chakra-stack css-1sgivba']//button[.='Add']")
    WebElement btnTagadd;
    //div[@id='toast-3-title']
    @FindBy(xpath = "//div[@class='css-1xeodxx']")
    WebElement bluecolor;
    @FindBy(xpath = "//div[@class='chakra-form-control css-uwa2p6']//input")
    WebElement budgetamount;
    @FindBy(xpath = "//*[name()='path' and contains(@d,'M11 11V5h2')]")
    WebElement Allocatebtn;
    @FindBy(xpath = "//div[(@role='group') and (@class='chakra-form-control css-al1k6j')]")
    WebElement budgetItems;
    //div[@class='chakra-form-control css-al1k6j']//input[@type='text']
    @FindBy(xpath = "(//div[@class='chakra-stack css-1igwmid'])[2]//div")
    WebElement allcolours;


    @FindBy(xpath = "//button[contains(.,'Save')]")
    WebElement btnSave;
    WebDriver driver;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickEdit() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        btnArrow.click();
        AdminSettings.click();
        btnEdit.click();
    }

    public void addFoundationTags() throws InterruptedException {

        FoundationTag.sendKeys(foundationTag);
        //JavaUtils.randomElement().click();
        btnTagadd.click();
        btnSave.click();
    }

    public void AddTeamMember() {
        AddTeamMember.click();
        DisplayName.sendKeys(displayName);
        useremail.sendKeys(userEmail);
        Title.sendKeys(titleOfMember);

        String actualaccessType = "";
        Select sc = new Select(AccessType);
        if (actualaccessType == accessType) {
            sc.selectByVisibleText(actualaccessType);
        }
       btncancel.click();
        //btnadd.click();
        Assert.assertEquals(driver.getTitle(), title);
    }

    public void Budget() throws InterruptedException {
        budgetamount.clear();
        budgetamount.sendKeys(totalbudgetAmount);
        Allocatebtn.click();

        List<WebElement> values = driver.findElements(By.xpath("//div[@class='chakra-form-control css-al1k6j']//input[@type='text']"));

        for (int i = 1; i <= values.size(); i++) {
            WebElement value = driver.findElement(By.xpath("(//div[@class='chakra-form-control css-al1k6j']//input[@type='text'])[" + i + "]"));
            if (value.getAttribute("value").equalsIgnoreCase("$0")) {
                Thread.sleep(2000);
                WebElement budgetctgy = driver.findElement(By.xpath("(//div[@class='chakra-form-control css-al1k6j'])[" + i + "]//input"));
                budgetctgy.sendKeys(budgetCatogory);
                value.sendKeys(bdgtcatAmountt);
                break;
            }

        }
        btnSave.click();
    }
}

