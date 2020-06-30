@vppBenefits
Feature: ACQ-Plan benefits validation

     
  @planSummary_ExcelValidation
  Scenario Outline: Verify plan benefits on the Plan Summary Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to plan summary page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>			|

			@planSummaryBenefitsAARP01
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet1  | AARP |
      
      @planSummaryBenefitsAARP02
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2  | AARP |
      
      @planSummaryBenefitsAARP03
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet3  | AARP |
      
      @planSummaryBenefitsAARP04
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet4  | AARP |
      
      @planSummaryBenefitsAARP05
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet5  | AARP |
      
      @planSummaryBenefitsAARP06
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet6  | AARP |
      
      @planSummaryBenefitsAARP07
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet7  | AARP |
      
      @planSummaryBenefitsAARP08
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet8  | AARP |
      
      @planSummaryBenefitsAARP09
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet9  | AARP |
      
      @planSummaryBenefitsAARP10
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet10  | AARP |
      
      @planSummaryBenefitsAARP11
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet11 | AARP |
      
      @planSummaryBenefitsAARP12
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet12  | AARP |
      
      @planSummaryBenefitsPDPAARP01
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | PDPSheet1  | AARP |
      
       @planSummaryBenefitsPDPAARP02
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | PDPSheet2  | AARP |