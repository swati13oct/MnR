/**
 * 
 */
package pages.acquisition.vppforaep;


import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.springframework.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import atdd.framework.UhcDriver;
import pages.acquisition.dce.DrugCostEstimatorPage;
import pages.acquisition.ole.WelcomePage;
import acceptancetests.data.CommonConstants;
import acceptancetests.data.MRConstants;
import acceptancetests.data.PageData;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;


/**
 * @author gumeshna
 *
 */
public class AepPlanComparePage extends UhcDriver {

	@FindBy(xpath="//div[contains(@class,'zipcodePrint')]")
	private WebElement cmpPgHeader;
	
	@FindBy(xpath="//div[@id='topRowCopy']//div[@ng-repeat='i in count']")
	private List<WebElement> listOfCmpPlansColumns;
	

	public AepPlanComparePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();
	}

	@Override
	public void openAndValidate() {
		

	}

	public HashMap<Boolean, String> compareBenefits(String columnName, String benefitValue, HashMap<String, String> benefitsMap) {
		boolean flag = true; int counter =0;
		String tmpUIString1 = "",tmpUIString2="",benefitValueUI="";
		HashMap<Boolean, String> comparedResult = new HashMap<Boolean, String>();
		for(String key : benefitsMap.keySet()) {
			benefitValueUI = benefitsMap.get(key);
			tmpUIString1 = benefitValueUI;
			key = key.toLowerCase();
			key = key.replace(":", "");
			columnName = columnName.toLowerCase();
			if(columnName.contains("tier"))
				System.out.println();

			benefitValue = benefitValue.trim();

			if((benefitValue.contains("NA")||benefitValue.contains("N/A")||benefitValue.equalsIgnoreCase("No coverage"))) {
				counter++;
				//if(key.contains(columnName)) {
				flag= true;break;
				//	}

			}else if(key.trim().equals(columnName.trim())) {
				counter++;
				benefitValueUI = benefitValueUI.replace("\n", "").replaceAll("\\s+", "").replace(":","").replace(",","");
				benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", "").replace(":","").replace(",","");

				//the following code is used to remove the footnote values from the benefit value string.

				if(benefitValueUI.contains(benefitValue)||benefitValueUI.equalsIgnoreCase(benefitValue)) {
					flag = true;break;
				}else {
					flag = false;
					System.out.println("Values did not match for col:1 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
					tmpUIString2 = tmpUIString1;
					break;
				}

			}
		}

		if(counter == 0) {
			flag = false;
			System.out.println("Values did not match for col:2 "+columnName+" Excel: "+benefitValue+" | UI: BENEFIT NOT FOUND");
			tmpUIString2 = "BENEFIT NOT FOUND ON THE UI";
		}

		comparedResult.put(flag, tmpUIString2);
		return comparedResult;
		
	}


	public HashMap<String, String> collectInfoVppPlanComparePg(String planType, String network) {

		System.out.println("Proceed to collect the info on vpp compare page =====");
		HashMap<String, String> result=new HashMap<String, String>();

		//Read Plan Summary table
		result.putAll(readBenefitsData("plan-summary-table", planType.equals("PDP") ? "" : "PC"));

		//Read prescription Drug Benefits and PlanCosts table
		result.putAll(readBenefitsData("prescription-drug-table", ""));
		result.putAll(readBenefitsData("plan-costs-table", ""));

		if(planType.startsWith("MA")) {

			//Read INN Benefits data
			result.putAll(readBenefitsData("medical-benefits-table", ""));
			result.putAll(readBenefitsData("additional-benefits-table", ""));

			//Read Optional Services (Riders) data
			result.putAll(readBenefitsData("optional-services-table",""));

			//Read OON Benefits data
			if(network.trim().startsWith("OON")) {
				WebElement medicareBenefitsSlider = driver.findElement(By.id("medicareBenefitsSlider"));
				WebElement additionalBenefitsStartSlider = driver.findElement(By.id("additionalBenefitsStartSlider"));

				if (medicareBenefitsSlider != null && medicareBenefitsSlider.isDisplayed()) {
					jsClickNew(medicareBenefitsSlider);
					if (medicareBenefitsSlider.getAttribute("aria-checked").equals("true")) {
						result.putAll(readBenefitsData("medical-benefits-table", "OON"));
					}
				}

				if (additionalBenefitsStartSlider != null && additionalBenefitsStartSlider.isDisplayed()) {
					jsClickNew(additionalBenefitsStartSlider);
					if (additionalBenefitsStartSlider.getAttribute("aria-checked").equals("true")) {
						result.putAll(readBenefitsData("additional-benefits-table", "OON"));
					}
				}
			}

		}
		System.out.println("Finished collecting the info on vpp compare page =====");
		return result;
	}

	//This method reads the benefit table values on UI into a HashMap as key value pairs
	//tableId - Id attribute of the benefit table
	//keyword - this is a parameter passed to generate the key name matching with that of the excel header name to distinguish between PC,INN and OON
	private HashMap<String, String> readBenefitsData(String tableId, String keyword) {


		HashMap<String, String> result=new HashMap<String, String>();

		String rowXpath="//table[contains(@id,'"+tableId+"')]//tbody//tr[contains(@class,'uhc')]";
		List<WebElement> listOfRowsInPlanCompareTbl = driver.findElements(By.xpath(rowXpath));

		if(listOfRowsInPlanCompareTbl == null || listOfRowsInPlanCompareTbl.size() == 0)
		{
			return result;
		}

		for (int i=0; i<listOfRowsInPlanCompareTbl.size(); i++) {

			try{

				String key = "";
				String value = "";

				List<WebElement> headerCellXpathList = (listOfRowsInPlanCompareTbl.get(i).findElements(By.tagName("th")));
				List<WebElement> planCellXpathList = (listOfRowsInPlanCompareTbl.get(i).findElements(By.tagName("td")));

				if(headerCellXpathList.size()!=0) {
					key = headerCellXpathList.get(0).getText();
				}

				if(planCellXpathList.size()!=0) {
					value = planCellXpathList.get(0).getText();
				}

				result.put(key+keyword, value);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}


		}


		for(String keyValue : result.keySet()) {
			System.out.println("Table : "+tableId +" | Key : "+keyValue+"\t| Value: "+result.get(keyValue));
			System.out.println(
					"_________________________________________________________________________________________________"
			); }
		return result;
	}

	//Format Plan compare cell value before validating against plan detail (to avoid making changes to PlanDetail compareBenefits method)
	public String formatCellValueForPlanDetail(String currentColName, String currentCellValue) {

		String formatedCellValue = currentCellValue;

		if(currentColName.equalsIgnoreCase("Dental") && currentCellValue.startsWith("Prescription"))
		{
			formatedCellValue = currentCellValue + "Ismydentistcoveredforthisplan?";
		}

		if(currentColName.startsWith("Tier"))
		{
			formatedCellValue = currentCellValue.replace(":","");
		}

		return  formatedCellValue;
	}
}
