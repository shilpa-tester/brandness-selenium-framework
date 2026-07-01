package com.qa.locators;

import org.openqa.selenium.By;

public class ContactManagementLocators {

    // Contacts button in dashboard row
    // uses lucide-users SVG class
    public static By contactsButton =
            By.xpath(
                "(//button[.//*[contains("
                + "@class,'lucide-users')]])[1]");

    // Panel title
    public static By panelTitle =
            By.xpath(
                "//*[contains(text(),"
                + "'Manage customer access') "
                + "or contains(text(),"
                + "'Klanttoegang beheren')]");

    // Close panel button X top right
    public static By closePanelButton =
            By.xpath(
                "//button[contains(@class,"
                + "'absolute') and contains"
                + "(@class,'right')]");

    // Name input field
    public static By nameInput =
            By.xpath(
                "//input[@placeholder="
                + "'E.g. Jan de Vries' "
                + "or @placeholder="
                + "'Bijv. Jan de Vries']");

    // Email input field
    public static By emailInput =
            By.xpath(
                "//input[@placeholder="
                + "'jan@voorbeeld.nl']");

    // Invite button
    public static By inviteButton =
            By.xpath(
                "//button[contains(.,'To invite') "
                + "or contains(.,'Uitnodigen')]");

    // Withdraw invitation button
    public static By withdrawInviteButton =
            By.xpath(
                "//div[contains(@class,'rounded-lg')]"
                + "//button[contains(@class,'text-')]");

 // New tab - scoped to tablist to avoid
// matching "New Dashboard" button
public static By newTab =
        By.xpath(
            "//div[@role='tablist']"
            + "//button[contains(.,'New') "
            + "or contains(.,'Nieuw')]");

    // Existing tab
    public static By existingTab =
            By.xpath(
                "//button[contains(.,'Existing') "
                + "or contains(.,'Bestaand')]");

    // Outstanding invitations section
    public static By outstandingInvitations =
            By.xpath(
                "//*[contains(text(),"
                + "'OUTSTANDING INVITATIONS') "
                + "or contains(text(),"
                + "'OPENSTAANDE UITNODIGINGEN')]");

    // Validation or error message
    public static By validationMessage =
            By.xpath(
                "//*[contains(@class,'error') "
                + "or contains(@class,'invalid') "
                + "or contains(@class,'destructive') "
                + "or contains(@class,'warning')]");

    // Existing user email in panel
    public static By existingUserEmail =
            By.xpath(
                "//*[contains(text(),"
                + "'pvadakoote@thoughtlinedigital.com')]");

    // Contacts count button in row
    public static By contactsCountButton =
            By.xpath(
                "(//button[.//*[contains("
                + "@class,'lucide-users')]])[1]");

                // First plus button in Existing tab
public static By firstExistingUserAddButton =
        By.xpath("(//button[.//*[contains(@class,'lucide-plus')]])[1]");

// First delete button in Existing tab
public static By firstExistingUserDeleteButton =
        By.xpath("(//button[.//*[contains(@class,'lucide-trash')]])[1]");

// Any panel card/user row
public static By userCard =
        By.xpath("//div[contains(@class,'rounded-lg')]");

}