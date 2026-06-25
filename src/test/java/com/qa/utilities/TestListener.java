package com.qa.utilities;

import com.qa.base.BaseTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestListener implements ITestListener {

    ExtentReports extent =
            ExtentManager.getInstance();

    ExtentTest test;

    @Override
public void onFinish(
        ITestContext context) {

    extent.flush();
}

    
    @Override
public void onTestStart(
        ITestResult result) {

    System.out.println(
            "Extent Listener Running");

    String testName =
        result.getMethod()
                .getDescription();

if (testName == null
        || testName.trim().isEmpty()) {

    testName =
            result.getMethod()
                    .getMethodName();
}
String parameters =
        java.util.Arrays.toString(
                result.getParameters());

test = extent.createTest(
        testName + " " + parameters);

    String className =
            result.getTestClass()
                    .getRealClass()
                    .getSimpleName();

    if (className.contains("Login")) {

        test.assignCategory("LOGIN");

    } else if (className.contains("Dashboard")
            && !className.contains("NewDashboard")) {

        test.assignCategory("DASHBOARD");

    } else if (className.contains("ContactManagement")) {

        test.assignCategory(
                "CONTACT MANAGEMENT");

    } else if (className.contains("NewDashboard")) {

        test.assignCategory(
                "NEW DASHBOARD");
    }
}

    @Override
    public void onTestSuccess(
            ITestResult result) {

        test.pass("Test Passed");
    }


    @Override
public void onTestFailure(
        ITestResult result) {

    System.out.println(
            "Inside onTestFailure");

    if (test != null) {

        test.fail(
                result.getThrowable());

        String screenshotPath =
                ScreenshotUtility
                        .captureScreenshot(
                                BaseTest.getDriver(),
                                result.getName());

        try {

           test.fail("Screenshot below");

if (screenshotPath != null) {
    test.addScreenCaptureFromPath(
            screenshotPath,
            "Failure Screenshot");
}

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    System.out.println(
            "Failed Test: "
            + result.getName());
}
}