@fixedTestCaseTest
Feature: 1.07 .ACQ- Provider Search Flow in AARP

  @ProviderSearchUlayerSmoke @ProviderSearchUlayerCurrentSmoke
  Scenario Outline: Verify Provider Search  in AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    #And the user views the plans of the below plan type in AARP site
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    When the user Click on Is my Provider covered link Ulayer
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer
      | PlanName | <planname> |

    Examples: 
      | zipcode | isMultutiCounty | county          | plantype | planname                             |
      |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 2 (HMO) |

  @ProviderSearchFromGlobalHeaderUlayer @AcqRegressionProviderSearchUlayer @prodRegression
  Scenario Outline: Verify Provider Search  in AARP site from Global Header
    Given the user is on AARP medicare acquisition site landing page
    When the user clicks on Provider Search on the global header
    Then the user enters the zipcode and select a plan on the Rally tool
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
      | Year      | <year>     |
    When user selects a provider and saves it

    Examples: 
      | zipcode | planname                             | year     |
      |   10001 | AARP Medicare Advantage Plan 2 (HMO) | nextYear |

  @ProviderSearchFromGlobalHeaderUlayer1 
  Scenario Outline: Verify Provider Search  in AARP site from Global Header -plan count-<plancount>
    Given the user is on AARP medicare acquisition site landing page
    When the user clicks on Provider Search on the global header
    When the user enters the zipcode and counts the plan Ulayer
      | Zip Code  | <zipcode>   |
      | Plancount | <plancount> |

    @AcqRegressionProviderSearchUlayer
    Examples: 
      | zipcode | plancount |
      |   10001 |        12 |
      
    Examples: 
      | zipcode | plancount |
      |   55344 |         7 |
      |   04011 |         6 |

  @ProviderSearchFromWidgetUlayer 
  Scenario Outline: Verify Provider Search  in AARP site from Global Header
    Given the user is on AARP medicare acquisition site landing page
    When the user clicks on Provider Search on the Home Page
    When the user enters the zipcode and counts the plan Ulayer
      | Zip Code  | <zipcode>   |
      | Plancount | <plancount> |

	@AcqRegressionProviderSearchUlayer
    Examples: 
      | zipcode | plancount |
      |   10001 |        12 |
      
    Examples: 
      | zipcode | plancount |
      |   55344 |         7 |
      |   04011 |         6 |

  @ProviderSearchFromVppPlanSummaryPageUlayer @AcqRegressionProviderSearchUlayer @prodRegression
  Scenario Outline: Verify Provider Search  in AARP site from plan summary page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    When the user Click on Is my Provider covered link Ulayer
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer
      | PlanName | <planname> |

    Examples: 
      | zipcode | isMultutiCounty | county          | plantype | planname                             |
      |   10001 | NO              | New York County | MAPD     | AARP Medicare Advantage Plan 2 (HMO) |

  @ProviderSearchFromVppPlanDetailsPageUlayer @AcqRegressionProviderSearchUlayer @prodRegression
  Scenario Outline: Verify Provider Search  in AARP site from Plan Details page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    Then the user navigates to the plan Details page
      | Plan Name | <planName> |
    Then the user Click on Look up your Provider button
    When user selects a provider and retuns to VPP plan details page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Details page Ulayer

    Examples: 
      | zipcode | isMultutiCounty | county          | plantype | planName                                |
      |   10001 | NO              | New York County | MA       | AARP Medicare Advantage Essential (HMO) |

  @ProviderSearchFromHomePageUlayer @AcqRegressionProviderSearchUlayer @ProviderSearchFromHomePageNextYrUlayerSmoke @prodRegression
  Scenario Outline: Verify Provider Search  in AARP site from Home Page
    Given the user is on AARP medicare acquisition site landing page
    When the user clicks on Provider Search on the Home Page
    Then the user enters the zipcode and select a plan on the Rally tool
      | Zip Code  | <zipcode>  |
      | Plan Name | <planname> |
      | Year      | <year>     |
    When user selects a provider and saves it

    Examples: 
      | zipcode | planname                             | year     |
      |   10001 | AARP Medicare Advantage Plan 2 (HMO) | nextYear |

  @ProviderSearchHospitalsUlayerSmoke @ProviderSearchUlayerCurrentSmoke
  Scenario Outline: Verify Hospitals Provider Search  in AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    #And the user views the plans of the below plan type in AARP site
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    When the user Click on Is my Provider covered link Ulayer
      | PlanName | <planname> |
    When user selects a Hospitals and retuns to VPP page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer
      | PlanName | <planname> |
    Then Verify provider name is displayed on Plan Summary page Ulayer
      | PlanName | <planname> |

    Examples: 
      | zipcode | isMultutiCounty | county       | plantype | planname                                     |
      |   78006 | YES             | Bexar County | MAPD     | AARP Medicare Advantage SecureHorizons (HMO) |
