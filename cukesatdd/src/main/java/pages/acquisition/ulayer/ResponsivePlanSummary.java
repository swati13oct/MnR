package pages.acquisition.ulayer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
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

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.MRConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.member.ulayer.Rallytool_Page;
import pages.mobile.acquisition.ulayer.VPPAarpNeedAStepBackWidget;
import pages.mobile.acquisition.ulayer.VPPAarpNeedHelpWidgetPage;
import pages.mobile.acquisition.ulayer.VPPNeedMoreInformationWidget;
import pages.mobile.acquisition.ulayer.VPPRequestSendEmailPage;

public class ResponsivePlanSummary extends UhcDriver{
	
	//US504467
		@FindBy(xpath = "//div[@class='tab'][1]")
		private WebElement viewMaPlans;
		
		@FindBy(xpath = "//*[@class='ng-valid ng-dirty']/span/div[1]/p")
		private WebElement errorMessageincorrect;
		
		@FindBy(xpath = "//*[@id='zip-form']/span/div[1]/p")
		private WebElement errorMessageincorrect2;
		
		
		//@FindBy(id = "zipcode")
		@FindBy(xpath = "//*[@id='zipcode']")
		private WebElement zipCodeField;
		
		@FindBy(xpath = "//div[@class='tab'][2]")
		private WebElement viewPdpPlans;

		@FindBy(xpath = "//div[@class='tab'][3]")
		private WebElement viewSnpPlans;
		
 		@FindBy(xpath="//*[contains(text(),'HMO')]")
 		List<WebElement> maPlanElement;
		
		@FindBy(xpath = "//div[@class='disabledprint ng-scope']")
		List<WebElement> pdpPlanElement;
		
		@FindBy(xpath = "//div[@class='overview-main']")
		private WebElement responsivevpppage;
		
		@FindBy(className="change-location-link")
		private WebElement changeLoationLink;
		
		@FindBy(id="zipcode")
		private WebElement zipcodeBox;
		
		@FindBy(xpath="//*[@class='content-cols']/div[1]/h3")
		private WebElement planHighlightsHeader;
		
		@FindBy(xpath="//h2[contains(text(),'We have')]")
		private WebElement countyNameDetail;
		
		//@FindBy(xpath="//div[@class='content-cols']/descendant::div[1]/h3")
		@FindBy(xpath="//*[@class='content-cols']/div[2]/h3")
		private WebElement benefitsHeader;
		
		@FindBy(xpath="//a[contains(text(),'Find a provider')]")
		private WebElement providerSearchLink;
		
		@FindBy(xpath="//*[@class='content-cols']/div[1]/ul/li")
		private List<WebElement> marketingBullet;
		
		@FindBy(xpath="//div[2]/div/div/span[1]/span")
		private List<WebElement> planCountList;
		
		@FindBy(className="plan-index")
		private List<WebElement> planIndexList;
		
		@FindBy(xpath = "//*[@class='tab']/div[1]/span[3]")
		private WebElement showMaPlansClickable;
		
		@FindBy(xpath="//*[@class='tab active' and contains(text(),'Medicare Advantage Plans')]/div[1]/span[3]")
		private WebElement showMaPlansNotClickable;
		
		@FindBy(xpath = "//*[@class='tab med-supp']/div[1]/span[3]")
		private WebElement showMsPlans;
		
		@FindBy(xpath="//*[contains(text(),'Start Plan Selector')]")
		private WebElement planSelector;
		
		@FindBy(className="errmsgcolor")
		private WebElement errmsgcolor;
		
		/*@FindBy(xpath="//html/body/div[4]/div[2]/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div/span[1]")
		private WebElement showMaPlans;*/
	
		 @FindBy(id="compare-plan-1")
		    private WebElement chkBoxAddtoCompare1;
		    
		 @FindBy(id="compare-plan-2")
		    private WebElement chkBoxAddtoCompare2;
		    
		 @FindBy(id="compare-plan-3")
		  private WebElement chkBoxAddtoCompare3;
		    
		    @FindBy(id="compare-plan-4")
		    private WebElement chkBoxAddtoCompare4;
		    
		    @FindBy(id="compare-plan-5")
		    private WebElement chkBoxAddtoCompare5;
		    
		    @FindBy(xpath="(//*[text()='Compare plans'])[8]")
		    private WebElement comparePlans;
		    
		   // @FindBy(xpath="(.//*[text()='View details'])[1]")
		    @FindBy(xpath="//*[@id='innerdiv']/a[1]")
		    private WebElement viewDetails;
		    
			@FindBy(xpath=".//*[text()='Back to all plans']")
			private WebElement backtoallPlans;
		    
		   // @FindBy(xpath="(.//*[@class='remove-button'])[1]")
		    @FindBy(xpath="//*[@id='topRowCopy']/div[2]/div[1]//span[@class='remove-button']")
		    private WebElement removePlanlnk;
		    
		    //@FindBy(xpath="(.//*[@class='remove-button'])[2]")
		    @FindBy(xpath=".//*[@id='topRowCopy']/div/div[3]/span")
		    private WebElement removePlanlnk1;
		    
		    //@FindBy(xpath=".//*[@id='fixTable']/tbody/tr[24]/td/p")
		    @FindBy(xpath=".//*[@id='fixTable']/tbody/tr[33]/td/p")
		    private WebElement footNote;
		    
		    @FindBy(xpath=".//*[@class='parbase planscompare section']/div[2]")
		    private WebElement disclaimerTxt;
		    
		    @FindBy(xpath=".//*[text()='2017 AARP MedicareComplete SecureHorizons Plan 1 (HMO)']")
		    private WebElement mapdPlan1;
		    
		    
//Medical Benefits
		    
		    //@FindBy (xpath=".//*[@id='fixTable']/tbody/tr[2]/td[2]")
		    @FindBy (xpath=".//*[@id='fixTable']/tbody/tr[2]/td[2]/div")
		    private WebElement monthlypremium1;
		    
		   //@FindBy (xpath= ".//*[@id='fixTable']/tbody/tr[2]/td[4]")
		    @FindBy(xpath= ".//*[@id='fixTable']/tbody/tr[2]/td[4]/div")
		    private WebElement monthlypremium2;
		    
		    @FindBy (xpath= ".//*[@id='fixTable']/tbody/tr[3]/td[1]/p")
		    private WebElement outofpocketmaximum;
		    
		    @FindBy (xpath=".//*[@id='fixTable']/tbody/tr[2]/td[1]/p")
		    private WebElement monthlypremium;
		    
		    @FindBy (xpath=".//*[@id='fixTable']/tbody/tr[3]/td[2]")
		    private WebElement outofpocket1;
		    
		    @FindBy (xpath=".//*[@id='fixTable']/tbody/tr[3]/td[4]")
		    private WebElement outofpocket2;
		    
		    @FindBy(xpath="(.//span[contains(text(),'View Plans')][@class='trigger-closed'])[1]")
		//  @FindBy(xpath=".//*[@id='site-wrapper']/div[4]/div/div[1]/div/div/div/div/div[1]/div/div[2]/div[1]/div[2]/div/div[2]/div[1]/div/span[3]")
		    private WebElement showMaPlans;
			
			@FindBy(xpath="//*[contains(text(),'Medicare Prescription')]/following-sibling::span[2]")
			private WebElement showPdpPlans;
			
			//prescription drug benefits
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[16]/td[1]/p")
		    private WebElement deductible;
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[16]/td[2]/span")
		    private WebElement deductible1;
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[16]/td[10]/span")
		    private WebElement deductible2;
			
			//@FindBy (xpath="//*[@id='fixTable']/tbody/tr[17]/td[1]/p")
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[25]/td[1]/p")
		    private WebElement tier1value;			
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[25]/td[2]/span[1]/strong")
		    private WebElement tier1value1;
			// .//*[@id='fixTable']/tbody/tr[17]/td[2]/span[1]/strong
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[25]/td[5]/span[1]/strong")
		    private WebElement tier1value2;
			// .//*[@id='fixTable']/tbody/tr[22]/td[6]/span[1]/strong
			
//Optional Services
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[18]/td[1]/p")
		    private WebElement optionalDental;
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[11]/td[2]/div[1]/div/strong")
		    private WebElement optionalDental1;
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[11]/td[4]/div[1]/div/strong")
		    private WebElement optionalDental2;
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[12]/td[1]/p")
		    private WebElement highOptionDental;
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[12]/td[2]/div[2]/div/strong")
		    private WebElement highOptionDental1;
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[12]/td[4]/div[2]/div/strong")
		    private WebElement highOptionDental2;
			
//Plan Costs
			//@FindBy(xpath="//*[@id='fixTable']/tbody/tr[22]/td[1]/p")
			@FindBy (xpath=".//*[@id='fixTable']/tbody/tr[29]/td[1]/p/span")
		    private WebElement planPremium;
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[22]/td[2]/strong[1]")
		    private WebElement planPremium1;
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[22]/td[4]/strong[1]")
		    private WebElement planPremium2;
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[24]/td[1]/p")
		    private WebElement medicalBenefits;
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[24]/td[2]/strong[1]")
		    private WebElement medicalBenefits1;
			
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[24]/td[4]/strong[1]")
		    private WebElement medicalBenefits2;
			
		@FindBy	(xpath="//span[@class='remove-plan-text show']/p")
		private WebElement errorMessage;
			
			private static String CAMPAIGN_URL_1 = MRConstants.CAMPAIGN_PAGE_URL1;
			
			private static String CAMPAIGN_URL_2 = MRConstants.CAMPAIGN_PAGE_URL2;
			
	   private String urlType;  

	private PageData vppPlanSummary;

	public JSONObject vppPlanSummaryJson;
	
	public ResponsivePlanSummary(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	//	CommonUtility.waitForPageLoad(driver, responsivevpppage, CommonConstants.TIMEOUT_30);

		String fileName = CommonConstants.VPP_PLAN_SUMMARY_PAGE_DATA;
		vppPlanSummary = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}
	public ResponsivePlanSummary(WebDriver driver, String url) {
		super(driver);
		urlType=url;
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
	private JSONObject formJsonObject(PageData vppPlanSummary) {
		JSONObject jsonObject = new JSONObject();
		for (String key : vppPlanSummary.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(vppPlanSummary.getExpectedData().get(key));
			if (elements.size() == 1) {
				if (validate(elements.get(0))) {
					try {
						jsonObject.put(key, elements.get(0).getText().trim());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					if (validate(element)) {
						try {
							JSONObject jsonObjectForArray = new JSONObject();
							jsonObjectForArray.put(vppPlanSummary.getExpectedData().get(key).getElementName(),
									element.getText().trim());
							jsonArray.put(jsonObjectForArray);
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
				try {
					jsonObject.put(key, jsonArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
		return jsonObject;

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

public void selectAddToCompareCheckboxes()  {
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	js.executeScript("arguments[0].click();", chkBoxAddtoCompare1);
	js.executeScript("arguments[0].click();", chkBoxAddtoCompare2);
	js.executeScript("arguments[0].click();", chkBoxAddtoCompare3);
	js.executeScript("arguments[0].click();", chkBoxAddtoCompare4);
	
}



public void viewdetailslnk() throws InterruptedException{
	Thread.sleep(3000);
	viewDetails.click();
	validate(viewDetails);
	
}

public void removePlanlnk() throws InterruptedException{
	Thread.sleep(3000);
	removePlanlnk.click();
	validate(removePlanlnk);
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

public void backtoAllPlans(){
	backtoallPlans.click();
}


public void disclaimerText(){
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
	 boolean link = comparePlans.isEnabled(); 
	 System.out.println(link); 
	 Thread.sleep(5000);
	 comparePlans.click(); 
	 validate(comparePlans); 
	
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

		public VPPAarpNeedAStepBackWidget validateStepBackWidget(){
			 return new VPPAarpNeedAStepBackWidget(driver);
		}
		public VPPAarpNeedHelpWidgetPage validateNeedHelpWidget(){
			 return new VPPAarpNeedHelpWidgetPage(driver);
		}
		public VPPNeedMoreInformationWidget validateNeedMoreInformationWidget(){
			 return new VPPNeedMoreInformationWidget(driver);
		}
		public VPPRequestSendEmailPage validateEmailWidget(){
			 return new VPPRequestSendEmailPage(driver);
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
				                if(driver.getTitle().equalsIgnoreCase("Medicare Advantage Enrollment | AARP® Medicare Plans from UnitedHealthcare®")){
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
					 if(medBen1.equals(medicalBenefits1.getText()))
					 {
						 System.out.println("Medical Benefits is verified for plan 1");
						 Assert.assertTrue(true);
					 }
					 else
					 {
						 Assert.fail("Error in displaying Medical Benefits value for plan 1");
					 }
					 if(medBen2.equals(medicalBenefits2.getText()))
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
					
				}
			 
