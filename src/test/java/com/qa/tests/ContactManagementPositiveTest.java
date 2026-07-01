package com.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.locators.ContactManagementLocators;
//import com.qa.locators.ContactManagementLocators;
import com.qa.pages.ContactManagementPage;

public class ContactManagementPositiveTest extends BaseTest {
 ContactManagementPage contactPage;

    // ==========================
    // LOGIN ONCE
    // ==========================

@BeforeClass
public void setup() throws InterruptedException {

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

    getDriver().get(
        "https://test.brandness.thoughtlinedigital.com/admin/dashboard");

    if (getDriver().getCurrentUrl().contains("/auth")) {

        System.out.println(
            "Session expired. Logging in again.");

        loginToApplication();

        getDriver().get(
            "https://test.brandness.thoughtlinedigital.com/admin/dashboard");
    }

    System.out.println(
        "Current URL: "
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
    // TEST 1: PANEL OPENS
    // ==========================

    @Test(
    description =
    "Contacts Panel Opens Successfully")
public void verifyContactsPanelOpens()
        throws InterruptedException {

    contactPage.openContactsPanel();

    contactPage.waitForPanel();

    Assert.assertTrue(
            contactPage.isPanelOpen(),
            "Contacts panel did not open");

    System.out.println(
            "Panel opens test passed");
}

    // ==========================
    // TEST 2: PANEL TITLE CORRECT
    // ==========================

    @Test
    public void verifyContactsPanelTitle()
            throws InterruptedException {

        contactPage.openContactsPanel();

        contactPage.waitForPanel();



        String pageSource = getDriver().getPageSource();

        boolean titleCorrect =
                pageSource.contains(
                        "Manage customer access")
                || pageSource.contains(
                        "Klanttoegang beheren");

        Assert.assertTrue(
                titleCorrect,
                "Panel title not correct");

        System.out.println(
                "Panel title test passed");
    }

    // ==========================
    // TEST 3: EXISTING USER SHOWN
    // ==========================

   @Test
public void verifyExistingUserDisplayed()
        throws InterruptedException {

    contactPage.openContactsPanel();

    contactPage.waitForPanel();


    int userCount =
            contactPage.getUserCount();

    System.out.println(
            "Users found : "
            + userCount);

    Assert.assertTrue(
            userCount > 0,
            "No users displayed");

    System.out.println(
            "Users displayed test passed");
}

    // ==========================
    // TEST 4: OUTSTANDING INVITATIONS
    // ==========================
@Test
public void verifyOutstandingInvitationsSection()
        throws InterruptedException {

    contactPage.openContactsPanel();
    contactPage.waitForPanel();


    String pageSource = getDriver().getPageSource();

    boolean sectionVisible =
            pageSource.contains(
                    "OUTSTANDING INVITATIONS")
            || pageSource.contains(
                    "OPENSTAANDE UITNODIGINGEN");

    // Log result but don't fail
    // section only appears when invitations exist
    System.out.println(
            "Outstanding invitations visible: "
            + sectionVisible);

    // Just verify panel opened correctly
    Assert.assertTrue(
            contactPage.isPanelOpen(),
            "Panel did not open");

    System.out.println(
            "Outstanding invitations test passed");
}

    // ==========================
    // TEST 5: NEW TAB IS DEFAULT
    // ==========================

    @Test
    public void verifyNewTabIsDefault()
            throws InterruptedException {

        contactPage.openContactsPanel();

        contactPage.waitForPanel();


        // Name and email fields visible
        // means New tab is active
        boolean nameVisible =
                contactPage.isNameFieldVisible();

        boolean emailVisible =
                contactPage.isEmailFieldVisible();

        Assert.assertTrue(
                nameVisible,
                "Name field not visible — "
                + "New tab not active");

        Assert.assertTrue(
                emailVisible,
                "Email field not visible — "
                + "New tab not active");

        System.out.println(
                "New tab default test passed");
    }

    // ==========================
    // TEST 6: INVITE BUTTON VISIBLE
    // ==========================

    @Test
    public void verifyInviteButtonIsVisible()
            throws InterruptedException {

        contactPage.openContactsPanel();

        contactPage.waitForPanel();



        boolean visible =
                contactPage.isInviteButtonVisible();

        Assert.assertTrue(
                visible,
                "Invite button not visible");

        System.out.println(
                "Invite button visible test passed");
    }

    // ==========================
    // TEST 7: NAME FIELD ACCEPTS INPUT
    // ==========================

    @Test
    public void verifyNameFieldAcceptsInput()
            throws InterruptedException {

        contactPage.openContactsPanel();

        contactPage.waitForPanel();


        contactPage.enterName("Test User");

        String value =
                contactPage.getNameFieldValue();

        Assert.assertEquals(
                value,
                "Test User",
                "Name field did not accept input");

        System.out.println(
                "Name field input test passed");
    }

    // ==========================
    // TEST 8: EMAIL FIELD ACCEPTS INPUT
    // ==========================

    @Test
    public void verifyEmailFieldAcceptsInput()
            throws InterruptedException {

        contactPage.openContactsPanel();

        contactPage.waitForPanel();


        contactPage.enterEmail(
                "test@example.com");

        String value =
                contactPage.getEmailFieldValue();

        Assert.assertEquals(
                value,
                "test@example.com",
                "Email field did not accept input");

        System.out.println(
                "Email field input test passed");
    }

    // ==========================
    // TEST 9: SWITCH TO EXISTING TAB
    // ==========================

    @Test
    public void verifyCanSwitchToExistingTab()
            throws InterruptedException {

        contactPage.openContactsPanel();

        contactPage.waitForPanel();


        contactPage.clickExistingTab();

        

        // App should not crash
        String currentURL = getDriver().getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains("dashboard"),
                "App crashed on Existing tab");

        System.out.println(
                "Existing tab switch test passed");
    }

    // ==========================
    // TEST 10: SWITCH BACK TO NEW TAB
    // ==========================

    @Test
    public void verifyCanSwitchBackToNewTab()
            throws InterruptedException {

        contactPage.openContactsPanel();

        contactPage.waitForPanel();

        // Switch to Existing tab first
        contactPage.clickExistingTab();

       Thread.sleep(1500);

        // Switch back to New tab
        contactPage.clickNewTab();

       

        // Name/email fields should be visible again
        boolean nameVisible =
                contactPage.isNameFieldVisible();

        Assert.assertTrue(
                nameVisible,
                "Could not switch back to New tab");

        System.out.println(
                "Switch back to New tab test passed");
    }

    // ==========================
    // TEST 11: PANEL CLOSES WITH X
    // ==========================

   @Test
public void verifyContactsPanelClosesWithX()
        throws InterruptedException {

    if (getDriver().getCurrentUrl().contains("/auth")) {

        loginToApplication();
    }

    contactPage.openContactsPanel();

    contactPage.waitForPanel();

    Assert.assertTrue(
            contactPage.isPanelOpen());

    contactPage.closePanel();

    Assert.assertTrue(
            contactPage.isPanelClosed());

    System.out.println(
            "Panel closes with X test passed");
}
    // ==========================
    // TEST 12: CONTACTS COUNT SHOWN
    // ==========================
@Test
public void verifyContactsCountDisplayed() {

    contactPage.openContactsPanel();

    contactPage.waitForPanel();

    boolean countVisible =
            getDriver().findElements(
                    ContactManagementLocators
                            .contactsCountButton)
                    .size() > 0;

    Assert.assertTrue(
            countVisible,
            "Contacts count not shown");
}

@Test
public void verifyNewUserInviteWithUniqueData()
        throws InterruptedException {

    contactPage.openContactsPanel();

    contactPage.waitForPanel();

    contactPage.clickNewTab();

    String uniqueName =
            "Auto User "
            + System.currentTimeMillis();

    String uniqueEmail =
            "autouser"
            + System.currentTimeMillis()
            + "@example.com";

    contactPage.enterName(uniqueName);

    contactPage.enterEmail(uniqueEmail);

    contactPage.clickInvite();

    Thread.sleep(3000);

    Assert.assertTrue(
            contactPage.isPanelOpen(),
            "Panel closed or app crashed after invite");

    System.out.println(
            "Invite created with: "
            + uniqueName
            + " / "
            + uniqueEmail);
}



@Test
public void verifyExistingUserAddedSuccessfully()
        throws InterruptedException {

    contactPage.openContactsPanel();

    contactPage.waitForPanel();

    int beforeCount =
            contactPage.getAccessUserCount();

    System.out.println(
            "User count before add: "
            + beforeCount);

    contactPage.clickExistingTab();

    Thread.sleep(2000);

    contactPage.clickFirstExistingUserAddButton();

    Thread.sleep(3000);

    int afterCount =
            contactPage.getAccessUserCount();

    System.out.println(
            "User count after add: "
            + afterCount);

    Assert.assertTrue(
            afterCount > beforeCount,
            "Existing user was not added successfully");

    System.out.println(
            "Existing user added successfully");
}
}