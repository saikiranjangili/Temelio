package org.Temelio.PageObjects;

import org.Temelio.Utilities.JavaUtils;
import org.Temelio.Utilities.ReadConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ContactsPage {
    private static final String searchname = ReadConfig.contactData().get("orgSearchName");
    private static final String OrgFullName = ReadConfig.contactData().get("orgfullname");
    private static final String Contactname = ReadConfig.contactData().get("contactname");
    private static final String ContactEmail = ReadConfig.contactData().get("contactemail");
    private static final String InternalNotes = ReadConfig.contactData().get("internalnotes");
    private static final String Filepath = ReadConfig.contactData().get("uploadpath");
    private static final String SearchFilename = ReadConfig.contactData().get("searchFileName");
    private static final String Filename = ReadConfig.contactData().get("FileName");
    private static final String tileofPage = ReadConfig.loginData().get("TitleofPage");
    @FindBy(xpath = "//div[@class='chakra-stack css-1ysupqj']/a//div[contains(text(),'Contacts')]")
    WebElement Contacts;
    @FindBy(xpath = "//div[@class='css-5gzrmk']")
    WebElement Grantees;
    @FindBy(xpath = "//div[@class='css-10z8ruj']//div[starts-with(text(),'Entity')]")
    WebElement Entity;
    @FindBy(xpath = "//input[@placeholder='Search...']")
    WebElement entitySearch;
    @FindBy(xpath = "(//div[@class='chakra-stack css-g2omk4']/button)[2]")
    WebElement NewContact;
    @FindBy(xpath = "//form[@class='chakra-modal__body css-qlig70']//div/input[@placeholder='Search by Name']")
    WebElement SearchByName;
    @FindBy(xpath = "//form[@class='chakra-modal__body css-qlig70']//div/button")
    WebElement btnsearch;
    @FindBy(xpath = "//input[@name='primaryContactName']")
    WebElement PrimaryContactname;
    @FindBy(xpath = "//input[@name='primaryContactEmail']")
    WebElement PrimaryContactEmail;
    @FindBy(xpath = "//*[@id=\"create-contact-form\"]/div[2]/div[6]/label[2]/span")
    WebElement emailtoggle;
    @FindBy(xpath = "//div[@class='chakra-button__group css-1ind3v2']/button[@type='submit']")
    WebElement btnCreatecontact;
    @FindBy(xpath = "//div[@class='chakra-modal__content-container css-1u2cvaz']//footer//button[contains(text(),'Cancel')]")
    WebElement btnContactcancel;
    @FindBy(xpath = "//div[@class=' css-1yiwoxh']//input")
    WebElement ContactSearch;
    @FindBy(xpath = "//button[@aria-label='refresh']")
    WebElement refresh;
    @FindBy(xpath = "//p[contains(text(),'Latest Filing PDF')]/a")
    WebElement filing990;
    @FindBy(xpath = "//h2[contains(text(),'TOP DOG')]/button")
    WebElement btncontactedit;
    @FindBy(xpath = "//div[@class='chakra-stack css-1bpxyol']/a/div[contains(text(),'Activity')]")
    WebElement Activity;
    @FindBy(xpath = "//div[@class='chakra-stack css-1bpxyol']/a/div[contains(text(),'Payments')]")
    WebElement Payments;
    @FindBy(xpath = "//div[@class='chakra-stack css-1bpxyol']/a/div[contains(text(),'Documents')]")
    WebElement Documents;
    @FindBy(xpath = "//div[@class='chakra-stack css-1bpxyol']/a/div[contains(text(),'Grant History')]")
    WebElement GrantHistory;
    @FindBy(xpath = "//button[@class='chakra-button css-l2c5hn']")
    WebElement btnFolder;
    @FindBy(xpath = "//button[@class='chakra-button css-16fpbmu']")
    WebElement Upload;
    @FindBy(xpath = "//input[@placeholder='Search folders or files']")
    WebElement searchfile;
    @FindBy(xpath = "//div[@class='chakra-modal__content-container css-1u2cvaz']//section/button")
    WebElement btnfilecancel;
    @FindBy(xpath = "//div[@class='css-e44hq7']//h2[contains(text(),'Grant Payments')]/following-sibling::button")
    WebElement schedulepayment;
    @FindBy(xpath = "//div[@class='chakra-stack css-1igwmid']/button[@class='chakra-button css-w0kjkl']")
    WebElement paymentcancel;
    @FindBy(xpath = "//div[@class='chakra-stack css-1igwmid']/button[@class='chakra-button css-w0kjkl']/following-sibling::button")
    WebElement btnSchdulepayment;
    @FindBy(xpath = "//button[@class='chakra-button css-90cizr']")
    WebElement Internalnotes;
    @FindBy(xpath = "//div[@class='css-11zlnje']//p")
    WebElement notebox;
    @FindBy(xpath = "//button[@class='chakra-button css-1e3cgdi']")
    WebElement AddNote;
    @FindBy(xpath = "//button[@class='chakra-button css-nc5tln']")
    WebElement viewSystemmails;
    @FindBy(xpath = "//div[@class='chakra-modal__content-container css-1u2cvaz']//section//footer/button")
    WebElement btnEmailsCancel;
    WebDriver driver;
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public ContactsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private static void fileupload(String filepath) throws AWTException {
        Robot robot = new Robot();
        for (char c : filepath.toCharArray()) {
            typeCharacter(robot, c);
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }

    private static void typeCharacter(Robot robot, char character) {
        switch (character) {
            case ':':
                robot.keyPress(KeyEvent.VK_SHIFT);
                robot.keyPress(KeyEvent.VK_SEMICOLON);
                robot.keyRelease(KeyEvent.VK_SEMICOLON);
                robot.keyRelease(KeyEvent.VK_SHIFT);
                break;
            case '\\':
                robot.keyPress(KeyEvent.VK_BACK_SLASH);
                robot.keyRelease(KeyEvent.VK_BACK_SLASH);
                break;
            default:
                if (Character.isUpperCase(character)) {
                    robot.keyPress(KeyEvent.VK_SHIFT);
                }
                robot.keyPress(Character.toUpperCase(character));
                robot.keyRelease(Character.toUpperCase(character));
                if (Character.isUpperCase(character)) {
                    robot.keyRelease(KeyEvent.VK_SHIFT);
                }
                break;
        }
    }

    public void addContact() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        Contacts.click();
        NewContact.click();
        SearchByName.sendKeys(searchname);
        btnsearch.click();

        List<WebElement> element = driver.findElements(By.xpath("//div[@class='chakra-stack css-1mgamsk']//p"));
        JavaUtils.elementclick(OrgFullName, element);

        PrimaryContactname.sendKeys(Contactname);
        PrimaryContactEmail.sendKeys(ContactEmail);
        emailtoggle.click();

        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        btnContactcancel.click();
        btnCreatecontact.click();


        List<WebElement> element2 = driver.findElements(By.xpath("//div[@class='css-i8tuof']//a"));
        JavaUtils.elementclick(OrgFullName, element2);

        Thread.sleep(2000);
        refresh.click();
        filing990.click();

        Set<String> windowsIDs = driver.getWindowHandles();
        Iterator<String> it = windowsIDs.iterator();
        String parentID = it.next();
        String childID = it.next();

        String acttitle = driver.switchTo().window(parentID).getTitle();
        Assert.assertEquals(acttitle, tileofPage);

    }

    public void organizationPage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Contacts.click();
        Entity.click();
        entitySearch.click();
        entitySearch.sendKeys(searchname);
        Grantees.click();

        List<WebElement> entities = driver.findElements(By.xpath("//div[@class='css-i8tuof']//a"));
        JavaUtils.elementclick(OrgFullName, entities);

    }

    public void editGranteeHistory() {
        GrantHistory.click();
    }

    public void editPayment() throws InterruptedException {

        Payments.click();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        Thread.sleep(2000);
        schedulepayment.click();
        paymentcancel.click();
        //btnSchdulepayment.click();
    }

    public void editActivities() throws InterruptedException {

        Activity.click();
        Thread.sleep(2000);
        Internalnotes.click();
        notebox.sendKeys(InternalNotes);
        Thread.sleep(2000);
        AddNote.click();
        Thread.sleep(2000);
        viewSystemmails.click();
        btnEmailsCancel.click();

    }

    public void editDocuments() throws AWTException, InterruptedException {


        Documents.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        Thread.sleep(200);
        Upload.click();
        Thread.sleep(2000);
        fileupload(Filepath);
        Thread.sleep(2000);
        viewdocument();


    }

    private void viewdocument() throws InterruptedException {
        searchfile.sendKeys(SearchFilename);
        List<WebElement> files = driver.findElements(By.xpath("//div[@class='chakra-stack css-1pxcov7']//p"));
        int count = 1;
        for (WebElement file : files) {

            if (file.getText().equalsIgnoreCase(Filename)) {

                WebElement viewfile = driver.findElement(By.xpath("(//div[@class='chakra-stack css-1pxcov7']//div[@class='chakra-stack css-1hohgv6'])[" + count + "]//button[@class='chakra-button css-18rl20d']"));
                viewfile.click();
                break;
            }
            count++;
            break;
        }
        Thread.sleep(3000);
        btnfilecancel.click();
    }


}
