package MiniAssignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.logging.Logger;

public class CheckoutPage {
    WebDriver driver;
    WebElement  firstNameE, lastNameE, zipCodeE, continueBtnE, finishE, successMsgE;
    By successMsg = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
    By finishBtn = By.xpath("//*[@id=\"finish\"]");
    By firstName = By.xpath("//*[@id=\"first-name\"]");
    By lastName = By.xpath("//*[@id=\"last-name\"]");
    By zipCode = By.xpath("//*[@id=\"postal-code\"]");
    By continueBtn = By.xpath("//*[@id=\"continue\"]");
    public CheckoutPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterFirstName(String name){
        firstNameE = driver.findElement(firstName);
        firstNameE.sendKeys(name);
    }
    public void enterLastName(String name){
        lastNameE = driver.findElement(lastName);
        lastNameE.sendKeys(name);
    }
    public void enterAddress(String name){
        zipCodeE = driver.findElement(zipCode);
        zipCodeE.sendKeys(name);
    }
    public void clickContinue(){
        continueBtnE = driver.findElement(continueBtn);
        continueBtnE.click();
    }
    public void clickFinish(){
        finishE = driver.findElement(finishBtn);
        finishE.click();
    }
    public void getSuccessMsg(){
        successMsgE =driver.findElement(successMsg);
        System.out.println(successMsgE.getText());
    }

}
