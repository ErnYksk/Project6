package StepDefinitions;

import Pages.DialogContent;
import Utils.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginSteps {

    DialogContent dc=new DialogContent();
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
