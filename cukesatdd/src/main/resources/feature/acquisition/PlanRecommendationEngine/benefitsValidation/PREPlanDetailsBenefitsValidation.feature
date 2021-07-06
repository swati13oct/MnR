Feature: PRE Plans benefits validation

  @PREPlanBenefits_ExcelValidation
  Scenario Outline: Verify PRE plan benefits on the PRE Results Page for the plans provided in Excel : <excelPath> and Sheet : <workSheet> with the site : <site>
    Given the user navigates to PRE results page and compares plan benefits value from excel to UI and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |
      | Site          | <site>      |

    @PREPlanBenefitsAARP
    Examples: 
      | excelPath                    | workSheet   | site |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS | AARP |
      | 2021 MA_SNP_Plan Details_PRE | PREBENEFITS1| AARP |
      #| 2021 PDP_ Plan details_PRE | PREBENEFITS | AARP |
