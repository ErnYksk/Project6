package Helper;

import Utils.GWD;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DynamicLocator {

    public String productXPath(String element) {
        return "//strong//a[@title='" + element + "'][1]";
    }

    public String optionsCssSelector(String element) {
        return "div[option-label='" + element + "']";
    }

    public String itemBoxAddToWishListCSS(String productId) {
        return "a[class='action towishlist'][data-post*='" + productId + "']";
    }

    public String wishListAddToCartXPath(int wishListIndex) {
        return "(//div[@class='box-tocart']//button[@class='action tocart primary'])["+wishListIndex+"]";
    }

    public String itemBoxRemoveButtonCSS(String element) {
        return "a[data-post*='" + element + "'][class*='delete']";
    }

    public String productIdFinder(DataTable elements) {
        String productId = "";
        List<WebElement> productsName = GWD.getDriver().findElements(By.cssSelector("div[class='product-item-info']>div[class*='product-item-details']>strong[class*='product-item-name']"));
        List<WebElement> productsIdFinder = GWD.getDriver().findElements(By.cssSelector("div[class='price-box price-final_price']"));
        List<String> listElements = elements.asList(String.class);
        for (String strText : listElements) {
            for (int i = 0; i < productsName.size(); i++) {
                if (productsName.get(i).getText().trim().equalsIgnoreCase(strText)) {
                    productId = productsIdFinder.get(i).getAttribute("data-product-id");
                    break;
                }
            }
        }
        return productId;
    }
    public int WishListIndexFinder(DataTable elements) {
        int index=0;
        List<WebElement> productsName = GWD.getDriver().findElements(By.cssSelector("div[class*='product-item-info']>strong[class*='product-item-name']"));
        List<String> listElements = elements.asList(String.class);
        for (String strText : listElements) {
            for (int i = 0; i < productsName.size(); i++) {
                if (productsName.get(i).getText().trim().equalsIgnoreCase(strText)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    public String productIdFinderInCompare(DataTable elements) {
        String productId="";
        List<WebElement> productsName = GWD.getDriver().findElements(By.cssSelector("td[class='cell product info']>strong[class='product-item-name']"));
        List<WebElement> productsIdFinder = GWD.getDriver().findElements(By.cssSelector("div[class='price-box price-final_price']"));
        List<String> listElements = elements.asList(String.class);
        for (String strText : listElements) {
            for (int i = 0; i < productsName.size(); i++) {
                if (productsName.get(i).getText().trim().equalsIgnoreCase(strText)) {
                    productId = productsIdFinder.get(i).getAttribute("data-product-id");
                    break;
                }
            }
        }
        return productId;
    }
}