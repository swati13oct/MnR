package pages.acquisition.ulayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import pages.acquisition.ole.WelcomePage;
import atdd.framework.UhcDriver;
public class ComparePlansPage extends UhcDriver {

	
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

	@FindBy(xpath = "//a[text()='Edit provider list']")
	public WebElement EditproviderlistLink;
	
	@FindBy(xpath = "//td[contains(@class,'estimatedrugcost')][1]//div")
	public WebElement VerifyEstimatedDrugCost;
	
	@FindBy(xpath=".//*[@id='emailSuccessMsgPopUp']/div/form/div[2]/button")
	private WebElement closeButtonthankyoumessagepopup;

	
		
	public ComparePlansPage(WebDriver driver) {
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
		validate(VerifyProviderCount);
		System.out.println("Verified Provider Count Displayed");
		validate(EditproviderlistLink);
		System.out.println("Verified Edit Provider Link Displayed");

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
	
	//--------------------------------------------
	//note: begin - added for deeplink validaton
	/**
	 * Alternative to validate deeplink in email
	 * Get the deeplink from network's postData from the email plan list request
	 * Use that deeplink to open page and validate content at later step
	 */
	public String getEmailDeepLink() {
		String deepLinkEntryLine=null;
		List<LogEntry> entries = driver.manage().logs().get(LogType.PERFORMANCE).getAll();
	    for (LogEntry entry : entries) {
	    	String line=entry.getMessage();
	    	if (line.toLowerCase().contains("deeplink")) {
	    		deepLinkEntryLine=line;
	    		System.out.println("TEST found line="+line);
	    	}
	    }
	    Assert.assertTrue("PROBLEM - unable to locate the network entry that contains the deeplink value", deepLinkEntryLine!=null);
	    JSONParser parser = new JSONParser();
	    JSONObject jsobObj=null;
	    try {
	    	jsobObj = (JSONObject) parser.parse(deepLinkEntryLine);
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - unable to convert target string into json object", false);
		}
	    JSONObject messageObj = (JSONObject) jsobObj.get("message");
	    Assert.assertTrue("PROBLEM - unable to locate message json object", messageObj!=null);
	    JSONObject paramsObj = (JSONObject) messageObj.get("params");
	    Assert.assertTrue("PROBLEM - unable to locate message json object", paramsObj!=null);
	    JSONObject requestObj = (JSONObject) paramsObj.get("request");
	    Assert.assertTrue("PROBLEM - unable to locate message json object", requestObj!=null);
	    System.out.println("TEST - headersObj="+requestObj.toString());
	    String postDataStr = (String) requestObj.get("postData");
	    Assert.assertTrue("PROBLEM - unable to locate postData string", postDataStr!=null);
	    String tmp=postDataStr.replace("\\\"{", "{").replace("}\\\"", "}");
	    tmp=tmp.replace("\\\\\"", "\"");
	    System.out.println("TEST - tmp="+tmp);
	    try {
	    	jsobObj = (JSONObject) parser.parse(tmp);
		} catch (ParseException e) {
			e.printStackTrace();
			Assert.assertTrue("PROBLEM - unable to convert postDataStr string into json object", false);
		}
	    JSONObject toObj = (JSONObject) jsobObj.get("to");
	    Assert.assertTrue("PROBLEM - unable to locate 'to' json object", toObj!=null);
	    JSONObject contactAttributesObj = (JSONObject) toObj.get("contactAttributes");
	    Assert.assertTrue("PROBLEM - unable to locate 'contactAttributes' json object", contactAttributesObj!=null);
	    JSONObject subscriberAttributesObj = (JSONObject) contactAttributesObj.get("subscriberAttributes");
	    Assert.assertTrue("PROBLEM - unable to locate 'subscriberAttributes' json object", subscriberAttributesObj!=null);
	    System.out.println("TEST - subscriberAttributesObj="+subscriberAttributesObj.toString());
	    String deepLinkStr = (String) subscriberAttributesObj.get("deepLink");
	    Assert.assertTrue("PROBLEM - unable to locate deepLinkStr string", deepLinkStr!=null);
	    System.out.println("TEST - *** deepLinkStr="+deepLinkStr);
	    return deepLinkStr;
	}

	@FindBy(xpath="//h2[contains(@class,'zipcodePrint') and not(contains(@class,'ng-hide'))]")
	private WebElement cmpPgHeader;
	
	@FindBy(xpath="//div[@id='topRowCopy']//div[@ng-repeat='i in count']")
	private List<WebElement> listOfCmpPlansColumns;
	
	@FindBy(xpath="//div[@id='topRowCopy']//a[contains(@class,'added')]")
	private List<WebElement> planCompare_listOfSavedHearts;
	
	@FindBy(xpath="//table[@id='fixTable']//tr")
	private List<WebElement> listOfRowsInPlanCompareTbl;
	
	public HashMap<String, String> collectInfoVppPlanComparePg(String planType, String forWhat) {
		System.out.println("Proceed to collect the info on vpp compare page =====");
		HashMap<String, String> result=new HashMap<String, String>();
		result.put("Page Header", cmpPgHeader.getText());
		
		result.put("Columns Count", String.valueOf(listOfCmpPlansColumns.size()));
		for (int i=1; i<=listOfCmpPlansColumns.size(); i++) {
			String columnXpath="//div[@id='topRowCopy']//div[@ng-repeat='i in count']["+i+"]";
			
			String planNameXpath=columnXpath+"//h3";
			result.put(i+"- Plan Name", "none");
			try {
				WebElement e=driver.findElement(By.xpath(planNameXpath));
				if (validate(e))
					result.put(i+"- Plan Name", e.getAttribute("textContent"));
			} catch (Exception e) {
				System.out.println("no plan name info for '"+i+"- Plan Name'");
			}
			
			String heartXpath=columnXpath+"//a[contains(@class,'added')]";
			result.put(i+"- Plan Heart", "none");
			try {
				WebElement e=driver.findElement(By.xpath(heartXpath));
				if (validate(e)) 
					result.put(i+"- Plan Heart", "saved");
			} catch (Exception e) {
				System.out.println("no plan heart info for '"+i+"- Plan Heart'");
			}
			 
		}
		int cellsPerRow=listOfCmpPlansColumns.size()+1;
		result.put("Total Table Rows", String.valueOf(listOfRowsInPlanCompareTbl.size()));
		//note: loop through each row
		int rowStartAt=1;
		if (planType.equals("PDP")) {
			rowStartAt=24;
		}
		for (int i=rowStartAt; i<=listOfRowsInPlanCompareTbl.size(); i++) {
			String rowXpath="//table[@id='fixTable']//tr["+i+"]//td";
			List<WebElement> tmp=driver.findElements(By.xpath(rowXpath));
			if (tmp.size()==1) {
				// only one cell then that's the table section header
				String cellXpath="//table[@id='fixTable']//tr["+i+"]//td[1]";
				WebElement e=driver.findElement(By.xpath(cellXpath));
				String key="R"+i+"C1";
				String value=e.getAttribute("textContent");
				result.put("R"+i+"C1", value);
				System.out.println("TEST - "+forWhat+" - key='"+key+"' | value='"+value+"'");
				for (int j=1; j<=cellsPerRow; j++) {
					key="R"+i+"C"+j;
					result.put(key, "none");
					System.out.println("TEST - "+forWhat+" - key='"+key+"' | value='"+value+"'");
				}
			} else { //note: data row, collect text of each cell
				for (int j=1; j<=cellsPerRow; j++) {
					String cellXpath="//table[@id='fixTable']//tr["+i+"]//td["+j+"]";
					WebElement e=driver.findElement(By.xpath(cellXpath));
					String key="R"+i+"C"+j;
					String value=e.getText();
					result.put(key, value);
					System.out.println("TEST - "+forWhat+" - key='"+key+"' | value='"+value+"'");
				}
			}
		}
		System.out.println("Finished collecting the info on vpp compare page =====");
		return result;
	}
	@FindBy(xpath="//div[@class='popup-modal active']//h2[@id='plan-year-modal-header']")
	private WebElement planYearPopup;
	
	@FindBy(xpath="//div[contains(@class,'planOptions')]//label[@for='current_Year']")
	private WebElement currentYearSelection;
	
	@FindBy(xpath="//button[@id='lisGoBtn']")
	private WebElement planYearPopupGoButton;

	@FindBy(xpath="//div[contains(@class,'planOptions')]//label[@for='next_Year']")
	private WebElement nextYearSelection;

	public void handlePlanYearSelectionPopup(String planType) {
		if (!(planType.equalsIgnoreCase("MS"))) {
		CommonUtility.checkPageIsReadyNew(driver);
		CommonUtility.waitForPageLoad(driver, planYearPopup, 5);
		if (validate(planYearPopup)) {
			if (validate(nextYearSelection)) {
				nextYearSelection.click();
				CommonUtility.waitForPageLoadNew(driver, planYearPopupGoButton, 10);
				planYearPopupGoButton.click();
			}
		}
		}
	}
	
	public String comparePageItem(String targetKey, HashMap<String, String> origPage, HashMap<String, String> emailage) {
		String failedMessage="NONE";
		System.out.println("TEST - validate content for map key="+targetKey+"...");
		if (!(origPage.get(targetKey)).equals(emailage.get(targetKey))) {
			//note: keep this for now in case anything needs to be bypassed
			//if (targetKey.equals("xyz")) { 
			//	failedMessage="BYPASS validation until fix (tick# xxxxx) - ";
			//	failedMessage=failedMessage+"item '"+targetKey+"' mismatch | original='"+origPage.get(targetKey)+"' | email='"+emailage.get(targetKey)+"'";
			//} else {
				finalResult=false;
				failedMessage="item '"+targetKey+"' mismatch | original='"+origPage.get(targetKey)+"' | email='"+emailage.get(targetKey)+"'";
			//}
		}
		System.out.println("TEST - failedMessage="+failedMessage);		
		return failedMessage;
	}
	
	boolean finalResult=true;
	public List<String> validatePlanCompareEmailDeeplink(String planType, String deepLinkStringId, String infoMapStringId, String deepLink, HashMap<String, String> origPage) {
		List<String> testNote=new ArrayList<String>();
		System.out.println("Proceed to validate the original page content vs page content from email deeplnk for plan compare...");
		List<String> listOfFailure=new ArrayList<String>();
		String failedMessage="";
		
		System.out.println("Proceed to validate the original page content vs page content from email deeplnk for plan compare...");

		
		System.out.println("Collect info from page content of the plan compare");
		HashMap<String, String> emailage=collectInfoVppPlanComparePg(planType, "email deepLink");
		
		String targetKey="Page Header";
		String failedmessage=comparePageItem(targetKey, origPage, emailage);
		if (failedmessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);

		targetKey="Columns Count";
		int numPlanColumns=Integer.valueOf(origPage.get(targetKey));
		failedmessage=comparePageItem(targetKey, origPage, emailage);
		if (failedmessage.contains("mismatch")) 
			listOfFailure.add(failedMessage);	
		if (failedMessage.contains("BYPASS")) 
			testNote.add(failedMessage);

		for (int i=1; i<=numPlanColumns; i++) {
			targetKey=i+"- Plan Name";
			failedmessage=comparePageItem(targetKey, origPage, emailage);
			if (failedmessage.contains("mismatch")) 
				listOfFailure.add(failedMessage);	
			if (failedMessage.contains("BYPASS")) 
				testNote.add(failedMessage);

			targetKey=i+"- Plan Heart";
			failedmessage=comparePageItem(targetKey, origPage, emailage);
			if (failedmessage.contains("mismatch")) 
				listOfFailure.add(failedMessage);	
			if (failedMessage.contains("BYPASS")) 
				testNote.add(failedMessage);
		}
		
		int cellsPerRow=numPlanColumns+1;
		int totalTableRows=Integer.valueOf(origPage.get("Total Table Rows"));
		int startRowIndex=1;
		if (planType.equals("PDP")) {
			startRowIndex=24;
		}
		for (int r=startRowIndex; r<=totalTableRows; r++) {
			for (int c=1; c<=cellsPerRow; c++) {
				targetKey="R"+r+"C"+c;
				failedmessage=comparePageItem(targetKey, origPage, emailage);
				if (failedmessage.contains("mismatch")) 
					listOfFailure.add(failedMessage);	
				if (failedMessage.contains("BYPASS")) 
					testNote.add(failedMessage);
			}		
		}
		System.out.println("Finished validation for the original page content vs page content from email deeplnk for plan compare ===========");
		Assert.assertTrue("PROBLEM - original page content and email deeplink page content are not the same. total items mismatch='"+listOfFailure.size()+"'. list of mismatch: "+listOfFailure , finalResult);
		return testNote;
	}
	//note: end- added for deeplink validaton
	//--------------------------------------------

}

