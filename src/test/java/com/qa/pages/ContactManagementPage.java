package com.qa.pages;

import java.time.Duration;

import com.qa.utilities.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.locators.ContactManagementLocators;

public class ContactManagementPage extends BasePage{

        public ContactManagementPage(WebDriver driver) {

        super(driver);
    }

    // ==========================
    // OPEN PANEL
    // ==========================

    public void openContactsPanel()
{

    WebDriverWait wait =
            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10));

   WebElement button =
        wait.until(
            ExpectedConditions.elementToBeClickable(
                ContactManagementLocators.contactsButton));

button.click();

}



    // ==========================
    // WAIT FOR PANEL
    // ==========================

    public void waitForPanel()
             {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        ContactManagementLocators.panelTitle));

        Logger.info(
        "Panel is visible");
    }

    // ==========================
    // CHECK PANEL IS OPEN
    // ==========================

    public boolean isPanelOpen() {

        try {

            WebDriverWait wait =
                    new WebDriverWait(driver,
                            Duration.ofSeconds(5));

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            ContactManagementLocators.panelTitle));

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    // ==========================
    // CHECK PANEL IS CLOSED
    // ==========================

    public boolean isPanelClosed() {

        try {

            WebDriverWait wait =
                    new WebDriverWait(driver,
                            Duration.ofSeconds(5));

            wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(
                            ContactManagementLocators.panelTitle));

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    // ==========================
    // CLOSE PANEL
    // ==========================

    public void closePanel()
             {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        WebElement close =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                ContactManagementLocators
                                        .closePanelButton));

        close.click();

wait.until(
        ExpectedConditions.invisibilityOfElementLocated(
                ContactManagementLocators.panelTitle));

Logger.info(
        "Panel closed");
}

    // ==========================
    // ENTER NAME
    // ==========================

    public void enterName(String name)
             {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        WebElement input =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                ContactManagementLocators.nameInput));

        input.clear();
        input.sendKeys(name);

        Logger.info(
        "Name entered: " + name);
    }

    // ==========================
    // ENTER EMAIL
    // ==========================

    public void enterEmail(String email)
             {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        WebElement input =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                ContactManagementLocators.emailInput));

        input.clear();
        input.sendKeys(email);

        Logger.info(
        "Email entered: " + email);
    }

    // ==========================
    // CLICK INVITE BUTTON
    // ==========================

    public void clickInvite()
             {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        WebElement button =
                wait.until(
                        ExpectedConditions.presenceOfElementLocated(
                                ContactManagementLocators.inviteButton));

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();", button);

        Logger.info(
        "Invite button clicked");

            }

    // ==========================
    // CLICK WITHDRAW INVITATION
    // ==========================

    public void clickWithdrawInvitation()
             {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        WebElement button =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                ContactManagementLocators
                                        .withdrawInviteButton));

        button.click();

        Logger.info(
        "Withdraw invitation clicked");

        
    }

    // ==========================
    // CLICK NEW TAB
    // ==========================

    public void clickNewTab()
             {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        WebElement tab =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                ContactManagementLocators.newTab));

        tab.click();

        wait.until(
        ExpectedConditions.visibilityOfElementLocated(
                ContactManagementLocators.nameInput));

Logger.info(
        "New tab clicked");
    }

    // ==========================
    // CLICK EXISTING TAB
    // ==========================

    public void clickExistingTab() {

    WebDriverWait wait =
            new WebDriverWait(driver,
                    Duration.ofSeconds(10));

    WebElement tab =
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            ContactManagementLocators.existingTab));

    JavascriptExecutor js =
            (JavascriptExecutor) driver;

    js.executeScript(
            "arguments[0].click();",
            tab);

    Logger.info("Existing tab clicked");
}

    // ==========================
    // CHECK VALIDATION MESSAGE
    // ==========================

    public boolean isValidationMessageShown() {

        try {

            WebDriverWait wait =
                    new WebDriverWait(driver,
                            Duration.ofSeconds(5));

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            ContactManagementLocators
                                    .validationMessage));

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    // ==========================
    // CHECK NAME FIELD VISIBLE
    // ==========================

    public boolean isNameFieldVisible() {

        try {

            return driver.findElements(
                    ContactManagementLocators.nameInput)
                    .size() > 0;

        } catch (Exception e) {

            return false;
        }
    }

    // ==========================
    // CHECK EMAIL FIELD VISIBLE
    // ==========================

    public boolean isEmailFieldVisible() {

        try {

            return driver.findElements(
                    ContactManagementLocators.emailInput)
                    .size() > 0;

        } catch (Exception e) {

            return false;
        }
    }

    // ==========================
    // CHECK INVITE BUTTON VISIBLE
    // ==========================

    public boolean isInviteButtonVisible() {

        try {

            return driver.findElements(
                    ContactManagementLocators.inviteButton)
                    .size() > 0;

        } catch (Exception e) {

            return false;
        }
    }

    // ==========================
    // GET NAME FIELD VALUE
    // ==========================

    public String getNameFieldValue() {

        WebElement input =
                driver.findElement(
                        ContactManagementLocators.nameInput);

        return input.getAttribute("value");
    }

    // ==========================
    // GET EMAIL FIELD VALUE
    // ==========================

    public String getEmailFieldValue() {

        WebElement input =
                driver.findElement(
                        ContactManagementLocators.emailInput);

        return input.getAttribute("value");
    }

    public void clickFirstExistingUserAddButton() {

    WebDriverWait wait =
            new WebDriverWait(driver,
                    Duration.ofSeconds(10));

    WebElement button =
            wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            ContactManagementLocators
                                    .firstExistingUserAddButton));

    JavascriptExecutor js =
            (JavascriptExecutor) driver;

    js.executeScript(
            "arguments[0].scrollIntoView({block:'center'});",
            button);

    js.executeScript(
            "arguments[0].click();",
            button);

    Logger.info(
            "First existing user add button clicked");
}
public void clickFirstExistingUserDeleteButton() {

    WebDriverWait wait =
            new WebDriverWait(driver,
                    Duration.ofSeconds(10));

    WebElement button =
            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            ContactManagementLocators
                                    .firstExistingUserDeleteButton));

    button.click();

    Logger.info("First existing user delete button clicked");
}

    public int getUserCount() {

    return driver.findElements(
            org.openqa.selenium.By.xpath(
                    "//div[contains(@class,'rounded-lg')]"))
            .size();
}

public int getAccessUserCount() {

    WebDriverWait wait =
            new WebDriverWait(driver,
                    Duration.ofSeconds(10));

    wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    ContactManagementLocators.userCard));

    return driver.findElements(
            ContactManagementLocators.userCard)
            .size();
}
}