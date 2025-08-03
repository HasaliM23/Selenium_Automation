import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutorExample {
    WebDriver driver;
    JavascriptExecutor jsExecutor;

    @BeforeMethod
    public void openJSExecutorPage() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");
        Thread.sleep(3000);
    }

    @Test
    public void jsExecutorTests() throws InterruptedException{


        jsExecutor = (JavascriptExecutor) driver;

        //1) Get a Alert Box in to Web page using javaScript

        //jsExecutor.executeScript("alert('My name is hasali');");

        //2) Set a input value in a text box using javascriptExecutor
        //2.1) - way 1 > Set the value using the value property (common approach)

        WebElement inputNameTextBox = driver.findElement(By.xpath("//input[@id='name']"));
        //jsExecutor.executeScript("arguments[0].value='Learn with Hashir';", inputNameTextBox);

        //2.2) - way 2 > Set the value using setAttribute (alternative approach)
        jsExecutor.executeScript("arguments[0].setAttribute('value', 'Hasali Medya');", inputNameTextBox);

        Thread.sleep(4000);


        //3) Highlight element
        jsExecutor.executeScript("arguments[0].style.border='3px solid red';", inputNameTextBox);
        jsExecutor.executeScript("arguments[0].style.background='yellow';", inputNameTextBox);

        Thread.sleep(4000);

        //4) Click element using javascriptExecutor
        WebElement maleCheckBox=driver.findElement(By.xpath("//input[@id='male']"));
        jsExecutor.executeScript("arguments[0].click();", maleCheckBox);

        Thread.sleep(4000);


        //5) Scrolling the Page
        scrollPage();

        //6) Get all attributes from a wanted element
        getAllAttributes(inputNameTextBox);





    }

    public void scrollPage() throws InterruptedException{
        //5.1) scroll to some position

        jsExecutor.executeScript("window.scrollTo(0, 1000);");  //verically pixel 1000k down krnna(pahalata yanna)
        System.out.println("Current pageYOffset value is : " + jsExecutor.executeScript("return window.pageYOffset;"));

        jsExecutor.executeScript("window.scrollTo(0, -1000);"); // meka aye mulatama enna kiyala kiynne
        Thread.sleep(5000);


        //5.2) scroll to Bottom of the page by pixel Number

        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);"); //pahalatama scroll wenwa
        Thread.sleep(5000);

        //5.3) Scroll to the top of the page

        jsExecutor.executeScript("window.scrollTo(0, 0);"); // page eka udatama enwa (Top of the page )
        Thread.sleep(5000);

        //5.4) Scroll the page till element is visible
        WebElement scrollintoElemnt = driver.findElement(By.xpath("//label[text()='Gender:']")); // element ekak lagata
        // scroll wenna kiyala methana kiynne
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", scrollintoElemnt);



    }

    //

    public String getAllAttributes(WebElement webElement) {
        Object elementAttributes = jsExecutor.executeScript(
                "var items = {}; for (index = 0; index < arguments[0].attributes.length; ++index) { items[arguments[0].attributes[index].name] = arguments[0].attributes[index].value }; return items;",
                webElement);
        System.out.println("All Attribute value are : " + elementAttributes.toString());
        return elementAttributes.toString();
    }


}
