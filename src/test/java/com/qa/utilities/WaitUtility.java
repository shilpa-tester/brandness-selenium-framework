package com.qa.utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

    WebDriver driver;

    public WaitUtility(WebDriver driver) {

        this.driver = driver;
    }

    // Visible
    public WebElement waitForElement(By locator) {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(20));

        return wait.until(
                ExpectedConditions
                        .visibilityOfElementLocated(locator));
    }

    // Clickable
    public WebElement waitForClickable(By locator) {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(20));

        return wait.until(
                ExpectedConditions
                        .elementToBeClickable(locator));
    }

    // Invisible
    public boolean waitForInvisible(By locator) {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(20));

        return wait.until(
                ExpectedConditions
                        .invisibilityOfElementLocated(locator));
    }
}