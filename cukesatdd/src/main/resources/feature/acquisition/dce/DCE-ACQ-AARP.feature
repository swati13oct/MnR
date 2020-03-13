@acq_dce_AARP
Feature: 1.10.1 ACQ-DCE AARP - To test Acq Home to DCE Flows

  @acq_drug_cost_estimator_ulayer_flow @dceUlayerSmoke @vbfGate @DCE_Regression_Ulayer_Home1 @prodRegression
  Scenario Outline: 1.10.11 To verify DCE flow from Ulayer home page
    Given the user is on the AARP medicare site landing page
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
      | Zipcode | <zipcode> |
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
  Scenario Outline: 1.10.12 To verify DCE flow from Ulayer home page hover over
    Given the user is on the AARP medicare site landing page
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
      | County |<county> |
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
      | drug    | dosage   | quantity | frequency     | branded | zipcode | county |plantype | planName                                          | radius   |
      | Lipitor | TAB 10MG |       30 | Every 1 month | yes     |   31042 | Laurens County |SNP      | UnitedHealthcare Medicare Gold (Regional PPO C-SNP) | 15 miles |

 
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
