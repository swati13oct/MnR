@OLEBenefits
Feature: ACQ-Plan benefits validation

  Scenario Outline: Verify plan benefits on the Plan Summary Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
   # Given the user navigates to OLE plan summary page and compares benefits value from excel to UI and reports into excel

    Given the user navigates to Welcome OLE page and compares premium value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>	    |

     @regressionAARP @OLEplanSummaryBenefitsAARP01
    	Examples: 
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_OLE_Data | OLE Sheet2021  | AARP |

  @regressionUHC @OLEplanSummaryBenefitsUHC01
    Examples:
      | excelPath                | workSheet | site |
      | Plan Summary Benefits_OLE_Data | OLE Sheet2021  | UHC |
