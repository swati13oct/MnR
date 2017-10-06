/**
 * 
 */
package pages.member.bluelayer;

import java.util.ArrayList;
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
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author njain112
 *
 */
public class BenefitsAndCoveragePage extends UhcDriver {

	
	public PageData benefitsCoverage;

	public JSONObject benefitsandcoverageJson;

	
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[2]/div[1]/span")
	private WebElement memberId;
	
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[1]/div[1]/span")
	private WebElement memberName;
	
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[4]/div[1]/span")
	private WebElement effectiveDate;
	
	@FindBy(xpath="//*[@id='_content_uhcm_home_my-plans_benefits-and-coverage-page_jcr_content_overview_needhelp_tfnParplansource_teaser']/div/section/div/div[1]/div/h2")
	private WebElement NeedHelpHeader;
	
	@FindBy(xpath="//*[@id='_content_uhcm_home_my-plans_benefits-and-coverage-page_jcr_content_overview_needhelp_tfnParplansource_teaser']/div/section/div/div[3]/div/p")
	private WebElement Contactussection;
	
	@FindBy(xpath = "//span[contains(.,'keyboard_arrow_down')]")
	private WebElement disclaimersLink;

        @FindBy(xpath = ".//*[@id='plan_benefit_documents']/section/div/div[1]/div")
	private WebElement planBenefitsDocuments;
	
        @FindBy(xpath = ".//*[@id='lang-select-2']")
	private WebElement langdropdown;
    
        @FindBy(xpath = ".//*[@id='ancillary_benefits']/div[2]/div[1]/div")
	private WebElement Hearingsection;
    
        @FindBy(xpath = ".//*[@id='ancillary_benefits']/div[2]/div[2]/div")
	private WebElement Hearingaid;
    
        @FindBy(xpath = ".//*[@id='ancillary_benefits']/div[3]/div[1]/div")
	private WebElement Visionsection;
    
        @FindBy(xpath = ".//*[@id='ancillary_benefits']/div[3]/div[2]/div")
	private WebElement Dentalsection;
    
    @FindBy(xpath = ".//*[@id='ancillary_benefits']/div[1]/div")
	private WebElement Headersection; 
    
    @FindBy(xpath = ".//*[@id='drug-copays-and-discounts']/section/div[2]/div[5]/div/span/div/div/div/div/h3/span")
    private WebElement DrugCoveragetext;

    @FindBy(xpath = ".//*[@id='drug-copays-and-discounts']/section/div[2]/div[5]/div/span/div/div/div/div/p")
    private WebElement DrugCoverageHeader;
    
    @FindBy(xpath = ".//*[@id='drug-copays-and-discounts']/section/div[2]/div[6]/div[1]/div/div/div/div/p")
    private WebElement LookupDrugstext;
    
    @FindBy(xpath=".//*[@id='drug-copays-and-discounts']/section/div[2]/div[6]/div[1]/a")
    private WebElement LookUpDrugsButton;
    
    @FindBy(xpath = ".//*[@id='drug-copays-and-discounts']/section/div[1]/div/div/div/div/div/div/h2")
    private WebElement DrugCopayHeader;
    
    @FindBy(xpath = ".//*[@id='drug-copays-and-discounts']/section/div[1]/div/div/div/div/div/div/p")
    private WebElement DrugCopayText;
    
    @FindBy(id = "drug-costs")
    private WebElement DrugCostDropdown;
    
    @FindBy(xpath = ".//*[@id='drug-copays-and-discounts']/section/div[2]/div[1]/div")
    private WebElement DrugCostheaderandtext;
    
    @FindBy(xpath = ".//*[@id='drug-copays-and-discounts']/section/div[2]/div[2]/div/div/div[2]/p[2]")
    private WebElement Pharmacycontent;
    
    @FindBy(xpath=".//*[@id='waystosave']/div/div/div[1]/div/h1")
    private WebElement TextWaystoSave;
   
    @FindBy(xpath = ".//*[@id='drug-copays-and-discounts']/section/div[2]/div[3]/div/div/div/div/div[1]/div/a")
    private WebElement Learnmoretierslink;
    
    @FindBy(xpath = ".//*[@id='drug-copays-and-discounts']/section/div[2]/div[3]/div/div/div/div/div[2]/div/a")
    private WebElement Learnmorestagelink;
 
    @FindBy(xpath = ".//*[@id='drug-copays-and-discounts']/section/div[2]/div[6]/div[2]/div/div/div/div/p")
    private WebElement locateapharmacysection;
    
    @FindBy(xpath = ".//*[@id='drug-copays-and-discounts']/section/div[2]/div[6]/div[2]/a")
    private WebElement locateapharmacybutton;
    
    @FindBy(id="mapdPageNonLis")
    private WebElement drugcopaytable;
    
    @FindBy(id="mapdPageLis")
    private  WebElement RetailDrugCost_Table;

    @FindBy(id="waystosave")
    private  WebElement waysToSave;
    
    
    @FindBy(xpath = ".//*[@id='plan_benefit_documents']/section/div/div[2]/div/form/span[1]")
    private WebElement view_label;
    
    @FindBy(xpath = ".//*[@id='plan_benefit_documents']/section/div/div[2]/div/form/span[2]")
    private WebElement documents_label;
    
    
    @FindBy(xpath="//*[@id='planBenefitsApp']/section/div/div[1]/div/div/div/div/h1")
	private WebElement planName;
	
    @FindBy(xpath = "//*[@id='planBenefitsApp']/section/div/div[2]/div[1]/div/div[1]/div[1]/span")
    private WebElement nameLabel;

    @FindBy(xpath = "//*[@id='planBenefitsApp']/section/div/div[2]/div[1]/div/div[2]/div[1]/span")
    private WebElement memberID;

    @FindBy(xpath = "//*[@id='planBenefitsApp']/section/div/div[2]/div[1]/div/div[3]/div[1]/span")
    private WebElement effective_Date;
    
    
    @FindBy(xpath = "//*[@id='planBenefitsApp']/section/div/div[2]/div[4]/span[2]")
    private WebElement Monthly_Premium;
    
    
	@FindBy(xpath = "//*[@id='planBenefitsApp']/section/div/div[2]/div[2]/div[1]/div/div[1]/div/span")
	private WebElement ExtraHelp;

	@FindBy(className = "atdd-benefitssummary-headertitle")
	private WebElement BenefitsSummaryHeader;

	@FindBy(className = "atdd-benefitssummary-subheadertitle")
	private WebElement Copayscoinsuranceheader;

	@FindBy(className = "atdd-hospitalvisits-title")
	private WebElement HospitalVisits;

	@FindBy(className = "atdd-emergencycare-title")
	private WebElement EmergencyHeader;

	@FindBy(className = "atdd-ambulance-title")
	private WebElement AmbulanceHeader;

	@FindBy(className = "atdd-officevisits-title")
	private WebElement OfficeVisits;

	@FindBy(className = "atdd-outpatientsurgery-title")
	private WebElement OutpatientSurgeryCenter;
    
    
 

    public static final String learnmorestagetext_xpath =".//*[@id='collapseStages']";

    public static final String learnmorelinktiertext_xpath = ".//*[@id='collapseTiers']";
    
	public static final String disclaimertextarea_xpath ="//*[@id='collapseDisclaimer']";
	


        public BenefitsAndCoveragePage(WebDriver driver) {
        	super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.BENEFITS_AND_COVERAGE_PAGE_DATA;
		benefitsCoverage = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		openAndValidate();
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		/*get PHR expected data*/
		JSONObject benefitsExpectedJson = expectedDataMap.get(CommonConstants.BENEFITS_AND_COVERAGE);
		JSONObject commonExpectedJson = expectedDataMap.get(CommonConstants.COMMON);
		//JSONObject globalExpectedJson = expectedDataMap.get(CommonConstants.GLOBAL);
		benefitsExpectedJson = CommonUtility.mergeJson(benefitsExpectedJson, commonExpectedJson);
		//benefitsExpectedJson = CommonUtility.mergeJson(benefitsExpectedJson, commonExpectedJson);

		return benefitsExpectedJson;

	}
	
	public void validateFieldsOnBenefitsAndCoveragePage(){
		
		try {
			validate(planName);
			
			validate(memberId);

			validate(memberName);

			validate(effectiveDate);

		} catch (Exception e) {
			System.out.println("Elements are not found ...");
		}
	}

	
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : benefitsCoverage.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(benefitsCoverage.getExpectedData().get(key));
			/*if (elements.size() == 1) {
				validate(elements.get(0));
				try {
					jsonObject.put(key, elements.get(0).getText());
					//System.out.println("Text"+elements.get(0).getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (elements.size() > 1) {*/
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					validate(element);
					try {
						JSONObject jsonObjectForArray = new JSONObject();
						jsonObjectForArray.put(benefitsCoverage.getExpectedData().get(key).getElementName(),
								element.getText());
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

		
		benefitsandcoverageJson = jsonObject;

		System.out.println("BenefitsCoverageJson----->" + benefitsandcoverageJson);
		
	}
	
	
public void validateNeedhelpheader(){
		
		try {
			validate(NeedHelpHeader);
			validate(disclaimersLink);
		    System.out.println("text"+ disclaimersLink.getText());
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

	public void PlanDocumentssection() {

		try {
			validate(planBenefitsDocuments);
		} catch (Exception e) {
			System.out.println("Elements is not found ...");
		}
	}

public boolean validatecontactussection()
{
	try{
	if(Contactussection.getText().contains("See more ways to contact us")){
	System.out.println("contactus section is coming ");
	}
	else
	{
	System.out.println("Contactussection.getText() >>>>>>   "+Contactussection.getText());
	}
	}
	catch(Exception e){
	return false;
	}
	return true;
	}

public void clickOnDisclaimers(JSONObject benefitsandcoverageExectedJson) {
	// TODO Auto-generated method stub
	
	disclaimersLink.click();
	//Thread.sleep(15000);
	String finalPath;
	String table_data;
    
	//validate(disclaimertextarea_xpath);
	try {
	finalPath = disclaimertextarea_xpath+"/p[1]";  
	table_data = driver.findElement(By.xpath(finalPath)).getText();
	System.out.println(table_data);
	Assert.assertEquals(benefitsandcoverageExectedJson
			.get("1stline"), table_data);
	// to validate amount Billed
	finalPath = disclaimertextarea_xpath+"/p[2]";
	table_data = driver.findElement(By.xpath(finalPath)).getText();
	System.out.println(table_data);
	Assert.assertEquals(benefitsandcoverageExectedJson
			.get("2ndline"), table_data);
	// to validate amount Paid
	finalPath = disclaimertextarea_xpath+"/p[3]";
	table_data = driver.findElement(By.xpath(finalPath)).getText();
	System.out.println(table_data);
	Assert.assertEquals(benefitsandcoverageExectedJson
			.get("3rdline"), table_data);
	// to validate paid Date
	finalPath = disclaimertextarea_xpath+"/p[4]";
	table_data = driver.findElement(By.xpath(finalPath)).getText();
	System.out.println(table_data);
	Assert.assertEquals(benefitsandcoverageExectedJson
			.get("4thline"), table_data);
	}
catch (JSONException e) {
	e.printStackTrace();
}
}

public boolean getview_label() 
{
 return validate(view_label);
 }

public boolean getdocuments_label() 
{
 return validate(documents_label);
}

public void languagevalidation()
{
	if (langdropdown.isDisplayed())
	{
	    List<String> listActual = new ArrayList<String>();
		Select dropdown = new Select(langdropdown);
		List<WebElement> webElements = dropdown.getOptions();
		for(WebElement element : webElements)
		 {
	     
	     if (element.getText().equals("SPANISH") || element.getText().equals("CHINESE")) 
	     {
	        Assert.fail("The element" + element.getText() + "should not display");
            System.out.println("The element " + element.getText() + "should not display");
         }
	     else
	     {
	    	 Assert.assertTrue(true);
	     }
	     }
	     }
	     
 }
		
public void validate_langdropdown_first_selection()
{
//WebElement langdropdown;
if (langdropdown.isDisplayed())
{
    Select langdropdwn = new Select(langdropdown);
if (langdropdwn.getFirstSelectedOption().getText().equals("ENGLISH"))
{
Assert.assertTrue(true);
}
else
Assert.fail("Issue in English selection");
}
else
Assert.fail("Plan year dropdown not displayed");

   
} 

public void validate_langdropdown_select(String language)
{
Select langdropdwn = new Select(langdropdown);
langdropdwn.selectByVisibleText(language);
}

public void HearingSection() {

	try {
		validate(Hearingsection);
	} catch (Exception e) {
		System.out.println("Elements is not found ...");
	}
}
public void HearingAid() {

	try {
		validate(Hearingaid);
	} catch (Exception e) {
		System.out.println("Elements is not found ...");
	}
}
public void Vision() {

	try {
		validate(Visionsection);
	} catch (Exception e) {
		System.out.println("Elements is not found ...");
	}
}
public void Dental() {

	try {
		validate(Dentalsection);
	} catch (Exception e) {
		System.out.println("Elements is not found ...");
	}
}
public void Header() {

	try {
		validate(Headersection);
	} catch (Exception e) {
		System.out.println("Elements is not found ...");
	}
}

public void validatedrugcoverageheaderandtext()
{
	validate(DrugCoverageHeader);
	validate(DrugCoveragetext);
}

public void validatelookupdrugsbutton()
{
if (LookUpDrugsButton.isDisplayed())
{
	Assert.assertTrue(true);
}
else
Assert.fail("Button not displayed");
}


public void validate_lookupdrugstext()
{
	validate(LookupDrugstext);
	
}

public void validate_drugcopayheaderntext()
{
	validate(DrugCopayHeader);
	validate(DrugCopayText);

}

public void validate_drugcostheaderntext()
{
	validate(DrugCostheaderandtext);
	
}

public void validate_locateapharmacysection()
{
	validate(locateapharmacysection);
	validate(locateapharmacybutton);
	
}

public void validate_tierlinknotdisplay()
{
	if(Learnmoretierslink.isDisplayed())
	{
        Assert.fail("The element" + Learnmoretierslink.getText() + "should not display");
        System.out.println("The element " + Learnmoretierslink.getText() + "should not display");
     }
     else
     {
    	 Assert.assertTrue(true);
     }
	
}

public void validate_dropdownnotdisplay()
{
	if(DrugCostDropdown.isDisplayed())
	{
        Assert.fail("The element" + DrugCostDropdown.getText() + "should not display");
        System.out.println("The element " + DrugCostDropdown.getText() + "should not display");
     }
     else
     {
    	 Assert.assertTrue(true);
     }
	
}

public void validate_drugcostdropdownoptions(JSONObject benefitsandcoverageExectedJson)

{
	try {
	validate(DrugCostDropdown);
	validate(Pharmacycontent);
	Assert.assertEquals("true or not", benefitsandcoverageExectedJson.get("drugcostdropdown"), benefitsandcoverageJson.get("drugcostdropdown"));
	}
catch (JSONException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}
	

public void validate_learnmoreaboutlink()
{
	validate(Learnmoretierslink);
	validate(Learnmorestagelink);
	
}

public void validate_learnmoreaboutstagelink()
{
	
	validate(Learnmorestagelink);
	
}



public void clickOnLearnmoreaboutlinktier(JSONObject benefitsandcoverageExectedJson) {
	// TODO Auto-generated method stub
	try {
		Thread.sleep(30000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Learnmoretierslink.click();
	try {
		Thread.sleep(30000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	//Thread.sleep(15000);
	String finalPath;
	String table_data;
    
	//validate(disclaimertextarea_xpath);
	try {
	finalPath = learnmorelinktiertext_xpath+"/p[1]";  
	table_data = driver.findElement(By.xpath(finalPath)).getText();
	System.out.println(table_data);
	Assert.assertEquals(benefitsandcoverageExectedJson
			.get("1stLinetier"), table_data);
	// to validate amount Billed
	finalPath = learnmorelinktiertext_xpath+"/p[2]";
	table_data = driver.findElement(By.xpath(finalPath)).getText();
	System.out.println(table_data);
	Assert.assertEquals(benefitsandcoverageExectedJson
			.get("2ndLinetier"), table_data);
	// to validate amount Paid
	finalPath = learnmorelinktiertext_xpath+"/p[3]";
	table_data = driver.findElement(By.xpath(finalPath)).getText();
	System.out.println(table_data);
	Assert.assertEquals(benefitsandcoverageExectedJson
			.get("3rdLinetier"), table_data);
	// to validate paid Date
	finalPath = learnmorelinktiertext_xpath+"/p[5]";
	table_data = driver.findElement(By.xpath(finalPath)).getText();
	System.out.println(table_data);
	Assert.assertEquals(benefitsandcoverageExectedJson
			.get("4thLinetier"), table_data);
	finalPath = learnmorelinktiertext_xpath+"/p[7]";
	table_data = driver.findElement(By.xpath(finalPath)).getText();
	System.out.println(table_data);
	Assert.assertEquals(benefitsandcoverageExectedJson
			.get("5thLinetier"), table_data);
	finalPath = learnmorelinktiertext_xpath+"/p[9]";
	table_data = driver.findElement(By.xpath(finalPath)).getText();
	System.out.println(table_data);
	Assert.assertEquals(benefitsandcoverageExectedJson
			.get("6thLinetier"), table_data);
	Learnmoretierslink.click();
	}
catch (JSONException e) {
	e.printStackTrace();
}
}

public void clickOnLearnmoreaboutlinkstage(JSONObject benefitsandcoverageExectedJson) {
	// TODO Auto-generated method stub
	
	Learnmorestagelink.click();
	try {
		Thread.sleep(30000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	//Thread.sleep(15000);
	String finalPath;
	String table_data;
    

	try {
	finalPath = learnmorestagetext_xpath+"/p[1]";  
	table_data = driver.findElement(By.xpath(finalPath)).getText();
	System.out.println(table_data);
	Assert.assertEquals(benefitsandcoverageExectedJson
			.get("1stLinestage"), table_data);
	// to validate amount Billed
	finalPath = learnmorestagetext_xpath+"/p[3]";
	table_data = driver.findElement(By.xpath(finalPath)).getText();
	System.out.println(table_data);
	Assert.assertEquals(benefitsandcoverageExectedJson
			.get("2thLinestage"), table_data);
	// to validate amount Paid
	finalPath = learnmorestagetext_xpath+"/p[5]";
	table_data = driver.findElement(By.xpath(finalPath)).getText();
	System.out.println(table_data);
	Assert.assertEquals(benefitsandcoverageExectedJson
			.get("3rdLinestage"), table_data);
	// to validate paid Date
	finalPath = learnmorestagetext_xpath+"/p[7]";
	table_data = driver.findElement(By.xpath(finalPath)).getText();
	System.out.println(table_data);
	Assert.assertEquals(benefitsandcoverageExectedJson
			.get("4thLinestage"), table_data);
	

	Learnmorestagelink.click();
	}
catch (JSONException e) {
	e.printStackTrace();
}
}


public void validatedrugcopaytable()
{
	//Select langdropdwn = new Select(langdropdown);
	
		validate(drugcopaytable);
		
}

public void validatedrugcosttable() {
	// TODO Auto-generated method stub
	validate(RetailDrugCost_Table);

	
}



public void validateWaystoSave() 
{
	validate(waysToSave);
	validate(TextWaystoSave);
	
	System.out.println(TextWaystoSave.getText());
	//Assert.assertEquals(, );

	
	
}

public void validatePlanOverview() {
	// TODO Auto-generated method stub

	validateNew(planName);
	validateNew(nameLabel);
	validateNew(memberID);
	validateNew(effective_Date);
	validateNew(Monthly_Premium);

}

public void validatePlanOverviewLis() {
	validateNew(planName);
	validateNew(nameLabel);
	validateNew(memberID);
	validateNew(effective_Date);
	validateNew(Monthly_Premium);
	validateNew(ExtraHelp);

}

public void validateHeaders() {
	validateNew(BenefitsSummaryHeader);
	validateNew(Copayscoinsuranceheader);
	validateNew(HospitalVisits);
	validateNew(OfficeVisits);
	validateNew(OutpatientSurgeryCenter);


}

public void validateHeadersGroup() {
	validateNew(BenefitsSummaryHeader);
	validateNew(Copayscoinsuranceheader);
	validateNew(EmergencyHeader);
	validateNew(AmbulanceHeader);
	validateNew(HospitalVisits);
	validateNew(OfficeVisits);
	validateNew(OutpatientSurgeryCenter);

}

}





	

