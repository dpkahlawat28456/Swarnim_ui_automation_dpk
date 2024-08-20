package listeners;

import java.util.HashSet;
import java.util.Set;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomReportListener implements ITestListener {

	// Set to track the test results to avoid logging retries
	private Set<ITestResult> loggedResults = new HashSet<>();
	
	@Override
	public void onTestStart(ITestResult result) {
		// Do nothing
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logResult(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logResult(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logResult(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// Do nothing
	}

	@Override
	public void onStart(ITestContext context) {
		// Do nothing
	}

	@Override
	public void onFinish(ITestContext context) {
		// Finalize reports if needed
	}
	
	
	
	private void logResult(ITestResult result) {
		// Check if the result is already logged
		if (!loggedResults.contains(result)) {
			// Add the result to the set
			loggedResults.add(result);

			// Log the final result of the test case
			if (result.isSuccess()) {
				System.out.println("Test Passed: " + result.getName());
			} else if (result.getStatus() == ITestResult.FAILURE) {
				System.out.println("Test Failed: " + result.getName());
			} else if (result.getStatus() == ITestResult.SKIP) {
				System.out.println("Test Skipped: " + result.getName());
			}
		}
	}

}
