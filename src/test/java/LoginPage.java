import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPage  {



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

    @Test
    void openBrowser() throws InterruptedException {
        try {


            Thread.sleep(5000);
            WebElement logo = driver.findElement(By.xpath("//i[@class='fa fa-paw']"));
            Assert.assertTrue(logo.isDisplayed(), "Logo is displayed correctly.");

        }catch (Exception e)

        {
            System.out.println("Error Not Found!");
        }

    }


}