package acceptancetests.memberredesign.IDcards;



import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import acceptancetests.data.PageConstantsMnR;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.regression.IDCardPage.IDCardPage;
import pages.regression.accounthomepage.AccountHomePage;

/**
 * 
 * Functionality Contact Us UHC site
 *
 */
public class IDCardsStepDefinition {
	/**
	 * 
	 */
		@Autowired
		MRScenario loginScenario;

		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		
		public MRScenario getLoginScenario() {
			return loginScenario;
		}
		
		/**
		 *  @toDO : the user navigate to the contact us page
		 */
		@When("^the user clicks on View and Print Member ID cards link$")
		public void the_user_clicks_on_View_and_Print_Member_ID_cards_link() {
			
			AccountHomePage accountHomePage = (AccountHomePage) getLoginScenario().getBean(PageConstantsMnR.ACCOUNT_HOME_PAGE);
			
			IDCardPage iDCardPage = accountHomePage.viewIDCard();
			if(iDCardPage != null)				
				getLoginScenario().saveBean(PageConstants.ID_CARD_PAGE,
						iDCardPage);
		}
		
		/**
		 *  @toDO : the user validates cancel link on secure email widget on contact us page
		 */
		@Then("^user validates Coverage Status as of Today$")
		public void user_validates_Coverage_Status_as_of_Today(DataTable givenAttributes)
		{
			/* Reading the given attribute from feature file */
			List<DataTableRow> memberAttributesRow = givenAttributes
					.getGherkinRows();
			for (int i = 0; i < memberAttributesRow.size(); i++) {

				memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0), memberAttributesRow.get(i).getCells().get(1));
			}
			String coverageStatus = memberAttributesMap.get("Coverage Status");
			
			IDCardPage iDCardPage=(IDCardPage)getLoginScenario().getBean(PageConstants.ID_CARD_PAGE);
			
			iDCardPage.validateCoverageStatus(coverageStatus);
			
			if(iDCardPage != null)				
				getLoginScenario().saveBean(PageConstants.ID_CARD_PAGE,
						iDCardPage);
		}
		
		@And("^validate the headers$")
		public void validate_the_headers(DataTable givenAttributes)
		{
			IDCardPage iDCardPage=(IDCardPage)getLoginScenario().getBean(PageConstants.ID_CARD_PAGE);
			
			iDCardPage.validateIDCardPage(givenAttributes);
			
			if(iDCardPage != null)				
				getLoginScenario().saveBean(PageConstants.ID_CARD_PAGE,
						iDCardPage);
		}
	}

