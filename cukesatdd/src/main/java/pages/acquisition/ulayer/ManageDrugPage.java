/**
 * 
 */
package pages.acquisition.ulayer;

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

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class ManageDrugPage extends UhcDriver {

	@FindBy(xpath = "//div[@class='costSavingsDrawer cb']")
	private WebElement switchTogenericButton;

	/*@FindBy(css = "div > img[alt=\"Plus Image\"]")
	WebElement plusSign;*/

	@FindBy(xpath = "//div[@class='reduceCosts generic']")
	private WebElement reduceCostPath;

	@FindBy(linkText = "Reduce costs")
	WebElement reduceCostLink;

	@FindBy(linkText = "View plan results")
	private WebElement viewPlansLink;

	@FindBy(className = "drugList")
	private List<WebElement> selectedDrug;
	
	@FindBy(xpath = "//div[@id='dcemodal']/div/div/div[8]/div[4]/a[2]")
	private WebElement pharmacySearchButton;
	
	@FindBy(xpath="//div[@class='delete']/a")
	WebElement drugDelete;
	
	@FindBy(linkText = "Close and apply changes")
	WebElement applyChangesButton;
	
	@FindBy(xpath = "//div[@class='addDrugBox']")
	WebElement adddrugdiv;
	
	@FindBy(xpath="//div[@class='tabsHead']/div[2]")
	WebElement selectPharmacyTab;

	public JSONObject manageDrugJson;

	private PageData drugInfo;
	
	private PageData manageDrug;

	public ManageDrugPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String manageDrugFile = CommonConstants.MANAGE_DRUG_PAGE_DATA;
		manageDrug = CommonUtility.readPageData(manageDrugFile,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		if (!selectedDrug.isEmpty()) {
			String drugInfoFile = CommonConstants.SELECTED_DRUG_INFORMATION_PAGE_DATA;
			drugInfo = CommonUtility.readPageData(drugInfoFile,
					CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		}
		openAndValidate();

	}

	public AddDrugPage navigateToAddDrug() {
		/*plusSign.click();
		try {
			if (plusSign.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, plusSign,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("pharmacySearchButton not found");
		} catch (TimeoutException ex) {
			System.out.println("pharmacySearchButton not found");
		} catch (Exception e) {
			System.out.println("pharmacySearchButton not found");
		}
		*/
		if(currentUrl().contains("drugSearch"))
		{
			return new AddDrugPage(driver);
		}
		return null;
	}
	
	public SelectPharmacyPage navigateToPharmacyPage() {
		pharmacySearchButton.click();
		try {
			if (pharmacySearchButton.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver,
						pharmacySearchButton, CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("pharmacySearchButton not found");
		} catch (TimeoutException ex) {
			System.out.println("pharmacySearchButton not found");
		} catch (Exception e) {
			System.out.println("pharmacySearchButton not found");
		}

		if (currentUrl().contains("selectPharmacy")) {
			return new SelectPharmacyPage(driver);
		} else {
			return null;
		}

	}
	
	public VPPPlanSummaryPage navigateToPlanSummaryPage() {

		viewPlansLink.click();
		try {
			if (viewPlansLink.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, viewPlansLink,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("viewPlansLink not found");
		}
		catch (TimeoutException ex)
		{
			System.out.println("viewPlansLink not found");
		}
		catch(Exception e)
		{
			System.out.println("viewPlansLink not found");
		}
		if (currentUrl().contains("health-plans.html")) {
			return new VPPPlanSummaryPage(driver);
		} else {
			return null;
		}

	}
	
	public void reduceCost() {
		reduceCostLink.click();
		System.out.println("reduce cost");

	}

	public void switchToGeneric() {
		switchTogenericButton.findElement(By.linkText("Switch to generic"))
				.click();
		System.out.println();
	}

	public void applyChanges() {
		applyChangesButton.click();
		System.out.println("changes");

	}
	
	public JSONObject getExpectedData(String fileName, String directory) {
		JSONObject drugsAddedExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);
		return drugsAddedExpectedJson;

	}

	@Override
	public void openAndValidate() {
		//validate(plusSign);

		if (!selectedDrug.isEmpty()) {
		JSONObject jsonObject = new JSONObject();
		for (String key : manageDrug.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(manageDrug
					.getExpectedData().get(key));
			if (elements.equals(selectedDrug)) {
				JSONArray drugInforJsonArray = new JSONArray();
				if (elements.size() == 1) {
					if (validate(elements.get(0))) {
						JSONObject drugInforObject = new JSONObject();
						for (String drugInfoKey : drugInfo
								.getExpectedData().keySet()) {
							WebElement drugInforElement = findChildElement(
									drugInfo.getExpectedData().get(
											drugInfoKey), elements.get(0));
							try {
								drugInforObject.put(drugInfoKey,
										drugInforElement.getText());
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						drugInforJsonArray.put(drugInforObject);
						try {
							jsonObject.put(key, drugInforJsonArray);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else if (elements.size() > 1) {
					for (WebElement element : elements) {
						if (validate(element)) {
							JSONObject drugInforObject = new JSONObject();
							for (String drugInfoKey : drugInfo
									.getExpectedData().keySet()) {
								WebElement drugInforElement = findChildElement(
										drugInfo.getExpectedData().get(
												drugInfoKey),
										element);
								try {
									drugInforObject.put(drugInfoKey,
											drugInforElement.getText());
								} catch (JSONException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							drugInforJsonArray.put(drugInforObject);
						}
					}
					try {
						jsonObject.put(key, drugInforJsonArray);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else {
				if (elements.size() == 1) {
					if (validate(elements.get(0))) {
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

						if (validate(element)) {
							try {
								JSONObject jsonObjectForArray = new JSONObject();
								jsonObjectForArray.put(manageDrug
										.getExpectedData().get(key)
										.getElementName(),
										element.getText());
								jsonArray.put(jsonObjectForArray);
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
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

		}
		manageDrugJson = jsonObject;
		System.out.println("manageDrugJson with selected drug info----->"
				+ manageDrugJson);
	}
	

	}
	
	public AddDrugPage addDrugFlowCheck() {		
		drugDelete.click();
		if(currentUrl().contains("drugSearch"))
		{
			return new AddDrugPage(driver);
		}		
		
		return null;
	}
	
	public void clickAddImage() {       
        validate(adddrugdiv);
        adddrugdiv.click();
	}
	
	public void swithedToSelectPharmacyTab(){
		selectPharmacyTab.click();
	}
	
	public SelectPharmacyPage navigateToUpdatedPharmacyPage() {
		if (currentUrl().contains("selectPharmacy")) {
			return new SelectPharmacyPage(driver);
		} else {
			return null;
		}

	}

}
