package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class ExtentReportManager {

    private static ExtentReports extentReports;
    private static ExtentTest test;

    public static void initExtentReport() {
        String path = System.getProperty("user.dir") + "\\reports\\extendReport.html";
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(path);
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
    }

    public static void flush() {
        extentReports.flush();
    }

    public static void createTest(String name) {
        test = extentReports.createTest(name);
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static void attachScreenshot() {
        test.addScreenCaptureFromPath(getScreenshot());
    }

    static int i = 1;
    public static String getScreenshot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager.getDriver();
        File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String filePath = "src\\test\\resources\\screenshots\\screenshot" + (i++) + ".png";
        try {
            FileUtils.copyFile(file, new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return System.getProperty("user.dir") + "\\" + filePath;
    }

}
