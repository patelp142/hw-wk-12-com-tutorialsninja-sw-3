package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class MyAccountsTest extends Utility {

    String baseUrl = "https://tutorialsninja.com/demo/index.php";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    public void selectMyAccountOptions(String option, By by){
        List<WebElement> options = driver.findElements(by);
        for (WebElement name : options){
            if (name.getText().equalsIgnoreCase(option)){
                name.click();
                break;
            }
        }
    }
    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully(){
//        1.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
//        1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register", By.xpath("//a[normalize-space()='Register']"));
//        1.3 Verify the text “Register Account”.
        verifyExpectedAndActual(By.xpath("//h1[normalize-space()='Register Account']"),
                "Register Account");
    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully(){
//        2.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
//        2.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login", By.xpath("//a[normalize-space()='Login']"));
//        2.3 Verify the text “Returning Customer”.
        verifyExpectedAndActual(By.xpath("//h2[normalize-space()='Returning Customer']"),
                "Returning Customer");
    }
    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
//        3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
//        3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOptions("Register", By.xpath("//a[normalize-space()='Register']"));
//        3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"),"Mike");
//        3.4 Enter Last Name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"),"Miller");
//        3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"),"qwerty5@gmail.com");
//        3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"),"07914253687");
//        3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"Qwerty@123");
//        3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"),"Qwerty@123");
//        3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//label[normalize-space()='Yes']//input[@name='newsletter']"));
//        3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//input[@name='agree']"));
//        3.11 Click on Continue button
        clickOnElement(By.xpath("//input[@value='Continue']"));
//        3.12 Verify the message “Your Account Has Been Created!”
        verifyExpectedAndActual(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']"),
                "Your Account Has Been Created!");
//        3.13 Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
//        3.14 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
//        3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOptions("Logout",By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));
//        3.16 Verify the text “Account Logout”
        Thread.sleep(2000);
        verifyExpectedAndActual(By.xpath("//h1[normalize-space()='Account Logout']"),
                "Account Logout");
//        3.17 Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
    }
    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
//        4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
//        4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOptions("Login", By.xpath("//a[normalize-space()='Login']"));
//        4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"),"qwerty3@gmail.com");
//        4.4 Enter Last Name - NOT APPLICABLE
//        4.5 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"),"Qwerty@123");
//        4.6 Click on Login button
        clickOnElement(By.xpath("//input[@value='Login']"));
//        4.7 Verify text “My Account”
        Thread.sleep(2000);
        verifyExpectedAndActual(By.xpath("//h2[normalize-space()='My Account']"),"My Account");
//        4.8 Click on My Account Link.
        clickOnElement(By.xpath("//span[normalize-space()='My Account']"));
//        4.9 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        clickOnElement(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']"));
//        4.10 Verify the text “Account Logout”
        Thread.sleep(2000);
        verifyExpectedAndActual(By.xpath("//h1[normalize-space()='Account Logout']"),
                "Account Logout");
//        4.11 Click on Continue button
        clickOnElement(By.xpath("//a[@class='btn btn-primary']"));
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
