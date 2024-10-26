import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends PageBase {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private By gender = By.id("gender-female");

    private By firstName = By.id("FirstName");
    private WebElement firstNameElement;
    private By lastName = By.id("LastName");
    private WebElement lastNameElement;
    private By Email = By.id("Email");
    private WebElement emailFieldElement;
    private By password = By.id("Password");
    private WebElement passwordElement;
    private By ConfirmPassword = By.id("ConfirmPassword");
    private WebElement confirmPasswordElement;
    private By registerButton = By.id("register-button");
    private By Message = By.cssSelector("[class=\"page-body\"]");
    private By Continue = By.cssSelector("input[class=\"button-1 register-continue-button\"]");
    private By logout = By.cssSelector("a[href=\"/logout\"]");
    By myAccount = By.cssSelector("div[class=\"header-links\"] a[href=\"/customer/info\"]");
    private By emailRequired = By.cssSelector("span[class=\"field-validation-error\"] span");

    public void gender() {
        Clicking(driver.findElement(gender));
    }

    public void EnterFirstName(String FName) {
        firstNameElement = driver.findElement(firstName);
        sendText(firstNameElement, FName);
    }

    public void EnterLastName(String lName) {
        lastNameElement = driver.findElement(lastName);
        sendText(lastNameElement, lName);
    }

    public void EnterEmail(String email) {
        emailFieldElement = driver.findElement(Email);
        sendText(emailFieldElement, email);

    }

    public void EnterPassword(String Password) {
        passwordElement = driver.findElement(password);
        sendText(passwordElement, Password);
    }

    public void ConfirmPassword(String rePassword) {
        confirmPasswordElement = driver.findElement(ConfirmPassword);
        sendText(confirmPasswordElement, rePassword);
    }

    public void registerButton() {
        Clicking(driver.findElement(registerButton));
    }

    public String getErrorMessage()
    {
        return driver.findElement(Message).getText();
    }
    public void ClickonContinueButton()
    {
        Clicking(driver.findElement(Continue));
    }

    public void userLogout(){
        Clicking(driver.findElement(logout));
    }
    public void openMyAccountPage()
    {
        Clicking(driver.findElement(myAccount));
    }
    public String EmailIsRequired()
    {
        return driver.findElement(emailRequired).getText();
    }

}


