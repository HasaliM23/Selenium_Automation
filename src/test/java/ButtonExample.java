import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonExample {

    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/button.xhtml");
    }

    @Test
    public void buttonTest(){

        //Click and Confirm title.

    driver.findElement(By.xpath("//*[@id='j_idt88:j_idt90']")).click();
    String expectedTitle = "Dashboard";
    String actualTitle = driver.getTitle();
    if (expectedTitle.equals(actualTitle)){
        System.out.println("Actual title is same as expected title");
    }
    else {
        System.out.println("actual title not same as expected title");
    }

    //Find the position of the Submit button
        driver.navigate().back();

        WebElement getPosition = driver.findElement(By.id("j_idt88:j_idt94"));
        Point xyPoint = getPosition.getLocation();
        int x = xyPoint.getX();
        int y = xyPoint.getY();

        System.out.println("Element position - X: " + x + ", Y: " + y);


        //Find the Save button color

        WebElement buttonColor = driver.findElement(By.id("j_idt88:j_idt94"));
        String color = buttonColor.getCssValue("background-color");
        System.out.println("Button color is " + color);




    }
}
