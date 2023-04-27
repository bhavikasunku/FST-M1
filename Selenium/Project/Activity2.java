package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,"/dev/null");
        // Setup the Firefox driver(GeckoDriver)
        WebDriverManager.firefoxdriver().setup();

        // Create a new instance of the Firefox driver
        WebDriver driver = new FirefoxDriver();

        // Open the browser
        driver.get("https://alchemy.hguy.co/jobs");
        String HeaderText = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();
        System.out.println("Heading of Webpage: " +  HeaderText);
        Thread.sleep(20000);
        // Close the browser

        driver.quit();
    }
}
