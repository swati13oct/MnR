package pages.mobile.acquisition.emailAndPrint;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EmailAndPrintUtilMobile extends EmailAndPrintUtilBaseMobile{

	public EmailAndPrintUtilMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

	PlanSummaryEmailAndPrintUtilMobile planSummaryEmailAndPrintUtil=new PlanSummaryEmailAndPrintUtilMobile(driver);

	PlanCompareEmailAndPrintUtilMobile planComapreEmailAndPrintUtil=new PlanCompareEmailAndPrintUtilMobile(driver);
	
	PlanDetailsEmailAndPrintUtilMobile planDetailsEmailAndPrintUtil=new PlanDetailsEmailAndPrintUtilMobile(driver);

	//note: plan summary section------------------------------------------------
	public void validateEmailOptionExistOnSummaryPage(String planType) {
		planSummaryEmailAndPrintUtil.validateEmailOptionExistOnSummaryPage(planType);
	}
	
	public void validateEmailFunctionOnSummaryPage(String planType) {
		planSummaryEmailAndPrintUtil.validateEmailFunctionOnSummaryPage(planType);
	}	
	
	public HashMap<String, Integer> collectInfoVppPlanSummaryPg() {
		return planSummaryEmailAndPrintUtil.collectInfoVppPlanSummaryPg();
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
	
	public void waitForSummaryPageToLoad() {
		planSummaryEmailAndPrintUtil.waitForSummaryPageToLoad();
	}
	
	//note: plan compare section------------------------------------------------
	public HashMap<String, String> collectInfoVppPlanComparePg(String planType, String forWhat, WebDriver origDriver) {
		return planComapreEmailAndPrintUtil.collectInfoVppPlanComparePg(planType, forWhat, origDriver);
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
	
	public List<String> validatePlanCompareEmailDeeplink(String planType, String deepLinkStringId, String infoMapStringId, String deepLink, HashMap<String, String> origPage, WebDriver origDriver) {
		return planComapreEmailAndPrintUtil.validatePlanCompareEmailDeeplink(planType, deepLinkStringId, infoMapStringId, deepLink, origPage, origDriver);
	}
	
	public void waitForComparePageToLoad() {
		planComapreEmailAndPrintUtil.waitForComparePageToLoad();
	}
	
	//note: plan detail section------------------------------------------------
	public HashMap<String, String> collectInfoVppPlanDetailPg(String plantype, String forWhat, WebDriver origDriver) {
		return planDetailsEmailAndPrintUtil.collectInfoVppPlanDetailPg(plantype, forWhat, origDriver);
	}	

	public List<String> validatePlanDetailEmailDeeplink(String planType, String deepLinkStringId, String infoMapStringId, String deepLink, HashMap<String, String> origPage, WebDriver origDriver) {
		return planDetailsEmailAndPrintUtil.validatePlanDetailEmailDeeplink(planType, deepLinkStringId, infoMapStringId, deepLink, origPage, origDriver);
	}

	public void validatingFunctionalityOfEmailOnPlanDetails() {
		planDetailsEmailAndPrintUtil.validatingFunctionalityOfEmailOnPlanDetails();
	}

	public void validatePrintPlanDetails() {
		planDetailsEmailAndPrintUtil.validatePrintPlanDetails();
	}

	public void validateEmailOnPlanDetails() {
		planDetailsEmailAndPrintUtil.validateEmailOnPlanDetails();
	}

}
