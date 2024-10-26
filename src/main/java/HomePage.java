import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends PageBase {



    public HomePage(WebDriver driver) {
        super(driver);
        action = new Actions(driver);
    }
    By registerButton = By.className("ico-register");
    WebElement registerButtonElement;
    By loginButton = By.className("ico-login");
    WebElement loginButtonElement;
    By contact = By.cssSelector("a[href=\"/contactus\"]");
    public WebElement contactUs;

    By Computer = By.cssSelector("div[class=\"header-menu\"] ul[class=\"top-menu\"] a[href=\"/computers\"]");
    public WebElement ComputerMenu;

    By NoteBook = By.xpath("/html/body/div[4]/div[1]/div[4]/div[1]/div[1]/div[2]/ul/li[2]/ul/li[2]/a");
    public WebElement noteBookMenu;

    public RegisterPage clickOnRegisterButton()
    {
        registerButtonElement =driver.findElement(registerButton);
        Clicking(registerButtonElement);
        return new RegisterPage(driver);
    }
    public LoginPage clickOnLoginButton() {
        loginButtonElement = driver.findElement(loginButton);
        Clicking(loginButtonElement);
        return new LoginPage(driver);

    }
    public void contactUsPage(){
        scrollToBottom();
    }
    public void ClickOnContactUs()
    {
        contactUs =driver.findElement(contact);
        Clicking(contactUs);
    }

    public void ComputersMenu()
    {
        ComputerMenu =driver.findElement(Computer);
        action.moveToElement(ComputerMenu).click().build().perform();

    }

    public void NoteBookMenu()
    {
        noteBookMenu =driver.findElement(NoteBook);
        Clicking(noteBookMenu);
    }


}
