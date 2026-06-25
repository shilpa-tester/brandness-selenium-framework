package com.qa.tests;

import org.testng.annotations.DataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.time.Duration;

import com.qa.base.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.utilities.ExcelReader;

public class LoginDataDrivenTest extends BaseTest {

    LoginPage loginPage;

    @DataProvider(name = "loginData")
public Object[][] loginData() {

    int rowCount =
            ExcelReader.getRowCount(
                    "Login");

    Object[][] data =
            new Object[rowCount][3];

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

        data[i - 1][2] =
                ExcelReader.getCellData(
                        "Login",
                        i,
                        2);
    }

    return data;
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
    description = "Excel Driven Login Test",
    groups = {"smoke", "regression", "login"})

public void loginTest(
        String username,
        String password,
        String expectedResult) throws Exception {

    loginPage.login(
            username,
            password);


if (expectedResult.equalsIgnoreCase(
        "PASS")) {

    WebDriverWait wait =
            new WebDriverWait(
                    getDriver(),
                    Duration.ofSeconds(20));

    wait.until(
            ExpectedConditions.visibilityOfElementLocated(
        By.tagName("body")));
}

Thread.sleep(5000);

String currentURL =
       getDriver().getCurrentUrl();

System.out.println(
        "Current URL = "
        + currentURL);

boolean loginSuccess =
        currentURL.contains(
                "dashboard");

                    System.out.println(
        "Expected Result = "
        + expectedResult);

    if (expectedResult.equalsIgnoreCase(
            "PASS")) {

        org.testng.Assert.assertTrue(
                loginSuccess,
                "Expected Login Success");

        System.out.println(
                "PASS CASE EXECUTED");
    }

    else {

        org.testng.Assert.assertFalse(
                loginSuccess,
                "Expected Login Failure");

        System.out.println(
                "FAIL CASE EXECUTED");
    }
}

}