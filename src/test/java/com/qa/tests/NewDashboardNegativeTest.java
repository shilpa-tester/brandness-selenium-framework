package com.qa.tests;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.DashboardPage;
import com.qa.pages.NewDashboardPage;
import com.qa.utilities.ConfigReader;

public class NewDashboardNegativeTest extends BaseTest {

    DashboardPage dashboardPage;
    NewDashboardPage newDashboardPage;
    
    // ==========================
    // LOGIN ONCE
    // ==========================

@BeforeClass
public void setup(){
        

    setupBrowser();

    dashboardPage =
            new DashboardPage(getDriver());

    newDashboardPage =
            new NewDashboardPage(getDriver());

    loginToApplication();
}
    // ==========================
    // NAVIGATE BEFORE EACH TEST
    // ==========================

    @BeforeMethod
public void goToDashboard(){
        

    getDriver().get(
        ConfigReader.getProperty(
                "dashboardUrl"));

    
}

    // ==========================
    // CLOSE BROWSER ONCE
    // ==========================

    @AfterClass
    public void tearDown() {

        closeBrowser();
    }

    // ==========================
    // BLANK NAME TEST
    // ==========================

    @Test
    public void testBlankDashboardName(){
            

        dashboardPage.clickNewDashboard();

        newDashboardPage.waitForModal();

        // Leave name blank and click create
        newDashboardPage.clickCreateDashboard();

        
        boolean modalStillOpen =
                !newDashboardPage.isModalClosed();

        boolean errorShown =
                newDashboardPage.isValidationErrorShown();

        System.out.println(
                "Modal still open: "
                + modalStillOpen);

        System.out.println(
                "Error shown: " + errorShown);

        System.out.println(
                "Validation message: "
                + newDashboardPage
                        .getValidationErrorText());

        Assert.assertTrue(
                modalStillOpen || errorShown,
                "Blank name was accepted — "
                + "dashboard should NOT be created");

        System.out.println(
                "Blank name test passed");
    }

    // ==========================
    // SPACES ONLY TEST
    // ==========================

    @Test
    public void testSpacesOnlyDashboardName(){
            

        dashboardPage.clickNewDashboard();

        newDashboardPage.waitForModal();

        newDashboardPage.enterDashboardName(
                "     ");

        newDashboardPage.clickCreateDashboard();

        
        boolean modalStillOpen =
                !newDashboardPage.isModalClosed();

        boolean errorShown =
                newDashboardPage.isValidationErrorShown();

        System.out.println(
                "Modal still open: "
                + modalStillOpen);

        System.out.println(
                "Error shown: " + errorShown);

        System.out.println(
                "Validation message: "
                + newDashboardPage
                        .getValidationErrorText());

        Assert.assertTrue(
                modalStillOpen || errorShown,
                "Spaces only name was accepted");

        System.out.println(
                "Spaces only test passed");
    }

    // ==========================
    // SPECIAL CHARACTERS TEST
    // ==========================

    @Test
    public void testSpecialCharactersDashboardName(){
            

        dashboardPage.clickNewDashboard();

        newDashboardPage.waitForModal();

        newDashboardPage.enterDashboardName(
                "@#$%^&*()");

        newDashboardPage.clickCreateDashboard();

        
        // App should not crash
        String currentURL = getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "App crashed on special characters");

        System.out.println(
                "Special characters test passed");
    }

    // ==========================
    // LONG NAME TEST
    // ==========================

    @Test
    public void testLongDashboardName(){
           

        dashboardPage.clickNewDashboard();

        newDashboardPage.waitForModal();

        String longName = "a".repeat(200);

        newDashboardPage.enterDashboardName(longName);

        newDashboardPage.clickCreateDashboard();

        
        // App should not crash
        String currentURL = getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "App crashed on long name");

        System.out.println(
                "Long name test passed");
    }

    // ==========================
    // CANCEL BUTTON TEST
    // ==========================

    @Test
    public void testCancelButton(){
            

        dashboardPage.clickNewDashboard();

        newDashboardPage.waitForModal();

        
        newDashboardPage.clickCancel();

        

        boolean modalClosed =
                newDashboardPage.isModalClosed();

        Assert.assertTrue(
                modalClosed,
                "Modal did not close after Cancel");

        System.out.println(
                "Cancel button test passed");
    }

    // ==========================
    // CLOSE BUTTON TEST
    // ==========================

    @Test
    public void testCloseButton(){
            

        dashboardPage.clickNewDashboard();

        newDashboardPage.waitForModal();

        
        newDashboardPage.clickClose();

        
        boolean modalClosed =
                newDashboardPage.isModalClosed();

        Assert.assertTrue(
                modalClosed,
                "Modal did not close after X button");

        System.out.println(
                "Close button test passed");
    }

    // ==========================
    // GOOGLE ADS DROPDOWN TEST
    // ==========================

    @Test
    public void testGoogleAdsDropdown(){
            

        dashboardPage.clickNewDashboard();

        newDashboardPage.waitForModal();

        newDashboardPage.clickGoogleAdsDropdown();

        
        String currentURL = getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "App crashed on Google Ads dropdown");

        System.out.println(
                "Google Ads dropdown test passed");
    }

    // ==========================
    // GA4 DROPDOWN TEST
    // ==========================

    @Test
    public void testGA4Dropdown(){
            

        dashboardPage.clickNewDashboard();

        newDashboardPage.waitForModal();

        newDashboardPage.clickGA4Dropdown();

       
        String currentURL = getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "App crashed on GA4 dropdown");

        System.out.println(
                "GA4 dropdown test passed");
    }
}