@vppUlayer 
Feature: ACQ-Plan benefits validation

     
  @PlanDetails_ExcelValidation
  Scenario Outline: Verify plan benefits on the Plan Details Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to plan details and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>			|

			@planDetailsBenefitsAARP01
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_1  | AARP |
      
      @planDetailsBenefitsAARP02
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_2  | AARP |
      
      @planDetailsBenefitsAARP03
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_3  | AARP |
      
      @planDetailsBenefitsAARP04
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_4  | AARP |
      
      @planDetailsBenefitsAARP05
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_5  | AARP |
      
      @planDetailsBenefitsAARP06
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_6  | AARP |
      
      @planDetailsBenefitsAARP07
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_7  | AARP |
      
      @planDetailsBenefitsAARP08
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_8  | AARP |
      
      @planDetailsBenefitsAARP09
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_9  | AARP |
      
      @planDetailsBenefitsAARP10
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_10  | AARP |
      
      @planDetailsBenefitsAARP11
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_11 | AARP |
      
      @planDetailsBenefitsAARP12
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_12  | AARP |
      
      @planDetailsBenefitsPDPAARP01
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | PDPSheet2020_1  | AARP |
      
       @planDetailsBenefitsPDPAARP02
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | PDPSheet2020_2  | AARP |
      

# Below are examples for UHC plan details benefits

      @planDetailsBenefitsUHC01
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_1  | UHC |
      
      @planDetailsBenefitsUHC02
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_2  | UHC |
      
      @planDetailsBenefitsUHC03
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_3  | UHC |
      
      @planDetailsBenefitsUHC04
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_4  | UHC |
      
      @planDetailsBenefitsUHC05
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_5  | UHC |
      
      @planDetailsBenefitsUHC06
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_6  | UHC |
      
      @planDetailsBenefitsUHC07
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_7  | UHC |
      
      @planDetailsBenefitsUHC08
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_8  | UHC |
      
      @planDetailsBenefitsUHC09
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_9  | UHC |
      
      @planDetailsBenefitsUHC10
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_10  | UHC |
      
      @planDetailsBenefitsUHC11
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_11 | UHC |
      
      @planDetailsBenefitsUHC12
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2020_12  | UHC |
      
      @planDetailsBenefitsPDPUHC01
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | PDPSheet2020_1  | UHC |
      
       @planDetailsBenefitsPDPUHC02
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | PDPSheet2020_2  | UHC |
      
# 2021 plans examples seen below

		@planDetailsBenefitsAARP01_NextYear  
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_1  | AARP |
      
      @planDetailsBenefitsAARP02_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_2  | AARP |
      
      @planDetailsBenefitsAARP03_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_3  | AARP |
      
      @planDetailsBenefitsAARP04_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_4  | AARP |
      
      @planDetailsBenefitsAARP05_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_5  | AARP |
      
      @planDetailsBenefitsAARP06_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_6  | AARP |
      
      @planDetailsBenefitsAARP07_NextYear
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_7  | AARP |
      
      @planDetailsBenefitsAARP08_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_8  | AARP |
      
      @planDetailsBenefitsAARP09_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_9  | AARP |
      
      @planDetailsBenefitsAARP10_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_10  | AARP |
      
      @planDetailsBenefitsAARP11_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_11 | AARP |
      
      @planDetailsBenefitsAARP12_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_12  | AARP |
      
      @planDetailsBenefitsAARP13_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_13  | AARP |
      
       @planDetailsBenefitsAARP14_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_14  | AARP |
      
      @planDetailsBenefitsAARP15_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_15  | AARP |
      
      @planDetailsBenefitsAARP16_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_16  | AARP |
      
       @planDetailsBenefitsAARP17_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_17  | AARP |

      
 	  @planDetailsBenefitsPDPAARP01_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | SheetPDP2021_1  | AARP |
      
       @planDetailsBenefitsPDPAARP02_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | SheetPDP2021_2  | AARP | 
      
            
# 2021 UHC  
      
      @planDetailsBenefitsUHC01_NextYear  
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_1  | UHC |
      
      @planDetailsBenefitsUHC02_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_2  | UHC |
      
      @planDetailsBenefitsUHC03_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_3  | UHC |
      
      @planDetailsBenefitsUHC04_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_4  | UHC |
      
      @planDetailsBenefitsUHC05_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_5  | UHC |
      
      @planDetailsBenefitsUHC06_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_6  | UHC |
      
      @planDetailsBenefitsUHC07_NextYear
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_7  | UHC |
      
      @planDetailsBenefitsUHC08_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_8  | UHC |
      
      @planDetailsBenefitsUHC09_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_9  | UHC |
      
      @planDetailsBenefitsUHC10_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_10  | UHC |
      
      @planDetailsBenefitsUHC11_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_11 | UHC |
      
      @planDetailsBenefitsUHC12_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_12  | UHC |
      
      @planDetailsBenefitsUHC13_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_13  | UHC |
      
       @planDetailsBenefitsUHC14_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_14  | UHC |
      
      @planDetailsBenefitsUHC15_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_15  | UHC |
      
      @planDetailsBenefitsUHC16_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_16  | UHC |
      
       @planDetailsBenefitsUHC17_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2021_17  | UHC |
      
 	  @planDetailsBenefitsPDPUHC01_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | SheetPDP2021_1  | UHC |
      
       @planDetailsBenefitsPDPUHC02_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | SheetPDP2021_2  | UHC |   