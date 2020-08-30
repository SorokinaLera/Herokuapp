import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploaderTest {
    WebDriver driver;
    WebDriverWait wait;
    public static final By Locator = By.id("file-submit");
    String UniversalLocator = "//*[contains(text(),'%s')]";

    @Test
    public void validate() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(Locator)); //не работает
        //задача, в него отправить путь к файлу
        driver.findElement(By.id("file-upload")).sendKeys(System.getProperty("user.dir") + "/src/test/resources/Screenshot_8.png");
        driver.findElement(By.id("file-submit")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(UniversalLocator, "File Uploaded!"))));
        Assert.assertEquals("Screenshot_8.png", driver.findElement(By.xpath("//*[@id=\"uploaded-files\"]")).getText());
        driver.close();

    }
}
