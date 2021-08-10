@vppBenefits
Feature: ACQ-Plan benefits validation

  @planSummary_ExcelValidation @2022planSummaryAARP
  Scenario Outline: Verify plan benefits on the Plan Summary Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to plan summary page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    @planSummaryBenefitsAARP01
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_1 | AARP |

    @planSummaryBenefitsAARP02
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_2 | AARP |

    @planSummaryBenefitsAARP03
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_3 | AARP |

    @planSummaryBenefitsAARP04
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_4 | AARP |

    @planSummaryBenefitsAARP05
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_5 | AARP |

    @planSummaryBenefitsAARP06
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_6 | AARP |

    @planSummaryBenefitsAARP07
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_7 | AARP |

    @planSummaryBenefitsAARP08
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_8 | AARP |

    @planSummaryBenefitsAARP09
    Examples: 
      | excelPath                  | workSheet   | site |
      | Plan Summary Benefits_Data | Sheet2022_9 | AARP |

    @planSummaryBenefitsAARP10
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_10 | AARP |

    @planSummaryBenefitsAARP11
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_11 | AARP |

    @planSummaryBenefitsAARP12
    Examples: 
      | excelPath                  | workSheet    | site |
      | Plan Summary Benefits_Data | Sheet2022_12 | AARP |

    @planSummaryBenefitsPDPAARP01
    Examples: 
      | excelPath                  | workSheet      | site |
      | Plan Summary Benefits_Data | PDPSheet2022_1 | AARP |

    @planSummaryBenefitsPDPAARP02
    Examples: 
      | excelPath                  | workSheet      | site |
      | Plan Summary Benefits_Data | PDPSheet2022_2 | AARP |

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

    @planSummaryBenefitsPDPUHC01
    Examples: 
      | excelPath                  | workSheet      | site |
      | Plan Summary Benefits_Data | PDPSheet2022_1 | UHC  |

    @planSummaryBenefitsPDPUHC02
    Examples: 
      | excelPath                  | workSheet      | site |
      | Plan Summary Benefits_Data | PDPSheet2022_2 | UHC  |
