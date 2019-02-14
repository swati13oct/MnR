/**
 * 
 */
package pages.acquisition.bluelayer;


import java.awt.Desktop.Action;
import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.PageTitleConstants;


public class PlanSelectorNewPage extends UhcDriver {

	@FindBy(id = "planSelectorTool")
	private WebElement iframePst; 


	/*@FindBy(xpath = "//div[@id='widget_0tdroCAgSEGuqWNwLbf7xA']/div/a")
	private WebElement getStartedBtn; */
	
	@FindBy(xpath = "(//a[contains(text(), 'Get Started')])[2]")
	private WebElement getStartedBtn; 

	//	@FindBy(css = "#widget_0tdroCAgSEGuqWNwLbf7xA > div > a")
	//	private WebElement getStartedBtn; 

	@FindBy(id = "DemographicsDataModel_ZipCode")
	private WebElement zipCode;
	
	@FindBy(id = "Counties")
	private WebElement PSTCounty;
	
	@FindBy(xpath = "//*[@id='CoverageType_Idontknow_Option_7_Lable']/following-sibling ::label")
	private WebElement TypeOfCoverageOption; 

	@FindBy(xpath = "//div[@class='rightBlk']//a[@class='btn btn-primary next leftBlk nextBtn']")
	private WebElement continueBtn; 
	
	@FindBy(xpath = "//*[@id='control_control_0_4']/following-sibling::label")
	private WebElement NoneOption;
	
	@FindBy(xpath = "//*[@id='control_control_1_4']/following-sibling::label")
	private WebElement NonePreference;
	
	@FindBy(xpath = "(//*[@class='preferencenavigation pageNavigation']/a[2])[1]")
	private WebElement NextQuestionButton;
	
	@FindBy(id = "planPreferenceLegend_1")
	private WebElement NextQuestion;
	
	@FindBy(xpath="//*[@class='planPreferenceQuestion']//div[@class='preferencenavigation pageNavigation']/a[2]")
	private WebElement NextQuestionButton2;
	
	@FindBy(xpath = "(//*[contains(text(), 'Medicare Advantage (Part C)')])[2]")
	private WebElement FinalResults;
	
	@FindBy(xpath = "//*[@class='skipToResultsLink']")
	private WebElement ResultsPageLink;
	
	@FindBy(id = "planPreferenceLegend_1")
	private WebElement PrescriptionBox;
	
	@FindBy(id = "DrugSearchBox_SearchtextBox")
	private WebElement PrescriptionBox_1;
	
	/*@FindBy(xpath = "//*[@id='41d4dd57-ca06-f737-8466-59563fb2d535']//li/a[@id='ui-active-menuitem']")
	private WebElement PrescriptionAutoResults;*/
	
	//@FindBy(id="ui-active-menuitem")
	@FindBy(xpath="(//a[@id='ui-active-menuitem'])[1]")
	private WebElement PrescriptionAutoResultsOld;
	
	@FindBy(xpath="(//li[@class='ui-menu-item'])[1]")
	private WebElement PrescriptionAutoResults;
	
	@FindBy(xpath = "//*[@class='addDrugRow addDPad']/a[@id='Drugs_AddDrug']")
	private WebElement AddDrugPSTButton;

	@FindBy(xpath = "//*[@class='rightBlk']/a[2]")
	private WebElement DrugContinueButton;
	
	@FindBy(xpath = "(//*[@class='checkboxCol']//label[@class='sr-only selectable'])[1]")
	private WebElement PharmacyCheckBox;
	
	//a[@class='btn btn-primary next leftBlk nextBtn']
	@FindBy(xpath = "//div[@id='widget_B9pzC-bMU02tTlxiTpbchA']//div/a[@href='/PlanCompare/Consumer/Type3/2018/Compare/ComparePlans']")
	private WebElement skipToResultsLink;

	public  JSONObject planselectoruhcJson;

	@FindBy(xpath = "(//div[@class='planList']/div[2]//a[@class='btn-primary EnrollPeriod'])[1]")
	private WebElement firstPlanDetailsBtn;

	@FindBy(xpath = "//a[@id='backToPlanSelectorTop']")
	private WebElement backToPlanOptionsTop;

	@FindBy(xpath = "(//*[@id='selectCounty']/p/a)[1]")
	private WebElement BackToPlanCounty;
	
	@FindBy(id = "backToPlanSelectorBottom")
	private WebElement backToPlanSelectorBottom;

	@FindBy(xpath = "//*[@class='PlanPreferenceCollection']//div[@class='planPreferenceQuestion ']//h1")
	private WebElement PreferencesHeader;

	@FindBy(id = "Enrollbtn_225193")
	private WebElement PlanDetailsPageButton;


	public PlanSelectorNewPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		openAndValidate();
	}


	@Override
	public void openAndValidate() {
		validate(getStartedBtn);

	}


	public PlanSelectorNewPage quizStartAndRunQuestionnaire(String zip_code) throws InterruptedException
	{

			switchToNewIframe(iframePst);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(getStartedBtn));
		getStartedBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(zipCode));

		sendkeys(zipCode, zip_code);
		TypeOfCoverageOption.click();
		System.out.println("'I don't know option' radio button should be selected");		
		continueBtn.click();
		waitforElement(PreferencesHeader);				
		if(PreferencesHeader.getText().contains("Your Preferences"))
		return new PlanSelectorNewPage(driver);
		else 
			return null;

	}
	
	public PlanSelectorNewPage quizStartAndRunQuestionnaireWithCounty(String zip_code, String County) throws InterruptedException
	{

			switchToNewIframe(iframePst);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(getStartedBtn));
		getStartedBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(zipCode));
		sendkeys(zipCode, zip_code);
		//wait.until(ExpectedConditions.elementToBeClickable(PSTCounty));
		
		try {
			Thread.sleep(10000);
			Select drpCountry = new Select(driver.findElement(By.id("Counties")));
			System.out.println("county name is "+County);			
			drpCountry.selectByVisibleText(County);
		}
		catch(Exception ex)
		{
			Thread.sleep(2000);
			Select drpCountry = new Select(driver.findElement(By.id("Counties")));
			drpCountry.selectByValue("48029");
		}
		
		//Select drpCountry = new Select(driver.findElement(By.id("Counties")));
		//drpCountry.selectByVisibleText(County);
		
		//driver.findElement(By.xpath("//*[@id='Counties']/option[text()='" + County + "']")).click();
		TypeOfCoverageOption.click();
		System.out.println("'I don't know option' radio button should be selected");		
		continueBtn.click();
		waitforElement(PreferencesHeader);				
		if(PreferencesHeader.getText().contains("Your Preferences"))
		return new PlanSelectorNewPage(driver);
		else 
			return null;

	}
	
	
	public PlanSelectorNewPage NextQuestion() throws InterruptedException
	{		
		NoneOption.click();
		NextQuestionButton.click();		
		waitforElement(NextQuestion);
		if(NextQuestion.isDisplayed())
		return new PlanSelectorNewPage(driver);
		else 
			return null;

	}
	
	public PlanSelectorNewPage JumpLink() throws InterruptedException
	{		
		NonePreference.click();
		//ResultsPageLink.click();
		int i;
		
		for(i=0; i<6; i++)
		{
			Thread.sleep(3000);
		NextQuestionButton2.click();		
		}
		
		//waitforElement(FinalResults);
		Thread.sleep(10000);
		try{
			if(PrescriptionBox.isDisplayed())
				PrescriptionBox.sendKeys("Adci");				
		}catch(Exception e)
		{
			PrescriptionBox_1.sendKeys("Adci");
			System.out.println("Prescription page loaded");
		}		
		
		Thread.sleep(5000);
		
		try{
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", PrescriptionAutoResultsOld);
		}
		catch(Exception e)
		{
			PrescriptionAutoResults.click();
			System.out.println("second one worked");
		}
		
		
		
		/*Actions builder = new Actions(driver);
        builder.moveToElement(PrescriptionAutoResults).click()
        .build().perform();*/
        
		//PrescriptionAutoResults.click();
		waitforElement(AddDrugPSTButton);
		AddDrugPSTButton.click();
		Thread.sleep(2000);
		DrugContinueButton.click();
		Thread.sleep(5000);
		waitforElement(PharmacyCheckBox);
        PharmacyCheckBox.click();
        DrugContinueButton.click();
        Thread.sleep(5000);
        DrugContinueButton.click();
        waitforElement(FinalResults); 	
		
		if(FinalResults.isDisplayed())
		return new PlanSelectorNewPage(driver);
		else 
			return null;
	}
	
	

	public PlanSelectorNewPage navigateToPlanDetails() throws InterruptedException
	{
		/*Thread.sleep(3000);
		driver.switchTo().defaultContent();
		//Thread.sleep(5000);
		waitforElement(iframePst);
		switchToNewIframe(iframePst);
		//waitforElement(firstPlanDetailsBtn);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(firstPlanDetailsBtn));*/

		PlanDetailsPageButton.click();


		driver.switchTo().defaultContent();

		return new PlanSelectorNewPage(driver);

	}

	public PlanSelectorNewPage verifyBackToPlanOptionslink() throws InterruptedException
	{
		validatetopbacktoplansOptionlink();
		//browserBack();
		//validatedownbacktoplansOptionslink();


		return new PlanSelectorNewPage(driver);
	}

	public void validatetopbacktoplansOptionlink() throws InterruptedException{

         Thread.sleep(2000);
         
		try{
			BackToPlanCounty.click();	
		}catch(Exception e)
		{
			System.out.println("No zipcode turned in again");
		}
		
		Thread.sleep(2000);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(backToPlanOptionsTop));
		validateUsergrpParam();
		backToPlanOptionsTop.click();
		System.out.println("Top Button clicked");
		Thread.sleep(3000);
		//switchToNewIframe(iframePst);

		//waitforElement(firstPlanDetailsBtn);
		if (driver.getTitle().contentEquals(PageTitleConstants.BLAYER_PLAN_SELECTOR))
		{
			Assert.assertTrue(true);
		}

		else Assert.assertTrue(false);

	}

	public void validatedownbacktoplansOptionslink() throws InterruptedException{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1350)");
		Thread.sleep(1000);
		
		waitforElement(backToPlanSelectorBottom);
		validateUsergrpParam();
		Thread.sleep(1000);
		backToPlanSelectorBottom.click();
		//Thread.sleep(3000);
		//waitforElement(iframePst);
		//switchToNewIframe(iframePst);
		//waitforElement(firstPlanDetailsBtn);
		if (driver.getTitle().contentEquals(PageTitleConstants.BLAYER_PLAN_SELECTOR))
		{
			Assert.assertTrue(true);
		}

		else Assert.assertTrue(false);

	}

	public void browserBack() {

		driver.navigate().back();
	}

	public void validateUsergrpParam () {
		if (currentUrl().contains("userGroup=DST"))
		{
			Assert.assertTrue(true);
		}

		else Assert.assertTrue(false);
	}
}
