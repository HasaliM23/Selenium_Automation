import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class BrokenImage {

    WebDriver driver;

    @BeforeMethod
    public void frameTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test

    public void findBrokenImage(){
        driver.get("https://the-internet.herokuapp.com/broken_images");

        List<WebElement> images = driver.findElements(By.xpath("//div[@class='example']/img"));

        // image ekak broken da ndda balanna puluwan method ekk tiyenwa, a kiynne element wala tiyenwa hangichcha attribute
        // ekk "naturalWidth" naturalWidth =0 nam a element eka broken image ekaki

        int i =1;
        for (WebElement image:images){
            if (image.getAttribute("naturalWidth").equals("0")){
                System.out.println("Image: " + i + "is Broken");
            }
            else{
                System.out.println("Image: " + i + "is not Broken");
            }

            i++;
        }


    }


    @Test
    public void brokenImageTestTwo(){
        driver.get("https://demoqa.com/broken");
        WebElement brokenImages = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/img[2]"));

        if (brokenImages.getAttribute("naturalWidth").equals("0")){
            System.out.println("Image:is Broken");

        }
        else{
            System.out.println("Image: is not Broken");
        }



    }

}
