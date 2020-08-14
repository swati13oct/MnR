package pages.acquisition.ulayer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Strings;
import com.mysql.jdbc.StringUtils;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.ole.WelcomePage;
public class ComparePlansPage extends UhcDriver {

	
	@FindBy(id = "backtoplansummarypage")
	private WebElement BackToAllPlan;
	
	@FindBy(id = "enrollment-next-button")
	private WebElement NextBtn;
	
	@FindBy(id = "backtoplansummarypage")
	private WebElement backToAllPlansLink;
	
	@FindBy(xpath=".//*[@id='printComparison']")
	private WebElement validateprintbutton;
	
	@FindBy(xpath=".//*[@id='emailComparison']")
	private WebElement validateemailbutton;
	
	@FindBy(xpath=".//*[@id='emailcompareDescription']")
	private WebElement leavingcomapreplansitepopup;
	
	@FindBy(xpath=".//*[@id='form-valid']/div[2]/button[1]")
	private WebElement cancelButtonEmailPlanComparePopUp;
	
	@FindBy(xpath=".//*[@id='form-valid']/div[2]/button[2]")
	private WebElement sendButtonEmailPlanComparePopUp;
	
	@FindBy(xpath=".//*[@id='emailSuccessMsgPopUp']")
	private WebElement validatesuccesspopup;
	
	@FindBy(xpath = "//p[text()='Drug Costs from Formulary']/parent::td/following::td[1]//a")
	private WebElement dceLink;

	@FindBy(xpath = "//p[text()='Your Doctors / Providers']/parent::td/following::td[1]//a[contains(text(),'Look up')]")
	private WebElement LookUpYourDoctorLink;

	@FindBy(id = "add-drug")
	public WebElement addDrug;

	@FindBy(xpath = "//span[text()='Find Care']")
	public WebElement FindCareLink;

	@FindBy(xpath = "//span[text()='1 out of 1 providers covered']")
	public WebElement VerifyProviderCount;

	@FindBy(xpath = "//a[contains(text(),'Edit') and contains(text(),'Provider')]")
	public WebElement EditproviderlistLink;
	
	@FindBy(xpath = "//td[contains(@class,'estimatedrugcost')][1]//div")
	public WebElement VerifyEstimatedDrugCost;
	
	@FindBy(xpath=".//*[@id='emailSuccessMsgPopUp']/div/form/div[2]/button")
	private WebElement closeButtonthankyoumessagepopup;

	@FindBy(xpath = "//*[@id='sam-call-button']//*[contains(@class,'sam__button__icon')]")
   	private WebElement callsam;
   	
   	@FindBy(xpath = "//*[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text')]")
   	private WebElement callsamtooltip;
   	
   	@FindBy(xpath ="//*[@id='sam-call-modal']/div/div")
   	private WebElement callSamPopup;
   	
   	
   	@FindBy(xpath ="//*[@id='sam-call-modal']/div/div/div[2]/p[1]/a[1]")
   	private WebElement CallSamModel;
   	
   	@FindBy(xpath ="//*[contains(@id,'sam-call-modal')]//*[contains(@dtmname,'TFN Link') and contains(text(),'1-')]")
   	private WebElement CallSamTFN;
   	
   	@FindBy(xpath ="//*[contains(@id,'sam-call-modal')]//*[contains(@class,'modal-close')]")
   	private WebElement CallSamTFNClose;
   	
   	String CallSam= "Call a Licensed Insurance Agent";
   	@FindBy(xpath = "//*[@id='sam-button--chat']/div/span[2]/img")
   	private WebElement chatsam;
   	
   	@FindBy(xpath = "//*[@id='sam-button--chat']/div/span[1]")
   	private WebElement chatsamtooltip;
   	
   	@FindBy(xpath ="//*[@id='inner-chat']")
   	private WebElement chatSamPopup;
   	
   	
   	@FindBy(xpath ="//*[@id='agent-name']")
   	private WebElement ChatSamHead;
   	
   	@FindBy(xpath ="//*[@id='sp-close-frame']")
   	private WebElement ChatSamTFNClose;
	
   	String ChatSamText= "Chat with a Licensed Insurance Agent";
   	
   	@FindBy(xpath="//*[contains(@class,'remove')]")
	private WebElement removeLink;
	
	@FindBy(xpath="//span[@class='remove-button removebtn3']")
	private WebElement remove4thplan;
	
	@FindBy(xpath="//span[@class='remove-button removebtn3']")
	private WebElement remove4thplanName;
	
	@FindBy(xpath="//th[@ng-repeat='plan in count'][4]//a[contains(@class,'uhc-link-button d-none d-lg-inline-block')]")
	private WebElement Newremove4thplan;
	
	@FindBy(xpath="//th[@ng-repeat='plan in count'][4]//div[contains(@ng-if,'planName')]")
	private WebElement Newremove4thplanName;
	
	@FindBy(xpath="//a[@id='addanotherplanbutton2']")
	private WebElement add3Plan;
	
	@FindBy(xpath="//button[@id='addanotherplanbutton']")
	private WebElement addPlanButton;
	
	@FindBy(xpath="//h3[@id='favouriteplanSelect2']")
	private WebElement plan3added;
	
	@FindBy(xpath="//div[text()='Your Hospitals']")
	private WebElement yourHospitalsBanner;
	
	@FindBy(xpath="//a[text()='Add Hospitals']")
	private WebElement addHospitalsLink;
	
	@FindBy(xpath="//a[text()='Edit Hospitals']")
	private WebElement editHospitalsLink;
	
	@FindBy(xpath="//*[normalize-space(text())='Hospital Summary']")
	private WebElement HospitalSummaryHeader;
	
	@FindBy(xpath="//*[normalize-space(text())='Hospital Summary']/ancestor::th/following::td[1]")
	private WebElement HospitalSummaryCoverageHeader;

	@FindBy(xpath="//*[normalize-space(text())='Hospital Summary']/ancestor::th/following::tr[1]//th//span[contains(@class,'provider-name')]")
	private WebElement HospitalProviderName;
	
	@FindBy(xpath="//*[normalize-space(text())='Hospital Summary']/ancestor::th/following::tr[1]//td[1]")
	private WebElement HospitalProviderCoverageText;	
	
	@FindBy(xpath="//div[text()='Your Doctors']")
	private WebElement yourDoctorsBanner;
	
	@FindBy(xpath="//a[text()='Add Doctors']")
	private WebElement addDoctorsLink;
	
	@FindBy(xpath="//a[text()='Edit Doctors']")
	private WebElement editDoctorsLink;
	@FindBy(xpath="//*[contains(@class,'provider') and text()='Summary']")
	private WebElement providerSumamryHeader;
	
	@FindBy(xpath="//*[contains(@class,'provider') and text()='Summary']/ancestor::th/following::td[1]")
	private WebElement providerSumamryHeaderCount;
	
	@FindBy(xpath="//*[contains(@class,'provider') and text()='Summary']/ancestor::th/following::tr[1]//th//div[contains(@class,'provider-name')]")
	private WebElement FirstProviderName;
	
	@FindBy(xpath="//*[contains(@class,'provider') and text()='Summary']/ancestor::th/following::tr[1]//td[1]//a")
	private WebElement viewlocationsLink;	
	
	@FindBy(xpath="//div[text()='Your Drugs']")
	private WebElement yourDrugsBanner;
	
	@FindBy(xpath="//a[text()='Add Drugs']")
	private WebElement addDrugsLink;
	
	@FindBy(xpath="//*[normalize-space(text())='Edit Drugs']")
	private WebElement editDrugsLink;
	
	@FindBy(xpath="//*[normalize-space(text())='Drug Summary']")
	private WebElement DrugSummaryHeader;
	
	@FindBy(xpath="//*[normalize-space(text())='Drug Summary']/ancestor::th/following::td[1]")
	private WebElement DrugSummaryCoverageHeader;

	@FindBy(xpath="//*[normalize-space(text())='Drug Summary']/ancestor::th/following::tr[1]//th//span[contains(@class,'drugtext')]")
	private WebElement DrugName;
	
	@FindBy(xpath="//*[normalize-space(text())='Drug Summary']/ancestor::th/following::tr[1]//td[1]")
	private WebElement DrugCoverageText;	
		
	@FindBy(css="div.member-info-status>p:nth-child(2)")
	private WebElement memberName;
	
	@FindBy(css="div.member-info-status>p:last-child")
	private WebElement memberMBI;
	
	@FindBy(xpath="//div[@class='member-info-status']/following::p[contains(text(),'DOB')]")
	private WebElement memberDOB;
	
	@FindBy(css = "div#CSRLoginAlert>div")
	private WebElement agentModeBanner;
	
	@FindBy(xpath="//div[contains(text(),'Current')]/preceding::div[contains(@class,'text-dark')]")
	private WebElement enrolledPlanName;
	
	@FindBy(xpath="//div[contains(text(),'Status')]/preceding-sibling::div/span[1]")
	private WebElement nonMemberName;
	
	@FindBy(xpath="//div[contains(text(),'Status')]/following::div[contains(text(),'DOB')]")
	private WebElement nonMemberDOB;
	
	@FindBy(css="#changes-submitted button")
	private WebElement popupAccept;
	
	@FindBy(css="input.uhc-switch__input")
	private WebElement currentPlanToggle;
	
	@FindBys(value = { @FindBy(css = "table#your-doctors-table tbody>tr") })
	private List<WebElement> providersList;
	
	@FindBys(value = { @FindBy(css = "table#your-drugs-table tbody>tr") })
	private List<WebElement> drugList;
	
	@FindBy(id="dupIconFlyOut")
	private WebElement shoppingCartIcon;
	
	public ComparePlansPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}


	@Override
	public void openAndValidate() {
		checkModelPopup(driver,20);
		
	}
	
	public VPPPlanSummaryPage backToVPPPage(){
		backToAllPlansLink.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(currentUrl().contains("#/plan-summary"))
			return new VPPPlanSummaryPage(driver);
		return null;
	}


	/**
	 * @author sdwaraka
	 * Method Added for OLE Flow - Navigate to OLE from Plan Summary Page
	 * @param planName
	 * @return
	 * @throws InterruptedException
	 */
	public WelcomePage Enroll_OLE_Plan(String planName) throws InterruptedException {
		
		System.out.println("Enroll in Plan for Plan : "+planName);
		WebElement EnrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@id='innerdiv']//*[contains(text(), 'Enroll in plan')]"));
		try {
		validate(EnrollForPlan);
		
		System.out.println("Found Enroll IN Plan Button for the Plan : "+planName);
		}catch(Exception e){
			System.out.println("Enroll in Plan Button is Not Displayed ");
		}
		EnrollForPlan.click();
		
		try {
			Thread.sleep(5000);
			} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(driver.getCurrentUrl().contains("enrollment")){
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}


	public void validateprintandemail() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
		validate(validateprintbutton);
		validate(validateemailbutton);
		System.out.println("successfully validated the Print and email in plan compare page ");
		
	}


	public void validatingprintandemail() {
		// TODO Auto-generated method stub
		validateemailbutton.click();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//Validating email popup
		validate(leavingcomapreplansitepopup);
		System.out.println("!!!Leaving site popup is displayed ===>"+leavingcomapreplansitepopup.isDisplayed());
		//Validating email cancel button
		validate(cancelButtonEmailPlanComparePopUp);
		System.out.println("!!!Cancel Button is displayed ===>"+cancelButtonEmailPlanComparePopUp.isDisplayed());
		cancelButtonEmailPlanComparePopUp.click();
		System.out.println("Success click of cancel email");
		//Validating email send button
		validateemailbutton.click();
		validate(leavingcomapreplansitepopup);
		System.out.println("!!!Leaving site popup is displayed ===>"+leavingcomapreplansitepopup.isDisplayed());
		validate(sendButtonEmailPlanComparePopUp);
		System.out.println("!!!Cancel Button is displayed ===>"+sendButtonEmailPlanComparePopUp.isDisplayed());
		driver.findElement(By.xpath(".//*[@id='email']")).sendKeys("rani_madadi@optum.com");
		System.out.println("!!!Entered valid Email ");
		sendButtonEmailPlanComparePopUp.click();
		System.out.println("Email has successfull send to user");
		//Validating email success popup
		validateNew(validatesuccesspopup);
		System.out.println("Validated Thank you Message");
		
	}
	
	public DrugCostEstimatorPage clickonDCE() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(dceLink);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", dceLink);
		jsClickNew(dceLink);
		waitforElement(addDrug);
		if (validate(addDrug)) {
			System.out.println("User is on DCE Page");
			return new DrugCostEstimatorPage(driver);
		} else
			return null;
	}

	public FindCarePage clickonLookUpYourDoctor() throws InterruptedException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(LookUpYourDoctorLink);
		String ParentWindow = driver.getTitle();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", LookUpYourDoctorLink);
		jsClickNew(LookUpYourDoctorLink);

		Thread.sleep(25000);
		Set<String> handles1 = driver.getWindowHandles();
		for (String windowHandle : handles1) {
			if (!windowHandle.equals(ParentWindow)) {
				driver.switchTo().window(windowHandle);
				String title = driver.getTitle();
				System.out.println("Window title is : " + title);
				if (title.contains("Find Care")) {
					System.out.println("We are on Find Care winodow opened");
					driver.manage().window().maximize();
					Thread.sleep(3000);
					waitforElement(FindCareLink);
					break;
				}
			} else {
				System.out.println("Not found Expected window");
				driver.switchTo().window(ParentWindow);
			}

		}
		waitforElement(FindCareLink);
		if (validate(FindCareLink)) {
			System.out.println("User is on Find care Page");
			return new FindCarePage(driver);
		} else
			return null;
	}

	public void verifyProvidercount() {
		Assert.assertTrue("Verified Provider Count not Displayed",validate(VerifyProviderCount));
		Assert.assertTrue("Verified Edit Provider Link not Displayed",validate(EditproviderlistLink));

	}
	
	public void verifyDCEAmount() {
		validate(VerifyEstimatedDrugCost);
		System.out.println("Verified DCE Link Exists");
		System.out.println(VerifyEstimatedDrugCost.getText());
		String DCEValue = VerifyEstimatedDrugCost.getText();
		if (DCEValue.contains("Monthly")){
			System.out.println("Verified Monthly varies Yearly Text Displayed");
		}else{
			System.out.println("No Monthly varies Yearly Text Displayed");
		}

	}


	public boolean validatingMedicalBenefitTextInPlanDetails(String benefitType, String expectedText, String planName) {
		boolean validationFlag = true;
		WebElement MedicalBenefitTypeRow;
		WebElement ActualTextforBenefit;
		String displayedText;
		
		int index = findindexofPlan_PlanCompare(planName);
		index++;
		MedicalBenefitTypeRow = driver.findElement(By.xpath("//p[(contains(text(), '"+benefitType+"'))]/ancestor::tr"));
		System.out.println("The additional Benefit to Valuidate : "+benefitType);
		ActualTextforBenefit =  driver.findElement(By.xpath("//p[(contains(text(), '"+benefitType+"'))]/ancestor::tr//td["+index+"]"));
		displayedText = ActualTextforBenefit.getText();
		System.out.println("Text Displayed for the Medical Benefit on Plan Compare Page : ");
		System.out.println(displayedText);
		String[] Expected = expectedText.split("/");
		for(String str :Expected){
			if(!displayedText.contains(str.trim())){
				validationFlag = false;
				System.out.println("Expected Text - "+str+" is NOT displayed");
			}
		}
		return validationFlag;		}


	private int findindexofPlan_PlanCompare(String planName) {
		int index = 1;
		List <WebElement> PlanHeadings = driver.findElements(By.xpath("//div[@ng-repeat = 'i in count']"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Total Plans displayed - Total elements for Plan Name are : "+PlanHeadings.size());
		for(WebElement currentPlanColumn : PlanHeadings){
			WebElement PlanNameDisplay = driver.findElement(By.xpath("//div[@ng-repeat = 'i in count']["+index+"]//a[contains(@class,'ng-binding')]"));
			if(validateNew(PlanNameDisplay) && PlanNameDisplay.getText().contains(planName)){
				System.out.println("Index for the Plan -"+planName+" in Plan Compare is : "+index);
				return index;
			}
			index++;
		}
		return index;
	}

	
	public void validatingthankyoumessage() {
		// TODO Auto-generated method stub
		closeButtonthankyoumessagepopup.click();
		System.out.println("Thank you Message pop up is closed");
	}
	
  	public WelcomePage Enroll_OLE_Plan() throws InterruptedException {
	WebElement enrollForPlan = null;
	enrollForPlan = driver.findElement(By.xpath("//*[@id='enrollbtnplancompare0']/span"));
	if(enrollForPlan!=null){
		//validateNew(enrollForPlan);
		enrollForPlan.click();
	}
	CommonUtility.waitForPageLoadNew(driver, NextBtn, 30);
	System.out.println(driver.getCurrentUrl());
	if(driver.getCurrentUrl().contains("welcome"))
	{
		System.out.println("OLE Welcome Page is Displayed");
		return new WelcomePage(driver);
	}
	return null;
  	}
  	
  	public WelcomePage Enroll_OLE_Plancompare() throws InterruptedException {
  		WebElement enrollForPlan = null;
  		enrollForPlan = driver.findElement(By.xpath("//*[@id='enrollbtnplancompare0']//button//span[text()='Enroll']"));
  		if(enrollForPlan!=null){
  			//validateNew(enrollForPlan);
  			enrollForPlan.click();
  		}
  		CommonUtility.waitForPageLoadNew(driver, NextBtn, 30);
  		System.out.println(driver.getCurrentUrl());
  		if(driver.getCurrentUrl().contains("welcome"))
  		{
  			System.out.println("OLE Welcome Page is Displayed");
  			return new WelcomePage(driver);
  		}
  		return null;
  	  	}
  	
	public PlanDetailsPage navigateToPlanDetails() {
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement PlanDetailsLink = driver.findElement(By.xpath("(//*[contains(text(),'View details')])[1]"));
				CommonUtility.waitForPageLoadNew(driver, PlanDetailsLink, 30);
				PlanDetailsLink.click();
				System.out.println("View Plan Details Link is clicked");
		
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("#/details")) 
		{	
			return new PlanDetailsPage(driver);
		}
		return null;
	}
	
	public PlanDetailsPage navigateToPlanDetailfromplanCompare() {
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement PlanDetailsLink = driver.findElement(By.xpath("(//*[contains(text(),'View Plan Details')])[1]"));
				CommonUtility.waitForPageLoadNew(driver, PlanDetailsLink, 30);
				PlanDetailsLink.click();
				System.out.println("View Plan Details Link is clicked");
		
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("#/details")) 
		{	
			return new PlanDetailsPage(driver);
		}
		return null;
	}
		
	public VPPPlanSummaryPage navigateBackToAllPlans() {
		CommonUtility.checkPageIsReadyNew(driver);
				CommonUtility.waitForPageLoadNew(driver, BackToAllPlan, 30);
				BackToAllPlan.click();
				System.out.println("Back to all plan is clicked");
		
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("#/plan-summary")) 
		{	
			return new VPPPlanSummaryPage(driver);
		}
		return null;
	}
		
    public void validateCallSam() throws InterruptedException {
        boolean present;
        try {
        validateNew(callsam);
        present = true;
        } catch (NoSuchElementException e) {
        present = false;
        }
        if (present) {
          System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
        }
        else
        	System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
	}
	
	public void validateCallSamContent() throws InterruptedException {
		
		Actions action = new Actions(driver);
		WebElement element = callsam;
		action.moveToElement(element).perform();
		String toolTipText = callsamtooltip.getText();
		System.out.println("====================================================================");
		System.out.println(toolTipText);
		System.out.println("====================================================================");
        if (CallSam.equalsIgnoreCase(toolTipText)) {
          System.out.println("Call sticky action menu roll out and contain the text Call a Licensed Insurance Agent");
        }
        else
        	System.out.println("No Call sticky action menu didn't roll out and doesn't contain the text Call a Licensed Insurance Agent");
	}
	
	public void  validateCallpopup() throws InterruptedException {
		//CommonUtility.checkPageIsReady(driver);
		callsam.click();
		System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");		
		driver.switchTo().activeElement();
		if (CallSamTFN.getText().isEmpty()) {
			// return null;
			Assert.fail("TFN number was not found on the SAM call Popup");
		} else {
			CallSamTFNClose.click();
			validateNew(callsam);
		}
	}
	
	public ComparePlansPage validateChatSam() throws InterruptedException {
        boolean present;
        try {
        validateNew(chatsam);
        present = true;
        } catch (NoSuchElementException e) {
        present = false;
        }
        if (present) {
          System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
          return new ComparePlansPage(driver);
        }
        else
        	System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
       return null;
	}
	
	public ComparePlansPage validateChatSamContent() throws InterruptedException {
		
		Actions action = new Actions(driver);
		WebElement element = chatsam;
		action.moveToElement(element).perform();
		String ChattoolTipText = chatsamtooltip.getText();
		System.out.println("====================================================================");
		System.out.println(ChattoolTipText);
		System.out.println("====================================================================");
		
        if (ChatSamText.equalsIgnoreCase(ChattoolTipText)) {
          System.out.println("Chat sticky action menu roll out and contain the text Chat with a Licensed Insurance Agent");
          return new ComparePlansPage(driver);
        }
        else
        	System.out.println("No Chat sticky action menu didn't roll out and doesn't contain the text Chat with a Licensed Insurance Agent");
       return null;
	}
	
	public ComparePlansPage  validateChatpopup() throws InterruptedException {
		//CommonUtility.checkPageIsReady(driver);
		chatsam.click();
		System.out.println("@@@@@@@@@@@@@@@ Chat Icon Clicked @@@@@@@@@@@@@@@");	
		chatsamtooltip.click();
		driver.switchTo().activeElement();
		System.out.println(ChatSamHead.getText());
		ChatSamTFNClose.click();
		validateNew(chatsam);		
		return null;
	}
	public void validatePlanComparePage() {
		validateNew(backToAllPlansLink);
		validateNew(validateprintbutton);
		validateNew(validateemailbutton);
		//validateNew(removeLink);
		//validateNew(viewDetailslink);
		//validateNew(savePlanIcon);
		System.out.println("Validated all links plan compare");
		
	}
	
	public void clickOnRemoveLink(){
		validateNew(removeLink);
		String PlanName=remove4thplanName.getText();
		System.out.println("4th plan name is : " + PlanName );
		remove4thplan.click();
		System.out.println("Clicked on Remove Link on plan Compare page");

	}
	
	public void clickOnNewRemoveLink(){
		validateNew(Newremove4thplan);
		String PlanName=Newremove4thplanName.getText();
		System.out.println("3rd plan name is : " + PlanName );
		Newremove4thplan.click();
		System.out.println("Clicked on Remove Link on plan Compare page");

	}
	
	public void CounterNewRemoveLink(String counter){
		WebElement removelink = driver.findElement(By.xpath("//th[@ng-repeat='plan in count']["+counter+"]//a[contains(@class,'uhc-link-button d-none d-lg-inline-block')]"));
		WebElement removePlanName = driver.findElement(By.xpath("//th[@ng-repeat='plan in count']["+counter+"]//div[contains(@ng-if,'planName')]"));
		String PlanName=removePlanName.getText();
		System.out.println("3rd plan name is : " + PlanName );
		removelink.click();
		System.out.println("Clicked on Remove Link on plan Compare page");
		
		if(driver.findElement(By.xpath("//th[@ng-repeat='plan in count'][1]//a[contains(@class,'remove')]")).isDisplayed()){
			System.out.println("Element is Present");
			Assert.fail("remove icon is Displaying in plan compare page");
			}else{
			System.out.println("remove icon is not Displaying in plan compare page");

			}

	}
	
	public void clickOnBacktoPlans(){
		validateNew(backToAllPlansLink);
		backToAllPlansLink.click();
		System.out.println("Clicked on Back to plans");
	}
	
	public VPPPlanSummaryPage clickOnAddIcon(){
   	 
    	//a[@class='planNameVisibility']//h3
    	 
    	 validateNew(add3Plan);
    	 add3Plan.click();
 		try {
 			Thread.sleep(4000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		if(currentUrl().contains("#/plan-summary"))
 			return new VPPPlanSummaryPage(driver);
 		return null;
     }
	
	public VPPPlanSummaryPage clickOnNewAddIcon(){
    	 
    	 validateNew(addPlanButton);
    	 addPlanButton.click();
 		try {
 			Thread.sleep(4000);
 		} catch (InterruptedException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		if(currentUrl().contains("#/plan-summary"))
 			return new VPPPlanSummaryPage(driver);
 		return null;
     }
	
	public void validatenewlyAddPlan() {
   	 List<WebElement> allMAPlans = driver.findElements(By.xpath("//*[@class='planNameVisibility']//h3"));	
		int plansForCompare=allMAPlans.size();
		if (plansForCompare == 3) {
			Assert.assertTrue(true);
			System.out.println("Verified Three plans Added on plan compare");
		}
		else Assert.assertTrue(false); 		
	}
		
	public void validatenewlyAddPlanonNewPlanComapre() {
	   	 List<WebElement> allMAPlans = driver.findElements(By.xpath("//th[@ng-repeat='plan in count']//div[contains(@ng-if,'planName')]"));	
			int plansForCompare=allMAPlans.size();
			if (plansForCompare == 3) {
				Assert.assertTrue(true);
				System.out.println("Verified Three plans Added on plan compare");
			}
			else Assert.assertTrue(false); 		
		}
	public void validatePlansAddedonPlancompareforVisitorProfile() {
		List<WebElement> allMAPlans = driver.findElements(By.xpath("//*[@class='planNameVisibility']//h3"));
		int plansForCompare = allMAPlans.size();
		if (plansForCompare == 2) {
			Assert.assertTrue(true);
			System.out.println("Verified two plans Added on plan compare from visitor profile testharness");
		} else
			Assert.assertTrue(false);
	}
	
	public void validatePlansAddedonPlancompareforVisitorProfile(String plans) {
		List<WebElement> allMAPlans = driver.findElements(By.xpath("//*[@class='planNameVisibility']//h3"));
		String[] plan = plans.split(",");
		for(int i=0;i<allMAPlans.size();i++) {
			Assert.assertEquals(plan[i], allMAPlans.get(i).getText().trim());
		}
	}
	
	public void validateDoctors() {
		validateNew(backToAllPlansLink);
		validateNew(yourDoctorsBanner);
		validateNew(editDoctorsLink);
		validateNew(providerSumamryHeader);
		validateNew(providerSumamryHeaderCount);
		validateNew(FirstProviderName);
		validateNew(viewlocationsLink);
		System.out.println("Verified Edit Doctors Section");
	}	
	
	public void validateAddDoctors() {
		validateNew(backToAllPlansLink);
		validateNew(yourDoctorsBanner);
		validateNew(addDoctorsLink);
		System.out.println("Verified Add Doctors Section");
	}
	
	public void validateEditHospitals() {
		validateNew(backToAllPlansLink);
		validateNew(yourHospitalsBanner);
		validateNew(editHospitalsLink);
		validateNew(HospitalSummaryHeader);
		validateNew(HospitalSummaryCoverageHeader);
		System.out.println("Coverage Header for plan 1 : " + HospitalSummaryCoverageHeader.getText());
		validateNew(HospitalProviderName);
		System.out.println("Added Hospital Name : " + HospitalProviderName.getText());
		validateNew(HospitalProviderCoverageText);
		System.out.println("Covered or not covered text for plan 1 : " + HospitalProviderCoverageText.getText());
		System.out.println("Verified Edit Hospitals Section header and Summary section");
		
	}	
	
	public void validateAddHospitals() {
		validateNew(backToAllPlansLink);
		validateNew(yourHospitalsBanner);
		validateNew(addHospitalsLink);
		System.out.println("Verified Add Hospitals Section");
	}
	
	public void validateEditDrugs() {
		validateNew(backToAllPlansLink);			
		validateNew(yourDrugsBanner);
		validateNew(editDrugsLink);
		validateNew(DrugSummaryHeader);
		validateNew(DrugSummaryCoverageHeader);
		System.out.println("Coverage Header for plan 1 : " + DrugSummaryCoverageHeader.getText());
		validateNew(DrugName);
		System.out.println("Added Drug Name : " + DrugName.getText());
		validateNew(DrugCoverageText);
		System.out.println("Covered or not covered text for plan 1 : " + DrugCoverageText.getText());
		System.out.println("Verified Edit Drugs Section header and Summary section");
		
	}	
	public FindCarePage clickonEditYourDoctors() throws InterruptedException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(editDoctorsLink);
		String ParentWindow = driver.getTitle();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", editDoctorsLink);
		
		
		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
		switchToNewTabNew(editDoctorsLink);
		
		if (driver.getCurrentUrl().contains("werally")) {
			System.out.println("We are on Find Care winodow opened");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			waitforElement(FindCareLink);
		} else {
		System.out.println("Not found Expected window");
		driver.switchTo().window(ParentWindow);
	}
		waitforElement(FindCareLink);
		if (validate(FindCareLink)) {
			System.out.println("User is on Find care Page");
			return new FindCarePage(driver);
		} else
			return null;
	}
	
	public FindCarePage clickonEditYourHosptials() throws InterruptedException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(editHospitalsLink);
		String ParentWindow = driver.getTitle();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", editHospitalsLink);
		
		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
		switchToNewTabNew(editHospitalsLink);
		
		if (driver.getCurrentUrl().contains("werally")) {
			System.out.println("We are on Find Care winodow opened");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			waitforElement(FindCareLink);
		} else {
		System.out.println("Not found Expected window");
		driver.switchTo().window(ParentWindow);
	}
		
		waitforElement(FindCareLink);
		if (validate(FindCareLink)) {
			System.out.println("User is on Find care Page");
			return new FindCarePage(driver);
		} else
			return null;
	}
	
	public FindCarePage clickonAddYourDoctors() throws InterruptedException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(addDoctorsLink);
		String ParentWindow = driver.getTitle();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", addDoctorsLink);
		
		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
		switchToNewTabNew(addDoctorsLink);
		
		if (driver.getCurrentUrl().contains("werally")) {
			System.out.println("We are on Find Care winodow opened");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			waitforElement(FindCareLink);
		} else {
		System.out.println("Not found Expected window");
		driver.switchTo().window(ParentWindow);
	}
		waitforElement(FindCareLink);
		if (validate(FindCareLink)) {
			System.out.println("User is on Find care Page");
			return new FindCarePage(driver);
		} else
			return null;
	}
	
	public FindCarePage clickonAddYourHospitals() throws InterruptedException {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(addHospitalsLink);
		String ParentWindow = driver.getTitle();
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", addHospitalsLink);
		
		CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION = driver.getWindowHandle();
		switchToNewTabNew(addHospitalsLink);
		
		if (driver.getCurrentUrl().contains("werally")) {
			System.out.println("We are on Find Care winodow opened");
			driver.manage().window().maximize();
			Thread.sleep(3000);
			waitforElement(FindCareLink);
		} else {
		System.out.println("Not found Expected window");
		driver.switchTo().window(ParentWindow);
	}
		waitforElement(FindCareLink);
		if (validate(FindCareLink)) {
			System.out.println("User is on Find care Page");
			return new FindCarePage(driver);
		} else
			return null;
	}
	
	public DrugCostEstimatorPage clickonEdityourDrugs() {

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(editDrugsLink);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", editDrugsLink);
		jsClickNew(editDrugsLink);
		waitforElement(addDrug);
		if (validate(addDrug)) {
			System.out.println("User is on DCE Page");
			return new DrugCostEstimatorPage(driver);
		} else
			return null;
	}
	
	public void validateViewMoreplansComparePage() {
		validateNew(backToAllPlansLink);
		
		WebElement viewMore = driver.findElement(By.xpath("//span[text()='Scroll Plans Right']/ancestor::button"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		for(int i=0;viewMore.isEnabled();){
			viewMore.click();
			System.out.println("Clicked no. of times : " + i);
			i++;	
		}
		WebElement RightButtonDisabled = 
			    wait.until(ExpectedConditions
			                   .visibilityOfElementLocated(
			                        By.xpath("//span[text()='Scroll Plans Right']/ancestor::button[attribute::disabled]")));
		validateNew(RightButtonDisabled);
		System.out.println("Validated Right arrow is Disabled");
		
	}
	
	public void validateViewlessplansComparePage() {
		validateNew(backToAllPlansLink);		
		WebElement viewLess = driver.findElement(By.xpath("//span[text()='Scroll Plans Left']/ancestor::button"));
		WebDriverWait wait = new WebDriverWait(driver, 60);
		for(int i=0;viewLess.isEnabled();){
			viewLess.click();
			System.out.println("Clicked no. of times : " + i);
			i++;	
		}
		WebElement LeftButtonDisabled = 
			    wait.until(ExpectedConditions
			                   .visibilityOfElementLocated(
			                        By.xpath("//span[text()='Scroll Plans Left']/ancestor::button[attribute::disabled]")));
		validateNew(LeftButtonDisabled);
		System.out.println("Validated Left arrow is Disabled");
	}
	
	/**
	 * Validate the Agent Mode Banners and Enrolled Plan overlay
	 * @param planName
	 */
	public void validateMemberDetails(DataTable userData) {

		List<DataTableRow> givenAttributesRow = userData.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String plan = givenAttributesMap.get("Plan Name");
		String enrolledPlan = givenAttributesMap.get("Enrolled Plan Name");
		String drugs = givenAttributesMap.get("Drugs");
		String providers = givenAttributesMap.get("Providers");
		String fname = givenAttributesMap.get("First Name");
		String lname = givenAttributesMap.get("Last Name");
		String dob = givenAttributesMap.get("DOB");
		String mbi = givenAttributesMap.get("MBI");
		
		allSet();
		
		System.out.println("######### "+agentModeBanner.getText().trim()+"#########");
		Assert.assertEquals("You are in Agent mode viewing "+fname+" "+lname+" profile", agentModeBanner.getText().trim());
		
		if(Strings.isNullOrEmpty(enrolledPlan)) {
			System.out.println("#########Empty Profile#########");
			Assert.assertEquals("DOB: "+dob, memberDOB.getText().trim());
			Assert.assertEquals(fname+" "+lname, memberName.getText().trim().toUpperCase());
		}
		
		else if(enrolledPlan.contains("Group") || enrolledPlan.contains("D-SNP")) {
			Assert.assertEquals("(#"+mbi+")", memberMBI.getText().trim());
			Assert.assertEquals(fname+" "+lname, memberName.getText().trim().toUpperCase());
			Assert.assertEquals("DOB: "+dob, memberDOB.getText().trim());
		}
		else {
			CommonUtility.waitForPageLoad(driver, currentPlanToggle, 5);
			Assert.assertEquals(enrolledPlan, enrolledPlanName.getText().trim());
			Assert.assertEquals("(#"+mbi+")", memberMBI.getText().trim());
			Assert.assertEquals(fname+" "+lname, memberName.getText().trim().toUpperCase());
			//Assert.assertEquals("DOB: "+dob, memberDOB.getText().trim());
			
		}
		
		//Validate Providers
		if(!providers.equalsIgnoreCase("no")) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", editDoctorsLink);
			validate(editDoctorsLink);
			String[] provider = providers.split(";");
			for(int i=0;i<provider.length;i++) {
				if(!StringUtils.isNullOrEmpty(providers)) {
					Assert.assertTrue(provider[i].split(":")[0].contains(providersList.get(i+1).findElement(By.cssSelector("th>span>span")).getText().trim()));
					System.out.println("#########"+providersList.get(i+1).findElement(By.cssSelector("th>span>span")).getText().trim()+"#########");
				}
			}
		}else {
			
			System.out.println("#########No Providers for this member#########");
		}
		
		if(!drugs.equalsIgnoreCase("no")) {
			validate(editDrugsLink);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", editDrugsLink);
			String[] drugName = drugs.split(",");
			for(int i=0;i<drugName.length;i++) {
				if(!StringUtils.isNullOrEmpty(drugs)) {
					Assert.assertTrue(drugName[i].contains(drugList.get(i+1).findElement(By.cssSelector("th>span>span")).getText().trim()));
					System.out.println("#########"+drugList.get(i+1).findElement(By.cssSelector("th>span>span")).getText().trim()+"#########");
				}
			}
		}else {
			System.out.println("#########No Drugs available for this member#########");
		}
		
	}
	
	/**
	 * Validate the Agent Mode Banners and Enrolled Plan overlay
	 * @param planName
	 */
	public void validateAgentModeBannersForNonMember(DataTable userData) {

		List<DataTableRow> givenAttributesRow = userData.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String plan = givenAttributesMap.get("Plan Name");
		String enrolledPlan = givenAttributesMap.get("Enrolled Plan Name");
		String drugs = givenAttributesMap.get("Drugs");
		String providers = givenAttributesMap.get("Providers");
		String fname = givenAttributesMap.get("First Name");
		String lname = givenAttributesMap.get("Last Name");
		String dob = givenAttributesMap.get("DOB");
		String mbi = givenAttributesMap.get("MBI");
		
		
		System.out.println("######### "+agentModeBanner.getText().trim()+"#########");
		Assert.assertEquals("You are in Agent mode viewing "+fname+" "+lname+" profile", agentModeBanner.getText().trim());
	}
	
	public void allSet() {
		CommonUtility.waitForPageLoad(driver, popupAccept, 60);
		popupAccept.click();
	}
	
	/**
	 * Navigate to Visitor Profile Page
	 * @return
	 */
	public VisitorProfilePage navigateToVisitorProfilePage() {
		shoppingCartIcon.click();
		if(driver.getCurrentUrl().contains("profile")) {
			CommonUtility.checkPageIsReadyNew(driver);
			return new VisitorProfilePage(driver);
		}else {
			System.out.println("Navigation to visitor profile is failed");
			return null;
		}
	}
}

