package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Activity3 {
    AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.calculator");
        options.setAppActivity("com.android.calculator2.Calculator");
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL,options);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test
public void addition()
{
    driver.findElement(AppiumBy.id("digit_5")).click();
    driver.findElement(AppiumBy.id("op_add")).click();
    driver.findElement(AppiumBy.id("digit_9")).click();
    driver.findElement(AppiumBy.id("eq")).click();
    String result= driver.findElement(AppiumBy.id("result_final")).getText();
    Assert.assertEquals("14",result);

}

    @Test
    public void Subtarct()
    {
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("op_sub")).click();
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("eq")).click();
        String result= driver.findElement(AppiumBy.id("result_final")).getText();
        Assert.assertEquals("5",result);
    }
    @Test
    public void Multiplication()
    {
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("op_mul")).click();
        driver.findElement(AppiumBy.id("digit_1")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();

        driver.findElement(AppiumBy.id("eq")).click();
        String result= driver.findElement(AppiumBy.id("result_final")).getText();
        Assert.assertEquals("500",result);
    }
    @Test
    public void Division()
    {
        driver.findElement(AppiumBy.id("digit_5")).click();
        driver.findElement(AppiumBy.id("digit_0")).click();
        driver.findElement(AppiumBy.id("op_div")).click();
        driver.findElement(AppiumBy.id("digit_2")).click();
        driver.findElement(AppiumBy.id("eq")).click();
        String result= driver.findElement(AppiumBy.id("result_final")).getText();
        Assert.assertEquals("25",result);
    }

    @AfterClass
    public void teardown()
    {
        driver.quit();
    }

}
