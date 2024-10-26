import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyAccountTest extends TestBase{
    private HomePage homePage;
    private RegisterPage registerPage;
    private LoginPage loginPage;
    private MyAccountPage myAccount;
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    String oldPassword=faker.internet().password();
    String newPassword="Rania1234";
    String confirmPassword="Rania1234";

    @Test(priority = 1)
    public void validRegisterTC() throws InterruptedException {
        homePage = new HomePage(driver);
        registerPage= homePage.clickOnRegisterButton();
        registerPage.gender();
        registerPage.EnterFirstName(firstName);
        registerPage.EnterLastName(lastName);
        registerPage.EnterEmail(email);
        registerPage.EnterPassword(oldPassword);
        registerPage.ConfirmPassword(oldPassword);
        registerPage.registerButton();
        // Assertion
        Assert.assertEquals(registerPage.getErrorMessage(),"Your registration completed","Your registration completed is wrong");
        registerPage.ClickonContinueButton();
        Thread.sleep(3000);
    }

    @Test(priority = 2)
    public void RegisteredUserCanChangePassword() throws InterruptedException {
        myAccount = new MyAccountPage(driver);
        registerPage.openMyAccountPage();
        Thread.sleep(3000);
        myAccount.openChangePasswordPage();
        Thread.sleep(3000);
        myAccount.oldPasswordText(oldPassword);
        myAccount.newPasswordText(newPassword);
        myAccount.confirmPasswordText(confirmPassword);
        myAccount.clickOnChangePassword();
        Assert.assertEquals(myAccount.getResult(),"Password was changed","Password was changed");
    }

    @Test(priority = 3)
    public void RegisteredUserCanLogout()
    {
        registerPage.userLogout();
    }

    @Test(priority = 4)
    public void validLoginTC() throws InterruptedException {
        homePage = new HomePage(driver);
        loginPage = homePage.clickOnLoginButton();
        Thread.sleep(3000);
        Assert.assertEquals(loginPage.getMessage(),"Returning Customer","Returning Customer is wrong");
        loginPage.EnterEmailInLogin(email);
        Thread.sleep(3000);
        loginPage.EnterPasswordInLogin(newPassword);
        Thread.sleep(3000);
        loginPage.clickInLoginButton();

    }


}
