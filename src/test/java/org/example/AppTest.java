package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.util.List;
import java.util.ResourceBundle;

import static org.apache.commons.lang3.CharSetUtils.count;
import static org.testng.TestNGAntTask.Mode.junit;

public class AppTest {

    WebDriver driver;

    @BeforeClass
    @Parameters({"browser","url"})

    void setUpDriver(String browser,String link){
        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.get(link);
        driver.manage().window().maximize();
    }

    @Test
    public void googleTest() throws InterruptedException {
        ResourceBundle r =ResourceBundle.getBundle("config");
        String username=r.getString("username");
        String password=r.getString("password");

        driver.findElement(By.name("username")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys(password);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[3]/button/div")).click();
        Thread.sleep(10000);

        driver.findElement(By.xpath("//button[contains(text(),'Save Info')]")).click();
        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div/div[1]/div/div[2]/div/div/div/div/div[2]/div/div/div[3]/button[2]")).click();
        Thread.sleep(5000);

        driver.findElement(By.linkText("Search")).click();
        Thread.sleep(5000);

        driver.findElement(By.className("_aauy")).sendKeys("lpu");
        Thread.sleep(5000);

        driver.findElement(By.partialLinkText("lpuuniversity")).click();
        Thread.sleep(5000);
    }

    @AfterClass
    void close(){
        driver.close();
    }


}



