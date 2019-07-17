package pages.acquisition.ulayer;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class VisitorProfilePage extends UhcDriver {

	@FindBy(css = "a#dupIconFlyOut")
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
	
	@FindBy(xpath="//div[@class='drug-list-accordion open']/a")
	private WebElement expandDrugBlock;
	
	@FindBy(css="div.drug-info-container>div>span.name")
	private WebElement drugName;
	
	@FindBy(css="li.pharmacy>div>span.address:last-child")
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
		if(driver.getTitle().contains("Find Medicare Plans"))
			return new AcquisitionHomePage(driver,1);
		return null;
	}
	
	public void validateAddedDrugAndPharmacy(String drug) {
		expandDrugBlock.click();
		
		Assert.assertEquals(drug, drugName.getText().trim());
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
}