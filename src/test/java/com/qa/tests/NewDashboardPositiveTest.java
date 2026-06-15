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

public class NewDashboardPositiveTest extends BaseTest {

    DashboardPage dashboardPage;
    NewDashboardPage newDashboardPage;
    
    // ==========================
    // LOGIN ONCE
    // ==========================

@BeforeClass
public void setup(){
        

    setupBrowser();

    dashboardPage =
            new DashboardPage(driver);

    newDashboardPage =
            new NewDashboardPage(driver);

    loginToApplication();
}
    // ==========================
    // NAVIGATE BEFORE EACH TEST
    // ==========================

    @BeforeMethod
public void goToDashboard(){
        

    driver.get(
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

     
@Test
public void verifyNewDashboardModalOpens() {

    dashboardPage.clickNewDashboard();

    newDashboardPage.waitForModal();

    Assert.assertFalse(
            newDashboardPage.isModalClosed(),
            "New Dashboard modal did not open");

    System.out.println(
            "New Dashboard modal opens test passed");
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

        
        String currentURL = driver.getCurrentUrl();

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

       
        String currentURL = driver.getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "App crashed on GA4 dropdown");

        System.out.println(
                "GA4 dropdown test passed");
    }
}