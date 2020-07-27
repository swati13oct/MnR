package pages.acquisition.dceredesign;

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
}
