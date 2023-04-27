package activities;// Imports
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Activity7 {
    public static <WebElement> void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://alchemy.hguy.co/jobs");
        driver.findElement(By.linkText("Post a Job")).click();
        System.out.println("Post Job title: " + driver.getTitle());
        Thread.sleep(200);
        WebElement keywords = (WebElement) (WebElement) (WebElement) driver.findElement(By.xpath("//input[starts-with(@type, 'text')]"));
        ((org.openqa.selenium.WebElement) keywords).sendKeys("James@gmail.com");
        driver.findElement(By.id("job_title")).sendKeys("Checking_test_mine");
        driver.findElement(By.id("job_location")).sendKeys("Kochi");
        driver.findElement(By.id("job_description_ifr")).sendKeys(" Testing jobs in bangalore");
        driver.findElement(By.id("application")).sendKeys("James@gmail.com");
        driver.findElement(By.id("company_name")).sendKeys("IBM");
        driver.findElement(By.xpath("//input[@value='Preview']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@value='Submit Listing']")).click();

        driver.get("https://alchemy.hguy.co/jobs");
        driver.findElement(By.linkText("Jobs")).click();

        driver.close();
    }
}