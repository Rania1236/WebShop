import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class PageBase {
    protected WebDriver driver;
    Actions action;

    public PageBase(WebDriver driver){
        this.driver =driver;
    }
    public static void Clicking(WebElement element)
    {
        element.click();
    }



    public static void sendText(WebElement element, String text)
    {
        element.sendKeys(text);
    }
    public void scrollToBottom(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,8000);");
    }
}
