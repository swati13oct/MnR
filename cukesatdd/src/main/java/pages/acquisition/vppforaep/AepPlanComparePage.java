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

	public boolean compareBenefits(String columnName, String benefitValue, HashMap<String, String> benefitsMap) {
		boolean flag = true; int counter =0;
		
		for(String key : benefitsMap.keySet()) {
			String benefitValueUI = benefitsMap.get(key);
			
			benefitValueUI = benefitValueUI.replace("\n", "").replaceAll("\\s+", "");
			benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", ""); 

			key = key.toLowerCase();
			columnName = columnName.toLowerCase();
			
			if(benefitValueUI.endsWith("footnote2"))
				benefitValueUI = benefitValueUI.replace("footnote2", "");
			else if(benefitValueUI.endsWith("footnote1"))
				benefitValueUI = benefitValueUI.replace("footnote1", "");
			else if(benefitValueUI.endsWith("1"))
				benefitValueUI = 	StringUtils.trimTrailingCharacter(benefitValueUI, '1');
			else if(benefitValueUI.endsWith("2"))
				benefitValueUI = 	StringUtils.trimTrailingCharacter(benefitValueUI, '2');
			else if(benefitValueUI.contains("out-of-networkbenefits"))
				benefitValueUI = benefitValueUI.replace("opensinanewwindow", "");
			
			if(key.endsWith("1"))
				key = 	StringUtils.trimTrailingCharacter(key, '1');
			else if(key.endsWith("2"))
				key = 	StringUtils.trimTrailingCharacter(key, '2');
		
			if((benefitValue.contains("NA")||benefitValue.contains("N/A")||benefitValue.equalsIgnoreCase("No coverage"))) {
				counter++;
				if(columnName.equalsIgnoreCase("Part B Premium Reduction") || columnName.equalsIgnoreCase("Platinum DentalPS") || columnName.equalsIgnoreCase("Optional Dental") ||columnName.equalsIgnoreCase("High Option Dental") ||columnName.equalsIgnoreCase("Footnotes") ||columnName.equalsIgnoreCase("Dental Platinum") ||columnName.equalsIgnoreCase("SilverSneakers") ||columnName.equalsIgnoreCase("Silver SneakersPS") || columnName.equalsIgnoreCase("Optional DentalPS") ||columnName.equalsIgnoreCase("High Option DentalPS")) {
					columnName = columnName.replace("PS","");
					if(key.contains(columnName)) { 
						flag = false;
						break;
					}
				
				}else if(key.equalsIgnoreCase(columnName)) {
						flag= false;
						 break;
					}
			
			}else if(columnName.equalsIgnoreCase("Platinum DentalPS")||columnName.equalsIgnoreCase("Silver SneakersPS") || columnName.equalsIgnoreCase("Optional DentalPS") ||columnName.equalsIgnoreCase("High Option DentalPS")) {
					
					columnName = columnName.replace("ps","");
					if(key.contains("optional rider")&& key.contains(columnName)) {
						counter++;
						if(benefitValueUI.contains(benefitValue)||benefitValueUI.equalsIgnoreCase(benefitValue)) {
							flag = true;
							 break;
						}else {
							flag = false;
							System.out.println("Values did not match for col:PS "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
							break;
						}
				
					}
					columnName = columnName+"PS";
			}else if(columnName.equalsIgnoreCase("Dental Platinum")||columnName.equalsIgnoreCase("Optional Dental")||columnName.equalsIgnoreCase("High Option Dental") || columnName.equalsIgnoreCase("silver sneakers")||columnName.equalsIgnoreCase("Footnotes")||columnName.equalsIgnoreCase("Estimated annual total")) {
			
				
				benefitValueUI = benefitValueUI.replaceAll("\\u2022", "");
				benefitValue = benefitValue.replaceAll("\\u2022", "");
				
				 if(columnName.equalsIgnoreCase("Footnotes")&& key.contains("footnotes")) { 
					key = key.replace("\n", "");
					key = key.replaceAll("\\s+", "").replaceAll("\\*", "");
					counter++;
					//removing footnote values from the string
					if(key.contains("footnotes2") && key.contains("footnotes1")) {
						key = key.replace("footnotes2", "");
						key = key.replace("footnotes1", "");
					}else if(key.contains("footnotes1")) {
						key = key.replace("footnotes1", "");
					}else if(key.contains("footnotes2"))
						key = key.replace("footnotes2", "");
					
					//removing footnote values from the string
					if(key.contains(".2"))
						key = key.replace(".2", ".");
					else if(key.contains(".1"))
						key = key.replace(".1", ".");
						
					//key = key.replaceAll(".", "");
					benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", ""); //.replaceAll("-", "").replaceAll(".", "");
					benefitValue = benefitValue.toLowerCase();
					if(key.contains(benefitValue)) {
						flag = true;break;
					}else {
						flag = false;
						System.out.println("Values did not match for col:2 "+columnName+"\n"+benefitValue+"\n"+key);
						break;
					}
				
				
				}else if(key.contains(columnName)) {
					counter++;
					if(benefitValueUI.contains(benefitValue)||benefitValueUI.equalsIgnoreCase(benefitValue)) {
						flag = true;break;
					}else {
						flag = false;
						System.out.println("Values did not match for col:3 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
						break;
					}
				}
			}else if(columnName.equalsIgnoreCase("Monthly Premium") ||columnName.equalsIgnoreCase("Dental") || columnName.equalsIgnoreCase("Coverage Gap Stage")|| columnName.equalsIgnoreCase("Preferred Retail Pharmacy Network")){
				
				counter++;
				if(key.equalsIgnoreCase("Preferred Retail Pharmacy Network") ) {
					if(benefitValueUI.contains("1."))
						benefitValueUI = benefitValueUI.replace("1.", ".");
				}
					if(key.equalsIgnoreCase(columnName)) {
						 if(benefitValueUI.equalsIgnoreCase(benefitValue)) {
								flag = true;break;
							}else {
								flag = false;
								System.out.println("Values did not match for col:4 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
								break;
							}
					}
				
			
			}else if(key.equalsIgnoreCase(columnName)||key.contains(columnName)) {
						
						counter++;
						//the following code is used to remove the footnote values from the benefit value string. 
						if(benefitValueUI.contains("footnote2") && benefitValueUI.contains("footnote1")) {
							benefitValueUI = benefitValueUI.replace("footnote2", "");
							benefitValueUI = benefitValueUI.replace("footnote1", "");
						}else if(benefitValueUI.contains("footnote2"))
							benefitValueUI = benefitValueUI.replace("footnote2", "");
						else if(benefitValueUI.contains("footnote1"))
							benefitValueUI = benefitValueUI.replace("footnote1", "");
						else if(benefitValueUI.contains("1/"))
							benefitValueUI = benefitValueUI.replaceAll("1/", "");
						else if(benefitValueUI.contains("2/"))
							benefitValueUI = benefitValueUI.replaceAll("2/", "");
						else if(benefitValueUI.contains("/") && !benefitValueUI.contains("Ismydoctor"))
							benefitValueUI = benefitValueUI.replaceAll("/", "");
						
						
						//the following code is only needed for the specific benefit values where we have to remove the footnote values form the end
						if( key.equalsIgnoreCase("Preferred Mail Home Delivery through OptumRx")) {
							 if(benefitValueUI.contains(".2"))
								benefitValueUI = benefitValueUI.replace(".2", ".");
						
						}
								
						 if(benefitValueUI.equalsIgnoreCase(benefitValue)) {
							flag = true;break;
						}else {
							flag = false;
							System.out.println("Values did not match for col:5 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
							break;
						}
			
				}
			}
		

			if(counter == 0)
				flag = false;
		
			return flag;
		
	}
	
	public HashMap<String, String> collectInfoVppPlanComparePg(String planType) {
		
		System.out.println("Proceed to collect the info on vpp compare page =====");
		HashMap<String, String> result=new HashMap<String, String>();

		
		if(planType.contains("MA"))
			planType = "uhc";
		else
			planType = "pdp";

		String rowXpath="//table[contains(@id,'compare-table')]//tbody//tr[contains(@class,'"+planType+"')]";
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
