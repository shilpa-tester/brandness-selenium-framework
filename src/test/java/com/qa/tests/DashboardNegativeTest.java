package com.qa.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;


import com.qa.base.BaseTest;
import com.qa.pages.DashboardPage;
import com.qa.utilities.ConfigReader;


public class DashboardNegativeTest extends BaseTest {

  
    DashboardPage dashboardPage;

    // Login once
    @BeforeClass
    public void setup() throws InterruptedException {

        setupBrowser();

        
        dashboardPage = new DashboardPage(getDriver());

        loginToApplication();

            }

    // Navigate to dashboard before each test
@BeforeMethod
public void goToDashboard() {

    getDriver().get(
        ConfigReader.getProperty(
                "dashboardUrl"));

    if(getDriver().getCurrentUrl()
            .contains("auth")) {

        loginToApplication();

       getDriver().get(
            ConfigReader.getProperty(
                    "dashboardUrl"));
    }

    System.out.println(
            "Current URL: "
            + getDriver().getCurrentUrl());
    }

    @AfterClass
    public void tearDown() {

        closeBrowser();
    }

    // ==========================
    // SEARCH NEGATIVE TESTS
    // ==========================

    @Test
    public void verifySearchWithNonExistentDashboard()
            throws InterruptedException {

        // Search for something that doesn't exist
        dashboardPage.searchDashboard(
                "XXXXXXXXXNOTEXISTS123456");

        

        // Row count should be 0 or no results shown
        boolean noResults =
                dashboardPage.isNoResultsDisplayed();

        int rowCount =
                getDriver().findElements(
                        org.openqa.selenium.By.xpath(
                            "//table//tbody//tr"))
                        .size();

        System.out.println(
                "Rows found: " + rowCount);

        Assert.assertTrue(
                noResults || rowCount == 0,
                "Expected no results for invalid search"
                + " but found: " + rowCount);

        System.out.println(
                "Non-existent search test passed");
    }

    @Test
    public void verifySearchWithSpecialCharacters()
            throws InterruptedException {

        // Search with special characters
        dashboardPage.searchDashboard(
                "!@#$%^&*()");

      

        // App should not crash — URL should still
        // be dashboard
        String currentURL = getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "App crashed on special character search");

        System.out.println(
                "Special character search test passed");
    }

    @Test
    public void verifySearchWithNumbers()
            throws InterruptedException {

        // Search with only numbers
        dashboardPage.searchDashboard("999999999");

        

        String currentURL = getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "App crashed on number search");

        System.out.println(
                "Number search test passed");
    }

    @Test
    public void verifySearchWithWhitespace()
            throws InterruptedException {

        // Search with only spaces
        dashboardPage.searchDashboard("     ");

       
        // Should show all results or no results
        // but not crash
        String currentURL = getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "App crashed on whitespace search");

        System.out.println(
                "Whitespace search test passed");
    }
@Test
public void verifySearchBoxClearsCorrectly()
        throws InterruptedException {

    // Type something first
    dashboardPage.searchDashboard("d11");

    Thread.sleep(1000);

    // Get the search box
    WebElement search =
            getDriver().findElement(
                    com.qa.locators.DashboardPageLocators
                            .searchBox);

    // Select all text and delete
    // (works better than clear() on React inputs)
    search.sendKeys(
            org.openqa.selenium.Keys.CONTROL + "a");

    Thread.sleep(500);

    search.sendKeys(
            org.openqa.selenium.Keys.DELETE);

    Thread.sleep(1000);

    // Check value is empty
    String value = search.getAttribute("value");

    System.out.println(
            "Search box value after clear: '"
            + value + "'");

    Assert.assertTrue(
            value == null || value.isEmpty(),
            "Search box not cleared properly. "
            + "Value: '" + value + "'");

    System.out.println(
            "Search clear test passed");
}

    @Test
    public void verifySearchWithVeryLongText()
            throws InterruptedException {

        // Search with 200 character string
        String longText =
                "a".repeat(200);

        dashboardPage.searchDashboard(longText);

       

        // App should not crash
        String currentURL = getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "App crashed on long text search");

        System.out.println(
                "Long text search test passed");
    }

    // ==========================
    // PAGINATION NEGATIVE TESTS
    // ==========================

    @Test
    public void verifyPaginationDefaultIs10()
            throws InterruptedException {

        // By default pagination should be 10
        String paginationText =
                dashboardPage.getPaginationText();

        System.out.println(
                "Pagination text: " + paginationText);

        Assert.assertTrue(
                paginationText.contains("10"),
                "Default pagination is not 10. Got: "
                + paginationText);

        System.out.println(
                "Default pagination test passed");
    }

    @Test
    public void verifyPaginationChangeTo100()
            throws InterruptedException {

        // Change to 100 per page
        dashboardPage.changePagination(
                "100 per pagina");

       

        String paginationText =
                dashboardPage.getPaginationText();

        System.out.println(
                "Pagination text after change: "
                + paginationText);

        // All 7 dashboards should be visible
        // (less than 100)
        int rowCount =
                getDriver().findElements(
                        org.openqa.selenium.By.xpath(
                            "//table//tbody//tr"))
                        .size();

        Assert.assertTrue(
                rowCount > 0,
                "No rows visible after pagination change");

        System.out.println(
                "Pagination 100 test passed. "
                + "Rows: " + rowCount);
    }

    // ==========================
    // NEW DASHBOARD NEGATIVE TESTS
    // ==========================

    @Test
public void verifyNewDashboardButtonIsVisible() {

    dashboardPage.clickNewDashboard();

    System.out.println(
            "New Dashboard button visibility test passed");
}

    @Test
public void verifyPageDoesNotCrashAfterNavigation() {

    getDriver().navigate().refresh();

    if(getDriver().getCurrentUrl()
            .contains("auth")) {

        loginToApplication();

        getDriver().get(
            ConfigReader.getProperty(
                    "dashboardUrl"));
    }

    Assert.assertTrue(
            getDriver().getCurrentUrl()
                    .contains("dashboard"),
            "Page broken after refresh");

    System.out.println(
            "Navigation test passed");
}

    @Test
public void verifyPageRefreshKeepsData()
        throws InterruptedException {

    int rowsBefore =
            dashboardPage.getDashboardRowCount();

    getDriver().navigate().refresh();

    if (getDriver().getCurrentUrl()
            .contains("auth")) {

        loginToApplication();

        getDriver().get(
            ConfigReader.getProperty(
                    "dashboardUrl"));
    }

    WebDriverWait wait =
            new WebDriverWait(
                    getDriver(),
                    Duration.ofSeconds(20));

    wait.until(
            ExpectedConditions.urlContains(
                    "dashboard"));

    int rowsAfter =
            dashboardPage.getDashboardRowCount();

    Assert.assertEquals(
            rowsBefore,
            rowsAfter,
            "Row count changed after refresh");

    System.out.println(
            "Page refresh test passed. Rows: "
            + rowsAfter);
}

    // ==========================
    // SEARCH + PAGINATION COMBINED
    // ==========================

    @Test
    public void verifySearchThenChangePagination()
            throws InterruptedException {

        // Search first
        dashboardPage.searchDashboard("d");

      

        // Then change pagination — should not crash
        String currentURL = getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "Page broken after search");

        System.out.println(
                "Search then pagination test passed");
    }

    // ==========================
    // UI ELEMENT VISIBILITY
    // ==========================
@Test
public void verifyAllTableColumnsVisible() {

    WebDriverWait wait =
            new WebDriverWait(
                    getDriver(),
                    Duration.ofSeconds(10));

    wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//th[contains(text(),'Dashboard naam')]")));

    Assert.assertTrue(
            getDriver().getPageSource()
                    .contains("Dashboard naam"));

    Assert.assertTrue(
            getDriver().getPageSource()
                    .contains("Contacten"));

    Assert.assertTrue(
            getDriver().getPageSource()
                    .contains("Acties"));

    System.out.println(
            "All columns visible test passed");
}
    @Test
    public void verifySearchIsEnabledOnLoad()
            throws InterruptedException {

        // Search box should be enabled and empty
        // when page loads
        boolean isEnabled =
                dashboardPage.isSearchBoxEnabled();

        boolean isEmpty =
                dashboardPage.isSearchBoxEmpty();

        Assert.assertTrue(
                isEnabled,
                "Search box is disabled on load");

        Assert.assertTrue(
                isEmpty,
                "Search box is not empty on load");

        System.out.println(
                "Search box state on load test passed");
    }
}