package pages.acquisition.bluelayer;

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
			Assert.assertTrue(driver.findElement(By.xpath("//h4[text()='"+plan+"']/following::div[@class='provider-list'][1]/a")).isDisplayed());
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
}
