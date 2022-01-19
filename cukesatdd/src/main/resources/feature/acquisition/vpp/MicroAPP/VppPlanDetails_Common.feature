@vpp @planDetails
Feature: 1.01.2-Vpp to plan Details AARP Scenarios

  Scenario Outline: TestCaseID: <TCID> - PDF Type: <pdfType> - Verify specific PDF Plan Documents in Plan Details Page for provided plan on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <planName> |
    Then the user validates following PDF link is displayed with correct document code
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |
    Then the user click on PDF link and validates document code in site URL
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |

    @vppPlanDetailsCommon_AARP01
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county      | plantype | planName                                  | pdfType               | docCode                  | planyear |
      | 00001 | AARP |   53503 | No              | Iowa County | MAPD     | AARP Medicare Advantage Open Plan 2 (PPO) | Step Therapy Criteria | Step_Therapy_MCOREE_2021 | current  |

    @vppPlanDetailsCommon_UHC01
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county      | plantype | planName                                  | pdfType               | docCode                  | planyear |
      | 00001 | UHC  |   53503 | No              | Iowa County | MAPD     | AARP Medicare Advantage Open Plan 2 (PPO) | Step Therapy Criteria | Step_Therapy_MCOREE_2021 | current  |

    @regressionAARP @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county      | plantype | planName                                  | pdfType               | docCode                  | planyear |
      | 00001 | AARP |   53503 | No              | Iowa County | MAPD     | AARP Medicare Advantage Open Plan 2 (PPO) | Step Therapy Criteria | Step_Therapy_MCORE_2022  | future   |

    @regressionUHC @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county      | plantype | planName                                  | pdfType               | docCode                  | planyear |
      | 00001 | UHC  |   53503 | No              | Iowa County | MAPD     | AARP Medicare Advantage Open Plan 2 (PPO) | Step Therapy Criteria | Step_Therapy_MCOREE_2021 | future   |

  #1a
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify Plan costs tab in Plan Details for provided plan on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <planName> |
    Then the user click on Plan costs tab and validates in site
      | Monthly Premium | <monthlyPremium> |
      | Yearly Premium  | <yearlyPremium>  |

    @vppPlanDetailsCommon_AARP01 @regressionAARP @sanity
    Examples: 
      | TID   | site | zipcode | isMultutiCounty | county      | plantype | planName                                  | monthlyPremium | yearlyPremium | planyear |
      #| 00002 | AARP |   53503 | No              | Iowa County | MAPD     | AARP Medicare Advantage Open Plan 2 (PPO) | $29            | $348          | current  |

    @vppPlanDetailsCommon_UHC01 @regressionUHC @prodRegression @sanity @vbfGate
    Examples: 
      | TID   | site | zipcode | isMultutiCounty | county      | plantype | planName                                  | monthlyPremium | yearlyPremium | planyear |
     # | 00002 | UHC  |   53503 | No              | Iowa County | MAPD     | AARP Medicare Advantage Open Plan 2 (PPO) | $29            | $348          | current  |

    @regressionAARP @nextYear @prodRegression
    Examples: 
      | TID   | site | zipcode | isMultutiCounty | county      | plantype | planName                                  | monthlyPremium | yearlyPremium | planyear |
      | 00002 | AARP |   53503 | No              | Iowa County | MAPD     | AARP Medicare Advantage Open Plan 2 (PPO) | $29            | $348          | future   |

    @regressionUHC @nextYear
    Examples: 
      | TID   | site | zipcode | isMultutiCounty | county      | plantype | planName                                  | monthlyPremium | yearlyPremium | planyear |
      | 00002 | UHC  |   53503 | No              | Iowa County | MAPD     | AARP Medicare Advantage Open Plan 2 (PPO) | $29            | $348          | future   |

  #1b
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify Optional Services tab in Plan Details for provided plan on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <planName> |
    Then the user click on Optional Services tab and add the rider on site
      | Optional Rider  | <optionalRider>  |
      | Monthly Premium | <monthlyPremium> |
    Then the user click on Plan costs tab and validates on site
      | Monthly Premium | <monthlyPremium> |
      | Yearly Premium  | <yearlyPremium>  |

    @vppPlanDetailsCommon_AARP01 @regressionAARP @vbfGate
    Examples: 
      | TID   | site | zipcode | isMultutiCounty | county        | plantype | planName                                                   | optionalRider   | monthlyPremium | yearlyPremium | planyear |
     # | 00003 | AARP |   11516 | No              | Nassau County | MA       | UnitedHealthcare Medicare Advantage Patriot (Regional PPO) | Dental Platinum | $0             | $0            | current  |

    @vppPlanDetailsCommon_UHC01 @regressionUHC
    Examples: 
      | TID   | site | zipcode | isMultutiCounty | county        | plantype | planName                                                   | optionalRider   | monthlyPremium | yearlyPremium | planyear |
     # | 00003 | UHC  |   11516 | No              | Nassau County | MA       | UnitedHealthcare Medicare Advantage Patriot (Regional PPO) | Dental Platinum | $0             | $0            | current  |

    @regressionAARP @nextYear
    Examples: 
      | TID   | site | zipcode | isMultutiCounty | county        | plantype | planName                                                   | optionalRider   | monthlyPremium | yearlyPremium | planyear |
      | 00003 | AARP |   11516 | No              | Nassau County | MA       | UnitedHealthcare Medicare Advantage Patriot (Regional PPO) | Dental Platinum | $0             | $0            | future   |

    @regressionUHC @nextYear
    Examples: 
      | TID   | site | zipcode | isMultutiCounty | county        | plantype | planName                                                   | optionalRider   | monthlyPremium | yearlyPremium | planyear |
      | 00003 | UHC  |   11516 | No              | Nassau County | MA       | UnitedHealthcare Medicare Advantage Patriot (Regional PPO) | Dental Platinum | $0             | $0            | future   |

  Scenario Outline: UserStory: <TCID> -plan type: <plantype> - To click Back to all plans from Top and bottom of the plan deatils page and verify redirection back to the VPP-Summary page <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    #Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    #    Then the user view plan details of the above selected plan in site vpp
    Then the user views plan details of the above selected plan and validates
      | Plan Name | <planName> |
    # | Plan Type | <plantype> |
    Then the user clicks on both top and bottom back to plans link and validate its redirection

    @vppPlanDetailsCommon_AARP02 @regressionAARP
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planName                              | planyear |
     # | 00004 | AARP |   90210 | NO            | Los Angeles County | MA       | AARP Medicare Advantage Patriot (HMO) | current  |

    @vppPlanDetailsCommon_UHC02 @regressionUHC
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planName                              | planyear |
    #  | 00004 | UHC  |   90210 | NO            | Los Angeles County | MA       | AARP Medicare Advantage Patriot (HMO) | current  |

    @regressionAARP @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planName                              | planyear |
      | 00004 | AARP |   90210 | NO            | Los Angeles County | MA       | AARP Medicare Advantage Patriot (HMO) | future   |

    @regressionUHC @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultiCounty | county             | plantype | planName                              | planyear |
      | 00004 | UHC  |   90210 | NO            | Los Angeles County | MA       | AARP Medicare Advantage Patriot (HMO) | future   |

  Scenario Outline: <TCID> - Plan type: <plantype> - Verify OLE Landing from VPP Plan Details on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <planName> |
    Then the user clicks on Enroll Now in Plan Details Page to start the OLE flow on the site
    Then The User validates the Plan details on OLE page

    @vppPlanDetailsCommon_AARP02 @regressionAARP @sampleTest
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county             | plantype | planName                                                | planyear |
     # | 00005 | AARP |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)     | current  |
     # | 00006 | AARP |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                         | current  |
     # | 00007 | AARP |   24571 | YES             | Bedford County     | MAPD     | UnitedHealthcare Medicare Advantage Choice Plan 2 (PPO) | current  |
     # | 00008 | AARP |   78006 | YES             | Bexar County       | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)              | current  |

    @prodRegression 
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county             | plantype | planName                                            | planyear |
      | 00005 | AARP |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | future  |

    @vppPlanDetailsCommon_UHC02 @regressionUHC
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county             | plantype | planName                                                | planyear |
     # | 00005 | UHC  |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)     | current  |
     # | 00006 | UHC  |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                         | current  |
     # | 00007 | UHC  |   24571 | YES             | Bedford County     | MAPD     | UnitedHealthcare Medicare Advantage Choice Plan 2 (PPO) | current  |
     # | 00008 | UHC  |   78006 | YES             | Bexar County       | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)              | current  |

    @prodRegression 
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county       | plantype | planName                                   | planyear |
      | 00008 | UHC  |   78006 | YES             | Bexar County | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP) | future  |

    @regressionAARP @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county             | plantype | planName                                                | planyear |
      | 00005 | AARP |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)     | future   |
      | 00006 | AARP |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                         | future   |
      | 00007 | AARP |   24571 | YES             | Bedford County     | MAPD     | UnitedHealthcare Medicare Advantage Choice Plan 2 (PPO) | future   |
      | 00008 | AARP |   78006 | YES             | Bexar County       | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)              | future   |

    @regressionUHC @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county             | plantype | planName                                                | planyear |
      | 00005 | UHC  |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)     | future   |
      | 00006 | UHC  |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                         | future   |
      | 00007 | UHC  |   24571 | YES             | Bedford County     | MAPD     | UnitedHealthcare Medicare Advantage Choice Plan 2 (PPO) | future   |
      | 00008 | UHC  |   78006 | YES             | Bexar County       | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)              | future   |

  Scenario Outline: UserStory: <TCID> -plan type: <plantype> - Verify Provider Search  in <site> site from Plan Details page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <planName> |
    When the user Click on Look up your Provider button on Plan Details Page
    When user selects a provider and retuns to VPP plan details page
    Then Verify X out of Y provider covered information is displayed on Plan Details page

    @vppPlanDetailsCommon_AARP02 @prodRegression @regressionAARP @sanity
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county       | plantype | planName                             | planyear |
    #  | 00009 | AARP |   78006 | YES             | Bexar County | MA       | AARP Medicare Advantage Choice (PPO) | current  |

    @vppPlanDetailsCommon_UHC02 @regressionUHC @sanity
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county       | plantype | planName                             | planyear |
   #   | 00009 | UHC  |   78006 | YES             | Bexar County | MA       | AARP Medicare Advantage Choice (PPO) | current  |

    @regressionAARP @nextYear @prodRegression
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county       | plantype | planName                             | planyear |
      | 00009 | AARP |   78006 | YES             | Bexar County | MA       | AARP Medicare Advantage Choice (PPO) | future   |

    @regressionUHC @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county       | plantype | planName                             | planyear |
      | 00009 | UHC  |   78006 | YES             | Bexar County | MA       | AARP Medicare Advantage Choice (PPO) | future   |

  Scenario Outline: UserStory: <TCID> -plan type: <plantype> - Verify Prescription Drug Benefits tab in Plan Details for provided plan
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <planName> |
    Then the user click on Prescription Drug Benefits and validates

    @vppPlanDetailsCommon_AARP03 @regressionAARP
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county             | plantype | planName                                            | planyear |
      #| 00010 | AARP |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | current  |
      #| 00011 | AARP |   78006 | YES             | Bexar County       | PDP      | AARP MedicareRx Walgreens (PDP)                     | current  |
      #| 00012 | AARP |   78006 | YES             | Bexar County       | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP)       | current  |

    @vppPlanDetailsCommon_UHC03 @regressionUHC
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county             | plantype | planName                                            | planyear |
      #| 00010 | UHC  |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | current  |
      #| 00011 | UHC  |   78006 | YES             | Bexar County       | PDP      | AARP MedicareRx Walgreens (PDP)                     | current  |
      #| 00012 | UHC  |   78006 | YES             | Bexar County       | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP)       | current  |

    @regressionAARP @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county             | plantype | planName                                            | planyear |
      | 00010 | AARP |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | future   |
      | 00011 | AARP |   78006 | YES             | Bexar County       | PDP      | AARP MedicareRx Walgreens (PDP)                     | future   |
      | 00012 | AARP |   78006 | YES             | Bexar County       | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP)       | future   |

    @regressionUHC @nextYear
    Examples: 
      | TCID  | site | zipcode | isMultutiCounty | county             | plantype | planName                                            | planyear |
      | 00010 | UHC  |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | future   |
      | 00011 | UHC  |   78006 | YES             | Bexar County       | PDP      | AARP MedicareRx Walgreens (PDP)                     | future   |
      | 00012 | UHC  |   78006 | YES             | Bexar County       | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP)       | future   |

  Scenario Outline: UserStory: <TCID> -plan type: <plantype> - Verify plan details and back to summary and add to compare and uncheck in plan details and verify uncheck in plan summary on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user navigates to the plan details page
      | Plan Name | <planName> |
    And the user validates the pdf section on site
    Then User clicks on Back to Plans link and navigate back to plan summary
    Then User click on add to compare checkbox and click on view details link
    Then I uncheck and go back to the vpp page to validate for site

    @vppPlanDetailsCommon_AARP03 @regressionAARP @prodRegression
    Examples: 
      | TCID   | site | zipcode | isMultutiCounty | county       | plantype | planName                              | planyear |
     # | 000013 | AARP |   78006 | YES             | Bexar County | MA       | AARP Medicare Advantage Patriot (HMO) | current  |

    @vppPlanDetailsCommon_UHC03 @regressionUHC
    Examples: 
      | TCID   | site | zipcode | isMultutiCounty | county       | plantype | planName                              | planyear |
      #| 000013 | UHC  |   78006 | YES             | Bexar County | MA       | AARP Medicare Advantage Patriot (HMO) | current  |

    @regressionAARP @nextYear @prodRegression
    Examples: 
      | TCID   | site | zipcode | isMultutiCounty | county       | plantype | planName                              | planyear |
      | 000013 | AARP |   78006 | YES             | Bexar County | MA       | AARP Medicare Advantage Patriot (HMO) | future   |

    @regressionUHC @nextYear
    Examples: 
      | TCID   | site | zipcode | isMultutiCounty | county       | plantype | planName                              | planyear |
      | 000013 | UHC  |   78006 | YES             | Bexar County | MA       | AARP Medicare Advantage Patriot (HMO) | future   |

  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify <optionalRider> in Plan Details for provided plan and validating Dental Directory link on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user views plan details of the above selected plan and validates
      | Plan Name | <planName> |
    Then the user click on Dental Cover Popup he must be able to validate plan defaults
      | Optional Rider | <optionalRider> |
      | Plan Name      | <planName>      |

    @vppPlanDetailsCommon_AARP03 @regressionAARP
    Examples: 
      | TID    | site | zipcode | isMultutiCounty | county        | plantype | planName                                                   | optionalRider   | planyear |
     # | 000014 | AARP |   11516 | No              | Nassau County | MA       | UnitedHealthcare Medicare Advantage Patriot (Regional PPO) | Dental Platinum | current  |

    @vppPlanDetailsCommon_UHC03 @regressionUHC
    Examples: 
      | TID    | site | zipcode | isMultutiCounty | county        | plantype | planName                                                   | optionalRider   | planyear |
     # | 000014 | UHC  |   11516 | No              | Nassau County | MA       | UnitedHealthcare Medicare Advantage Patriot (Regional PPO) | Dental Platinum | current  |

    @regressionAARP @nextYear
    Examples: 
      | TID    | site | zipcode | isMultutiCounty | county        | plantype | planName                                                   | optionalRider   | planyear |
#      | 000014 | AARP |   11516 | No              | Nassau County | MA       | UnitedHealthcare Medicare Advantage Patriot (Regional PPO) | Dental Platinum | future   |

    @regressionUHC @nextYear
    Examples: 
      | TID    | site | zipcode | isMultutiCounty | county        | plantype | planName                                                   | optionalRider   | planyear |
#      | 000014 | UHC  |   11516 | No              | Nassau County | MA       | UnitedHealthcare Medicare Advantage Patriot (Regional PPO) | Dental Platinum | future   |

  Scenario Outline: UserStory: <TCID> -plan type: <plantype> - Verify plan details and back to summary and add to compare and uncheck in plan details and verify uncheck in plan summary on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans and "<planIndices>" plans to compare
    And the user navigates to the plan details page
      | Plan Name | <planName> |
    Then click add to compare checkbox on plan details page and navigate to compare page
    Then verify plan compare page is loaded

    @vppPlanDetailsCommon_AARP03 @regressionAARP
    Examples: 
      | TCID   | site | zipcode | isMultutiCounty | county       | plantype | planName                              | planyear | planIndices |
     # | 000015 | AARP |   78006 | YES             | Bexar County | MA       | AARP Medicare Advantage Patriot (HMO) | current  |         1,3 |
     # | 000016 | AARP |   78006 | YES             | Bexar County | PDP      | AARP MedicareRx Walgreens (PDP)       | current  |         1,2 |

    @vppPlanDetailsCommon_UHC03 @regressionUHC
    Examples: 
      | TCID   | site | zipcode | isMultutiCounty | county       | plantype | planName                              | planyear | planIndices |
     # | 000015 | UHC  |   78006 | YES             | Bexar County | MA       | AARP Medicare Advantage Patriot (HMO) | current  |         1,3 |
     # | 000016 | UHC  |   78006 | YES             | Bexar County | PDP      | AARP MedicareRx Walgreens (PDP)       | current  |         1,2 |

    @regressionAARP @nextYear
    Examples: 
      | TCID   | site | zipcode | isMultutiCounty | county       | plantype | planName                              | planyear | planIndices |
      | 000015 | AARP |   78006 | YES             | Bexar County | MA       | AARP Medicare Advantage Patriot (HMO) | future   |         1,3 |
      | 000016 | AARP |   78006 | YES             | Bexar County | PDP      | AARP MedicareRx Walgreens (PDP)       | future   |         1,2 |

    @regressionUHC @nextYear
    Examples: 
      | TCID   | site | zipcode | isMultutiCounty | county       | plantype | planName                              | planyear | planIndices |
      | 000015 | UHC  |   78006 | YES             | Bexar County | MA       | AARP Medicare Advantage Patriot (HMO) | future   |         1,3 |
      | 000016 | UHC  |   78006 | YES             | Bexar County | PDP      | AARP MedicareRx Walgreens (PDP)       | future   |         1,2 |
