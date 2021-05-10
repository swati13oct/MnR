package atdd.framework;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.testng.IAnnotationTransformer;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

public class TestNGMethodListener implements IInvokedMethodListener, IAnnotationTransformer {

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

	}

	/**
	 * Set the name of the runner class
	 * before the method annotated with @Test from runner class is invoked
	 * */
	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
		MRScenario.setRunnerFileName(testResult.getTestClass().getRealClass().getSimpleName());
	}

	
	
	/**
	 * This is an implementation for transform method from IAnnotationTransformer interface, 
	 * it is capable of handling the execution of a Test runner based on the microapps parameter from POM.
	 * 
	 * If the runner name contains the micro app name, then it will be executed. If not, it will be skipped.
	 * 
	 * If no value for property microapps is passed, it will be skipped
	 */
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		String MicroApps = System.getProperty("microapps");
		List<String> selectedMicroApps =  MicroApps.isEmpty() ? new ArrayList<String>() : Arrays.asList(MicroApps.split(","));
		Set<String> selectedRunners = new HashSet<String>();
		if (!selectedMicroApps.isEmpty()) {
			for (String MicroApp : selectedMicroApps) {
				String runnerFileName = testMethod.getDeclaringClass().getSimpleName();
				if (runnerFileName.contains(MicroApp)) {
					annotation.setEnabled(true);
					selectedRunners.add(runnerFileName);
					System.out.println("Enabling " + runnerFileName + " for " + MicroApp);
				} else {
					if (!selectedRunners.contains(runnerFileName)) {
						System.out.println("Disabling " + runnerFileName + " for " + MicroApp);
						annotation.setEnabled(false);
					}
				}
			}
		}
	}
}
