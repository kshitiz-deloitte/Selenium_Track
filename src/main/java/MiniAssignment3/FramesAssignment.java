package MiniAssignment3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAssignment {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Software\\Selenium\\Chrome Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[22]/a")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        System.out.println("Title: "+ driver.getTitle());
        driver.quit();
    }
}
