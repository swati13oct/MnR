@fixedTestCaseTest @vppPlanSummary
Feature: To test VPP Plan Summary Page in UMS Site

  @vppPlanCardsRegression @fastandfurious
  Scenario Outline: Verify plan cards on plan summary page in UMS site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the UMS site 
    Then the user validates plan summary for the below plan in the UMS site
      | Plan Name | <planName> |
    Then the user validates Add to compare checkbox for the above selected plan in the AARP site for MA, MAPD , PDP Plans
    Then the user validates Add to compare checkbox is not present for DSNP Plans
    Then the user validates marketing bullets of the plan
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    Then User clicks on Back to Plans link and navigate back to plan summary in UMS site
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
    Then the user hover overs the tool tip for Why is my premium $0 and validates the text for MAPD Plan , MA Plan
    Then the user hover overs the tool tip for Annual Deductible and validates the text for PDP Plan
    Then the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan
    Then the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan
    Then the user validates See premium if I get Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans
    Then the user clicks on See premium if I get Extra help link and validates the pop up is coming for MAPD, PDP,DSNP Plans 
    Then the user closes the pop up and validates its redirection to VPP
    Then the user validates Is my provider covered in my ZIP code/county? link is present for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans
    Then the user clicks on Is my provider covered in my ZIP code/county? link and validates Provider Search Page for MA , MAPD and DSNP Plans
    Then the user closes Provider Search Page and reaches to Plan Summary Page
    Then the user clicks on Enroll Now for UMS site and validates the Welcome to OLE Page
      | Plan Name | <planName> |       

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                             | monthlyPremium  | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                       | annualDeductible                                       |
      |  90210  | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)    | $0              | $0 copay             | $0 copay   | Yes              | $3,400.00          | $4  copay                                    |                                                        | 
      |  28105  | YES             | Mecklenburg County | DSNP     | UnitedHealthcare Dual Complete (HMO SNP)             | $0 - $26.30     | $0 copay             | $0 copay   | No               | $0 - $6,700.00     | $0, $1.25, $3.40 copay, or 15% coinsurance   |                                                        |                                                        |        
      |  90210  | NO              | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Essential (HMO) | $0              | $5 copay             | $10 copay  | Yes              | $4900.00           |                                              |                                                        | 
      |  90210  | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                      | $28.10          |                      |            |                  |                    | $0 copay                                     | $0 for Tier 1, Tier 2  $415 for Tier 3, Tier 4, Tier 5 |
      
   @rightRailRegression
   Scenario Outline: Verify right rail on plan summary page in UMS site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user validates the right rail in UMS Site
    Then the user validates the Need Help Section in the right rail
    Then the user validates the TFN in the Need Help Section
    Then the user validates Find an agent in your area link
    Then the user clicks on Find an agent in your area link and validates Agent EBRC Page
    Then the user navigates back to the Plan Summary Page
    Then the user validates Get a free medicare Guide section in the right rail
    Then the user enters the following information in the Get a free medicare Guide section
      | First Name | <firstName> |
      | Last Name | <lastName> |
      | Email Address | <emailAddress> |
    Then the user clicks on Submit button and validates the pop up
    Then the user closes the pop up 
    Then the user validates Need More Information? section in the right rail
    Then the user validates and click on Choose a video link 
    Then the user validates Medicare Plans Video Guide Page
    Then the user closes Medicare Plans Video Guide page and navigates back to Plan Summary Page 
    Then the user validates Need a Step Back? section in the right rail  
    Then the user validates and clicks on Start Plan Selector button 
    Then the user validates Plan Selector Page 
    Then the user navigates back to Plan Summary Page
    
    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | firstName | lastName | emailAddress         | 
      |  90210  | NO              | Los Angeles County | MAPD     | test      | test     | yashima_16@optum.com | 
    
                              