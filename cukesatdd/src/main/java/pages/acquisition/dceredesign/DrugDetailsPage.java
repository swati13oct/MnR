package pages.acquisition.dceredesign;
import static org.junit.Assert.fail;

import java.util.List;
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

public class DrugDetailsPage extends UhcDriver {



	@FindBy(xpath = "//a[@id='changePharmacyLink']")
	public WebElement DrugDetails_ChangePharmacyLnk;

	@FindBy(xpath = "//h2[contains(text(), 'Drug Cost Details')]")
	public WebElement DrugDetails_DrugCostsHeading;


	public DrugDetailsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		//CommonUtility.waitForPageLoad(driver, addDrugDetailsPage, 10);
		//openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validateNew(DrugDetails_ChangePharmacyLnk);
		validateNew(DrugDetails_DrugCostsHeading);
	}

	public void validatePlanName(String planName) {

		WebElement PlanNameElement = driver.findElement(By.xpath("//h1[contains(text(), '"+planName+"')]"));
		if(validateNew(PlanNameElement)) {
			Assert.assertTrue("Plan Name is correct for Drug Details Page"+PlanNameElement.getText(), true);
		}
		Assert.fail("Plan Name validation Failed for Drug Details Page");
	}



}
