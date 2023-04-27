package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Activity9 {
    public static void main(String[] arg) {
        String Username = "root";
        String logeduser;
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        driver.findElement(By.id("user_login")).sendKeys(Username);
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        driver.findElement(By.xpath("//li[@id='menu-posts-job_listing']")).click();
        driver.findElement(By.xpath("//a[@class='page-title-action'and contains(text(),'Add New')]")).click();
        driver.findElement(By.xpath("//textarea[@id='post-title-0']")).sendKeys("Test");
        driver.findElement(By.xpath("//button[contains(text(),'Publish')]")).click();
        driver.findElement(By.xpath("//div[@class='editor-post-publish-panel__header-publish-button']/button")).click();
        if (driver.findElement(By.xpath("//div[contains(text(),'Published')]")).isDisplayed())
        {
            System.out.println("Activity9 Passed");
        }
        else
        {
            System.out.println("Activity9 Failed");
        }
        driver.quit();

    }


}

