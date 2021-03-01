package pages.acquisition.uhcretiree;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author ckoppura
 *
 */

public class RetireeAcquisitionHomePage extends UhcDriver {

	@Override
	public void openAndValidate() {
		if (MRScenario.environment.equalsIgnoreCase("Stage") || MRScenario.environment.equalsIgnoreCase("offline") ||MRScenario.environment.equalsIgnoreCase("offline-stage")) {
			start(UHCRETIREE_ACQISITION_PAGE_URL);
		} else {
			start(TEAM_UHCRETIREE_ACQISITION_PAGE_URL);

		}
		impliciWait(druglookuplink, 20);

		validate(druglookuplink);
	}

	@FindBy(linkText = "Pharmacy information")

	private WebElement pharmacyLocator;

	@FindBy(linkText = "Look up prescription drugs")
	private WebElement druglookuplink;

	@FindBy(id = "new_form_GroupSelector")
	private WebElement dropDownMenu;

	@FindBy(xpath = ".//*[@id='main']/div/div[1]/div/div[4]/div[1]/div/div[1]/div[2]/div/div/div/p[2]/a")
	private WebElement lookupproviderLink;

	@FindBy(id = "new_form_GroupSelector")
	private WebElement alcatelLucentSelect;

	@FindBy(xpath = "//*[@id='main']/div/div[1]/div/div[8]/div/div/div/div[1]/ul/li[6]/a")
	private WebElement sitemaplink;

	public JSONObject browserCheckJson;
	private PageData browserCheckData;

	@FindBy(xpath = ".//*[@id='main']//h1")
	private WebElement searchForaDrugHeader;

	@FindBy(xpath = "//a[contains (text(),'Look up a provider now')]")
	private WebElement providerSearchFromHomeScreen;

	private static String UHCRETIREE_ACQISITION_PAGE_URL = MRConstants.UHCRETIREE_URL;
	
	private static String TEAM_UHCRETIREE_ACQISITION_PAGE_URL = MRConstants.TEAM_UHCRETIREE_URL;

	public RetireeAcquisitionHomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	/**
	 * Navigate to pharmacy Locator Page
	 * 
	 * @return
	 */
	public UhcRetireePharmacyLocatorPage navigateToPharmacyLocator() {
		pharmacyLocator.click();
		return new UhcRetireePharmacyLocatorPage(driver);
	}

	public SelectFormularyPage prescriptionsDrugLink() {

		try {
			Thread.sleep(7000);
			validate(druglookuplink);
			druglookuplink.click();
			if (getTitle().equalsIgnoreCase("UnitedHealthcare Group Retiree – Search for a Drug")) {
				return new SelectFormularyPage(driver);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		return null;
	}

	public RetireesOfSelectedPlans openDropDown(String groupName) {
		validate(dropDownMenu);
		Select dropdown = new Select(driver.findElement(By.id("new_form_GroupSelector")));
		dropdown.selectByVisibleText(groupName);
		System.out.println(getTitle());
		return new RetireesOfSelectedPlans(driver);
	}

	public Rallytool_Page lookupproviderclick() {
		validate(lookupproviderLink);
		lookupproviderLink.click();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase("Enter Zip")) {
			return new Rallytool_Page(driver);
		}
		return null;

	}

	public JSONObject getBrowserCheck() {
		String fileName = CommonConstants.GR_BROWSER_CHECK_DATA;
		browserCheckData = CommonUtility.readPageData(fileName, CommonConstants.RETIREE_PAGE_OBJECT_DIRECTORY);
		JSONObject jsonObject = new JSONObject();
		for (String key : browserCheckData.getExpectedData().keySet()) {
			WebElement element = findElement(browserCheckData.getExpectedData().get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		browserCheckJson = jsonObject;

		return browserCheckJson;
	}

	public AlcatelLucentHomePage selectAlcatelLucent_dropdown() {
		validate(alcatelLucentSelect);
		Select dropdown = new Select(alcatelLucentSelect);
		dropdown.selectByIndex(1);
		if (getTitle().equalsIgnoreCase("Alcatel-Lucent Group Retiree - Home")) {
			return new AlcatelLucentHomePage(driver);
		}

		return null;
	}

	public UHCRetireeSiteMapPage clicksitemap() {

		validate(sitemaplink);
		sitemaplink.click();
		if (getTitle().equalsIgnoreCase("UnitedHealthcare Group Retiree – Site Map")) {
			return new UHCRetireeSiteMapPage(driver);
		}
		return null;
	}

	public GroupHomePage selectGroupFromList(String groupName) {

		ElementData groupTypeElement = new ElementData("select:className", "form_field");
		List<WebElement> pharmacyTypeOptions = findElements(groupTypeElement);

		for (WebElement pharmacyTypeOption : pharmacyTypeOptions) {
			if (pharmacyTypeOption.getText().equalsIgnoreCase(groupName)) {
				pharmacyTypeOption.click();
				break;
			}
		}

		String url = "/home.html";
		if (currentUrl().contains(url)) {
			return new GroupHomePage(driver);
		} else {
			return null;
		}
	}

	public void validateGroupDropdownList() {
		Assert.assertTrue("Group dropdown is not displayed", dropDownMenu.isDisplayed());
	}

	public void impliciWait(WebElement element, int timeUnit) {
		driver.manage().timeouts().implicitlyWait(timeUnit, TimeUnit.SECONDS);
		waitforElement(element);
	}

	public DrugLookUpPage navigateToDrugLookUp() {
		druglookuplink.click();
		impliciWait(searchForaDrugHeader, 10);
		// waitforElement(searchForaDrugHeader);
		Assert.assertTrue("Header Displayed", searchForaDrugHeader.isDisplayed());
		return new DrugLookUpPage(driver);
	}

	public ProviderSearchPageUhcRetiree navigateToProviderSearchTool() {
		validateNew(providerSearchFromHomeScreen);
		switchToNewTabNew(providerSearchFromHomeScreen);
		if (!MRScenario.environment.equalsIgnoreCase("stage")) { //need this sleep for lower env
			try { //need this sleep for 
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		CommonUtility.checkPageIsReady(driver);
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getCurrentUrl().contains("werally")) {
			return new ProviderSearchPageUhcRetiree(driver);

		}
		return null;
	}
	
	@Override
	public void waitforElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5L);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
}
