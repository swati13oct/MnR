package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.acquisition.uhcretiree.Rallytool_Page;
import pages.acquisition.bluelayer.VPPPlanSummaryPage;
import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class PlanDetailsPage extends UhcDriver{

	@FindBy(id = "planDetailsPage")
	private WebElement planDetailsContent;

	@FindBy(id = "learnmorebtnDetails")
	private WebElement learnMoreButton;

	@FindBy(id = "yourDceInitial")
	private WebElement enterDrugInfoLink;

	@FindBy(xpath ="/html/body/div[4]/div/table/tbody/tr[2]/td/div/table/tbody/tr[2]/td/div/div/div[2]/div/div/div/div[2]/div[2]/div[1]/div/div[2]/div/div/table/tbody/tr[4]/td[2]/a")
	private WebElement plandetailsProviderlink;

	@FindBy(xpath =".//*[@id='myDoctorDetails']")
	private WebElement plandetailProviderlink;

	@FindBy(xpath = "//*[@id='yourDruglist']/div[1]/p[4]")
	private WebElement errorMessage;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[2]/td[3]/span[1]")
	private WebElement planCost1;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[2]/td[4]/span[1]")
	private WebElement planCost2;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[3]/td[4]/div/div/span[1]")
	private WebElement planCost3;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[4]/td/div[3]/span[1]")
	private WebElement planCost4;
	

	@FindBy(xpath = ".//*[@id='site-wrapper']/div[4]/div/div/div/div/div/div/div[1]/div/div/a")
	private WebElement backToAllPlans;
	
	@FindBy(xpath = "//*[@id='yourDruglist']/div[2]/table/tbody/tr[3]/td/span[2]")
    private WebElement drugListCost;
    
    @FindBy(xpath = "//*[@id='yourDruglist']/div[2]/table/tbody/tr[4]/td/div[1]/p[1]")
    private WebElement drugListPharmacyName;
	
    @FindBy(xpath = "//*[@id='detailplanNameBox']/div/div/div/span/h3")
	private WebElement planName;
    
    @FindBy(xpath=".//*[@id='medicalBenefits']")
	private WebElement medBenefitsSection;
	
	@FindBy(xpath=".//*[@id='myDoctorDetails']")
	private WebElement isMyDoctorCoveredLink;
	
	@FindBy(xpath=".//*[@id='additionalBenefits']")
	private WebElement addBenefitsSection;

	@FindBy(xpath=".//*[@id='drugCopayandDiscounts']")
	private WebElement drugCoPaysSection;
	
	@FindBy(xpath=".//*[@id='backToplans']")
	private WebElement backToPlansBtn;
	
	@FindBy(xpath=".//*[@id='enrollDetails']")
	private WebElement enrollInPlanBtn;
	
	@FindBy(xpath=".//*[@id='optRiders']")
	private WebElement optRiderSection;
	
	@FindBy(xpath=".//*[@id='planCost']")
	private WebElement planCostsSection;
	
	 @FindBy(xpath = ".//*[@id='highlights']/div/div/span[1]/label")
	 private WebElement compareBox;
	 
	 @FindBy(xpath = ".//*[@id='highlights']/div/div/span[2]/span/span")
	 private WebElement compareBoxMessage;
	 
	 @FindBy(xpath = ".//*[@id='highlights']/div/div/span[2]/span")
	 private WebElement compareBoxMessagePDP;
	    
	@FindBy(xpath=".//*[@id='_content_uhcmedicaresolutions_en_health-plans_medicare-advantage-plans_plan-detail_jcr_content_contentPar_plandetails_parsys_plandetailstwocoloum_parsys_teaser']")
	private WebElement planDocsSection;

	private PageData vppPlanDetails;

	public JSONObject vppPlanDetailsJson;
	
	private PageData planDocsPDF;
	
	public JSONObject planDocPDFAcqJson;
	

	public PlanDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//openAndValidate();
	}

	public String getPlanDetails() {
		return planDetailsContent.getText();

	}

	public AddDrugPage navigateToWTSPage() {
		learnMoreButton.click();
		if(driver.getTitle().equalsIgnoreCase("Plan Details"))
		{
			return new AddDrugPage(driver);
		}
		else
		{
			return null;
		}

	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : vppPlanDetails.getExpectedData().keySet()) {
			WebElement element = findElement(vppPlanDetails.getExpectedData()
					.get(key));
			if (element != null) {
				if(validate(element)){
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
		vppPlanDetailsJson = jsonObject;

	}

	public GetStartedPage clicksOnEnterDrugInformationLink() {

		enterDrugInfoLink.click();

		if (currentUrl().contains("/estimate-drug-costs")) {
			return new GetStartedPage(driver);
		}
		return null;
	}

	public Rallytool_Page lookupproviderclick() {
		validate(plandetailsProviderlink);
		plandetailsProviderlink.click();
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase(
				"Welcome")) {
			return new Rallytool_Page(driver);
		}

		// TODO Auto-generated method stub
		return null;
	}

	public Rallytool_Page lookupaproviderclick() {
		validate(plandetailProviderlink);
		plandetailProviderlink.click();
		ArrayList<String> tabs = new ArrayList<String>(
				driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		if (getTitle().equalsIgnoreCase(
				"Welcome")) {
			return new Rallytool_Page(driver);
		}




		// TODO Auto-generated method stub
		return null;
	}

	public void validateDrugList(String nameOfPlan, String expectedErrorMessage) {
		driver.navigate().refresh();
		String pName = planName.getText().toString();
		if(pName.contains(nameOfPlan)){
			//String expectedErrorMessage = "The pharmacy selected is not part of this plan's pharmacy network. Please edit your current pharmacy to estimate your drug costs for this plan.";
			String actualErrorMessage = errorMessage.getText().toString();
			if(actualErrorMessage.equals(expectedErrorMessage))
			{
				System.out.println("Validated the error message");
			}
			else{
				System.out.println("Expected Error Message is --------"+expectedErrorMessage);
				System.out.println("But got ---------"+actualErrorMessage);
			}

		}
		else{
			System.out.println("The user is not on the correct page");
		}

	} 

	public VPPPlanSummaryPage backtoPlanSummaryPage() {
		validate(backToAllPlans);
		if(backToAllPlans != null){
		backToAllPlans.click();		
		return new VPPPlanSummaryPage(driver);
		}
		
	return null;
		
	}
	
	public boolean validatePlandetails(String planName){
		boolean flag = true;
		String fileName = null;
		if(planName.contains("HMO"))
		{
			fileName = "maplandetails.json";
		}
		if(planName.contains("PDP"))
		{
			fileName = "pdpplandetails.json";
		}
		if(planName.contains("SNP"))
		{
			fileName = "snpplandetails.json";
		}
		ElementData elementData = new ElementData("className", "detailplanNameBg");
		WebElement detailPlanName = findElement(elementData);
		System.out.println(detailPlanName.isDisplayed());
		System.out.println("detailPlanName: "+detailPlanName.getText());
		
		vppPlanDetails = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);
		for (String key : vppPlanDetails.getExpectedData().keySet()) {
			WebElement element = findElement(vppPlanDetails.getExpectedData()
					.get(key));
			System.out.println("key : "+key);
			if (element != null) {
				System.out.println("element.getText() : "+element.getText());
				flag = validate(element);
				if(!flag){
					break;
				}
			}
		}
		return flag;
	}
	
	public JSONObject getActualPdfLinksData() {
		// TODO Auto-generated method stub
		String fileName = CommonConstants.PLAN_DOC_PDF_ACQ_PAGE_DATA;
		planDocsPDF = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_ACQ);		
		JSONObject jsonObject = new JSONObject();
		for (String key : planDocsPDF.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(planDocsPDF.getExpectedData()
					.get(key));
			JSONArray jsonArray = new JSONArray();
			for (WebElement element : elements) {				
				element.click();
				try {
					JSONObject jsonObjectForArray = new JSONObject();
					jsonObjectForArray.put(element.getText(), element.getAttribute("href"));
					jsonArray.put(jsonObjectForArray);
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			try {
				jsonObject.put(key, jsonArray);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}					
		}
		planDocPDFAcqJson = jsonObject;
		return planDocPDFAcqJson;
	}


	public void validatePlanCost(String planName){
		String pName = planName.toString();
		String pCost1 = planCost1.getText();
		String pCost2 = planCost2.getText();
		String pCost3 = planCost3.getText();
		String pCost4 = planCost4.getText();
		if(pName.contains(planName)){
			if(pCost1.equals("--")&&pCost2.equals("--")&&pCost3.equals("--")&&pCost4.equals("--")){
				System.out.println("Verified Plan Costs");
			}
			else{
				System.out.println("Plan costs contains data");
			}


		}
		else{
			System.out.println("The user is not on the correct page");
		}

	}
	
	    public void validatePharmacyNameAndDrugCost(String drugCost,
            String pharmacyName) {
        String drugCostActual = drugListCost.getText();
        System.out.println(drugCostActual);
        String pharmacyNameActual = drugListPharmacyName.getText();
        System.out.println(pharmacyNameActual);
        if(drugCost.equals(drugCostActual) && pharmacyName.equals(pharmacyNameActual))
            System.out.println("The results is as expected");
        else
            System.out.println("Fail");
        
    }
	
	    public boolean validatePlanDetailsPage(){
			boolean flag = false;
			if(validate(backToPlansBtn)&&validate(isMyDoctorCoveredLink)&&validate(enrollInPlanBtn)&&
					medBenefitsSection.getText().contains("Monthly Premium")&&addBenefitsSection.getText().contains("Routine Physical")
					&&drugCoPaysSection.getText().contains("Annual Prescription Deductible")&&optRiderSection.getText().contains("Optional Dental")&&
					optRiderSection.getText().contains("High Option Dental")&& planCostsSection.getText().contains("Plan Premium")
					&& planCostsSection.getText().contains("Estimated Annual Total")&&planDocsSection.getText().contains("General Plan Information")){
				flag =true;
				
			}
			return flag;
		}

	   
		public boolean validateCompareBox() {
			clickCompareBox();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			clickCompareBox();
			if(compareBoxMessage.getText().contains("plans added") && compareBoxMessage.getText().contains("Compare plans"))
				return true;
			return false;
		}
		
		public void clickCompareBox(){
			compareBox.click();
		}
		
		public boolean validateCompareBoxPDP() {
			clickCompareBox();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(compareBoxMessagePDP.getText().contains("1 plan added, please select another plan to continue"))
				return true;
			return false;
		}
}


