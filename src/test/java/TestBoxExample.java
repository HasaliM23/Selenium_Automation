import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestBoxExample {


    WebDriver driver;

    @BeforeMethod
    public void openLinkTestPage() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/input.xhtml");
    }

    @Test
    public void textBoxTests() {

        // Type your name
        WebElement testName = driver.findElement(By.id("j_idt88:name"));
        testName.sendKeys("Hasali Medya");

        // Type your country
        WebElement country = driver.findElement(By.id("j_idt88:j_idt91"));
        country.sendKeys(" Sri Lanka");

        // Verify textbox is enabled (disabled field)
        boolean enabled = driver.findElement(By.id("j_idt88:j_idt93")).isEnabled();
        System.out.println("Is textbox enabled? " + enabled);

        // Clear the text
        WebElement clearText = driver.findElement(By.id("j_idt88:j_idt95"));
        clearText.clear();

        // Retrieve the value
        WebElement findText = driver.findElement(By.id("j_idt88:j_idt97"));
        String value = findText.getAttribute("value");
        System.out.println("Retrieved value: " + value);

        // Type email and press TAB to move to next field
        WebElement email = driver.findElement(By.id("j_idt88:j_idt99"));
        email.sendKeys("hasalimedya12@gmail.com" + Keys.TAB + "confirm control moved to next element");
    }









        //



    }



