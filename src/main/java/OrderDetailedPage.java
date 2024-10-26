import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderDetailedPage extends PageBase{
    public OrderDetailedPage(WebDriver driver) {
        super(driver);
    }

    By confirmElement = By.cssSelector("input[class=\"button-1 confirm-order-next-step-button\"]");
    WebElement ConfirmButton;

    By ThankYou = By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[1]/h1");
    By successMessage=By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[1]/strong");

    By orderDetails =By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/ul/li[2]/a");
    WebElement ClickHere;

    By invoiceElement =By.xpath("/html/body/div[4]/div[1]/div[4]/div/div/div[1]/a[2]");
    WebElement InvoiceBtn;

    public void ClickOnConfirmOrder()
    {
        ConfirmButton = driver.findElement(confirmElement);
        Clicking(ConfirmButton);
    }
    public String verifyOrder()
    {
        //Thank you
        return driver.findElement(ThankYou).getText();
    }
    public String verifyOrderPage()
    {
        return driver.findElement(successMessage).getText();
        //Your order has been successfully processed!
    }

    public void ClickOnOrderDetailed()
    {
        ClickHere = driver.findElement(orderDetails);
        Clicking(ClickHere);
    }
    public void ClickOnPDFInvoice()
    {
        InvoiceBtn = driver.findElement(invoiceElement);
        Clicking(InvoiceBtn);
    }



}

