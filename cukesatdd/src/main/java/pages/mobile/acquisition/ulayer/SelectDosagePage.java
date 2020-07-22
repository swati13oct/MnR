package pages.mobile.acquisition.ulayer;

/*@author pagarwa5*/

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class SelectDosagePage extends UhcDriver {

	@FindBy(className = "borderBtmGrey")
	List<WebElement> drugDosage;

	@FindBy(className = "individualDrug")
	WebElement drugdosageInput;

	@FindBy(xpath = "//div[@className ='drugListScroll']/div/div")
	WebElement drugDosageBlock;

	@FindBy(name = "Quantity")
	WebElement quantityField;

	@FindBy(linkText = "Continue")
	WebElement continueButton;

	@FindBy(className = "dropDown")
	WebElement frequencyDropdown;

	@FindBy(className = "drugListScroll")
	WebElement dosageElement;

	private PageData drugDosageInfo;

	public JSONObject drugDosageJson;

	public SelectDosagePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, quantityField,
				CommonConstants.TIMEOUT_30);
		String fileName = CommonConstants.DRUG_DOSAGE_PAGE_DATA;
		drugDosageInfo = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}

	public Object selectDosage(String drugDosage, String drugQuantity,
			String drugFrequency, String packages) {
		ElementData elementData = new ElementData("className", "borderBtmGrey");
		List<WebElement> drugDosages = findElements(elementData);

		for (WebElement dosage : drugDosages) {
			if (dosage.getText().equalsIgnoreCase(drugDosage)) {
				ElementData dosageElementData = new ElementData("className",
						"individualDrug");
				WebElement dosageElement = findChildElement(dosageElementData,
						dosage);

				if (!dosageElement.isSelected()) {

					dosageElement.click();
					System.out.println("not selected");
					selectPackage(packages);

				}

				else {
					selectPackage(packages);
				}

			}

		}

		/* select quantity */
		sendkeys(quantityField, drugQuantity);

		/* select frequncy */
		ElementData frequencyElement = new ElementData("select:className",
				"dropDown");
		List<WebElement> frequencyOptions = findElements(frequencyElement);

		for (WebElement frequencyOption : frequencyOptions) {
			if (frequencyOption.getText().equalsIgnoreCase(drugFrequency)) {
				frequencyOption.click();
			} 
		}

		continueButton.click();
		try {
			if (dosageElement.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, dosageElement,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("dosageElement not found");
		}
		catch (TimeoutException ex)
		{
			System.out.println("dosageElement not found");
		}
		catch(Exception e)
		{
			System.out.println("dosageElement not found");
		}
		if (currentUrl().contains("selectGeneric")) {
			return new SelectGenericPage(driver);
		} else if(currentUrl().contains("manageDrugList")) {
			return new ManageDrugPage(driver);
		}
		else
		{
			return null;
		}

	}

	private void selectPackage(String packages) {
		if (null != packages) {
			for (WebElement pack : drugDosage) {
				if (pack.getText().equalsIgnoreCase(packages)) {
					if (!pack.findElement(By.xpath("//input")).isSelected()) {

						pack.findElement(By.name("packageDisplayName")).click();
						System.out.println("not selected");

					}
				}
			}
		}

	}

	@Override
	public void openAndValidate() {
		validate(quantityField);
		validate(continueButton);
		JSONObject jsonObject = new JSONObject();
		for (String key : drugDosageInfo.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(drugDosageInfo
					.getExpectedData().get(key));
			if (elements.size() == 1) {
				validate(elements.get(0));
				try {
					if (elements.get(0).getText() != null
							&& !elements.get(0).getText().isEmpty()) {
						jsonObject.put(key, elements.get(0).getText());
					} else if (elements.get(0).getAttribute("value") != null
							&& !elements.get(0).getAttribute("value").isEmpty()) {
						jsonObject.put(key,
								elements.get(0).getAttribute("value"));
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
						jsonObjectForArray.put(key, element.getText());
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
		drugDosageJson = jsonObject;
		System.out.println("drugDosageJson----->" + drugDosageJson);

	}

}
