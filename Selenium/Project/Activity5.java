package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs");
        // identify element
        WebElement jobs = driver.findElement(By.linkText("Jobs"));
        // href value from getAttribute()
        String v = jobs.getAttribute("href");
        System.out.println("Href value of link: "+ v);
        Thread.sleep(20000);
        // Close the browser

        driver.quit();
    }
}
