package acceptancetests.mobile.acquisition.shopforaplan;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.ole.oleCommonConstants;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class AARPShopForaPlanStepDefenition {
	
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	/*@Given("^the user hovers screen over the shop for a plan drop down in AARP$")
	public void the_user_hovers_screen_over_the_shop_for_a_plan_drop_down_in_AARP() throws Throwable {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ShopforaplanAARPlayer shop = acqusitionHomePage.Hoveronaplan();
		if (shop!=null) {
			System.out.println("Shop for a plan drop down is opened");
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER, shop);
		}
		else {
			Assertion.fail("Issue in selecting a plan drop down");
		}
	}*/
	
	/*@Given("^click on Enroll Plan on shop for plan for AARP$")
	public void click_on_Enroll_Plan_on_shop_for_plan_for_AARP() throws Throwable {
		ShopforaplanAARPlayer shopaplan = (ShopforaplanAARPlayer) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		EnrollmentBasicsPage enrollPage = shopaplan.enrollLinkOnShopPlan();
		if (enrollPage != null)
			getLoginScenario().saveBean(PageConstants.ENROLLMENT_BASICS_PAGE, enrollPage);
		else
			System.out.println("continue button is not displayed provider search page");
	}
	*/
	@Given("^click on Learn how to enroll plan on enroll page for AARP$")
	public void click_on_Learn_how_to_enroll_plan_on_enroll_page_for_AARP(DataTable givenAttributes) throws Throwable {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String planyear = "2019"; 
		String plantype = givenAttributesMap.get("Plan Type");
		String planName = givenAttributesMap.get("Plan Name");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*EnrollmentBasicsPage enrollPage = (EnrollmentBasicsPage) getLoginScenario()
				.getBean(PageConstants.ENROLLMENT_BASICS_PAGE);
		enrollPage.clickONEnrollLink(plantype, planName);*/
		
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, plantype);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, planName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, planyear);
	}
	

}
