package acceptancetests.acquisition.vpp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import acceptancetests.data.CommonConstants;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.emailAndPrint.EmailAndPrintUtil;
import pages.acquisition.vppforaep.AepPlanComparePage;
import pages.acquisition.vppforaep.AepPlanDetailsPage;
import pages.acquisition.vppforaep.AepVppPlanSummaryPage;
import pages.acquisition.vppforaep.VppCommonPage;

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
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		
		
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
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
				 String currentCellValue = "";
				 String currentColName = "";
				  
				 HashMap <String, String> benefitsMap = new HashMap<String, String>();
				 System.out.println(sheetName+ " SAUCE URL: "+ MRScenario.returnJobURL());
				 //Looping over total rows with values
				 for(int rowIndex=0; rowIndex<=lastRow; rowIndex++)
		            {
					 	int failureCounter = 0;
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
		                		 currentColName = sheet.getRow(0).getCell(cellIndex).getStringCellValue();
		                	 }catch (Exception e) {
		                		 System.out.println("Error getting value for "+sheetName+ " Row "+rowIndex +" Cell "+cell);
		                		 System.out.println(e);
		                	 }
			                 HSSFCell newCell = (HSSFCell) resultsRow.createCell(cellIndex); 
							 if(rowIndex==0) {
								 newCell.setCellValue(cell.getStringCellValue()); 
							 }
							 if(rowIndex!=0) { //skip the header row
								 if(cellIndex==0) { 
									 
									  System.out.println("Validating "+sheetName+ " Plan "+rowIndex+" ************************************************************");
									  new VppCommonPage(wd,siteType,currentCellValue);  //gets the partial deeplink fromt the excel and appends it with the environment URL and navigates to plan details page	
									  planDetailsPage = new AepPlanDetailsPage(wd);
									  
									  if(sheetName.contains("PDP")) {
										  if(!row.getCell(6).getStringCellValue().contains("NA")) {
											  planDetailsPage.navigateToDCEandAddDrug(row.getCell(6).getStringCellValue());
											  benefitsMap = planDetailsPage.collectInfoVppPlanDetailPg();
											  planDetailsPage.editDrugListAndRemoveDrug();
										  }else 
											  benefitsMap = planDetailsPage.collectInfoVppPlanDetailPg();
									  }else
										  benefitsMap = planDetailsPage.collectInfoVppPlanDetailPg();              //  stores all the table info into hashmap

								 }

								 if(!(currentColName.equalsIgnoreCase("Drug Name")||currentColName.equalsIgnoreCase("Error Count")||currentColName.equalsIgnoreCase("portal labels")||currentColName.equalsIgnoreCase("OON_IN")||currentColName.equalsIgnoreCase("plan type")||currentColName.equalsIgnoreCase("county")||currentColName.equalsIgnoreCase("Link parameters")||currentColName.equalsIgnoreCase("Contract PBP Segment ID")||currentColName.equalsIgnoreCase("product")||currentColName.equalsIgnoreCase("plan name")||currentColName.equalsIgnoreCase("zipcode")||currentColName.equalsIgnoreCase("fips"))) {	

								      resultMap = planDetailsPage.compareBenefits(currentColName, currentCellValue, benefitsMap); //compares the benefit value from the excel to the values from the hashmap. key = columnName, value= benefit value
								      if(resultMap.containsKey(false))
											 valueMatches = false;
									  System.out.println(currentColName + " : "+ valueMatches);
									 	if(valueMatches) {					                    
									 		newCell.setCellStyle(stylePassed);
								 		}else {		
								 			newCell.setCellStyle(styleFailed);
									 		failureCounter++;										 
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
	
	@Then("^the user navigates to plan compare page and compares benefits value from excel to UI and reports into excel$")
	public void exceldataValidation_planCompare(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
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

			  
		//Setting First Row for Results excel

			try {
				 AepPlanComparePage planComparePage = null;
				 String currentCellValue = "";
				 String currentColName = "";
				 
				 HashMap <String, String> benefitsMap = new HashMap<String, String>();
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
		                		 currentColName = sheet.getRow(0).getCell(cellIndex).getStringCellValue();
		                	 }catch (Exception e) {
		                		 System.out.println("Error getting value for "+sheetName+ " Row "+rowIndex +" Cell "+cell);
		                		 System.out.println(e);
		                	 }
			                 HSSFCell newCell = (HSSFCell) resultsRow.createCell(cellIndex); 
							 newCell.setCellValue(cell.getStringCellValue());
							
							 if(rowIndex!=0) { //skip the header row
								 if(cellIndex==0) { 
									 
								  System.out.println("Validating "+sheetName+ " Plan "+rowIndex+" ************************************************************");
									 new VppCommonPage(wd,siteType,currentCellValue);  //gets the partial deeplink fromt the excel and appends it with the environment URL and navigates to plan details page
									 planComparePage = new AepPlanComparePage(wd);

									 if(sheetName.contains("PDP")) {
										 benefitsMap = planComparePage.collectInfoVppPlanComparePg("PDP","");
									 }
									 else
									 {
									 	benefitsMap = planComparePage.collectInfoVppPlanComparePg(row.getCell(3).getStringCellValue(), row.getCell(1).getStringCellValue());
									 }
								 }

								 if(!(currentColName.equalsIgnoreCase("Product") || currentColName.equalsIgnoreCase("Out-of-Network Benefits")|| currentColName.equalsIgnoreCase("Error Count")||currentColName.equalsIgnoreCase("Drug Name")||currentColName.equalsIgnoreCase("county")||currentColName.equalsIgnoreCase("Link parameters")||currentColName.equalsIgnoreCase("Contract PBP Segment ID")||currentColName.equalsIgnoreCase("plan name")||currentColName.equalsIgnoreCase("zipcode")||currentColName.equalsIgnoreCase("fips"))) {

									 resultMap = planComparePage.compareBenefits(currentColName, currentCellValue, benefitsMap); //compares the benefit value from the excel to the values from the hashmap. key = columnName, value= benefit value
									 if(resultMap.containsKey(false))
										 valueMatches = false;
									  System.out.println(currentColName + " : "+ valueMatches);
									 	if(!valueMatches) {
									 		//Ignore OON column data validation for a Plan that is only In-network
											if(row.getCell(1).getStringCellValue().trim().startsWith("IN") && currentColName.trim().endsWith("OON"))
											{
												newCell.setCellStyle(styleIgnore);
											}
											else {
												newCell.setCellStyle(styleFailed);
												failureCounter++;
											}
								 		}else {				
								 			newCell.setCellStyle(stylePassed);
								 
									  }
								 }

								 if(currentColName.equalsIgnoreCase("Error Count")&&rowIndex!=0)
									 newCell.setCellValue(failureCounter);
								 else {
									 if(valueMatches) { 			//if boolean value is true then it will write only the excel value from the input sheet and mark it green
										 newCell.setCellValue(cell.getStringCellValue());
									 } else {
										 //Ignore OON column data validation for a Plan that is only In-network
										 if(row.getCell(1).getStringCellValue().trim().startsWith("IN") && currentColName.trim().endsWith("OON"))
										 {
											 newCell.setCellValue(cell.getStringCellValue());
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
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
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
			  
		//Setting First Row for Results excel

			try {
			
				 AepVppPlanSummaryPage planSummaryPage = null;
				 String currentCellValue = "";
				 String currentColName = "";
				 
				 HashMap <String, String> benefitsMap = new HashMap<String, String>();
				 System.out.println(sheetName+ " SAUCE URL: "+ MRScenario.returnJobURL());
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
		                		 currentColName = sheet.getRow(0).getCell(cellIndex).getStringCellValue();
		                	 }catch (Exception e) {
		                		 System.out.println("Error getting value for "+sheetName+ " Row "+rowIndex +" Cell "+cell);
		                		 System.out.println(e);
		                	 }
			                 HSSFCell newCell = (HSSFCell) resultsRow.createCell(cellIndex); 
			                 if(rowIndex==0) {
								 newCell.setCellValue(cell.getStringCellValue()); 
			                 }
							
							 if(rowIndex!=0) { //skip the header row
								 if(cellIndex==0) { 
									 
									  String countyName = row.getCell(4).getStringCellValue();
									  String planYear = row.getCell(5).getStringCellValue();
									  String planName = row.getCell(3).getStringCellValue();
									  
									  System.out.println("Validating "+sheetName+ " Plan "+rowIndex+" ************************************************************");
									  new VppCommonPage(wd,siteType,currentCellValue);  //gets the partial deeplink fromt the excel and appends it with the environment URL and navigates to plan details page
									  planSummaryPage = new AepVppPlanSummaryPage(wd);
									  planSummaryPage.checkForMultiCountyPopup(countyName);
									  planSummaryPage.selectYearOption(planYear);
									  benefitsMap = planSummaryPage.collectInfoVppPlanSummaryPg(planName);   									  							  		
								 }

								 if(!(currentColName.equalsIgnoreCase("plan year")||currentColName.equalsIgnoreCase("Error Count")||currentColName.equalsIgnoreCase("portal labels")||currentColName.equalsIgnoreCase("OON_IN")||currentColName.equalsIgnoreCase("plan type")||currentColName.equalsIgnoreCase("county")||currentColName.equalsIgnoreCase("Link parameters")||currentColName.equalsIgnoreCase("Contract PBP Segment ID")||currentColName.equalsIgnoreCase("product")||currentColName.equalsIgnoreCase("plan name")||currentColName.equalsIgnoreCase("zipcode")||currentColName.equalsIgnoreCase("fips"))) {	
									 
									 resultMap = planSummaryPage.compareBenefits(currentColName, currentCellValue, benefitsMap); //compares the benefit value from the excel to the values from the hashmap. key = columnName, value= benefit value
									 if(resultMap.containsKey(false))
										 valueMatches = false;
									 System.out.println(currentColName + " : "+ valueMatches);
									 if(valueMatches) 
										 newCell.setCellStyle(stylePassed);	
									 else {
										 newCell.setCellStyle(styleFailed);				
									 	  failureCounter++;
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
