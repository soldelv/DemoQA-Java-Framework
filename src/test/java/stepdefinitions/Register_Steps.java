package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import pages.RegisterPage;

import static junit.framework.TestCase.assertEquals;

public class Register_Steps {
    private WebDriver driver;
    RegisterPage registerPage;

    @Before
    public void setUp() throws Exception{
        registerPage = new RegisterPage(driver);
        driver = registerPage.driverSetUp("https://demoqa.com/register");
    }
    @After
    public void tearDown() throws Exception{
        registerPage.driverTearDown();
    }

    @Given("The user access to the Register page")
    public void theUserAccessToTheRegisterPage() {
        // TO DO
        System.out.println("User already is on register page");
    }

    @When("The user fills the register form and proceeds to register")
    public void theUserFillsTheRegisterFormAndProceedsToRegister() throws InterruptedException {
        registerPage.registerUser();
    }

    @Then("The user is successfully registered")
    public void theUserIsSuccessfullyRegistered() throws InterruptedException {
        assertEquals("User Register Successfully.",registerPage.registeredMessage());
    }
}
