@acq_drug_cost_estimator
Feature: 1.10. ACQ-DCE AARP

  @acq_drug_cost_estimator_ulayer_flow @dceUlayerSmoke @vbfGate @DCE_Regression_Ulayer_Home1 @prodRegression
  Scenario Outline: To verify DCE flow from Ulayer home page
    Given the user is on AARP medicare acquisition site landing page
    When I access the acquisition DCE tool from home page
    And I have added a drug to my drug list
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page
    And the user selects the pharmacy tab information like miles, zipcode and pharmacy type
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy
    And I navigate to step3 page and validate for DCE homepage flow
      | Drug | <drug> |
    Then user enters zipcode on step3 and validate plan summary page
      | Zip | <zipcode> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    #Then the user checks for AEP CUrrent year plans link and clicks to view current year plans on AARP
    Then user validates drug cost in medical benefit section in the AARP site
      | Plan Name | <planName> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then user validates drug added on prescription drug benefits tab in AARP
      | Drug | <drug> |

    Examples: 
      | drug    | dosage   | quantity | frequency     | branded | zipcode | plantype | planName                                            | radius   |
      | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | 15 miles |


  @dce @DCE_Regression_Ulayer_Home1 @ulayer
  Scenario Outline: To verify DCE flow from Ulayer home page hover over
    Given the user is on AARP medicare acquisition site landing page
    When I click on Drug Cost Estimator link from Shop for a plan hover over for AARP site
    And I have added a drug to my drug list
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page
    And the user selects the pharmacy tab information like miles, zipcode and pharmacy type
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy
    And I navigate to step3 page and validate for DCE homepage flow
      | Drug | <drug> |
    Then user enters zipcode on step3 and validate plan summary page
      | Zip | <zipcode> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then user validates drug cost in medical benefit section in the AARP site
      | Plan Name | <planName> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then user validates drug added on prescription drug benefits tab in AARP
      | Drug | <drug> |

    #Test Id V1.0: 15615
    Examples: 
      | drug    | dosage   | quantity | frequency     | branded | zipcode | plantype | planName                                           | radius   |
      | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO) | 15 miles |

  @switchNowStep3 @dceVBF @DCE_Regression_Ulayer_VPP1_1 @prodRegression
  Scenario Outline: To test the DCE flow from vpp and the switch now option in step 3
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And I access the DCE tool on aarp site
      | Plan Type | <plantype> |
    And I have added a drug to my drug list
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page
    And I select the first pharmacy
    And I navigate to step3 page and validate
      | Drug | <drug> |
    Then I switch to generic drug and validate
    And the user clicks on return link to navigate to plan summary

    Examples: 
      | zipcode | drug    | dosage   | plantype | county | isMultutiCounty | quantity | frequency     | branded |
      |   90210 | Lipitor | TAB 10MG | MA       | none   | no              |       30 | Every 1 month | yes     |

  @defect3235 @DCE_Regression_Ulayer_VPP1_2 @prodRegression
  Scenario Outline: To go through dce flow from prescription drugs tab and verify right message when clicked on add to compare
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And I go to the view plan details page and access DCE flow from prescription drugs tab
      | Plan Name | <planname> |
      | Plan Type | <plantype> |
    And I have added a drug to my drug list
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Dosage    | <dosage>    |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page
    And I select the first pharmacy
    Then I navigate back to plan details page and verify correct message shows when clicked on compare check box

    Examples: 
      | zipcode | drug    | dosage   | planname                                             | plantype | county | isMultutiCounty | quantity | frequency     | branded |
      |   33021 | Lipitor | TAB 10MG | AARP Medicare Advantage Choice Plan 2 (Regional PPO) | MA       | none   | no              |       30 | Every 1 month | yes     |


  @dceThroughPlanDetailsAARP @aarp @DCE_Regression_Ulayer_VPP1_3 @dce3 @aarpDce
  Scenario Outline: To Verify the drug cost estimator flow for <plantype> through plan details page's Plan Costs tab
    Given the user is on the AARP medicare site landing page
    When user performs plan search using following information in the AARP site
      | Zip Code    | <zipcode>     |
      | County      | <county>      |
      | aep         | <aep>         |
      | currentyear | <currentyear> |
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
      | zipcode | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName                    | plantype | planName                        | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear |
      |   90210 | Los Angeles County | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Preferred Retail | 15 miles | COMMUNITY, A WALGREENS PHARMACY | PDP      | AARP MedicareRx Walgreens (PDP) |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          |

######################### End of Regression ATDDs #############################
        @dceMousehoverOurPlans @aprilRelease2018 @regressiontestcase-ATDDtags
  Scenario Outline: To Mousehover on Our Plans tab from the DCE Page
    Given the user is on AARP medicare acquisition site landing page
    When I access the acquisition DCE tool from home page
    And I hover or click on Our Plans in the top navigation and enter zipcode Ulayer
      | Zip Code | <zipcode> |
    Then I should be directed to the VPP Plan Summary Page Ulayer and I should see the Plan Count Overlay populated appropriately

    Examples: 
      | zipcode |
      |   90210 |

  #| 30210   |
  #| 10002   |
  @dcePerformanceUlayer
  Scenario Outline: To go to DCE flow from Home page
    Given the user is on AARP medicare acquisition site landing page
    When I access the acquisition DCE tool from home page
    And I have added a drug to my drug list
      | Drug | <drug> |
    And user selects drug details
      | Drug      | <drug>      |
      | Quantity  | <quantity>  |
      | Frequency | <frequency> |
    When user successfully adds drug
      | Is Branded Drug | <branded> |
      | Drug            | <drug>    |
    And I navigate to step2 page
    And the user selects the pharmacy tab information like miles, zipcode and pharmacy type
      | Zipcode | <zipcode> |
      | Radius  | <radius>  |
    And I select the first pharmacy

    Examples: 
      | drug             | quantity | frequency     | branded | zipcode | radius   |
      | Lipitor TAB 10MG |       30 | Every 1 month | yes     |   90210 | 15 miles |
      