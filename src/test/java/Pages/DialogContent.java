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

    @FindBy(xpath = "//button[@class='action-primary action-accept']/span")
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




//********************************************************************************************


    @FindBy(xpath = "//a[@class='action showcart']")
    private WebElement Cart;

    @FindBy(xpath = "//a[@class='action delete']/span")
    private WebElement deleteButton;









    @FindBy(xpath = "//span[text()='View and Edit Cart']")
    private WebElement viewAndEditCart;

    @FindBy(xpath = "//input[@class='input-text qty']")
    private WebElement shoppingCartQuantity;

    @FindBy(xpath = "//span[text()='Update Shopping Cart']")
    private WebElement UpdateShoppingCart;

    @FindBy(xpath = "//wtf[text()='22.00']")
    private WebElement subtotal;
//"Check subtotal value bigger than old value" geti yapılacak.....

    @FindBy(xpath = "(//input[@type='number'])[1]")
    private WebElement cartModuleQuantity;

    @FindBy(xpath = "//span[text()='Update']")
    private WebElement update;

    @FindBy(xpath = "(//span[@class='counter-number'])")
    private WebElement counterNumber;

    @FindBy(css= "[class='subtitle empty']")
    private WebElement verifyNoItem;


    // Gettextini alıcaz.. Metot yapılacak.....






    //********************************************************************************************
    WebElement myElement;


    public void findAndSend(String strElement, String value) {
        switch (strElement) {
            case "email":
                myElement = email;
                break;

            case "password":
                myElement = password;
                break;

            case "shoppingCartQuantity":
                myElement = shoppingCartQuantity;
                break;

            case "cartModuleQuantity":
                myElement = cartModuleQuantity;
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
            case "deleteButton":
                myElement = deleteButton;
                break;

            case "okButton":
                myElement = okButton;
                break;

            case "viewAndEditCart":
                myElement = viewAndEditCart;
                break;

            case "UpdateShoppingCart":
                myElement = UpdateShoppingCart;
                break;

            case "update":
                myElement = update;
                break;

            case "Cart":
                myElement = Cart;
                break;


        }
        clickFunction(myElement);








//********************************************************************************************




    }

    public void findAndContainsText(String strlement, String text) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement) {
            case "loginSuccess":
                myElement = loginSuccess;
                break;
            case "subtotal":
                myElement = subtotal;
                break;
            case "verifyNoItem":
                myElement = verifyNoItem;
                break;




            //"Check subtotal value bigger than old value" fiyatlar alınıp karşlılaştırılacak
        }

        verifyContainsTextFunction(myElement, text);
    }
}