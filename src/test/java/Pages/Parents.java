package Pages;

import Helper.DynamicLocator;
import Utils.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Parents {

    WebDriverWait wait=new WebDriverWait(GWD.getDriver(), java.time.Duration.ofSeconds(30));
    Actions actions = new Actions(GWD.getDriver());

    public void sendKeysFunction(WebElement element, String value)
    {
        waitUntilVisible(element);
        scrollToelement(element);
        element.clear();
        element.sendKeys(value);
    }
    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element);
        scrollToelement(element);
        element.click();
    }
    public void waitUntilVisible(WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilClickable(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void scrollToelement(WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void verifyContainsTextFunction(WebElement element, String value)
    {
        wait.until(ExpectedConditions.textToBePresentInElement(element, value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()),"The text you searched couldn't be find");
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).perform();
    }

    public void moveToElement (String productId){
        actions.moveToElement(GWD.getDriver().findElement(By.cssSelector("div[data-product-id='" + productId + "']"))).build().perform();
    }

    public void moveToElementForWishList (int wishListIndex){
        actions.moveToElement(GWD.getDriver().findElement(By.xpath("(//div[contains(@class,'product-item-info')]//strong[contains(@class, 'product-item-name')])["+wishListIndex+"]"))).build().perform();
    }
    public void dropDownSelect(WebElement element,String value){
        waitUntilClickable(element);
        Select ddMenu=new Select(element);
        ddMenu.selectByValue(value);
    }
}
