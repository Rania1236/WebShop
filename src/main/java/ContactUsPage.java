import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage extends PageBase{
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }
    By fullName = By.cssSelector("input[class=\"fullname\"]");
    WebElement fullNameTxt;
    By emailElement = By.id("Email");
    WebElement emailTxt;
    By enquiryElement = By.id("Enquiry");
    WebElement enquiryTxt;
    By submit = By.cssSelector("input[class=\"button-1 contact-us-button\"]");
    WebElement submitBtn;

    By successMessage = By.cssSelector("div[class=\"page-body\"] div[class=\"result\"]");



    public void FullName(String Name)
    {
        fullNameTxt=driver.findElement(fullName);
        sendText(fullNameTxt,Name);
    }
    public void email(String sendEmail)
    {
        emailTxt=driver.findElement(emailElement);
        sendText(emailTxt,sendEmail);
    }
    public void enquiry(String sendEnquiry)
    {
        enquiryTxt=driver.findElement(enquiryElement);
        sendText(enquiryTxt,sendEnquiry);
    }
    public void Submit()
    {
        submitBtn=driver.findElement(submit);
        Clicking(submitBtn);
    }

    public String successMessage() {
        return driver.findElement(successMessage).getText();
    }






}
