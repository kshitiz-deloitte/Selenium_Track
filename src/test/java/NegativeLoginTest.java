import MiniAssignment4.LoginPage;
import MiniAssignment4.UserCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class NegativeLoginTest {

    WebDriver driver;
    LoginPage loginPage;
    String url = "https://www.saucedemo.com/";
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
}
