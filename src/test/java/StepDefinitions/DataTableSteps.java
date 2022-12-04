package StepDefinitions;

import Helper.DynamicLocator;
import Pages.DialogContent;
import Pages.Parents;
import Utils.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DataTableSteps extends Parents {

    DialogContent dc=new DialogContent();
    DynamicLocator dl = new DynamicLocator();
    Actions actions= new Actions(GWD.getDriver());

    @And("Click on the element in the Dialog")
    public void clickOnTheElementInTheDialog(DataTable elemanlar) {
        List<String> listElemanlar= elemanlar.asList(String.class);

        for(String strButtonName : listElemanlar)
            dc.findAndClick(strButtonName);
    }


    @And("User sending the keys in Dialog content")
    public void userSendingTheKeysInDialogContent(DataTable elemanlar) {

        //ÇİFT BOYUTLU OLDUĞU İÇİN
        List<List<String>> listElemanlar= elemanlar.asLists(String.class);

        for(int i=0;i< listElemanlar.size() ; i++ )
            dc.findAndSend(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1) );
        // eleman adı                    eleman değeri
    }


    @And("Click on the card module in US_{int}_{int}")
    public void clickOnTheCardModuleInUS__(DataTable elemanlar) {
        List<List<String>> listElemanlar= elemanlar.asLists(String.class);

        for(int i=0;i< listElemanlar.size() ; i++ )
            dc.findAndSend(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1) );
        // eleman adı                    eleman değeri
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.findAndContainsText("verifyNoItem", "no items" );
    }

    @And("Click on the element in the  US_{int}_{int}")
    public void clickOnTheElementInTheUS__(DataTable elemanlar) {

        List<List<String>> listElemanlar= elemanlar.asLists(String.class);

        for(int i=0;i< listElemanlar.size() ; i++ )
            dc.findAndSend(listElemanlar.get(i).get(0), listElemanlar.get(i).get(1) );
        // eleman adı                    eleman değeri

    }
    @Then("User should see the this message")
    public void userShouldSeeTheThisMessage(DataTable elements) {
        List<String> listElements = elements.asList(String.class);

        for (String strText : listElements) {
            dc.findAndContainsText("checkText", strText);
        }
    }

    @And("Click on this product")
    public void clickOnThisProduct(DataTable elements) {
        List<String> listElements = elements.asList(String.class);
        for (String strText : listElements) {
            waitUntilClickable(GWD.getDriver().findElement(By.xpath(dl.productXPath(strText))));
            GWD.getDriver().findElement(By.xpath(dl.productXPath(strText))).click();
        }

    }

    @And("Choose option in product")
    public void chooseOptionInProduct(DataTable elements) {
        List<String> listElements = elements.asList(String.class);
        for (String strText : listElements) {
            waitUntilVisible(GWD.getDriver().findElement(By.cssSelector("div[class='swatch-opt']")));
            GWD.getDriver().findElement(By.cssSelector(dl.optionsCssSelector(strText))).click();
        }
    }

    @And("User should choose {string} on item box")
    public void userShouldChooseOnItemBox(String option, DataTable elements) {
        String productId;
        List<WebElement> productsName = GWD.getDriver().findElements(By.cssSelector("div[class='product-item-info']>div[class*='product-item-details']>strong[class*='product-item-name']"));
        List<WebElement> productsIdFinder = GWD.getDriver().findElements(By.cssSelector("div[class='price-box price-final_price']"));
        List<String> listElements = elements.asList(String.class);
        for (String strText : listElements) {
            for (int i = 0; i < productsName.size(); i++) {
                if (productsName.get(i).getText().trim().equalsIgnoreCase(strText)) {
                    productId = productsIdFinder.get(i).getAttribute("data-product-id");
                    actions.moveToElement(GWD.getDriver().findElement(By.cssSelector("div[data-product-id='"+productId+"']:nth-child(1)"))).build().perform();
                    GWD.getDriver().findElement(By.xpath(dl.itemBoxOptionXPath(productId, option))).click();
                    break;
                }
            }
        }
    }

    @And("User should click add to wish list on item box")
    public void userShouldClickAddToWishListOnItemBox(DataTable elements) {
        String productId;
        List<WebElement> productsName = GWD.getDriver().findElements(By.cssSelector("div[class='product-item-info']>div[class*='product-item-details']>strong[class*='product-item-name']"));
        List<WebElement> productsIdFinder = GWD.getDriver().findElements(By.cssSelector("div[class='price-box price-final_price']"));
        List<String> listElements = elements.asList(String.class);
        for (String strText : listElements) {
            for (int i = 0; i < productsName.size(); i++) {
                if (productsName.get(i).getText().trim().equalsIgnoreCase(strText)) {
                    productId = productsIdFinder.get(i).getAttribute("data-product-id");
                    actions.moveToElement(GWD.getDriver().findElement(By.cssSelector("div[class='product details product-item-details']>div[data-product-id='"+productId+"']"))).build().perform();
                    waitUntilClickable(GWD.getDriver().findElement(By.cssSelector(dl.itemBoxAddToWishListCSS(productId))));
                    GWD.getDriver().findElement(By.cssSelector(dl.itemBoxAddToWishListCSS(productId))).click();
                    break;
                }
            }
        }
    }

    @And("User should click add to cart on item box")
    public void userShouldClickAddToCartOnItemBox(DataTable elements) {
        String product;
        List<WebElement> productsName = GWD.getDriver().findElements(By.cssSelector("div[class='product-item-info']>div[class*='product-item-details']>strong[class*='product-item-name']"));
        List<WebElement> productsAddToCart = GWD.getDriver().findElements(By.cssSelector("form[data-role='tocart-form']"));
        List<String> listElements = elements.asList(String.class);
        for (String strText : listElements) {
            for (int i = 0; i < productsName.size(); i++) {
                if (productsName.get(i).getText().trim().equalsIgnoreCase(strText)) {
                    product = productsAddToCart.get(i).getAttribute("data-product-sku");
                    System.out.println(product.toLowerCase());
                    actions.moveToElement(GWD.getDriver().findElement(By.xpath("//div[@class='products wrapper grid products-grid']//img[contains(@src,'"+product.toLowerCase()+"')]"))).build().perform();
                    GWD.getDriver().findElement(By.cssSelector(dl.itemBoxAddToCartCSS(product))).click();
                    waitUntilVisible(GWD.getDriver().findElement(By.cssSelector("div[class='page messages']")));
                    break;
                }
            }
        }
    }

    @And("User should click add to cart on item box in Wishlist")
    public void userShouldClickAddToCartOnItemBoxInWishlist(DataTable elements) {
        String productId;
        List<WebElement> productsName = GWD.getDriver().findElements(By.cssSelector("div[class*='product-item-info']>strong[class*='product-item-name']"));
        List<WebElement> productsId = GWD.getDriver().findElements(By.cssSelector("li[data-row='product-item']"));
        List<String> listElements = elements.asList(String.class);
        for (String strText : listElements) {
            for (int i = 0; i < productsName.size(); i++) {
                if (productsName.get(i).getText().trim().equalsIgnoreCase(strText)) {
                    productId = productsId.get(i).getAttribute("id").replaceAll("\\D","");
                    actions.moveToElement(GWD.getDriver().findElement(By.cssSelector("li[id='item_"+productId+"']>div>strong[class='product-item-name']"))).build().perform();
                    GWD.getDriver().findElement(By.cssSelector(dl.wishListAddToCartCSS(productId))).click();
                    break;
                }
            }
        }
    }

    @And("Click remove that item in the Compare Page")
    public void clickRemoveThatItemInTheComparePage(DataTable elements) {
        String productId;
        List<WebElement> productsName = GWD.getDriver().findElements(By.cssSelector("td[class='cell product info']>strong[class='product-item-name']"));
        List<WebElement> productsIdFinder = GWD.getDriver().findElements(By.cssSelector("div[class='price-box price-final_price']"));
        List<String> listElements = elements.asList(String.class);
        for (String strText : listElements) {
            for (int i = 0; i < productsName.size(); i++) {
                if (productsName.get(i).getText().trim().equalsIgnoreCase(strText)) {
                    productId = productsIdFinder.get(i).getAttribute("data-product-id");
                    GWD.getDriver().findElement(By.cssSelector(dl.itemBoxRemoveButtonCSS(productId))).click();
                    break;
                }
            }
        }
    }
}

