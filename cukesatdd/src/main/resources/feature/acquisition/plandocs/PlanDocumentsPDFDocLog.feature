@PlanDetails_PlanDocumentsAARP
Feature: test Plan Documents PDFs on Plan Deatils Page
  

  @PlanDocs_ExcelValidation
  Scenario Outline: Verify specific PDF Plan Documents in Plan Details Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user picks each example from excel to validate Plan Document PDFs and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site					| <site>			|
      | ExcelFileDocLog| <excelDocLog>|
      | WorkSheetNameDocLog| <sheetDocLog>|

    @pdfDocLogAARP01
    Examples: 
      | excelPath                | workSheet | site | excelDocLog | sheetDocLog |
      | PlanDocs_Validation_Data | Sheet1    | AARP | MADocLog		| Doc Log	|
      
      @pdfDocLogAARP02
    Examples: 
      | excelPath                | workSheet | site |excelDocLog | sheetDocLog |
      | PlanDocs_Validation_Data | Sheet2    | AARP |MADocLog		| Doc Log	|
      
         @pdfDocLogAARP03
    Examples: 
      | excelPath                | workSheet | site |excelDocLog | sheetDocLog |
      | PlanDocs_Validation_Data | Sheet3    | AARP |MADocLog		| Doc Log	|
      
      @pdfDocLogUHC01
    Examples: 
      | excelPath                | workSheet | site |excelDocLog | sheetDocLog |
      | PlanDocs_Validation_Data | Sheet1    | UHC |MADocLog		| Doc Log	|
      
       @pdfDocLogUHC02
    Examples: 
      | excelPath                | workSheet | site |excelDocLog | sheetDocLog |
      | PlanDocs_Validation_Data | Sheet2    | UHC |MADocLog		| Doc Log	|
      
       @pdfDocLogUHC03
    Examples: 
      | excelPath                | workSheet | site |excelDocLog | sheetDocLog |
      | PlanDocs_Validation_Data | Sheet3    | UHC |MADocLog		| Doc Log	|
