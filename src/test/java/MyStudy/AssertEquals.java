package MyStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class AssertEquals {
    //  Bir class oluşturun: C3_DropDownAmazon
   //  https://www.amazon.com/ adresine gidin.
    //        - Test 1
    //     Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45oldugunu test edin
    //    -Test 2
    //    1. Kategori menusunden Books secenegini secin
   //    2. Arama kutusuna Java yazin ve aratin
    //   3. Bulunan sonuc sayisini yazdirin
    //  4. Sonucun Java kelimesini icerdigini test edin


static WebDriver driver;
    @BeforeClass
    public static void setup1(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(" https://www.amazon.com/ ");
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void test01(){
        //  Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        // Element dropdown menu oldugu icin Select class'indan olusturacagimiz
        // obje ile ilgili method'lari kullanmaliyiz
        WebElement dropdownMenuElementi= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropdownMenuElementi);
        int expectedOptionSayisi=45;
        int actualOptionSayisi= select.getOptions().size();
        Assert.assertEquals(expectedOptionSayisi,actualOptionSayisi);
    }
}