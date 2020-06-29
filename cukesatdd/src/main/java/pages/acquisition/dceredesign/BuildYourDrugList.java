package pages.acquisition.dceredesign;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;
import pages.acquisition.ulayer.PageTitleConstants;

public class BuildYourDrugList extends UhcDriver {



	@FindBy(xpath = "//input[contains(@aria-label, 'Drug Name')]")
	public WebElement EnterDrugNameTxt;
	
	@FindBy(xpath = "//button[@id='search']")
	public WebElement searchBtn;

	@FindBy(xpath = "(//button[text()='Select'])[1]")
	public WebElement selectBtn;
	
	@FindBy(xpath = "//button//span[contains(text(),'Add to  drug List')]")
	public WebElement addToDrugList;
	
	@FindBy(xpath = "(//button//span[contains(text(),'Next:Review Drug Costs')])[1]")
	public WebElement reviewDrugCost;
	
	public BuildYourDrugList(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		//openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(EnterDrugNameTxt);
	}

	public void addDrugs(String drugName) {
		EnterDrugNameTxt.sendKeys(drugName);
		searchBtn.click();
		selectBtn.click();
		addToDrugList.click();
		//reviewDrugCost.click();
	}
	
	public void clickReviewDrugCostBtn() {
		reviewDrugCost.click();
	}
}
