/**
 *
 */
package pages.acquisition.vpp;


import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.springframework.util.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import atdd.framework.UhcDriver;
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

    @FindBy(xpath = "//div[contains(@class,'zipcodePrint')]")
    private WebElement cmpPgHeader;

    @FindBy(xpath = "//div[@id='topRowCopy']//div[@ng-repeat='i in count']")
    private List<WebElement> listOfCmpPlansColumns;

    int retryCnt = 1;
    String sheetName = "";
	int rowIndex;
	
	@FindBy(xpath = "//*[contains(@class,'plan-detail-table')]")
	private WebElement lisPlanTable;


    public AepPlanComparePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {


    }

    public HashMap<Boolean, String> compareBenefits(String columnName, String benefitValue, HashMap<String, String> benefitsMap) {
        boolean flag = false;
        int counter = 0;
        String tmpUIString1 = "", tmpUIString2 = "", benefitValueUI = "";
        HashMap<Boolean, String> comparedResult = new HashMap<Boolean, String>();
        for (String key : benefitsMap.keySet()) {
            benefitValueUI = benefitsMap.get(key).toLowerCase();
            tmpUIString1 = benefitValueUI;
            key = key.toLowerCase();
            key = key.replace(":", "");

            columnName = columnName.toLowerCase().trim();
//			if(columnName.contains("tier"))
//				System.out.println();

            benefitValue = benefitValue.trim().toLowerCase();

            if (benefitValue.equalsIgnoreCase("NA") || benefitValue.equalsIgnoreCase("N/A")) {
                counter++;
                if (!key.trim().equals(columnName.trim())) {
                    flag = true;
                    continue;
                }

                if ((key.trim().equals(columnName.trim())) && benefitValueUI.equalsIgnoreCase("N/A")) {
                    flag = true;
                    break;
                }
                flag = false;
                tmpUIString2 = tmpUIString1;
                break;

            } else if (key.trim().equals(columnName.trim())) {
                counter++;
                benefitValueUI = benefitValueUI.replace("\n", "").replaceAll("\\s+", "").replace(":", "").replace(",", "").replace("-", "").replace(";", "");
                benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", "").replace(":", "").replace(",", "").replace("-", "").replace(";", "");


                if (columnName.equalsIgnoreCase("Monthly Premium")
                        || columnName.equalsIgnoreCase("Monthly PremiumPC")
                        || columnName.equalsIgnoreCase("Monthly PremiumOON")) {
                    if (benefitValue.endsWith(".00") && !benefitValueUI.contains(".")) {
                        benefitValue = benefitValue.replace(".00", "");
                    }
                } else if (!columnName.contains("Monthly Premium")) {
                    if (benefitValueUI.endsWith("1") && !benefitValue.endsWith("1"))
                        benefitValueUI = StringUtils.trimTrailingCharacter(benefitValueUI, '1');
                    else if (benefitValueUI.endsWith("2") && !benefitValue.endsWith("2"))
                        benefitValueUI = StringUtils.trimTrailingCharacter(benefitValueUI, '2');
                    else if (benefitValueUI.endsWith("4") && !benefitValue.endsWith("4"))
                        benefitValueUI = StringUtils.trimTrailingCharacter(benefitValueUI, '4');

                    if (benefitValueUI.endsWith("*") && !benefitValue.endsWith("*"))
                        benefitValueUI = StringUtils.trimTrailingCharacter(benefitValueUI, '*');
                    if (benefitValueUI.endsWith(".") && !benefitValue.endsWith("."))
                        benefitValueUI = StringUtils.trimTrailingCharacter(benefitValueUI, '.');

                }
                if(key.equalsIgnoreCase("Routine Dental")||key.equalsIgnoreCase("Routine DentalOON")) {
					//benefitValueUI = benefitValueUI.replace("Ismydentistcoveredforthisplan?", "");
					benefitValueUI = benefitValueUI.replace("-opensinnewwindow", "");
					benefitValueUI = benefitValueUI.replace("opensinanewwindow", "");
					benefitValueUI = benefitValueUI.replace("opensinnewwindow", "");
                }
                benefitValueUI = benefitValueUI.trim();
                benefitValue = benefitValue.trim();

                if (benefitValueUI.equalsIgnoreCase(benefitValue)) {
                    flag = true;
                    break;
                } else {
                    flag = false;
                    System.out.println("Values did not match for col:1 " + columnName + " Excel: " + benefitValue + " | UI: " + benefitValueUI);
                    tmpUIString2 = tmpUIString1;
                    break;
                }

            }
        }

        if (counter == 0) {
            flag = false;
            System.out.println("Values did not match for col:2 " + columnName + " Excel: " + benefitValue + " | UI: BENEFIT NOT FOUND");
            tmpUIString2 = "BENEFIT NOT FOUND ON THE UI";
        }

        comparedResult.put(flag, tmpUIString2);
        return comparedResult;

    }

    public HashMap<String, String> collectInfoVppPlanComparePg(String planType, String network, String sheetName, int rowIndex) {
        HashMap<String, String> result = new HashMap<String, String>();

        for (int i = 0; i < 5; i++) {
            try {
                result = collectInfoVppPlanComparePg(planType, network);
                int benefitUICnt = result.size();
                System.out.println(sheetName + "_" + rowIndex + " - Attempt - " + (i + 1) + ", Benefits Map count - " + benefitUICnt);
                if (benefitUICnt < 1) {
                    driver.navigate().refresh();
                    System.out.println(sheetName + "_" + rowIndex + " - Attempt - " + (i + 1) + ", Page Refreshed");
                    continue;
                } else {
                    return result;
                }
            } catch (Exception ex) {
                driver.navigate().refresh();
                System.out.println(sheetName + "_" + rowIndex + " - Attempt - " + (i + 1) + ", Page Refreshed after Exception");
                continue;
            }

        }


        return result;
    }

    public HashMap<String, String> collectInfoVppPlanComparePg(String planType, String network) {

       
        sleepBySec(5);

        //CommonUtility.checkPageIsReady(driver);

        System.out.println("Proceed to collect the info on vpp compare page =====");
        HashMap<String, String> result = new HashMap<String, String>();

        result.putAll(readPlanName());

        //Read prescription Drug Benefits table
        //result.putAll(readBenefitsData("prescription-drug-table", ""));

        HashMap<String, String> pdresult = new HashMap<String, String>();
        for (int i = 0; i < 4; i++) {
            try {
                pdresult = readBenefitsData("prescription-drug-table", "");
                int benefitUICnt = pdresult.size();
                System.out.println("prescription-drug-table - Attempt - " + (i + 1) + ", Benefits Map count - " + benefitUICnt);
                if(i==3)
                {
                    result.putAll(pdresult);
                    break;
                }
                if (benefitUICnt == 0 ||benefitUICnt == 6 ) {
                    driver.navigate().refresh();
                    threadsleep(2000);
                    System.out.println("prescription-drug-table - Attempt - " + (i + 1) + ", Page Refreshed");
                    continue;
                } else {
                    result.putAll(pdresult);
                    break;
                }
            } catch (Exception ex) {
                driver.navigate().refresh();
                System.out.println("prescription-drug-table - Attempt - " + (i + 1) + ", Page Refreshed after Exception");
                continue;
            }

        }

        //Read PlanCosts table
        result.putAll(readBenefitsData("plan-costs-table", ""));

        //Read Plan Summary table
        result.putAll(readBenefitsData("plan-summary-table", planType.equals("PDP") ? "" : "PC"));

        if (planType.startsWith("MA") || planType.startsWith("SNP")) {

            //Read INN Benefits data
            result.putAll(readBenefitsData("medical-benefits-table", ""));
            result.putAll(readBenefitsData("additional-benefits-table", ""));

            //Read Optional Services (Riders) data
            result.putAll(readBenefitsData("optional-services-table", ""));

            //Read OON Benefits data
            if (network.trim().startsWith("OON")) {
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

    private HashMap<String, String> readPlanName() {


        HashMap<String, String> result = new HashMap<String, String>();

        String planNameXPath = "//tr[contains(@id,'printPlans')]/th[3]/div";
        WebElement planNameElement = driver.findElement(By.xpath(planNameXPath));

        if (planNameElement == null ) {
            System.out.println("No PLan Name data found");
            return result;
        }
        else
        {
            try {
                result.put("Plan Name", planNameElement.getText());
            }
            catch (Exception ex) {
                System.out.println(ex.getMessage());
            }

        }
        return result;
    }

    //This method reads the benefit table values on UI into a HashMap as key value pairs
    //tableId - Id attribute of the benefit table
    //keyword - this is a parameter passed to generate the key name matching with that of the excel header name to distinguish between PC,INN and OON
    private HashMap<String, String> readBenefitsData(String tableId, String keyword) {


        HashMap<String, String> result = new HashMap<String, String>();

        //validateNew(driver.findElement(By.id(tableId)));

        String rowXpath = "//table[contains(@id,'" + tableId + "')][1]//tbody//tr[not(contains(@id,'Hide'))]";
        List<WebElement> listOfRowsInPlanCompareTbl = driver.findElements(By.xpath(rowXpath));

        if (listOfRowsInPlanCompareTbl == null || listOfRowsInPlanCompareTbl.size() == 0) {
            System.out.println(tableId + " - No benefit data found");
            return result;
        }

        for (int i = 0; i < listOfRowsInPlanCompareTbl.size(); i++) {

            try {

                String key = "";
                String value = "";

                List<WebElement> headerCellXpathList = (listOfRowsInPlanCompareTbl.get(i).findElements(By.tagName("th")));
                List<WebElement> planCellXpathList = (listOfRowsInPlanCompareTbl.get(i).findElements(By.tagName("td")));

                if (headerCellXpathList.size() != 0) {
                    key = headerCellXpathList.get(0).getText();
                }

                if (planCellXpathList.size() != 0) {
                    value = planCellXpathList.get(0).getText();
                }

                result.put(key + keyword, value);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }


        }


//		for(String keyValue : result.keySet()) {
//			System.out.println("Table : "+tableId +" | Key : "+keyValue+"\t| Value: "+result.get(keyValue));
//			System.out.println(
//					"_________________________________________________________________________________________________"
//			); }
        return result;
    }

    //Format Plan compare cell value before validating against plan detail (to avoid making changes to PlanDetail compareBenefits method)
    public String formatCellValueForPlanDetail(String currentColName, String currentCellValue) {

        String formatedCellValue = currentCellValue;

        if (currentColName.startsWith("Routine Dental") && currentCellValue.startsWith("Click")) {
            formatedCellValue = currentCellValue + "Ismydentistcoveredforthisplan?-opensinnewwindow";
        }

        if (currentColName.startsWith("Tier")) {
            formatedCellValue = currentCellValue.replace(":", "");
        }

        return formatedCellValue;
    }

    public String getPlanDetailColumnName(String currentColName) {

        if (currentColName.equalsIgnoreCase("Primary Care Provider") || currentColName.equalsIgnoreCase("Specialist"))
            return currentColName + " Copay";

        if (currentColName.equalsIgnoreCase("Diagnostic Radiology Services"))
            return "Diagnostic Radiology Services (such as MRIs/CT scans, etc.)";

        if (currentColName.equalsIgnoreCase("Hearing Aids - All Types"))
            return "Hearing Aids";

        if (currentColName.equalsIgnoreCase("Fitness"))
            return "Fitness Program through Renew Active?";

        if (currentColName.equalsIgnoreCase("Referral Required"))
            return "Referral to Specialist required?";

        if (currentColName.equalsIgnoreCase("Outpatient Hospital Services"))
            return "Outpatient Hospital Services" + "\n" + "(includes observation services)";

        return currentColName;
    }

    public Map<String, String> sortDetailMap(HashMap<String, String> benefitsDetailMap) {
        Map<String, String> map = new TreeMap<String, String>(benefitsDetailMap);
        return map;
    }
    
    public HashMap<String, String> collectInfoVppPlanSummaryPg(String planName, String countyName, String planYear, String sheetName, int rowIndex) throws InterruptedException {
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
            //checkForMultiCountyPopup(countyName);
           // selectYearOption(planYear);
            result = collectInfoVppPlanCompareBaselinePg(planName, sheetName);
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
    
	public HashMap<String, String> collectInfoVppPlanCompareBaselinePg(String planName, String sheetName)
			throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		System.out.println(sheetName + "_" + rowIndex
				+ " - Proceed to collect the plan benefits info on vpp Compare baseline page");

		HashMap<String, String> result = new HashMap<String, String>();
		try {
			if (sheetName.contains("SNP") || sheetName.contains("MAPD")) {

				Thread.sleep(15000);
				if (sheetName.contains("SNP")) {
					driver.navigate().refresh();
					
					WebDriverWait wait = new WebDriverWait(driver, 30);
					wait.until(ExpectedConditions.visibilityOfElementLocated(
							By.xpath("//*[@id = 'toggleSnpId']/ancestor::label//*[@class = 'uhc-switch__slider']")));
					if (driver
							.findElements(By.xpath(
									"//*[@id = 'toggleSnpId']/ancestor::label//*[@class = 'uhc-switch__slider']"))
							.size() != 0) {
						WebElement SNPToggle = driver.findElement(
								By.xpath("//*[@id = 'toggleSnpId']/ancestor::label//*[@class = 'uhc-switch__slider']"));
						SNPToggle.click();
					}
				}

				List<WebElement> PlanNames = driver.findElements(By.xpath("//span[contains(@class,'headerPlanName')]"));
				Thread.sleep(5000);
				int totalPlans = PlanNames.size();
				String planNameRunTime = "";
				for (int i = 0; i < totalPlans; i++) {
					planNameRunTime = PlanNames.get(i).getText();
					if (driver.findElement(By.xpath(
							"//span[contains(@class,'headerPlanName') and (contains(text(), '" + planName + "')) ]"))
							.isDisplayed() == false) {
						for (int j = 0; j <= totalPlans - 3; j++) {
							driver.findElement(By.xpath(
									("//button[@dtmname = 'Plan Compare:View More Plans' and contains(@class,'leftScrollBtnStyle') and (contains(@ng-class, 'isEnrolledDataNotAvailable'))]")))
									.click();
							if (driver.findElement(
									By.xpath("//span[contains(@class,'headerPlanName') and (contains(text(), '"
											+ planName + "')) ]"))
									.isDisplayed() == true) {
								planNameRunTime = planName;
								break;
							}
						}

					}
				}
				totalPlans = PlanNames.size();
				for (int k = 0; k < totalPlans; k++) {
					planNameRunTime = PlanNames.get(k).getText();
					if (planNameRunTime.equalsIgnoreCase(planName)) {
						List<WebElement> MoreOptions = driver
								.findElements(By.xpath("//tr//span[contains(@class,'headerPlanName') and text()='"
										+ planName + "']//ancestor::div//*[contains(text() , 'More Options')]"));
						MoreOptions.get(k).click();
						WebElement BaseineBenefit = driver.findElement(
								By.xpath("//tr//span[contains(@class,'headerPlanName') and text()='" + planName
										+ "']/ancestor::div//*[@id = 'moreOptionsId']//span[contains(text() , 'Baseline Benefits')]"));
						BaseineBenefit.click();
						// String planNameRunTime =
						// driver.findElement(By.xpath("//*[@id='baseline-benefits-popup']//span[contains(@class,
						// 'plan-name')]")).getText();
						System.out.println("Plan Name on Baseline Benefits : " + planNameRunTime);
						break;
					}
				}
				String rowXpath = "//*[@id='baseline-benefits-popup']/div/table/tbody/tr[contains(@ng-if, 'baseLinePlanType')]";
				List<WebElement> listOfRowsPerTable = driver.findElements(By.xpath(rowXpath));
				String key = "";
				String value = "";
				String MonthlyPremium = driver
						.findElement(By.xpath(("//*[@id='baseline-benefits-popup']/div/table/tbody/tr/td"))).getText();
				System.out.println(MonthlyPremium);
				key = MonthlyPremium;
				String MonthlyPremiumValue = driver
						.findElement(By.xpath(("//*[@id='baseline-benefits-popup']/div/table/tbody/tr/td[2]/span")))
						.getText();
				System.out.println(MonthlyPremiumValue);
				value = MonthlyPremiumValue;
				result.put(key, value);

				for (int rowIndex = 1; rowIndex <= 3; rowIndex++) { // note: loop through each row
					String cellsXpath = "", benefitValueXpath = "";
					String rowText = "", benefitValueText = "";

					cellsXpath = rowXpath + "[" + rowIndex + "]" + "/td";

					benefitValueXpath = rowXpath + "[" + rowIndex + "]" + "/td/span";// xpath for the benefit value for
																						// the cell

					// the below code gets the benefit name from the table before the : symbol
					WebElement e = driver.findElement(By.xpath(cellsXpath));
					rowText = e.getText();
					System.out.println(rowText);

					key = rowText;

					// the below code gets the benefit value from the table after the : symbol
					WebElement j = driver.findElement(By.xpath(benefitValueXpath));

					benefitValueText = j.getText();
					System.out.println(benefitValueText);
					value = benefitValueText;

					result.put(key, value);
				}
				String SpecialistReferral = driver
						.findElement(By.xpath("//*[@id='baseline-benefits-popup']/div/table/tbody/tr[5]/td")).getText();
				key = SpecialistReferral;
				String SpecialistReferralValue = driver
						.findElement(By.xpath("//*[@id='baseline-benefits-popup']/div/table/tbody/tr[5]/td[2]"))
						.getText();
				value = SpecialistReferralValue;
				result.put(key, value);

				if (driver.findElements(By.xpath("//*[@id='baseline-benefits-popup']/div/table/tbody/tr[6]/td"))
						.size() != 0) {
					String Prescription = driver
							.findElement(By.xpath("//*[@id='baseline-benefits-popup']/div/table/tbody/tr[6]/td"))
							.getText();
					key = Prescription;
					String PrescriptionValue = driver
							.findElement(
									By.xpath("//*[@id='baseline-benefits-popup']/div/table/tbody/tr[6]/td[2]/span"))
							.getText();
					value = PrescriptionValue;
					result.put(key, value);
				}
				WebElement Close = driver.findElement(By.xpath(("//*[@ng-click='closeBaseLinePopup()']/div")));
				Close.click();

				// commenting the below lines of coe to reduce the log on Jenkins job

				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				System.out.println(sheetName + "_" + rowIndex
						+ " - Finished to collect the plan benefits info on vpp summary page - Benefits Map count - "
						+ result.size());

			}
		} catch (Exception e) {
			System.out.println("SNP toggle is not working.");
		}
		if (sheetName.contains("PDP")) {
			Thread.sleep(15000);
			try {
				List<WebElement> PDP = driver.findElements(By.xpath("//h1[@ng-if= \"planSelectedType == 'PDP'\"]"));

				if (PDP.size() == 0) {

					if (driver
							.findElement(By.xpath(
									"//th [not(contains(@id ,'printMobileHeader'))]//*[@id = 'viewallplansbtn']"))
							.isDisplayed() == true) {
						driver.navigate().refresh();
						WebDriverWait wait = new WebDriverWait(driver, 30);
						wait.until(ExpectedConditions.visibilityOfElementLocated(By
								.xpath("//th [not(contains(@id ,'printMobileHeader'))]//*[@id = 'viewallplansbtn']")));
						driver.findElement(
								By.xpath("//th [not(contains(@id ,'printMobileHeader'))]//*[@id = 'viewallplansbtn']"))
								.click();
					}
				}
				List<WebElement> PlanNames = driver.findElements(By.xpath("//span[contains(@class,'headerPlanName')]"));
				Thread.sleep(5000);
				int totalPlans = PlanNames.size();
				String planNameRunTime = "";
				for (int i = 0; i < totalPlans; i++) {
					planNameRunTime = PlanNames.get(i).getText();
					if (driver.findElement(By.xpath(
							"//span[contains(@class,'headerPlanName') and (contains(text(), '" + planName + "')) ]"))
							.isDisplayed() == false) {
						for (int j = 0; j <= totalPlans - 3; j++) {
							driver.findElement(By.xpath(
									("//button[@dtmname = 'Plan Compare:View More Plans' and contains(@class,'leftScrollBtnStyle') and (contains(@ng-class, 'isEnrolledDataNotAvailable'))]")))
									.click();
							if (driver.findElement(
									By.xpath("//span[contains(@class,'headerPlanName') and (contains(text(), '"
											+ planName + "')) ]"))
									.isDisplayed() == true) {
								planNameRunTime = planName;
								break;
							}
						}

					}
				}
				totalPlans = PlanNames.size();
				for (int k = 0; k < totalPlans; k++) {
					planNameRunTime = PlanNames.get(k).getText();
					if (planNameRunTime.equalsIgnoreCase(planName)) {
						List<WebElement> MoreOptions = driver
								.findElements(By.xpath("//tr//span[contains(@class,'headerPlanName') and text()='"
										+ planName + "']//ancestor::div//*[contains(text() , 'More Options')]"));
						MoreOptions.get(k).click();
						WebElement BaseineBenefit = driver.findElement(
								By.xpath("//tr//span[contains(@class,'headerPlanName') and text()='" + planName
										+ "']/ancestor::div//*[@id = 'moreOptionsId']//span[contains(text() , 'Baseline Benefits')]"));
						BaseineBenefit.click();
						// String planNameRunTime =
						// driver.findElement(By.xpath("//*[@id='baseline-benefits-popup']//span[contains(@class,
						// 'plan-name')]")).getText();
						System.out.println("Plan Name on Baseline Benefits : " + planNameRunTime);
						break;
					}
				}
				String rowXpath = "//*[@id='baseline-benefits-popup']/div/table/tbody/tr[contains(@ng-if, 'baseLinePlanType')]";
				List<WebElement> listOfRowsPerTable = driver.findElements(By.xpath(rowXpath));
				String key = "";
				String value = "";
				String MonthlyPremium = driver
						.findElement(By.xpath(("//*[@id='baseline-benefits-popup']/div/table/tbody/tr/td"))).getText();
				System.out.println(MonthlyPremium);
				key = MonthlyPremium;
				String MonthlyPremiumValue = driver
						.findElement(By.xpath(("//*[@id='baseline-benefits-popup']/div/table/tbody/tr/td[2]/span")))
						.getText();
				System.out.println(MonthlyPremiumValue);
				value = MonthlyPremiumValue;
				result.put(key, value);

				for (int rowIndex = 1; rowIndex < 2; rowIndex++) { // note: loop through each row
					String cellsXpath = "", benefitValueXpath = "";
					String rowText = "", benefitValueText = "";

					cellsXpath = rowXpath + "[" + rowIndex + "]" + "/td";

					benefitValueXpath = rowXpath + "[" + rowIndex + "]" + "/td/span";// xpath for the benefit value for
																						// the cell

					// the below code gets the benefit name from the table before the : symbol
					WebElement e = driver.findElement(By.xpath(cellsXpath));
					rowText = e.getText();
					System.out.println(rowText);

					key = rowText;

					// the below code gets the benefit value from the table after the : symbol
					WebElement j = driver.findElement(By.xpath(benefitValueXpath));

					benefitValueText = j.getText();
					System.out.println(benefitValueText);
					value = benefitValueText;

					result.put(key, value);
				}

				WebElement Close = driver.findElement(By.xpath(("//*[@ng-click='closeBaseLinePopup()']/div")));
				Close.click();
			} catch (Exception e) {
				System.out.println("PDP Plan is not getting displayed");
			}
		}
		for (String keyValue : result.keySet()) {
			System.out.println("Key : " + keyValue + " Value: " + result.get(keyValue));
			System.out.println(
					"_________________________________________________________________________________________________");
		}
		return result;
	}

	public HashMap<Boolean, String> compareBaselineBenefits(String columnName, String benefitValue,
			HashMap<String, String> benefitsMap) {
		boolean flag = true;
		int counter = 0;
		String tmpUIString1 = "", tmpUIString2 = "", benefitValueUI = "", headerPremiumString = "";
		HashMap<Boolean, String> comparedResult = new HashMap<Boolean, String>();

		benefitValue = benefitValue.replaceAll("\\s+", "");

		for (String key : benefitsMap.keySet()) {
			benefitValueUI = benefitsMap.get(key).replaceAll("\\s+", "");

			tmpUIString1 = benefitValueUI;
			key = key.toLowerCase().trim();
			// key = key.replace(",", "");
			columnName = columnName.toLowerCase().trim();
			if (key.contains("%"))
				key = key.replaceAll("\\s+", "");
			if (columnName.contains("%"))
				columnName = columnName.replaceAll("\\s+", "");
			if ((benefitValue.contains("NA") || benefitValue.contains("N/A"))) {
				counter++;

				if (key.contains(columnName) && !columnName.equalsIgnoreCase("prescription drugs")) { 
					flag = false;
					tmpUIString2 = tmpUIString1;
					break;
				} else if (key.equalsIgnoreCase(columnName)) {
					flag = false;
					tmpUIString2 = tmpUIString1;
					break;
				}

			} else if (columnName.equalsIgnoreCase("prescription drugs")) {
				if (key.equalsIgnoreCase(columnName)) {
					counter++;
					if (benefitValueUI.equalsIgnoreCase(benefitValue)) {
						flag = true;
						break;
					} else {
						flag = false;
						System.out.println(sheetName + "_" + rowIndex + " - Values did not match for col:5 "
								+ columnName + " Excel: " + headerPremiumString + " | UI: " + benefitValueUI);
						tmpUIString2 = tmpUIString1;
						break;
					}
				}

			} else if (key.contains(columnName)) {

				counter++;
				benefitValueUI = benefitValueUI.replace("\n", "").replaceAll("\\s+", "");
				benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", "");

			} else if (columnName.contains(key)) {
				counter++;
				benefitValueUI = benefitValueUI.replaceAll("\\s+", "");
				benefitValue = benefitValue.replaceAll("\\s+", "");
				if (benefitValueUI.equalsIgnoreCase(benefitValue)) {
					flag = true;
					break;
				} else {
					flag = false;
					System.out.println(sheetName + "_" + rowIndex + " - Values did not match for col:4 " + columnName
							+ " Excel: " + benefitValue + " | UI: " + benefitValueUI);
					tmpUIString2 = tmpUIString1;
					break;
				}

			}
		}

		if (counter == 0) {
			flag = false;
			System.out.println(sheetName + "_" + rowIndex + " - Values did not match for col:5 " + columnName
					+ " Excel: " + benefitValue + " | UI: BENEFIT NOT FOUND");
			tmpUIString2 = "BENEFIT NOT FOUND ON THE UI";
		}

		comparedResult.put(flag, tmpUIString2);
		return comparedResult;

	}

	}
	

