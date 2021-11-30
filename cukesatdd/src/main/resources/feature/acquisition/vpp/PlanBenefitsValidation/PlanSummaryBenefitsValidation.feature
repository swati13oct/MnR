@vppBenefits
Feature: ACQ-Plan benefits validation

  @planSummary_ExcelValidation @2022planSummaryAARP @2022planSummaryBenefits
  Scenario Outline: Verify plan benefits on the Plan Summary Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to plan summary page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    @2022planSummaryBenefitsAARP01 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_1 | AARP |

    @2022planSummaryBenefitsAARP02 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_2 | AARP |

    @2022planSummaryBenefitsAARP03 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_3 | AARP |

    @2022planSummaryBenefitsAARP04 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_4 | AARP |

    @2022planSummaryBenefitsAARP05 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_5 | AARP |

    @2022planSummaryBenefitsAARP06 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_6 | AARP |

    @2022planSummaryBenefitsAARP07 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_7 | AARP |

    @2022planSummaryBenefitsAARP08 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_8 | AARP |

    @2022planSummaryBenefitsAARP09 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_9 | AARP |

    @2022planSummaryBenefitsAARP10 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_10 | AARP |

    @2022planSummaryBenefitsAARP11 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_11 | AARP |

    @2022planSummaryBenefitsAARP12 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_12 | AARP |

    @2022planSummaryBenefitsAARP13 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_13 | AARP |

    @2022planSummaryBenefitsAARP14 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_14 | AARP |

    @2022planSummaryBenefitsAARP15 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_15 | AARP |

    @2022planSummaryBenefitsAARP16 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_16 | AARP |

    @2022planSummaryBenefitsAARP17 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_17 | AARP |

    @2022planSummaryBenefitsAARP18 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_18 | AARP |

    @2022planSummaryBenefitsAARP19 @2022planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_19 | AARP |

    @2022planSummaryBenefitsPDPAARP01
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Summary Benefits_Data_2022 | PDPSheet2022_1 | AARP |

    @2022planSummaryBenefitsPDPAARP02
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Summary Benefits_Data_2022 | PDPSheet2022_2 | AARP |

    @2022planSummaryBenefitsPDPAARP03
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Summary Benefits_Data_2022 | PDPSheet2022_3 | AARP |
      
     @2022planSummaryBenefitsProd_1
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | ProdSheet2022_1 | AARP |

   @2022planSummaryBenefitsProd_2
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | ProdSheet2022_2 | AARP |

  # Below are examples for UHC plan Summary benefits
  @planSummary_ExcelValidation @2022planSummaryBenefitsUHC @2022planSummaryBenefits
  Scenario Outline: Verify plan benefits on the Plan Summary Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to plan summary page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    @2022planSummaryBenefitsUHC01 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_1 | UHC  |

    @2022planSummaryBenefitsUHC02 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_2 | UHC  |

    @2022planSummaryBenefitsUHC03 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_3 | UHC  |

    @2022planSummaryBenefitsUHC04 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_4 | UHC  |

    @2022planSummaryBenefitsUHC05 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_5 | UHC  |

    @2022planSummaryBenefitsUHC06 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_6 | UHC  |

    @2022planSummaryBenefitsUHC07 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_7 | UHC  |

    @2022planSummaryBenefitsUHC08 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_8 | UHC  |

    @2022planSummaryBenefitsUHC09 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_9 | UHC  |

    @2022planSummaryBenefitsUHC10 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_10 | UHC  |

    @2022planSummaryBenefitsUHC11 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_11 | UHC  |

    @2022planSummaryBenefitsUHC12 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_12 | UHC  |

    @2022planSummaryBenefitsUHC13 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_13 | UHC  |

    @2022planSummaryBenefitsUHC14 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_14 | UHC  |

    @2022planSummaryBenefitsUHC15 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_15 | UHC  |

    @2022planSummaryBenefitsUHC16 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_16 | UHC  |

    @2022planSummaryBenefitsUHC17 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_17 | UHC  |

    @2022planSummaryBenefitsUHC18 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_18 | UHC  |

    @2022planSummaryBenefitsUHC19 @2022planSummaryBenefitsUHCMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | Sheet2022_19 | UHC  |

    @2022planSummaryBenefitsPDPUHC01 @2022planSummaryBenefitsUHCPDP
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Summary Benefits_Data_2022 | PDPSheet2022_1 | UHC  |

    @2022planSummaryBenefitsPDPUHC02 @2022planSummaryBenefitsUHCPDP
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Summary Benefits_Data_2022 | PDPSheet2022_2 | UHC  |

    @2022planSummaryBenefitsPDPUHC03 @2022planSummaryBenefitsUHCPDP
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Summary Benefits_Data_2022 | PDPSheet2022_3 | UHC  |

 	@2022planSummaryBenefitsProd01
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | ProdSheet2022_1 | UHC |

   @2022planSummaryBenefitsProd02
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2022 | ProdSheet2022_2 | UHC |
  #2021 Plans
  @planSummary_ExcelValidation @2021planSummaryAARP
  Scenario Outline: Verify plan benefits on the Plan Summary Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to plan summary page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    @2021planSummaryBenefitsAARP01
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_1 | AARP |

    @2021planSummaryBenefitsAARP02
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_2 | AARP |

    @2021planSummaryBenefitsAARP03
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_3 | AARP |

    @2021planSummaryBenefitsAARP04
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_4 | AARP |

    @2021planSummaryBenefitsAARP05
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_5 | AARP |

    @2021planSummaryBenefitsAARP06
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_6 | AARP |

    @2021planSummaryBenefitsAARP07
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_7 | AARP |

    @2021planSummaryBenefitsAARP08
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_8 | AARP |

    @2021planSummaryBenefitsAARP09
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_9 | AARP |

    @2021planSummaryBenefitsAARP10
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_10 | AARP |

    @2021planSummaryBenefitsAARP11
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_11 | AARP |

    @2021planSummaryBenefitsAARP12
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_12 | AARP |

    @2021planSummaryBenefitsAARP13
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_13 | AARP |

    @2021planSummaryBenefitsAARP14
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_14 | AARP |

    @2021planSummaryBenefitsPDPAARP01
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Summary Benefits_Data_2021 | PDPSheet2021_1 | AARP |

    @2021planSummaryBenefitsPDPAARP02
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Summary Benefits_Data_2021 | PDPSheet2021_2 | AARP |

  # UHC
  @planSummary_ExcelValidation @2021planSummaryUHC
  Scenario Outline: Verify plan benefits on the Plan Summary Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to plan summary page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    @2021planSummaryBenefitsUHC01
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_1 | UHC  |

    @2021planSummaryBenefitsUHC02
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_2 | UHC  |

    @2021planSummaryBenefitsUHC03
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_3 | UHC  |

    @2021planSummaryBenefitsUHC04
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_4 | UHC  |

    @2021planSummaryBenefitsUHC05
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_5 | UHC  |

    @2021planSummaryBenefitsUHC06
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_6 | UHC  |

    @planSummaryBenefitsUHC07
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_7 | UHC  |

    @2021planSummaryBenefitsUHC08
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_8 | UHC  |

    @2021planSummaryBenefitsUHC09
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_9 | UHC  |

    @2021planSummaryBenefitsUHC10
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_10 | UHC  |

    @2021planSummaryBenefitsUHC11
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_11 | UHC  |

    @2021planSummaryBenefitsUHC12
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_12 | UHC  |

    @2021planSummaryBenefitsUHC13
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_13 | UHC  |

    @2021planSummaryBenefitsUHC14
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Summary Benefits_Data_2021 | Sheet2021_14 | UHC  |

    @2021planSummaryBenefitsPDPUHC01
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Summary Benefits_Data_2021 | PDPSheet2021_1 | UHC  |

    @2021planSummaryBenefitsPDPUHC02
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Summary Benefits_Data_2021 | PDPSheet2021_2 | UHC  |
