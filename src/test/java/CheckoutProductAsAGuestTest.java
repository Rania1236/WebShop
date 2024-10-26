import com.beust.ah.A;
import org.checkerframework.checker.units.qual.C;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutProductAsAGuestTest extends TestBase{
    String productName="Build your own cheap computer";
    SearchPage searchObject;
    ProductDetailsPage detailsObject;
    ShoppingCartPage CartPage;
    CheckoutPage CheckoutObject;
    OrderDetailedPage orderDetailedObject;



    @Test(priority = 1)
    public void CheckOUt() throws InterruptedException {
        searchObject = new SearchPage(driver);
        detailsObject = new ProductDetailsPage(driver);
        Thread.sleep(3000);
        searchObject.productSearch(productName);
        Thread.sleep(3000);
        searchObject.ClickOnSearchBtn();
        Thread.sleep(3000);
        searchObject.ProductDetailsPage();
        detailsObject.ClickOnAddToCart();
        CartPage = new ShoppingCartPage(driver);
        CartPage.AddToCart();
        CartPage.ClickOnTerms();
        CartPage.OpenCheckout();
        CheckoutObject = new CheckoutPage(driver);
        CheckoutObject.clickOnCheckOutASGuest();
        CheckoutObject.sendFirstName("rania");
        CheckoutObject.sendLastName("magdy");
        CheckoutObject.sendEmail("rania127magdy@gmail.com");
        CheckoutObject.sendCompany("semi");
        CheckoutObject.Country();
        CheckoutObject.sendCity("Giza");
        CheckoutObject.sendAddress1("Dokki");
        CheckoutObject.sendAddress2("El-Haram");
        CheckoutObject.sendZipCode("1234");
        CheckoutObject.sendPhoneNumber("3444557324");
        CheckoutObject.sendFaxNumber("1234");
        Thread.sleep(3000);
        CheckoutObject.ClickOnContinue();
        Thread.sleep(8000);
        CheckoutObject.ClickCheckBox();

        Thread.sleep(8000);
        CheckoutObject.ClickOnShippingAddressBtn();

        //Thread.sleep(8000);
        //CheckoutObject.ChooseShippingMethod();


        Thread.sleep(8000);
        CheckoutObject.ChoosePaymentMethod();
        Thread.sleep(6000);
        CheckoutObject.ClickOnPaymentMethodBtn();

        Assert.assertEquals(CheckoutObject.verifyPaymentInformation(),"You will pay by COD","You will pay by COD");
        CheckoutObject.ClickOnPaymentInformation();

    }

    @Test(priority = 2)
    public void confirmOrder() throws InterruptedException {
        orderDetailedObject =new OrderDetailedPage(driver);
        orderDetailedObject.ClickOnConfirmOrder();
        //Assert.assertEquals(orderDetailedObject.verifyOrder(),"Thank you","Thank you");
        Assert.assertEquals(orderDetailedObject.verifyOrderPage(),"Your order has been successfully processed!","Your order has been successfully processed!");
        Thread.sleep(4000);
        orderDetailedObject.ClickOnOrderDetailed();
        Thread.sleep(5000);
        Assert.assertEquals(CheckoutObject.verifyOrderInformation(),"Order information");
        orderDetailedObject.ClickOnPDFInvoice();

    }
}
