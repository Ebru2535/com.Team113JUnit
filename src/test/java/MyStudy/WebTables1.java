package MyStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class WebTables1 extends TestBase {

    //1."https://www.amazon.com" adresine gidin
    @Test
    public void test01() {
        driver.get("https://www.amazon.com");

        //2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).perform();
        //3.Web table tum body’sini yazdirin
        WebElement tumbody = driver.findElement(By.tagName("tbody"));
        System.out.println(tumbody.getText());
        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> satırElementi = driver.findElements(By.xpath("//tbody/tr"));

        int excepted = 10;
        int actual = satırElementi.size();
        Assert.assertEquals(excepted, actual);

        //5.Tum satirlari yazdirin

        for (WebElement each : satırElementi
        ) {
            System.out.println(each.getText());
            System.out.println("----------");
        }

        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement> sutunsayisi = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int beklenen = 14;
        int sonuc = sutunsayisi.size();
        Assert.assertEquals(beklenen, sonuc);
        //7. 5.sutunu yazdirin
        List<WebElement> sutunsayisi5 = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement each1 : sutunsayisi5
        ) {
            System.out.println(each1.getText());
        }

        //8.Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi
        //döndüren bir method olusturu

    }
}
