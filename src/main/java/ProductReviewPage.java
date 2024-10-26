import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductReviewPage extends PageBase{
    public ProductReviewPage(WebDriver driver) {
        super(driver);
    }
    By reviewTitle = By.id("AddProductReview_Title");
    WebElement ReviewTitleTxt;

    By reviewTextAreaElement = By.id("AddProductReview_ReviewText");
    WebElement ReviewTxt;

    By addProductRatingElement = By.id("addproductrating_4");

    By submitElement = By.cssSelector("input[class=\"button-1 write-product-review-button\"]");
    By successMessage = By.cssSelector("div[class=\"page-body\"] div[class=\"result\"]");




    public void AddProductReviewText(String ReviewText)
    {
        ReviewTitleTxt =driver.findElement(reviewTitle);
        sendText(ReviewTitleTxt,ReviewText);
    }

    public void sendReviewTextArea(String reviewTextArea)
    {
        ReviewTxt =driver.findElement(reviewTextAreaElement);
        sendText(ReviewTxt,reviewTextArea);
    }
    public void ClickOnProductRating()
    {
        Clicking(driver.findElement(addProductRatingElement));
    }
    public void ClickOnSubmitButton()
    {
        Clicking(driver.findElement(submitElement));
    }

    public String SuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

}
