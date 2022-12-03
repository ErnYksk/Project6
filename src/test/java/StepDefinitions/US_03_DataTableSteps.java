package StepDefinitions;

import Pages.DialogContent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class US_03_DataTableSteps {


    DialogContent dc=new DialogContent();
    @And("User should be able to remove Item from the cart")
    public void userShouldBeAbleToRemoveItemFromTheCart() {

    dc.findAndClick("Cart");
    dc.findAndClick("deleteButton");
    dc.findAndClick("okButton");
    dc.findAndClick("Cart");

    }

    @Then("User should see Item has been removed")
    public void userShouldSeeItemHasBeenRemoved() {
    dc.findAndContainsText("verifyNoItem", "no items" );


    }


    //*****************************ÜRÜN EKLEME GİRİLECEK.......
    @And("User should be able to change quantity")
    public void userShouldBeAbleToChangeQuantity() {

        dc.findAndClick("viewAndEditCart");
        dc.findAndSend("shoppingCartQuantity","2");

    }
    @And("User should be able to update shopping cart button")
    public void userShouldBeAbleToUpdateShoppingCartButton() {
        dc.findAndClick("UpdateShoppingCart");
    }


    @Then("User should be able to check subtotal value bigger than old value")
    public void userShouldBeAbleToCheckSubtotalValueBiggerThanOldValue() {

        //FORMUL YAZILACAK

    }


    @And("User should be able to change quantity on the cart module")
    public void userShouldBeAbleToChangeQuantityOnTheCartModule() {
        dc.findAndClick("Cart");
        dc.findAndSend("cartModuleQuantity", "2");
        dc.findAndClick("update");

    }
    @Then("User should be able to check  Cart Icon's number")
    public void userShouldBeAbleToCheckCartIconSNumber() {
      dc.findAndContainsText("counterNumber", "2");

        //FORMUL YAZILACAK


    }


}
