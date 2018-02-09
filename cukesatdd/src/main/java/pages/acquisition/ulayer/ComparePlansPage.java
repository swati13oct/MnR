package pages.acquisition.ulayer;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
public class ComparePlansPage extends UhcDriver {

	private PageData compareplan;
	
	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/div/div/div/div/div[1]/div/div[1]/a")
	private WebElement backToAllPlansLink;
	
	public ComparePlansPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//openAndValidate();
	}


	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
	}
	
	public VPPPlanSummaryPage backToVPPPage(){
		backToAllPlansLink.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(currentUrl().contains("#/plan-summary"))
			return new VPPPlanSummaryPage(driver);
		return null;
	}
	
	


}

