package pages.mobile.acquisition.commonpages;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ole.PlanPremiumPage;
import pages.mobile.acquisition.ole.PrimaryCarePhysicianPageMobile;

public class ProposedEffectiveDatePageMobile extends UhcDriver{
	
	@FindBy(id = "proposedsavncnt")
	private WebElement saveAndContinue;
	
	@FindBy(xpath = "//*[@id='enrollment-step-1-part-10']/div[1]/div/div[1]")
	private WebElement segmentHeading;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-1-part-10']/div[1]/div/div[2]/fieldset/span/label")
	private WebElement proposedDate;
	
	private PageData ped;

	public JSONObject pedJson;

	public ProposedEffectiveDatePageMobile(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.PED_PAGE_DATA;
		ped = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_ACQ);
		//PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		
		validate(saveAndContinue);
		
		
		JSONObject jsonObject = new JSONObject();
		for (String key : ped.getExpectedData().keySet()) {
			WebElement element = findElement(ped.getExpectedData()
					.get(key));
			if (element != null) {
				if (validate(element)) {
					try {
						jsonObject.put(key, element.getText());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
		pedJson = jsonObject;
		
	}
	
	public void selectTheDate() {
		proposedDate.click();
	}
	

	@FindBy(xpath = "//*[@type='radio']//following-sibling::label")
	private List <WebElement> ProposedEffectiveDateOptions;
	
	public boolean validate_proposed_effective_date_options(){
		boolean validation_Flag = true;
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = ProposedEffectiveDateOptions.size();
		if(count>0){
			validation_Flag = true;
			System.out.println("Proposed Effective Date displayed");
			for(WebElement Dateoption : ProposedEffectiveDateOptions){
				System.out.println(Dateoption.getText());
			}
		}
		else{
			System.out.println("Proposed Effective Date is NOT displayed");
			validation_Flag = false;
		}
		return validation_Flag;
	}
	
	@FindBy(id = "ole-form-next-button")
	private WebElement NextBtn;
	
	public Object navigate_to_PCP_Page(String planType) {

		validateNew(NextBtn);
		jsClickNew(NextBtn);
		threadsleep(2000);
		/*JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", NextBtn);*/
		
		if(planType.contentEquals("PDP")){
			if(validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Plan Premium')]")))){
				System.out.println("OLE Monthly Plan Premium Page is Displayed");
				return new PlanPremiumPage(driver);
			}
			else{
				System.out.println("OLE Monthly Plan Premium Page is Not Displayed");
				return null;
			}
		}
		else{
			if (validateNew(driver.findElement(By.xpath("//h1[contains(text(),'Provider')]")))){
				System.out.println("OLE Primary Care Physician Page is Displayed");
				return new PrimaryCarePhysicianPageMobile(driver);
			}
			else{
				System.out.println("OLE Primary Care Physician Page is Not Displayed");
				return null;
			}
		}
	}
	
	public String get_proposed_effective_date(){
		String proposedEfDate = null;
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = ProposedEffectiveDateOptions.size();
		if(count>0){
			System.out.println("Proposed Effective Date displayed");
			proposedEfDate= ProposedEffectiveDateOptions.get(0).getText();
		 }
		else{
			System.out.println("Proposed Effective Date is NOT displayed");
			
		}
		return proposedEfDate;
	}
	
	
	public ReviewAndSubmitPageMobile clickOnSaveAndContinue(String plantype){
		//if(segmentHeading.getText().contains("Proposed Effective Date")){
			saveAndContinue.click();
			try {
				  Thread.sleep(10000);
				} catch (InterruptedException ie) {
				    //Handle exception
				}
			
			return new ReviewAndSubmitPageMobile(driver,plantype);	
		//}
		//return null;
	}
	@FindBy(xpath = ".//*[@id='enrollment-step-1-part-10']/div[1]/div/div[2]/fieldset/span/label")
	private WebElement dateRadioBtn;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-1-part-10']/div[2]/a[2]")
	private WebElement pedPrevBtn;
	
	@FindBy(xpath = ".//*[@id='enrollment-step-1-part-10']/div[2]/a[3]")
	private WebElement pedCancelBtn;
	
	public boolean validateEffectiveDatePage(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(validate(segmentHeading)&&validate(saveAndContinue)&&validate(dateRadioBtn)&&
		validate(pedPrevBtn)&&validate(pedCancelBtn))
			return true;
		return false;
	}
	
}

