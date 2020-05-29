@fixedTestCaseTest @vppBlayer
Feature: 2.02-Favorite Plans in vpp flow UMS
      
  #@feature-F265872 @us1598162 @vppFavoritePlanRegressionBlayer1 @vppFavoritePlanInSession @vppFavoritePlanInSessionUhc @thePredators @Apr_release_2019 @prodRegression
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can save and unsave favorite plans on view plan preview page on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site 
    Then user validates selected plans can be saved as favorite on UHC site
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates saved favorite plans will be stored within same session after zipcode change from Home on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates saved favorite plans will be stored within same session after zipcode change from Shop For a Plan on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates saved favorite plans will be stored within same session after zipcode change within VPP page on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
	Then user validates ability to unsave a saved plan on UHC site   
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates unsave favorite plans will be stored within same session after zipcode change from Home on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates unsave favorite plans will be stored within same session after zipcode change from Shop For a Plan on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates unsave favorite plans will be stored within same session after zipcode change within VPP page on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |

    Examples: 
      | UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                          | PDP_testPlans                                                    | SNP_testPlans                                                                               |
      | 1598162 | 80001   | NO            | Jefferson County | AARP Medicare Advantage SecureHorizons Essential (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO)| AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP)|

@feature-F265872 @us1598162 @vppFavoritePlanRegressionBlayer1 @vppFavoritePlanInSession @vppFavoritePlanInSessionUhc @thePredators @Apr_release_2019 @prodRegression
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can save and unsave favorite plans on view plan preview page for zipcode change from home page on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site 
    Then user validates selected plans can be saved as favorite on UHC site
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates saved favorite plans will be stored within same session after zipcode change from Home on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
	Then user validates ability to unsave a saved plan on UHC site   
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates unsave favorite plans will be stored within same session after zipcode change from Home on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |

    Examples: 
      | UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                          | PDP_testPlans                                                    | SNP_testPlans                                                                               |
      | 1598162 | 80001   | NO            | Jefferson County | AARP Medicare Advantage SecureHorizons Essential (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO)| AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP)|

 @feature-F265872 @us1598162 @vppFavoritePlanRegressionBlayer2 @vppFavoritePlanInSession @vppFavoritePlanInSessionUhc @thePredators @Apr_release_2019 @prodRegression
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can save and unsave favorite plans on view plan preview page for zipcode change from Shop for Plan dropdown on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site 
    Then user validates selected plans can be saved as favorite on UHC site
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates saved favorite plans will be stored within same session after zipcode change from Shop For a Plan on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
	Then user validates ability to unsave a saved plan on UHC site   
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates unsave favorite plans will be stored within same session after zipcode change from Shop For a Plan on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |

    Examples: 
      | UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                          | PDP_testPlans                                                    | SNP_testPlans                                                                               |
      | 1598162 | 80001   | NO            | Jefferson County | AARP Medicare Advantage SecureHorizons Essential (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO)| AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP)|

 @feature-F265872 @us1598162 @vppFavoritePlanRegressionBlayer3 @vppFavoritePlanInSession @vppFavoritePlanInSessionUhc @thePredators @Apr_release_2019 @prodRegression
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can save and unsave favorite plans on view plan preview page for zipcode change within VPP on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site 
    Then user validates selected plans can be saved as favorite on UHC site
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates saved favorite plans will be stored within same session after zipcode change within VPP page on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
	Then user validates ability to unsave a saved plan on UHC site   
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates unsave favorite plans will be stored within same session after zipcode change within VPP page on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |

    Examples: 
      | UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                          | PDP_testPlans                                                    | SNP_testPlans                                                                               |
      | 1598162 | 80001   | NO            | Jefferson County | AARP Medicare Advantage SecureHorizons Essential (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO)| AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP)|

  @feature-F265872 @us1598162 @vppFavoritePlanRegressionBlayer4 @vppFavoritePlanInSessionCloseTab @vppFavoritePlanInSessionCloseTabUhc @thePredators @Apr_release_2019
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can favorite plans will be saved within session on view plan preview page by switching window tab on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site 
    Then user validates selected plans can be saved as favorite on UHC site
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
	Then user closes the original tab and open new tab for UHC site
	Then the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
	Then user validates plans remain saved within same session for UHC site
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
 
    Examples: 
      | UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                          | PDP_testPlans                                                    | SNP_testPlans                                                                               |
      | 1598162 | 80001   | NO            | Jefferson County | AARP Medicare Advantage SecureHorizons Essential (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO)| AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP)|
