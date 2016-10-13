/**
 * 
 */
package pages.member.bluelayer;

import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.atdd.data.CommonConstants;
import acceptancetests.atdd.data.PageData;
import acceptancetests.atdd.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author pagarwa5
 *
 */
public class BenefitsCoveragePage extends UhcDriver {

	@FindBy(id = "disclosure_link")
	private WebElement logOut;

	private PageData benefitsAndCoverage;

	public JSONObject benefitsAndCoverageJson;

	public BenefitsCoveragePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		String fileName = CommonConstants.BENEFITS_AND_COVERAGE_PDP_NONLIS_NONUS_PAGE_DATA;
		benefitsAndCoverage = CommonUtility.readPageData(fileName,
				CommonConstants.PAGE_OBJECT_DIRECTORY_BLUELAYER_MEMBER);
		openAndValidate();
	}

	public JSONObject getExpectedData(Map<String, JSONObject> expectedDataMap) {

		/* get BENEFITS AND COVERAGE expected data */
		JSONObject globalExpectedJson = expectedDataMap
				.get(CommonConstants.GLOBAL);
		JSONObject commonExpectedJson = expectedDataMap
				.get(CommonConstants.COMMON);
		JSONObject benefitsAndCoverageExpectedJson = expectedDataMap
				.get(CommonConstants.PLAN_BENEFITS_AND_COVERAGE);
		benefitsAndCoverageExpectedJson = CommonUtility.mergeJson(
				benefitsAndCoverageExpectedJson, globalExpectedJson);
		benefitsAndCoverageExpectedJson = CommonUtility.mergeJson(
				benefitsAndCoverageExpectedJson, commonExpectedJson);

		return benefitsAndCoverageExpectedJson;

	}

	@Override
	public void openAndValidate() {
		validate(logOut);

		JSONObject jsonObject = new JSONObject();
		for (String key : benefitsAndCoverage.getExpectedData().keySet()) {
			WebElement element = findElement(benefitsAndCoverage
					.getExpectedData().get(key));
			validate(element);
			try {
				jsonObject.put(key, element.getText());
			} catch (JSONException e) {
				e.printStackTrace();
			}

		}
		benefitsAndCoverageJson = jsonObject;
		
		System.out.println("benefitsAndCoverageJson----->"+benefitsAndCoverageJson);

	}

	public void logOut() {
		logOut.click();

	}

	public void validatesPharmacySaver() {
		driver.navigate().refresh();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean present;
		try {
			driver.findElement(By.id("ATDD_Saver_Widget2016"));
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}

		if(present)
			System.out.println("@@@@@@@@@ Able to find Pharmacy Saver widget @@@@@@@@@");
		else
			System.out.println("@@@@@@@@@ No Pharmacy Saver widget @@@@@@@@@");
		
	}
}
