@vppNextActionModalUlayer @F445017 @F473803
Feature: 1.03-ACQ-Next Action Modal on vpp flow AARP

  #**************************************************************MAPD*************************************************************************
  @vppNextActionModalRegression_12 @NBA_MAPD_AARP01
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for MAPD Plan when no Drug cost/provider is added
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
    And user Verify and click perform on Next Best Action Modal for Get Started
    Then user should be navigated to first step of DCE Page

    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear |
      | AARP |   19019 | No              | Iowa County | MAPD     | next     |

  @vppNBAAddDrugMAPD @NBA_MAPD_AARP01
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Provider search on VPP summary page for MAPD Plan when Drug cost exists
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
    And user Verify and click perform on Next Best Action Modal for Get Started
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to add providers on the VPP summary page
    When user clicks on Find My Doctor button
    And user should be redirected to Provider search Rally page

    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | drug1   | planyear|
      | AARP |   19019 | No              | Iowa County | MAPD     | Lipitor | next|

  @vppNextActionModalAddDrugProvider @NBA_MAPD_AARP01
  Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal on VPP summary page for MAPD plan when Drug/Provider exists
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
    And user Verify and click perform on Next Best Action Modal for Get Started
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to add providers on the VPP summary page
    When user clicks on Find My Doctor button
    When user selects a provider and retuns to VPP page
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page

    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | drug1   | planyear |
      | AARP |   19019 | No              | Iowa County | MAPD     | Lipitor |  next     |

  @vppNBAMAPDToPDP @NBA_MAPD_AARP01
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
    And user Verify and click perform on Next Best Action Modal for Get Started
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to add providers on the VPP summary page
    And the user views the plans of the below plan type
      | Plan Type | <plantype1> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page

    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | plantype1 | drug1   | planyear  |
      | AARP |   19019 | No              | Iowa County | MAPD     | PDP       | Lipitor |  next     |

  @vppDCEFlowtoNextActionModalMAPD @NBA_MAPD_AARP02
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
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see Medicare Advantage plan by default
    When user clicks view drug cost button
    Then the user clicks VPP Plan Details button from Drug Details Page
    Then the user click on view plan summary button on vpp detail page
    Then user should be able to see the NBA modal to add providers on the VPP summary page

    Examples: 
      | site | drug1   | zipCode | plantype |
      | AARP | Lipitor |   19019 | MAPD     | 

  @vppNBAAddproviderCoveredLink @NBA_MAPD_AARP02
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
    And the user selects plan year
      | Plan Year | <planyear> |
    Then user Verify and click perform on Next Best Action Modal for Get Started

    Examples: 
      | site | zipcode | isMultutiCounty | county          | plantype | planname                             | planyear |
      | AARP |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | next     |

  @vppNBASavedMAPDPlan @NBA_MAPD_AARP02
  Scenario Outline: Test to verify the Select Plan for Enroll Modal when  user clicks on "Enroll in Plan" button and multiple plans are saved
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
    Then user Verify and click perform on Next Best Action Modal for Get Started
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to add providers on the VPP summary page
    When user clicks on Find My Doctor button
    When user selects a provider and retuns to VPP page
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    When user clicks on Continue Enrollment button on summary page
    Then user should be able to see the Select Plan for Enroll Modal with saved plans
      | Test Plans | <testPlans> |
    When user clicks on Enroll in plan button on the select plan modal on vpp summary page
    Then user should be navigated to OLE page

    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | drug1   | testPlans                           | planyear |
      | AARP |   10001 | No              | Iowa County | MAPD     | Lipitor | AARP Medicare Advantage Prime (HMO) | next     |

  @vppUnsavedEnrollMAPDPlan @NBA_MAPD_AARP02
  Scenario Outline: Test to verify the Select Plan for Enroll Modal when  user clicks on "Enroll in Plan" button and no plans are saved
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
    And user Verify and click perform on Next Best Action Modal for Get Started
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to add providers on the VPP summary page
    When user clicks on Find My Doctor button
    When user selects a provider and retuns to VPP page
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    When user clicks on Continue Enrollment button on summary page
    Then user should be able to see the Select Plan for Enroll Modal with all plans on vpp summary page
    When user clicks on Enroll in plan button on the select plan modal on vpp summary page
    Then user should be navigated to OLE page

    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | drug1   | planyear |
      | AARP |   19019 | No              | Iowa County | MAPD     | Lipitor | next     |

  #*****************************************************PDP**************************************************************************************
  @vppNBAPDPNoDrug @NBA_PDP_AARP01
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for PDP Plan when no Drugs added
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
    And user Verify and click perform on Next Best Action Modal for Get Started
    Then user should be navigated to first step of DCE Page

    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | planyear |
      | AARP |   19019 | No              | Iowa County | PDP     | next     |

  @vppNBAPDPAddDrug
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when Drugs are added
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
    And user Verify and click perform on Next Best Action Modal for Get Started
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page

    Examples: 
      | site | drug1   | zipcode | plantype | planName                        | planyear |
      | AARP | Lipitor |   90210 | PDP      | AARP MedicareRx Walgreens (PDP) | next     |

  @vppDCEFlowtoNextActionModalPDP @NBA_PDP_AARP01
  Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when drug added from DCE
    Given the user is on AARP medicare acquisition site landing page
    When I access the acquisition DCE tool from home page
    Then the user validates Get Started Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see Medicare Advantage plan by default
    When user clicks view drug cost button
    Then the user clicks VPP Plan Details button from Drug Details Page
    Then the user click on view plan summary button on vpp detail page
    Then user should be able to see the NBA modal to add providers on the VPP summary page
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page

    Examples: 
      | site | drug1   | zipCode | plantype |
      | AARP | Lipitor |   19019 | PDP      |

  @vppSavedPDPEnrollNBA @NBA_PDP_AARP02
  Scenario Outline: Test to verify the Select Plan for Enroll Modal when  user clicks on "Enroll in Plan" button and multiple plans are saved
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
    Then user Verify and click perform on Next Best Action Modal for Get Started
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    Then user clicks on Continue Enrollment button on summary page
    When user clicks on Continue Enrollment button on summary page
    Then user should be able to see the Select Plan for Enroll Modal with saved plans
      | Test Plans | <testPlans> |
    When user clicks on Enroll in plan button on the select plan modal on vpp summary page
    Then user should be navigated to OLE page

    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | drug1   | testPlans                       | planyear |
      | AARP |   19019 | No              | Iowa County | PDP      | Lipitor | AARP MedicareRx Walgreens (PDP) | next     |

  @vppunSavedPDPPlans @NBA_PDP_AARP02
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for PDP Plan when Drug cost and Enroll for All Plans
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |  |
    And user Verify and click perform on Next Best Action Modal for Get Started
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    When user clicks on Continue Enrollment button on summary page
    Then user should be able to see the Select Plan for Enroll Modal with all plans on vpp summary page
    When user clicks on Enroll in plan button on the select plan modal on vpp summary page
    Then user should be navigated to OLE page

    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | drug1   | planyear |
      | AARP |   19019 | No              | Iowa County | PDP      | Lipitor | next     |

  @vppPDPToMAPD @NBA_PDP_AARP02
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
    And user Verify and click perform on Next Best Action Modal for Get Started
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page
    And the user views the plans of the below plan type
      | Plan Type | <plantype1> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then user verify the NBA modal to add providers on the VPP summary page

    Examples: 
      | site | zipcode | isMultutiCounty | county      | plantype | plantype1 | drug1   | planyear |
      | AARP |   19019 | No              | Iowa County | PDP      | MAPD      | Lipitor | next     |
