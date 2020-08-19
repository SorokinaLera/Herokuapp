import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Herokuapp {

    WebDriver browser;

    @Test
    public void blabla(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/");

        /*ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        browser = new ChromeDriver(options);*///ctrl+shift+/
        browser.manage().window().maximize();
        browser.manage().window().setSize(new Dimension(1024,768));
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        browser.quit();

    }
}
