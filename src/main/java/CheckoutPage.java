import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends PageBase {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    /*
    By Register = By.cssSelector("input[class=\"button-1 register-button\"]");
    WebElement registerBtn;

    public void clickOnRegister()
    {
        registerBtn = driver.findElement(Register);
        Clicking(registerBtn);
    }

     */
    By CheckOutASGuest = By.cssSelector("input[class=\"button-1 checkout-as-guest-button\"]");

    By FirstNameElement = By.id("BillingNewAddress_FirstName");
    WebElement firstNameTxt;

    By LastNameElement = By.id("BillingNewAddress_LastName");
    WebElement lastNameTxt;

    By emailElement = By.id("BillingNewAddress_Email");
    WebElement emailTxt;

    By CompanyElement = By.id("BillingNewAddress_Email");
    WebElement CompanyTxt;

    By CityElement = By.id("BillingNewAddress_City");
    WebElement CityTxt;

    By Address1Element = By.id("BillingNewAddress_Address1");
    WebElement Address1Txt;

    By Address2Element = By.id("BillingNewAddress_Address2");
    WebElement Address2Txt;

    By ZipCodeElement = By.id("BillingNewAddress_ZipPostalCode");
    WebElement ZipCOdeTxt;

    By PhoneNumberElement = By.id("BillingNewAddress_PhoneNumber");
    WebElement PhoneNumberTxt;

    By FaxNumberElement = By.id("BillingNewAddress_FaxNumber");
    WebElement FaxNumberTxt;

    By ContinueElement = By.cssSelector("div[id=\"billing-buttons-container\"] input[class=\"button-1 new-address-next-step-button\"]");


    By checkbox = By.cssSelector("input[id=\"PickUpInStore\"]");


    By ShippingAddressElement = By.xpath("//*[@id=\"shipping-buttons-container\"]/input");

    By ShippingMethodElement = By.cssSelector("input[id=\"shippingoption_0\"]");
    WebElement checkBoxInShippingMethod;


    By PaymentMethodElement = By.cssSelector("input[id=\"paymentmethod_0\"]");
    By PaymentElement = By.cssSelector("input[class=\"button-1 payment-method-next-step-button\"]");


    By PaymentInformationTxt = By.cssSelector("#checkout-payment-info-load > div > div > div.info > table > tbody > tr > td > p");

    By PaymentInformationElement = By.cssSelector("input[class=\"button-1 payment-info-next-step-button\"]");

    By orderInformation = By.cssSelector("div[class=\"page-title\"] h1");
    public void clickOnCheckOutASGuest() {
        Clicking(driver.findElement(CheckOutASGuest));
    }

    public void sendFirstName(String firstName) {
        firstNameTxt= driver.findElement(FirstNameElement);
        sendText(firstNameTxt,firstName);
    }

    public void sendLastName(String lastName) {
        lastNameTxt = driver.findElement(LastNameElement);
        sendText(lastNameTxt, lastName);
    }

    public void sendEmail(String Email) {
        emailTxt = driver.findElement(emailElement);
        sendText(emailTxt, Email);
    }

    public void sendCompany(String Company) {
        CompanyTxt = driver.findElement(CompanyElement);
        sendText(CompanyTxt, Company);
    }

    public void Country() {
        Select ChooseCountry = new Select(driver.findElement(By.cssSelector("div[class=\"inputs\"] select[id=\"BillingNewAddress_CountryId\"]")));
        ChooseCountry.selectByValue("31");

    }

    public void sendCity(String City) {
        CityTxt = driver.findElement(CityElement);
        sendText(CityTxt, City);
    }

    public void sendAddress1(String Address1) {
        Address1Txt = driver.findElement(Address1Element);
        sendText(Address1Txt, Address1);
    }

    public void sendAddress2(String Address2) {
        Address2Txt = driver.findElement(Address2Element);
        sendText(Address2Txt, Address2);
    }

    public void sendZipCode(String ZipCode) {
        ZipCOdeTxt = driver.findElement(ZipCodeElement);
        sendText(ZipCOdeTxt, ZipCode);
    }

    public void sendPhoneNumber(String PhoneNumber) {
        PhoneNumberTxt = driver.findElement(PhoneNumberElement);
        sendText(PhoneNumberTxt, PhoneNumber);
    }

    public void sendFaxNumber(String FaxNumber) {
        FaxNumberTxt = driver.findElement(FaxNumberElement);
        sendText(FaxNumberTxt, FaxNumber);


    }

    public void ClickOnContinue() {
        Clicking(driver.findElement(ContinueElement));
    }


    public void ClickCheckBox() {

        Clicking(driver.findElement(checkbox));

    }

    public void ClickOnShippingAddressBtn() {

        Clicking(driver.findElement(ShippingAddressElement));


    }


    public void ChooseShippingMethod() {
        checkBoxInShippingMethod = driver.findElement(ShippingMethodElement);
        Clicking(checkBoxInShippingMethod);

    }


    public void ChoosePaymentMethod() {
        Clicking(driver.findElement(PaymentMethodElement));


    }

    public void ClickOnPaymentMethodBtn() {
        Clicking(driver.findElement(PaymentElement));


    }

    public String verifyPaymentInformation() {
        //You will pay by COD
        return driver.findElement(PaymentInformationTxt).getText();
    }

    public void ClickOnPaymentInformation() {
        Clicking(driver.findElement(PaymentInformationElement));
    }

    public String verifyOrderInformation() {
        return driver.findElement(orderInformation).getText();
    }




}


