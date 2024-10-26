import org.testng.annotations.Test;

public class AddProductToCompareTest extends TestBase{
    String firstProductName ="Desktop PC with CDRW";
    String secondProductName="Build your own computer";
    //search for product number 1
    //search for product number 2
    //Add to compare
    //clear list
    ProductDetailsPage detailsObject;
    HomePage homePage;
    ComparePage compareObject;
    SearchPage searchObject;
    @Test(priority = 1)
    public void UserCanCompareProducts() throws InterruptedException {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        homePage = new HomePage(driver);
        compareObject =new ComparePage(driver);
        searchObject.productSearch(firstProductName);
        searchObject.ClickOnSearchBtn();
        Thread.sleep(3000);
        detailsObject.ClickOnProductTitle();
        detailsObject.AddProductToCompare();

        searchObject.productSearch(secondProductName);
        searchObject.ClickOnSearchBtn();
        detailsObject.ClickOnProductTitle();
        detailsObject.AddProductToCompare();
        driver.navigate().to("https://demowebshop.tricentis.com/compareproducts");
        compareObject.CompareProduct();

    }



}
