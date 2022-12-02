package Pages;

import Utils.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DialogContent extends Parents {

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//ul[@class='header links']//a)[1]")
    private WebElement signIn;

    @FindBy(css = "input[id='email']")
    private WebElement email;

    @FindBy(css = "input[id='pass'][name='login[password]']")
    private WebElement password;

    @FindBy(xpath = "(//li[@class='greet welcome']//span)[1]")
    private WebElement loginSuccess;
    @FindBy(css = "[name='send'][class='action login primary']")
    private WebElement signInButton;

    @FindBy()
    private WebElement myAccountButton;

    @FindBy()
    private WebElement okButton;

    //class="action save primary" olacak
    @FindBy()
    private WebElement saveButton;

    @FindBy()
    private WebElement editButton;

    @FindBy()
    private WebElement editCartButton;

    @FindBy()
    private WebElement checkOutButton;

    @FindBy()
    private WebElement nextButton;

    @FindBy()
    private WebElement orderButton;

    @FindBy()
    private WebElement removeItemButton;

    @FindBy()
    private WebElement removeProductButton;

    @FindBy(xpath = "//button[@title='Add to Cart']")
    private WebElement addToCart;

    @FindBy()
    private WebElement optionSize;

    @FindBy()
    private WebElement optionColor;

    @FindBy()
    private WebElement quantity;

    @FindBy()
    private WebElement updateCart;


    WebElement myElement;


    public void findAndSend(String strElement, String value) {
        switch (strElement) {
            case "email":
                myElement = email;
                break;

            case "password":
                myElement = password;
                break;


        }
        sendKeysFunction(myElement, value);


    }

    public void findAndClick(String strElement) {
        switch (strElement) {
            case "signIn":
                myElement = signIn;
                break;
            case "signInButton":
                myElement = signInButton;
                break;
        }
        clickFunction(myElement);
    }

    public void findAndContainsText(String strlement, String text) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement) {
            case "loginSuccess":
                myElement = loginSuccess;
                break;


        }

        verifyContainsTextFunction(myElement, text);
    }
}