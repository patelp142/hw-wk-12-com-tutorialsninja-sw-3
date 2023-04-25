package homepage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    public void selectMenu(String menu) {
        clickOnElement(By.linkText(menu));

    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        selectMenu("Show AllDesktops");
        verifyExpectedAndActual(By.xpath("//h2[normalize-space()='Desktops']"),"Desktops");
    }

    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully(){
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        selectMenu("Show AllLaptops & Notebooks");
        verifyExpectedAndActual(By.xpath("//h2[normalize-space()='Laptops & Notebooks']"),
                "Laptops & Notebooks");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully(){
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Components']"));
        selectMenu("Show AllComponents");
        verifyExpectedAndActual(By.xpath("//h2[normalize-space()='Components']"),"Components");
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
