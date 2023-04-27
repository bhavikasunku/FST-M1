package activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Activity6 {
    public static void main (String[] arg)
    {
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://alchemy.hguy.co/jobs/");
        driver.findElement(By.xpath("//li[@id='menu-item-24']/a")).click();
        driver.findElement(By.id("search_keywords")).sendKeys("Banking");
        driver.findElement(By.xpath("//div[@class='search_submit']/input")).click();
        driver.findElement(By.xpath("//ul[@class='job_listings']/li[1]")).click();
        driver.findElement(By.xpath("//input[@value='Apply for job']")).click();
        String EmailId=driver.findElement(By.xpath("//p[contains(text(),'To apply for this job')]/a")).getText();
        System.out.println("Emailid to apply job is "+EmailId);
        driver.quit();

    }
}
