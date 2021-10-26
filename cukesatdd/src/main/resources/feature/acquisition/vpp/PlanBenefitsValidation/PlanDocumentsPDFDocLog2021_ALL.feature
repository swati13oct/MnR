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
