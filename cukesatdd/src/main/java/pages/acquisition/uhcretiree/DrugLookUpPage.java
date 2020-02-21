package pages.acquisition.uhcretiree;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;


/**
 * @author ckoppura
 *
 */

@SuppressWarnings("deprecation")
public class DrugLookUpPage extends UhcDriver {

	@FindBy(id = "drugNameFilter_scr")
	public WebElement findAdrugTextBox;

	@FindBy(id = "findDrugsButton_srch")
	public WebElement findDrugButton;

	@FindBy(id = "formularyListTable")
	public WebElement formularyDrugListTable;

	@FindBy(xpath = ".//*[@id='formularyListTable']//tr[2]//a")
	public WebElement drugLink;

	@FindBy(id = "brandsection")
	public WebElement formularyDrugTable;

	@FindBy(xpath = ".//*[@id='brandtable']//tbody//tr")
	public List<WebElement> MedicationDrugTable;

	@FindBy(xpath = ".//*[@id='generictable']//tbody//tr")
	public List<WebElement> genericDrugTable;
	
	@FindBy(xpath="(//div[contains(@class,'return_search_results')])[1]")
	public WebElement backToSearchResults;
	
	@FindBy(xpath="(//div[contains(@class,'new_search')])[1]")
	public WebElement backToNewSearch;

	@Override
	public void openAndValidate() {

	}

	public DrugLookUpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	public boolean validateDrugLookUpPage() {
		String currenturl = "";
		if (MRScenario.environment.equalsIgnoreCase("stage")) {
			currenturl = "/gr/en/drug_lookup.html";
		} else {
			currenturl = "drug_lookup.html";
		}
		if (currentUrl().contains(currenturl)) {
			System.out.println("User is on Drug Look Up Page");
			return true;
		}
		Assert.assertTrue(false);
		return false;
	}

	public void selectTheGroupName(String groupName) {
		String linktoclick = groupName;
		driver.findElement(By.xpath("//a[text()='"+linktoclick+"']")).click();
		validateNew(findAdrugTextBox);
		validateNew(findDrugButton);
	}

	public void impliciWait(WebElement element, int timeUnit) {
		driver.manage().timeouts().implicitlyWait(timeUnit, TimeUnit.SECONDS);
		waitforElement(element);
		System.out.println("Required Element Got Displayed Proceesing Further:    " + element.isDisplayed());
	}

	public void enterDrugNameToSearch() {
		findAdrugTextBox.sendKeys("lipitor");
		findDrugButton.click();
		impliciWait(formularyDrugListTable, 10);
	}

	public void selectTheDrugFromSearchResults() {
		try {
		drugLink.click();
		impliciWait(formularyDrugTable, 10);
		} catch (TimeoutException e) {
			Assert.assertTrue("PROBLEM - unable to locate the formularyDrugTable element", false);
		}
	}

	public void validateDrugResults() {
		MedicationDrugTable.size();
		genericDrugTable.size();
		for (int i = 0; i < MedicationDrugTable.size(); i++) {
			String tableRow = MedicationDrugTable.get(i).getText();
			System.out.println(tableRow);
		}
		for (int j = 0; j < genericDrugTable.size(); j++) {
			String tableRow = genericDrugTable.get(j).getText();
			System.out.println(tableRow);
		}
	}
	
	public void validateBacktoSearchResults() {
		validateNew(backToSearchResults);
		validateNew(backToNewSearch);
		backToSearchResults.click();
		validateNew(formularyDrugListTable);
	}
	
	@Override
	public void waitforElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 5L);
		wait.until(ExpectedConditions.visibilityOf(element));

	}
}