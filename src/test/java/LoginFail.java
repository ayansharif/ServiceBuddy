import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginFail {
WebDriver driver;


    @BeforeTest
    public void setup() {
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.get("http://app.getservicebuddy.com/login");

    }

    @AfterTest
    public void quit()
    {
        driver.quit();
    }
    @Test(priority = 1)
    void login() throws InterruptedException {
        driver.findElement(By.id("email")).sendKeys("admin1@example.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(priority = 2)
    void getLoginFailText() throws InterruptedException {
        try{
            String errorText = driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText();
            System.out.println("Login Error Found! "+errorText);
        }catch (Exception e)
        {
            System.out.println("Error Not Found!");
        }

    }

    void tearDown()
    {
        driver.quit();
    }

}