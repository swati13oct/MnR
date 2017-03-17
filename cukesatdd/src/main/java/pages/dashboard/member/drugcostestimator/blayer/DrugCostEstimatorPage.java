package pages.dashboard.member.drugcostestimator.blayer;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
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


	@FindBy(xpath = "//div[@id='drugs-tab']//div[@id='add-drug']")
	public WebElement addDrug;
	
	@FindBy(xpath="//p[contains(text(),'STEP2:')]/following-sibling::span[p[contains(text(),'PHARMACY')]]")
	public WebElement step2;
	
	@FindBy(xpath="//p[contains(text(),'STEP1:')]/following-sibling::span[p[contains(text(),'DRUGS')]]")
	public WebElement step1;
	
	@FindBy(id="pharmacy-form")
	public WebElement pharmacyform;
	
	@FindBy(id="standard")
	public WebElement rbStandardNetwork;
	
	@FindBy(id="saver")
	public WebElement rbPharmacySaver;
	
	@FindBy(id="mail-service")
	public WebElement rbPreferredMailService;
	
	@FindBy(id="retail")
	public WebElement rbPreferredRetail;
	
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
	
	@FindBy(xpath="//p[contains(text(),'STEP2:')]/following-sibling::span[p[contains(text(),'PHARMACY')]]")
	public WebElement step2PharmacyTab;
	
	@FindBy(id = "distance")
	public WebElement milesSelection;
	
	@FindBy (id = "zipcode")
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
	
	@FindBy(xpath="//p[contains(text(), 'Summary')]")
	public WebElement SummaryHeader;
	
	@FindBy(xpath="//div/p[contains(text(),'Enter your drugs to see your total drug costs')]")
	public WebElement Enter_drug_text;
	
	@FindBy(xpath="//a[@href='#drugs-tab']/span/p")
	public WebElement drugTab;
	
	@FindBy(xpath="//span[@class='msg-more-drugs ng-scope']/p")
	public WebElement mesgMoreDrugsOther;

	@FindBy(xpath="//div[@class='drug-container ng-scope'][1]/p[@class='ng-binding ng-scope']")
	public WebElement drugndosage1;
	
	@FindBy(xpath="//div[@class='drug-container ng-scope'][2]/p[@class='ng-binding ng-scope']")
	public WebElement drugndosage2;
	
	@FindBy(xpath="//div[@class='drug-container ng-scope'][3]/p[@class='ng-binding ng-scope']")
	public WebElement drugndosage3;
	
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
	public AddNewDrugModal clickOnAddDrug() throws InterruptedException {
		Thread.sleep(5000);
		waitforElement(addDrug);
		addDrug.click();
		System.out.println("Current Page title :: "+driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("My Benefits & Coverage")) {
			return new AddNewDrugModal(driver);
		}
		return null;
	}
	public void changeUrlToNewDCEPage() {

		String NewDCEUrl = "https://member.team-b-uhcmedicaresolutions.uhc.com/content/dashboard/home/drug-cost-estimator.html";
		//String NewDCEUrl = "https://www.team-b-uhcmedicaresolutions.uhc.com/content/dashboard/home/drug-cost-estimator.html";
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

	public void addDrugs(int count,String drug) throws InterruptedException{
		for(int i=1;i<=count;i++){
			AddNewDrugModal addNewDrugModal = clickOnAddDrug();
			if((getDrugsCount()) == 25 || i == 26){
				System.out.println("Exceeded the limit");
				addNewDrugModal.verifyExceededError();
				break;
			}
			addNewDrugModal.typeDrugName(drug);
			addNewDrugModal.submit();
			addNewDrugModal.selectDrug(drug);
			AddDrugDetails addDrugDetails = new AddDrugDetails(driver);
			addDrugDetails.selectQnty(i+"");
			addDrugDetails.continueAddDrugDetails();
			SavingsOppurtunity savingsOppurtunity  = new SavingsOppurtunity(driver);
			savingsOppurtunity.savedrugbutton();
			Thread.sleep(3000);
		}
	}
	public int getDrugsCount(){
		List<WebElement> drugs = driver.findElements(By.xpath("//div[@id='drugs-tab']//div[contains(@ng-repeat,'eachDrug')]"));
		return drugs.size();
	}
	
	public void navigateToStep2(){
		waitforElement(step2);
		step2.click();
	}
	
	public void backwardToStep1(){
		step1.click();
	}
	
	public void validatePharmacyForm(){
		Assert.assertTrue(pharmacyform.isDisplayed());
		Assert.assertTrue(rbStandardNetwork.isDisplayed());
		Assert.assertTrue(rbPharmacySaver.isDisplayed());
		Assert.assertTrue(rbPreferredMailService.isDisplayed());
		Assert.assertTrue(rbPreferredRetail.isDisplayed());
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
	
	public boolean validatemesgmoredrugsothertext(String otherscount) {
		// TODO Auto-generated method stub
		
		System.out.println("--------------" + mesgMoreDrugsOther.getText());
		if(mesgMoreDrugsOther.getText().contentEquals(otherscount))
			//mesgMoreDrugsOther.getText().contentEquals(cs)
			return true;
		else 
			return false;
	}
	public void validateenterdrugtext() {
		Assert.assertTrue(Enter_drug_text.isDisplayed());
		}

public void validatesummaryheading() {
	
		Assert.assertTrue(SummaryHeader.isDisplayed());
	}
	
	public boolean validatetabdrugheading() {
		// TODO Auto-generated method stub
		
		if(drugTab.getText().equalsIgnoreCase("DRUGS")){
			
			return true;
		}
			else 
			return false;
	}

public void validateDrugsnotPresent(String dosage){
		
		String deleteDrugXpath="//div[@id='drugs-tab']//p[contains (text(), '"+dosage+"')]";
		try{
		WebElement dosagedrug=driver.findElement(By.xpath(deleteDrugXpath));
		Assert.assertFalse(true);
		}catch(NoSuchElementException e){
			Assert.assertFalse(false);
		}
		
	}

public void deleteDrugsByDosage(String dosage) throws InterruptedException {
	Thread.sleep(15000);
	String deleteDrugXpath="//div[@id='drugs-tab']//p[contains (text(), '"+dosage+"')]/following-sibling::ul//li/a[@class='delete-drug']";
	WebElement deletedrug=driver.findElement(By.xpath(deleteDrugXpath));
	deletedrug.click();
	Thread.sleep(5000);

}

public AddDrugDetails navigateToEditDrug(String drug) throws Exception{
	//editDrug.click();
	Thread.sleep(15000);
	WebElement editDrug = driver.findElement(By.xpath("//div[@class='drug-container']//p[contains(text(),'"+drug+"')]/parent::section//a[@class='edit-drug']"));
	editDrug.click();
	Thread.sleep(5000);
	return new AddDrugDetails(driver);
}


public boolean validateAddedDrug(String args1,String arg2, String arg3) {
		// TODO Auto-generated method stub
		validate(driver.findElement(By.xpath("//div[@id='drugs-tab']//p[contains (text(), '"+args1+"')]/following-sibling::p/span[contains(text(),'"+arg2+"')]")));
		
		//List<WebElement> stri = driver.findElements(By.xpath("//div[@id='drugs-tab']//p[contains (text(), '"+args1+"')]")).getText();
	//System.out.println("++++++++drugdetails+++++++++" + drugdetails + "+++++++++++++++++" );

	 driver.findElement(By.xpath("//div[@id='drugs-tab']//p[contains (text(), '"+args1+"')]")).getText().contains(arg2);
	 driver.findElement(By.xpath("//div[@id='drugs-tab']//p[contains (text(), '"+args1+"')]")).getText().contains(arg3);
	
		//driver.findElements(By.xpath("//div[@id='drugs-tab']//p[contains (text(), '"+args1+"')]).gettext();
	return true;
	}


	public boolean validatedrugdosagetext(String arg1, String arg2, String arg3) {
		// TODO Auto-generated method stub
		if(drugndosage1.getText().equalsIgnoreCase(arg1)&&drugndosage2.getText().equalsIgnoreCase(arg2)&&drugndosage3.getText().equalsIgnoreCase(arg3))
			return true;
		else 
			return false;
	}
		
}

