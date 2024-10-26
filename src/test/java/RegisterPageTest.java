import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends TestBase {
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    String WrongEmail =faker.internet().emailAddress();



    @Test(priority =1)
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
        Thread.sleep(3000);
        registerPage.userLogout();
        loginPage = homePage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getMessage(), "Returning Customer", "Returning Customer is wrong");
        loginPage.EnterEmailInLogin(email);
        loginPage.EnterPasswordInLogin(password);
        loginPage.clickInLoginButton();
    }

    @Test(priority = 2)
    public void InvalidRegisterTC()
    {
        registerPage.userLogout();
        registerPage = homePage.clickOnRegisterButton();
        registerPage.gender();
        registerPage.EnterFirstName(firstName);
        registerPage.EnterLastName(lastName);
        registerPage.EnterEmail("");
        registerPage.EnterPassword(password);
        registerPage.ConfirmPassword(password);
        registerPage.registerButton();
        Assert.assertEquals(registerPage.EmailIsRequired(),"Email is required.");

    }

    @Test(priority = 3)
    public void InvalidRegisterTCWithWrongFirstName()
    {

        registerPage = homePage.clickOnRegisterButton();
        registerPage.gender();
        registerPage.EnterFirstName("5334");
        registerPage.EnterLastName("52223225");
        registerPage.EnterEmail(WrongEmail);
        registerPage.EnterPassword(password);
        registerPage.ConfirmPassword(password);
        registerPage.registerButton();

    }


    @Test(priority = 4)
    public void InvalidLoginTC()
    {
        registerPage.userLogout();
        loginPage = homePage.clickOnLoginButton();
        loginPage.EnterEmailInLogin("");
        loginPage.EnterPasswordInLogin(password);
        loginPage.clickInLoginButton();
        Assert.assertEquals(loginPage.NoCustomerAccountFound(),"No customer account found");

    }

    @Test(priority = 5)
    public void InvalidLoginTCWithWrongEmail()
    {
        //registerPage.userLogout();
        loginPage = homePage.clickOnLoginButton();
        loginPage.EnterEmailInLogin("Rania77magdy@gmail.com");
        loginPage.EnterPasswordInLogin(password);
        loginPage.clickInLoginButton();
        Assert.assertEquals(loginPage.EmailIsWrong(),"The credentials provided are incorrect");
    }





}

