package pages.acquisition.emailAndPrint;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class EmailAndPrintUtilWebElements extends UhcDriver {

	@FindBy(xpath="//div[contains(@class,'plan-detail-tabs')]//a")
	protected List<WebElement> listOfTabHeaders;

	@FindBy(xpath="//div[@class='accordion-content']")
	protected List<WebElement> listOfTabBody;

	@FindBy(xpath="//div[contains(@id,'detail') and contains(@class,'active')]//h3")
	protected List<WebElement> listOfSectionHeaderForActiveTab;

	@FindBy(xpath="//div[contains(@id,'detail') and contains(@class,'active')]//table")
	protected List<WebElement> listOfSectionTableForActiveTab;

	@FindBy(xpath="//div[contains(@id,'plan-list') and contains(@class,'active')]//div[contains(@class,'plan-card') or contains(@class,'swiper-slide')][1]//a[@aria-selected='false']")
	protected WebElement firstSaveHeartOnActiveSummaryPlanPage;
	
	@FindBy(xpath = "//div[@ng-show='showMaPlans']//a[contains(@dtmname,'Print Saved Plan List')]")
	protected WebElement summary_maPrintOption;

	@FindBy(xpath = "//div[@ng-show='showMaPlans']//a[contains(@dtmname,'Email Saved Plan List')]")
	protected WebElement summary_maEmailOption;

	@FindBy(xpath = "//div[@ng-show='showPdpPlans']//a[contains(@dtmname,'Print Saved Plan List')]")
	protected WebElement summary_pdpPrintOption;

	@FindBy(xpath = "//div[@ng-show='showPdpPlans']//a[contains(@dtmname,'Email Saved Plan List')]")
	protected WebElement summary_pdpEmailOption;

	@FindBy(xpath = "//div[@ng-show='showSnpPlans']//a[contains(@dtmname,'Print Saved Plan List')]")
	protected WebElement summary_snpPrintOption;

	@FindBy(xpath = "//div[@ng-show='showSnpPlans']//a[contains(@dtmname,'Email Saved Plan List')]")
	protected WebElement summary_snpEmailOption;

	@FindBy(xpath = "//div[@id='emailPlanSummaryPopUp']")
	protected WebElement emailPlanSummaryPopupScreen;

	@FindBy(xpath = "//h3[@id='emailplandetail']")
	protected WebElement emailPlanSummaryPopupScreenText;

	@FindBy(xpath = "//input[@id='email']")
	protected WebElement emailPlanSummaryFieldBox;

	@FindBy(xpath = "///button[contains(@type,'submit') and contains(text(), 'Send')]")
	protected WebElement emailPlanSummarySendButton;

	@FindBy(xpath = "//button[@class='cta-button close-modal secondary']")
	protected WebElement emailPlanSummaryCancelButton;

	@FindBy(xpath = "//*[@id='emailSuccess']") 
	protected WebElement emailPlanSummarySuccessText;

	@FindBy(xpath = "//button[@ng-click='closeEmailSuccessMsgSummaryPopUp()']")
	protected WebElement emailPlanSummarySuccessCloseButton;

	@FindBy(xpath = "//input[@id='email' and @class='error']")
	protected WebElement emailPlanSummaryErrorFieldBox;

	@FindBy(xpath = "//p//span[@id='emailError']")
	protected WebElement emailPlanSummaryInputErrorText;

	@FindBy(xpath="//div[contains(@class,'active')]//a[contains(@class,'added')]")
	protected List<WebElement> planSummary_listOfSavedHearts;
	
	@FindBy(xpath="//div[contains(@class,'active')]//div[@class='enroll-details']//a[contains(@dtmname,'Enroll in Plan')]")
	protected List<WebElement> planSummary_listOfEnrollInPlanButtons;

	@FindBy(xpath="//div[contains(@class,'active')]//div[@class='enroll-details']//a[contains(@dtmname,'View More Details')]")
	protected List<WebElement> planSummary_listOfViewPlanDetailsButtons;
	
	@FindBy(xpath = "//div[contains(@class,'overview-main')]/h2")
	protected WebElement vppTop;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[1]//span[@class='ng-binding']")
	protected WebElement maPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[2]//span[@class='ng-binding']")
	protected WebElement msPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[3]//span[@class='ng-binding']")
	protected WebElement pdpPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[4]//span[@class='ng-binding']")
	protected WebElement snpPlansCount;

	@FindBy(xpath="//h2[contains(@class,'zipcodePrint') and not(contains(@class,'ng-hide'))]")
	protected WebElement cmpPgHeader;

	@FindBy(xpath="//div[@id='topRowCopy']//div[@ng-repeat='i in count']")
	protected List<WebElement> listOfCmpPlansColumns;

	@FindBy(xpath="//div[@id='topRowCopy']//a[contains(@class,'added')]")
	protected List<WebElement> planCompare_listOfSavedHearts;

	@FindBy(xpath="//table[@id='fixTable']//tr")
	protected List<WebElement> listOfRowsInPlanCompareTbl;

	@FindBy(xpath="//div[@class='popup-modal active']//h2[@id='plan-year-modal-header']")
	protected WebElement planYearPopup;

	@FindBy(xpath="//div[contains(@class,'planOptions')]//label[@for='current_Year']")
	protected WebElement currentYearSelection;

	@FindBy(xpath="//button[@id='lisGoBtn']")
	protected WebElement planYearPopupGoButton;

	@FindBy(xpath="//div[contains(@class,'planOptions')]//label[@for='next_Year']")
	protected WebElement nextYearSelection;

	@FindBy(xpath = ".//*[@id='printdetails']")
	protected WebElement validatePrintButtonOnPlanDetails;

	@FindBy(xpath=".//*[@id='printComparison']")
	protected WebElement compare_validateprintbutton;

	@FindBy(xpath=".//*[@id='emailComparison']")
	protected WebElement compare_validateemailbutton;

	@FindBy(xpath="//a[@id='backtoplansummarypage']")
	protected WebElement backToAllPlansLnk;

	@FindBy(xpath=".//*[@id='emailSuccessMsgPopUp']/div/form/div[2]/button")
	protected WebElement closeButtonthankyoumessagepopup;

	@FindBy(xpath=".//*[@id='emailComparison']")
	protected WebElement validateemailbutton;
	
	@FindBy(xpath=".//*[@id='emailcompareDescription']")
	protected WebElement leavingcomapreplansitepopup;
	
	@FindBy(xpath=".//*[@id='form-valid']/div[2]/button[1]")
	protected WebElement cancelButtonEmailPlanComparePopUp;
	
	@FindBy(xpath=".//*[@id='form-valid']/div[2]/button[2]")
	protected WebElement sendButtonEmailPlanComparePopUp;
	
	@FindBy(xpath=".//*[@id='emailSuccessMsgPopUp']")
	protected WebElement validatesuccesspopup;

	@FindBy(xpath = ".//*[@id='emailPlanDetail']")
	protected WebElement validateEmailButtonOnPlanDetails;

	@FindBy(xpath = ".//*[@id='emailPlanDetailPopUp']")
	protected WebElement emailPopup;

	@FindBy(xpath = ".//*[@id='closepopup']")
	protected WebElement cancelButtonEmailPlanDetailsPopUp;

	@FindBy(xpath = ".//*[@id='form-valid']//button[2]")
	protected WebElement sendButtonEmailPlanDetailsPopUp;

	@FindBy(xpath="//a[contains(@dtmname,'Enroll in Plan')]")
	protected List<WebElement> planDetailEnrollButtonList;
	
	@FindBy(xpath="//label[contains(@dtmname,'Add to Compare')]")
	protected List<WebElement> planDetailAddToCompareBoxList;

	public EmailAndPrintUtilWebElements(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() {
	}

}
