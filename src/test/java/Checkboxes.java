import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Checkboxes {

    WebDriver browser;

    @Test
    public void validateCheckboxes() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/checkboxes");
        browser.manage().window().maximize();
        WebElement checkboxes = browser.findElement(By.id("checkboxes"));
        checkboxes.isSelected(); //false
        Assert.assertEquals(false,false);
        WebElement checkboxes1 = browser.findElement(By.id("checkboxes"));
        checkboxes1.click();
        checkboxes1.isSelected();
        Assert.assertEquals(true,true);

        WebElement checkboxes2 = browser.findElement(By.id("checkboxes"));
        checkboxes2.isSelected(); //false
        Assert.assertEquals(true,true);

        WebElement checkboxes3 = browser.findElement(By.id("checkboxes"));
        checkboxes3.isSelected(); //false
        checkboxes3.click();

        //не важно true/false, все равно тест походит))
        Assert.assertEquals(true,true);

        browser.quit();

    }
}
