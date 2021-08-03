Feature: PRE Plans benefits validation

  @PREPlanBenefits_ExcelValidation
  Scenario Outline: Verify PRE plan benefits on the PRE Results Page for the plans provided in Excel : <excelPath> and Sheet : <workSheet> with the site : <site>
    Given the user navigates to PRE results page and compares plan benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS1_AARP
    Examples: 
      | excelPath                    | workSheet    | site |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS1 | AARP |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS2_AARP
    Examples: 
      | excelPath                    | workSheet    | site |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS2 | AARP |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS3_AARP
    Examples: 
      | excelPath                    | workSheet    | site |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS3 | AARP |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS4_AARP
    Examples: 
      | excelPath                    | workSheet    | site |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS4 | AARP |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS5_AARP
    Examples: 
      | excelPath                    | workSheet    | site |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS5 | AARP |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS6_AARP
    Examples: 
      | excelPath                    | workSheet    | site |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS6 | AARP |

    @PREPlanBenefitsAARP @PDP_PREBENEFITS_AARP
    Examples: 
      | excelPath                  | workSheet   | site |
      | 2021 PDP_ Plan details_PRE | PREBENEFITS | AARP |

    @PREPlanBenefitsAARP_UAT
    Examples: 
      | excelPath                    | workSheet       | site |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS_UAT | AARP |
      | 2021 PDP_ Plan details_PRE   | PREBENEFITS_UAT | AARP |

    @PREPlanBenefitsAARP_TEMP @MA_SNP_PREBENEFITS_Temp_AARP
    Examples: 
      | excelPath                    | workSheet        | site |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS_Temp | AARP |

    @PREPlanBenefitsAARP_TEMP @PDP_PREBENEFITS_Temp_AARP
    Examples: 
      | excelPath                  | workSheet        | site |
      | 2021 PDP_ Plan details_PRE | PREBENEFITS_Temp | AARP |
