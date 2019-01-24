/**
 * 
 */
package pages.acquisition.bluelayer;


import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
	@FindBy(xpath = "//*[@id='CoverageType_Idontknow_Option_7_Lable']/following-sibling ::label")
	private WebElement TypeOfCoverageOption; 

	@FindBy(xpath = "//div[@class='rightBlk']//a[@class='btn btn-primary next leftBlk nextBtn']")
	private WebElement continueBtn; 
	
	@FindBy(xpath = "//*[@id='control_control_0_4']/following-sibling::label")
	private WebElement NoneOption;
	
	@FindBy(xpath = "(//*[@class='preferencenavigation pageNavigation']/a[2])[1]")
	private WebElement NextQuestionButton;
	
	@FindBy(id = "planPreferenceLegend_1")
	private WebElement NextQuestion;

	//a[@class='btn btn-primary next leftBlk nextBtn']
	@FindBy(xpath = "//div[@id='widget_B9pzC-bMU02tTlxiTpbchA']//div/a[@href='/PlanCompare/Consumer/Type3/2018/Compare/ComparePlans']")
	private WebElement skipToResultsLink;

	public  JSONObject planselectoruhcJson;

	@FindBy(xpath = "//div[@class='planList']/div[2]//a[@class='btn-primary EnrollPeriod']")
	private WebElement firstPlanDetailsBtn;

	@FindBy(xpath = "//a[@id='backToPlanSelectorTop']")
	private WebElement backToPlanOptionsTop;

	@FindBy(id = "backToPlanSelectorBottom")
	private WebElement backToPlanSelectorBottom;

	@FindBy(xpath = "//*[@class='PlanPreferenceCollection']//div[@class='planPreferenceQuestion ']//h1")
	private WebElement PreferencesHeader;



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

	//	Thread.sleep(2000);

		switchToNewIframe(iframePst);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(getStartedBtn));
		getStartedBtn.click();
		/*driver.switchTo().defaultContent();

		switchToNewIframe(iframePst);*/

		wait.until(ExpectedConditions.elementToBeClickable(zipCode));

		sendkeys(zipCode, zip_code);
		TypeOfCoverageOption.click();
		System.out.println("I don't know option radio button should be selected");
		
		//wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
		continueBtn.click();
		waitforElement(PreferencesHeader);
		/*driver.switchTo().defaultContent();
		switchToNewIframe(iframePst);*/

		/*wait.until(ExpectedConditions.elementToBeClickable(skipToResultsLink));

		skipToResultsLink.click();*/
		
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
	

	public PlanSelectorNewPage navigateToPlanDetails() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		//Thread.sleep(5000);
		waitforElement(iframePst);
		switchToNewIframe(iframePst);
		//waitforElement(firstPlanDetailsBtn);

		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(firstPlanDetailsBtn));

		firstPlanDetailsBtn.click();


		driver.switchTo().defaultContent();

		return new PlanSelectorNewPage(driver);

	}

	public PlanSelectorNewPage verifyBackToPlanOptionslink() throws InterruptedException
	{
		validatetopbacktoplansOptionlink();
		browserBack();
		validatedownbacktoplansOptionslink();


		return new PlanSelectorNewPage(driver);
	}

	public void validatetopbacktoplansOptionlink() throws InterruptedException{


		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(backToPlanOptionsTop));
		validateUsergrpParam();
		backToPlanOptionsTop.click();
		Thread.sleep(3000);
		switchToNewIframe(iframePst);

		waitforElement(firstPlanDetailsBtn);
		if (driver.getTitle().contentEquals(PageTitleConstants.BLAYER_PLAN_SELECTOR))
		{
			Assert.assertTrue(true);
		}

		else Assert.assertTrue(false);

	}

	public void validatedownbacktoplansOptionslink() throws InterruptedException{

		waitforElement(backToPlanSelectorBottom);
		validateUsergrpParam();
		backToPlanSelectorBottom.click();
		//Thread.sleep(3000);
		waitforElement(iframePst);
		switchToNewIframe(iframePst);
		waitforElement(firstPlanDetailsBtn);
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
