package acceptancetests.acquisition.shopforaplan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.acquisition.ole.oleCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.EnrollmentBasicsPage;
import pages.acquisition.commonpages.ShopforaplanAARPlayer;




public class ShopForaPlanCommonStepDefinition {
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	WebDriver wd;
	
	@Given("^the user hovers screen over the shop for a plan$")
	public void the_user_hovers_screen_over_the_shop_for_a_plan() throws Throwable {	
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ShopforaplanAARPlayer shop = acqusitionHomePage.Hoveronaplan();
		if (shop!=null) {
			System.out.println("Shop for a plan drop down is opened");
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER, shop);
		}
		else {
			Assert.fail("Issue in selecting a plan drop down");
		}
	}
	
	@Given("^click on Enroll Plan on shop for plan for AARP$")
	public void click_on_Enroll_Plan_on_shop_for_plan_for_AARP() throws Throwable {
		ShopforaplanAARPlayer shopaplan = (ShopforaplanAARPlayer) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		ShopforaplanAARPlayer enrollPage = shopaplan.ShopLinkOnShopPlan();
		if (enrollPage != null)
			getLoginScenario().saveBean(PageConstants.ENROLLMENT_BASICS_PAGE, enrollPage);
		else
			System.out.println("continue button is not displayed provider search page");
	}
	
	@Given("^click on Learn how to enroll shop pages on enroll page$")
	public void click_on_Learn_how_to_enroll_Shopplan_on_enroll(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String planyear = "2019"; 
		String plantype = givenAttributesMap.get("Plan Type");
		String planName = givenAttributesMap.get("Plan Name");
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ShopforaplanAARPlayer enrollPage = (ShopforaplanAARPlayer) getLoginScenario()
				.getBean(PageConstants.SHOP_FOR_A_PLAN_AARPLAYER);
		enrollPage.clickONEnrollShopLink(plantype, planName);
		
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_TYPE, plantype);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_NAME, planName);
		getLoginScenario().saveBean(oleCommonConstants.OLE_PLAN_YEAR, planyear);
	}
	

}

