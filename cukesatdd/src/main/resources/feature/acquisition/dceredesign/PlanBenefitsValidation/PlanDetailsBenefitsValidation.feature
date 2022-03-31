@dceUlayer
Feature: ACQ-Plan benefits validation

  @PlanDetails_ExcelValidation @2022DCEPlanDetialsAARP
  Scenario Outline: Verify plan benefits on the Plan Details Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to DCE plan details and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    @DCE_MAPD_SNP_Sheet_1 @DCE_MAPD_SNP
    Examples: 
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_1 | AARP |

    @DCE_MAPD_SNP_Sheet_2 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_2 | AARP |

    @DCE_MAPD_SNP_Sheet_3 @DCE_MAPD_SNP
    Examples: 
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_3 | AARP |

    @DCE_MAPD_SNP_Sheet_4 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_4 | AARP |

    @DCE_MAPD_SNP_Sheet_5 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_5 | AARP |

    @DCE_MAPD_SNP_Sheet_6 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_6 | AARP |

    @DCE_MAPD_SNP_Sheet_7 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_7 | AARP |

    @DCE_MAPD_SNP_Sheet_8 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_8 | AARP |

    @DCE_MAPD_SNP_Sheet_9 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_9 | AARP |

    @DCE_MAPD_SNP_Sheet_10 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_10 | AARP |

    @DCE_MAPD_SNP_Sheet_11 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_11 | AARP |

    @DCE_MAPD_SNP_Sheet_12 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_12 | AARP |

    @DCE_MAPD_SNP_Sheet_13 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_13 | AARP |

    @DCE_MAPD_SNP_Sheet_14 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_14 | AARP |

    @DCE_MAPD_SNP_Sheet_15 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_15 | AARP |

    @DCE_MAPD_SNP_Sheet_16 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_16 | AARP |

    @DCE_MAPD_SNP_Sheet_17 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_17 | AARP |

    @DCE_MAPD_SNP_Sheet_18 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_18 | AARP |

    @DCE_MAPD_SNP_Sheet_19 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_19 | AARP |

    @DCE_MAPD_SNP_Sheet_20 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_20 | AARP |

    @DCE_MAPD_SNP_Sheet_21 @DCE_MAPD_SNP
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_SNP_2022 | MAPD_SNP_DCE_2022_21 | AARP |

    @DCE_MAPD_Preferred_Sheet_1 @DCE_MAPD_Preferred
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_Preferred_2022 | MAPD_Preferred_Sheet_1 | AARP |

    @DCE_MAPD_Preferred_Sheet_2 @DCE_MAPD_Preferred
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_Preferred_2022 | MAPD_Preferred_Sheet_2 | AARP |

    @DCE_MAPD_Preferred_Sheet_3 @DCE_MAPD_Preferred
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_Preferred_2022 | MAPD_Preferred_Sheet_3 | AARP |

    @DCE_MAPD_Preferred_Sheet_4 @DCE_MAPD_Preferred
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_MAPD_Preferred_2022 | MAPD_Preferred_Sheet_4 | AARP |

    @DCE_PDP_Preferred_Sheet_1 @DCE_PDP_Preferred
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_PDP_Preferred_2022 | PDP_Preferred_Sheet_1 | AARP |

    @DCE_PDP_Preferred_Sheet_2 @DCE_PDP_Preferred
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_PDP_Preferred_2022 | PDP_Preferred_Sheet_2 | AARP |

    @DCE_PDP_Preferred_Sheet_3 @DCE_PDP_Preferred
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_PDP_Preferred_2022 | PDP_Preferred_Sheet_3 | AARP |

    @DCE_PDP_Preferred_Sheet_4 @DCE_PDP_Preferred
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_PDP_Preferred_2022 | PDP_Preferred_Sheet_4 | AARP |

    @DCE_PDP_Preferred_Sheet_5 @DCE_PDP_Preferred
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_PDP_Preferred_2022 | PDP_Preferred_Sheet_5 | AARP |

    @DCE_PDP_Preferred_Sheet_6 @DCE_PDP_Preferred
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_PDP_Preferred_2022 | PDP_Preferred_Sheet_6 | AARP |

    @DCE_PDP_Preferred_Sheet_7 @DCE_PDP_Preferred
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_PDP_Preferred_2022 | PDP_Preferred_Sheet_7 | AARP |

    @DCE_PDP_Preferred_Sheet_8 @DCE_PDP_Preferred
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_PDP_Preferred_2022 | PDP_Preferred_Sheet_8 | AARP |

    @DCE_PDP_Preferred_Sheet_9 @DCE_PDP_Preferred
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_PDP_Preferred_2022 | PDP_Preferred_Sheet_9 | AARP |

    @DCE_PDP_Preferred_Sheet_10 @DCE_PDP_Preferred
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_PDP_Preferred_2022 | PDP_Preferred_Sheet_10 | AARP |

    @DCE_LIS_Buydow_Sheet_1 @DCE_LIS_Buydow
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_LIS_Buydown_2022 | LIS_Buydown_Sheet_1 | AARP |

    @DCE_LIS_Buydow_Sheet_2 @DCE_LIS_Buydow
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_LIS_Buydown_2022 | LIS_Buydown_Sheet_2 | AARP |

    @DCE_LIS_Buydow_Sheet_3 @DCE_LIS_Buydow
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_LIS_Buydown_2022 | LIS_Buydown_Sheet_3 | AARP |

    @DCE_LIS_Buydow_Sheet_4 @DCE_LIS_Buydow
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_LIS_Buydown_2022 | LIS_Buydown_Sheet_4 | AARP |

    @DCE_LIS_Buydow_Sheet_5 @DCE_LIS_Buydow
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_LIS_Buydown_2022 | LIS_Buydown_Sheet_5 | AARP |

    @DCE_LIS_Buydow_Sheet_6 @DCE_LIS_Buydow
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_LIS_Buydown_2022 | LIS_Buydown_Sheet_6 | AARP |

    @DCE_LIS_Buydow_Sheet_7 @DCE_LIS_Buydow
    Examples:
      | excelPath                       | workSheet   | site |
      | DCE_MBD_LIS_Buydown_2022 | LIS_Buydown_Sheet_7 | AARP |



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


    @2022planDetailsBenefitsPDPUHC01
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Details Benefits_Data_2022 | PDPSheet2022_1 | UHC  |

    @2022planDetailsBenefitsPDPUHC02
    Examples: 
      | excelPath                       | workSheet      | site |
      | Plan Details Benefits_Data_2022 | PDPSheet2022_2 | UHC  |

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

    @planDetailsProd01
    Examples: 
      | excelPath                       | workSheet       | site |
      | Plan Details Benefits_Data_2021 | ProdSheet2021_1 | AARP |

    @planDetailsProd02
    Examples: 
      | excelPath                       | workSheet       | site |
      | Plan Details Benefits_Data_2021 | ProdSheet2021_2 | AARP |

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

    @planDetailsProd01
    Examples: 
      | excelPath                       | workSheet       | site |
      | Plan Details Benefits_Data_2021 | ProdSheet2021_1 | UHC  |

    @planDetailsProd02
    Examples: 
      | excelPath                       | workSheet       | site |
      | Plan Details Benefits_Data_2021 | ProdSheet2021_2 | UHC  |
