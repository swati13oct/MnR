package pages.member.bluelayer;

/**
 * @author pagarwa5
 *
 */

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

public class ViewDrugCostPage extends UhcDriver {

	@FindBy(linkText = "edit")
	private WebElement editLink;

	@FindBy(linkText = "Delete")
	private WebElement deleteLink;

	@FindBy(className = "viewDrugCost")
	private WebElement drugCostContent;

	@FindBy(linkText = "Sign Out")
	private WebElement logOut;

	private PageData viewDrugCost;

	public JSONObject viewDrugCostJson;

	public ViewDrugCostPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, drugCostContent, CommonConstants.TIMEOUT_30);
		String fileName = CommonConstants.VIEW_DRUG_COST_INDIVIDUAL_BLUE_LAYER_PAGE_DATA;
		viewDrugCost = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public ViewDrugCostPage(WebDriver driver, String category) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, drugCostContent, CommonConstants.TIMEOUT_30);
		String fileName = CommonConstants.VIEW_DRUG_COST_BLUE_LAYER_PAGE_DATA;
		viewDrugCost = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public ManageDrugPage editDrugList() {
		editLink.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deleteLink.click();
		System.out.println("Deleted drug from list");
		if (driver.getTitle().equalsIgnoreCase("Drug Cost Estimator")) {
			return new ManageDrugPage(driver);
		} else {
			return null;
		}

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		/* get BENEFITS AND COVERAGE expected data */
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);

		JSONObject viewDrugCostExpectedJson = expectedDataMap
				.get(CommonConstants.VIEW_DRUG_COST);
		viewDrugCostExpectedJson = CommonUtility.mergeJson(
				viewDrugCostExpectedJson, globalExpectedJson);

		return viewDrugCostExpectedJson;

	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : viewDrugCost.getExpectedData().keySet()) {
			WebElement element = findElement(viewDrugCost.getExpectedData()
					.get(key));

			if (null != element && !element.getText().equalsIgnoreCase("")) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}

		}
		viewDrugCostJson = jsonObject;
		
		System.out.println("viewDrugCostJson----->"+viewDrugCostJson);

	}

	public void logOut() {
		logOut.click();

	}
	
	@FindBy(xpath = ".//*[@id='dce.member']/div/div[6]/div/div/div/div/div[1]/div[3]/div[2]/table/tbody/tr[7]/td[1]")
	private WebElement drugInfoBox;
	
	@FindBy(linkText ="Edit pharmacy")
	private WebElement editPharmacyLink;
	
	@FindBy(xpath =".//*[@id='dce.member']/div/div[6]/div/div/div/div/div[1]/div[3]/div[2]")
	private WebElement descriptionTable;
	
	public boolean validateViewDrugPage(String dosage) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("text: " +drugInfoBox.getText()); System.out.println("dosage: "+dosage);
		if(validate(descriptionTable)&&(drugInfoBox.getText().contains(dosage)) && validate(editLink)&&validate(editPharmacyLink))
			return true;
		else 
			return false;
	}

}
