package com.qa.locators;

import org.openqa.selenium.By;

public class NewDashboardLocators {

    // New Dashboard Button (on dashboard list page)
    public static By newDashboardBtn =
            By.cssSelector("button.bg-primary");

    // Dashboard Name Input
    public static By dashboardName =
            By.xpath(
                "//input[@placeholder="
                + "'Bijv. Ferrari Dashboard']");

    // Annuleren (Cancel) Button
    public static By cancelBtn =
            By.xpath(
                "//button[contains(.,'Annuleren')]");

    // Dashboard aanmaken (Create) Button
    public static By createDashboardBtn =
            By.xpath(
                "//button[contains(."
                + ",'Dashboard aanmaken')]");

    // Close (X) Button
    public static By closeBtn =
            By.xpath(
                "//button[contains(@class,'absolute')]"
                + "[.//*[name()='svg']]");

    // Google Ads Dropdown
    public static By googleAdsDropdown =
            By.xpath(
                "//button[contains(.,"
                + "'Selecteer Google Ads account')]");

    // GA4 Dropdown
    public static By ga4Dropdown =
            By.xpath(
                "//button[contains(.,"
                + "'Selecteer GA4 property')]");

    // Validation error message
    public static By validationError =
            By.xpath(
                "//*[contains(@class,'error') "
                + "or contains(@class,'invalid') "
                + "or contains(@class,'destructive')]");

    // Modal/Popup container
    public static By modalContainer =
            By.xpath(
                "//*[contains(text(),"
                + "'Nieuw Dashboard Aanmaken')]");

}