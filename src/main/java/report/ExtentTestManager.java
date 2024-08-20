package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

    private static ExtentReports extent = ExtentManager.report();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static synchronized ExtentTest getTest() {
        return test.get();
    }

    public static synchronized void endTest() {
        extent.flush();
    }

    public static synchronized ExtentTest startTest(String testName, String desc) {
        ExtentTest extentTest = extent.createTest(testName, desc);
        test.set(extentTest);
        return extentTest;
    }
}
