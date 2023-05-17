package MyStudy;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DosyaYolu {

    public void test01() throws IOException {


        String dosya = System.getProperty("user.dir") + "/src/test/java/day10_actionsClass_Faker_FileTestleri/deneme.txt";
        FileInputStream fis = new FileInputStream(dosya);  // dosyaya ulaşmak için bunu yapıyoruz

        Workbook workbook= WorkbookFactory.create(fis);
        workbook.getSheet("Sayfa1")
                .getRow(15)
                .getCell(0)
                .toString();



    }
}