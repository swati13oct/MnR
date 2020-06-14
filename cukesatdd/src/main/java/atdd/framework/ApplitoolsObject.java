package atdd.framework;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

public class ApplitoolsObject {

	private static Eyes eyes;
	private BatchInfo batch;
	static WebDriver webDriver;
	
	public static final String USERNAME = "ucpadmin";

	public static final String ACCESS_KEY = "2817affd-616e-4c96-819e-4583348d7b37";

	public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY
			+ "@ondemand.saucelabs.com:443/wd/hub";
	
	private Map<String, Object> scenarioObjectMap = new HashMap<String, Object>();
	
	public ApplitoolsObject(){
		eyes = new Eyes();
		eyes.setApiKey("sAdOjZCjfkyK5G111xeuEgLb4OcNhdPNzO6c0CaCovsds110");
		
	}
	
	public void setApplitools(){
		eyes.setMatchTimeout(3000);	
	}
	
	public void setBatch(String batchName){
		batch = new BatchInfo(batchName);
		eyes.setBatch(batch);
	}
	
	public void printBatchName(){
		System.out.println(batch.getName());
	}
	
	public void takeScreenshotFullPage(WebDriver wd, String appName, String testName, String windowName ){
			eyes.setMatchLevel(MatchLevel.CONTENT);
			
			eyes.setForceFullPageScreenshot(true);
			eyes.setWaitBeforeScreenshots(4000);
			eyes.open(wd, appName, testName,new RectangleSize(1280, 960));
			eyes.checkWindow(windowName);
			eyes.close(false);
		
	}
	
	public void takeScreenshot(WebDriver wd, String appName, String testName, String windowName){
		
			eyes.setForceFullPageScreenshot(false);
			eyes.setWaitBeforeScreenshots(2000);
			eyes.setMatchLevel(MatchLevel.CONTENT);
			eyes.open(wd, appName, testName,new RectangleSize(1280, 960));
			eyes.checkWindow(windowName);
			eyes.close(false);
		
		
	}
	public void takeScreenshotFullPage(WebDriver wd, String appName, String testName, String windowName, boolean takeScreenshot ){
		if(takeScreenshot==true){
			eyes.setMatchLevel(MatchLevel.CONTENT);
			eyes.setForceFullPageScreenshot(true);
			eyes.setWaitBeforeScreenshots(2000);
			eyes.open(wd, appName, testName,new RectangleSize(1280, 960));
			eyes.checkWindow(windowName);
			eyes.close(false);
		}
	}
	
	public void takeScreenshot(WebDriver wd, String appName, String testName, String windowName, boolean takeScreenshot){
		if(takeScreenshot==true){
			eyes.setForceFullPageScreenshot(false);
			eyes.setWaitBeforeScreenshots(2000);
			eyes.setMatchLevel(MatchLevel.CONTENT);
			eyes.open(wd, appName, testName,new RectangleSize(1280, 960));
			eyes.checkWindow(windowName);
			eyes.close(false);
		}
		
	}

	public WebDriver getWebDriver() {

		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability("platform", "Windows 7");
		capabilities.setCapability("version", "66.0");
		capabilities.setCapability("screenResolution", "2560x1600");
		capabilities.setCapability("parent-tunnel", "sauce_admin");
		capabilities.setCapability("tunnelIdentifier",
				"OptumSharedTunnel-Stg");
		//capabilities.setCapability("name", "MRATDD-TestSuite");
		capabilities.setCapability("build", System.getenv("JOB_NAME") + "__" + System.getenv("RUNNER_NUMBER"));
		String jobName = "VBF Execution - Using " + capabilities.getBrowserName() + " in  " + System.getProperty("environment") +" environment";
		capabilities.setCapability("name", jobName);
		try {
			webDriver = new RemoteWebDriver(new URL(URL), capabilities);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return webDriver;

	}
	public void saveBean(String id, Object object) {
		scenarioObjectMap.put(id, object);
	}
	
	public Object getBean(String id) {
		Object result = scenarioObjectMap.get(id);
		if (result == null) {
			System.out.println("Object not initialized");
		}
		return result;

	}
}
