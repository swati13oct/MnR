package pages.member_deprecated.bluelayer;

/**
 * @author pperugu
 *
 */

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class LowCostOptPage extends UhcDriver {

	@FindBy(linkText = "continue")
	private WebElement continueButton;

	@FindBys(value = { @FindBy(name = "typeofdrug") })
	private List<WebElement> genericDrugs;

	private PageData lowCostOptions;

	public JSONObject lowCostOptionsJson;

	public LowCostOptPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.LOW_COST_OPTIONS_INDIVIDUAL_BLUE_LAYER_PAGE_DATA;
		lowCostOptions = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public LowCostOptPage(WebDriver driver, String category) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.LOW_COST_OPTIONS_BLUE_LAYER_PAGE_DATA;
		lowCostOptions = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public ManageDrugPage selectDrugType(String drugType, String category) {

		if (!drugType.equalsIgnoreCase("Brand")) {
			for (WebElement dosage : genericDrugs) {
				if (!dosage.isSelected()) {
					dosage.click();
					break;
				}
			}
		}

		continueButton.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (driver.getTitle().equalsIgnoreCase("Drug Cost Estimator") && category.equalsIgnoreCase(CommonConstants.GROUP)) {
			return new ManageDrugPage(driver,category);
		} else if(driver.getTitle().equalsIgnoreCase("Drug Cost Estimator")){
			return new ManageDrugPage(driver);
		}

		return null;
	}

	@Override
	public void openAndValidate() {

		validate(continueButton);

		JSONObject jsonObject = new JSONObject();
		for (String key : lowCostOptions.getExpectedData().keySet()) {
			WebElement element = findElement(lowCostOptions.getExpectedData()
					.get(key));
			if (null != element) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		lowCostOptionsJson = jsonObject;
		
		System.out.println("lowCostOptionsJson----->"+lowCostOptionsJson);

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,
			Map<String, String> dosageAttributesMap) {

		String drugDosage = dosageAttributesMap.get("Drug Dosage");
		String drugQuantity = dosageAttributesMap.get("Drug Quantity");
		String drugFrequency = dosageAttributesMap.get("Drug Frequency");
		String packages = dosageAttributesMap.get("Packages");

		String key = null;
		if ((packages != null) && (!(packages.equalsIgnoreCase("null")))) {
			key = drugDosage + "_" + drugQuantity + "_" + drugFrequency + "_"
					+ packages;
		} else {
			key = drugDosage + "_" + drugQuantity + "_" + drugFrequency;
		}

		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject lowCostOptionsExpectedJson = null;
		try {
			lowCostOptionsExpectedJson = (JSONObject) expectedDataMap.get(
					CommonConstants.LOW_COST_OPTIONS).get(key);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lowCostOptionsExpectedJson = CommonUtility.mergeJson(
				lowCostOptionsExpectedJson, globalExpectedJson);
		return lowCostOptionsExpectedJson;
	}
	
	@FindBy(xpath = ".//*[@id='dce.member']div/div[3]/div/div/div[1]/p[2]")
	private WebElement genericDrug;
	
	@FindBy(xpath = ".//*[@id='dce.member']div/div[3]/div/div/div[1]/p[1]/span/a")
	private WebElement editLink;
	
	public boolean validateLowCostSection(){
		boolean flag = false;
		if(validate(genericDrug)&&validate(continueButton)&&validate(editLink))
			flag = true;
		return flag;
	}
}