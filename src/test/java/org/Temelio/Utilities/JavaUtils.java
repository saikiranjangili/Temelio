package org.Temelio.Utilities;

import com.aventstack.extentreports.Status;
import org.Temelio.testCases.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;


public class OtherMethods extends BaseClass{
    WebDriver driver;
public void captureScreen(String tname) throws IOException {

        driver = getDriver();
        TakesScreenshot s = (TakesScreenshot) driver;
        File source = s.getScreenshotAs((OutputType.FILE));
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);

    }
}
