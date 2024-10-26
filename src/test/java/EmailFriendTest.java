import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmailFriendTest extends TestBase{
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    String productName="Desktop PC with CDRW";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    EmailPage emailObject;
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
    //Your message has been sent.
    //Search For Product
    @Test(priority = 2)
    public void UserCanSearchForProduct() throws InterruptedException {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        Thread.sleep(3000);
        searchObject.productSearch(productName);
        Thread.sleep(3000);
        searchObject.ClickOnSearchBtn();
        Thread.sleep(3000);
        searchObject.ProductDetailsPage();
        Thread.sleep(3000);
        Assert.assertEquals(detailsObject.BreadCrumbProduct(),productName,"productName is wrong");
    }

    @Test(priority = 3)
    public void RegisterUserCanSendProductToFriend() throws InterruptedException {
        detailsObject.ClickOnButton();
        emailObject = new EmailPage(driver);
        emailObject.EmailFriend("aaa@gmail.com");
        emailObject.YourEmailAddress("");
        Thread.sleep(2000);
        emailObject.EnterYourPersonalMessage("Hello my friend, Check This Product");
        emailObject.ClickOnSendEmail();
        Assert.assertEquals(emailObject.successMessage(),"Your message has been sent.","Your message has been sent.");

    }

    @Test(priority = 4)
    public void RegisteredUserCanLogout()
    {
        registerPage.userLogout();
    }

}
