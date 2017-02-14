package atdd.framework;

import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.Before;



/**
 * 
 * @author schak38
 *
 */
public class GlobalBeforeHook implements BeforeHook {
	
	@Autowired 
	MRScenario globalScenario;
	

	public MRScenario getGlobalScenario() {
		return globalScenario;
	}

	public void setGlobalScenario(MRScenario globalScenario) {
		this.globalScenario = globalScenario;
	}

	@Before
	public void setup() throws Exception {
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					
					//globalScenario.removeMember();
					//TODO:: add de-register logic here 
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
	}
	
	
}
