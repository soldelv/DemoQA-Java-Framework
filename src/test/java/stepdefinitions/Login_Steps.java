package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

import static junit.framework.TestCase.assertEquals;

public class Login_Steps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp() throws Exception{
        loginPage = new LoginPage(driver);
        driver = loginPage.driverSetUp("https://demoqa.com/books");
    }
    @After
    public void tearDown() throws Exception{
        loginPage.driverTearDown();
    }

    @Given("The user access to the Books page")
    public void theUserAccessToTheBooksPage() {
        assert !loginPage.userIsLogged();
    }

    @When("The user clicks on Login page")
    public void theUserClicksOnLoginPage() {
        loginPage.clickOnLogin();
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
        assert loginPage.checkRegisterPage();
    }
}
