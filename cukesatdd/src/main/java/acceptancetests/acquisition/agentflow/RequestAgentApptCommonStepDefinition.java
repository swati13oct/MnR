package acceptancetests.acquisition.agentflow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.vpp.VPPCommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.RequestAgentAppointmentPage;
import pages.acquisition.commonpages.RequestHelpAndInformationPage;
import pages.acquisition.ulayer.ProviderSearchPage;
import pages.acquisition.ulayer.VPPPlanSummaryPage;


/**
 *Functionality: Agent Flow
 */
public class RequestAgentApptCommonStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	/**
	 * @toDo: user navigates to request more help and information in 
	 */
	@When("^the user navigates to EBRC links$")
	public void User_navigate_EBRC_Links(DataTable arg1) throws InterruptedException {
		Map<String, String> inputAttributesMap=parseInputArguments(arg1);
		String myUHCAgentURL = inputAttributesMap.get("UHC Agent URL");
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage)getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		
		if(myUHCAgentURL!=null){
			aquisitionhomepage.clickonFindanAgentlink(myUHCAgentURL);
			Assert.assertTrue(true);
		}else
			Assert.fail("Error in loading the UHC Agent Page");
	}
	
	public Map<String, String> parseInputArguments(DataTable memberAttributes) {
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
		}
		return memberAttributesMap;
	}
}
