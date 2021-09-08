@vppBenefits
Feature: ACQ-Plan benefits validation

  @planSummary_ExcelValidation @2022planSummaryAARP
  Scenario Outline: Verify plan benefits on the Plan Summary Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to plan summary page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    @planSummaryBenefitsAARP01 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_1 | AARP |

    @planSummaryBenefitsAARP02 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_2 | AARP |

    @planSummaryBenefitsAARP03 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_3 | AARP |

    @planSummaryBenefitsAARP04 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_4 | AARP |

    @planSummaryBenefitsAARP05 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_5 | AARP |

    @planSummaryBenefitsAARP06 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_6 | AARP |

    @planSummaryBenefitsAARP07 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_7 | AARP |

    @planSummaryBenefitsAARP08 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_8 | AARP |

    @planSummaryBenefitsAARP09 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_9 | AARP |

    @planSummaryBenefitsAARP10 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_10 | AARP |

    @planSummaryBenefitsAARP11 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_11 | AARP |

    @planSummaryBenefitsAARP12 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_12 | AARP |

    @planSummaryBenefitsAARP13 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_13 | AARP |

    @planSummaryBenefitsAARP14 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_14 | AARP |

    @planSummaryBenefitsAARP15 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_15 | AARP |

    @planSummaryBenefitsAARP16 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_16 | AARP |

    @planSummaryBenefitsAARP17 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_17 | AARP |

    @planSummaryBenefitsAARP18 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_18 | AARP |

    @planSummaryBenefitsAARP19 @planSummaryBenefitsAARPMA
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_19 | AARP |

    @planSummaryBenefitsPDPAARP01
    Examples: 
      | excelPath                  | workSheet      | site |
      | Plan Summary Benefits_Data | PDPSheet2022_1 | AARP |

    @planSummaryBenefitsPDPAARP02
    Examples: 
      | excelPath                  | workSheet      | site |
      | Plan Summary Benefits_Data | PDPSheet2022_2 | AARP |

    @planSummaryBenefitsPDPAARP02
    Examples: 
      | excelPath                  | workSheet      | site |
      | Plan Summary Benefits_Data | PDPSheet2022_3 | AARP |

  # Below are examples for UHC plan Summary benefits
  @planSummary_ExcelValidation @2022planSummaryUHC
  Scenario Outline: Verify plan benefits on the Plan Summary Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to plan summary page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    @planSummaryBenefitsUHC01
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_1 | UHC  |

    @planSummaryBenefitsUHC02
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_2 | UHC  |

    @planSummaryBenefitsUHC03
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_3 | UHC  |

    @planSummaryBenefitsUHC04
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_4 | UHC  |

    @planSummaryBenefitsUHC05
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_5 | UHC  |

    @planSummaryBenefitsUHC06
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_6 | UHC  |

    @planSummaryBenefitsUHC07
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_7 | UHC  |

    @planSummaryBenefitsUHC08
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_8 | UHC  |

    @planSummaryBenefitsUHC09
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_9 | UHC  |

    @planSummaryBenefitsUHC10
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_10 | UHC  |

    @planSummaryBenefitsUHC11
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_11 | UHC  |

    @planSummaryBenefitsUHC12
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_12 | UHC  |

    @planSummaryBenefitsUHC13
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_13 | UHC  |

    @planSummaryBenefitsUHC14
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_14 | UHC  |

    @planSummaryBenefitsUHC15
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_15 | UHC  |

    @planSummaryBenefitsPDPUHC01
    Examples: 
      | excelPath                  | workSheet      | site |
      | Plan Summary Benefits_Data | PDPSheet2022_1 | UHC  |

    @planSummaryBenefitsPDPUHC02
    Examples: 
      | excelPath                  | workSheet      | site |
      | Plan Summary Benefits_Data | PDPSheet2022_2 | UHC  |
