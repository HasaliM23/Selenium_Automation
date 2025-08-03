package Screenshots;



import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class TakeScreenShotsExamples {
    WebDriver driver;

    @BeforeMethod
    public void openWebPage() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");


    }

    @Test
    public void takeScreenshotTests() throws IOException, AWTException {

        //caputre screnshot full page

  /*      TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
       File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
       //C:\Users\INTEL\IdeaProjects\Selenium_Automation\Screenshots
       File destinationFile = new File(System.getProperty("user.dir") + "\\ScreenShot\\"+ "alert_full_web_page.png");
       FileHandler.copy(sourceFile,destinationFile);



        //2) capture Screenshot of Section of  a Web Page

        WebElement section1pageElement = driver.findElement(By.xpath("//*[@id='j_idt88']/div/div[1]"));
        File source = section1pageElement.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + "alert_section_of_the_Page.png");
        FileUtils.copyFile(source, target);


        //3) capture Screenshot of an Element on a  Web Page

        WebElement elementOfThePage = driver.findElement(By.xpath("//*[@id='j_idt88']/div/div[1]/div[1]"));
        File source1 = elementOfThePage.getScreenshotAs(OutputType.FILE);
        File target1 = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + "alert_element_of_the_Page.png");
        FileUtils.copyFile(source1,target1);  */



        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();

        Robot robot = new Robot();
        Dimension scrennSize = Toolkit.getDefaultToolkit().getScreenSize();
        java.awt.Rectangle rectangle = new Rectangle(scrennSize); //rectangele size screen tiyena nisa

        BufferedImage source2 = robot.createScreenCapture(rectangle); //rectangle eken ghnna
        File destinationFile2 = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + "alert_Page_entireScreen.png");
        ImageIO.write(source2,"png",destinationFile2);

    }










}
