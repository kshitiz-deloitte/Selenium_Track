package MiniAssignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Software\\Selenium\\Chrome Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        Actions action = new Actions(driver);
        WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement droppable = driver.findElement(By.xpath("//div[@id=\"droppable\"]"));
        action.dragAndDrop(draggable, droppable).build().perform();
        Thread.sleep(5000);
        driver.quit();
    }
}
