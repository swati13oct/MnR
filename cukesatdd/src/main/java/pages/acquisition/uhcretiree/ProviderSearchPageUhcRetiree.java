package pages.acquisition.uhcretiree;
import java.util.Calendar;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
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
 * @author akapoo18
 *
 */
public class ProviderSearchPageUhcRetiree extends UhcDriver{


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

	@FindBy(xpath="(//div[contains(@class,'searchData')]//button[contains(@class,'saved-provider-button')]/span)[1]")
	private WebElement SaveBtn;
	
	@FindBy(xpath="//*[contains(text(),'View Saved')]")
	private WebElement Viewsavebtn;

	@FindBy(xpath="//div[contains(@class,'exportSavedProviders')]//button[contains(@class,'action-btn')]")
	private WebElement Checkcoverage;
	
	@FindBy(xpath="//*[contains(text(),'People')][contains(@class,'option-title')]")
	private WebElement People;
	
	@FindBy(xpath="//*[contains(text(),'Primary Care')][contains(@class,'option-title')]")
	private WebElement Primary;
	
	
	@FindBy(xpath="//button[contains(text(),'Primary Care Physician')]")
	private WebElement Physician;

	
	@FindBy(xpath="//div[contains(@class,'first')]//div[@class='hidden-phone']//button")
	private WebElement Savebtn;
	
	@FindBy(xpath="//button[contains(text(),'Get Started')]")
	private WebElement GetStarted;

	@FindBy(id="location")
	private WebElement zipCodeTextfield;
	
	@FindBy(xpath="//*[@id='mainContent']//button")
	private WebElement continueButton;
	
	@FindBy(xpath="(//*[contains(@class,'searchData')]//*[contains(@data-test-id,'provider-name-link')])[1]")
	private WebElement PrimaryCarePhysician;
	
	@FindBy(xpath="//span[contains(text(),'Print / Email Providers')]")
	private WebElement PrintEmailBtn;

	@FindBy(className="saved-provider-button")
	private WebElement SaveBtn2;
	
	public ProviderSearchPageUhcRetiree(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
		// TODO Auto-generated constructor stub
	}



	@Override
	public void openAndValidate() {
		//CommonUtility.waitForPageLoadNew(driver, GetStarted, 45);
	}

	@FindBy(xpath="//a[contains(@ng-click,'ChoosePlanYearCtrl')]")
	private List<WebElement> planYearSelections;

	public void entersZipcodeAndSelectsPlanName(String zipcode,String planName) {

		validateNew(zipCodeTextfield);	
		zipCodeTextfield.sendKeys(zipcode);
		validateNew(continueButton);
		continueButton.click();
		//note if year button shows up, select current year
		if (planYearSelections.size()>0) {
			try {
				int year = Calendar.getInstance().get(Calendar.YEAR);
				WebElement yearBtn=driver.findElement(By.xpath("//a[contains(@ng-click,'ChoosePlanYearCtrl')]//*[text()='"+year+"']"));
				yearBtn.click();
			} catch (Exception e) {
				Assert.assertTrue("PROBLEM - Page is showing year selection but unable to locate current year button", false);
			}
		}
		WebElement planNameToBeSelected = driver.findElement(By.xpath("//*[contains(text(),\'" + planName+ "\')]"));
		planNameToBeSelected.click();
	}
	
	public void selectProviderFromHomePage() {
		

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
		validateNew(PrintEmailBtn);
		
		
		}

}
