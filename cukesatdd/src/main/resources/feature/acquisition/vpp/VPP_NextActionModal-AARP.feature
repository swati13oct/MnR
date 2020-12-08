@vppNextActionModalUlayer @F445017 @F473803 @vppNextActionModalUlayer
Feature: 1.03-ACQ-Next Action Modal on vpp flow AARP

  #**************************************************************MAPD*************************************************************************
  @vppNextActionModalRegression_12 @NBA_MAPD_AARP01
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for MAPD Plan when no Drug cost/provider is added
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
    Then user should be navigated to first step of DCE Page

    Examples: 
      | zipcode | isMultutiCounty | county      | plantype | planyear |
      |   19019 | No              | Iowa County | MAPD     | future   |

  @vppNBAAddDrugMAPD @NBA_MAPD_AARP01
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Provider search on VPP summary page for MAPD Plan when Drug cost exists
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user verify the NBA modal to add providers on the VPP summary page in AARP site
    When user clicks on Find My Doctor button in AARP Site
    And user should be redirected to Provider search Rally page in AARP site

    Examples: 
      | zipcode | isMultutiCounty | county      | plantype | drug1   | planName                                            |
      |   19019 | No              | Iowa County | MAPD     | Lipitor | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

  @vppNextActionModalAddDrugProvider @NBA_MAPD_AARP01
  Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal on VPP summary page for MAPD plan when Drug/Provider exists
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user verify the NBA modal to add providers on the VPP summary page in AARP site
    When user clicks on Find My Doctor button in AARP Site
    When user selects a provider and retuns to VPP page in ulayer
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site

    Examples: 
      | zipcode | isMultutiCounty | county      | plantype | drug1   | planName                                    | planyear |
      |   19019 | No              | Iowa County | MAPD     | Lipitor | AARP Medicare Advantage SecureHorizons Plan | future   |

  @vppNBAMAPDToPDP @NBA_MAPD_AARP01
  Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when user adds Drug cost from MAPD page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    #And wait for the VPP summary page to load
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype1> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site

    Examples: 
      | zipcode | isMultutiCounty | county      | plantype | plantype1 | drug1   | planName                                            | planyear |
      |   19019 | No              | Iowa County | MAPD     | PDP       | Lipitor | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | future   |

  @vppDCEFlowtoNextActionModalMAPD @NBA_MAPD_AARP02
  Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Provider search on VPP summary page for MAPD Plan when drug added from DCE
    Given the user is on the AARP medicare site landing page
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

    Examples: 
      | drug1   | zipCode | plantype | planName                                            |
      | Lipitor |   19019 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

  @vppNBAAddproviderCoveredLink @NBA_MAPD_AARP02
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for MAPD plan when Provider exists
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    #And the user views the plans of the below plan type in AARP site
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    When the user Click on Is my Provider covered link Ulayer
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page in ulayer
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site

    Examples: 
      | zipcode | isMultutiCounty | county          | plantype | planname                             | planyear |
      |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | future   |

  @vppNBASavedMAPDPlan @NBA_MAPD_AARP02
  Scenario Outline: Test to verify the Select Plan for Enroll Modal when  user clicks on "Enroll in Plan" button and multiple plans are saved
    Given the user is on AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user saves plan as favorite on AARP site
      | Plan Type | <testPlans> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user verify the NBA modal to add providers on the VPP summary page in AARP site
    When user clicks on Find My Doctor button in AARP Site
    When user selects a provider and retuns to VPP page in ulayer
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site
    Then user clicks on Continue Enrollment button in AARP Site
    Then user should be able to see the Select Plan for Enroll Modal with saved plans in AARP site
      | Test Plans | <testPlans> |
    When user clicks on Enroll in plan button on the select plan modal in AARP site
    Then user should be navigated to OLE page in AARP site

    Examples: 
      | zipcode | isMultutiCounty | county      | plantype | drug1   | testPlans                                   | planyear |
      |   19019 | No              | Iowa County | MAPD     | Lipitor | AARP Medicare Advantage Choice Plan 2 (PPO) | future   |

  @vppUnsavedEnrollMAPDPlan @NBA_MAPD_AARP02
  Scenario Outline: Test to verify the Select Plan for Enroll Modal when  user clicks on "Enroll in Plan" button and no plans are saved
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user verify the NBA modal to add providers on the VPP summary page in AARP site
    When user clicks on Find My Doctor button in AARP Site
    When user selects a provider and retuns to VPP page in ulayer
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site
    Then user clicks on Continue Enrollment button in AARP Site
    Then user should be able to see the Select Plan for Enroll Modal with all plans in AARP site
      | Test Plans | <testPlans> |
    When user clicks on Enroll in plan button on the select plan modal in AARP site
    Then user should be navigated to OLE page in AARP site

    Examples: 
      | zipcode | isMultutiCounty | county      | plantype | drug1   | planyear |
      |   19019 | No              | Iowa County | MAPD     | Lipitor | future   |

  #*****************************************************PDP**************************************************************************************
  @vppNBAPDPNoDrug @NBA_PDP_AARP01
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal on VPP summary page for PDP Plan when no Drugs added
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
    Then user should be navigated to first step of DCE Page

    Examples: 
      | zipcode | isMultutiCounty | county      | plantype | planyear |
      |   19019 | No              | Iowa County | PDP      | future   |

  @vppNBAPDPAddDrug @NBA_PDP_AARP01
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when Drugs are added
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site

    Examples: 
      | drug1   | zipcode | plantype | planName                        | planyear |
      | Lipitor |   90210 | PDP      | AARP MedicareRx Walgreens (PDP) | future   |

  @vppDCEFlowtoNextActionModalPDP @NBA_PDP_AARP01
  Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Enroll Plan on VPP summary page for PDP Plan when drug added from DCE
    Given the user is on the AARP medicare site landing page
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
      | drug1   | zipCode | plantype |
      | Lipitor |   19019 | pdp      |

  @vppSavedPDPEnrollNBA @NBA_PDP_AARP02
  Scenario Outline: Test to verify the Select Plan for Enroll Modal when  user clicks on "Enroll in Plan" button and multiple plans are saved
    Given the user is on AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user saves plan as favorite on AARP site
      | Plan Type | <testPlans> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site
    Then user clicks on Continue Enrollment button in AARP Site
    Then user should be able to see the Select Plan for Enroll Modal with saved plans in AARP site
      | Test Plans | <testPlans> |
    When user clicks on Enroll in plan button on the select plan modal in AARP site
    Then user should be navigated to OLE page in AARP site

    Examples: 
      | zipcode | isMultutiCounty | county      | plantype | drug1   | testPlans                       | planyear |
      |   19019 | No              | Iowa County | PDP      | Lipitor | AARP MedicareRx Walgreens (PDP) | future   |

  @vppunSavedPDPPlans @NBA_PDP_AARP02
  Scenario Outline: UserStory: Plan type: <plantype> -Test to verify the Next action modal for PDP Plan when Drug cost and Enroll for All Plans
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site
    Then user clicks on Continue Enrollment button in AARP Site
    Then user should be able to see the Select Plan for Enroll Modal with all plans in AARP site
      | Test Plans | <testPlans> |
    When user clicks on Enroll in plan button on the select plan modal in AARP site
    Then user should be navigated to OLE page in AARP site

    Examples: 
      | zipcode | isMultutiCounty | county      | plantype | drug1   | testPlans                       | planyear |
      |   19019 | No              | Iowa County | PDP      | Lipitor | AARP MedicareRx Walgreens (PDP) | future   |

  @vppPDPToMAPD @NBA_PDP_AARP02
  Scenario Outline: UserStory: Plan type: <plantype> Test to verify the Next action modal for Enroll Plan on VPP summary page for MAPD Plan when user adds Drug cost from PDP page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user Verify and click perform on Next Best Action Modal for Get Started in AARP site
    Then user should be navigated to first step of DCE Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    And clicks on Review drug cost button
    Then user should be able to see Medicare Advantage plan by default
    When user clicks on Return to plan summary page link in DCE
    Then user should be able to see the NBA modal to Enroll Plan on the VPP summary page in AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype1> |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then user verify the NBA modal to add providers on the VPP summary page in AARP site

    Examples: 
      | zipcode | isMultutiCounty | county      | plantype | plantype1 | drug1   | planyear |
      |   19019 | No              | Iowa County | PDP      | MAPD      | Lipitor | future   |
