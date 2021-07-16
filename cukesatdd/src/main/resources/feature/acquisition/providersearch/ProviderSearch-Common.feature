#File Name: ProviderSearch-Common.feature
#@fixedTestCaseTest
@providerSearch
Feature: 1.07.1 .ACQ- Provider Search Flow in AARP

  Scenario Outline: Verify Provider Search  in <site> site
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

    @ProviderSearchCommon_AARP @regressionAARP
    Examples: 
      | zipcode | site | isMultutiCounty | county          | plantype | planname                             | planyear |
      |   10001 | AARP | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | future   |

    @ProviderSearchCommon_UHC @regressionUHC
    Examples: 
      | zipcode | site | isMultutiCounty | county          | plantype | planname                             | planyear |
      |   10001 | UHC  | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | future   |

  Scenario Outline: Verify Provider Search  in <site> site from Global Header
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user clicks on Provider Search on the global header for site
    Then the user enters the zipcode and select a plan on the Rally tool for given zipcode
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
      | Year      | <year>     |
    When user select a provider and save it

    @ProviderSearchCommon_AARP @regressionAARP
    Examples: 
      | zipcode | site | planname                             | year   |
      |   10001 | AARP | AARP Medicare Advantage Plan 2 (HMO) | future |

    @ProviderSearchCommon_UHC @regressionUHC
    Examples: 
      | zipcode | site | planname                             | year   |
      |   10001 | UHC  | AARP Medicare Advantage Plan 2 (HMO) | future |

  Scenario Outline: Verify Provider Search  in <site> site from plan summary page
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

    @ProviderSearchCommon_AARP @regressionAARP
    Examples: 
      | zipcode | site | isMultutiCounty | county          | plantype | planname                             | planyear |
      |   10001 | AARP | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | future   |

    @ProviderSearchCommon_UHC @regressionUHC @sanity
    Examples: 
      | zipcode | site | isMultutiCounty | county          | plantype | planname                             | planyear |
      |   10001 | UHC  | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 2 (HMO) | future   |

  Scenario Outline: Verify Provider Search  in <site> site from Plan Details page
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

    @ProviderSearchCommon_AARP @regressionAARP
    Examples: 
      | zipcode | site | isMultutiCounty | county          | plantype | planName                                | planyear |
      |   10001 | AARP | NO              | New York County | MA       | AARP Medicare Advantage Essential (HMO) | future   |

    @ProviderSearchCommon_UHC @regressionUHC
    Examples: 
      | zipcode | site | isMultutiCounty | county          | plantype | planName                                | planyear |
      |   10001 | UHC  | NO              | New York County | MA       | AARP Medicare Advantage Essential (HMO) | future   |

  Scenario Outline: Verify Provider Search  in <site> site from Home Page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user click on Provider Search on the Home Page
    Then the user enters the zipcode and select a plan on the Rally tool for given zipcode
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
      | Year      | <year>     |
    When user select a provider and save it

    @ProviderSearchCommon_AARP @regressionAARP
    Examples: 
      | zipcode | site | planname                             | year     |
      |   10001 | AARP | AARP Medicare Advantage Plan 2 (HMO) | nextYear |

    @ProviderSearchCommon_UHC @regressionUHC
    Examples: 
      | zipcode | site | planname                             | year     |
      |   10001 | UHC  | AARP Medicare Advantage Plan 2 (HMO) | nextYear |

  Scenario Outline: Verify Provider Search plan count in <site> site from Global Header -plan count-<plancount>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user clicks on Provider Search on the global header for site
    When the user enters the zipcode and counts the plan
      | Zip Code  | <zipcode>   |
      | Plancount | <plancount> |
      | Year      | <year>      |

    @ProviderSearchCommon_AARP @regressionAARP @sanity
    Examples: 
      | zipcode | site | plancount | year   |
      |   10001 | AARP |        12 | future |

    @ProviderSearchCommon_UHC @regressionUHC
    Examples: 
      | zipcode | site | plancount | year   |
      |   10001 | UHC  |        12 | future |

    Examples: 
      | zipcode | site | plancount | year   |
      |   55344 | AARP |         7 | future |
      |   04011 | AARP |         6 | future |

    Examples: 
      | zipcode | site | plancount | year   |
      |   55344 | UHC  |         7 | future |
      |   04011 | UHC  |         6 | future |

  Scenario Outline: Verify Provider Search plan count in <site> site from Home Page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user click on Provider Search on the Home Page
    When the user enters the zipcode and counts the plan
      | Zip Code  | <zipcode>   |
      | Plancount | <plancount> |
      | Year      | <year>      |

    @ProviderSearchCommon_AARP @regressionAARP
    Examples: 
      | zipcode | site | plancount | year   |
      |   10001 | AARP |        12 | future |

    @ProviderSearchCommon_UHC @regressionUHC
    Examples: 
      | zipcode | site | plancount | year   |
      |   10001 | UHC  |        12 | future |

    Examples: 
      | zipcode | site | plancount | year   |
      |   55344 | AARP |         7 | future |
      |   04011 | AARP |         6 | future |

    Examples: 
      | zipcode | site | plancount | year   |
      |   55344 | UHC  |         7 | future |
      |   04011 | UHC  |         6 | future |
