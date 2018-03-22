package acceptancetests.acquisitionvbf.common;

import org.springframework.beans.factory.annotation.Autowired;
import atdd.framework.MRScenario;

/**
 *Functionality:Attend Community Meeting
 */
public class CommonStepDefinitionAARP {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	
}