Feature: ACQ-OLE Welcome Page Plan benefits validation

  Scenario Outline: Verify plan benefits on the Welcome OLE Page for <site> provided OLE plans in Excel : <excelPath> and Sheet : <workSheet>
   
    Given the user navigates to Welcome OLE page and compares premium value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>	    |



  @OLEPlanBenefits_AARP_MA_SNP_dummy
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Dummy | AARP |

  @OLEPlanBenefits_AARP_PDP @OLEPlanBenefits_AARP_1
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_PDP_OLE | OLEPDP_Dummy  | AARP |



  @OLEPlanBenefits_AARP_PDP @OLEPlanBenefits_AARP
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_PDP_OLE | OLEPDPSheet_1  | AARP |

    @OLEPlanBenefits_AARP_PDP @OLEPlanBenefits_AARP
    Examples:
      | excelPath                	 | workSheet | site |
      | 2022_Plan Benefits_PDP_OLE | OLEPDPSheet_2  | AARP |

    @OLEPlanBenefits_AARP_PDP @OLEPlanBenefits_AARP
    Examples:
      | excelPath                | workSheet | site |
  
      | 2022_Plan Benefits_PDP_OLE | OLEPDPSheet_3  | AARP |

  @OLEPlanBenefits_AARP_PDP @OLEPlanBenefits_UHC
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_PDP_OLE | OLEPDPSheet_1  | UHC |

  @OLEPlanBenefits_AARP_PDP @OLEPlanBenefits_UHC
    Examples:
      | excelPath                	 | workSheet | site |
      | 2022_Plan Benefits_PDP_OLE | OLEPDPSheet_2  | UHC |

  @OLEPlanBenefits_AARP_PDP @OLEPlanBenefits_UHC
    Examples:
      | excelPath                | workSheet | site |

      | 2022_Plan Benefits_PDP_OLE | OLEPDPSheet_3  | UHC |

  
  #------------------------------------MA and SNP Plans--------------------------------#######
  @OLEPlanBenefits_AARP_MA_SNP_1 @OLEPlanBenefits_AARP
      Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_1 | AARP |

  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_AARP
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_2 | AARP |
  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_AARP
    Examples:
       | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_3 | AARP |
  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_AARP
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_4 | AARP |
  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_AARP
    Examples:
       | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_5 | AARP |
  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_AARP
    Examples:
     | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_6 | AARP |

  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_AARP
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_7 | AARP |
  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_AARP
    Examples:
     | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_8 | AARP |

  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_AARP
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_9 | AARP |


  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_AARP
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_10 | AARP |


  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_AARP
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_11 | AARP |

  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_AARP
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_12 | AARP |

  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_AARP
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_13 | AARP |

  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_AARP
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_14 | AARP |

  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_AARP
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_15 | AARP |


  @OLEPlanBenefits_AARP_MA_SNP_1 @OLEPlanBenefits_UHC
      Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_1 | UHC |

  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_UHC
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_2 | UHC |
  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_UHC
    Examples:
       | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_3 | UHC |
  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_UHC
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_4 | UHC |
  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_UHC
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_5 | UHC |
  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_UHC
    Examples:
     	| excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_6 | UHC |

  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_UHC
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_7 | UHC |
  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_UHC
    Examples:
     	| excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_8 | UHC |

  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_UHC
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_9 | UHC |


  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_UHC
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_10 | UHC |


  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_UHC
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_11 | UHC |
  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_UHC
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_12 |UHC  |

  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_UHC
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_13 | UHC  |

  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_UHC
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_14 | UHC |

  @OLEPlanBenefits_AARP_MA_SNP @OLEPlanBenefits_UHC
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_15 |UHC  |


