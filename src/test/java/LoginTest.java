import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeTest
    void openBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://app.getservicebuddy.com/login");

    }

    @Test
    void Login() {
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345678");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test
    void homepageTitle() {
        String title = driver.getTitle();
        Assert.assertEquals("Service Buddy", title, "This is the correct Title.");
    }
    @AfterTest
    void tearDown()
    {
        driver.quit();
    }
}
