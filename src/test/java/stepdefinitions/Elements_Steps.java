package stepdefinitions;

import factory.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ElementsPage;

import static junit.framework.TestCase.assertEquals;

public class Elements_Steps {
    private ElementsPage elementsPage;
    private final TestContext context;

    public Elements_Steps(TestContext context) {
        this.context = context;
        elementsPage = PageFactoryManager.getElementsPage(context.driver);
    }

    @When("The user clicks on {string} option")
    public void theUserGoesToOption(String option) {
        elementsPage.goToElementOption(option);
    }

    @When("^fills the form with (.*), (.*), (.*), and (.*)$")
    public void fillsTheFormWithFull_nameEmailCurrent_addressAndPermanent_address(
            String fullName, String email, String cAddress, String pAddress) {
        elementsPage.fillTextBoxForm(fullName, email, cAddress, pAddress);
    }

    @Then("The information filled is displayed as an output")
    public void theInformationFilledIsDisplayedAsAnOutput() {
        assert elementsPage.checkOutput();
    }
    @When("Click on add button")
    public void clickOnAddButton() {
        elementsPage.clickOnAddButton();
    }
    @And("^Complete the form with (.*), (.*), (.*), (.*), (.*) and (.*)$")
    public void completeTheFormWithFirst_nameLast_nameEmailAgeSalaryAndDepartment(
            String first_name, String last_name, String email, String age, String salary,
            String department) {
        elementsPage.fillRegistrationForm(first_name,last_name, email, age, salary, department);

    }

    @And("^The user search a web table register as (.*)$")
    public void theUserSearchARegister(String wordToSearch) {
        elementsPage.searchRegister(wordToSearch);
    }

    @And("but it does not work")
    public void butItDoesNotWork() {
        assertEquals("Record not founded",elementsPage.checkSearch());
        
    }

    @And("found it")
    public void foundIt() {
        assertEquals("Record founded",elementsPage.checkSearch());
    }

    @And("The user edit a web table register")
    public void theUserEditARegister() {
        elementsPage.editRecord1("IT");

    }

    @And("The user delete a web table register")
    public void theUserDeleteARegister() {
        elementsPage.deleteRecord1();

    }

    @Then("The web table is deleted")
    public void theRegisterIsDeleted() {
        assertEquals(elementsPage.checkSearch(), "Record not founded");
    }
}
