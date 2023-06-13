package factory;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.RegisterPage;

public class PageFactoryManager {

    private static LoginPage loginPage;
    private static RegisterPage registerPage;

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

    public static RegisterPage getRegisterPage(WebDriver driver){
        return registerPage == null ? new RegisterPage(driver) : registerPage;
    }
}
