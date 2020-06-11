@vppUlayer @emailAndPrint @emailAndPrint_AARP
Feature: 1.04 -ACQ-Print and email on VPP page on AARP

     
  @Plan_ExcelValidation
  Scenario Outline: Verify specific PDF Plan Documents in Plan Details Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to plan details and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>			|

    Examples: 
      | excelPath                   | workSheet | site |
      | PlanBenefits_Validation_Data | PlanBenefits  | AARP |