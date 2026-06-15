package com.qa.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

    @Test
    public void openGoogleTest()
            throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        
        String actualTitle =
                driver.getTitle();

        System.out.println(
                "Google Page Title : "
                + actualTitle);

        Assert.assertTrue(
                actualTitle.contains("Google"));

        System.out.println("[PASS] Google Page Opened Successfully");

        driver.quit();
    }
}