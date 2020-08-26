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
      | Plan Details Benefits_Data | Sheet1  | AARP |
      
      @planDetailsBenefitsAARP02
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2  | AARP |
      
      @planDetailsBenefitsAARP03
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet3  | AARP |
      
      @planDetailsBenefitsAARP04
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet4  | AARP |
      
      @planDetailsBenefitsAARP05
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet5  | AARP |
      
      @planDetailsBenefitsAARP06
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet6  | AARP |
      
      @planDetailsBenefitsAARP07
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet7  | AARP |
      
      @planDetailsBenefitsAARP08
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet8  | AARP |
      
      @planDetailsBenefitsAARP09
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet9  | AARP |
      
      @planDetailsBenefitsAARP10
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet10  | AARP |
      
      @planDetailsBenefitsAARP11
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet11 | AARP |
      
      @planDetailsBenefitsAARP12
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet12  | AARP |
      
      @planDetailsBenefitsPDPAARP01
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | PDPSheet1  | AARP |
      
       @planDetailsBenefitsPDPAARP02
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | PDPSheet2  | AARP |
      

# Below are examples for UHC plan details benefits

      @planDetailsBenefitsUHC01
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet1  | UHC |
      
      @planDetailsBenefitsUHC02
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2  | UHC |
      
      @planDetailsBenefitsUHC03
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet3  | UHC |
      
      @planDetailsBenefitsUHC04
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet4  | UHC |
      
      @planDetailsBenefitsUHC05
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet5  | UHC |
      
      @planDetailsBenefitsUHC06
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet6  | UHC |
      
      @planDetailsBenefitsUHC07
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet7  | UHC |
      
      @planDetailsBenefitsUHC08
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet8  | UHC |
      
      @planDetailsBenefitsUHC09
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet9  | UHC |
      
      @planDetailsBenefitsUHC10
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet10  | UHC |
      
      @planDetailsBenefitsUHC11
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet11 | UHC |
      
      @planDetailsBenefitsUHC12
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet12  | UHC |
      
      @planDetailsBenefitsPDPUHC01
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | PDPSheet1  | UHC |
      
       @planDetailsBenefitsPDPUHC02
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | PDPSheet2  | UHC |
      
# 2021 plans examples seen below

		@planDetailsBenefitsAARP01_NextYear  
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet1_21  | AARP |
      
      @planDetailsBenefitsAARP02_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet2_21  | AARP |
      
      @planDetailsBenefitsAARP03_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet3_21  | AARP |
      
      @planDetailsBenefitsAARP04_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet4_21  | AARP |
      
      @planDetailsBenefitsAARP05_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet5_21  | AARP |
      
      @planDetailsBenefitsAARP06_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet6_21  | AARP |
      
      @planDetailsBenefitsAARP07_NextYear
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet7_21  | AARP |
      
      @planDetailsBenefitsAARP08_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet8_21  | AARP |
      
      @planDetailsBenefitsAARP09_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet9_21  | AARP |
      
      @planDetailsBenefitsAARP10_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet10_21  | AARP |
      
      @planDetailsBenefitsAARP11_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet11_21 | AARP |
      
      @planDetailsBenefitsAARP12_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet12_21  | AARP |
      
      @planDetailsBenefitsAARP13_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet13_21  | AARP |
      
       @planDetailsBenefitsAARP14_NextYear
      Examples: 
      | excelPath                | workSheet | site |
      | Plan Details Benefits_Data | Sheet14_21  | AARP |
      