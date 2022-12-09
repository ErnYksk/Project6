package StepDefinitions;

import Helper.DynamicLocator;
import Pages.US_04_DialogContent;
import Pages.Parents;
import Utils.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.util.List;

public class US_04_PageSteps extends Parents {

    US_04_DialogContent dc = new US_04_DialogContent();
    DynamicLocator dl = new DynamicLocator();

    @And("Click on the element in US_04_Dialog")
    public void clickOnTheElementInUS_04_Dialog(DataTable elemanlar) {
        List<String> listElemanlar = elemanlar.asList(String.class);

        for (String strButtonName : listElemanlar)
            dc.findAndClick(strButtonName);
    }

    @And("User sending the keys in US_04_Dialog")
    public void userSendingTheKeysInUS_04_Dialog(DataTable elemanlar) {
        List<List<String>> listElements = elemanlar.asLists(String.class);

        for (int i = 0; i < listElements.size(); i++)
            dc.findAndSend(listElements.get(i).get(0), listElements.get(i).get(1));

    }

    @Then("User should see the this message in US_04_Dialog")
    public void userShouldSeeTheThisMessage(DataTable elements) {
        List<String> listElements = elements.asList(String.class);

        for (String strText : listElements) {
            dc.findAndContainsText("checkText", strText);
        }
    }

    @And("User should click add to wish list on item box in US_04_Dialog")
    public void userShouldClickAddToWishListOnItemBox(DataTable elements) {
        String productId = dl.productIdFinder(elements);
        moveToElement(productId);
        GWD.getDriver().findElement(By.cssSelector(dl.itemBoxAddToWishListCSS(productId))).click();
    }

    @And("User should click add to cart on item box at Wishlist in US_04_Dialog")
    public void userShouldClickAddToCartOnItemBoxInWishlist(DataTable elements) {
        int wishListIndex = dl.WishListIndexFinder(elements);
        moveToElementForWishList(wishListIndex);
        GWD.getDriver().findElement(By.xpath(dl.wishListAddToCartXPath(wishListIndex))).click();
    }
}

