@PlanDetails_PlanDocumentsAARP
Feature: test Plan Documents PDFs on Plan Deatils Page
  @PlanDocs_PDF_URLvalidation
  Scenario Outline: Plan type: <plantype> - PDF Type: <pdfType> - Verify specific PDF Plan Documents in Plan Details Page for provided plan
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user validates following PDF link is displayes with correct document code
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |
    Then the user click on PDF link and validates document code in URL
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |

    Examples: 
      | zipcode | isMultutiCounty | county      | plantype | planName                                     | pdfType               | docCode                 |
      |   53503 | No              | Iowa County | MAPD     | UnitedHealthcare MedicareComplete Open (PPO) | Step Therapy Criteria | Step_Therapy_MCORE_2019 |

  @PlanDocs_PDF_Textvalidation
  Scenario Outline: Plan type: <plantype> - PDF Type: <pdfType> - Verify specific PDF Plan Documents in Plan Details Page for provided plan
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user validates following PDF link is displayes with correct document code
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |
    Then the user validates the document code is present in the PDF
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |

    Examples: 
      | zipcode | isMultutiCounty | county         | plantype | planName                              | pdfType             | docCode             |
      |   99210 | No              | Spokane County | MA       | AARP MedicareComplete Essential (HMO) | Summary of Benefits | AAWA19HM4290842_000 |

  @PlanDocs_PDF_ExcelValidation
  Scenario Outline: Plan type: <plantype> - PDF Type: <pdfType> - Verify specific PDF Plan Documents in Plan Details Page for provided plan
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user validates following PDF link is displayes with correct document code
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |
    Then the user validates the document code is present in the PDF or url
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |

    Examples: 
      | zipcode | isMultutiCounty | county         | plantype | planName                                     | pdfType               | docCode                 |
      |   99210 | No              | Spokane County | MA       | AARP MedicareComplete Essential (HMO)        | Summary of Benefits   | AAWA19HM4290842_000     |
      |   53503 | No              | Iowa County    | MAPD     | UnitedHealthcare MedicareComplete Open (PPO) | Step Therapy Criteria | Step_Therapy_MCORE_2019 |

  @PlanDocs_ExcelValidation1
  Scenario Outline: Verify specific PDF Plan Documents in Plan Details Page for provided plan provided in Excel : <excelPath> and Sheet : <workSheet>
    Given the user picks each example from excel to validate Plan Document PDFs and reports into excel
      | ExcelFile     | <excelPath> |
      | WorkSheetName | <workSheet> |

    Examples: 
      | excelPath                   | workSheet |
      | AcqPlanDocs_Validation_Data | PlanDocs  |
