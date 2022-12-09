package Pages;

import Utils.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class US_05_DialogContent extends Parents {

    public US_05_DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "(//ul[@class='header links']//a)[1]")
    private WebElement signIn;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "pass")
    private WebElement password;

    @FindBy(xpath = "(//li[@class='greet welcome']//span)[1]")
    private WebElement loginSuccess;
    @FindBy(css = "[name='send'][class='action login primary']")
    private WebElement signInButton;

    @FindBy(css = "li[class='item product product-item']:nth-child(1)")
    private WebElement productItem;

    @FindBy(css = "button[class='action-primary action-accept']>span")
    private WebElement okButton;

    @FindBy(xpath = "//button[@title='Add to Cart']")
    private WebElement addToCart;

    @FindBy(id = "search")
    private WebElement searchBox;

    @FindBy(css = "button[title='Search']")
    private WebElement searchButton;

    @FindBy(css = "a[class='action tocompare']")
    private WebElement addToCompare;

    @FindBy(xpath = "//div[@role='alert']//div/div[1]")
    private WebElement checkText;

    @FindBy(css = "span[data-bind='text: compareProducts().countCaption']")
    private WebElement comparePage;
    WebElement myElement;


    public void findAndSend(String strElement, String value) {
        switch (strElement) {
            case "email":
                myElement = email;
                break;
            case "password":
                myElement = password;
                break;
            case "searchBox":
                myElement = searchBox;
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
            case "searchButton":
                myElement = searchButton;
                break;
            case "productItem":
                myElement = productItem;
                break;
            case "addToCompare":
                myElement = addToCompare;
                break;
            case "comparePage":
                myElement = comparePage;
                break;
            case "okButton":
                myElement = okButton;
                break;
            case "addToCart":
                myElement = addToCart;
                break;
        }
        clickFunction(myElement);
    }

    public void findAndContainsText(String strElement, String text) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strElement) {
            case "loginSuccess":
                myElement = loginSuccess;
                break;
            case "checkText":
                myElement = checkText;
                break;
        }
        verifyContainsTextFunction(myElement, text);
    }
}