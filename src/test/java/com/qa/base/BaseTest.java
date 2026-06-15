package com.qa.base;

import com.qa.utilities.Logger;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.pages.LoginPage;
import com.qa.utilities.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

    public static WebDriver driver;

    public void setupBrowser() {

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get(
            ConfigReader.getProperty("url"));
    }

    public void loginToApplication() {

    driver.get(
        ConfigReader.getProperty("url"));

    Logger.info(
        "Login page loaded: "
        + driver.getCurrentUrl());

    LoginPage loginPage =
            new LoginPage(driver);

    loginPage.login(
            ConfigReader.getProperty("username"),
            ConfigReader.getProperty("password"));

    Logger.info(
        "After login click: "
        + driver.getCurrentUrl());

    WebDriverWait wait =
            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(30));

    wait.until(
        ExpectedConditions.or(
            ExpectedConditions.urlContains(
                    "dashboard"),
            ExpectedConditions.urlContains(
                    "admin")));

Logger.pass(
        "Logged in successfully");
}

    public void closeBrowser() {

    if (driver != null) {

        Logger.info(
                "Closing browser");

        driver.quit();
    }
}
}