package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.ContactManagementPage;
import com.qa.utilities.ConfigReader;
import com.qa.locators.ContactManagementLocators;

public class ContactManagementNegativeTest
        extends BaseTest {

    ContactManagementPage contactPage;

    // ==========================
    // LOGIN ONCE
    // ==========================

    @BeforeClass
public void setup() {

    setupBrowser();

    contactPage =
            new ContactManagementPage(getDriver());

    loginToApplication();
}
    // ==========================
    // NAVIGATE BEFORE EACH TEST
    // ==========================

  @BeforeMethod
public void goToDashboard() {

    System.out.println(
        "BeforeMethod URL: "
        + getDriver().getCurrentUrl());

    getDriver().get(
        ConfigReader.getProperty(
                "dashboardUrl"));

    System.out.println(
        "After navigation URL: "
        + getDriver().getCurrentUrl());
}

    // ==========================
    // CLOSE BROWSER ONCE
    // ==========================

    @AfterClass
    public void tearDown() {

        closeBrowser();
    }

    // ==========================
    // CLOSE PANEL WITH X TEST
    // ==========================

    @Test
    public void testClosePanelWithX()
            throws InterruptedException {

        contactPage.openContactsPanel();
        contactPage.waitForPanel();

        Assert.assertTrue(
                contactPage.isPanelOpen(),
                "Panel did not open");

        contactPage.closePanel();

        Assert.assertTrue(
                contactPage.isPanelClosed(),
                "Panel did not close after X");

        System.out.println(
                "Close panel test passed");
    }

    // ==========================
    // BLANK NAME AND EMAIL TEST
    // ==========================

    @Test
    public void testInviteBlankNameAndEmail()
            throws InterruptedException {

        contactPage.openContactsPanel();
        contactPage.waitForPanel();

        // Leave both blank and click invite
        contactPage.clickInvite();

        Thread.sleep(2000);

        // Panel should still be open
        boolean panelOpen =
                contactPage.isPanelOpen();

        boolean errorShown =
                contactPage.isValidationMessageShown();

        System.out.println(
                "Panel still open: " + panelOpen);

        System.out.println(
                "Error shown: " + errorShown);

        Assert.assertTrue(
                panelOpen || errorShown,
                "Blank invite was accepted");

        System.out.println(
                "Blank name and email test passed");
    }

    // ==========================
    // BLANK EMAIL TEST
    // ==========================

    @Test
    public void testInviteBlankEmail()
            throws InterruptedException {

        contactPage.openContactsPanel();
        contactPage.waitForPanel();

        contactPage.enterName("Test User");

        // Leave email blank
        contactPage.clickInvite();

        Thread.sleep(2000);

        boolean panelOpen =
                contactPage.isPanelOpen();

        boolean errorShown =
                contactPage.isValidationMessageShown();

        System.out.println(
                "Panel still open: " + panelOpen);

        System.out.println(
                "Error shown: " + errorShown);

        Assert.assertTrue(
                panelOpen || errorShown,
                "Invite without email was accepted");

        System.out.println(
                "Blank email test passed");
    }

    // ==========================
    // BLANK NAME TEST
    // ==========================

    @Test
    public void testInviteBlankName()
            throws InterruptedException {

        contactPage.openContactsPanel();
        contactPage.waitForPanel();

        contactPage.enterEmail(
                "test@example.com");

        // Leave name blank
        contactPage.clickInvite();

        Thread.sleep(2000);

        boolean panelOpen =
                contactPage.isPanelOpen();

        boolean errorShown =
                contactPage.isValidationMessageShown();

        System.out.println(
                "Panel still open: " + panelOpen);

        System.out.println(
                "Error shown: " + errorShown);

        Assert.assertTrue(
                panelOpen || errorShown,
                "Invite without name was accepted");

        System.out.println(
                "Blank name test passed");
    }

    // ==========================
    // INVALID EMAIL FORMAT TEST
    // ==========================

    @Test
    public void testInviteInvalidEmailFormat()
            throws InterruptedException {

        contactPage.openContactsPanel();
        contactPage.waitForPanel();

        contactPage.enterName("Test User");
        contactPage.enterEmail("notanemail");

        contactPage.clickInvite();

        Thread.sleep(2000);

        // App should not crash
        String currentURL = getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "App crashed on invalid email");

        System.out.println(
                "Invalid email format test passed");
    }

    // ==========================
    // SPACES ONLY TEST
    // ==========================

    @Test
    public void testInviteWithSpacesOnly()
            throws InterruptedException {

        contactPage.openContactsPanel();
        contactPage.waitForPanel();

        contactPage.enterName("     ");
        contactPage.enterEmail("     ");

        contactPage.clickInvite();

        Thread.sleep(2000);

        boolean panelOpen =
                contactPage.isPanelOpen();

        boolean errorShown =
                contactPage.isValidationMessageShown();

        Assert.assertTrue(
                panelOpen || errorShown,
                "Spaces only invite was accepted");

        System.out.println(
                "Spaces only test passed");
    }

    // ==========================
    // VERY LONG NAME TEST
    // ==========================

    @Test
    public void testInviteWithVeryLongName()
            throws InterruptedException {

        contactPage.openContactsPanel();
        contactPage.waitForPanel();

        String longName = "a".repeat(200);

        contactPage.enterName(longName);
        contactPage.enterEmail(
                "test@example.com");

        contactPage.clickInvite();

        Thread.sleep(2000);

        // App should not crash
        String currentURL = getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "App crashed on long name");

        System.out.println(
                "Long name test passed");
    }

    // ==========================
    // VERY LONG EMAIL TEST
    // ==========================

    @Test
    public void testInviteWithVeryLongEmail()
            throws InterruptedException {

        contactPage.openContactsPanel();
        contactPage.waitForPanel();

        contactPage.enterName("Test User");

        String longEmail =
                "a".repeat(190) + "@test.com";

        contactPage.enterEmail(longEmail);

        contactPage.clickInvite();

        Thread.sleep(2000);

        // App should not crash
        String currentURL = getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "App crashed on long email");

        System.out.println(
                "Long email test passed");
    }

    // ==========================
    // SPECIAL CHARACTERS TEST
    // ==========================

    @Test
    public void testInviteWithSpecialCharacters()
            throws InterruptedException {

        contactPage.openContactsPanel();
        contactPage.waitForPanel();

        contactPage.enterName("!@#$%^&*()");
        contactPage.enterEmail("!@#$%^&*()");

        contactPage.clickInvite();

        Thread.sleep(2000);

        // App should not crash
        String currentURL = getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "App crashed on special characters");

        System.out.println(
                "Special characters test passed");
    }

    // ==========================
    // NEW TAB IS DEFAULT TEST
    // ==========================

    @Test
    public void testNewTabIsDefault()
            throws InterruptedException {

        contactPage.openContactsPanel();
        contactPage.waitForPanel();

        // Name and email fields should be visible
        // by default (New tab active)
        boolean nameVisible =
                getDriver().findElements(
                        ContactManagementLocators
                                .nameInput)
                        .size() > 0;

        Assert.assertTrue(
                nameVisible,
                "New tab is not active by default");

        System.out.println(
                "New tab default test passed");
    }

    // ==========================
    // EXISTING TAB CLICKABLE TEST
    // ==========================

    @Test
    public void testExistingTabClickable()
            throws InterruptedException {

        contactPage.openContactsPanel();
        contactPage.waitForPanel();

        contactPage.clickExistingTab();

        Thread.sleep(1000);

        // App should not crash
        String currentURL = getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "App crashed on Existing tab click");

        System.out.println(
                "Existing tab test passed");
    }

    // ==========================
    // WITHDRAW INVITATION TEST
    // ==========================

    //@Test
    public void testWithdrawInvitation()
            throws InterruptedException {

        contactPage.openContactsPanel();
        contactPage.waitForPanel();

        // Check outstanding invitations visible
        boolean invitationsVisible =
                getDriver().findElements(
                        ContactManagementLocators
                                .outstandingInvitations)
                        .size() > 0;

        System.out.println(
                "Invitations visible: "
                + invitationsVisible);

        if (invitationsVisible) {

            contactPage.clickWithdrawInvitation();

            Thread.sleep(2000);

            // App should not crash
            String currentURL =
                    getDriver().getCurrentUrl();

            Assert.assertTrue(
                    currentURL.contains("dashboard"),
                    "App crashed on withdraw");

            System.out.println(
                    "Withdraw invitation test passed");

        } else {

            System.out.println(
                    "No pending invitations found "
                    + "— skipping withdraw test");
        }
    }
}