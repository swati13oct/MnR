@vppPlanDetailsAARP
Feature: 1.01.2-Vpp to plan Details AARP Scenarios

  @vppPlanDetailsAARP01 @vppPlanDetailsAARPRun01 @vppPlanDetailsAARPRegression
  Scenario Outline: TestCaseID: <TCID> - PDF Type: <pdfType> - Verify specific PDF Plan Documents in Plan Details Page for provided plan
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user validates following PDF link is displayes with correct document code
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |
    Then the user click on PDF link and validates document code in URL
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |

    Examples: 
      | TCID  | zipcode | isMultutiCounty | county      | plantype | planName                                       | pdfType               | docCode                 | planyear |
      | 00001 |   53503 | No              | Iowa County | MAPD     | UnitedHealthcare Medicare Advantage Open (PPO) | Step Therapy Criteria | Step_Therapy_MCORE_2020 | current  |

  @vppPlanDetailsAARP02 @vppPlanDetailsAARPRun01
  Scenario Outline: Plan type: <plantype> - PDF Type: <pdfType> - Verify specific PDF Plan Documents in Plan Details Page for provided plan
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user validates following PDF link is displayes with correct document code
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |
    Then the user validates the document code is present in the PDF
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |

    Examples: 
      | TCID  | zipcode | isMultutiCounty | county         | plantype | planName                                | pdfType         | docCode             | planyear |
      | 00002 |   99210 | No              | Spokane County | MA       | AARP Medicare Advantage Essential (HMO) | Enrollment Form | AAWA20HM4522892_000 | current  |

  @vppPlanDetailsAARP03 @vppPlanDetailsAARPRun01 @vppPlanDetailsAARPRegression
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify Plan costs tab in Plan Details for provided plan
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user click on Plan costs tab and validates in AARP site
      | Monthly Premium | <monthlyPremium> |
      | Yearly Premium  | <yearlyPremium>  |

    Examples: 
      | TID   | zipcode | isMultutiCounty | county         | plantype | planName                                       | monthlyPremium | yearlyPremium | planyear |
      | 15638 |   53503 | No              | Iowa County    | MAPD     | UnitedHealthcare Medicare Advantage Open (PPO) | $47            | $564          | current  |
      | 15640 |   99210 | No              | Spokane County | MA       | AARP Medicare Advantage Essential (HMO)        | $0             | $0            | current  |
      | 15641 |   99210 | No              | Spokane County | SNP      | UnitedHealthcare Dual Complete (HMO D-SNP)     | $25            | $300          | current  |

  @vppPlanDetailsAARP04 @vppPlanDetailsAARPRun01 @vppPlanDetailsAARPRegression
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify Optional Services tab in Plan Details for provided plan
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user click on Optional Services tab and add the rider in AARP site
      | Optional Rider  | <optionalRider>  |
      | Monthly Premium | <monthlyPremium> |
    Then the user click on Plan costs tab and validates in AARP site
      | Monthly Premium | <monthlyPremium> |
      | Yearly Premium  | <yearlyPremium>  |

    Examples: 
      | TID   | zipcode | isMultutiCounty | county        | plantype | planName                                                         | optionalRider   | monthlyPremium | yearlyPremium | planyear |
      | 15658 |   11516 | No              | Nassau County | MA       | UnitedHealthcare Medicare Advantage Essential (Regional PPO)     | Dental Platinum | $0             | $0            | current  |
      | 15662 |   11516 | No              | Nassau County | MAPD     | UnitedHealthcare Medicare Advantage Choice Plan 1 (Regional PPO) | Dental Platinum | $16            | $192          | current  |

  @vppPlanDetailsAARP05 @vppPlanDetailsAARPRun02 @vppPlanDetailsAARPRegression
  Scenario Outline: UserStory: <TCID> -plan type: <plantype> - To click Back to all plans from Top and bottom of the plan deatils page and verify redirection back to the VPP-Summary page AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    #Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then the user view plan details of the above selected plan in AARP site vpp
      | Plan Name | <planName> |
      | Plan Type | <plantype> |
    Then the user clicks on both top and bottom back to plans link and validates its redirection AARP

    Examples: 
      | TCID  | zipcode | isMultiCounty | county             | plantype | planName                                               | planyear |
      | 00004 |   90210 | NO            | Los Angeles County | MA       | AARP Medicare Advantage SecureHorizons Essential (HMO) | current  |

  @vppPlanDetailsAARP06 @vppPlanDetailsAARPRun02 @vppPlanDetailsAARPRegression
  Scenario Outline: <TCID> - Plan type: <plantype> - Verify OLE Landing from VPP Plan Details
    Given the user lands on AARP medicare acquisition site page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user clicks on Enroll Now in Plan Details Page to start the OLE flow
    Then the user validates the Plan details on OLE

    Examples: 
      | TCID  | zipcode | isMultutiCounty | county             | plantype | planName                                                   | planyear |
      | 00005 |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)        | current  |
      | 00006 |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                            | current  |
      | 00007 |   24571 | YES             | Bedford County     | MAPD     | Piedmont Select Medicare Option One (PPO)                  | current  |
      | 00008 |   78006 | YES             | Bexar County       | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) | current  |
#      | 00009 |   78006 | YES             | Bexar County       | SNP      | UnitedHealthcare Medicare Gold (Regional PPO C-SNP)        | current  |

  @vppPlanDetailsAARP07 @vppPlanDetailsAARPRun02 @vppPlanDetailsAARPRegression
  Scenario Outline: UserStory: <TCID> -plan type: <plantype> - Verify Provider Search  in AARP site from Plan Details page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then the user navigates to the plan Details page
      | Plan Name | <planName> |
    Then the user Click on Look up your Provider button
    When user selects a provider and retuns to VPP plan details page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Details page Ulayer

    Examples: 
      | TCID  | zipcode | isMultutiCounty | county       | plantype | planName                                               | planyear |
      | 00010 |   78006 | YES             | Bexar County | MA       | AARP Medicare Advantage SecureHorizons Essential (HMO) | current  |

  @vppPlanDetailsAARP08 @vppPlanDetailsAARPRun03 @vppPlanDetailsAARPRegression
  Scenario Outline: UserStory: <TCID> -plan type: <plantype> -  To Verify the drug cost estimator flow for <plantype> through plan details page's Plan Costs tab
    Given the user is on the AARP medicare site landing page
    When user performs plan search using following information in the AARP site
      | Zip Code    | <zipcode>     |
      | County      | <county>      |
      | aep         | <aep>         |
      | currentyear | <currentyear> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then the user navigates to the plan details for the given plan type in AARP site
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
    Then the user navigates to Plan Costs tab in AARP site
    Then user adds drug to drug cost estimator flow for the given plan name in AARP site
      | PlanName   | <planName>  |
      | Drug Name1 | <drugName1> |
    And selects drug details in ums site
      | Drug Name1 | <drugName1> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    When user successfully adds drug in the ums site
      | Drug Name1 | <drugName1> |
    Then the user clicks on the Pick a pharmacy button in the DCE flow in AARP site
    When the user selects the pharmacy type and distance in AARP site
      | Pharmacy Type | <pharmacyType> |
      | Distance      | <distance>     |
    Then the user selects a pharmacy from the list of pharmacies in AARP site
      | Pharmacy Name | <pharmacyName> |
    Then the user validates the added drugs on See your Estimated Costs page in AARP site
      | Drug Name1 | <drugName1> |
    When the user clicks on Edit Drug List link in AARP site
    Then Enter your drugs page is displayed to the user in AARP site
    Then User click on Switch now to select the Generic of the Brand drug added in AARP site
    Then the user clicks on the Pick a pharmacy button in the DCE flow in AARP site
    Then the user change the pharmacy type and select new pharmacy in AARP site
      | New Pharmacy Type | <newPharmacyType> |
    Then the user validates the added drugs on See your Estimated Costs page in AARP site
      | Drug Name1 | <genericName1> |
    And the user clicks on Back to Plans button on See Your Estimated Costs page in AARP site
    And user verifies annual drug cost in the Plan Cost tab of AARP site
      | Plan Type | <plantype> |
    And the user clicks on Back to All Plans button present on details page in AARP site
    Then user validates Drug information is reflected on plan summary page in AARP site
      | PlanName | <planName> |

    Examples: 
      | TCID  | zipcode | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName                    | plantype | planName                        | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear | planyear |
      | 00011 |   90210 | Los Angeles County | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Preferred Retail | 15 miles | COMMUNITY, A WALGREENS PHARMACY | PDP      | AARP MedicareRx Walgreens (PDP) |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          | current  |

  @vppPlanDetailsAARP09 @vppPlanDetailsAARPRun03 @vppPlanDetailsAARPRegression
  Scenario Outline: UserStory: <TCID> -plan type: <plantype> - Verify Prescription Drug Benefits tab in Plan Details for provided plan
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user click on Prescription Drug Benefits and validates in AARP site

    Examples: 
      | TCID  | zipcode | isMultutiCounty | county             | plantype | planName                                            | planyear |
      | 00013 |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | current  |
      | 00014 |   78006 | YES             | Bexar County       | PDP      | AARP MedicareRx Walgreens (PDP)                     | current  |
      | 00015 |   78006 | YES             | Bexar County       | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP)       | current  |

  @vppPlanDetailsAARP10 @vppPlanDetailsAARPRun03
  Scenario Outline: UserStory: <TCID> -plan type: <plantype> - To verify links displayed in the global footer on plan details page for AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then the user navigates to the plan Details page
      | Plan Name | <planName> |
    And user clicks on Aboutus link from footer of the AARP Medicare Plans home page
    And user clicks on contactus link of aboutus page
    And user clicks on sitemap link of contactus page
    And user clicks on privacypolicy link of sitemap page
    #And user clicks on termsOfuse link of privacypolicy page
    And user clicks on disclaimers link of terms&conditions page
    And user clicks on agents&brokers link of disclaimers page
    #And user clicks on Request Assistance and validates modal window ulayer
    And user verifies home link of agents&brokers page ulayer

    Examples: 
      | TCID  | zipcode | isMultutiCounty | county       | plantype | planName                                               | planyear |
      | 00016 |   78006 | YES             | Bexar County | MA       | AARP Medicare Advantage SecureHorizons Essential (HMO) | current  |

  @vppPlanDetailsAARP11 @vppPlanDetailsAARPRun03 @vppPlanDetailsAARPRegression
  Scenario Outline: UserStory: <TCID> -plan type: <plantype> - Verify plan details and back to summary and add to compare and uncheck in plan details and verify uncheck in plan summary
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then the user navigates to the plan Details page
      | Plan Name | <planName> |
    And the user validates the pdf section
    Then User clicks on Back to Plans link and navigate back to plan summary in AARP site
    Then User click on add to compare checkbox and click on view details link on AARP
    Then I uncheck and go back to the vpp page to validate for AARP

    Examples: 
      | TCID   | zipcode | isMultutiCounty | county       | plantype | planName                                               | planyear |
      | 000017 |   78006 | YES             | Bexar County | MA       | AARP Medicare Advantage SecureHorizons Essential (HMO) | current  |

  @vppPlanDetailsAARP12 @vppPlanDetailsAARPRun03 @vppPlanDetailsAARPRegression
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify <optionalRider> in Plan Details for provided plan and validating Dental Directory link
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user click on Dental Cover Popup he must be able to validate plan defaults in AARP
      | Optional Rider | <optionalRider> |
      | Plan Name      | <planName>      |

    Examples: 
      | TID        | zipcode | isMultutiCounty | county          | plantype | planName                                                         | optionalRider   | planyear |
      | F435191-01 |   11516 | No              | Nassau County   | MA       | UnitedHealthcare Medicare Advantage Essential (Regional PPO)     | Dental Platinum | current  |
      | F435191-02 |   11516 | No              | Nassau County   | MAPD     | UnitedHealthcare Medicare Advantage Choice Plan 1 (Regional PPO) | Dental Platinum | current  |
      | F435191-03 |   78006 | Yes             | Bexar County    | SNP      | UnitedHealthcare Medicare Gold (Regional PPO C-SNP)              | Dental Platinum | current  |
      | F435191-04 |   55343 | No              | Hennepin County | MAPD     | AARP Medicare Advantage Headwaters (PPO)                         |                 | current  |
      | F435191-05 |   55343 | No              | Hennepin County | SNP      | UnitedHealthcare Nursing Home Plan (PPO I-SNP)                   |                 | current  |
      | F435191-06 |   11516 | No              | Nassau County   | MA       | UnitedHealthcare Medicare Advantage Essential (Regional PPO)     |                 | current  |
