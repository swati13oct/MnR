package pages.regression.formsandresources;

import java.util.*;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.regression.benefitandcoverage.BenefitsAndCoveragePage;
import pages.regression.claims.ClaimSummarypage;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

@SuppressWarnings("deprecation")
public class FormsAndResourcesPage extends UhcDriver {
	/*
	 * @FindBy(
	 * xpath="//*[@class='clearfix MAPD_govt_false_57425290']//*[contains(text(),'Benefit Highlights')]"
	 * ) private WebElement pdf;
	 */

	@FindBy(id = "pageHeader")
	private WebElement documentheader;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]//*[contains(text(),'Order Plan Materials')]")
	private WebElement ordermatpage;

	@FindBy(xpath = "(//*[@alt='TEXAS ERS'])[1]")
	private WebElement pdptexaslogo;

	@FindBy(xpath = "//*[contains(text(),'Redetermination Request Form for HealthSelect of TX')]")
	private WebElement pdptexasdocument;

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
	@FindBy(xpath = "html/body/div[5]/div[1]/h1")
	private WebElement perceptionpopup;

	@FindBy(className = "btn btn-no")
	private WebElement nothanksbutton;

	/** Medical button in EOB section for MAPD - Forms And Resources page */
	@FindBy(xpath = "//*[@class='otherPages EOBComponentforMAPDNICE_2018']//*[@class='explanationbenefits parbase section']//*[@class='block-body']")
	private WebElement eobMedicalButton;

	@FindBy(xpath = " //*[@class='otherPages EOB_MA_COSMOS']//*[contains(text(),'SEARCH EOB HISTORY')]")
	private WebElement eobMedicalButtonMA;

	/** Drug button in EOB section for MAPD */
	@FindBy(xpath = "//*[@class='otherPages EOBComponentforMAPDNICE_2018']//*[@class='explanationbenefits parbase section']//*[@class='col-md-4 block border-left']")
	private WebElement eobDrugButton;

	/** Medical button in Eob section for mapd group */
	@FindBy(xpath = "//*[@class='otherPages EOB_MAPD_COSMOS']//*[contains(text(),'SEARCH MEDICAL EOB HISTORY')]")
	private WebElement eobMedicalEobgroup;

	@FindBy(xpath = "//*[@class='otherPages EOB_MAPD_COSMOS']//*[contains(text(),'SEARCH DRUG EOB HISTORY')]")
	private WebElement eobPDPEobGroup;

	/** Drug button in EOB section for PDP */
	@FindBy(xpath = "//*[@class='otherPages EOB_PDP']//*[text()='SEARCH EOB HISTORY']")
	private WebElement eobDrugButtonPDP;

	/** Renew Magazine Section - Forms And Resources page */
	@FindBy(xpath = "//div[@class='otherPages renewmagazine_AARP_MA_MAPD']//*[contains(text(),'Renew Magazine')]")
	private WebElement renewMagazineSectionMAPDAARP;

	@FindBy(xpath = "//*[@class='otherPages renewmagazine_AARP_PDP']")
	private WebElement renewMagazinePDPAARP;

	@FindBy(xpath = "//*[@class='otherPages renewmagazine_UHC_PDP']")
	private WebElement renewMagazinePDPUHC;

	@FindBy(xpath = "//*[@class='otherPages renewmagazine_UHC_GROUP_MA_MAPD']")
	private WebElement renewMagazineMAPDUHCGroup;

	@FindBy(xpath = "//*[@class='otherPages renewmagazine_UHC_Individual_MA_MAPD']")
	private WebElement renewMagazineMAPDUHCInd;

	@FindBy(xpath = "//*[@class='otherPages renewmagazine_UHC_GROUP_MA_MAPD']//*[contains(text(),'Renew Magazine')]")
	private WebElement renewMagazineMAPDGroup;
	/** My DocumentSection - Forms And Resources page */

	@FindBy(id = "myDocHeader")
	private WebElement myDocumentSection;

	/** Plan Material Section **/

	@FindBy(xpath = "//*[@id='plan_material_fnr2018']//*[not(contains(text(),'ng-hide'))]//*[contains(text(),'Plan Materials')]")
	public WebElement PlanMaterialSection;

	/* for active member */
	@FindBy(xpath = "//*[@class='otherPages PlanDocumentsActiveCallouts2018']//*[contains(text(),'VIEW MEMBER')]")
	private WebElement MemberIdCardlink;

	/* for terminated */
	@FindBy(xpath = "(//a[contains(text(),'VIEW MEMBER ID CARD')])[1]")
	private WebElement MemberIdCardlinkterminated;

	@FindBy(xpath = "//*[@class='otherPages PlanDocumentsActiveCallouts2018']//*[contains(text(),'ORDER PLAN')]")
	private WebElement OrderPlanMaterialLink;

	/*
	 * @FindBy(xpath =
	 * "//*[@id='lang-select-2source-content-configurations_plan-material_jcr-content_overview_formsandresourcescon_formsAndResourcesParsys_customsegments_segmentContainer_planbenefitdocuments']")
	 * private WebElement languagedropdown;
	 */

	@FindBy(id = "lang-select-2overview_customsegments-welcomeKit-2018_segmentContainer_planbenefitdocuments")
	private List<WebElement> languagedropdown;

	/** Anoc Section **/
	@FindBy(xpath = "(//*[@id=\"anoc_headerfnr\"])[1]/div/div/h2")
	private WebElement AnocSection;

	/** Anoc section for group **/
	@FindBy(id = "anoc_headerfnrgroup")
	private WebElement AnocSectionGroup;

	/** Anoc and Annual Directories Documents */
	@FindBy(xpath = "//*[@class='otherPages']//div[@class='sectionWise_div_2018']//*[@class='document-list-new margin-small']")
	private WebElement anocannualdirectorydocuments;

	/** Annual Directories Section **/
	@FindBy(id = "FnR_annualDirectory")
	private WebElement AnnualDirectorySection;

	/* Provider Search Link for MAPD */
	@FindBy(xpath = "//*[@class='otherPages calloutBoth_AD']//*[text()='Provider Search']")
	private WebElement ProviderSearchLink;

	/* Pharmacy Locator Link for MAPD and MA */

	// @FindBy(//*[@class='customsegments parbase
	// section']//div[@class='otherPages']//*[contains(text(),'Pharmacy
	// Locator')])[2]
	@FindBy(xpath = "//*[@class='otherPages calloutBoth_AD']//*[contains(text(),'Pharmacy Locator')]")
	private WebElement PharmacyLocatorLink;

	/* PharmacyLocatorLink for MAPD */
	@FindBy(xpath = "(//*[contains(text(),'Pharmacy Locator')])[7]")
	private WebElement PharmacyLocatorLinkMAPD;

	/* Provider Search link for PDP and MA */
	@FindBy(xpath = "//*[@class='otherPages providerSearchCallout_AD']//*[text()='Provider Search']")
	private WebElement ProviderSearchLinkPDP;

	/* Pharmacy Locator Link for PDP */
	@FindBy(xpath = "//*[@class='otherPages PharmacyLocatorCallout_AD']//*[text()='Pharmacy Locator']")
	private WebElement PharmacyLocatorLinkPDP;

	/** Forms and Resources section **/
	@FindBy(xpath = "//h2[@id='formsAndResHeader']")
	private WebElement FormsnResources;

	@FindBy(xpath = "//*[contains(text(),'MA/MAPD opt-out form (PDF')]")
	private WebElement ALPEEhipDoc;

	@FindBy(xpath = "//*[@class='disenrollmentinformation']//*[@href='#collapse-source-content-configurations__forms-and-resources-section__jcr-content__overview__formsandresourcesdoc__formsAndResourceHeaderDocListingParsys__customsegments-5-AL-PEEHIP__segmentContainer__formsandresources-3']")
	private WebElement disenrollment;

	@FindBy(xpath = "//area[@href='javascript:clWin()'][@alt = 'close']")
	private WebElement FeedbackModal;

	@FindBy(xpath = "//*[@class='nav nav-tabs']//*[@class='ng-scope active']//*[(contains(@href,'#'))]")
	private WebElement FirstTab;

	@FindBy(xpath = "//*[@class='nav nav-tabs']//*[@class='ng-scope']//*[(contains(@href,'#'))]")
	private WebElement SecondTab;

	@FindBy(xpath = "//*[@class='otherPages']//*[@class='reimbursementforms']")
	private WebElement reimbursementforms;

	@FindBy(xpath = "//*[@class='otherPages']//*[@class='medicationauthorizationforms']")
	private WebElement medicationauthorizationforms;

	@FindBy(xpath = "//*[@class='otherPages']//*[@class='authorizationforms']")
	private WebElement authorizationforms;

	@FindBy(xpath = "//*[@class='otherPages']//*[@class='otherresources']")
	private WebElement otherresources;

	@FindBy(xpath = "//*[@class='clearfix ship']//*[contains(text(),'Plan Overview')]")
	private WebElement planoverviewpdf;

	@FindBy(xpath = "//*[@class='clearfix ship']//*[contains(text(),'Benefits Table')]")
	private WebElement benefitstable;

	@FindBy(xpath = "//*[@class='clearfix ship']//*[contains(text(),'Outline of Coverage')]")
	private WebElement outlineofcoverage;

	@FindBy(className = "noPdfMessageClass")
	private WebElement errormessageforship;

	@FindBy(xpath = "(//*[@href='/content/dam/UCP/SHIP/eft_content.pdf'])[5]")
	private WebElement eftpdfforship;

	/** i perception pop up objects */
	@FindBy(id = "IPerceptionsEmbed")
	private WebElement iPerceptionBody;

	@FindBy(id = "closeButton")
	private WebElement iPerceptionCloseButton;

	@FindBy(xpath = "//*[@class='overview_customsegments-40_segmentContainer_planbenefitdocuments_2018']//*[@class='document-list-new margin-small spanWithImmDiv divWithImmLi']/ul/li")
	private List<WebElement> anocxpath;

	@FindBy(xpath = "(//*[@class='document-list-new margin-small spanWithImmDiv divWithImmLi'])[1]/ul/li")
	private List<WebElement> planmaterialxpath;

	@FindBy(xpath = "(//*[@class='source-content-configurations_plan-material_jcr-content_overview_formsandresourcescon_formsAndResourcesParsys_customsegments_segmentContainer_planbenefitdocuments'])[1]/div/ul/li")
	private List<WebElement> shipplanmaterialxpath;

	@FindBy(xpath = ("(//*[@alt='CoLogo'])[1]"))
	private WebElement alpeehiplogo;

	@FindBy(xpath = "//*[@class='overview_customsegments-welcomeKit-2018_segmentContainer_planbenefitdocuments']//li")
	private List<WebElement> PreEffectiveMemMaterials;

	
	@FindBy(xpath = "//*[contains(text(),'Pharmacy Locator')])[7]")
	private WebElement pharmacyLocatorLinkIndMAPDPreEffective;
	
	/**
	 * @return the pharmacyLocatorLinkIndMAPDPreEffective
	 */
	public WebElement getPharmacyLocatorLinkIndMAPDPreEffective() {
		return pharmacyLocatorLinkIndMAPDPreEffective;
	}

	/*
	 * @FindBy(xpath="") private WebElement annualdirectoryxpath;
	 */
	String pDR = "Plan Documents & Resources";

	public FormsAndResourcesPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReady(driver);

		CommonUtility.checkPageIsReady(driver);
		Thread.sleep(5000);
		try {
			waitforElementNew(iPerceptionBody);
			driver.switchTo().frame("IPerceptionsEmbed");
			Thread.sleep(5000);
			iPerceptionCloseButton.click();
			System.out.println("iPerception Pop Up is Present");
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("issue with perception prpup Present");
		}

		/*
		 * try{ FeedbackModal.click(); System.out.println("FeedBack Modal Present"); if
		 * (validate(FeedbackModal)){
		 * System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked"); }
		 * System.out.println("FeedBack Modal Closed"); } catch (Exception e) {
		 * System.out.println("FeedBack Modal NOT Present"); }
		 */
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		// start(MRConstants.UHCM_MEMBER_URL);

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
		linkToFormsAndResources.click();

	}

	/**
	 * @toDo : EOB medical button
	 */
	public WebElement getEOBMedicaButton() {
		return eobMedicalButton;
	}

	/**
	 * @toDo : EOB medical button
	 */
	public WebElement getEOBMedicaButtonMA() {
		return eobMedicalButtonMA;
	}

	/**
	 * @toDo : EOB drug button
	 */
	public WebElement getEOBDrugButton() {
		return eobDrugButton;
	}

	/**
	 * @toDo : renew magazine section
	 */
	public WebElement getRenewMagazineSectionMAPD() {
		return renewMagazineSectionMAPDAARP;
	}

	/**
	 * @toDo : renew magazine section for PDP
	 */
	public WebElement getRenewMagazineSectionPDP() {
		return renewMagazinePDPAARP;
	}

	public WebElement getRenewMagazineSectionPDPUHC() {
		return renewMagazinePDPUHC;
	}

	public WebElement getRenewMagazineSectionMAPDGroupUHC() {
		return renewMagazineMAPDUHCGroup;
	}

	/**
	 * @toDo : my document section
	 */
	public WebElement getMyDocumentSection() {
		return myDocumentSection;
	}

	/**
	 * @toDo : anoc section
	 */
	public WebElement getANOCSection() {
		return AnocSection;
	}

	/**
	 * @toDo : forms and resources section
	 */
	public WebElement getFormsandResourcesSection() {
		return FormsnResources;
	}

	/**
	 * @toDo : annual directory section
	 */
	public WebElement getAnnualDirectorySection() {
		return AnnualDirectorySection;
	}

	/**
	 * @toDo : provider search link
	 */
	public WebElement getprovisesearchlink() {
		return ProviderSearchLink;
	}

	/**
	 * @toDo : pharmacy search link
	 */
	public WebElement getpharmacysearchlink() {
		return PharmacyLocatorLink;
	}

	/**
	 * @toDo : plan materials section
	 */
	public WebElement getplanmaterialsection() {
		/* CommonUtility.waitForPageLoad(driver, documentheader, 40); */
		return PlanMaterialSection;
	}

	/**
	 * @toDo : order plan material link
	 */
	public WebElement getOrderPlanMaterialLink() {
		return OrderPlanMaterialLink;
	}

	/**
	 * @toDo : to click order plan material link
	 */
	public void validateOrderPlanMaterial() throws InterruptedException {
		try {
			Thread.sleep(15000);
			driver.switchTo().frame("iPerceptionBody");
			Thread.sleep(5000);
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();

			driver.switchTo().defaultContent();

		} catch (Exception e) {
			System.out.println("failed and exception in frame , popup has not come yet");
		}
		if ((OrderPlanMaterialLink).isDisplayed()) {
			OrderPlanMaterialLink.click();
		}
		CommonUtility.waitForPageLoad(driver, ordermatpage, 40);
		if (driver.getCurrentUrl().contains("order-materials")) {
			Assert.assertTrue(true);
		} else {
			Assert.fail("failed to load order materials page");
		}

		driver.navigate().back();
		CommonUtility.waitForPageLoad(driver, documentheader, 40);
		if (driver.getCurrentUrl().contains("documents/overview")) {
			Assert.assertTrue(true);
		}

		else {
			Assert.fail("failed to loaf fnr page");
		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");
	}

	/**
	 * @toDo : temporary id card link
	 */
	public WebElement getTemporaryIdcardlink() {
		return MemberIdCardlink;
	}

	/**
	 * @toDo : to click temporary id card link
	 */
	public void validateIDCard() throws InterruptedException {

		if (MRScenario.environmentMedicare.equalsIgnoreCase("team-g")
				|| MRScenario.environmentMedicare.equalsIgnoreCase("test-a")
				|| MRScenario.environment.equalsIgnoreCase("team-ci1")) {

			String s = getTemporaryIdcardlink().getAttribute("href");
			if (s.contains("test-harness")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Some wrong link is coming for member id cards");
			}

		} else if (MRScenario.environmentMedicare.equalsIgnoreCase("stage"))

		{
			String s = getTemporaryIdcardlink().getAttribute("href");
			if (s.contains("int.uhc.com")) {
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
		Select oselect = new Select(languagedropdown.get(0));
		if (oselect.getFirstSelectedOption().getText().equals("ENGLISH")) {
			System.out.println(oselect.getFirstSelectedOption().getText());
			System.out.println("true");
			Assert.assertTrue(true);
		}

		else {
			Assert.fail("false");
		}
	}

	/**
	 * @toDo : switch language
	 */
	public void changelanguage() throws InterruptedException {
		/* CommonUtility.waitForPageLoad(driver, pdf, 20); */
		Select oselect = new Select(languagedropdown.get(0));

		Thread.sleep(3000);
		languagedropdown.get(0).click();
		oselect.selectByVisibleText("SPANISH");
		System.out.println(oselect.getFirstSelectedOption().getText());
		Thread.sleep(6000);
	}

	public void scroll() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)", "");

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

	public boolean verifypdfname(String a[]) throws InterruptedException {
		boolean checkflag = true;

		Select langdropdwn = new Select(languagedropdown.get(0));
		if (langdropdwn.getFirstSelectedOption().getText().contains("ENGLISH")) {

			java.util.List<WebElement> pdfs = driver.findElements(
					By.xpath("(//*[@class='document-list-new margin-small spanWithImmDiv divWithImmLi'])[1]/ul"));
			System.out.println(pdfs.size());
			for (int i = 0; i < pdfs.size(); i++) {
				String pdfnames = null;
				pdfnames = (pdfs.get(i).getText());
				System.out.println(pdfnames);
			}

			for (int i = 0; i < pdfs.size(); i++) {
				String pdf[] = pdfs.get(i).getText().split(Pattern.quote("("));
				if (pdf[0].contains(a[i])) {
					System.out.println(pdf[0]);
					checkflag = true;
				} else {
					checkflag = false;
					break;
				}
			}

		} else if (langdropdwn.getFirstSelectedOption().getText().contains("SPANISH")) {

			java.util.List<WebElement> pdfs = driver
					.findElements(By.xpath(".//*[@class='PlanPdf section']/div/div[1]/div[2]/span/div/ul/li[2]/a"));
			System.out.println("Size" + pdfs.size());
			for (int i = 0; i < pdfs.size(); i++) {
				String pdfnames = null;
				pdfnames = (pdfs.get(i).getText());
				System.out.println(pdfnames);
			}

			for (int i = 0; i < pdfs.size(); i++) {

				String pdf[] = pdfs.get(i).getText().split(Pattern.quote("("));

				System.out.println(pdf[0]);
				if (pdf[0].contains(a[i])) {
					checkflag = true;
				} else {
					checkflag = false;
					break;
				}

			}

		}

		return checkflag;
	}

	/**
	 * This method verifies the PDF links present for the ANOC section on forms and
	 * resource page
	 * 
	 * @param a
	 *            --> This will collect the PDF link names
	 * @return --> true/false
	 * @throws InterruptedException
	 */
	public boolean verifypdfnamesforanocdocuments(String a[]) throws InterruptedException

	{
		Thread.sleep(2000);
		scroll();
		boolean checkflag = true;
		java.util.List<WebElement> anocpdfs = driver.findElements(
				By.xpath("(//*[@class='otherPages']//*[@class='col-md-8']//*[@class='planDocuments parsys'])[2]//li"));
		System.out.println(anocpdfs.size());
		for (int i = 0; i < anocpdfs.size(); i++) {
			String pdfnames = null;
			pdfnames = (anocpdfs.get(i).getText());
			System.out.println(pdfnames);
		}

		if (anocpdfs.size() == 0) {
			Assert.fail("no pdfs are coming");
			checkflag = false;

		} else if (anocpdfs.size() != a.length) {
			Assert.fail("less or more pdfs are coming");
			checkflag = false;

		} else {

			for (int i = 0; i < anocpdfs.size(); i++) {
				String pdf[] = anocpdfs.get(i).getText().split(Pattern.quote("("));
				if (pdf[0].contains(a[i])) {
					System.out.println(pdf[0]);
					checkflag = true;
				} else {
					checkflag = false;
					break;
				}
			}

		}
		return checkflag;
	}

	public boolean verifypdfnamemembershipmaterials(String a[]) throws InterruptedException {
		boolean checkflag = false;

		Select langdropdwn = new Select(languagedropdown.get(0));
		if (langdropdwn.getFirstSelectedOption().getText().contains("ENGLISH")) {

			java.util.List<WebElement> pdfs = PreEffectiveMemMaterials;
			System.out.println(pdfs.size());
			System.out.println(a.length);
			for (int i = 0; i < pdfs.size(); i++) {
				String pdfnames = null;
				pdfnames = (pdfs.get(i).getText());
				System.out.println(pdfnames);
			}

			for (int i = 0; i < pdfs.size(); i++) {
				String pdf[] = pdfs.get(i).getText().split(Pattern.quote("("));
				if (pdf[0].trim().toLowerCase().contains(a[i].trim().toLowerCase())) {
					System.out.println(pdf[0]);
					checkflag = true;
				} else {
					checkflag = false;
					break;
				}
			}

		} else if (langdropdwn.getFirstSelectedOption().getText().contains("SPANISH")) {

			java.util.List<WebElement> pdfs = driver.findElements(By.xpath(
					"//*[@class='overview_customsegments-welcomeKit-2018_segmentContainer_planbenefitdocuments']/div/ul/li"));
			System.out.println("Size" + pdfs.size());
			for (int i = 0; i < pdfs.size(); i++) {
				String pdfnames = null;
				pdfnames = (pdfs.get(i).getText());
				System.out.println(pdfnames);
			}

			for (int i = 0; i < pdfs.size(); i++) {

				String pdf[] = pdfs.get(i).getText().split(Pattern.quote("("));

				System.out.println(pdf[0]);
				if (pdf[0].contains(a[i])) {
					checkflag = true;
				} else {
					checkflag = false;
					break;
				}

			}

		}

		return checkflag;
	}

	public void waitforFNRpage() {
		WebDriverWait wait = new WebDriverWait(this.driver, 40);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				if (driver.getTitle().contains(pDR))
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

	/**
	 * @return the Annual Directories section for group
	 */
	public boolean checkAnnualDirectoriesforgroup() {

		if (AnnualDirectorySection.isDisplayed()) {
			System.out.println("Annual Directories section is present");
			return false;
		} else {
			System.out.println("Annual Directories section is not present");
			return true;
		}

	}

	/**
	 * check the provider and pharmacy section for group
	 */
	public boolean checkProviderforgroup() {

		try {
			if (ProviderSearchLink.isDisplayed()) {
				System.out.println("Provider section is present for group");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Provider section is not present for group");
			return true;

		}

		return false;
	}

	public boolean checkPharmacyforgroup() {

		try {
			if (PharmacyLocatorLink.isDisplayed()) {
				System.out.println("Pharmacy section is present for group");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Pharmacy section is not present for group");
			return true;

		}

		return false;
	}

	public WebElement geteobsectionall() {

		return driver.findElement(By.xpath("//div[@class='otherPages EOB_PDP']//*[contains(text(),'Explanation')]"));

	}

	public WebElement getAnocforgroup() {

		return AnocSectionGroup;
	}

	public WebElement getPharmacyforPDP() {

		return PharmacyLocatorLinkPDP;
	}

	public WebElement getProviderforPDP() {

		return ProviderSearchLinkPDP;
	}

	public WebElement getDrugEOBforPDP() {

		return eobDrugButtonPDP;
	}

	public WebElement getmedicalEOBforGroup() {

		return eobMedicalEobgroup;
	}

	public WebElement getDrugEOBforGroup() {

		return eobPDPEobGroup;
	}

	public WebElement getMAPDALpeehipDoc() {

		return ALPEEhipDoc;
	}

	public WebElement getdisenrollment() {

		return disenrollment;
	}

	public WebElement getProviderSerachLinkMA() {

		return ProviderSearchLinkPDP;
	}

	public boolean checkProviderforPDP() {

		try {
			if (ProviderSearchLinkPDP.isDisplayed()) {
				System.out.println("Provider section is present for PDP");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Provider section is not present for PDP");
			return true;

		}

		return false;
	}

	public boolean checkMedicalEobforPDP() {

		try {
			if (eobMedicalButton.isDisplayed()) {
				System.out.println("Medical Eob is present for PDP");
				return false;
			}

		} catch (Exception e) {
			System.out.println("Medical Eob  is not present for PDP");
			return true;

		}

		return false;
	}

	public boolean checkRenewsection() {
		try {
			if (renewMagazineSectionMAPDAARP.isDisplayed()) {
				System.out.println("Renew magazine sec is present");
				return false;
			} else {

			}
		} catch (Exception e) {
			System.out.println("Renew magazine section is not present");
			return true;
		}
		return false;
	}

	public boolean checkRenewsectionPDP() {
		try {
			if (renewMagazinePDPAARP.isDisplayed()) {
				System.out.println("Renew magazine sec is present");
				return false;
			} else {

			}
		} catch (Exception e) {
			System.out.println("Renew magazine section is not present");
			return true;
		}
		return false;
	}

	public boolean checkdrugeobforMA() {
		try {
			if (eobDrugButton.isDisplayed()) {
				System.out.println("Drug Eob sec is present for MA");
				return false;
			} else {

			}
		} catch (Exception e) {
			System.out.println("Drug Eob section is not present");
			return true;
		}
		return false;
	}

	public boolean checkpharmacyforMA() {
		try {
			if (PharmacyLocatorLink.isDisplayed()) {
				System.out.println("Pharmacy sec is present for MA");
				return false;
			} else {

			}
		} catch (Exception e) {
			System.out.println("Pharmacy section is not present");
			return true;
		}
		return false;
	}

	public boolean checkanocforPCP() {
		try {
			if (driver.findElement(By.xpath("//*[@class='otherPages']//*[@id='anoc_headerfnr']")).isDisplayed()) {
				System.out.println("Anoc sec is present");
				return false;
			} else {

			}
		} catch (Exception e) {
			System.out.println("Anoc section is not present");
			return true;
		}
		return false;
	}

	public boolean checkeobsection() {
		try {
			if (geteobsectionall().isDisplayed()) {
				System.out.println("Eob sec is present for SSUP");
				return false;
			} else {

			}
		} catch (Exception e) {
			System.out.println("Eob section is not present for SSUP");
			return true;
		}
		return false;
	}

	public boolean checkmedicaleob() {
		try {
			if (geteobsectionall().isDisplayed()) {
				System.out.println("Med Eob sec is present for SSUP");
				return false;
			} else {

			}
		} catch (Exception e) {
			System.out.println("Med Eob section is not present for SSUP");
			return true;
		}
		return false;

	}

	public WebElement getfirstplantab() {
		return FirstTab;

	}

	public WebElement getsecondplantab() {
		return SecondTab;

	}

	public WebElement getoutlineofcoverage() {
		return outlineofcoverage;
	}

	public WebElement getbenefitstable() {
		return benefitstable;
	}

	public WebElement geterrormessgaeforship() {
		return errormessageforship;
	}

	public void selectlanguagedropdown(String language) {
		Select langdropdwn = new Select(languagedropdown.get(0));
		langdropdwn.selectByVisibleText(language);
	}

	public WebElement geteftpdfforship() {
		return eftpdfforship;
	}

	public void checkshipdocuments() {
		java.util.List<WebElement> pdfs = driver.findElements(By.xpath(
				"(//*[@class='source-content-configurations_plan-material_jcr-content_overview_formsandresourcescon_formsAndResourcesParsys_customsegments_segmentContainer_planbenefitdocuments'])[1]/div/ul/li"));

		String pdfnames[] = new String[pdfs.size()];
		for (int i = 0; i < pdfs.size(); i++) {
			pdfnames[i] = (pdfs.get(i).getText());
		}

		/*
		 * int pdfCount = 0; if (ArrayUtils.isNotEmpty(pdfnames)) {
		 * 
		 * if (ArrayUtils.contains(pdfnames, "Benefit")) { pdfCount = pdfCount + 1;
		 * 
		 * } if (ArrayUtils.contains(pdfnames, "Outline")) { pdfCount = pdfCount + 1; }
		 */
	}

	public boolean checkerrormessageforship() {
		try {
			if (errormessageforship.isDisplayed()) {
				System.out.println("error for ship is present");
				return false;
			} else {

			}
		} catch (Exception e) {
			System.out.println("error for ship is not present");
			return true;
		}
		return false;
	}

	public void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,400)", "");

	}

	public WebElement getpdptexaslogo() {

		return pdptexaslogo;
	}

	public WebElement getalpeehiplogo() {

		return alpeehiplogo;
	}

	public WebElement getmedicationforms() {
		// TODO Auto-generated method stub
		return medicationauthorizationforms;
	}

	public WebElement getpdptexasdocument() {
		// TODO Auto-generated method stub
		return pdptexasdocument;
	}

	// *[@class='overview_customsegments-4_segmentContainer_planbenefitdocuments_2018']

	public boolean verifypdfnamesfordocuments(String a[], List<WebElement> xpathofwebelement)
			throws InterruptedException

	{
		Thread.sleep(20000);
		System.out.println("reached in function");
		boolean checkflag = true;
		List<WebElement> pdfs = (List<WebElement>) xpathofwebelement;
		System.out.println(pdfs);
		System.out.println(pdfs.size());
		for (int i = 0; i < pdfs.size(); i++) {
			String pdfnames = null;
			pdfnames = (pdfs.get(i).getText());
			System.out.println(pdfnames);
		}

		if (pdfs.size() == 0) {
			Assert.fail("no pdfs are coming");
			checkflag = false;

		} else if (pdfs.size() != a.length) {
			Assert.fail("less or more pdfs are coming");
			checkflag = false;

		} else {

			for (int i = 0; i < pdfs.size(); i++) {
				String pdf[] = pdfs.get(i).getText().split(Pattern.quote("("));
				if (pdf[0].contains(a[i])) {
					System.out.println(pdf[0]);
					checkflag = true;
				} else {
					checkflag = false;
					break;
				}
			}

		}
		return checkflag;
	}

	public boolean xpathSelectionSectionwise(String a[], String section) throws InterruptedException {
		if (section == "plan material") {
			return verifypdfnamesfordocuments(a, planmaterialxpath);

		} else if (section == "anoc") {
			return verifypdfnamesfordocuments(a, anocxpath);

		} else if (section == "ship plan material") {
			return verifypdfnamesfordocuments(a, shipplanmaterialxpath);
		}
		/*
		 * else if (section=="annual directory") { return verifypdfnamesfordocuments(a,
		 * annualdirectoryxpath);
		 * 
		 * }
		 */
		return false;

	}

	public void verifyTitleOfPage() {
		System.out.println("Now checking the title of forms and resources page");
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Plan Documents"));
		System.out.println("Assert condition on title of forms and resources page was passed");
	}

	public ClaimSummarypage clickonClaimsTab() throws InterruptedException {
		System.out.println("Now clicking on Claims Tab on Forms and Resources Page");
		driver.findElement(By.xpath("//a[contains(text(),'Claims')]")).click();
		System.out.println("Now waiting for 10 seconds");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title = driver.getTitle();
		System.out.println("Now user is on this page:" + title);
		return new ClaimSummarypage(driver);
	}

	
}
