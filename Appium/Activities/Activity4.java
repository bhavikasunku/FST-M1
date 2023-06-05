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
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Activity4 {
    AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.contacts");
        options.setAppActivity("com.android.contacts.activities.PeopleActivity");
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL,options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
@Test
    public void addcontact() {
    String Firstname = "Aaditya";
    String Surname = "Varma";
    String PNumber = "999148292";
    driver.findElement(AppiumBy.id("floating_action_button")).click();
    driver.findElement(AppiumBy.xpath("//android.widget.EditText[contains(@text,'First name')]")).sendKeys(Firstname);
    driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Surname']")).sendKeys(Surname);
    driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys(PNumber);
    driver.findElement(AppiumBy.id("toolbar_button")).click();
    String Name = driver.findElement(AppiumBy.id("com.google.android.contacts:id/large_title")).getText();
    Assert.assertEquals(Firstname + " " + Surname, Name);
}

        @AfterClass
        public void teardown()
        {
            driver.quit();
        }



}
