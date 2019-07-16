@PlanDetails_PlanDocumentsAARP
Feature: test Plan Documents PDFs on Plan Deatils Page

  @PlanDocs_PDFvalidation
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify specific Additional Benefits in Plan Details for provided plan
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
     | PDF type | <pdfType> |
     | DocumentCode | <docCode> |
    Then the user click on PDF link and validates document code in URL
     | PDF type | <pdfType> |
     | DocumentCode | <docCode> |
    
 
   Examples: 
      | TID   | zipcode | isMultutiCounty | county         | plantype | planName                                     | pdfType | docCode |
      | 15652 |   53503 | No              | Iowa County    | MAPD     | UnitedHealthcare MedicareComplete Open (PPO) | Step Therapy Criteria | Step_Therapy_MCORE_2019 |
     # | 15645 |   99210 | No              | Spokane County | MA       | AARP MedicareComplete Essential (HMO)        |
          