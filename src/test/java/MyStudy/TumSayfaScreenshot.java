package MyStudy;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class TumSayfaScreenshot extends TestBase {
    @Test
    public void test01() throws IOException {
        driver.get("https://www.amazon.com");
        // Nutella icin arama yapalim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
WebElement sonucElementi=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));

String actualSonucYazisi= sonucElementi.getText();
String expectedIcerik="Nutella";
        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

        TakesScreenshot tss= (TakesScreenshot) driver;

        File tumsayfaResim=new File("target/ekranResimleri/tumSayfaResim.png");

        File geciciResim=tss.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(geciciResim,tumsayfaResim);






    }
}
