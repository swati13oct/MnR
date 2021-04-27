@UATRegression @regressionAARP
Feature: 1.07.2 UAT-Provider Search Flows

  
  Scenario Outline: <Scenario> : Verify Provider Search  in <site> site from Global Header
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user clicks on Provider Search on the global header for site
    Then the user enters the zipcode and select a plan on the Rally tool for given zipcode
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
      | Year      | <year>     |
    When user select a provider and save it

    @ProviderSearchCommon_AARP @ProviderSearchCommon_Prod_AARP @ProviderSearchFromGlobalHeaderUlayer
    Examples: 
      | Scenario                             | zipcode | site | planname                             | year    |
      | Provider Search - E2E Scenario 4_AMP |   10001 | AARP | AARP Medicare Advantage Plan 2 (HMO) | current |

    #@ProviderSearchCommon_UHC @ProviderSearchCommon_Prod_UHC @ProviderSearchFromGlobalHeaderBlayer
    #Examples: 
      #| Scenario                             | zipcode | site | planname                             | year    |
      #| Provider Search - E2E Scenario 4_AMP |   10001 | UHC  | AARP Medicare Advantage Plan 2 (HMO) | current |

  
  Scenario Outline: <Scenario> : Verify Provider Search  in <site> site from plan summary page
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
    Then Verify X out of Y provider covered information is displayed on Plan Summary page
      | PlanName | <planname> |
    Then Verify provider name is displayed on Plan Summary page
      | PlanName | <planname> |

    @ProviderSearchCommon_AARP @ProviderSearchCommon_Prod_AARP @ProviderSearchFromVppPlanSummaryPageUlayer
    Examples: 
      | Scenario                             | zipcode | site | isMultutiCounty | county          | plantype | planname                             | planyear |
      | Provider Search - E2E Scenario 3_AMP |   10001 | AARP | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | current  |

    #@ProviderSearchCommon_UHC @ProviderSearchCommon_Prod_UHC @ProviderSearchFromVppPlanSummaryPageBlayer
    #Examples: 
      #| Scenario                             | zipcode | site | isMultutiCounty | county          | plantype | planname                             | planyear |
      #| Provider Search - E2E Scenario 3_AMP |   10001 | UHC  | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | current  |

  
  Scenario Outline: <Scenario> : Verify Provider Search  in <site> site from Plan Details page
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
    Then the user navigates to the plan details page
      | Plan Name | <planName> |
    Then the user Click on Look up your Provider button on Plan Details Page
    When user selects a provider and retuns to VPP plan details page
    Then Verify X out of Y provider covered information is displayed on Plan Details page

    @ProviderSearchCommon_AARP @ProviderSearchCommon_Prod_AARP @ProviderSearchFromVppPlanDetailsPageUlayer
    Examples: 
      | Scenario                             | zipcode | site | isMultutiCounty | county          | plantype | planName                                | planyear |
      | Provider Search - E2E Scenario 2_AMP |   10001 | AARP | NO              | New York County | MA       | AARP Medicare Advantage Plan 1 (HMO) | current  |

    #@ProviderSearchCommon_UHC @ProviderSearchCommon_Prod_UHC @ProviderSearchFromVppPlanDetailsPageBlayer
    #Examples: 
      #| Scenario                             | zipcode | site | isMultutiCounty | county          | plantype | planName                                | planyear |
      #| Provider Search - E2E Scenario 2_AMP |   10001 | UHC  | NO              | New York County | MA       | AARP Medicare Advantage Essential (HMO) | current  |

    
  Scenario Outline: <Scenario> : Verify Provider Search  in AARP site from Home Page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user click on Provider Search on the Home Page
    Then the user enters the zipcode and select a plan on the Rally tool for given zipcode
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
      | Year      | <year>     |
    When user select a provider and save it

    @ProviderSearchCommon_AARP @ProviderSearchCommon_Prod_AARP @ProviderSearchFromHomePageUlayer @ProviderSearchFromHomePageNextYrUlayerSmoke
    Examples: 
      | Scenario                             | zipcode | site | planname                             | year     |
      | Provider Search - E2E Scenario 1_AMP |   10001 | AARP | AARP Medicare Advantage Plan 2 (HMO) | nextYear |
#
    #@ProviderSearchCommon_UHC @ProviderSearchCommon_Prod_UHC @ProviderSearchFromHomePageBlayer @ProviderSearchFromHomePageNextYrBlayerSmoke
    #Examples: 
      #| Scenario                             | zipcode | site | planname                             | year     |
      #| Provider Search - E2E Scenario 1_AMP |   10001 | UHC  | AARP Medicare Advantage Plan 2 (HMO) | nextYear |