@PlanDetails_PlanDocumentsAARP
Feature: test Plan Documents PDFs on Plan Deatils Page

  @PlanDocs_ExcelValidation2021 @pdfDocLogAARP
  Scenario Outline: Verify specific PDF Plan Documents in Plan Details Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user picks each example from excel to validate Plan Document PDFs and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    @pdfDocLogAARP01
    Examples: 
      | excelPath                | workSheet   | site |
      | PlanDocs_Validation_2021 | Sheet2021_1 | AARP |

    @pdfDocLogAARP02
    Examples: 
      | excelPath                | workSheet   | site |
      | PlanDocs_Validation_2021 | Sheet2021_2 | AARP |

    @pdfDocLogAARP03
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_ 3 | AARP |

    @pdfDocLogAARP04
    Examples: 
      | excelPath                | workSheet   | site |
      | PlanDocs_Validation_2021 | Sheet2021_4 | AARP |

    @pdfDocLogAARP05
    Examples: 
      | excelPath                | workSheet   | site |
      | PlanDocs_Validation_2021 | Sheet2021_5 | AARP |

    @pdfDocLogAARP06
    Examples: 
      | excelPath                | workSheet   | site |
      | PlanDocs_Validation_2021 | Sheet2021_6 | AARP |

    @pdfDocLogAARP07
    Examples: 
      | excelPath                | workSheet   | site |
      | PlanDocs_Validation_2021 | Sheet2021_7 | AARP |

    @pdfDocLogAARP08
    Examples: 
      | excelPath                | workSheet   | site |
      | PlanDocs_Validation_2021 | Sheet2021_8 | AARP |

    @pdfDocLogAARP09
    Examples: 
      | excelPath                | workSheet   | site |
      | PlanDocs_Validation_2021 | Sheet2021_9 | AARP |

    @pdfDocLogAARP10
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_10 | AARP |

    @pdfDocLogAARP11
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_11 | AARP |

    @pdfDocLogAARP05
    Examples: 
      | excelPath                | workSheet  | site |
      | PlanDocs_Validation_2021 | Sheet2021_ | AARP |

    @pdfDocLogAARP12
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_12 | AARP |

    @pdfDocLogAARP13
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_13 | AARP |

    @pdfDocLogAARP14
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_14 | AARP |

    @pdfDocLogAARP15
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_15 | AARP |

    @pdfDocLogAARP16
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_16 | AARP |

    @pdfDocLogAARP17
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_17 | AARP |

    @pdfDocLogAARP18
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_18 | AARP |

    @pdfDocLogAARP19
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_19 | AARP |

    @pdfDocLogAARP20
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_20 | AARP |

    @pdfDocLogAARP21
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_21 | AARP |

    @pdfDocLogAARP22
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_22 | AARP |

    @pdfDocLogAARP23
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_23 | AARP |

    @pdfDocLogAARP24
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_24 | AARP |

    @pdfDocLogAARP25
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_25 | AARP |

    @pdfDocLogAARP26
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_26 | AARP |

    @pdfDocLogAARP27
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_27 | AARP |

    @pdfDocLogAARP28
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_28 | AARP |

    @pdfDocLogAARP29
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_29 | AARP |

    @pdfDocLogAARP30
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_30 | AARP |

    @pdfDocLogAARP31
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_31 | AARP |

    @pdfDocLogAARP32
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_32 | AARP |

    @pdfDocLogAARP33
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_33 | AARP |

    @pdfDocLogAARP34
    Examples: 
      | excelPath                | workSheet    | site |
      | PlanDocs_Validation_2021 | Sheet2021_34 | AARP |

    @pdfDocLogPDPAARP01
    Examples: 
      | excelPath                | workSheet      | site |
      | PlanDocs_Validation_2021 | PDPSheet2021_1 | AARP |

    @pdfDocLogPDPAARP02
    Examples: 
      | excelPath                | workSheet      | site |
      | PlanDocs_Validation_2021 | PDPSheet2021_2 | AARP |

    @pdfDocLogPDPAARP03
    Examples: 
      | excelPath                | workSheet      | site |
      | PlanDocs_Validation_2021 | PDPSheet2021_3 | AARP |

    @pdfDocLogPDPAARP04
    Examples: 
      | excelPath                | workSheet      | site |
      | PlanDocs_Validation_2021 | PDPSheet2021_4 | AARP |

    @pdfDocLogPDPAARP05
    Examples: 
      | excelPath                | workSheet      | site |
      | PlanDocs_Validation_2021 | PDPSheet2021_5 | AARP |

    @pdfDocLogPDPAARP06
    Examples: 
      | excelPath                | workSheet      | site |
      | PlanDocs_Validation_2021 | PDPSheet2021_6 | AARP |
