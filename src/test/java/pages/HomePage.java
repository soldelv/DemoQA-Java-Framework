package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h5[contains(text(), 'Elements')]")
    private WebElement btn_goToElements;

    @FindBy(xpath = "//h5[contains(text(), 'Alerts')]")
    private WebElement btn_goToAlerts;

    @FindBy(xpath = "//h5[contains(text(), 'Widgets')]")
    private WebElement btn_goToWidgets;

    @FindBy(xpath = "//h5[contains(text(), 'Interactions')]")
    private WebElement btn_goToInteractions;
    @FindBy( xpath = "//h5[contains(text(), 'Book')]")
    private WebElement btn_goToBookStore;

    @FindBy( xpath = "//h5[contains(text(), 'Forms')]")
    private WebElement btn_goToForms;

    @FindBy( xpath = "//header//a//img")
    public WebElement btn_goToToolsQA;

     public void goToHomePage(){
        clickOnElement(btn_goToToolsQA);

    }

    public void clickOnBookStoreApp(){
        clickOnElement(btn_goToBookStore);
    }

    public void goToPage(String page){
         switch (page){
             case "Home":{
                 clickOnElement(btn_goToToolsQA);
                 break;
             }
             case "Elements":{
                 clickOnElement(btn_goToElements);
                 break;
             }
             case "Forms":{
                 clickOnElement(btn_goToForms);
                 break;
             }
             case "Alerts":{
                 clickOnElement(btn_goToAlerts);
                 break;
             }
             case "Widgets":{
                 clickOnElement(btn_goToWidgets);
                 break;
             }
             case "Interactions":{
                 clickOnElement(btn_goToInteractions);
                 break;
             }
             case "Book Store Application":{
                 clickOnElement(btn_goToBookStore);
                 break;
             }
             default:
                 throw new IllegalStateException("INVALID PAGE: " + page);
            }
         }

}