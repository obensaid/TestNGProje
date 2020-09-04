package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest extends TestBase {
    @Test
    public  void  cokluPencereTest(){
        driver.get("https://the-internet.herokuapp.com/windows");

        String sayfaninhandlesi = driver.getWindowHandle();
        System.out.println(sayfaninhandlesi);
        //CDwindow-1D896EF47C2693969B7B0BCBBB0B6EF7

        driver.findElement(By.partialLinkText("Click Here")).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String>tumPencereler = driver.getWindowHandles();
        for (String handle : tumPencereler) {
            System.out.println(handle);
        }
        Object[] array = (Object[]) tumPencereler.toArray();
        String ikinciSayfaHandle = array[array.length - 1].toString();

        driver.switchTo().window(sayfaninhandlesi);

    }

}
