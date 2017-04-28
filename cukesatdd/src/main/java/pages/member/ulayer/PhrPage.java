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

public class PhrPage extends UhcDriver {

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	@FindBy(id = "phr_widget_2")
	private WebElement showMyDrugs;

	@FindBy(id = "phr_widget_3")
	private WebElement showMyFacilities;

	@FindBy(id = "phr_widget_4")
	private WebElement showMyProducts;

	@FindBy(id = "phr_widget_6")
	private WebElement showMyHealthConcerns;

	@FindBy(id = "phr_widget_7")
	private WebElement showMyPharmacies;

	@FindBy(id = "phr_widget_8")
	private WebElement showMyQuizzesAssessments;

	private PageData phr;

	public JSONObject phrJson;

	public PhrPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, showMyDrugs, CommonConstants.TIMEOUT_30);
		showMyDrugs.click();
		showMyFacilities.click();
		showMyProducts.click();
		showMyHealthConcerns.click();
		showMyPharmacies.click();
		showMyQuizzesAssessments.click();

		String fileName = CommonConstants.PHR_PAGE_DATA;

		phr = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public void logOut() {
		logOut.click();

	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : phr.getExpectedData().keySet()) {
			WebElement element = findElement(phr.getExpectedData().get(key));
			validate(element);
			try {
				if (null != element) {
					jsonObject.put(key, element.getText());
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		phrJson = jsonObject;
		
		System.out.println("phrJson----->"+phrJson);

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap)
			{
		/* get PHR expected data */
		JSONObject phrExpectedJson = expectedDataMap.get(CommonConstants.PHR);

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		phrExpectedJson = CommonUtility.mergeJson(phrExpectedJson,
				globalExpectedJson);

		return phrExpectedJson;
	}
}
