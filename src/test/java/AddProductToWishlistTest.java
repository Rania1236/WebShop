import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddProductToWishlistTest extends TestBase{

    String productName="50's Rockabilly Polka Dot Top JR Plus Size\n";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    WishlistPage wishlistObject;

    @Test(priority = 1)
    public void UserCanSearchForProduct() throws InterruptedException {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        Thread.sleep(3000);
        searchObject.productSearch(productName);
        Thread.sleep(3000);
        searchObject.ClickOnSearchBtn();

    }
    @Test(priority = 2)
    public void UserCanAddProductToWishlist() throws InterruptedException {
        detailsObject = new ProductDetailsPage(driver);
        driver.switchTo().alert().accept();
        detailsObject.ClickOnProductTitle();
        detailsObject.AddProductToWishlist();
        wishlistObject = new WishlistPage(driver);
        wishlistObject.ClickOnWishlistInBarNotification();
        wishlistObject.wishlistHeader();
        Assert.assertEquals(wishlistObject.wishlistHeader(),"Wishlist","Wishlist is wrong");
        Thread.sleep(1000);
        Assert.assertEquals(wishlistObject.verifyProductTitle(),"50's Rockabilly Polka Dot Top JR Plus Size","Title is wrong");
        Assert.assertEquals(wishlistObject.verifyProductPrice(),"11.00","price is wrong");
    }
    @Test(priority = 3)
    public void UserCanRemoveProductFromWishlist()
    {
        wishlistObject = new WishlistPage(driver);
        wishlistObject.RemoveElementFromWishlist();
        wishlistObject.ClickOnUpdateWishlistBtn();
        Assert.assertEquals(wishlistObject.verifyThatWishlistRemove(),"The wishlist is empty!","Empty wishlist is wrong");
    }

}
