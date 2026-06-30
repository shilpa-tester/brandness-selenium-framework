package com.qa.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("target/ExtentReport.html");

            spark.config().setReportName(
                    "Brandness Automation Smoke Report");

            spark.config().setDocumentTitle(
                    "Brandness Test Execution Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Application", "Brandness");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
            extent.setSystemInfo("Language", "Java");
            extent.setSystemInfo("Browser", "Chrome");
            extent.setSystemInfo("Tester", "Shilpa");
            extent.setSystemInfo("Execution Type", "Smoke Suite");
            extent.setSystemInfo("Environment", "QA");
        }

        return extent;
    }
}