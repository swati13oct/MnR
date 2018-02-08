/**
 * 
 */
package pages.acquisition.bluelayer;

import java.util.List;
import java.util.Map;

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
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pjaising
 *
 */
public class ManageDrugPage extends UhcDriver {

	@FindBy(xpath = "//div[@class='costSavingsDrawer cb']")
	private WebElement switchTogenericButton;

	@FindBy(css = "div > img[alt=\"Plus Image\"]")
	WebElement plusSign;

	@FindBy(xpath = "//div[@class='reduceCosts generic']")
	private WebElement reduceCostPath;

	@FindBy(linkText = "Reduce costs")
	WebElement reduceCostLink;

	@FindBy(linkText = "Switch to generic")
	WebElement switchToGenericLink;

	@FindBy(linkText = "View plan results")
	private WebElement viewPlansLink;

	@FindBy(linkText = "Close and apply changes")
	private WebElement closeAndApplyChangesLink;

	@FindBy(className = "drugList")
	private List<WebElement> selectedDrug;

	@FindBy(xpath = "//div[@id='dcemodal']/div/div/div[8]/div[4]/a[2]")
	private WebElement pharmacySearchButton;

	@FindBy(xpath = "//span[@class='dceOrangeBtn']")
	private WebElement pharmacySearchButton2;

	@FindBy(linkText = "Close and apply changes")
	WebElement applyChangesButton;

	@FindBy(xpath="//div[@class='delete']/a")
	WebElement drugDelete;

	@FindBy(xpath = "//div[@class='addDrugBox']")
	WebElement adddrugdiv;

	@FindBy(xpath="//div[@class='tabsHead']/div[2]")
	WebElement selectPharmacyTab;

	@FindBy(xpath="//div[@class='tabsHead']/div")
	WebElement manageDrugTab;

	@FindBy(className = "drugSearchBox")
	WebElement drugSearchBox;

	@FindBy(xpath = "/html/body/div[3]/div/table/tbody/tr[3]/td/div/div/div/div/div[7]/form/div[2]/span[3]/p/span")
	private WebElement expectedTooltip;

	@FindBy(xpath = "//span[@class='tooltipalign']/p/span")
	private WebElement addtooltip;

	@FindBy(xpath = "//div[contains(@class, 'drugDetailsMessage')]")
	private WebElement drugdetailMsg;

	@FindBy(className = "drugDetailsMessage")
	private WebElement drugdetailMsg1;
	
	@FindBy(linkText = "Edit Pharmacy")
	WebElement editPharmacyLink;

	@FindBy(xpath = "//span[@class='current-pharmacy']")
	private WebElement pharmacyNameElement;
	
	public JSONObject manageDrugJson;

	private PageData drugInfo;

	private PageData manageDrug;

	public ManageDrugPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		/*		String manageDrugFile = CommonConstants.MANAGE_DRUG_PAGE_DATA;
		manageDrug = CommonUtility.readPageData(manageDrugFile,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		if (!selectedDrug.isEmpty()) {
			String drugInfoFile = CommonConstants.SELECTED_DRUG_INFORMATION_PAGE_DATA;
			drugInfo = CommonUtility.readPageData(drugInfoFile,
					CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		}
		 */
		openAndValidate();

	}


	public boolean validateDruginformation(String drugSelected,Map<String, String> dosageMap){
		boolean flag = true;
		try {
			Thread.sleep(5000);	
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("*************");
		System.out.println(drugdetailMsg1.getText());
		if(!drugdetailMsg1.getText().equals("You added "+drugSelected+" to your Drug List.")){
			flag = false;
		}

		String selectedDrugdetailsExpected=dosageMap.get("Drug Dosage")+"\n"+"Qty "+dosageMap.get("Quantity")+" "+dosageMap.get("Drug Frequency")+
				"\nSwitch to generic\nEdit\nDelete";
		String selectedDrugdetailsActual = selectedDrug.get(0).getText();	
		System.out.println(selectedDrugdetailsActual);
		if(!selectedDrugdetailsActual.equals(selectedDrugdetailsExpected)){
			flag = false;
		}
		return flag;
	}
	
	public boolean validateSelectedpharmacy(String pharmacyName, String pharmacyType){
		boolean flag = true;
		String expectedPharmacytype = null;
		if(pharmacyType.equals("Available Pharmacies")){
			 expectedPharmacytype = "Standard Network Pharmacy";
		}
		ElementData elementData = new ElementData("className", "current-pharmacy");
		List<WebElement> selectedPharmacyname = findElements(elementData);
		System.out.println(selectedPharmacyname.get(0).getText());
		if(!selectedPharmacyname.get(0).getText().equals(pharmacyName)){
			flag = false;
		}
		
		ElementData elementData_type = new ElementData("className", "current-pharmacy-type");
		List<WebElement> selectedPharmacytype = findElements(elementData_type);
		for (WebElement pharmacy : selectedPharmacytype) {
			System.out.println(pharmacy.getText());
			if (!pharmacy.getText().equals(expectedPharmacytype)){
				flag = false;
			}
		}
		
		if(!editPharmacyLink.isDisplayed()){
			flag = false;
		}
		return flag;
	}

	public AddDrugPage navigateToAddDrug() {
		plusSign.click();
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

		if (currentUrl().contains("drugSearch")) {
			return new AddDrugPage(driver);
		}
		return null;
	}

	public SelectPharmacyPage navigateToPharmacyPage() {
		pharmacySearchButton2.click();
		try {
			if (pharmacySearchButton2.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver,
						pharmacySearchButton2, CommonConstants.TIMEOUT_30);
			}
			Thread.sleep(2000);
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
	
	public SelectPharmacyPage navigateToPharmacyPageByclickingEditPharmacy() {
		editPharmacyLink.click();
		try {
			if (editPharmacyLink.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver,
						editPharmacyLink, CommonConstants.TIMEOUT_30);
			}
			Thread.sleep(2000);
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
		} catch (TimeoutException ex) {
			System.out.println("viewPlansLink not found");
		} catch (Exception e) {
			System.out.println("viewPlansLink not found");
		}
		if (currentUrl().contains("health-plans.html")) {
			return new VPPPlanSummaryPage(driver);
		} else {
			return null;
		}

	}

	public ManageDrugPage reduceSelectedDrugCost() {
		reduceCostLink.click();

		try {
			if (reduceCostLink.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, reduceCostLink,
						CommonConstants.TIMEOUT_30);

			}
		} catch (NoSuchElementException e) {
			System.out.println("reduceCostLink not found");
		} catch (TimeoutException ex) {
			System.out.println("reduceCostLink not found");
		} catch (Exception e) {
			System.out.println("reduceCostLink not found");
		}
		if (currentUrl().contains("manageDrugList")) {
			return new ManageDrugPage(driver);
		} else {
			return null;
		}
	}

	public ManageDrugPage reduceCostForADrug(String drugName, String quantity, String frequency) {
		String selectedDrugName = drugName+"\n"+"Qty "+quantity+" "+frequency;
		ElementData elementData = new ElementData("id","branded");
		for(WebElement drug: selectedDrug)
		{
			WebElement selectedDrug = findChildElement(elementData, drug);
			if(selectedDrugName.equalsIgnoreCase(selectedDrug.getText()))
			{
				ElementData reduceCostElementData = new ElementData("linkText","Reduce Costs");
				WebElement reduceCostLink = findChildElement(reduceCostElementData, drug);
				reduceCostLink.click();
			}
		}
		try {
			if (reduceCostLink.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, reduceCostLink,
						CommonConstants.TIMEOUT_30);

			}
		} catch (NoSuchElementException e) {
			System.out.println("reduceCostLink not found");
		} catch (TimeoutException ex) {
			System.out.println("reduceCostLink not found");
		} catch (Exception e) {
			System.out.println("reduceCostLink not found");
		}
		if (currentUrl().contains("manageDrugList")) {
			return new ManageDrugPage(driver);
		} else {
			return null;
		}

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
		/*
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
								if (validate(drugInforElement)) {
									try {
										drugInforObject.put(drugInfoKey,
												drugInforElement.getText());
									} catch (JSONException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
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
													drugInfoKey), element);
									if (validate(drugInforElement)) {
										try {
											drugInforObject.put(drugInfoKey,
													drugInforElement.getText());
										} catch (JSONException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
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

		 */

	}

	public ManageDrugPage switchToGeneric(String drugDosage, String quantity,
			String drugFrequency) {
		String selectedDrugName = drugDosage+"\n"+"Qty "+quantity+" "+drugFrequency;
		ElementData elementData = new ElementData("id","branded");
		for(WebElement drug: selectedDrug)
		{
			WebElement selectedDrug = findChildElement(elementData, drug);
			if(selectedDrugName.equalsIgnoreCase(selectedDrug.getText()))
			{
				ElementData switchToGenericElementData = new ElementData("linkText","Switch to generic");
				WebElement switchToGenericLink = findChildElement(switchToGenericElementData, drug);
				switchToGenericLink.click();
			}
		}

		try {
			if (switchToGenericLink.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, switchToGenericLink,
						CommonConstants.TIMEOUT_30);

			}
		} catch (NoSuchElementException e) {
			System.out.println("switchToGenericLink not found");
		} catch (TimeoutException ex) {
			System.out.println("switchToGenericLink not found");
		} catch (Exception e) {
			System.out.println("switchToGenericLink not found");
		}
		if (currentUrl().contains("manageDrugList")) {
			return new ManageDrugPage(driver);
		} else {
			return null;
		}
	}

	public void performSwitchtoGenericfunctionality(){
		switchToGenericLink.click();
		drugDelete.click();
	}
	public VPPPlanSummaryPage applieschanges() {
		closeAndApplyChangesLink.click();
		try {
			if (closeAndApplyChangesLink.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, closeAndApplyChangesLink,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("closeAndApplyChangesLink not found");
		} catch (TimeoutException ex) {
			System.out.println("closeAndApplyChangesLink not found");
		} catch (Exception e) {
			System.out.println("closeAndApplyChangesLink not found");
		}
		if (currentUrl().contains("health-plans.html")) {
			return new VPPPlanSummaryPage(driver);
		}		
		return null;


	}

	public PlanDetailsPage applieschanges(String planName) {
		closeAndApplyChangesLink.click();
		try {
			if (closeAndApplyChangesLink.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, closeAndApplyChangesLink,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("closeAndApplyChangesLink not found");
		} catch (TimeoutException ex) {
			System.out.println("closeAndApplyChangesLink not found");
		} catch (Exception e) {
			System.out.println("closeAndApplyChangesLink not found");
		}

		if(currentUrl().contains("plan-detail.html")){
			//return new PlanDetailsPage(driver,planName);
		}

		return null;


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



	public void toolTipValidation() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(expectedTooltip);
		validate(addtooltip);
		System.out.println("Tool tips validated");
	}


	public SelectPharmacyPage navigateToUpdatedPharmacyPage() {
		if (currentUrl().contains("selectPharmacy")) {
			return new SelectPharmacyPage(driver);
		} else {
			return null;
		}

	}

	public void validateAddDrugFlow(){
		validate(drugSearchBox);
		selectPharmacyTab.click();
		manageDrugTab.click();
		validate(drugSearchBox);

	}


}
