package MyStudy;

import com.github.dockerjava.core.exec.ExecStartCmdExec;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class EnableTest {
    @Test
    public void test01() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1. Bir class olusturun : EnableTest
        //2. Bir metod olusturun : isEnabled()
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın

        WebElement textBoxElementi = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBoxElementi.isEnabled());

        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin

        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement itsEnableElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));


        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

        Assert.assertTrue(itsEnableElementi.isDisplayed());

        Thread.sleep(2000);


        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.

        Assert.assertTrue(textBoxElementi.isEnabled());


        driver.close();
    }
    }