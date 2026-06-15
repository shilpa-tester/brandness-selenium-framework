package com.qa.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {

    public static By emailField =
            By.xpath("//input[@type='email']");

    public static By passwordField =
            By.xpath("//input[@type='password']");

    public static By loginButton =
            By.xpath("//button[@type='submit']");

    public static By errorMessage =
            By.xpath("//*[contains(text(),'Invalid') "
                    + "or contains(text(),'incorrect') "
                    + "or contains(text(),'required')]");
}