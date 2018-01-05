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
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.ElementData;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class BenefitsCoveragePage extends UhcDriver {

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	@FindBy(xpath="//*[text()='search providers']")
	private WebElement searchProviderButton;

	@FindBy(xpath = "//a[contains(.,'My prescription drug cost and benefits summary')]")
	private WebElement MyDrugCostAndBenefitSummaryLink;

	@FindBy(xpath="//*[@id='main_content']/div[2]/div/div[2]/div[2]/div")
	private WebElement prescriptiondrugcost;

	@FindBy(xpath="//*[@id='main_content']/div[2]/div/div[2]/div[2]/div/h2")
	private WebElement prescriptiondrugcostandsummary;
	
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[2]/div[1]/span")
	private WebElement memberId;
	
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[1]/div[1]/span")
	private WebElement memberName;
	
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[4]/div[1]/span")
	private WebElement effectiveDate;
	
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[2]/div[4]/div/section/span/div")
	private WebElement emerCoPayText;

	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[2]/div[4]/div/section/div[1]/div/h1")
	private WebElement emerCoPayAmtPct;


	@FindBy(id="addAnotherPlanLink")
	private WebElement addPlansTab;

	
	@FindBy(xpath="//a[contains(text(),'Passport Flyer') and contains(text(),'PDF')]")
	private WebElement passportFlyerPdf;


	private PageData benefitsAndCoverage;

	public JSONObject benefitsAndCoverageJson;
	private PageData planDocsPDF;
	
	public JSONObject planDocPDFAcqJson;

	public BenefitsCoveragePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//String fileName = CommonConstants.BENEFITS_AND_COVERAGE_PDP_NONLIS_NONUS_PAGE_DATA;
		String fileName = CommonConstants.BENEFITS_AND_COVERAGE_MAPD_LIS_NONUS_PAGE_DATA;
		//benefitsAndCoverage = CommonUtility.readPageData(fileName,
				//CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		//openAndValidate();
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		/* get BENEFITS AND COVERAGE expected data */
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject commonExpectedJson = expectedDataMap
				.get(CommonConstants.COMMON);
		JSONObject benefitsAndCoverageExpectedJson = expectedDataMap
				.get(CommonConstants.PLAN_BENEFITS_AND_COVERAGE);
		benefitsAndCoverageExpectedJson = CommonUtility.mergeJson(
				benefitsAndCoverageExpectedJson, globalExpectedJson);
		benefitsAndCoverageExpectedJson = CommonUtility.mergeJson(
				benefitsAndCoverageExpectedJson, commonExpectedJson);

		return benefitsAndCoverageExpectedJson;

	}

	@Override
	public void openAndValidate() {
		validate(logOut);

		JSONObject jsonObject = new JSONObject();
		for (String key : benefitsAndCoverage.getExpectedData().keySet()) {
			WebElement element = findElement(benefitsAndCoverage
					.getExpectedData().get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				e.printStackTrace();
			}

		}
		benefitsAndCoverageJson = jsonObject;
		
		System.out.println("benefitsAndCoverageJson----->"+benefitsAndCoverageJson);

	}

	public void logOut() {
		logOut.click();

	}
	public Rallytool_Page clickAndValidateProviderSearch(){
		  // waitforElement(searchProviderButton);
		   searchProviderButton.click();
		   switchToNewTab();
		   if(currentUrl().contains("systest3.myuhc")){
			   System.out.println("SSO Launched");
			   System.out.println("--------------Page Title="+getTitle());
			   return new Rallytool_Page(driver);
		   }else{
			   System.out.println("-------------Failed as rally did launch in new tab-------------");
			   Assert.fail();
			   return null;
		   }
	   }
	
	public JSONObject getActualPdfLinksData() {
		String fileName = CommonConstants.B_AND_C_PDF_MEMBER_PAGE_DATA;
		planDocsPDF = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);		
		JSONObject jsonObject = new JSONObject();
		for (String key : planDocsPDF.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(planDocsPDF.getExpectedData()
					.get(key));
			JSONArray jsonArray = new JSONArray();
			for (WebElement element : elements) {
				ElementData elementData = new ElementData("tagName","a");
				findChildElement(elementData,element).click();
				try {
					JSONObject jsonObjectForArray = new JSONObject();
					jsonObjectForArray.put("pdfName",element.getText());
					jsonArray.put(jsonObjectForArray);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			try {
				jsonObject.put(key, jsonArray);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		planDocPDFAcqJson = jsonObject;
		return planDocPDFAcqJson;
	}



	public void validatesPharmacySaver() {
		driver.navigate().refresh();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean present;
		try {
			driver.findElement(By.id("ATDD_Saver_Widget2016"));
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}

		if(present)
			System.out.println("@@@@@@@@@ Able to find Pharmacy Saver widget @@@@@@@@@");
		else
			System.out.println("@@@@@@@@@ No Pharmacy Saver widget @@@@@@@@@");
		
	}

	public void validatesDrugCostTable() {
		driver.navigate().refresh();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean present;
		try {
			driver.findElement(By.id("preferred_retail_drugCosts"));
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}

		if(present)
			System.out.println("@@@@@@@@@ Able to find Preferred Retail Drug Cost Table @@@@@@@@@");
		else
			System.out.println("@@@@@@@@@ No Preferred Retail Drug Cost Table @@@@@@@@@");
	}

	public void validateRidersWidgetandPDFLinks() {
		try {
			Thread.sleep(70000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean present;
		try {
			//optionalRiders.isDisplayed();
			driver.findElement(By.xpath("//*[@id='accountdetails']/div/div[3]/div/div[2]/div"));
			driver.findElement(By.xpath("//*[@id='optionalservice_box']/div[2]/div[2]/div/p[4]/a"));
			driver.findElement(By.xpath("//*[@id='optionalservice_box']/div[2]/div[2]/div/p[5]/a"));
			//PDFLinks1.isDisplayed();
			//PDFLinks2.isDisplayed();
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}

		if(present)
			System.out.println("@@@@@@@@@ Able to find Optional Riders widget and PDF links @@@@@@@@@");
		else
			System.out.println("@@@@@@@@@ No Optional Riders widget and PDF links @@@@@@@@@");
		//MyDrugCostAndBenefitSummaryLink.isDisplayed();
	}

	public void clickOnMyDrugCostAndBenefitSummaryLink() {


		MyDrugCostAndBenefitSummaryLink.isDisplayed();
		MyDrugCostAndBenefitSummaryLink.click();
		boolean present;
		try {
			prescriptiondrugcost.isDisplayed();
			prescriptiondrugcostandsummary.isDisplayed();
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}

		if(present)
			System.out.println("@@@@@@@@@ Able to find My 2017 Prescription Drug Cost and Benefit Summary @@@@@@@@@");
		else
			System.out.println("@@@@@@@@@ No Optional Riders widget and deductible 3,4,5 @@@@@@@@@");


	}

	/**
	 * Validate memberid, membername and effective date.
	 */
	public void validateFieldsOnBenefitsAndCoveragePage() {
		try {
			validate(memberId);

			validate(memberName);

			validate(effectiveDate);
			
			validate(emerCoPayAmtPct);
			
			validate(emerCoPayText);

		} catch (Exception e) {
			System.out.println("Elements are not found ...");
		}
		
	}

	public boolean validateAddPlanLink(){
        boolean flag = false;
        try{
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
        
        }catch(Exception e){
            System.out.println("element not displayed and exception handled");
        }
        return flag;
 }

	public void verifyPassportFlyerPdf(){
		try {
		validate(passportFlyerPdf);

		} catch (Exception e) {
			System.out.println("PASSPORT PDF NOT FOUND ...");
		}
	}



}
