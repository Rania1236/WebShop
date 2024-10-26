import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistPage extends PageBase{
    public WishlistPage(WebDriver driver) {
        super(driver);
    }
    By wishlist = By.cssSelector("div[id=\"bar-notification\"] a[href=\"/wishlist\"]");
    WebElement wishlistLink;
    By pageTitle = By.cssSelector("div[class=\"page-title\"] h1");
    By product = By.cssSelector("a[href=\"/50s-rockabilly-polka-dot-top-jr-plus-size\"]");
    By price = By.className("product-unit-price");
    By  removeWishlist= By.cssSelector("td[class=\"remove-from-cart\"] input[name=\"removefromcart\"]");
    WebElement removeFromCartCheck;
    By  updateWishlist= By.cssSelector("input[class=\"button-2 update-wishlist-button\"]");
    WebElement updateWishlistBtn;
    By wishlistContent = By.cssSelector("div[class=\"wishlist-content\"]");



    public void ClickOnWishlistInBarNotification()
    {
        wishlistLink = driver.findElement(wishlist);
        Clicking(wishlistLink);
    }

    public String wishlistHeader()
    {
        return driver.findElement(pageTitle).getText();
    }

    public String verifyProductTitle()
    {
        return driver.findElement(product).getText();
    }
    public String verifyProductPrice()
    {
        return driver.findElement(price).getText();
    }

    public void RemoveElementFromWishlist()
    {
        removeFromCartCheck = driver.findElement(removeWishlist);
        Clicking(removeFromCartCheck);
    }
    public void ClickOnUpdateWishlistBtn()
    {
        updateWishlistBtn = driver.findElement(updateWishlist);
        Clicking(updateWishlistBtn);
    }
    public String verifyThatWishlistRemove()
    {
        return driver.findElement(wishlistContent).getText();
    }


}
