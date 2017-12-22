package pages.redesign;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.claims.data.ClaimsCommonConstants;
import atdd.framework.UhcDriver;

/**
 * @author sdwaraka
 *
 */
public class MedicalClaimSummaryPage extends UhcDriver {

	@FindBy(xpath = "//h1[contains(text(), 'My Claims')]")
	private WebElement ClaimsPageHeader;

	@FindBy(xpath = "//a[contains(text(), '(Terminated)')]")
	private List<WebElement> TerminatedTabs;

	private PageData medicalClaimsSummary;

	public JSONObject medicalClaimsSummaryJson;

	public MedicalClaimSummaryPage(WebDriver driver) {
		super(driver);
		String fileName = CommonConstants.MEDICAL_CLAIMS_SUMMARY_PAGE_DATA;
		medicalClaimsSummary = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}


	@Override
	public void openAndValidate() {
		CommonUtility.checkPageIsReady(driver);
		if(validate(ClaimsPageHeader)){
			System.out.println("CLAIMS PAGE is LOADED");
		}
		else{
			System.out.println("CLAIMS PAGE is NOT LOADED");
		}
	}
	
	public boolean Validate_Single_Tab_SHIP(){
		List<WebElement> PlanTabs = driver.findElements(By.xpath("//a[contains(text(),'Supplemental Insurance Plans')]"));
		System.out.println("No of tabs: "+PlanTabs.size());
		if(PlanTabs.size()>1){
			return false;
		}
		else{
			return true;
		}
	}
	
	public boolean Validate_Terminated_Tab(){
		List<WebElement> PlanTabs = driver.findElements(By.xpath("//a[contains(text(),'(Terminated)')]"));
		System.out.println("No of tabs: "+PlanTabs.size());
		
		if(PlanTabs.size() > 0 ){
			System.out.println("Terminated Tabs for the following Plans are Displayed");

			for(WebElement TerminatedPlan: PlanTabs){
				System.out.println(TerminatedPlan.getText());
			}
			return true;
		}
		return false;
	}

}
