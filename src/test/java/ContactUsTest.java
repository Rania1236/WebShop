import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsTest extends TestBase{
    HomePage homePage;
    ContactUsPage ContactPage;
    Faker faker = new Faker();
    String name=faker.name().firstName();
    String email=faker.internet().emailAddress();
    String enquiry ="Hello Rania,I have a Problem";

    @Test
    public void UserCanUseContactUS() throws InterruptedException {
        homePage =new HomePage(driver);
        ContactPage=new ContactUsPage(driver);
        homePage.contactUsPage();
        Thread.sleep(3000);
        homePage.ClickOnContactUs();
        Thread.sleep(3000);
        ContactPage.FullName(name);
        ContactPage.email(email);
        ContactPage.enquiry(enquiry);
        ContactPage.Submit();
        Thread.sleep(3000);
        Assert.assertEquals(ContactPage.successMessage(),"Your enquiry has been successfully sent to the store owner.");
    }
}

