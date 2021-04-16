#@fixedTestCaseTest @vppUlayer
#Feature: 1.02-Favorite Plans in vpp flow AARP
#
  #@feature-F265872 @us1598162 @vppFavoritePlanRegressionUlayer1 @vppFavoritePlanInSession @vppFavoritePlanInSessionAarp @thePredators @Apr_release_2019 @prodRegression
  #Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can save and unsave favorite plans on view plan preview page on AARP site
    #Given the user is on AARP medicare acquisition site landing page
    #When the user performs plan search using following information in the AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
    #Then user validates plan count for all plan types on plan summary page in the AARP site
    #And the user views the plans of the below plan type in AARP site
      #| Plan Type | <plantype> |
    #And the user selects plan year for the AARP site
      #| Plan Year | <planyear> |
    #Then user validates selected plans can be saved as favorite on AARP site
      #| MA Test Plans  | <MA_testPlans>  |
      #| PDP Test Plans | <PDP_testPlans> |
      #| SNP Test Plans | <SNP_testPlans> |
    #Then user validates saved favorite plans will be stored within same session after zipcode change from Home on AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
      #| MA Test Plans   | <MA_testPlans>  |
      #| PDP Test Plans  | <PDP_testPlans> |
      #| SNP Test Plans  | <SNP_testPlans> |
    #Then user validates saved favorite plans will be stored within same session after zipcode change from Shop For a Plan on AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
      #| MA Test Plans   | <MA_testPlans>  |
      #| PDP Test Plans  | <PDP_testPlans> |
      #| SNP Test Plans  | <SNP_testPlans> |
    #Then user validates saved favorite plans will be stored within same session after zipcode change within VPP page on AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
      #| MA Test Plans   | <MA_testPlans>  |
      #| PDP Test Plans  | <PDP_testPlans> |
      #| SNP Test Plans  | <SNP_testPlans> |
    #Then user validates ability to unsave a saved plan on AARP site
      #| MA Test Plans  | <MA_testPlans>  |
      #| PDP Test Plans | <PDP_testPlans> |
      #| SNP Test Plans | <SNP_testPlans> |
    #Then user validates unsave favorite plans will be stored within same session after zipcode change from Home on AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
      #| MA Test Plans   | <MA_testPlans>  |
      #| PDP Test Plans  | <PDP_testPlans> |
      #| SNP Test Plans  | <SNP_testPlans> |
    #Then user validates unsave favorite plans will be stored within same session after zipcode change from Shop For a Plan on AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
      #| MA Test Plans   | <MA_testPlans>  |
      #| PDP Test Plans  | <PDP_testPlans> |
      #| SNP Test Plans  | <SNP_testPlans> |
    #Then user validates unsave favorite plans will be stored within same session after zipcode change within VPP page on AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
      #| MA Test Plans   | <MA_testPlans>  |
      #| PDP Test Plans  | <PDP_testPlans> |
      #| SNP Test Plans  | <SNP_testPlans> |
#
    #Examples: 
      #| UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                            | PDP_testPlans                                                    | SNP_testPlans                              | planyear |
      #| 1598162 |   80001 | NO            | Jefferson County | AARP Medicare Advantage SecureHorizons Plan 2 (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) | current  |
#
  #@feature-F265872 @us1598162 @vppFavoritePlanRegressionUlayer1 @vppFavoritePlanInSession @vppFavoritePlanInSessionAarp @thePredators @Apr_release_2019 @prodRegression
  #Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can save and unsave favorite plans on view plan preview page for zipcode change from home page on AARP site
    #Given the user is on AARP medicare acquisition site landing page
    #When the user performs plan search using following information in the AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
    #Then user validates plan count for all plan types on plan summary page in the AARP site
    #Then user validates selected plans can be saved as favorite on AARP site
      #| MA Test Plans  | <MA_testPlans>  |
      #| PDP Test Plans | <PDP_testPlans> |
      #| SNP Test Plans | <SNP_testPlans> |
      #| Plan Year      | <planyear>      |
    #Then user validates saved favorite plans will be stored within same session after zipcode change from Home on AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
      #| MA Test Plans   | <MA_testPlans>  |
      #| PDP Test Plans  | <PDP_testPlans> |
      #| SNP Test Plans  | <SNP_testPlans> |
    #Then user validates ability to unsave a saved plan on AARP site
      #| MA Test Plans  | <MA_testPlans>  |
      #| PDP Test Plans | <PDP_testPlans> |
      #| SNP Test Plans | <SNP_testPlans> |
    #Then user validates unsave favorite plans will be stored within same session after zipcode change from Home on AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
      #| MA Test Plans   | <MA_testPlans>  |
      #| PDP Test Plans  | <PDP_testPlans> |
      #| SNP Test Plans  | <SNP_testPlans> |
#
    #Examples: 
      #| UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                            | PDP_testPlans                                                    | SNP_testPlans                              | planyear |
      #| 1598162 |   80001 | NO            | Jefferson County | AARP Medicare Advantage SecureHorizons Plan 2 (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) | current  |
#
  #@feature-F265872 @us1598162 @vppFavoritePlanRegressionUlayer2 @vppFavoritePlanInSession @vppFavoritePlanInSessionAarp @thePredators @Apr_release_2019 @prodRegression
  #Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can save and unsave favorite plans on view plan preview page from zipcode change from Shop For Plan dropdown on AARP site
    #Given the user is on AARP medicare acquisition site landing page
    #When the user performs plan search using following information in the AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
    #Then user validates plan count for all plan types on plan summary page in the AARP site
    #Then user validates selected plans can be saved as favorite on AARP site
      #| MA Test Plans  | <MA_testPlans>  |
      #| PDP Test Plans | <PDP_testPlans> |
      #| SNP Test Plans | <SNP_testPlans> |
      #| Plan Year      | <planyear>      |
    #Then user validates saved favorite plans will be stored within same session after zipcode change from Shop For a Plan on AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
      #| MA Test Plans   | <MA_testPlans>  |
      #| PDP Test Plans  | <PDP_testPlans> |
      #| SNP Test Plans  | <SNP_testPlans> |
    #Then user validates ability to unsave a saved plan on AARP site
      #| MA Test Plans  | <MA_testPlans>  |
      #| PDP Test Plans | <PDP_testPlans> |
      #| SNP Test Plans | <SNP_testPlans> |
    #Then user validates unsave favorite plans will be stored within same session after zipcode change from Shop For a Plan on AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
      #| MA Test Plans   | <MA_testPlans>  |
      #| PDP Test Plans  | <PDP_testPlans> |
      #| SNP Test Plans  | <SNP_testPlans> |
#
    #Examples: 
      #| UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                            | PDP_testPlans                                                    | SNP_testPlans                              | planyear |
      #| 1598162 |   80001 | NO            | Jefferson County | AARP Medicare Advantage SecureHorizons Plan 2 (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) | current  |
#
  #@feature-F265872 @us1598162 @vppFavoritePlanRegressionUlayer3 @vppFavoritePlanInSession @vppFavoritePlanInSessionAarp @thePredators @Apr_release_2019 @prodRegression
  #Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can save and unsave favorite plans on view plan preview page for zipcode change within VPP on AARP site
    #Given the user is on AARP medicare acquisition site landing page
    #When the user performs plan search using following information in the AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
    #Then user validates plan count for all plan types on plan summary page in the AARP site
    #Then user validates selected plans can be saved as favorite on AARP site
      #| MA Test Plans  | <MA_testPlans>  |
      #| PDP Test Plans | <PDP_testPlans> |
      #| SNP Test Plans | <SNP_testPlans> |
      #| Plan Year      | <planyear>      |
    #Then user validates saved favorite plans will be stored within same session after zipcode change within VPP page on AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
      #| MA Test Plans   | <MA_testPlans>  |
      #| PDP Test Plans  | <PDP_testPlans> |
      #| SNP Test Plans  | <SNP_testPlans> |
    #Then user validates ability to unsave a saved plan on AARP site
      #| MA Test Plans  | <MA_testPlans>  |
      #| PDP Test Plans | <PDP_testPlans> |
      #| SNP Test Plans | <SNP_testPlans> |
    #Then user validates unsave favorite plans will be stored within same session after zipcode change within VPP page on AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
      #| MA Test Plans   | <MA_testPlans>  |
      #| PDP Test Plans  | <PDP_testPlans> |
      #| SNP Test Plans  | <SNP_testPlans> |
#
    #Examples: 
      #| UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                            | PDP_testPlans                                                    | SNP_testPlans                              | planyear |
      #| 1598162 |   80001 | NO            | Jefferson County | AARP Medicare Advantage SecureHorizons Plan 2 (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) | current  |
#
  #@feature-F265872 @us1598162 @vppFavoritePlanRegressionUlayer4 @vppFavoritePlanInSessionCloseTab @vppFavoritePlanInSessionCloseTabAarp @thePredators @Apr_release_2019
  #Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can favorite plans will be saved within session on view plan preview page by switching window tabs on AARP site
    #Given the user is on AARP medicare acquisition site landing page
    #When the user performs plan search using following information in the AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
    #Then user validates plan count for all plan types on plan summary page in the AARP site
    #Then user validates selected plans can be saved as favorite on AARP site
      #| MA Test Plans  | <MA_testPlans>  |
      #| PDP Test Plans | <PDP_testPlans> |
      #| SNP Test Plans | <SNP_testPlans> |
      #| Plan Year      | <planyear>      |
    #Then user closes the original tab and open new tab for AARP site
    #Then the user performs plan search using following information in the AARP site
      #| Zip Code        | <zipcode>       |
      #| County Name     | <county>        |
      #| Is Multi County | <isMultiCounty> |
    #Then user validates plans remain saved within same session for AARP site
      #| MA Test Plans  | <MA_testPlans>  |
      #| PDP Test Plans | <PDP_testPlans> |
      #| SNP Test Plans | <SNP_testPlans> |
#
    #Examples: 
      #| UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                            | PDP_testPlans                                                    | SNP_testPlans                              | planyear |
      #| 1598162 |   80001 | NO            | Jefferson County | AARP Medicare Advantage SecureHorizons Plan 2 (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) | current  |