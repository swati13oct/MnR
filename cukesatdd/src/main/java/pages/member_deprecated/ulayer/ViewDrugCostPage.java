package pages.member_deprecated.ulayer;

/**
 * @author pagarwa5
 *
 */

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class ViewDrugCostPage extends UhcDriver {

	@FindBy(xpath = "//table[@class='viewDrugCost']//td[@class='borderLeft_color druglistedit']/p/a")
	private WebElement editLink;

	

	@FindBy(linkText = "Sign Out")
	private WebElement logOut;

	@FindBy(linkText = "Delete")
	private WebElement deleteLink;
	
	@FindBy(className= "borderLeft drugdosage ng-binding")
	private WebElement descBox;
	


	private PageData viewDrugCost;

	public JSONObject viewDrugCostJson;

	public ViewDrugCostPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		
	
		//openAndValidate();
	}

	public ManageDrugPage editDrugList() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", editLink);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		deleteLink.click();
		System.out.println("Deleted drug from list");
		if (driver.getTitle().equalsIgnoreCase("Drug Lookup")) {
			return new ManageDrugPage(driver);
		} else {
			return null;
		}

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		/* get BENEFITS AND COVERAGE expected data */
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);

		JSONObject viewDrugCostExpectedJson = expectedDataMap
				.get(CommonConstants.VIEW_DRUG_COST);
		viewDrugCostExpectedJson = CommonUtility.mergeJson(
				viewDrugCostExpectedJson, globalExpectedJson);

		return viewDrugCostExpectedJson;

	}

	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : viewDrugCost.getExpectedData().keySet()) {
			WebElement element = findElement(viewDrugCost.getExpectedData()
					.get(key));
			if (null != element && !element.getText().equalsIgnoreCase("")) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
		viewDrugCostJson = jsonObject;
		
		System.out.println("viewDrugCostJson----->"+viewDrugCostJson);

	}

	public void logOut() {
		logOut.click();

	}
	
	public boolean validateViewDrugPage(String dosage) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if((descBox.getText().contains(dosage)))
			return true;
		else 
			return false;
	}
}
