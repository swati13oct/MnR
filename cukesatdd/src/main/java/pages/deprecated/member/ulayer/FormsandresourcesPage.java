/**
 * 
 */
package pages.deprecated.member.ulayer;

import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.ElementData;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class FormsandresourcesPage extends UhcDriver {

	@FindBy(linkText = "Search Medical EOB History")
	private WebElement medicalEobLink;

	@FindBy(linkText = "Search Prescription Drug EOB History")
	private WebElement prescriptionDrugEobMapdLink;

	@FindBy(linkText = "Search EOB History")
	private WebElement prescriptionDrugEobLink;

	@FindBy(linkText = "View EOB Statements")
	private WebElement suppInsurancelEobLink;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;
	
	@FindBy(xpath="//*[@id='benefits']/a")
	private WebElement benefitsAndCoverageLink;

	private PageData planDocsPDF;
	private PageData formsAndResources;

	public JSONObject formsAndResourcesJson;

	private JSONObject planDocPDFsJson;
	

	public FormsandresourcesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.FORMS_AND_RESOURCES_PAGE_DATA;
		formsAndResources = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}

	public void logOut() {
		logOut.click();

	}

	public MedicalEobPage navigateToMedicalEob() {
		medicalEobLink.click();
		CommonUtility.checkPageIsReadyNew(driver);

		if (currentUrl().contains("medical-eob-search.html")) {
			return new MedicalEobPage(driver);
		}
		return null;
	}

	public PrescriptionDrugEobPage navigateToPresDrugEob(String planType) {

		if (planType.equalsIgnoreCase("MAPD")) {
			prescriptionDrugEobMapdLink.click();
		} else {
			prescriptionDrugEobLink.click();
		}

		CommonUtility.checkPageIsReadyNew(driver);

		if (currentUrl().contains("part-d-eob-search.html")) {
			return new PrescriptionDrugEobPage(driver);
		}
		return null;
	}

	public SupplementalInsuranceEobPage navigateToSuppInsuranceEob() {
		suppInsurancelEobLink.click();
		CommonUtility.checkPageIsReadyNew(driver);

		if (currentUrl().contains("supplemental-insurance-eob.html")) {
			return new SupplementalInsuranceEobPage(driver);
		}
		return null;
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

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
		validateNew(logOut);

		JSONObject jsonObject = new JSONObject();
		for (String key : formsAndResources.getExpectedData().keySet()) {
			WebElement element = findElement(formsAndResources
					.getExpectedData().get(key));
			if (null != element && !element.getText().equalsIgnoreCase("")) {
				validateNew(element);
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
	
	public JSONObject getActualPdfLinksData() {
		// TODO Auto-generated method stub
		String fileName = CommonConstants.AARPM_FR_PDF_PAGE_DATA;
		String directory= CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER;
		planDocsPDF = CommonUtility.readPageData(fileName, directory);
		System.out.println(planDocsPDF);
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

		formsAndResourcesJson = jsonObject;
		return formsAndResourcesJson;

	}

	public JSONObject clickOnPDF() {
		String fileName = CommonConstants.FORMS_AND_RESOURCES_PLANMATERIAL_SECTION_PDFS_AARP;
		planDocsPDF = CommonUtility.readPageData(fileName, CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		JSONObject jsonObject = new JSONObject();
		for (String key : planDocsPDF.getExpectedData().keySet()) {
			List<WebElement> elements = findElements(planDocsPDF.getExpectedData().get(key));// list of divs
			JSONArray jsonArray = new JSONArray();
			for (WebElement element : elements) {
				ElementData elementData = new ElementData("tagName","p");
				List<WebElement> pdfSectionList = findChildElements(elementData, element);// list of paragraphs
				if(pdfSectionList != null) {
					for (WebElement anchorElement : pdfSectionList) {// iterating paragraphs					
						if(anchorElement != null) {
							ElementData anchorElementData = new ElementData("tagName","a");
							if(findChildElement(anchorElementData, anchorElement) != null) {
								findChildElement(anchorElementData, anchorElement).click();// final anchorTag
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
	
	
	
	public BenefitsAndCoveragePage1 navigateToBenefitsAndCoverage() {
		benefitsAndCoverageLink.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if (driver.getTitle().equalsIgnoreCase(
				"My Benefits & Coverage")) {
			return new BenefitsAndCoveragePage1(driver);
		} else
			return null;
	}
	}
	


