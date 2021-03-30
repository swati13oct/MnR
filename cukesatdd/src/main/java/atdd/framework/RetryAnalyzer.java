package atdd.framework;

import java.util.concurrent.atomic.AtomicInteger;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

	int counter = 0;
	boolean initialCounter = false;
	private AtomicInteger retryCounter;

	
	private ThreadLocal<Boolean> counterInitiliazed = new ThreadLocal<Boolean>() {
		@Override
		public Boolean initialValue() {
			return Boolean.valueOf(initialCounter);
		}
	};
	
	/**
	 * Sets the boolean counter for retry.
	 *
	 * Here we are setting the boolean to true if retry counter is initialized.
	 *
	 * Since we are having dynamic count for retry which we pass via our test runner using annotation, RetryCountIfFailed.
	 * if we get the value of this annotation in the overridden method retry, for each iteration the value will be initialized
	 * thus the script will be in infinite retry loop.
	 * 
	 * @param result if boolean retry counter is set
	 */
	private void setRetryCounter(ITestResult result) {
		if (!counterInitiliazed.get()) {
			RetryCountIfFailed retryClass = (RetryCountIfFailed) result.getTestClass().getRealClass()
					.getAnnotation(RetryCountIfFailed.class);
			if (retryClass != null) {
				retryCounter = new AtomicInteger(retryClass.value());
			} else {
				// If we are not having annotation in runner class, set retry counter to 0 and print warning message
				retryCounter = new AtomicInteger(0);
				System.out.println("Retry counter not set for runner - " + result.getTestClass().getName()
						+ ", add annotation to runner class !");
			}
			counterInitiliazed.set(Boolean.TRUE);
		}
	}
	
	
	@Override
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()) {
			setRetryCounter(result);
			if (0 < retryCounter.getAndDecrement()) {
				System.out.println("Retrying for test runner: " + result.getTestClass().getName());
				result.setStatus(ITestResult.SKIP);
				return true;
			} else {
				result.setStatus(ITestResult.FAILURE);
			}
			
			/** All tests that are retried after failures will appear in the skipped tests
			 list. This causes 'TestNG' to report those retry attempts as skipped tests.
			 Here we will explicitly remove the retry test from the skipped tests list so
			 that TestNG doesn't report retry attempts as skipped attempts.
			 The line below simply does that. */
			result.getTestContext().getSkippedTests().removeResult(result.getMethod());
		} else {
			result.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}
}
