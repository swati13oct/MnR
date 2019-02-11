@fixedTestCaseTest @vppPlanSummary
Feature: To test VPP Plan Summary Page in AARP Site

  @vppPlanCardsRegression @fastandfurious
  Scenario Outline: Verify plan cards on plan summary page in AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site 
    Then the user validates plan summary for the below plan in the AARP site
      | Plan Name | <planName> |
    Then the user validates Add to compare checkbox for the above selected plan in the AARP site for MA, MAPD , PDP Plans
    Then the user validates Add to compare checkbox is not present for DSNP Plans
    Then the user validates marketing bullets of the plan
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then the user validates below plan benefit values for the above selected plan in AARP site for MA , DSNP and MAPD Plans
      | Monthly Premium | <monthlyPremium> |
      | Primary Care Physician | <primaryCarePhysician> |
      | Specialist | <specialist> |
      | Referral Required | <referralRequired> |
      | Out Of Pocket Maximum | <outOfPocketMaximum> |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
    Then the user validates below plan benefit values for the above selected plan in AARP site for PDP  Plans
      | Monthly Premium | <monthlyPremium> |
      | Annual Deductible | <annualDeductible> |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |  
    Then the user hover overs the tool tip for Why is my premium $0 and validates the text for MAPD Plan , MA Plan
    Then the user hover overs the tool tip for Annual Deductible and validates the text for PDP Plan
    Then the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan
    Then the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan
    Then the user validates learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans
    Then the user clicks on learn more about Extra help link and validates the pop up is coming for MAPD, PDP,DSNP Plans 
    Then the user closes the pop up and validates its redirection to VPP
    Then the user validates Is my provider covered for one of these Medicare plans? link is present for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans
    Then the user clicks on Is my provider covered for one of these Medicare plans? link and validates Provider Search Page for MA , MAPD and DSNP Plans
    Then the user closes Provider Search Page and reaches to Plan Summary Page
    Then the user clicks on Enroll Now for AARP site and validates the Welcome to OLE Page
      | Plan Name | <planName> |
      

  

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                             | monthlyPremium  | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                       | annualDeductible                                       |
      |  90210  | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    | $0              | $0 copay             | $0 copay   | Yes              | $3,400.00          | $4  copay                                    |                                                        | 
      |  28105  | YES             | Mecklenburg County | DSNP     | UnitedHealthcare Dual Complete (HMO SNP)             | $0 - $26.30     | $0 copay             | $0 copay   | No               | $0 - $6,700.00     | $0, $1.25, $3.40 copay, or 15% coinsurance   |                                                        |                                                        |        
      |  90210  | NO              | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) | $0              | $5 copay             | $10 copay  | Yes              | $4900.00           |                                              |                                                        | 
      |  90210  | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                      | $28.10          |                      |            |                  |                    | $0 copay                                     | $0 for Tier 1, Tier 2  $415 for Tier 3, Tier 4, Tier 5 |
                              