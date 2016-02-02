package pages.acquisition.bluelayer;

/*@author pagarwa5*/

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

public class AddDrugPage extends UhcDriver {

	/*@FindBy(css = "div > img[alt=\"Plus Image\"]")
	WebElement plusSign;*/

	@FindBy(xpath = "//div[@class='drugDropDownList']")
	private WebElement drugDropDownList;
	
	@FindBy(xpath = "//div[@class='costSavingsDrawer cb']")
	private WebElement switchTogenericButton;
	
	@FindBy(xpath = "//div[@class='reduceCosts generic']")
	private WebElement reduceCostPath;
	
	@FindBy(linkText = "Close and apply changes")
	WebElement applyChangesButton;
	
	@FindBy(id = "dcemodal")
	WebElement drugsAdded;
	
	/*@FindBy(xpath = "//div[@class='tab selectedTab']")
	private WebElement pharmacySearchTab;*/
	
	@FindBy(xpath="//div[@class='tabsHead']/div[2]")
	private WebElement pharmacySearchTab;


	@FindBy(name = "drugname")
	WebElement drugNameField;
	
	@FindBy(linkText = "Reduce costs")
	WebElement reduceCostLink;

	@FindBy(name = "autoCompleteDrugs_Lipitor")
	WebElement lipitorDrug;
	
	@FindBy(linkText = "View plan results")
	private WebElement viewPlansLink;
	
	@FindBy(className = "drugSearchBox")
	WebElement drugSearchBox;
	
	@FindBy(xpath="//div[@class='tabsHead']/div[2]")
	WebElement selectPharmacyTab;
	
	@FindBy(xpath="//div[@class='tabsHead']/div")
	WebElement manageDrugTab;
	
	@FindBy(xpath="//div[@class='delete']/a")
	private WebElement drugDelete;	

	@FindBy(className = "addDrugBox")
	WebElement adddrugdiv;
	
	public AddDrugPage(WebDriver driver) {
		super(driver);
		// Initialise Elements
		PageFactory.initElements(driver, this);
	}

	public void enterDrugInitials(String drugInitials) {
		//plusSign.click();
		drugNameField.click();
		drugNameField.clear();
		drugNameField.sendKeys(drugInitials);
	}

	public String getDrugList() {
		return drugDropDownList.getText();

	}

	public SelectDosagePage selectDrug(String drugName) {
		List<WebElement> list = drugDropDownList.findElements(By
				.xpath("//div[@class='tHi autoCompleteDrugs ng-scope']"));

		for (WebElement element : list) {
			System.out.println(element.getText());
			if (element.getText().equalsIgnoreCase(drugName)) {
				String drugXpath = "//*[contains(text(), '" + drugName + "')]";
				element.findElement(By.xpath(drugXpath)).click();

			}

		}
		if(driver.getTitle().equalsIgnoreCase("Our Medicare Plan Types | UnitedHealthcare®"))
		{
			return new SelectDosagePage(driver);
		}
		else
		{
			return null;
		}
	

	}

	public String validateDrugsAdded() {
		
		return drugsAdded.getText();
	}

/*	public PharmacySearchPage navigateToPharmacyPage() {
		pharmacySearchTab.click();
		if (driver
				.getTitle()
				.equalsIgnoreCase(
						"Our Medicare Plan Types | UnitedHealthcare®")) {
			return new PharmacySearchPage(driver);
		} else {
			return null;
		}
		
		
	}*/
	public PharmacySearchPage navigateToPharmacyPage() {
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pharmacySearchTab.click();
		if (driver.getTitle().equalsIgnoreCase("Our Medicare Plan Types | UnitedHealthcare®")) {
			System.out.println("navigateToPharmacyPage if");
	        return new PharmacySearchPage(driver);
		} else {
			System.out.println("navigateToPharmacyPage else");
		   return null;
		}


		}

	public VPPPlanSummaryPage navigateToHealthPlansPage() {
		
		
		viewPlansLink.click();
		CommonUtility.checkPageIsReady(driver);
		if (driver.getTitle().equalsIgnoreCase("Our Medicare Plan Types | UnitedHealthcare®")) {
			return new VPPPlanSummaryPage(driver);
		} else {
			return null;
		}
		
	}

	public void reduceCost() {
		reduceCostLink.click();
		System.out.println("reduce cost");
		
	}

	public void switchToGeneric() {
		switchTogenericButton.findElement(By.linkText("Switch to generic")).click();
		System.out.println();
	}

	public void applyChanges() {
		applyChangesButton.click();
		System.out.println("changes");
		
	}
	
	public void validateAddDrugFlow(){
		validate(drugSearchBox);
		selectPharmacyTab.click();
		manageDrugTab.click();
		validate(drugSearchBox);
		
	}
	
	/*private boolean validate(WebElement element) {
		try {
			if (element.isDisplayed()) {
				System.out.println("Element found!!!!");
				return true;
			} else {
				System.out.println("Element not found/not visible");
			}
		} catch (Exception e) {
			System.out.println("Exception: Element not found/not visible");

		}
		return false;
	}*/
	
	public void addDrugFlowCheck(){
		drugDelete.click();
	}
	
	public void clickAddImage() {       
        
        adddrugdiv.click();
	}
	
	@Override
	public void openAndValidate() {
		

	}
	
	
	public void swithedToSelectPharmacyTab(){
		selectPharmacyTab.click();
	}
	
	public PharmacySearchPage navigateToUpdatedPharmacyPage() {
		if (currentUrl().contains("selectPharmacy")) {
			return new PharmacySearchPage(driver);
		} else {
			return null;
		}

	}

}
