@vppUlayer
Feature: ACQ-Plan benefits validation

  @PlanDetails_ExcelValidation @2022PlanDetialsAARP
  Scenario Outline: Verify plan benefits on the Plan Details Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to plan details and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    @2022planDetailsBenefitsAARP01 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_1 | AARP |

    @2022planDetailsBenefitsAARP02 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_2 | AARP |

    @2022planDetailsBenefitsAARP03 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_3 | AARP |

    @2022planDetailsBenefitsAARP04 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_4 | AARP |

    @2022planDetailsBenefitsAARP05 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_5 | AARP |

    @2022planDetailsBenefitsAARP06 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_6 | AARP |

    @2022planDetailsBenefitsAARP07 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_7 | AARP |

    @2022planDetailsBenefitsAARP08 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_8 | AARP |

    @2022planDetailsBenefitsAARP09 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_9 | AARP |

    @2022planDetailsBenefitsAARP10 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_10 | AARP |

    @2022planDetailsBenefitsAARP11 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_11 | AARP |

    @2022planDetailsBenefitsAARP12 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_12 | AARP |

    @2022planDetailsBenefitsAARP13 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_13 | AARP |

    @2022planDetailsBenefitsAARP14 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_14 | AARP |

    @2022planDetailsBenefitsAARP15 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_15 | AARP |

    @2022planDetailsBenefitsAARP16 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_16 | AARP |

    @2022planDetailsBenefitsAARP17 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_17 | AARP |

    @2022planDetailsBenefitsAARP18 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_18 | AARP |

    @2022planDetailsBenefitsAARP19 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_19 | AARP |

    @2022planDetailsBenefitsPDPAARP01
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Details Benefits_Data_2022 | PDPSheet2022_1 | AARP |

    @2022planDetailsBenefitsPDPAARP02
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Details Benefits_Data_2022 | PDPSheet2022_2 | AARP |
      
      @planDetailsProd01
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | ProdSheet2022_1 | AARP |

     @planDetailsProd02
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | ProdSheet2022_2 | AARP |

  @PlanDetails_ExcelValidation @2022PlanDetialsUHC
  Scenario Outline: Verify plan benefits on the Plan Details Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to plan details and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    # Below are examples for UHC plan details benefits
    @2022planDetailsBenefitsUHC01
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_1 | UHC  |

    @2022planDetailsBenefitsUHC02
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_2 | UHC  |

    @2022planDetailsBenefitsUHC03
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_3 | UHC  |

    @2022planDetailsBenefitsUHC04
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_4 | UHC  |

    @2022planDetailsBenefitsUHC05
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_5 | UHC  |

    @2022planDetailsBenefitsUHC06
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_6 | UHC  |

    @2022planDetailsBenefitsUHC07
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_7 | UHC  |

    @2022planDetailsBenefitsUHC08
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_8 | UHC  |

    @2022planDetailsBenefitsUHC09
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_9 | UHC  |

    @2022planDetailsBenefitsUHC10
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_10 | UHC  |

    @planDetailsBenefitsUHC11
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_11 | UHC  |

    @2022planDetailsBenefitsUHC12
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_12 | UHC  |

    @2022planDetailsBenefitsUHC13
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_13 | UHC  |

    @2022planDetailsBenefitsUHC14
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_14 | UHC  |

    @2022planDetailsBenefitsUHCP15
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_15 | UHC  |

    @2022planDetailsBenefitsUHC16 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_16 | UHC  |

    @2022planDetailsBenefitsUHC17 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_17 | UHC  |

    @2022planDetailsBenefitsUHC18 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_18 | UHC  |

    @2022planDetailsBenefitsUHC19 @planDetailsMA
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | Sheet2022_19 | UHC  |

    @2022planDetailsBenefitsPDPUHC01
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Details Benefits_Data_2022 | PDPSheet2022_1 | UHC  |

    @2022planDetailsBenefitsPDPUHC02
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Details Benefits_Data_2022 | PDPSheet2022_2 | UHC  |
      
       @2022planDetailsProd01
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | ProdSheet2022_1 | UHC |

     @2022planDetailsProd02
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2022 | ProdSheet2022_2 | UHC |

  # 2021 plans examples seen below
  @PlanDetails_ExcelValidation @2021PlanDetialsAARP
  Scenario Outline: Verify plan benefits on the Plan Details Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to plan details and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    @2021planDetailsBenefitsAARP01
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_1 | AARP |

    @2021planDetailsBenefitsAARP02
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_2 | AARP |

    @2021planDetailsBenefitsAARP03
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_3 | AARP |

    @2021planDetailsBenefitsAARP04
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_4 | AARP |

    @2021planDetailsBenefitsAARP05
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_5 | AARP |

    @2021planDetailsBenefitsAARP06
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_6 | AARP |

    @2021planDetailsBenefitsAARP07
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_7 | AARP |

    @2021planDetailsBenefitsAARP08
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_8 | AARP |

    @2021planDetailsBenefitsAARP09
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_9 | AARP |

    @2021planDetailsBenefitsAARP10
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_10 | AARP |

    @2021planDetailsBenefitsAARP11
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_11 | AARP |

    @2021planDetailsBenefitsAARP12
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_12 | AARP |

    @2021planDetailsBenefitsAARP13
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_13 | AARP |

    @2021planDetailsBenefitsAARP14
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_14 | AARP |

    @2021planDetailsBenefitsAARP15
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_15 | AARP |

    @2021planDetailsBenefitsAARP16
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_16 | AARP |

    @2021planDetailsBenefitsAARP17
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_17 | AARP |

    @2021planDetailsBenefitsPDPAARP01
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Details Benefits_Data_2021 | PDPSheet2021_1 | AARP |

    @2021planDetailsBenefitsPDPAARP02
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Details Benefits_Data_2021 | PDPSheet2021_2 | AARP |

  # 2021 UHC
  @PlanDetails_ExcelValidation @2021PlanDetialsUHC
  Scenario Outline: Verify plan benefits on the Plan Details Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to plan details and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    @2021planDetailsBenefitsUHC01
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_1 | UHC  |

    @2021planDetailsBenefitsUHC02
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_2 | UHC  |

    @2021planDetailsBenefitsUHC03
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_3 | UHC  |

    @2021planDetailsBenefitsUHC04
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_4 | UHC  |

    @2021planDetailsBenefitsUHC05
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_5 | UHC  |

    @2021planDetailsBenefitsUHC06
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_6 | UHC  |

    @2021planDetailsBenefitsUHC07
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_7 | UHC  |

    @2021planDetailsBenefitsUHC08
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_8 | UHC  |

    @2021planDetailsBenefitsUHC09
    Examples: 
      | excelPath                       | workSheet   | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_9 | UHC  |

    @2021planDetailsBenefitsUHC10
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_10 | UHC  |

    @2021planDetailsBenefitsUHC11
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_11 | UHC  |

    @2021planDetailsBenefitsUHC12
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_12 | UHC  |

    @2021planDetailsBenefitsUHC13
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_13 | UHC  |

    @2021planDetailsBenefitsUHC14
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_14 | UHC  |

    @2021planDetailsBenefitsUHC15
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_15 | UHC  |

    @2021planDetailsBenefitsUHC16
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_16 | UHC  |

    @2021planDetailsBenefitsUHC17
    Examples: 
      | excelPath                       | workSheet    | site |
      | Plan Details Benefits_Data_2021 | Sheet2021_17 | UHC  |

    @2021planDetailsBenefitsPDPUHC01
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Details Benefits_Data_2021 | PDPSheet2021_1 | UHC  |

    @2021planDetailsBenefitsPDPUHC02
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Details Benefits_Data_2021 | PDPSheet2021_2 | UHC  |
