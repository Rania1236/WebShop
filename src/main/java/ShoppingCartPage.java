import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingCartPage extends PageBase{
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }
    By Cart = By.cssSelector("div[id=\"bar-notification\"] a[href=\"/cart\"]");
    WebElement AddToCartOnBarNotification;
    By Remove = By.cssSelector("input[name=\"removefromcart\"]");
    WebElement removeCheck;
    By updateCart = By.cssSelector("input[class=\"button-2 update-cart-button\"]");
    WebElement updateCartBtn;
    By TotalPrice = By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div > div > div.page-body > div > form > table > tbody > tr > td.subtotal.nobr.end > span.product-subtotal");
    By productTitleTxt = By.cssSelector(" a[class=\"product-name\"]");
    By pageBody = By.cssSelector("div[class=\"order-summary-content\"]");
    By QuantityElement = By.cssSelector("input[class=\"qty-input\"]");


    By Terms = By.cssSelector("div[class=\"terms-of-service\"] input");
    WebElement TermsOfService;
    By Submit = By.cssSelector("button[id=\"checkout\"]");
    WebElement SubmitBtn;




    public void AddToCart()
    {
        AddToCartOnBarNotification = driver.findElement(Cart);
        Clicking(AddToCartOnBarNotification);
    }
    public void ClickOnRemoveCheck()
    {
        removeCheck = driver.findElement(Remove);
        Clicking(removeCheck);
    }

    public void UpdateQuantity(int quantity)
    {
        WebElement QuantityTxt =driver.findElement(QuantityElement);
        QuantityTxt.clear();
        QuantityTxt.sendKeys(String.valueOf(quantity));
    }


    public void ClickOnUpdateCart()
    {
        updateCartBtn = driver.findElement(updateCart);
        Clicking(updateCartBtn);
    }
    public String VerifyTotalPrice()
    {
        return driver.findElement(TotalPrice).getText();
    }

    public String VerifyProductTitle()
    {
        return driver.findElement(productTitleTxt).getText();
    }

    public String VerifyThatCartIsEmpty()
    {
        return driver.findElement(pageBody).getText();
    }

    public void ClickOnTerms()
    {
        TermsOfService = driver.findElement(Terms);
        Clicking(TermsOfService);
    }
    public void OpenCheckout()
    {
        SubmitBtn = driver.findElement(Submit);
        Clicking(SubmitBtn);
    }



}
