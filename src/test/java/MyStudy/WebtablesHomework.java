package MyStudy;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class WebtablesHomework extends TestBase {

    //        //Bir Class olusturun D19_WebtablesHomework

    @Test
    public void test01() {
        //        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");
        //        //2. Headers da bulunan basliklari yazdirin
        List<WebElement> baslik=driver.findElements(By.xpath("//div[@role='columnheader']"));

        for (WebElement baslikeach:baslik
             ) {
            System.out.println(baslikeach.getText());
        }
        //        //3. 3.sutunun basligini yazdirin
        String ucuncuBaslik=driver.findElement(By.xpath("//div[@role='columnheader'][3]")).getText();
        System.out.println(ucuncuBaslik);

        System.out.println(baslik.get(2).getText());
        //        //4. Tablodaki tum datalari yazdirin

List<WebElement> data=driver.findElements(By.xpath("//div[@role='gridcell']"));
int bosOlmayanDatasayisi=0;
        for (WebElement listeach:data
             ) {
            if(!listeach.getText().isBlank())
            System.out.println(listeach.getText());
            bosOlmayanDatasayisi++;
        }
        //        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("tabloda boş olmayan hucre sayısı:"+bosOlmayanDatasayisi);
        //        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> satirlarList=driver.findElements(By.xpath("//div[@role='rowgroup']"));
        System.out.println("tablodaki satır sayısı: "+satirlarList.size());
        //        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("tablodaki sutun sayısı:"+baslik.size());


        //        //8. Tablodaki 3.kolonu yazdirin
        //List<WebElement>ucuncuSutunElementi=driver.findElements(By.xpath("//div[@role='row']/div));
        //        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        //        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //        //sayisini girdigimde bana datayi yazdirsin
    }
    //}

}
