package Pages;

import Utils.GWD;
import io.cucumber.messages.types.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org.openqa.selenium.support.ui.WebDriverWait;
public class Parents {

    WebDriverWait wait=new WebDriverWait(GWD.getDriver(), java.time.Duration.ofSeconds(30));
    public void sendKeysFunction(WebElement element, String value)
    {
        waitUntilVisible(element); // gözükene kadar bekle
        scrollToelement(element);  // elemente kadar scroll yap (javascriptexecuter)
        element.clear();           //        temizle  (clear)
        element.sendKeys(value);//        değeri gönder (sendKeys)
    }


    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element); // Clickable olana kadar bekle
        scrollToelement(element);  // elemente kadar scroll yap (javascriptexecuter)
        element.click();           //        click
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
}
