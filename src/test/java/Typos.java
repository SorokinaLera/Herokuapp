import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Typos {
    WebDriver browser;

    @Test
    public void validateTypos() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        browser = new ChromeDriver(options);
        browser.get("http://the-internet.herokuapp.com/typos");
        browser.manage().window().maximize();
        String message = "Sometimes you'll see a typo, other times you won,t.";
        Assert.assertEquals(message, browser.findElement(By.xpath("//div/p[2]")).getText());
        browser.quit();

    }
}
