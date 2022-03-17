package acceptancetests.acquisition.dceredesign;

import acceptancetests.data.CommonConstants;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.dceredesign.DCEDetailsPage;
import pages.acquisition.vpp.AepPlanDetailsPage;
import pages.acquisition.vpp.VppCommonPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DCEPlanValidationStepDefinition {

    @Autowired
    MRScenario loginScenario;

    public MRScenario getLoginScenario() {
        return loginScenario;
    }

    @Then("^the user navigates to DCE plan details and compares benefits value from excel to UI and reports into excel$")
    public void exceldataValidation_planDetails(DataTable givenAttributes) throws Throwable {
        Map<String, String> givenAttributesMap = new HashMap<String, String>();
        givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
        String ExcelName = givenAttributesMap.get("ExcelFile");
        String sheetName = givenAttributesMap.get("WorkSheetName");
        String siteType = givenAttributesMap.get("Site");
        HashMap <String, Integer> benefitsColorMap = new HashMap<String, Integer>();
        ArrayList<Integer> benefitsArray = new ArrayList<Integer>();
        int counter =0, colorCounter = 0,cellCounter=0;
        WebDriver wd = getLoginScenario().getWebDriverNew();
        getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

        //Getting Date
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
        Date RunDate = new Date();
        String DateCreated = dateFormat.format(RunDate);
        String parentDirectory = null;
        parentDirectory = new java.io.File(".").getCanonicalPath();
        String InputFilePath = "";
        try{
            InputFilePath = parentDirectory+"/src/main/resources/database/PlanDocs/"+ExcelName+".xlsx";
        }
        catch (Exception ex){
            InputFilePath = parentDirectory+"/src/main/resources/database/PlanDocs/"+ExcelName+".xls";
        }

        String OutputFilePath = parentDirectory+"/target/DCEPlanValidation_Results_"+ExcelName+"_"+sheetName+"_"+siteType+"_"+DateCreated+".xls";

        //Reading Excel.xls file
        File InputFile = new File(InputFilePath);
        FileInputStream inputStream = new FileInputStream(InputFile);
        Workbook workbook = new XSSFWorkbook(inputStream);
        Sheet sheet = workbook.getSheet(sheetName);
        int lastRow =sheet.getLastRowNum();

        //Creating the results excel book
        Workbook ResultWorkbook = new HSSFWorkbook();
        Sheet ResultsSheet = ResultWorkbook.createSheet("PlanBenefitsResults");

        //Creating styles to use to highlight cells with colors
        CellStyle stylePassed = ResultWorkbook.createCellStyle();
        stylePassed.setFillForegroundColor(IndexedColors.GREEN.getIndex());
        stylePassed.setFillPattern(CellStyle.SOLID_FOREGROUND);

        CellStyle styleFailed = ResultWorkbook.createCellStyle();
        styleFailed.setFillForegroundColor(IndexedColors.RED.getIndex());
        styleFailed.setFillPattern(CellStyle.SOLID_FOREGROUND);
        try {
            DCEDetailsPage planDetailsPage = null;
            AcquisitionHomePage aquisitionhomepage = null;
            String currentCellValue = "";
            String currentColName = "";

            HashMap <String, String> benefitsMap = new HashMap<String, String>();
            System.out.println(sheetName+ " SAUCE URL: "+ getLoginScenario().returnJobURL());
            HSSFRow resultsRowNew = null;
            //Looping over total rows with values
            for(int rowIndex=0; rowIndex<=1; rowIndex++)
            {
                int failureCounter = 0, mcareFailureCounter = 0;
                int cellIndex = 0;
                XSSFRow row = (XSSFRow) sheet.getRow(rowIndex);
                Iterator<Cell> cellIterator = row.cellIterator();
                HSSFRow resultsRow = (HSSFRow) ResultsSheet.createRow(rowIndex);

                //looping through columns until an empty column is found
                while (cellIterator.hasNext())
                {
                    HashMap <Boolean, String> resultMap = new HashMap<Boolean, String>();
                    boolean valueMatches = true;
                    XSSFCell cell = (XSSFCell) cellIterator.next();

                    try {
                        currentCellValue = cell.getStringCellValue();
                        currentCellValue= currentCellValue.replaceAll("\\[~/n~]", "");
                        currentCellValue= currentCellValue.replaceAll("\\[~/n~}", "");
                        currentCellValue= currentCellValue.replaceAll("\\[~/n~", "");

                        currentColName = sheet.getRow(0).getCell(cellIndex).getStringCellValue();
                        // currentCellValue = currentCellValue.replace(currentColName, "");
                    }catch (Exception e) {
                        currentCellValue = cell.getRawValue();
                        currentCellValue= currentCellValue.replaceAll("\\[~/n~]", "");
                        currentCellValue= currentCellValue.replaceAll("\\[~/n~}", "");
                        currentCellValue= currentCellValue.replaceAll("\\[~/n~", "");

                        currentColName = sheet.getRow(0).getCell(cellIndex).getStringCellValue();
                        System.out.println("Error getting value for "+sheetName+ " Row "+rowIndex +" Cell "+cell);
                        System.out.println(e);
                    }
                    HSSFCell newCell = (HSSFCell) resultsRow.createCell(cellIndex);

                    if(rowIndex==0) {
                        newCell.setCellValue(cell.getStringCellValue());
                        benefitsArray.add(cellIndex, 0);//this will initialize the arraylist of colors to value of 0's for each benefit
                    }
                    if(rowIndex!=0) { //skip the header row
                        if(cellIndex==0) {

                            if(counter==0) {
                                aquisitionhomepage = (AcquisitionHomePage) getLoginScenario().openApplicationURL(wd, siteType);

                            }
                            counter++;
                            System.out.println("Validating "+sheetName+ " Plan "+rowIndex+" ************************************************************");
                            new VppCommonPage(wd,siteType,currentCellValue);  //gets the partial deeplink fromt the excel and appends it with the environment URL and navigates to plan details page
                            planDetailsPage = new DCEDetailsPage(wd);
                            benefitsMap = planDetailsPage.collectInfoDCEPlanDetailPg(sheetName,rowIndex);              //  stores all the table info into hashmap

                        }//end if cellIndex = 0


                        if(!(currentColName.equalsIgnoreCase("Link Parameters")
                                ||currentColName.equalsIgnoreCase("Product Focus")
                                ||currentColName.equalsIgnoreCase("Product")
                                ||currentColName.equalsIgnoreCase("Portal labels")
                                ||currentColName.equalsIgnoreCase("Contract PBP Segment ID")
                                ||currentColName.equalsIgnoreCase("OON_IN")
                                ||currentColName.equalsIgnoreCase("County")
                                ||currentColName.equalsIgnoreCase("ZipCode")
                                ||currentColName.equalsIgnoreCase("Fips")
                                ||currentColName.equalsIgnoreCase("Annual Prescription Deductible")
                                ||currentColName.equalsIgnoreCase("Coverage Gap Stage")
                                ||currentColName.equalsIgnoreCase("Catastrophic Coverage Stage")
                                ||currentColName.equalsIgnoreCase("Tier 1 Standard Mail Order")
                                ||currentColName.equalsIgnoreCase("Tier 2 Standard Mail Order")
                                ||currentColName.equalsIgnoreCase("Tier 3 Standard Mail Order")
                                ||currentColName.equalsIgnoreCase("Tier 3 Standard Mail Order (Insulin)")
                                ||currentColName.equalsIgnoreCase("Tier 4 Standard Mail Order")
                                ||currentColName.equalsIgnoreCase("DSNP Sub Type")
                                ||currentColName.equalsIgnoreCase("Business Area"))) {

                            resultMap = planDetailsPage.compareBenefits(currentColName, currentCellValue, benefitsMap); //compares the benefit value from the excel to the values from the hashmap. key = columnName, value= benefit value
                            if(resultMap.containsKey(false))
                                valueMatches = false;
                            System.out.println(currentColName + " : "+ valueMatches);
                            if(valueMatches) {
                                newCell.setCellStyle(stylePassed);
                                int value = benefitsArray.get(cellIndex); // get value at the index of cellCounter from the array
                                value = value + 1; // increment value for this indes if the cell is green
                                benefitsArray.set(cellIndex, value); // replace old value with the incremented value
                                benefitsColorMap.put(currentColName,value); //updating the value into the hashmap for the specific benefit
                            }else {
                                newCell.setCellStyle(styleFailed);
                                failureCounter++;
                                if(!(currentColName.equalsIgnoreCase("Out-of-Network Benefits")||currentColName.equalsIgnoreCase("High Option DentalPS")||currentColName.equalsIgnoreCase("Platinum DentalPS")||currentColName.equalsIgnoreCase("Estimated Annual Total Platinum Dental")||currentColName.equalsIgnoreCase("Estimated Annual Total High Option Dental")||currentColName.equalsIgnoreCase("Estimated Annual Total No riders")||currentColName.equalsIgnoreCase("Footnotes")||currentColName.equalsIgnoreCase("Drug Costs from Formulary")||currentColName.equalsIgnoreCase("Estimated Annual Total"))) {
                                    mcareFailureCounter++;
                                }
                            }

                            if(rowIndex==lastRow) {
                                if(cellCounter==0) {
                                    resultsRowNew = (HSSFRow) ResultsSheet.createRow(lastRow+1);
                                    cellCounter++;
                                }
                                HSSFCell colorRowCell = (HSSFCell) resultsRowNew.createCell(cellIndex);
                                colorRowCell.setCellValue(benefitsArray.get(cellIndex));
                            }

                        }


                        if(currentColName.equalsIgnoreCase("Error Count")&&rowIndex!=0)
                            newCell.setCellValue(failureCounter);
                        else if(currentColName.equalsIgnoreCase("MCARE Error Count")&&rowIndex!=0) {
                            newCell.setCellValue(mcareFailureCounter);
                        }else {
                            if(valueMatches) { 			//if boolean value is true then it will write only the excel value from the input sheet and mark it green
                                try {
                                    newCell.setCellValue(cell.getStringCellValue());
                                }
                                catch (Exception ex){
                                    newCell.setCellValue(cell.getNumericCellValue());
                                }
                            } else { 						//boolean value is false so it will add the UI value as well to differentiate and mark the cell red
                                try {
                                    newCell.setCellValue("Excel Value: "+cell.getStringCellValue()+" / UI Value: "+resultMap.get(false));
                                }
                                catch (Exception ex){
                                    newCell.setCellValue("Excel Value: "+cell.getNumericCellValue()+" / UI Value: "+resultMap.get(false));
                                }
                            }
                        }


                    } //end skip the header if logic
                    cellIndex++;
                }
            }
            File OutputFile = new File(OutputFilePath);
            FileOutputStream outputStream = new FileOutputStream(OutputFile);
            ResultWorkbook.write(outputStream);
            inputStream.close();
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            File OutputFile = new File(OutputFilePath);
            FileOutputStream outputStream = new FileOutputStream(OutputFile);
            ResultWorkbook.write(outputStream);
            inputStream.close();
            outputStream.flush();
            outputStream.close();
            e.printStackTrace();
        }

        for(String keyValue : benefitsColorMap.keySet()) {
            System.out.println("Benefit Name: "+keyValue+" Total Passed: "+benefitsColorMap.get(keyValue));
            System.out.println(
                    "_________________________________________________________________________________________________"
            ); }
    }
}
