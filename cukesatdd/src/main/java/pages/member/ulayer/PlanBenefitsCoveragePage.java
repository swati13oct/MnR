/**
 * 
 */
package pages.member.ulayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
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
public class PlanBenefitsCoveragePage extends UhcDriver {

	@FindBy(id = "planBenefitsApp")
	private WebElement planBenefitsContent;

	@FindBy(id ="disclosure_link")
	private WebElement logOut;

	@FindBy(id = "standardNetwork")
	private WebElement standardNetwork;

	private PageData planBenefitsCoverage;

	public JSONObject planBenefitsCoverageJson;

	
	private PageData planDocsPDF;
	
	public JSONObject planDocPDFAcqJson;
	




	public PlanBenefitsCoveragePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		CommonUtility.waitForPageLoad(driver, planBenefitsContent, CommonConstants.TIMEOUT_30);
		String fileName = CommonConstants.BENEFITS_AND_COVERAGE_PDP_NONLIS_NONUS_PAGE_DATA;
		planBenefitsCoverage = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public void logOut() {
		logOut.click();

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

	public void validatePharmacySaverWidget() {
		driver.navigate().refresh();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

}
