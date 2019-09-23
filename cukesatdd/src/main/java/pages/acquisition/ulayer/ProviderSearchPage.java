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

	@FindBy(xpath="(//div[contains(@class,'searchData')]//button[contains(@class,'saved-provider-button')])[1]")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//a[contains(text(),'View Saved')]")
	private WebElement Viewsavebtn;

	@FindBy(xpath="(//*[contains(text(),'Check Provider Coverage')])[2]")
	private WebElement Checkcoverage;
	
	@FindBy(xpath="//*[contains(text(),'People')][contains(@class,'option-title')]")
	private WebElement People;
	
	@FindBy(xpath="//*[contains(text(),'Primary Care')][contains(@class,'option-title')]")
	private WebElement Primary;
	
	
	@FindBy(xpath="//button[contains(text(),'Primary Care Physician')]")
	private WebElement Physician;

	@FindBy(xpath="//div[contains(@class,'first')]//div[@class='hidden-phone']//button")
	private WebElement Savebtn;
	
	@FindBy(xpath="//*[contains(text(),'Get Started')]")
	private WebElement GetStarted;
	
	@FindBy(id="location")
	private WebElement zipCodeTextfield;
	
	@FindBy(xpath="//*[@id='mainContent']//button")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[contains(@class,'searchData')]/h2/div/a[1]")
	private WebElement PrimaryCarePhysician;
	
	@FindBy(xpath="//span[contains(text(),'Print / Email Providers')]")
	private WebElement PrintEmailBtn;

	@FindBy(className="saved-provider-button")
	private WebElement SaveBtn2;
	
	@FindBy(xpath="//li[contains(@class,'provider-card')]//*[contains(@class,'provider-name')]/a[text()]")
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
	CommonUtility.waitForPageLoadNew(driver, Viewsavebtn, 30);

	jsClickNew(Viewsavebtn);
	validateNew(providerNameText);
	validateNew(Checkcoverage);
	jsClickNew(Checkcoverage);
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
			validateNew(nextYrTile);
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
		
		CommonUtility.waitForPageLoadNew(driver, SaveBtn2, 45);
		SaveBtn2.click();
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
			CommonUtility.waitForPageLoadNew(driver, Viewsavebtn, 30);

			jsClickNew(Viewsavebtn);

			validateNew(Checkcoverage);
			
			Checkcoverage.click();
			waitForCountDecrement(2);
			driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);

			return new PlanDetailsPage(driver);
		
	}
}
