package atdd.framework;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.atdd.util.CommonUtility;
import cucumber.api.java.Before;



/**
 * 
 * @author schak38
 *
 */
public class GlobalBeforeHook implements BeforeHook {
	
	private static final String VERSION_FILE_PATH = "target//version.txt";
	
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
		
		File f = new File(VERSION_FILE_PATH);
		if(!f.exists()){
			CommonUtility.createVersionFile(globalScenario);
		}
		
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				try {
					
					//globalScenario.removeMember();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
	}
	
	
}
