/**
 * 
 */
package pages.member.bluelayer;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
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

	@FindBy(id = "dis_continue_btn")
	private WebElement continueField;
	
	@FindBy(id = "cancleBTN")
	private WebElement continueButton;

	@FindBy(xpath = "//div[@id='medicareTitle']/h1")
	private WebElement pharmacySearchHeading;
	
	@FindBy(xpath = "//div[@id='subPageLeft']/div[2]/div[2]/h3")
	private WebElement pharmacySearchResultMsg;
	
	@FindBy(id = "selectcounty_box")
	private WebElement countyPopOut;

	@FindBy(id = "selectcountytable")
	private WebElement selectcountytable;
	
	@FindBys(value = { @FindBy(xpath = "//select[@id='showresults']/option") })
	private List<WebElement> distanceValues;
	
	@FindBys(value = { @FindBy(xpath = "//ul[@id='pharm_services']/li") })
	private List<WebElement> pharmacyTypesCheckboxes;

	@FindBy(id = "plan")
	private WebElement planNameDropDown;
	
	@FindBys(value = { @FindBy(xpath = "//select[@id='plan']/option") })
	private List<WebElement> planNames;
	
	@FindBy(id = "find_searchbtn")
	private WebElement searchPharmaciesButton;

	@FindBy(id = "pharm_services")
	private WebElement pharmacyTypes;

	@FindBy(id = "services")
	private WebElement pharmacyTypeSelectionRadioButton;
	@FindBy(xpath = "//*[@id='medicareTitle']/p/a[1]")
	private WebElement espanolLink;
	
	@FindBy(xpath = "//*[@id='medicareTitle']/p/a[2]")   //Story 261070
	private WebElement chineseLink;
	
	@FindBy(xpath = "////*[@id='subPageLeft']/div[2]/div[2]/h3[2]/a")
	private WebElement createPdfLink;
	
	public String county = null;

	public PharmacySearchPage(WebDriver driver) {

		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public PharmacySearchPage enterZipDistanceDetails(
			Map<String, String> zipAttributesMap) {
		
		String zipcode = zipAttributesMap.get("Zip Code");
		if (zipcode != null) {
			sendkeys(zipcodeField, zipcode);
		}
		String distance = zipAttributesMap.get("Distance");
		selectFromDropDown(distanceValues, distance);

		if (zipcode != null) {
			continueButton.click();
		} else {
			continueField.click();
		}

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			if (countyPopOut.isDisplayed()) {
				county = zipAttributesMap.get("County");
				List<WebElement> countyList = selectcountytable.findElements(By
						.tagName("tr"));
				selectFromDropDown(countyList, county);
			}
		} catch (Exception e) {
			return null;
		}

		if (this.driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Pharmacy Directory")) {
			return new PharmacySearchPage(driver);
		}

		return null;
	}

	public PharmacySearchPage selectsPlanName(String planName) {
		
		selectFromDropDown(planNames,planName);
		if (driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Pharmacy Directory")) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}


	public PharmacyResultPage searchesPharmacy() {

		searchPharmaciesButton.click();
		CommonUtility.waitForPageLoad(driver, pharmacySearchResultMsg, CommonConstants.TIMEOUT_30);
		if (driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Pharmacy Directory")) {
			return new PharmacyResultPage(driver);
		}
		return null;

	}

	public PharmacySearchPage selectsPharmacy(String[] pharmacyTypeArray) {

		pharmacyTypeSelectionRadioButton.click();
		for (String pharmacyType : pharmacyTypeArray) {
			for (WebElement checkBox : pharmacyTypesCheckboxes) {
				if (checkBox.getText().equalsIgnoreCase(pharmacyType)) {
					checkBox.findElement(By.tagName("input")).click();
				}
			}
		}
		if (this.driver.getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Pharmacy Directory")) {
			return new PharmacySearchPage(driver);
		}
		return null;

	}
	public PharmacySearchPage clickEspanol(){
		espanolLink.click();
		return new PharmacySearchPage(driver);
	}
	
	public PharmacySearchPage clickChinese(){
		chineseLink.click();
		   //Story 261070
		return new PharmacySearchPage(driver);
	}
	
	public PharmacySearchPage clickCreatePdf(){
		createPdfLink.click();
		System.out.println("CreatePdf clicked");
		return new PharmacySearchPage(driver);
	}

	@Override
	public void openAndValidate() {
		validate(continueField);
		validate(searchPharmaciesButton);
		validate(espanolLink);
		validate(chineseLink);
		validate(createPdfLink); 
	}

	public String getExpectedKey(String[] pharmacyTypeArray) {
		
		String zipcode = zipcodeField.getAttribute("value");

		String distance = null;
		for (WebElement distanceValue : distanceValues) {
			if (distanceValue.isSelected()) {
				distance = distanceValue.getText();
			}
		}

		String planName = null;
		for (WebElement planNameValue : planNames) {
			if (planNameValue.isSelected()) {
				planName = planNameValue.getText();
			}
		}

		String key = null;
		if (county != null) {
			key = zipcode + "_" + county + "_" + distance + "_" + planName;
		} else {
			key = zipcode + "_" + distance + "_" + planName;
		}

		if (pharmacyTypeArray != null) {
			for (String pharmacyType : pharmacyTypeArray) {
				if (pharmacyType != null && pharmacyType != "null") {
					key = key + "_" + pharmacyType;
				}
			}
		}

		return key;
	}
}
