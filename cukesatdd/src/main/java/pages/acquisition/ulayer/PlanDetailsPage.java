/**
 * 
 */
package pages.acquisition.ulayer;


import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author gumeshna
 *
 */
public class PlanDetailsPage extends UhcDriver {

	@FindBy(id = "planDetailsPage")
	private WebElement plandetails;

	@FindBy(id = "learnmorebtnDetails")
	private WebElement waysToSaveLink;

	@FindBy(xpath=".//*[@id='highlights']/div/a")
	private WebElement enrollInPlanBtn;

	@FindBy(xpath = "//*[@id='detailplanNameBox']/div/div/div/span/h3")
	private WebElement planName;

	@FindBy(xpath = "//*[@id='yourDruglist']/div[1]/p[4]")
	private WebElement errorMessage;

	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[2]/td[3]/span[1]")
	private WebElement planCost1;
	
	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[2]/td[4]/span[1]")
	private WebElement planCost2;
	
	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[3]/td[4]/div/div/span[1]")
	private WebElement planCost3;
	
	@FindBy(xpath = "//*[@id='planCost']/table/tbody/tr[4]/td/div[3]/span[1]")
	//*[@id='planCost']/table/tbody/tr[4]/td/div[3]/span[1]
	private WebElement planCost4;
	
	@FindBy(xpath = ".//*[@id='highlights']/div/div/span[1]/label")
	private WebElement compareChkBox;
	
	@FindBy(xpath = ".//*[@id='highlights']/div/div/span[2]/span")
	private WebElement compareMessageBox;


       @FindBy(id = "yourDceInitial")
	private WebElement enterDrugInfoLink;
	
	    @FindBy(xpath = "//*[@id='yourDruglist']/div[2]/table/tbody/tr[3]/td/span[2]")
    private WebElement drugListCost;
    
    @FindBy(xpath = "//*[@id='yourDruglist']/div[2]/table/tbody/tr[4]/td/div[1]/p[1]")
    private WebElement drugListPharmacyName;
	
	@FindBy(id = "backToplans")
	private WebElement backToAllPlans;
	
	@FindBy(id="medicalbenefits")
	private WebElement medBenefitsTab;
	
	@FindBy(xpath="//*[@id='detail-0']/div/div/div[1]")
	private WebElement medBenefitsSection;
	
	@FindBy(xpath="//*[@id='detail-0']/div/div/div[2]")
	private WebElement addBenefitsSection;

	@FindBy(id = "prescriptiondrug")
    private WebElement presDrugTab;
	
	@FindBy(xpath=".//*[@id='drugBenefits']")
	private WebElement drugBenefitsSection;
	
	@FindBy(xpath=".//*[@id='DrugListDetails']")
	private WebElement drugListEditBtn;
	
	@FindBy(id = "estimateYourDrugsLink")
	private WebElement estimateDrugBtn;
	
	@FindBy(xpath="//*[@id='detailTabs']/div[1]/a[1]")
	private WebElement optRidersTab;
	
	@FindBy(xpath=".//*[@id='optionalRiders']")
	private WebElement optRiderSection;
	
	@FindBy(id="plancosts")
	private WebElement planCostsTab;
	
	@FindBy(id="planCosts")
	private WebElement planCostsSection;
	
	private PageData vppPlanDetails;

	public JSONObject vppPlanDetailsJson;
	
	@FindBy(xpath="//*[@id='bf3dfe9a-aba6-449b-865c-b5628cb03a60']/a[6]")
	private WebElement pdfLink;
	
	private PageData planDocsPDF;
	
	public JSONObject planDocPDFAcqJson;

	public PlanDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public String getContent() {
		return plandetails.getText();
	}

	public String getPlanDetails() {
		// TODO write implementation of the method
		return null;
	}


	@Override
	public void openAndValidate() {
		validate(medBenefitsTab);
		validate(presDrugTab);
		validate(planCostsTab);
		
	}

	public PlanInformationPage navigatetoenrollinplanlink(String planName)
	{
		enrollInPlanBtn.click();
		System.out.println(driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase("AARP Medicare Complete Online Application") || driver.getTitle().equalsIgnoreCase("AARP Medicarerx Online Application")|| driver.getTitle().equalsIgnoreCase("Enrollment Information"))
		{
			System.out.println("in if");
			return new PlanInformationPage(driver, planName);
		}

		return null;
	}

	

	public VPPPlanSummaryPage backtoPlanSummary(String planType) {
		validate(backToAllPlans);
		if(backToAllPlans != null){
		backToAllPlans.click();		
		return new VPPPlanSummaryPage(driver, planType);
		}
		
	return null;
		
	}

	public void validatePDFLinks() {
		// TODO Auto-generated method stub
		if(pdfLink!=null)
		{
			pdfLink.click();
		}
		
	}
	
	public JSONObject getActualPdfLinksData() {
		// TODO Auto-generated method stub
		String fileName = CommonConstants.PLAN_DOC_PDF_ACQ_PAGE_DATA;
		planDocsPDF = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		
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
	


	public void validateDrugList(String planName,String expectedErrorMessage) {
		driver.navigate().refresh();
		String pName = planName.toString();
		if(pName.contains(planName)){
			//String expectedErrorMessage = "The pharmacy selected is not part of this plan's pharmacy network. Please edit your current pharmacy to estimate your drug costs for this plan.";
			String actualErrorMessage = errorMessage.getText();
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

	public void validatePlanCost(String planName) {
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
		
		if(validate(medBenefitsTab)&&validate(presDrugTab)&&validate(planCostsTab)&&
				medBenefitsSection.getText().contains("Monthly Premium"))
			return true;
		return false;
			
	}
    

	public DrugCostEstimatorPage navigateToDCE() {

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		presDrugTab.click();
		estimateDrugBtn.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(currentUrl().contains("/estimate-drug-costs.html"))
			return new DrugCostEstimatorPage(driver);
		return null;
	}

	public boolean validateCompareBoxMessage() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		compareChkBox.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(compareMessageBox.getText().contains("2 plans added") && compareMessageBox.getText().contains("Compare plans") )
			return true;
		return false;
	}

   	



	

}