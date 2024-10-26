import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage extends PageBase{
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    By search = By.cssSelector("input[class=\"search-box-text ui-autocomplete-input\"]");
    WebElement SearchText;
    By searchBtn = By.cssSelector("input[class=\"button-1 search-box-button\"]");
    By ProductTitle = By.cssSelector("body > div.master-wrapper-page > div.master-wrapper-content > div.master-wrapper-main > div.center-2 > div > div.page-body > div.search-results > div.product-grid > div > div > div.details > h2 > a");
    By NoProduct = By.cssSelector("div[class=\"search-results\"] strong");

    public void productSearch (String productName)
    {
        SearchText = driver.findElement(search);
        sendText(SearchText,productName);

    }

    public void ClickOnSearchBtn()
    {
        Clicking(driver.findElement(searchBtn));
    }
    public void ProductDetailsPage()
    {
        Clicking(driver.findElement(ProductTitle));
    }

    public String NoProductsWereFoundThatMatchedYourCriteria() {
        return driver.findElement(NoProduct).getText();
    }



}
