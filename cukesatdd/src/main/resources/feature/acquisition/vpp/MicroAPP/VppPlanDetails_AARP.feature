@vppPlanDetailsAARP
Feature: Vpp to plan Details AARP Scenarios

  @vppPlanDetailsAARP01
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
      | zipcode | isMultutiCounty | county      | plantype | planName                                       | pdfType               | docCode                 |
      |   53503 | No              | Iowa County | MAPD     | UnitedHealthcare Medicare Advantage Open (PPO) | Step Therapy Criteria | Step_Therapy_MCORE_2020 |

  @vppPlanDetailsAARP02
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
      | zipcode | isMultutiCounty | county         | plantype | planName                                | pdfType         | docCode             |
      |   99210 | No              | Spokane County | MA       | AARP Medicare Advantage Essential (HMO) | Enrollment Form | AAWA20HM4522892_000 |

  @vppPlanDetailsAARP03
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify Plan costs tab in Plan Details for provided plan
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    #    Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on AARP
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user click on Plan costs tab and validates in AARP site
      | Monthly Premium | <monthlyPremium> |
      | Yearly Premium  | <yearlyPremium>  |

    Examples: 
      | TID   | zipcode | isMultutiCounty | county         | plantype | planName                                       | monthlyPremium | yearlyPremium |
      | 15638 |   53503 | No              | Iowa County    | MAPD     | UnitedHealthcare Medicare Advantage Open (PPO) | $47            | $564          |
      | 15640 |   99210 | No              | Spokane County | MA       | AARP Medicare Advantage Essential (HMO)        | $0             | $0            |
      | 15641 |   99210 | No              | Spokane County | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)     | $25            | $300          |

  @vppPlanDetailsAARP04
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify Optional Services tab in Plan Details for provided plan
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    #    Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on AARP
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user click on Optional Services tab and add the rider in AARP site
      | Optional Rider  | <optionalRider>  |
      | Monthly Premium | <monthlyPremium> |
    Then the user click on Plan costs tab and validates in AARP site
      | Monthly Premium | <monthlyPremium> |
      | Yearly Premium  | <yearlyPremium>  |

    Examples: 
      | TID   | zipcode | isMultutiCounty | county        | plantype | planName                                                         | optionalRider   | monthlyPremium | yearlyPremium |
      #      | 15658 |   11516 | No              | Nassau County | MA       | UnitedHealthcare MedicareComplete Choice Essential (Regional PPO) | Dental Platinum | $32            | $384          |
      | 15662 |   11516 | No              | Nassau County | MAPD     | UnitedHealthcare Medicare Advantage Choice Plan 1 (Regional PPO) | Dental Platinum | $16            | $192          |

  #      | 15661 |   53910 | No              | Adams County  | SNP      | UnitedHealthcare Medicare Advantage Assist (PPO C-SNP)                | Dental Platinum | $14            | $168          |
  @vppPlanDetailsAARP05
  Scenario Outline: To click Back to all plans from Top and bottom of the plan deatils page and verify redirection back to the VPP-Summary page AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    #Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    #And the user validates the available plans for selected plan types in the AARP site
    Then the user view plan details of the above selected plan in AARP site vpp
      | Plan Name | <planName> |
      | Plan Type | <plantype> |
    Then the user clicks on both top and bottom back to plans link and validates its redirection AARP

    Examples: 
      | zipcode | isMultiCounty | county             | plantype | planName                                               |
      |   90210 | NO            | Los Angeles County | MA       | AARP Medicare Advantage SecureHorizons Essential (HMO) |
