/**
 * 
 */
package pages.drx;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class DrugSearchPage extends UhcDriver {

	@FindBy(id = "drugSearchField")
	private WebElement drugSearchField;

	@FindBy(id = "drugSearchBtn")
	private WebElement drugSearchBtn;

	@FindBy(id = "drugResults")
	private WebElement drugResultsTable;

	public JSONObject drugSearchJson;

	private PageData drugSearched;

	public DrugSearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.DRUG_SEARCH_PAGE_DATA;
		drugSearched = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_DRX);

		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		validate(drugSearchBtn);

	}

	public void enterDrugInitials(String drugInitials) {
		sendkeys(drugSearchField, drugInitials);
		drugSearchBtn.click();
		CommonUtility.waitForPageLoad(driver, drugResultsTable,
				CommonConstants.TIMEOUT_40);
		JSONObject jsonObject = new JSONObject();
		JSONArray jsonArray = new JSONArray();
		for (String key : drugSearched.getExpectedData().keySet()) {
			WebElement element = findElement(drugSearched.getExpectedData()
					.get(key));
			validate(element);
			try {

				List<WebElement> drugResultsRows = element.findElements(By
						.tagName("tr"));

				for (WebElement druglist : drugResultsRows) {
					JSONObject drugJsonObject = new JSONObject();
					List<WebElement> cells = druglist.findElements(By
							.tagName("td"));
					drugJsonObject.put("drugName", cells.get(0).getText());
					drugJsonObject.put("drugType", cells.get(1).getText());
					drugJsonObject.put("addDrugLink", cells.get(2).getText());
					jsonArray.put(drugJsonObject);
				}

				jsonObject.put(key, jsonArray);
			} catch (JSONException e) {
				System.out.println();
			}

		}
		drugSearchJson = jsonObject;
		System.out.println("drugSearchJson------>" + drugSearchJson);
	}

	public JSONObject getExpectedData(String fileName, String directory) {
		JSONObject drugsAddedExpectedJson = MRScenario.readExpectedJson(
				fileName, directory);
		return drugsAddedExpectedJson;
	}

}
