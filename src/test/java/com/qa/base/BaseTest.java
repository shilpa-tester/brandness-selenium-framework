package com.qa.base;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import com.qa.utilities.Logger;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.pages.LoginPage;
import com.qa.utilities.ConfigReader;



public class BaseTest {

    public static WebDriver driver;

    public void setupBrowser() {

    String browser =
            System.getProperty(
                    "browser",
                    "chrome");

    if (browser.equalsIgnoreCase(
            "edge")) {

        WebDriverManager.edgedriver()
                .setup();

        driver =
                new EdgeDriver();
    }

    else if (browser.equalsIgnoreCase(
            "firefox")) {

        WebDriverManager.firefoxdriver()
                .setup();

        driver =
                new FirefoxDriver();
    }

    else {

        WebDriverManager.chromedriver()
                .setup();

        driver =
                new ChromeDriver();
    }

    driver.manage()
            .window()
            .maximize();

    driver.get(
            ConfigReader.getProperty(
                    "url"));
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