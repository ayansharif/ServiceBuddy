import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginFail {
    WebDriver driver;

    @BeforeTest
    void openBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://app.getservicebuddy.com/login");
    }

    @Test
    void Login() {
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("admin1@example.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    void LoginFailText()
    {
        System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText());
    }

    void tearDown()
    {
        driver.quit();
    }

}