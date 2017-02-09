package pages.dashboard.member.drugcostestimator.blayer;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;
public class DrugCostEstimatorPage extends UhcDriver{

	public DrugCostEstimatorPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	//	CommonUtility.waitForPageLoad(driver, SaveDrugPage, 10);
		String fileName = CommonConstants.SAVE_DRUG_PAGE_DATA;
		//savedrugpage = CommonUtility.readPageData(fileName,
			//	CommonConstants.PAGE_OBJECT_DIRECTORY_BLAYER_MEMBER);
		//openAndValidate();
	}
	private PageData savedrugpage;

	public JSONObject savedrugpageJson;

	@FindBy(id = "add-drug")
	public WebElement addDrug;
	
	@FindBy(className = "edit-drug")
	public WebElement editDrug;
	
	@FindBy(id = "drug-search-input")
	public WebElement drugsearchinput;
	
	@FindBy(xpath = "//h1[contains(text(),'Drug')][contains(text(),'Cost')][contains(text(),'Estimator')]")
	public WebElement validateIntroductoryText;



	@FindBy(id="drug-alt-search-button")
	public WebElement continueButton;


	@FindBy(xpath="/html/body/div[2]/div[3]/div/div/div/div/div/div[3]/div/table/tbody/tr")
	public WebElement SaveDrugPage;
	
	@FindBy (xpath = "//div[@id='dce.member']/div[2]/div/div/div/div/div/div[2]/div[1]/div[2]/div[1]/ul/li[2]/a/p[2]")
	public WebElement step2PharmacyTab;
	
	@FindBy(className = "milesSelection")
	public WebElement milesSelection;
	
	@FindBy (xpath = "//div[@id='dce.member']/div/div[5]/div/div/form/div/div/div/div[2]/div[3]/span[1]")
	public WebElement zipcodeInput;
	
	@FindBy(xpath = "//div[@id='dce.member']/div/div[5]/div/div/form/div/div/div/div[2]/div[3]/a[1]")
	public WebElement SearchLink; //is it the same thing?
	
	@FindBy(xpath = "//div[@class='inputRadioButtons']/div[1]/p")
	public WebElement StandardNetworkPharmaciesRadioButton;
	
	@FindBy(xpath = "//div[@class='inputRadioButtons']/div[2]/div/p")
	public WebElement PharmacyNetworkPharmacyRadioButton;
	
	@FindBy(xpath = "//div[@class='inputRadioButtons']/div[4]/p")
	public WebElement PreferredMailServicePharmacyRadioButton;
	
	@FindBy(xpath = "//div[@class='inputRadioButtons']/div[2]/div/span[3]/div")
	public WebElement PreferredRetailSavingMsg;
	
	@FindBy(className = "tablePharmacy")
	public WebElement PharmacyList;
	
	@FindBy(xpath = "//span[contains(./text(),'Men')]")
	public WebElement PharmacyName;
	

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : savedrugpage.getExpectedData().keySet()) {
			WebElement element = findElement(savedrugpage.getExpectedData()
					.get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		savedrugpageJson = jsonObject;

		System.out.println("savedrugpageJson----->" + savedrugpageJson);
	}
	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		JSONObject dashoardExpectedJson = expectedDataMap
				.get(CommonConstants.DCEstimator);

		return dashoardExpectedJson;
	}
	public AddNewDrugModal clickOnAddDrug() {
		addDrug.click();
		System.out.println("Current Page title :: "+driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("My Benefits & Coverage")) {
			return new AddNewDrugModal(driver);
		}
		return null;
	}
	public void changeUrlToNewDCEPage() {

		//String NewDCEUrl = "https://member.team-b-uhcmedicaresolutions.uhc.com/content/dashboard/home/drug-cost-estimator.html#/drugCostEstimator";
		String NewDCEUrl = "https://www.team-b-uhcmedicaresolutions.uhc.com/content/dashboard/home/drug-cost-estimator.html";
		driver.get(NewDCEUrl);
		
		try{
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}catch(NoAlertPresentException e){
			
		}
        
		driver.manage().window().maximize();
		try {
			//CommonUtility.waitForPageLoad(driver, SaveDrugPage, 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteDrugs(int i) {
		String deleteDrugXpath="(//a[text()='Delete'])["+"i"+"]";
		WebElement deletedrug=driver.findElement(By.xpath(deleteDrugXpath));
		deletedrug.click();

	}
	public boolean validateintroductorytext() {
		// TODO Auto-generated method stub
		if(validateIntroductoryText.getText().equalsIgnoreCase("Drug Cost Estimator"))
			return true;
		else 
			return false;
	}
	public boolean validatedrugheading() {
		// TODO Auto-generated method stub
		if(validateIntroductoryText.getText().equalsIgnoreCase("Drug Cost Estimator"))
			return true;
		else 
			return false;
	}
	public void navgateToEditDrug(String drug){
		//editDrug.click();
		WebElement editDrug = driver.findElement(By.xpath("//div[@class='drug-container']//p[contains(text(),'"+drug+"')]/parent::section//a[@class='edit-drug']"));
		editDrug.click();
	}

	public void addDrugs(List<String> list){

		for(String drug : list){
			AddNewDrugModal addNewDrugModal = new AddNewDrugModal(driver);
			addNewDrugModal.clickonSearchButton(drug);
			AddDrugDetails addDrugDetails = addNewDrugModal.selectDrug(drug);
			addDrugDetails.continueAddDrugDetails();
			
		}
	}
	
	public void pharmacyInformation(String zipcode, String radius){
		validate(step2PharmacyTab);
		validate(zipcodeInput);
		validate(milesSelection);
		step2PharmacyTab.click();
		sendkeys(zipcodeInput,zipcode); //not sure what webelement to use
		SearchLink.click();
		Select options = new Select(milesSelection);
		options.selectByVisibleText(radius);
					
	}
		
		
}

