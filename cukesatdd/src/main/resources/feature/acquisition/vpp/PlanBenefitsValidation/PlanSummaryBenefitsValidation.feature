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
      | Plan Summary Benefits_Data | Sheet2020_1  | AARP |
      
      @planSummaryBenefitsAARP02
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_2  | AARP |
      
      @planSummaryBenefitsAARP03
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_3  | AARP |
      
      @planSummaryBenefitsAARP04
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_4  | AARP |
      
      @planSummaryBenefitsAARP05
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_5  | AARP |
      
      @planSummaryBenefitsAARP06
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_6  | AARP |
      
      @planSummaryBenefitsAARP07
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_7  | AARP |
      
      @planSummaryBenefitsAARP08
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_8  | AARP |
      
      @planSummaryBenefitsAARP09
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_9  | AARP |
      
      @planSummaryBenefitsAARP10
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_10  | AARP |
      
      @planSummaryBenefitsAARP11
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_11 | AARP |
      
      @planSummaryBenefitsAARP12
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_12  | AARP |
      
      @planSummaryBenefitsPDPAARP01
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | PDPSheet2020_1  | AARP |
      
       @planSummaryBenefitsPDPAARP02
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | PDPSheet2020_2  | AARP |
      
# Below are examples for UHC plan Summary benefits

      @planSummaryBenefitsUHC01
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_1  | UHC |
      
      @planSummaryBenefitsUHC02
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_2  | UHC |
      
      @planSummaryBenefitsUHC03
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_3  | UHC |
      
      @planSummaryBenefitsUHC04
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_4  | UHC |
      
      @planSummaryBenefitsUHC05
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_5  | UHC |
      
      @planSummaryBenefitsUHC06
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_6  | UHC |
      
      @planSummaryBenefitsUHC07
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_7  | UHC |
      
      @planSummaryBenefitsUHC08
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_8  | UHC |
      
      @planSummaryBenefitsUHC09
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_9  | UHC |
      
      @planSummaryBenefitsUHC10
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_10  | UHC |
      
      @planSummaryBenefitsUHC11
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_11 | UHC |
      
      @planSummaryBenefitsUHC12
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2020_12  | UHC |
      
      @planSummaryBenefitsPDPUHC01
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | PDPSheet2020_1  | UHC |
      
       @planSummaryBenefitsPDPUHC02
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | PDPSheet2020_2  | UHC |
      
#2021 Plans
      @planSummaryBenefitsAARP01_NextYear
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2021_1  | AARP |
      
      @planSummaryBenefitsAARP02_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2021_2  | AARP |
      
      @planSummaryBenefitsAARP03_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data |Sheet2021_3  | AARP |
      
      @planSummaryBenefitsAARP04_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2021_4  | AARP |
      
      @planSummaryBenefitsAARP05_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2021_5  | AARP |
      
      @planSummaryBenefitsAARP06_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2021_6  | AARP |
      
      @planSummaryBenefitsAARP07_NextYear
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2021_7  | AARP |
      
      @planSummaryBenefitsAARP08_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2021_8  | AARP |
      
      @planSummaryBenefitsAARP09_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2021_9  | AARP |
      
      @planSummaryBenefitsAARP10_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2021_10  | AARP |
      
      @planSummaryBenefitsAARP11_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2021_11 | AARP |
      
      @planSummaryBenefitsAARP12_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2021_12  | AARP |
      
        @planSummaryBenefitsAARP13_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2021_13 | AARP |
      
      @planSummaryBenefitsAARP14_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | Sheet2021_14  | AARP |
      
      @planSummaryBenefitsPDPAARP01_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | SheetPDP2021_1  | AARP |
      
       @planSummaryBenefitsPDPAARP02_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_Data | SheetPDP2021_2  | AARP |