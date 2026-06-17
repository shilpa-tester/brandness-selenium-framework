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


    int rowCount =
            ExcelReader.getRowCount(
                    "Login");

                    System.out.println(
        "Row Count = "
        + rowCount);

    Object[][] data =
            new Object[rowCount][2];

    for (int i = 1; i <= rowCount; i++) {

        data[i - 1][0] =
                ExcelReader.getCellData(
                        "Login",
                        i,
                        0);

        data[i - 1][1] =
                ExcelReader.getCellData(
                        "Login",
                        i,
                        1);
    }

    return data;
}

    @BeforeMethod
    public void startSetup() {

        setupBrowser();

        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void tearDown() {

        closeBrowser();
    }

@Test(dataProvider = "loginData")
public void successfulLoginTest(
        String username,
        String password) {


    loginPage.login(
            username,
            password);

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
