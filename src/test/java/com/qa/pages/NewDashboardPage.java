package com.qa.pages;

import java.time.Duration;
import com.qa.utilities.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.locators.NewDashboardLocators;

public class NewDashboardPage extends BasePage {

   
    public NewDashboardPage(WebDriver driver) {

        super(driver);
    }

    // ==========================
    // WAIT FOR MODAL
    // ==========================

    public void waitForModal(){
            

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        NewDashboardLocators.modalContainer));

        Logger.info(
        "Modal is visible");
    }

    // ==========================
    // ENTER DASHBOARD NAME
    // ==========================

    public void enterDashboardName(String name){
            

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        WebElement input =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                NewDashboardLocators.dashboardName));

        input.clear();
        input.sendKeys(name);

        System.out.println(
                "Dashboard name entered: " + name);
    }

    // ==========================
    // CLICK CANCEL BUTTON
    // ==========================

    public void clickCancel(){
            

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        WebElement cancel =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                NewDashboardLocators.cancelBtn));

        cancel.click();

        System.out.println(
                "Cancel button clicked");
    }

    // ==========================
    // CLICK CLOSE BUTTON
    // ==========================

    public void clickClose(){
          

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        WebElement close =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                NewDashboardLocators.closeBtn));

        close.click();

        System.out.println(
                "Close button clicked");
    }

    // ==========================
    // CLICK CREATE DASHBOARD
    // ==========================

    public void clickCreateDashboard() {

    WebDriverWait wait =
            new WebDriverWait(driver,
                    Duration.ofSeconds(10));

    WebElement create =
            wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            NewDashboardLocators.createDashboardBtn));

    JavascriptExecutor js =
            (JavascriptExecutor) driver;

    js.executeScript(
            "arguments[0].click();", create);

    System.out.println(
            "Create Dashboard button clicked");
}
    // ==========================
    // CLICK GOOGLE ADS DROPDOWN
    // ==========================

    public void clickGoogleAdsDropdown(){
            

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        WebElement dropdown =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                NewDashboardLocators.googleAdsDropdown));

        dropdown.click();

        System.out.println(
                "Google Ads dropdown clicked");
    }

    // ==========================
    // CLICK GA4 DROPDOWN
    // ==========================

    public void clickGA4Dropdown(){
            

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        WebElement dropdown =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                NewDashboardLocators.ga4Dropdown));

        dropdown.click();

        System.out.println(
                "GA4 dropdown clicked");
    }


    public void selectFirstGoogleAdsOption() {

    WebDriverWait wait =
            new WebDriverWait(driver,
                    Duration.ofSeconds(10));

    WebElement option =
            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            NewDashboardLocators.firstGoogleAdsOption));

    option.click();

    System.out.println(
            "First Google Ads option selected");


}

public void selectFirstGA4Option() {

    WebDriverWait wait =
            new WebDriverWait(driver,
                    Duration.ofSeconds(10));

    WebElement option =
            wait.until(
                    ExpectedConditions.elementToBeClickable(
                            NewDashboardLocators.firstGA4Option));

    option.click();

    System.out.println(
            "First GA4 option selected");
}



    // ==========================
    // CHECK IF MODAL IS CLOSED
    // ==========================

    public boolean isModalClosed() {

        try {

            WebDriverWait wait =
                    new WebDriverWait(driver,
                            Duration.ofSeconds(15));

            wait.until(
                    ExpectedConditions.invisibilityOfElementLocated(
                            NewDashboardLocators.modalContainer));

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    // ==========================
    // CHECK VALIDATION ERROR
    // ==========================

    public boolean isValidationErrorShown() {

        try {

            WebDriverWait wait =
                    new WebDriverWait(driver,
                            Duration.ofSeconds(5));

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            NewDashboardLocators.validationError));

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    // ==========================
    // GET VALIDATION ERROR TEXT
    // ==========================

    public String getValidationErrorText() {

        try {

            WebElement error =
                    driver.findElement(
                            NewDashboardLocators.validationError);

            return error.getText();

        } catch (Exception e) {

            return "No error message found";
        }
    }
}