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

			if((benefitValue.contains("NA")||benefitValue.contains("N/A")||benefitValue.equalsIgnoreCase("No coverage"))) {
				counter++;
				//if(key.contains(columnName)) {
				flag= true;break;
				//	}

			}else if(key.contains(columnName)) {
				counter++;
				benefitValueUI = benefitValueUI.replace("\n", "").replaceAll("\\s+", "").replace(":","");
				benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", "").replace(":","");

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
	
	public HashMap<String, String> collectInfoVppPlanComparePg() {
		
		System.out.println("Proceed to collect the info on vpp compare page =====");
		HashMap<String, String> result=new HashMap<String, String>();

		
//		if(planType.contains("MA"))
//			planType = "uhc";
//		else
//			planType = "pdp";

		String rowXpath="//table[contains(@id,'compare-table')]//tbody//tr[contains(@class,'uhc')]";
		List<WebElement> listOfRowsInPlanCompareTbl = driver.findElements(By.xpath(rowXpath));
		
		for (int i=1; i<=listOfRowsInPlanCompareTbl.size(); i++) {
			
			String key = "";
			String value = "";
			String headerCellXpath = "//table[contains(@id,'compare-table')]//tbody//tr[contains(@class,'uhc')]["+i+"]//th";
			String planCellXpath = "//table[contains(@id,'compare-table')]//tbody//tr[contains(@class,'uhc')]["+i+"]//td";
			
			List<WebElement> headerCellXpathList = driver.findElements(By.xpath(headerCellXpath));
			List<WebElement> planCellXpathList = driver.findElements(By.xpath(planCellXpath));
			
			if(headerCellXpathList.size()!=0) {
				key = headerCellXpathList.get(0).getText();
			}
			
			if(planCellXpathList.size()!=0) {
				String cellXpath = planCellXpath+"[1]";
				WebElement e=driver.findElement(By.xpath(cellXpath));
				value = e.getText();
			}
			
			result.put(key, value);
			
			
		}
		System.out.println("Finished collecting the info on vpp compare page =====");
		
		  for(String keyValue : result.keySet()) {
		  System.out.println("Key : "+keyValue+" Value: "+result.get(keyValue));
		  System.out.println(
		  "_________________________________________________________________________________________________"
		  ); }
		return result;
	}
	


	
}
