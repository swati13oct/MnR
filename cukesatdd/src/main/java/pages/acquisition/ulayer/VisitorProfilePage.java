package pages.acquisition.ulayer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

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
		
		List<String> listOfTestPlans = Arrays.asList(plans.split(","));
		for (String plan: listOfTestPlans) {
			driver.findElement(By.xpath("//h4[text()='"+plan+"']/preceding::button[1]")).click();
		}
		Assert.assertTrue(!(driver.findElements(By.xpath("//div[@class='title dropdown-open']")).size()>0));
	}
}
