package SeleniumWaits;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class ImplicitWaits {

    WebDriver driver;

    @BeforeMethod

    public void openTablePage(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   //page eka 10s athara load wenna oni
        driver.manage().window().maximize();

        driver.get("https://leafground.com/waits.xhtml");
    }



@Test
    public void implicitWaits() throws InterruptedException {



    driver.findElement(By.xpath("//button[@id='j_idt87:j_idt89']")).click();
    String newBtnText = driver.findElement(By.xpath("//button[@id='j_idt87:j_idt90']/span")).getText(); //word eka eliyta gnna kiyna ekata
    // getText() Method use krnawa
    System.out.println("New btn Text is : " + newBtnText);



}
    @AfterMethod
    public  void closeBrowser(){
        driver.quit();
    }
}
