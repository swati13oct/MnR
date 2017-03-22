package pages.acquisition.ulayer;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
import java.util.ArrayList;
import pages.member.ulayer.Rallytool_Page;
import pages.mobile.acquisition.ulayer.VPPAarpNeedAStepBackWidget;
import pages.mobile.acquisition.ulayer.VPPAarpNeedHelpWidgetPage;
import pages.mobile.acquisition.ulayer.VPPNeedMoreInformationWidget;
import pages.mobile.acquisition.ulayer.VPPRequestSendEmailPage;

public class ResponsivePlanSummary extends UhcDriver{
	
	//US504467
		@FindBy(xpath = "//div[@class='tab'][1]")
		private WebElement viewMaPlans;
		
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
		
		/*@FindBy(xpath="//html/body/div[4]/div[2]/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div/span[1]")
		private WebElement showMaPlans;*/
		
		@FindBy(xpath="(.//span[text()='View Plans'])[2]")
		private WebElement showMaPlans;
		
		 @FindBy(id="compare-plan-1")
		    private WebElement chkBoxAddtoCompare1;
		    
		 @FindBy(id="compare-plan-2")
		    private WebElement chkBoxAddtoCompare2;
		    
		 @FindBy(id="compare-plan-3")
		  private WebElement chkBoxAddtoCompare3;
		    
		    @FindBy(id="compare-plan-4")
		    private WebElement chkBoxAddtoCompare4;
		    
		    @FindBy(xpath="(//*[text()='Compare plans'])[8]")
		    private WebElement comparePlans;
		    
		    @FindBy(xpath="(.//*[text()='View details'])[1]")
		    private WebElement viewDetails;
		    
		    @FindBy(xpath="(.//*[@class='remove-button'])[1]")
		    private WebElement removePlanlnk;
		    
		    @FindBy(xpath="(.//*[@class='remove-button'])[2]")
		    private WebElement removePlanlnk1;
		    
		    @FindBy(xpath=".//*[@id='fixTable']/tbody/tr[24]/td/p")
		    private WebElement footNote;
		    
		    @FindBy(xpath=".//*[@class='parbase planscompare section']/div[2]")
		    private WebElement disclaimerTxt;
		
		
		
		
		@FindBy(xpath="//div/div/div[2]/div/div[2]/div[2]/div/span[2]")
		private WebElement showPdpPlans;

	private PageData vppPlanSummary;

	public JSONObject vppPlanSummaryJson;
	
	public ResponsivePlanSummary(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, responsivevpppage, CommonConstants.TIMEOUT_30);

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
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//waitforElement(selectAddToCompareCheckbox);
	//System.out.println(chkBoxAddtoCompare1.isEnabled());
	
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
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

public void disclaimerText(){
	String disclaimertxt = disclaimerTxt.getText();
	System.out.println(disclaimertxt);
}

public ResponsivePlanSummary viewPlanSummary(String planType) {
	if (planType.equalsIgnoreCase("PDP")) {
		showPdpPlans.click();
	} else if (planType.equalsIgnoreCase("MA")
			|| planType.equalsIgnoreCase("MAPD")) {
		System.out.println("inside MA");
		if(showMaPlansClickable.isEnabled()&& showMaPlansClickable.isDisplayed()){
		showMaPlansClickable.click();
		}
	}
	else if (planType.equalsIgnoreCase("MS")) {
		showMsPlans.click();
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"AARP Medicare Supplement Insurance Plans")){
//	return new ResponsivePlanSummary(driver);
}
	}
	return null;
}
 
public void comparePlanslnk(){
	comparePlans.click();
	validate(comparePlans);
	
}
	public void validateStickyZipcode(String actualZipcode){
		validate(changeLoationLink);
		changeLoationLink.click();
		String stickyZipcode=zipcodeBox.getAttribute("");
		if(stickyZipcode.equals(actualZipcode)){
			System.out.println("zipcode box displays sticky zipCode as  "+stickyZipcode);
			Assert.assertTrue(true);
		}else{
			System.out.println("zipcode box doesn't displays sticky zipCode as  "+stickyZipcode);
			Assert.fail();
		}
		
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
	 
	 public ResponsivePlanDetails viewPlanDetails(String planName){
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
			 String xpath="//a[contains(text(),'Is my provider covered?')]";  
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
}