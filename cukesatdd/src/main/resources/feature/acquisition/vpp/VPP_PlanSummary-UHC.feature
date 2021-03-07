@fixedTestCaseTest @vppPlanSummary
Feature: 2.01.ACQ-VPP Plan Summary Page in UMS 


 @vppPlanCardsRegressionBlayer @fastandfurious 
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify plan cards on plan summary page in UMS site
    Given the user is on uhcmedicaresolutions site landing page
    When the user does plan search using the following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
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
#    Then the user validates below plan benefit values for the above selected plan in UMS site for PDP  Plans
#      | Monthly Premium | <monthlyPremium> |
#      | Annual Deductible | <annualDeductible> |
#      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |  
    Then the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in UMS Site  
#   Then the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in UMS Site  
    Then the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan in UMS Site
    Then the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in UMS Site
   Then the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in UMS site
    Then the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in UMS site 
    Then the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans in UMS Site
    Then the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans in UMS Site
    Then the user clicks on Enroll Now for UMS site and validates the Welcome to OLE Page

    Examples: 
   |   TID  | zipcode | isMultutiCounty | county             | plantype | planName                                             | monthlyPremium  | primaryCarePhysician  | specialist  | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                       | annualDeductible                                       |
   |  15553 |  90210  | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)    | $0              | $0  copay             | $0  copay   | Yes              | $3,400.00          | $4  copay                                    |                                                        | 
   |  15554 |  28105  | YES             | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO-POS D-SNP)             | $0              | $0  copay             | $0  copay   | No               | $0 - $6,700.00     | $0, $1.25, $3.40 copay, or 15% coinsurance   |                                                        |                                                               
   
   @prodRegression
    Examples: 
   |   TID  | zipcode | isMultutiCounty | county             | plantype | planName                                             | monthlyPremium  | primaryCarePhysician  | specialist  | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                       | annualDeductible                                       |
   |  15542 |  90210  | NO              | Los Angeles County | MA       | AARP Medicare Advantage SecureHorizons Essential (HMO) | $0              | $5  copay             | $10  copay  | Yes              |  $4,900.00         |  No drug coverage                            |                                                        | 
   |  15543 |  90210  | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                      | $0              |                       |             |                  |                    | $0  copay                                    | $0 for Tier 1, Tier 2 $415 for Tier 3, Tier 4, Tier 5  |
      
   @rightRailRegressionBlayer @fastandfurious
   Scenario Outline: TID: <TID> -plan type: <plantype> - Verify right rail on plan summary page in UMS site
   Given the user is on uhcmedicaresolutions site landing page
    When the user does plan search using the following information in UMS site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    When user views plans of the below plan type in UMS site for current year
      | Plan Type | <plantype> |
    Then the user validates the right rail in UMS Site
    Then the user validates the Need Help Section in the right rail in ums Site
    Then the user validates the TFN in the Need Help Section in ums Site
    Then the user validates Get a free medicare Guide section in the right rail in ums Site
    Then the user enters the following information in the Get a free medicare Guide section in ums Site
     | First Name | <firstName> |
     | Last Name | <lastName> |
     | Email Address | <emailAddress> |
    Then the user validates Plan Selector Tool section in the right rail in ums Site  
    Then the user validates Plan Selector Page after clicking on Start Plan Selector button in ums Site
  # Then the user validates Need More Information section in the right rail in ums Site
  # Then the user validates Medicare Plans Video Guide Page after clicking Choose a video link in ums Site  
    
    Examples: 
   |   TID   | zipcode | isMultutiCounty | county             | plantype | firstName | lastName | emailAddress  | 
   |  15549  |  90210  | NO              | Los Angeles County | MAPD     | test      | test     | test@test.com | 
    
                              