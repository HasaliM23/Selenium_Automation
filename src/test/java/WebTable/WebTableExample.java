package WebTable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableExample {

    WebDriver driver;

    @BeforeMethod
    public void frameTestPage() throws InterruptedException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        Thread.sleep(3000);
    }

    @Test
    public void webTableTest() throws InterruptedException {

        //how many rows in the table

        int rowCount = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr")).size();
        System.out.println("Row Count: " + rowCount);

        //how many columns in the table

        int columnCount = driver.findElements(By.xpath("//table[@id='productTable']/thead/tr/th")).size();
        System.out.println("Column Count: " + columnCount);

        //Retrive the specific row/columns

        String value = driver.findElement(By.xpath("//*[@id='productTable']/tbody/tr[4]/td[3]")).getText();//copy xpath ekak meka
        System.out.println("Specfic row/columns is: " + value);


        //retrive all data of table

        for (int i = 1; i <= rowCount; i++) {   // Rows
            for (int j = 1; j <= columnCount; j++) {    // Columns
                String tblData = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[" + j + "]")).getText();
                System.out.print(tblData + "  ");
            }
            System.out.println();
        }

        //print ID nad Name Only
        for (int i = 1; i <= rowCount; i++) {
            String tblId = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[1]")).getText();
            String tblProductName = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[2]")).getText();
            System.out.println("Tbl id: " + tblId + "\tProduct Name: " + tblProductName);


            if (tblProductName.equals("Product 3")) {
                String productPrice = driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td[3]")).getText();
                System.out.println(tblProductName + "Relevent product price is : " + productPrice);
                break;
            }
        }

        // Select all the checkBoxes

        int pageCount = driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
        List<WebElement> pages =  driver.findElements(By.xpath("//ul[@id='pagination']/li"));

        for (int k=0; k<pageCount; k++){
            pages.get(k).click();
            Thread.sleep(1000);
            for(int i=1; i<=rowCount; i++){
                boolean atb=driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[4]/input")).isSelected();
                if (!atb){
                    driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+i+"]/td[4]/input")).click();
                    Thread.sleep(300);
                }
            }
        }


        //Select one checkbox

        int tblRow= 1;
        driver.findElement(By.xpath("//table[@id='productTable']/tbody/tr["+tblRow+"]/td[4]/input")).click();















    }


    }
