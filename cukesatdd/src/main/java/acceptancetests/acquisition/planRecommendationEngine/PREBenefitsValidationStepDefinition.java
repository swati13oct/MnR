package acceptancetests.acquisition.planRecommendationEngine;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import acceptancetests.data.CommonConstants;
import atdd.framework.DataTableParser;
import atdd.framework.MRScenario;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import pages.acquisition.commonpages.*;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineLandingAndZipcodePages;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineNewResultsPage;
import pages.acquisition.planRecommendationEngine.PlanRecommendationEngineResultsPage;
import pages.acquisition.planRecommendationEngine.PREBenefitsPage.PlanRecommendationEngineBenefits;

public class PREBenefitsValidationStepDefinition {

	@Autowired

	MRScenario loginScenario;

	public MRScenario getLoginScenario() {
		return loginScenario;
	}

	WebDriver wd;
	// List<DataTableRow> inputRow;
	HashMap<String, String> inputValues;
	public static String PREflow = "";

	boolean if_offline_prod = false, popup_clicked = false;

	public void readfeaturedata(DataTable data) {
		inputValues = new HashMap<String, String>();
		inputValues = DataTableParser.readDataTableAsMaps(data);
		String temp = inputValues.get("Plan Type");
		if (temp != null && PREflow != temp) {
			PREflow = temp;
			System.out.println("Current PRE Flow : " + PREflow);
		}
	}

	@Then("^the user navigates to PRE results page and compares plan benefits value from excel to UI and reports into excel$")
	public void preResults_exceldataValidation(DataTable givenAttributes) throws Throwable {
		// List<DataTableRow> givenAttributesRow = givenAttributes.getGherkinRows();
		Map<String, String> givenAttributesMap = new HashMap<String, String>();
		givenAttributesMap = DataTableParser.readDataTableAsMaps(givenAttributes);
		/*
		 * for (int i = 0; i < givenAttributesRow.size(); i++) {
		 * 
		 * givenAttributesMap.put(givenAttributesRow.get(i).getCells().get(0),
		 * givenAttributesRow.get(i).getCells().get(1)); }
		 */
		String ExcelName = givenAttributesMap.get("ExcelFile");
		String sheetName = givenAttributesMap.get("WorkSheetName");
		String siteType = givenAttributesMap.get("Site");
		String AEP = givenAttributesMap.get("AEP");
		String user = givenAttributesMap.get("USER");
		String year = givenAttributesMap.get("YEAR");

		WebDriver wd = getLoginScenario().getWebDriverNew();
		getLoginScenario().saveBean(CommonConstants.WEBDRIVER, wd);

		// Getting Date
		DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
		Date RunDate = new Date();
		String DateCreated = dateFormat.format(RunDate);
		String parentDirectory = null;
		parentDirectory = new java.io.File(".").getCanonicalPath();
		String InputFilePath = parentDirectory + "/src/main/resources/database/PREPlanDocs/" + ExcelName + ".xlsx";
		String OutputFilePath = parentDirectory + "/target/PREPlanBenefitsValidation_Results_" + ExcelName + "_"
				+ sheetName + "_" + siteType + "_" + DateCreated + ".xlsx";

		// Reading Excel.xlsx file
		File InputFile = new File(InputFilePath);
		FileInputStream inputStream = new FileInputStream(InputFile);
		XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum();
		System.out.println("Total Number of rows in " + sheetName + ": " + lastRow);

		// lastRow = 1;

		XSSFWorkbook ResultWorkbook = new XSSFWorkbook();
		XSSFSheet ResultsSheet = ResultWorkbook.createSheet("PREPlanBenefitsResults");

		CellStyle stylePassed = ResultWorkbook.createCellStyle();
		stylePassed.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		stylePassed.setFillPattern(CellStyle.SOLID_FOREGROUND);

		CellStyle styleFailed = ResultWorkbook.createCellStyle();
		styleFailed.setFillForegroundColor(IndexedColors.RED.getIndex());
		styleFailed.setFillPattern(CellStyle.SOLID_FOREGROUND);

		// Setting First Row for Results excel
		try {
			String currentCellValue = "";
			String currentColName = "";
			int zipCellNum = 0, countyCellNum = 0, planNameCellNum = 0;
			HashMap<String, String> benefitsMapPRE = new HashMap<String, String>();
			System.out.println(sheetName + " SAUCE URL: " + getLoginScenario().returnJobURL());

			PlanRecommendationEngineBenefits preBenefits = new PlanRecommendationEngineBenefits(wd);
			// Looping over total rows with values
			for (int rowIndex = 0; rowIndex <= lastRow; rowIndex++) {
				int failureCounter = 0;
				int cellIndex = 0;
				System.out.println("INSIDE Row");

				XSSFRow row = (XSSFRow) sheet.getRow(rowIndex);
				Iterator<Cell> cellIterator = row.cellIterator();
				XSSFRow resultsRow = (XSSFRow) ResultsSheet.createRow(rowIndex);

				// looping through columns until an empty column is found
				while (cellIterator.hasNext()) {
					HashMap<Boolean, String> resultMap = new HashMap<Boolean, String>();
					boolean valueMatches = true;
					XSSFCell cell = (XSSFCell) cellIterator.next();

					try {
						currentCellValue = cell.getStringCellValue();
						currentColName = sheet.getRow(0).getCell(cellIndex).getStringCellValue();
					} catch (Exception e) {
						System.out
								.println("Error getting value for " + sheetName + " Row " + rowIndex + " Cell " + cell);
						System.out.println(e);
					}
					XSSFCell newCell = (XSSFCell) resultsRow.createCell(cellIndex);
					if (rowIndex == 0) {
						newCell.setCellValue(cell.getStringCellValue());
						if (cell.getStringCellValue().equalsIgnoreCase("zipcode")
								|| cell.getStringCellValue().equalsIgnoreCase("zip code"))
							zipCellNum = cellIndex;
						else if (cell.getStringCellValue().equalsIgnoreCase("county"))
							countyCellNum = cellIndex;
						else if (cell.getStringCellValue().equalsIgnoreCase("plan name"))
							planNameCellNum = cellIndex;
					}

					if (rowIndex != 0) { // skip the header row
						if (cellIndex == 0) {

							String zipcode = row.getCell(zipCellNum).getStringCellValue();
							String countyName = row.getCell(countyCellNum).getStringCellValue();
							String planName = row.getCell(planNameCellNum).getStringCellValue();

							System.out.println("Validating " + sheetName + " Plan " + rowIndex
									+ " ************************************************************");

							AcquisitionHomePage aquisitionhomepage = new AcquisitionHomePage(wd, "PRE");

							PlanRecommendationEngineNewResultsPage resultsPage = new PlanRecommendationEngineNewResultsPage(
									wd);

							System.out.println(siteType);

							// wd.get("https://digital-uatv2-uhcmedicaresolutions.ocp-elr-core-nonprod.optum.com/plan-recommendation-engine.html#/get-started");

								if (AEP.equalsIgnoreCase("YES")) {
									if_offline_prod = aquisitionhomepage.openAEPPRE(siteType, user);
									aquisitionhomepage.fixPrivateConnection();
									aquisitionhomepage.loginflagSmithPRE(siteType, user);
									checkpopup();
								} else {
									if_offline_prod = aquisitionhomepage.openPRE(siteType);
									aquisitionhomepage.fixPrivateConnection();
									checkpopup();
								}
								
								//try {
								PlanRecommendationEngineLandingAndZipcodePages zip = new PlanRecommendationEngineLandingAndZipcodePages(
										wd);
								zip.navigateToCoveragePage(zipcode, countyName);

								Thread.sleep(5000);

								String recomObj = zip.getSessionValue("Session Storage", "ucp_planRecommendationObj");

								// set session

								String sessionValue = getSessionInfo(recomObj);

								zip.setSession("Session Storage", "ucp_planRecommendationObj", sessionValue);

								zip.navigateToPREResultsPage();

								if (year.equalsIgnoreCase("2021")) {
									PlanRecommendationEngineResultsPage planSelectorResultspage = new PlanRecommendationEngineResultsPage(
											wd);
									planSelectorResultspage.changePlanyear("current");
								}
							/*} catch (Exception flowerror) {
								System.out.println("**** Flow Error *** "+flowerror);
								break; // If any exception in flow then no record in excel
							}*/

							int planIndex = resultsPage.findPlan(planName,true);
							int planYear = 2021; // Not using now

							if (planIndex < 0)
								break;// If No plan in UI then no record in Result excel

							benefitsMapPRE = preBenefits.collectInfoPREResultsPage(zipcode, planName, planIndex,
									planYear, sheetName, rowIndex);
						}
						if (!(currentColName.equalsIgnoreCase("plan year")
								|| currentColName.equalsIgnoreCase("plan id qa script")
								|| currentColName.equalsIgnoreCase("product focus")
								|| currentColName.equalsIgnoreCase("dsnp sub type")
								|| currentColName.equalsIgnoreCase("Error Count")
								|| currentColName.equalsIgnoreCase("portal labels")
								|| currentColName.equalsIgnoreCase("OON_IN")
								|| currentColName.equalsIgnoreCase("plan type")
								|| currentColName.equalsIgnoreCase("county")
								|| currentColName.equalsIgnoreCase("Link parameters")
								|| currentColName.contains("Segment ID") || currentColName.equalsIgnoreCase("product")
								|| currentColName.equalsIgnoreCase("plan name")
								|| currentColName.equalsIgnoreCase("zipcode")
								|| currentColName.equalsIgnoreCase("zip code")
								|| currentColName.equalsIgnoreCase("drug name")
								|| currentColName.equalsIgnoreCase("fips")
								|| currentColName.equalsIgnoreCase("Plan code")
								|| currentColName.equalsIgnoreCase("StateCode")
								|| currentColName.equalsIgnoreCase("State"))) {

							resultMap = preBenefits.comparePREBenefits(currentColName, currentCellValue,
									benefitsMapPRE);

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

						if (currentColName.equalsIgnoreCase("Error Count") && rowIndex != 0)
							newCell.setCellValue(failureCounter);
						else {
							if (valueMatches) { // if boolean value is true then it will write only the excel value from
												// the input sheet and mark it green
								newCell.setCellValue(cell.getStringCellValue());
							} else { // boolean value is false so it will add the UI value as well to differentiate
										// and mark the cell red
								newCell.setCellValue("Excel Value: " + cell.getStringCellValue() + " / UI Value: "
										+ resultMap.get(false));
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

	// String sampleJson =
	// "{\"preferences\":[{\"questionId\":\"planType\",\"answers\":[{\"id\":\"co_ma\"}]},{\"questionId\":\"snpType\",\"answers\":[{\"id\":\"snp_none\"}]},{\"questionId\":\"doctorPref\",\"answers\":[{\"id\":\"doctor_accepts_medicare\"}]},{\"questionId\":\"additional-dental\",\"answers\":[{\"id\":\"as_dental_no\"}]},{\"questionId\":\"additional-hearing\",\"answers\":[{\"id\":\"as_hearing_no\"}]},{\"questionId\":\"additional-vision\",\"answers\":[{\"id\":\"as_vision_no\"}]},{\"questionId\":\"additional-fitness
	// membership\",\"answers\":[{\"id\":\"as_fitness_no\"}]},{\"questionId\":\"healthCarePref\",\"answers\":[{\"id\":\"cs_low\"}]}],\"planYear\":2021,\"location\":{\"zipcode\":\"10001\",\"selectedCounty\":{\"fipsCountyCode\":\"061\",\"fipsCountyName\":\"New
	// York
	// County\",\"fipsStateCode\":\"36\",\"stateCode\":\"NY\",\"cmsCountyCodes\":[\"420\"]}}}";

	public String getSessionInfo(String sessionObj) {
		String preferencePRE = "{\"preferences\":[{\"questionId\":\"planType\",\"answers\":[{\"id\":\"co_ma\"}]},{\"questionId\":\"snpType\",\"answers\":[{\"id\":\"snp_none\"}]},{\"questionId\":\"doctorPref\",\"answers\":[{\"id\":\"doctor_accepts_medicare\"}]},{\"questionId\":\"additional-dental\",\"answers\":[{\"id\":\"as_dental_no\"}]},{\"questionId\":\"additional-hearing\",\"answers\":[{\"id\":\"as_hearing_no\"}]},{\"questionId\":\"additional-vision\",\"answers\":[{\"id\":\"as_vision_no\"}]},{\"questionId\":\"additional-fitness\",\"answers\":[{\"id\":\"as_fitness_no\"}]},{\"questionId\":\"healthCarePref\",\"answers\":[{\"id\":\"cs_low\"}]}],";
		String planYear = "2022";
		String pYear = "\"planYear\":" + planYear + ",";
		String locationObj = "\"location\":";
		String msObj = "\"medsuppUserInfo\":";
		String plansObj = "\"plans\":[],";
		String fewMore = ",\"prevYearPlans\":null,\"plansFilter\":null,\"comparedPlans\":null,\"editResponse\":false";
		// {\"zipcode\":\"10001\",\"selectedCounty\":{\"fipsCountyCode\":\"061\",\"fipsCountyName\":\"New
		// York
		// County\",\"fipsStateCode\":\"36\",\"stateCode\":\"NY\",\"cmsCountyCodes\":[\"420\"]}}}";

		JSONParser parser = new JSONParser();
		JSONObject jsonObj = new JSONObject();
		String locationValues = "", medsubValues = "null";
		try {
			jsonObj = (JSONObject) parser.parse(sessionObj);
			System.out.println(jsonObj.get("location"));
			locationValues = jsonObj.get("location").toString();
			// System.out.println("mmmeeedddsssubb "+jsonObj.get("medsuppUserInfo"));
			if (jsonObj.get("medsuppUserInfo") != null)
				medsubValues = jsonObj.get("medsuppUserInfo").toString();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println(
				preferencePRE + plansObj + pYear + locationObj + locationValues + "," + msObj + medsubValues + fewMore +"}");
		return preferencePRE + plansObj + pYear + locationObj + locationValues + "," + msObj + medsubValues + fewMore + "}";
	}

	public void checkpopup() {
		if (if_offline_prod && !popup_clicked) {
			PlanRecommendationEngineLandingAndZipcodePages planSelectorhomepage = new PlanRecommendationEngineLandingAndZipcodePages(
					(WebDriver) getLoginScenario().getBean(CommonConstants.WEBDRIVER));
			popup_clicked = planSelectorhomepage.close_Popup();
		}
	}

}
