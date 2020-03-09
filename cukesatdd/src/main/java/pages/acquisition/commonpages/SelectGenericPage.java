package pages.acquisition.commonpages;

/*@author pagarwa5*/

import java.io.File;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.acquisition.dce.DceCommonConstants;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

public class SelectGenericPage extends UhcDriver {
	
	
	@FindBy(linkText = "Continue")
	WebElement continueButton;
	
	@FindBy(className = "genericDrugDetailsSec")
	WebElement genericDrugSection;
	
	@FindBy(name = "drug")
	List<WebElement> drugs;
	
	private PageData genericDrug;

	public JSONObject genericDrugJson;

	public SelectGenericPage(WebDriver driver) {
		super(driver);
		CommonUtility.waitForPageLoad(driver, genericDrugSection, CommonConstants.TIMEOUT_30);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.SELECT_GENERIC_PAGE_DATA;
		genericDrug = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}

	public ManageDrugPage selectGeneric(String drugDosage) {
		for (WebElement dosage : drugs) {		
				if (dosage.getText().equalsIgnoreCase(drugDosage) && !dosage.isSelected()) {

					dosage.click();
					System.out.println("not selected");

				}
		}
		
		continueButton.click();
		try {
			if (genericDrugSection.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, genericDrugSection,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("Generic Drug Section not found"+e);
		}
		catch (TimeoutException ex)
		{
			System.out.println("Generic Drug Section not found"+ex);
		}
		catch(Exception e)
		{
			System.out.println("Generic Drug Section not found"+e);
		}
		if (currentUrl().contains("manageDrugList")) {
			return new ManageDrugPage(driver);
		} else {
			return null;
		}

		
		
	}

	@Override
	public void openAndValidate() {
		validate(continueButton);
		JSONObject jsonObject = new JSONObject();
		for (String key : genericDrug.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(genericDrug
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				validate(elements.get(0));
				try {
					if(elements.get(0).getText()!=null && !elements.get(0).getText().isEmpty())
					{
					jsonObject.put(key, elements.get(0).getText());
					}
					else if(elements.get(0).getAttribute("value")!=null && !elements.get(0).getAttribute("value").isEmpty())
					{
						jsonObject.put(key, elements.get(0).getAttribute("value"));
					}	
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					validate(element);
					try {
						JSONObject jsonObjectForArray = new JSONObject();
						jsonObjectForArray.put(genericDrug.getExpectedData()
								.get(key).getElementName(), element.getText());
						jsonArray.put(jsonObjectForArray);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					jsonObject.put(key, jsonArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		genericDrugJson = jsonObject;
		System.out.println("genericDrugJson----->"+genericDrugJson);
		
		
	}

	public JSONObject getExpectedData(String drugName, String drugDosageWithQty)
	{
		String fileName = drugName;
		String directory = CommonConstants.ACQUISITION_EXPECTED_DIRECTORY+File.separator+CommonConstants.SITE_ULAYER+File.separator+DceCommonConstants.SELECT_GENERIC_FLOW_NAME+File.separator;
		JSONObject selectGeneric = MRScenario.readExpectedJson(fileName, directory);
		JSONObject selectGenericExpectedJson = null;
		try {
			selectGenericExpectedJson = selectGeneric.getJSONObject(drugDosageWithQty);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selectGenericExpectedJson;
	}
}
