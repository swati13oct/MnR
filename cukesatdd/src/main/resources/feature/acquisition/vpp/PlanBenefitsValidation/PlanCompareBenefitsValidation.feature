@vppUlayer 
Feature: ACQ-Plan benefits validation

     
  @planCompare_ExcelValidation
  Scenario Outline: Verify plan benefits on the Plan Compare Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to plan compare page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>			|

			@planCompareBenefitsAARP01
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Compare_Benefits_Data | Sheet1  | AARP |
      
      @planCompareBenefitsAARP02
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Compare_Benefits_Data | Sheet2  | AARP |
      
      @planCompareBenefitsAARP03
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Compare_Benefits_Data | Sheet3  | AARP |
      
      @planCompareBenefitsAARP04
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Compare_Benefits_Data | Sheet4  | AARP |
      
      @planCompareBenefitsAARP05
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Compare_Benefits_Data | Sheet5  | AARP |
      
      @planCompareBenefitsAARP06
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Compare_Benefits_Data | Sheet6  | AARP |
      
      @planCompareBenefitsAARP07
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Compare_Benefits_Data | Sheet7  | AARP |
      
      @planCompareBenefitsAARP08
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Compare_Benefits_Data | Sheet8  | AARP |
      
      @planCompareBenefitsAARP09
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Compare_Benefits_Data | Sheet9  | AARP |
      
      @planCompareBenefitsAARP10
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Compare_Benefits_Data | Sheet10  | AARP |
      
      @planCompareBenefitsAARP11
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Compare_Benefits_Data | Sheet11 | AARP |
      
      @planCompareBenefitsAARP12
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Compare_Benefits_Data | Sheet12  | AARP |
      
      @planCompareBenefitsPDPAARP01
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Compare_Benefits_Data | PDPSheet1  | AARP |
      
       @planCompareBenefitsPDPAARP02
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Compare_Benefits_Data | PDPSheet2  | AARP |