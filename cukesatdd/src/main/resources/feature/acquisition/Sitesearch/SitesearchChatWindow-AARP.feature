@acq_ChatWindow_AARP @F412628
Feature: 1.20 ACQ AARP- To test ChatWindow in AARP site search

@chatwindowonsitesearchUlayer
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify plan cards on plan summary page in AARP site
    Given the user is on the AARP medicare acquisition site landing page
    Then the user validates chat Icon
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    # And the user views the plans of the below plan type in AARP site and select Next year
    #  | Plan Type | <plantype> |
      And the user views the plans of the below plan type in AARP site and validates Chat Icon
      | Plan Type | <plantype> |
    Then the user validates chat Icon
    And the user validates available plans for selected plan types in the AARP site 
     Then the user validates chat Icon
    And the user validates plan summary for the below plan in AARP site
      | Plan Name | <planName> |
      Then the user validates chat Icon

     
    Examples: 
       |   TID  | zipcode | isMultutiCounty | county             | plantype | planName                                             | monthlyPremium  | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                         | annualDeductible                                       |
       | 15545  |  90210  | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)    | $0              | $0  copay             | $0  copay   | Yes              | $3,400.00          | $4  copay                                    |                                                        | 
       | 15546  |  28105  | YES             | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO-POS D-SNP)             | $0              | $0  copay             | $0  copay   | No               | $0 - $6,700.00     | $0, $1.25, $3.40 copay, or 15% coinsurance   |                                                        |                                                        |        
       
     @prodRegression
     Examples:
       |   TID  | zipcode | isMultutiCounty | county             | plantype | planName                                             | monthlyPremium  | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                         | annualDeductible                                       |
      # | 15551  |  90210  | NO              | Los Angeles County | MA       | AARP Medicare Advantage SecureHorizons Essential (HMO) | $0              | $5  copay             | $10  copay  | Yes              | $4,900.00          |  No drug coverage                            |                                                        | 
      # | 15552  |  90210  | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                      | $0              |                       |             |                  |                    | $0  copay                                    | $0 for Tier 1, Tier 2 $435 for Tier 3, Tier 4, Tier 5  | 
      
     