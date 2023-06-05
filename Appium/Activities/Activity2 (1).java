package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Activity2 {
    AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");

    //server setup
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver(serverURL,options);

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }
    @Test
    public void ChromeTest()
    {
        driver.get("https://www.training-support.net/");
        driver.findElement(AppiumBy.id("com.android.chrome:id/signin_fre_dismiss_button")).click();
        String Heading= driver.findElement(AppiumBy.xpath("//android.widget.TextView[1][@text='Training Support']")).getText();
        System.out.println("Heading main page = "+Heading);
       driver.findElement(AppiumBy.accessibilityId("About Us")).click();
       String aboutusHeading=driver.findElement(AppiumBy.xpath("//android.widget.TextView[1][@text='About Us']")).getText();
        System.out.println("Heading about us page = "+aboutusHeading);

    }
    @AfterClass
    public void teardown()
    {
        driver.quit();
    }
}
