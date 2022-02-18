@pharmacySearchBenefits
Feature: ACQ-Plan benefits validation

  @planSummary_ExcelValidation @2022planSummaryAARP @2022planSummaryBenefits
  Scenario Outline: Verify plan benefits on the Pharmacy Search Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user navigates to Pharmacy Search page and compares benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

  @2022PharmSearchAARPPDP_Sheet_1 @2022PharmSearchAARPPDP
    Examples:
      | excelPath               | workSheet       | site |
      | PharmacySearch_PDP_2022 | PDP_Preferred_1 | AARP |

  @2022PharmSearchAARPPDP_Sheet_2 @2022PharmSearchAARPPDP
    Examples:
      | excelPath               | workSheet       | site |
      | PharmacySearch_PDP_2022 | PDP_Preferred_2 | AARP |

  @2022PharmSearchAARPPDP_Sheet_3 @2022PharmSearchAARPPDP
    Examples:
      | excelPath               | workSheet       | site |
      | PharmacySearch_PDP_2022 | PDP_Preferred_3 | AARP |

  @2022PharmSearchAARPPDP_Sheet_4 @2022PharmSearchAARPPDP
    Examples:
      | excelPath               | workSheet       | site |
      | PharmacySearch_PDP_2022 | PDP_Preferred_4 | AARP |

  @2022PharmSearchAARPPDP_Sheet_5 @2022PharmSearchAARPPDP
    Examples:
      | excelPath               | workSheet       | site |
      | PharmacySearch_PDP_2022 | PDP_Preferred_5 | AARP |

  @2022PharmSearch_AARPPDP_SNP_NonPreferred @2022PharmSearchAARPPDP
    Examples:
      | excelPath               | workSheet            | site |
      | PharmacySearch_PDP_2022 | PDP_SNP_NonPreferred | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_1 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet           | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail1 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_2 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet           | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail2 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_3 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet           | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail3 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_4 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet           | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail4 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_5 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet           | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail5 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_6 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet           | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail6 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_7 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet           | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail7 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_8 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet           | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail8 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_9 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet           | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail9 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_10 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail10 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_11 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail11 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_12 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail12 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_13 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail13 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_14 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet           | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail4 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_15 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail15 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_16 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail16 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_17 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail17 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_18 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail18 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_19 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail19 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_20 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail20 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_21 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail21 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_22 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail22 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_23 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail23 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_24 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail24 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_25 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail25 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_26 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail26 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_27 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail27 | AARP |

  @2022PharmSearchAARPMAPD_PreferredMail_Sheet_28 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet            | site |
      | PharmacySearch_MAPD_2022 | MAPD_PreferredMail28 | AARP |

  @2022PharmSearchAARPMAPD_Walgreens_Sheet_1 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet       | site |
      | PharmacySearch_MAPD_2022 | MAPD_Walgreens1 | AARP |

  @2022PharmSearchAARPMAPD_Walgreens_Sheet_2 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet       | site |
      | PharmacySearch_MAPD_2022 | MAPD_Walgreens2 | AARP |

  @2022PharmSearchAARPMAPD_Walgreens_Sheet_3 @2022PharmSearchAARPMAPD
    Examples:
      | excelPath                | workSheet       | site |
      | PharmacySearch_MAPD_2022 | MAPD_Walgreens3 | AARP |

  @2022PharmSearchAARPSNP_PreferredMail_Sheet_1 @2022PharmSearchAARPSNP
    Examples:
      | excelPath               | workSheet          | site |
      | PharmacySearch_SNP_2022 | SNP_PreferredMail1 | AARP |

  @2022PharmSearchAARPSNP_PreferredMail_Sheet_2 @2022PharmSearchAARPSNP
    Examples:
      | excelPath               | workSheet          | site |
      | PharmacySearch_SNP_2022 | SNP_PreferredMail2 | AARP |

  @2022PharmSearchAARPSNP_PreferredMail_Sheet_3 @2022PharmSearchAARPSNP
    Examples:
      | excelPath               | workSheet          | site |
      | PharmacySearch_SNP_2022 | SNP_PreferredMail3 | AARP |

  @2022PharmSearchAARPSNP_LIS_Buydown_Sheet_1 @2022PharmSearchAARPSNP
    Examples:
      | excelPath               | workSheet    | site |
      | PharmacySearch_SNP_2022 | LIS_Buydown1 | AARP |

  @2022PharmSearchAARPSNP_LIS_Buydown_Sheet_2 @2022PharmSearchAARPSNP
    Examples:
      | excelPath               | workSheet    | site |
      | PharmacySearch_SNP_2022 | LIS_Buydown2 | AARP |

  @2022PharmSearchAARPSNP_LIS_Buydown_Sheet_3 @2022PharmSearchAARPSNP
    Examples:
      | excelPath               | workSheet    | site |
      | PharmacySearch_SNP_2022 | LIS_Buydown3 | AARP |

  @2022PharmSearchAARPSNP_LIS_Buydown_Sheet_4 @2022PharmSearchAARPSNP
    Examples:
      | excelPath               | workSheet    | site |
      | PharmacySearch_SNP_2022 | LIS_Buydown4 | AARP |

  @2022PharmSearchAARPSNP_LIS_Buydown_Sheet_5 @2022PharmSearchAARPSNP
    Examples:
      | excelPath               | workSheet    | site |
      | PharmacySearch_SNP_2022 | LIS_Buydown5 | AARP |

  @2022PharmSearchAARPSNP_LIS_Buydown_Sheet_6 @2022PharmSearchAARPSNP
    Examples:
      | excelPath               | workSheet    | site |
      | PharmacySearch_SNP_2022 | LIS_Buydown6 | AARP |

  @2022PharmSearchAARPSNP_LIS_Buydown_Sheet_7 @2022PharmSearchAARPSNP
    Examples:
      | excelPath               | workSheet    | site |
      | PharmacySearch_SNP_2022 | LIS_Buydown7 | AARP |

  @2022PharmSearchAARPSNP_LIS_NonBuydown_Sheet_1 @2022PharmSearchAARPSNP
    Examples:
      | excelPath               | workSheet       | site |
      | PharmacySearch_SNP_2022 | LIS_NonBuydown1 | AARP |

  @2022PharmSearchAARPSNP_LIS_NonBuydown_Sheet_2 @2022PharmSearchAARPSNP
    Examples:
      | excelPath               | workSheet       | site |
      | PharmacySearch_SNP_2022 | LIS_NonBuydown2 | AARP |

  @2022PharmSearchAARPSNP_LIS_NonBuydown_Sheet_3 @2022PharmSearchAARPSNP
    Examples:
      | excelPath               | workSheet       | site |
      | PharmacySearch_SNP_2022 | LIS_NonBuydown3 | AARP |

  @2022PharmSearchAARPSNP_LIS_NonBuydown_Sheet_4 @2022PharmSearchAARPSNP
    Examples:
      | excelPath               | workSheet       | site |
      | PharmacySearch_SNP_2022 | LIS_NonBuydown4 | AARP |

  @2022PharmSearchAARPSNP_LIS_NonBuydown_Sheet_5 @2022PharmSearchAARPSNP
    Examples:
      | excelPath               | workSheet       | site |
      | PharmacySearch_SNP_2022 | LIS_NonBuydown5 | AARP |

