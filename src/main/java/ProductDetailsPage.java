import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailsPage extends PageBase{
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }


    By breadCrumb = By.cssSelector("div[class=\"product-name\"] h1");
    By productEmailFriend = By.cssSelector("input[class=\"button-2 email-a-friend-button\"]");
    WebElement emailFriendBtn;

    By productReviewElement = By.cssSelector("#product-details-form > div > div.product-essential > div.overview > div.product-reviews-overview > div.product-review-links > a:nth-child(3)");
    WebElement ReviewLink;

    By productTitleElement = By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.search-results > div.product-grid > div > div > div.details > h2 > a");
    WebElement productTitleLink;

    By wishlistElement = By.id("add-to-wishlist-button-5");
    WebElement wishlistBtn;

    By CompareProduct21 = By.cssSelector("input[class=\"button-2 add-to-compare-list-button\"]");
    WebElement CompareProductBtn;

    By addToCart = By.cssSelector("input[class=\"button-1 add-to-cart-button\"]");
    WebElement addToCartBtn;

    public String BreadCrumbProduct()
    {
        return driver.findElement(breadCrumb).getText();
    }

    public void ClickOnButton()
    {
        emailFriendBtn =driver.findElement(productEmailFriend);
        Clicking(emailFriendBtn);
    }

    public void ClickOnReviewLink()
    {
        ReviewLink = driver.findElement(productReviewElement);
        Clicking(ReviewLink);
    }

    public void ClickOnProductTitle()
    {
        productTitleLink=driver.findElement(productTitleElement);
        Clicking(productTitleLink);
    }
    public void AddProductToWishlist()
    {
        wishlistBtn=driver.findElement(wishlistElement);
        Clicking(wishlistBtn);
    }
    public void AddProductToCompare()
    {
        CompareProductBtn=driver.findElement(CompareProduct21);
        Clicking(CompareProductBtn);
    }

    public void ClickOnAddToCart()
    {
        addToCartBtn=driver.findElement(addToCart);
        Clicking(addToCartBtn);
    }

}
