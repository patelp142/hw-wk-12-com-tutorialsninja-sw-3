package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class DesktopsTest extends Utility {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        //1.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //1.3 Select Sort By position "Name: Z to A"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Desktops']"));
        //2.2 Click on “Show All Desktops”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllDesktops']"));
        //2.3 Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Name (A - Z)");
        //2.4 Select product “HP LP3065”
        clickOnElement(By.xpath("//a[normalize-space()='HP LP3065']"));
        //2.5 Verify the Text "HP LP3065"
        verifyExpectedAndActual(By.xpath("//h1[normalize-space()='HP LP3065']"),"HP LP3065");
        //2.6 Select Delivery Date "2022-11-30"
        clearText(By.xpath("//input[@id='input-option225']"));
        sendTextToElement(By.xpath("//input[@id='input-option225']"),"2022-11-30");
        //2.7.Enter Qty "1” using Select class.
        clearText(By.xpath("//input[@id='input-quantity']"));
        sendTextToElement(By.xpath("//input[@id='input-quantity']"),"1");
        //2.8 Click on “Add to Cart” button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
        //2.9 Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        verifyExpectedAndActual(By.xpath("//div[@class='alert alert-success alert-dismissible']"),
                "Success: You have added HP LP3065 to your shopping cart!\n"+"×");
        Thread.sleep(2000);
        //2.10 Click on link “shopping cart” display into success message
        clickOnElement(By.linkText("shopping cart"));
        Thread.sleep(2000);
        //2.11 Verify the text "Shopping Cart"
        //verifyExpectedAndActual(By.xpath(("//h1[starts-with(text(),'Shopping Cart')]").substring(0,13)),"Shopping Cart");
        String actualMessage = driver.findElement(By.xpath("//h1[starts-with(text(),'Shopping Cart')]")).getText();
        Assert.assertEquals("Shopping Cart", actualMessage.substring(0,13));
        //2.12 Verify the Product name "HP LP3065"
        verifyExpectedAndActual(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),
                "HP LP3065");
        //2.13 Verify the Delivery Date "2022-11-30"
        verifyExpectedAndActual(By.xpath("//small[normalize-space()='Delivery Date:2022-11-30']"),"Delivery Date:2022-11-30");
        //2.14 Verify the Model "Product21"
        verifyExpectedAndActual(By.xpath("//td[normalize-space()='Product 21']"),"Product 21");
        //2.15 Verify the Total "$122.00"
        verifyExpectedAndActual(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"),
                "$122.00");

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
