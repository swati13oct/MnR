@vppNBAValidations_unauthenticatedUser @nextBestAction @vpp
Feature: ACQ-Next Action Modal on vpp flow for unauthenticated flow
	
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for MAPD Plan when no Drug cost/provider is added in <site> site
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
    Then user should be able to see the NBA modal to add drugs on the VPP summary page
    When user clicks on get started button on NBA
    Then user should be navigated to first step of DCE Page

    @NBA_MAPD_AARP01  
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear |
      | AARP |   19019 | No              | Iowa County | MAPD     | next     |

    @NBA_MAPD_UHC01 @sanity
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear |
      | UHC  |   19019 | No              | Iowa County | MAPD     | next     |
	
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for MAPD Plan when Drug cost exists in <site> site
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
    Then user should be able to see the NBA modal to add drugs on the VPP summary page
    When user clicks on get started button on NBA
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user be able to see the Find a Provider NBA on VPP
    When user clicks on Find a Provider button on NBA
    Then user should be redirected to Provider search Rally page

    @NBA_MAPD_AARP01  
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | drug1   |
      | AARP |   19019 | No              | Iowa County | MAPD     | next     | Lipitor |

    @NBA_MAPD_UHC01 @sanity
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | drug1   |
      | UHC  |   19019 | No              | Iowa County | MAPD     | next     | Lipitor |

  Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal on VPP summary page for MAPD plan when Drug and Provider exists in <site> site
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
    Then user should be able to see the NBA modal to add drugs on the VPP summary page
    When user clicks on get started button on NBA
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user be able to see the Find a Provider NBA on VPP
    When user clicks on Find a Provider button on NBA
    When user selects a provider and retuns to VPP page
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page

    @NBA_MAPD_AARP01 @NBA_MAPD_Sanity_AARP @prodRegression @regressionAARP @sanity
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | drug1   |
      | AARP |   19019 | No              | Iowa County | MAPD     | next     | Lipitor |

    @NBA_MAPD_UHC01 @regressionUHC
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | drug1   |
      | UHC  |   19019 | No              | Iowa County | MAPD     | next     | Lipitor |

  Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Provider search on VPP summary page for MAPD Plan when drug added from DCE
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipcode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see Medicare Advantage plan by default
    When user clicks view drug cost button
    Then the user clicks VPP Plan Details button from Drug Details Page
    Then the user click on view plan summary button on vpp detail page
    Then user be able to see the Find a Provider NBA on VPP
    When user clicks on Find a Provider button on NBA
    Then user should be redirected to Provider search Rally page

    @NBA_MAPD_AARP02 @regressionAARP
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | drug1   |
      | AARP |   19019 | No              | Iowa County | MAPD     | next     | Lipitor |

    @NBA_MAPD_UHC02 @regressionUHC @prodRegression
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | drug1   |
      | UHC  |   19019 | No              | Iowa County | MAPD     | next     | Lipitor |

  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for MAPD plan when Provider exists
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
    When the user Click on Is my Provider covered link
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page
    Then user should be able to see the NBA modal to add drugs on the VPP summary page
    When user clicks on get started button on NBA
    Then user should be navigated to first step of DCE Page

    @NBA_MAPD_AARP02 @regressionAARP
    Examples: 
      | site | zipcode | isMultutiCounty | county          | plantype | planyear | drug1   | planname                             |
      | AARP |   10001 | No              | New York County | MAPD     | next     | Lipitor | AARP Medicare Advantage Plan 2 (HMO) |

    @NBA_MAPD_UHC02 @regressionUHC
    Examples: 
      | site | zipcode | isMultutiCounty | county          | plantype | planyear | drug1   | planname                             |
      | UHC  |   10001 | No              | New York County | MAPD     | next     | Lipitor | AARP Medicare Advantage Plan 2 (HMO) |

  Scenario Outline: Test to verify the Select Plan for Enroll Modal when user clicks on "Enroll in Plan" button and when plans are saved for MAPD plan type
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
    Then user saves plan as favorite on vpp summary page
      | Test Plans | <testPlans> |
    Then user should be able to see the NBA modal to add drugs on the VPP summary page
    When user clicks on get started button on NBA
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user should be able to see the NBA modal to add providers on the VPP summary page
    When user clicks on Find My Doctor button
    When user selects a provider and retuns to VPP page
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    When user clicks on Select a plan button on NBA
    Then user should be able to see the Select Plan for Enroll Modal with saved plans
      | Test Plans | <testPlans> |
    When user clicks on Enroll in plan button on the select plan modal on vpp summary page
    Then user should be navigated to OLE page

    @NBA_MAPD_AARP02 @regressionAARP
    Examples: 
      | site | zipcode | isMultutiCounty | county          | plantype | planyear | drug1   | testPlans                            |
      | AARP |   10001 | No              | New York County | MAPD     | next     | Lipitor | AARP Medicare Advantage Plan 2 (HMO) |

    @NBA_MAPD_UHC02 @regressionUHC
    Examples: 
      | site | zipcode | isMultutiCounty | county          | plantype | planyear | drug1   | testPlans                            |
      | UHC  |   10001 | No              | New York County | MAPD     | next     | Lipitor | AARP Medicare Advantage Plan 2 (HMO) |

  Scenario Outline: Test to verify the Select Plan for Enroll Modal when user clicks on "Enroll in Plan" button and when no plans are saved for MAPD plan type
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
    Then user should be able to see the NBA modal to add drugs on the VPP summary page
    When user clicks on get started button on NBA
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user should be able to see the NBA modal to add providers on the VPP summary page
    When user clicks on Find My Doctor button
    When user selects a provider and retuns to VPP page
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    When user clicks on Select a plan button on NBA
    Then user should be able to see the Select Plan for Enroll Modal with all plans on vpp summary page
    When user clicks on Enroll in plan button on the select plan modal on vpp summary page
    Then user should be navigated to OLE page

    @NBA_MAPD_AARP01 @regressionAARP
    Examples: 
      | site | zipcode | isMultutiCounty | county          | plantype | planyear | drug1   |
      | AARP |   10001 | No              | New York County | MAPD     | next     | Lipitor |

    @NBA_MAPD_UHC01 @NBA_MAPD_Sanity_UHC @prodRegression @regressionUHC
    Examples: 
      | site | zipcode | isMultutiCounty | county          | plantype | planyear | drug1   |
      | UHC  |   10001 | No              | New York County | MAPD     | next     | Lipitor |

  Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when user adds Drug cost from MAPD page
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
    Then user should be able to see the NBA modal to add drugs on the VPP summary page
    When user clicks on get started button on NBA
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user should be able to see the NBA modal to add providers on the VPP summary page
    And the user views the plans of the below plan type
      | Plan Type | <plantype1> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page

    @NBA_MAPD_AARP02 @NBA_MAPD_Sanity_AARP_01 @prodRegression @regressionAARP
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | plantype1 | drug1   | planyear |
      | AARP |   19019 | No              | Iowa County | MAPD     | PDP       | Lipitor | next     |

    @NBA_MAPD_UHC02 @regressionUHC
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | plantype1 | drug1   | planyear |
      | UHC  |   19019 | No              | Iowa County | MAPD     | PDP       | Lipitor | next     |

  ################################################## PDP  Plan type #########################################################
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for PDP Plan when no Drug cost/provider is added
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
    Then user should be able to see the NBA modal to add drugs on the VPP summary page
    When user clicks on get started button on NBA
    Then user should be navigated to first step of DCE Page

    @NBA_PDP_AARP01 
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear |
      | AARP |   19019 | No              | Iowa County | PDP      | next     |

    @NBA_PDP_UHC01 
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear |
      | UHC  |   19019 | No              | Iowa County | PDP      | next     |

  Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal on VPP summary page for PDP plan when Drug exists
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
    Then user should be able to see the NBA modal to add drugs on the VPP summary page
    When user clicks on get started button on NBA
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page

    @NBA_PDP_AARP01 @regressionAARP @sanity
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | drug1   |
      | AARP |   19019 | No              | Iowa County | PDP      | next     | Lipitor |

    @NBA_PDP_UHC01 @regressionUHC
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | drug1   |
      | UHC  |   19019 | No              | Iowa County | PDP      | next     | Lipitor |

  Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for enrollment on VPP summary page for PDP Plan when drug added from DCE
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipcode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see "Medicare Advantage Plans" by default
    When user clicks view drug cost button
    And the user clicks VPP Plan Details button from Drug Details Page
    And the user click on view plan summary button on vpp detail page
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page

    @NBA_PDP_AARP01 @NBA_PDP_Sanity_AARP @prodRegression @regressionAARP
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | drug1   |
      | AARP |   19019 | No              | Iowa County | PDP      | next     | Lipitor |

    @NBA_PDP_UHC01 @NBA_PDP_Sanity_UHC @regressionUHC
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | drug1   |
      | UHC  |   19019 | No              | Iowa County | PDP      | next     | Lipitor |

  Scenario Outline: Test to verify the Select Plan for Enroll Modal when user clicks on "Enroll in Plan" button and when plans are saved for PDP plan type
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
    Then user saves plan as favorite on vpp summary page
      | Test Plans | <testPlans> |
    Then user should be able to see the NBA modal to add drugs on the VPP summary page
    When user clicks on get started button on NBA
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    When user clicks on Select a plan button on NBA
    Then user should be able to see the Select Plan for Enroll Modal with saved plans
      | Test Plans | <testPlans> |
    When user clicks on Enroll in plan button on the select plan modal on vpp summary page
    Then user should be navigated to OLE page

    @NBA_PDP_AARP02 @NBA_PDP_Sanity_AARP @regressionAARP
    Examples: 
      | site | zipcode | isMultutiCounty | county          | plantype | planyear | drug1   | testPlans                       |
      | AARP |   10001 | No              | New York County | PDP      | next     | Lipitor | AARP MedicareRx Walgreens (PDP) |

    @NBA_PDP_UHC02 @NBA_PDP_Sanity_UHC @prodRegression @regressionUHC @sanity
    Examples: 
      | site | zipcode | isMultutiCounty | county          | plantype | planyear | drug1   | testPlans                       |
      | UHC  |   10001 | No              | New York County | PDP      | next     | Lipitor | AARP MedicareRx Walgreens (PDP) |

  Scenario Outline: Test to verify the Select Plan for Enroll Modal when user clicks on "Enroll in Plan" button and when no plans are saved for PDP plan type
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
    Then user should be able to see the NBA modal to add drugs on the VPP summary page
    When user clicks on get started button on NBA
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    When user clicks on Select a plan button on NBA
    Then user should be able to see the Select Plan for Enroll Modal with all plans on vpp summary page
    When user clicks on Enroll in plan button on the select plan modal on vpp summary page
    Then user should be navigated to OLE page

    @NBA_PDP_AARP02 @regressionAARP
    Examples: 
      | site | zipcode | isMultutiCounty | county          | plantype | planyear | drug1   |
      | AARP |   10001 | No              | New York County | PDP      | next     | Lipitor |

    @NBA_PDP_UHC02 @regressionUHC
    Examples: 
      | site | zipcode | isMultutiCounty | county          | plantype | planyear | drug1   |
      | UHC  |   10001 | No              | New York County | PDP      | next     | Lipitor |

  Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Enroll Plan on VPP summary page for MAPD Plan when user adds Drug cost from PDP page
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
    Then user should be able to see the NBA modal to add drugs on the VPP summary page
    When user clicks on get started button on NBA
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    And the user views the plans of the below plan type
      | Plan Type | <plantype1> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then user should be able to see the NBA modal to add providers on the VPP summary page

    @NBA_PDP_AARP02 @regressionAARP
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | plantype1 | drug1   | planyear |
      | AARP |   19019 | No              | Iowa County | PDP      | MAPD      | Lipitor | next     |

    @NBA_PDP_UHC02 @regressionUHC
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | plantype1 | drug1   | planyear |
      | UHC  |   19019 | No              | Iowa County | PDP      | MAPD      | Lipitor | next     |

  ################################################# Additional Flows ##########################################################
  Scenario Outline: UserStory: Test to verify the Next action modal is not displayed on VPP summary page when user navigates from PRE
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    # When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    #When user navigate to Plan Recommendation Engine Tool
    When user navigate Plan Recommendation Engine Using Shop From Home in Find Your Plan
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>       |
      | Is Multi County | <isMultiCounty> |
      | CountyDropDown  | <county>        |
    And user selects plan type in coverage options page
      | Plan Type | <isCoverageOpt> |
    And user selects SNP options in Special Needs Page
      | SNP Options | <specialNeeds> |
    And user selects Travel options in Care Away From Home Page
      | Travel Options | <travel> |
    And user selects doctors in doctors page
      | Doctors             | <doctors>       |
      | Doctors Search Text | <DoctorsName>   |
      | Multi Doctor        | <isMultiDoctor> |
    And user selects skip option in Drug page
      | Drug Selection | <Drug Selection> |
    And user selects additional services option in additional services page
      | Additional Option | <Dental-Hearing-Vision-Fitness> |
    Then user selects cost preferences option in cost preferences page
      | Preference Option | <costPreferenceOption> |
    Then user selects priority in priorities page
      | Priority Option | <priorityOption> |
      | Priorities      | <priorities>     |
    Then user validate elements in loading results page
    And the user selects plan year for PRE Flow
      | Plan Year | <planyear> |
    Then user verify NBA is not displayed on the VPP page
    When the user views the plans of the below plan type
      | Plan Type | <plantype> |
    #  And the user selects plan year
    #  | Plan Year | <planyear> |
    Then user verify NBA is not displayed on the VPP page

    @NBA_PRE_AARP01 @regressionAARP
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel | doctors    | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | plantype | drug1   | planyear | prioritiesOption | priorities    |
      | AARP |   10001 | No            | Miami-Dade | MAPD          | None         | None   | UHGNetwork | [blank]     | [blank]       | No             | Yes,No,No,No                  | Higher               | PDP      | Orkambi | next     | 1st              | Doctors, None |

    @NBA_PRE_UHC01 @regressionUHC
    Examples: 
      | site | Zipcode | isMultiCounty | county     | isCoverageOpt | specialNeeds | travel | doctors    | DoctorsName | isMultiDoctor | Drug Selection | Dental-Hearing-Vision-Fitness | costPreferenceOption | plantype | drug1   | planyear | prioritiesOption | priorities    |
      | UHC  |   33143 | No            | Miami-Dade | MAPD          | None         | None   | UHGNetwork | [blank]     | [blank]       | No             | Yes,No,No,No                  | Higher               | PDP      | Orkambi | next     | 1st              | Doctors, None |

  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for PDP Plan when drugs added from SNP plan card
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
    And I access the DCE Redesign from Plan Summary for mentioned plan
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    When the user clicks on Review Drug Costs to Land on Drug Details Page
    When the user click on return to plan summary from Drug Details Page to return to VPP Plan Summary
    And the user views the plans of the below plan type
      | Plan Type | <plantype1> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    And the user views the plans of the below plan type
      | Plan Type | <plantype2> |
    Then user be able to see the Find a Provider NBA on VPP

    @NBA_AARP03 @regressionAARP
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | planname                                        | plantype1 | drug1   | plantype2 |
      | AARP |   19019 | No              | Iowa County | SNP      | next     | UnitedHealthcare Dual Complete - PA (HMO D-SNP) | PDP       | Lipitor | MAPD      |

    @NBA_UHC03 @regressionUHC
    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | planname                                        | plantype1 | drug1   | plantype2 |
      | UHC  |   19019 | No              | Iowa County | SNP      | next     | UnitedHealthcare Dual Complete - PA (HMO D-SNP) | PDP       | Lipitor | MAPD      |

  @F545298
  Scenario Outline: UserStory: Plan type: <plantype> - Test to verify NBA displayed when navigated to VPP from shop pages
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user navigates to Shop plans for PDP Page and clicks on DCE link fto land on DCE Redesign
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see "Medicare Prescription Drug Plans" by default
    When user clicks view drug cost button
    And the user clicks VPP Plan Details button from Drug Details Page
    And the user click on view plan summary button on vpp detail page
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    When user clicks on Select a plan button on NBA
    Then user should be able to see the Select Plan for Enroll Modal with all plans on vpp summary page

    @dce_NBA_ShopPagesPDP_AARP @regressionAARP
    Examples: 
      | drug1   | zipCode | site | plantype |
      | Orkambi |   80002 | AARP | PDP      |

    @dce_NBA_ShopPagesPDP_UHC @regressionUHC
    Examples: 
      | drug1   | zipCode | site | plantype |
      | Orkambi |   80002 | UHC  | PDP      |

  @F545298
  Scenario Outline: UserStory: Plan type: <plantype> - Test to verify Get Started NBA after removing the drug when user navigated to VPP from shop pages
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the User validates Shop for a Plan Navigation link
    Then the user navigates to Shop plans for PDP Page and clicks on DCE link fto land on DCE Redesign
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see "Medicare Prescription Drug Plans" by default
    When user clicks view drug cost button
    And the user clicks VPP Plan Details button from Drug Details Page
    And the user click on view plan summary button on vpp detail page
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And user removes drugs from plan card
    Then user should see the Get started NBA on VPP
    And the user views the plans of the below plan type
      | Plan Type | <plantype1> |
    Then user should see the Get started NBA on VPP

    @dce_NBA_ShopPagesPDP_AARP @regressionAARP
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode | site | plantype | planyear | plantype1 |
      | Orkambi | Fanapt | Humalog | Adderall |   80002 | AARP | MAPD     | next     | PDP       |

    @dce_NBA_ShopPagesPDP_UHC @regressionUHC
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode | site | plantype | planyear | plantype1 |
      | Orkambi | Fanapt | Humalog | Adderall |   80002 | UHC  | MAPD     | next     | PDP       |

  ############################################## AEP Scenarios - 10/1 ################################################################
  Scenario Outline: UserStory: Test to verify NBA for AEP period 10/1
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
    Then user should be able to see the NBA modal to add drugs on the VPP summary page
    When user clicks on get started button on NBA
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user be able to see the Find a Provider NBA on VPP
    When user clicks on Find a Provider button on NBA
    When user selects a provider and retuns to VPP page
    Then user verify NBA is not displayed on the VPP page
    When the user selects plan year
      | Plan Year | <planyear1> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page

    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | drug1   | planyear1 |
      | AARP |   19019 | No              | Iowa County | MAPD     | future   | Lipitor | current   |

    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | drug1   | planyear1 |
      | UHC  |   19019 | No              | Iowa County | MAPD     | next     | Lipitor | current   |

  ############################################## AEP Scenarios - 10/15 ################################################################
  Scenario Outline: UserStory: Test to verify NBA for AEP period 10/15
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
    Then user should be able to see the NBA modal to add drugs on the VPP summary page
    When user clicks on get started button on NBA
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user be able to see the Find a Provider NBA on VPP
    When user clicks on Find a Provider button on NBA
    When user selects a provider and retuns to VPP page
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    When the user selects plan year
      | Plan Year | <planyear1> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page

    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | drug1   | planyear1 |
      | AARP |   19019 | No              | Iowa County | MAPD     | next     | Lipitor | current   |

    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | drug1   | planyear1 |
      | UHC  |   19019 | No              | Iowa County | MAPD     | next     | Lipitor | current   |

  ############################################## AEP Scenarios - 12/8 ################################################################
  Scenario Outline: UserStory: Test to verify NBA for AEP period 12/8
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
    Then user should be able to see the NBA modal to add drugs on the VPP summary page
    When user clicks on get started button on NBA
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user be able to see the Find a Provider NBA on VPP
    When user clicks on Find a Provider button on NBA
    When user selects a provider and retuns to VPP page
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    When the user selects plan year
      | Plan Year | <planyear1> |
    Then user verify NBA is not displayed on the VPP page

    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | drug1   | planyear1 |
      | AARP |   19019 | No              | Iowa County | MAPD     | next     | Lipitor | current   |

    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear | drug1   | planyear1 |
      | UHC  |   19019 | No              | Iowa County | MAPD     | next     | Lipitor | current   |
