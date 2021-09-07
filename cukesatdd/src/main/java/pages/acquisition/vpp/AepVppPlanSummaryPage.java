/**
 * 
 */
package pages.acquisition.vpp;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import acceptancetests.util.CommonUtility;
import atdd.framework.UhcDriver;

/**
 * @author 
 *
 */
public class AepVppPlanSummaryPage extends UhcDriver {

	@FindBy(xpath="//*[(text()='Welcome to Online Enrollment')]")
	private WebElement welcomePageHeader;

	@FindBy(xpath="//label[contains(@for, 'currentYear')]")
	private WebElement CurrentYearLink;

	@FindBy(xpath="//label[contains(@for, 'futureYear')]")
	private WebElement NextYearLink;

	@FindBy(xpath = "//*[contains(@id,'change-location')]")
	private WebElement zipcodeChangeLink;
	
	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[1]//span[@class='ng-binding']")
	private WebElement maPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[2]//span[@class='ng-binding']")
	private WebElement msPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[3]//span[@class='ng-binding']")
	private WebElement pdpPlansCount;

	@FindBy(xpath = "//div[contains(@class,'overview-tabs module-tabs-tabs')]/div[4]//span[@class='ng-binding']")
	private WebElement snpPlansCount;
	
	@FindBy(xpath = "//*[contains(@class,'popup-modal active')]")
	private WebElement countyModal;

	@FindBy(xpath = "//div[@class='overview-main']//h2")
	private WebElement vppTop;

	@FindBy(xpath = "//*[contains(@class,'module-tabs-tabs')]/*[not (contains(@class,'active'))]//*[contains(@id,'pdpviewplans')]/following-sibling::*[contains(@aria-label,'View Plans')]")
	private WebElement pdpPlansViewLink;
	
	@FindBy(xpath = "//div[contains(@class,'module-tabs-tabs')]/div[not (contains(@class,'active'))]//span[@id='maviewplans']/following-sibling::a")
	private WebElement maPlansViewLink;

	@FindBy(xpath = "//*[contains(@class,'module-tabs-tabs')]/*[not (contains(@class,'active'))]//*[contains(@dtmname,'SNP')]/following-sibling::a")
	private WebElement snpPlansViewLink;
	
	@FindBy(xpath = "//div[contains(@id,'plan-list-') and not(contains(@class,'ng-hide'))]/div[contains(@class,'plan-list-content')]")
	private WebElement planListContainer;
	
	@FindBy(xpath = "//*[contains(@class,'plan-detail-table')]")
	private WebElement lisPlanTable;
	
	@FindBy(xpath = "//*[not(contains(@class,'ng-hide')) and contains(text(), 'Enroll in plan')]")
	private WebElement EnrollinPlan_PlanDetails;
	
	
	String sheetName = "";
	int rowIndex;

	public AepVppPlanSummaryPage(WebDriver driver) {
		super(driver);
		
		PageFactory.initElements(driver, this);
			openAndValidate();
	}

	public AepVppPlanSummaryPage(WebDriver driver, String planType) {
		super(driver);
		PageFactory.initElements(driver, this);
		openAndValidate();

	}

	@Override
	public void openAndValidate() {
		validate(CurrentYearLink);
		validate(zipcodeChangeLink,30);
	}
	
	

	public boolean Validate_preAEP_NextYearPlanSummary(String planName) {
		List <WebElement> EnrollBtns = driver.findElements(By.xpath("//*[contains(text(), 'Enroll in plan')]"));
		boolean validation_Flag = true;
		WebElement EnrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Enroll in')]"));
		if(EnrollForPlan.isDisplayed()){
			validation_Flag=false;
			System.out.println("Found Enroll IN Plan Button for the Plan : "+planName);
		}
		for(WebElement Currentenrollbtn : EnrollBtns){
			if(Currentenrollbtn.isDisplayed()){
				validation_Flag=false;
				System.out.println("Enroll button is dispalyed for Next year plan summary page for pre-aep");
			}
		}
		return validation_Flag;
	}
	
	public AepPlanDetailsPage navigateToPlanDetails(String planName, String planType) {
		driver.manage().window().maximize();
	
		if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {	
		WebElement MAmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//a[contains(text(),'View plan and drug coverage details')][1]"));
			validate(MAmoreDetailsLink);
			MAmoreDetailsLink.click();
			System.out.println("View Plan Details Link is clicked for MA plan"+planName);


		} else if (planType.equalsIgnoreCase("PDP")) {
			WebElement PDPmoreDetailsLink = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[@id = 'viewmoredetlinkpdp']"));
			validate(PDPmoreDetailsLink);
			PDPmoreDetailsLink.click();
			System.out.println("View Plan Details Link is clicked for PDP plan"+planName);
			
		}
		
		CommonUtility.checkPageIsReady(driver);
		if (driver.getCurrentUrl().contains("#/details")) {	
			return new AepPlanDetailsPage(driver);
		}
		return null;
	}

	public boolean Validate_preAEP_AEP_CurrentYearPlanSummary(String planName) {
		List <WebElement> EnrollBtns = driver.findElements(By.xpath("//*[contains(text(), 'Enroll in plan')]"));
		boolean validation_Flag = true;
		WebElement EnrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Enroll in')]"));
		if(EnrollForPlan.isDisplayed()){
			System.out.println("Found Enroll IN Plan Button for the Plan : "+planName);
		}
		else{
			System.out.println("Enroll IN Plan Button is Not Displayed for the Plan : "+planName);

			validation_Flag=false;
		}
		int count=0;
		for(WebElement Currentenrollbtn : EnrollBtns){
			if(Currentenrollbtn.isDisplayed()){
				count++;
			}
		}
		if(count==0){
			System.out.println("Enroll buttons are Not dispalyed for Current year plan summary page for pre-aep");
			validation_Flag=false;

		}
		return validation_Flag;
	}

	public void ClickCurrentYearLink() {
		if(validate(CurrentYearLink)){
			CurrentYearLink.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean Validate_AEP_NextYearPlanSummary(String planName) {
		List <WebElement> EnrollBtns = driver.findElements(By.xpath("//*[contains(text(), 'Enroll in plan')]"));
		boolean validation_Flag = true;
		WebElement EnrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Enroll in')]"));
		if(EnrollForPlan.isDisplayed()){
			System.out.println("Found Enroll IN Plan Button for the Plan : "+planName);
		}
		else{
			System.out.println("Enroll IN Plan Button is Not Displayed for the Plan : "+planName);

			validation_Flag=false;
		}
		int count=0;
		for(WebElement Currentenrollbtn : EnrollBtns){
			if(Currentenrollbtn.isDisplayed()){
				count++;
			}
		}
		if(count==0){
			System.out.println("Enroll buttons are Not dispalyed for Next year plan summary page for AEP Enrollment Period");
			validation_Flag=false;

		}
		return validation_Flag;
	}

	public boolean Validate_PostAEP_AEP_CurrentYearPlanSummary(String planName) {
		List <WebElement> EnrollBtns = driver.findElements(By.xpath("//*[contains(text(), 'Enroll in plan')]"));
		boolean validation_Flag = true;
		WebElement EnrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '"+planName+"')]/ancestor::div[@class='module-plan-overview module swiper-slide ng-scope']//*[contains(text(), 'Enroll in')]"));
		if(EnrollForPlan.isDisplayed()){
			validation_Flag=false;
			System.out.println("Found Enroll IN Plan Button for the Plan : "+planName);
		}
		for(WebElement Currentenrollbtn : EnrollBtns){
			if(Currentenrollbtn.isDisplayed()){
				validation_Flag=false;
				System.out.println("Enroll button is dispalyed for Current year plan summary page for No Enrollment Allowed Period for Current Year");
			}
		}
		return validation_Flag;
	}

	public HashMap<String, String> collectInfoVppPlanSummaryPg(String planName) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);  
		System.out.println(sheetName+"_"+rowIndex+" - Proceed to collect the plan benefits info on vpp summary page");

		HashMap<String, String> result=new HashMap<String, String>();
		String planCard = "//*[contains(text(), '"+planName+"') and contains(@class,'ng-binding')]/ancestor::*[contains(@class,'module-plan-overview module')]";
		System.out.println("Plan card xpath : "+ planCard);
		String rowXpath = "";
		String headerPremiumXpath = planCard+"//*[contains(@class,'monthly-cost')]";
		String headerPrem = "header premium"; //this variable will be stored as key for the header premium
		String headerPremiumText = "Header not found";
		String learnMoreLink = "";
		if(planName.contains("PDP"))
			learnMoreLink = planCard + "//span[contains(@ng-if,'!= 0')]//*[contains(@ng-click,'lispopup')]";
		else
			learnMoreLink = planCard + "//*[contains(@ng-click,'lispopup')]";
		
		List<WebElement> learnMoreAboutLink = driver.findElements(By.xpath(learnMoreLink));
		
		if(planName.contains("PDP"))
			rowXpath = planCard+"//*[contains(@class,'pdpbenefittable')]//ul//li";
		else {
			rowXpath = planCard+"//ul[contains(@class,'benefits-table')]//li";
			List<WebElement> headerPremium = driver.findElements(By.xpath(headerPremiumXpath));
			if(headerPremium.size()!=0) {
				 headerPremiumText = headerPremium.get(0).getText(); //this variable will be stored as value for the header premium value
				
			}
			result.put(headerPrem, headerPremiumText);
		}
		List<WebElement> listOfRowsPerTable=driver.findElements(By.xpath(rowXpath));
		
		String key = "";
		
		
		
		for(int rowIndex=1; rowIndex<=listOfRowsPerTable.size(); rowIndex++) { //note: loop through each row
			String cellsXpath="",benefitValueXpath ="";
			String value = "",rowText ="" ,benefitValueText = "";
			
			 cellsXpath = rowXpath+"["+rowIndex+"]"; //index xpath for each row in the table
			benefitValueXpath = cellsXpath + "//*[contains(@class,'float-right')]";// xpath for the benefit value for the cell
			 
			 // the below code gets the benefit name from the table before the : symbol
			 WebElement e=driver.findElement(By.xpath(cellsXpath));
			 rowText = e.getText();
			 String [] parts = rowText.split(":");
			 key = parts[0];
			 
			 //the below code gets the benefit value from the table after the : symbol
			 List <WebElement> j = driver.findElements(By.xpath(benefitValueXpath));
			 if(j.size()!=0)
				 benefitValueText = j.get(0).getText();
			 
			 /*for (int i = 1; i < parts.length; i++) {
				 value = value + parts[i]; 
			 }*/
			 value = benefitValueText;
			 
			 
			 result.put(key, value);
			 
		}
		
		if(learnMoreAboutLink.size()!= 0) {
			String value = "";
			jsClickNew(learnMoreAboutLink.get(0));
			validateNew(lisPlanTable);
			for(int i =2; i<=5;i++) {
				WebElement lisValueFirstCol = driver.findElement(By.xpath("//*[contains(@class,'plan-detail-table')]//tr["+i+"]//td[1]"));
				WebElement lisValueSecondCol = driver.findElement(By.xpath("//*[contains(@class,'plan-detail-table')]//tr["+i+"]//td[2]"));

				key = lisValueFirstCol.getText();
				value = lisValueSecondCol.getText();
				result.put(key, value);
				
			}
		}
		
		//commenting the below lines of coe to reduce the log on Jenkins job
		
		for(String keyValue : result.keySet()) {
			  System.out.println("Key : "+keyValue+" Value: "+result.get(keyValue));
			  System.out.println("_________________________________________________________________________________________________");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println(sheetName+"_"+rowIndex+" - Finished to collect the plan benefits info on vpp summary page - Benefits Map count - " + result.size());
		return result;
	}

    public HashMap<String, String> collectInfoVppPlanSummaryPg(String planName, String countyName, String planYear, String sheetName, int rowIndex) {
		this.sheetName = sheetName;
		this.rowIndex = rowIndex;

        HashMap<String, String> result=new HashMap<String, String>();
        int minBenefitListCnt = 5;

        if(planName.contains("(PDP)"))
		{
			minBenefitListCnt = 2;
		}

        for(int i=0;i<5;i++)
        {
            checkForMultiCountyPopup(countyName);
            selectYearOption(planYear);
            result = collectInfoVppPlanSummaryPg(planName);
            int benefitUICnt = result.size();
            System.out.println(sheetName+"_"+rowIndex+" - Attempt - "+(i+1)+", Benefits Map count - " + benefitUICnt +", Plan - "+planName);
            if(benefitUICnt < minBenefitListCnt )
            {
                driver.navigate().refresh();
                System.out.println(sheetName+"_"+rowIndex+" - Attempt - "+(i+1)+", Page Refreshed");
                continue;
            }
            else
            {
                return result;
            }
        }

        return result;
    }
	
	public HashMap<Boolean, String> compareBenefits(String columnName, String benefitValue, HashMap<String, String> benefitsMap) {
		boolean flag = true; int counter =0;
		String tmpUIString1 = "",tmpUIString2="",benefitValueUI="", headerPremiumString="";
		HashMap<Boolean, String> comparedResult = new HashMap<Boolean, String>();
		headerPremiumString = benefitsMap.get("header premium"); //gets the value for the header premium that was stored from the UI
		
		if(headerPremiumString!=null) //the header monthly premium value is not there for PDP plans so in case of PDP plans this value will be null
			headerPremiumString = headerPremiumString.replace("\n", "").replaceAll("\\s+", ""); //removing spaces and next lines if any
		
		for(String key : benefitsMap.keySet()) {
			 benefitValueUI = benefitsMap.get(key);
			tmpUIString1 = benefitValueUI;
			key = key.toLowerCase().trim();
			//key = key.replace(",", "");
			columnName = columnName.toLowerCase().trim();
			if(key.contains("%"))
				key = key.replaceAll("\\s+", "");
			if(columnName.contains("%"))
				columnName = columnName.replaceAll("\\s+", "");
			if((benefitValue.contains("NA")||benefitValue.contains("N/A"))) {
				counter++;
				if(key.contains(columnName)) {
						flag= false;
						tmpUIString2 = tmpUIString1;
						break;
				}
				
				
			
			}else if(key.contains(columnName)) {
						counter++;
						benefitValueUI = benefitValueUI.replace("\n", "").replaceAll("\\s+", "");
						benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", ""); 
						
						//the following code is used to remove the footnote values from the benefit value string.

						benefitValue = benefitValue.trim();
						benefitValueUI = benefitValueUI.trim();
						
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
						else if(benefitValueUI.contains(benefitValue)||benefitValueUI.equalsIgnoreCase(benefitValue)) {
							flag = true;break;
						}else {
							flag = false;
							System.out.println(sheetName+"_"+rowIndex+" - Values did not match for col:3 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
							tmpUIString2 = tmpUIString1;
							break;
						}
					
				}else if(columnName.contains(key)) {
					counter++;
					benefitValueUI = benefitValueUI.replaceAll("\\s+", "");
					benefitValue = benefitValue.replaceAll("\\s+", "");
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
			System.out.println(sheetName+"_"+rowIndex+" - Values did not match for col:5 "+columnName+" Excel: "+benefitValue+" | UI: BENEFIT NOT FOUND");
			tmpUIString2 = "BENEFIT NOT FOUND ON THE UI";
		}
		
		comparedResult.put(flag, tmpUIString2);
		return comparedResult;
		
	}
	
	public HashMap<Boolean, String> comparePremium(String sheetName, int rowIndex, String columnName, String valueExcel, HashMap<String, String> premiumMap) {
		boolean flag = false; int counter =0;

		String tmpUIString1 = "",tmpUIString2="",valueUI="", headerPremiumString="";
		HashMap<Boolean, String> comparedResult = new HashMap<Boolean, String>();
		headerPremiumString = premiumMap.get("Monthly Premium"); //gets the value for the header premium that was stored from the UI
		
		if(headerPremiumString!=null) //the header monthly premium value is not there for PDP plans so in case of PDP plans this value will be null
			headerPremiumString = headerPremiumString.replace("\n", "").replaceAll("\\s+", ""); //removing spaces and next lines if any
		
		for(String key : premiumMap.keySet()) {
			valueUI = premiumMap.get(key);
			tmpUIString1 = valueUI;
			key = key.toLowerCase().trim();
			columnName = columnName.toLowerCase().trim();
			
			if(key.contains(columnName)) {
				counter++;
				valueUI = valueUI.replace("\n", "").replaceAll("\\s+", "");
				valueExcel = valueExcel.replace("\n", "").replaceAll("\\s+", "");

				//the following code is used to remove the footnote values from the benefit value string.

				valueExcel = valueExcel.trim();
				valueUI = valueUI.trim();

				if (key.contains("premium")) {
					if (valueExcel.contains("-")) {
						String[] premiumArray = valueExcel.split("-");
						valueExcel = premiumArray[1];
					}
					if (valueExcel.contains("$0") && !valueExcel.contains("-")) {
						valueExcel = valueExcel.concat(".00");
					}
					if (!valueExcel.contains(".")){
						valueExcel = valueExcel.concat(".00");
					}
					if (valueUI.equalsIgnoreCase(valueExcel)) { //if the UI value and the excel value matches
						if (valueUI.equalsIgnoreCase(headerPremiumString)) {
							flag = true;
							System.out.println("==============VERIFY PREMIUM PASSED==============");
							System.out.println(sheetName + "_" + rowIndex + " - HEADER PREMIUM VALUE MATCH WITH BOX FOR: " + columnName + " Excel: " + headerPremiumString + " | UI: " + valueUI);
							break;
						} else if (headerPremiumString == null) { //for PDP plans this will be null
							flag = true;
							System.out.println("==============VERIFY PREMIUM PASSED==============");
							System.out.println(sheetName + "_" + rowIndex + " - HEADER PREMIUM VALUE MATCH WITH BOX FOR: " + columnName + " Excel: " + headerPremiumString + " | UI: " + valueUI);
							break;
						} else {
						//	flag = false;
							System.out.println("==============VERIFY PREMIUM FAILED==============");
							System.out.println(sheetName + "_" + rowIndex + " - header premium value didn't match with the box for: " + columnName + " Excel: " + headerPremiumString + " | UI: " + valueUI);
							tmpUIString2 = tmpUIString1 + " / Header Value: " + headerPremiumString;
							break;
						}

					} else {
						//flag = false;
						System.out.println(sheetName + "_" + rowIndex + " - Values did not match for col:1 " + columnName + " Excel: " + valueExcel + " | UI: " + valueUI);
						tmpUIString2 = tmpUIString1 + " / Header Value: " + headerPremiumString;
						break;
					}
				} else if (key.equalsIgnoreCase("plan name")) {
					if (valueUI.contains(valueExcel)) {
						flag = true;
						System.out.println("==============VERIFY " + key.toString() + " PASSED==============");
						System.out.println(sheetName + "_" + rowIndex + " - Values match for col:2 " + columnName + " Excel: " + valueExcel + " | UI: " + valueUI);
						break;
					} else {
					//	flag = false;
						System.out.println(sheetName + "_" + rowIndex + " - Values did not match for col:2 " + columnName + " Excel: " + valueExcel + " | UI: " + valueUI);
						tmpUIString2 = tmpUIString1;
						break;
					}

				} else if (key.contains("zip")) {
					if (valueUI.equalsIgnoreCase(valueExcel)) {
						flag = true;
						System.out.println("==============VERIFY " + key.toString() + " PASSED==============");
						System.out.println(sheetName + "_" + rowIndex + " - Values match for col:3 " + columnName + " Excel: " + valueExcel + " | UI: " + valueUI);
						break;
					} else {
						flag = false;
						System.out.println(sheetName + "_" + rowIndex + " - Values did not match for col:3 " + columnName + " Excel: " + valueExcel + " | UI: " + valueUI);
						tmpUIString2 = tmpUIString1;
						break;
					}

				}

				else if (key.equalsIgnoreCase("high option monthly")) {
					if (valueExcel.contains(valueUI)) {
						flag = true;
						System.out.println("==============VERIFY " + key.toString() + " PASSED==============");
						System.out.println(sheetName + "_" + rowIndex + " - Values match for col:4 " + columnName + " Excel: " + valueExcel + " | UI: " + valueUI);
						break;
					} else {
						flag = false;
						System.out.println(sheetName + "_" + rowIndex + " - Values did not match for col:4 " + columnName + " Excel: " + valueExcel + " | UI: " + valueUI);
						tmpUIString2 = tmpUIString1;
						break;
					}
				}	
					else if (key.equalsIgnoreCase("high option annual")) {
						if (valueExcel.contains(valueUI)) {
							flag = true;
							System.out.println("==============VERIFY " + key.toString() + " PASSED==============");
							System.out.println(sheetName + "_" + rowIndex + " - Values match for col:5 " + columnName + " Excel: " + valueExcel + " | UI: " + valueUI);
							break;
						} else {
							flag = false;
							System.out.println(sheetName + "_" + rowIndex + " - Values did not match for col:5 " + columnName + " Excel: " + valueExcel + " | UI: " + valueUI);
							tmpUIString2 = tmpUIString1;
							break;
						}


				}

					else if (key.equalsIgnoreCase("dental platinum monthly")) {
						if (valueExcel.contains(valueUI)) {
							flag = true;
							System.out.println("==============VERIFY " + key.toString() + " PASSED==============");
							System.out.println(sheetName + "_" + rowIndex + " - Values match for col:6 " + columnName + " Excel: " + valueExcel + " | UI: " + valueUI);
							break;
						} else {
							flag = false;
							System.out.println(sheetName + "_" + rowIndex + " - Values did not match for col:6 " + columnName + " Excel: " + valueExcel + " | UI: " + valueUI);
							tmpUIString2 = tmpUIString1;
							break;
						}


				}
					else if (key.equalsIgnoreCase("dental platinum Annual")) {
						if (valueExcel.contains(valueUI)) {
							flag = true;
							System.out.println("==============VERIFY " + key.toString() + " PASSED==============");
							System.out.println(sheetName + "_" + rowIndex + " - Values match for col:7 " + columnName + " Excel: " + valueExcel + " | UI: " + valueUI);
							break;
						} else {
							flag = false;
							System.out.println(sheetName + "_" + rowIndex + " - Values did not match for col:7 " + columnName + " Excel: " + valueExcel + " | UI: " + valueUI);
							tmpUIString2 = tmpUIString1;
							break;
						}


				}
			}
		}
		
		comparedResult.put(flag, tmpUIString2);
		return comparedResult;
		
	}

	
	public boolean checkForMultiCountyPopup(String countyName) {
		boolean flag = false;
		if(validate(countyModal,20)) {
			driver.findElement(By.xpath("//*[contains(@id,'selectCounty')]//*[contains(text(),'" + countyName + "')]")).click();
			validateNew(zipcodeChangeLink,20);
			flag = true;
		}

		return flag;
	}

	public void viewPlanSummary(String planType) {
		//driver.findElement(By.className("uhc-modal__close")).click();
		if (planType.equalsIgnoreCase("PDP")) {
			validateNew(pdpPlansViewLink, 30);
			pdpPlansViewLink.click();
			System.out.println("PDP Plan Type Clicked");
			validateNew(planListContainer, 30);
		} else if (planType.equalsIgnoreCase("MA") || planType.equalsIgnoreCase("MAPD")) {
			validateNew(maPlansViewLink, 30);
			//sleepBySec(2);
			maPlansViewLink.click();
			validateNew(planListContainer, 30);
		}  else if (planType.equalsIgnoreCase("SNP")) {
			//sleepBySec(5);
			validateNew(snpPlansViewLink, 30);
			snpPlansViewLink.click();
			validateNew(planListContainer, 30);
			
		}
	}
	
	public void selectYearOption(String year) {
		try {
			if(year.equalsIgnoreCase("current")) {
				if(validate(CurrentYearLink))
					CurrentYearLink.click();
			}else {
				if(validate(NextYearLink))
					NextYearLink.click();
			}
			CommonUtility.checkPageIsReadyNew(driver);
		} catch (Exception e) {
			System.out.println("AEP Year Toggle Radio and Modal is NOT displayed on VPP Page : ");
			e.printStackTrace();
		}
		
	}

	public void selectCounty(String county){
		//CommonUtility.waitForPageLoad(driver, countyModal, 10);
		if (validate(countyModal))

			jsClickNew(driver.findElement(By.xpath("//div[@id='selectCounty']//a[contains(text(),'" + county + "')]")));
		/*ArrayList<String> tabs_windows = new ArrayList<String>(driver.getWindowHandles());
		Iterator<String> itr = tabs_windows.iterator();
		while (itr.hasNext()) {
			String window = itr.next();
			driver.switchTo().window(window);
		System.out.println(driver.getTitle());
		}*/
			//CommonUtility.waitForPageLoadNew(driver, vppTop, 30);



	}

	public void Enroll_OLE_Plan(String planName, String planType) throws InterruptedException {
		Thread.sleep(5000);
		WebElement enrollForPlan = null;
		System.out.println("Enroll in Plan for Plan : " + planName);
		if (planType.equalsIgnoreCase("PDP")) {
			// driver.navigate().refresh();
			//Thread.sleep(5000);
			validateNew(driver.findElement(By.xpath("//*[contains(text(), '" + planName + "')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'enrollment')]//*[contains(@class,'cta-button')]")));
			scrollToView(driver.findElement(By.xpath("//*[contains(text(), '" + planName + "')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'enrollment')]//*[contains(@class,'cta-button')]")));
			enrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + planName + "')]/ancestor::*[contains(@class,'module-plan-overview module')]//*[contains(@class,'enrollment')]//*[contains(@class,'cta-button')]"));
		} else {
			validateNew(driver.findElement(By.xpath("//*[contains(text(), '" + planName + "')]/following::a[contains(text(),'Enroll in Plan')][2]")));
			scrollToView(driver.findElement(By.xpath("//*[contains(text(), '" + planName + "')]/following::a[contains(text(),'Enroll in Plan')][2]")));
			enrollForPlan = driver.findElement(By.xpath("//*[contains(text(), '" + planName + "')]/following::a[contains(text(),'Enroll in Plan')][2]"));
		}

		if (enrollForPlan != null) {
			//validateNew(enrollForPlan);
			jsClickNew(enrollForPlan);
			validateNew(welcomePageHeader,60);

		}
		
	}
	
	public HashMap<String, String> collectInfoWelcomeOLEpg(String planName, String countyName, String planYear, String sheetName, int rowIndex, String highOpDental, String dentalPl) throws InterruptedException {
		this.sheetName = sheetName;
		this.rowIndex = rowIndex;

		HashMap<String, String> result=new HashMap<String, String>();
        
        result = collectInfoOLEpg(planName,sheetName,rowIndex,highOpDental,dentalPl);
        
        System.out.println(sheetName);
        System.out.println(rowIndex);
        System.out.println(planName);
        
        return result;
    }

	public HashMap<String, String> collectInfoOLEpg(String planName,String sheetName, int rowIndex, String highOptionalDental, String dentalPlatinum) throws InterruptedException {
		String dentalMonthlyValue = null;
		String highdentalAnnualValue = null;
		String HIGHdentalMonthlyValue = null;
		String highOptionalDentalMonthlyElementText=null;
		String detalAnnualValue = null;
		WebElement highOptionalDentalElement = null, dentalPlantinumMonthlyElement = null,dentalPlantinumElement = null,highOptionalDentalMonthlyElement = null;
		String highOptionalDentaltext = null, dentalPlatinumtext = null, headerPremiumText = null, headerPlanNameText = null, headerZipText = null,dentalPlantinumMonthlyElementtext=null,highOptionalDentalMonthlyElementtext=null;
		System.out.println(sheetName+"_"+rowIndex+" - Proceed to collect the info on Welcome OLE Page");
		HashMap<String, String> result=new HashMap<String, String>();
			WebElement  planYear = driver.findElement(By.xpath("//h3[@class='h3-welcome-class']"));
			String[] planYearArray = planYear.getText().split(" ");

			String planYearValue = planYearArray[0];
		System.out.println("Plan year coming as " +planYearValue);
		try {
		String planCard = "(//*[contains(text(), '"+planName+"')])[2]";
		String headerPremiumXpath = planCard+"/parent::div/ul/li[1]";
		String headerPrem = "Monthly Premium"; //this variable will be stored as key for the header premium
		headerPremiumText = driver.findElement(By.xpath(headerPremiumXpath)).getText();
		String [] headerPremiumArray = headerPremiumText.split(" ");
		if(headerPremiumArray[2].substring(3, 5).equalsIgnoreCase("0.00"))
		{
		String updatedHeaderPremium = headerPremiumArray[2].substring(0, 2) ;
		result.put(headerPrem, updatedHeaderPremium);
		}
		else {
			result.put(headerPrem, headerPremiumArray[2]);
		}

		String headerPlanName = "plan name"; //this variable will be stored as key for the header plan name
		headerPlanNameText = driver.findElement(By.xpath(planCard)).getText();
		result.put(headerPlanName, headerPlanNameText);
		String headerZipXpath = planCard+"/parent::div/ul/li[2]";
		String headerZip = "ZipCode"; //this variable will be stored as key for the header zip
		headerZipText = driver.findElement(By.xpath(headerZipXpath)).getText();
		String [] headerZipArray = headerZipText.split(" ");
		result.put(headerZip, headerZipArray[2]);
		} catch (Exception e) {
			System.out.println("validation for plan name and zipcode on welcome ole page");
		}
		if(!planName.contains("PDP")) {
			// HIGH OPTIONAL DENATL
			try {
				// Step 1 capturing the values for high optional dental
				// STep 1.1 caputing monthly value
				highOptionalDentalMonthlyElement = driver.findElement(By.cssSelector("label[for^='HighOptionDental'] > span"));
				highOptionalDentalMonthlyElementText=highOptionalDentalMonthlyElement.getText().trim(); // for $45 a month
				String [] HIGHdentalMonthlyArray= highOptionalDentalMonthlyElementText.split(" "); //{"for","$45","a","month"}
				HIGHdentalMonthlyValue = HIGHdentalMonthlyArray[1];
				//Step 1.2 capturing annual value
				highOptionalDentalElement = driver.findElement(By.xpath("//*[contains(@id,'HighOptionDental')]//li[contains(text(), 'annual maximum')]"));
				String [] annualHighText = highOptionalDentalElement.getText().split(" ");
				highdentalAnnualValue = annualHighText[annualHighText.length-1];
			} catch (Exception e) {
				System.out.println("No high dental option rider for Plan :"+planName);
			}
			//DENTAL PLATINUM
			try {

				// Step 2 capturing the values for dental platinum
				// STep 2.1 caputing monthly value
				dentalPlantinumMonthlyElement = driver.findElement(By.cssSelector("label[for^='DentalPlatinum_selectedRiders'] > span"));
				
				dentalPlantinumMonthlyElementtext=dentalPlantinumMonthlyElement.getText().trim(); // for $45 a month
				String [] dentalMonthlyArray= dentalPlantinumMonthlyElementtext.split(" "); //{"for","$45","a","month"}
				dentalMonthlyValue = dentalMonthlyArray[1];
				
				//STep 2.2 caputing annual value
				dentalPlantinumElement = driver.findElement(By.xpath("//*[contains(@id,'DentalPlatinum')]//li[1]"));
					String [] annualText = dentalPlantinumElement.getText().split(" ");
				 if(planYearValue.equalsIgnoreCase("2021")) {
					detalAnnualValue = annualText[annualText.length-1];
					}
				else {
					 detalAnnualValue = annualText[0];
					
				}
				
			
			} catch (Exception e) {
				System.out.println("No dental platinum rider for Plan :"+planName);
			}
			

			if (highOptionalDental.equalsIgnoreCase("NA") && !dentalPlatinum.equalsIgnoreCase("NA")) {
				System.out.println("###########################1st scenario #####################################");
				System.out.println(" EXCEL Value highOptionalDental :----------->"+highOptionalDental);
				System.out.println("-----------------------------------------------------------------------");
				System.out.println(" EXCEL Value dentalPlatinum :----------->"+dentalPlatinum);	
				System.out.println("-----------------------------------------------------------------------");
				System.out.println(" UI Value dentalMonthlyValue :----------->"+dentalMonthlyValue);
				System.out.println("-----------------------------------------------------------------------");
				System.out.println(" UI Value detalAnnualValue:----------->"+detalAnnualValue);

				
				

				result.put("high option monthly", highOptionalDental);
				result.put("high option annual ", highOptionalDental);
				
				result.put("dental platinum monthly", dentalMonthlyValue);
				result.put("dental platinum Annual", detalAnnualValue);
				
				} else if (!highOptionalDental.equalsIgnoreCase("NA") && !dentalPlatinum.equalsIgnoreCase("NA")) {
					System.out.println("#########################2nd scenario#######################################");
					System.out.println(" EXCEL Value highOptionalDental :----------->"+highOptionalDental);
					System.out.println("-----------------------------------------------------------------------");
					System.out.println(" EXCEL Value dentalPlatinum :----------->"+dentalPlatinum);	
					System.out.println("-----------------------------------------------------------------------");
					System.out.println(" UI Value dentalMonthlyValue :----------->"+dentalMonthlyValue);
					System.out.println("-----------------------------------------------------------------------");
					System.out.println(" UI Value detalAnnualValue:----------->"+detalAnnualValue);
					System.out.println("-----------------------------------------------------------------------");
					System.out.println(" UI Value HIGHdentalMonthlyValue :----------->"+HIGHdentalMonthlyValue);
					System.out.println("-----------------------------------------------------------------------");
					System.out.println(" UI Value HighdentalAnnualValue:----------->"+highdentalAnnualValue);

					
					result.put("high option monthly", HIGHdentalMonthlyValue);
					result.put("high option annual ", highdentalAnnualValue);
				
					result.put("dental platinum monthly", dentalMonthlyValue);
					result.put("dental platinum Annual", detalAnnualValue);
	
			} else if (highOptionalDental.equalsIgnoreCase("NA") && dentalPlatinum.equalsIgnoreCase("NA")) {
				System.out.println("#########################3rd scenario#######################################");

				System.out.println(" UI Value HIGHdentalMonthlyValue :----------->"+highOptionalDental);
				System.out.println("-----------------------------------------------------------------------");
				System.out.println(" UI Value dentalAnnualHighValue:----------->"+highOptionalDental);
				System.out.println("-----------------------------------------------------------------------");
				System.out.println(" UI Value dental platinum monthly :----------->"+dentalPlatinum);
				System.out.println("-----------------------------------------------------------------------");
				System.out.println(" UI Value dental platinum Annual:----------->"+dentalPlatinum);

				result.put("high option monthly", highOptionalDental);
			result.put("high option annual ", highOptionalDental);
			
			result.put("dental platinum monthly", dentalPlatinum);
			result.put("dental platinum Annual", dentalPlatinum);
			
			}
			else if (!highOptionalDental.equalsIgnoreCase("NA") && dentalPlatinum.equalsIgnoreCase("NA")) {

				System.out.println("#########################4th scenario#######################################");
				System.out.println(" UI Value HIGHdentalMonthlyValue :----------->"+HIGHdentalMonthlyValue);
				System.out.println("-----------------------------------------------------------------------");
				System.out.println(" UI Value dentalAnnualHighValue:----------->"+highdentalAnnualValue);
				System.out.println("-----------------------------------------------------------------------");
				System.out.println(" UI Value dental platinum monthly :----------->"+dentalPlatinum);
				System.out.println("-----------------------------------------------------------------------");
				System.out.println(" UI Value dental platinum Annual:----------->"+dentalPlatinum);

				result.put("high option monthly", HIGHdentalMonthlyValue);
				result.put("high option annual ", highdentalAnnualValue);
			
				result.put("dental platinum monthly", dentalPlatinum);
				result.put("dental platinum Annual", dentalPlatinum);
			}
			
		}

		System.out.println("================ Finished collecting info on Welcome OLE Page================");
		return result;
	}

    
    public boolean Enroll_OLE_Plan_PlanDetails(String planName, String planType) throws InterruptedException {
    	boolean flag = true;

    		System.out.println("Enroll in Plan for Plan : " + planName);

				WebElement enrollInPlan = null;
					try {
						//Thread.sleep(5000);
				if(planType.equalsIgnoreCase("MA")) {

					validate(driver.findElement(By.xpath("//*[contains(text(),'Enroll in plan')]")));
					scrollToView(driver.findElement(By.xpath("//*[contains(text(),'Enroll in plan')]")));
					enrollInPlan = driver.findElement(By.xpath("//*[contains(text(),'Enroll in plan')]"));
				}
				if(planType.equalsIgnoreCase("SNP")){
					validate(driver.findElement(By.xpath("(//*[contains(text(),'Enroll in plan')])[2]")));
					scrollToView(driver.findElement(By.xpath("(//*[contains(text(),'Enroll in plan')])[2]")));
					enrollInPlan = driver.findElement(By.xpath("(//*[contains(text(),'Enroll in plan')])[2]"));
				}
					}catch(Exception e){
				System.out.println("This plan does not have enroll button");
				flag = false;
					}

				if (enrollInPlan != null) {
					validateNew(enrollInPlan);
					jsClickNew(enrollInPlan);
					validateNew(welcomePageHeader,60);
				}
		return flag;
		}
	}

	
