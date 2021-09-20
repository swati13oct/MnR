package atdd.framework;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.acquisition.commonpages.*;
/**
 * 
 * @author schak38
 *
 */
public class GlobalBeforeHook implements BeforeHook {

	@Autowired
	MRScenario globalScenario;
	List<String> tagsList = new ArrayList<String>();

	public WebDriver driver;
	
	public MRScenario getGlobalScenario() {
		return globalScenario;
	}

	public void setGlobalScenario(MRScenario globalScenario) {
		this.globalScenario = globalScenario;
	}

	public void setup() throws Exception {
//		getGlobalScenario().flushBeans();
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					// globalScenario.removeMember();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}

	@Before
	public List<String> beforeGlobal(Scenario scenario) {		
		tagsList.clear();
		for (String tag : scenario.getSourceTagNames()) {
			tagsList.add(tag);
			System.out.print("Tag: " + tag);
		}

		
		scenario.log("Executing scenario using runner : " + MRScenario.getRunnerFileName());
		return tagsList;
	}

	public List<String> getTagsList() {
		return tagsList;
	}

	public void setTagsList(List<String> tagsList) {
		this.tagsList = tagsList;
	}
	
	//@Before
	public void launchBrowser() {
		System.out.println("Launcing Browser");
		WebDriver wd = getGlobalScenario().getWebDriverNew();
		getGlobalScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		
		wd.get("https://www.stage-uhcmedicaresolutions.uhc.com/fsem/featuretest.html");
	}
}
