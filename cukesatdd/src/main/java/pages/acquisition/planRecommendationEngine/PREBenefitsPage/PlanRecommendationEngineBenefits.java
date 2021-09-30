/**
* 
 */
package pages.acquisition.planRecommendationEngine.PREBenefitsPage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.html5.SessionStorage;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

public class PlanRecommendationEngineBenefits extends UhcDriver {

	public PlanRecommendationEngineBenefits(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public void openAndValidate() throws InterruptedException {
	}

	// Result Page Elements

	@FindBy(css = "body>div#overlay")
	private WebElement planLoaderscreen;

	@FindBy(css = "li.planTileGrid")
	private List<WebElement> plantiles;

	@FindBy(css = "#recommendSort option")
	private List<WebElement> sortByOptions;

	String sampleJson = "{\"preferences\":[{\"questionId\":\"planType\",\"answers\":[{\"id\":\"co_ma\"}]},{\"questionId\":\"snpType\",\"answers\":[{\"id\":\"snp_none\"}]},{\"questionId\":\"doctorPref\",\"answers\":[{\"id\":\"doctor_accepts_medicare\"}]},{\"questionId\":\"additional-dental\",\"answers\":[{\"id\":\"as_dental_no\"}]},{\"questionId\":\"additional-hearing\",\"answers\":[{\"id\":\"as_hearing_no\"}]},{\"questionId\":\"additional-vision\",\"answers\":[{\"id\":\"as_vision_no\"}]},{\"questionId\":\"additional-fitness membership\",\"answers\":[{\"id\":\"as_fitness_no\"}]},{\"questionId\":\"healthCarePref\",\"answers\":[{\"id\":\"cs_low\"}]}],\"planYear\":2021,\"location\":{\"zipcode\":\"10001\",\"selectedCounty\":{\"fipsCountyCode\":\"061\",\"fipsCountyName\":\"New York County\",\"fipsStateCode\":\"36\",\"stateCode\":\"NY\",\"cmsCountyCodes\":[\"420\"]}}}";

	public void poc() {
		System.out.println("Doing POC.....");
		String StorageKey = "ucp_planRecommendationObj", value = sampleJson;
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		threadsleep(5000);
		try {
			js.executeScript(String.format("window.sessionStorage.setItem('%s','%s');", StorageKey, value));
		} catch (Exception e1) {
			System.out.println("data");
		}

	}

	String sheetName = "";
	int rowIndex;

	public HashMap<String, String> collectInfoPREResultsPage(String zip, String planName, int planIndex, int planYear,
			String sheetName, int rowIndex) {

		HashMap<String, String> preresult = new HashMap<String, String>();

		preresult = collectInfoPREResultsPage(zip, planName, planIndex);

		return preresult;
	}

	public HashMap<String, String> collectInfoPREResultsPage(String zip, String planName, int planIndex) {

		HashMap<String, String> preResult = new HashMap<String, String>();

		// Gather sticky header value for give plan name

		String value = formatString(plantiles.get(planIndex)
				.findElement(By.cssSelector("div.premiumValues p.monthlyPremium strong")).getText());
		preResult.put(formatString("Monthly Premium : "), value);

		if (planName.contains("(PDP)")) {
			return preResult;
		}

		value = formatString(plantiles.get(planIndex)
				.findElement(By.cssSelector("div.premiumValues p[class*='outOfPocket'] strong")).getText());
		preResult.put(formatString("Out-of-Pocket Maximum : "), value);

		if (zip.contains("88042") && planName.contains("Medicare Supplement Insurance Plan")) {
			// No Additional service for this state
		} else {
			// Additional Serivce
			int additional_Service_Count = 4;
			for (int i = 1; i <= additional_Service_Count; i++) {
				String header = formatString(plantiles.get(planIndex)
						.findElement(By.cssSelector(
								"div[class*='additionalServicesContent'] div:nth-child(" + String.valueOf(i) + ") h4"))
						.getText());
				List<WebElement> data = plantiles.get(planIndex).findElements(By.cssSelector(
						"div[class*='additionalServicesContent'] div:nth-child(" + String.valueOf(i) + ") ul li"));
				String content = "";
				for (WebElement e : data) {
					content = content + e.getText();
				}
				preResult.put(header, formatString(content));
			}
		}

		// Plan Benefits
		int provider_max_benefits_Count = 3, j = 1;
		for (int i = 1; i <= provider_max_benefits_Count; i++) {

			if (i == 3 && planName.toLowerCase().contains("medicare supplement insurance plan"))
				break;

			String header = formatString(plantiles.get(planIndex)
					.findElement(
							By.cssSelector("div[class*='planInfoContent'] div[class*='provider-section'] div:nth-child("
									+ String.valueOf(j) + ")>h4"))
					.getText());
			List<WebElement> data = plantiles.get(planIndex).findElements(
					By.cssSelector("div[class*='planInfoContent'] div[class*='provider-section'] div:nth-child("
							+ String.valueOf(j) + ")>p"));
			String content = "";
			for (WebElement e : data) {
				content = content + e.getText();
			}
			preResult.put(header, formatString(content));
			j = j + 2;// +2 for - empty div tag of new line
		}

		String header = formatString(plantiles.get(planIndex)
				.findElement(By.cssSelector("div[class*='planInfoContent'] div[class*='referral-content']>h4"))
				.getText());
		String content = plantiles.get(planIndex)
				.findElement(By.cssSelector("div[class*='planInfoContent'] div[class*='referral-content']>p"))
				.getText();
		preResult.put(header, formatString(content));

		header = formatString(plantiles.get(planIndex)
				.findElement(By.cssSelector("div[class*='planInfoContent'] div[class*='inpatient-hospital']>h4"))
				.getText());
		List<WebElement> data = plantiles.get(planIndex)
				.findElements(By.cssSelector("div[class*='planInfoContent'] div[class*='inpatient-hospital']>p"));
		content = "";
		for (WebElement e : data) {
			content = content + e.getText();
		}
		preResult.put(header, formatString(content));

		return preResult;
	}

	public String formatString(String inp) {
		return inp.toLowerCase().replace("in network", "").replace("out of network", "").replace("in-network", "")
				.replace("out-of-network", "").replace(":", "").replace("  ", "").replace("\n", "").replace("\",\"", "")
				.replace("\"", "").replace(",", "").replace("-", "").trim();
	}

	public HashMap<Boolean, String> comparePREBenefits(String columnName, String benefitValue,
			HashMap<String, String> benefitsMap) {
		boolean flag = true;
		int counter = 0;
		String tmpUIString1 = "", tmpUIString2 = "", benefitValueUI = "";
		HashMap<Boolean, String> comparedResult = new HashMap<Boolean, String>();

		for (String key : benefitsMap.keySet()) {
			benefitValueUI = benefitsMap.get(key);
			tmpUIString1 = benefitValueUI;
			key = key.toLowerCase().trim();
			// key = key.replace(",", "");
			columnName = columnName.toLowerCase().trim();
			if (columnName.contains("%"))
				System.out.println();
			if ((benefitValue.contains("NA"))) {
				counter++;
				if (key.contains(columnName)) {
					flag = false;
					tmpUIString2 = tmpUIString1;
					break;
				}
			} else if (key.contains(columnName) || columnName.contains(key)) {
				counter++;
				benefitValueUI = benefitValueUI.replace("\n", "").replace(" ", "").replaceAll("\\s+", "");
				benefitValue = benefitValue.replace("\n", "").replace(" ", "").replaceAll("\\s+", "");

				benefitValue = formatString(benefitValue);
				benefitValueUI = formatString(benefitValueUI);

				System.out.println("Comparing :" + benefitValueUI + " with" + benefitValue);
				if (benefitValueUI.contains(benefitValue) || benefitValueUI.equalsIgnoreCase(benefitValue)) {
					flag = true;
					break;
				} else {
					flag = false;
					System.out.println(sheetName + "_" + rowIndex + " - Values did not match for col " + columnName
							+ " Excel: " + benefitValue + " | UI: " + benefitValueUI);
					tmpUIString2 = tmpUIString1;
					break;
				}
			}
		}
		if (counter == 0) {
			flag = false;
			System.out.println(sheetName + "_" + rowIndex + " - Values did not match for col:4 " + columnName
					+ " Excel: " + benefitValue + " | UI: BENEFIT NOT FOUND");
			tmpUIString2 = "BENEFIT NOT FOUND ON THE UI";
		}
		comparedResult.put(flag, tmpUIString2);
		return comparedResult;
	}
}
