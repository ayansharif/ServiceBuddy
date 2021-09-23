import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

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
    void LoginPage() throws InterruptedException {

            Thread.sleep(1000);
            WebElement logo = driver.findElement(By.xpath("//i[@class='fa fa-paw']"));
            Assert.assertTrue(logo.isDisplayed(), "Logo is displayed correctly.");
        }


    @Test(priority = 2)
    void LoginFail() {


            driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("admin1@example.com");
            driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345678");
            driver.findElement(By.xpath("//button[@type='submit']")).click();



    }

    @Test(priority = 3)
    void LoginFailText() {

            System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-info']")).getText());
        }


    @Test(priority = 4)
    void Login() throws InterruptedException {




            driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("admin@example.com");
            driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("12345678");
            driver.findElement(By.xpath("//button[@type='submit']")).click();
        }


    @Test(priority = 5)
    void homepageTitle() throws InterruptedException {

            Thread.sleep(1000);
            String title = driver.getTitle();
            Assert.assertEquals("Service Buddy", title, "This is the correct Title.");
        }

}
