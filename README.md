# Brandness Automation Framework

## Overview

This project is a Selenium WebDriver Test Automation Framework developed using Java, TestNG, Maven, and Extent Reports.

The framework follows the Page Object Model (POM) design pattern and supports:

- Positive and Negative Test Scenarios
- Extent Reports
- Screenshot Capture on Failure
- TestNG Listeners
- Logger Utility
- Reusable BasePage Architecture
- Maven Execution
- Cross-module Regression Execution

---

## Tech Stack

| Technology | Version |
|------------|----------|
| Java | 17 |
| Selenium WebDriver | Latest |
| TestNG | Latest |
| Maven | Latest |
| Extent Reports | Latest |
| WebDriverManager | Latest |

---

## Framework Architecture

```
src/test/java
│
├── base
│   └── BaseTest.java
│
├── locators
│   ├── LoginPageLocators.java
│   ├── DashboardPageLocators.java
│   ├── ContactManagementLocators.java
│   └── NewDashboardLocators.java
│
├── pages
│   ├── BasePage.java
│   ├── LoginPage.java
│   ├── DashboardPage.java
│   ├── ContactManagementPage.java
│   └── NewDashboardPage.java
│
├── tests
│   ├── BrandnessPositiveLoginTest.java
│   ├── NegativeLoginTest.java
│   ├── DashboardTestPositive.java
│   ├── DashboardNegativeTest.java
│   ├── ContactManagementPositiveTest.java
│   ├── ContactManagementNegativeTest.java
│   ├── NewDashboardPositiveTest.java
│   └── NewDashboardNegativeTest.java
│
└── utilities
    ├── ConfigReader.java
    ├── Logger.java
    ├── WaitUtility.java
    ├── ScreenshotUtility.java
    ├── ExtentManager.java
    └── TestListener.java
```

---

## Features Implemented

### Page Object Model (POM)

All web page interactions are separated into dedicated page classes.

Benefits:

- Better maintainability
- Reusable methods
- Cleaner test scripts

---

### BasePage

Common page functionality is centralized in:

```java
BasePage.java
```

Examples:

- Wait Methods
- Click Methods
- SendKeys Methods
- Scroll Utilities

---

### Logger Utility

Framework-wide logging support.

Examples:

```java
Logger.info("Dashboard opened");

Logger.pass("Login Successful");

Logger.fail("Test Failed");
```

---

### Screenshot Capture

Automatic screenshot capture during test failures.

Location:

```
target/screenshots
```

Example:

```
verifyConfigureButton.png
```

---

### Extent Reports

Report generated automatically after execution.

Location:

```
target/ExtentReport.html
```

Includes:

- Pass/Fail Status
- Categories
- Exception Details
- Screenshot Attachments

---

### TestNG Listener

Implemented using:

```java
ITestListener
```

Functions:

- onTestStart()
- onTestSuccess()
- onTestFailure()
- onFinish()

---

## Test Modules

### Login Module

Positive:

- Valid Login

Negative:

- Invalid Email
- Invalid Password
- Empty Credentials

---

### Dashboard Module

Positive:

- Contacts Button
- Configure Button
- Delete Button
- Search Dashboard
- New Dashboard Button
- Pagination

Negative:

- Invalid Search
- Empty Search
- Pagination Validation

---

### Contact Management Module

Positive:

- Open Panel
- Invite User
- Withdraw Invitation
- Existing User Flow

Negative:

- Empty Name
- Empty Email
- Invalid Email
- Validation Checks

---

### New Dashboard Module

Positive:

- Open Modal
- Close Modal
- Cancel Button
- Dropdown Validation

Negative:

- Mandatory Field Validation
- Invalid Input Validation

---

## Running Tests

### Execute Complete Regression

```bash
mvn clean test
```

---

### Execute Individual Test Class

```bash
mvn clean test -Dtest=BrandnessPositiveLoginTest
```

Example:

```bash
mvn clean test -Dtest=DashboardTestPositive
```

---

## Regression Execution Summary

Latest Framework Validation:

```
Tests Run : 53
Failures  : 0
Errors    : 0

BUILD SUCCESS
```

---

## Future Enhancements

- Jenkins CI/CD Integration
- GitHub Actions
- Cross Browser Execution
- Parallel Execution
- Data Driven Framework
- API Automation Integration
- Docker Execution

---

## Author

Shilpa

Automation Test Engineer

Built using Selenium WebDriver + TestNG + Maven