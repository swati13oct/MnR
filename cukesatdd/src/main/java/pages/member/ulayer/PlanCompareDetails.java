package pages.member.ulayer;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class PlanCompareDetails extends UhcDriver {
	
	private PageData planCompareDetails;
	
	public JSONObject planCompareDetailsJson;
	
	@FindBy(xpath="/html/body/div[7]/div/div/table/tbody/tr[5]/td/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[4]/div[4]/h3")
	private WebElement pageHeader;
	
	@FindBy(xpath="/html/body/div[7]/div/div/table/tbody/tr[5]/td/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[4]/div[5]/div[1]/div/div[2]/div/div[2]/div/div[2]/div[1]/div[2]/div/div/p[1]")
	private WebElement preferredText;
	
	@FindBy(xpath="/html/body/div[7]/div/div/table/tbody/tr[5]/td/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[4]/div[5]/div[2]/div[3]/div[2]/div/p")
	private WebElement preferredTableText;
	
	@FindBy(xpath="")
	private WebElement preferredDisclaimerText;
	
	@FindBy(xpath="/html/body/div[7]/div/div/table/tbody/tr[5]/td/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[4]/div[4]/div/div[8]/div[2]/p[2]")
	private WebElement preferredNetworkDisclaimerMAPD;
	
	@FindBy(xpath="/html/body/div[7]/div/div/table/tbody/tr[5]/td/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[4]/div[4]/div/div[8]/div[2]/p[3]")
	private WebElement pharmacySaverFooter;
	
	@FindBy(xpath="/html/body/div[7]/div/div/table/tbody/tr[5]/td/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div[4]/div[4]/div/div[3]/div[4]/div[2]/div[1]")
	private WebElement pharmacySaverRightRail;
	
	public PlanCompareDetails(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PLAN_COMPARE_DETAILS;
		planCompareDetails = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(pageHeader);
		
	}

	public boolean isPreferredNetwork() {
		boolean valid;
		valid = validate(preferredText) && preferredText.getText().equals("UnitedHealthcare members can save more money on thousands of prescription drugs through our Preferred Retail Pharmacy Network. We've worked with many retail pharmacies in your area to help you save money on your prescription co-pays.");
		if (!valid) return false;
		else if (validate(preferredTableText) && preferredTableText.getText().equals("Some plans offer savings for buying a three-month supply via mail rather than buying a one-month supply from a standard retail pharmacy. Prices here are for a three-month supply using the Preferred Mail Service Pharmacy.")) {
			return true;
		}
		
		return false;
	}

	public boolean isPreferredNetworkMAPD() {
		boolean valid;
		valid = validate(preferredNetworkDisclaimerMAPD) && preferredNetworkDisclaimerMAPD.isDisplayed();
		if (valid) return true;
		
		return false;
	}

	public boolean isPharmacySaver() {
		boolean valid;
		valid = validate(pharmacySaverFooter) && pharmacySaverFooter.isDisplayed();
		if (!valid) return false;
		else if (validate(pharmacySaverRightRail) && pharmacySaverRightRail.isDisplayed()) {
			return true;
		}
		
		return false;
	}
	
}