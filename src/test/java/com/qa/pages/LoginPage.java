package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.locators.LoginPageLocators;
import com.qa.utilities.WaitUtility;

public class LoginPage extends BasePage {

   
    WaitUtility waitUtility;

    public LoginPage(WebDriver driver) {

    super(driver);

    waitUtility = new WaitUtility(driver);
}
    public void enterEmail(String email) {

        WebElement emailField =
                waitUtility.waitForElement(
                        LoginPageLocators.emailField);

        emailField.clear();

        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {

        WebElement passwordField =
                waitUtility.waitForElement(
                        LoginPageLocators.passwordField);

        passwordField.clear();

        passwordField.sendKeys(password);
    }

    public void clickLogin() {

    WebElement loginButton =
            waitUtility.waitForClickable(
                    LoginPageLocators.loginButton);

    loginButton.click();

    System.out.println(
            "Login button clicked");
}

    public String getErrorMessage() {

        try {

            WebElement error =
                    waitUtility.waitForElement(
                            LoginPageLocators.errorMessage);

            return error.getText();

        } catch(Exception e) {

            return "No Error Message";
        }
    }

    public void login(String email,
                  String password) {

    System.out.println("Entering Email");

    enterEmail(email);

    System.out.println("Entering Password");

    enterPassword(password);

    System.out.println("Clicking Login");

    clickLogin();
}

}