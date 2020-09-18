package pages.regression.planDocumentsAndResources;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import pages.regression.myDocumentsPage.MyDocumentsPage;

import org.openqa.selenium.support.PageFactory;

public class PlanDocumentsAndResourcesPage extends PlanDocumentsAndResourcesBase  {

	int forceTimeoutInMin=5;

	public PlanDocumentsAndResourcesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.checkPageIsReady(driver);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
	}

	@Override
	public void openAndValidate() throws InterruptedException {
		Assert.assertTrue("PROBLEM - unable to locate page header text element", planDocValidate(pageHeader));
	}

	PlanDocumentsAndResourcesPM planMaterials=new PlanDocumentsAndResourcesPM(driver);
	PlanDocumentsAndResourcesMM membershipMaterials=new PlanDocumentsAndResourcesMM(driver);
	PlanDocumentsAndResourcesANOC anoc=new PlanDocumentsAndResourcesANOC(driver);
	PlanDocumentsAndResourcesPD providerDirectories=new PlanDocumentsAndResourcesPD(driver);
	PlanDocumentsAndResourcesMD myDocuments=new PlanDocumentsAndResourcesMD(driver);
	PlanDocumentsAndResourcesFnR formsAndResources=new PlanDocumentsAndResourcesFnR(driver);
	PlanDocumentsAndResourcesEOB eob=new PlanDocumentsAndResourcesEOB(driver);
	PlanDocumentsAndResourcesRM renewMagazine=new PlanDocumentsAndResourcesRM(driver);
	PlanDocumentsAndResourcesNH needHelp=new PlanDocumentsAndResourcesNH(driver);

	public void validateJumplink_PM(boolean sectionDisplay) {
		planMaterials.validateJumplink_PM(sectionDisplay);
	}

	public void validateSectionHeader_PM(boolean sectionDisplay) {
		planMaterials.validateSectionHeader_PM(sectionDisplay);
	}

	public void valiateOrderPlanMaterialsLink_PM(HashMap<String, String> testInputInfoMap, boolean orderPlanMaterialsDisplay) {
		planMaterials.valiateOrderPlanMaterialsLink_PM(testInputInfoMap, orderPlanMaterialsDisplay);
	}

	public void valiateViewMemberIdCard_PM(HashMap<String, String> testInputInfoMap, boolean viewMemberCardIdDisplay) {
		planMaterials.valiateViewMemberIdCard_PM(testInputInfoMap, viewMemberCardIdDisplay);
	}

	public void validateDefaultLangSelect_PM(HashMap<String,String> testInputInfoMap, boolean sectionDisplay) {
		planMaterials.validateDefaultLangSelect_PM(testInputInfoMap, sectionDisplay);
	}

	public void validateFooter_PM(HashMap<String,String> testInputInfoMap) {
		planMaterials.validateFooter_PM(testInputInfoMap);
	}

	public void validateJumplink_MM(boolean sectionDisplay)  {
		membershipMaterials.validateJumplink_MM(sectionDisplay);
	}

	public void validateSectionHeader_MM(boolean sectionDisplay)  {
		membershipMaterials.validateSectionHeader_MM(sectionDisplay);
	}

	public void validateDefaultLangSelect_MM(boolean sectionDisplay) {
		membershipMaterials.validateDefaultLangSelect_MM(sectionDisplay);
	}

	public void validateJumplink_ANOC(boolean sectionDisplay)  {
		anoc.validateJumplink_ANOC(sectionDisplay);
	}

	public void validateSectionHeader_ANOC(boolean sectionDisplay, HashMap<String, Boolean> expectedDocTypeDisplayMap, HashMap<String, String> yearsMap)  {
		anoc.validateSectionHeader_ANOC(sectionDisplay, expectedDocTypeDisplayMap, yearsMap);
	}

	public void validateSectionHeader_ANOC_sanity(boolean sectionDisplay)  {
		anoc.validateSectionHeader_ANOC_sanity(sectionDisplay);
	}

	public void validateDefaultLangSelect_ANOC(boolean sectionDisplay)  {
		anoc.validateDefaultLangSelect_ANOC(sectionDisplay);
	}

	public void  validateJumplink_PD(boolean sectionDisplay) {
		providerDirectories.validateJumplink_PD(sectionDisplay);
	}

	public void validateSectionHeader_PD(HashMap<String, String> testInputInfoMap, boolean sectionDisplay, HashMap<String, Boolean> expectedDocTypeDisplayMap, HashMap<String, String> yearsMap) {
		providerDirectories.validateSectionHeader_PD(testInputInfoMap, sectionDisplay, expectedDocTypeDisplayMap, yearsMap);
	}
	
	public void validateSectionHeader_PD_sanity(HashMap<String, String> testInputInfoMap, boolean sectionDisplay) {
		providerDirectories.validateSectionHeader_PD_sanity(testInputInfoMap, sectionDisplay);
	}	

	public List<String> valiateProviderSearch_PD(HashMap<String, String> testInputInfoMap, boolean sectionDisplay)  {
		return providerDirectories.valiateProviderSearch_PD(testInputInfoMap, sectionDisplay);
	}	

	public List<String> valiatePharmacyLocator_PD(HashMap<String, String> testInputInfoMap, boolean sectionDisplay) {
		return providerDirectories.valiatePharmacyLocator_PD(testInputInfoMap, sectionDisplay);
	}	

	public void validateDefaultLangSelect_PD(HashMap<String, String> testInputInfoMap, boolean sectionDisplay) {
		providerDirectories.validateDefaultLangSelect_PD(testInputInfoMap, sectionDisplay);
	}	

	public void validateJumplink_MD(boolean sectionDisplay) {
		myDocuments.validateJumplink_MD(sectionDisplay);
	}	

	public void validateSectionHeader_MD(boolean sectionDisplay) {
		myDocuments.validateSectionHeader_MD(sectionDisplay);
	}	

	public void valiateSearchDocuments_MD(HashMap<String, String> testInputInfoMap, boolean sectionDisplay) {
		myDocuments.valiateSearchDocuments_MD(testInputInfoMap, sectionDisplay);
	}	

	public void validateJumplink_EOB(boolean sectionDisplay) {
		eob.validateJumplink_EOB(sectionDisplay);
	}	

	public void validateSectionHeader_EOB(boolean sectionDisplay) {
		eob.validateSectionHeader_EOB(sectionDisplay);
	}	

	public void valiateMedicalLnk_EOB(HashMap<String, String> testInputInfoMap, boolean searchMedicalEobHsitoryDisplay) {
		eob.valiateMedicalLnk_EOB(testInputInfoMap, searchMedicalEobHsitoryDisplay);
	}	

	public void valiateDrugLnk_EOB(HashMap<String, String> testInputInfoMap, boolean searchDrugEobHsitoryDisplay) {
		eob.valiateDrugLnk_EOB(testInputInfoMap, searchDrugEobHsitoryDisplay);
	}

	public void validateJumplink_FnR(boolean sectionDisplay) {
		formsAndResources.validateJumplink_FnR(sectionDisplay);
	}

	public void validateSectionHeader_FnR(boolean sectionDisplay) {
		formsAndResources.validateSectionHeader_FnR(sectionDisplay);
	}

	//------------------
	public List<String> validate_section_FnR(HashMap<String, String> testInputInfoMap) {
		return formsAndResources.validate_section_FnR(testInputInfoMap);
	}
	
	public List<String> validateDocs_FnR(HashMap<String, String> testInputInfoMap) {
		return formsAndResources.validateDocs_FnR(testInputInfoMap);
	}
	
	public void collapse_section_FnR(HashMap<String, String> testInputInfoMap) {
		formsAndResources.collapse_section_FnR(testInputInfoMap);
	}

	//------------------
	public void validateJumplink_RM(boolean sectionDisplay) {
		renewMagazine.validateJumplink_RM(sectionDisplay);
	}

	public void validateSectionHeader_RM(boolean sectionDisplay) {
		renewMagazine.validateSectionHeader_RM(sectionDisplay);
	}

	public void valiateCurrentIssue_RM(HashMap<String, String> testInputInfoMap, boolean sectionDisplay, String currentYear) {
		renewMagazine.valiateCurrentIssue_RM(testInputInfoMap, sectionDisplay, currentYear);
	}

	public void valiatePreviousIssue_RM(HashMap<String, String> testInputInfoMap, boolean sectionDisplay) {
		renewMagazine.valiatePreviousIssue_RM(testInputInfoMap, sectionDisplay);
	}

	public void validateAdobePdfDocText() {
		formsAndResources.validateAdobePdfDocText();
	}

	public String validateSectionInNeedHelp(String planType, String memberType) {
		return needHelp.validateSectionInNeedHelp(planType, memberType);
	}
	
	/**
	 * For MyDocument testing
	 */
	public MyDocumentsPage navigateToMyDocumentsPage() {
		checkModelPopup(driver,5);
		myDocumentLink_MD.click();
		if (MRScenario.environment.contains("team-atest")) {
			sleepBySec(8);
			System.out.println("Check if Alert popup present...if yes, handle it...");
			isAlertPresent();
		}
		CommonUtility.checkPageIsReady(driver);
		if (driver.getCurrentUrl().contains("/my-documents/")){
				return new MyDocumentsPage(driver);
	     }
		return null;
	}
	
	public boolean isMyDocumentSectionExist() {
		if (planDocValidate(myDocumentSection))
			return true;
		else 
			return false;
	}

	public void validateNEWTextAgainstPlanDocument() {
		Assert.assertTrue("PROBLEM - unable to locate NEW text against SHIP document", planDocValidate(newTextAgainstPlanDocument));
	}
}