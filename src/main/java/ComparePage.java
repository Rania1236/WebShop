import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ComparePage extends PageBase {
    public ComparePage(WebDriver driver) {
        super(driver);
    }

    By clearList = By.cssSelector("a[href=\"#\"]");
    WebElement clearListOnCompareList;
    By PageBodyTxt = By.cssSelector("div[class=\"page-body\"]");


    public void ClickOnClearList() {
        clearListOnCompareList = driver.findElement(clearList);
        Clicking(clearListOnCompareList);
    }

    public String verifyPageBody() {
        return driver.findElement(PageBodyTxt).getText();
        //You have no items to compare.
    }

    public void CompareProduct() {
        WebElement table = driver.findElement(By.cssSelector("table.compare-products-table"));

        List<WebElement> rows = table.findElements(By.tagName("tr"));

        List<WebElement> productNameCells = rows.get(1).findElements(By.tagName("td"));
        List<WebElement> productPriceCells = rows.get(2).findElements(By.tagName("td"));

        for (int i = 1; i < productNameCells.size(); i++) {
            String productName = productNameCells.get(i).getText().trim();
            String productPrice = productPriceCells.get(i).getText().trim();

            System.out.println("Product [" + i + "]" + " : " + productName + " | Price: " + productPrice);
        }


    }
}





