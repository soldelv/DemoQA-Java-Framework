package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import static constants.Constants.EXPLICIT_WAIT;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;
    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        PageFactory.initElements(driver, this);
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

    public void type(String inputText, WebElement element){
        element.sendKeys(inputText);
    }

    public void clearAndType(String inputText, WebElement element){
        element.clear();
        element.sendKeys(inputText);

    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void clickOnElement(WebElement element){
        if (isDisplayed(element)){
            safeClick(element);
            System.out.println("Clicked on element "+element);
        }else{
            System.out.println("Element "+element+" is not displayed");
        }
    }

    public void click(WebElement element){
        waitForElementToBeClickable(element);
        element.click();
    }

    public void safeClick(WebElement locator){
        try {
            click(locator);
        }catch(ElementClickInterceptedException e){
            handle_error(locator);
        }
    }

    public void doubleClick(WebElement element){
        Actions action = new Actions(driver);
        action.doubleClick(element).perform();

    }
    public void rightClick(WebElement element){
        Actions action = new Actions(driver);
        action.contextClick(element).perform();

    }
    public void handle_error(WebElement element){
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

    public boolean isDisplayed(WebElement element){
        try{
            return element.isDisplayed();
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

    public Boolean compareWithCurrentUrl(String expected_url){
        return driver.getCurrentUrl().contains(expected_url);
    }

    public void waitForElementToBeVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilIsNotVisible(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
