import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends PageBase {
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    private By returningCustomer = By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.customer-blocks > div.returning-wrapper > div.title > strong");
    private By enterEmail = By.id("Email");
    private WebElement emailFieldInLogin;
    private By enterPassword = By.id("Password");
    private WebElement passWordFieldInLogin;
    private By LoginButton = By.cssSelector("input[class=\"button-1 login-button\"]");
    private By noCustomer = By.cssSelector("div[class=\"validation-summary-errors\"] li");
    private By credentialsProvidedAreIncorrect = By.cssSelector("div[class=\"message-error\"] li");



    public String getMessage() {
        return driver.findElement(returningCustomer).getText();
    }

    public void EnterEmailInLogin(String Email)
    {
        emailFieldInLogin =driver.findElement(enterEmail);
        sendText(emailFieldInLogin,Email);
    }
    public void EnterPasswordInLogin(String Password)
    {
        passWordFieldInLogin =driver.findElement(enterPassword);
        sendText(passWordFieldInLogin,Password);
    }
    public void clickInLoginButton()
    {
        Clicking(driver.findElement(LoginButton));
    }

    public String NoCustomerAccountFound() {
        return driver.findElement(noCustomer).getText();
    }
    public String EmailIsWrong() {
        return driver.findElement(credentialsProvidedAreIncorrect).getText();
    }






}
