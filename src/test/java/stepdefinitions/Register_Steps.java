package stepdefinitions;

import factory.PageFactoryManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RegisterPage;

import static junit.framework.TestCase.assertEquals;

public class Register_Steps {
    RegisterPage registerPage;
    private final TestContext context;

    public Register_Steps(TestContext context) {
        this.context = context;
        registerPage = PageFactoryManager.getRegisterPage(context.driver);
    }

    @Given("The user access to the Register page")
    public void theUserAccessToTheRegisterPage() {
        registerPage.visit("https://demoqa.com/register");
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
