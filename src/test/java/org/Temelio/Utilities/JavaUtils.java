package org.Temelio.Utilities;

import org.Temelio.testCases.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;


public class JavaUtils extends BaseClass {

    public static void elementclick(String name, List<WebElement> element)
    {
        List<WebElement> list = element;
        for (WebElement listitem : list)
        {
            if (listitem.getText().contains(name))
            {
                listitem.click();
                break;
            }
        }
    }

    public void captureScreen(String tname) throws IOException {

        TakesScreenshot s = (TakesScreenshot) driver;
        File source = s.getScreenshotAs((OutputType.FILE));
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);

    }
    public static WebElement randomElement() throws InterruptedException {

        List<WebElement> colors = driver.findElements(By.xpath("(//div[@class='chakra-stack css-1igwmid'])[2]//div"));
        Random random = new Random();
        int randomIndex = random.nextInt(1,18);
        WebElement randomElement = driver.findElement(By.xpath("((//div[@class='chakra-stack css-1igwmid'])[2]//div)["+randomIndex+"]"));
       return randomElement;
    }


}
