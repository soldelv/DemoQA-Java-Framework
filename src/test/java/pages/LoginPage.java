package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login")
    private WebElement login_btn;

    @FindBy(id = "userName")
    private WebElement username_locator;
    @FindBy(id = "password")
    private WebElement password_locator;
    @FindBy(id = "newUser")
    private WebElement newUser_btn;
    @FindBy(id = "submit")
    private WebElement logOut_btn;
    @FindBy(id = "name")
    private WebElement failed_login_msg;
    @FindBy(id = "gotologin")
    private WebElement goToLogin;


    public void clickOnLogin(){
        safeClick(login_btn);
        waitForElementToBeVisible(username_locator);
    }

    public Boolean checkIsInLoginPage(){
        return compareWithCurrentUrl("https://demoqa.com/login");
    }

    public void fillLoginForm(String username, String password){
        if(isDisplayed(login_btn)){
            type(username, username_locator);
            type(password, password_locator);
            waitForElementToBeVisible(login_btn);

            try{
                click(login_btn);
            }catch(org.openqa.selenium.ElementClickInterceptedException e){
                handle_error(login_btn);
            }
        }else{
            System.out.println("Button Login is not displayed");
        }
    }

    public boolean userIsLogged(){
        waitForElementToBeVisible(logOut_btn);
        return isDisplayed(logOut_btn);
    }

    public String checkFailedLogin(){
        waitForElementToBeVisible(failed_login_msg);
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

    public Boolean checkIsInRegisterPage(){
        if(compareWithCurrentUrl("https://demoqa.com/register")){
            if (isDisplayed(goToLogin)){
                click(goToLogin);
            }
            return true;
        }
        return false;
    }
}
