package MiniAssignment4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {
    WebDriver driver;
    WebElement price, addToCartBtn, removeBtn, cartIconBtn, cartValueE;
    By filterBtn = By.xpath("//span[@class=\"select_container\"]");
    By filterDropDown = By.xpath("//span[@class=\"select_container\"]//child::select");
    By inventoryItems = By.xpath("//div[@class=\"inventory_list\"]//child::div[@class=\"inventory_item\"]");
    By itemPrice = By.xpath("//div[@class=\"inventory_item_price\"]");
    By addToCart = By.xpath("//button[contains(text(),\"Add to cart\")]");
    By remove = By.xpath("//button[contains(text(),\"Remove\")]");
    By cartIcon = By.xpath("//div[@id=\"shopping_cart_container\"]");
    By cartValue = By.xpath("//span[@class='shopping_cart_badge']");
    By errorMsg = By.xpath("//button[@class=\"error-button\"]//parent::h3");
    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    public void clickFilterBtn(){
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(filterBtn));
        System.out.println(driver.getCurrentUrl());
        WebElement filterUserElement = driver.findElement(filterBtn);
        filterUserElement.click();
    }
    public void selectFilter(String filter){
        Select filterOptions =new Select(driver.findElement(filterDropDown));
        filterOptions.selectByVisibleText(filter);
    }
    public void clickAddToCart(){
        addToCartBtn.click();
    }
    public boolean removeItem(){
        removeBtn = driver.findElement(remove);
        if(!checkRemoveButtonEnabled())
            return checkRemoveButtonEnabled();
        boolean test = removeBtn.isEnabled();
        removeBtn.click();
        return test;
    }
    public boolean checkRemoveButtonEnabled(){
        return removeBtn.isEnabled();
    }
    public boolean verifyItemPriceAndButton(){
        List<WebElement> items = driver.findElements(inventoryItems);
        for (WebElement item: items){
            System.out.println(item.getText());
            price = driver.findElement(new ByChained(inventoryItems, itemPrice));
            addToCartBtn = driver.findElement(new ByChained(inventoryItems, addToCart));
            break;
        }
        System.out.println(addToCartBtn.getText());
        float itemPrice = Float.parseFloat(price.getText().replaceAll("[^\\d.]", ""));
        return addToCartBtn.isEnabled() | itemPrice<100;
    }
    public void clickCartIcon(){
        cartIconBtn = driver.findElement(cartIcon);
        cartIconBtn.click();
    }
    public int getAddedItemsNumber(){
        cartValueE = driver.findElement(cartValue);
        return Integer.parseInt(cartValueE.getText());
    }

}
