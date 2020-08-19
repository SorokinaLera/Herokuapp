import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownTest {
    WebDriver browser;

    @Test
    public void validateDropDown() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/dropdown");
        Select select = new Select(browser.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        String text = select.getFirstSelectedOption().getText();
        Assert.assertEquals(text, "Option 1");

        List<WebElement> options = select.getOptions();

        for (WebElement element : options) {
            System.out.println(element.getText());
            System.out.println(element.isEnabled());
        }
        browser.quit();
    }

}
