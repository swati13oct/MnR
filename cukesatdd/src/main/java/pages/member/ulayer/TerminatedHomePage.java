/**
 * 
 */
package pages.member.ulayer;

import java.util.Map;

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

/**
 * @author pjaising
 *
 */
public class TerminatedHomePage extends UhcDriver {

	@FindBy(id = "memberId")
	private WebElement memberId;

	@FindBy(id = "terminatedDate")
	private WebElement terminatedDate;

	@FindBy(linkText = "Search medical claims")
	private WebElement searchMedicalClaims;

	@FindBy(linkText = "Search drug claims")
	private WebElement searchDrugClaims;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	@FindBy(id = "teaserContent")
	private WebElement terminatedPageElement;

	private PageData terminatedAccount;

	public JSONObject terminatedAccountJson;

	public TerminatedHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.TERMINATED_ACCOUNT_PAGE_DATA;
		terminatedAccount = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public void logOut() {
		logOut.click();
	}

	public String getTerminatedPlanContent() {
		return terminatedPageElement.getText();
	}

	public MedicalClaimSummaryPage navigateToMedicalClaimsSummary() {
		searchMedicalClaims.click();
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new MedicalClaimSummaryPage(driver);
		}
		return null;
	}

	public DrugClaimSummaryPage navigateToDrugClaimsSummary() {
		searchDrugClaims.click();
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new DrugClaimSummaryPage(driver);
		}
		return null;
	}

	@Override
	public void openAndValidate() {
		validate(memberId);
		validate(terminatedDate);

		JSONObject jsonObject = new JSONObject();
		for (String key : terminatedAccount.getExpectedData().keySet()) {
			WebElement element = findElement(terminatedAccount
					.getExpectedData().get(key));
			if (element != null) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		terminatedAccountJson = jsonObject;
		
		System.out.println("terminatedAccountJson----->"+terminatedAccountJson);

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject accountHomeExpectedJson = expectedDataMap
				.get(CommonConstants.TERMINATED_ACCOUNT);
		accountHomeExpectedJson = CommonUtility.mergeJson(
				accountHomeExpectedJson, globalExpectedJson);
		return accountHomeExpectedJson;
	}

}
