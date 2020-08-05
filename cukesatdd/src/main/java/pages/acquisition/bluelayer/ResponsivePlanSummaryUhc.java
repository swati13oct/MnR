package pages.acquisition.bluelayer;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
// import acceptancetests.planName.bluelayer.PlanNamesStepDefinition;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.PageTitleConstants;
import pages.dashboard_deprecated.member.blayer.DrugCostEstimatorPage;
import pages.member_deprecated.ulayer.Rallytool_Page;

public class ResponsivePlanSummaryUhc extends UhcDriver{
	
	//US504467
	
		@FindBy(xpath = "//span[@class='title' and contains(text(),'Medicare Advantage Plans')]")
		private WebElement viewMAPlans;
		
		@FindBy(xpath = "//*[@class='ng-valid ng-dirty']/span/div[1]/p")
		private WebElement errorMessageincorrect;
		
		@FindBy(xpath = "//*[@id='zip-form']/span/div[1]/p")
		private WebElement errorMessageincorrect2;
		
		
		//@FindBy(id = "zipcode")
		@FindBy(xpath = "//*[@id='zipcode']")
		private WebElement zipCodeField;
		
		@FindBy(xpath="//span[contains(text(),'Enroll in plan')]")
		private WebElement enrollbutton;
		
		@FindBy(xpath = "//span[@class='title' and contains(text(),'Medicare Prescription Drug Plan')]")
		private WebElement viewPdpPlans;

		@FindBy(xpath = "//span[@class='title' and contains(text(),'Medicare Special Needs Plans')]")
		private WebElement viewSnpPlans;
		
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

		@FindBy(xpath="//*[@class='content-cols']/div[1]/ul")
		private List<WebElement> marketingBullet;
		
		@FindBy(xpath="//div[2]/div/div/span[1]/span")
		private List<WebElement> planCountList;
		
		@FindBy(className="plan-index")
		private List<WebElement> planIndexList;
		
		@FindBy(xpath = "//div[@class='tab med-supp plancountheight']/div")
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
		    
		    @FindBy(xpath="(.//*[text()='View details'])[1]")
		    private WebElement viewDetails;
		    
			@FindBy(xpath=".//*[text()='Back to all plans']")
			private WebElement backtoallPlans;
		    
		    @FindBy(xpath="(.//*[@class='remove-button'])[1]")
		    private WebElement removePlanlnk;
		    
		    @FindBy(xpath="(.//*[@class='remove-button'])[2]")
		    private WebElement removePlanlnk1;
		    
		    @FindBy(xpath=".//*[@id='fixTable']/tbody/tr[24]/td/p")
		    private WebElement footNote;
		    
		    @FindBy(xpath=".//*[@class='parbase planscompare section']/div[2]")
		    private WebElement disclaimerTxt;
		    
		    @FindBy(xpath="//*[contains(text(),'You Have Chosen to Enroll in the Following Plan')]")
		    private WebElement enrollInPlan;
		  
		    
//Medical Benefits
		    
		    @FindBy (xpath=".//*[@id='fixTable']/tbody/tr[2]/td[2]")
		    private WebElement monthlypremium1;
		    
		    @FindBy (xpath= ".//*[@id='fixTable']/tbody/tr[2]/td[4]")
		    private WebElement monthlypremium2;
		    
		    @FindBy (xpath= ".//*[@id='fixTable']/tbody/tr[3]/td[1]/p")
		    private WebElement outofpocketmaximum;
		    
		    @FindBy (xpath=".//*[@id='fixTable']/tbody/tr[2]/td[1]/p")
		    private WebElement monthlypremium;
		    
		    @FindBy (xpath=".//*[@id='fixTable']/tbody/tr[3]/td[2]")
		    private WebElement outofpocket1;
		    
		    @FindBy (xpath=".//*[@id='fixTable']/tbody/tr[3]/td[4]")
		    private WebElement outofpocket2;
			
			//prescription drug benefits
			
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
			@FindBy (xpath="//*[@id='fixTable']/tbody/tr[11]/td[1]/p")
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
			//@FindBy (xpath="//*[@id='fixTable']/tbody/tr[22]/td[1]/p")
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
			
			@FindBy(xpath="//*[contains(text(),'Want to enroll')]")
            private WebElement blueBannerText;

			@FindBy(xpath="//a[@class='ng-binding']")
            private WebElement planYearToggle;

			@FindBy(xpath="//div[@class='tab plancountheight active']/div/span/span")
            private WebElement planCount;
			
			@FindBy(xpath="//a[@class='cta-button secondary value-added-services']")
            private WebElement vasButton;
			
			/*@FindBy(xpath="//div[@class='tab plancountheight'][1]/div/span/span")
            private WebElement maPlanCount;
			
			@FindBy(xpath="//div[@class='tab plancountheight'][1]/div/span/span")
            private WebElement maPlanCount;*/
			
		@FindBy	(xpath="//span[@class='remove-plan-text show']/p")
		private WebElement errorMessage;
		
		@FindBy(id="nav")
		private WebElement headerElement;
		
		@FindBy(className="footer")
		private WebElement footerElement;
		
			
			String drugCost=null;
			
			String pharmacyDetails=null;
			
	   private String urlType;  

	private PageData vppPlanSummary;

	public JSONObject vppPlanSummaryJson;
	
	public ResponsivePlanSummaryUhc(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	//	CommonUtility.waitForPageLoad(driver, responsivevpppage, CommonConstants.TIMEOUT_30);

		String fileName = CommonConstants.VPP_PLAN_SUMMARY_PAGE_DATA;
		vppPlanSummary = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		openAndValidate();
	}
	public ResponsivePlanSummaryUhc(WebDriver driver, String url) {
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
		//validate(showMsPlans);	
		/*if(urlType.equalsIgnoreCase("endorsed")){
			start(ENDORSED_URL);
		}
		if(urlType.equalsIgnoreCase("non-endorsed")){
			start(NON_ENDORSEDURL);
		}*/
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



public void viewdetailslnk(){
	viewDetails.click();
	validate(viewDetails);
	
}

public void removePlanlnk(){
	removePlanlnk.click();
	validate(removePlanlnk);
}

public void removePlanlnk1(){
	removePlanlnk1.click();
}

public void footNoteSection(){
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

public ResponsivePlanSummaryUhc viewPlanSummary(String planType) {
	WebDriverWait wait = new WebDriverWait(driver, 90);
	try{
	driver.findElement(By.xpath(".//*[@id='58']"));
	}catch(Exception e){
		System.out.println("help widget not displayed");
	}
	if (planType.equalsIgnoreCase("PDP")) {
		wait.until(ExpectedConditions.elementToBeClickable(viewPdpPlans));
		viewPdpPlans.click();
		return new ResponsivePlanSummaryUhc(driver);
			} else if (planType.equalsIgnoreCase("MA")
			|| planType.equalsIgnoreCase("MAPD")) {
			wait.until(ExpectedConditions.elementToBeClickable(viewMAPlans));
			System.out.println("inside MA");
			//viewMaPlans.click();
			//viewMAPlans.click();
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", viewMAPlans);

		return new ResponsivePlanSummaryUhc(driver);		 
			}else if(planType.equalsIgnoreCase("MS")){
				wait.until(ExpectedConditions.elementToBeClickable(showMsPlans));
		         showMsPlans.click();
		         try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   // if(driver.getTitle().equals("UnitedHealthcare Medicare Solutions | AARP Medicare Supplement Plans")){
 		    	return new ResponsivePlanSummaryUhc(driver);
		    /*}else{
		    	System.out.println("MS plans header not displayed");
		    	Assert.fail();
		    }*/
		}else if(planType.equalsIgnoreCase("SNP")){
			wait.until(ExpectedConditions.elementToBeClickable(viewSnpPlans));
			viewSnpPlans.click();
	return new ResponsivePlanSummaryUhc(driver);
	}
			return null;
}
	

public BLayerPlanComparePage TeamCviewPlanSummary(String planType) throws InterruptedException {
//	JavascriptExecutor js = (JavascriptExecutor)driver;
	
		
	Thread.sleep(9000);
	if (planType.equalsIgnoreCase("PDP")) {
		viewPdpPlans.click();
		return new BLayerPlanComparePage(driver);
			} else if (planType.equalsIgnoreCase("MA")
			|| planType.equalsIgnoreCase("MAPD")) {
			System.out.println("inside MA");
			//viewMaPlans.click();
			viewMAPlans.click();
		return new BLayerPlanComparePage(driver);
			}else if(planType.equalsIgnoreCase("MS")){
		           showMsPlans.click();
		           System.out.println(driver.getTitle());
		           if(driver.getTitle().equals(PageTitleConstants.BLAYER_UNITEDHEALTHCARE_MEDICARE_SOLUTIONS)){
		return new BLayerPlanComparePage(driver);
		           }else{
		        	   Assert.fail();
		           }
		}else if(planType.equalsIgnoreCase("SNP")){
			viewSnpPlans.click();
	return new BLayerPlanComparePage(driver);
	}
			return null;
}

 
public void comparePlanslnk(){
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
	 boolean link = comparePlans.isEnabled(); 
	 System.out.println(link); 
	 comparePlans.click(); 
	 validate(comparePlans); 
	
}
	
	//US501386 - Plan Highlights 
	public ResponsivePlanSummaryUhc validatePlanHighlights(){
		validate(planHighlightsHeader);
		//validate(providerSearchLink);
		if(planHighlightsHeader.isDisplayed()){
			for(int i=0; i<=marketingBullet.size()-1; i++){
				if(marketingBullet.get(i).getText()!=null){
					System.out.println("=======Marketing Bullets Displayed==========");
				}else{
					System.out.println("=======Marketing Bullets not Displayed======");
					Assert.fail();
				}
			}
		}return new ResponsivePlanSummaryUhc(driver);
	}
	
	 public void planCountOnPlanCard(){
	    WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.elementToBeClickable(viewMAPlans));
		 System.out.println(planCountList.size());
		 System.out.println(planIndexList.size());
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
	 
	 public ResponsivePlanDetailsUhc viewPlanDetails(String planName){
		 driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		 if(planName.contains("PDP")){
			 driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/following-sibling::div[1]/div/a[2]")).click();
			 return new ResponsivePlanDetailsUhc(driver);
		 }
		 if(planName.contains("AARP")){
		 driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/parent::div/following-sibling::div[1]/div/div[3]/a")).click();
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return new ResponsivePlanDetailsUhc(driver);
		 }
		 if(planName.equalsIgnoreCase("Plan F") || planName.contains("Plan G")){
			 driver.findElement(By.xpath("//h2[text()='"+planName+"']/parent::a/parent::div/following-sibling::div[2]/div/a")).click();
			 return new ResponsivePlanDetailsUhc(driver);
		 }if(planName.contains("SNP")){
			 driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/following-sibling::div[1]/div/a[2]")).click();
			 return new ResponsivePlanDetailsUhc(driver);
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
			 if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_PLAN_SELECTOR)){
				 return new PlanSelectorPage(driver);
			 }
			 return null;	 
		}
		/*public Rallytool_Page navigateToRallyPage(String planName) { 
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
			}*/
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
				public Rallytool_Page navigateToRallyPage(String planName) { 
                    driver.manage().window().maximize(); 
                    //a[contains(text(),'Is my provider covered?')]
                    int i=0;
                    List<WebElement> plans = driver.findElements(By.xpath("//h2[contains(text(),'UnitedHealthcare Senior Care')]"));
                    System.out.println("PLANS SIZE :: "+plans.size());
                    String xpath="//a[contains(text(),'Is my provider')]";  
                     List<WebElement> providerSearch = driver.findElements(By.xpath(xpath));
                    
                     System.out.println("Is my provider covered? "+providerSearch.size());
                    for(WebElement plan : plans){
                          if(plan.getText().equalsIgnoreCase(planName)){               
                                  providerSearch.get(i+4).click();
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

				public ResponsivePlanSummaryUhc validateBlueBanner(String timePeriod, String currentYear, String futureYear, String planType, String planName){
					if(timePeriod.equalsIgnoreCase("AEP")){
						System.out.println("User is in AEP");
						if(blueBannerText.getText().contains(futureYear)) {
							/*if(driver.findElement(By.xpath("//h2[@class='ng-binding' and contains(text(),'2017')]")).getText().contains(futureYear)){
								System.out.println(futureYear + " Plans Displayed correctly");
								//validateEnrollInPlan(planType, planName);
							}else{
								System.out.println(futureYear + " Plans Not Displayed correctly");
								Assert.fail();
							}*/	
							planYearToggle.click();	
							//System.out.println(viewPlanHeader.getText());
							if(planYearToggle.getText().contains(futureYear)){
								//validateEnrollInPlan(planType, planName);
								System.out.println(currentYear + " Plans Displayed correctly"); 
							}else{
								System.out.println(currentYear + " Plans Not Displayed correctly");
								Assert.fail();
							}				
						}
						return new ResponsivePlanSummaryUhc(driver);
					}else if(timePeriod.equalsIgnoreCase("nonAEP")){
						System.out.println("User is in non AEP period");
						return new ResponsivePlanSummaryUhc(driver); 
					}
					return null;
				}
			 
				/*public ResponsivePlanSummaryUhc validateEnrollInPlan(String planType, String planName){
					if(planType!="SNP"){
						System.out.println("Enroll Plan Validation Starts");
						if (planName.contains("HMO")) {
							for (WebElement plan : maPlanElement) {
								if (plan.getText().contains(planName)) {
									ElementData elementData = new ElementData("xpath", "//*[contains(text(),'Enroll in plan')]");
									if(findChildElement(elementData, plan).isDisplayed()){
										System.out.println("Enroll Plan Link Displayed Correcetly");
										Assert.assertTrue(true);
										}else{
											System.out.println("Enroll Plan Link not displayed");
											Assert.fail();
										}
									}
								}}
						else if (planName.contains("PDP")) {
									for (WebElement plan : pdpPlanElement) {
										if (plan.getText().contains(planName)) {
											ElementData elementData = new ElementData("id", "enrollPDP"); // TODO:
																											// Re-check
											findChildElement(elementData, plan).click();

										}
										break;
									}
							}		                 
						return new ResponsivePlanSummaryUhc(driver);
					}else{
						System.out.println("No Enroll Option for SNP Plans");
						return null;
					}
 				}*/
				
				public void validatePlanCount(String planType){
					try {
						Thread.sleep(10000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					List<WebElement> planCardNumber = driver.findElements(By.xpath("//div[@class='"+planType+"benefittable']"
							+ "/parent::div/parent::div"));
					 
  								int planCountValue =	Integer.parseInt(planCount.getText());
  								System.out.println(planCountValue);
  								if(planCardNumber.size()==planCountValue){
  									System.out.println("------count number matches---"); 
  									validatePlanNumbersOnEachPlanCard(planType, planCountValue, "");
  									Assert.assertTrue(true);
  								}else{
  									System.out.println("-----count number mis-match-----");
  									Assert.fail();
  								}
                             
				}
				public MAEnrollmentPage clicklearnmorelink(String planName) {
					
					List<WebElement> plans = driver.findElements(By.xpath("//div[@class='vppplanheading ng-binding']"));
		               System.out.println("PLANS SIZE :: "+plans.size());
		               String xpath=" //div[@class='vppsub_planbtnbar']/div/span[@class='vppenroll vppenrolllink_enrollLink']";  
		                List<WebElement> learnMoreLinks = driver.findElements(By.xpath(xpath));            
		                System.out.println("LEARN MORE LINKS SIZE"+learnMoreLinks.size());     
		               for(int i=0; i<plans.size();i++){
		                      if(plans.get(i).getText().equalsIgnoreCase(planName)){
		                    	  learnMoreLinks.get(i).click();
		                            if(driver.getTitle().equalsIgnoreCase(PageTitleConstants.BLAYER_MEDICARE_ADVANTAGE_PLAN_ENROLLMENT_INFORMATION)){
		                                   try {
		                                          Thread.sleep(5000);
		                                   } catch (InterruptedException e) {
		                                          // TODO Auto-generated catch block
		                                          e.printStackTrace();
		                                   }
		                                   return new MAEnrollmentPage(driver);
		                            }
		                            break;
		                      }
		               }
		                      return null;
					// TODO Auto-generated method stub
				
		               }
				
	
				public boolean validateaddtocompare() {
					
             boolean presentLink =false;
					try {
						if(chkBoxAddtoCompare2.isDisplayed()){
							
							presentLink = true;
						}			  
						 
					} catch (NoSuchElementException e) {
						presentLink = false;
					}
					return presentLink;
					
				}
				
					// TODO Auto-generated method stub
				
			
				public boolean validateenrollbutton() {
					
     boolean presentLink =false;
					
					try {
						if(enrollbutton.isDisplayed()){
							
							presentLink = true;
						}			  
						 
					} catch (NoSuchElementException e) {
						presentLink = false;
					}
					return presentLink;
					// TODO Auto-generated method stub
					
				}
				public void validateBenefitTable(String monthlypremium,
						String primarycare, String specialist,
						String referralRequired, String prescriptionDrug, String planType, String planName) {
					System.out.println(driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/following-sibling::div[1]/div/div/div[@class='snpbenefittable']/ul/li[1]/span")).getText());
					System.out.println(monthlypremium);	
						if(monthlypremium.equals(driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/following-sibling::div[1]/div/div/div[@class='snpbenefittable']/ul/li[1]/span")).getText()))
							 {
								 System.out.println("Monthly premium is displayed");
								 Assert.assertTrue(true);
							 }
							 else
							 {
								 Assert.fail("Error in monthly premium");
							 }
						System.out.println(primarycare);
						     System.out.println(driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/following-sibling::div[1]/div/div/div[@class='snpbenefittable']/ul/li[2]/span")).getText());
							 
						     if((driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/following-sibling::div[1]/div/div/div[@class='snpbenefittable']/ul/li[3]/span")).getText()).contains(specialist))
							 {
								 System.out.println("specialist is displayed");
								 Assert.assertTrue(true);
							 }
							 else
							 {
								 Assert.fail("Error in specialist");
							 }
							 
							 if((driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent:"
								 		+ ":div/following-sibling::div[1]/div/div/div[@class='snpbenefittable'"
								 		+ "]/ul/li[2]/span")).getText()).contains(primarycare))
							 {
								 System.out.println("Specialist value is displayed");
								 Assert.assertTrue(true);
							 }
							 else
							 {
								 Assert.fail("Error in specialist value is not displayed");
							 }
							 if((driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/following-sibling::div[1]/div/div/div[@class='snpbenefittable']/ul/li[4]/span")).getText()).contains(referralRequired))
							 {
								 System.out.println("Referral value is displayed");
								 Assert.assertTrue(true);
							 }
							 else
							 {
								 Assert.fail("Error in referral value");
							 }
							 if((driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/following-sibling::div[1]/div/div/div[@class='snpbenefittable']/ul/li[5]/span")).getText()).contains(prescriptionDrug))
							 {
								 System.out.println("Prescription drug value is displayed");
								 Assert.assertTrue(true);
							 }
							 else
							 {
								 Assert.fail("Error in displaying Prescription drug value");
							 }
							 
							 
						
					
				}
				
				public void learnmore_button(String planName){
					if (planName.contains("UnitedHealthcare")) {
						driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/parent::div/following-sibling::div[2]/div[@class='content-secondary']/div/a/span")).click();
						if(!driver.getTitle().equals("plans")){
							System.out.println("Learn more page displayed"); 
							System.out.println(driver.getTitle());
							Assert.assertTrue(true);
						}else{
							System.out.println("Learn more page not displayed");
							Assert.fail();
						}

					}
				}
					
					public void validateBenefitTablema(String monthlypremium,
							String primarycare, String specialist,
							String referralRequired, String prescriptionDrug, String planType, String planName) {
						
						System.out.println(driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/parent::div/following-sibling::div[1]/div/div[1]/div[@class='mabenefittable']/ul/li[1]/span[1]")).getText());
						System.out.println(monthlypremium);	
							if(monthlypremium.equals(driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/parent::div/following-sibling::div[1]/div/div[1]/div[@class='mabenefittable']/ul/li[1]/span[1]")).getText()))
								 {
									 System.out.println("Monthly premium is displayed");
									 Assert.assertTrue(true);
								 }
								 else
								 {
									 Assert.fail("Error in monthly premium");
								 }
							System.out.println(primarycare);
							     System.out.println(driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/parent::div/following-sibling::div[1]/div/div[1]/div[@class='mabenefittable']/ul/li[2]/span[1]")).getText());
								 
							     if((driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/parent::div/following-sibling::div[1]/div/div[1]/div[@class='mabenefittable']/ul/li[3]/span[1]")).getText()).contains(specialist))
								 {
									 System.out.println("specialist is displayed");
									 Assert.assertTrue(true);
								 }
								 else
								 {
									 Assert.fail("Error in specialist");
								 }
								 
								 if((driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/parent::div/following-sibling::div[1]/div/div[1]/div[@class='mabenefittable']/ul/li[2]/span[1]")).getText()).contains(primarycare))
								 {
									 System.out.println("primary care is displayed");
									 Assert.assertTrue(true);
								 }
								 else
								 {
									 Assert.fail("Error in primary care is not displayed");
								 }
								 if((driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/parent::div/following-sibling::div[1]/div/div[1]/div[@class='mabenefittable']/ul/li[4]/span[1]")).getText()).contains(referralRequired))
								 {
									 System.out.println("Referral value is displayed");
									 Assert.assertTrue(true);
								 }
								 else
								 {
									 Assert.fail("Error in referral value");
								 }
								 if((driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/parent::div/following-sibling::div[1]/div/div[1]/div[@class='mabenefittable']/ul/li[6]/span[1]")).getText()).contains(prescriptionDrug))
								 {
									 System.out.println("Prescription drug value is displayed");
									 Assert.assertTrue(true);
								 }
								 else
								 {
									 Assert.fail("Error in displaying Prescription drug value");
								 }
						
						
					
					// TODO Auto-generated method stub
					
				}
			public DrugCostEstimatorPage navigateToDCE(String planType, String planName){
				if(planType.equals("MA")){
					driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/parent::div/"
							+ "following-sibling::div[1]/div/div[1]/div[@class='mabenefittable']/ul/li[6]/span[2]/a")).click();
					return new DrugCostEstimatorPage(driver);
				}
				return null;
			}	
			
			public ResponsivePlanSummaryUhc enrollInPlan(String planType, String planName){
                WebElement enrollNowLink;
				if(planType.equalsIgnoreCase("ma")){
					enrollNowLink = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]"
	            	 		+ "/parent::div/parent::div/following-sibling::div[2]/div/a/span"));
                	 enrollNowLink.click();
                  }else if(planType.equalsIgnoreCase("PDP")){
                	  enrollNowLink = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]"
                    			 +	"/parent::div/following-sibling::div[2]/div/a/span"));
                	  enrollNowLink.click();
                  }else if(planType.equalsIgnoreCase("SNP")){
                	 if(driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]"
 	            	 		+ "/parent::div/parent::div/following-sibling::div[2]/div/a/span")).isDisplayed()
                			 ||driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]"
                        			 +	"/parent::div/following-sibling::div[2]/div/a/span")).isDisplayed()){
                		 System.out.println("Enroll Now link displayed for SNP");
                		 Assert.fail();
                	 }else{
                		 System.out.println("Enroll Now link not displayed for SNP");
                		 return new ResponsivePlanSummaryUhc(driver);
                	 }
                  }
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                 if(enrollInPlan.getText().contains("You Have Chosen to Enroll in the Following Plan")){
                	 System.out.println("Enroll Plan Pop Up Displayed Correctly");
                	 return new ResponsivePlanSummaryUhc(driver);
                 } else{
                	 System.out.println("Enroll Pop up not displayed ");
                	 Assert.fail();
                 }
				return null;
			}
			public ResponsivePlanSummaryUhc validateEndorsedPlans(String planName, String urlType2) {
				
				if(urlType.equalsIgnoreCase("Endorse")){
					System.out.println(planName);
		             System.out.println(driver.findElement(By.xpath("//div[@class='segment-title']/h2")).getText()); 
					if(planName.equalsIgnoreCase(driver.findElement(By.xpath("//div[@class='segment-title']/h2")).getText())){
						System.out.println("Endorsed Plan Displayed Successfully");
						return new ResponsivePlanSummaryUhc(driver);
					}else{
						System.out.println("Endorsed Plan not Displayed Correctly");
						Assert.fail();
					} 
				}else if(urlType.equalsIgnoreCase("Non-Endorsed")){
					if(planName.equalsIgnoreCase(driver.findElement(By.xpath("//div[@class='segment-title']/h2")).getText())){
						System.out.println("Non Endorsed Plan Displayed Successfully");
						return new ResponsivePlanSummaryUhc(driver);
					}else{
						System.out.println("Non Endorsed Plan not Displayed Correctly");
						Assert.fail();
					} 
					
				}
				return null;
			}
				// TODO Auto-generated method stub
			public void changelocationcm() {
				
				validate(changeLoationLink);
				String pageTitle = driver.getTitle();
				System.out.println(pageTitle);
				changeLoationLink.click();	
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				System.out.println(driver.getTitle());
				if(!driver.getTitle().equals(pageTitle)){
					System.out.println("plan is not displayed"); 
					System.out.println(driver.getTitle());
					Assert.assertTrue(true);
				}else{
					System.out.println("Cm is displayed");
					Assert.fail();
				}


				// TODO Auto-generated method stub
				
			}
			
			public void selectPlanToCompare(String planName, String planType){
				if(planType.equalsIgnoreCase("MAPD")){
					System.out.println("Inside MAPD");
					driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/parent::div/following-sibling::div[2]/div/div/span[1]/label")).click();										
				}
				if(planType.equalsIgnoreCase("PDP")){
					System.out.println("Inside PDP");
					driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/following-sibling::div[2]/div/div/span[1]/label")).click();
				}
				
				//driver.findElement(By.xpath(".//*[@id='plan-list-1']/div/div[2]/div/div[3]/div[3]/div/div/span[4]/a")).click();
			}
				
			public void clickCompareLink(){
				driver.findElement(By.xpath(".//*[@id='plan-list-1']/div/div[3]/div/div[2]/div[3]/div/div/span[3]/a")).click();
 			}

			public void validateMedicalBenefitsTableblayer(String monthlyPremium1, String monthlyPremium2, String outofPocket1, String outofPocket2){
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
				 }}
			public ResponsivePlanDetailsUhc validateHeaderFooter(){
				if(headerElement.isDisplayed() && footerElement.isDisplayed()){
					System.out.println("==============Header Footer displayed correctly==============");
					return new ResponsivePlanDetailsUhc(driver);
				}else{
					System.out.println("==============Header Footer not displayed correctly==============");
					Assert.fail();
				}
				return null;
		 	}
			
			public ResponsivePlanSummaryUhc navigateToStartApplication(String planName){
				driver.findElement(By.xpath("//h2[text()='"+planName+"']/parent::a/parent::div/following-sibling::div[3]/div/a")).click();
				return new ResponsivePlanSummaryUhc(driver);
				}
			
			public void validatePlanNumbersOnEachPlanCard(String planType, int planCountValue, String drugName){
				if(planType.equalsIgnoreCase("MA")){
					List<WebElement> planCardNumber = driver.findElements(By.xpath("//h2[contains(text(),'HMO')]/parent::div/parent::div/span"));
					for(int i=0; i<planCardNumber.size(); i++){
						if(planCardNumber.get(i).getText().trim().equalsIgnoreCase((i+1)+" of "+planCountValue+" Plans")){
							System.out.println((i+1)+" of "+planCountValue +" value displayed correctly on plan number "+ (i+1));
							System.out.println(drugCost + " " +pharmacyDetails);
						}else{							 
							System.out.println("Value not displayed correectly on plan card number "+(i+1));
							Assert.fail();
						}
					}
				}if(planType.equalsIgnoreCase("PDP")){
					List<WebElement> planCardNumber = driver.findElements(By.xpath("//h2[contains(text(),'PDP')]/parent::div/span"));
					for(int i=0; i<planCardNumber.size(); i++){
						if(planCardNumber.get(i).getText().trim().equalsIgnoreCase((i+1)+" of "+planCountValue+" Plans")){
							System.out.println((i+1)+" of "+planCountValue +" value displayed correctly on plan number "+ (i+1));
						}else{							 
							System.out.println("Value not displayed correectly on plan card number "+(i+1));
							Assert.fail();
						}
					}
				}if(planType.equalsIgnoreCase("SNP")){
					List<WebElement> planCardNumber = driver.findElements(By.xpath("//h2[contains(text(),'SNP')]/parent::div/span"));
					for(int i=0; i<planCardNumber.size(); i++){
						if(planCardNumber.get(i).getText().trim().equalsIgnoreCase((i+1)+" of "+planCountValue+" Plans")){
							System.out.println((i+1)+" of "+planCountValue +" value displayed correctly on plan number "+ (i+1));
						}else{							 
							System.out.println("Value not displayed correectly on plan card number "+(i+1));
							Assert.fail();
						}
					}
				}
			}
			
			public ResponsivePlanSummaryUhc navigateToEstimateDrugPage(String planName, String planType, String drugName){
				if(planType.equalsIgnoreCase("MAPD")){
					System.out.println("Inside MAPD");
					driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/parent::div/"
							+ "following-sibling::div[1]/div/div[1]/div[@class='mabenefittable']/ul/li[6]/span[2]/a")).click();					 
				}
				if(planType.equalsIgnoreCase("PDP")){
					System.out.println("Inside PDP");
					driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/parent::div/div[2]/div/div/div[2]/ul/li[3]/span[2]/a")).click();
					return new ResponsivePlanSummaryUhc(driver);
				}if(planType.equalsIgnoreCase("SNP")){
					System.out.println("Inside SNP");
					driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/following-sibling::div[1]/div/div/div[2]/ul/li[5]/span[2]/a")).click();
					return new ResponsivePlanSummaryUhc(driver);
				}			
				return null;
			}
			
            public ResponsivePlanSummaryUhc addDrug(String drugName){
                try {
                       Thread.sleep(10000);
                } catch (InterruptedException e1) {
                       // TODO Auto-generated catch block
                       e1.printStackTrace();
                }
                
                //driver.findElement(By.cssSelector("div#add-drug>section")).click();
                driver.findElement(By.xpath("//*[contains(text(),' +ADD A DRUG')]")).click();
                try {
                    Thread.sleep(3000);
             } catch (InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
             }
                driver.findElement(By.id("drug-search-input")).sendKeys(drugName);
                
                driver.findElement(By.id("drug-search-button")).click();
                
                driver.findElement(By.id("drug-alt-search-button")).click();
                try {
                       Thread.sleep(2000);
                } catch (InterruptedException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                }
                driver.findElement(By.id("drug-dosage-button")).click();
                try {
                       Thread.sleep(3000);
                } catch (InterruptedException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                }
                driver.findElement(By.id("save-drug-button")).click();
                try {
                       Thread.sleep(3000);
                } catch (InterruptedException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                }
                driver.findElement(By.xpath("//a[contains(text(),'NEXT:')]")).click();
                try {
                       Thread.sleep(10000);
                } catch (InterruptedException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                }
                driver.findElement(By.xpath("//li[1]/div[1]/div[2]/button[@class='cta-button secondary select-pharmacy']")).click();
                try {
                       Thread.sleep(6000);
                } catch (InterruptedException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                }
                driver.findElement(By.xpath("//button[contains(text(),'NEXT:VIEW COSTS')]")).click();
                try {
                       Thread.sleep(6000);
                } catch (InterruptedException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                }
                pharmacyDetails = driver.findElement(By.cssSelector("div#acqsummary .pharmacy-container div#selectedPharmacyInfoId>p:first-child")).getText();
                try {
                       Thread.sleep(3000);
                } catch (InterruptedException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                }
                drugCost = driver.findElement(By.xpath("//*[text()='Costs']/parent::div/p")).getText();
                System.out.println(pharmacyDetails + "------------" + drugCost);     
                
                driver.findElement(By.xpath("//*[text()='See other plans']")).click();
                try {
                       Thread.sleep(3000);
                } catch (InterruptedException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
                }
                return new ResponsivePlanSummaryUhc(driver);
                
          }

			public ResponsivePlanSummaryUhc validateBenefitsTableAfterAddingDrug(String planType, String planName, String drugCostExpected){
			System.out.println(planType);
				String drugCostActual=null;
 				String drugCoverage=null;
 				WebElement editDrugLink=null;
 				try {
 					 Thread.sleep(10000);
 					 				} catch (InterruptedException e) {
 										// TODO Auto-generated catch block
 										e.printStackTrace();
 									}
 				if(planType.equalsIgnoreCase("MA")||planType.equalsIgnoreCase("MAPD")){
 					System.out.println("Inside mPAD");
 					drugCoverage = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/parent::div/following-sibling::div[1]/div/div[1]/div[2]/ul/li[7]/p")).getText();
 					drugCostActual = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/parent::div/following-sibling::div[1]/div/div[1]/div[2]/ul/li[7]/span[3]")).getText();
 					editDrugLink = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/parent::div/following-sibling::div[1]/div/div[1]/div[2]/ul/li[7]/a")); 								 
 				}if(planType.equalsIgnoreCase("PDP")){
 					drugCoverage = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/following-sibling::div[1]/div/div/div[2]/ul/li[4]/p")).getText();
 					drugCostActual = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/following-sibling::div[1]/div/div/div[2]/ul/li[4]/span[2]")).getText();
 					editDrugLink = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/following-sibling::div[1]/div/div/div[2]/ul/li[4]/a"));
 				}if(planType.equalsIgnoreCase("SNP")){
 					drugCoverage = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/following-sibling::div[1]/div/div/div[2]/ul/li[6]/p")).getText();
 					drugCostActual = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/following-sibling::div[1]/div/div/div[2]/ul/li[6]/span[2]")).getText();
 					editDrugLink = driver.findElement(By.xpath("//*[contains(text(),'"+planName+"')]/parent::div/following-sibling::div[1]/div/div/div[2]/ul/li[6]/span[4]/a"));
 				}
 				
 				System.out.println(drugCoverage+ "--" + drugCostActual + "==" +editDrugLink);
  				if(drugCoverage.contains("out of 1 drugs covered")
 					    && editDrugLink.isDisplayed()
 						&& drugCostActual.equals(drugCostExpected)){
 						System.out.println(drugCoverage+" =========displayed correctly");
 						Assert.assertTrue(true);
 					}else{
 						System.out.println("=======Drug cost not displayed corectly=============");
 						Assert.fail();
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
			 
			 public VASPage navigateToBLayerVASPage(){
				 vasButton.click();
 				 return new VASPage(driver);
				
				}
			 
			 }