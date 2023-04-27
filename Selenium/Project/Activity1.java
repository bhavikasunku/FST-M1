package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity1 {
    public static void main(String[] args) throws InterruptedException {
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
            // Setup the Firefox driver(GeckoDriver)
            WebDriverManager.firefoxdriver().setup();

            // Create a new instance of the Firefox driver
            WebDriver driver = new FirefoxDriver();

            // Open the browser
            driver.get("https://alchemy.hguy.co/jobs");
            Thread.sleep(20000);
            // Close the browser

            driver.quit();
        }

    }


