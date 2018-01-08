/**
 * 
 */
package pages.redesign;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.member.bluelayer.PharmacySearchPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;

/**
 * @author sdwaraka
 *
 */
public class EoBSearchPage extends UhcDriver {

	@FindBy(xpath = "//h1[contains(text(), 'Explanation of Benefits')]")
	private WebElement EOBPageHeader;

	@FindBy(xpath = "//a[contains(text(), '(Terminated)')]")
	private List<WebElement> TerminatedTabs;

	private PageData planBenefitsCoverage;

	
	public EoBSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.MEDICAL_EOB_PAGE_DATA;
		planBenefitsCoverage = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		if(validate(EOBPageHeader)){
			System.out.println("Explanation of Benefits PAGE is LOADED");
		}
		else{
			System.out.println("Explanation of Benefits is NOT LOADED");
		}
	}
	public boolean Validate_Single_Tab_SHIP(){
		List<WebElement> PlanTabs = driver.findElements(By.xpath("//a[contains(text(),'Supplemental  Insurance Plans')]"));
		System.out.println("No of tabs: "+PlanTabs.size());
		if(PlanTabs.size()>1){
			return false;
		}
		else{
			return true;
		}
	}
	public boolean Validate_Terminated_Tab(){
		
		if(!TerminatedTabs.isEmpty()){
			System.out.println("Terminated Tabs for the following Plans are Displayed");

			for(WebElement TerminatedPlan: TerminatedTabs){
				System.out.println(TerminatedPlan.getText());
			}
			return true;
		}
		return false;
	}


}
