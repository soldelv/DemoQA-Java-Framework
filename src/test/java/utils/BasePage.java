package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.BooleanSupplier;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait waitDriver;
    public int TIMEOUT = 30;
    public int PAGE_LOAD_TIMEOUT = 50;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver driverSetUp(String url){
        System.setProperty("webdriver.chrome.driver","src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        return driver;
    }

    public void driverTearDown(){
        driver.close();
        driver.quit();
    }

    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void click(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }

    public void safeClick(By locator){
        try {
            click(findElement(locator));
        }catch(ElementClickInterceptedException e){
            handle_error(locator);
        }
    }
    public void handle_error(By locator){
        WebElement element = driver.findElement(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
    }

    public String handle_alert() throws InterruptedException {
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        System.out.println(message);
        alert.accept();
        return message;
    }

    public boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }
    public void visit(String url){
        driver.get(url);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public Boolean compareUrlWithCurrent(String url){
        return driver.getCurrentUrl().contains(url);
    }

    public void setWaitDriver(WebDriverWait wait){
        this.waitDriver = wait;
    }
    public void waitForElementToBeVisible(WebElement element){
        setWaitDriver(new WebDriverWait(driver,TIMEOUT));
        waitDriver.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element){
        setWaitDriver(new WebDriverWait(driver,TIMEOUT));
        waitDriver.until(ExpectedConditions.elementToBeClickable(element));
    }
}
