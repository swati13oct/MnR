package acceptancetests.acquisition.shopforaplan;

import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.PageConstants;
import atdd.framework.MRScenario;
import cucumber.api.java.en.Given;
import pages.acquisition.ulayer.AcquisitionHomePage;
import pages.acquisition.bluelayer.ShopforaplanUHClayer;
import pages.acquisition.ulayer.ShopforaplanAARPlayer;

public class AARPShopForaPlanStepDefenition {
	
	
	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}
	
	@Given("^the user hovers screen over the shop for a plan drop down in AARP$")
	public void the_user_hovers_screen_over_the_shop_for_a_plan_drop_down_in_AARP() throws Throwable {
		AcquisitionHomePage acqusitionHomePage = (AcquisitionHomePage) getLoginScenario().getBean(PageConstants.ACQUISITION_HOME_PAGE);
		ShopforaplanAARPlayer shop = acqusitionHomePage.Hoveronaplan();
		if (shop!=null) {
			System.out.println("Shop for a plan drop down is opened");
			getLoginScenario().saveBean(PageConstants.SHOP_FOR_A_PLAN_UHCLAYER, shop);
		}
		else {
			Assert.fail("Issue in selecting a plan drop down");
		}
	}
	

}
