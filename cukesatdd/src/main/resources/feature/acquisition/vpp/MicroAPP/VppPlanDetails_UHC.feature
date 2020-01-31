@vppPlanDetailsUHC
Feature: Vpp to plan Details UHC Scenarios

  @vppPlanDetailsUHC01
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify Plan costs tab in Plan Details for provided plan
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    #    Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on UHC
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    Then the user click on Plan costs tab and validates
      | Monthly Premium | <monthlyPremium> |
      | Yearly Premium  | <yearlyPremium>  |

    Examples: 
      | TID   | zipcode | isMultutiCounty | county         | plantype | planName                                       | monthlyPremium | yearlyPremium |
      | 15638 |   53503 | No              | Iowa County    | MAPD     | UnitedHealthcare Medicare Advantage Open (PPO) | $47            | $564          |
      | 15640 |   99210 | No              | Spokane County | MA       | AARP Medicare Advantage Essential (HMO)        | $0             | $0            |
      | 15641 |   99210 | No              | Spokane County | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)     | $25            | $300          |

  @vppPlanDetailsUHC02
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify Plan costs tab in Plan Details for provided plan
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    #    Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on UHC
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    Then the user click on Optional Services tab and add the rider
      | Optional Rider  | <optionalRider>  |
      | Monthly Premium | <monthlyPremium> |
    Then the user click on Plan costs tab and validates
      | Monthly Premium | <monthlyPremium> |
      | Yearly Premium  | <yearlyPremium>  |

    Examples: 
      | TID   | zipcode | isMultutiCounty | county        | plantype | planName                                                     | optionalRider   | monthlyPremium | yearlyPremium |
      #      | 15658 |   11516 | No              | Nassau County | MA       | UnitedHealthcare MedicareComplete Choice Essential (Regional PPO) | Dental Platinum | $32            | $384          |
      | 15662 |   11516 | No              | Nassau County | MAPD     | UnitedHealthcare Medicare Advantage Essential (Regional PPO) | Dental Platinum | $0             | $0            |

  #      | 15661 |   53910 | No              | Adams County  | SNP      | UnitedHealthcare Medicare Advantage Assist (PPO C-SNP)                | Dental Platinum | $14            | $168          |
  @vppPlanDetailsUHC03
  Scenario Outline: Verify plan details in UMS site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    # When user views plans of the below plan type in UMS site
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    And the user validates the pdf section for uhc
    Then User clicks on Back to Plans link and navigate back to plan summary in UMS site
    Then User click on add to compare checkbox and click on view details link on UMS
    Then I uncheck and go back to the vpp page to validate

    Examples: 
      | zipcode | isMultutiCounty | county       | plantype | planName                                            |
      |   80002 | YES             | Adams County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

  @vppPlanDetailsUHC04
  Scenario Outline: Verify plan details and Plan Compare checkbox in plan details  page in UMS site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    # When user views plans of the below plan type in UMS site
    When user views plans of the below plan type in UMS site for current year
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    And the user validates the pdf section for uhc
    Then User clicks on Back to Plans link and navigate back to plan summary in UMS site
    Then User click on add to compare checkbox and click on view details link on UMS
    Then I uncheck and go back to the vpp page to validate

    Examples: 
      | zipcode | isMultutiCounty | county       | plantype | planName                                            |
      |   80002 | YES             | Adams County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |

  @vppPlanDetailsUHC05
  Scenario Outline: TO click Back to all plans from Top and bottom of the page and verify redirection back to the VPP-Summary page UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    And the user view plan details of the above selected plan in UMS site vpp
      | Plan Name | <planName> |
    Then the user clicks on both top and bottom back to plans link and validates its redirection

    Examples: 
      | zipcode | planName                                             | plantype |
      |   33012 | AARP Medicare Advantage Choice Plan 2 (Regional PPO) | MAPD     |
