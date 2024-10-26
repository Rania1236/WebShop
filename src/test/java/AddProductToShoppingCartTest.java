import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductToShoppingCartTest extends TestBase{

    ProductDetailsPage detailsObject;
    SearchPage searchObject;
    ShoppingCartPage CartPage;
    String productName="Build your own cheap computer";
    @Test(priority = 1)
    public void UserCanSearchForProduct() throws InterruptedException {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        searchObject.productSearch(productName);
        searchObject.ClickOnSearchBtn();
        Thread.sleep(1000);
        searchObject.ProductDetailsPage();


    }
    @Test(priority = 2)
    public void UserCanAddProductToShoppingCart() throws InterruptedException {
        detailsObject = new ProductDetailsPage(driver);
        detailsObject.ClickOnAddToCart();
        CartPage = new ShoppingCartPage(driver);
        CartPage.AddToCart();
        CartPage.UpdateQuantity(3);
        CartPage.ClickOnUpdateCart();
        Assert.assertEquals(CartPage.VerifyTotalPrice(),"2445.00","Price is wrong");
        Thread.sleep(1000);
        Assert.assertEquals(CartPage.VerifyProductTitle(),productName,"productName in cart is wrong");


    }

    @Test(priority = 3)
    public void UserCanRemoveProductFromCart()
    {
        CartPage = new ShoppingCartPage(driver);
        CartPage.ClickOnRemoveCheck();
        CartPage.ClickOnUpdateCart();
        Assert.assertEquals(CartPage.VerifyThatCartIsEmpty(),"Your Shopping Cart is empty!","Your Shopping Cart is empty!");


    }


}
