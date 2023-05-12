package MyStudy;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class P06_IFrame extends TestBase {
    //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
    //2) sayfadaki iframe sayısını bulunuz.
    //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
    //4) ilk iframe'den çıkıp ana sayfaya dönünüz
    //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız

    @Test
    public void test01() throws InterruptedException {

        //1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz
        driver.get("http://demo.guru99.com/test/guru99home/");

        //2) sayfadaki iframe sayısını bulunuz.
        List<WebElement> sayfadakIframeElementleri=driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki IFrame sayilari :"+sayfadakIframeElementleri.size());

        //3) ilk iframe'deki (Youtube) play butonuna tıklayınız.
        Thread.sleep(3000);
        WebElement iframeElementi=driver.findElement(By.xpath("//iframe[@width='560']"));
        driver.switchTo().frame(iframeElementi);
        driver.findElement(By.xpath("//button[@aria-label='Oynat']")).click();

        //4) ilk iframe'den çıkıp ana sayfaya dönünüz

        driver.switchTo().defaultContent();
        //5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-selenium-project.html) tıklayınız
        WebElement ikinciIframe=driver.findElement(By.id("a077aa5e"));
        driver.switchTo().frame(ikinciIframe);

        driver.findElement(By.tagName("a")).click();
        Thread.sleep(8000);



    }
}