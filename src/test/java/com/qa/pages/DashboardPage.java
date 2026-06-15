package com.qa.pages;

import java.time.Duration;
import java.util.List;
import com.qa.utilities.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.qa.locators.DashboardPageLocators;

public class DashboardPage extends BasePage {

  public DashboardPage(
        WebDriver driver) {

    super(driver);
}
    // ==========================
    // CONTACTS BUTTON
    // ==========================

    public void clickContactsButton() {

       WebDriverWait wait =
        new WebDriverWait(driver,
                Duration.ofSeconds(20));

WebElement contactsButton =
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        DashboardPageLocators.contactsButton));

contactsButton.click();

        Logger.info(
        "Contacts button clicked");
    }

    // ==========================
    // CONFIGURE BUTTON
    // ==========================

    public void clickConfigure(){
            

        WebDriverWait wait =
        new WebDriverWait(driver,
                Duration.ofSeconds(20));

WebElement configureButton =
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        DashboardPageLocators.configureButton));

configureButton.click();

        Logger.info(
        "Configure button clicked");

       
        // Close the modal by pressing Escape
        driver.findElement(
                By.tagName("body"))
                .sendKeys(Keys.ESCAPE);

       Logger.info(
        "Modal closed");

            }

    // ==========================
    // DELETE BUTTON
    // ==========================

    public void clickDeleteButton() {
       

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(20));

        WebElement deleteBtn =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                DashboardPageLocators.deleteButton));
deleteBtn.click();

Logger.info(
        "Delete button clicked");
    }

    // ==========================
    // SEARCH DASHBOARD
    // ==========================

    public void searchDashboard(String dashboardName){
            

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(20));

        WebElement search =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                DashboardPageLocators.searchBox));

        wait.until(
                ExpectedConditions.elementToBeClickable(
                        search));

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].scrollIntoView(true);",
                search);

        js.executeScript(
                "arguments[0].click();",
                search);

        search.clear();

        search.sendKeys(dashboardName);

        Logger.info(
        "Search text entered : "
        + dashboardName);
            }

    // ==========================
    // NEW DASHBOARD BUTTON
    // ==========================

    public void clickNewDashboard(){
            

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(20));

        WebElement button =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                DashboardPageLocators.newDashboardButton));

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "arguments[0].click();", button);

        Logger.info(
                "New Dashboard button clicked");
    }

    // ==========================
    // CHANGE PAGINATION
    // ==========================

    public void changePagination(String option){
            
        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        // Scroll to bottom so pagination is visible
        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "window.scrollTo(0, "
                + "document.body.scrollHeight)");

        

        // Click the pagination dropdown
        WebElement dropdown =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                DashboardPageLocators.paginationDropdown));

        dropdown.click();

        Logger.info(
                "Pagination dropdown clicked");

        

        // Click the option using any element type
        WebElement paginationOption =
                wait.until(
                        ExpectedConditions.elementToBeClickable(
                                By.xpath(
                                    "//*[contains(text(),'"
                                    + option
                                    + "')]")));

        paginationOption.click();

        Logger.info(
                "Pagination changed to: " + option);

        
    }

    // ==========================
    // GET DASHBOARD ROW COUNT
    // ==========================

    public int getDashboardRowCount() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        DashboardPageLocators.dashboardRows));

        return driver.findElements(
                DashboardPageLocators.dashboardRows)
                .size();
    }

    // ==========================
    // GET SEARCH BOX VALUE
    // ==========================

    public String getSearchBoxValue() {

        WebElement search =
                driver.findElement(
                        DashboardPageLocators.searchBox);

        return search.getAttribute("value");
    }

    // ==========================
    // CHECK NO RESULTS DISPLAYED
    // ==========================

    public boolean isNoResultsDisplayed() {

        try {

            WebDriverWait wait =
                    new WebDriverWait(driver,
                            Duration.ofSeconds(5));

            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            DashboardPageLocators.noResultsMessage));

            return true;

        } catch (Exception e) {

            return false;
        }
    }

    // ==========================
    // GET PAGINATION TEXT
    // ==========================

    public String getPaginationText() {

        WebDriverWait wait =
                new WebDriverWait(driver,
                        Duration.ofSeconds(10));

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript(
                "window.scrollTo(0, "
                + "document.body.scrollHeight)");

        WebElement pagination =
                wait.until(
                        ExpectedConditions.visibilityOfElementLocated(
                                DashboardPageLocators.paginationDropdown));

        return pagination.getText();
    }

    // ==========================
    // SEARCH AND GET ROW COUNT
    // ==========================

    public int searchAndGetRowCount(String searchTerm){
            
        searchDashboard(searchTerm);

                List<WebElement> rows =
                driver.findElements(
                        DashboardPageLocators.dashboardRows);

        return rows.size();
    }

    // ==========================
    // CHECK SEARCH BOX EMPTY
    // ==========================

    public boolean isSearchBoxEmpty() {

        WebElement search =
                driver.findElement(
                        DashboardPageLocators.searchBox);

        String value =
                search.getAttribute("value");

        return value == null || value.isEmpty();
    }

    // ==========================
    // CHECK SEARCH BOX ENABLED
    // ==========================

public boolean isSearchBoxEnabled() {

    WebDriverWait wait =
            new WebDriverWait(
                    driver,
                    Duration.ofSeconds(10));

    WebElement search =
            wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            DashboardPageLocators.searchBox));

    return search.isEnabled();
}

    // ==========================
    // CHECK NEW DASHBOARD BUTTON VISIBLE
    // ==========================

  
}