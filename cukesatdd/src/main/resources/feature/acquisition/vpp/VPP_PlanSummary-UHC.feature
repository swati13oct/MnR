@fixedTestCaseTest @vppPlanSummary
Feature: To test VPP Plan Summary Page in UMS Site

  @vppPlanCardsRegressionUHC @fastandfurious
  Scenario Outline: Verify plan cards on plan summary page in UMS site
    Given the user is on uhcmedicaresolutions site landing page
    When the user does plan search using the following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
  #  And the user validates available plans for selected plan types in the UMS site 
    And the user validates plan summary for the below plan in UMS site
      | Plan Name | <planName> |
    Then the user validates and clicks Add to compare checkbox for the above selected plan in the UMS site for MA, MAPD , PDP Plans
    Then the user validates Add to compare checkbox is not present for DSNP Plans in UMS 
    Then the user validates marketing bullets of the plan in UMS Site
    Then the user view plan details of the above selected plan in UMS site and validate
      | Plan Name | <planName> |
    Then the user clicks on back to all plans link and validates its redirection to Plan Summary in UMS site
    Then the user validates below plan benefit values for the above selected plan in UMS site for MA , DSNP and MAPD Plans
      | Monthly Premium | <monthlyPremium> |
      | Primary Care Physician | <primaryCarePhysician> |
      | Specialist | <specialist> |
      | Referral Required | <referralRequired> |
      | Out Of Pocket Maximum | <outOfPocketMaximum> |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
    Then the user validates below plan benefit values for the above selected plan in UMS site for PDP  Plans
      | Monthly Premium | <monthlyPremium> |
      | Annual Deductible | <annualDeductible> |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |  
  #  Then the user hover overs the tool tip for Why is my premium $0 and validates the text for MAPD Plan , MA Plan in UMS Site
  #  Then the user hover overs the tool tip for Annual Deductible and validates the text for PDP Plan in UMS Site
    Then the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan in UMS Site
    Then the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in UMS Site
    Then the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in UMS site
    Then the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in UMS site 
   # Then the user closes the pop up and validates its redirection to VPP in UMS Site
    Then the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans in UMS Site
    Then the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans in UMS Site
    Then the user clicks on Enroll Now for UMS site and validates the Welcome to OLE Page

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                             | monthlyPremium  | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                       | annualDeductible                                       |
      |  90210  | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    | $0              | $0  copay             | $0  copay   | Yes              | $3,400.00          | $4  copay                                    |                                                        | 
     # |  28105  | YES             | Mecklenburg County | SNP     | UnitedHealthcare Dual Complete (HMO SNP)             | $0 - $26.30     | $0  copay             | $0  copay   | No               | $0 - $6,700.00     | $0, $1.25, $3.40 copay, or 15% coinsurance   |                                                        |                                                        |        
     #  |  90210  | NO              | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) | $0              | $5  copay             | $10  copay  | Yes              |  $4,900.00            |   No drug coverage                                           |                                                        | 
     # |  90210  | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                      | $28.10          |                      |            |                  |                    | $0  copay                                     | $0 for Tier 1, Tier 2 $415 for Tier 3, Tier 4, Tier 5 |
      
   @rightRailRegressionUHC
   Scenario Outline: Verify right rail on plan summary page in UMS site
   Given the user is on uhcmedicaresolutions site landing page
    When the user does plan search using the following information in UMS site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user validates the right rail in UMS Site
    Then the user validates the Need Help Section in the right rail in ums Site
    Then the user validates the TFN in the Need Help Section in ums Site
    Then the user validates and clicks on Find an agent in your area link in ums Site
   # Then the user clicks on Find an agent in your area link and validates Agent EBRC Page in UMS Site
   # Then the user navigates back to the Plan Summary Page
    Then the user validates Get a free medicare Guide section in the right rail in ums Site
    Then the user enters the following information in the Get a free medicare Guide section in ums Site
     | First Name | <firstName> |
     | Last Name | <lastName> |
     | Email Address | <emailAddress> |
    #Then the user clicks on Submit button and validates the pop up
  #  Then the user closes the pop up 
    Then the user validates Plan Selector Tool section in the right rail in ums Site  
    Then the user validates Plan Selector Page after clicking on Start Plan Selector button in ums Site
    Then the user validates Need More Information section in the right rail in ums Site
    Then the user validates Medicare Plans Video Guide Page after clicking Choose a video link in ums Site  
   # Then the user closes Medicare Plans Video Guide page and navigates back to Plan Summary Page 
    #Then the user validates Plan Selector Page 
   # Then the user navigates back to Plan Summary Page
    
    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | firstName | lastName | emailAddress         | 
      |  90210  | NO              | Los Angeles County | MAPD     | test      | test     | yashima_16@optum.com | 
    
                              