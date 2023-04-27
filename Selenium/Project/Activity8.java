package activities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity8 {
    public static void main(String[] arg)
    {
        String Username="root";
        String logeduser;
        WebDriverManager.firefoxdriver().setup();
        FirefoxDriver driver=new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
        driver.findElement(By.id("user_login")).sendKeys(Username);
        driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
        driver.findElement(By.id("wp-submit")).click();
        logeduser=driver.findElement(By.xpath("//span[@class='display-name']")).getText();
        if (Username.equals(logeduser))
        {
            System.out.println("Activity8 Passed");
        }
        else

        {
            System.out.println("Activity8 Failed");
        }
        driver.quit();
    }
}

