/**
 * 
 */
package pages.member.bluelayer;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
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

	@FindBy(linkText = "Search Medical EOB History")
	private WebElement medicalEobLink;

	@FindBy(linkText = "Search Prescription Drug EOB History")
	private WebElement prescriptionDrugEobLink;

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	@FindBy(xpath = "//*[@id='SummaryofBenefits_-1609990126']/p/a")
	private WebElement PDF1;

	private PageData formsAndResources;

	public JSONObject formsAndResourcesJson;

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

	public void clickOnPDF() {
		// TODO Auto-generated method stub
		//PDF1.click();
		//input[starts-with(@id,'reportcombo')
		//List<WebElement> links = driver.findElements(By.xpath("//div[@id='_content_campaigns_uhcm_formsresources-plandocs-main_group_jcr_content_par_borderedtitledescrip_subContent_teaser']"));
		
		WebElement links1 = driver.findElement(By.xpath("//*[contains(text(),'Plan Materials')]"));
		if(links1.isDisplayed()){
		//List<WebElement> links = links1.findElements(By.xpath("//div/p/a"));
		List<WebElement> links = links1.findElements(By.xpath("//div[@class = 'parbase section formsresources']//p/a"));
		//List<WebElement> links = driver.findElements(By.xpath("//div[starts-with(@id,'pdflinks')]"));
		int linkcount = links.size(); 
		System.out.println(links.size()); 
		for(WebElement myElement :  links){
			//WebElement myElement =  links.get(i);
			//WebElement myElement1 = myElement.findElement(By.xpath("//div/p/a"));
			//String a = myElement1.toString();
			String link = myElement.getText(); 
			System.out.println(link);
			System.out.println(myElement);   
			if (link !=""){
				myElement.click();
				try {
					Thread.sleep(20000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				driver.findElement(By.xpath("//*[@id='proceed']")).click();
				driver.switchTo().defaultContent();
				
				System.out.println("Opened the PDF");
			}
		}
		}
		else{
			System.out.println("Plan Materials section is not displayed");
		}

	}
}
