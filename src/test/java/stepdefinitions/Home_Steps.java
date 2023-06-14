package stepdefinitions;

import factory.PageFactoryManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;

import static junit.framework.TestCase.assertEquals;
public class Home_Steps {
    private HomePage homePage;
    private final TestContext context;

    public Home_Steps(TestContext context) {
        this.context = context;
        homePage = PageFactoryManager.getHomePage(context.driver);
    }

    @Given("The user access to the Home page")
    public void theUserAccessToTheBooksPage() {
        homePage.visit("https://demoqa.com/");
    }

    @When("The user goes to Book Store Application")
    public void theUserGoesToBooksOption() {
        homePage.clickOnBookStoreApp();

    }

    @Then("The user is able to see every option")
    public void theUserIsAbleToSeeEveryOption() throws InterruptedException {
        //assert homePage.compareWithCurrentUrl("https://demoqa.com/books");
        //Thread.sleep(3000);
        homePage.goToPage("Home");
        assertEquals(homePage.getCurrentUrl(),"https://demoqa.com/");
    }

    @Given("The user access to DemoQA page")
    public void theUserAccessToDemoQAPage() {
        homePage.visit("https://demoqa.com/");
    }

    @When("The user goes to {string} section")
    public void theUserGoesToSection(String page) {
        homePage.goToPage(page);
    }

    @Then("The user is able to see the {string} page")
    public void theUserIsAbleToSeeThePage(String page) {
        assertEquals(homePage.getCurrentUrl(),"https://demoqa.com/"+page);
    }
}
