package pages.acquisition.dceredesign;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;

public class DrugSummaryPage extends UhcDriver {

	public DrugSummaryPage(WebDriver driver) throws InterruptedException {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@FindBy(xpath = "//h2[contains(text(),'Your estimated')]")
	public WebElement reviewDrugCostPageHeading;

	@FindBy(xpath = "//*[@class='uhc-filter-group']")
	public WebElement planTypeToggle;
	
	@FindBy(xpath = "//*[text()='Pharmacy:']/..")
	public WebElement pharmacyLink;
	
	@FindBy(xpath = "//*[@class='column column-12']//*[@class='uhc-select uhc-select--block']")
	public WebElement sortDropdown;
	
	@FindBy(xpath = "//*[@class='uhc-card__header']//h4")
	public WebElement planCardHeader;
	
	@FindBy(xpath = "//*[text()='Average Monthly Drug Cost']/following-sibling::div")
	public WebElement avgMonthlyDrugCost;
	
	@FindBy(xpath = "//*[text()='Monthly Premium']/following-sibling::div")
	public WebElement monthlyPremium;
	
	@FindBy(xpath = "//*[text()='Annual Estimated Total']/following-sibling::div")
	public WebElement annualEstimatedTotal;
	
	@FindBy(xpath = "//*[text()='Drugs Covered']/following-sibling::div")
	public WebElement drugsCovered;
	
	@FindBy(xpath = "//button[contains(text(),'Why Average?')]")
	public WebElement whyAverageLink;
	
	@FindBy(xpath = "//*[contains(@id,'includeLinkBtn')]")
	public WebElement whatsIncludedLink;
	
	@FindBy(xpath = "//*[contains(@id,'priceLinkBtn')]")
	public WebElement drugPricingLink;
	
	@FindBy(xpath = "//button/span[text()='View Drug Costs']")
	public WebElement viewDrugCostBtn;
	
	@FindBy(xpath = "//button/span[text()='View Plan Details']")
	public WebElement viewPlanDetailsBtn;
	
	@FindBy(xpath = "//button//span[text()='Save']")
	public WebElement saveBtn;
	
	@FindBy(xpath = "//*[@id='disclaimer-accordion-wrap']")
	public WebElement disclaimer;
	
	@FindBy(xpath = "//*[@class='heading-4 mb-10']")
	public WebElement planTypeHeading;
	
	@FindBy(xpath = "//label[@class='uhc-filter column column-4']//span[contains(text(),'Medicare Prescription Drug Plans')]")
	public WebElement pdpPlanToggle;
	
	@FindBy(xpath = "//label[@class='uhc-filter column column-4']//span[contains(text(),'Medicare Special Needs Plans')]")
	public WebElement snpPlanToggle;

	@Override
	public void openAndValidate() throws InterruptedException {
		validateNew(reviewDrugCostPageHeading);
		
	}
	
	public DrugSummaryPage validateDrugSummaryPage() throws InterruptedException {
		if(validateNew(reviewDrugCostPageHeading) && validateNew(planTypeToggle) &&	validateNew(pharmacyLink) &&
		validateNew(planCardHeader)&&
		validateNew(avgMonthlyDrugCost) &&
		validateNew(monthlyPremium)&&
		validateNew(annualEstimatedTotal) &&
		validateNew(drugsCovered)&&
		validateNew(whyAverageLink)&&
		validateNew(whatsIncludedLink)&&
		validateNew(drugPricingLink)&&
		validateNew(viewDrugCostBtn)&&
		validateNew(viewPlanDetailsBtn)&&
		validateNew(saveBtn)&&
		validateNew(disclaimer)) {
		return new DrugSummaryPage(driver);
		}
		
		return null;
	}
	
	public DrugSummaryPage verifyDefaultPlanType() throws InterruptedException {
		if(planTypeHeading.getText().contains("Medicare Advantage Plans")) {
			return new DrugSummaryPage(driver);
		}
		return null;
	}
	
	public DrugSummaryPage verifyPDPPlanToggle() throws InterruptedException {
		pdpPlanToggle.click();
		if(planTypeHeading.getText().contains("Medicare Prescription Drug Plans")) {
			return new DrugSummaryPage(driver);
		}
		return null;
	}
	
	public DrugSummaryPage verifySNPPlanToggle() throws InterruptedException {
		snpPlanToggle.click();
		if(planTypeHeading.getText().contains("Medicare Special Needs Plans")) {
			return new DrugSummaryPage(driver);
		}
		return null;
	}
	
	@FindBy(id = "sign-up-modal-header")
	private WebElement createProfilePopup;
	
	public void savePlan(String planName)
	{		
		try {
			List<String> listOfTestPlans = Arrays.asList(planName.split(","));
			System.out.println("Going to mark the following "+listOfTestPlans.size()+" number of test plans as favorite");
			Thread.sleep(5000);
			for (String plan: listOfTestPlans) {
				//WebElement savePlan = driver.findElement(By.xpath("//*[contains(text(),'"+plan+"')]/following::div[contains(@class,'favorite-plan-container')][1]//img[contains(@src,'unfilled.png')]"));
				WebElement savePlan = driver.findElement(By.xpath("//button[contains(@id,'saveBtn') and @aria-label='Save "+plan+"']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", savePlan);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", savePlan);
			}
			/*if(createProfilePopup.isDisplayed()) {
				closeProfilePopup.click();
			}*/
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FindBy(xpath = "//label[contains(@class,'uhc-filter')]/input[@name='plans-filter' and @value='PDP']")
	private WebElement clickPdpplan;
	
	@FindBy(xpath = "//label[contains(@class,'uhc-filter')]/input[@name='plans-filter' and @value='SNP']")
	private WebElement clickSnpplan;
	
	public void clickOnPDPPlan()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(clickPdpplan);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click()", clickPdpplan);
		//clickPdpplan.click();
		
		
	}
	
	public void clickOnSNPPlan()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		validate(clickSnpplan);
		JavascriptExecutor je = (JavascriptExecutor)driver;
		je.executeScript("arguments[0].click()", clickSnpplan);
	}
	
	
}
