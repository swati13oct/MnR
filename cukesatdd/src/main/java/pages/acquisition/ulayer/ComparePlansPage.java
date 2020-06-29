package pages.acquisition.ulayer;
import java.util.List;
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
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
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

	@FindBy(xpath = "//*[@id='sam-call-button']/div/span[2]/img")
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
	
		
	public ComparePlansPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}


	@Override
	public void openAndValidate() {
		checkModelPopup(driver,45);
		
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
		
    public ComparePlansPage validateCallSam() throws InterruptedException {
        boolean present;
        try {
        validateNew(callsam);
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
	
	public ComparePlansPage validateCallSamContent() throws InterruptedException {
		
		Actions action = new Actions(driver);
		WebElement element = callsam;
		action.moveToElement(element).perform();
		String toolTipText = callsamtooltip.getText();
		System.out.println("====================================================================");
		System.out.println(toolTipText);
		System.out.println("====================================================================");
		
        if (CallSam.equalsIgnoreCase(toolTipText)) {
          System.out.println("Call sticky action menu roll out and contain the text Call a Licensed Insurance Agent");
          return new ComparePlansPage(driver);
        }
        else
        	System.out.println("No Call sticky action menu didn't roll out and doesn't contain the text Call a Licensed Insurance Agent");
       return null;
	}
	
	public ComparePlansPage  validateCallpopup() throws InterruptedException {
		//CommonUtility.checkPageIsReady(driver);
		callsam.click();
		System.out.println("@@@@@@@@@@@@@@@ Call Icon Clicked @@@@@@@@@@@@@@@");		
		driver.switchTo().activeElement();
		System.out.println(CallSamTFN.getText());
		CallSamTFNClose.click();
		validateNew(callsam);		
		return null;
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
	}	
	
	public void validateAddDoctors() {
		validateNew(backToAllPlansLink);
		validateNew(yourDoctorsBanner);
		validateNew(addDoctorsLink);
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
		jsClickNew(editDoctorsLink);

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
		jsClickNew(addDoctorsLink);

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
}

