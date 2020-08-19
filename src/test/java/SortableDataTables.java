import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortableDataTables {

    WebDriver browser;

    @Test
    public void validateSortableDataTables() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        browser = new ChromeDriver(options);
        browser.get("http://the-internet.herokuapp.com/tables");
        browser.manage().window().maximize();
        WebElement text = browser.findElement(By.xpath("//table/tbody/tr[2]/td[3]"));
        Assert.assertEquals("fbach@yahoo.com", "fbach@yahoo.com");

        text = browser.findElement(By.xpath("//table/thead/tr/th[2]/span"));
        Assert.assertEquals("Email", "Email");

        text = browser.findElement(By.xpath("//table/tbody/tr[4]/td[2]"));
        Assert.assertEquals("Tim", "Tim");

        browser.quit();
    }
}

