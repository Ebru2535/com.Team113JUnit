package MyStudy;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Action extends TestBase {
    @Test
    public void test01() {
        //1. "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
        //2. "Hover over Me First" kutusunun ustune gelin
        //3. "Link 1" e tiklayin
        Actions actions=new Actions(driver);
        WebElement havorOver=driver.findElement(By.xpath("//div[@class='dropdown hover']"));
        WebElement link1=  driver.findElement(By.xpath("(//a[@class='list-alert'])[1]"));
        actions.moveToElement(havorOver).click(link1).perform(); // hveover yapıp link 1 etıkladım
        //4. Popup mesajini yazdirin
       String linktext= driver.switchTo().alert().getText();

        System.out.println(linktext);

        //5. Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        //6. "Click and hold" kutusuna basili tutun
       WebElement cahElementi= driver.findElement(By.xpath("(//div[@class='col-lg-12 text-center'])[3]"));
       actions.clickAndHold(cahElementi).perform();

        //7. "Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println(cahElementi.getText());

        //8. "Double click me" butonunu cift tiklayin
        WebElement doubleClickMe=driver.findElement(By.xpath("//h2[text()='Double Click Me!']"));
       actions.doubleClick(doubleClickMe).perform();
    }
}