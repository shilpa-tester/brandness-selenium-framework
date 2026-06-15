package com.qa.tests;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

import com.qa.utilities.Logger;
import com.qa.base.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.utilities.ConfigReader;

public class BrandnessPositiveLoginTest extends BaseTest {

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

   @Test
public void successfulLoginTest() {

    loginPage.login(
            ConfigReader.getProperty("username"),
            ConfigReader.getProperty("password"));

    WebDriverWait wait =
            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(20));

    wait.until(
            ExpectedConditions.urlContains(
                    "dashboard"));

    String currentURL =
            driver.getCurrentUrl();

    Assert.assertTrue(
            currentURL.contains("dashboard"),
            "Login Failed");

    Logger.pass(
        "Login Successful");

    Logger.info(
        "Current URL : "
        + currentURL);
}
}