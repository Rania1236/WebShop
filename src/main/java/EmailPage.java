import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EmailPage extends PageBase{
    public EmailPage(WebDriver driver) {
        super(driver);
    }
    By productEmailTxt = By.id("FriendEmail");
    WebElement sendEmailFriend;
    By yourEmail = By.id("YourEmailAddress");
    WebElement EnterYourEmail;
    By yourPersonalMessage= By.id("PersonalMessage");
    WebElement personalMessage;
    By sendEmailElement= By.cssSelector("input[class=\"button-1 send-email-a-friend-button\"]");
    WebElement sendEmailBtn;
    By SuccessMessage = By.cssSelector("div[class=\"page-body\"] div[class=\"result\"]");

    public void EmailFriend(String emailFriend)
    {
        sendEmailFriend = driver.findElement(productEmailTxt);
        sendText(sendEmailFriend,emailFriend);
    }
    public void YourEmailAddress(String emailAddress)
    {
        EnterYourEmail = driver.findElement(yourEmail);
        sendText(EnterYourEmail,emailAddress);
    }
    public void EnterYourPersonalMessage(String PersonalMessage)
    {
        personalMessage = driver.findElement(yourPersonalMessage);
        sendText(personalMessage,PersonalMessage);
    }
    public void ClickOnSendEmail()
    {
        sendEmailBtn = driver.findElement(sendEmailElement);
        Clicking(sendEmailBtn);
    }

    public String successMessage() {
        return driver.findElement(SuccessMessage).getText();
    }


}
