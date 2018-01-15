/**
 * 
 */
package pages.member.bluelayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import acceptancetests.login.data.LoginCommonConstants;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class FormsandresourcesPage extends UhcDriver {

	@FindBy(xpath = "/html/body/div[6]/div/div/table/tbody/tr[5]/td/div[2]/div/div/div[2]/div[5]/div/div/div/div/div/div/div/div/div/div[2]/div/div/div/div")
	private WebElement PlanMaterialsSection;

	@FindBy(linkText = "Plan Benefits")
	private WebElement benefitsLink;
	
	@FindBy(xpath = ".//*[@id='_content_campaigns_uhcm_formsresources-main_formsresources-main_jcr_content_par_teaser_2']")
	private WebElement eobSectionBox;

	@FindBy(xpath = ".//*[@id='_content_campaigns_uhcm_formsresources-main_formsresources-main_jcr_content_par_teaser_2']/div/div[1]/div[2]/div[1]/p[2]/a")
	private WebElement medicalEobLink;

	@FindBy(xpath = ".//*[@id='_content_campaigns_uhcm_formsresources-main_formsresources-main_jcr_content_par_teaser_2']/div/div[1]/div[2]/div[1]/p[3]/a")
	private WebElement prescriptionDrugEobLink;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	@FindBy(xpath = "//*[@id='SummaryofBenefits_-1609990126']/p/a")
	private WebElement PDF1;

	@FindBy(xpath=".//*[contains(text(),'search providers')]")
	private WebElement searchProvider;
	
	@FindBy(xpath="//*[@id='benefits']/a")
	private WebElement benefitsAndCoverage;  
	
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[1]/div/div/div/div/span[2]")
	private WebElement planName;
	
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div[1]/div[1]/div[2]")  
	private WebElement memberNameText;
	
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[2]/div[3]/span[2]")
	private WebElement monthlyPremiumText;
	
	@FindBy(linkText = "Prescription Mail Order Form - Preferred Mail Service Pharmacy through OptumRx")
	private WebElement preferredMailOrderLink;
	
	@FindBy(id="addAnotherPlanLink")
	private WebElement addPlansTab;
	
	@FindBy(className="fd_FormsResouceSelected")
	private WebElement formsAndResourcesTab;

	@FindBy(linkText = "Passport Flyer")
	private WebElement passport_Flyer;
	
	@FindBy(linkText = "Passport Flyer Spanish")
	private WebElement passport_Flyer_Spanish;
	
	@FindBy(xpath = ".//*[@id='_content_campaigns_uhcm_formsresources-plandocs-main_group_jcr_content_par_borderedtitledescrip_subContent_teaser_1']/div/p[1]")
	private WebElement myDocuments;

	@FindBy(xpath = ".//*[@id='_content_campaigns_uhcm_formsresources-plandocs-main_group_jcr_content_par_borderedtitledescrip_subContent_teaser_1']/div/p[2]/a")
	private WebElement viewMyDocsLink;
	
	private PageData formsAndResources;

	public JSONObject formsAndResourcesJson;

	private PageData planDocsPDF;

	private JSONObject planDocPDFsJson;

	public FormsandresourcesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.FORMS_AND_RESOURCES_PAGE_DATA;
		formsAndResources = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public String getPlanDocumentContent() {
		return PlanMaterialsSection.getText();
	}

	public MedicalEobPage navigateToMedicalEob() {
		medicalEobLink.click();
		CommonUtility.checkPageIsReady(driver);

		if (currentUrl().contains("medical-eob-search.html")) {
			return new MedicalEobPage(driver);
		}
		return null;
	}

	public PrescriptionDrugEobPage navigateToPresDrugEob() {
		CommonUtility.waitForPageLoad(driver, prescriptionDrugEobLink, 20);
		prescriptionDrugEobLink.click();
		CommonUtility.checkPageIsReady(driver);

		if (currentUrl().contains("part-d-eob-search.html")) {
			return new PrescriptionDrugEobPage(driver);
		}
		return null;
	}

	public void logOut() {
		logOut.click();

	}
	
	public FormsandresourcesPage clickBenefitsAndCoverage(){
		benefitsAndCoverage.click();
		  
		return new FormsandresourcesPage(driver);  
	}
	/* public Rallytool_Page clickAndValidateProviderSearch(){
		  // waitforElement(searchProviderButton);
		   searchProvider.click();
		   switchToNewTab();
		   if(currentUrl().contains("connect.werally.com")){
			   System.out.println("Rally Tool Launched Sucessfully");
			   System.out.println("--------------Page Title="+getTitle());
			   return new Rallytool_Page(driver);
		   }else{
			   System.out.println("-------------Failed as rally did not launch in new tab-------------");
			   Assert.fail();
			   return null;
		   }
	   }*/
	public void validatePlanName(){
    	String planName = LoginCommonConstants.PLAN_NAME;
    	System.out.println(planName);
    	List<WebElement> planWebElement = driver.findElements(By.xpath("//*[text()='"+LoginCommonConstants.PLAN_NAME+"']"));
    	for(int i=0; i<planWebElement.size();i++){
    		if(planWebElement.get(i).getText().contains("HealthSelect Medicare Rx ")){
    			System.out.println("----------Failed due to presence of HealthSelect Medicare Rx ------------");
    			Assert.fail();
    		}
    		else if(planWebElement.get(i).getText().equalsIgnoreCase(LoginCommonConstants.PLAN_NAME)){
    			System.out.println("----------Plan name displayed as expected="+planName);
    		} else{
	    			System.out.println("----------Failed because Plan NAme not present");
	    			Assert.fail();
	    		} 	  		 
    	}
 }
	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		/* get FORMS AND RESOURCES expected data */ 
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject formsAndResourcesExpectedJson = expectedDataMap
				.get(CommonConstants.FORMS_AND_RESOURCES);
		formsAndResourcesExpectedJson = CommonUtility.mergeJson(
				formsAndResourcesExpectedJson, globalExpectedJson);
		return formsAndResourcesExpectedJson;

	}

	@Override
	public void openAndValidate() {
		validate(logOut);

		JSONObject jsonObject = new JSONObject();
		for (String key : formsAndResources.getExpectedData().keySet()) {
			WebElement element = findElement(formsAndResources
					.getExpectedData().get(key));
			if(validate(element)){
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		formsAndResourcesJson = jsonObject;


		System.out.println("formsAndResourcesJson----->"+formsAndResourcesJson);

	}

	public JSONObject clickOnPlanMaterialPdfs() {
		// TODO Auto-generated method stub
				String fileName = CommonConstants.FORMS_AND_RESOURCES_PLANMATERIAL_SECTION_PDFS;
				planDocsPDF = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);		
				JSONObject jsonObject = new JSONObject();
				
				for (String key : planDocsPDF.getExpectedData().keySet()) {
					 /* planmaterial section list of dives*/
					List<WebElement> elements = findElements(planDocsPDF.getExpectedData().get(key));
					JSONArray jsonArray = new JSONArray();
					for (WebElement element : elements) {
						ElementData elementData = new ElementData("tagName","p");
						System.out.println("elementData::"+elementData);
							/* list of paragraphs*/
						List<WebElement> pdfSectionList = findChildElements(
								elementData, element);
						if(pdfSectionList != null) {
								/*iterating paragraphs*/
							for (WebElement anchorElement : pdfSectionList) {					
								if(anchorElement != null  ) {				
									ElementData anchorElementData = new ElementData("tagName","a");
										if(findChildElement(anchorElementData, anchorElement) != null){
												/*final anchorTag*/
											findChildElement(anchorElementData, anchorElement).click();
										
												try {
													JSONObject jsonObjectForArray = new JSONObject();
													jsonObjectForArray.put("pdfName",findChildElement(anchorElementData,anchorElement).getText());
													jsonArray.put(jsonObjectForArray);
													} catch (JSONException e) {
												// TODO Auto-generated catch block
													e.printStackTrace();
													}
												}
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
				planDocPDFsJson = jsonObject;
				return planDocPDFsJson;

	}

	/**
	 * Click the benefits and Coverage link.
	 */
	/*public BenefitsAndCoveragePage navigateToBenefitsAndCoverage() {
		benefitsAndCoverage.click();
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase(
				"My Benefits & Coverage")) {
			return new BenefitsAndCoveragePage(driver);
		} else {
			return null;
		}
		
	}	*/


	public boolean validateAddPlanLink(){
		boolean flag = false;
		try{
		if(formsAndResourcesTab.getText().equals("Forms and Resources")){
		if(addPlansTab.isDisplayed()){
			System.out.println(addPlansTab.getText()+" is displayed, hence scenario failed");
			//Assert.assertTrue(flag);
			flag=true;
			return flag;
		}else{
			System.out.println("addPlansTab is not displayed");
			//Assert.fail();!
			return flag;
		}
		}
		}catch(Exception e){
			Assert.fail();
		}
		return flag;
	}

	public boolean verifyPassportFlyer(){
		return validate(passport_Flyer);
	}
	public boolean verifyPassportFlyerSpanish(){
		return validate(passport_Flyer_Spanish);

	}
	
	public String validatePrescriptionmailorderBenefitPdfs() {
		// TODO Auto-generated method stub
		validate(preferredMailOrderLink);
		preferredMailOrderLink.click();
		if (currentUrl().contains("Prescription Mail Order Form - Preferred Mail Service Pharmacy through OptumRx")){
			return "true";
		}else{
			
		return "false";
		}
	}

	public void validateMyDocumentsSection() {
		String actualText = myDocuments.getText();
		if(actualText.equalsIgnoreCase("My Documents"))
		{
			System.out.println("My Documents section is present");
		}
		
	}

	public void clickOnViewotherdocLink() {
		viewMyDocsLink.click();
		if(driver.getTitle().equalsIgnoreCase("My Documents"))
		{
			System.out.println("Navigated to My Documents page");
		}
		
	}
	
	public boolean validateMedEOBFormsPage(){
		if(eobSectionBox.getText().contains("Explanation of Benefits (EOB)")&&validate(medicalEobLink))
			return true;
		return false;
	}
	/**
	 * Click the benefits and Coverage link.
	 */
	public BenefitsAndCoveragePage navigateToBenefitsAndCoverage() {
		benefitsAndCoverage.click();
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase(
				"My Benefits & Coverage")) {
			return new BenefitsAndCoveragePage(driver);
		} else {
			return null;
		}
		
	}	

}
