import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddProductReviewTest extends TestBase{

    //UserRegistration
    HomePage homePage;
    RegisterPage registerPage;
    String productName="Build your own cheap computer";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    ProductReviewPage reviewObject;
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    @Test(priority = 1)
    public void validRegisterTC() throws InterruptedException {
        homePage = new HomePage(driver);
        registerPage = homePage.clickOnRegisterButton();
        registerPage.gender();
        registerPage.EnterFirstName(firstName);
        registerPage.EnterLastName(lastName);
        registerPage.EnterEmail(email);
        registerPage.EnterPassword(password);
        registerPage.ConfirmPassword(password);
        registerPage.registerButton();
        // Assertionon
        Assert.assertEquals(registerPage.getErrorMessage(), "Your registration completed", "Your registration completed is wrong");
        registerPage.ClickonContinueButton();
    }
    //Search For Product

    @Test(priority = 2)
    public void UserCanSearchForProduct() throws InterruptedException {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        searchObject.productSearch(productName);
        searchObject.ClickOnSearchBtn();
        searchObject.ProductDetailsPage();
        Assert.assertEquals(detailsObject.BreadCrumbProduct(),productName,"productName is wrong");
    }

    @Test(priority = 3)
    public void RegisterUserCanReviewProduct() throws InterruptedException {
        detailsObject.ClickOnReviewLink();
        reviewObject = new ProductReviewPage(driver);
        reviewObject.AddProductReviewText("new review");
        reviewObject.sendReviewTextArea("The Product is very good");
        reviewObject.ClickOnProductRating();
        reviewObject.ClickOnSubmitButton();
        Assert.assertEquals(reviewObject.SuccessMessage(),"Product review is successfully added.","Product review is successfully added.");
    }
    //Log out
    @Test(priority = 4)
    public void RegisteredUserCanLogout()
    {
        registerPage.userLogout();
    }

}

