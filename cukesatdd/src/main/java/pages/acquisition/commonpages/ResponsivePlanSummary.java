package pages.acquisition.commonpages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.bluelayer.PlanComparePage;
import pages.member_deprecated.ulayer.Rallytool_Page;
import pages.mobile.acquisition.ulayer.VPPAarpNeedAStepBackWidgetMobile;
import pages.mobile.acquisition.ulayer.VPPAarpNeedHelpWidgetPageMobile;
import pages.mobile.acquisition.ulayer.VPPNeedMoreInformationWidgetMobile;
import pages.mobile.acquisition.ulayer.VPPRequestSendEmailPageMobile;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ResponsivePlanSummary extends UhcDriver{
	
	//US504467
		
		@FindBy(xpath = "(.//*[contains(text(),'View')])[12]")
        private WebElement planYear;
    
		@FindBy(xpath = "(//*[@id='enrollMAButton']/span)[1]")
        private WebElement enrollNowbtn;
		
		 @FindBy(xpath ="(.//*[@id='pdpDrugCostEstimatorLink'])[1]")
         private WebElement enterDrugInformationlnk;
		
		 @FindBy(xpath = "(//a[contains(text(),'Enter drug information')])[1]")
         private WebElement enterDrugMAInformationlnk;
		
		@FindBy(xpath = "//*[@class='ng-valid ng-dirty']/span/div[1]/p")
		private WebElement errorMessageincorrect;
		
		@FindBy(xpath = "//*[@id='zip-form']/span/div[1]/p")
		private WebElement errorMessageincorrect2;
		
		@FindBy(xpath=".//*[@id='add-drug']/section")
           WebElement addaDrug;
		
		//@FindBy(id = "zipcode")
		@FindBy(xpath = "//*[@id='zipcode']")
		private WebElement zipCodeField;
		
 		@FindBy(xpath="//*[contains(text(),'HMO')]")
 		List<WebElement> maPlanElement;
		
		@FindBy(xpath = "//div[@class='disabledprint ng-scope']")
		List<WebElement> pdpPlanElement;
		
		@FindBy(className="change-location-link")
		private WebElement changeLoationLink;
		
		@FindBy(xpath="//*[@class='content-cols']/div[1]/h3")
		private WebElement planHighlightsHeader;
		
		@FindBy(xpath="//h2[contains(text(),'We have')]")
		private WebElement countyNameDetail;
		
		@FindBy(xpath="//a[contains(text(),'Find a provider')]")
		private WebElement providerSearchLink;
		
		@FindBy(xpath="//*[@class='content-cols']/div[1]/ul/li")
		private List<WebElement> marketingBullet;
		
		@FindBy(xpath="//div[2]/div/div/span[1]/span")
		private List<WebElement> planCountList;
		
		@FindBy(className="plan-index")
		private List<WebElement> planIndexList;
		
		@FindBy(xpath = "//div[@class='tab med-supp plancountheight']/div")
		//@FindBy(xpath = "(//*[@id='site-wrapper']//div[@class='content-section']//div[@class='parbase vppClient section']//div[@class='parsys planCountPar']//div[@class='tab-contents']/span[@class='trigger-closed'])[1]")
		private WebElement showMsPlans;
		
		@FindBy(xpath="//*[contains(text(),'Start Plan Selector')]")
		private WebElement planSelector;
		
		@FindBy(className="errmsgcolor")
		private WebElement errmsgcolor;
		
		@FindBy(xpath="//a[@class='cta-button secondary value-added-services']")
        private WebElement vasButton;
		
		/*@FindBy(xpath="//html/body/div[4]/div[2]/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div/span[1]")
		private WebElement showMaPlans;*/
	
		 @FindBy(xpath="(//*[contains(text(),'Add to compare')])[1]")
		    private WebElement chkBoxAddtoCompare1;
		    
		 @FindBy(xpath="(//*[contains(text(),'Add to compare')])[2]")
		    private WebElement chkBoxAddtoCompare2;
		    
		 @FindBy(xpath="(//*[contains(text(),'Add to compare')])[3]")
		  private WebElement chkBoxAddtoCompare3;
		    
		    @FindBy(xpath="(//*[contains(text(),'Add to compare')])[4]")
		    private WebElement chkBoxAddtoCompare4;
		    
		    @FindBy(xpath="(//*[contains(text(),'Add to compare')])[5]")
		    private WebElement chkBoxAddtoCompare5;
		    
		    //@FindBy(xpath="//*[@id='plan-list-1']//div[@class='swiper-container']/div/div[4]//div[@class='content-secondary']//div[@class='compare-box']/span[4]/a")		  
		    @FindBy(xpath="//*[@id='plan-list-1']/div/div[2]/div/div[4]/div[2]/div/div/span[4]/a")		                  
		    private WebElement comparePlans;
		    
		   // @FindBy(xpath="(.//*[text()='View details'])[1]")
		    @FindBy(xpath="(//a[@class='view-more-link'])[1]")
		    private WebElement viewDetails;
		    
			@FindBy(xpath="//a[@id='backtoplansummarypage']")
			private WebElement backtoallPlans;
		    
		   // @FindBy(xpath="(.//*[@class='remove-button'])[1]")
		    @FindBy(xpath="//*[@id='topRowCopy']/div[2]/div[1]//span[@class='remove-button']")
		    private WebElement removePlanlnk;
		    
		    //@FindBy(xpath="(.//*[@class='remove-button'])[2]")
		    @FindBy(xpath=".//*[@id='topRowCopy']/div/div[3]/span")
		    private WebElement removePlanlnk1;
		    
		    //@FindBy(xpath=".//*[@id='fixTable']/tbody/tr[24]/td/p")
		    @FindBy(xpath=".//*[@id='fixTable']/tbody/tr[30]/td/p")
		    private WebElement footNote;
		    
		    @FindBy(xpath=".//*[@id='site-wrapper']/div[4]/div/div[1]/div/div/div/div/div/div/div/div[2]/div[3]/p[1]")
		    private WebElement disclaimerTxt;
		    
		    
//Medical Benefits
		    
		    //@FindBy (xpath=".//*[@id='fixTable']/tbody/tr[2]/td[2]")
		    @FindBy (xpath="//table[@id='fixTable']//p[text()='Monthly Premium']/following::td[1]/div/div")
		    private WebElement monthlypremium1;
		    
		   //@FindBy (xpath= ".//*[@id='fixTable']/tbody/tr[2]/td[4]")
		    @FindBy(xpath= "//table[@id='fixTable']//p[text()='Monthly Premium']/following::td[2]/div/div")
		    private WebElement monthlypremium2;
		    
		    @FindBy (xpath= "//table[@id='fixTable']//p[text()='Annual Out of Pocket Maximum']")
		    private WebElement outofpocketmaximum;
		    
		    @FindBy (xpath="//table[@id='fixTable']//p[text()='Monthly Premium']")
		    private WebElement monthlypremium;
		    
		    @FindBy (xpath="//table[@id='fixTable']//p[text()='Annual Out of Pocket Maximum']/following::td[1]/div/div")
		    private WebElement outofpocket1;
		    
		    @FindBy (xpath="//table[@id='fixTable']//p[text()='Annual Out of Pocket Maximum']/following::td[2]/div/div")
		    private WebElement outofpocket2;
		    
		    @FindBy(xpath="(.//span[contains(text(),'View Plans')][@class='trigger-closed'])[1]")
		//  @FindBy(xpath=".//*[@id='site-wrapper']/div[4]/div/div[1]/div/div/div/div/div[1]/div/div[2]/div[1]/div[2]/div/div[2]/div[1]/div/span[3]")
		    private WebElement showMaPlans;
			
			@FindBy(xpath="//*[contains(text(),'Medicare Prescription')]/following-sibling::span[2]")
			private WebElement showPdpPlans;
			
//prescription drug benefits
			
			//@FindBy (xpath="//*[@id='fixTable']/tbody/tr[17]/td[1]/p")
			@FindBy (xpath="//*[contains(text(),'Tier 1: Preferred Generic Drugs')]/parent::td[1]/parent::tr/td[2]/div[1]/span[1]/strong")
		    private WebElement tier1value;			
			
			@FindBy (xpath="//*[contains(text(),'Tier 1: Preferred Generic Drugs')]/parent::td[1]/parent::tr/td[3]/div[1]/span[1]/strong")
		    private WebElement tier1value1;
			// .//*[@id='fixTable']/tbody/tr[17]/td[2]/span[1]/strong
			
			@FindBy (xpath="//*[contains(text(),'Tier 1: Preferred Generic Drugs')]/parent::td[1]/parent::tr/td[3]/div[1]/span[1]/strong")
		    private WebElement tier1value2;
			// .//*[@id='fixTable']/tbody/tr[22]/td[6]/span[1]/strong
			
//Optional Services
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[18]/td[1]/p")
		    private WebElement optionalDental;
			
			@FindBy (xpath=".//*[@id='fixTable']/tbody/tr[18]/td[2]/div[1]/div[2]/div/strong")			              
		    private WebElement optionalDental1;
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[18]/td[3]/div[1]/div[1]/div/strong")
		    private WebElement optionalDental2;
			
			@FindBy (xpath=".//*[@id='fixTable']/tbody/tr[19]/td[1]/p")
		    private WebElement highOptionDental;
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[19]/td[2]/div[1]/div[1]/div/strong")
		    private WebElement highOptionDental1;
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[19]/td[3]/div[1]/div[2]/div/strong")
		    private WebElement highOptionDental2;
			
//Plan Costs
			//@FindBy(xpath="//*[@id='fixTable']/tbody/tr[22]/td[1]/p")
			@FindBy (xpath="//table[(@id='fixTable')]//span[contains(text(),'Plan Premium')]")
		    private WebElement planPremium;
			
			@FindBy (xpath="//table[(@id='fixTable')]//span[contains(text(),'Plan Premium')]/following::strong[1]")
		    private WebElement planPremium1;
			
			@FindBy (xpath="//table[(@id='fixTable')]//span[contains(text(),'Plan Premium')]/following::strong[3]")
		    private WebElement planPremium2;
			
			@FindBy (xpath="//table[(@id='fixTable')]//p[contains(text(),'Medical Benefits')]")
		    private WebElement medicalBenefits;
			
			@FindBy (xpath="//table[(@id='fixTable')]//p[contains(text(),'Medical Benefits')]/following::strong[1]")
		    private WebElement medicalBenefits1;
			
			@FindBy (xpath="//table[(@id='fixTable')]//p[contains(text(),'Medical Benefits')]/following::strong[2]")
		    private WebElement medicalBenefits2;
			
		@FindBy	(xpath="//span[@class='remove-plan-text show']/p")
		private WebElement errorMessage;
			 

	private PageData vppPlanSummary;

	public JSONObject vppPlanSummaryJson;
	
	public ResponsivePlanSummary(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	//	CommonUtility.waitForPageLoad(driver, responsivevpppage, CommonConstants.TIMEOUT_30);

		String fileName = CommonConstants.VPP_PLAN_SUMMARY_PAGE_DATA;
		vppPlanSummary = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		//openAndValidate();
	}
	public ResponsivePlanSummary(WebDriver driver, String url) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.VPP_PLAN_SUMMARY_PAGE_DATA;
		vppPlanSummary = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
		}
		// TODO Auto-generated constructor stub
		// ADD JSON Validation Path if required
	

	@Override
	public void openAndValidate() {
		validate(showMsPlans);		
	// validate(showMsPlans);
	//	validate(viewMaPlans);
	//	validate(viewPdpPlans);
	//	validate (viewSnpPlans);
	//	vppPlanSummaryJson = formJsonObject(vppPlanSummary);
		// TODO Auto-generated method stub
		// ADD elements that needed to validate
	}
	
	public JSONObject getPlanSummaryActualData(String planName) {
	String fileName = null;
	if (planName.contains("HMO")) {
		fileName = "maplansummary.json";
		JSONObject jsonObject = getActualJsonObject(fileName, planName, maPlanElement);
		return jsonObject;

	}
	if (planName.contains("PDP")) {
		fileName = "pdpplansummary.json";
		JSONObject jsonObject = getActualJsonObject(fileName, planName, maPlanElement);
		return jsonObject;
	}
	if (planName.contains("Regional PPO")) {
		fileName = "mamultistateplansummary.json";
		JSONObject jsonObject = getActualJsonObject(fileName, planName, maPlanElement);
		return jsonObject;

	}

	return null;
}


private JSONObject getActualJsonObject(String fileName, String planName, List<WebElement> planElement) {
	System.out.println(fileName);
	vppPlanSummary = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
	for (WebElement plan : planElement) {
		if (plan.getText().contains(planName)) {

			JSONObject jsonObject = new JSONObject();
			for (String key : vppPlanSummary.getExpectedData().keySet()) {
				WebElement element = findChildElement(vppPlanSummary.getExpectedData().get(key), plan);
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
			return jsonObject;

		}
	}
	return null;
}

public void selectAddToCompareCheckboxes() throws InterruptedException  {
	
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,600)", "");
	validate (chkBoxAddtoCompare1);
	chkBoxAddtoCompare1.click();
	Thread.sleep(1000);
	jse.executeScript("window.scrollBy(0,750)", "");
	Thread.sleep(1000);	
	validate (chkBoxAddtoCompare2);
	chkBoxAddtoCompare2.click();
	Thread.sleep(1000);
	jse.executeScript("window.scrollBy(0,750)", "");
	Thread.sleep(1000);
	validate (chkBoxAddtoCompare3);
	chkBoxAddtoCompare3.click();
	Thread.sleep(2000);
	jse.executeScript("window.scrollBy(0,600)", "");
	Thread.sleep(1000);
	validate (chkBoxAddtoCompare4);
	chkBoxAddtoCompare4.click();
	
}



public void viewdetailslnk() throws InterruptedException{
	Thread.sleep(9000);
	viewDetails.click();
	//validate(viewDetails);
	
}

public void removePlanlnk() throws InterruptedException{
	Thread.sleep(9000);
	removePlanlnk.click();
	//validate(removePlanlnk);
}

public void removePlanlnk1() throws InterruptedException{
	Thread.sleep(3000);
	removePlanlnk1.click();
}

public void footNoteSection() throws InterruptedException{
	Thread.sleep(3000);
	String txt = footNote.getText();
	System.out.println(txt);
}

public void backtoAllPlans() throws InterruptedException{
	Thread.sleep(9000);
	backtoallPlans.click();
}


public void disclaimerText() throws InterruptedException{
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,750)", "");
	Thread.sleep(8000);
	String disclaimertxt = disclaimerTxt.getText();
	System.out.println(disclaimertxt);
}

public ResponsivePlanSummary viewPlanSummary(String planType) {
//	JavascriptExecutor js = (JavascriptExecutor)driver;
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	if (planType.equalsIgnoreCase("PDP")) {
			showPdpPlans.click();
		return new ResponsivePlanSummary(driver);
			} else if (planType.equalsIgnoreCase("MA")
			|| planType.equalsIgnoreCase("MAPD")) {
			System.out.println("inside MA");
			showMaPlans.click();
		return new ResponsivePlanSummary(driver);
			}else if(planType.equalsIgnoreCase("MS")){
		           showMsPlans.click();
		return new ResponsivePlanSummary(driver);
		}
			return null;
}
	

 
public void comparePlanslnk() throws InterruptedException{
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,150)");
	Thread.sleep(2000);
	 boolean link = comparePlans.isEnabled(); 
	 System.out.println(link); 
	 Thread.sleep(8000);
	 validate(comparePlans); 
	 comparePlans.click(); 
	
	
}
	
	//US501386 - Plan Highlights 
	public ResponsivePlanSummary validatePlanHighlights(){
		validate(planHighlightsHeader);
		validate(providerSearchLink);
		if(planHighlightsHeader.isDisplayed()){
			for(int i=0; i<=marketingBullet.size()-1; i++){
				if(marketingBullet.get(i).getText()!=null){
					System.out.println("=======Marketing Bullets Displayed==========");
				}else{
					System.out.println("=======Marketing Bullets not Displayed======");
					Assert.fail();
				}
			}
		}return new ResponsivePlanSummary(driver);
	}
	
	 public void planCountOnPlanCard(){
		   for(int i=0;i<=planCountList.size();i++){
			   planCountList.get(i).click();
			   for(int j=0;j<=planIndexList.size();i++){
				   if(planCountList.size()==planIndexList.size()){
					   System.out.println("Count Match");
					   if(planIndexList.get(i).getText().equalsIgnoreCase((j+1)+" of "+(planCountList.size()+1)+" Plans")){
						   System.out.println(planIndexList.get(i).getText().equalsIgnoreCase((j+1)+" of "+(planCountList.size()+1)+" Plans") + " displayed correctly");
					   }
				   }
			   }
		   }
	 }
	 
	/* public ResponsivePlanDetails viewPlanDetails(String planName){
		int i=0;
		 List<WebElement> plans = driver.findElements(By.xpath("//h2[contains(text(),'AARP')]"));
		 System.out.println("PLANS SIZE :: "+plans.size());
		 String xpath="View more details";  
		 List<WebElement> viewMoreLnks = driver.findElements(By.linkText(xpath));
		 
		 System.out.println("VIEW MORE LINKS SIZE"+viewMoreLnks.size());
		 for(WebElement plan : plans){
			 System.out.println(plan.getText());
			 if(plan.getText().equalsIgnoreCase(planName)){			 
				 plan.click();
				 if(driver.getTitle().equalsIgnoreCase("plans")){
					 return new ResponsivePlanDetails(driver);
				 }
				 break;
			 }
			 i++;
		 }
		 return null;
	 }
	 */
	 
	 public ResponsivePlanDetails viewPlanDetails(String planName)
	 {
	               List<WebElement> plans = driver.findElements(By.xpath("//h2[contains(text(),'AARP')][1]"));
	               System.out.println("PLANS SIZE :: "+plans.size());
	               String xpath="//a[@class='view-more-link']";  
	                List<WebElement> viewMoreLnks = driver.findElements(By.xpath(xpath));            
	                System.out.println("VIEW MORE LINKS SIZE"+viewMoreLnks.size());     
	               for(int i=0; i<plans.size();i++){
	                      if(plans.get(i).getText().equalsIgnoreCase(planName)){
	                            viewMoreLnks.get(i).click();
	                            if(driver.getTitle().equalsIgnoreCase("plans")){
	                                   try {
	                                          Thread.sleep(5000);
	                                   } catch (InterruptedException e) {
	                                          // TODO Auto-generated catch block
	                                          e.printStackTrace();
	                                   }
	                                   return new ResponsivePlanDetails(driver);
	                            }
	                            break;
	                      }
	               }
	               return null;
	        

	 	 }

	 
	 public void validateCountyName(String CountyName)  {
			if(countyNameDetail.getText().contains(CountyName)){
				System.out.println("CountyName"+CountyName);
			
				Assert.assertTrue("---content displayed---", true);		
				}else{
			  Assert.fail();
			}
			
			// TODO Auto-generated method stub
			
		}

		public VPPAarpNeedAStepBackWidgetMobile validateStepBackWidget(){
			 return new VPPAarpNeedAStepBackWidgetMobile(driver);
		}
		public VPPAarpNeedHelpWidgetPageMobile validateNeedHelpWidget(){
			 return new VPPAarpNeedHelpWidgetPageMobile(driver);
		}
		public VPPNeedMoreInformationWidgetMobile validateNeedMoreInformationWidget(){
			 return new VPPNeedMoreInformationWidgetMobile(driver);
		}
		public VPPRequestSendEmailPageMobile validateEmailWidget(){
			 return new VPPRequestSendEmailPageMobile(driver);
		}
		public PlanSelectorPage navigateToPlanSelectorPage(){
			 planSelector.click();
			 try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 if(driver.getTitle().equalsIgnoreCase("Plan Selector")){
				 return new PlanSelectorPage(driver);
			 }
			 return null;	 
		}
		public Rallytool_Page navigateToRallyPage(String planName) { 
			driver.manage().window().maximize(); 
			//a[contains(text(),'Is my provider covered?')]
			int i=0;
			 List<WebElement> plans = driver.findElements(By.xpath("//h2[contains(text(),'AARP MedicareComplete')]"));
			 System.out.println("PLANS SIZE :: "+plans.size());
			 String xpath="//a[contains(text(),'Is my provider')]";  
			 List<WebElement> providerSearch = driver.findElements(By.xpath(xpath));
			 
			 System.out.println("Is my provider covered? "+providerSearch.size());
			 for(WebElement plan : plans){
				 if(plan.getText().equalsIgnoreCase(planName)){			 
					 providerSearch.get(i).click();
					 try {
						Thread.sleep(8000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}						  
							ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
							try {
								Thread.sleep(6000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}		
							driver.switchTo().window(tabs.get(1));
							System.out.println(driver.getTitle());
							if (driver.getTitle().equalsIgnoreCase("Welcome")) {
							return new Rallytool_Page(driver);
							}
							else{

							}
						 }
					 }
				 i++;			 
				 return null;
			}
		 public void selectPlansToCompareTwoPlans(String planName1, String planName2){
				// int i=0;
				 List<WebElement> plans = driver.findElements(By.xpath("//h2[contains(text(),'AARP')]"));
				 System.out.println("PLANS SIZE :: "+plans.size());
				 //String xpath="//label[contains(text(),'Add to Compare')]"; 
				 //String xpath="//span/input[@class='custom-checkbox']";
				 String xpath="//span[contains(text(),'Enroll in plan')]";
				 System.out.println("xpath is :"+ xpath);
				// List<WebElement> comparePlansLink = driver.findElements(By.xpath("//*[contains(text(),'Compare plans')]"));
				 //List<WebElement> compareCheckBox = driver.findElements(By.xpath(xpath));
				 List<WebElement> compareCheckBox = driver.findElements(By.xpath(xpath));
				 for(int i=0; i<plans.size();i++){
					 if(plans.get(i).getText().equals(planName1)){
						 compareCheckBox.get(i).click();
						 System.out.println(planName1+"compare link clicked");
					 }
					 if(plans.get(i).getText().equals(planName2)){
						 compareCheckBox.get(i).click();
						 System.out.println(planName2+"compare link clicked");
						// .//*[@id='plan-list-1']/div/div[2]/div/div["+"i"+""]
						  
		 			 }		  		 

				}
				 comparePlans.click();
	 
			 }
			 public void validateMedicalBenefitsTable(String monthlyPremium1, String monthlyPremium2, String outofPocket1, String outofPocket2){
				 if(monthlypremium.getText().equals("Monthly Premium")){
					 if(monthlyPremium1.equals(monthlypremium1.getText())){
				 
					 System.out.println("monthly premium is verified");
					 Assert.assertTrue(true);
				 }else{
					 Assert.fail("Error in displaying monthly premium 1");
				 }
				 if(monthlyPremium2.equals(monthlypremium2.getText())){
					 Assert.assertTrue(true);
				 }else{
					 Assert.fail("Error in displaying monthly premium 2");
				 }
				 }
				 if (outofpocketmaximum.getText().equals("Out of Pocket Maximum")) {
					 if(outofpocket1.getText().equals(outofPocket1)){
						 
						 System.out.print("Out of pockect is verified");
						 Assert.assertTrue(true);
					 }else{
						 Assert.fail("Error in displaying outofpocket1");
					 }
					 if(outofpocket2.getText().equals(outofPocket2)){
						 Assert.assertTrue(true);
					 }else{
						 Assert.fail("Error in displaying outofpocket2");
					 }
					 }
					
				}	
			 public GetStartedPage estimateYourDrugs(String planName){
				//	int i=0;
					List<WebElement> plans = driver.findElements(By.xpath("//h2[contains(text(),'AARP')]"));
					System.out.println("PLANS SIZE :: "+plans.size());
					String xpath="Estimate Your Drugs";  
					List<WebElement> estimateDrugLink = driver.findElements(By.linkText(xpath));

					System.out.println("Estimate your drugs"+estimateDrugLink.size());
					for(WebElement plan : plans){
					if(plan.getText().equalsIgnoreCase(planName)){ 
						for(WebElement drugLink: estimateDrugLink){
							drugLink.click();	
							return new GetStartedPage(driver);
						}
					
				// estimateDrugLink.get(i).click();
					try {
					Thread.sleep(3000);
					} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
					if(driver.getTitle().equalsIgnoreCase("plans")){
					return new GetStartedPage(driver);
					}
					break;
					}
				//	i++;
					}
					return null;
					}
			 
			 public void clicksOnEnrollInplanLink(String planName) {
					if (planName.contains("HMO")) {
						for (WebElement plan : maPlanElement) {
							if (plan.getText().contains(planName)) {
								ElementData elementData = new ElementData("xpath", "//*[contains(text(),'Enroll in plan')]");
								findChildElement(elementData, plan).click();
				                try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
				                System.out.println(driver.getTitle());
				                if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_ADVANTAGE_ENROLLMENT)){
				                	System.out.println("Page displayed successfully");
				                	Assert.assertTrue(true);
				                }else{
				                	Assert.fail();
				                }
							}
							break;
						}
					} else if (planName.contains("PDP")) {
						for (WebElement plan : pdpPlanElement) {
							if (plan.getText().contains(planName)) {
								ElementData elementData = new ElementData("id", "enrollPDP"); // TODO:
																								// Re-check
								findChildElement(elementData, plan).click();

							}
							break;
						}
					}
					//return new IntroductionInformationPage(driver);
				}
			 public void validatePrescriptionBenefitsTable(String deduct1, String deduct2, String tiervalue1, String tiervalue2){
				 System.out.println("Inside validatePrescriptionBenefitsTabl");
				 /**System.out.println("Deductible 1: "+deduct1);
				 System.out.println("Actual value: "+deductible1.getText());
				 System.out.println("Deductible 2: "+deduct2);
				 System.out.println("Actual value: "+deductible2.getText());
				 System.out.println("Tier 1: "+tiervalue1);
				 System.out.println("Actual value: "+tier1value1.getText());
				 System.out.println("Tier 2: "+tiervalue2);
				 System.out.println("Actual value: "+tier1value2.getText());
				 
				 if(deductible.getText().equals("Annual Prescription Deductible"))
				 {
					 System.out.println("Deductible value is:"+deductible1.getText());
					 System.out.println("Inside comparisons");
					 if(deduct1.equals(deductible1.getText()))
					 {
						 System.out.println("Annual Prescription Deductible is verified");
						 Assert.assertTrue(true);
					 }
					 else
					 {
						 Assert.fail("Error in displaying Annual Prescription Deductible for plan 1");
					 }
					 if(deduct2.equals(deductible2.getText()))
					 {
						 System.out.println("Annual Prescription Deductible is verified");
						 Assert.assertTrue(true);
					 }
					 else
					 {
						 Assert.fail("Error in displaying Annual Prescription Deductible for plan 2");
					 }
					 
				 }*/
				 if(tier1value.getText().equals("Tier 1: Preferred Generic Drugs"))
				 {
					 if(tiervalue1.equals(tier1value1.getText()))
					 {
						 System.out.println("Tier 1 value is verified for plan 1");
						 Assert.assertTrue(true);
					 }
					 else
					 {
						 Assert.fail("Error in displaying Tier 1 value for plan 1");
					 }
					 if(tiervalue2.equals(tier1value2.getText()))
					 {
						 System.out.println("Tier1 value is verified for plan 2");
						 Assert.assertTrue(true);
					 }
					 else
					 {
						 Assert.fail("Error in displaying Tier 1 value for plan 2");
					 }
					 
				 }
			 }
			public void validateOptionalServicesTable(String opDen1, String opDen2, String highOpDen1, String highOpDen2){
				 if(optionalDental.getText().equals("Optional Dental"))
				 {
					 if(opDen1.equals(optionalDental1.getText()))
					 {
						 System.out.println("Optional Dental is verified for Plan 1");
						 Assert.assertTrue(true);
					 }
					 else
					 {
						 Assert.fail("Error in displaying Optional Dental for plan 1");
					 }
					 if(opDen1.equals(optionalDental2.getText()))
					 {
						 System.out.println("Optional Dental is verified for Plan 2");
						 Assert.assertTrue(true);
					 }
					 else
					 {
						 Assert.fail("Error in displaying Optional Dental for plan 2");
					 }
					 
				 }
				 if(highOptionDental.getText().equals("High Option Dental"))
				 {
					 if(highOpDen1.equals(highOptionDental1.getText()))
					 {
						 System.out.println("Hign Option Dental is verified for plan 1");
						 Assert.assertTrue(true);
					 }
					 else
					 {
						 Assert.fail("Error in displaying High Option Denatl value for plan 1");
					 }
					 if(highOpDen2.equals(highOptionDental2.getText()))
					 {
						 System.out.println("Hign Option Dental is verified for plan 2");
						 Assert.assertTrue(true);
					 }
					 else
					 {
						 Assert.fail("Error in displaying High Option Denatl value for plan 2");
					 }
					 
				 }
			 }
			 
			 public void validatePlanCostsTable(String planPrem1, String planPrem2, String medBen1, String medBen2){
				 if(planPremium.getText().equals("Plan Premium"))
				 {
					 if(planPrem1.equals(planPremium1.getText()))
					 {
						 System.out.println("Plan Premium is verified for Plan 1");
						 Assert.assertTrue(true);
					 }
					 else
					 {
						 Assert.fail("Error in displaying Plan Premium for plan 1");
					 }
					 if(planPrem2.equals(planPremium2.getText()))
					 {
						 System.out.println("Plan Premium is verified for Plan 2");
						 Assert.assertTrue(true);
					 }
					 else
					 {
						 Assert.fail("Error in displaying Plan Premium for plan 2");
					 }
					 
				 }
				 if(medicalBenefits.getText().equals("Medical Benefits"))
				 {
					 if(medicalBenefits1.getText().contains(medBen1))
					 {
						 System.out.println("Medical Benefits is verified for plan 1");
						 Assert.assertTrue(true);
					 }
					 else
					 {
						 Assert.fail("Error in displaying Medical Benefits value for plan 1");
					 }
					 if(medicalBenefits2.getText().contains(medBen2))
					 {
						 System.out.println("Medical Benefits is verified for plan 2");
						 Assert.assertTrue(true);
					 }
					 else
					 {
						 Assert.fail("Error in displaying Medical Benefits value for plan 2");
					 }
					 
				 }
			 }
			 
			 public void selectFivePlans()  {				

					JavascriptExecutor js = (JavascriptExecutor)driver;

					js.executeScript("arguments[0].click();", chkBoxAddtoCompare1);
					js.executeScript("arguments[0].click();", chkBoxAddtoCompare2);
					js.executeScript("arguments[0].click();", chkBoxAddtoCompare3);
					js.executeScript("arguments[0].click();", chkBoxAddtoCompare4);
					js.executeScript("arguments[0].click();", chkBoxAddtoCompare5);
				}
			 
			 public void errorMessage() {
				 validate(errorMessage);
				 System.out.println(errorMessage.getText());
			 }
				public void validateStickyZipcode(String actualZipcode){
					validate(changeLoationLink);
					changeLoationLink.click();
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					String stickyZipcode =  (String) executor.executeScript("return document.getElementById('zipcode').value;");
					System.out.println(stickyZipcode);
					//String stickyZipcode=zipcodeBox.getText();
					//System.out.println(driver.findElement(By.xpath("//*[@id='zipd
					if(stickyZipcode.equals(actualZipcode)){
						System.out.println("zipcode box displays sticky zipCode as  "+stickyZipcode);
						Assert.assertTrue(true);
					}else{
						System.out.println("zipcode box doesn't displays sticky zipCode as  "+stickyZipcode);
						Assert.fail();
					}
					
				}
				
				public void selecttwoplanCheckboxes() {
					JavascriptExecutor js = (JavascriptExecutor)driver;
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					js.executeScript("arguments[0].click();", chkBoxAddtoCompare1);
					
				}
				public void validateincorrectZipcode(String actualZipcode,
						String invalidzipcode) {
					
					validate(changeLoationLink);
					changeLoationLink.click();
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					String stickyZipcode =  (String) executor.executeScript("return document.getElementById('zipcode').value;");
					System.out.println(stickyZipcode);
					//String stickyZipcode=zipcodeBox.getText();
					//System.out.println(driver.findElement(By.xpath("//*[@id='zipd
					if(stickyZipcode.equals(actualZipcode)){
						System.out.println("zipcode box displays sticky zipCode as  "+stickyZipcode);
						//Assert.assertTrue(true);
					}else{
						System.out.println("zipcode box doesn't displays sticky zipCode as  "+stickyZipcode);
						Assert.fail();
					}
					driver.manage().window().setSize(new Dimension(1400, 1000));
					countyNameDetail.click();
					countyNameDetail.sendKeys(Keys.TAB);
 					executor.executeScript("document.getElementById('zipcode').click()");
					System.out.println("clicked inside tet box");
 					Actions action = new Actions(driver);
 					PageFactory.initElements(driver, this);
					action.moveToElement(zipCodeField).perform();
					action.doubleClick();
					action.perform();
					
					action.sendKeys(Keys.DELETE);
					action.perform();
					
					System.out.println("tet box clean");
					action.moveToElement(zipCodeField).perform();
					action.sendKeys(invalidzipcode).perform();
					action.moveToElement(driver.findElement(By.id("submit"))).perform();;
					action.sendKeys(Keys.ENTER).perform();
					/*zipcodeBox.sendKeys(invalidzipcode);
					zipCodeField.sendKeys(Keys.ENTER);
					*/
					executor.executeScript("document.getElementById('submit').click()");
					System.out.println(errorMessageincorrect2.getText());
					//System.out.println(errorMessageincorrect.getText());
					//errorMessageforincorrectzipcode();
					// sendkeys(zipCodeField, invalidzipcode);
					//    zipCodeField.sendKeys(Keys.ENTER);
					//driver.findElement(By.className("change-location-link")).sendKeys(By.id("zipcode");
					
				}
				public void errorMessageforincorrectzipcode() {
				//	validate(errorMessageincorrect);
					 if(errorMessageincorrect2.isDisplayed()){
						 System.out.println("Displayed Error message is "+errorMessageincorrect2.getText());
						 if(errorMessageincorrect2.getText().equals("Please enter a valid ZIP code.")){
					// System.out.println(errorMessageincorrect.getText());
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						 }
					 }
					 /*if(errorMessageincorrect.isDisplayed()){
						 System.out.println("Displayed Error message is "+errorMessageincorrect.getText());
						 if(errorMessageincorrect.getText().equals("Please enter a valid ZIP code.")){
							 System.out.println("Error message content displayed correctly");
						 }else{
							 System.out.println("content of error message not displayed correctly");
							 Assert.fail();
						 }
					 }else{
						 if(errmsgcolor.getAttribute("class").contains("errmsgcolor")){
							 System.out.println("successfully, although phantom js cannot check getText");
						 }else{
						 System.out.println("Error message not displayed");
						 Assert.fail();
						 }
					 }
					// TODO Auto-generated method stub
*/					
				}
				
					// TODO Auto-generated method stub
				
				public void enterZipandVAlidateError(String actualZipcode, 
						String invalidzipcode){
 					driver.manage().window().maximize();
					if(changeLoationLink.isDisplayed()){
 						driver.manage().window().maximize();
						changeLoationLink.click();
						try{
							System.out.println("User clicks changelocation and enters error zipcode");
 							driver.manage().window().maximize();
						//	zipCodeField.sendKeys(invalidzipcode);
 							Actions action = new Actions(driver);
 							PageFactory.initElements(driver, this);
 							action.moveToElement(zipCodeField).perform();
 							action.doubleClick();
 							action.perform();
 							
 							action.sendKeys(Keys.DELETE);
 							action.perform();
 							
 							System.out.println("tet box clean");
 							action.moveToElement(zipCodeField).perform();
 							action.sendKeys(invalidzipcode).perform();
 							action.moveToElement(driver.findElement(By.id("submit"))).perform();;
 							action.sendKeys(Keys.ENTER).perform();
  							if(!errmsgcolor.getAttribute("class").contains("ng-hide")){
								 System.out.println("Displayed Error message is "+errorMessageincorrect.getText());
 									driver.manage().window().maximize();
								 if(errorMessageincorrect.getText().equals("Please enter a valid ZIP code.")){
									 System.out.println("Error message content displayed correctly");
								 }else{
									 System.out.println("content of error message not displayed correctly");
									 Assert.fail();
								 }
							 }else{
								 if(errmsgcolor.getAttribute("class").contains("ng-hide")){
									 System.out.println("successfully, phantom js issue......");
								 }else{
									 System.out.println("Error message not displayed");
									 Assert.fail();
								 }
								
							 }
						}catch(Exception e){
							System.out.println("Element not accessable");
							Assert.fail();
						}
					}
					
				}
				
				public AddDrugPage addDrug(){
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    addaDrug.click();
                    System.out.println("Add a new drug popup should appear");
                    return new AddDrugPage(driver);
            }
				
				public VPPPlanSummaryPage clicksOnEnterDrugInformationLink(String planName) {
                    if (planName.contains("HMO")) {
                            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                            enterDrugMAInformationlnk.click();
                            System.out.println("MA Estimate drog cost page is displayed");
                            
                            /*for (WebElement plan : maPlanElement) {
                            if (plan.getText().contains(planName)) {
                            ElementData elementData = new ElementData("id",
                            "enterDrugMA");
                            findChildElement(elementData, plan).click();
                            }
                            }*/
                            }
                            if (planName.contains("PDP")) {
                                    enterDrugInformationlnk.click();
                                    System.out.println("Estimate drug cost page is displayed");
                            /*for (WebElement plan : pdpPlanElement) {
                            if (plan.getText().contains(planName)) {
                            ElementData elementData = new ElementData("id",
                            "pdpDrugCostEstimatorLink"); // TODO Re-check
                            findChildElement(elementData, plan).click();
                            }
                            }*/
                                    
                            }
                            
                            if (driver.getTitle().equalsIgnoreCase(
                            PageTitleConstants.ULAYER_OUR_MEDICARE_PLAN_TYPES) || driver.getTitle().equalsIgnoreCase("estimate-drug-costs")) {
                            return new VPPPlanSummaryPage(driver);
                            }
                    
            
                    return null;
            }
					
				 public VPPPlanSummaryPage planYear() throws InterruptedException{
                     Thread.sleep(10000);
                     planYear.click();
                         //showMaPlans.click();
                         return null;
                         
                 }
				 public VPPPlanSummaryPage enrollNowbtn(){
                     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                         enrollNowbtn.click();
                         if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_ADVANTAGE_ENROLLMENT))                
                         System.out.println("Online enrollment tool launched");
                         driver.navigate().back();
                         System.out.println("Back to plan summary page");
                         return null;
                 }
				 
				 public VPPPlanSummaryPage verifyEnrollNowbtn2017(){
                     
                     //List<WebElement> webElements =driver.findElements(By.xpath("(.//*[@class='segment-title']/div"));
                     
                 try{
                         if(enrollNowbtn.isDisplayed())
                                 Assert.fail("Enroll now button should not display");
                         
                         Assert.assertTrue("Enroll now button did not display", true);
                 }
                 catch(Exception e){
                         Assert.assertTrue("Enroll now button did not display", true);
                 }
                 return null;
         }
				 
				 public PlanComparePage navigateToPlanCompare(String planName){
						driver.findElement(By.xpath("//*[@id='compare-"+planName+"']/parent::span/following-sibling::p")).click();
							return new PlanComparePage(driver);
					
					}
					
					 public void selectPlanstoCompare(String planName){
						 driver.findElement(By.xpath("//*[@id='compare-"+planName+"']/parent::span")).click();
		 				 System.out.println("========="+planName+" is selected to compare===========");
						 }
					 
					 public ULayerVASPage navigateToULayerVASPage(){
						 vasButton.click();
		 				 return new ULayerVASPage(driver);
}
}			 
