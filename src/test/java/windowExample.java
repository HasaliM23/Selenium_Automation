import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class windowExample {

    WebDriver driver;

    @BeforeMethod
    public void windowsTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/window.xhtml");
}

@Test
public void windowsTest() throws InterruptedException {

        //1) Click and Confirm new Window Opens


    String oldWindow = driver.getWindowHandle();
    System.out.println("Parent window : " + oldWindow);

    WebElement openButton = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
    openButton.click();
    Thread.sleep(3000);

    Set<String> handles = driver.getWindowHandles();
    System.out.println("handles size " + handles.size());


       //First Method Using Foreach loop

   // for (String newWindow : handles) {
    //    System.out.println(newWindow);
     //   driver.switchTo().window(newWindow);
     //   System.out.println("page title is : " + driver.getTitle());
    // }

    // driver.close();

      //driver.switchTo().window(oldWindow);

        //second method Using List


    List<String> list = new ArrayList<String>(handles);  //Converting Set to List
    if (list.size() > 1) {
        driver.switchTo().window(list.get(1));
        System.out.println("child tab title is : " + driver.getTitle());
        driver.close();
        driver.switchTo().window(oldWindow);
    }

    WebElement openButton1 = driver.findElement(By.xpath("//*[@id='j_idt88:new']/span"));
    boolean openbuttonVisibility = openButton1.isDisplayed();
    System.out.println("Open button Visibility " + openbuttonVisibility);

        //2)Find the number of opened tabs

     WebElement multiOpenWindow = driver.findElement(By.xpath("//*[@id='j_idt88:j_idt91']"));
     multiOpenWindow.click();
     Thread.sleep(3000);

     Set<String> multiWindowHandle = driver.getWindowHandles();
     int howManyWindow= multiWindowHandle.size();
    System.out.println("No of open windows " + howManyWindow);

        //3)Close all windows except Primary

    WebElement dontClose = driver.findElement(By.id("j_idt88:j_idt93"));
    dontClose.click();
    Thread.sleep(3000);

    Set<String> newWindowHandle = driver.getWindowHandles();
    for (String allwindows : newWindowHandle) {
        if (!allwindows.equals(oldWindow)){
            driver.switchTo().window(allwindows);
            driver.close();
        }
    }

    driver.quit();

    //driver.close() ---> close single browser window driver which one focus
    //driver.quit() ----> close all browser







    }
}