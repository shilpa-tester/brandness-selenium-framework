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

    private static ThreadLocal<WebDriver> driver =
            new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driver.get();
    }

    public void setupBrowser() {

        String browser =
                System.getProperty("browser", "chrome");

        if (browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();
            driver.set(new EdgeDriver());

        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver.set(new FirefoxDriver());

        } else {

            WebDriverManager.chromedriver().setup();
            driver.set(new ChromeDriver());
        }

        getDriver().manage().window().maximize();
        getDriver().manage().deleteAllCookies();

        getDriver().get(
                ConfigReader.getProperty("url"));
    }

    public void loginToApplication() {

        getDriver().get(
                ConfigReader.getProperty("url"));

        Logger.info(
                "Login page loaded: "
                + getDriver().getCurrentUrl());

        LoginPage loginPage =
                new LoginPage(getDriver());

        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        Logger.info(
                "After login click: "
                + getDriver().getCurrentUrl());

        WebDriverWait wait =
                new WebDriverWait(
                        getDriver(),
                        Duration.ofSeconds(30));

        wait.until(
                ExpectedConditions.or(
                        ExpectedConditions.urlContains("dashboard"),
                        ExpectedConditions.urlContains("admin")));

        Logger.pass("Logged in successfully");
    }

    public void closeBrowser() {

        if (getDriver() != null) {

            Logger.info("Closing browser");

            getDriver().quit();
            driver.remove();
        }
    }
}