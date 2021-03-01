package pages.acquisition.bluelayer;
import java.util.List;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.bluelayer.DrugCostEstimatorPage;
public class SavingsOppurtunity extends UhcDriver{
	

	public JSONObject switchgenericJson;
	

	@FindBy(id="drug-alt-search-button")
	public WebElement continueButton;
	
	@FindBy(id="save-drug-button")
	public WebElement savedrugbutton;
	
	@FindBy(xpath=".//*[@id='popup4']/header/span[contains(text(),' SAVINGS OPPORTUNITY')]")
	public WebElement SwitchGenericPage;
	
	@FindBy(xpath="//div[@id='popup4']//*[contains(@class,'subtitle')]")
	public WebElement SwitchGenericPageHeading;
	
	@FindBy(xpath="//div[@id='popup4']//section[contains(@class,'add-drug-slide-body')]//h2[contains(@class,'drug-name')]")
	public WebElement drugHeading;
	
	@FindBy(id="drug-name-sr-only")
	public WebElement genericDrugName;
	
	@FindBy(xpath="//*[@id='generic-1']/following-sibling::label")
	public WebElement switchToGenericOption;
	
	@FindBy(xpath="//*[@id='generic-2']/following-sibling::label")
	public WebElement keepBrandedDrugOption;
	
	public SavingsOppurtunity(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}
	@Override
	public void openAndValidate() {
		CommonUtility.waitForPageLoadNew(driver, SwitchGenericPageHeading, 30);
		validateNew(drugHeading);
		validateNew(genericDrugName);
		validateNew(switchToGenericOption);
		validateNew(keepBrandedDrugOption);	
	}
	
	public void switchToGeneric() throws InterruptedException {

		List<WebElement> generic = driver.findElements(By.xpath(".//*[@id='generic-check']/div[1]"));
		generic.get(0).click();
		Thread.sleep(3000);
	}
	
	public DrugCostEstimatorPage savedrugbutton() throws InterruptedException {
		validateNew(savedrugbutton);
		savedrugbutton.click();
		return new DrugCostEstimatorPage(driver);
	}
}
