package acceptancetests.acquisition.vpp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.emailAndPrint.EmailAndPrintUtil;
import pages.acquisition.vpp.AepPlanComparePage;
import pages.acquisition.vpp.AepPlanDetailsPage;
import pages.acquisition.vpp.AepVppPlanSummaryPage;
import pages.acquisition.vpp.VppCommonPage;
import pages.acquisition.commonpages.AcquisitionHomePage;

/**
 * Functionality: VPP flow for Acquisition
 */
/**
 * Steps related to email and print validation for both ulayer and blayer
 *
 */
public class VppPlanValidationStepDefinition {

	@Autowired
	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	
	@Then("^the user navigates to plan details page using deeplink$")
	public void saveFirtPlan() {
		WebDriver wd = getLoginScenario().getWebDriverNew();
		
		EmailAndPrintUtil util=new EmailAndPrintUtil(wd);
		util.savedHeartFirstPlanOnSummaryPage();
	}

	@Then("^the user navigates to plan details and compares benefits value from excel to UI and reports into excel$")
	public void exceldataValidation_planDetails(DataTable givenAttributes) throws Throwable {
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
		HashMap <String, Integer> benefitsColorMap = new HashMap<String, Integer>();
		 ArrayList <Integer> benefitsArray = new ArrayList<Integer>();
		 int counter =0, colorCounter = 0,cellCounter=0;
		 WebDriver wd = getLoginScenario().getWebDriverNew();
		 getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);
		
		//Getting Date
			DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			Date RunDate = new Date();
			String DateCreated = dateFormat.format(RunDate);
			String parentDirectory = null;
			parentDirectory = new java.io.File(".").getCanonicalPath();
			String InputFilePath = parentDirectory+"/src/main/resources/database/PlanDocs/"+ExcelName+".xls";
			String OutputFilePath = parentDirectory+"/target/PlanValidation_Results_"+ExcelName+"_"+sheetName+"_"+siteType+"_"+DateCreated+".xls";
			
		//Reading Excel.xls file
			File InputFile = new File(InputFilePath);
			FileInputStream inputStream = new FileInputStream(InputFile);
			Workbook workbook = new HSSFWorkbook(inputStream);
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
				 AepPlanDetailsPage planDetailsPage = null;
				 AcquisitionHomePage aquisitionhomepage = null;
				 String currentCellValue = "";
				 String currentColName = "";
				  
				 HashMap <String, String> benefitsMap = new HashMap<String, String>();
				 System.out.println(sheetName+ " SAUCE URL: "+ getLoginScenario().returnJobURL());
				 HSSFRow resultsRowNew = null;
				 //Looping over total rows with values
				 for(int rowIndex=0; rowIndex<=lastRow; rowIndex++)
		            {
					 	int failureCounter = 0, mcareFailureCounter = 0;
					 	int cellIndex = 0;
					 	
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
		                		 currentCellValue= currentCellValue.replaceAll("\\[~/n~]", "");
		                		 currentCellValue= currentCellValue.replaceAll("\\[~/n~", "");
		                		 currentColName = sheet.getRow(0).getCell(cellIndex).getStringCellValue();
		                		// currentCellValue = currentCellValue.replace(currentColName, "");
		                	 }catch (Exception e) {
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
									  planDetailsPage = new AepPlanDetailsPage(wd);
									  
									/*  if(sheetName.contains("PDP")) {
										  if(!row.getCell(6).getStringCellValue().contains("NA")) {
											  //planDetailsPage.navigateToDCEandAddDrug(row.getCell(6).getStringCellValue());
											  //benefitsMap = planDetailsPage.collectInfoVppPlanDetailPg();
											  //planDetailsPage.editDrugListAndRemoveDrug();
										  }else 
											  benefitsMap = planDetailsPage.collectInfoVppPlanDetailPg(sheetName,rowIndex);
									  }else*/
										  benefitsMap = planDetailsPage.collectInfoVppPlanDetailPg(sheetName,rowIndex);              //  stores all the table info into hashmap

				                 }//end if cellIndex = 0
								 
						
								 if(!(currentColName.equalsIgnoreCase("Plan ID QA script")||currentColName.equalsIgnoreCase("Product Focus")||currentColName.equalsIgnoreCase("DSNP Sub Type")||currentColName.equalsIgnoreCase("Drug Name")||currentColName.equalsIgnoreCase("Error Count")||currentColName.equalsIgnoreCase("portal labels")||currentColName.equalsIgnoreCase("OON_IN")||currentColName.equalsIgnoreCase("plan type")||currentColName.equalsIgnoreCase("county")||currentColName.equalsIgnoreCase("Link parameters")||currentColName.equalsIgnoreCase("Contract PBP Segment ID")||currentColName.equalsIgnoreCase("product")||currentColName.equalsIgnoreCase("zipcode")||currentColName.equalsIgnoreCase("fips")||currentColName.equalsIgnoreCase("Business Area")||currentColName.equalsIgnoreCase("Product Focus <Next Year>")||currentColName.equalsIgnoreCase("MCARE Error count"))) {	
									  
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
				                		 newCell.setCellValue(cell.getStringCellValue()); 
				                	 } else { 						//boolean value is false so it will add the UI value as well to differentiate and mark the cell red
				                		 newCell.setCellValue("Excel Value: "+cell.getStringCellValue()+" / UI Value: "+resultMap.get(false));	 
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
	
	@Then("^the user navigates to plan compare page and compares benefits value from excel to UI and reports into excel$")
	public void exceldataValidation_planCompare(DataTable givenAttributes) throws Throwable {
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
			parentDirectory = new java.io.File(".").getCanonicalPath();
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

			CellStyle styleIgnore = ResultWorkbook.createCellStyle();
			styleIgnore.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
			styleIgnore.setFillPattern(CellStyle.SOLID_FOREGROUND);

			CellStyle styleUpdateMBD = ResultWorkbook.createCellStyle();
			styleUpdateMBD.setFillForegroundColor(IndexedColors.VIOLET.getIndex());
			styleUpdateMBD.setFillPattern(CellStyle.SOLID_FOREGROUND);

			HashMap <String, Integer> benefitsColorMap = new HashMap<String, Integer>();
			 ArrayList <Integer> benefitsArray = new ArrayList<Integer>();
			 int colorCounter = 0, cellCounter = 0;
			 HSSFRow resultsRowNew = null;
		//Setting First Row for Results excel

			try {
				 AepPlanComparePage planComparePage = null;
				 AepPlanDetailsPage planDetailsPage = null;
				 String currentCellValue = "";
				 String currentColName = "";
				 
				 HashMap <String, String> benefitsMap = new HashMap<String, String>();
				 HashMap <String, String> benefitsDetailMap = new HashMap<String, String>();
				 
				TreeMap<String, String> benefitsDetailMapSorted = new TreeMap<String, String>();
				 //Looping over total rows with values
				 for(int rowIndex=0; rowIndex<=lastRow; rowIndex++)
		            {
						int failureCounter = 0;int cellIndex = 0;System.out.println("INSIDE Row");
					 	
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
		                		 currentColName = sheet.getRow(0).getCell(cellIndex).getStringCellValue().trim();
		                		 currentCellValue= currentCellValue.replaceAll("\\[~/n~]", "");
		                		 currentCellValue= currentCellValue.replaceAll("\\[~/n~", "");
		                	 }catch (Exception e) {
		                		 System.out.println("Internal Error - Error getting value for "+sheetName+ " Row "+rowIndex +" Cell "+cell);
		                		 System.out.println(e);
								 int lastcellNum = resultsRow.getLastCellNum();
								 resultsRow.createCell(lastcellNum).setCellValue(e.getMessage());
								 break;
		                	 }
			                 HSSFCell newCell = (HSSFCell) resultsRow.createCell(cellIndex); 
							 newCell.setCellValue(cell.getStringCellValue());
							
							 if(rowIndex!=0) { //skip the header row
								 if(cellIndex==0) { 
									 
								  System.out.println("Validating "+sheetName+ " Plan "+rowIndex+" ************************************************************");
									 new VppCommonPage(wd,siteType,currentCellValue);  //gets the partial deeplink fromt the excel and appends it with the environment URL and navigates to plan details page
									 planComparePage = new AepPlanComparePage(wd);

									 try {
										 if (sheetName.contains("PDP")) {
											 benefitsMap = planComparePage.collectInfoVppPlanComparePg("PDP", "", sheetName, rowIndex);
										 } else {
											 benefitsMap = planComparePage.collectInfoVppPlanComparePg(row.getCell(6).getStringCellValue(), row.getCell(3).getStringCellValue(), sheetName, rowIndex);
										 }
									 }
									 catch(Exception ex)
									 {
									 	int lastcellNum = resultsRow.getLastCellNum();
									 	resultsRow.createCell(lastcellNum).setCellValue(ex.getMessage());
									 	System.out.println("Internal Error - collectInfoVppPlanComparePg - Failed  | Sheet Name - " + sheetName + "| Plan - "+rowIndex + " | Error - " +ex.getMessage() );
									 	break;
									 }
								 }

								 if(cellIndex == 1)
								 {
									 new VppCommonPage(wd,siteType,currentCellValue);  //gets the partial deeplink fromt the excel and appends it with the environment URL and navigates to plan details page
									 planDetailsPage = new AepPlanDetailsPage(wd);
									// benefitsDetailMap = planDetailsPage.collectInfoVppPlanDetailPg();

									 if(sheetName.contains("PDP")) {
										 if(!row.getCell(7).getStringCellValue().contains("NA")) {
											 //planDetailsPage.navigateToDCEandAddDrug(row.getCell(7).getStringCellValue()); //TODO
											 benefitsDetailMap = planDetailsPage.collectInfoVppPlanDetailPg(sheetName,rowIndex);
											 //planDetailsPage.editDrugListAndRemoveDrug();
										 }else
											 benefitsDetailMap = planDetailsPage.collectInfoVppPlanDetailPg(sheetName,rowIndex);
									 }else
										 benefitsDetailMap = planDetailsPage.collectInfoVppPlanDetailPg(sheetName,rowIndex);             //  stores all the table info into hashmap


								 }
								 if(rowIndex==1) {//this will initialize the arraylist of colors to value of 0's for each benefit
									  benefitsArray.add(cellIndex, 0);
								  }
								 if(!(currentColName.equalsIgnoreCase("Plan Detail link parameter") ||currentColName.equalsIgnoreCase("DSNP Sub type")||currentColName.equalsIgnoreCase("Business Area")|| currentColName.equalsIgnoreCase("Product") || currentColName.equalsIgnoreCase("Out-of-Network Benefits")|| currentColName.equalsIgnoreCase("Error Count")||currentColName.equalsIgnoreCase("Drug Name")||currentColName.equalsIgnoreCase("county")||currentColName.equalsIgnoreCase("Link parameters")||currentColName.equalsIgnoreCase("Contract PBP Segment ID")||currentColName.equalsIgnoreCase("zipcode")||currentColName.equalsIgnoreCase("fips"))) {

								 	if(sheetName.contains("PDP") && currentColName.trim().equalsIgnoreCase("Drug Costs from Formulary"))
									{
										currentCellValue = currentCellValue + "Estimate drug costs";
									}
									 resultMap = planComparePage.compareBenefits(currentColName.trim(), currentCellValue.trim(), benefitsMap); //compares the benefit value from the excel to the values from the hashmap. key = columnName, value= benefit value
									 if(resultMap.containsKey(false))
										 valueMatches = false;
									  System.out.println(currentColName + " : "+ valueMatches);
									 	if(!valueMatches) {
									 		//Ignore OON column data validation for a Plan that is only In-network
											if(!sheetName.contains("PDP") && row.getCell(2).getStringCellValue().trim().startsWith("IN") && currentColName.trim().endsWith("OON"))
											{
												newCell.setCellStyle(styleIgnore);
											}
											else {
												newCell.setCellStyle(styleFailed);

												HashMap<Boolean, String> resultDetailMap = new HashMap<Boolean, String>();
												String formatedCellValue = currentCellValue;
												String existingUIValue, OONValue, INNValue = "";

												if (!sheetName.contains("PDP")) {
													formatedCellValue = planComparePage.formatCellValueForPlanDetail(currentColName, currentCellValue);

													if (currentColName.endsWith("PC")) {
														currentColName = currentColName.substring(0, (currentColName.length() - 2));
													}

													if (currentColName.endsWith("OON")) {
														if (!benefitsDetailMap.containsKey(currentColName)) {
															currentColName = planComparePage.getPlanDetailColumnName(currentColName.substring(0, (currentColName.length() - 3)));

															if (benefitsDetailMap.containsKey(currentColName) && benefitsDetailMap.get(currentColName).split("/").length > 1) {
																existingUIValue = benefitsDetailMap.get(currentColName);
																INNValue = existingUIValue.split("/")[0];
																OONValue = existingUIValue.split("/")[1];
																benefitsDetailMap.replace(currentColName, existingUIValue, INNValue);
																benefitsDetailMap.put(currentColName + "OON", OONValue);
																currentColName = currentColName + "OON";
															}
														}

													} else {
														currentColName = planComparePage.getPlanDetailColumnName(currentColName);

														if (benefitsDetailMap.containsKey(currentColName) && benefitsDetailMap.get(currentColName).split("/").length > 1) {
															existingUIValue = benefitsDetailMap.get(currentColName);
															INNValue = existingUIValue.split("/")[0];
															OONValue = existingUIValue.split("/")[1];
															benefitsDetailMap.replace(currentColName, existingUIValue, INNValue);
															benefitsDetailMap.put(currentColName + "OON", OONValue);
														}
													}
												}

												resultDetailMap = planDetailsPage.compareBenefits(currentColName.trim(),formatedCellValue.trim(),planComparePage.sortDetailMap(benefitsDetailMap));
												if(resultDetailMap.containsKey(true) || (resultDetailMap.containsKey(false) && resultDetailMap.get(false).equalsIgnoreCase("BENEFIT NOT FOUND ON THE UI")))
												{
													newCell.setCellStyle(styleFailed);
                                                    failureCounter++;
												}
												else {
													newCell.setCellStyle(styleUpdateMBD);
												}
											}
								 		}else {
								 			newCell.setCellStyle(stylePassed);
								 			int value = benefitsArray.get(cellIndex); // get value at the index of cellCounter from the array
									 		value = value + 1; // increment value for this indes if the cell is green
									 		benefitsArray.set(cellIndex, value); // replace old value with the incremented value
									 		benefitsColorMap.put(currentColName,value); //updating the value into the hashmap for the specific benefit
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
									 } else {
										 //Ignore OON column data validation for a Plan that is only In-network
										 if(!sheetName.contains("PDP") && row.getCell(2).getStringCellValue().trim().startsWith("IN") && currentColName.trim().endsWith("OON"))
										 {
											 newCell.setCellStyle(styleIgnore);
											 newCell.setCellValue(cell.getStringCellValue());

											 if(cell.getStringCellValue().replace("\n","").trim().equalsIgnoreCase("No Coverage"))
											 {
												 newCell.setCellStyle(stylePassed);
											 }
										 }
										 else {//boolean value is false so it will add the UI value as well to differentiate and mark the cell red
											 newCell.setCellValue("Excel Value: " + cell.getStringCellValue() + " / UI Value: " + resultMap.get(false));
										 }
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
	
	@Then("^the user navigates to plan summary page and compares benefits value from excel to UI and reports into excel$")
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
			parentDirectory = new java.io.File(".").getCanonicalPath();
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
			
				 AepVppPlanSummaryPage planSummaryPage = null;
				 AcquisitionHomePage aquisitionhomepage = null;
				 String currentCellValue = "";
				 String currentColName = "";
				//int countyCellNum = 9, planYearCellNum = 10, planNameCellNum = 7, counter=0; //to be used when running a random row number
				// int countyCellNum =3, planYearCellNum = 5, planNameCellNum = 2; // to be used for PDP sheets when running a random row number on local
				 int countyCellNum = 0, planYearCellNum =0, planNameCellNum = 0, counter=0;
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
			                 }
							
							 if(rowIndex!=0) { //skip the header row
								 if(cellIndex==0) { 
									 
									  String countyName = row.getCell(countyCellNum).getStringCellValue(); 
									  String planYear = row.getCell(planYearCellNum).getStringCellValue();
									  String planName = row.getCell(planNameCellNum).getStringCellValue();
									  
									  System.out.println("Validating "+sheetName+ " Plan "+rowIndex+" ************************************************************");
									  if(counter==0) {
										  aquisitionhomepage = (AcquisitionHomePage) getLoginScenario().openApplicationURL(wd, siteType);
										  counter++;
									  }
									  new VppCommonPage(wd,siteType,currentCellValue);  //gets the partial deeplink fromt the excel and appends it with the environment URL and navigates to plan details page
									  planSummaryPage = new AepVppPlanSummaryPage(wd);
									  //planSummaryPage.checkForMultiCountyPopup(countyName);
									 // planSummaryPage.selectYearOption(planYear);
									  //benefitsMap = planSummaryPage.collectInfoVppPlanSummaryPg(planName);

                                      benefitsMap = planSummaryPage.collectInfoVppPlanSummaryPg(planName, countyName, planYear, sheetName, rowIndex);
								 }
								 if(rowIndex==1) {//this will initialize the arraylist of colors to value of 0's for each benefit
									  benefitsArray.add(cellIndex, 0);
								  }
								 if(!(currentColName.equalsIgnoreCase("plan year")||currentColName.equalsIgnoreCase("Business Area")||currentColName.equalsIgnoreCase("plan id qa script")||currentColName.equalsIgnoreCase("product focus")||currentColName.equalsIgnoreCase("dsnp sub type")||currentColName.equalsIgnoreCase("Error Count")||currentColName.equalsIgnoreCase("portal labels")||currentColName.equalsIgnoreCase("OON_IN")||currentColName.equalsIgnoreCase("plan type")||currentColName.equalsIgnoreCase("county")||currentColName.equalsIgnoreCase("Link parameters")||currentColName.contains("Segment ID")||currentColName.equalsIgnoreCase("product")||currentColName.equalsIgnoreCase("plan name")||currentColName.equalsIgnoreCase("zipcode")||currentColName.equalsIgnoreCase("zip code")||currentColName.equalsIgnoreCase("fips"))) {	
									 
									 resultMap = planSummaryPage.compareBenefits(currentColName, currentCellValue, benefitsMap); //compares the benefit value from the excel to the values from the hashmap. key = columnName, value= benefit value
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
	
	//@Then("^the user navigates to OLE plan summary page and compares benefits value from excel to UI and reports into excel$")
	@Then("^the user navigates to Welcome OLE page and compares premium value from excel to UI and reports into excel$")
	public void exceldataValidation_OLE_planSummary(DataTable givenAttributes) throws Throwable {
		//HashMap<String, Boolean> btnMap = new HashMap<String, Boolean>();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);

		boolean result = false;
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
			parentDirectory = new java.io.File(".").getCanonicalPath();
			String InputFilePath = parentDirectory+"/src/main/resources/database/PlanDocs/"+ExcelName+".xls";
			String OutputFilePath = parentDirectory+"/target/WelcomeOLEpage_Results_"+ExcelName+"_"+sheetName+"_"+siteType+"_"+DateCreated+".xls";

		//Reading Excel.xls file
			File InputFile = new File(InputFilePath);
			FileInputStream inputStream = new FileInputStream(InputFile);
			Workbook workbook = new HSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheet(sheetName);
			int lastRow = sheet.getLastRowNum();
			Workbook ResultWorkbook = new HSSFWorkbook();
			Sheet ResultsSheet = ResultWorkbook.createSheet("Results");

			CellStyle stylePassed = ResultWorkbook.createCellStyle();
			stylePassed.setFillForegroundColor(IndexedColors.GREEN.getIndex());
			stylePassed.setFillPattern(CellStyle.SOLID_FOREGROUND);

			CellStyle styleFailed = ResultWorkbook.createCellStyle();
			styleFailed.setFillForegroundColor(IndexedColors.RED.getIndex());
			styleFailed.setFillPattern(CellStyle.SOLID_FOREGROUND);

		//Setting First Row for Results excel

			try {
			     AepVppPlanSummaryPage planSummaryPage = null;
			     AcquisitionHomePage aquisitionhomepage = null;
				 String currentCellValue = "";
				 String currentColName = "";
				 int counter=0,countyCellNum = 0, planYearCellNum =0, planNameCellNum = 0, planTypeCellNum = 0, highOptionDentalCellNum = 0, dentalPlatinumCellNum = 0, monthlyPremiumCellNum = 0;
				 HashMap<String, String> premiumMap = new HashMap<String, String>();
				 System.out.println(sheetName+ " SAUCE URL: "+ getLoginScenario().returnJobURL());
				 //Looping over total rows with values
				 for(int rowIndex=0; rowIndex<=lastRow; rowIndex++)
		            {
					 	int failureCounter = 0;int cellIndex = 0;System.out.println("INSIDE Row");
                	 	HSSFRow row = (HSSFRow) sheet.getRow(rowIndex);
		                Iterator<Cell> cellIterator = row.cellIterator();
		                HSSFRow resultsRow = (HSSFRow) ResultsSheet.createRow(rowIndex);
                         //looping through columns until an empty column is found
		                while (cellIterator.hasNext()) {
							HashMap<Boolean, String> resultMap = new HashMap<Boolean, String>();
							boolean valueMatches = true;
							HSSFCell cell = (HSSFCell) cellIterator.next();
                    	try {
								currentCellValue = cell.getStringCellValue();
								currentColName = sheet.getRow(0).getCell(cellIndex).getStringCellValue();
							} catch (Exception e) {
								System.out.println("Error getting value for " + sheetName + " Row " + rowIndex + " Cell " + cell);
								System.out.println(e);
							}
							HSSFCell newCell = (HSSFCell) resultsRow.createCell(cellIndex);
							if (rowIndex == 0) {
								newCell.setCellValue(cell.getStringCellValue());
								if (cell.getStringCellValue().equalsIgnoreCase("county"))
									countyCellNum = cellIndex;
								else if (cell.getStringCellValue().equalsIgnoreCase("plan year"))
									planYearCellNum = cellIndex;
								else if (cell.getStringCellValue().equalsIgnoreCase("plan name"))
									planNameCellNum = cellIndex;
								else if (cell.getStringCellValue().equalsIgnoreCase("portal labels"))
									planTypeCellNum = cellIndex;
								else if (cell.getStringCellValue().equalsIgnoreCase("high option dental"))
									highOptionDentalCellNum = cellIndex;
								else if (cell.getStringCellValue().equalsIgnoreCase("dental platinum"))
									dentalPlatinumCellNum = cellIndex;
								else if (cell.getStringCellValue().equalsIgnoreCase("Monthly Premium"))
									monthlyPremiumCellNum = cellIndex;
							}
                    		 if(rowIndex!=0) { //skip the header row
								 if(cellIndex==0) {
                    				  String countyName = row.getCell(countyCellNum).getStringCellValue();
									  String planYear = row.getCell(planYearCellNum).getStringCellValue();
									  String planName = row.getCell(planNameCellNum).getStringCellValue();
									  String planType = "";
									  if(planName.contains("PDP")){
										  planType = "PDP";
									  }else {
									  	  planType = row.getCell(planTypeCellNum).getStringCellValue();
									  }
									  String highOptionDental = row.getCell(highOptionDentalCellNum).getStringCellValue();
									  String dentalPlatinum = row.getCell(dentalPlatinumCellNum).getStringCellValue();
									 String monthlyPremium = row.getCell(monthlyPremiumCellNum).getStringCellValue();

									 System.out.println("Excel VALUE for High Optional Dental :"+highOptionDental);
									 System.out.println("Excel VALUE for dental Platinum  :"+dentalPlatinum);

									System.out.println("Validating " + sheetName + " Plan " + rowIndex + " ************************************************************");

									 if(counter==0) {
										 aquisitionhomepage = (AcquisitionHomePage) getLoginScenario().openApplicationURL(wd, siteType);
										 counter++;
									 }
									new VppCommonPage(wd, siteType, currentCellValue);  //gets the partial deeplink fromt the excel and appends it with the environment URL and navigates to plan details page
									planSummaryPage = new AepVppPlanSummaryPage(wd);
									if (planType.equalsIgnoreCase("PDP")) {
										result = true;
										planSummaryPage.selectCounty(countyName);	
										//planSummaryPage.selectYearOptionOLE(planYear);
										planSummaryPage.Enroll_OLE_Plan(planName, planType, planYear);
										premiumMap = planSummaryPage.collectInfoWelcomeOLEpg(planName, countyName, planYear, sheetName, rowIndex , highOptionDental, dentalPlatinum);
										} else {
					    					result = planSummaryPage.Enroll_OLE_Plan_PlanDetails(planName, planType);
					    					//btnMap = planSummaryPage.updatedEnroll_OLE_Plan_PlanDetails(planName, planType);
										if (result) {
											premiumMap = planSummaryPage.collectInfoWelcomeOLEpg(planName, countyName, planYear, sheetName, rowIndex , highOptionDental, dentalPlatinum);
										}
										/*if (btnMap.get("EnrollBtnDisplayed")){
											premiumMap = planSummaryPage.collectInfoWelcomeOLEpg(planName, countyName, planYear, sheetName, rowIndex , highOptionDental, dentalPlatinum);
										}*/
									}
								 }
								if (result) {
									if (!(currentColName.equalsIgnoreCase("plan year") ||
											currentColName.equalsIgnoreCase("plan id qa script") ||
											currentColName.equalsIgnoreCase("Contract PBP Segment ID") ||
											currentColName.equalsIgnoreCase("Segment ID") ||
											currentColName.equalsIgnoreCase("product focus") ||
											currentColName.equalsIgnoreCase("dsnp sub type") ||
											currentColName.equalsIgnoreCase("Error Count") ||
											currentColName.equalsIgnoreCase("portal labels") ||
											currentColName.equalsIgnoreCase("plan type") ||
											currentColName.equalsIgnoreCase("county") ||
											currentColName.equalsIgnoreCase("Link parameters") ||
											currentColName.equalsIgnoreCase("product")  ||
											currentColName.equalsIgnoreCase("Fips")
									)) {
                                        resultMap = planSummaryPage.comparePremium(sheetName, rowIndex, currentColName, currentCellValue, premiumMap);

										if (resultMap.containsKey(false))
											valueMatches = false;
										System.out.println(currentColName + " : " + valueMatches);
										if (valueMatches)
											newCell.setCellStyle(stylePassed);
										else {
											newCell.setCellStyle(styleFailed);
											failureCounter++;
										}

									}
								}
								
								/*if (btnMap.get("EnrollBtnDisplayed")) {
									if (!(currentColName.equalsIgnoreCase("plan year") ||
											currentColName.equalsIgnoreCase("plan id qa script") ||
											currentColName.equalsIgnoreCase("Contract PBP Segment ID") ||
											currentColName.equalsIgnoreCase("Segment ID") ||
											currentColName.equalsIgnoreCase("product focus") ||
											currentColName.equalsIgnoreCase("dsnp sub type") ||
											currentColName.equalsIgnoreCase("Error Count") ||
											currentColName.equalsIgnoreCase("portal labels") ||
											currentColName.equalsIgnoreCase("plan type") ||
											currentColName.equalsIgnoreCase("county") ||
											currentColName.equalsIgnoreCase("Link parameters") ||
											currentColName.equalsIgnoreCase("product")  ||
											currentColName.equalsIgnoreCase("Fips")
									)) {
                                        resultMap = planSummaryPage.comparePremium(sheetName, rowIndex, currentColName, currentCellValue, premiumMap);

										if (resultMap.containsKey(false))
											valueMatches = false;
										System.out.println(currentColName + " : " + valueMatches);
										if (valueMatches)
											newCell.setCellStyle(stylePassed);
										else {
											newCell.setCellStyle(styleFailed);
											failureCounter++;
										}

									}
								}*/
								//
								/*if(currentColName.equalsIgnoreCase("Monthly Premium") && rowIndex != 0 && !result){
										newCell.setCellValue("N/A");
										newCell.setCellStyle(stylePassed);
								}
								 if(currentColName.equalsIgnoreCase("Monthly Premium") && rowIndex != 0){
								 	System.out.println("VALIDATE_PREMIUM_NA_AND_PLAN SHOULD NOT HAVE ENROLL BUTTON");
								 	//result = true;
								 	if (currentCellValue.equalsIgnoreCase("NA") && result) {
								 		 newCell.setCellValue("ERROR");
										 newCell.setCellStyle(styleFailed);
										 failureCounter++;
									 }
								 }
		*/

								 if(currentColName.equalsIgnoreCase("Monthly Premium")) {
									 System.out.println("RUNNING TEST FOR MONTHLY PREMIUM");
									 System.out.println("MONTHLY PREMIUM IS: "+currentCellValue);
									 //For plan having enroll button in UI result flag is true
									 //TEST1- PREMIUM_ANY NUMERIC VALUE-e.g. 90$ & PLAN DOES NOT HAVE ENROLL BTN- RESULT SHOULD BE-ERROR COUNT=1
									 if (currentCellValue.contains("$") && rowIndex != 0 && !result) {
										 System.out.println("EXECUTING TEST1");
										 String output = "ERROR_EXPECTED-ENROLL BTN SHOULD BE PRESENT FOR THIS PLAN_ACTUAL-ENROLL BTN NOT PRESENT";
										 newCell.setCellValue(output);
										 newCell.setCellStyle(styleFailed);
										 System.out.println(output);
										 failureCounter++;
									 }
									 //TEST2- PREMIUM_NA & PLAN HAVE ENROLL BTN- RESULT SHOULD BE-ERROR COUNT=1
									 if (currentCellValue.equalsIgnoreCase("NA") && rowIndex != 0 && result) {
										 System.out.println("EXECUTING TEST2");
										 String output = "ERROR_EXPECTED-ENROLL BTN SHOULD NOT BE PRESENT FOR THIS PLAN_ACTUAL-ENROLL BTN PRESENT";
									 	 newCell.setCellValue(output);
										 newCell.setCellStyle(styleFailed);
										 System.out.println(output);
										 failureCounter++;
									 }
									 //TEST3- PREMIUM_NA & PLAN DO NOT HAVE ENROLL BTN- RESULT SHOULD BE-ERROR COUNT=0
									 if (currentCellValue.equalsIgnoreCase("NA") && rowIndex != 0 && !result) {
										 System.out.println("EXECUTING TEST3");
									 	 String output = "SUCCESS_EXPECTED-ENROLL BTN SHOULD NOT BE PRESENT FOR THIS PLAN_ACTUAL-ENROLL BTN NOT PRESENT";
										 newCell.setCellValue(output);
										 newCell.setCellStyle(stylePassed);
										 System.out.println(output);
									 }
								 }
									 //	if(result){
								if (currentColName.equalsIgnoreCase("Error Count") && rowIndex != 0) {
									newCell.setCellValue(failureCounter);
								}
								/*else if (currentColName.equalsIgnoreCase("Save Plan Displayed") && rowIndex != 0)
								{
									newCell.setCellValue(btnMap.get("SaveBtnDisplayed"));
								}
								*/
								
								else{
									if (valueMatches) {//if boolean value is true then it will write only the excel value from the input sheet and mark it green
										//newCell.setCellValue(cell.getStringCellValue());
										//if(!currentColName.equalsIgnoreCase("Monthly Premium")){
											//if boolean value is true then it will write only the excel value from the input sheet and mark it green
											newCell.setCellValue(cell.getStringCellValue());
										//}
									} else {                        //boolean value is false so it will add the UI value as well to differentiate and mark the cell red
										newCell.setCellValue("Excel Value: " + cell.getStringCellValue() + " / UI Value: " + resultMap.get(false));
									}
								}
							//}
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

				/*int lastRow_output = ResultsSheet.getLastRowNum();
				if (lastRow != lastRow_output){
					Assert.assertFalse(false,"Premium validation failed");
				}*/



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
