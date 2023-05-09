package MyStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test1 {
    WebDriver driver;
    /*
    1. Launch browser

     2. Navigate to url 'http://automationexercise.com
            3. Verify that home page is visible successfully
    4. Click on 'Signup / Login' button
     5. Verify 'Login to your account' is visible
    6. Enter incorrect email address and password
   7. Click 'login' button
    8. Verify error 'Your email or password is incorrect!' is visible

   */
    @Test
    public void Test(){
        mainMethod1();
    driver.findElement(By.xpath("//a[.=' Home']")).isDisplayed();
    driver.findElement(By.xpath("//a[.=' Signup / Login']")).click();
     WebElement loginBuotnu= driver.findElement(By.xpath("/html/body/section/div/div/div[1]/div/h2"));
     Assert.assertTrue(loginBuotnu.isDisplayed());
   WebElement emailButonu=driver.findElement(By.xpath("(//input[@type='email'])[1]"));
   emailButonu.sendKeys("a@gmail.com");
   emailButonu.click();

   WebElement paswordButonu= driver.findElement(By.xpath("//input[@type='password']"));
   paswordButonu.sendKeys("ebru");
   paswordButonu.click();

   driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
   WebElement incorret=driver.findElement(By.xpath("//p[.='Your email or password is incorrect!']"));
        System.out.println("incorret.isDisplayed() = " + incorret.isDisplayed());


    }
    public void mainMethod1(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://automationexercise.com");
    }

}
