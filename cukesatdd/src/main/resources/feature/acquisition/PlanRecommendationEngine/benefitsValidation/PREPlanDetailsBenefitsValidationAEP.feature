Feature: PRE Plans benefits validation

  #AEP value should be Yes while using flagsmith and change the year accordingly i.e previous/current year
  #AEP value should be NO on non-AEP period i.e not using flagsmith or from OCT-01
  #year.equalsIgnoreCase("2021") change the year in step definition to validate previous/current year
  @AEP_PREPlanBenefits_ExcelValidation
  Scenario Outline: Verify PRE plan benefits on the PRE Results Page for the plans provided in Excel : <excelPath> and Sheet : <workSheet> with the site : <site>
    Given the user navigates to PRE results page and compares plan benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |
      | AEP           | <AEP>       |
      | USER          | <USER>      |
      | YEAR          | <YEAR>      |

    @AEP_PREPlanBenefitsAARP @AEP_MA_SNP_PREBENEFITS_AARP @AEP_MA_SNP_PREBENEFITS1_AARP
    Examples: 
      | excelPath                    | workSheet    | site | AEP | USER   | YEAR |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS1 | AARP | No  | OCT-15 | 2021 |

    @AEP_PREPlanBenefitsAARP @AEP_MA_SNP_PREBENEFITS_AARP @AEP_MA_SNP_PREBENEFITS2_AARP
    Examples: 
      | excelPath                    | workSheet    | site | AEP | USER   | YEAR |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS2 | AARP | No  | OCT-15 | 2021 |

    @AEP_PREPlanBenefitsAARP @AEP_MA_SNP_PREBENEFITS_AARP @AEP_MA_SNP_PREBENEFITS3_AARP
    Examples: 
      | excelPath                    | workSheet    | site | AEP | USER   | YEAR |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS3 | AARP | No  | OCT-15 | 2021 |

    @AEP_PREPlanBenefitsAARP @AEP_MA_SNP_PREBENEFITS_AARP @AEP_MA_SNP_PREBENEFITS4_AARP
    Examples: 
      | excelPath                    | workSheet    | site | AEP | USER   | YEAR |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS4 | AARP | No  | OCT-15 | 2021 |

    @AEP_PREPlanBenefitsAARP @AEP_MA_SNP_PREBENEFITS_AARP @AEP_MA_SNP_PREBENEFITS5_AARP
    Examples: 
      | excelPath                    | workSheet    | site | AEP | USER   | YEAR |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS5 | AARP | No  | OCT-15 | 2021 |

    @AEP_PREPlanBenefitsAARP @AEP_MA_SNP_PREBENEFITS_AARP @AEP_MA_SNP_PREBENEFITS6_AARP
    Examples: 
      | excelPath                    | workSheet    | site | AEP | USER   | YEAR |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS6 | AARP | No  | OCT-15 | 2021 |

    @AEP_PREPlanBenefitsAARP @AEP_PDP_PREBENEFITS_AARP
    Examples: 
      | excelPath                 | workSheet   | site | AEP | USER   | YEAR |
      | 2021 PDP_Plan details_PRE | PREBENEFITS | AARP | No  | OCT-15 | 2021 |

    @AEP_PREPlanBenefitsAARP @AEP_MS_PREBENEFITS_AARP
    Examples: 
      | excelPath                | workSheet   | site | AEP | USER   | YEAR |
      | 2021 MS_Plan Details_PRE | PREBENEFITS | AARP | No  | OCT-15 | 2021 |

    @AEP_PREPlanBenefitsAARP_UAT @AEP_MA_SNP_PDP_PREBENEFITS_AARP_UAT
    Examples: 
      | excelPath                    | workSheet       | site | AEP | USER   | YEAR |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS_UAT | AARP | No  | OCT-15 | 2021 |
      | 2021 PDP_Plan details_PRE    | PREBENEFITS_UAT | AARP | No  | OCT-15 | 2021 |

    @AEP_PREPlanBenefitsAARP_UAT @AEP_MS_PREBENEFITS_AARP_UAT
    Examples: 
      | excelPath                | workSheet       | site | AEP | USER   | YEAR |
      | 2021 MS_Plan Details_PRE | PREBENEFITS_UAT | AARP | No  | OCT-15 | 2021 |

    @AEP_PREPlanBenefitsAARP_TEMP @AEP_MA_SNP_PREBENEFITS_AARP_Temp
    Examples: 
      | excelPath                    | workSheet        | site | AEP | USER   | YEAR |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS_Temp | AARP | No  | OCT-15 | 2021 |

    @AEP_PREPlanBenefitsAARP_TEMP @AEP_PDP_PREBENEFITS_AARP_Temp
    Examples: 
      | excelPath                 | workSheet        | site | AEP | USER   | YEAR |
      | 2021 PDP_Plan details_PRE | PREBENEFITS_Temp | AARP | No  | OCT-15 | 2021 |

    @AEP_PREPlanBenefitsAARP_Temp @AEP_MS_PREBENEFITS_AARP_Temp
    Examples: 
      | excelPath                | workSheet        | site | AEP | USER   | YEAR |
      | 2021 MS_Plan Details_PRE | PREBENEFITS_Temp | AARP | No  | OCT-15 | 2021 |
