package com.techproed.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JSAlertTest {
    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void jsAlertTest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//<button onclick="jsAlert()">Click for JS Alert</button>

        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button.click();
        String alertMesaji = driver.switchTo().alert().getText();
        System.out.println(alertMesaji);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();
    }

    @Test
    public void jsConfirmIest() {
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //<button onclick="jsConfirm()">Click for JS Confirm</button>
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        button.click();
        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().dismiss();
    }


    @Test
    public void jsPromtTest() {
        //<button onclick="jsPrompt()">Click for JS Prompt</button>
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        button.click();
        String mesaj = driver.switchTo().alert().getText();
        System.out.println(mesaj);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().sendKeys("selamun aleykum");
        driver.switchTo().alert().accept();

    }

    @Test
    public void iframeTest() {
        driver.get("https://the-internet.herokuapp.com/iframe");
     //<p>Your content goes here.</p>

        driver.switchTo().frame(0);
     WebElement  paragraf = driver.findElement(By.xpath("//p"));
     paragraf.clear();
     paragraf.sendKeys("merhaba iframe");
    }

    @Test
    public void iFrameTest2(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame("mce_0_ifr");
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("selenium aleykum");

    }

    @Test
    public void iFrameTest3(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement iFrame = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrame);
        WebElement paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("selenium aleykum");

    }

    @Test
    public void iframeTest4() {
        driver.get("https://the-internet.herokuapp.com/iframe");
        //<p>Your content goes here.</p>

        driver.switchTo().frame(0);
        WebElement  paragraf = driver.findElement(By.xpath("//p"));
        paragraf.clear();
        paragraf.sendKeys("merhaba iframe");

        driver.switchTo().defaultContent();

        WebElement slnium = driver.findElement(By.partialLinkText("Elemental Selenium"));
        slnium.click();
    }

}
