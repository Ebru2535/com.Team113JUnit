package MyStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class UploadFile extends TestBase {
    @Test

    public void test01() {

        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

         //3. chooseFile butonuna basalim
       WebElement chooseFleButonu= driver.findElement(By.id("file-upload"));

        //4. Yuklemek istediginiz dosyayi secelim.
      String dosyaYolu="C:\\Users\\ELİF\\Desktop\\ustes5";
      chooseFleButonu.sendKeys(dosyaYolu);

       //5. Upload butonuna basalim.
        driver.findElement(By.id("file-submit"));

        //6. “File Uploaded!” textinin goruntulendigini test edelim
   WebElement result=driver.findElement(By.tagName("h3"));

        Assert.assertTrue(result.isDisplayed());


    }
}