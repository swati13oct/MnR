package pages.acquisition.ulayer;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ResponsivePlanDetails extends UhcDriver{
	
	private PageData vppPlanDetails;

		
	public ResponsivePlanDetails(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
		// ADD JSON Validation Path if required
	}

	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		// ADD elements that needed to validate
	}
	
	public ResponsivePlanDetails validatePage(){
		if(driver.getTitle().equalsIgnoreCase("")){
			return new ResponsivePlanDetails(driver);
		}else{
			return null; 
		}
	}
	
}