package stepdefinitions;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks_Steps {
    private WebDriver driver;
    private final TestContext context;

    public Hooks_Steps(TestContext context) {
        this.context = context;
    }

    @Before
    public void driverSetUp(Scenario scenario){
        driver = DriverFactory.initializeDriver();
        context.driver = driver;
    }

    @After
    public void driverTearDown(Scenario scenario){
        driver.close();
        driver.quit();
    }
}
