package factory;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    private static LoginPage loginPage;
    private static RegisterPage registerPage;
    private static HomePage homePage;
    private static ElementsPage elementsPage;
    private static FormsPage formsPage;
    private static AlertsWindowsPage alertsWindowsPage;
    private static WidgetsPage widgetsPage;
    private static InteractionsPage interactionsPage;

    public static LoginPage getLoginPage(WebDriver driver) {
        /**
         * Using Ternary Operator: Checking for loginPage as null.
         *
         * If it is null, then, create new object and return
         *
         * If it is not null, then, return loginPage
         */
        return loginPage == null ? new LoginPage(driver) : loginPage;
    }

    public static HomePage getHomePage(WebDriver driver){
        return homePage == null ? new HomePage(driver) : homePage;
    }

    public static RegisterPage getRegisterPage(WebDriver driver){
        return registerPage == null ? new RegisterPage(driver) : registerPage;
    }

    public static ElementsPage getElementsPage(WebDriver driver){
        return elementsPage == null? new ElementsPage(driver) : elementsPage;
    }
    public static FormsPage getFormsPage(WebDriver driver){
        return formsPage == null? new FormsPage(driver) : formsPage;
    }
    public static AlertsWindowsPage getAlertsWindowsPage(WebDriver driver){
        return alertsWindowsPage == null? new AlertsWindowsPage(driver) : alertsWindowsPage;
    }
    public static WidgetsPage getWidgetsPage(WebDriver driver){
        return widgetsPage == null? new WidgetsPage(driver) : widgetsPage;
    }
    public static InteractionsPage getInteractionsPage(WebDriver driver){
        return interactionsPage == null? new InteractionsPage(driver) : interactionsPage;
    }
}
