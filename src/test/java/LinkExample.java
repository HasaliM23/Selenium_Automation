import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LinkExample {


    WebDriver driver;

@BeforeMethod
 public void openLinkTestPage(){

     driver = new ChromeDriver();
     driver.manage().window().maximize();
    driver.get("https://leafground.com/link.html");

}

    @Test
    public void LinkTest(){
     WebElement homeLink = driver.findElement(By.linkText("Go to Dashboard"));
     homeLink.click();
     driver.navigate().back();



    }
}
