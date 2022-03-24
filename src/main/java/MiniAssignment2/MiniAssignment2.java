package MiniAssignment2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Scanner;


public class MiniAssignment2  {
    private static WebDriver driver;
    private static ChromeOptions options;
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.setProperty("webdriver.chrome.driver", "C:\\Software\\Selenium\\Chrome Driver\\chromedriver.exe");

        System.out.print("1: With GUI\n2: Without GUI\nInput: ");
        int ch = sc.nextInt();
        switch (ch){
            case 1:
                break;
            case 2:
                options = new ChromeOptions();
                options.addArguments("headless");
                break;
            default:
                System.out.println("Invalid number");
        }

        if(options!=null){
            driver = new ChromeDriver(options);
        }else{
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.get("https://phptravels.com/demo");
        String title = driver.getTitle();
        if(title.contains("PHPTRAVELS")){
            System.out.println("Pass: Title contain PHPTRAVELS");
        }else {
            System.out.println("Fail: : Title doesn't contain PHPTRAVELS");
        }
        driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
        Thread.sleep(3000);
        Object[] allWindows = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) allWindows[1]);
        String newTitle = driver.getTitle();
        if(title.compareTo(newTitle)==0){
            System.out.println("Pass: Title same as main page");
        }else {
            System.out.println("Fail: Title not same as main page");
        }
        driver.switchTo().window((String) allWindows[0]);
        String URL = driver.getCurrentUrl();
        System.out.println("Current URL: "+URL);
        driver.findElement(By.xpath("//a[contains(text(),'Pricing')]")).click();
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.quit();


    }
}
