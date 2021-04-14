package atdd.framework;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;

import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@Configuration
@ComponentScan("atdd.framework")
@Listeners(TestNGMethodListener.class)
public abstract class BaseTestConfig {
	protected TestNGCucumberRunner testNGCucumberRunner;
	
	protected final String ScenarioDataProvider = "scenarios";
	
	public abstract void runCukes(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper);
	
	@BeforeSuite(alwaysRun = true)
	public void setupSuite(ITestContext context) {
		System.out.println("Dataprovider thread count set to : " + context.getSuite().getXmlSuite().getDataProviderThreadCount());
		for(ITestNGMethod method : context.getAllTestMethods()) {
			method.setRetryAnalyzer(new RetryAnalyzer());
		}
	}
	
	@BeforeClass(alwaysRun = true)
	public void setupClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		if (testNGCucumberRunner == null) {
			testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
		}
		return testNGCucumberRunner.provideScenarios();
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
	}

}
