package atdd.framework;
import org.openqa.selenium.WebDriver;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.MatchLevel;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.selenium.Eyes;

public class ApplitoolsObject {

	private static Eyes eyes;
	
	public ApplitoolsObject(){
		eyes = new Eyes();
		eyes.setApiKey("sAdOjZCjfkyK5G111xeuEgLb4OcNhdPNzO6c0CaCovsds110");

	}
	public void setApplitools(){
		
		eyes.setMatchTimeout(3000);
		eyes.setForceFullPageScreenshot(true);
		eyes.setWaitBeforeScreenshots(4000);
	}
	
	public void setBatch(String batchName){
		BatchInfo batch = new BatchInfo(batchName);
		eyes.setBatch(batch);
	}
	
	public void takeScreenshot(WebDriver wd, String appName, String testName, String windowName ){
		eyes.setMatchLevel(MatchLevel.CONTENT);
		eyes.open(wd, appName, testName,new RectangleSize(1280, 960));
		eyes.checkWindow(windowName);
		eyes.close();
	}

}
