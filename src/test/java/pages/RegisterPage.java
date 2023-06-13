package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(id = "firstname")
    private WebElement firstName;
    @FindBy(id = "lastname")
    private WebElement lastName;
    @FindBy(id = "userName")
    private WebElement userName;
    @FindBy(id = "password")
    private WebElement password;
    @FindBy(id = "g-recaptcha")
    private WebElement captcha_btn;
    By captcha_marked = By.cssSelector("recaptcha-checkbox-checkmark");
    @FindBy(id = "register")
    private WebElement register_btn;
    @FindBy(id = "gotologin")
    private WebElement backToLogin_btn;
    @FindBy(id = "gotologin")
    private WebElement registerMessage;

    public void registerUser() throws InterruptedException {
        Random rnd = new Random(12);
        String rnd_user = "Test"+ rnd.nextInt();
        String rnd_password = rnd_user+"*+";

        type("test_firstName", firstName);
        type("test_lastName", lastName);
        type(rnd_user, userName);
        type(rnd_password, password);

        try{
            click(captcha_btn);
        }catch(org.openqa.selenium.ElementClickInterceptedException e){
            handle_error(captcha_btn);
        }
        Thread.sleep(5000);
        try{
            click(register_btn);
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
