package pages.acquisition.bluelayer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class VisitorProfilePage extends UhcDriver {

	@FindBy(css = "a#dupIconFlyOut")
	private WebElement shoppingCartIcon;
	
	@FindBy(css = "div.signupCTA a:first-child")
	private WebElement signIn;
	
	@FindBy(css = "div.signupCTA a.profileBtn")
	private WebElement btnCreateProfile;
	
	@FindBy(xpath = "//*[contains(@aria-label,'Add Plans')]")
	private WebElement addPlans;
	
	@FindBy(css = "a.addrugs")
	private WebElement addrugs;
	
	@FindBy(css = "a.add-provider")
	private WebElement addprovider;
	
	@FindBy(xpath="//div[contains(@class,'drug-list-accordion')]//button[contains(@class,'drug-list-toggle')][contains(@class,'collapsed')]")
	private WebElement expandDrugBlock;
	
	@FindBy(xpath="//*[contains(@id,'DrugName-noplan-0')]")
	private WebElement drugName;
	
	@FindBy(xpath="//*[contains(@class,'pharminfo')]")
	private WebElement pharmacyAddress;
	
	@FindBy(xpath="//button[contains(@dtmname,'2019')]")
	private WebElement planYearBtn2019;
	
	@FindBy(xpath="//button[contains(@dtmname,'2020')]")
	private WebElement planYearBtn2020;
	
	@FindBy(css="div.signupCTA.signupContainer a")
	private WebElement signOut;
	
	@FindBy(id = "enrollment-next-button")
	private WebElement NextBtn;
	
	@FindBy(xpath = "//div[@id='dashPlansContainer']//div[contains(@class,'Plan')][1]//div[@class='enroll-container']/button")
	private WebElement enrollInPlan;
	
	@FindBy(id = "header-number")
	private WebElement shoppingCartNumber;
	
	@FindAll({@FindBy(xpath = "//li[@class='drug']")})
	private List<WebElement> savedDrugs;
	
	@FindBy(xpath="//div[contains(@class,'drug--block card')]//ul")
	private WebElement drugBlock;
	
	public VisitorProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		validateNew(shoppingCartIcon);

	}
	
	public DrugCostEstimatorPage addDrug(){
		
		addrugs.click();
		if(currentUrl().contains("/estimate-drug-costs.html"))
			return new DrugCostEstimatorPage(driver);
		return null;
	}
	
	public AcquisitionHomePage addPlan() {
		addPlans.click();
		CommonUtility.checkPageIsReadyNew(driver);
		if(driver.getCurrentUrl().contains("zipcode"))	{
			String page = "health-plans";
			return new AcquisitionHomePage(driver,page);
		}
		return null;
	}
	
	public void validateAddedDrugAndPharmacy(String drug) {
		expandDrugBlock.click();
		
		Assert.assertTrue(drugName.getText().trim().contains(drug));
		Assert.assertTrue(pharmacyAddress.isDisplayed());
	}
	
	public void validateAddedPlans(String planNames) {
		List<String> listOfTestPlans = Arrays.asList(planNames.split(","));
		for (String plan: listOfTestPlans) {
			Assert.assertEquals(plan, driver.findElement(By.xpath("//h4[text()='"+plan+"']")).getText());
			Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='"+plan+"']/following::button[1]")).isDisplayed());
		}
	}
	
	public void validateAddedMsPlans(String planNames) {
		List<String> listOfTestPlans = Arrays.asList(planNames.split(","));
		for (String plan: listOfTestPlans) {
			Assert.assertEquals(plan, driver.findElement(By.xpath("//h2[text()='"+plan+"']")).getText());
			//Assert.assertTrue(driver.findElement(By.xpath("//h2[text()='"+plan+"']/following::a[1]")).isDisplayed());
			Assert.assertTrue(driver.findElement(By.xpath("//div/a[contains(@aria-describedby,'"+plan+"')] [contains(@class,'pdf-link')]")).isDisplayed());
		}
	}
	
	public void validateAddedPlansPDFLinks(String planNames) {
		List<String> listOfTestPlans = Arrays.asList(planNames.split(","));
		for (String plan: listOfTestPlans) {
			Assert.assertTrue(driver.findElement(By.xpath("//div/a[contains(@aria-describedby,'"+plan+"')] [contains(@class,'pdf-link')]")).isDisplayed());
		}
	}
	
	public PlanDetailsPage navigateToPlanDetails(String planName) {
		try {
			driver.findElement(By.xpath("//h4[text()='"+planName+"']")).click();
			Thread.sleep(20000);
			if (driver.getCurrentUrl().contains("#/details")) {	
				return new PlanDetailsPage(driver);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void validateAndChoosePlanYear(String planYear) {
		
		if(planYear.equalsIgnoreCase("2019")){
			if(validate(planYearBtn2019))
				planYearBtn2019.click();
		}else if(planYear.equalsIgnoreCase("2020")){
			if(validate(planYearBtn2020))
				planYearBtn2020.click();
		}else
			System.out.println("No plan buttons were present");

		
	}
	
	/**
	 * Sign In with Optum Id credentials
	 * @param username
	 * @param password
	 */
	public void signIn(String username,String password) {
		try {
			
			signIn.click();
			driver.findElement(By.cssSelector("input#userNameId_input")).sendKeys(username);
			driver.findElement(By.cssSelector("input#passwdId_input")).sendKeys(password);
			driver.findElement(By.cssSelector("input#SignIn")).click();
			String Question = driver.findElement(By.cssSelector("label#challengeQuestionLabelId")).getText().trim();
			WebElement securityAnswer = driver.findElement(By.cssSelector("div#challengeSecurityAnswerId >input"));
			if (Question.equalsIgnoreCase("What is your best friend's name?")) {
				System.out.println("Question is related to friendname");
				securityAnswer.sendKeys("name1");
			}

			else if (Question.equalsIgnoreCase("What is your favorite color?")) {
				System.out.println("Question is related to color");
				securityAnswer.sendKeys("color1");
			} else {
				System.out.println("Question is related to phone");
				securityAnswer.sendKeys("number1");
			}
			driver.findElement(By.cssSelector("input#authQuesSubmitButton")).click();
			CommonUtility.waitForPageLoadNew(driver, signOut, 15);
			
		} catch (Exception e) {
			Assert.fail("###############Optum Id Sign In failed###############");
		}
		
	}
	
	/**
	 * Delete all the drugs from the profile
	 */
	public void deleteAllDrugs() {
		CommonUtility.waitForPageLoadNew(driver, savedDrugs.get(0), 45);
		driver.findElement(By.xpath("//li[@class='drug']//button")).click();
		/*for (WebElement drug: savedDrugs) {
			drug.findElement(By.xpath("//button")).click();
		}*/
		CommonUtility.waitForPageLoadNew(driver, addrugs, 45);
		Assert.assertTrue(addrugs.isDisplayed());
	}
	
	/**
	 * Deletes the specified plans
	 * @param plans
	 */
	public void deletePlans(String plans) {
		try {
			List<String> listOfTestPlans = Arrays.asList(plans.split(","));
			for (String plan: listOfTestPlans) {
				driver.findElement(By.xpath("//h4[text()='"+plan+"']/preceding::button[1]")).click();
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(!(driver.findElements(By.xpath("//div[@class='title dropdown-open']")).size()>0));
	}
	
	public void validatePlanCountOnCartIcon(String plancount) {
		Assert.assertEquals(plancount, shoppingCartNumber.getText());
		System.out.println("count mapped on Shopping cart icon with : " + plancount);

	}

	public VPPTestHarnessPage switchBackToVPTestharness() {
		driver.close();
		driver.switchTo().window(CommonConstants.MAIN_WINDOW_HANDLE_ACQUISITION);
		System.out.println("Switching back to MainWindow");
		if (driver.getCurrentUrl().contains("visitorprofiletestharness")) {
			System.out.println("visitorprofiletestharness Page is Displayed");
			return new VPPTestHarnessPage(driver);
		}
		return null;
	}
}
