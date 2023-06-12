package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    By login_btn = By.id("login");
    By username_locator = By.id("userName");
    By password_locator = By.id("password");
    By newUser_btn = By.id("newUser");
    By logOut_btn = By.id("submit");
    By failed_login_msg = By.id("name");
    By goToLogin = By.id("gotologin");


    public void clickOnLogin(){
        click(findElement(login_btn));
        waitForElementToBeVisible(findElement(username_locator));
    }

    public void fillLoginForm(String username, String password){
        if(isDisplayed(login_btn)){
            type(username, username_locator);
            type(password, password_locator);
            waitForElementToBeVisible(findElement(login_btn));

            try{
                click(findElement(login_btn));
            }catch(org.openqa.selenium.ElementClickInterceptedException e){
                handle_error(login_btn);
            }
        }else{
            System.out.println("Button Login is not displayed");
        }
    }

    public boolean userIsLogged(){
        waitForElementToBeVisible(findElement(logOut_btn));
        return isDisplayed(logOut_btn);
    }

    public String checkFailedLogin(){
        if (isDisplayed(failed_login_msg)){
            return getText(failed_login_msg);
        }
        return "No error message is displayed";
    }

    public void clickOnRegister(){
        if (isDisplayed(newUser_btn)){
            safeClick(newUser_btn);
        }else{
            System.out.println("Button New User is not displayed");
        }
    }

    public Boolean checkRegisterPage(){
        if(compareUrlWithCurrent("https://demoqa.com/register")){
            if (isDisplayed(goToLogin)){
                click(goToLogin);
            }
            return true;
        }
        return false;
    }
}
