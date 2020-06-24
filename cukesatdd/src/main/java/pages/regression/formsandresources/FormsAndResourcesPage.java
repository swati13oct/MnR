package pages.regression.formsandresources;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.MRConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.memberrdesignVBF.TestHarness;
import pages.regression.claims.ClaimsSummaryPage;
import pages.regression.payments.PaymentHistoryPage;


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
	// @FindBy(xpath = "//*[@class='otherPages
	// EOBComponentforMAPDNICE_2018']//*[@class='explanationbenefits parbase
	// section']//*[@class='block-body']")
	@FindBy(xpath = "(//*[@id='eobsection']/div[2]/div[1]/div/div/a)[6]")
	private WebElement btnEobMedicalButton;

	@FindBy(xpath = "//*[@class='otherPages EOB_MA_COSMOS']//*[contains(text(),'SEARCH EOB HISTORY')]")
	private WebElement eobMedicalButtonMA;

	/** Drug button in EOB section for MAPD */
	// @FindBy(xpath = "//*[@class='otherPages
	// EOBComponentforMAPDNICE_2018']//*[@class='explanationbenefits parbase
	// section']//*[@class='col-md-4 block border-left']")
	@FindBy(xpath = "(//*[@id='eobsection']/div[2]/div[2]/div/div/a)[1]")
	private WebElement btneobDrugButton;

	/** Medical button in Eob section for mapd group */
	@FindBy(xpath = "//*[@class='otherPages EOB_MAPD_COSMOS']//*[contains(text(),'SEARCH MEDICAL EOB HISTORY')]")
	private WebElement eobMedicalEobgroup;

	@FindBy(xpath = "//*[@class='otherPages EOB_MAPD_COSMOS']//*[contains(text(),'SEARCH DRUG EOB HISTORY')]")
	private WebElement eobPDPEobGroup;

	/** Drug button in EOB section for PDP */
	@FindBy(xpath = "//*[@class='otherPages EOB_PDP']//*[text()='SEARCH EOB HISTORY']")
	private WebElement eobDrugButtonPDP;

	/** Renew Magazine Section - Forms And Resources page */
	@FindBy(xpath = "(//*[@id='renew_magazine']/div/div/div/div[1]/div/div/div[2]/h2)[1]")
	private WebElement renewMagazineSectionMAPDAARP;

	@FindBy(xpath = "//*[@class='otherPages renewmagazine_AARP_PDP']")
	private WebElement renewMagazinePDPAARP;

	// @FindBy(xpath = "//*[@class='otherPages renewmagazine_UHC_PDP']")
	@FindBy(xpath = "(//*[@id='renew_magazine']//h2)[2]")
	private WebElement renewMagazinePDPUHC;

	@FindBy(xpath = "//*[@class='otherPages renewmagazine_UHC_GROUP_MA_MAPD']")
	private WebElement renewMagazineMAPDUHCGroup;

	@FindBy(xpath = "//*[@class='otherPages renewmagazine_UHC_Individual_MA_MAPD']")
	private WebElement renewMagazineMAPDUHCInd;

	@FindBy(xpath = "//*[@class='otherPages renewmagazine_UHC_GROUP_MA_MAPD']//*[contains(text(),'Renew Magazine')]")
	private WebElement renewMagazineMAPDGroup;
	/** My DocumentSection - Forms And Resources page */

	@FindBy(xpath = "//*[@id='myDocButtonText']")
	private WebElement myDocumentSection;

	/** Plan Material Section **/

	// @FindBy(xpath =
	// "//*[@id='plan_material_fnr2018']//*[not(contains(text(),'ng-hide'))]//*[contains(text(),'Plan
	// Materials')]")
	@FindBy(xpath = "//*[contains(@ng-show,'planMaterial') and not(contains(@class,'ng-hide'))]//*[contains(@id,'plan_material_fnr')]")
	public WebElement PlanMaterialSection;
	
	@FindBy(xpath = "(//*[@class='plan_benefit_documents_forms_amd_resources']//*[@class='planBenefitsHeaderParsys parsys']//*[contains(text(),'Plan Materials')])[2]")
	public WebElement hdrPlanMaterialSection;
	
	// *[@id="plan_material_fnr"]/div/div[1]/h2

	@FindBy(xpath = "//*[@id='plan_material_fnr']/div/div[2]/h2[contains(text(), 'Plan Materials')]") 
	public WebElement planMaterialHeaderSection;

	@FindBy(xpath = "//*[@id='plan_material_fnr']/div/div[1]/h2")
	public List<WebElement> lstPlanMaterialHeaderSection;
	
	@FindBy(xpath="//*[@id='plan_material_fnr']/div/div[2]/h2")
	public List<WebElement> Secondary_lstPlanMaterialHeaderSection;
	
	//@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/div[3]/div[4]/div/div/div/div/section//*[@id='anoc_headerfnr']/div/div/h2")
	@FindBy(xpath = "//*[@id='anoc_headerfnr']/div/div/h2")
	public List<WebElement> anocHeaderSection;
	
	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/div[3]/div[4]/div/div/div/div/section/div/div[1]")
	 public List<WebElement> anocHeaderSection_alt;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/div[3]/div[8]/div/div/div/div/section//*[@id='FnR_annualDirectory']/div/div[2]/div/div/div/h2")
	public List<WebElement> annualdirectoriesHeaderSection;

	@FindBy(xpath = "(//*[@id='FnR_annualDirectory']/div/div[2]/div/div/div/h2)[2]")
	public List<WebElement> annualdirectoriesHeaderSectionMAPDGRP;

	//@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/div[3]/div[16]/div//*[@id='eobsection']/div[1]/div/h2")
	//@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/div[3]/div[16]/div/div/div/section/div/div/div/h2")
	@FindBy(xpath = "//*[@id='eobsection']//*[contains(text(),'Explanation of Benefits')]")
	public List<WebElement> eobHeaderSection;

	/* for active member */
	@FindBy(xpath = "//*[@class='otherPages PlanDocumentsActiveCallouts2018']//*[contains(text(),'VIEW MEMBER')]")
	private WebElement MemberIdCardlink;

	@FindBy(xpath = "//*[@id='plan_material_fnr']/div/div[5]/div/div/div/div/div/div/div/ul/li[2]/a")
	private WebElement lnkMemberIdCardlink;

	/* for terminated */
	@FindBy(xpath = "(//a[contains(text(),'VIEW MEMBER ID CARD')])[1]")
	private WebElement MemberIdCardlinkterminated;

	// @FindBy(xpath = "//*[@class='otherPages
	// PlanDocumentsActiveCallouts2018']//*[contains(text(),'ORDER PLAN')]")
	@FindBy(xpath = "//*[@class='otherPages PlanDocumentsActiveCallouts2019']//*[contains(text(),'ORDER PLAN')]")
	private WebElement OrderPlanMaterialLink;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']//div[2]//div[2]/div/div[2]//section/div/div[1]//div[4]//ul/li[1]/a")
	private WebElement lnkOrderPlanMaterialLink;

	@FindBy(xpath = "//*[@id='plan_material_fnr']/div/div[5]/div/div/div/div/div/div/div/ul/li[1]/a[contains(text(),'ORDER PLAN MATERIALS')]")
	private WebElement pcpOrderPlanMaterialLink;

	@FindBy(xpath = "//*[@id='renew_magazine']/div/div/div/div[1]/div/div/div[2]/h2")
	public List<WebElement> renewMagazineSectionHeader;

	// *[@id="plan_material_fnr2018"]/div/div[4]//ul/li[1]/a

	/*
	 * @FindBy(xpath =
	 * "//*[@id='lang-select-2source-content-configurations_plan-material_jcr-content_overview_formsandresourcescon_formsAndResourcesParsys_customsegments_segmentContainer_planbenefitdocuments']")
	 * private WebElement languagedropdown;
	 */

	public WebElement getPcpOrderPlanMaterialLink() {
		return pcpOrderPlanMaterialLink;
	}

	// @FindBy(id =
	// "lang-select-2overview_customsegments-welcomeKit-2018_segmentContainer_planbenefitdocuments")
	@FindBy(id = "lang-select-2source-content-configurations_plan-material_jcr-content_overview_formsandresourcescon_formsAndResourcesParsys_customsegments2019_segmentContainer_planbenefitdocuments")
	private WebElement languagedropdown;

	// AEP language xpath changed
	@FindBy(id = "lang-select-2source-content-configurations_plan-material_jcr-content_overview_formsandresourcescon_formsAndResourcesParsys_customsegments_segmentContainer_planbenefitdocuments")
	private WebElement languagedropdowncopy;

	@FindBy(id = "lang-select-2overview_customsegments-welcomeKit-2018_segmentContainer_planbenefitdocuments")
	private List<WebElement> languagedropdownPreEfffective;

	// AEP language xpath changed
	@FindBy(id = "lang-select-2source-content-configurations_plan-material_jcr-content_overview_formsandresourcescon_formsAndResourcesParsys_customsegments_segmentContainer_planbenefitdocuments")
	private List<WebElement> languagedropdownPreEfffectiveCopy;

	/** Anoc Section **/
	@FindBy(xpath = "//*[@id='anoc_headerfnr']")
	private List<WebElement> hdrAnocSection;

	/** Anoc section for group **/
	@FindBy(xpath = "//*[@id='anoc_headerfnr']/div/div/h2")
	private List<WebElement> AnocSectionGroup;
	
	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/div[3]/div[6]/div/div/div/div/section/div/div[2]/div/div[1]/div[1]/div/div/div/ul/li")
	public List<WebElement> AnocSectionpdpuhcGroup;

	/** Anoc and Annual Directories Documents */
	@FindBy(xpath = "//*[@class='otherPages']//div[@class='sectionWise_div_2018']//*[@class='document-list-new margin-small']")
	private WebElement anocannualdirectorydocuments;

	/** Annual Directories Section **/
	@FindBy(id = "FnR_annualDirectory")
	private List<WebElement> hdrAnnualDirectorySection;

	/** Annual Directories Section **/
	@FindBy(xpath = "(//*[@id='FnR_annualDirectory']//h2[contains(text(),'Provider and Pharmacy Directories')])[3]")
	private WebElement preAnnualDirectorySection;

	/** Annual Directories Section for pre-effective MAPD **/
	@FindBy(xpath = "(//*[@id='FnR_annualDirectory'])[3]")
	private WebElement preMAAnnualDirectorySection;

	public WebElement getPreMAAnnualDirectorySection() {
		return preMAAnnualDirectorySection;
	}

	/* Provider Search Link for MAPD */
	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[3]/div[8]//section//div[2]/div/div[1]/div[3]//ul/li[1]/a")
	private WebElement lnkProviderSearchLink;
	
	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[3]/div[8]//section//div[2]/div/div[1]/div[3]//ul/li[1]/a")
	private WebElement lnkProviderSearchLinkPCP;

	/* Pharmacy Locator Link for MAPD and MA */

	// @FindBy(//*[@class='customsegments parbase
	// section']//div[@class='otherPages']//*[contains(text(),'Pharmacy
	// Locator')])[2]
	@FindBy(xpath = "//*[@class='otherPages calloutBoth_AD']//*[contains(text(),'Pharmacy Locator')]")
	private WebElement PharmacyLocatorLink;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[3]/div[8]//section/div/div[2]//div[1]/div[3]//ul/li[2]/a")
	private WebElement lnkPharmacyLocatorLink;
	
	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[3]/div[8]//section/div/div[2]//div[1]/div[3]//ul/li[2]/a")
	private WebElement lnkPharmacyLocatorLinkPCP;

	/* PharmacyLocatorLink for MAPD */
	@FindBy(xpath = "(//*[contains(text(),'Pharmacy Locator')])[7]")
	private WebElement PharmacyLocatorLinkMAPD;

	/* Provider Search link for PDP and MA */
	@FindBy(xpath = "//*[@class='otherPages providerSearchCallout_AD']//*[text()='Provider Search']")
	private WebElement ProviderSearchLinkPDP;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[3]/div[8]//section/div/div[2]/div/div[1]/div[3]//ul/li[1]/a")
	private WebElement lnkProviderSearchLinkMAPDGroup;

	/* Provider Search link for PDP and MA */
	@FindBy(xpath = "//*[@class='otherPages provide_rSearch_Callout_PE']//*[text()='Provider Search']")
	private WebElement ProviderSearchLinkPreEffectivePDPMA;

	public WebElement getProviderSearchLinkPreEffectivePDPMA() {
		return ProviderSearchLinkPreEffectivePDPMA;
	}

	/* Pharmacy Locator Link for PDP */
	// @FindBy(xpath = "//*[@class='otherPages
	// PharmacyLocatorCallout_AD']//*[text()='Pharmacy Locator']")
	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/div[3]/div[9]/div/div/div/div/section/div/div[2]/div/div[1]/div[2]/div/div/div/div/div/div/div/ul/li/a")
	private WebElement PharmacyLocatorLinkPDP;

	@FindBy(xpath = "(//*[contains(text(),'Pharmacy Locator')])[4]")
	private WebElement lnkPharmacyLocatorLinkMAPDGroup;
	
	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/div[3]/div[8]/div/div/div/div/section/div/div[2]/div/div[1]/div[2]/div/div/div/div/div/div/div/ul/li/a")
	private WebElement lnkPharmacyLocatorLinkTexas;
	
	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/div[3]/div[8]/div/div/div/div/section/div/div[2]/div/div[1]/div[2]/div/div/div/div/div/div/div/ul/li/a")
	private WebElement lnkPharmacyLocatorLinkpdpUHC;
	
	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/div[3]/div[8]/div/div/div/div/section/div/div[2]/div/div[1]/div[3]/div/div/div/div/div/div/div/ul/li[2]/a")
	private WebElement lnkPharmacyLocatorLinkAlPeehip;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[3]/div[8]//section/div/div[2]/div/div[1]/div[2]//ul/li/a")
	private WebElement lnkPharmacyLocatorLinkPDPUHCGroupFnR;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[3]/div[9]//section/div/div[2]/div/div[1]/div[2]//ul/li/a")
	private WebElement preEffectivePharmacyLocatorLinkPDP;

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

	@FindBy(xpath = "//*[@id=\"resources\"]/div/div[2]/div/div/div[13]/div/div/div/ul/li[1]/a")
	private WebElement eftpdfforship;
	
	@FindBy(xpath = "//div[@id='eobsection']//h3[text()='SHIP EOB']")
	private WebElement shipEOBHeader;

	/** i perception pop up objects */
	@FindBy(id = "IPerceptionsEmbed")
	private WebElement iPerceptionBody;

	@FindBy(id = "closeButton")
	private WebElement iPerceptionCloseButton;

	@FindBy(xpath = "(//*[@class='img-responsive coLogo'])[1]")
	private WebElement logoPEEHIP;

	public WebElement getLogoPEEHIP() {
		return logoPEEHIP;
	}

	@FindBy(xpath = "(//*[contains(@class,'document-list-new margin-small spanWithImmDiv divWithImmLi')])[4]//li")
	private List<WebElement> anocxpath;

	@FindBy(xpath = "//*[@id='globalContentIdForSkipLink']/div[3]/div[6]//section/div/div[2]/div/div[1]/div[1]//ul/li")
	private List<WebElement> lstTexasRxanocxpath;

	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[3]/div[6]//section/div/div[2]/div/div[1]/div[1]//ul/li")
	private List<WebElement> lstGRPanocxpath;

	// @FindBy(xpath = "(//*[@class='document-list-new margin-small spanWithImmDiv
	// divWithImmLi'])[1]/ul/li")
	@FindBy(xpath = "(//*[contains(@class,'document-list-new margin-small spanWithImmDiv divWithImmLi')])[1]//li")
	private List<WebElement> planmaterialxpath;

	@FindBy(xpath = "//*[@class='source-content-configurations_plan-material_jcr-content_overview_formsandresourcescon_formsAndResourcesParsys_customsegments_segmentContainer_planbenefitdocuments'])[1]/div/ul/li")
	private List<WebElement> shipplanmaterialxpath;

	@FindBy(xpath = ("(//*[@alt='CoLogo'])[1]"))
	private WebElement alpeehiplogo;

	@FindBy(xpath = "//*[@class='overview_customsegments-welcomeKit-2018_segmentContainer_planbenefitdocuments']//li")
	private List<WebElement> PreEffectiveMemMaterials;

	// @FindBy(xpath =
	// "//*[@id=\"globalContentIdForSkipLink\"]/div[3]/div[8]//section/div/div[2]/div/div[1]/div[1]//ul/li")
	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[3]/div[9]//section/div/div[2]/div/div[1]/div[1]//ul/li")
	// *[@id="globalContentIdForSkipLink"]/div[3]/div[9]//section/div/div[2]/div/div[1]/div[1]//ul/li
	private List<WebElement> annualDirectoryPdfList;

	@FindBy(xpath = "(//*[contains(@class,'overview_customsegments-AnnualDirectories')])[2]//li")
	private List<WebElement> copyAnnualDirectoryPdfList;

	@FindBy(xpath = "//*[@id='home_2']")
	private WebElement home;

	@FindBy(xpath = "(//*[@id='backToTopContainer']/a/span/p)[2]")
	private WebElement linkBackToTop;

	//@FindBy(xpath = "(//*[@id='backToTopContainer']/a/span/p)[2]")
	@FindBy(xpath = "//footer[contains(@class,'footerContainer')]/div/div[2]//*[@id='backToTopContainer']/a")
	private WebElement LinkBackToTop_copy;

	// JumpLinks

	// directory section for MAPD
	@FindBy(xpath = "//*[@id='forms-and-resources-quickLinksParsys']/div[1]//div[3]//ul/li")
	private List<WebElement> jumpLinks;

	@FindBy(xpath = "//*[@id='forms-and-resources-quickLinksParsys']/div[1]/div[1]/div[2]/div/div[4]/div/div/div/div/ul/li")
	private List<WebElement> jumpLinksGroup;

	@FindBy(xpath = "//*[@id='forms-and-resources-quickLinksParsys']/div[1]/div[1]/div[2]/div/div[6]/div/div/div/div/ul/li")
	private List<WebElement> jumpLinksMAPDIndUHC;

	// directory section for MA

	@FindBy(xpath = "//*[@id='forms-and-resources-quickLinksParsys']/div[1]/div[1]/div[2]/div/div[8]/div/div/div/div/ul/li")
					 
	private List<WebElement> jumpLinksMAIndUHC;

	@FindBy(xpath = "//*[@id='forms-and-resources-quickLinksParsys']/div[1]/div[1]/div[2]/div/div[8]/div/div/div/div/ul/li") 
	private List<WebElement> jumpLinksMAGroup;

	@FindBy(xpath = "//*[@id='forms-and-resources-quickLinksParsys']/div[1]/div[1]/div[2]/div/div[2]/div/div/div/div/ul/li")
	private List<WebElement> jumpLinksMAIndAARP;

	@FindBy(xpath = "//*[@id='welcomekit']")
	private List<WebElement> membershipMaterialHeaderSection;

	@FindBy(xpath = "//*[@id='FnR_annualDirectory']")
	private List<WebElement> annualdirectoriesHeaderSectionMA;

	@FindBy(xpath = "//*[@id='forms-and-resources-quickLinksParsys']/div[1]/div[1]/div[2]/div/div[1]//ul/li")
	private List<WebElement> jumpLinksMedSupp;

	@FindBy(xpath = "//*[@id='forms-and-resources-quickLinksParsys']/div[1]/div[1]/div[2]/div/div[5]//ul/li")
	private List<WebElement> jumpLinksPDP;

	@FindBy(xpath = "//*[@id='forms-and-resources-quickLinksParsys']/div[1]/div[1]/div[2]/div/div[9]/div/div/div/div/ul/li")
	private List<WebElement> jumpLinksPDPGroup;

	@FindBy(xpath = "//*[@id='forms-and-resources-quickLinksParsys']/div[1]/div[1]/div[2]/div/div[10]//ul/li")
	private List<WebElement> jumpLinksSSUP;

	@FindBy(xpath="//div[contains(@class,'annualNotice') and not(contains(@class,'ng-hide'))]//h2[text()='Annual Notice of Changes Documents']")
	private WebElement anocSection;
	

/*<<<<<<< theATeam
	@FindBy(xpath = "(//*[@id='eobsection']/div[1]/div/h2)[6]")
	private WebElement btnEobSectionall;
	
	
	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[3]/div[17]/div/div/div/section/div")
=======*/
	@FindBy(xpath = "//div[contains(@ng-show,'evaluateAEM_Segments') and not (contains(@class,'ng-hide'))]//a[contains(@class,'btn btn--secondary') and contains(text(),'EOB HISTORY')]")
	private WebElement btnEobSectionall;

	@FindBy(xpath = "//div[contains(@ng-show,'evaluateAEM_Segments') and not (contains(@class,'ng-hide'))]//h3[contains(text(),'EOB')]")

	private WebElement eobSectionall;
	
	@FindBy(xpath = "//*[@class='otherPages UHC_IND_MAPD']//ul/li[3]/a")
	private WebElement jumpLinkToProviderAndPharmacyDirectories;
	
	@FindBy(xpath = "//*[@class='otherPages calloutBoth_2019_PCP_Medica']//*[text()='Provider Search']")
	private WebElement ProviderSearchLinkPCPMedica;
	
	@FindBy(xpath = "//div[contains(@class,'preeffectiveShip')]//h4")
	private WebElement preEffecShipPlanName;
	
	@FindBy(xpath = "//h4")
	private WebElement preEffecShipPlanNameCombo;
	
	
	@FindBy(xpath = "//h4//parent::div[@ng-show='showshiplist']//following-sibling::div[@class='ng-scope']//following-sibling::div[@class='ng-binding']")
	private WebElement preEffectiveCoverageDate;
	
	@FindBy(xpath = "//h4//parent::div[contains(@ng-if,'shipPlanProfileList')]//following-sibling::div[@class='ng-scope']//following-sibling::div[@class='ng-binding']")
	private WebElement preEffectiveComboCoverageDate;
	
	//h4//parent::div[contains(@ng-if,'shipPlanProfileList')]//following-sibling::div[@class='ng-scope']//following-sibling::div[@class='ng-binding']
	
	@FindBy(xpath = "//div[@id='plan_material_fnr']//a[contains(@href,'order-materials')]")
	private WebElement preEffecShipOrderPlan;

	@FindBy(xpath = "//a[@id='myDocButtonText']")
	public WebElement myDocumentsButton;
	
	@FindBy(xpath="//a[@id='premiumpayment_4']")
	protected WebElement pymtTabTopMenu;
	
	@FindBy(xpath = "//p[contains(@ng-if, 'preEffective == true') or (contains(@ng-if, 'preEffective != true') and contains(@ng-if, 'businessType ==') )]")
	protected WebElement preEffectiveTechSupportNumber;
	
	@FindBy(xpath = "(//*[@class='tabs-desktop']//a[contains(.,'Senior Supplement Plan')])[2]")
	protected WebElement SSUPTab;

	public WebElement getEobSectionall() {
		return eobSectionall;
	}

	public WebElement getLnkPharmacyLocatorLink() {
		return lnkPharmacyLocatorLink;
	}
	
	 public WebElement getLnkPharmacyLocatorLinkPCP() {
		return lnkPharmacyLocatorLinkPCP;
	}

	public WebElement getBtnEobSectionall() {
		return btnEobSectionall;
	}

	public WebElement getLnkPharmacyLocatorLinkPDPUHCGroupFnR() {
		return lnkPharmacyLocatorLinkPDPUHCGroupFnR;
	}

	public List<WebElement> getLstTexasRxanocxpath() {
		return lstTexasRxanocxpath;
	}

	public WebElement getLnkPharmacyLocatorLinkMAPDGroup() {
		return lnkPharmacyLocatorLinkMAPDGroup;
	}
	
	public WebElement getLnkPharmacyLocatorLinkTexas() {
		return lnkPharmacyLocatorLinkTexas;
	}
	
	public WebElement getLnkPharmacyLocatorLinkPDPUHCGroup() {
		return lnkPharmacyLocatorLinkpdpUHC;
	}
	
	public WebElement getLnkPharmacyLocatorLinkAlPeehip() {
		return lnkPharmacyLocatorLinkAlPeehip;
	}

	public WebElement getLnkProviderSearchLinkMAPDGroup() {
		return lnkProviderSearchLinkMAPDGroup;
	}

	public List<WebElement> getLstGRPanocxpath() {
		return lstGRPanocxpath;
	}

	public List<WebElement> getJumpLinksPDPGroup() {
		return jumpLinksPDPGroup;
	}

	public List<WebElement> getJumpLinksSSUP() {
		return jumpLinksSSUP;
	}

	public List<WebElement> getJumpLinksPDP() {
		return jumpLinksPDP;
	}

	public List<WebElement> getLstPlanMaterialHeaderSection() {
		return lstPlanMaterialHeaderSection;
	}
	
	public List<WebElement> getLstPlanMaterialHeaderSection_secondary() {
		return Secondary_lstPlanMaterialHeaderSection;
	}

	public List<WebElement> getAnnualdirectoriesHeaderSectionMA() {
		return annualdirectoriesHeaderSectionMA;
	}

	public List<WebElement> getJumpLinksMAIndAARP() {
		return jumpLinksMAIndAARP;
	}

	public List<WebElement> getJumpLinksMAIndUHC() {
		return jumpLinksMAIndUHC;
	}

	public List<WebElement> getMembershipMaterialHeaderSection() {
		return membershipMaterialHeaderSection;
	}

	public List<WebElement> getJumpLinksMAGroup() {
		return jumpLinksMAGroup;
	}

	public List<WebElement> getJumpLinksMAPDIndUHC() {
		return jumpLinksMAPDIndUHC;
	}

	public List<WebElement> getAnnualdirectoriesHeaderSectionMAPDGRP() {
		return annualdirectoriesHeaderSectionMAPDGRP;
	}

	public List<WebElement> getJumpLinksGroup() {
		return jumpLinksGroup;
	}

	public List<WebElement> getRenewMagazineSectionHeader() {
		return renewMagazineSectionHeader;
	}

	public WebElement getLinkBackToTop() {
		return linkBackToTop;
	}

	public WebElement getLinkBackToTop_copy() {
		return LinkBackToTop_copy;
	}

	public List<WebElement> getJumpLinks() {
		return jumpLinks;
	}

	public WebElement getPlanMaterialHeaderSection() {
		return planMaterialHeaderSection;
	}

	public List<WebElement> getAnocHeaderSection() {
		return anocHeaderSection;
	}
	
	public List<WebElement> getAnocHeaderSection_alt() {
		return anocHeaderSection_alt;
	}
	public List<WebElement> getAnnualdirectoriesHeaderSection() {
		return annualdirectoriesHeaderSection;
	}

	public List<WebElement> getEobHeaderSection() {
		return eobHeaderSection;
	}
	public List<WebElement> getEobHeaderSectionMA() {
		return eobHeaderSection;
	}

	public WebElement getPreEffectivePharmacyLocatorLinkPDP() {
		return preEffectivePharmacyLocatorLinkPDP;
	}
	

	public WebElement getHome() {
		return home;
	}

	public List<WebElement> getAnnualDirectoryPdfList(String memberType) {
		if (memberType.contains("Pre-Effective"))
			return annualDirectoryPdfList;
		else
			return copyAnnualDirectoryPdfList;
	}

	public List<WebElement> getPreEffectiveMemMaterials() {
		return PreEffectiveMemMaterials;
	}

	// @FindBy(xpath = "//*[contains(text(),'Pharmacy Locator')])[7]")
	@FindBy(xpath = "//*[@id=\"globalContentIdForSkipLink\"]/div[3]/div[8]//section/div/div[2]/div/div[1]/div[3]//ul/li[2]/a")
	private WebElement lnkpharmacyLocatorLinkIndMAPDPreEffective;

	/**
	 * @return the pharmacyLocatorLinkIndMAPDPreEffective
	 */
	public WebElement getPharmacyLocatorLinkIndMAPDPreEffective() {
		return lnkpharmacyLocatorLinkIndMAPDPreEffective;
	}

	public List<WebElement> getJumpLinksMedSupp() {
		return jumpLinksMedSupp;
	}

	/*
	 * @FindBy(xpath="") private WebElement annualdirectoryxpath;
	 */
	String pDR = "Plan Documents & Resources";
	WebDriverWait wait = null;
	String iPerceptionframeName = "iPerceptionBody";

	public List<WebElement> getDirectorySection(String planType, String memberType, String identifier) {

		int planId = 0;
		/*
		 * Menu 1-MAPD 2-MA 3-MedSupp 4-PDP 5-SSUP
		 * 
		 */
		if (planType.equalsIgnoreCase("MAPD"))
			planId = 1;
		if (planType.equalsIgnoreCase("MA"))
			planId = 2;
		if (planType.equalsIgnoreCase("MedSupp"))
			planId = 3;
		if (planType.equalsIgnoreCase("PDP"))
			planId = 4;
		if (planType.equalsIgnoreCase("SSUP"))
			planId = 5;

		switch (planId) {
		case 1:

			if (identifier.contains("AARP"))
				return getJumpLinks();
			else if ((identifier.contains("UHC") && memberType.contains("Individual")) || identifier.contains("PCP")
					|| identifier.contains("Medica"))
				return getJumpLinksMAPDIndUHC();
			else
				return getJumpLinksGroup();

		case 2:
			if (identifier.contains("IndEffectiveUHC"))
				return getJumpLinksMAIndUHC();
			else if (identifier.contains("IndEffectiveAARP"))
				return getJumpLinksMAIndAARP();
			else
				return getJumpLinksMAGroup();

		case 3:
			System.out.println("Tamzid - A");

			return getJumpLinksMedSupp();

		case 4:

			if (memberType.contains("Group"))
				return getJumpLinksPDPGroup();
			else
				return getJumpLinksPDP();

		case 5:
			return getJumpLinksSSUP();

		default:
			System.out.println("Plan Not Found");
			break;

		}
		return null;

	}

	public FormsAndResourcesPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReady(driver);

		CommonUtility.checkPageIsReady(driver);
		// Thread.sleep(5000);
		iPerceptionHandle("IPerceptionsEmbed");

		/*
		 * try{ FeedbackModal.click(); System.out.println("FeedBack Modal Present"); if
		 * (validate(FeedbackModal)){
		 * System.out.println("FeedBack Modal NOT CLOSING - Close button is clicked"); }
		 * System.out.println("FeedBack Modal Closed"); } catch (Exception e) {
		 * System.out.println("FeedBack Modal NOT Present"); }
		 */
		openAndValidate();
	}

	public void iPerceptionHandle(String frameName) {
		wait = new WebDriverWait(driver, 15);

		try {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
			/*
			 * driver.switchTo().frame("iPerceptionBody"); Thread.sleep(5000);
			 */
			System.out.println("iPerception Pop Up is Present");
			iPerceptionCloseButton.click();

			driver.switchTo().defaultContent();

		} catch (Exception e) {
			System.out.println("iPerception popup didn't appear");
		}
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
		return btnEobMedicalButton;
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
		return btneobDrugButton;
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
	public List<WebElement> getANOCSection() {
		return hdrAnocSection;
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
	public WebElement getAnnualDirectorySection(String memberType) {

		if (memberType == "Pre-Effective")
			return preAnnualDirectorySection;
		else
			return hdrAnnualDirectorySection.get(1);
	}

	/**
	 * @toDo : provider search link
	 */
	public WebElement getprovisesearchlink() {
		return lnkProviderSearchLink;
	}
	
	 public WebElement getprovisesearchlinkPCP() {
		return lnkProviderSearchLinkPCP;
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
	public WebElement getplanmaterialsection(String memberType) {
		/* CommonUtility.waitForPageLoad(driver, documentheader, 40); */
		if (memberType.toLowerCase().contains("term"))
			return hdrPlanMaterialSection;
		else
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
		iPerceptionHandle(iPerceptionframeName);
		try {
			if ((OrderPlanMaterialLink).isDisplayed()) {
				OrderPlanMaterialLink.click();
			}
		} catch (Exception e) {
			if ((getPcpOrderPlanMaterialLink()).isDisplayed()) {
				getPcpOrderPlanMaterialLink().click();
			}

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
	public WebElement getTemporaryIdcardlink(String memberType) {

		if (memberType.toLowerCase().contains("pcp") || memberType.toLowerCase().contains("medica"))
			return lnkMemberIdCardlink;
		else
			return MemberIdCardlink;
	}

	/**
	 * @toDo : to click temporary id card link
	 */
	public void validateIDCard(String memberType) throws InterruptedException {

		if (MRScenario.environmentMedicare.equalsIgnoreCase("team-g")
				|| MRScenario.environmentMedicare.equalsIgnoreCase("test-a")
				|| MRScenario.environment.equalsIgnoreCase("team-ci1")) {

			String s = getTemporaryIdcardlink(memberType).getAttribute("href");
			if (s.contains("test-harness")) {
				Assert.assertTrue(true);
			} else {
				Assert.fail("Some wrong link is coming for member id cards");
			}

		} else if (MRScenario.environmentMedicare.equalsIgnoreCase("stage"))

		{
			String s = getTemporaryIdcardlink(memberType).getAttribute("href");
			if (memberType.equalsIgnoreCase("PCP") || memberType.equalsIgnoreCase("Medica")) {
				if (s.contains("int.mymedicareaccount.uhc")) {
					Assert.assertTrue(true);
				} else {
					Assert.fail("The member id cards link is wrong");
				}

			}

			else {
				if (s.contains("int.uhc.com")) {
					Assert.assertTrue(true);
				} else {
					Assert.fail("The member id cards link is wrong");
				}
			}
		}
	}

	/**
	 * @toDo : to verify english as a default language
	 */
	public void validateEngDefault(String memberType) {
		Select oselect, oselectCopy;
		if (memberType.contains("Pre-Effective")) {
			oselect = new Select(languagedropdownPreEfffective.get(0));
			oselectCopy = new Select(languagedropdownPreEfffectiveCopy.get(0));
		}

		else {
			oselect = new Select(languagedropdown);
			oselectCopy = new Select(languagedropdowncopy);
		}
		if (oselect.getFirstSelectedOption().getText().equals("ENGLISH")
				|| oselectCopy.getFirstSelectedOption().getText().equals("ENGLISH")) {
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
		Select oselect = new Select(languagedropdownPreEfffective.get(0));

		Thread.sleep(3000);
		languagedropdownPreEfffective.get(0).click();
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

		Select langdropdwn = new Select(languagedropdownPreEfffective.get(0));
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

	public boolean verifyPdfNames(String a[], List<WebElement> listOfPdf) throws InterruptedException {
		boolean checkflag = false;
		checkflag = pdfComparison(a, listOfPdf, checkflag);
		/*
		 * Select langdropdwn = new Select(languagedropdownPreEfffective.get(0)); if
		 * (langdropdwn.getFirstSelectedOption().getText().contains("ENGLISH")) {
		 * checkflag = pdfComparison(a, listOfPdf, checkflag); } else if
		 * (langdropdwn.getFirstSelectedOption().getText().contains("SPANISH")) {
		 * checkflag = pdfComparison(a, listOfPdf, checkflag); }
		 */

		return checkflag;
	}

	public boolean pdfComparison(String[] a, List<WebElement> listOfPdf, boolean checkflag) {
		java.util.List<WebElement> pdfs = listOfPdf;
		System.out.println("Actual PDF size="+pdfs.size());
		System.out.println("Expected PDF size="+a.length);
		for (int i = 0; i < pdfs.size(); i++) {
			String pdfnames = null;
			pdfnames = (pdfs.get(i).getText());
			System.out.println("Actual PDF index="+i+" | filename="+pdfnames);
		}

		for (int i = 0; i < pdfs.size(); i++) {
			String pdf[] = pdfs.get(i).getText().split(Pattern.quote("("));
			System.out.println("Compare Actual   ="+pdf[0].trim().toLowerCase());
			System.out.println("Compare Expected ="+a[i].trim().toLowerCase());
			if (pdf[0].trim().toLowerCase().contains(a[i].trim().toLowerCase())) {
				System.out.println(pdf[0]);
				checkflag = true;
			} else {
				checkflag = false;
				break;
			}
		}
		return checkflag;
	}

	public void waitforFNRpage() {
		wait = new WebDriverWait(this.driver, 40);
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

		if (hdrAnnualDirectorySection.get(1).isDisplayed()) {
			System.out.println("Annual Directories section is present");
			return false;
		} else {
			System.out.println("Annual Directories section is not present");
			return true;
		}

	}
	
	public boolean checkAnnualDirectoriesforgroupssup() {

		if (hdrAnnualDirectorySection.get(1).isDisplayed()) {
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
			if (lnkProviderSearchLink.isDisplayed()) {
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

		return driver.findElement(By.xpath(
				"//*[@id='globalContentIdForSkipLink']/div[4]/div[12]/div/div/div/section/div/div[2]/div/div/div/h3"));

	}

	public List<WebElement> getAnocforgroup() {

		return AnocSectionGroup;
	}

	public List<WebElement> getAnocforpdpuhcgroup() {

		return AnocSectionpdpuhcGroup;
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
			if (btnEobMedicalButton.isDisplayed()) {
				System.out.println("Medical Eob is present for PDP");
				return false;
			} else
				return true;

		} catch (Exception e) {
			System.out.println("Medical Eob  is not present for PDP");
			return true;

		}

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
			if (btneobDrugButton.isDisplayed()) {
				System.out.println("Drug Eob sec is present for MA");
				return false;
			} else {
				return true;

			}
		} catch (Exception e) {
			System.out.println("Drug Eob section is not present");
			return true;
		}
		// return false;
	}

	public boolean checkpharmacyforMA() {
		try {
			if (PharmacyLocatorLink.isDisplayed()) {
				System.out.println("Pharmacy sec is present for MA");
				return false;
			} else {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Pharmacy section is not present");
			return false;
		}

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
				return true;
			}
		} catch (Exception e) {
			System.out.println("Med Eob section is not present for SSUP");
			return true;
		}
	}

	public WebElement getfirstplantab() {
		return FirstTab;

	}
	
	public WebElement getplantabTobeSelected(String PlanName) {
		WebElement PlanTabToSelect = driver.findElement(
				By.xpath("//a[contains(@class,'tab-change') and normalize-space(text())='" + PlanName + "']"));
		return PlanTabToSelect;

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
		Select langdropdwn = new Select(languagedropdownPreEfffective.get(0));
		langdropdwn.selectByVisibleText(language);
	}

	public WebElement geteftpdfforship() {
		return eftpdfforship;
	}

	public WebElement getShipEobHeader() {
		return shipEOBHeader;
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
		//note: 'a' is the target string array that stores the list of expected filenames
		//note: xpathofwebelement is the actual string array that stores the list of actual filenames

		Thread.sleep(20000);
		System.out.println("reached in function");
		boolean checkflag = true;
		List<WebElement> pdfs = (List<WebElement>) xpathofwebelement; //note: pdfs is same as xpathofwebelement, the actual list of filenames
		//System.out.println(pdfs);
		System.out.println("------------------ expected number of files=" +a.length);
		for (int i = 0; i < pdfs.size(); i++) {
			String pdfnames = null;
			pdfnames = (pdfs.get(i).getText());
			System.out.println("i='+i+' | actual filename = "+pdfnames);
		}
		System.out.println("------------------ actual number of files=" +pdfs.size());
		for (int i = 0; i < a.length; i++) {
			System.out.println("i='"+i+"' | expected filename = "+a[i]);
		}

		Assert.assertFalse("no pdfs are coming",pdfs.size() == 0);
		Assert.assertFalse("less or more pdfs are coming",pdfs.size() != a.length);
		for (int i = 0; i < pdfs.size(); i++) {
			String pdf[] = pdfs.get(i).getText().split(Pattern.quote("("));
			System.out.println("Comparing filename:");
			System.out.println("actual  ='"+pdf[0]+"'");
			System.out.println("expected='"+a[i]+"'");
			if (pdf[0].contains(a[i])) {
				System.out.println("matched portion ="+pdf[0]);
				checkflag = true;
			} else {
				checkflag = false;
				break;
			}
		}
		return checkflag;
	}

	public boolean xpathSelectionSectionwise(String a[], String section, String memberType)
			throws InterruptedException {
		//note: 'a' is the target string array that stores the list of expected filename
		if (section == "plan material") {
			return verifypdfnamesfordocuments(a, planmaterialxpath);

		} else if (section == "anoc") {

			if (memberType.contains("Group"))
				return verifypdfnamesfordocuments(a, getLstGRPanocxpath());
			else {
				if (memberType.contains("TexasRx"))
					return verifypdfnamesfordocuments(a, getLstTexasRxanocxpath());
				else
					return verifypdfnamesfordocuments(a, anocxpath);
			}

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

	public ClaimsSummaryPage clickonClaimsTab() throws InterruptedException {
		System.out.println("Now clicking on Claims Tab on Forms and Resources Page");
		//driver.findElement(By.xpath("//a[contains(text(),'Claims')]")).click();
		driver.navigate().to("https://stage-medicare.uhc.com/medicare/member/claims/overview.html");
		System.out.println("Now waiting for 10 seconds");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String title = driver.getTitle();
		System.out.println("Now user is on this page:" + title);
		return new ClaimsSummaryPage(driver);
	}

	public void pdfValidationOfAllTypes(FormsAndResourcesPage formsAndResourcesPage, DataTable givenAttributes,
			String materialType) throws InterruptedException {
		String memberType = null;
		List<WebElement> temp = null;
		List<DataTableRow> memberAttributesRow = givenAttributes.getGherkinRows();
		System.out.println(memberAttributesRow);
		Map<String, String> memberAttributesMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < memberAttributesRow.size(); i++) {
			memberAttributesMap.put(memberAttributesRow.get(i).getCells().get(0),
					memberAttributesRow.get(i).getCells().get(1));

		}

		memberType = memberAttributesRow.get(0).getCells().get(1).toString().trim();
		memberAttributesMap.remove("MemberType");
		memberAttributesMap.remove("Member Type");
		memberAttributesMap.remove("memberType");
		memberAttributesMap.remove("member Type");

		Collection<String> values = memberAttributesMap.values();
		String[] targetArray = values.toArray(new String[values.size()]);
		System.out.println(values.size());

		if (materialType == "memberShip")
			temp = getPreEffectiveMemMaterials();
		else if (materialType == "welcomeGuide")
			temp = getPreEffectiveMemMaterials();// same for both
			SystemOutPrintln(temp);	
		 if (materialType == "annualDirectory") {
			// formsAndResourcesPage.scrollToView(preAnnualDirectorySection);
			temp = getAnnualDirectoryPdfList(memberType);
			/*
			 * if(temp.size()<1) temp = getAnnualDirectoryPdfList();
			 */

		}

		boolean arraycheck = formsAndResourcesPage.verifyPdfNames(targetArray, temp);
		SystemOutPrintln(arraycheck);
		Assert.assertTrue("Incorrect pdf's shown", arraycheck == true);
	}

	private void SystemOutPrintln(boolean arraycheck) {
		// TODO Auto-generated method stub
		
	}

	private void SystemOutPrintln(List<WebElement> temp) {
		// TODO Auto-generated method stub
		
	}

	public void verifyPresenceOfJumpLinksMAPD(String rider, String planType, String memberType, String identifier) {
		int t = 0;
		CommonUtility.waitForPageLoad(driver, myDocumentSection, 15);

		Assert.assertTrue("jmpLinkToPLANMATERIALS isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(0).isDisplayed());

		if ((identifier.toString().trim().contains("UHC") || identifier.toString().trim().contains("PCP")
				|| identifier.toString().trim().contains("Medica"))
				&& memberType.toString().trim().contains("Individual")) {

		} else {

			Assert.assertTrue("jmpLinkTo Annual Notice of Changes Documents isn't displayed",
					getDirectorySection(planType, memberType, identifier).get(2).isDisplayed());

		}

		if ((identifier.contains("UHC") && memberType.contains("Individual")) || identifier.contains("PCP")
				|| identifier.contains("Medica"))// decrementing the index by 1 as ANOC doesn't appear for this
			t = 1;

		Assert.assertTrue("jmpLinkTo Annual Directories/Annual Directory isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(3 - t).isDisplayed());

		Assert.assertTrue("jmpLinkToMyDocuments isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(4 - t).isDisplayed());

		Assert.assertTrue("jmpLinkToExplanationofBenefits(EOB) isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(5 - t).isDisplayed());

		Assert.assertTrue("jmpLinkToForms&Resources isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(6 - t).isDisplayed());

		Assert.assertTrue("jmpLinkToRenewMagazine isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(7 - t).isDisplayed());

		System.out.println("All Jump links are displayed for the MAPD Plan");
		System.out.println(jumpLinksGroup);

	}

	public void clicksOnJumpLinksAndCheckRespectiveSectionsMAPD(String rider, String planType, String memberType,
			String identifier) {

		int t = 0;
		if ((identifier.contains("UHC") && memberType.contains("Individual")) || identifier.contains("PCP")
				|| identifier.contains("Medica"))// decrementing the index by 1 as ANOC doesn't appear for this
			t = 1; // decrementing the index by 1 as ANOC doesn't appear for this

		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(0),
				getPlanMaterialHeaderSection());
		if ((identifier.toString().trim().contains("UHC") || identifier.toString().trim().contains("PCP")
				|| identifier.toString().trim().contains("Medica"))
				&& memberType.toString().trim().contains("Individual")) {

		} else {

			if (identifier.toString().trim().contains("AARP") && memberType.toString().trim().contains("Individual"))
				clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(2),
						getAnocHeaderSection().get(1)
						);

			if (identifier.toString().trim().contains("UHC") && memberType.toString().trim().contains("Group"))
				clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(2),
						getAnocHeaderSection().get(2)
						);

		}

		if (memberType.toString().trim().contains("Group"))
			clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(3),
					getAnnualdirectoriesHeaderSectionMAPDGRP());
		else
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(3 - t),
					getAnnualdirectoriesHeaderSection());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(4 - t),
				getMyDocumentSection());

		if ( (memberType.toString().trim().contains("Individual") && (identifier.contains("UHC") )))
			clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(5 - t),
					getEobHeaderSection().get(5));
		
		if (memberType.toString().trim().contains("Group") && (identifier.contains("UHC") || identifier.toString().trim().contains("PCP")
						|| identifier.toString().trim().contains("Medica")))
			clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(5 - t),
					getEobHeaderSection().get(6));
		else
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(5),
				//	getEobHeaderSection().get(5));

		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(6 - t),
				getFormsandResourcesSection());

		if (memberType.toString().trim().contains("Group"))
			clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(7),
					getRenewMagazineSectionHeader().get(3));
		else if ((identifier.contains("UHC") || identifier.toString().trim().contains("PCP")
				|| identifier.toString().trim().contains("Medica")) && memberType.contains("Individual"))
			clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(7 - t),
					getRenewMagazineSectionHeader().get(2));
		else
			clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(7),
					getRenewMagazineSectionHeader().get(0));

		System.out.println("All sections are present for the MAPD Plan");

	}

	private FormsAndResourcesPage SystemOutPrintln() {
		// TODO Auto-generated method stub
		return null;
	}

	// For MA Plan
	public void verifyPresenceOfJumpLinksMA(String rider, String planType, String memberType, String identifier) {
		CommonUtility.waitForPageLoad(driver, myDocumentSection, 30);

		Assert.assertTrue("jmpLinkToPLANMATERIALS isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(0).isDisplayed());

		if (identifier.contains("GrpEffectiveUHC")){
				if(getDirectorySection(planType, memberType, identifier).get(1).isDisplayed()){
					System.out.println("Member is in the first year of membership");}
					else{
						if(getDirectorySection(planType, memberType, identifier).get(2).isDisplayed()){
							System.out.println("membership is more than one year old, So ANoc Section appeared ");
						}
						
				}
		}
		
		
		Assert.assertTrue("jmpLinkToProviderDirectory isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(3).isDisplayed());

		Assert.assertTrue("jmpLinkToMyDocuments isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(4).isDisplayed());

		Assert.assertTrue("jmpLinkToExplanationofBenefits(EOB) isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(5).isDisplayed());

		Assert.assertTrue("jmpLinkToForms&Resources isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(6).isDisplayed());

		Assert.assertTrue("jmpLinkToRenewMagazine isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(7).isDisplayed());

		System.out.println("All Jump links are displayed for the MA Plan");

	}
	
	public   void validatePlanMaterial(String planType, String memberType,
			String identifier) {
		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(0),    
					getPlanMaterialHeaderSection());   // PLAN MATERIAL (No Index Needed)
	}

	public void validateAnocDocument(int jumlinkIndex,String planType, String memberType,
			String identifier) {
		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(2),
						getAnocHeaderSection().get(jumlinkIndex)); // ANOC Section
	}

	public void validateProviderDirectory(int jumlinkIndex,String planType, String memberType,
			String identifier) {
		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(3),
					getAnnualdirectoriesHeaderSectionMA().get(jumlinkIndex));   // Provider Directory
	}
	public void validateMyDocument(String planType, String memberType,
			String identifier){
		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(4),
					getMyDocumentSection());   // My Document (No Index Needed)
	}
	public void validateEOB(int jumlinkIndex,String planType, String memberType,
			String identifier){
		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(5), 
						getEobHeaderSection().get(jumlinkIndex));  //  EOB 
	}
	
	public void validateFormsandResources(String planType, String memberType,
			String identifier){
		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(6),
					getFormsandResourcesSection()); // Forms Resources (No Index Needed)
	}
	public void validateRenewMagazine(int jumlinkIndex,String planType, String memberType,
			String identifier){
		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(7),
						getRenewMagazineSectionHeader().get(jumlinkIndex)); // Renew Magazine
	}

	
public void clicksOnJumpLinksAndCheckRespectiveSectionsMA(String rider,String planType, String memberType,
		String identifier) throws InterruptedException {
		
		if (identifier.equalsIgnoreCase("IndEffectiveAARP"))   { 
			String targetPlanType="MA";
			String targetMemberType="Individual_FormsResources";
			String targetIdentifier="IndEffectiveAARP";
			// Individual AARP Users Returns 7 Jumplinks; The numbers represent the index numbers (jumplink index)in the List WebElement
			
		
			validatePlanMaterial(targetPlanType,targetMemberType,targetIdentifier);
			Thread.sleep(5000);
			validateAnocDocument(1,targetPlanType,targetMemberType,targetIdentifier); //note: first parameter is the jumplink index
			Thread.sleep(5000);
			validateProviderDirectory(1,targetPlanType,targetMemberType,targetIdentifier);
			Thread.sleep(5000);
			validateMyDocument(targetPlanType,targetMemberType,targetIdentifier);
			Thread.sleep(5000);
			validateEOB(0,targetPlanType,targetMemberType,targetIdentifier);  //  0 for rider
			Thread.sleep(5000);
			validateFormsandResources(targetPlanType,targetMemberType,targetIdentifier);
			Thread.sleep(5000);
			validateRenewMagazine(0,targetPlanType,targetMemberType,targetIdentifier);  
			System.out.println("All sections are present for the MA Plan");
			}
			
		if (identifier.contains("IndEffectiveAARP_NR"))   { 
			String targetPlanType="MA";
			String targetMemberType="Individual_FormsResources";
			String targetIdentifier="IndEffectiveAARP_NR";
			// Individual AARP Users Returns 7 Jumplinks; The numbers represent the index numbers (jumplink index)in the List WebElement
			
		
			validatePlanMaterial(targetPlanType,targetMemberType,targetIdentifier);
			Thread.sleep(5000);
			validateAnocDocument(1,targetPlanType,targetMemberType,targetIdentifier); //note: first parameter is the jumplink index
			Thread.sleep(5000);
			validateProviderDirectory(1,targetPlanType,targetMemberType,targetIdentifier);
			Thread.sleep(5000);
			validateMyDocument(targetPlanType,targetMemberType,targetIdentifier);
			Thread.sleep(5000);
			validateEOB(1,targetPlanType,targetMemberType,targetIdentifier);  // its 1 for the no rider index,
			Thread.sleep(5000);
			validateFormsandResources(targetPlanType,targetMemberType,targetIdentifier);
			Thread.sleep(5000);
			validateRenewMagazine(0,targetPlanType,targetMemberType,targetIdentifier);  
			System.out.println("All sections are present for the MA Plan");
			}	
		
		if (identifier.contains("GrpEffectiveUHC"))   { 
			String targetPlanType="MA";
			String targetMemberType="Individual_FormsResources";
			String targetIdentifier="GrpEffectiveUHC";
			// Individual AARP Users Returns 7 Jumplinks; The numbers represent the index numbers (jumplink index)in the List WebElement
			//note: first parameter is the jumplink index
		
			validatePlanMaterial(targetPlanType,targetMemberType,targetIdentifier);
			Thread.sleep(5000);
			validateAnocDocument(2,targetPlanType,targetMemberType,targetIdentifier); 
			Thread.sleep(5000);
			validateProviderDirectory(1,targetPlanType,targetMemberType,targetIdentifier);
			Thread.sleep(5000);
			validateMyDocument(targetPlanType,targetMemberType,targetIdentifier);
			Thread.sleep(5000);
			validateEOB(1,targetPlanType,targetMemberType,targetIdentifier);  // its 1 for the no rider index,
			Thread.sleep(5000);
			validateFormsandResources(targetPlanType,targetMemberType,targetIdentifier);
			Thread.sleep(5000);
			validateRenewMagazine(3,targetPlanType,targetMemberType,targetIdentifier);  
			System.out.println("All sections are present for the MA Plan");
			}		
		if (identifier.contains("IndEffectiveUHC"))   { 
			String targetPlanType="MA";
			String targetMemberType="Individual_FormsResourcesl";
			String targetIdentifier="IndEffectiveUHC";
			// Individual AARP Users Returns 7 Jumplinks; The numbers represent the index numbers (jumplink index)in the List WebElement
			
		
			validatePlanMaterial(targetPlanType,targetMemberType,targetIdentifier);
			Thread.sleep(5000);
			validateAnocDocument(2,targetPlanType,targetMemberType,targetIdentifier); //note: first parameter is the jumplink index
			Thread.sleep(5000);
			validateProviderDirectory(1,targetPlanType,targetMemberType,targetIdentifier);
			validateMyDocument(targetPlanType,targetMemberType,targetIdentifier);
			Thread.sleep(5000);
			validateEOB(0,targetPlanType,targetMemberType,targetIdentifier);  // its 1 for the no rider index,
			Thread.sleep(5000);
			validateFormsandResources(targetPlanType,targetMemberType,targetIdentifier);
			Thread.sleep(5000);
			validateRenewMagazine(3,targetPlanType,targetMemberType,targetIdentifier);  
			System.out.println("All sections are present for the MA Plan");
			}
		}

	private void clicksOnLinkAndBackToTop(WebElement element_1, boolean contains) {
		// TODO Auto-generated method stub
		
	}

	// MedSupp

	public void verifyPresenceOfJumpLinksMedSupp(String rider, String planType, String memberType, String identifier) {
		CommonUtility.waitForPageLoad(driver, getDirectorySection(planType, memberType, identifier).get(0), 15);

		Assert.assertTrue("jmpLinkToPlanMaterials isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(0).isDisplayed());

		Assert.assertTrue("jmpLinkToExplanationOfBenefits isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(1).isDisplayed());

		Assert.assertTrue("jmpLinkToForms&Resources isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(2).isDisplayed());

		System.out.println("All Jump links are displayed for the MedSupp Plan");

	}

	public void clicksOnJumpLinksAndCheckRespectiveSectionsMedSupp(String rider, String planType, String memberType,
			String identifier) throws InterruptedException {
System.out.println("Tamzid - 1");
System.out.println("Tamzid - 11 getDirectorySection(planType, memberType, identifier).get(0)="+getDirectorySection(planType, memberType, identifier).get(0));
		if (planType.equalsIgnoreCase("MedSupp")) {
			System.out.println("Tamzid - 13 getLstPlanMaterialHeaderSection_medSupp().get(0)="+getLstPlanMaterialHeaderSection_secondary().get(0));
			clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(0),
					getLstPlanMaterialHeaderSection_secondary().get(0));
		} else {
			System.out.println("Tamzid - 12 getLstPlanMaterialHeaderSection().get(0)="+getLstPlanMaterialHeaderSection().get(0));
			clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(0),
					getLstPlanMaterialHeaderSection().get(0));
		}
		
		
System.out.println("Tamzid - 2");
		Thread.sleep(5000);
		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(1),
				getEobHeaderSection().get(2));
		System.out.println("Tamzid - 3");
		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(2),
				getFormsandResourcesSection());
		System.out.println("Tamzid - 4");

		System.out.println("All sections are present for the MedSupp Plan");

	}

	// PDP

	public void verifyPresenceOfJumpLinksPDP(String rider, String planType, String memberType, String identifier) {
		CommonUtility.waitForPageLoad(driver, myDocumentSection, 15);

		Assert.assertTrue("jmpLinkToPlanMaterials isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(0).isDisplayed());

		//Assert.assertTrue("jmpLinkToWelcomeGuide isn't displayed",
				if(getDirectorySection(planType, memberType, identifier).get(1).isDisplayed()){
					System.out.println("member is 1st year of serveice, so welcome guide is displayed");}
					else
						System.out.println("Welcome guide not present Due to member is more then 1 year old in his/her plan service");
				

		Assert.assertTrue("jmpLinkToANNUALNOTICEOFCHANGESDOCUMENTS isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(2).isDisplayed());
		Assert.assertTrue("jmpLinkToPHARMACYDIRECTORIY isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(3).isDisplayed());
		Assert.assertTrue("jmpLinkToMYDOCUMENTS isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(4).isDisplayed());
		Assert.assertTrue("jmpLinkToEOB isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(5).isDisplayed());
		Assert.assertTrue("jmpLinkToFORMS&RESOURCES isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(6).isDisplayed());
		if(memberType.equalsIgnoreCase("Group_FormsResources")){
		
				//Do Nothing
		}else
			Assert.assertTrue("jmpLinkToRENEWMAGAZINE isn't displayed",
					getDirectorySection(planType, memberType, identifier).get(7).isDisplayed());

//		if (memberType.contains("Group")) {
//			// do noting
//		} else
//			Assert.assertTrue("jmpLinkToRENEWMAGAZINE isn't displayed",
//					getDirectorySection(planType, memberType, identifier).get(7).isDisplayed());

		System.out.println("All Jump links are displayed for the PDP Plan");

	}

	public void clicksOnJumpLinksAndCheckRespectiveSectionsPDP(String rider, String planType, String memberType,
			String identifier) {

		System.out.println("Tamzid - 2");
		System.out.println("Tamzid - 22  getDirectorySection(planType, memberType, identifier).get(0)="+getDirectorySection(planType, memberType, identifier).get(0));
				if (planType.equalsIgnoreCase("PDP")) {
					System.out.println("Tamzid  PDP");
					clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(0),
							getLstPlanMaterialHeaderSection_secondary().get(0));
				} else {
					System.out.println("Tamzid - 12 getLstPlanMaterialHeaderSection().get(0)="+getLstPlanMaterialHeaderSection().get(0));
					clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(0),
							getLstPlanMaterialHeaderSection().get(0));
				}
	//	clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(0),
//				
//				
//				getLstPlanMaterialHeaderSection().get(0));
		
		
//		
		//clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(1), // member ship material doesnt exists for member more then 1 year old
				//getMembershipMaterialHeaderSection().get(0));
System.out.println(memberType);
		if (memberType.contains("Group"))
			clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(2),
					getAnocHeaderSection().get(2));
		else
			System.out.println("Tamzid - 1");
		System.out.println("Tamzid - 11 getDirectorySection(planType, memberType, identifier).get(0)="+getDirectorySection(planType, memberType, identifier).get(0));
				if (memberType.equalsIgnoreCase("Individual_FormsResources")) {
					System.out.println("Tamzid - 13");
					clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(0),
							getAnocHeaderSection_alt().get(0));
				} else {
					System.out.println("Tamzid - 13 - Anoc Section");
					clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(2),
							getAnocHeaderSection().get(2));
				}

		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(3),
				getAnnualDirectorySection(memberType));

		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(4), getMyDocumentSection());
		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(5),
				getEobHeaderSection().get(3));
		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(6),
				getFormsandResourcesSection());
		if (memberType.contains("Group")) {
			// do noting
		} else
			clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(7),
					getRenewMagazineSectionHeader());
		System.out.println("All sections are present for the PDP Plan");
		/*
		 * if (Identifier.contains("UHC")) {
		 * clicksOnLinkAndBackToTop(getJmpLinkToDrugCopaysAndDiscountsPDPUHC(),
		 * getDrugCopaysAndDiscountsSectionHeader());
		 * clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResourcesPDPUHC(),
		 * getPlanDocumentsAndResourcesSectionHeader()); } else {
		 * 
		 * clicksOnLinkAndBackToTop(getJmpLinkToDrugCopaysAndDiscountsPDP(),
		 * getDrugCopaysAndDiscountsSectionHeader());
		 * clicksOnLinkAndBackToTop(getJmpLinkToDrugCoveragePDP(),
		 * getDrugCoverageSectionHeader());
		 * clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResourcesPDP(),
		 * getPlanDocumentsAndResourcesSectionHeader());
		 * clicksOnLinkAndBackToTop(getJmpLinkToWaysToSaveMoneyPDP(),
		 * getWaysToSaveMoneySectionHeader()); }
		 * System.out.println("All sections are present for the PDP Plan");
		 */

	}

	// SSUP
	public void verifyPresenceOfJumpLinksSSUP(String rider, String planType, String memberType, String identifier) {
		CommonUtility.waitForPageLoad(driver, myDocumentSection, 15);

		Assert.assertTrue("jmpLinkToPlanMaterials isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(0).isDisplayed());
		if(planType.contains("SSUP")){
			System.out.println("Membership material doesn't exists for ssup users");
		}else
		{
			Assert.assertTrue("jmpLinkToMEMBERSHIPMATERIALS isn't displayed",
					getDirectorySection(planType, memberType, identifier).get(1).isDisplayed());
		}
		Assert.assertTrue("jmpLinkToMYDOCUMENTS isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(2).isDisplayed());
		Assert.assertTrue("jmpLinkToFORMS&RESOURCES isn't displayed",
				getDirectorySection(planType, memberType, identifier).get(4).isDisplayed());

		System.out.println("All Jump links are displayed for SSUP Plan");

	}

	public void clicksOnJumpLinksAndCheckRespectiveSectionsSSUP(String rider, String planType, String memberType,
			String identifier) {

		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(0),
				getLstPlanMaterialHeaderSection().get(0));
		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(1),
				getMembershipMaterialHeaderSection().get(0));
		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(2), getMyDocumentSection());
		clicksOnLinkAndBackToTop(getDirectorySection(planType, memberType, identifier).get(4),
				getFormsandResourcesSection());

		/*
		 * clicksOnLinkAndBackToTop(getJmpLinkToMedicalCopaysOrCoinsuranceSSUP(),
		 * getCopayscoinsuranceheader());
		 * clicksOnLinkAndBackToTop(getJmpLinkToOutofPocketMaximumSSUP(),
		 * getOutOfPocketSectionHeader());
		 * 
		 * 
		 * if(memberType.equalsIgnoreCase("Individual"))
		 * clicksOnLinkAndBackToTop(getJmpLinkToPrimaryCareProviderSSUP(),
		 * getPrimaryCareProviderHeaderInd()); else
		 * 
		 * clicksOnLinkAndBackToTop(getJmpLinkToPrimaryCareProviderSSUP(),
		 * getPrimaryCareProviderSectionHeaderGroup());
		 * 
		 * clicksOnLinkAndBackToTop(getJmpLinkToPlanDocumentsAndResourcesSSUP(),
		 * getPlanDocumentsAndResourcesSectionHeader());
		 * System.out.println("All sections are present for SSUP Plan");
		 */

	}

	// SSUP ends here

	public void verifyElementPresence(WebElement element) {
		Assert.assertTrue("Section/Link isn't displayed", element.isDisplayed());
		System.out.println(element.getText());
	}

	public void verifyElementPresence(List<WebElement> element) {
		Assert.assertTrue("Section/Link isn't displayed",
				element.get(0).isDisplayed() || element.get(1).isDisplayed() || element.get(2).isDisplayed());
		try {
			if (element.get(0).isDisplayed())
				System.out.println(element.get(0).getText());
		} catch (Exception ex) {
			try {
				if (element.get(1).isDisplayed())
					System.out.println(element.get(0).getText());

			} catch (Exception e) {
				if (element.get(2).isDisplayed())
					System.out.println(element.get(0).getText());

			}

		}
	}

	public void clicksOnLinkAndBackToTop(WebElement element_1, List<WebElement> element_2) {
		element_1.click();

		try {
			Thread.sleep(1000); // Added sleep to mimic user interaction
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verifyElementPresence(element_2);
		try {
			getLinkBackToTop_copy().click();
		} catch (Exception ex) {
			getLinkBackToTop().click();

		}
		try {
			Thread.sleep(1000); // Added sleep to mimic user interaction
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void clicksOnLinkAndBackToTop(WebElement element_1, WebElement element_2) {
		element_1.click();

		try {
			Thread.sleep(1000); // Added sleep to mimic user interaction
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		verifyElementPresence(element_2);
		try {
			getLinkBackToTop_copy().click();
		} catch (Exception ex) {
			getLinkBackToTop().click();

		}
		try {
			Thread.sleep(1000); // Added sleep to mimic user interaction
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void directoryLinksCount(int linkCount, String rider, String planType, String memberType,
			String identifier) {
		int count = 0;

		if (planType.equalsIgnoreCase("MedSupp") || planType.equalsIgnoreCase("PDP"))
			count = getDirectorySection(planType, memberType, identifier).size();
		else
			count = getDirectorySection(planType, memberType, identifier).size() - 1;

		/*
		 * if (identifier.toString().trim().contains("UHC") &&
		 * memberType.toString().trim().contains("Individual")) count =
		 * getDirectorySection(planType, memberType,identifier).size() - 2; else
		 */

		/*
		 * if (planType.equals("MA") || planType.equals("MAPD")) { if
		 * (memberType.equalsIgnoreCase("Individual")) {
		 * 
		 * count = getDirectorySection(planType, memberType).size() - 1; if
		 * (rider.toString().trim().equals("Rider")) count += 1;
		 * 
		 * } else if (memberType.equalsIgnoreCase("Group")) { if
		 * (planType.equals("MAPD")) count = getDirectorySection(planType,
		 * memberType).size(); else count = getDirectorySection(planType,
		 * memberType).size()-1; } else count = getDirectorySection(planType,
		 * memberType).size(); } else count = getDirectorySection(planType,
		 * memberType).size();
		 */
		System.out.println("The link count is " + count);
		Assert.assertTrue("Irrelevant links are present", count == linkCount);
		System.out.println("No irrelevant links found");

	}

	public pages.memberrdesignVBF.ProviderSearchPage validateFindCareUrl() {
		// TODO Auto-generated method stub
		
		validateNew(jumpLinkToProviderAndPharmacyDirectories);
		jumpLinkToProviderAndPharmacyDirectories.click();
		validateNew(ProviderSearchLinkPCPMedica);
		ProviderSearchLinkPCPMedica.click();
		if (driver.getCurrentUrl().contains("pcp/find-care"))
		{
			Assert.assertTrue(true);
			return new pages.memberrdesignVBF.ProviderSearchPage(driver);
		}
		return null;
	}
	
	public void verifyPreeffectiveshipPlan(Map<String, String> memberAttributesMap) {

		String PlanName = memberAttributesMap.get("ShipPreEffe PlanName");
		String CovDate = memberAttributesMap.get("Coverge Date");
		System.out.println("Ship Pre effective Plan name is : " + preEffecShipPlanName.getText());
		Assert.assertEquals(preEffecShipPlanName.getText().trim(), PlanName);
		System.out.println("Ship Pre Effective Plan name is Displayed : " + PlanName);
		System.out.println("Coverage Date is : " + preEffectiveCoverageDate.getText().trim());
		Assert.assertEquals(preEffectiveCoverageDate.getText().trim(), CovDate);
		System.out.println("Ship Pre Effective Coverage Date is : " + preEffectiveCoverageDate.getText().trim());
	}

	public void verifyPreeffectiveshipPlanforCombo(Map<String, String> memberAttributesMap) {

		String PlanName = memberAttributesMap.get("ShipPreEffe PlanName");
		String CovDate = memberAttributesMap.get("Coverge Date");
		System.out.println("Ship Pre effective Plan name is : " + preEffecShipPlanNameCombo.getText());
		Assert.assertEquals(preEffecShipPlanNameCombo.getText().trim(), PlanName);
		System.out.println("Ship Pre Effective Plan name is Displayed : " + PlanName);
		System.out.println("Coverage Date is : " + preEffectiveComboCoverageDate.getText().trim());
		Assert.assertEquals(preEffectiveComboCoverageDate.getText().trim(), CovDate);
		System.out.println("Ship Pre Effective Coverage Date is : " + preEffectiveComboCoverageDate.getText().trim());
	}

	public void verifypreEffShipOderplanNotDisplay() {
		if (!(preEffecShipOrderPlan.isDisplayed())) {
			System.out.println("OrderPlan Materials is not displayed for pre Effective ship Plan");
			Assert.assertTrue(true);
		} else
			Assert.fail("OrderPlan Materials is displayed for pre Effective ship Plan");
	}

	public void verifypreEffShipOderplanNotDisplayforCombo() {
		if (!(preEffecShipOrderPlan.isDisplayed())) {
			System.out.println("OrderPlan Materials is not displayed for pre Effective ship Plan");
			Assert.assertTrue(true);
		} else
			Assert.fail("OrderPlan Materials is displayed for pre Effective ship Plan");
	}

	public void validateSegmentId(String planType, String memberType, String expectedSegmentId) {
		String lookForPlanCategory="";
		boolean isComboUser=false;
		if (memberType.toUpperCase().contains("COMBO"))
			isComboUser=true;
		if (planType.equalsIgnoreCase("SHIP"))
			lookForPlanCategory="MEDICARE SUPPLEMENT";
		else if (planType.equalsIgnoreCase("SSUP")) 
			lookForPlanCategory="SSP";
		else if (planType.equalsIgnoreCase("PCP") || planType.equalsIgnoreCase("MEDICA")) 
			lookForPlanCategory="MAPD";
		else 
			lookForPlanCategory=planType;

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String consumerDetails=getConsumerDetailsFromlocalStorage();
		String actualSegmentId=getSegmentIdInConsumerDetails(isComboUser, lookForPlanCategory, consumerDetails);
		Assert.assertTrue("PROBLEM - not getting expected SegmentId for plan '"+planType+"'. "
				+ "Expected='"+expectedSegmentId+"' | Actual='"+actualSegmentId+"'", 
				expectedSegmentId.equals(actualSegmentId));
	}

	public String getConsumerDetailsFromlocalStorage() {
		WebStorage webStorage = (WebStorage) new Augmenter().augment(driver) ;
		LocalStorage localStorage = webStorage.getLocalStorage();
		String consumerDetails=localStorage.getItem("consumerDetails");
		return consumerDetails;
	}
	
	public String getSegmentIdInConsumerDetails(boolean isComboUser, String lookForPlanCategory, String consumerDetails) {
		String actualSegmentId=null;
		try {
			JSONObject jsonObj = new JSONObject(consumerDetails);
			JSONArray arr =jsonObj.getJSONArray("planProfiles");
			if (isComboUser) 
				Assert.assertTrue("PROBLEM - test data expect this user to be a combo user "
						+ "but the localStorage.consumerDetails has only one planProfiles.  "
						+ "Please double check and correct test data", arr.length()>1);
			for (int i = 0; i < arr.length(); i++) {
				String actualPlanCategory = arr.getJSONObject(i).getString("planCategory");
				//note: need to locate the right plan for segmentId validation
				//System.out.println("test is looking for plan='"+lookForPlanCategory+"' | user has planCategory="+actualPlanCategory);
				if (lookForPlanCategory.equals(actualPlanCategory)) {
					actualSegmentId = arr.getJSONObject(i).getString("segmentId");
				}
			}
			Assert.assertTrue("PROBLEM - unable to locate segmentId from localStorage.consumerDetails", 
					actualSegmentId!=null);
		} catch (JSONException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - encounted problem reading the json result from localStorage.consumerDetails", false);
		}
		return actualSegmentId;
	}
	
	public void validateAnocSectionContent(String planType, String memberType, int targetYear, 
			boolean expectAnocSection, boolean exptYearSubSection,
			String expected_anocPdfCode, String expected_eocPdfCode, String expected_cfPdfCode) {
		System.out.println("TEST - memberType="+memberType);
		if (!expectAnocSection || memberType.contains("Term") || memberType.contains("PreEff")  
				|| planType.equalsIgnoreCase("SHIP")) {
			Assert.assertTrue("PROBLEM - should not be able to locate Annal Notice of Changes Documents section for Pre-effective or Terminated user", !fnrValidate(anocSection, 2));
			return;
		} 
		Assert.assertTrue("PROBLEM - unable to locate Annal Notice of Changes Documents section", validate(anocSection)); 
		
		/* tbd
		String targetYearAnocSectionXpath="//div[contains(@class,'ANOC') and not(contains(@class,'ng-hide'))]//div[@class='sectionWise_div_"+targetYear+"']";
		String targetYearAnocXpath="//div[contains(@class,'ANOC_IND_TwoYears') and not(contains(@class,'ng-hide'))]//div[contains(@class,'planbenefitdocuments_"+targetYear+"')]//a[contains(text(),'Annual Notice of Changes')]//parent::li";
		String targetYearCoeDocXpath="//div[contains(@class,'ANOC_IND_TwoYears') and not(contains(@class,'ng-hide'))]//div[contains(@class,'planbenefitdocuments_"+targetYear+"')]//a[contains(text(),'Evidence Of Coverage') or contains(text(),'Evidence of Coverage')]//parent::li";
		String targetYearCfXpath="//div[contains(@class,'ANOC_IND_TwoYears') and not(contains(@class,'ng-hide'))]//div[contains(@class,'planbenefitdocuments_"+targetYear+"')]//a[contains(text(),'Comprehensive Formulary')]//parent::li";
		*/
		String targetYearAnocSectionXpath="//div[contains(@class,'annualNotice') and not(contains(@class,'ng-hide'))]//div[@class='sectionWise_div_"+targetYear+"']";
		String targetYearAnocXpath=targetYearAnocSectionXpath+"//a[contains(text(),'Annual Notice of Changes')]//parent::li";
		String targetYearCoeDocXpath=targetYearAnocSectionXpath+"//a[contains(text(),'Evidence Of Coverage') or contains(text(),'Evidence of Coverage')]//parent::li";
		String targetYearCfXpath=targetYearAnocSectionXpath+"//a[contains(text(),'Comprehensive Formulary')]//parent::li";
		
		if (exptYearSubSection) {
			try {
				WebElement exp_YrAnocSecElement=driver.findElement(By.xpath(targetYearAnocSectionXpath));
				Assert.assertTrue("PROBLEM - unable to locate '"+targetYear+"' year ANOC section", validate(exp_YrAnocSecElement));
			} catch (NoSuchElementException nse) {
				Assert.assertTrue("PROBLEM - unable to locate '"+targetYear+"' year ANOC section", false);
			}
		} else {
			try {
				WebElement exp_YrAnocSecElement=driver.findElement(By.xpath(targetYearAnocSectionXpath));
				Assert.assertTrue("PROBLEM - do not expect to locate "+targetYear+" year ANOC section", !fnrValidate(exp_YrAnocSecElement, 2));
			} catch (NoSuchElementException nse) {
				Assert.assertTrue("PROBLEM - do not expect to locate "+targetYear+" year ANOC section", true);
			}
		}

		String docName="Annual Notice of Changes";
		validatePdfCode(expected_anocPdfCode, targetYearAnocXpath, targetYear, docName);
		
		docName="Evidence Of Coverage";
		validatePdfCode(expected_eocPdfCode, targetYearCoeDocXpath, targetYear, docName);
		
		docName="Comprehensive Formulary";
		validatePdfCode(expected_cfPdfCode, targetYearCfXpath, targetYear, docName);
	}

	public void validatePdfCode(String expected_PdfCode, String targetYearXpath, int targetYear, String docName) {
		if (expected_PdfCode.equals("NA")) {
			try {
				WebElement exp_yrDocElement=driver.findElement(By.xpath(targetYearXpath));
				Assert.assertTrue("PROBLEM - should not be able to locate '"+targetYear+"' year "+docName+" doc", !fnrValidate(exp_yrDocElement, 2));
			} catch (NoSuchElementException nse) {
				Assert.assertTrue("PROBLEM - should not be able to locate '"+targetYear+"' year "+docName+" doc", true);
			}
		} else {
			try {
				WebElement exp_yrDocElement=driver.findElement(By.xpath(targetYearXpath));
				Assert.assertTrue("PROBLEM - unable to locate '"+targetYear+"' year "+docName+" doc", validate(exp_yrDocElement));

				String actual_pdfCode=exp_yrDocElement.getAttribute("id");
				System.out.println("TEST - "+docName+" pdf="+actual_pdfCode);
				Assert.assertTrue("PROBLEM - '"+docName+"' pdf code is not as expected. Expected='"+expected_PdfCode+"' | Actual='"+actual_pdfCode+"'", expected_PdfCode.equals(actual_pdfCode));
			} catch (NoSuchElementException nse) {
				Assert.assertTrue("PROBLEM - unable to locate '"+targetYear+"' year "+docName+" doc", false);
			}
		}
	}
	
	/**
	 * to validate whether element exists with input timeout value control
	 * note: use this instead of the one from UhcDriver which takes up to 30 sec to timeout
	 * @param element
	 * @param timeoutInSec
	 * @return
	 */
	public boolean fnrValidate(WebElement element, int timeoutInSec) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeoutInSec);
			wait.until(ExpectedConditions.visibilityOf(element));
			if (element.isDisplayed()) {
				System.out.println("Element found!!!!");
				return true;
			} else {
				System.out.println("Element not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Exception: Element not found/not visible. Exception message - "+e.getMessage());

		}
		return false;
	}
/* tbd 
	@FindBy(xpath = "//a[@id='myDocButtonText']")
	public WebElement myDocumentsButton;

	public MyDocumentsPage navigateToMyDocumentsPage() {
	
		myDocumentsButton.click();
		if (MRScenario.environment.contains("team-atest")) {
			try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Check if Alert popup present...if yes, handle it...");
			isAlertPresent();
		}
		CommonUtility.checkPageIsReady(driver);
		if (driver.getCurrentUrl().contains("/my-documents/")){
				return new MyDocumentsPage(driver);
	     }
			 return null;
			
	}
*/	
	public boolean isAlertPresent() {
		try {
				Alert alert = driver.switchTo().alert();
				alert.accept();
				System.out.println("Detected Alert popup, accept it and move on...");
		} catch (NoAlertPresentException Ex) {
			System.out.println("DID NOT detect Alert popup, move on...");
			return false;
		}
		return true;
	}
	
	public void verifyPaymentTabIsDisplayedForPreEffectiveMembers() {
		
		if(pymtTabTopMenu.isDisplayed())
		{
			System.out.println("Premium Payment tab was displayed on secondary page - Forms and Resources, Test Passed");
		}
		else
		{
			Assert.fail("Premium Payment tab was NOT displayed on secondary page - Forms and Resources, Test FAILED");
		}
	}
	
	public PaymentHistoryPage userClicksOnPremiumPaymentFromFormsAndResources() {

		try {
			System.out.println("Now clicking on Premium Payment tab");
			pymtTabTopMenu.click();
			System.out.println("Premium Payment tab has been clicked");
			CommonUtility.checkPageIsReadyNew(driver);
			Thread.sleep(4000);
			System.out.println("Current URL is: " + driver.getCurrentUrl());
			if (driver.getCurrentUrl().contains("payments")) {
				System.out.println("payments text was returned in URL , returning PaymentHistoryPage");
				return new PaymentHistoryPage(driver);
			}
		}

		catch (Exception e) {
			Assert.fail("Premium Payment tab was NOT loaded when clicked from Forms and Resources, Test FAILED");
			return null;
		}
		return null;
	}

	public void verifyCorrectTechSupportNumberForPreEffectiveMembers(String technicalPhNo) throws InterruptedException

	{
		System.out.println("Now checking for Tech Support Number for Pre-effective members");
		System.out.println(
				"The Tech Support phone number displayed on screen is " + preEffectiveTechSupportNumber.getText());
		System.out.println("Expected Tech Support phone number from feature file is " + technicalPhNo);
		Assert.assertEquals(preEffectiveTechSupportNumber.getText(), technicalPhNo);
		System.out.println("Assert for correct Tech Suppport Phone Number  was passed");

	}

	public void navigateToSSUPTab() {
		TestHarness.checkForIPerceptionModel(driver);
		System.out.println("Now clicking on Group SSUP Plan Tab");
		try {
			SSUPTab.click();
			CommonUtility.checkPageIsReadyNew(driver);
			Thread.sleep(4000);
		} catch (Exception e) {
			System.out.println("SSUP Plan Tab was not displayed");
			Assert.fail("SSUP Plan Tab was not displayed");
		}
	}
}
