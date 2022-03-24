package MiniAssignment3;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FlightBooking {

    static WebDriver driver;
    public static void locationSelection(String fromTo,String xpath, String location){
        try{
            driver.findElement(By.xpath("//span[contains(text(),'"+fromTo+"')]//parent::div")).click();
        }catch (Exception e){
            System.out.println("Testing");
        }
        driver.findElement(By.xpath(xpath)).sendKeys(location);
        List<WebElement> myList = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='autoSuggest-list']//child::li")));
        for (WebElement element : myList){
            if (element.getText().contains(location)){
                element.click();
                break;
            }
        }
    }
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver", "C:\\Software\\Selenium\\Chrome Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://www.goibibo.com/");
        driver.findElement(By.xpath("//span[contains(text(),\"Round-trip\")]//ancestor::li")).click();
        locationSelection("From","//span[contains(text(),'From')]//following::input","New York");
        locationSelection("To","//span[contains(text(),'To')]//following::input","Seattle");
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='DayPicker Range']")));
        while (true) {
            try {
                driver.findElement(By.xpath("//div[contains(text(),\"June\")]"));
                driver.findElement(By.xpath("//div[@aria-label='Fri Jun 24 2022']//p")).click();
                break;
            } catch (Exception e) {
                driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
            }
        }


        driver.findElement(By.xpath("// span [contains(text(),\"Return\")]//parent::div[@role=\"presentation\"]")).click();
        while (true) {
            try {
                driver.findElement(By.xpath("//div[contains(text(),'July')]"));
                break;
            } catch (Exception e) {
                driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
            }
        }
        driver.findElement(By.xpath("//div[@aria-label='Fri Jul 08 2022']//p")).click();
        driver.findElement(By.xpath("//span[contains(text(),\"Done\")]")).click();
        driver.findElement(By.xpath("//a[contains(text(),\"Done\")]")).click();
        driver.findElement(By.xpath("//span[contains(text(),\"SEARCH FLIGHTS\")]")).click();
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File srcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File destFile=new File("test.png");
        FileHandler.copy(srcFile, destFile);
        driver.findElements(By.xpath("//button[contains(text(),\"BOOK\")]")).get(0).click();
        Thread.sleep(3000);
        driver.quit();

    }
}
