Feature: PRE Plans benefits validation

  #AEP value should be Yes while using flagsmith and change the year accordingly ie future year
  #AEP value should be NO on non-AEP period i.e not using flagsmith or from OCT-01
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
      | excelPath                   | workSheet    | site | AEP | USER   | YEAR |
      | 2022_MA_SNP_PlanDetails_PRE | PREBENEFITS1 | AARP | No  | OCT-15 | 2022 |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS_AARP @MA_SNP_PREBENEFITS2_AARP
    Examples: 
      | excelPath                   | workSheet    | site | AEP | USER   | YEAR |
      | 2022_MA_SNP_PlanDetails_PRE | PREBENEFITS2 | AARP | No  | OCT-15 | 2022 |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS_AARP @MA_SNP_PREBENEFITS3_AARP
    Examples: 
      | excelPath                   | workSheet    | site | AEP | USER   | YEAR |
      | 2022_MA_SNP_PlanDetails_PRE | PREBENEFITS3 | AARP | No  | OCT-15 | 2022 |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS_AARP @MA_SNP_PREBENEFITS4_AARP
    Examples: 
      | excelPath                   | workSheet    | site | AEP | USER   | YEAR |
      | 2022_MA_SNP_PlanDetails_PRE | PREBENEFITS4 | AARP | No  | OCT-15 | 2022 |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS_AARP @MA_SNP_PREBENEFITS5_AARP
    Examples: 
      | excelPath                   | workSheet    | site | AEP | USER   | YEAR |
      | 2022_MA_SNP_PlanDetails_PRE | PREBENEFITS5 | AARP | No  | OCT-15 | 2022 |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS_AARP @MA_SNP_PREBENEFITS6_AARP
    Examples: 
      | excelPath                   | workSheet    | site | AEP | USER   | YEAR |
      | 2022_MA_SNP_PlanDetails_PRE | PREBENEFITS6 | AARP | No  | OCT-15 | 2022 |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS_AARP @MA_SNP_PREBENEFITS7_AARP
    Examples: 
      | excelPath                   | workSheet    | site | AEP | USER   | YEAR |
      | 2022_MA_SNP_PlanDetails_PRE | PREBENEFITS7 | AARP | No  | OCT-15 | 2022 |

    @PREPlanBenefitsAARP @PDP_PREBENEFITS_AARP
    Examples: 
      | excelPath                | workSheet   | site | AEP | USER   | YEAR |
      | 2022_PDP_PlanDetails_PRE | PREBENEFITS | AARP | No  | OCT-15 | 2022 |

    @PREPlanBenefitsAARP @MS_PREBENEFITS_AARP
    Examples: 
      | excelPath               | workSheet   | site | AEP | USER   | YEAR |
      | 2022_MS_PlanDetails_PRE | PREBENEFITS | AARP | No  | OCT-15 | 2022 |

    @PREPlanBenefitsAARP_UAT @MA_SNP_PDP_PREBENEFITS_AARP_UAT
    Examples: 
      | excelPath                   | workSheet       | site | AEP | USER   | YEAR |
      | 2022_MA_SNP_PlanDetails_PRE | PREBENEFITS_UAT | AARP | No  | OCT-15 | 2022 |
      | 2022_PDP_PlanDetails_PRE    | PREBENEFITS_UAT | AARP | No  | OCT-15 | 2022 |

    @PREPlanBenefitsAARP_UAT @MS_PREBENEFITS_AARP_UAT
    Examples: 
      | excelPath               | workSheet       | site | AEP | USER   | YEAR |
      | 2022_MS_PlanDetails_PRE | PREBENEFITS_UAT | AARP | No  | OCT-15 | 2022 |

    @PREPlanBenefitsAARP_TEMP @MA_SNP_PREBENEFITS_AARP_Temp
    Examples: 
      | excelPath                   | workSheet        | site | AEP | USER   | YEAR |
      | 2022_MA_SNP_PlanDetails_PRE | PREBENEFITS_Temp | AARP | No  | OCT-15 | 2022 |

    @PREPlanBenefitsAARP_TEMP @PDP_PREBENEFITS_AARP_Temp
    Examples: 
      | excelPath                | workSheet        | site | AEP | USER   | YEAR |
      | 2022_PDP_PlanDetails_PRE | PREBENEFITS_Temp | AARP | No  | OCT-15 | 2022 |

    @PREPlanBenefitsAARP_Temp @MS_PREBENEFITS_AARP_Temp
    Examples: 
      | excelPath               | workSheet        | site | AEP | USER   | YEAR |
      | 2022_MS_PlanDetails_PRE | PREBENEFITS_Temp | AARP | No  | OCT-15 | 2022 |

    @PREPlanBenefitsAARP @MA_SNP_PREBENEFITS_AARP_SUPPRESSION
    Examples: 
      | excelPath                   | workSheet            | site | AEP | USER   | YEAR |
      | 2022_MA_SNP_PlanDetails_PRE | PREBENEFITS_Temp_Neg | AARP | No  | OCT-15 | 2022 |
