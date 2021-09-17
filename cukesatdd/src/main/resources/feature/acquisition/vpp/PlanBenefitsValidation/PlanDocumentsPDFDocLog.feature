@PlanDetails_PlanDocumentsAARP
Feature: test Plan Documents PDFs on Plan Deatils Page

  @PlanDocs_ExcelValidation @pdfDocLogAARP
  Scenario Outline: Verify specific PDF Plan Documents in Plan Details Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user picks each example from excel to validate Plan Document PDFs and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    @pdfDocLogAARP01
    Examples: 
      | excelPath                | workSheet | site |
      | PlanDocs_Validation_Data | Sheet1    | AARP |

    @pdfDocLogAARP02
    Examples: 
      | excelPath                | workSheet | site |
      | PlanDocs_Validation_Data | Sheet2    | AARP |

    @pdfDocLogAARP03
    Examples: 
      | excelPath                | workSheet | site |
      | PlanDocs_Validation_Data | Sheet3    | AARP |

    @pdfDocLogAARP04
    Examples: 
      | excelPath                | workSheet | site |
      | PlanDocs_Validation_Data | Sheet4    | AARP |

    @pdfDocLogAARP05
    Examples: 
      | excelPath                | workSheet | site |
      | PlanDocs_Validation_Data | Sheet5    | AARP |

  @PlanDocs_ExcelValidation @pdfDocLogUHC
  Scenario Outline: Verify specific PDF Plan Documents in Plan Details Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user picks each example from excel to validate Plan Document PDFs and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    @pdfDocLogUHC01
    Examples: 
      | excelPath                | workSheet | site |
      | PlanDocs_Validation_Data | Sheet1    | UHC  |

    @pdfDocLogUHC02
    Examples: 
      | excelPath                | workSheet | site |
      | PlanDocs_Validation_Data | Sheet2    | UHC  |

    @pdfDocLogUHC03
    Examples: 
      | excelPath                | workSheet | site |
      | PlanDocs_Validation_Data | Sheet3    | UHC  |

    @pdfDocLogUHC04
    Examples: 
      | excelPath                | workSheet | site |
      | PlanDocs_Validation_Data | Sheet4    | UHC  |

    @pdfDocLogUHC05
    Examples: 
      | excelPath                | workSheet | site |
      | PlanDocs_Validation_Data | Sheet5    | UHC  |
