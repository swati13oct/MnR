package pages.memberrdesignVBF;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class FormsAndResourcesPage extends UhcDriver {
	@FindBy(xpath = "//li[@class='clearfix MAPD_govt_false_57425290']/a[contains(text(),'Benefit Highlights')]")
	private WebElement pdf;

	@FindBy(linkText = "VIEW DOCUMENTS & RESOURCES")
	private WebElement DOCUMENTSRESOURCES;

	/** The member signin link. */
	@FindBy(id = "fd_memberSignInButton")
	private WebElement memberSignInButton;

	/** userId */
	@FindBy(id = "loginPOPUPuser")
	private WebElement loginuserId;

	/** Password */
	@FindBy(id = "loginPOPUPpass")
	private WebElement loginpassword;

	/** Sign in button in login pop screen */
	@FindBy(className = "memSignPopup")
	private WebElement memberSignInPopup;

	/** Link to Form And resources page in Test Harness Page */
	@FindBy(linkText = "Go to Forms And Resources page")
	private WebElement linkToFormsAndResources;

	/** Link for perception popup **/
	@FindBy(xpath = "html/body/div[3]/div[2]/map/area[1]")
	private WebElement perceptionpopup;

	/** Medical button in EOB section - Forms And Resources page */
	@FindBy(xpath = "//*[@class='customsegments parbase section']//div[@class='otherPages']//div[@class='explanationbenefits parbase section']//section[@class='block-body']/a[text()='SEARCH MEDICAL EOB HISTORY']")
	private WebElement eobMedicalButton;

	/** Drug button in EOB section */
	@FindBy(xpath = "//div[@class='customsegments parbase section']//div[@class='otherPages']//div[@class='explanationbenefits parbase section']//*[@class='col-md-4 block border-left']//a[text()='SEARCH DRUG EOB HISTORY']")
	private WebElement eobDrugButton;

	/** Renew Magazine Section - Forms And Resources page */
	@FindBy(xpath = "//*[@class='customsegments parbase section']//div[@class='otherPages']//*[@href='/wellness/health/health-wellness-programs-pastissues-renew?type=lifestyle']")
	private WebElement renewMagazineSection;

	/** My DocumentSection - Forms And Resources page */
	@FindBy(id = "myDocHeader")
	private WebElement myDocumentSection;

	/** Plan Material Section **/

	@FindBy(id = "plan_material_fnr2018")
	private WebElement PlanMaterialSection;

	/* for active uhc member */
	@FindBy(xpath = "(//div[contains(@class,'planBenefitsHeaderParsys')]//div[@class='otherPages']//a[contains(text(),'VIEW MEMBER')])[1]")
	private WebElement MemberIdCardlink;
	// *[contains(text(),'VIEW MEMBER ID CARD')]

	/* for terminated */
	@FindBy(xpath = "(//a[contains(text(),'VIEW MEMBER ID CARD')])[1]")
	private WebElement MemberIdCardlinkterminated;

	@FindBy(xpath = "(//div[contains(@class,'planBenefitsHeaderParsys')]//div[@class='otherPages']//a[contains(text(),'ORDER PLAN MATERIALS')])[1]")
	private WebElement OrderPlanMaterialLink;

	@FindBy(xpath = "//*[@id='lang-select-2source-content-configurations_plan-material_jcr-content_overview_formsandresourcescon_formsAndResourcesParsys_customsegments2018_segmentContainer_planbenefitdocuments']")
	private WebElement languagedropdown;

	/** Anoc Section **/
	@FindBy(id = "anoc_headerfnr")
	private WebElement AnocSection;

	/** Annual Directories Section **/
	@FindBy(id = "FnR_annualDirectory")
	private WebElement AnnualDirectorySection;

	/* Provider Search Link */
	@FindBy(xpath = "//div[@class='customsegments parbase section']//div[@class='otherPages']//div[contains(@ng-show ,'mapdIndividual')]//a[contains(text(),'Provider Search')]")
	private WebElement ProviderSearchLink;

	/* Pharmacy Locator Link */
	@FindBy(xpath = "//div[@class='customsegments parbase section']//div[@class='otherPages']//div[contains(@ng-show ,'mapdIndividual')]//a[contains(text(),'Pharmacy Locator')]")
	private WebElement PharmacyLocatorLink;

	/** Forms and Resources section **/
	@FindBy(xpath = "//h2[@id='formsAndResHeader']")
	private WebElement FormsnResources;
	
	/** Forms and Resources links **/
	@FindBy(xpath = "//div[@class='formsAndResourceHeaderDocListingParsys parsys']/div[@class='customsegments parbase section']/div[not(contains(@class,'ng-hide'))]/div[@class='customsegments parbase']//div[@class='formsAndResources base_tools_component section']/div/a")
	private WebElement FormsnResourcesLinks;
	
	/** Forms and Resources links' pdf **/
	@FindBy(xpath = "//div[@class='formsAndResourceHeaderDocListingParsys parsys']/div[@class='customsegments parbase section']/div[not(contains(@class,'ng-hide'))]/div[@class='customsegments parbase']//div[@class='formsAndResources base_tools_component section']/div/div[starts-with(@id,'collapse-source-content-configurations') and contains(@aria-expanded,'true')]")
	private WebElement FormsnResourcesLinkPdf;
	
	
	@FindBy(xpath = "//div[contains(@class,'plan-material')]//span//li/a")
	private List<WebElement> actualPlanMaterialsPdfs;

	@FindBy(xpath = "//a[contains(text(),'Search Documents')]")
	private WebElement searchDocuments;
	
	@FindBy(xpath = "//div[@class='customsegments parbase section']//div[@class='otherPages']//div[@class='explanationbenefits parbase section']//h1[contains(text(),'Explanation')]")
	private WebElement eobSectionHeader;
	

	// *[@class='formsAndResourcesDocListContainer base_tools_component
	// section']
	private WebElement FormsandResourcesSection;

	@FindBy(id = "pageHeader")
	private WebElement pageHeader;

	public FormsAndResourcesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReadyNew(driver);

		RallyDashboardPage.checkModelPopup(driver);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(pageHeader);
	}

	public void clickMemberSignIn() {
		memberSignInButton.click();

	}

	public void enterUserid(String userId) {
		sendkeys(loginuserId, userId);

	}

	public void enterPassword(String password) {
		sendkeys(loginpassword, password);

	}

	public void clickMemberSignInButton() {
		memberSignInPopup.click();

	}

	public void openTestHarnessPage() {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(0));
		driver.get(MRConstants.BLUE_LAYER_TEST_HARNESS_LINK);
	}

	public void clickonFormsAndResourcesLinkOnTestHarness() {
		validateNew(linkToFormsAndResources);
		linkToFormsAndResources.click();

	}

	/**
	 * @toDo : EOB medical button
	 */
	public WebElement getEOBMedicaButton() {
		validateNew(eobMedicalButton);
		return eobMedicalButton;
	}

	/**
	 * @toDo : EOB drug button
	 */
	public WebElement getEOBDrugButton() {
		validateNew(eobDrugButton);
		return eobDrugButton;
	}

	/**
	 * @toDo : renew magazine section
	 */
	public WebElement getRenewMagazineSection() {
		validateNew(renewMagazineSection);
		return renewMagazineSection;
	}

	/**
	 * @toDo : my document section
	 */
	public WebElement getMyDocumentSection() {
		validateNew(myDocumentSection);
		return myDocumentSection;
	}

	/**
	 * @toDo : my document section
	 */
	public WebElement getSearchDocument() {
		validateNew(searchDocuments);
		return searchDocuments;
	}
	
	/**
	 * @toDo : anoc section
	 */
	public WebElement getANOCSection() {
		validateNew(AnocSection);
		return AnocSection;
	}

	/**
	 * @toDo : forms and resources section
	 */
	public WebElement getFormsandResourcesSection() {
		validateNew(FormsnResources);
		return FormsnResources;
	}

	/**
	 * @toDo : annual directory section
	 */
	public WebElement getAnnualDirectorySection() {
		validateNew(AnnualDirectorySection);
		return AnnualDirectorySection;
	}

	/**
	 * @toDo : provider search link
	 */
	public WebElement getprovisesearchlink() {
		validateNew(ProviderSearchLink);
		return ProviderSearchLink;
	}

	/**
	 * @toDo : pharmacy search link
	 */
	public WebElement getpharmacysearchlink() {
		validateNew(PharmacyLocatorLink);
		return PharmacyLocatorLink;
	}

	/**
	 * @toDo : clicking on perception
	 */
	public void clickonperceptionpopup() {
		perceptionpopup.click();
		perceptionpopup.click();

	}

	/**
	 * @toDo : plan materials section
	 */
	public WebElement getplanmaterialsection() {
		return PlanMaterialSection;
	}

	/**
	 * @toDo : order plan material link
	 */
	public WebElement getOrderPlanMaterialLink() {
		validateNew(OrderPlanMaterialLink);
		return OrderPlanMaterialLink;
	}

	/**
	 * @toDo : to click order plan material link
	 */
	public void validateOrderPlanMaterial() throws InterruptedException {

		OrderPlanMaterialLink.click();
		Thread.sleep(5000);
		if (driver.getCurrentUrl().contains("order plan materials")) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed to loaf order materials page");
		}

		driver.navigate().back();
		Thread.sleep(20000);
		if (driver.getCurrentUrl().contains("documents overview")) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed to loaf fnr page");
		}

	}

	/**
	 * @toDo : temporary id card link
	 */
	public WebElement getTemporaryIdcardlink() {
		validateNew(MemberIdCardlink);
		return MemberIdCardlink;
	}

	/**
	 * @toDo : to click temporary id card link
	 */
	public void validateIDCard() throws InterruptedException {
		String IDCardAttribute = getTemporaryIdcardlink().getAttribute("href");
if("YES".equalsIgnoreCase(MRScenario.isTestHarness)){

			
			if (IDCardAttribute.contains("test-harness")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Some wrong link is coming for member id cards");
			}

		} else if ("NO".equalsIgnoreCase(MRScenario.isTestHarness)){
			if (IDCardAttribute.contains("int.uhc.com")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("The member id cards link is wrong");
			}

		}
	}

	/**
	 * @toDo : to verify english as a default language
	 */
	public void validateEngDefault() {
		validateNew(languagedropdown);
		Select oselect = new Select(languagedropdown);
		System.out.println("Default selected language: " + oselect.getFirstSelectedOption().getText());
		Assert.assertTrue("Default selected language is ENGLISH",
				(oselect.getFirstSelectedOption().getText().equals("ENGLISH")));
	}

	/**
	 * @toDo : switch language
	 */
	public void changelanguage() throws InterruptedException {
		CommonUtility.waitForPageLoadNew(driver, pdf, 20);
		Select oselect = new Select(languagedropdown);
		System.out.println(oselect.getOptions());
		if (oselect.getOptions().contains("SPANISH")) {
			Thread.sleep(3000);
			languagedropdown.click();
			oselect.selectByVisibleText("SPANISH");
			Thread.sleep(3000);
			System.out.println(oselect.getFirstSelectedOption().getText());
		} else {
			System.out.println("only english doc are there");
		}

	}

	public void scroll() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,150)", "");

	}

	public void checkOrderPlanMaterialLinkforterminated() {
		Assert.assertTrue(!(validate(driver.findElement(By.xpath(
				"(//div[contains(@class,'planBenefitsHeaderParsys')]/div/div[not(contains(@class,'ng-hide')]//*[contains(text(),'ORDER')])[1])")))));

	}

	public void checkRenewsectionforterminated() {
		Assert.assertTrue(!(validate(driver.findElement(By.xpath("//*[contains(text(),'Renew Magazine')]")))));
	}

	public void validateshipeob() {
		WebElement shipeob = driver.findElement(By.xpath("(//*[contains(text(),'Medical EOB')])[7]"));
		validate(shipeob);
	}

	public boolean verifypdfname(String expectedPDFArray[]) {
		/*java.util.List<WebElement> pdfs = driver
				.findElements(By.xpath("//div[contains(@class,'plan-material')]//span//li/a"));*/
		int actualPdfSize = actualPlanMaterialsPdfs.size();
		int expectedPdfSize = expectedPDFArray.length;
		System.out.println("Number of PDFs --"+actualPdfSize);
/*		for (int i = 0; i < actualPdfSize; i++) {
			String pdfnames = null;
			pdfnames = (actualPlanMaterialsPdfs.get(i).getText());
			System.out.println(pdfnames);
		}
*/
		boolean checkflag = true;		
		if(expectedPdfSize==actualPdfSize){
			
		for (int i = 0; i < expectedPdfSize; i++) {
			if (!(actualPlanMaterialsPdfs.get(i).getText().trim().contains(expectedPDFArray[i].trim()))) {
				checkflag = false;
				break;
			}

		}
		}
		else{
			Assert.fail("Expected "+expectedPdfSize+" and actual "+actualPdfSize+" pdf's count doesn't match");
		}
		return checkflag;
	}

	public void waitforFNRpage() {
		WebDriverWait wait = new WebDriverWait(this.driver, 60);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				if (driver.getTitle().contains("Documents Overview"))
					return true;
				else
					return false;
			}
		});

	}

	/**
	 * @return the Order Plan Material Link
	 */
	public boolean checkPOrderPlanMaterialLinkNotAvailable() {
		try {
			if (driver.findElement(By.xpath("(*//[contains(text(),'ORDER')])[1])")).isDisplayed()) {
				System.out.println("Order Plan Material Link link is present");
				return false;
			} else {

			}
		} catch (Exception e) {
			System.out.println("Order Plan Material Link link is not present");
			return true;
		}
		return false;
	}

	public WebElement geteobmapdsection() {
validateNew(eobSectionHeader);
return eobSectionHeader;
		/*return driver.findElement(By.xpath(
				"//*[@class='customsegments parbase section']//div[@class='otherPages']//*[@class='explanationbenefits parbase section']//*[contains(text(),'Explanation')]"));*/

	}
	
	/**
	 * @toDo : forms and resources link
	 */
	public void validateFormsResourcesLinks() {
		validateNew(FormsnResourcesLinks);
		FormsnResourcesLinks.click();
		validateNew(FormsnResourcesLinkPdf);
	}
}
