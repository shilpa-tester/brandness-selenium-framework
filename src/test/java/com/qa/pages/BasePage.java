package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;

        wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(20));
    }

    protected WebElement waitForVisibility(
            WebElement element) {

        return wait.until(
                ExpectedConditions
                        .visibilityOf(element));
    }

    protected WebElement waitForClickable(
            WebElement element) {

        return wait.until(
                ExpectedConditions
                        .elementToBeClickable(
                                element));
    }

    protected void clickElement(
            WebElement element) {

        waitForClickable(element)
                .click();
    }

    protected void typeText(
            WebElement element,
            String text) {

        waitForVisibility(element)
                .sendKeys(text);
    }

    protected void scrollIntoView(
            WebElement element) {

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                element);
    }
}