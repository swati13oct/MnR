package acceptancetests.acquisition.vpp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Iterator;

import org.apache.poi.hssf.record.cf.PatternFormatting;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;



import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import acceptancetests.data.PageConstants;
import acceptancetests.util.CommonUtility;
import atdd.framework.MRScenario;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.formatter.model.DataTableRow;
import pages.acquisition.commonpages.AcquisitionHomePage;
import pages.acquisition.commonpages.PlanDetailsPage;
import pages.acquisition.emailAndPrint.EmailAndPrintUtil;
import pages.acquisition.ulayer.ComparePlansPage;
import pages.acquisition.vppforaep.AepPlanDetailsPage;

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
	public void the_user_ExceldataValidation_PDF_link_and_validates_document_code_in_PDFtext_URL(DataTable givenAttributes) throws Throwable {
		List<DataTableRow> givenAttributesRow = givenAttributes
				.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		for (int i = 0; i < givenAttributesRow.size(); i++) {

			givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
					givenAttributesRow.get(i).getCells().get(1));
		}
		String ExcelName = givenAttributesMap.get("ExcelFile");
		String SheetName = givenAttributesMap.get("WorkSheetName");
		String siteType = givenAttributesMap.get("Site");
		System.out.println("Set of TFNs from Sheet : "+SheetName);
		
		 WebDriver wd = getLoginScenario().getWebDriverNew();
		
			
		
		//Getting Date
			DateFormat dateFormat = new SimpleDateFormat("MMddyyyy");
			Date RunDate = new Date();
			String DateCreated = dateFormat.format(RunDate);
			String parentDirectory = null;
			parentDirectory = new java.io.File(".").getCanonicalPath();
			String InputFilePath = parentDirectory+"/src/main/resources/database/PlanDocs/"+ExcelName+".xls";
			String OutputFilePath = parentDirectory+"/target/PlanValidation_Results_"+ExcelName+"_"+SheetName+"_"+DateCreated+".xls";
			
		//Reading Excel.xls file
			File InputFile = new File(InputFilePath);
			FileInputStream inputStream = new FileInputStream(InputFile);
			Workbook workbook = new HSSFWorkbook(inputStream);
			Sheet sheet = workbook.getSheet(SheetName);
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
				 Iterator<Row> rowIterator = sheet.iterator();
				 AepPlanDetailsPage planDetailsPage = null;
				 String currentCellValue = "";
				 String currentColName = "";
				 
				 HashMap <String, String> benefitsMap = new HashMap<String, String>();
				 //Looping over total rows with values
				 for(int rowIndex=0; rowIndex<=1; rowIndex++)
		            {
					 	int cellIndex = 0;System.out.println("INSIDE Row");
					 	
					 	HSSFRow row = (HSSFRow) sheet.getRow(rowIndex);
		                Iterator<Cell> cellIterator = row.cellIterator();
		                HSSFRow resultsRow = (HSSFRow) ResultsSheet.createRow(rowIndex);
		                
		                //looping through columns until an empty column is found
		                while (cellIterator.hasNext()) 
		                {
		                	 boolean valueMatches = true;
		                	 HSSFCell cell = (HSSFCell) cellIterator.next();
				             currentCellValue = cell.getStringCellValue();
			                 currentColName = sheet.getRow(0).getCell(cellIndex).getStringCellValue();
			           
			                 HSSFCell newCell = (HSSFCell) resultsRow.createCell(cellIndex); 
							 newCell.setCellValue(cell.getStringCellValue());
							
							 if(rowIndex!=0) { //skip the header row
								 if(cellIndex==0) { 
								  System.out.println("Validating Plan "+rowIndex+" ************************************************************");
								  planDetailsPage = new AepPlanDetailsPage(wd,siteType,currentCellValue);  //gets the partial deeplink fromt the excel and appends it with the environment URL and navigates to plan details page
								 benefitsMap = planDetailsPage.collectInfoVppPlanDetailPg();              //  stores all the table info into hashmap
								 
								 }
								  valueMatches = planDetailsPage.compareBenefits(currentColName, currentCellValue, benefitsMap); //compares the benefit value from the excel to the values from the hashmap. key = columnName, value= benefit value
								 
								
								 if(!(currentColName.equalsIgnoreCase("portal labels")||currentColName.equalsIgnoreCase("OON_IN")||currentColName.equalsIgnoreCase("plan type")||currentColName.equalsIgnoreCase("county")||currentColName.equalsIgnoreCase("Link parameters")||currentColName.equalsIgnoreCase("Contract PBP Segment ID")||currentColName.equalsIgnoreCase("product")||currentColName.equalsIgnoreCase("plan name")||currentColName.equalsIgnoreCase("zipcode")||currentColName.equalsIgnoreCase("fips"))) {	
								 		System.out.println(currentColName + " : "+ valueMatches);
									 	if(!valueMatches) {
					                    
									 		newCell.setCellStyle(styleFailed);
								 		}else {
					                    					
								 			newCell.setCellStyle(stylePassed);
								 
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
