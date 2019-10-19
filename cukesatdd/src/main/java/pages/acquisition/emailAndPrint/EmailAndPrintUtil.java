package pages.acquisition.emailAndPrint;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EmailAndPrintUtil extends EmailAndPrintUtilBase{

	public EmailAndPrintUtil(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	PlanSummaryEmailAndPrintUtil planSummaryEmailAndPrintUtil=new PlanSummaryEmailAndPrintUtil(driver);

	PlanCompareEmailAndPrintUtil planComapreEmailAndPrintUtil=new PlanCompareEmailAndPrintUtil(driver);
	
	PlanDetailsEmailAndPrintUtil planDetailsEmailAndPrintUtil=new PlanDetailsEmailAndPrintUtil(driver);

	public void validatePrintFunctionOnSummaryPage(String planType) {
		planSummaryEmailAndPrintUtil.validatePrintFunctionOnSummaryPage(planType);
	}
	
	public void validateEmailOptionExistOnSummaryPage(String planType) {
		planSummaryEmailAndPrintUtil.validateEmailOptionExistOnSummaryPage(planType);
	}
	
	public void validateEmailFunctionOnSummaryPage(String planType) {
		planSummaryEmailAndPrintUtil.validateEmailFunctionOnSummaryPage(planType);
	}	
	
	public HashMap<String, Integer> collectInfoVppPlanSummaryPg() {
		return planSummaryEmailAndPrintUtil.collectInfoVppPlanSummaryPg();
	}
	
	public String summary_comparePageItem(String targetKey, HashMap<String, Integer> origPage, HashMap<String, Integer> emailage) {
		return planSummaryEmailAndPrintUtil.summary_comparePageItem(targetKey, origPage, emailage);
	}
	
	public List<String> validatePlanSummaryEmailDeeplink(String planType, String deepLinkStringId, String infoMapStringId, String deepLink, HashMap<String, Integer> origPage) {
		return planSummaryEmailAndPrintUtil.validatePlanSummaryEmailDeeplink(planType, deepLinkStringId, infoMapStringId, deepLink, origPage);
	}
	
	public void clickOnBackToAllPlansFromCompareBackToSummaryPage() {
		planSummaryEmailAndPrintUtil.clickOnBackToAllPlansFromCompareBackToSummaryPage();
	}
	
	public boolean validateAllPlansCheckedOnSummaryPage(String plansForCompare) {
		return planSummaryEmailAndPrintUtil.validateAllPlansCheckedOnSummaryPage(plansForCompare);
	}
	
	public void validatingFunctionalityOfPrintOnPlanCompare(String planType) {
		planComapreEmailAndPrintUtil.validatingFunctionalityOfPrintOnPlanCompare(planType);
	}
	
	public HashMap<String, String> collectInfoVppPlanComparePg(String planType, String forWhat) {
		return planComapreEmailAndPrintUtil.collectInfoVppPlanComparePg(planType, forWhat);
	}
	
	public void validatePlanCompareEmailThankYouMessage() {
		planComapreEmailAndPrintUtil.validatePlanCompareEmailThankYouMessage();
	}
	
	public void validatePrintPlanCompare() {
		planComapreEmailAndPrintUtil.validatePrintPlanCompare();
	}
	
	public void validateEmailPlanCompare() {
		planComapreEmailAndPrintUtil.validateEmailPlanCompare();
	}
	
	public String compare_comparePageItem(String targetKey, HashMap<String, String> origPage, HashMap<String, String> emailage) {
		return planComapreEmailAndPrintUtil.compare_comparePageItem(targetKey, origPage, emailage);
	}
	
	public List<String> validatePlanCompareEmailDeeplink(String planType, String deepLinkStringId, String infoMapStringId, String deepLink, HashMap<String, String> origPage) {
		return planComapreEmailAndPrintUtil.validatePlanCompareEmailDeeplink(planType, deepLinkStringId, infoMapStringId, deepLink, origPage);
	}
	
	public void validateComparePrintOption(String planType) {
		planComapreEmailAndPrintUtil.validateComparePrintOption(planType);
	}
	
	public HashMap<String, String> collectInfoVppPlanDetailPg(String plantype, String forWhat) {
		return planDetailsEmailAndPrintUtil.collectInfoVppPlanDetailPg(plantype, forWhat);
	}	

	public String detail_comparePageItem(String targetKey, HashMap<String, String> origPage, HashMap<String, String> emailage) {
		return planDetailsEmailAndPrintUtil.detail_comparePageItem(targetKey, origPage, emailage);
	}

	public List<String> validatePlanDetailEmailDeeplink(String planType, String deepLinkStringId, String infoMapStringId, String deepLink, HashMap<String, String> origPage) {
		return planDetailsEmailAndPrintUtil.validatePlanDetailEmailDeeplink(planType, deepLinkStringId, infoMapStringId, deepLink, origPage);
	}


	public void validatingFunctionalityOfEmailOnPlanDetails() {
		planDetailsEmailAndPrintUtil.validatingFunctionalityOfEmailOnPlanDetails();
	}

	public void validatingFunctionalityOfPrintOnPlanDetails(String planType) {
		planDetailsEmailAndPrintUtil.validatingFunctionalityOfPrintOnPlanDetails(planType);
	}

	public void validatePrintPlanDetails() {
		planDetailsEmailAndPrintUtil.validatePrintPlanDetails();
	}

	public void validateEmailOnPlanDetails() {
		planDetailsEmailAndPrintUtil.validateEmailOnPlanDetails();
	}

	public void validateDetailPrintOption(String planType) {
		planDetailsEmailAndPrintUtil.validateDetailPrintOption(planType);
	}
		
}
