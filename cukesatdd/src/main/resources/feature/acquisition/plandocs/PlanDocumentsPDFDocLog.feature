@PlanDetails_PlanDocumentsAARP
Feature: test Plan Documents PDFs on Plan Deatils Page
  

  @PlanDocs_ExcelValidation
  Scenario Outline: Verify specific PDF Plan Documents in Plan Details Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user picks each example from excel to validate Plan Document PDFs and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site					| <site>			|


    @pdfDocLogAARP01
    Examples: 
      | excelPath                | workSheet | site | 
      | PlanDocs_Validation_Data | Sheet1    | AARP | 
      
      @pdfDocLogAARP02
    Examples: 
      | excelPath                | workSheet | site |
      | PlanDocs_Validation_Data | Sheet2    | AARP |
      
         @pdfDocLogAARP03
    Examples: 
      | excelPath                | workSheet | site |
      | PlanDocs_Validation_Data | Sheet3    | AARP |
      
      @pdfDocLogUHC01
    Examples: 
      | excelPath                | workSheet | site |
      | PlanDocs_Validation_Data | Sheet1    | UHC |
      
       @pdfDocLogUHC02
    Examples: 
      | excelPath                | workSheet | site |
      | PlanDocs_Validation_Data | Sheet2    | UHC |
      
       @pdfDocLogUHC03
    Examples: 
      | excelPath                | workSheet | site |
      | PlanDocs_Validation_Data | Sheet3    | UHC |