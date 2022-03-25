import MiniAssignment4.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class SwagLabsTest {
    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    CartPage cartPage;
    int laterNum = 0;
    String url = "https://www.saucedemo.com/";
    boolean condition = true;
    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Software\\Selenium\\Chrome Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Test(priority = 1)
    public void enterUserDetails() throws FileNotFoundException {
        loginPage = new LoginPage(driver);
        UserCredentials userCredentials = new UserCredentials();
//        loginPage.enterUsername("TEts");
//        loginPage.enterPassword("Tests");
        loginPage.enterUsername(userCredentials.getUsername());
        loginPage.enterPassword(userCredentials.getPassword());

    }
    @Test(priority = 2)
    public void validateLogin(){
        loginPage = new LoginPage(driver);
        loginPage.clickLogin();
    }

    @Test(priority = 3)
    public void addToCart(){
        mainPage = new MainPage(driver);
        mainPage.clickFilterBtn();
        mainPage.selectFilter("Price (high to low)");
        condition = mainPage.verifyItemPriceAndButton();
        mainPage.clickAddToCart();
    }
    @Test(priority = 4)
    public void remove(){
        mainPage = new MainPage(driver);
        mainPage.removeItem();
    }
    @Test(priority = 5)
    public void addToCartAfterRemove(){
        mainPage = new MainPage(driver);
        mainPage.clickFilterBtn();
        mainPage.selectFilter("Price (high to low)");
        condition = mainPage.verifyItemPriceAndButton();
        mainPage.clickAddToCart();
    }
    @Test(priority = 6)
    public void clickCart(){
        mainPage = new MainPage(driver);
        mainPage.clickCartIcon();
    }
    @Test(priority = 7)
    public void clickContinueShopping(){
        cartPage = new CartPage(driver);
        cartPage.clickContinueShoppingBtn();
    }
    @Test(priority = 8)
    public void addToCheapProdCart() throws Throwable {
        mainPage = new MainPage(driver);
        mainPage.clickFilterBtn();
        mainPage.selectFilter("Price (low to high)");
        condition = mainPage.verifyItemPriceAndButton();
        int initNum = mainPage.getAddedItemsNumber();
        mainPage.clickAddToCart();
        laterNum = mainPage.getAddedItemsNumber();
        if(initNum == laterNum){
            driver.navigate().refresh();
        }
        mainPage.clickCartIcon();
    }
    @Test(priority = 9)
    public void checkValueNumber() throws Throwable {
        cartPage = new CartPage(driver);
        int cartNum = cartPage.getAddedItemsNumber();
        if (cartNum != laterNum){
            condition = false;
            afterMethod();
        }
    }
    @Test(priority = 10)
    public void clickCheckOut(){
        cartPage = new CartPage(driver);
        cartPage.clickCheckout();
    }
    @Test(priority = 11)
    public void proceedCheckOut() throws FileNotFoundException {
        CheckoutPage checkoutPage= new CheckoutPage(driver);
        UserDetails userDetails = new UserDetails();
        checkoutPage.enterFirstName(userDetails.getFirstName());
        checkoutPage.enterLastName(userDetails.getLastName());
        checkoutPage.enterAddress(userDetails.getAddress());
        checkoutPage.clickContinue();
    }
    @Test(priority = 12)
    public void finishAndGetSuccessMethod(){
        CheckoutPage checkoutPage= new CheckoutPage(driver);
        checkoutPage.clickFinish();
        checkoutPage.getSuccessMsg();

    }






    @AfterMethod
    public void afterMethod() throws Throwable {
        System.out.println("in after method");
        if(!condition)
        {
            afterClass();
        }
    }

    @AfterClass
    public void afterClass() throws Throwable {
        System.out.println("in after class ");
        driver.quit();
        System.exit(0);
    }
}
