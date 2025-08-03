import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;



public class DownloadUploadFiles {

    WebDriver driver;

    @BeforeMethod
    public void openFilesTestPage() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(3000);

    }

    @Test
    public void fileDownloadTest() throws InterruptedException {
        driver.get("https://www.leafground.com/file.xhtml");
       WebElement downloadButton = driver.findElement(By.id("j_idt93:j_idt95"));
       downloadButton.click();
       Thread.sleep(3000);


       //Download file eke eka tiyenwada kiyala check krnwa
        File file = new File("C:\\Users\\INTEL\\Downloads");
        File[] totalFiles = file.listFiles();
        for (File findFile:totalFiles){
            if (findFile.getName().equals("TestLeaf Logo.png")){
                System.out.println("File is downloaded");
                break;
            }

        }

    }

    //file upload -> meka selenuim walin krnna ba, meka java walin thma krnna wenne ,
    //two methods

    //1 way-using robot class

    @Test
            public void fileUpload() throws InterruptedException, AWTException {
        driver.get("https://www.leafground.com/file.xhtml");

        WebElement uploadBtn = driver.findElement(By.id("j_idt88:j_idt89"));
        uploadBtn.click();

        //windows control begin here

      /* String data ="C:\\Users\\INTEL\\Downloads\\TestLeaf Logo.png";
       StringSelection selection = new StringSelection(data);

        //coping to clipboard

    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);

        Thread.sleep(4000);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(4000);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);  */


        // second way using sendKeys

        // second way run krnna nm first way comment krnna oni

        String data ="C:\\Users\\INTEL\\Downloads\\TestLeaf Logo.png";

        WebElement uploadUsingKeys = driver.findElement(By.id("j_idt88:j_idt89_input"));
        uploadUsingKeys.sendKeys(data);


    }










}
