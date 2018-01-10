/**
 * 
 */
package pages.member.ulayer;

import java.util.List;
import java.util.Map;

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

/**
 * @author pperugu
 *
 */
public class MedicalClaimDetailsPage extends UhcDriver {

	@FindBy(id = "searchRange")
	private WebElement searchRange;

	@FindBy(id = "searchbutton")
	private WebElement searchbutton;

	@FindBy(xpath = "//table[@id='claim']/tbody/tr[3]/td[6]/form/input[12]")
	private WebElement claimDetail;

	@FindBy(id = "medicaldetailsinner")
	private WebElement medicalClaimDetailsSection;

	@FindBy(id = "drugclaimdetail")
	private WebElement servicesChargesSection;

	@FindBy(id = "drugdetailtableheader")
	private WebElement drugdetailtableheader;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	//@FindBy(xpath = ".//*[@id='drugclaimdetail']")
	//private WebElement drugclaimdetailbox;
	
	@FindBy(id="drugclaimdetail")
	private WebElement drugclaimdetailbox;
	
	//@FindBy(xpath = ".//*[@id='medicaldetailsinner']")
	//private WebElement medDetailsInnerBox;
	
	
	@FindBy(id = "medicaldetailsinner")
	private WebElement medDetailsInnerBox;
	
	@FindBy(xpath = ".//*[@id='medicaldetailsouter']/div[2]/a")
	private WebElement backtoClaimSearchbtn;

	private PageData medicalClaimDetails;

	public JSONObject medicalClaimDetailsJson;

	public MedicalClaimDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, drugdetailtableheader, CommonConstants.TIMEOUT_30);
		String fileName = CommonConstants.MEDICAL_CLAIMS_DETAILS_PAGE_DATA;
		medicalClaimDetails = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public MedicalClaimDetailsPage searchClaims(
			Map<String, String> timeAttributesMap) {

		String claimPeriod = timeAttributesMap.get("Claim Period");
		searchRange.click();
		searchRange.sendKeys(claimPeriod);
		CommonUtility.checkPageIsReady(driver);
		searchbutton.click();
		CommonUtility.checkPageIsReady(driver);

		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new MedicalClaimDetailsPage(driver);
		}
		return null;
	}

	public String getMedicalClaimsDetails() {
		return medicalClaimDetailsSection.getText();
	}

	public String getServicesChargesContent() {
		return servicesChargesSection.getText();
	}

	public void logOut() {
		logOut.click();

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject medicalClaimDetailsExpectedJson = expectedDataMap
				.get(CommonConstants.MEDICAL_CLAIMS_DETAILS);

		String claimNumber = getClaimNumber();

		try {
			medicalClaimDetailsExpectedJson = (JSONObject) medicalClaimDetailsExpectedJson
					.get(claimNumber);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		medicalClaimDetailsExpectedJson = CommonUtility.mergeJson(
				medicalClaimDetailsExpectedJson, globalExpectedJson);
		return medicalClaimDetailsExpectedJson;
	}

	private String getClaimNumber() {
		String claimNumber;
		String currentUrl = currentUrl();
		String claimNumUrl = currentUrl.split("cn=")[1];
		if (claimNumUrl.contains("&")) {
			claimNumber = claimNumUrl.split("&")[0];
		} else {
			claimNumber = claimNumUrl;
		}
		return claimNumber;
	}

	@Override
	public void openAndValidate() {

		validate(logOut);
		JSONObject jsonObject = new JSONObject();
		for (String key : medicalClaimDetails.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(medicalClaimDetails
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (validate(elements.get(0))) {
					try {
						jsonObject.put(key, elements.get(0).getText());
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {
					validate(element);
					try {
						JSONObject jsonObjectForArray = new JSONObject();
						jsonObjectForArray.put("detailRow", element.getText());
						jsonArray.put(jsonObjectForArray);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
				try {
					jsonObject.put(key, jsonArray);
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}

		}
		medicalClaimDetailsJson = jsonObject;
		
		System.out.println("medicalClaimDetailsJson----->"+medicalClaimDetailsJson);

	}

	public boolean validateMoreInfo(){
		boolean flag = false;
		if(validate(drugclaimdetailbox)&&validate(medDetailsInnerBox)&&validate(backtoClaimSearchbtn))
			flag = true;
		
		return flag;
	}

}
