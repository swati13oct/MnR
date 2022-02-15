package acceptancetests.acquisition.pharmacylocator;

import acceptancetests.data.CommonConstants;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.emailAndPrint.EmailAndPrintUtil;
import pages.acquisition.pharmacyLocator.PharmacySearchPageNew;
import pages.acquisition.vpp.AepPlanComparePage;
import pages.acquisition.vpp.AepPlanDetailsPage;
import pages.acquisition.vpp.AepVppPlanSummaryPage;
import pages.acquisition.vpp.VppCommonPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Functionality: VPP flow for Acquisition
 */

/**
 * Steps related to email and print validation for both ulayer and blayer
 *
 */
public class PharmacySearchBenefitsValidationStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}


	@Then("^the user navigates to Pharmacy Search page and compares benefits value from excel to UI and reports into excel$")
	public void exceldataValidation_planSummary(DataTable givenAttributes) throws Throwable {
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}*/
		String ExcelName = givenAttributesMap.get("ExcelFile");
		String sheetName = givenAttributesMap.get("WorkSheetName");
		String siteType = givenAttributesMap.get("Site");


		 WebDriver wd = getLoginScenario().getWebDriverNew();
		 getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);


		//Getting Date
			DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			Date RunDate = new Date();
			String DateCreated = dateFormat.format(RunDate);
			String parentDirectory = null;
			parentDirectory = new File(".").getCanonicalPath();
			String InputFilePath = parentDirectory+"/src/main/resources/database/PlanDocs/"+ExcelName+".xls";
			String OutputFilePath = parentDirectory+"/target/PlanValidation_Results_"+ExcelName+"_"+sheetName+"_"+siteType+"_"+DateCreated+".xls";

		//Reading Excel.xls file
			File InputFile = new File(InputFilePath);
			FileInputStream inputStream = new FileInputStream(InputFile);
			Workbook workbook = new HSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			int lastRow = sheet.getLastRowNum();
			Workbook ResultWorkbook = new HSSFWorkbook();
			Sheet ResultsSheet = ResultWorkbook.createSheet("PlanBenefitsResults");

			CellStyle stylePassed = ResultWorkbook.createCellStyle();
			stylePassed.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			stylePassed.setFillPattern(CellStyle.SOLID_FOREGROUND);

			CellStyle styleFailed = ResultWorkbook.createCellStyle();
			styleFailed.setFillForegroundColor(IndexedColors.RED.getIndex());
			styleFailed.setFillPattern(CellStyle.SOLID_FOREGROUND);

			HashMap <String, Integer> benefitsColorMap = new HashMap<String, Integer>();
			 ArrayList <Integer> benefitsArray = new ArrayList<Integer>();
			 int  colorCounter = 0, cellCounter=0;
			 HSSFRow resultsRowNew = null;
		//Setting First Row for Results excel

			try {

				PharmacySearchPageNew pharmacySearchPage = null;
				 AcquisitionHomePage aquisitionhomepage = null;
				 String currentCellValue = "";
				 String currentColName = "";
				//int countyCellNum = 9, planYearCellNum = 10, planNameCellNum = 7, counter=0; //to be used when running a random row number
				// int countyCellNum =3, planYearCellNum = 5, planNameCellNum = 2; // to be used for PDP sheets when running a random row number on local
				 int countyCellNum = 0, planYearCellNum =0, planNameCellNum = 0, counter=0, zipCodeCellNum=0;
				 HashMap <String, String> benefitsMap = new HashMap<String, String>();
				 System.out.println(sheetName+ " SAUCE URL: "+ getLoginScenario().returnJobURL());
				 //Looping over total rows with values
				 for(int rowIndex=0; rowIndex<=lastRow; rowIndex++)
		            {
					 	int failureCounter = 0;int cellIndex = 0; System.out.println("INSIDE Row");

					 	HSSFRow row = (HSSFRow) sheet.getRow(rowIndex);
		                Iterator<Cell> cellIterator = row.cellIterator();
		                HSSFRow resultsRow = (HSSFRow) ResultsSheet.createRow(rowIndex);

		                //looping through columns until an empty column is found
		                while (cellIterator.hasNext())
		                {
		                	HashMap <Boolean, String> resultMap = new HashMap<Boolean, String>();
		                	boolean valueMatches = true;
		                	 HSSFCell cell = (HSSFCell) cellIterator.next();

		                	 try {
		                		 currentCellValue = cell.getStringCellValue();
		                		 currentColName = sheet.getRow(0).getCell(cellIndex).getStringCellValue();
		                	 }catch (Exception e) {
		                		 System.out.println("Error getting value for "+sheetName+ " Row "+rowIndex +" Cell "+cell);
		                		 System.out.println(e);
		                	 }
			                 HSSFCell newCell = (HSSFCell) resultsRow.createCell(cellIndex);
			                 if(rowIndex==0) {
								 newCell.setCellValue(cell.getStringCellValue());
								 if(cell.getStringCellValue().equalsIgnoreCase("county"))
									  countyCellNum = cellIndex;
								 else if(cell.getStringCellValue().equalsIgnoreCase("plan year"))
									 planYearCellNum = cellIndex;
								 else if(cell.getStringCellValue().equalsIgnoreCase("plan name"))
									 planNameCellNum = cellIndex;
								 else if(cell.getStringCellValue().equalsIgnoreCase("ZipCode"))
									 zipCodeCellNum = cellIndex;
			                 }

							 if(rowIndex!=0) { //skip the header row
								 if(cellIndex==0) {

									  String countyName = row.getCell(countyCellNum).getStringCellValue();
									  String planYear = row.getCell(planYearCellNum).getStringCellValue();
									  String planName = row.getCell(planNameCellNum).getStringCellValue();
									  String zipCode = row.getCell(zipCodeCellNum).getStringCellValue();

									  System.out.println("Validating "+sheetName+ " Plan "+rowIndex+" ************************************************************");
									  if(counter==0) {
										  aquisitionhomepage = (AcquisitionHomePage) getLoginScenario().openApplicationURL(wd, siteType);
										  counter++;
									  }
									  new VppCommonPage(wd,siteType,currentCellValue);  //gets the partial deeplink fromt the excel and appends it with the environment URL and navigates to plan details page
									 pharmacySearchPage = new PharmacySearchPageNew(wd);

                                      benefitsMap = pharmacySearchPage.collectInfoPharmacyPage(planName, zipCode, countyName, planYear, sheetName, rowIndex);
								 }
								 if(rowIndex==1) {//this will initialize the arraylist of colors to value of 0's for each benefit
									  benefitsArray.add(cellIndex, 0);
								  }
								 if(!(currentColName.equalsIgnoreCase("plan year")||currentColName.equalsIgnoreCase("Business Area")||currentColName.equalsIgnoreCase("plan id qa script")||currentColName.equalsIgnoreCase("product focus")||currentColName.equalsIgnoreCase("dsnp sub type")||currentColName.equalsIgnoreCase("Error Count")||currentColName.equalsIgnoreCase("portal labels")||currentColName.equalsIgnoreCase("OON_IN")||currentColName.equalsIgnoreCase("plan type")||currentColName.equalsIgnoreCase("county")||currentColName.equalsIgnoreCase("Link parameters")||currentColName.contains("Segment ID")||currentColName.equalsIgnoreCase("product")||currentColName.equalsIgnoreCase("plan name")||currentColName.equalsIgnoreCase("zipcode")||currentColName.equalsIgnoreCase("zip code")||currentColName.equalsIgnoreCase("fips"))) {

									 resultMap = pharmacySearchPage.compareBenefits(currentColName, currentCellValue, benefitsMap); //compares the benefit value from the excel to the values from the hashmap. key = columnName, value= benefit value
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
					             else {
					                	 if(valueMatches) { 			//if boolean value is true then it will write only the excel value from the input sheet and mark it green
					                		 newCell.setCellValue(cell.getStringCellValue());
					                	 } else { 						//boolean value is false so it will add the UI value as well to differentiate and mark the cell red
					                		 newCell.setCellValue("Excel Value: "+cell.getStringCellValue()+" / UI Value: "+resultMap.get(false));
					                	 }
					              }
							 }

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
	}

}
