package pages.memberrdesignVBF;

import java.util.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.CommonConstants;
import acceptancetests.memberrdesignVBF.common.CommonStepDefinition;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import junit.framework.Assert;
import pages.regression.explanationofbenefits.EOBPage;

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
	@FindBy(xpath = "//div[@class='customsegments parbase section']//div[contains(@class,'otherPages') and not (contains(@class,'ng-hide'))]//div[@class='explanationbenefits parbase section']//*[@class='block-body']/a[text()='SEARCH MEDICAL EOB HISTORY']")
	private WebElement eobMedicalButton;

	/** Drug button in EOB section */
	@FindBy(xpath = "//div[@class='customsegments parbase section']//div[contains(@class,'otherPages') and not (contains(@class,'ng-hide'))]//div[@class='explanationbenefits parbase section']//a[text()='SEARCH DRUG EOB HISTORY']")
	private WebElement eobDrugButton;

	/** Renew Magazine Section - Forms And Resources page */
	@FindBy(xpath = "//div[@class='customsegments parbase section']//div[contains(@class,'otherPages') and not (contains(@class,'ng-hide'))]//a[@href='/wellness/health/health-wellness-programs-pastissues-renew?type=lifestyle']")
	private WebElement renewMagazineSection;

	/** My DocumentSection - Forms And Resources page */
	@FindBy(id = "myDocHeader")
	private WebElement myDocumentSection;

	/** Plan Material Section **/

	@FindBy(xpath = "(//div[contains(@class,'formsAndResourcesParsys')]//div[contains(@class,'planMaterial201') and not(contains(@class,'ng-hide'))]//div[contains(@class,'planBenefitsHeaderParsys')])[1]")
	private WebElement PlanMaterialSection;

	/* for active uhc member */
	@FindBy(xpath = "(//div[contains(@class,'formsAndResourcesParsys')]//div[contains(@class,'planMaterial201') and not(contains(@class,'ng-hide'))]//a[contains(text(),'VIEW MEMBER')])[1]")
	private WebElement MemberIdCardlink;

	/* for terminated */
	@FindBy(xpath = "(//a[contains(text(),'VIEW MEMBER ID CARD')])[1]")
	private WebElement MemberIdCardlinkterminated;

	@FindBy(xpath = "(//div[contains(@class,'formsAndResourcesParsys')]//div[contains(@class,'planMaterial201') and not(contains(@class,'ng-hide'))]//a[contains(text(),'ORDER PLAN MATERIALS')])[1]")
	private WebElement OrderPlanMaterialLink;

	@FindBy(xpath = "//div[contains(@class,'formsAndResourcesParsys')]//div[contains(@class,'planMaterial201') and not(contains(@class,'ng-hide'))]//select[contains(@id,'lang-select-2source-content-configurations_plan-material_jcr-content_overview_formsandresourcescon_formsAndResourcesParsys_customsegments')]")
	private WebElement languagedropdown;

	/** Anoc Section **/
	@FindBy(xpath = "(//div[contains(@class,'customsegments')]//div[contains(@class,'annualNotice201') and not(contains(@class,'ng-hide'))]//div[contains(@class,'planBenefitsHeaderParsys')])[1]")
	private WebElement AnocSection;

	/** Annual Directories Section **/
	@FindBy(xpath = "(//div[contains(@class,'customsegments')]//div[contains(@class,'annualDirectories_201') and not(contains(@class,'ng-hide'))]//div[contains(@class,'planBenefitsHeaderParsys')])[1]")
	private WebElement AnnualDirectorySection;

	/* Provider Search Link */
	@FindBy(xpath = "//div[contains(@class,'customsegments')]//div[contains(@class,'annualDirectories_201')]//div[not(contains(@class,'ng-hide')) and contains(@class,'calloutBoth')]//a[contains(text(),'Provider Search')]")
	private WebElement ProviderSearchLink;

	/* Pharmacy Locator Link */
	@FindBy(xpath = "//div[contains(@class,'customsegments')]//div[contains(@class,'annualDirectories_201')]//div[not(contains(@class,'ng-hide')) and contains(@class,'calloutBoth')]//a[contains(text(),'Pharmacy Locator')]")
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

	@FindBy(xpath = "//div[contains(@class,'plan-material')]//ul//li/a")
	private List<WebElement> actualPlanMaterialsPdfs;

	@FindBy(xpath = "//a[contains(text(),'Search Documents')]")
	private WebElement searchDocuments;

	@FindBy(xpath = "//div[@class='customsegments parbase section']//div[contains(@class,'otherPages') and not (contains(@class,'ng-hide'))]//div[@class='explanationbenefits parbase section']//*[contains(text(),'Explanation')]")
	private WebElement eobSectionHeader;

	@FindBy(id = "pageHeader")
	private WebElement pageHeader;

	@FindBy(id = "benefitssummary")
	private List<WebElement> L2benefitssummary;

	@FindBy(id = "ordermaterials")
	private List<WebElement> orderMaterials;

	@FindBy(id = "premiumpayment_3")
	private List<WebElement> premiumPayment;

	@FindBy(id = "healthwellness_3")
	private List<WebElement> healthWellness;

	@FindBy(xpath = "//*[contains(text(), 'You can search by type')]")
	private WebElement validateDocumentTypePage;
	
	@FindBy(id="doc-type")
	private WebElement documentType;
	
	@FindBy(id="document-date")
	private WebElement planType;
	
	@FindBy(xpath = "//*[text()='Document Type:']")
	private List<WebElement> DocumentType;
	
	@FindBy(xpath = "//*[@id='myDocuments']/div[2]/div[2]/div/table")
	private WebElement validateTable;
	
	@FindBy(xpath = "//*[@class='link link--icon-left link--icon-circled']")
	private WebElement returnToPrevious;
	String category = null;

	public FormsAndResourcesPage(WebDriver driver) {
		super(driver);
		category = CommonStepDefinition.getMemberAttributeMap().get("Member Type");
		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReadyNew(driver);
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RallyDashboardPage.checkModelPopup(driver);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(pageHeader);
		validateNew(PlanMaterialSection);
		validateNew(myDocumentSection);
		validateNew(FormsnResources);
		validateNew(FormsnResourcesLinks);
		if (category.contains(CommonConstants.CATEGORY_TERMIATED)) {
			Assert.assertTrue("PASS !!! Benefits not displayed for terminated", L2benefitssummary.isEmpty());
			Assert.assertTrue("PASS !!! orderMaterials not displayed for terminated", orderMaterials.isEmpty());
			Assert.assertTrue("PASS !!! premiumPayment not displayed for terminated", premiumPayment.isEmpty());
			Assert.assertTrue("PASS !!! healthWellness not displayed for terminated", healthWellness.isEmpty());
		}
	}

	/**
	 * @toDo : Document Type text
	 */
	public WebElement getvalidateDocumentTypePage() {
		validateNew(validateDocumentTypePage);
		return validateDocumentTypePage;
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

			if (IDCardAttribute.contains("member.uhc.com") || IDCardAttribute.contains("int.uhc.com")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("The member id cards link is wrong");
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

	public boolean verifypdfname(String expectedPDFArray[]) {
		int actualPdfSize = actualPlanMaterialsPdfs.size();
		int expectedPdfSize = expectedPDFArray.length;
		System.out.println("Number of PDFs --" + actualPdfSize);
		boolean checkflag = false;
		int expectedPdfMatchCount = 0;
		if (expectedPdfSize <= actualPdfSize) {

			for (int i = 0; i < expectedPdfSize; i++) {
				System.out.println("Inside For loop:"+i);
				for (int currentActualIndex = 0; currentActualIndex < actualPdfSize; currentActualIndex++) {
					System.out.println("Actual PDF---"+actualPlanMaterialsPdfs.get(currentActualIndex).getText().trim());
					System.out.println("Expected PDF --"+expectedPDFArray[i].trim() );
					if (actualPlanMaterialsPdfs.get(currentActualIndex).getText().trim().contains(expectedPDFArray[i].trim())) {
						System.out.println("actual PDF matched...."+actualPlanMaterialsPdfs.get(currentActualIndex).getText());
						expectedPdfMatchCount +=1 ;
						break;
					}
				}
			}
		} else {
			Assert.fail("Expected " + expectedPdfSize + " and actual " + actualPdfSize + " pdf's count doesn't match");
		}
		if (expectedPdfMatchCount == expectedPdfSize){
			checkflag = true;
		}		
		return checkflag;
	}

	public WebElement geteobmapdsection() {
		validateNew(eobSectionHeader);
		return eobSectionHeader;

	}

	/**
	 * @toDo : forms and resources link
	 */
	public void validateFormsResourcesLinks() {
		validateNew(FormsnResourcesLinks);
		FormsnResourcesLinks.click();
		validateNew(FormsnResourcesLinkPdf);
	}
	
	
	@FindBy(xpath = "//*[contains(text(),'There are no documents available')]")
	private WebElement validateNoTable;
	
	public FormsAndResourcesPage selectDateRange(String documentTypeData, String planTypeData){
		selectFromDropDownByText(driver,documentType,documentTypeData);
		selectFromDropDownByText(driver,planType,planTypeData);	
		waitforElementVisibilityInTime(validateTable,60);
		if(validateTable.isDisplayed())	{
				validateNew(validateTable);
				System.out.println("Plan document view/download table is visible.");		
		}else if(validateNoTable.isDisplayed()){
			System.out.println("There are no documents available for the time period entered. Select a new date range.");
		}
		else{
			Assert.fail("Plan document view/download table is not visible.");
		}
		returnToPrevious.click();
		validateNew(FormsnResourcesLinks);
 		return new FormsAndResourcesPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
