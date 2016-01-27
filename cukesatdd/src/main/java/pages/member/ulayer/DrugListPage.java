/**
 * 
 */
package pages.member.ulayer;

import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pperugu
 *
 */
public class DrugListPage extends UhcDriver {
	

	@FindBys(value = { @FindBy(xpath = "//div[@class='drugDropDownList']/div") })
	private List<WebElement> drugListElements;
	
	@FindBy(xpath = "//div[@id='dce.member']/div/div[3]/div/div/div/div[5]/p")
	private WebElement dosagePageText;

	public JSONObject drugListJson;

	private PageData drugList;

	public DrugListPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.DRUG_LIST_PAGE_DATA;
		drugList = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_ULAYER_MEMBER);
		openAndValidate();
	}
	
	public DrugDosagePage selectDrug(String drugName) {

		for (WebElement element : drugListElements) {
			System.out.println(element.getText());
			if (element.getText().equalsIgnoreCase(drugName)) {
				String drugXpath = "//*[contains(text(), '" + drugName + "')]";
				element.findElement(By.xpath(drugXpath)).click();
			}
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (dosagePageText.getText().equalsIgnoreCase("Select dosage:*")) {
			return new DrugDosagePage(driver);
		}
		return null;

	}

	
	@Override
	public void openAndValidate() {

		JSONObject jsonObject = new JSONObject();
		for (String key : drugList.getExpectedData().keySet()) {
			WebElement element = findElement(drugList.getExpectedData().get(
					key));
			if (element != null) {
				validate(element);
				try {
					jsonObject.put(key, element.getText());
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		drugListJson = jsonObject;

	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap,
			String drugInitials) {
		
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject drugListExpectedJson = null;
		try {
			drugListExpectedJson = (JSONObject) expectedDataMap
					.get(CommonConstants.DRUG_LIST).get(drugInitials);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		drugListExpectedJson = CommonUtility.mergeJson(
				drugListExpectedJson, globalExpectedJson);
		return drugListExpectedJson;
	}

}
