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

	public HashMap<String, String> collectInfoPREResultsPage(String planName, int planIndex, int planYear,
			String sheetName, int rowIndex) {

		HashMap<String, String> preresult = new HashMap<String, String>();

		preresult = collectInfoPREResultsPage(planName, planIndex);

		return preresult;
	}

public HashMap<String, String> collectInfoPREResultsPage(String planName, int planIndex) {
	
	HashMap<String, String> preResult=new HashMap<String, String>();
    
	//Gather sticky header value for give plan name
	
	String value = formatString(plantiles.get(planIndex).findElement(By.cssSelector("div.premiumValues p.monthlyPremium strong")).getText());
	preResult.put(formatString("Monthly Premium : "), value);
	
	value = formatString(plantiles.get(planIndex).findElement(By.cssSelector("div.premiumValues p[class*='outOfPocket'] strong")).getText());
	preResult.put(formatString("Out-of-Pocket Maximum : "), value);
	
	if(planName.contains("(PDP)"))
	{
		return preResult;
	}
	
	// Additional Serivce
	int additional_Service_Count = 4;
	for(int i=1;i<=additional_Service_Count;i++) {
		String header = formatString(plantiles.get(planIndex).findElement(By.cssSelector("div[class*='additionalServicesContent'] div:nth-child("+String.valueOf(i)+") h4")).getText());
		List<WebElement> data = plantiles.get(planIndex).findElements(By.cssSelector("div[class*='additionalServicesContent'] div:nth-child("+String.valueOf(i)+") ul li"));
		String content = "";
		for(WebElement e:data) {
			content = content + e.getText();
		}
		preResult.put(header,formatString(content));
	}
	
	// Plan Benefits
	int benefits_Count = 5,j=1;
	for(int i=1;i<=benefits_Count;i++) {
		String header = formatString(plantiles.get(planIndex).findElement(By.cssSelector("div[class*='planInfoContent'] div:nth-child("+String.valueOf(j)+")>h4")).getText());
		List<WebElement> data = plantiles.get(planIndex).findElements(By.cssSelector("div[class*='planInfoContent'] div:nth-child("+String.valueOf(j)+")>p"));
		String content = "";
		for(WebElement e:data) {
			content = content + e.getText();
		}
		preResult.put(header,formatString(content));
		j=j+2;//+2 for - empty div tag of new line
	}
    return preResult;
}

	public String formatString(String inp) {
		return inp.toLowerCase()
				.replace("in network", "").replace("out of network", "")
				.replace("in-network", "").replace("out-of-network", "")
				.replace(":", "").replace("  ", "").
				replace("\n", "").replace("\",\"", "").replace("\"", "").replace(",", "").replace("-", "")
				.trim();
	}

	public HashMap<Boolean, String> comparePREBenefits(String columnName, String benefitValue, HashMap<String, String> benefitsMap) {
		boolean flag = true; int counter =0;
		String tmpUIString1 = "",tmpUIString2="",benefitValueUI="";
		HashMap<Boolean, String> comparedResult = new HashMap<Boolean, String>();
		
		for(String key : benefitsMap.keySet()) {
			 benefitValueUI = benefitsMap.get(key);
			tmpUIString1 = benefitValueUI;
			key = key.toLowerCase().trim();
			//key = key.replace(",", "");
			columnName = columnName.toLowerCase().trim();
			if(columnName.contains("%"))
				System.out.println();
			if((benefitValue.contains("NA")||benefitValue.contains("N/A"))) {
				counter++;
				if(key.contains(columnName)) {
						flag= false;
						tmpUIString2 = tmpUIString1;
						break;
				}
				
				
			
			}else if(key.contains(columnName)) {
						counter++;
						benefitValueUI = benefitValueUI.replace("\n", "").replace(" ", "").replaceAll("\\s+", "");
						benefitValue = benefitValue.replace("\n", "").replace(" ", "").replaceAll("\\s+", ""); 
						
						//the following code is used to remove the footnote values from the benefit value string.

						benefitValue = formatString(benefitValue);
						benefitValueUI = formatString(benefitValueUI);
						
						
						/*
						if(key.contains("monthly premium")) {
							if(benefitValueUI.equalsIgnoreCase(benefitValue)) { //if the UI value and the excel value matches
								if(benefitValueUI.equalsIgnoreCase(headerPremiumString)){
										flag = true;break;
								}else if(headerPremiumString == null ) { //for PDP plans this will be null
										flag = true; break;
								}
								else {
										flag = false;
										System.out.println(sheetName+"_"+rowIndex+" - header premium value didn't match with the box for: "+columnName+" Excel: "+headerPremiumString+" | UI: "+benefitValueUI);
										tmpUIString2 = tmpUIString1 +" / Header Value: "+headerPremiumString;
										break;
								}
							
							}else {
								flag = false;
								System.out.println(sheetName+"_"+rowIndex+" - Values did not match for col:1 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
								tmpUIString2 = tmpUIString1+" / Header Value: "+headerPremiumString;
								break;
							}
						}
						else if(key.contains("primary care physician")||key.contains("specialist")||key.contains("out of pocket")) {
							if(benefitValueUI.equalsIgnoreCase(benefitValue)) {
								flag = true;break;
							}else {
								flag = false;
								System.out.println(sheetName+"_"+rowIndex+" - Values did not match for col:2 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
								tmpUIString2 = tmpUIString1;
								break;
							}
									
						}
						else 
						*/	
							
					if(benefitValueUI.contains(benefitValue)||benefitValueUI.equalsIgnoreCase(benefitValue)) {
							flag = true;break;
						}else {
							flag = false;
							System.out.println(sheetName+"_"+rowIndex+" - Values did not match for col:3 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
							tmpUIString2 = tmpUIString1;
							break;
						}
					
				}else if(columnName.contains(key)) {
					counter++;
					columnName= columnName.replace("\n", "").replaceAll("\\s+", "");
					key = key.replace("\n", "").replaceAll("\\s+", "");
					if(benefitValueUI.equalsIgnoreCase(benefitValue)) {
						flag = true;break;
					}else {
						flag = false;
						System.out.println(sheetName+"_"+rowIndex+" - Values did not match for col:4 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
						tmpUIString2 = tmpUIString1;
						break;
					}
							
				}
			}
		
		
		
		if(counter == 0) {
			flag = false;
			System.out.println(sheetName+"_"+rowIndex+" - Values did not match for col:4 "+columnName+" Excel: "+benefitValue+" | UI: BENEFIT NOT FOUND");
			tmpUIString2 = "BENEFIT NOT FOUND ON THE UI";
		}
		
		comparedResult.put(flag, tmpUIString2);
		return comparedResult;
		
	}
	
}
