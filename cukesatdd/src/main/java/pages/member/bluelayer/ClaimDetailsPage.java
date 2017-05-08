package pages.member.bluelayer;

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
 * @author pagarwa5
 *
 */
public class ClaimDetailsPage extends UhcDriver {

	@FindBy(id = "searchRange")
	private WebElement searchRange;

	@FindBy(id = "searchbutton")
	private WebElement searchbutton;

	@FindBy(xpath = "//table[@id='claim']/tbody/tr[3]/td[6]/form/input[12]")
	private WebElement claimDetail;

	@FindBy(id = "medicaldetailsinner")
	private WebElement medicalClaimDetailsSection;

	@FindBy(linkText = "Sign Out")
	private WebElement logOut;

	@FindBy(id = "drugclaimdetail")
	private WebElement servicesChargesSection;

	private PageData claimsDetails;

	public JSONObject claimsDetailsJson;

	public ClaimDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.MEDICAL_CLAIM_DETAILS_PAGE_DATA;
		claimsDetails = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}
	public ClaimDetailsPage searchClaims(Map<String, String> timeAttributesMap) {
		String claimPeriod = timeAttributesMap.get("Claim Period");
		searchRange.click();
		searchRange.sendKeys(claimPeriod);
		CommonUtility.checkPageIsReady(driver);
		searchbutton.click();
		CommonUtility.checkPageIsReady(driver);

		if (driver.getTitle().equalsIgnoreCase("Claims")) {
			return new ClaimDetailsPage(driver);
		}
		return null;
	}

	public String getMedicalClaimsDetails() {
		return medicalClaimDetailsSection.getText();
	}

	public String getServicesChargesContent() {
		return servicesChargesSection.getText();
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		// // get expected data for claim summary
		String claimNumber = getClaimNumber();
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject claimdetailsExpectedJson = null;
		try {
			claimdetailsExpectedJson = expectedDataMap.get(
					CommonConstants.CLAIM_DETAILS).getJSONObject(claimNumber);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		claimdetailsExpectedJson = CommonUtility.mergeJson(
				claimdetailsExpectedJson, globalExpectedJson);
		return claimdetailsExpectedJson;
	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : claimsDetails.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(claimsDetails
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (elementFound(elements.get(0))) {
					try {
						jsonObject.put(key, elements.get(0).getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
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
		claimsDetailsJson = jsonObject;
		
		System.out.println("claimsDetailsJson----->"+claimsDetailsJson);

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

	public void logout() {
		logOut.click();
	}
	@FindBy(xpath = ".//*[@id='drugclaimdetail']")
	private WebElement drugclaimdetailbox;
	
	@FindBy(xpath = ".//*[@id='medicaldetailsinner']")
	private WebElement medDetailsInnerBox;
	
	@FindBy(xpath = ".//*[@id='medicaldetailsouter']/div[2]/a")
	private WebElement backtoClaimSearchbtn;
	
	public boolean validateMoreInfo(){
		boolean flag = false;
		if(validate(drugclaimdetailbox)&&validate(medDetailsInnerBox)&&validate(backtoClaimSearchbtn))
			flag = true;
		
		return flag;
	}
}
