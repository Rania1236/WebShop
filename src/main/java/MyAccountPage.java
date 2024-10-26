import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends PageBase{

    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    By changePassword = By.cssSelector("a[href=\"/customer/changepassword\"]");
    WebElement changePasswordLink;

    By oldPassword = By.id("OldPassword");
    WebElement oldPasswordElement;

    By newPassword = By.id("NewPassword");
    WebElement newPasswordElement;

    By confirmPassword = By.id("ConfirmNewPassword");
    WebElement confirmPasswordElement;

    By clickChangePassword = By.cssSelector("input[class=\"button-1 change-password-button\"]");
    WebElement ChangePasswordBtn;

    By result = By.cssSelector("div[class=\"result\"]");


    public void openChangePasswordPage()
    {
        changePasswordLink = driver.findElement(changePassword);
        Clicking(changePasswordLink);
    }
    public void oldPasswordText(String OldPassword)
    {
        oldPasswordElement = driver.findElement(oldPassword);
        sendText(oldPasswordElement,OldPassword);
    }
    public void newPasswordText(String NewPassword)
    {
        newPasswordElement = driver.findElement(newPassword);
        sendText(newPasswordElement,NewPassword);
    }
    public void confirmPasswordText(String ConfirmPassword)
    {
        confirmPasswordElement = driver.findElement(confirmPassword);
        sendText(confirmPasswordElement,ConfirmPassword);
    }
    public void clickOnChangePassword()
    {
        ChangePasswordBtn = driver.findElement(clickChangePassword);
        Clicking(ChangePasswordBtn);
    }

    public String getResult() {
        return driver.findElement(result).getText();
    }


}
