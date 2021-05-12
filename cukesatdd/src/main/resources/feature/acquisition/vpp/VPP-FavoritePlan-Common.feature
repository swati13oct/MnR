@fixedTestCaseTest @vppUlayer @vpp @favoritePlans
Feature: 1.02-Favorite Plans in vpp flow AARP

  #@feature-F265872 @us1598162 @vppFavoritePlanRegressionUlayer1 @vppFavoritePlanInSession @vppFavoritePlanInSessionAarp @thePredators @Apr_release_2019 @prodRegression @feature-F265872 @us1598162 @vppFavoritePlanRegressionBlayer1 @vppFavoritePlanInSession @vppFavoritePlanInSessionUhc @thePredators @Apr_release_2019 @prodRegression
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can save and unsave favorite plans on view plan preview page for zipcode change from home page on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
    Then user validates plan count for all plan types on plan summary page
    Then user validates selected plans can be saved as favorite
      | MA Test Plans  | <MA_testPlans>  |
      | PDP Test Plans | <PDP_testPlans> |
      | SNP Test Plans | <SNP_testPlans> |
      | Plan Year      | <planyear>      |
    Then user validates saved favorite plans will be stored within same session after zipcode change from Home page
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates ability to unsave a saved plan
      | MA Test Plans  | <MA_testPlans>  |
      | PDP Test Plans | <PDP_testPlans> |
      | SNP Test Plans | <SNP_testPlans> |
    Then user validates unsave favorite plans will be stored within same session after zipcode change from Home page
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |

    @vppFavoritePlanCommon_AARP_1 @regressionAARP
    Examples: 
      | UID     | site | zipcode | isMultiCounty | county           | MA_testPlans                                                                              | PDP_testPlans                                                    | SNP_testPlans                              | planyear |
      | 1598162 | AARP |   80001 | NO            | Jefferson County | AARP Medicare Advantage Patriot (HMO),AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) | future   |

    @vppFavoritePlanCommon_UHC_1 @regressionUHC
    Examples: 
      | UID     | site | zipcode | isMultiCounty | county           | MA_testPlans                                                                              | PDP_testPlans                                                    | SNP_testPlans                              | planyear |
      | 1598162 | UHC  |   80001 | NO            | Jefferson County | AARP Medicare Advantage Patriot (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) | future   |

  #@feature-F265872 @us1598162 @vppFavoritePlanRegressionUlayer2 @vppFavoritePlanInSession @vppFavoritePlanInSessionAarp @thePredators @Apr_release_2019 @prodRegression @feature-F265872 @us1598162 @vppFavoritePlanRegressionBlayer2 @vppFavoritePlanInSession @vppFavoritePlanInSessionUhc @thePredators @Apr_release_2019 @prodRegression
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can save and unsave favorite plans on view plan preview page from zipcode change from Shop For Plan dropdown on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
    Then user validates plan count for all plan types on plan summary page
    Then user validates selected plans can be saved as favorite
      | MA Test Plans  | <MA_testPlans>  |
      | PDP Test Plans | <PDP_testPlans> |
      | SNP Test Plans | <SNP_testPlans> |
      | Plan Year      | <planyear>      |
    Then user validates saved favorite plans will be stored within same session after zipcode change from Shop For a Plan Page
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates ability to unsave a saved plan
      | MA Test Plans  | <MA_testPlans>  |
      | PDP Test Plans | <PDP_testPlans> |
      | SNP Test Plans | <SNP_testPlans> |
    Then user validates unsave favorite plans will be stored within same session after zipcode change from Shop For a Plan Page
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |

    @vppFavoritePlanCommon_AARP_2 @regressionAARP
    Examples: 
      | UID     | site | zipcode | isMultiCounty | county           | MA_testPlans                                                                              | PDP_testPlans                                                    | SNP_testPlans                              | planyear |
      | 1598162 | AARP |   80001 | NO            | Jefferson County | AARP Medicare Advantage Patriot (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) | future   |

    @vppFavoritePlanCommon_UHC_2 @regressionUHC
    Examples: 
      | UID     | site | zipcode | isMultiCounty | county           | MA_testPlans                                                                              | PDP_testPlans                                                    | SNP_testPlans                              | planyear |
      | 1598162 | UHC  |   80001 | NO            | Jefferson County | AARP Medicare Advantage Patriot (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) | future   |

  # @feature-F265872 @us1598162 @vppFavoritePlanRegressionUlayer3 @vppFavoritePlanInSession @vppFavoritePlanInSessionAarp @thePredators @Apr_release_2019 @prodRegression @feature-F265872 @us1598162 @vppFavoritePlanRegressionBlayer3 @vppFavoritePlanInSession @vppFavoritePlanInSessionUhc @thePredators @Apr_release_2019 @prodRegression
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can save and unsave favorite plans on view plan preview page for zipcode change within VPP on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
    Then user validates plan count for all plan types on plan summary page
    Then user validates selected plans can be saved as favorite
      | MA Test Plans  | <MA_testPlans>  |
      | PDP Test Plans | <PDP_testPlans> |
      | SNP Test Plans | <SNP_testPlans> |
      | Plan Year      | <planyear>      |
    Then user validates saved favorite plans will be stored within same session after zipcode change within VPP page
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates ability to unsave a saved plan
      | MA Test Plans  | <MA_testPlans>  |
      | PDP Test Plans | <PDP_testPlans> |
      | SNP Test Plans | <SNP_testPlans> |
    Then user validates unsave favorite plans will be stored within same session after zipcode change within VPP page
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |

    @vppFavoritePlanCommon_AARP_3 @regressionAARP @prodRegression
    Examples: 
      | UID     | site | zipcode | isMultiCounty | county           | MA_testPlans                                                                              | PDP_testPlans                                                    | SNP_testPlans                              | planyear |
      | 1598162 | AARP |   80001 | NO            | Jefferson County | AARP Medicare Advantage Patriot (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) | future   |

    @vppFavoritePlanCommon_UHC_3 @regressionUHC
    Examples: 
      | UID     | site | zipcode | isMultiCounty | county           | MA_testPlans                                                                              | PDP_testPlans                                                    | SNP_testPlans                              | planyear |
      | 1598162 | UHC  |   80001 | NO            | Jefferson County | AARP Medicare Advantage Patriot (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) | future   |

  #@feature-F265872 @us1598162 @vppFavoritePlanRegressionUlayer4 @vppFavoritePlanInSessionCloseTab @vppFavoritePlanInSessionCloseTabAarp @thePredators @Apr_release_2019  @feature-F265872 @us1598162 @vppFavoritePlanRegressionBlayer4 @vppFavoritePlanInSessionCloseTab @vppFavoritePlanInSessionCloseTabUhc @thePredators @Apr_release_2019
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can favorite plans will be saved within session on view plan preview page by switching window tabs on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultiCounty> |
      | County Name     | <county>          |
    Then user validates plan count for all plan types on plan summary page
    Then user validates selected plans can be saved as favorite
      | MA Test Plans  | <MA_testPlans>  |
      | PDP Test Plans | <PDP_testPlans> |
      | SNP Test Plans | <SNP_testPlans> |
      | Plan Year      | <planyear>      |
    Then user closes the original tab and open new tab
    Then the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plans remain saved within same session
      | MA Test Plans  | <MA_testPlans>  |
      | PDP Test Plans | <PDP_testPlans> |
      | SNP Test Plans | <SNP_testPlans> |

    @vppFavoritePlanCommon_AARP_4 @regressionAARP
    Examples: 
      | UID     | site | zipcode | isMultiCounty | county           | MA_testPlans                                                                              | PDP_testPlans                                                    | SNP_testPlans                              | planyear |
      | 1598162 | AARP |   80001 | NO            | Jefferson County | AARP Medicare Advantage Patriot (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) | future   |

    @vppFavoritePlanCommon_UHC_4 @regressionUHC
    Examples: 
      | UID     | site | zipcode | isMultiCounty | county           | MA_testPlans                                                                              | PDP_testPlans                                                    | SNP_testPlans                              | planyear |
      | 1598162 | UHC  |   80001 | NO            | Jefferson County | AARP Medicare Advantage Patriot (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) | future   |
