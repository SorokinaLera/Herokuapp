import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElements {

    WebDriver browser;

    @Test
    public void validateAddRemoveElements() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        browser = new ChromeDriver(options);
        browser.get("http://the-internet.herokuapp.com/add_remove_elements/");
        browser.manage().window().maximize();
        WebElement buttonAddElement = browser.findElement(By.xpath("//*[@onclick='addElement()']"));
        buttonAddElement.click();
        buttonAddElement.click();
        WebElement buttonDelete = browser.findElement(By.xpath("//*[@onclick='deleteElement()']"));
        buttonDelete.click();

        List<WebElement> listOfDeleteButton = browser.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        int s = listOfDeleteButton.size();
        Assert.assertEquals(s, 1);
        browser.quit();
    }
}

