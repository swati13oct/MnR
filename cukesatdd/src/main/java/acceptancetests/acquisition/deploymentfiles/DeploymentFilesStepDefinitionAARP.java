package acceptancetests.acquisition.deploymentfiles;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.Assertion;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pages.acquisition.commonpages.AcquisitionHomePage;

/**
 *Functionality:Global Header Footer 
 */
public class DeploymentFilesStepDefinitionAARP {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Then("^the user validates whether page load is loading on AARP$")
	public void the_user_validates_whether_page_is_loading_AARP()  {
		
	AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean isPageLoadError = aquisitionhomepage.isValidatePageLoadError();
		
		if(isPageLoadError)
			Assertion.fail("Page is not loading properly. It is showing error -PAGE NOT FOUND");
		else
			Assertion.assertTrue("Page is loading.", true); 
		
	}
	
	
	@Then("^the user validates whether correct content is visible on AARP")
	public void the_user_validates_whether_content_is_visible_AARP(DataTable arg1) throws Throwable {
		Map<String, String> personalAttributesMap = new HashMap<String, String>();
		personalAttributesMap = DataTableParser.readDataTableAsMaps(arg1);
		/*List<DataTableRow> personalAttributesRow = arg1
				.getGherkinRows();
		for (int i = 0; i < personalAttributesRow.size(); i++) {

			personalAttributesMap.put(personalAttributesRow.get(i).getCells()
					.get(0), personalAttributesRow.get(i).getCells().get(1));
		}*/
		
		String strFileName = personalAttributesMap.get("pagename");
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		Boolean isValidContent=aquisitionhomepage.isValidateContent(strFileName);
		if(isValidContent)
			Assertion.assertTrue("File is loaded", true);
		else
			Assertion.fail("File is not loading");
	}

	

	
	
}
