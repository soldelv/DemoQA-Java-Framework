package stepdefinitions;

import factory.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import static junit.framework.TestCase.assertEquals;

public class Login_Steps {
    private LoginPage loginPage;
    private final TestContext context;

    public Login_Steps(TestContext context){
        this.context = context;
        loginPage = PageFactoryManager.getLoginPage(context.driver);
    }

    @Given("The user access to the Books page")
    public void theUserAccessToTheBooksPage() {
        loginPage.visit("https://demoqa.com/books");
        assert !loginPage.userIsLogged();
    }

    @When("The user clicks on Login page")
    public void theUserClicksOnLoginPage() {
        loginPage.clickOnLogin();
    }

    @Then("The user is on Login Page")
    public void theUserIsOnLoginPage() {
        assert loginPage.checkIsInLoginPage();
    }

    @And("^The user enters user (.*) and password (.*)$")
    public void theUserEntersUserUsernameAndPasswordPassword(String username, String password) {
        loginPage.fillLoginForm(username,password);
    }

    @Then("The user is on the Home page")
    public void theUserIsOnTheHomePage() {
        assert loginPage.userIsLogged();
    }

    @Then("An Error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
        assertEquals("Invalid username or password!", loginPage.checkFailedLogin());
    }

    @And("The user clicks on New User button")
    public void theUserClicksOnNewUserButton() {
        loginPage.clickOnRegister();
    }

    @Then("The user is on Register page and goes back to Login page")
    public void theUserIsOnRegisterPageAndGoesBackToLoginPage() {
        assert loginPage.checkIsInRegisterPage();
    }

}
