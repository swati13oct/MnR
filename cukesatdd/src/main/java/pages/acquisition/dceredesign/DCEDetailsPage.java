package pages.acquisition.dceredesign;

import acceptancetests.data.MRConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import atdd.framework.UhcDriver;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.text.DecimalFormat;
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

    @FindBy(xpath="//h2[text()='Coverage Gap Stage']/../../../../../..//p")
    private WebElement coverageGapStageModalText;

    @FindBy(xpath="//h2[text()='Catastrophic Coverage Stage']/../../../../../..//p")
    private WebElement catastrophicCoverageStageModalText;

    @FindBy(xpath="//h2[text()='Initial Coverage Stage']/../../../../../..//p")
    private WebElement initialCoverageStageModalText;

    @FindBy(xpath="//button[text()='What is the Initial Coverage stage?']")
    private WebElement initialCoverageStageModalLink;

    @FindBy(xpath="//button[text()=' What is the Coverage Gap stage?']")
    private WebElement coverageGapStageModalLink;

    @FindBy(xpath="//button[text()=' What is the Catastrophic Coverage stage?']")
    private WebElement catastrophicCoverageStageModalLink;

    @FindBy(xpath="//h2[text()='Initial Coverage Stage']/../../../../../..//span[text()='Done']")
    private WebElement initialCoverageStageModalCloseBtn;

    @FindBy(xpath="//h2[text()='Coverage Gap Stage']/../../../../../..//span[text()='Done']")
    private WebElement coverageGapStageModalCloseBtn;

    @FindBy(xpath="//h2[text()='Catastrophic Coverage Stage']/../../../../../..//span[text()='Done']")
    private WebElement catastrophicCoverageStageModalCloseBtn;

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
        String ReturnValue = "";
        validate(plandetails,10);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        threadsleep(5000);
        try {
            ReturnValue = (String) js
                    .executeScript(String.format("return window.getCookieDataInStringFormat('%s')", "userSessionCookie"));
            threadsleep(5000);
            String drugJson = "{\"drugs\":[{\"brandName\":\"Lipitor\",\"dosageStrength\":\"Lipitor TAB 10MG\",\"drugId\":\"13158\",\"frequency\":\"Month\",\"drugType\":\"Brand\",\"drugDescriptionType\":\"(Brand)\",\"dosageID\":\"1N1V3S593B\",\"genericDosageID\":\"0JBCNTL5BC\",\"supplyLength\":\"Every 1 Month\",\"genericDosageName\":\"atorvastatin calcium TAB 10MG\",\"genericDrugId\":\"46497\",\"genericndcCode\":\"60505257808\",\"isGeneric\":true,\"packageName\":null,\"packageQuantity\":null,\"packageSize\":null,\"proxyNdcCode\":\"00071015523\",\"quantity\":30,\"genericDrugName\":\"atorvastatin calcium\",\"ariaid\":\"Lipitor\"}],\"zipCode\":\"\",\"countyObj\":null,\"pharmacy\":{\"distanceFromSearchLocation\":1012.71,\"eprescription\":true,\"indianTribalUnion\":false,\"latitude\":44.6936383,\"longTermCare\":false,\"longitude\":-93.2836152,\"mailOrder\":false,\"network\":\"true\",\"ninetyDay\":true,\"npiNumber\":\"1841206489YN\",\"pharmacyName\":\"Retail Chain Pharmacy\",\"pharmacyNumber\":\"2426814\",\"pharmacySaver\":false,\"pharmacyType\":\"4\",\"preferredNetwork\":false,\"retail\":true,\"twentyFourHour\":false,\"year\":null},\"sessionId\":\"90715139\"}";
            js.executeScript(String.format("window.localStorage.setItem('%s','%s');", "ucp_drugList", drugJson.replace("90715139",ReturnValue)));
        } catch (Exception e1) {
            System.out.println("data");
        }
        threadsleep(2000);
        driver.navigate().refresh();
        threadsleep(5000);
        driver.findElement(By.xpath("//a[@id='prescriptiondrug']")).click();
        threadsleep(2000);
        try {
            if(driver.findElement(By.xpath("//a[@id='DrugListDetails']")).isDisplayed()){
                System.out.println("Link is Displayed");
                driver.findElement(By.xpath("//a[@id='DrugListDetails']")).click();
                threadsleep(5000);
                driver.findElement(By.xpath("(//button/span[text()='Next: Review Drug Costs'])[1]")).click();
            }
        }
        catch (Exception ex){

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
                result = collectInfoVppPlanDetailPg(sheetName);
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

    public HashMap<String, String> collectInfoVppPlanDetailPg(String sheetName) {
        System.out.println("Proceed to collect the info on DCE detail page =====");

        String sessionID = "";
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        threadsleep(5000);
        try {
            sessionID = (String) js
                    .executeScript(String.format("return window.getCookieDataInStringFormat('%s')", "userSessionCookie"));
        } catch (Exception e1) {
        }
        String pharmacyJson = "";
        threadsleep(5000);
        try {
            pharmacyJson = (String) js
                    .executeScript(String.format("return window.localStorage.getItem('%s')", "ucp_drugList"));
        } catch (Exception e1) {
        }
        Object obj = null;
        JSONObject jo = null;
        try {
            obj = new JSONParser().parse(pharmacyJson);
            jo = (JSONObject) obj;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        threadsleep(5);
        //List<WebElement> drugCopays = driver.findElements(By.xpath("(//div[@id='copayInsuranceSection']//ul)[1]//li//span"));
        //List<WebElement> drugCopays = driver.findElements(By.xpath("(//h3[text()='Drug Copays & Coinsurance']/../..//ul)[1]//span"));

        HashMap<String, String> result=new HashMap<String, String>();

        result.put("Plan Name", planName.getText());
        result.put("Monthly Premium", monthly_Premium.getText());

//        coverageGapStageModalLink.click();
//        result.put("Coverage Gap Stage",coverageGapStageModalText.getText());
//        coverageGapStageModalCloseBtn.click();
//
//        catastrophicCoverageStageModalLink.click();
//        result.put("Catastrophic Coverage Stage",catastrophicCoverageStageModalText.getText());
//        catastrophicCoverageStageModalCloseBtn.click();
//
//        initialCoverageStageModalLink.click();
//        result.put("Initial Coverage Stage",initialCoverageStageModalText.getText());
//        initialCoverageStageModalCloseBtn.click();

        if(sheetName.contains("MAPD_SNP_DCE")){
            for(int i = 0; i < 2 ; i++){
                if(i == 0){
                    setPharmacy("Preferred Mail", sessionID , jo);
                    List<WebElement> drugCopays = driver.findElements(By.xpath("//h3[text()='Drug Copays & Coinsurance']/../..//span"));
                    for(int j = 0; j < drugCopays.size(); j++){

                        try {
                            Integer.parseInt(drugCopays.get(j).getText().trim().split("")[1]);
                            continue;
                        }
                        catch (Exception ex){ }

                        if(drugCopays.get(j).getText().contains("Tier 1 (Preferred Generic)")){
                            result.put("Tier 1 Prefered Mail Order", drugCopays.get(j+1).getText());
                        }
                        else if(drugCopays.get(j).getText().contains("Tier 2 (Generic)")){
                            result.put("Tier 2 Prefered Mail Order", drugCopays.get(j+1).getText());
                        }
                        else if(drugCopays.get(j).getText().contains("Tier 3 (Preferred Brand)")){
                            result.put("Tier 3 Prefered Mail Order", drugCopays.get(j+1).getText());
                        }
                        else if(drugCopays.get(j).getText().contains("Tier 3 (Select Insulin Drugs)")){
                            result.put("Tier 3 Preferred Mail Order (Insulin)", drugCopays.get(j+1).getText());
                        }
                        else if(drugCopays.get(j).getText().contains("Tier 4 (Non-Preferred)")){
                            result.put("Tier 4 Prefered Mail Order", drugCopays.get(j+1).getText());
                        }
                        else if(drugCopays.get(j).getText().contains("Tier 5 (Specialty)")){
                            if(!drugCopays.get(j+1).getText().contains("N/A")) {
                                result.put("Tier 5: Specialty Tier Drugs", drugCopays.get(j + 1).getText());
                            }
                            break;
                        }
                    }
                }
                if(i == 1){
                    setPharmacy("Standard Retail", sessionID , jo);
                    List<WebElement> drugCopays = driver.findElements(By.xpath("//h3[text()='Drug Copays & Coinsurance']/../..//span"));
                    for(int j = 0; j < drugCopays.size(); j++){

                        try {
                            Integer.parseInt(drugCopays.get(j).getText().trim().split("")[1]);
                            continue;
                        }
                        catch (Exception ex){ }

                        if(drugCopays.get(j).getText().contains("Tier 1 (Preferred Generic)")){
                            result.put("Tier 1 Standard Network Pharmacy", drugCopays.get(j+1).getText());
                        }
                        else if(drugCopays.get(j).getText().contains("Tier 2 (Generic)")){
                            result.put("Tier 2 Standard Network Pharmacy", drugCopays.get(j+1).getText());
                        }
                        else if(drugCopays.get(j).getText().contains("Tier 3 (Preferred Brand)")){
                            result.put("Tier 3 Standard Network Pharmacy", drugCopays.get(j+1).getText());
                        }
                        else if(drugCopays.get(j).getText().contains("Tier 3 (Select Insulin Drugs)")){
                            result.put("Tier 3 Standard Network Pharmacy (Insulin)", drugCopays.get(j+1).getText());
                        }
                        else if(drugCopays.get(j).getText().contains("Tier 4 (Non-Preferred)")){
                            result.put("Tier 4 Standard Network Pharmacy", drugCopays.get(j+1).getText());
                        }
                        else if(drugCopays.get(j).getText().contains("Tier 5 (Specialty)")){
                            result.put("Tier 5: Specialty Tier Drugs", drugCopays.get(j+1).getText().replace("%",""));
                            break;
                        }
                    }
                }
            }
        }
        else if(sheetName.contains("MAPD_Preferred") || sheetName.contains("PDP_Preferred")){
            for(int i = 0; i < 3 ; i++){
                if(i == 0){
                    setPharmacy("Preferred Mail", sessionID , jo);
                    //8drugCopayDeductible = new HashMap<String, String>();
                }
                if(i == 1){
                    setPharmacy("Standard Retail", sessionID , jo);
                    //drugCopayDeductible = new HashMap<String, String>();
                }
                if(i == 2){
                    setPharmacy("Preferred Retail", sessionID , jo);
                    //drugCopayDeductible = new HashMap<String, String>();
                }
//                drugCopayDeductible.put("","");
//                drugCopayDeductible.put("","");
//                drugCopayDeductible.put("","");
//                drugCopayDeductible.put("","");
//                drugCopayDeductible.put("","");
//                drugCopayDeductibleAllType.put("",drugCopayDeductible);

            }
        }

        System.out.println("Finished collecting the info on vpp detail page =====");

        for(String keyValue : result.keySet()) {
            System.out.println("Key : "+keyValue+" Value: "+result.get(keyValue));
            System.out.println(
                    "_________________________________________________________________________________________________"
            ); }

        return result;
    }

    private void setPharmacy(String pharmacyType , String sessionID , JSONObject jo){
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        if(pharmacyType.equalsIgnoreCase("Preferred Mail")){
           String preferredMail = "{\n" +
                    "\t\t\"pharmacyAddress\": null,\n" +
                    "\t\t\"pharmacyName\": \"OptumRx Mail Service Pharmacy\",\n" +
                    "\t\t\"pharmacyNumber\": \"05TSC\",\n" +
                    "\t\t\"pharmacySaver\": null,\n" +
                    "\t\t\"preferredNetwork\": null,\n" +
                    "\t\t\"mailOrder\": true\n" +
                    "\t}";
            JSONParser parser = new JSONParser();
            JSONObject jsonPharmaCY = null;
            try {
                jsonPharmaCY = (JSONObject) parser.parse(preferredMail);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            jo.remove("pharmacy");
            jo.put("pharmacy",jsonPharmaCY);
            jo.put("sessionId",sessionID);
            try {
                threadsleep(5000);
                js.executeScript(String.format("window.localStorage.setItem('%s','%s');", "ucp_drugList", jo.toString()));
            } catch (Exception e1) {
            }
            driver.navigate().refresh();
        }
        else if(pharmacyType.equalsIgnoreCase("Standard Retail")){
            String standardRetail = "{\n" +
                    "\t\t\"pharmacyAddress\": {\n" +
                    "\t\t\t\"addressLine1\": \"1116 WHEELING AVE\",\n" +
                    "\t\t\t\"addressLine2\": \"\",\n" +
                    "\t\t\t\"city\": \"CAMBRIDGE\",\n" +
                    "\t\t\t\"state\": \"OH\",\n" +
                    "\t\t\t\"zipCode\": \"43725\",\n" +
                    "\t\t\t\"phoneNumber\": \"7404393502\",\n" +
                    "\t\t\t\"tty\": \"711\"\n" +
                    "\t\t},\n" +
                    "\t\t\"pharmacyName\": \"CVS PHARMACY #03472 03472\",\n" +
                    "\t\t\"pharmacyNumber\": \"3610551\",\n" +
                    "\t\t\"pharmacySaver\": false,\n" +
                    "\t\t\"preferredNetwork\": false,\n" +
                    "\t\t\"mailOrder\": false\n" +
                    "\t}";
            JSONParser parser = new JSONParser();
            JSONObject jsonPharmaCY = null;
            try {
                jsonPharmaCY = (JSONObject) parser.parse(standardRetail);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            jo.remove("pharmacy");
            jo.put("pharmacy",jsonPharmaCY);
            jo.put("sessionId",sessionID);
            try {
                threadsleep(5000);
                js.executeScript(String.format("window.localStorage.setItem('%s','%s');", "ucp_drugList", jo.toString()));
            } catch (Exception e1) {
            }
            driver.navigate().refresh();
        }
        else{
            String preferredRetail = "{\n" +
                    "\t\t\"pharmacyAddress\": {\n" +
                    "\t\t\t\"addressLine1\": \"957 CURRY ROAD\",\n" +
                    "\t\t\t\"addressLine2\": null,\n" +
                    "\t\t\t\"city\": \"ROTTERDAM\",\n" +
                    "\t\t\t\"state\": \"NY\",\n" +
                    "\t\t\t\"zipCode\": \"12306\",\n" +
                    "\t\t\t\"phoneNumber\": \"5183566310\",\n" +
                    "\t\t\t\"tty\": \"711\"\n" +
                    "\t\t},\n" +
                    "\t\t\"pharmacyName\": \"WALGREENS #19611 19611\",\n" +
                    "\t\t\"pharmacyNumber\": \"5821928\",\n" +
                    "\t\t\"pharmacySaver\": false,\n" +
                    "\t\t\"preferredNetwork\": true,\n" +
                    "\t\t\"mailOrder\": false\n" +
                    "\t}";
            JSONParser parser = new JSONParser();
            JSONObject jsonPharmaCY = null;
            try {
                jsonPharmaCY = (JSONObject) parser.parse(preferredRetail);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            jo.remove("pharmacy");
            jo.put("pharmacy",jsonPharmaCY);
            jo.put("sessionId",sessionID);
            try {
                threadsleep(5000);
                js.executeScript(String.format("window.localStorage.setItem('%s','%s');", "ucp_drugList", jo.toString()));
            } catch (Exception e1) {
            }
            driver.navigate().refresh();
        }

    }

    public HashMap<Boolean, String> compareBenefits(String columnName, String benefitValue, Map<String, String> benefitsMap) {
        boolean flag = false; int counter =0;
        String tmpUIString1 = "",tmpUIString2="", tmpKeyString="",benefitValueUI="";
        HashMap<Boolean, String> comparedResult = new HashMap<Boolean, String>();

        if(columnName.equalsIgnoreCase("Tier 5: Specialty Tier Drugs")){

            DecimalFormat df = new DecimalFormat("0.00");
            df.setMaximumFractionDigits(0);
            benefitValue = df.format(Float.parseFloat(benefitValue)*100);

        }

        if(benefitsMap.get(columnName).contains(benefitValue)) {
            flag = true;
        }else {
            flag = false;
            System.out.println("Values did not match for col:6 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
            tmpUIString2 = benefitsMap.get(columnName);
        }
//        for(String key : benefitsMap.keySet()) {
//            benefitValueUI = benefitsMap.get(key);
//            tmpUIString1 = benefitValueUI; 												//storing the original benefit value before string manipulation
//            tmpKeyString = key; 														//storing the original key value (benefit name from the UI) before string manipulation
////            benefitValueUI = benefitValueUI.replace("\n", "").replaceAll("\\s+", "").replaceAll("\\*",""); 	//replace all the next lines and spaces from the string
////            benefitValue = benefitValue.replace("\n", "").replaceAll("\\s+", "").replaceAll("\\*",""); 		//replace all the next lines and spaces from the string
////            benefitValueUI= benefitValueUI.replaceAll("\\[~/n~]", "");
////            benefitValueUI= benefitValueUI.replaceAll("\\[~/n~}", "");
////            benefitValueUI= benefitValueUI.replaceAll("\\[~/n~", "");
//                if(benefitValueUI.equalsIgnoreCase(benefitValue)) {
//                    flag = true;break;
//                }else {
//                    flag = false;
//                    System.out.println("Values did not match for col:6 "+columnName+" Excel: "+benefitValue+" | UI: "+benefitValueUI);
//                    tmpUIString2 = tmpUIString1;
//                    break;
//                }
//
//            }

//        if(counter == 0) {
//            flag = false;
//            System.out.println("Values did not match for col:7 "+columnName+" Excel: "+benefitValue+" | UI: BENEFIT NOT FOUND");
//            tmpUIString2 = "BENEFIT NOT FOUND ON THE UI";
//        }

        comparedResult.put(flag, tmpUIString2);
        return comparedResult;

    }

}
