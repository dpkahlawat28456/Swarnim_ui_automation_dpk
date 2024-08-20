package listeners;

import com.aventstack.extentreports.Status;

import report.ExtentManager;
import report.ExtentTestManager;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        // Start the test in the report
        ExtentTestManager.startTest(result.getMethod().getMethodName(), null);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        if (result.getMethod().getRetryAnalyzer(result) == null || !result.getMethod().getRetryAnalyzer(result).retry(result)) {
            // Log only the final result
            ExtentTestManager.getTest().log(Status.PASS, "Test passed");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        if (result.getMethod().getRetryAnalyzer(result) == null || !result.getMethod().getRetryAnalyzer(result).retry(result)) {
            // Log only the final result
            ExtentTestManager.getTest().log(Status.FAIL, "Test failed: " + result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log the skipped test
        ExtentTestManager.getTest().log(Status.SKIP, "Test skipped: " + result.getThrowable());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Handle partial success scenarios if needed
    }

    @Override
    public void onStart(ITestContext context) {
        // On start of the test
    }

    @Override
    public void onFinish(ITestContext context) {
        // On finish of the test
        ExtentTestManager.endTest();
        ExtentManager.report().flush();
    }
}
