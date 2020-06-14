package pages.dashboard_deprecated.member.blayer;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import junit.framework.Assert;

public class ClaimsSummary extends UhcDriver{



	private PageData newClaimsSummarypage;

	public JSONObject newClaimsSummaryJson;

	@FindBy(xpath="//*[@id='MA']")
	private WebElement MA;

	@FindBy(xpath="//*[@id='MAPD']")
	private WebElement MAPD;

	@FindBy(xpath="//*[@id='PDP']")
	private WebElement PDP;

	@FindBy(xpath="//*[@id='summaryview']/div/div/div[1]/div/div/div/div/div/div/h1")
	private WebElement myCaimsText;

	@FindBy(xpath="//*[@id='medical']")
	private WebElement ClaimsSummaryPage;

	@FindBy(xpath="//div[contains(.,'Medical')]")
	private WebElement claimTypeMA;

	@FindBy(id="claim-type")
	private WebElement claimTypeMAPD;


	@FindBy(xpath="//div[normalize-space()='Prescription Drug']")
	private WebElement claimTypePDP;

	@FindBy(xpath=".//*[@id='document-date']")
	private WebElement viewClaimsFrom;

	@FindBy (xpath="(.//*[@id='summaryview']//section/div/div/div/p)[1]")                    
	private WebElement claimsCopyText;


	@FindBy (xpath="(.//*[@id='summaryview']//section/div/div/div/p)[2]")                    
	private WebElement claimsCopyText2;

	@FindBy (xpath=".//*[@id='table-medical']//div/h2")
	private WebElement dynamicNumberOfClaimsText;
	
	@FindBy (xpath="//*[@id='table-medical']/div[1]/div[1]/div/h2[2]")
	private WebElement dynamicNumberOfClaimsTextPDP;

	@FindBy (xpath=".//*[@id='table-medical']/div[3]/div/div")
	private WebElement claimsTable;

	@FindBy (xpath=".//*[@id='summaryview']/div/div/main/div/div[2]/section/div/div/div[2]/div/div/ul")
	private WebElement claimsTablePagination;

	@FindBy (xpath="//h2[contains(.,'Medical EOB')]")
	private WebElement medicalEobText;

	@FindBy (xpath="//h2[contains(.,'Prescription Drug EOB')]")
	private WebElement PrescriptionEobText;

	@FindBy (xpath="//*[@id='table-medical']/div[2]/div[1]/div/a")
	private WebElement learnmore;
	
	@FindBy (xpath = ".//*[@id='table-medical']/div[2]/div[2]/div/a")
	private WebElement learnmorePDP;

	@FindBy (xpath="//img[@alt='Blue Button']")
	private WebElement downloadmydatabutton;

	@FindBy (xpath=".//*[@id='differentProviderClaims']/div/div")
	private WebElement proceedToDownloadPopUp;

	public ClaimsSummary(WebDriver driver) {
		super(driver);

		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, ClaimsSummaryPage, 60);
	}

	@Override
	public void openAndValidate() {
		JSONObject jsonObject = new JSONObject();
		for (String key : newClaimsSummarypage.getExpectedData().keySet()) {
			WebElement element = findElement(newClaimsSummarypage.getExpectedData().get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		newClaimsSummaryJson = jsonObject;

		System.out.println("newClaimsSummaryJson----->" + newClaimsSummaryJson);

	}

	@SuppressWarnings("deprecation")
	public void validateHeader() {

		if(myCaimsText.getText().contains("My Claims")){
			Assert.assertTrue(true);
		}
		else{
			Assert.fail("Claims Page Header Not found");
		}
	}


	public  boolean validateClaimType(String abc){	

		if(abc.equals("MA")){	
			return claimTypeMA.isDisplayed();		
		}
		else if(abc.equals("PDP")){	
			System.out.println(claimTypePDP.isDisplayed());
			return claimTypePDP.isDisplayed();		
		}
		else{
			System.out.println(claimTypeMAPD.isDisplayed());
			return claimTypeMAPD.isDisplayed();	
			/*Select select = new Select(claimTypeMAPD);
			int size = select.getOptions().size();
			//select.getFirstSelectedOption()
			if(size!=2){
				return false;		
			}
			else{
				List<WebElement> values = select.getOptions();
				System.out.println(values.get(0));
				System.out.println(values.get(1));

				return values.get(0).equals("medical")&&values.get(1).equals("prescription drug");
			}*/
		}	
	}	
	public String validateViewClaimsFromDropDown(){		
		Select select = new Select(viewClaimsFrom);
		return select.getFirstSelectedOption().getText(); 		
	}

	public boolean verifyCopyText(){
		return claimsCopyText.isDisplayed();
	}


	public boolean verifyCopyText2(){
		return claimsCopyText2.isDisplayed();
	}


	public boolean verifyDynamicText(){
		return dynamicNumberOfClaimsText.isDisplayed() || dynamicNumberOfClaimsTextPDP.isDisplayed();

	}

	public boolean verifyClaimsTableAndPagination(){

		return claimsTable.isDisplayed() && claimsTablePagination.isDisplayed();

	}

	public boolean validteEobfordifferentDomainType(String domain, String plantype){

		if (domain.equals("COSMOS")&& plantype.equals("MAPD"))
		{
			System.out.println("for MAPD COSMOS  medical and precription drug EOB's are displayed===> "+ (medicalEobText.isDisplayed() && PrescriptionEobText.isDisplayed()));
			return medicalEobText.isDisplayed() && PrescriptionEobText.isDisplayed();

		}
		else if (domain.equals("NICE")&&plantype.equals("MAPD"))
		{
			System.out.println("for MAPD NICE prescription drug EOB's are displayed ===>"+ (PrescriptionEobText.isDisplayed()));
			return PrescriptionEobText.isDisplayed();
		}
		else if (plantype.equals("MA"))
		{
			System.out.println("for MA medical Eob is diplayed ====>"+ (medicalEobText.isDisplayed()));
			return medicalEobText.isDisplayed();
		}
		else {
			System.out.println("for PDP prescription drug EOB's are diaplayed ====> "+ (PrescriptionEobText.isDisplayed()));
			return PrescriptionEobText.isDisplayed();
		}
	}

	public void navigateToRequiredPlan(String planType) {
		if(planType.equals("MAPD") )
			MAPD.click();
		else if(planType.equals("MA"))
			MA.click();
		else if(planType.equals("PDP"))
			PDP.click();
	}

	public boolean validateLearnmoreaboutsection() {

		return learnmore.isDisplayed() || learnmorePDP.isDisplayed();

	}

	public Boolean validateDownloadMyDataButton(){

		System.out.println("download my data button is displayed ====>"+ (downloadmydatabutton.isDisplayed()));

		if (downloadmydatabutton.isDisplayed())

		{			
			downloadmydatabutton.click();	
			waitforElement(proceedToDownloadPopUp);

			System.out.println("proceed button pop up is displayed ====>"+(proceedToDownloadPopUp.isDisplayed()));
			return proceedToDownloadPopUp.isDisplayed();
		}
		else 
		{
			System.out.println("bownlaod my data button is not displayed ");
			return false;
		}
	}

}
