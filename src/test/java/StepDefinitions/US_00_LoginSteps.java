package StepDefinitions;

import Pages.US_04_DialogContent;
import Utils.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class US_00_LoginSteps {

    US_04_DialogContent dc =new US_04_DialogContent();
    @Given("Navigate to Luma website")
    public void navigateToLumaWebsite() {
        GWD.getDriver().get("https://magento.softwaretestingboard.com/");
        GWD.getDriver().manage().window().maximize();
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
        dc.findAndClick("signIn");
        dc.findAndSend("email","group2Techno@gmail.com");
        dc.findAndSend("password","Group2Password");
        dc.findAndClick("signInButton");

    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        dc.findAndContainsText("loginSuccess","Project");
    }
}
