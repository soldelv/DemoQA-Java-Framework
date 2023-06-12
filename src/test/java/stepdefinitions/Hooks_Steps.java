package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks_Steps {
    private WebDriver driver;
    public int TIMEOUT = 30;
    public int PAGE_LOAD_TIMEOUT = 50;
    /*@Before
    public void setUp() throws Exception{
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/books");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
    }
    @After
    public void tearDown() throws Exception{
        driver.close();
        driver.quit();
    }*/
}
