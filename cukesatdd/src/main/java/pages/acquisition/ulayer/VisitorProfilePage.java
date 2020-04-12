package pages.acquisition.ulayer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ole.WelcomePage;

public class VisitorProfilePage extends UhcDriver {

	@FindBy(id = "dupIconFlyOut")
	private WebElement shoppingCartIcon;
	
	@FindBy(css = "div.signupCTA a:first-child")
	private WebElement signIn;
	
	@FindBy(css = "div.signupCTA a.profileBtn")
	private WebElement btnCreateProfile;
	
	@FindBy(css = "div.dashboardCard.plans a.empty-message-link")
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
	
	@FindAll({@FindBy(xpath = "//li[@class='drug']")})
	private List<WebElement> savedDrugs;
	
	@FindBy(xpath="//div[contains(@class,'drug--block card')]//ul")
	private WebElement drugBlock;
	
	@FindBy(css="div.signupCTA.signupContainer a")
	private WebElement signOut;
	
	@FindBy(id = "enrollment-next-button")
	private WebElement NextBtn;
	
	public VisitorProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

		openAndValidate();
	}
	
	@Override
	public void openAndValidate() {
		validate(shoppingCartIcon);

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
		if(driver.getCurrentUrl().contains("zipcode")){
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
			Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='"+plan+"']/following::div[@class='provider-list'][1]/a")).isDisplayed());
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
	
	public boolean providerinfo(String planName)
	{
		WebElement ProviderSearchLink = driver.findElement
				(By.xpath("//*[contains(text(),'"+planName+"')]/following::div[contains(@class, 'provider-accordion')]//button[contains(@class,'provider-toggle')]"));
		String mproviderinfo=ProviderSearchLink.getText();
		System.out.println(mproviderinfo);
		if(mproviderinfo.toLowerCase().contains("providers covered"))
		{
			return true;
		}
		return false;

	}
	
	/**
	 * Sign In with Optum Id credentials
	 * @param username
	 * @param password
	 */
	public void signIn(String username,String password) {
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
	}
	
	public WelcomePage Enroll_OLE_Plan(String planName) {
		WebElement enrollForPlan = null;
		
		enrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::*[contains(@class,'title-container')]//*[contains(@class,'btn') and contains(@dtmname,'Enroll in Plan')]"));
		if(enrollForPlan!=null){
			enrollForPlan.click();
		}
		validateNew(NextBtn);
		if(driver.getCurrentUrl().contains("welcome")){
			System.out.println("OLE Welcome Page is Displayed");
			return new WelcomePage(driver);
		}
		return null;
	}
}
