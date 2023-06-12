package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    //public final static WebDriver driver = SeleniumDriver.getDriver();
    //public final static WebDriverWait wait = SeleniumDriver.waitDriver();

    @FindBy(how=How.XPATH, using = "//h5[contains(text(), 'Book')]")
    private static WebElement btn_goToBooks;

    /*public static void navigateTo_HomePage() {
        SeleniumDriver.openPage("https://demoqa.com/books");
    }*/

    /*public static void clickOn_Books() {
        WebElement btn_goToBooks2 = driver.findElement(
                By.xpath("//div[contains(@class, 'card mt-4 top-card')][6]//div[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(btn_goToBooks2));
        btn_goToBooks2.click();
        // Actions actions = new Actions(driver);
        // actions.moveToElement(btn_goToBooks2).click().build().perform();
    }*/
}