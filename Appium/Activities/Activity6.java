package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activity6 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL,options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @Test
    public void mainTest()
    {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        driver.get("https://www.training-support.net/selenium/lazy-loading");
        if (driver.findElement(AppiumBy.id("com.android.chrome:id/signin_fre_dismiss_button")).isDisplayed())
        {
            driver.findElement(AppiumBy.id("com.android.chrome:id/signin_fre_dismiss_button")).click();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.className("android.widget.Image")));

        List<WebElement> Images=driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("before scroll"+Images.size());
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable +".scrollTextIntoView(\"helen\")"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[2][@text,'helen']")));
        List<WebElement>Images1=driver.findElements(AppiumBy.className("android.widget.Image"));
        System.out.println("After Scroll"+Images1.size());
        Assert.assertEquals(Images1.size(), 4);
    }

    @AfterClass
    public void teardown()
    {

        driver.quit();
    }


}
