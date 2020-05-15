@vppPlanDetailsUHC
Feature: Vpp to plan Details UHC Scenarios

  @vppPlanDetailsUHC01 @vppPlanDetailsUHCRun01 @vppPlanDetailsUHCRegression
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify specific PDF Plan Documents in Plan Details Page for provided plan
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
    Then the user validates following PDF link is displayes with correct document code for UHC
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |
    Then the user click on PDF link and validates document code in URL for UHC
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |

    Examples: 
      | TID   | zipcode | isMultutiCounty | county      | plantype | planName                                       | pdfType               | docCode                 |
      | 00001 |   53503 | No              | Iowa County | MAPD     | UnitedHealthcare Medicare Advantage Open (PPO) | Step Therapy Criteria | Step_Therapy_MCORE_2020 |

  @vppPlanDetailsUHC02 @vppPlanDetailsUHCRun01
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify specific PDF Plan Documents in Plan Details Page for provided plan
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
    Then the user validates following PDF link is displayes with correct document code for UHC
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |
    Then the user validates the document code is present in the PDF for UHC
      | PDF type     | <pdfType> |
      | DocumentCode | <docCode> |

    Examples: 
      | TID   | zipcode | isMultutiCounty | county         | plantype | planName                                | pdfType         | docCode             |
      | 00002 |   99210 | No              | Spokane County | MA       | AARP Medicare Advantage Essential (HMO) | Enrollment Form | AAWA20HM4522892_000 |

  @vppPlanDetailsUHC03 @vppPlanDetailsUHCRun01 @vppPlanDetailsUHCRegression
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

  @vppPlanDetailsUHC04 @vppPlanDetailsUHCRun01 @vppPlanDetailsUHCRegression
  Scenario Outline: UserStory: <TID> -plan type: <plantype> - Verify Optional Services tab in Plan Details for provided plan
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
      | TID   | zipcode | isMultutiCounty | county        | plantype | planName                                                         | optionalRider   | monthlyPremium | yearlyPremium |
      | 15658 |   11516 | No              | Nassau County | MA       | UnitedHealthcare Medicare Advantage Essential (Regional PPO)     | Dental Platinum | $0             | $0            |
      | 15662 |   11516 | No              | Nassau County | MAPD     | UnitedHealthcare Medicare Advantage Choice Plan 1 (Regional PPO) | Dental Platinum | $16            | $192          |

  @vppPlanDetailsUHC05 @vppPlanDetailsUHCRun02 @vppPlanDetailsUHCRegression
  Scenario Outline: TCID - <TID> - plan Type: <plantype> - TO click Back to all plans from Top and bottom of the page and verify redirection back to the VPP-Summary page UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    And the user view plan details of the above selected plan in UMS site vpp
      | Plan Name | <planName> |
    Then the user clicks on both top and bottom back to plans link and validates its redirection

    Examples: 
      | TID   | zipcode | planName                                             | plantype |
      | 00003 |   33012 | AARP Medicare Advantage Choice Plan 2 (Regional PPO) | MAPD     |

  @vppPlanDetailsUHC06 @vppPlanDetailsUHCRun02 @vppPlanDetailsUHCRegression
  Scenario Outline: TCID - <TID> - plan Type: <plantype> - OLE Landing from UHC Acquisition site VPP Plan Details
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in UMS site vpp
      | Plan Name | <planName> |
    Then the user clicks on Enroll Now in Plan Details Page to start the OLE flow
    Then the user validates the Plan details on OLE

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype | planName                                                   |
      | 00004 |   90210 | NO              | Los Angeles County | MA       | AARP Medicare Advantage SecureHorizons Essential (HMO)     |
      | 00005 |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                            |
      | 00006 |   24571 | YES             | Bedford County     | MAPD     | Piedmont Select Medicare Option One (PPO)                  |
      | 00007 |   78006 | YES             | Bexar County       | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO D-SNP) |
      | 00008 |   78006 | YES             | Bexar County       | SNP      | UnitedHealthcare Medicare Gold (Regional PPO C-SNP)        |

  @vppPlanDetailsUHC07 @vppPlanDetailsUHCRun02 @vppPlanDetailsUHCRegression
  Scenario Outline: TCID - <TID> - plan Type: <plantype> - Verify Provider Search  in UHC site from Plan Details page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    Then the user Click on Look up your Provider button in UMS site
    When user selects a provider and retuns to VPP plan details page in blayer
    Then Verify X out of Y provider covered information is displayed on Plan Details page blayer

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype | planName                                               |
      | 00009 |   90210 | NO              | Los Angeles County | MA       | AARP Medicare Advantage SecureHorizons Essential (HMO) |

  @vppPlanDetailsUHC08 @vppPlanDetailsUHCRun03 @vppPlanDetailsUHCRegression
  Scenario Outline: TCID - <TID> - plan Type: <plantype> - To Verify the drug cost estimator flow for <plantype> through plan details page's Plan Costs tab
    Given user is on blue layer landing page
    When user performs plan search using following information in the UMS site
      | Zip Code    | <zipcode>     |
      | County      | <county>      |
      | aep         | <aep>         |
      | currentyear | <currentyear> |
    Then the user navigates to the plan details for the given plan type in UMS site
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
    Then the user navigates to Presciption Drug Benefits tab in UMS site
    And I verify the plan name in UMS site
      | PlanName | <planName> |
    Then user adds drug to drug cost estimator flow for the given plan name in UMS site
      | PlanName   | <planName>  |
      | Drug Name1 | <drugName1> |
    And selects drug details in UMS site
      | Drug Name1 | <drugName1> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    When user successfully adds drug in the UMS site
      | Drug Name1 | <drugName1> |
    Then user adds drug to drug cost estimator flow for the given plan name in UMS site
      | PlanName   | <planName>  |
      | Drug Name2 | <drugName2> |
    And selects drug details for other drugs in UMS site
      | Drug Name2 | <drugName2> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    Then user adds drug to drug cost estimator flow for the given plan name in UMS site
      | PlanName   | <planName>  |
      | Drug Name3 | <drugName3> |
    And selects drug details in UMS site
      | Drug Name3 | <drugName3> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    When user successfully adds drug in the UMS site
      | Drug Name3 | <drugName3> |
    Then the user clicks on the Pick a pharmacy button in the DCE flow in UMS site
    When the user selects the pharmacy type and distance in UMS site
      | Pharmacy Type | <pharmacyType> |
      | Distance      | <distance>     |
    Then the user selects a pharmacy from the list of pharmacies in UMS site
      | Pharmacy Name | <pharmacyName> |
    Then the user validates the added drugs on See your Estimated Costs page in UMS site
      | Drug Name1 | <drugName1> |
      | Drug Name2 | <drugName2> |
      | Drug Name3 | <drugName3> |
    When the user clicks on Edit Drug List link in UMS site
    Then Enter your drugs page is displayed to the user in UMS site
    Then User click on Switch now to select the Generic of the Brand drug added in UMS site
    Then the user clicks on the Pick a pharmacy button in the DCE flow in UMS site
    Then the user change the pharmacy type and select new pharmacy in UMS site
      | New Pharmacy Type | <newPharmacyType> |
    Then the user validates the added drugs on See your Estimated Costs page in UMS site
      | Drug Name1 | <genericName1> |
      | Drug Name2 | <drugName2>    |
      | Drug Name3 | <genricName3>  |
    And the user clicks on Back to Plans button on See Your Estimated Costs page in UMS site
    And user verifies annual drug cost in the prescription drug tab of UMS site
      | Plan Type | <plantype> |
    And the user clicks on Back to All Plans button present on details page in UMS site
    Then user validates Drug information is reflected on plan summary page in UMS site
      | PlanName | <planName> |

    Examples: 
      | zipcode | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName | plantype | planName                                           | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear |
      |   90002 | Los Angeles County | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Standard Network | 15 miles | CVS PHARMACY | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO) |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          |

  @vppPlanDetailsUHC09 @vppPlanDetailsUHCRun03 @vppPlanDetailsUHCRegression
  Scenario Outline: TCID - <TID> - plan Type: <plantype> - Verify Prescription Drug Benefits tab in Plan Details for provided plan
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
    Then the user click on Prescription Drug Benefits and validates in UHC site

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype | planName                                            |
      | 00011 |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |
      | 00012 |   78006 | YES             | Bexar County       | PDP      | AARP MedicareRx Walgreens (PDP)                     |
      | 00013 |   78006 | YES             | Bexar County       | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP)       |

  @vppPlanDetailsUHC10 @vppPlanDetailsUHCRun03
  Scenario Outline: TCID - <TCID> - plan Type: <plantype> - To verify links displayed in Global footer section on plan details page in UMS site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    And the user clicks on Aboutus link from home page footer UHC Medicaresolutions Site
    And the user clicks on Contactus link from about us page footer UHC Medicaresolutions Site
    And the user clicks on Sitemap link from home page footer UHC Medicaresolutions Site
    And the user clicks on Privacy Policy link from Contactus page footer UHC Medicaresolutions Site
    #And the user clicks on Terms of use link from Privacy Policy page footer UHC Medicaresolutions Site
    And the user clicks on Disclaimers link from Terms of use page footer UHC Medicaresolutions Site
    #And the user clicks on Agents & Brokers link from Disclaimers page footer UHC Medicaresolutions Site
    #And user clicks on Request Assistance and validates modal window bluelayer
    And user verifies home link of agents&brokers page bluelayer

    Examples: 
      | TID   | zipcode | isMultutiCounty | county       | plantype | planName                                            |
      | 00014 |   80002 | YES             | Adams County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |

  @vppPlanDetailsUHC11 @vppPlanDetailsUHCRun03 @vppPlanDetailsUHCRegression
  Scenario Outline: TCID - <TID> - plan Type: <plantype> - Verify plan details and back to summary and add to compare and uncheck in plan details and verify uncheck in plan summary
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
      | TID   | zipcode | isMultutiCounty | county       | plantype | planName                                            |
      | 00015 |   80002 | YES             | Adams County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |
