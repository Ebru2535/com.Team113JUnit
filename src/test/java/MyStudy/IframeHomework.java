package MyStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class IframeHomework extends TestBase {
    @Test
    public void test01() throws InterruptedException {

        //1. “http://webdriveruniversity.com/IFrame/index.html” sayfasina gidin
        driver.get("http://webdriveruniversity.com/IFrame/index.html");

        //2. “Our Products” butonuna basin
        driver.switchTo().frame("frame");   // handle ıframe with name or id
        //driver.switchTo().frame(0); -- index numrası ile frame
        driver.findElement(By.xpath("//a[.='Our Products']")).click();


        //3. “Cameras product”i tiklayin
      WebElement cameraElementi= driver.findElement(By.xpath("//p[.='Cameras']"));
      cameraElementi.click();
      Thread.sleep(2000);

        //4. Popup mesajini yazdirin
        WebElement popUpMesaji=driver.findElement(By.xpath("//div[@class='modal-body']"));
        System.out.println(popUpMesaji.getText());

        //5. “close” butonuna basin
        WebElement closeElementi=driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]"));
        closeElementi.click();

        //6. "WebdriverUniversity.com (IFrame)" linkini tiklayin
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("(//a[@class='navbar-brand'])[1]")).click();


        //7. "http://webdriveruniversity.com/index.html" adresine gittigini test edin
        String expectedUrl="http://webdriveruniversity.com/index.html";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

    }
}