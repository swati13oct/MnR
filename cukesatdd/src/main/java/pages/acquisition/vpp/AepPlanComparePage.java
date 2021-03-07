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


    public AepPlanComparePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    @Override
    public void openAndValidate() {


    }

    public HashMap<Boolean, String> compareBenefits(String columnName, String benefitValue, HashMap<String, String> benefitsMap) {
        boolean flag = true;
        int counter = 0;
        String tmpUIString1 = "", tmpUIString2 = "", benefitValueUI = "";
        HashMap<Boolean, String> comparedResult = new HashMap<Boolean, String>();
        for (String key : benefitsMap.keySet()) {
            benefitValueUI = benefitsMap.get(key);
            tmpUIString1 = benefitValueUI;
            key = key.toLowerCase();
            key = key.replace(":", "");

            columnName = columnName.toLowerCase().trim();
//			if(columnName.contains("tier"))
//				System.out.println();

            benefitValue = benefitValue.trim();

            if (benefitValue.contains("NA") || benefitValue.contains("N/A")) {
                counter++;
                if (!key.trim().equals(columnName.trim())) {
                    flag = true;
                    continue;
                }

                if ((key.trim().equals(columnName.trim())) && benefitValueUI.contains("N/A")) {
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

        threadsleep(2000);

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

        if (planType.startsWith("MA")) {

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

        String planNameXPath = "//table[contains(@id,'compare-table')]//thead/tr/th[2]/div/div";
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

        String rowXpath = "//table[contains(@id,'" + tableId + "')]//tbody//tr[contains(@class,'uhc')]";
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
}
