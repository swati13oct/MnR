package pages.acquisition.ulayer;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
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
		
		@FindBy(xpath="//a[contains(text(),'Is my provider covered?')]")
		private WebElement providerSearchLink;
		
		@FindBy(xpath="//*[@class='content-cols']/div[1]/ul/li")
		private List<WebElement> marketingBullet;
		
		@FindBy(xpath="//div[2]/div/div/span[1]/span")
		private List<WebElement> planCountList;
		
		@FindBy(className="plan-index")
		private List<WebElement> planIndexList;
		
		/*@FindBy(xpath="//html/body/div[4]/div[2]/div[1]/div/div/div/div/div[1]/div/div/div/div[2]/div/div[2]/div[1]/div/span[1]")
		private WebElement showMaPlans;*/
		
		@FindBy(xpath="(.//span[text()='View Plans'])[2]")
		private WebElement showMaPlans;
			
		@FindBy(xpath="//div/div/div[2]/div/div[2]/div[2]/div/span[2]")
		private WebElement showPdpPlans;
		
		//planCOmpare path
		 @FindBy(id="compare-plan-1")
		 private WebElement chkBoxAddtoCompare1;
		    
	  @FindBy(id="compare-plan-2")
		    private WebElement chkBoxAddtoCompare2;
		    
		    @FindBy(id="compare-plan-3")
		    private WebElement chkBoxAddtoCompare3;
		    
		    @FindBy(id="compare-plan-4")
		    private WebElement chkBoxAddtoCompare4;
		    
		    @FindBy(className="single-added-text show")
		    private WebElement onePlanAdded;
		    
		    @FindBy(xpath=".//*[@id='plan-list-1']/div/div[2]/div/div[4]/div/div[3]/div/div/span[4]/a")
		    private WebElement comparePlans;
		    
		    @FindBy(xpath=".//*[@id='plan-list-1']/div/div[2]/div/div[1]/div[3]/div/div/span[3]/a")
		    private WebElement comparePlansLink;
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
public ResponsivePlanSummary viewPlanSummary(String planType) {
	if (planType.equalsIgnoreCase("PDP")) {
		showPdpPlans.click();
	} else if (planType.equalsIgnoreCase("MA")
			|| planType.equalsIgnoreCase("MAPD")) {
		System.out.println("inside MA");
		showMaPlans.click();
	}
	return new ResponsivePlanSummary(driver);
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
	 public void selectPlansToCompareTwoPlans(String planName1, String planName2){
			// int i=0;
			 List<WebElement> plans = driver.findElements(By.xpath("//h2[contains(text(),'AARP')]"));
			 System.out.println("PLANS SIZE :: "+plans.size());
			 String xpath="//label[contains(text(),'Add to Compare')]"; 
			// List<WebElement> comparePlansLink = driver.findElements(By.xpath("//*[contains(text(),'Compare plans')]"));
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
			 comparePlansLink.click();
 
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
		 
}