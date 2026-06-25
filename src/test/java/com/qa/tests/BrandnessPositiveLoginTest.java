package com.qa.tests;

import org.testng.annotations.DataProvider;
import com.qa.utilities.ExcelReader;
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


public class BrandnessPositiveLoginTest extends BaseTest {

    LoginPage loginPage;

   @DataProvider(name = "loginData")
public Object[][] loginData() {

    return new Object[][] {
        {
            ExcelReader.getCellData("Login", 1, 0),
            ExcelReader.getCellData("Login", 1, 1)
        }
    };
}


    @BeforeMethod(alwaysRun = true)
    public void startSetup() {

        setupBrowser();

        loginPage = new LoginPage(getDriver());
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        closeBrowser();
    }

@Test(
    dataProvider = "loginData",
    groups = {"smoke", "login"})
public void successfulLoginTest(
        String username,
        String password) {


    loginPage.login(
            username,
            password);

    WebDriverWait wait =
            new WebDriverWait(
                    getDriver(),
                    Duration.ofSeconds(20));

    wait.until(
            ExpectedConditions.urlContains(
                    "dashboard"));

    String currentURL =
            getDriver().getCurrentUrl();

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
