package MiniAssignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    WebDriver driver;
    WebElement continueShoppingBtn, checkoutBtn, cartValueE;
    By cartValue = By.xpath("//span[@class='shopping_cart_badge']");
    By continueShopping = By.xpath("//button[contains(text(),\"Continue Shopping\")]");
    By checkout = By.xpath("//*[@id=\"checkout\"]");
    public CartPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickContinueShoppingBtn(){
        continueShoppingBtn = driver.findElement(continueShopping);
        continueShoppingBtn.click();
    }
    public int getAddedItemsNumber(){
        cartValueE = driver.findElement(cartValue);
        return Integer.parseInt(cartValueE.getText());
    }
    public void clickCheckout(){
        checkoutBtn = driver.findElement(checkout);
        checkoutBtn.click();
    }
}
