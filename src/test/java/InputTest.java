import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputTest {

    WebDriver browser;

    @Test
    public void validateInput(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = browser.findElement(By.tagName("input"));
        input.sendKeys("18");
        String text = input.getAttribute("value");
        Assert.assertEquals(text, "18");

        input.sendKeys(Keys.ARROW_DOWN);
        text = input.getAttribute("value");
        Assert.assertEquals(text, "17");

        input.clear();
        text = input.getAttribute("value");
        Assert.assertEquals(text, "");

        browser.quit();

    }
}
