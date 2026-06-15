package com.qa.utilities;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtility {

    public static String captureScreenshot(
        WebDriver driver,
        String testName) {

    try {

        
        File source =
                ((TakesScreenshot) driver)
                        .getScreenshotAs(
                                OutputType.FILE);

        
        String path =
                "target/screenshots/"
                + testName
                + ".png";

        File destination =
                new File(path);

        destination.getParentFile()
                .mkdirs();

        Files.copy(
                source.toPath(),
                destination.toPath(),
                StandardCopyOption.REPLACE_EXISTING);

                return path;

    } catch (Exception e) {

        e.printStackTrace();

        return null;
    }
}
}