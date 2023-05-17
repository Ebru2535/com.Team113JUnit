package MyStudy;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class WindowHandle extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        //1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        //2."Login Portal" a kadar asagi inin
        WebElement loginPortal=driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));
        Actions actions= new Actions(driver);
        actions.scrollToElement(loginPortal).perform();
        Thread.sleep(2000);
        String WhD1=driver.getWindowHandle();

        //3."Login Portal" a tiklayin
        loginPortal.click();
        //4.Diger window'a gecin
        String ikinciWHD2="";
        Set<String> WHDhandles=driver.getWindowHandles();
        for (String eahandle:WHDhandles
             ) {
            if(!eahandle.equalsIgnoreCase(WhD1)){
                ikinciWHD2=eahandle;
            }
        }
        driver.switchTo().window(ikinciWHD2);

        //5."username" ve "password" kutularina deger yazdirin
        //6."login" butonuna basin
        Faker faker=new Faker();
        WebElement userElementi=driver.findElement(By.id("text"));
        actions.click(userElementi).sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB).perform();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin 8.Ok diyerek Popup'i kapatin
        String expectedSonuc = "validation failed";
        String alertElementi = driver.switchTo().alert().getText();
        Thread.sleep(3000);
        Assert.assertEquals(expectedSonuc, alertElementi);

        //9.Ilk sayfaya geri donun
        driver.switchTo().window(WhD1);

        //10.Ilk sayfaya donuldugunu test edin
        String expectedUrl = "http://webdriveruniversity.com/";
        Assert.assertEquals(expectedUrl, driver.getCurrentUrl());

    }
}












