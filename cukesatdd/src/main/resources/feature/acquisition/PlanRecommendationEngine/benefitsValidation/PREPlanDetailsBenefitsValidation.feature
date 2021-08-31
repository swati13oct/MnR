Feature: PRE Plans benefits validation

  @PREPlanBenefits_ExcelValidation
  Scenario Outline: Verify PRE plan benefits on the PRE Results Page for the plans provided in Excel : <excelPath> and Sheet : <workSheet> with the site : <site>
    Given the user navigates to PRE results page and compares plan benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |
      | AEP           | <AEP>       |
      | USER          | <USER>      |
      | YEAR          | <YEAR>      |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS_AARP @MA_SNP_PREBENEFITS1_AARP
    Examples: 
      | excelPath                    | workSheet    | site | AEP | USER   | YEAR |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS1 | AARP | Yes | OCT-15 | 2021 |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS_AARP @MA_SNP_PREBENEFITS2_AARP
    Examples: 
      | excelPath                    | workSheet    | site | AEP | USER   | YEAR |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS2 | AARP | Yes | OCT-15 | 2021 |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS_AARP @MA_SNP_PREBENEFITS3_AARP
    Examples: 
      | excelPath                    | workSheet    | site | AEP | USER   | YEAR |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS3 | AARP | Yes | OCT-15 | 2021 |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS_AARP @MA_SNP_PREBENEFITS4_AARP
    Examples: 
      | excelPath                    | workSheet    | site | AEP | USER   | YEAR |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS4 | AARP | Yes | OCT-15 | 2021 |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS_AARP @MA_SNP_PREBENEFITS5_AARP
    Examples: 
      | excelPath                    | workSheet    | site | AEP | USER   | YEAR |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS5 | AARP | Yes | OCT-15 | 2021 |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS_AARP @MA_SNP_PREBENEFITS6_AARP
    Examples: 
      | excelPath                    | workSheet    | site | AEP | USER   | YEAR |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS6 | AARP | Yes | OCT-15 | 2021 |

    @PREPlanBenefitsAARP @PDP_PREBENEFITS_AARP
    Examples: 
      | excelPath                 | workSheet   | site | AEP | USER   | YEAR |
      | 2021 PDP_Plan details_PRE | PREBENEFITS | AARP | Yes | OCT-15 | 2021 |

    @PREPlanBenefitsAARP @MS_PREBENEFITS_AARP
    Examples: 
      | excelPath                | workSheet   | site | AEP | USER   | YEAR |
      | 2021 MS_Plan Details_PRE | PREBENEFITS | AARP | Yes | OCT-15 | 2021 |

    @PREPlanBenefitsAARP_UAT @MA_SNP_PDP_PREBENEFITS_AARP_UAT
    Examples: 
      | excelPath                    | workSheet       | site | AEP | USER   | YEAR |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS_UAT | AARP | Yes | OCT-15 | 2021 |
      | 2021 PDP_Plan details_PRE    | PREBENEFITS_UAT | AARP | Yes | OCT-15 | 2021 |

    @PREPlanBenefitsAARP_UAT @MS_PREBENEFITS_AARP_UAT
    Examples: 
      | excelPath                | workSheet       | site | AEP | USER   | YEAR |
      | 2021 MS_Plan Details_PRE | PREBENEFITS_UAT | AARP | Yes | OCT-15 | 2021 |

    @PREPlanBenefitsAARP_TEMP @MA_SNP_PREBENEFITS_AARP_Temp
    Examples: 
      | excelPath                    | workSheet        | site | AEP | USER   | YEAR |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS_Temp | AARP | Yes | OCT-15 | 2021 |

    @PREPlanBenefitsAARP_TEMP @PDP_PREBENEFITS_AARP_Temp
    Examples: 
      | excelPath                 | workSheet        | site | AEP | USER   | YEAR |
      | 2021 PDP_Plan details_PRE | PREBENEFITS_Temp | AARP | Yes | OCT-15 | 2021 |

    @PREPlanBenefitsAARP_Temp @MS_PREBENEFITS_AARP_Temp
    Examples: 
      | excelPath                | workSheet        | site | AEP | USER   | YEAR |
      | 2021 MS_Plan Details_PRE | PREBENEFITS_Temp | AARP | Yes | OCT-15 | 2021 |
