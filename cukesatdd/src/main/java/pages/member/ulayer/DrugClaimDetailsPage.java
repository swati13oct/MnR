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
 * @author pperugu
 *
 */
public class DrugClaimDetailsPage extends UhcDriver{

	@FindBy(id = "searchRange")
	private WebElement searchRange;

	@FindBy(id = "searchbutton")
	private WebElement searchbutton;

	@FindBy(id = "drugdetailfooter")
	private WebElement drugCostDetailsSection;

	@FindBy(id = "drugclaimdetail")
	private WebElement servicesChargesSection;
	
	@FindBy(id = "drugdetailtableheader")
	private WebElement drugdetailtableheader;
	
	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	private PageData drugClaimDetail;

	public JSONObject drugClaimDetailJson;
	
	public DrugClaimDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.DRUG_CLAIMS_DETAILS_PAGE_DATA;
		CommonUtility.waitForPageLoad(driver, drugdetailtableheader, CommonConstants.TIMEOUT_30);
		drugClaimDetail = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public void logOut() {
		logOut.click();

	}

	@Override
	public void openAndValidate() {
		validate(logOut);
		JSONObject jsonObject = new JSONObject();
		for (String key : drugClaimDetail.getExpectedData().keySet()) {
			WebElement element = findElement(drugClaimDetail.getExpectedData()
					.get(key));
			if (element != null) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		drugClaimDetailJson = jsonObject;
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,String firstRxNumber) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject drugClaimDetailsExpectedJson = expectedDataMap
				.get(CommonConstants.DRUG_CLAIMS_DETAILS);	
		try {
			drugClaimDetailsExpectedJson = (JSONObject) drugClaimDetailsExpectedJson.get(firstRxNumber);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drugClaimDetailsExpectedJson = CommonUtility.mergeJson(
				drugClaimDetailsExpectedJson, globalExpectedJson);
		return drugClaimDetailsExpectedJson;
	}

}

