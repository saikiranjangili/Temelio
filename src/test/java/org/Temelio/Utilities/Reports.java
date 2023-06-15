package org.Temelio.Utilities;

// Listener class used to generate Extent reports

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.Temelio.testCases.BaseClass;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reports  implements ITestListener {
    public WebDriver driver;
    protected static ExtentReports extent;
    protected static ExtentTest logger;
    public ExtentSparkReporter htmlReporter;


    public void onStart(ITestContext context) {

        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());   // time stamp
        String repName = "Test-Report-" + timeStamp;
        htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/" + repName);  // specify location
        try {
            htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extent = new ExtentReports();
        extent.attachReporter((htmlReporter));
        extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("user", "Saikiran");

        htmlReporter.config().setDocumentTitle("Temelio Project");                  //Title of report
        htmlReporter.config().setReportName("Functional Test Report");             // name of the report
        htmlReporter.config().setTheme(Theme.DARK);

    }
    public void onTestStart(ITestResult result) {
        logger = extent.createTest(result.getMethod().getMethodName());
        logger.log(Status.INFO, MarkupHelper.createLabel(result.getName(), ExtentColor.WHITE));
    }

    public void onTestSuccess(ITestResult result) {
        //logger = extent.createTest(result.getMethod().getMethodName());         // Create New Entry in the report
        logger.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));         // send the passed information

    }

    public void onTestFailure(ITestResult result) {
       // logger = extent.createTest(result.getName());
        logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));

        try {
            JavaUtils ju= new JavaUtils();
            ju.captureScreen(result.getName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger.fail("Screenshot is below : " + System.getProperty("user.dir") + "/Screenshots/" + result.getName() + ".jpeg");
    }

    public void onTestSkipped(ITestResult result) {
        //logger = extent.createTest(result.getName());
        logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.ORANGE));
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }


    public void onFinish(ITestContext context) {
        extent.flush();
    }


}
