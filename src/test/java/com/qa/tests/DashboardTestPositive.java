package com.qa.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

import com.qa.base.BaseTest;
import com.qa.pages.DashboardPage;
import com.qa.utilities.ConfigReader;

@Listeners(com.qa.utilities.TestListener.class)
public class DashboardTestPositive extends BaseTest {
   
    DashboardPage dashboardPage;

    // Runs ONCE — login only
    
    @BeforeClass
public void setup() {

    setupBrowser();

    dashboardPage =
            new DashboardPage(getDriver());

    loginToApplication();
}

    // Runs BEFORE EACH TEST — navigate to correct page
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

    // Runs ONCE — close browser
    @AfterClass
    public void tearDown() {

        closeBrowser();
    }

    // ==========================
    // CONTACTS BUTTON
    // ==========================

    @Test
    public void verifyContactsButtonClick(){
            

        dashboardPage.clickContactsButton();

        
        System.out.println(
                "Contacts click test completed");
    }

    // ==========================
    // CONFIGURE BUTTON
    // ==========================

    @Test
    public void verifyConfigureButton(){
            

        dashboardPage.clickConfigure();

        
        String currentURL = getDriver().getCurrentUrl();

        System.out.println(currentURL);

        Assert.assertTrue(
        currentURL.contains("dashboard"),
        "Wrong page opened");
    }

    // ==========================
    // DELETE BUTTON
    // ==========================

    @Test
    public void verifyDeleteButton(){
            

        dashboardPage.clickDeleteButton();

        System.out.println(
                "Delete button test completed");
    }

    // ==========================
    // SEARCH FUNCTIONALITY
    // ==========================

    @Test
    public void verifyDashboardSearch(){
            

        dashboardPage.searchDashboard("d11");

        
        System.out.println("Search completed");
    }

    // ==========================
    // NEW DASHBOARD BUTTON
    // ==========================

    @Test
    public void verifyNewDashboardButton(){
            

        dashboardPage.clickNewDashboard();

       
        String currentURL = getDriver().getCurrentUrl();

        System.out.println(currentURL);

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "New dashboard page not opened");
    }

    // ==========================
    // PAGINATION
    // ==========================

    @Test
    public void verifyPaginationChange(){
            

        dashboardPage.changePagination(
                "25 per pagina");

       
        String pageSource = getDriver().getPageSource();

        Assert.assertTrue(
                pageSource.contains("25 per pagina"),
                "Pagination did not change to 25");

        System.out.println(
                "Pagination test completed");
    }
}