import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownExample {



    WebDriver driver;

    @BeforeMethod
    public void dropDownTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/select.xhtml");
    }


    //1.1) ways of select values in Basic dropdown
@Test
  public void dropDownTest(){

       WebElement dropdown = driver.findElement(By.xpath("//select[@class ='ui-selectonemenu']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        select.selectByVisibleText("Selenium");

        //using sendkeys select the dropdown

    dropdown.sendKeys("cypress");

    //selecting value is bootsrap dropdown

  WebElement dropDown2 = driver.findElement(By.xpath("//div[@id='j_idt87:country']"));
  dropDown2.click();
  List<WebElement> listofdropdownvalue2= driver.findElements(By.xpath("//ul[@id='j_idt87:country_items']/li"));
   for (WebElement element :listofdropdownvalue2){
       String dropdownvalue =element.getText();
       if (dropdownvalue.equals("USA")){

           element.click();
           break;
       }
   }








    }
}
