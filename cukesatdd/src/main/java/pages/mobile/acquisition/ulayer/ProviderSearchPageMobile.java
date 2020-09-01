/**
 * 
 */
package pages.mobile.acquisition.ulayer;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class ProviderSearchPageMobile extends UhcDriver {

	private static final String planToBeSelected = null;

	@FindBy(className = "firstTierFilterItem")
	private WebElement physcianSearchTypes;

	@FindBys(value = { @FindBy(xpath = "//div[@id='providerResultsContainer']/div") })
	private List<WebElement> providerNameList;

	@FindBy(className = "cboxIframe")
	private WebElement cboxIframeElement;

	@FindBy(className = "providerName")
	private WebElement providerName;

	@FindBy(id = "ctl00_PopupContentPlaceHolder_CompleteListButton")
	private WebElement completeMyList;

	@FindBy(id = "pageHeader")
	private WebElement pageHeader;

	@FindBy(xpath = "(//*[@data-test-id='saved-provider-button'])[1]")
	private WebElement selectProviderBtn;

	@FindBys(value = {
			@FindBy(xpath = "//div[@class='acquisitionButtons hidden-phone']//button[contains(@class,'saved-provider-button')]/span[text()='Save']") })
	private List<WebElement> SaveBtns;

	@FindBys(value = {
			@FindBy(xpath = "//div[@class='acquisitionButtons hidden-phone']//button[contains(@class,'saved-provider-button')]") })
	private List<WebElement> MulitpleSaveBtns;

	@FindBy(xpath = "//button[@data-test-id='button-close']")
	private WebElement Viewsavebtn;
	
	@FindBy(xpath = "//*[contains(@class,'action-btn') and contains(text(),'Finish')]")
	private WebElement finishReturnBtn;
	
	@FindBy(xpath = "//*[text()='View Saved']")
	private WebElement ViewsaveProviderbtn;
	
	@FindBy(xpath="//*[contains(@text(),'View Saved')]")
	private WebElement EditSavedButton;
	
	@FindBy(xpath="//span[text()='View Saved Providers']")
	private WebElement ViewSavedProvidersLink;

	@FindBy(xpath = "//*[contains(@id,'label_unsaved_selectedLocation0')]")
	private WebElement selectLocationOption;

	@FindBy(xpath = "(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[1]")
	private WebElement Checkcoverage;

	@FindBy(xpath = "//*[contains(text(),'People')][contains(@class,'option-title')]")
	private WebElement People;

	@FindBy(xpath = "//*[contains(text(),'Places')][contains(@class,'option-title')]")
	private WebElement Places;

	@FindBy(xpath = "//*[contains(text(),'Hospitals')][contains(@class,'option-title')]")
	private WebElement Hospitals;

	@FindBy(xpath = "//*[contains(text(),'Primary Care')][contains(@class,'option-title')]")
	private WebElement Primary;

	@FindBy(xpath = "//*[contains(text(),'All Primary Care')]")
	private WebElement Physician;

	@FindBy(xpath = "//div[contains(@class,'first')]//div[@class='hidden-phone']//button")
	private WebElement Savebtn;

	@FindBy(xpath = "//*[contains(text(),'Get Started')]")
	private WebElement GetStarted;

	@FindBy(id = "location")
	private WebElement zipCodeTextfield;

	@FindBy(xpath = "//*[@id='mainContent']//button")
	private WebElement continueButton;

	@FindBy(xpath = "(//*[contains(@class,'searchData')]//*[contains(@data-test-id,'provider-name-link')])[2]")
	private WebElement PrimaryCarePhysician;

	@FindBy(xpath = "//*[contains(@class,'action-btn negative print')]")
	private WebElement PrintEmailBtn;

	@FindBy(xpath = "//span[contains(@ng-switch-when, 'false') and (text()='Save')]")
	private WebElement saveBtn2;

	@FindBy(xpath = "//button[text()='Cancel']//following-sibling::button")
	private WebElement NewsaveBtn2;

	@FindBy(xpath = "(//span[contains(@ng-bind-html, 'item.title') and contains(text(),'Saved')])")
	private WebElement Savedproviders;

	@FindBy(xpath = "//*[contains(text(),'Close')]")
	private WebElement BtnClose;

	@FindBy(xpath = "//*[contains(@class,'provider-name')]")
	private WebElement providerNameText;

	@FindBy(xpath = "//ul[contains(@class,'gs-options')]/li//div[contains(@class,'img')][contains(@src,'next')]")
	private WebElement nextYrTile;

	@FindBy(xpath = "//ul[contains(@class,'gs-options')]/li//div[contains(@class,'img')][contains(@src,'current')]")
	private WebElement currentYrTile;
	
	@FindBy(xpath="//button[text()='Continue Searching']")
	private WebElement continueSearching;
	
	@FindBy(xpath="(//button[contains(text(),'Finish')])[1]")
	private WebElement Finish;

	public ProviderSearchPageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, continueButton, 45);
	}

	public VPPPlanSummaryPageMobile selectsProvider(String physicianSearchCriteria, String physicianName) {

		CommonUtility.waitForPageLoad(driver, physcianSearchTypes, 10);
		ElementData elementData = new ElementData("linkText", physicianSearchCriteria);
		findElement(elementData).click();
		CommonUtility.waitForPageLoad(driver, providerName, 10);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (WebElement element : providerNameList) {
			ElementData providerElementData = new ElementData("className", "providerName");
			if (findChildElement(providerElementData, element).getText().equalsIgnoreCase(physicianName)) {
				ElementData addToListElementData = new ElementData("linkText", "Add to List");
				findChildElement(addToListElementData, element).click();
				break;
			}
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		switchToNewIframe(cboxIframeElement);
		completeMyList.click();

		if (getTitle().equalsIgnoreCase("Our Medicare Plan Types | AARP� Medicare Plans from UnitedHealthcare�")) {
			return new VPPPlanSummaryPageMobile(driver);
		}
		return null;

	}

	public VPPPlanSummaryPageMobile selectsProvider() {
		CommonUtility.waitForPageLoadNew(driver, GetStarted, 45);
		GetStarted.click();

		CommonUtility.waitForPageLoadNew(driver, People, 30);
		People.click();

		CommonUtility.waitForPageLoadNew(driver, Primary, 30);
		Primary.click();

		CommonUtility.waitForPageLoadNew(driver, Physician, 30);

		Physician.click();
		CommonUtility.waitForPageLoadNew(driver, selectProviderBtn, 30);
		jsClickNew(selectProviderBtn);

		if (validate(selectLocationOption,10)) {
			selectLocationOption.click();
			validateNew(saveBtn2);
			saveBtn2.click();
		}
		
		validateNew(providerNameText);
		String providerSaved = providerNameText.getText().trim();
		System.out.println("Hospital Name is : " + providerSaved);
		MRConstants.PROV_NAME=providerSaved;
		
		validateNew(finishReturnBtn, 10);

		finishReturnBtn.click();
		/*
		 * if(validate(EditSavedButton)){ ViewSavedProvidersLink.click(); }
		 */
		
		//Checkcoverage.click();
		/*
		 * validateNew(Checkcoverage); jsClickNew(Checkcoverage);
		 */
		waitForCountDecrement(2);
		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);

		return new VPPPlanSummaryPageMobile(driver);
	}

	public VPPPlanSummaryPageMobile selectsHospitals() {
		CommonUtility.waitForPageLoadNew(driver, GetStarted, 45);
		GetStarted.click();

		CommonUtility.waitForPageLoadNew(driver, Places, 30);
		Places.click();

		CommonUtility.waitForPageLoadNew(driver, Hospitals, 30);
		Hospitals.click();

		CommonUtility.waitForPageLoadNew(driver, selectProviderBtn, 45);

		jsClickNew(selectProviderBtn);
		if (validate(selectLocationOption)) {
			selectLocationOption.click();
			validateNew(saveBtn2);
			saveBtn2.click();
		}
		CommonUtility.waitForPageLoadNew(driver, Viewsavebtn, 30);

		jsClickNew(Viewsavebtn);
		if(validate(EditSavedButton)){
			ViewSavedProvidersLink.click();
		}
		validateNew(providerNameText);
		String providerSaved = providerNameText.getText().trim();
		System.out.println("Hospital Name is : " + providerSaved);
		MRConstants.PROV_NAME = providerSaved;
		Checkcoverage.click();
		/*
		 * validateNew(Checkcoverage); jsClickNew(Checkcoverage);
		 */
		waitForCountDecrement(2);
		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);

		return new VPPPlanSummaryPageMobile(driver);
	}

	public void entersZipcodeAndSelectPlanName(String zipcode, String planName, String year) {

		validateNew(zipCodeTextfield);
		zipCodeTextfield.sendKeys(zipcode);
		validateNew(continueButton);
		continueButton.click();
		if (year.contains("current")) {
			if (validate(currentYrTile)) {
				currentYrTile.click();
			} else {
				System.out.println("Current year tile is not present");
			}
		} else if (year.contains("next")) {
			if (validate(nextYrTile))
				nextYrTile.click();
		}
		WebElement planNameToBeSelected = driver.findElement(By.xpath("//*[contains(text(),\'" + planName + "\')]"));
		validateNew(planNameToBeSelected);
		planNameToBeSelected.click();
		// TODO Auto-generated method stub

	}

	public int entersZipcodeAndPlancount(String zipcode) {

		validateNew(zipCodeTextfield);
		zipCodeTextfield.sendKeys(zipcode);
		validateNew(continueButton);
		continueButton.click();

		List<WebElement> topicDropDownValues = driver.findElements(By.xpath("//li//button[attribute::data-ui-element-name]"));

		return topicDropDownValues.size();
	}

	public void selectsProviderFromGlobaHeader() {

		CommonUtility.waitForPageLoadNew(driver, People, 30);
		People.click();

		CommonUtility.waitForPageLoadNew(driver, Primary, 30);
		Primary.click();

		CommonUtility.waitForPageLoadNew(driver, Physician, 30);
		Physician.click();

		CommonUtility.waitForPageLoadNew(driver, PrimaryCarePhysician, 30);
		PrimaryCarePhysician.click();

		CommonUtility.waitForPageLoadNew(driver, selectProviderBtn, 45);
		selectProviderBtn.click();

		if (validate(selectLocationOption)) {
			selectLocationOption.click();
			validateNew(saveBtn2);
			saveBtn2.click();
		}

		CommonUtility.waitForPageLoadNew(driver, ViewsaveProviderbtn, 30);
		ViewsaveProviderbtn.click();
		if(validate(EditSavedButton)){
			ViewSavedProvidersLink.click();
		}
		validateNew(providerNameText);
		validateNew(PrintEmailBtn);

	}

	/*public PlanDetailsPage selectsProviderFromVppPlanDetailsPage() {
		// TODO Auto-generated method stub

		CommonUtility.waitForPageLoadNew(driver, GetStarted, 45);
		GetStarted.click();

		CommonUtility.waitForPageLoadNew(driver, People, 30);
		People.click();

		CommonUtility.waitForPageLoadNew(driver, Primary, 30);
		Primary.click();

		CommonUtility.waitForPageLoadNew(driver, Physician, 30);

		Physician.click();
		CommonUtility.waitForPageLoadNew(driver, selectProviderBtn, 45);
		jsClickNew(selectProviderBtn);

		if (validate(selectLocationOption)) {
			selectLocationOption.click();
			validateNew(saveBtn2);
			saveBtn2.click();
		}

		validateNew(providerNameText);
		String providerSaved = providerNameText.getText().trim();
		System.out.println("Hospital Name is : " + providerSaved);
		MRConstants.PROV_NAME=providerSaved;
		
		validateNew(finishReturnBtn, 10);

		finishReturnBtn.click();
	
		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);

		return new PlanDetailsPage(driver);

	}
*/

	public VPPPlanSummaryPageMobile MultipleselectsProvider() {
		GetStarted.click();

		CommonUtility.waitForPageLoadNew(driver, People, 30);
		People.click();

		CommonUtility.waitForPageLoadNew(driver, Primary, 30);
		Primary.click();

		CommonUtility.waitForPageLoadNew(driver, Physician, 30);
		jsClickNew(Physician);

		for (WebElement element : MulitpleSaveBtns) {
			CommonUtility.waitForPageLoadNew(driver, element, 45);
			jsClickNew(element);

			if (validate(selectLocationOption)) {
				CommonUtility.waitForPageLoadNew(driver, selectLocationOption, 45);

				selectLocationOption.click();

				validateNew(NewsaveBtn2);

				jsClickNew(NewsaveBtn2);

			}
			/*New Changes
			 */
			CommonUtility.waitForPageLoadNew(driver, continueSearching, 45);
			continueSearching.click();
			
			/*
			CommonUtility.waitForPageLoadNew(driver, BtnClose, 45);
			jsClickNew(BtnClose);*/

			// counter++;
//			if(counter==2)
//			{
//				break;
//			}

		}

		CommonUtility.waitForPageLoadNew(driver, Savedproviders, 30);
		/*Old Changes
		 * 
		 jsClickNew(Savedproviders); 
		 validateNew(providerNameText);
		 validateNew(Checkcoverage); 
		 Checkcoverage.click(); 
		//jsClickNew(Checkcoverage); 
		 waitForCountDecrement(2);
		 driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		 return new VPPPlanSummaryPage(driver);
		*/
		 
		jsClickNew(Savedproviders);
		validateNew(Finish);
		Finish.click();	
		waitForCountDecrement(2);
		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		return new VPPPlanSummaryPageMobile(driver);
		
	}

	public void verifyProviderSearchRallyPageDisplayed() {
		org.testng.Assert.assertTrue(driver.getCurrentUrl().contains("werally"),
				"Provider Search Rally Page is not displayed");
	}
}