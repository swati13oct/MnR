package acceptancetests.acquisition.footer;

import org.springframework.beans.factory.annotation.Autowired;

import atdd.framework.MRScenario;

/**
 *Functionality: Global Header Footer
 */
public class GlobalHeaderFooterStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

}
