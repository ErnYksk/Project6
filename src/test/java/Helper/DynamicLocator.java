package Helper;

public class DynamicLocator {
    public String productXPath(String element) {
        return "//strong//a[@title='" + element + "'][1]";
    }

    public String optionsCssSelector(String element) {
        return "div[option-label='" + element + "']";
    }

    public String itemBoxOptionXPath(String productId, String element) {
        return "//div[@class='swatch-opt-" + productId + "']//div[@option-label='" + element + "']";
    }

    public String itemBoxAddToWishListCSS(String productId) {
        return "a[class='action towishlist'][data-post*='" + productId + "']";
    }

    public String itemBoxAddToCartCSS(String element) {
        return "form[data-product-sku='" + element + "']";
    }
    public String wishListAddToCartCSS(String element) {
        return "button[data-item-id='" + element + "']";
    }
}
