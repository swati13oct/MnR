@dce @dce_Redesign_VPP_PlanSummary
Feature: 1.10.2 ACQ-DCERedesign-VPP_PlanSummary AARP - To test VPP Plan Details - DCE Flows in AARP site

  @dce_Redesign_VPP_PlanSummary_Plan
  Scenario Outline: 1.10.2.1 To test the DCE Redesign flow for PlanType :  <plantype> from vpp Plan Summary
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I access the DCE Redesign from Plan Summary for mentioned plan
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user validates planName matches plan Name in VPP
    Then the user Captures Drug costs on Drug Details Page
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates Important information section
    #Then the user validates Disclaimers section
    Then the user validates link to Drug Summary Page

    @dce_Redesign_VPP_PlanSummary_MAPD_AARP @regressionAARP
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1   | planname                                           |
      | AARP |   90210 | MAPD     | future   | none   | no              | Orkambi | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @dce_Redesign_VPP_PlanSummary_MAPD_UHC @regressionUHC
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1   | planname                                           |
      | UHC  |   90210 | MAPD     | future   | none   | no              | Orkambi | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @dce_Redesign_VPP_PlanSummary_PDP_AARP @regressionAARP
    Examples: 
      | site | zipcode | plantype | planyear	|	county       | isMultutiCounty | drug1   | planname                        |
      | AARP |   80002 | PDP      | future		|	Adams County | yes             | Orkambi | AARP MedicareRx Walgreens (PDP) |

    @dce_Redesign_VPP_PlanSummary_PDP_UHC @regressionUHC
    Examples: 
      | site | zipcode | plantype |	planyear	| county       | isMultutiCounty | drug1   | planname                        |
      | UHC  |   80002 | PDP      | future		|	Adams County | yes             | Orkambi | AARP MedicareRx Walgreens (PDP) |

    @dce_Redesign_VPP_PlanSummary_SNP_AARP @prodRegression_AARP @regressionAARP
    Examples: 
      | site | zipcode | plantype | planyear	|	county       | isMultutiCounty | drug1   | planname                                  |
      | AARP |   78006 | SNP      | future		|	Bexar County | yes             | Orkambi |  UnitedHealthcare Dual Complete (HMO D-SNP) |

    @dce_Redesign_VPP_PlanSummary_SNP_UHC @prodRegression_UHC @prodRegression @regressionUHC
    Examples: 
      | site | zipcode | plantype |	planyear	| county       | isMultutiCounty | drug1   | planname                                    |
      | UHC  |   78006 | SNP      | future		|	Bexar County | yes             | Orkambi |  UnitedHealthcare Dual Complete (HMO D-SNP) |

  @dceRedesingDrugSummarytoVPPdetail @470713
  Scenario Outline: Test to Verify that user navigates to vpp detail page from drug summary page to validate drug cost estimator and view plan summary
    Given the user is on the AARP medicare site landing page
    When I access the acquisition DCE tool from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page in AARP
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP
    And user should be able to see Medicare Advantage plan by default
    And user click on view plan details on drug summary page
    Then the user verify the drug cost estimator and view plan summary on VPP summary page in AARP
    Then the user click on drug cost estimator on vpp plan summary page in AARP

    #Then User validates planName matches plan Name in DCE summary page in AARP
    @dceRedesingDrugSummarytoVPPdetail_MAPD
    Examples: 
      | zipCode | plantype | county | isMultutiCounty | drug1   | planname                                           |
      |   10001 | MAPD     | none   | no              | Orkambi | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @dceRedesingDrugSummarytoVPPdetail_PDP
    Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                        |
      |   80002 | PDP      | Adams County | yes             | Orkambi | AARP MedicareRx Walgreens (PDP) |

    @dceRedesingDrugSummarytoVPPdetail_SNP
    Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                                              |
      |   78006 | SNP      | Bexar County | yes             | Orkambi | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) |

  @vvpSummarytoVppDetail
  Scenario Outline: Test to verify the Drug cost estimator and view plan summary are not visible when user navigate away from DCE and navigate to VPP detail page
    Given the user is on the AARP medicare site landing page
    When I access the acquisition DCE tool from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP in AARP
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    #And user selects plan year in AARP
    And user clicks on continue button in Zip Entry Page in AARP
    #Then load screen should be displayed in AARP
    And user should be navigated to Review drug cost estimate page in AARP
    And user should be able to see Medicare Advantage plan by default
    And user click on view plan details on drug summary page
    Then the user verify the drug cost estimator and view plan summary on VPP summary page in AARPs
    Then the user click on view plan summary on vpp detail page in AARP
    Then user click on veiw plan details on summary page in AARP

    @vvpSummarytoVppDetail_MAPD
    Examples: 
      | zipCode | plantype | county | isMultutiCounty | drug1   | planname                                           |
      |   10001 | MAPD     | none   | no              | Orkambi | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @vvpSummarytoVppDetail_PDP
    Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                        |
      |   80002 | PDP      | Adams County | yes             | Orkambi | AARP MedicareRx Walgreens (PDP) |

    @vvpSummarytoVppDetail_SNP
    Examples: 
      | zipcode | plantype | county       | isMultutiCounty | drug1   | planname                                              |
      |   78006 | SNP      | Bexar County | yes             | Orkambi | UnitedHealthcare Medicare Silver (Regional PPO C-SNP) |

  @dceSavePlanDifferentZipcode @F519020
  Scenario Outline: Test to Verify the Plan saved correctly in visitor profile through differnt zipcodes
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type and select Next year
      | Plan Type | <plantype> |
    And user saves below plan
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    And I access the DCE Redesign from Plan Summary for mentioned plan
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user validates planName matches plan Name in VPP
    Then the user click on return to plan summary on DCE summary page
    And user updates the new zipcode on vpp summary page
      | New Zip Code | <newzipcode> |
    And user navigate to Drug Summary page
    Then user save the plan on drug detail page
    When the user navigate to Visitor profile page
    And user validates the plans on new visitor profile page of AARP site
      | Test Plans | <mapdtestPlans> |

  @dceSavePlanDifferentZipcode_AARP
    Examples:
      | site | zipcode | plantype | county | isMultutiCounty | drug1   | planname                                           | mapdtestPlans                        | newzipcode |
      | AARP |   90210 | MAPD     | none   | no              | Orkambi | AARP Medicare Advantage SecureHorizons Focus (HMO) | AARP Medicare Advantage Plan 1 (HMO) |      10001 |

  @dceSavePlanDifferentZipcode_UHC
    Examples: 
      | site | zipcode | plantype | county | isMultutiCounty | drug1   | planname                                           | mapdtestPlans                        | newzipcode |
      | UHC  |   90210 | MAPD     | none   | no              | Orkambi | AARP Medicare Advantage SecureHorizons Focus (HMO) | AARP Medicare Advantage Plan 1 (HMO) |      10001 |

  @drugSummary_InitialZipCodeRetained @F539025
  Scenario Outline: To verify intial zipcode infomraiton retained while navigating to DCE from VPP summary
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When I click on DCE Redesign link from Shop for a plan hover over
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs button to Land on Drug Summary Page

    @F539025AARP
    Examples: 
      | site | zipcode | county | isMultutiCounty | drug1   |
      | AARP |   90210 | none   | no              | Orkambi |

    @F539025UHC
    Examples: 
      | site | zipcode | county | isMultutiCounty | drug1   |
      | UHC  |   90210 | none   | no              | Orkambi |

  @drugSummary_InitialZipCodeRetained @F539025
  Scenario Outline: To verify zipcode infomraiton retained when plans are saved and zip code updated while navigating from VPP summary to DCE
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then user saves two plans as favorite
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then user gets a create profile prompt
    Then user click on view saved plans button
    And user validates the added plans on new visitor profile page
      | Test Plans | <testPlans> |
    And the user clicks on the add drugs button to navigate to DCE Redesign on the profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs button to Land on Drug Summary Page
    Then user should be able to see Return to profile link on summary page
    And Back to profile button should be displayed for each plan card
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
    Then user should be able to see Return to profile link on details page
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    Then the user validates planName matches plan Name in VPP
    Then the user click on view plan summary on vpp detail page
    And user updates the new zipcode on vpp summary page
      | New Zip Code | <newzipcode> |
    Then user saves two plans as favorite
      | Plan Type  | <plantype>   |
      | Test Plans | <testPlans1> |
    Then user gets a create profile prompt
    Then user click on view saved plans button
    And user validates the added plans on new visitor profile page
      | Test Plans | <testPlans1> |
    When user clicks on Edit Drug and Pharmacy on visitor profile page
    Then user should be navigated to build drug list page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user clicks on Review Drug Costs button to Land on Drug Summary Page
    Then user should be able to see Return to profile link on summary page
    And Back to profile button should be displayed for each plan card

    @F539025AARP
    Examples: 
      | site | drug1   | drug2  | plantype | planyear | zipcode | testPlans                                                                | newzipcode | isMultiCounty | county          | planName                            | testPlans1                                                                                        |
      | AARP | Orkambi | Fanapt | MAPD     | next     |   10001 | AARP Medicare Advantage Prime (HMO),AARP Medicare Advantage Plan 1 (HMO) |      90210 | NO            | New York County | AARP Medicare Advantage Prime (HMO) | AARP Medicare Advantage Freedom Plus (HMO-POS),AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @F539025UHC
    Examples: 
      | site | drug1   | drug2  | plantype | planyear | zipcode | testPlans                                                                | newzipcode | isMultiCounty | county          | planName                            | testPlans1                                                                                        |
      | UHC  | Orkambi | Fanapt | MAPD     | next     |   10001 | AARP Medicare Advantage Prime (HMO),AARP Medicare Advantage Plan 1 (HMO) |      90210 | NO            | New York County | AARP Medicare Advantage Prime (HMO) | AARP Medicare Advantage Freedom Plus (HMO-POS),AARP Medicare Advantage SecureHorizons Focus (HMO) |

  @drugSummary_ZipCodeRetainedDCENBAFlow @F539025
  Scenario Outline: To verify zipcode infomraiton retained when plans are saved while navigating from VPP summary through Get Started NBA
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And user Verify and click perform on Next Best Action Modal for Get Started
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button to land on drug summary page
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user saves two plans as favorite
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then user gets a create profile prompt
    Then user click on view saved plans button
    And user validates the added plans on new visitor profile page
      | Test Plans | <testPlans> |
    When user clicks on Edit Drug and Pharmacy on visitor profile page
    Then user should be navigated to build drug list page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user clicks on Review Drug Costs button to Land on Drug Summary Page

    @F539025AARP0
    Examples: 
      | site | drug1   | drug2  | plantype | planyear | testPlans                                                                | zipcode | isMultiCounty | county          |
      | AARP | Orkambi | Fanapt | MAPD     | next     | AARP Medicare Advantage Prime (HMO),AARP Medicare Advantage Plan 1 (HMO) |   10001 | NO            | New York County |

    @F539025UHC
    Examples: 
      | site | drug1   | drug2  | plantype | planyear | testPlans                                                                | zipcode | isMultiCounty | county          |
      | UHC  | Orkambi | Fanapt | MAPD     | next     | AARP Medicare Advantage Prime (HMO),AARP Medicare Advantage Plan 1 (HMO) |   10001 | NO            | New York County |

  Scenario Outline: To verify zipcode infomraiton retained while navigating to shop pages from VPP summary
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the user navigates to Shop plans for PDP Page and clicks on DCE link fto land on DCE Redesign
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs button to Land on Drug Summary Page
    Then user should be able to see "Medicare Prescription Drug Plans" by default

    @F549665
    Examples: 
      | site | zipcode | county | isMultutiCounty | drug1   |
      | AARP |   90210 | none   | no              | Orkambi |

    @F549665
    Examples: 
      | site | zipcode | county | isMultutiCounty | drug1   |
      | UHC  |   90210 | none   | no              | Orkambi |
