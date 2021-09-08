Feature: ACQ-OLE Welcome Page Plan benefits validation

  Scenario Outline: Verify plan benefits on the Welcome OLE Page for <site> provided OLE plans in Excel : <excelPath> and Sheet : <workSheet>
   
    Given the user navigates to Welcome OLE page and compares premium value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>	    |



  @OLEBenefitsnextyear_MA_SNP_dummy
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Dummy | AARP |

  @OLEBenefitsnextyear_PDP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_PDP_OLE | OLEPDPSheet_1  | AARP |

    @OLEBenefitsnextyear_PDP @OLEBenefitsnextyear
    Examples:
      | excelPath                	 | workSheet | site |
      | 2022_Plan Benefits_PDP_OLE | OLEPDPSheet_2  | AARP |

    @OLEBenefitsnextyear_PDP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |
  
      | 2022_Plan Benefits_PDP_OLE | OLEPDPSheet_3  | AARP |

  @OLEBenefitsnextyear_PDP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_PDP_OLE | OLEPDPSheet_1  | UHC |

  @OLEBenefitsnextyear_PDP @OLEBenefitsnextyear
    Examples:
      | excelPath                	 | workSheet | site |
      | 2022_Plan Benefits_PDP_OLE | OLEPDPSheet_2  | UHC |

  @OLEBenefitsnextyear_PDP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |

      | 2022_Plan Benefits_PDP_OLE | OLEPDPSheet_3  | UHC |

  
  #------------------------------------MA and SNP Plans--------------------------------#######
  @OLEBenefitsnextyear_MA_SNP_1 @OLEBenefitsnextyear
      Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_1 | AARP |

  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_2 | AARP |
  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
       | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_3 | AARP |
  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_4 | AARP |
  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
       | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_5 | AARP |
  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
     | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_6 | AARP |

  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_7 | AARP |
  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
     | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_8 | AARP |

  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_9 | AARP |


  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_10 | AARP |


  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_11 | AARP |



  @OLEBenefitsnextyear_MA_SNP_1 @OLEBenefitsnextyear
      Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_1 | UHC |

  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_2 | UHC |
  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
       | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_3 | UHC |
  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_4 | UHC |
  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_5 | UHC |
  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
     	| excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_6 | UHC |

  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_7 | UHC |
  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
     	| excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_8 | UHC |

  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_9 | UHC |


  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_10 | UHC |


  @OLEBenefitsnextyear_MA_SNP @OLEBenefitsnextyear
    Examples:
      | excelPath                | workSheet | site |
      | 2022_Plan Benefits_MA_SNP_OLE | MA_SNP_Sheet_11 | UHC |
