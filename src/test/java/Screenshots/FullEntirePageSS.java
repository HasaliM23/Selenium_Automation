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

import static java.awt.Toolkit.getDefaultToolkit;

public class FullEntirePageSS {
    WebDriver driver;

    @BeforeMethod
    public void openWebPage() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.leafground.com/alert.xhtml");


    }

    //Meken Alert ekk ehema click krama eka click krala pennena eka SS eka wadinwa

    @Test
    public void fullPageScreenShotsTest() throws AWTException, IOException, InterruptedException {

        // 4) capture Screenshot of Full entire screen
        WebElement alertBox = driver.findElement(By.id("j_idt88:j_idt91"));
        alertBox.click();

        // Wait for alert to appear visually
        Thread.sleep(2000); // wait 1 second

        Robot robot = new Robot();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle rectangle = new Rectangle(screenSize);

        BufferedImage source2 = robot.createScreenCapture(rectangle);
        File destinationFile2 = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + "alert_Page_entireScreen.png");
        ImageIO.write(source2, "png", destinationFile2);
    }


}
