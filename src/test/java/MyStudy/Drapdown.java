package MyStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Drapdown {
    /*
    1. http://zero.webappsecurity.com/ Adresine gidin
    2. Sign in butonuna basin
    3  . Login kutusuna “username” yazin
    4. Password kutusuna “password.” yazin
    5. Sign in tusuna basin
    6. Pay Bills sayfasina gidin
    7. “Purchase Foreign Currency” tusuna basin
    8. “Currency” drop down menusunden Eurozone’u secin
9. “amount” kutusuna bir sayi girin
10. “US Dollars” in secilmedigini test edin
11. “Selected currency” butonunu secin
12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
kontrol edin.
     */

   static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

    }


    @AfterClass
    public static void teardown(){
        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {

        // 2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();


        //    3  . Login kutusuna “username” yazin
        driver.findElement(By.id("user_login")).sendKeys("username");

        //    4. Password kutusuna “password.” yazin
        driver.findElement(By.id("user_password")).sendKeys("password");

        //    5. Sign in tusuna basin
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.navigate().back();

        driver.findElement(By.xpath("//strong[.='Online Banking']")).click();


        //    6. Pay Bills sayfasina gidin
        driver.findElement(By.id("pay_bills_link")).click();

        //    7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//a[.='Purchase Foreign Currency']")).click();

        //    8. “Currency” drop down menusunden Eurozone’u secin
        WebElement curruncyDropDownElementi= driver.findElement(By.id("pc_currency"));
        Select select= new Select(curruncyDropDownElementi);
        select.selectByVisibleText("Eurozone (euro)");

        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.id("pc_amount")).sendKeys("50");

        //10. “US Dollars” in secilmedigini test edin



        Assert.assertTrue(!driver.findElement(By.id("pc_inDollars_true")).isSelected());


        //WebElement usDollarsElementi= driver.findElement(By.id("pc_inDollars_true"));
        //Assert.assertFalse(usDollarsElementi.isSelected());

        Thread.sleep(3000);
        //usDollarsElementi.isSelected();


    }
    @Test
    public void test2(){

        //11. “Selected currency” butonunu secin

        
        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini
        //kontrol edin.
    }



}