@fixedTestCaseTest @vppPlanSummary
Feature: 1.01. ACQ- VPP Plan Summary Page in AARP

  @VPP-Plan-Summary-Android
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify plan cards on plan summary page in AARP site
    Given the user is on the AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planYear> |
    #    And the user validates available plans for selected plan types in the AARP site
    And the user validates plan summary for the below plan in AARP site
      | Plan Name | <planName> |
    Then the user validates marketing bullets of the plan in AARP site
    Then the user validates and clicks Add to compare checkbox for the above selected plan in the AARP site for MA, MAPD , PDP Plans
    Then the user view plan details of the above selected plan in AARP site and validate
      | Plan Name | <planName> |
    Then the user clicks on back to all plans link and validates its redirection to Plan Summary in AARP site
    Then the user validates below plan benefit values for the above selected plan in AARP site for MA , DSNP and MAPD Plans
      | Monthly Premium            | <monthlyPremium>         |
      | Primary Care Physician     | <primaryCarePhysician>   |
      | Specialist                 | <specialist>             |
      | Referral Required          | <referralRequired>       |
      | Out Of Pocket Maximum      | <outOfPocketMaximum>     |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
      | Plan Type                  | <plantype>               |
    Then the user validates below plan benefit values for the above selected plan in AARP site for PDP  Plans
      | Monthly Premium            | <monthlyPremium>         |
      | Annual Deductible          | <annualDeductible>       |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
    Then the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in AARP Site
    Then the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in AARP Site
    Then the user clicks on enter drug information link in the benefits table and validate the DCE Home Page for MAPD, PDP , DSNP Plan in AARP site
    Then the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in AARP Site
    Then the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in AARP site
    Then the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in AARP site
    Then the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans
    Then the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans
    Then the user clicks on Enroll Now for AARP site and validates the Welcome to OLE Page

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | planYear | plantype | planName                                            | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                     | annualDeductible |  |
      | 15545 |   90210 | NO              | Los Angeles County | current  | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | $0             | $0  copay            | $0  copay  | Yes              | $3,400.00          | $4  copay                                  |                  |  |
      | 15546 |   28105 | YES             | Mecklenburg County | current  | SNP      | UnitedHealthcare Dual Complete (HMO-POS D-SNP)      | $0             | $0  copay            | $0  copay  | No               | $0 - $6,700.00     | $0, $1.25, $3.40 copay, or 15% coinsurance |                  |  |

    @prodRegression
    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype | planYear | planName                                               | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1 | annualDeductible                                      |
      | 15551 |   90210 | NO              | Los Angeles County | MA       | current  | AARP Medicare Advantage SecureHorizons Essential (HMO) | $0             | $5  copay            | $10  copay | Yes              | $4,900.00          | No drug coverage       |                                                       |
      | 15552 |   90210 | NO              | Los Angeles County | PDP      | current  | AARP MedicareRx Walgreens (PDP)                        | $0             |                      |            |                  |                    | $0  copay              | $0 for Tier 1, Tier 2 $435 for Tier 3, Tier 4, Tier 5 |

  @rightRailRegressionUlayer @fastandfurious
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify right rail on plan summary page in AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    Then the user validates the right rail in AARP Site
    Then the user validates the Need Help Section in the right rail in aarp Site
    Then the user validates the TFN in the Need Help Section in aarp Site
    Then the user validates Get a free medicare Guide section in the right rail in aarp Site
    Then the user enters the following information in the Get a free medicare Guide section in aarp Site
      | First Name    | <firstName>    |
      | Last Name     | <lastName>     |
      | Email Address | <emailAddress> |
    # Then the user validates Need More Information section in the right rail in aarp Site
    # Then the user validates Medicare Plans Video Guide Page after clicking Choose a video link in aarp Site
    Then the user validates Plan Selector Tool section in the right rail in aarp Site
    Then the user validates Plan Selector Page after clicking on Start Plan Selector button in aarp Site

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype | firstName | lastName | emailAddress  | planyear |
      | 15550 |   90210 | NO              | Los Angeles County | MAPD     | test      | test     | test@test.com | current  |
