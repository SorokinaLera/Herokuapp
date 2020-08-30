import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest {
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void validateFrames() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/frames");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("[href='/iframe']")).click();
        //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'iFrame')]"))); java.lang.NullPointerException
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));//mceu_13 no such frame: element is not a frame
        Assert.assertEquals(driver.findElement(By.xpath(String.format("//*[contains(text(),'Your content goes here.')]"))).getText(), "Your content goes here.");
        driver.switchTo().defaultContent();
        driver.close();


    }
}
