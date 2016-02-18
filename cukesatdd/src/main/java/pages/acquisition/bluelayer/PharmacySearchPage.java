/**
 * 
 */
package pages.acquisition.bluelayer;

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
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class PharmacySearchPage extends UhcDriver {

	@FindBy(id = "zipCode")
	private WebElement zipcodeField;

	@FindBy(id = "showresults")
	private WebElement distanceField;

	@FindBy(id = "continue")
	private WebElement continueField;

	@FindBy(id = "selectcounty_box")
	private WebElement countyPopOut;

	@FindBy(id = "selectcountytable")
	private WebElement selectcountytable;

	@FindBy(id = "plan")
	private WebElement planNameDropDown;

	@FindBys(value = { @FindBy(xpath = "//select[@id='plan']/option") })
	private List<WebElement> planNamesList;

	@FindBys(value = { @FindBy(xpath = "//table[@id='selectcountytable']/tbody/tr") })
	private List<WebElement> countyList;

	@FindBy(id = "pharmacies")
	private WebElement allPharmacies;

	@FindBy(id = "services")
	private WebElement particularServices;

	@FindBy(id = "find_searchbtn")
	private WebElement searchPharmaciesButton;

	@FindBys(value = { @FindBy(xpath = "//select/option") })
	private List<WebElement> distanceDropDown;

	@FindBys(value = { @FindBy(xpath = "//ul[@id='pharm_services']/li") })
	private List<WebElement> pharmacyTypesCheckboxes;

	@FindBy(xpath = "//form[@id='searchCriteria']/div[3]/p[2]/span")
	private WebElement narrowYourSearchContent;

	@FindBy(xpath = "//div[@id='medicareTitle']/h1")
	private WebElement pharmacyResultHeader;
	
	@FindBy(id = "services")
	private WebElement pharmacyTypeSelectionRadioButton;

import pages.acquisition.ulayer.ManageDrugPage;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;

public class PharmacySearchPage extends UhcDriver{

	@FindBy(xpath = "//div[@class='pharmacyListScroll']")
	private WebElement pharmacyTable;
	
	@FindBys(value = { @FindBy(xpath = "//select[@class='pharmacyDropDown']/option") })
	private List<WebElement> pharmacyDropDowmElements;

	@FindBys(value = { @FindBy(xpath = "//select[@class='milesDropDown']/option") })
	private List<WebElement> milesDropDownElements;
	
	@FindBy(className = "dceBlueBtn")
	WebElement selectLink;

	@FindBy(className = "rowBorder")
	List<WebElement> pharmacyRows;
	
	public JSONObject availablePharmaciesJson;
	


	private PageData pharmacies;
	
	public PageData pharmacyInfo;
	
	public PharmacySearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		String fileName = CommonConstants.SELECT_PHARMACIES_PAGE_DATA;
		pharmacies = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		String pharmacyInfoFileName = CommonConstants.PHARMACY_INFORMATION_PAGE_DATA;
		pharmacyInfo = CommonUtility.readPageData(pharmacyInfoFileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);

		openAndValidate();
	}

	public PharmacySearchPage enterZipDistanceDetails(String zipcode,
			String distance, String county) {

		sendkeys(zipcodeField, zipcode);
		selectFromDropDown(distanceDropDown, distance);

		continueField.click();
		CommonUtility.checkPageIsReady(driver);
		if (countyPopOut.isDisplayed()) {
			for (WebElement webElement : countyList) {
				if (webElement.getText().contains(county)) {
					webElement.click();
					break;
				}
			}
		}
		if (driver.getTitle().equalsIgnoreCase(
				"Locate a Pharmacy | UnitedHealthcare®")) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	public PharmacySearchPage selectsPlanName(String planName) {
		selectFromDropDown(planNamesList, planName);
		if (narrowYourSearchContent.getText().equalsIgnoreCase(
				"Narrow your search")) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}

	public PharmacyResultPage searchesPharmacy() {

		searchPharmaciesButton.click();
		CommonUtility.checkPageIsReady(driver);

		if (pharmacyResultHeader.getText().equalsIgnoreCase(
				"Pharmacies Available in Your Area")) {
			return new PharmacyResultPage(driver);
		}
		return null;

	}



	public PharmacyResultPage showAllPharmacies() {
		allPharmacies.click();
		searchPharmaciesButton.click();
		
		if (pharmacyResultHeader.getText().equalsIgnoreCase(
				"Pharmacies Available in Your Area")) {
			return new PharmacyResultPage(driver);
		}
		return null;
	}


	public PharmacySearchPage showParticularService() {
		particularServices.click();
		return new PharmacySearchPage(driver);

	}

	@Override
	public void openAndValidate() {
		validate(continueField);
	}

	public PharmacyResultPage searchSelectingPharmacyTypes(
			String[] pharmacyTypeArray) {

		pharmacyTypeSelectionRadioButton.click();
		for (String pharmacyType : pharmacyTypeArray) {
			for (WebElement checkBox : pharmacyTypesCheckboxes) {
				if (checkBox.getText().equalsIgnoreCase(pharmacyType)) {
					ElementData elementData = new ElementData("id",
							"pharmacyTypesCheckboxes");
					findChildElement(elementData, checkBox).click();
				}

	/*public AddDrugPage selectPharmacy(String pharmacyName) {

		WebElement pharmacyTable = driver.findElement(By
				.xpath("//div[@class='pharmacyListScroll']"));
		List<WebElement> allRows = pharmacyTable.findElements(By.tagName("tr"));
		for (WebElement row : allRows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			WebElement pharmacyNameElement = cells.get(0);
			String[] pharmacyArray = pharmacyNameElement.getText().split("\\n");
			if (pharmacyArray[1].equalsIgnoreCase(pharmacyName)) {
				WebElement selectLink = cells.get(1);
				selectLink.getText();
				selectLink.findElement(By.linkText("Select")).click();
				System.out.println("clicked");
				break;
				selectLink.findElement(By.xpath("//*[contains(text(), 'Select')]")).click();

			}
		}

		searchPharmaciesButton.click();

		if (pharmacyResultHeader.getText().equalsIgnoreCase(
				"Pharmacies Available in Your Area")) {
			return new PharmacyResultPage(driver);
		}
		return null;
	}
	*/
	
	public AddDrugPage selectPharmacy(String pharmacyName) {
		for (WebElement element : pharmacyRows) {
			if (element.getText().contains(pharmacyName)) {
				ElementData elementData = new ElementData("className",
						"dceBlueBtn");
				WebElement selectLink = findChildElement(elementData, element);
				selectLink.click();
				break;
			}

		}
		try {
			if (pharmacyTable.isDisplayed()) {
				CommonUtility.waitForElementToDisappear(driver, pharmacyTable,
						CommonConstants.TIMEOUT_30);
			}
		} catch (NoSuchElementException e) {
			System.out.println("pharmacyTable not found");
		} catch (TimeoutException ex) {
			System.out.println("pharmacyTable not found");
		} catch (Exception e) {
			System.out.println("pharmacyTable not found");
		}
		if (currentUrl().contains("manageDrugList")) {
			return new AddDrugPage(driver);
		} else {
			return null;
		}
	}

	public PharmacySearchPage searchPharmacies(String pharmacyType,
			String distance) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*ElementData pharmacyTypeElement = new ElementData("select:className",
				"pharmacyDropDown");
		List<WebElement> pharmacyTypeOptions = findElements(pharmacyTypeElement);
*/
		for (WebElement pharmacyTypeOption : pharmacyDropDowmElements) {
			if (pharmacyTypeOption.getText().equalsIgnoreCase(pharmacyType)) {
				pharmacyTypeOption.click();
			}
		}
/*
		ElementData distanceElement = new ElementData("select:className",
				"milesDropDown");
		List<WebElement> distanceOptions = findElements(distanceElement);*/

		for (WebElement distanceOption : milesDropDownElements) {
			if (distanceOption.getText().equalsIgnoreCase(distance)) {
				distanceOption.click();
			}
		}
		return new PharmacySearchPage(driver);
	}
	
	
	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : pharmacies.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(pharmacies
					.getExpectedData().get(key));
			if (elements.equals(pharmacyRows)) {
				JSONArray pharmacyInfoJsonArray = new JSONArray();
				if (elements.size() == 1) {
					if (validate(elements.get(0))) {
						JSONObject pharmacyInfoObject = new JSONObject();
						for (String pharmacyInfoKey : pharmacyInfo
								.getExpectedData().keySet()) {
							WebElement drugInforElement = findChildElement(
									pharmacyInfo.getExpectedData().get(
											pharmacyInfoKey), elements.get(0));
							try {
								pharmacyInfoObject.put(pharmacyInfoKey,
										drugInforElement.getText());
							} catch (JSONException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						pharmacyInfoJsonArray.put(pharmacyInfoObject);
						try {
							jsonObject.put(key, pharmacyInfoJsonArray);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} else if (elements.size() > 1) {
					for (WebElement element : elements) {
						if (validate(element)) {
							JSONObject drugInforObject = new JSONObject();
							for (String drugInfoKey : pharmacyInfo
									.getExpectedData().keySet()) {
								WebElement drugInforElement = findChildElement(
										pharmacyInfo.getExpectedData().get(
												drugInfoKey), element);
								try {
									drugInforObject.put(drugInfoKey,
											drugInforElement.getText());
								} catch (JSONException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
							pharmacyInfoJsonArray.put(drugInforObject);
						}
					}
					try {
						jsonObject.put(key, pharmacyInfoJsonArray);
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
								jsonObjectForArray.put(pharmacies
										.getExpectedData().get(key)
										.getElementName(), element.getText());
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
		availablePharmaciesJson = jsonObject;
		System.out.println("availablePharmaciesJson----->"
				+ availablePharmaciesJson);

	}

	public JSONObject getExpectedData(String fileName, String directory) {
		JSONObject availablePharmaciesExpectedJson = MRScenario
				.readExpectedJson(fileName, directory);
		return availablePharmaciesExpectedJson;
	}
	

}
