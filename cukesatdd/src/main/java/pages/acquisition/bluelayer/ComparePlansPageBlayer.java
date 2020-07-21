package pages.acquisition.bluelayer;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ole.WelcomePage;

public class ComparePlansPageBlayer extends UhcDriver {

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
	
	@FindBy(xpath=".//*[@id='emailSuccessMsgPopUp']/div/form/div[2]/button")
	private WebElement closeButtonthankyoumessagepopup;
	
	@FindBy(linkText ="Back to all plans")
	private WebElement topbackToPlanslink;
	
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
	
	@FindBy(xpath = "//td[contains(@class,'estimatedrugcost')][1]//div")
	public WebElement VerifyEstimatedDrugCost;

	@FindBy(xpath = "//a[contains(text(),'Edit') and contains(text(),'Provider')]")
	public WebElement EditproviderlistLink;

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
	
	@FindBy(xpath="//*[@class='view-more-link']")
	private WebElement viewDetailslink;
	
	@FindBy(xpath="//*[text()='Save Plan']")
	private WebElement savePlanIcon;
	
	@FindBy(xpath="//*[text()='Saved']")
	private WebElement savedPlanIcon;
	
	@FindBy(xpath="//a[@id='addanotherplanbutton2']")
	private WebElement add3Plan;
	
	@FindBy(xpath="//button[@id='addanotherplanbutton']")
	private WebElement addPlanButton;
	
	@FindBy(xpath="//h3[@id='favouriteplanSelect2']")
	private WebElement plan3added;
	
	@FindBy(xpath = "//*[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__icon')]//img")
   	private WebElement callsam;
   	
   	@FindBy(xpath = "//*[@id='sam-call-button']/div/span[1]")
   	private WebElement callsamtooltip;
   	
   	@FindBy(xpath ="//*[@id='sam-call-modal']/div/div")
   	private WebElement callSamPopup;
   	
   	
   	@FindBy(xpath ="//*[@id='sam-call-modal']/div/div/div[2]/p[1]/a[1]")
   	private WebElement CallSamModel;
   	
   	@FindBy(xpath ="//*[@id='sam-call-modal']/div/div/div[2]/p[1]/a[1]")
   	private WebElement CallSamTFN;
   	
   	@FindBy(xpath ="//*[@id='sam-call-modal']/div/div/div[1]/a")
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
	
		
	public ComparePlansPageBlayer(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//openAndValidate();
	}


	@Override
	public void openAndValidate() {
		// TODO Auto-generated method stub
		
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

   	public WelcomePage Enroll_OLE_Plan_UHC() throws InterruptedException {
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
   	
   	public WelcomePage Enroll_OLE_newPlancompare_UHC() throws InterruptedException {
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


	public void validatingthankyoumessage() {
		// TODO Auto-generated method stub
		closeButtonthankyoumessagepopup.click();
		System.out.println("Thank you Message pop up is closed");
	}


	public void validatetopbacktoplanslink() {
		// TODO Auto-generated method stub
		System.out.println("i am in");
    	topbackToPlanslink.click();
    	System.out.println("i clicked");
    	if (driver.getCurrentUrl().contains("health-plans.html#/plan-summary"))
    	{
    		Assert.assertTrue(true);
    	}
    	
    	else Assert.assertTrue(false);
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
		Assert.assertTrue(validate(VerifyProviderCount), "Verified Provider Count not Displayed");
		Assert.assertTrue(validate(EditproviderlistLink), "Verified Edit Provider Link not Displayed");
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
	
	public void clickOnBacktoPlans(){
		validateNew(backToAllPlansLink);
		backToAllPlansLink.click();
		System.out.println("Clicked on Back to plans");
	}
	public void validatePlanComparePage() {
		validateNew(backToAllPlansLink);
		validateNew(validateprintbutton);
		validateNew(validateemailbutton);
		validateNew(removeLink);
		//validateNew(viewDetailslink);
		//validateNew(savePlanIcon);
		System.out.println("Validated all links plan compare");
		
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
     
     public ComparePlansPageBlayer validateCallSam() throws InterruptedException {
         boolean present;
         try {
         validateNew(callsam);
         present = true;
         } catch (NoSuchElementException e) {
         present = false;
         }
         if (present) {
           System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
           return new ComparePlansPageBlayer(driver);
         }
         else
         	System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
        return null;
 	}
 	
 	public ComparePlansPageBlayer validateCallSamContent() throws InterruptedException {
 		
 		Actions action = new Actions(driver);
 		WebElement element = callsam;
 		action.moveToElement(element).perform();
 		String toolTipText = callsamtooltip.getText();
 		System.out.println("====================================================================");
 		System.out.println(toolTipText);
 		System.out.println("====================================================================");
 		
         if (CallSam.equalsIgnoreCase(toolTipText)) {
           System.out.println("Call sticky action menu roll out and contain the text Call a Licensed Insurance Agent");
           return new ComparePlansPageBlayer(driver);
         }
         else
         	System.out.println("No Call sticky action menu didn't roll out and doesn't contain the text Call a Licensed Insurance Agent");
        return null;
 	}
 	
 	public ComparePlansPageBlayer  validateCallpopup() throws InterruptedException {
 		//CommonUtility.checkPageIsReady(driver);
 		callsam.click();
 		System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");		
 		driver.switchTo().activeElement();
 		System.out.println(CallSamTFN.getText());
 		CallSamTFNClose.click();
 		validateNew(callsam);		
 		return null;
 	}
 	
 	public ComparePlansPageBlayer validateChatSam() throws InterruptedException {
         boolean present;
         try {
         validateNew(chatsam);
         present = true;
         } catch (NoSuchElementException e) {
         present = false;
         }
         if (present) {
           System.out.println("@@@@@@@@@ Able to find TFN widget @@@@@@@@@");
           return new ComparePlansPageBlayer(driver);
         }
         else
         	System.out.println("@@@@@@@@@ No TFN widget @@@@@@@@@");
        return null;
 	}
 	
 	public ComparePlansPageBlayer validateChatSamContent() throws InterruptedException {
 		
 		Actions action = new Actions(driver);
 		WebElement element = chatsam;
 		action.moveToElement(element).perform();
 		String ChattoolTipText = chatsamtooltip.getText();
 		System.out.println("====================================================================");
 		System.out.println(ChattoolTipText);
 		System.out.println("====================================================================");
 		
         if (ChatSamText.equalsIgnoreCase(ChattoolTipText)) {
           System.out.println("Chat sticky action menu roll out and contain the text Chat with a Licensed Insurance Agent");
           return new ComparePlansPageBlayer(driver);
         }
         else
         	System.out.println("No Chat sticky action menu didn't roll out and doesn't contain the text Chat with a Licensed Insurance Agent");
        return null;
 	}
 	
 	public ComparePlansPageBlayer  validateChatpopup() throws InterruptedException {
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
 	
 	public ComparePlansPageBlayer navigateToPlanDetail() {
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement PlanDetailsLink = driver.findElement(By.xpath("(//*[contains(text(),'View details')])[1]"));
				CommonUtility.waitForPageLoadNew(driver, PlanDetailsLink, 30);
				PlanDetailsLink.click();
				System.out.println("View Plan Details Link is clicked");
		
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("#/details")) 
		{	
			return new ComparePlansPageBlayer(driver);
		}
		return null;
	}
 	
 	public ComparePlansPageBlayer navigateToPlanDetailfromplanCompare() {
		CommonUtility.checkPageIsReadyNew(driver);
		WebElement PlanDetailsLink = driver.findElement(By.xpath("(//*[contains(text(),'View Plan Details')])[1]"));
				CommonUtility.waitForPageLoadNew(driver, PlanDetailsLink, 30);
				PlanDetailsLink.click();
				System.out.println("View Plan Details Link is clicked");
		
		CommonUtility.checkPageIsReadyNew(driver);
		System.out.println(driver.getCurrentUrl());
		if (driver.getCurrentUrl().contains("#/details")) 
		{	
			return new ComparePlansPageBlayer(driver);
		}
		return null;
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
 	
 	public void validateAddDoctors() {
		validateNew(backToAllPlansLink);
		validateNew(yourDoctorsBanner);
		validateNew(addDoctorsLink);
		System.out.println("Verified Add Doctors Section");
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
 	
 	public void validatePlansAddedonPlancompareforVisitorProfile(String plans) {
		List<WebElement> allMAPlans = driver.findElements(By.xpath("//*[@class='planNameVisibility']//h3"));
		String[] plan = plans.split(",");
		for(int i=0;i<allMAPlans.size();i++) {
			Assert.assertEquals(plan[i], allMAPlans.get(i).getText().trim());
		}
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
     
}

