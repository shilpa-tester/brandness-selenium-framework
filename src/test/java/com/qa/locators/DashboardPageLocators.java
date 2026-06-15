package com.qa.locators;

import org.openqa.selenium.By;

public class DashboardPageLocators {

    // Contacts Button
    public static By contactsButton =
            By.xpath(
                "(//button[contains(@class,'rounded-lg')])[1]");

    // Configure Button
    
            public static By configureButton =
        By.cssSelector("button[aria-label*='Configureer']");

    // Delete Button
    public static By deleteButton =
            By.cssSelector(
                "button[aria-label*='Verwijder']");

    // Search Box
    public static By searchBox =
            By.xpath(
                "//input[@placeholder='Zoek dashboards...']");

    // New Dashboard Button
public static By newDashboardButton =
        By.xpath("//button[contains(.,'Nieuw Dashboard')]");

    // Pagination Dropdown
    public static By paginationDropdown =
            By.xpath(
                "//button[contains(.,'per...') "
                + "or contains(.,'per pagina')]");

    // Pagination Option
    public static By pagination25 =
            By.xpath("//div[text()='25 per pagina']");

    // Dashboard table rows
    public static By dashboardRows =
            By.xpath("//table//tbody//tr");

    // No results message
    public static By noResultsMessage =
            By.xpath(
                "//*[contains(text(),'geen') "
                + "or contains(text(),'Geen') "
                + "or contains(text(),'no results') "
                + "or contains(text(),'not found')]");

    // Dashboard name cells
    public static By dashboardNameCells =
            By.xpath("//table//tbody//tr//td[1]");

}