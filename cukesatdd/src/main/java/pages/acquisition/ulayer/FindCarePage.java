package pages.acquisition.ulayer;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class FindCarePage extends UhcDriver {

	public FindCarePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();

	}

	@FindBy(xpath = "//span[text()='Find Care']")
	public WebElement FindCareLink;

	@FindBy(xpath = "//button[@class='action-btn getStarted']")
	public WebElement GetstartedButton;

	@FindBy(xpath = "//span[@class='location']")
	public WebElement LocationLink;

	@FindBy(xpath = "//span[text()='Change Location']")
	public WebElement ChangeLocationButton;

	@FindBy(xpath = "//*[contains(@data-ui-element-name,'Places')]")
	public WebElement PlacesButton;

	@FindBy(xpath = "//*[contains(@data-ui-element-name,'Hospitals')]")
	public WebElement HospitalsButton;

	@FindBy(xpath = "//h1[text()='Which type of place?']")
	public WebElement Whichtypeofplace;

	@FindBy(xpath = "//h1//span[text()='Results for ']")
	public WebElement ResultsHeader;

	@FindBy(xpath = "(//*[contains(@data-test-id,'provider-name-link')])[1]")
	public WebElement FirstHospitalRecord;

	@FindBy(xpath = "//Img[@alt='Facility icon']")
	public WebElement Facilityicon;

	@FindBy(xpath = "//h1[@class='heading']")
	public WebElement PlanHeading;

	@FindBy(xpath = "//button[contains(@class,'cta-header-button')]//span[text()='Save']")
	public WebElement SaveButton;

	@FindBy(xpath = "//h1[@class='provider-name']")
	public WebElement ProviderNameHeader;

	@FindBy(xpath = "//header[@class='txtCenter step-header']")
	public WebElement GreatHeaderText;

	@FindBy(xpath = "//a[contains(text(),'View Saved')]")
	public WebElement ViewSavedButton;

	@FindBy(xpath = "//*[contains(@data-ui-element-name,'Saved')]")
	public WebElement SavedHeader;

	@FindBy(xpath = "//h2[@class='provider-name']//a")
	public WebElement SavedProviderName;

	@FindBy(xpath = "(//*[contains(text(),'Check Provider Coverage')])[1]")
	public WebElement CheckProviderCoverageButton;

	@FindBy(xpath = "(//*[contains(text(),'Edit my Doctor')])[1]")
	public WebElement EditproviderlistLink;
	
	@FindBy(xpath = "//*[contains(@class,'modal-btns')]//*[contains(text(),'Save')]")
	public WebElement addressSaveButton; 
	
	@FindBy(xpath = "//*[contains(@id,'label_unsaved_selectedLocation0')]")
	public WebElement addressCheckBox;

	public ComparePlansPage getstarted() throws Exception {
		validate(GetstartedButton);
		GetstartedButton.click();
		System.out.println("in find care page");
		validate(LocationLink);
		validate(ChangeLocationButton);
		PlacesButton.click();
		waitforElement(Whichtypeofplace);
		HospitalsButton.click();
		waitforElement(ResultsHeader);
		String HospName = FirstHospitalRecord.getText();
		FirstHospitalRecord.click();
		validate(Facilityicon);
		if (HospName.equals(PlanHeading.getText())) {
			System.out.println("Provder Name is verified :: " + HospName);
		}
		SaveButton.click();
		waitforElement(ProviderNameHeader);
		String ProvName = ProviderNameHeader.getText();
		if (HospName.equals(ProvName)) {
			System.out.println("Provder Name is verified");
		} else {
			System.out.println("selected Provder Name is not matching");
		}
		
		if(validate(addressCheckBox)){
			addressCheckBox.click();
			addressSaveButton.click();
		}
		String GreatText = GreatHeaderText.getText();
		System.out.println("Text is :: " + GreatText);
		ViewSavedButton.click();
		waitforElement(SavedHeader);
		if (HospName.equals(SavedProviderName.getText())) {
			System.out.println("Provder Name is verified :: " + HospName);
		}
		String ParentWindow = driver.getTitle();
		CheckProviderCoverageButton.click();
		Set<String> handles1 = driver.getWindowHandles();
		for (String windowHandle : handles1) {
			if (!windowHandle.equals(ParentWindow)) {
				driver.switchTo().window(windowHandle);
				String title = driver.getTitle();
				System.out.println("Window title is : " + title);
				if (title.contains("Compare Medicare Plans")) {
					System.out.println("We are on Compare Medicare Plans winodow opened");
					driver.manage().window().maximize();
					Thread.sleep(3000);
					waitforElement(EditproviderlistLink);
					break;
				}
			} else {
				System.out.println("Not found Expected window");
				driver.switchTo().window(ParentWindow);
			}

		}
		if (currentUrl().contains("/health-plans.html#/plan-compare"))
			return new ComparePlansPage(driver);
		return null;

	}

	@Override
	public void openAndValidate() {

		CommonUtility.waitForPageLoadNew(driver, FindCareLink, 30);
		validate(FindCareLink);

	}

}
