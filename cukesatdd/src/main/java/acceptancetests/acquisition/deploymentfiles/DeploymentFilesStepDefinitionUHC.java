package acceptancetests.acquisition.deploymentfiles;

import gherkin.formatter.model.DataTableRow;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.bluelayer.AcquisitionHomePage;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;

/**
 *Functionality:Global Header Footer 
 */
public class DeploymentFilesStepDefinitionUHC {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	@Then("^the user validates whether page load error is not visible on UHC$")
	public void the_user_validates_whether_page_is_loading_UHC() throws InterruptedException {
		
	AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		Boolean isPageLoadError=aquisitionhomepage.isValidatePageLoadError();
		if(isPageLoadError)
			Assert.fail("Page is not loading properly. It is showing error -PAGE NOT FOUND");
		else
			Assert.assertTrue("Page is loading.", true);
		
	}
	
	
	@Then("^the user validates whether correct content is visible on UHC")
	public void the_user_validates_whether_content_is_visible_UHC(DataTable arg1) throws Throwable {
		List<DataTableRow> personalAttributesRow = arg1
				.getGherkinRows();
		Map<String, String> personalAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < personalAttributesRow.size(); i++) {

			personalAttributesMap.put(personalAttributesRow.get(i).getCells()
					.get(0), personalAttributesRow.get(i).getCells().get(1));
		}
		
		String strFileName = personalAttributesMap.get("pagename");
		AcquisitionHomePage aquisitionhomepage = (AcquisitionHomePage) getLoginScenario()
				.getBean(PageConstants.ACQUISITION_HOME_PAGE);
		
		Boolean isValidContent=aquisitionhomepage.isValidateContent(strFileName);
		if(isValidContent)
			Assert.assertTrue("File is loaded", true);
		else
			Assert.assertFalse("File is not loading.", false);
		
	}

	

	
	
}
