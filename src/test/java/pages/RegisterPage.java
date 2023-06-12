package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BasePage;

import java.util.Random;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    By firstName = By.id("firstname");
    By lastName = By.id("lastname");
    By userName = By.id("userName");
    By password = By.id("password");
    By captcha_btn = By.id("g-recaptcha");
    By captcha_marked = By.cssSelector("recaptcha-checkbox-checkmark");
    By register_btn = By.id("register");
    By backToLogin_btn = By.id("gotologin");
    By registerMessage = By.id("gotologin");

    public void registerUser() throws InterruptedException {
        Random rnd = new Random(12);
        String rnd_user = "Test"+ rnd.nextInt();
        String rnd_password = rnd_user+"*+";

        type("test_firstName", firstName);
        type("test_lastName", lastName);
        type(rnd_user, userName);
        type(rnd_password, password);

        try{
            click(findElement(captcha_btn));
        }catch(org.openqa.selenium.ElementClickInterceptedException e){
            handle_error(captcha_btn);
        }
        Thread.sleep(5000);
        try{
            click(findElement(register_btn));
        }catch(org.openqa.selenium.ElementClickInterceptedException e){
            handle_error(register_btn);
        }
        System.out.printf("User: %s created successfully (password: %s)",rnd_user,rnd_password);
    }
    public String registeredMessage() throws InterruptedException {
        //List<WebElement> fonts = findElements(registerMessage);
        //return getText(fonts.get(5));
        return handle_alert();

    }

}
