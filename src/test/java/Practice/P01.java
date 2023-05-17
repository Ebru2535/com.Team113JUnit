package Practice;

import org.junit.*;

public class P01 {
   /* @BeforeClass   // sadece 1 kere çalişir
    @Before // Her testen önce 1 kere çalışır
    @AfterClass // tüm testlerden sonra 1 kere çalışır
    @After  // her testen sonra bir kere çalışır
    @Test // yazacağımız test kodlarının yer aldığı kısım
    */
    @Test
    public void test01(){
        System.out.println("test 01");
    }
    @Test
    public void test02(){
        System.out.println("test 02");
    }

    @Test
    public void test03(){
        System.out.println("test 03");
    }
}
