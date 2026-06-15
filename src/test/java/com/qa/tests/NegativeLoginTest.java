package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.LoginPage;

public class NegativeLoginTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void startSetup() {

        setupBrowser();

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {

        closeBrowser();
    }

    // ==========================================
    // 1. Invalid Username + Valid Password
    // ==========================================

    @Test
    public void invalidUsernameTest(){
            
        String loginURL = driver.getCurrentUrl();

        loginPage.enterEmail("wrong@test.com");

        loginPage.enterPassword("Test@123");

        loginPage.clickLogin();

        
        Assert.assertEquals(
                driver.getCurrentUrl(),
                loginURL);

        System.out.println("[PASS] Invalid Username Test Passed");

        System.out.println(
                "Displayed Error : "
                + loginPage.getErrorMessage());
    }

    // ==========================================
    // 2. Valid Username + Invalid Password
    // ==========================================

    @Test
    public void invalidPasswordTest(){            

        String loginURL = driver.getCurrentUrl();

        loginPage.enterEmail(
                "jabdul@thoughtlinetech.com");

        loginPage.enterPassword("Wrong123");

        loginPage.clickLogin();

        
        Assert.assertEquals(
                driver.getCurrentUrl(),
                loginURL);

        System.out.println("[PASS] Invalid Password Test Passed");

        System.out.println(
                "Displayed Error : "
                + loginPage.getErrorMessage());
    }

    // ==========================================
    // 3. Invalid Username + Invalid Password
    // ==========================================

    @Test
    public void invalidUsernamePasswordTest(){
          

        String loginURL = driver.getCurrentUrl();

        loginPage.enterEmail("wrong@test.com");

        loginPage.enterPassword("wrong123");

        loginPage.clickLogin();

        
        Assert.assertEquals(
                driver.getCurrentUrl(),
                loginURL);

        System.out.println("[PASS] Invalid Username + Password Test Passed");

        System.out.println(
                "Displayed Error : "
                + loginPage.getErrorMessage());
    }

    // ==========================================
    // 4. Empty Username
    // ==========================================

    @Test
    public void emptyUsernameTest(){
            

        String loginURL = driver.getCurrentUrl();

        loginPage.enterEmail("");

        loginPage.enterPassword("Test@123");

        loginPage.clickLogin();

    

        Assert.assertEquals(
                driver.getCurrentUrl(),
                loginURL);

        System.out.println("[PASS] Empty Username Validation Passed");

        System.out.println(
                "Displayed Error : "
                + loginPage.getErrorMessage());
    }

    // ==========================================
    // 5. Empty Password
    // ==========================================

    @Test
    public void emptyPasswordTest(){
            

        String loginURL = driver.getCurrentUrl();

        loginPage.enterEmail(
                "jabdul@thoughtlinetech.com");

        loginPage.enterPassword("");

        loginPage.clickLogin();

      
        Assert.assertEquals(
                driver.getCurrentUrl(),
                loginURL);

        System.out.println("[PASS] Empty Password Validation Passed");

        System.out.println(
                "Displayed Error : "
                + loginPage.getErrorMessage());
    }

    // ==========================================
    // 6. Empty Username + Password
    // ==========================================

    @Test
    public void emptyCredentialsTest(){
            

        String loginURL = driver.getCurrentUrl();

        loginPage.enterEmail("");

        loginPage.enterPassword("");

        loginPage.clickLogin();

        
        Assert.assertEquals(
                driver.getCurrentUrl(),
                loginURL);

        System.out.println("[PASS] Empty Credentials Validation Passed");

        System.out.println(
                "Displayed Error : "
                + loginPage.getErrorMessage());
    }

    // ==========================================
    // 7. SQL Injection Test
    // ==========================================

    @Test
    public void sqlInjectionTest(){
            

        String loginURL = driver.getCurrentUrl();

        loginPage.enterEmail("' OR '1'='1");

        loginPage.enterPassword("' OR '1'='1");

        loginPage.clickLogin();

       
        Assert.assertEquals(
                driver.getCurrentUrl(),
                loginURL);

        System.out.println("[PASS] SQL Injection Test Passed");

        System.out.println(
                "Displayed Error : "
                + loginPage.getErrorMessage());
    }
}