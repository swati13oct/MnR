@planCompare_ExcelValidation
Feature: ACQ-Plan benefits validation

  @2022_AARP @current_year
  Scenario Outline: 2022 AARP Plan Compare Benefits Validation - Sheet : <workSheet>
    Given the user navigates to plan compare page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | Plan Compare Benefits_Data |
      | WorkSheetName | <workSheet>                |
      | Site          | AARP                       |

    @planCompareBenefitsAARP01 @planCompareMA
    Examples: 
      | workSheet   |
      | Sheet2022_1 |

    @planCompareBenefitsAARP02 @planCompareMA
    Examples: 
      | workSheet   |
      | Sheet2022_2 |

    @planCompareBenefitsAARP032 @planCompareMA
    Examples: 
      | workSheet   |
      | Sheet2022_3 |

    @planCompareBenefitsAARP04 @planCompareMA
    Examples: 
      | workSheet   |
      | Sheet2022_4 |

    @planCompareBenefitsAARP05 @planCompareMA
    Examples: 
      | workSheet   |
      | Sheet2022_5 |

    @planCompareBenefitsAARP06 @planCompareMA
    Examples: 
      | workSheet   |
      | Sheet2022_6 |

    @planCompareBenefitsAARP07 @planCompareMA
    Examples: 
      | workSheet   |
      | Sheet2022_7 |

    @planCompareBenefitsAARP08 @planCompareMA
    Examples: 
      | workSheet   |
      | Sheet2022_8 |

    @planCompareBenefitsAARP09 @planCompareMA
    Examples: 
      | workSheet   |
      | Sheet2022_9 |

    @planCompareBenefitsAARP10 @planCompareMA
    Examples: 
      | workSheet    |
      | Sheet2022_10 |

    @planCompareBenefitsAARP11 @planCompareMA
    Examples: 
      | workSheet    |
      | Sheet2022_11 |

    @planCompareBenefitsAARP12 @planCompareMA
    Examples: 
      | workSheet    |
      | Sheet2022_12 |

    @planCompareBenefitsAARP13 @planCompareMA
    Examples: 
      | workSheet    |
      | Sheet2022_13 |

    @planCompareBenefitsAARP13 @planCompareMA
    Examples: 
      | workSheet    |
      | Sheet2022_14 |

    @planCompareBenefitsAARP13 @planCompareMA
    Examples: 
      | workSheet    |
      | Sheet2022_15 |

    @planCompareBenefitsAARP13 @planCompareMA
    Examples: 
      | workSheet    |
      | Sheet2022_16 |

    @planCompareBenefitsAARP13 @planCompareMA
    Examples: 
      | workSheet    |
      | Sheet2022_17 |

    @planCompareBenefitsPDPAARP01
    Examples: 
      | workSheet      |
      | PDPSheet2022_1 |

    @planCompareBenefitsPDPAARP02
    Examples: 
      | workSheet      |
      | PDPSheet2022_2 |

    @planCompareBenefitsPDPAARP03
    Examples: 
      | workSheet      |
      | PDPSheet2022_3 |

  @2022_UHC @current_year
  Scenario Outline: 2022 UHC Plan Compare Benefits Validation - Sheet : <workSheet>
    Given the user navigates to plan compare page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | Plan Compare Benefits_Data |
      | WorkSheetName | <workSheet>                |
      | Site          | UHC                        |

    @planCompareBenefitsUHC01
    Examples: 
      | workSheet   |
      | Sheet2022_1 |

    @planCompareBenefitsUHC02
    Examples: 
      | workSheet   |
      | Sheet2022_2 |

    @planCompareBenefitsUHC03
    Examples: 
      | workSheet   |
      | Sheet2022_3 |

    @planCompareBenefitsUHC04
    Examples: 
      | workSheet   |
      | Sheet2022_4 |

    @planCompareBenefitsUHC05
    Examples: 
      | workSheet   |
      | Sheet2022_5 |

    @planCompareBenefitsUHC06
    Examples: 
      | workSheet   |
      | Sheet2022_6 |

    @planCompareBenefitsUHC07
    Examples: 
      | workSheet   |
      | Sheet2022_7 |

    @planCompareBenefitsUHC08
    Examples: 
      | workSheet   |
      | Sheet2022_8 |

    @planCompareBenefitsUHC09
    Examples: 
      | workSheet   |
      | Sheet2022_9 |

    @planCompareBenefitsUHC10
    Examples: 
      | workSheet    |
      | Sheet2022_10 |

    @planCompareBenefitsUHC11
    Examples: 
      | workSheet    |
      | Sheet2022_11 |

    @planCompareBenefitsUHC12
    Examples: 
      | workSheet    |
      | Sheet2022_12 |

    @planCompareBenefitsUHC13
    Examples: 
      | workSheet    |
      | Sheet2022_13 |

    @planCompareBenefitsPDPUHC01
    Examples: 
      | workSheet      |
      | PDPSheet2022_1 |

    @planCompareBenefitsPDPUHC02
    Examples: 
      | workSheet      |
      | PDPSheet2022_2 |

    @planCompareBenefitsPDPUHC03
    Examples: 
      | workSheet      |
      | PDPSheet2022_3 |

  @2021_AARP @next_year @2021CompareAARP
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

    @planCompareBenefits_NextYearAARP14
    Examples: 
      | workSheet    |
      | Sheet2021_14 |

    @planCompareBenefits_NextYearAARP15
    Examples: 
      | workSheet    |
      | Sheet2021_15 |

    @planCompareBenefits_NextYearAARP16
    Examples: 
      | workSheet    |
      | Sheet2021_16 |

    @planCompareBenefits_NextYearAARP17
    Examples: 
      | workSheet    |
      | Sheet2021_17 |

    @planCompareBenefits_NextYearAARP18
    Examples: 
      | workSheet    |
      | Sheet2021_18 |

    @planCompareBenefits_NextYearAARP19
    Examples: 
      | workSheet    |
      | Sheet2021_19 |

    @planCompareBenefits_NextYearAARP20
    Examples: 
      | workSheet    |
      | Sheet2021_20 |

    @planCompareBenefits_NextYearAARP21
    Examples: 
      | workSheet    |
      | Sheet2021_21 |

    @planCompareBenefits_NextYearAARP22
    Examples: 
      | workSheet    |
      | Sheet2021_22 |

    @planCompareBenefits_NextYearAARP23
    Examples: 
      | workSheet    |
      | Sheet2021_23 |

    @planCompareBenefits_NextYearAARP24
    Examples: 
      | workSheet    |
      | Sheet2021_24 |

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

  @2021_AARP @current_year @2021CompareProd
  Scenario Outline: 2021 AARP Plan Compare Benefits Validation - Sheet : <workSheet>
    Given the user navigates to plan compare page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | Plan Compare Benefits_Data |
      | WorkSheetName | <workSheet>                |
      | Site          | AARP                       |

    @planCompareBenefits_NextYear_AARP_ProdCheckout_1
    Examples: 
      | workSheet                |
      | Sheet2021_ProdCheckout_1 |

    @planCompareBenefits_NextYear_AARP_ProdCheckout_2
    Examples: 
      | workSheet                |
      | Sheet2021_ProdCheckout_2 |

    @planCompareBenefits_NextYear_AARP_ProdCheckout_3
    Examples: 
      | workSheet                |
      | Sheet2021_ProdCheckout_3 |

    @planCompareBenefits_NextYear_AARP_ProdCheckout_4
    Examples: 
      | workSheet                |
      | Sheet2021_ProdCheckout_4 |

  @2021_UHC @next_year @2021CompareUHC
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

    @planCompareBenefits_NextYearUHC14
    Examples: 
      | workSheet    |
      | Sheet2021_14 |

    @planCompareBenefits_NextYearUHC15
    Examples: 
      | workSheet    |
      | Sheet2021_15 |

    @planCompareBenefits_NextYearUHC16
    Examples: 
      | workSheet    |
      | Sheet2021_16 |

    @planCompareBenefits_NextYearUHC17
    Examples: 
      | workSheet    |
      | Sheet2021_17 |

    @planCompareBenefits_NextYearUHC18
    Examples: 
      | workSheet    |
      | Sheet2021_18 |

    @planCompareBenefits_NextYearUHC19
    Examples: 
      | workSheet    |
      | Sheet2021_19 |

    @planCompareBenefits_NextYearUHC20
    Examples: 
      | workSheet    |
      | Sheet2021_20 |

    @planCompareBenefits_NextYearUHC21
    Examples: 
      | workSheet    |
      | Sheet2021_21 |

    @planCompareBenefits_NextYearUHC22
    Examples: 
      | workSheet    |
      | Sheet2021_22 |

    @planCompareBenefits_NextYearUHC23
    Examples: 
      | workSheet    |
      | Sheet2021_23 |

    @planCompareBenefits_NextYearUHC24
    Examples: 
      | workSheet    |
      | Sheet2021_24 |

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

  @2021_AARP @current_year @2021CompareProd
  Scenario Outline: 2021 AARP Plan Compare Benefits Validation - Sheet : <workSheet>
    Given the user navigates to plan compare page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | Plan Compare Benefits_Data |
      | WorkSheetName | <workSheet>                |
      | Site          | AARP                       |

    @planCompareBenefits_NextYear_UHC_ProdCheckout_1
    Examples: 
      | workSheet                |
      | Sheet2021_ProdCheckout_1 |

    @planCompareBenefits_NextYear_UHC_ProdCheckout_2
    Examples: 
      | workSheet                |
      | Sheet2021_ProdCheckout_2 |

    @planCompareBenefits_NextYear_UHC_ProdCheckout_3
    Examples: 
      | workSheet                |
      | Sheet2021_ProdCheckout_3 |

    @planCompareBenefits_NextYear_UHC_ProdCheckout_4
    Examples: 
      | workSheet                |
      | Sheet2021_ProdCheckout_4 |
