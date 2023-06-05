package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Activity5 {
    AndroidDriver driver;
    @BeforeClass
    public void setup() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.apps.messaging");
        options.setAppActivity(".main.MainActivity");
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(serverURL,options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
@Test
    public void message()
    {
        if (driver.findElement(AppiumBy.id("secondary_action_button")).isDisplayed()) {
            driver.findElement(AppiumBy.id("secondary_action_button")).click();
        }
        driver.findElement(AppiumBy.id("start_chat_fab")).click();
        driver.findElement(AppiumBy.id("recipient_text_view")).sendKeys("7208184800");
        driver.findElement(AppiumBy.id("recipient_text_view")).click();
        driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER));
        driver.findElement(AppiumBy.id("compose_message_text")).sendKeys("Hello from Appium");
        driver.findElement(AppiumBy.id("send_message_button_icon")).click();
        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
        String msg=driver.findElement(AppiumBy.xpath("//android.support.v7.widget.RecyclerView[@content-desc=\"Conversation list\"]/android.view.ViewGroup[1]/android.widget.RelativeLayout/android.widget.TextView[2]")).getText();
        Assert.assertEquals("You: Hello from Appium",msg);

    }

}
