package MyStudy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeClass;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Tekrar extends TestBaseBeforeClass {
    @Test
    public void test01() {
        //Test01 :
        //1- amazon gidin
        driver.get("https://www.amazon.com.tr/");
        //2- Arama kutusunun solundaki dropdown menuyu handle edip listesini ekrana yazdırın
        List<WebElement> ddm1 = driver.findElements(By.xpath("//option"));
        for (WebElement webElement : ddm1) {
            System.out.println(webElement.getText());
        }
        //3- dropdown menude 40 eleman olduğunu doğrulayın
        WebElement ddm = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(ddm);
        int menu = 40;
        int actualmenu = select.getOptions().size();
        Assert.assertEquals(menu, actualmenu);

    }

    @Test
    public void test02() throws InterruptedException {
        //Test02
        driver.get("https://www.amazon.com.tr/");
        //1- dropdown menuden elektronik bölümü seçin
        // WebElement ddm= driver.findElement(By.id("searchDropdownBox"));
        //  Select select=new Select(ddm);


        Thread.sleep(3000);

        driver.findElement(By.xpath("//input[@name='accept']")).click();
        Thread.sleep(3000);
        //select.selectByVisibleText("Elektronik");
        WebElement elektronikElementi = driver.findElement(By.xpath("//option[.='Elektronik']"));
        elektronikElementi.click();

        //2- arama kutusuna iphone yazip aratin ve bulunan sonuç sayısını yazdırın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("iphone");
        aramaKutusu.submit();
        Thread.sleep(3000);
        WebElement aramaSayisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String aramasonucu = aramaSayisi.getText();
        String[] s = aramasonucu.split(" ");
        System.out.println(Arrays.toString(s));
        System.out.println("iphone arama sonuc sayısı : " + s[0]);


        //3- sonuc sayisi bildiren yazinin iphone icerdigini test edin
        WebElement aramaSayisi1 = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedBaslik = "iphone";
        String actualBaslik = aramasonucu;
        Assert.assertTrue(actualBaslik.contains(expectedBaslik));
        //4- ikinci ürüne relative locater kullanarak tıklayin
        WebElement birinciurun = driver.findElement(By.xpath("(//a[@aria-hidden='true'])[7]"));
        WebElement ikinciurun = driver.findElement(RelativeLocator.with(By.tagName("div")).toRightOf(birinciurun));
        ikinciurun.click();


        //5- ürünün title'ni ve fiyatını variable’a assign edip ürünü sepete ekleyelim
        WebElement title = driver.findElement(By.xpath("  //span[.='        Apple iPhone 14 Pro (128 GB) - Koyu Mor       ']   "));
        String title1 = title.getText();

        WebElement fiyat = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[6]"));
        String fiyat1 = fiyat.getText();
        driver.findElement(By.xpath("(//input[@name='submit.add-to-cart'])[1]")).click();

    }

    @Test
    public void test03() throws InterruptedException {
        //Test03
        driver.get("https://www.amazon.com.tr/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='accept']")).click();
        //1- yeni bir sekme açarak amazon anasayfaya gidin
        String ilkHandle=driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        Thread.sleep(2000);

        Set<String> handles=driver.getWindowHandles();
        String ikinciHandle="";
        for (String each:handles
             ) {
            if(!each.equals(ilkHandle)){
                ikinciHandle=each;
            }
            driver.switchTo().window(ikinciHandle);
        }
        //2-dropdown’dan bebek bölümüne secin
        driver.switchTo().window(ilkHandle);
        Thread.sleep(2000);
      WebElement kategori=  driver.findElement(By.id("searchDropdownBox"));
      Select select=new Select(kategori);
      select.selectByVisibleText("Bebek");
      Thread.sleep(2000);

        //3-bebek puset aratıp bulundan sonuç sayısını yazdırın
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("bebek puset arabası"+ Keys.ENTER);
       WebElement sonuc= driver.findElement(By.xpath("//span[.='2.000 üzeri sonuç arasından 1-24 arası gösteriliyor. Aranan ürün:']"));
        System.out.println("sonuc.getText() = " + sonuc.getText());
        //4-sonuç yazsının puset içerdiğini test edin

        String expectedsonuc="puset";
        String actualsonuc=sonuc.getText();
        Assert.assertFalse(actualsonuc.contains(expectedsonuc));
        //5-üçüncü ürüne relative locater kullanarak tıklayin
        WebElement ucuncUrun=driver.findElement(By.xpath("(//a[@class='a-link-normal s-no-outline'])[3]"));
        WebElement ıkıncıUrun=driver.findElement( RelativeLocator.with(By.tagName("div")).toLeftOf(ucuncUrun));
        ıkıncıUrun.click();



        //6-title ve fiyat bilgilerini assign edelim ve ürünü sepete ekleyin
        WebElement title= driver.findElement(By.xpath("//span[@id='productTitle']"));

        //Test 4
        //1-sepetteki ürünlerle eklediğimiz ürünlerin aynı olduğunu isim ve fiyat olarak doğrulayı
    }
}
