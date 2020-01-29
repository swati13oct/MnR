package atdd.framework;

import java.util.ArrayList;
import java.util.List;

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
	static List<String> tagsList=new ArrayList<String>();

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
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
	}
		
		@Before
		public static List<String> beforeGlobal(cucumber.api.Scenario scenario){
	           tagsList.clear();
	        for(String tag : scenario.getSourceTagNames()){
	        	
	        	tagsList.add(tag);
	          System.out.print("Tag: " + tag);
	        }
	      
	        	MRScenario.loadCSV();
	       
	       return tagsList;
	    }
	
	
	
}
