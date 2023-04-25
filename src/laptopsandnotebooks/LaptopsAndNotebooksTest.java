package laptopsandnotebooks;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully(){
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
        //1.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
        //1.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
        //1.4 Verify the Product price will arrange in High to Low order.

    }
    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
//        2.1 Mouse hover on Laptops & Notebooks Tab and click
        mouseHoverToElementAndClick(By.xpath("//a[normalize-space()='Laptops & Notebooks']"));
//        2.2 Click on “Show All Laptops & Notebooks”
        clickOnElement(By.xpath("//a[normalize-space()='Show AllLaptops & Notebooks']"));
//        2.3 Select Sort By "Price (High > Low)"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-sort']"), "Price (High > Low)");
//        2.4 Select Product “MacBook”
        clickOnElement(By.xpath("//a[normalize-space()='MacBook']"));
//        2.5 Verify the text “MacBook”
        verifyExpectedAndActual(By.xpath("//h1[normalize-space()='MacBook']"),"MacBook");
//        2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.xpath("//button[@id='button-cart']"));
//        2.7 Verify the message “Success: You have added MacBook to your shopping cart!”
        verifyExpectedAndActual(By.xpath("//div[@class='alert alert-success alert-dismissible']"),
                "Success: You have added MacBook to your shopping cart!\n"+"×");
//        2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[normalize-space()='shopping cart']"));
//        2.9 Verify the text "Shopping Cart"
        Thread.sleep(2000);
        String actualMessage = driver.findElement(By.xpath("//h1[starts-with(text(),'Shopping Cart')]")).getText();
        Assert.assertEquals("Shopping Cart", actualMessage.substring(0,13));
//        2.10 Verify the Product name "MacBook"
        verifyExpectedAndActual(By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),
                "MacBook");
//        2.11 Change Quantity "2"
        Thread.sleep(2000);
        clearText(By.cssSelector("input[value='1']"));
        sendTextToElement(By.cssSelector("input[value='1']"),"2");
//        2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//i[@class='fa fa-refresh']"));
//        2.13 Verify the message “Success: You have modified your shopping cart!”
        verifyExpectedAndActual(By.xpath("//div[@class='alert alert-success alert-dismissible']"),
                "Success: You have modified your shopping cart!\n"+"×");
//        2.14 Verify the Total $1,204.00
        verifyExpectedAndActual(By.xpath("//body[1]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]"),
                "$1,204.00");
//        2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
//        2.16 Verify the text “Checkout”
        Thread.sleep(2000);
        verifyExpectedAndActual(By.xpath("//h1[normalize-space()='Checkout']"),"Checkout");
//        2.17 Verify the Text “New Customer”
        Thread.sleep(2000);
        verifyExpectedAndActual(By.xpath("//h2[normalize-space()='New Customer']"),"New Customer");
//        2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//input[@value='guest']"));
//        2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
//        2.20 Fill the mandatory fields
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"),"Mike");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"),"Miller");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"),"qwerty1@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"),"07914253687");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"),"1 ABC Street");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"),"London");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"),"AB12YZ");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-country']"),"United Kingdom");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='input-payment-zone']"),"Greater London");
//        2.21 Click on “Continue” Button
        clickOnElement(By.xpath("//input[@id='button-guest']"));
//        2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//textarea[@name='comment']"),"Testing text area");
//        2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));
//        2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));
//        2.25 Verify the message “Warning: Payment method required!”
        verifyExpectedAndActual(By.xpath("//div[@class='alert alert-danger alert-dismissible']"),
                "Warning: Payment method required!\n"+"×");
    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}
