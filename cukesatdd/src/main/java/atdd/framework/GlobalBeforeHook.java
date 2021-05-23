package atdd.framework;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * 
 * @author schak38
 *
 */
public class GlobalBeforeHook implements BeforeHook {

	@Autowired
	MRScenario globalScenario;
	List<String> tagsList = new ArrayList<String>();

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

}
