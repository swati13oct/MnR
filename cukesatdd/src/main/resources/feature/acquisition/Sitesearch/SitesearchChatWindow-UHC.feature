@acq_ChatWindow_UHC @F412628
Feature: 1.20 ACQ UHC- To test ChatWindow in uhc site search

  @chatwindowonsitesearchBlayer 
   Scenario Outline: TID: <TID> -plan type: <plantype> - Verify plan cards on plan summary page in UMS site
    Given the user is on uhcmedicaresolutions site landing page
    Then the user validates chat Icon on UHC site
    When the user does plan search using the following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the user validates chat Icon on UHC site
    When user views plans of the below plan type in UMS site for next year    
      | Plan Type | <plantype> |
    Then the user validates chat Icon on UHC site
    And the user validates plan summary for the below plan in UMS site
      | Plan Name | <planName> |
    #Then the user validates and clicks Add to compare checkbox for the above selected plan in the UMS site for MA, MAPD , PDP Plans
    Then the user validates chat Icon on UHC site
    #Then the user validates Add to compare checkbox is not present for DSNP Plans in UMS 
    #Then the user validates chat Icon on UHC site
    #Then the user validates marketing bullets of the plan in UMS Site
   # Then the user validates chat Icon on UHC site
    Then the user view plan details of the above selected plan in UMS site and validate
     | Plan Name | <planName> |
    Then the user validates chat Icon on UHC site
    Then the user clicks on back to all plans link and validates its redirection to Plan Summary in UMS site
    Then the user validates chat Icon on UHC site
   
   Then the user validates chat Icon on UHC site

    Examples: 
   |   TID  | zipcode | isMultutiCounty | county             | plantype | planName                                             | monthlyPremium  | primaryCarePhysician  | specialist  | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                       | annualDeductible                                       |
   |  15553 |  90210  | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)    | $0              | $0  copay             | $0  copay   | Yes              | $3,400.00          | $4  copay                                    |                                                        | 
   |  15554 |  28105  | YES             | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO-POS D-SNP)             | $0              | $0  copay             | $0  copay   | No               | $0 - $6,700.00     | $0, $1.25, $3.40 copay, or 15% coinsurance   |                                                        |                                                               
   
   @prodRegression
    Examples: 
   |   TID  | zipcode | isMultutiCounty | county             | plantype | planName                                             | monthlyPremium  | primaryCarePhysician  | specialist  | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                       | annualDeductible                                       |
 # |  15542 |  90210  | NO              | Los Angeles County | MA       | AARP Medicare Advantage SecureHorizons Essential (HMO) | $0              | $5  copay             | $10  copay  | Yes              |  $4,900.00         |  No drug coverage                            |                                                        | 
   #|  15543 |  90210  | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                      | $0     
   