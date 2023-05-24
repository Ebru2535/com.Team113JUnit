package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.Watchable;
import java.time.Duration;

public class P04 {
    // İlgili kurumları tamamlayalım
    // kullanıcı https://www.google.com adresine gider
    // cıkıyorsa kullanıcı cookies i kabul eder
    // arama kutusuna karsilaştırma yapmak istediği para birimini girer
    // para birimelerinin karşılaştırmasını alın
    // karşılastırılacak olan para biriminin 25 den küçük olduğu test edilir

     static WebDriver driver;

    // İlgili kurumları tamamlayalım
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

@Test
    public void paraKarsilastir(){
        driver.get("https://www.google.com");
    // arama kutusuna karsilaştırma yapmak istediği para birimini girer
    WebElement searchBox=driver.findElement(By.xpath("//*[@name='q']"));
    searchBox.sendKeys("USD TO TL"+ Keys.ENTER);

    // para birimelerinin karşılaştırmasını alın
    WebElement resultElementi=driver.findElement(By.xpath("//*[@class='DFlfde SwHCTb']"));
    String result=resultElementi.getText().replace(",","."); // noktoyı anlamdığı için virgiüle çevirdim
    double resultDouble=Double.parseDouble(result);

    Assert.assertTrue(resultDouble<25);

    if(resultDouble<25){
        System.out.println("suan 25 in altında");
    }



}



}
