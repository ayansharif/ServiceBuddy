import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoginPage {

    WebDriver driver;

    @Test
    void openBrowser() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://app.getservicebuddy.com/login");
        WebElement logo=driver.findElement(By.xpath("//i[@class='fa fa-paw']"));
        Assert.assertTrue(logo.isDisplayed(), "Logo is displayed correctly.");
        Thread.sleep(5000);

    }
    @AfterTest
    void tearDown()
    {
        driver.quit();
    }

}