/**
 * 
 */
package pages.acquisition.commonpages;

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
import pages.acquisition.commonpages.VPPPlanSummaryPage;
import pages.acquisition.commonpages.PlanDetailsPage;

/**
 * @author pperugu
 *
 */
public class ProviderSearchPage extends UhcDriver {

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

	@FindBy(xpath = "(//button[contains(@class,'saved-provider-button')])[1]")
	private WebElement SaveBtn;

	//@FindBy(xpath = "//a[contains(text(),'View Saved')]")
	@FindBy(xpath = "//button[@data-test-id='button-close']")
	private WebElement Viewsavebtn;

	@FindBy(xpath = "//*[contains(@id,'label_unsaved_selectedLocation0')]")
	private WebElement selectLocationOption;

	//@FindBy(xpath = "(//*[contains(text(),'Check Provider Coverage')])[2]")
	@FindBy(xpath = "(//button[contains(text(),'Check Provider Coverage')])[1]")
	private WebElement Checkcoverage;

	@FindBy(xpath = "//*[contains(text(),'People')][contains(@class,'option-title')]")
	private WebElement People;

	@FindBy(xpath = "//*[contains(text(),'Primary Care')][contains(@class,'option-title')]")
	private WebElement Primary;

	// @FindBy(xpath="//button[contains(text(),'Primary Care Physician')]")
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

	@FindBy(xpath = "//span[contains(@ng-switch-when, 'false') and contains(text(),'Save')]")
	private WebElement saveBtn2;

	// @FindBy(xpath =
	// "//*[contains(@class,'provider-card')]//*[contains(@class,'provider-name')]")
	@FindBy(xpath = "//*[contains(@class,'provider-name')]")
	private WebElement providerNameText;

	@FindBy(xpath = "//ul[contains(@class,'gs-options')]/li//div[contains(@class,'img')][contains(@src,'next')]")
	private WebElement nextYrTile;

	@FindBy(xpath = "//ul[contains(@class,'gs-options')]/li//div[contains(@class,'img')][contains(@src,'current')]")
	private WebElement currentYrTile;

	@FindBy(xpath = "(//*[@data-test-id='saved-provider-button'])[1]")
	private WebElement selectProviderBtn;

	@FindBy(xpath = "(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[2]")
	private WebElement FinishButton;
	
	@FindBy(xpath = "//*[contains(text(),'Places')][contains(@class,'option-title')]")
	private WebElement Places;
	
	@FindBy(xpath = "//*[contains(text(),'Hospitals')][contains(@class,'option-title')]")
	private WebElement Hospitals;
	
	@FindBy(xpath = "//*[@data-test-id='button-view-saved-provider']")
	private WebElement ViewsaveOldbtn;
	
	@FindBy(xpath="//span[contains(text(),'Saved')]")
	private WebElement ViewSavedProvidersLink;

	public ProviderSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, continueButton, 45);
	}

	public VPPPlanSummaryPage selectsProvider(String physicianSearchCriteria, String physicianName) {

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

		if (getTitle().equalsIgnoreCase("Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;

	}

	/*
	 * public VPPPlanSummaryPage selectsProvider() {
	 * CommonUtility.waitForPageLoadNew(driver, GetStarted, 45); GetStarted.click();
	 * 
	 * CommonUtility.waitForPageLoadNew(driver, People, 30); People.click();
	 * 
	 * CommonUtility.waitForPageLoadNew(driver, Primary, 30); Primary.click();
	 * 
	 * CommonUtility.waitForPageLoadNew(driver, Physician, 30);
	 * 
	 * Physician.click(); CommonUtility.waitForPageLoadNew(driver, SaveBtn, 45);
	 * jsClickNew(SaveBtn);
	 * 
	 * if (validate(selectLocationOption)) { selectLocationOption.click();
	 * validateNew(saveBtn2); saveBtn2.click(); }
	 * CommonUtility.waitForPageLoadNew(driver, Viewsavebtn, 30);
	 * 
	 * jsClickNew(Viewsavebtn); validateNew(providerNameText);
	 * validateNew(Checkcoverage); jsClickNew(Checkcoverage);
	 * waitForCountDecrement(2);
	 * driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
	 * 
	 * return new VPPPlanSummaryPage(driver); }
	 */

	public VPPPlanSummaryPage selectsProvider() {
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

		if (validate(selectLocationOption, 10)) {
			selectLocationOption.click();
			validateNew(saveBtn2);
			saveBtn2.click();
		}
	threadsleep(10);

		validateNew(providerNameText);
	String providerSaved = providerNameText.getText().trim();
	System.out.println("Provider Name is : " + providerSaved);
	MRConstants.PROV_NAME=providerSaved;
		/*
		 * validateNew(Checkcoverage); jsClickNew(Checkcoverage);
		 */
	if(driver.findElements(By.xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() > 0){
		System.out.println("OLD Rally page displayed");
		Checkcoverage.click();
	}	
	else if(driver.findElements(By.xpath("(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[1]")).size() > 0){
		System.out.println("NEW Rally page displayed");
		FinishButton.click();
	}else
		System.out.println("Issue with Xpath");
	
	threadsleep(3);
			
		waitForCountDecrement(2);
		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);

		return new VPPPlanSummaryPage(driver);
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

	public void selectsProviderFromGlobaHeader() {

		CommonUtility.waitForPageLoadNew(driver, People, 30);
		People.click();

		CommonUtility.waitForPageLoadNew(driver, Primary, 30);
		Primary.click();

		CommonUtility.waitForPageLoadNew(driver, Physician, 30);
		Physician.click();

		CommonUtility.waitForPageLoadNew(driver, PrimaryCarePhysician, 30);
		PrimaryCarePhysician.click();

		CommonUtility.waitForPageLoadNew(driver, SaveBtn, 45);
		SaveBtn.click();

		if (validate(selectLocationOption)) {
			selectLocationOption.click();
			validateNew(saveBtn2);
			saveBtn2.click();
		}

		CommonUtility.waitForPageLoadNew(driver, Viewsavebtn, 30);
		Viewsavebtn.click();
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
		CommonUtility.waitForPageLoadNew(driver, SaveBtn, 45);
		SaveBtn.click();

		if (validate(selectLocationOption)) {
			selectLocationOption.click();
			validateNew(saveBtn2);
			saveBtn2.click();
		}

		CommonUtility.waitForPageLoadNew(driver, Viewsavebtn, 30);

		jsClickNew(Viewsavebtn);

		validateNew(Checkcoverage);

		Checkcoverage.click();
		waitForCountDecrement(2);
		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);

		return new PlanDetailsPage(driver);

	}*/
	public PlanDetailsPage selectsProviderFromVppPlanDetailsPage() {
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
		
		/*
		 * if(driver.findElements(By.xpath(
		 * "//*[@data-test-id='button-view-saved-provider']")).size() > 0)
		 * ViewsaveOldbtn.click(); else
		 * if(driver.findElements(By.xpath("//button[@data-test-id='button-close']")).
		 * size() > 0){ Viewsavebtn.click();
		 * if(driver.findElements(By.xpath("//span[text()='Update This Provider']")).
		 * size() > 0){ ViewSavedProvidersLink.click(); } else
		 * System.out.println("New Rally page not displayed");
		 * 
		 * }
		 */
		if(driver.findElements(By.xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() > 0){
			System.out.println("OLD Rally page displayed");
			Checkcoverage.click();
		}	
		else if(driver.findElements(By.xpath("(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[1]")).size() > 0){
			System.out.println("NEW Rally page displayed");
			FinishButton.click();
		}else
			System.out.println("Issue with Xpath");
		
		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);

		return new PlanDetailsPage(driver);

	}

	public VPPPlanSummaryPage selectsHospitals() {
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
		validateNew(providerNameText);
		String providerSaved = providerNameText.getText().trim();
		System.out.println("Hospital Name is : " + providerSaved);
		MRConstants.PROV_NAME=providerSaved;
		
		if(driver.findElements(By.xpath("//*[@data-test-id='button-view-saved-provider']")).size() > 0)
			ViewsaveOldbtn.click();
		else if(driver.findElements(By.xpath("//button[@data-test-id='button-close']")).size() > 0){
			Viewsavebtn.click();
		if(driver.findElements(By.xpath("//span[text()='Update This Provider']")).size() > 0){
			ViewSavedProvidersLink.click();
		}
		else
			System.out.println("New Rally page not displayed");
		 
		}
		if(driver.findElements(By.xpath("(//button[contains(text(),'Check Provider Coverage')])[1]")).size() > 0){
			System.out.println("OLD Rally page displayed");
			Checkcoverage.click();
		}	
		else if(driver.findElements(By.xpath("(//form[@data-ui-element-name='check-provider-coverage']//button[contains(@class,'action-btn')])[1]")).size() > 0){
			System.out.println("NEW Rally page displayed");
			FinishButton.click();
		}else
			System.out.println("Issue with Xpath");
		waitForCountDecrement(2);
		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);

		return new VPPPlanSummaryPage(driver);
	}

}
