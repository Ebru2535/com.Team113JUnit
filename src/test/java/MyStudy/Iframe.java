package MyStudy;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Iframe extends TestBase {
    @Test
    public void test1() throws InterruptedException {

driver.get("https://the-internet.herokuapp.com/iframe");
    // tagname unıq old.imin lockedini aldık tagname ile
        WebElement ifFrameElementi=driver.findElement(By.tagName("h3"));
        // oradan çıkan yazı görnür olup olamdığını test ettk - is displayed
        Assert.assertTrue(ifFrameElementi.isDisplayed());
        // bunu yazdırmak için get text metdodunu kullanırım
        System.out.println("ifFrameElementi.getText() = " + ifFrameElementi.getText());

   // locked ettiğim yazı iframe nın içinde olduğu için direk alamadım oaraya geçiş yapmam lazım
        WebElement frameElementi= driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);

        WebElement yazi=driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        yazi.clear();
       yazi.sendKeys("Merhaba Dünya");
        Thread.sleep(3000);

    }



}
