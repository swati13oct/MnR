package pages.acquisition.dceredesign;

import acceptancetests.data.MRConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DCEDetailsPage extends UhcDriver {

    @FindBy(id = "planDetailsPage")
    private WebElement plandetails;

    private static String AARP_ACQISITION_PAGE_URL = MRConstants.AARP_URL;
    private static String AARP_ACQISITION_OFFLINE_PAGE_URL = MRConstants.AARP_URL_OFFLINE;
    private static String AARP_ACQISITION_PROD_PAGE_URL = MRConstants.AARP_URL_PROD;
    private static String UMS_ACQISITION_PAGE_URL = MRConstants.UHC_URL;
    private static String UMS_ACQISITION_OFFLINE_PAGE_URL = MRConstants.UHC_URL_OFFLINE;
    private static String UMS_ACQISITION_PROD_PAGE_URL = MRConstants.UHCM_URL_PROD;
    @Autowired
    MRScenario loginScenario;

    @FindBy(xpath="//h2[@class='heading-2 noborder text-blue-primary']")
    private WebElement planName;

    @FindBy(xpath="//h3[text()='Monthly Premium']/following-sibling::p")
    private WebElement monthly_Premium;

    public MRScenario getLoginScenario() {
        return loginScenario;
    }
    public DCEDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate();
    }

    public DCEDetailsPage(WebDriver driver, String site,String deeplinkUrl) {
        super(driver);
        PageFactory.initElements(driver, this);
        openAndValidate(site,deeplinkUrl);
    }


    public String getContent() {
        return plandetails.getText();
    }

    public String getPlanDetails() {
        // TODO write implementation of the method
        return null;
    }


    @Override
    public void openAndValidate() {
        //validate(backToAllPlans,30);
        validate(plandetails,10);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        threadsleep(5000);
        try {
            String drugJson = "{\"drugs\":[{\"brandName\":\"Lipitor\",\"dosageStrength\":\"Lipitor TAB 10MG\",\"drugId\":\"13158\",\"frequency\":\"Month\",\"drugType\":\"Brand\",\"drugDescriptionType\":\"(Brand)\",\"dosageID\":\"1N1V3S593B\",\"genericDosageID\":\"0JBCNTL5BC\",\"supplyLength\":\"Every 1 Month\",\"genericDosageName\":\"atorvastatin calcium TAB 10MG\",\"genericDrugId\":\"46497\",\"genericndcCode\":\"60505257808\",\"isGeneric\":true,\"packageName\":null,\"packageQuantity\":null,\"packageSize\":null,\"proxyNdcCode\":\"00071015523\",\"quantity\":30,\"genericDrugName\":\"atorvastatin calcium\",\"ariaid\":\"Lipitor\"}],\"zipCode\":\"\",\"countyObj\":null,\"pharmacy\":{\"distanceFromSearchLocation\":1012.71,\"eprescription\":true,\"indianTribalUnion\":false,\"latitude\":44.6936383,\"longTermCare\":false,\"longitude\":-93.2836152,\"mailOrder\":false,\"network\":\"true\",\"ninetyDay\":true,\"npiNumber\":\"1841206489YN\",\"pharmacyName\":\"Retail Chain Pharmacy\",\"pharmacyNumber\":\"2426814\",\"pharmacySaver\":false,\"pharmacyType\":\"4\",\"preferredNetwork\":false,\"retail\":true,\"twentyFourHour\":false,\"year\":null},\"sessionId\":\"90715139\"}";
            js.executeScript(String.format("window.localStorage.setItem('%s','%s');", "ucp_drugList", drugJson.replace("/","")));
        } catch (Exception e1) {
            System.out.println("data");
        }
        threadsleep(2000);
        driver.navigate().refresh();
        threadsleep(5000);
        try {
            if(driver.findElement(By.id("estimateYourDrugsLink")).isDisplayed()){
                driver.findElement(By.id("estimateYourDrugsLink")).click();
                threadsleep(5000);
                driver.findElement(By.id("adddrug")).click();
                driver.findElement(By.xpath("//input[contains(@id, 'drugsearch')]")).sendKeys("lipitor");
                driver.findElement(By.xpath("//button[(@id= 'search')]")).click();
                threadsleep(5000);
                driver.findElement(By.xpath("//uhc-list-item//button[contains(@aria-label, 'Select " + "Lipitor" + "')]")).click();
                threadsleep(5000);
                driver.findElement(By.xpath("//button//*[contains(text(),'Add to drug List')]")).click();
                threadsleep(2000);
                driver.findElement(By.xpath("(//button/span[text()='Next: Review Drug Costs'])[1]")).click();
            }
        }
        catch (Exception ex){
            if(driver.findElement(By.xpath("//a[@id='DrugListDetails']")).isDisplayed()){
                System.out.println("Link is Displayed");
                driver.findElement(By.xpath("//a[@id='DrugListDetails']")).click();
            }
        }
    }

    //this method is used for direct deeplink to plan details page for plan validation
    public void openAndValidate(String site, String deeplinkUrl) {

        String tempUrl = "";
        if ("AARP".equalsIgnoreCase(site)) {
            if (MRScenario.environment.equals("offline")) {
                tempUrl=AARP_ACQISITION_OFFLINE_PAGE_URL;
                driver.get(tempUrl+deeplinkUrl);
                checkModelPopup(driver,30);

            } else if (MRScenario.environment.equals("prod")) {
                tempUrl=AARP_ACQISITION_PROD_PAGE_URL+deeplinkUrl;
                driver.get(tempUrl+deeplinkUrl);
                checkModelPopup(driver,30);

            } else {
                tempUrl=AARP_ACQISITION_PAGE_URL;
                driver.get(tempUrl+deeplinkUrl);
                //checkModelPopup(driver,10);

            }
            System.out.println("Current page URL: "+driver.getCurrentUrl());
        }else {
            if (MRScenario.environment.equals("offline")) {
                tempUrl=UMS_ACQISITION_OFFLINE_PAGE_URL;
                driver.get(tempUrl+deeplinkUrl);
                checkModelPopup(driver);

            } else if (MRScenario.environment.equals("prod")) {
                tempUrl=UMS_ACQISITION_PROD_PAGE_URL+deeplinkUrl;
                driver.get(tempUrl+deeplinkUrl);
                checkModelPopup(driver);

            } else {
                tempUrl=UMS_ACQISITION_PAGE_URL;
                driver.get(tempUrl+deeplinkUrl);
                //checkModelPopup(driver,20);
            }
            System.out.println("Current page URL: "+driver.getCurrentUrl());
        }

    }

    public HashMap<String, String> collectInfoDCEPlanDetailPg(String sheetName, int rowIndex) {
        HashMap<String, String> result=new HashMap<String, String>();

        for (int i = 0; i < 5; i++) {
            try {
                result = collectInfoVppPlanDetailPg();
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

    public HashMap<String, String> collectInfoVppPlanDetailPg() {
        System.out.println("Proceed to collect the info on DCE detail page =====");

        HashMap<String, String> result=new HashMap<String, String>();

        result.put("Plan Name", planName.getText());
        result.put("Monthly Premium", monthly_Premium.getText());
//        String key="Total Tabs";
//        String value = "";
//        result.put(key, String.valueOf(listOfTabHeaders.size()));
//        //	System.out.println("TEST - "+forWhat+" - key="+key+" | value="+result.get(key));
//
//        for (int tab=0; tab<listOfTabHeaders.size(); tab++) { //note: loop through each table and store info
//            listOfTabHeaders.get(tab).click();
//            sleepBySec(3);
//            int tabIndex=(tab+1);
//            CommonUtility.checkPageIsReady(driver);
//
//            //System.out.println("Before Tab: "+tabIndex+" "+new Timestamp(System.currentTimeMillis()));
//
//            WebElement estimatedTotalValue =null;
//            String estimatedTotalXpath = "//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')][1]//table//tr[not(contains(@class,'ng-hide'))]//*[contains(text(),'Estimated')]/ancestor::td//following-sibling::td";
//
//            if(listOfTabHeaders.get(tab).getText().contains("Plan Costs")) {
//                estimatedTotalValue=driver.findElement(By.xpath(estimatedTotalXpath));System.out.println(estimatedTotalValue.getText());
//                result.put("Estimated Annual Total No riders", estimatedTotalValue.getText());
//            }
//            //note: store section table
//            int numSectionTable=listOfSectionHeaderForActiveTab.size();
//            //result.put("Total Sections Per T"+tabIndex,String.valueOf(numSectionTable));
//
//            for(int sectionIndex=1; sectionIndex<=numSectionTable; sectionIndex++) { //note: loop through each section table
//                String rowXpath="";
//                if(tab==0)
//                    rowXpath ="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table[not(contains(@class,'drug')) and not(contains(@id,'network'))]//tr";
//                else
//                    rowXpath ="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr";
//
//                List<WebElement> listOfRowsPerTable=driver.findElements(By.xpath(rowXpath));
//                int numRows=listOfRowsPerTable.size();
//
//                //result.put("Total Rows For T"+tabIndex+"S"+sectionIndex,String.valueOf(numRows));
//
//                if (numRows==0) { //note: no table so check for box
//
//                    String boxXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')][1]//div[contains(@class,'box') and not(contains(@class,'ng-hide'))]";
//                    List<WebElement> listOfBoxes=driver.findElements(By.xpath(boxXpath));
//                    result.put("Total Boxs For T"+tabIndex+"S"+sectionIndex, String.valueOf(listOfBoxes.size()));
//
//                    for(int boxIndex=1; boxIndex<=listOfBoxes.size(); boxIndex++) { //note: loop through each box
//                        String eachBoxXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')][1]//div[contains(@class,'box') and not(contains(@class,'ng-hide'))]["+boxIndex+"]";
//
//                        WebElement e=driver.findElement(By.xpath(eachBoxXpath));
//                        key=e.getText();
//                        value=e.getText();
//                        result.put(key, value);
//                        System.out.println("TEST - key="+key+" | value="+result.get(key));
//                    }
//
//                    //note: assume this is the optional service tab
//                    //note: after going through all the box should be no more section, don't iterate the rest of the section counts
//                    break;
//                } else {
//
//                    for(int rowIndex=1; rowIndex<=listOfRowsPerTable.size(); rowIndex++) { //note: loop through each row
//                        String cellsPerRowXpath="";
//                        value = "";
//
//                        if(tab==0)
//                            cellsPerRowXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table[not(contains(@class,'drug')) and not(contains(@id,'network'))]//tr["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]";
//                        else
//                            cellsPerRowXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr[not(contains(@class,'ng-hide'))]["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]";
//
//                        List<WebElement> listOfCellsPerRow=driver.findElements(By.xpath(cellsPerRowXpath));
//
//                        for (int cellIndex=1; cellIndex<=listOfCellsPerRow.size(); cellIndex++) {
//                            String eachCellXpath = "";
//
//                            if(tab==0)
//                                eachCellXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table[not(contains(@class,'drug')) and not(contains(@id,'network'))]//tr["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]["+cellIndex+"]";
//                            else
//                                eachCellXpath="//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr[not(contains(@class,'ng-hide'))]["+rowIndex+"]//td[not(contains(@class,'ng-hide'))]["+cellIndex+"]";
//
//
//                            WebElement e=driver.findElement(By.xpath(eachCellXpath));
//                            if(e.getText().contains("Platinum Dental") && e.getText().contains("Optional Rider")) {
//                                platinumDentalCheckbox.click();
//                                result.put("Estimated Annual Total Platinum Dental",estimatedTotalValue.getText());
//                            }
//
//                            if(listOfCellsPerRow.size()==2) {
//                                System.out.println(e.getText());
//                                if(cellIndex==1 && e.getText().contains("High Option Dental") && e.getText().contains("Optional Rider") ) {
//                                    highOptionDentalCheckbox.click();
//                                    key=e.getText();
//                                    WebElement g = driver.findElement(By.xpath("//div[contains(@id,'detail') and contains(@class,'active')]//div[contains(@class,'plan-benefits')]["+sectionIndex+"]//table//tr[not(contains(@class,'ng-hide'))]["+rowIndex+"]//td["+(cellIndex+1)+"]"));
//                                    value = g.getText();
//                                    result.put("Estimated Annual Total High Option Dental",estimatedTotalValue.getText());
//                                    //optionalDentalCheckbox.click();
//
//                                }else if(cellIndex==1) {
//                                    key=e.getText();//System.out.println("key :"+ key);
//                                }else {
//                                    value = value + e.getText();//System.out.println("after :"+ value);
//                                }
//                            }else if(listOfCellsPerRow.size()==3){
//                                if(cellIndex==1)
//                                    key=e.getText();
//                                else if(cellIndex==3)
//                                    value= value+"/"+e.getText();
//                                else
//                                    value= value+e.getText();
//                            }else {
//                                if(cellIndex==1) {
//                                    key=e.getText();
//                                    value= e.getText();
//
//                                }else {
//                                    value= value+e.getText();
//
//                                }
//
//                            }
//                            result.put(key, value);
//                        }
//                    }
//                }
//            }
//        }
//        System.out.println("Finished collecting the info on vpp detail page =====");
//
//        for(String keyValue : result.keySet()) {
//            System.out.println("Key : "+keyValue+" Value: "+result.get(keyValue));
//            System.out.println(
//                    "_________________________________________________________________________________________________"
//            ); }

//        return result;
        return null ;
    }

    public HashMap<Boolean, String> compareBenefits(String columnName, String benefitValue, Map<String, String> benefitsMap) {
        boolean flag = false; int counter =0;
        String tmpUIString1 = "",tmpUIString2="", tmpKeyString="",benefitValueUI="";
        HashMap<Boolean, String> comparedResult = new HashMap<Boolean, String>();

        if(columnName.equalsIgnoreCase("Plan Premium Zero"))
            columnName = columnName.replace(" Zero", "");
        for(String key : benefitsMap.keySet()) {
            benefitValueUI = benefitsMap.get(key);
            tmpUIString1 = benefitValueUI; 												//storing the original benefit value before string manipulation
            tmpKeyString = key; 														//storing the original key value (benefit name from the UI) before string manipulation
            benefitValueUI = benefitValueUI.replace("\n", "").replaceAll("\\s+", "").replaceAll("\\*",""); 	//replace all the next lines and spaces from the string
            benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", "").replaceAll("\\*",""); 		//replace all the next lines and spaces from the string
            benefitValueUI= benefitValueUI.replaceAll("\\[~/n~]", "");
            benefitValueUI= benefitValueUI.replaceAll("\\[~/n~}", "");
            benefitValueUI= benefitValueUI.replaceAll("\\[~/n~", "");

            if(key.contains("Passport"))
                key = key.replaceAll("\\u00AE", "").replace("(","").replace(")","");   //removes special characters like the Registered symbol

            key = key.toLowerCase();
            columnName = columnName.toLowerCase();
            benefitValue = benefitValue.toLowerCase();
            benefitValueUI = benefitValueUI.toLowerCase();
            if(columnName.startsWith("tier") && !columnName.contains(":") && key.startsWith("tier"))
                key = key.replace(":","");

            if(key.contains("monthly premium")) {
                key = key.replace("\n", "").replaceAll("footnote1", "").replaceAll("footnote", "");
            }

            if(key.endsWith("1"))
                key = 	StringUtils.trimTrailingCharacter(key, '1');
            else if(key.endsWith("2"))
                key = 	StringUtils.trimTrailingCharacter(key, '2');
            else if(key.contains("fitness")) {
                key = key.replace("\n", "").replaceAll("footnote", "");
            }

            if(key.contains("initial coverage stage")||columnName.contains("initial coverage stage")) {
                key.replaceAll("\\s+", "");
                columnName.replaceAll("\\s+", "");
            }

            //removing all the footnote words from the UI string and the superscripts
            if(!(key.equalsIgnoreCase("monthly premium")||key.contains("plan premium")||key.contains("optional rider")||key.contains("estimated annual total") || key.contains("part b"))) {
                if(benefitValueUI.endsWith("footnote2"))
                    benefitValueUI = benefitValueUI.replace("footnote2", "");
                else if(benefitValueUI.endsWith("footnote1"))
                    benefitValueUI = benefitValueUI.replace("footnote1", "");
                else if(benefitValueUI.endsWith("1"))
                    benefitValueUI = 	StringUtils.trimTrailingCharacter(benefitValueUI, '1');
                else if(benefitValueUI.endsWith("2"))
                    benefitValueUI = 	StringUtils.trimTrailingCharacter(benefitValueUI, '2');
                else if(benefitValueUI.contains("Out-of-NetworkBenefits")&&columnName.equalsIgnoreCase("Out-of-Network Benefits")) {
                    benefitValueUI = benefitValueUI.replace("Opensinanewwindow", "");
                    benefitValue = benefitValue.replace("Opensinanewwindow", "");
                }else if(key.equalsIgnoreCase("Routine Dental")||key.equalsIgnoreCase("Out-of-Network Benefits")) {
                    //benefitValueUI = benefitValueUI.replace("Ismydentistcoveredforthisplan?", "");
                    benefitValueUI = benefitValueUI.replace("-opensinnewwindow", "");
                    benefitValueUI = benefitValueUI.replace("opensinanewwindow", "");
                    benefitValueUI = benefitValueUI.replace("opensinnewwindow", "");
                }

                if(columnName.contains("eye exam")&&benefitValue.endsWith("1")) {
                    benefitValue = 	StringUtils.trimTrailingCharacter(benefitValue, '1');
                }
            }
            //removing footnote values from the end of the key values if any


            //if excel marks NA for the benefit then the following code validates the benefit isn't showing on the UI
            if((benefitValue.equalsIgnoreCase("NA")||benefitValue.equalsIgnoreCase("N/A"))) {
                counter++;
                flag = true;
                if(columnName.equalsIgnoreCase("Part B Premium Reduction") || columnName.equalsIgnoreCase("Platinum DentalPS") || columnName.equalsIgnoreCase("Optional Dental") ||columnName.equalsIgnoreCase("High Option Dental") ||columnName.equalsIgnoreCase("Footnotes") ||columnName.equalsIgnoreCase("Dental Platinum") ||columnName.equalsIgnoreCase("SilverSneakers") ||columnName.equalsIgnoreCase("Silver SneakersPS") || columnName.equalsIgnoreCase("Optional DentalPS") ||columnName.equalsIgnoreCase("High Option DentalPS")) {
                    columnName = columnName.replace("PS","");
                    if(key.contains(columnName)) {
                        flag = false;
                        if(key.contains("footnotes") && columnName.equalsIgnoreCase("footnotes"))
                            tmpUIString2 = tmpKeyString;
                        else
                            tmpUIString2 = tmpUIString1;
                        break;
                    }

                }else if(key.equalsIgnoreCase(columnName)) {
                    flag= false;
                    tmpUIString2 = tmpUIString1;
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
                        tmpUIString2 = tmpUIString1;
                        break;
                    }

                }
                columnName = columnName+"PS";
            }else if(columnName.equalsIgnoreCase("Dental Platinum")||columnName.equalsIgnoreCase("Optional Dental")||columnName.equalsIgnoreCase("High Option Dental") || columnName.equalsIgnoreCase("silversneakers")||columnName.equalsIgnoreCase("Footnotes")||columnName.equalsIgnoreCase("Estimated annual total")) {


                benefitValueUI = benefitValueUI.replaceAll("\\u2022", "");
                benefitValue = benefitValue.replaceAll("\\u2022", "");
                benefitValueUI = benefitValueUI.replaceAll("\\u00AE", "");
                benefitValue = benefitValue.replaceAll("\\u00AE", "");
                if(columnName.equalsIgnoreCase("Footnotes")&& key.contains("footnotes")) {
                    key = key.replace("\n", "");
                    key = key.replaceAll("\\s+", "").replaceAll("\\*", "");
                    counter++;
                    //removing footnote values from the string

                    if(key.contains("footnote1") || key.contains("footnotes1")) {
                        key = key.replaceAll("footnote1", "");
                        key = key.replaceAll("footnotes1", "");
                    }else if(key.contains("footnote2")||key.contains("footnotes2")) {
                        key = key.replaceAll("footnote2", "");
                        key = key.replaceAll("footnotes2", "");
                    }


                    //removing footnote values from the string
                    if(key.contains(".2"))
                        key = key.replace(".2", ".");
                    else if(key.contains(".1"))
                        key = key.replace(".1", ".");
                    else if(key.contains(".3"))
                        key = key.replace(".3", ".");

                    //key = key.replaceAll(".", "");
                    benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", ""); //.replaceAll("-", "").replaceAll(".", "");
                    benefitValue = benefitValue.toLowerCase();
                    benefitValue = benefitValue.replaceAll("\\*", "").replace("footnotes2", "");
                    benefitValue = benefitValue.replace("footnotes", "");
                    if(key.contains(benefitValue)) {
                        flag = true;break;
                    }else {
                        flag = false;
                        System.out.println("Values did not match for col:2 "+columnName+"\n Excel value: "+benefitValue+"\n UI Value: "+key);
                        tmpUIString2 = tmpKeyString;
                        break;
                    }


                }else if(key.contains(columnName)&& !key.contains("optional rider")) {
                    counter++;
                    if(benefitValueUI.contains(benefitValue)||benefitValueUI.equalsIgnoreCase(benefitValue)) {
                        flag = true;break;
                    }else {
                        flag = false;
                        System.out.println("Values did not match for col:3 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
                        tmpUIString2 = tmpUIString1;
                        break;
                    }
                }
            }else if(columnName.equalsIgnoreCase("Monthly Premium") ||columnName.equalsIgnoreCase("Routine Dental") || columnName.equalsIgnoreCase("Coverage Gap Stage")|| columnName.equalsIgnoreCase("Preferred Retail Pharmacy Network")){


                if(key.equalsIgnoreCase("Preferred Retail Pharmacy Network") ) {
                    if(benefitValueUI.contains("footnote1"))
                        benefitValueUI = benefitValueUI.replace("footnote1", "");
                    else if(benefitValueUI.contains("1."))
                        benefitValueUI = benefitValueUI.replace("1.", ".");

                    if(benefitValueUI.contains(".2"))
                        benefitValueUI = benefitValueUI.replace(".2", ".");
                    else if(benefitValueUI.contains(".1"))
                        benefitValueUI = benefitValueUI.replace(".1", ".");
                }
                benefitValue = benefitValue.replace("-opensinnewwindow", "");
                if(key.equalsIgnoreCase(columnName)) {
                    counter++;
                    benefitValueUI = benefitValueUI.replace("/", "");

                    if(benefitValueUI.equalsIgnoreCase(benefitValue)) {
                        flag = true;break;
                    }else {
                        flag = false;
                        System.out.println("Values did not match for col:4 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
                        tmpUIString2 = tmpUIString1;
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
                else if(benefitValueUI.contains("/") &&!benefitValueUI.contains("mydoctor"))
                    benefitValueUI =benefitValueUI.replaceAll("/", "");
                else if(key.equalsIgnoreCase("plan name")) {
                    benefitValueUI = benefitValueUI.substring(0, benefitValueUI.indexOf(")")+1);
                }
                else if(benefitValueUI.contains("monthlyvaries2")) {
                    benefitValueUI = benefitValueUI.replaceAll("monthlyvaries2", "monthlyvaries");
                }
                if(!columnName.contains("doctors/providers"))
                    benefitValueUI = benefitValueUI.replaceAll("/", "");

						/*if(key.equalsIgnoreCase("Walgreens – Preferred Retail Pharmacy")) {
							 if(benefitValueUI.contains(".1"))
								benefitValueUI = benefitValueUI.replace(".1", "");
						}*/

                //the following code is only needed for the specific benefit values where we have to remove the footnote values form the end
                if( key.equalsIgnoreCase("Preferred Mail Home Delivery through OptumRx")) {
                    if(benefitValueUI.contains(".2"))
                        benefitValueUI = benefitValueUI.replace(".2", ".");
                }else if(columnName.equalsIgnoreCase("Estimated Annual Total")||columnName.equalsIgnoreCase("Preventive services")||columnName.equalsIgnoreCase("Special Eligibility Requirement")) {
                    if(benefitValueUI.contains(benefitValue)) {
                        flag=true; break;
                    }else {
                        flag=false;
                        System.out.println("Values did not match for col:5 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
                        tmpUIString2 = tmpUIString1;
                        break;
                    }
                }

                if(benefitValueUI.equalsIgnoreCase(benefitValue)) {
                    flag = true;break;
                }else {
                    flag = false;
                    System.out.println("Values did not match for col:6 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
                    tmpUIString2 = tmpUIString1;
                    break;
                }

            }
        }


        if(counter == 0) {
            flag = false;
            System.out.println("Values did not match for col:7 "+columnName+" Excel: "+benefitValue+" | UI: BENEFIT NOT FOUND");
            tmpUIString2 = "BENEFIT NOT FOUND ON THE UI";
        }

        comparedResult.put(flag, tmpUIString2);
        return comparedResult;

    }

}
