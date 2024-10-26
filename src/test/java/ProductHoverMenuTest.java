import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductHoverMenuTest extends TestBase{

    HomePage homePage;
    @Test
    public void UserCanSelectSubCategoryFromMainMenu() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.ComputersMenu();
        Thread.sleep(3000);
        homePage.NoteBookMenu();
        Assert.assertTrue(driver.getCurrentUrl().contains("notebooks"));
    }
}
