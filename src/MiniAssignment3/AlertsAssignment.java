package MiniAssignment3;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsAssignment {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Software\\Selenium\\Chrome Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[contains(text(),'JavaScript Alerts')]")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
        Alert alert = driver.switchTo().alert();
        String txt = driver.switchTo().alert().getText();
        System.out.println("Text of the alert: "+ txt);
        alert.sendKeys("Test");
        alert.accept();
        Thread.sleep(5000);
        driver.quit();
    }
}
