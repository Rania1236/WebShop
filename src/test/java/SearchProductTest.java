import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchProductTest extends TestBase{

    String productName="Desktop PC with CDRW";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;

    @Test(priority = 1)
    public void UserCanSearchForProduct() throws InterruptedException {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        searchObject.productSearch(productName);
        Thread.sleep(1000);
        searchObject.ClickOnSearchBtn();
        searchObject.ProductDetailsPage();
        Assert.assertEquals(detailsObject.BreadCrumbProduct(),productName,"productName is wrong");

    }

    @Test(priority = 2)
    public void UserCanSearchForWrongProduct() throws InterruptedException {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        searchObject.productSearch("Historical Book");
        Thread.sleep(1000);
        searchObject.ClickOnSearchBtn();
        Assert.assertEquals(searchObject.NoProductsWereFoundThatMatchedYourCriteria(),"No products were found that matched your criteria.");
    }
}
