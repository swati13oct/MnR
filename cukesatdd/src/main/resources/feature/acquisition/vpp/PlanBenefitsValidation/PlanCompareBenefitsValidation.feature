@planCompare_ExcelValidation
Feature: ACQ-Plan benefits validation


  @2020_AARP @current_year
  Scenario Outline: 2020 AARP Plan Compare Benefits Validation - Sheet : <workSheet>
    Given the user navigates to plan compare page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | Plan Compare Benefits_Data |
      | WorkSheetName | <workSheet>                |
      | Site          | AARP                       |

  @planCompareBenefitsAARP01
    Examples:
      | workSheet   |
      | Sheet2020_1 |

  @planCompareBenefitsAARP02
    Examples:
      | workSheet   |
      | Sheet2020_2 |


  @planCompareBenefitsAARP03
    Examples:
      | workSheet   |
      | Sheet2020_3 |

  @planCompareBenefitsAARP04
    Examples:
      | workSheet   |
      | Sheet2020_4 |

  @planCompareBenefitsAARP05
    Examples:
      | workSheet   |
      | Sheet2020_5 |

  @planCompareBenefitsAARP06
    Examples:
      | workSheet   |
      | Sheet2020_6 |

  @planCompareBenefitsAARP07
    Examples:
      | workSheet   |
      | Sheet2020_7 |

  @planCompareBenefitsAARP08
    Examples:
      | workSheet   |
      | Sheet2020_8 |

  @planCompareBenefitsAARP09
    Examples:
      | workSheet   |
      | Sheet2020_9 |

  @planCompareBenefitsAARP10
    Examples:
      | workSheet    |
      | Sheet2020_10 |

  @planCompareBenefitsAARP11
    Examples:
      | workSheet    |
      | Sheet2020_11 |

  @planCompareBenefitsAARP12
    Examples:
      | workSheet    |
      | Sheet2020_12 |

  @planCompareBenefitsAARP13
    Examples:
      | workSheet    |
      | Sheet2020_13 |

  @planCompareBenefitsPDPAARP01
    Examples:
      | workSheet      |
      | PDPSheet2020_1 |

  @planCompareBenefitsPDPAARP02
    Examples:
      | workSheet      |
      | PDPSheet2020_2 |

  @planCompareBenefitsPDPAARP03
    Examples:
      | workSheet      |
      | PDPSheet2020_3 |

  @2020_UHC  @current_year
  Scenario Outline: 2020 UHC Plan Compare Benefits Validation - Sheet : <workSheet>
    Given the user navigates to plan compare page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | Plan Compare Benefits_Data |
      | WorkSheetName | <workSheet>                |
      | Site          | UHC                        |

  @planCompareBenefitsUHC01
    Examples:
      | workSheet   |
      | Sheet2020_1 |

  @planCompareBenefitsUHC02
    Examples:
      | workSheet   |
      | Sheet2020_2 |

  @planCompareBenefitsUHC03
    Examples:
      | workSheet   |
      | Sheet2020_3 |

  @planCompareBenefitsUHC04
    Examples:
      | workSheet   |
      | Sheet2020_4 |

  @planCompareBenefitsUHC05
    Examples:
      | workSheet   |
      | Sheet2020_5 |

  @planCompareBenefitsUHC06
    Examples:
      | workSheet   |
      | Sheet2020_6 |

  @planCompareBenefitsUHC07
    Examples:
      | workSheet   |
      | Sheet2020_7 |

  @planCompareBenefitsUHC08
    Examples:
      | workSheet   |
      | Sheet2020_8 |

  @planCompareBenefitsUHC09
    Examples:
      | workSheet   |
      | Sheet2020_9 |

  @planCompareBenefitsUHC10
    Examples:
      | workSheet    |
      | Sheet2020_10 |

  @planCompareBenefitsUHC11
    Examples:
      | workSheet    |
      | Sheet2020_11 |

  @planCompareBenefitsUHC12
    Examples:
      | workSheet    |
      | Sheet2020_12 |

  @planCompareBenefitsUHC13
    Examples:
      | workSheet    |
      | Sheet2020_13 |

  @planCompareBenefitsPDPUHC01
    Examples:
      | workSheet      |
      | PDPSheet2020_1 |

  @planCompareBenefitsPDPUHC02
    Examples:
      | workSheet      |
      | PDPSheet2020_2 |

  @planCompareBenefitsPDPUHC03
    Examples:
      | workSheet      |
      | PDPSheet2020_3 |

  @2021_AARP  @next_year
  Scenario Outline: 2021 AARP Plan Compare Benefits Validation - Sheet : <workSheet>
    Given the user navigates to plan compare page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | Plan Compare Benefits_Data |
      | WorkSheetName | <workSheet>                |
      | Site          | AARP                       |

  @planCompareBenefits_NextYearAARP01
    Examples:
      | workSheet   |
      | Sheet2021_1 |

  @planCompareBenefits_NextYearAARP02
    Examples:
      | workSheet   |
      | Sheet2021_2 |

  @planCompareBenefits_NextYearAARP03
    Examples:
      | workSheet   |
      | Sheet2021_3 |

  @planCompareBenefits_NextYearAARP04
    Examples:
      | workSheet   |
      | Sheet2021_4 |

  @planCompareBenefits_NextYearAARP05
    Examples:
      | workSheet   |
      | Sheet2021_5 |

  @planCompareBenefits_NextYearAARP06
    Examples:
      | workSheet   |
      | Sheet2021_6 |

  @planCompareBenefits_NextYearAARP07
    Examples:
      | workSheet   |
      | Sheet2021_7 |

  @planCompareBenefits_NextYearAARP08
    Examples:
      | workSheet   |
      | Sheet2021_8 |

  @planCompareBenefits_NextYearAARP09
    Examples:
      | workSheet   |
      | Sheet2021_9 |

  @planCompareBenefits_NextYearAARP10
    Examples:
      | workSheet    |
      | Sheet2021_10 |

  @planCompareBenefits_NextYearAARP11
    Examples:
      | workSheet    |
      | Sheet2021_11 |

  @planCompareBenefits_NextYearAARP12
    Examples:
      | workSheet    |
      | Sheet2021_12 |

  @planCompareBenefits_NextYearAARP13
    Examples:
      | workSheet    |
      | Sheet2021_13 |

  @planCompareBenefits_NextYearPDPAARP01
    Examples:
      | workSheet      |
      | PDPSheet2021_1 |

  @planCompareBenefits_NextYearPDPAARP02
    Examples:
      | workSheet      |
      | PDPSheet2021_2 |

  @planCompareBenefits_NextYearPDPAARP03
    Examples:
      | workSheet      |
      | PDPSheet2021_3 |

  @2021_UHC  @next_year
  Scenario Outline: 2021 UHC Plan Compare Benefits Validation - Sheet : <workSheet>
    Given the user navigates to plan compare page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | Plan Compare Benefits_Data |
      | WorkSheetName | <workSheet>                |
      | Site          | UHC                        |

  @planCompareBenefits_NextYearUHC01
    Examples:
      | workSheet   |
      | Sheet2021_1 |

  @planCompareBenefits_NextYearUHC02
    Examples:
      | workSheet   |
      | Sheet2021_2 |

  @planCompareBenefits_NextYearUHC03
    Examples:
      | workSheet   |
      | Sheet2021_3 |

  @planCompareBenefits_NextYearUHC04
    Examples:
      | workSheet   |
      | Sheet2021_4 |

  @planCompareBenefits_NextYearUHC05
    Examples:
      | workSheet   |
      | Sheet2021_5 |

  @planCompareBenefits_NextYearUHC06
    Examples:
      | workSheet   |
      | Sheet2021_6 |

  @planCompareBenefits_NextYearUHC07
    Examples:
      | workSheet   |
      | Sheet2021_7 |

  @planCompareBenefits_NextYearUHC08
    Examples:
      | workSheet   |
      | Sheet2021_8 |

  @planCompareBenefits_NextYearUHC09
    Examples:
      | workSheet   |
      | Sheet2021_9 |

  @planCompareBenefits_NextYearUHC10
    Examples:
      | workSheet    |
      | Sheet2021_10 |

  @planCompareBenefits_NextYearUHC11
    Examples:
      | workSheet    |
      | Sheet2021_11 |

  @planCompareBenefits_NextYearUHC12
    Examples:
      | workSheet    |
      | Sheet2021_12 |

  @planCompareBenefits_NextYearUHC13
    Examples:
      | workSheet    |
      | Sheet2021_13 |

  @planCompareBenefits_NextYearPDPUHC01
    Examples:
      | workSheet      |
      | PDPSheet2021_1 |

  @planCompareBenefits_NextYearPDPUHC02
    Examples:
      | workSheet      |
      | PDPSheet2021_2 |

  @planCompareBenefits_NextYearPDPUHC03
    Examples:
      | workSheet      |
      | PDPSheet2021_3 |
