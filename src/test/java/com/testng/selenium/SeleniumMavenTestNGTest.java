package com.testng.selenium;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
 
@Test
public class SeleniumMavenTestNGTest{
 
    private WebDriver driver;
 
    @BeforeTest
    public void startDriver(){
    	FirefoxProfile fp = new FirefoxProfile(new File("C:\\Users\\PJ00366401\\AppData\\Roaming\\Mozilla\\Firefox\\Profiles\\c6ez4ov4.default"));
        driver = new FirefoxDriver(fp);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
 
    @Test
    public void testSearch(){
        driver.navigate().to("http://www.google.com");
 
        String searchString = "Robot Framework";
 
        driver.findElement(By.id("lst-ib")).clear();
        driver.findElement(By.id("lst-ib")).sendKeys(searchString);
 
        assertEquals(driver.findElements(By.xpath("//ul[@class='sbsb_b']/li")).size(),6,
                "Search term not found in search results");
        
        
 
    }
 
    @AfterTest
    public void closeDriver(){
        
        driver.quit();
    }
}