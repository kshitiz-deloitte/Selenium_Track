package MiniAssignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    By username = By.xpath("//input[@id=\"user-name\"]");
    By password = By.xpath("//input[@id=\"password\"]");
    By loginBtn = By.xpath("//input[@id=\"login-button\"]");
    By errorBtn = By.xpath("//div[@class=\"error-message-container error\"]//child::button");
    By errorMsg = By.xpath("//button[@class=\"error-button\"]//parent::h3");
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
     public void enterUsername(String user){
         WebElement userElement = driver.findElement(username);
         System.out.println(user);
         userElement.sendKeys(user);
     }
    public void enterPassword(String pass){
        WebElement passElement = driver.findElement(password);
        passElement.sendKeys(pass);
    }
    public void clickLogin(){
        WebElement btnElement = driver.findElement(loginBtn);
        btnElement.click();
    }
    public void clickErrorBtn(){
        WebElement errorBtnElement = driver.findElement(errorBtn);
        errorBtnElement.click();
    }
    public String getErrorMsg(){
        WebElement msgElement = driver.findElement(errorMsg);
        return msgElement.getText();
    }
}
