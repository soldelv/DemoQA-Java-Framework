package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage{
    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//span[contains(text(),'Text Box')]")
    private WebElement btn_textBox;

    @FindBy(xpath="//span[contains(text(),'Check Box')]")
    private WebElement btn_checkBox;

    @FindBy(xpath="//span[contains(text(),'Radio')]")
    private WebElement btn_radioButton;

    @FindBy(xpath="//span[contains(text(),'Tables')]")
    private WebElement btn_webTables;

    @FindBy(xpath="//span[contains(text(),'Buttons')]")
    private WebElement btn_buttons;

    @FindBy(xpath="//span[contains(text(),'Links')]")
    private WebElement btn_links;

    @FindBy(xpath="//span[contains(text(),'Broken')]")
    private WebElement btn_brokenLinks;

    @FindBy(xpath="//span[contains(text(),'Upload')]")
    private WebElement btn_uploadDownload;

    @FindBy(xpath="//span[contains(text(),'Dynamic')]")
    private WebElement btn_dynamicProp;

    @FindBy(id="userName")
    private WebElement form_userName;

    @FindBy(id="userEmail")
    private WebElement form_userEmail;

    @FindBy(id="currentAddress")
    private WebElement form_currentAddress;

    @FindBy(id="permanentAddress")
    private WebElement form_permanentAddress;

    @FindBy(id="submit")
    private WebElement btn_submit;

    @FindBy(css="p#name.mb-1")
    private WebElement form_output;

    @FindBy(id="addNewRecordButton")
    private WebElement btn_addNewRecord;
    @FindBy(id="searchBox")
    private WebElement searchBox;

    @FindBy(id="firstName")
    private WebElement userFirstName;

    @FindBy(id="lastName")
    private WebElement userLastName;

    @FindBy(id="userEmail")
    private WebElement userEmail;

    @FindBy(id="age")
    private WebElement userAge;
    @FindBy(id="salary")
    private WebElement userSalary;

    @FindBy(id="department")
    private WebElement userDepartment;

    @FindBy(id = "edit-record-1")
    private WebElement btn_editRecord;

    @FindBy(id = "delete-record-1")
    private WebElement btn_deleteRecord;

    public void goToElementOption(String option){
        switch (option){
            case "Text Box":{
                clickOnElement(btn_textBox);
                break;
            }
            case "Check Box":{
                clickOnElement(btn_checkBox);
                break;
            }
            case "Radio Button":{
                clickOnElement(btn_radioButton);
                break;
            }
            case "Web Tables":{
                clickOnElement(btn_webTables);
                break;
            }
            case "Buttons":{
                clickOnElement(btn_buttons);
                break;
            }
            case "Links":{
                clickOnElement(btn_links);
                break;
            }
            case "Broken Links - Images":{
                clickOnElement(btn_brokenLinks);
                break;
            }
            case "Upload and Download":{
                clickOnElement(btn_uploadDownload);
                break;
            }
            case "Dynamic Properties":{
                clickOnElement(btn_dynamicProp);
                break;
            }
            default:
                throw new IllegalStateException("INVALID OPTION: " + option);
        }
    }

    public void fillTextBoxForm(String fullName, String email, String cAddress, String pAddress){
        waitForElementToBeVisible(btn_submit);
        type(fullName, form_userName);
        type(email, form_userEmail);
        type(cAddress, form_currentAddress);
        type(pAddress, form_permanentAddress);
        safeClick(btn_submit);
    }

    public Boolean checkOutput(){
        return isDisplayed(form_output);
    }

    public void clickOnAddButton(){
        safeClick(btn_addNewRecord);
    }

    public void fillRegistrationForm(String first_name, String last_name, String email, String age,
                                     String salary,String department){
        waitForElementToBeVisible(btn_submit);
        type(first_name, userFirstName);
        type(last_name, userLastName);
        type(email, userEmail);
        type(age, userAge);
        type(salary, userSalary);
        type(department, userDepartment);
        safeClick(btn_submit);
        //waitUntilIsNotVisible(btn_submit);
    }

    public void searchRegister(String wordToSearch){
        if(!isDisplayed(btn_submit)){
        waitForElementToBeVisible(searchBox);
        clearAndType(wordToSearch, searchBox);}
    }

    public void clearSearch(){
        searchBox.clear();
    }
    public String checkSearch(){
        if(isDisplayed(btn_editRecord)){
            System.out.println();
            return "Record founded";
        }else{
            return "Record not founded";
        }
    }

    public void editRecord1(String toEdit){
        safeClick(btn_editRecord);
        waitForElementToBeVisible(btn_submit);
        clearAndType(toEdit, userDepartment);
        safeClick(btn_submit);
    }

    public void deleteRecord1(){
        waitForElementToBeVisible(btn_deleteRecord);
        safeClick(btn_deleteRecord);
    }

}
