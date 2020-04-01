/**
 * 
 */
package pages.acquisition.ulayer;

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
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

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

	@FindBy(xpath="(//button[contains(@class,'saved-provider-button')])[1]")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//a[contains(text(),'View Saved')]")
	private WebElement Viewsavebtn;
	
	@FindBy(xpath="//*[contains(@id,'label_unsaved_selectedLocation0')]")
	private WebElement selectLocationOption;

	@FindBy(xpath="(//button[contains(text(),'Check Provider Coverage')])[1]")
	private WebElement Checkcoverage;
	
	@FindBy(xpath="//*[contains(text(),'People')][contains(@class,'option-title')]")
	private WebElement People;
	
	@FindBy(xpath="//*[contains(text(),'Primary Care')][contains(@class,'option-title')]")
	private WebElement Primary;
	
	
	@FindBy(xpath="//*[contains(text(),'All Primary Care')]")
	private WebElement Physician;

	@FindBy(xpath="//div[contains(@class,'first')]//div[@class='hidden-phone']//button")
	private WebElement Savebtn;
	
	@FindBy(xpath="//*[contains(text(),'Get Started')]")
	private WebElement GetStarted;
	
	@FindBy(id="location")
	private WebElement zipCodeTextfield;
	
	@FindBy(xpath="//*[@id='mainContent']//button")
	private WebElement continueButton;
	
	@FindBy(xpath="(//*[contains(@class,'searchData')]//*[contains(@data-test-id,'provider-name-link')])[2]")
	private WebElement PrimaryCarePhysician;
	
	@FindBy(xpath="//*[contains(@class,'action-btn negative print')]")
	private WebElement PrintEmailBtn;

	@FindBy(xpath="//span[contains(@ng-switch-when, 'false') and contains(text(),'Save')]")
	private WebElement saveBtn2;
	
	@FindBy(xpath="//*[contains(@class,'provider-card')]//*[contains(@class,'provider-name')]")
	private WebElement providerNameText;
	
	@FindBy(xpath="//ul[contains(@class,'gs-options')]/li//div[contains(@class,'img')][contains(@src,'next')]")
	private WebElement nextYrTile;
	
	@FindBy(xpath="//ul[contains(@class,'gs-options')]/li//div[contains(@class,'img')][contains(@src,'current')]")
	private WebElement currentYrTile;
	
	public ProviderSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, continueButton, 45);
	}

	public VPPPlanSummaryPage selectsProvider(String physicianSearchCriteria,
			String physicianName) {
	
		CommonUtility.waitForPageLoad(driver, physcianSearchTypes, 10);
		ElementData elementData = new ElementData("linkText",
				physicianSearchCriteria);
		findElement(elementData).click();
		CommonUtility.waitForPageLoad(driver, providerName, 10);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (WebElement element : providerNameList) {
			ElementData providerElementData = new ElementData("className",
					"providerName");
			if (findChildElement(providerElementData, element).getText()
					.equalsIgnoreCase(physicianName)) {
				ElementData addToListElementData = new ElementData("linkText",
						"Add to List");
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

		if (getTitle()
				.equalsIgnoreCase(
						"Our Medicare Plan Types | AARP® Medicare Plans from UnitedHealthcare®")) {
			return new VPPPlanSummaryPage(driver);
		}
		return null;

	}

	public VPPPlanSummaryPage selectsProvider() {
		CommonUtility.waitForPageLoadNew(driver, GetStarted, 45);
	GetStarted.click();

	CommonUtility.waitForPageLoadNew(driver, People, 30);
	People.click();

	CommonUtility.waitForPageLoadNew(driver, Primary, 30);
	Primary.click();

	CommonUtility.waitForPageLoadNew(driver, Physician, 30);

	Physician.click();
	CommonUtility.waitForPageLoadNew(driver, SaveBtn, 45);
	jsClickNew(SaveBtn);
	

	if(validate(selectLocationOption)){
		selectLocationOption.click();
		validateNew(saveBtn2);
		saveBtn2.click();
	}
	CommonUtility.waitForPageLoadNew(driver, Viewsavebtn, 30);

	jsClickNew(Viewsavebtn);
	validateNew(providerNameText);
	Checkcoverage.click();
	/*validateNew(Checkcoverage);
	jsClickNew(Checkcoverage);*/
	waitForCountDecrement(2);
	driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);

	return new VPPPlanSummaryPage(driver);
	}
	
	public void entersZipcodeAndSelectPlanName(String zipcode,String planName, String year) {

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
		WebElement planNameToBeSelected = driver.findElement(By.xpath("//*[contains(text(),\'" + planName+ "\')]"));
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
		
	
		if(validate(selectLocationOption)){
			selectLocationOption.click();
			validateNew(saveBtn2);
			saveBtn2.click();
		}
		
		CommonUtility.waitForPageLoadNew(driver, Viewsavebtn, 30);
		Viewsavebtn.click();
		validateNew(providerNameText);
		validateNew(PrintEmailBtn);
		
		
		}
	
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

	}
	public VPPTestHarnessPage selectsProviderNavigateBacktoTestharness() {
		GetStarted.click();

		CommonUtility.waitForPageLoadNew(driver, People, 30);
		People.click();

		CommonUtility.waitForPageLoadNew(driver, Primary, 30);
		Primary.click();

		CommonUtility.waitForPageLoadNew(driver, Physician, 30);

		jsClickNew(Physician);
		CommonUtility.waitForPageLoadNew(driver, SaveBtn, 45);
		jsClickNew(SaveBtn);

		if (validate(selectLocationOption)) {
			selectLocationOption.click();
			validateNew(saveBtn2);
			saveBtn2.click();
		}

		CommonUtility.waitForPageLoadNew(driver, Viewsavebtn, 30);

		jsClickNew(Viewsavebtn);
		validateNew(providerNameText);
		validateNew(Checkcoverage);
		Checkcoverage.click();
		waitForCountDecrement(2);
		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);

		return new VPPTestHarnessPage(driver);
	}
}
