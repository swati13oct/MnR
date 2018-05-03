package acceptancetests.acquisitionvbf.common;

import gherkin.formatter.model.DataTableRow;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import pages.acquisition.ulayer.AcquisitionHomePage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 *Functionality:Attend Community Meeting
 */
public class CommonStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public static WebDriver webDriverObj;
	
//	private static Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
	private static List<DataTableRow> memberAttributesRow = null;	
	
	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	
	public void setWebDriverObj() {		
		webDriverObj =getLoginScenario().getWebDriver();		
	}

	/**
	 * @toDo:user is on AARP medicare acquisition site landing page
	 */
	@Given("^the user is on AARP medicare acquisition site landing page appli tools$")
	public void the_user_on_aarp_medicaresolutions_Site() {
		setWebDriverObj();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(webDriverObj);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, webDriverObj);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,
				aquisitionhomepage);
		
	}
	
	/**
	 * @toDo:user is on blayer medicare
	 */
	@Given("^the user is on the UHC medicare solutions site home page$")
	public void the_user_is_on_UMS_medicare_solutions_site_home_page() {

		WebDriver wd = getLoginScenario().getWebDriver();
		AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd);

		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		getLoginScenario().saveBean(PageConstants.ACQUISITION_HOME_PAGE,aquisitionhomepage);		
	}
	
/*
	 * @toDo:atrributes in member map format
	 *//*
	@When("^fetch the data attributes in map form$")
	public  Map<String, String> fetch_the_data_attributes_in_map_form(DataTable memberAttributes) {
		// memberAttributesMap.clear();
	        List<DataTableRow> memberAttributesRow = memberAttributes.getGherkinRows();
	        if(memberAttributesRow.size()>0){
		        for (int i = 0; i < memberAttributesRow.size(); i++) {
		               memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),memberAttributesRow.get(i).getCells().get(1));
		        }
	        }
	        return memberAttributesMap;		
	}*/
	
	
	/**
	 * @toDo:atrributes in member row format
	 */
	@When("^fetch the data attributes in row form$")
	public List<DataTableRow>  fetch_the_data_attributes_in_row_form(DataTable memberAttributesrow) {
		memberAttributesRow.clear();
        List<DataTableRow> memberAttributesRow = memberAttributesrow.getGherkinRows();
       
        return memberAttributesRow;
		
	}	
	
	/*public Map<String, String> getAttributesMap(){
		return memberAttributesMap;
	}
*/
	public List<DataTableRow> getAttributesRow(){
		return memberAttributesRow;
	}
}