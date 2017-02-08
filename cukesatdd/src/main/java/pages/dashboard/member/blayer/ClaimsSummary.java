package pages.dashboard.member.blayer;

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

public class ClaimsSummary extends UhcDriver{
	
	

	private PageData newClaimsSummarypage;

	public JSONObject newClaimsSummaryJson;
	
	//Add any web element which is always present when the page loads
		@FindBy(xpath="/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr")
		public WebElement ClaimsSummaryPage;

	public ClaimsSummary(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, ClaimsSummaryPage, 10);
		String fileName = CommonConstants.NEW_CLAIM_SUMMARY_PAGE_DATA;
		newClaimsSummarypage = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		JSONObject jsonObject = new JSONObject();
		for (String key : newClaimsSummarypage.getExpectedData().keySet()) {
			WebElement element = findElement(newClaimsSummarypage.getExpectedData().get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		newClaimsSummaryJson = jsonObject;

		System.out.println("newClaimsSummaryJson----->" + newClaimsSummaryJson);
		
	}

	public void validateHeader() {
		
		
	}

}
