/**
 * 
 */
package pages.member_deprecated.ulayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import cucumber.api.DataTable;
import gherkin.formatter.model.DataTableRow;

/**
 * @author pagarwa5
 *
 */
public class PlanBenefitsCoveragePage extends UhcDriver {

	

	@FindBy(id ="disclosure_link")
	private WebElement logOut;

	

	private PageData planBenefitsCoverage;

	public JSONObject planBenefitsCoverageJson;

	
	private PageData planDocsPDF;
	
	public JSONObject planDocPDFAcqJson;
	
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[2]/div[1]/span")
	private WebElement memberId;
	
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[1]/div[1]/span")
	private WebElement memberName;
	
	@FindBy(xpath="//*[@id='planBenefitsApp']/div/div/div[2]/div[1]/div/div[4]/div[1]/span")
	private WebElement effectiveDate;
	




	public PlanBenefitsCoveragePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, planBenefitsContent, CommonConstants.TIMEOUT_30);
		String fileName = CommonConstants.BENEFITS_AND_COVERAGE_PDP_NONLIS_NONUS_PAGE_DATA;
		planBenefitsCoverage = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		//openAndValidate();
	}

	public void logOut() {
		logOut.click();

	}
	
	
	public void validateFieldsOnBenefitsAndCoveragePage(){
		
		try {
			validate(memberId);

			validate(memberName);

			validate(effectiveDate);

		} catch (Exception e) {
			System.out.println("Elements are not found ...");
		}
	}
	

	@Override
	public void openAndValidate() {


		JSONObject jsonObject = new JSONObject();
		for (String key : planBenefitsCoverage.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(planBenefitsCoverage.getExpectedData().get(key));
			if (elements.size() == 1) {
				validate(elements.get(0));
				try {
					jsonObject.put(key, elements.get(0).getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if (elements.size() > 1) {
				JSONArray jsonArray = new JSONArray();
				for (WebElement element : elements) {

					validate(element);
					try {
						JSONObject jsonObjectForArray = new JSONObject();
						jsonObjectForArray.put(planBenefitsCoverage.getExpectedData()
								.get(key).getElementName(), element.getText());
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

		}
		planBenefitsCoverageJson = jsonObject;

		System.out.println("planBenefitsCoverageJson----->"+planBenefitsCoverageJson);


	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		/*get PHR expected data*/
		JSONObject benefitsExpectedJson = expectedDataMap.get(CommonConstants.BENEFITS_AND_COVERAGE_PDP_NONLIS_NONUS_PAGE_DATA);
		JSONObject commonExpectedJson = expectedDataMap.get(CommonConstants.COMMON);
		JSONObject globalExpectedJson = expectedDataMap.get(CommonConstants.GLOBAL);
		benefitsExpectedJson = CommonUtility.mergeJson(benefitsExpectedJson, globalExpectedJson);
		benefitsExpectedJson = CommonUtility.mergeJson(benefitsExpectedJson, commonExpectedJson);

		return benefitsExpectedJson;

	}

	public void validateRightRailWidget() {
		driver.navigate().refresh();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validatePharmacySaverWidget();
		validatePreferredPharmacyWidget();
		validateWalgreensWidget();
	}
	
	public void validatePharmacySaverWidget(){
		boolean present;
		try {
			driver.findElement(By.id("Atdd_Pharmacy_Saver_Widget"));
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}

		if(present)
			System.out.println("@@@@@@@@@ Able to find Pharmacy Saver widget @@@@@@@@@");
		else
			System.out.println("@@@@@@@@@ No Pharmacy Saver widget @@@@@@@@@");
	}
	
	public void validatePreferredPharmacyWidget(){
		boolean present;
		try {
			driver.findElement(By.id("ATDD_preferredretail_widget"));
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}

		if(present)
			System.out.println("@@@@@@@@@ Able to find Preferred Pharmacy widget @@@@@@@@@");
		else
			System.out.println("@@@@@@@@@ No Preferred Pharmacy widget @@@@@@@@@");
	}
	
	public void validateWalgreensWidget(){
		boolean present;
		try {
			driver.findElement(By.id("ATDD_walgreens_widget"));
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}

		if(present)
			System.out.println("@@@@@@@@@ Able to find Walgreens widget @@@@@@@@@");
		else
			System.out.println("@@@@@@@@@ No Walgreens widget @@@@@@@@@");
	}

	public void validatePrefferedRetailDrugCostTable() {
		/*driver.navigate().refresh();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		boolean preferredRetailPresent;
		try{
			driver.findElement(By.id("preferredRetailBenefit"));
			preferredRetailPresent = true;			
		}catch(NoSuchElementException e){
			preferredRetailPresent = false;
		}
		if(preferredRetailPresent)
			System.out.println("@@@@@@@@@ Able to find Preffered Retail Drug Cost Table @@@@@@@@@");
		else
			System.out.println("@@@@@@@@@ No Preffered Drug Cost Table @@@@@@@@@");

	}

	public void validateStandardDrugCostTable() {
		boolean standardPresent;
		try {
			driver.findElement(By.id("standardNetwork"));
			standardPresent = true;
		} catch (NoSuchElementException e) {
			standardPresent = false;
		}
		if(standardPresent)
			System.out.println("@@@@@@@@@ Able to find Standard Drug Cost Table @@@@@@@@@");
		else
			System.out.println("@@@@@@@@@ No Standard Drug Cost Table @@@@@@@@@");


	}

	public JSONObject getActualPdfLinksData() {
		String fileName = CommonConstants.B_AND_C_PDF_MEMBER_PAGE_DATA;
		planDocsPDF = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);		
		JSONObject jsonObject = new JSONObject();
		for (String key : planDocsPDF.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(planDocsPDF.getExpectedData()
					.get(key));
			JSONArray jsonArray = new JSONArray();
			for (WebElement element : elements) {
				ElementData elementData = new ElementData("tagName", "a");
				findChildElement(elementData, element).click();
					try {
						JSONObject jsonObjectForArray = new JSONObject();
						jsonObjectForArray.put("pdfName", element.getText());
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
	public void validateSequenceOfPlanBenefitsAndCoverageSummaryRightRow(DataTable sequenceAttribute){
		List<DataTableRow> sequenceAttributeRow = sequenceAttribute.getGherkinRows();
		Map<String, String> sequenceAttributeMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < sequenceAttributeRow.size(); i++) {

			sequenceAttributeMap.put(sequenceAttributeRow.get(i).getCells().get(0), sequenceAttributeRow.get(i).getCells().get(1));
		}

		Set<String> memberAttributesKeySet = sequenceAttributeMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(sequenceAttributeMap.get(key));
			}
    	}
		System.out.println("desiredAttributes.." + desiredAttributes);
		
		List<WebElement> rightRow = driver.findElements(By.xpath("//div[@ng-repeat='x in planBenefitMap[key]']"));
		for(int i=0; i<=12;i++){
			int j=i+1;
			if(rightRow.get(i).getText().contains(desiredAttributes.get(i))){
				 System.out.println("Sequence Number "+j+" is "+rightRow.get(i).getText());
				 Assert.assertTrue("@@@@@@   "+desiredAttributes.get(i)+"   Displayed correctly", true);
			}else{
                Assert.fail(rightRow.get(i).getText()+"---not equals--"+desiredAttributes.get(i));
			}
		}
	 
		
	}
	public void validateSequenceOfPlanBenefitsAndCoverageSummaryLeftRow(DataTable sequenceAttribute){
		List<DataTableRow> sequenceAttributeRow = sequenceAttribute.getGherkinRows();
		Map<String, String> sequenceAttributeMap = new LinkedHashMap<String, String>();
		for (int i = 0; i < sequenceAttributeRow.size(); i++) {

			sequenceAttributeMap.put(sequenceAttributeRow.get(i).getCells().get(0), sequenceAttributeRow.get(i).getCells().get(1));
		}

		Set<String> memberAttributesKeySet = sequenceAttributeMap.keySet();
		List<String> desiredAttributes = new ArrayList<String>();
		for (Iterator<String> iterator = memberAttributesKeySet.iterator(); iterator.hasNext();) {
			{
				String key = iterator.next();
				desiredAttributes.add(sequenceAttributeMap.get(key));
			}

		}
		System.out.println("desiredAttributes.." + desiredAttributes);

		List<WebElement> leftRow = driver.findElements(By.xpath("//*[@class='ship_row_left']"));
 	
		for(int i=0;i<7;i++){
			 if(leftRow.get(i).getText().contains(desiredAttributes.get(i))){
				 int j=i+1;
				 System.out.println("Sequence Number "+j+" is "+leftRow.get(i).getText());
				 Assert.assertTrue("@@@@@@   "+desiredAttributes.get(i)+"   Displayed correctly", true);
			 }else{
				 Assert.fail(desiredAttributes.get(i)+"----not equals---"+leftRow.get(i).getText());
			 }
		}
		
		
		
	}
	
	public boolean Validate_Single_Tab_SHIP(){
		List<WebElement> PlanTabs = driver.findElements(By.xpath("//a[contains(text(),'Supplemental  Insurance Plans')]"));
		System.out.println("No of tabs: "+PlanTabs.size());
		if(PlanTabs.size()>1){
			return false;
		}
		else{
			return true;
		}
	}

	
	/*public PharmacySearchPage navigateToPharmacyLocator() {

		pharmacyLocator.click();
		CommonUtility.waitForPageLoad(driver, pharmacyLocatorHeading, CommonConstants.TIMEOUT_30);
		if (getTitle().equalsIgnoreCase(
				"UnitedHealthcare Medicare Solutions | Pharmacy Directory")) {
			return new PharmacySearchPage(driver);
		}
		return null;
	}*/

}
