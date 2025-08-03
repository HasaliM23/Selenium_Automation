import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class FrameExample {

    WebDriver driver;

    @BeforeMethod
    public void frameTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/frame.xhtml");
    }


    @Test
    public void frameTests(){

        // 1) Click Me (Inside Frame)

        driver.switchTo().frame(0);
        WebElement frameClick = driver.findElement(By.xpath("//button[@id='Click']"));
        frameClick.click();
        String afterClickButton = frameClick.getText();
        System.out.println("After click button show me inside text " + afterClickButton);



        //2) click me (Nested Frame)

        driver.switchTo().defaultContent();

        driver.switchTo().frame(2);
        driver.switchTo().frame("frame2");

        WebElement button3= driver.findElement(By.id("Click"));
        button3.click();

        String afterClickNestedFrameButtonText = button3.getText();
        System.out.println("After Click Inside Nested Frame Button Text : " + afterClickNestedFrameButtonText);





        // How many frames in this page?


        driver.switchTo().defaultContent();

        List<WebElement> getIframeTagCount =  driver.findElements(By.tagName("iframe"));
        int size = getIframeTagCount.size();
        System.out.println("Iframe tag count : " + size);

        for (WebElement iframeElemnt :getIframeTagCount) {
            String frameSRCattributrValue=iframeElemnt.getAttribute("src");
            System.out.println("frame src attribute value : " + frameSRCattributrValue);
        }




    }





}
