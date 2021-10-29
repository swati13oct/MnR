Feature: UAT Scripts-To test Campaign TFN through all the flows in Prod

  #######################Script 1: Direct traffic########################################
  @Scenario_1_2_DirectTraffic_UAT_PROD @UATRegression @prodRegression_UAT
  Scenario Outline: <scenario> 1.0 Verify TFN in VPP Plan Details and OLE pages, DCE,
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user enter zipcode in homepage
      | Zip Code  | <zipcode>    |
      | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigate to following MedED Pages URL and validate Federal TFN
      | MedEd URL | <medicareUrl> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates back to page
    Then the user navigates to plan tab for any plan
      | Plan Type | <MSplantype> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <PDPplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to Plan Details Page for any plan and validates Federal TFN
      | Plan Type | <PDPplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to Plan Details Page for any plan for Enroll and validates Federal TFN
      | Plan Type | <PDPplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates back to page
    When user clicks on back to plans link to navigate plan summary
    Then the user navigates to plan tab for any plan
      | Plan Type | <MAplantype> |
    #Then the user navigates to homepage validates Federal TFN
    #Then the user enter zipcode in homepage
    #| Zip Code  | <zipcode>    |
    # | Plan Type | <MAplantype> |
    And the user clicks on the shopping cart icon
    #And the user clicks on the shsopping cart icon in AARP site
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to following memeber signin page and navigate to view medicare plans link AARP
      | Member Signin URL         | <memberSignIn>        |
      | Member Signin URL STG     | <memberSignInstage>   |
      | Member Signin URL Offline | <memberSignInOffline> |
    Then the user navigates to refresh page
    Then the user validates TFN Number
      | TFN No    | <memberTFNNo> |
      #| TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath>    |

    #------------------------------------------
    #Then the user validates PSC code
    #| PSC Code | <Precedence2PSC> |
    @Scenario_1_2_DirectTraffic_UAT_PROD_Medsup3.0 @campaignTFNProd
    Examples: 
      | scenario         | site | zipcode | TFNNo          | memberTFNNo    | MedSupTFN      | memberSignIn                  | memberSignInstage               | memberSignInOffline               | pscCode | maUrl                     | pdpUrl                       | snpUrl                                                                                                                                                                                                                                                                                                                      | medSuppUrl                                                                | medicareUrl             | site   | zipcode | plantype | isMultutiCounty | planyear | dceUrl                                                     | Precedence2PSC | PDPplantype | MAplantype | TFNxpath                          | MedsuppTFNxpath                   | DCETFNxpath                                                                                | MSplantype | userName        | password      |
      | Scenario 1 - AMP | AARP |   10001 | 1-877-699-5710 | 1-855-349-3447 | 1-866-408-5545 | https://www.medicare.uhc.com/ | https://stage-medicare.uhc.com/ | https://offline.medicare.uhc.com/ |  810027 | enroll/ma-enrollment.html | shop/estimate/pdp-costs.html | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | medicare-education.html | Ulayer |   80001 | MA       | No              | current  | health-plans/estimate-drug-costs.html#/drug-cost-estimator |        8009508 | PDP         | MA         | (//a[contains(@class, 'tel')])[3] | //*[contains(@class,'tel right')] | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | MS         | TiggerOptumID39 | TiggerTigger1 |

    @Scenario_1_2_DirectTraffic_UAT_PROD_Medsup4.0 @campaignTFNProd
    Examples: 
      | scenario         | site | zipcode | TFNNo          | memberTFNNo    | MedSupTFN      | memberSignIn                  | memberSignInstage               | memberSignInOffline               | pscCode | maUrl                     | pdpUrl                       | snpUrl                                                                                                                                                                                                                                                                                                                      | medSuppUrl                                                                | medicareUrl             | site   | zipcode | plantype | isMultutiCounty | planyear | dceUrl                                                     | Precedence2PSC | PDPplantype | MAplantype | TFNxpath                          | MedsuppTFNxpath                                    | DCETFNxpath                                                                                | MSplantype | userName        | password      |
      | Scenario 1 - AMP | AARP |   90210 | 1-877-699-5710 | 1-855-349-3447 | 1-866-408-5545 | https://www.medicare.uhc.com/ | https://stage-medicare.uhc.com/ | https://offline.medicare.uhc.com/ |  810027 | enroll/ma-enrollment.html | shop/estimate/pdp-costs.html | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | medicare-education.html | Ulayer |   80001 | MA       | No              | current  | health-plans/estimate-drug-costs.html#/drug-cost-estimator |        8009508 | PDP         | MA         | (//a[contains(@class, 'tel')])[3] | //*[contains(@class, 'invoca_swap text-bold tel')] | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | MS4.0      | TiggerOptumID39 | TiggerTigger1 |

  #######################Script 9: External Link Plan 11########################################
  @Scenario_9_External_Link_UAT_PROD @UATRegression @prodRegression_UAT
  Scenario Outline: <scenario> 1.0 Verify TFN through External Links
    #Given the user Starts WebDriver
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    #Given the user is on AARP medicare acquisition site from External Link and Land on MA Plans
    Given the user is on AARP External Link and Land on MA Plans
      | Campaign URL | <campaignUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to refresh page
    Then user validates TFN in header
    Then the user navigates to plan tab for any plan
      | Plan Type | <MAplantype> |
    Then the user navigates to Plan Details Page for any plan and validates Federal TFN
      | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    #And the user clicks on the shopping cart icon in AARP site
    And the user clicks on the shopping cart icon
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |

    @Scenario_9_External_Link_UAT_PROD_Medsup3.0 @campaignTFNProd
    Examples: 
      | scenario                      | site   | zipcode | MAplantype | pscCode | state   | campaignUrl                                                                        | medEdURL1                                  | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName        | password      | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      |
      | Scenerio 9-ExternalLink - AMP | ULayer |   10001 | MA         | 8000158 | Alabama | health-plans.html?zipcode=10001&WT.mc_id=8000158&county=420&state=36#/plan-summary | medicare-articles/medicare-made-clear.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID39 | TiggerTigger1 | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[2] |

    @Scenario_9_External_Link_UAT_PROD_Medsup4.0 @campaignTFNProd
    Examples: 
      | scenario                      | site   | zipcode | MAplantype | pscCode | state   | campaignUrl                                                                        | medEdURL1                                  | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName        | password      | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      |
      | Scenerio 9-ExternalLink - AMP | ULayer |   90210 | MA         | 8000158 | Alabama | health-plans.html?zipcode=90210&WT.mc_id=8000158&county=420&state=36#/plan-summary | medicare-articles/medicare-made-clear.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID39 | TiggerTigger1 | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[2] |

  #######################Script 1: Direct traffic########################################
  @Scenario_1_2_DirectTraffic__UHC_UAT_PROD @UATRegression
  Scenario Outline: <scenario>  Verify TFN in VPP Plan Details and OLE pages, DCE,
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then user validates TFN in header
    Then the user enter zipcode in homepage
      | Zip Code  | <zipcode>    |
      | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then user validates TFN in header
    Then the user navigate to following MedED Pages URL and validate Federal TFN
      | MedEd URL | <medicareUrl> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    When the user performs plan search using learn about medicare Pages
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <MAplantype> |
    Then user validates TFN in header
    Then the user navigates to Plan Details Page for any plan and validates Federal TFN
      | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates back to page
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <MSplantype> |
    Then user validates TFN in header
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <PDPplantype> |
    Then user validates TFN in header
    Then the user navigates to Plan Details Page for any plan and validates Federal TFN
      | Plan Type | <PDPplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to Plan Details Page for any plan for Enroll and validates Federal TFN
      | Plan Type | <PDPplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>          |
      | TFN Xpath | <EnrollTFNxpath> |
    #Then the user navigates back to page
    Then the user navigates to homepage validates Federal TFN
    #And the user clicks on the shopping cart icon in UHC site
    And the user clicks on the shopping cart icon
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then user validates TFN in header

    @Scenario_1_2_DirectTraffic__UHC_UAT_PROD_Medsup3.0 @campaignTFNProd
    Examples: 
      | scenario         | site | zipcode | TFNNo          | MedSupTFN      | isMultutiCounty | county         | pscCode | maUrl                     | pdpUrl                       | snpUrl                                                                                                                                                                                                                                                                                                                      | medSuppUrl                                                                | medicareUrl             | site   | zipcode | plantype | isMultutiCounty | planyear | dceUrl                                                     | Precedence2PSC | PDPplantype | MAplantype | TFNxpath                          | MedsuppTFNxpath                   | DCETFNxpath                                                                                | MSplantype | EnrollTFNxpath                    | userName        | password      | planyear |
      | Scenario 1 - UMS | UHC  |   10001 | 1-877-596-3258 | 1-888-378-0254 | NO              | Baldwin County |  880180 | enroll/ma-enrollment.html | shop/estimate/pdp-costs.html | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | medicare-education.html | Ulayer |   10001 | MA       | No              | future   | health-plans/estimate-drug-costs.html#/drug-cost-estimator |        8009508 | PDP         | MA         | (//a[contains(@class, 'tel')])[3] | //*[contains(@class,'tel right')] | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | MS         | (//a[contains(@class, 'tel')])[3] | TiggerOptumID39 | TiggerTigger1 | future   |

    @Scenario_1_2_DirectTraffic__UHC_UAT_PROD_Medsup4 @campaignTFNProd
    Examples: 
      | scenario         | site | zipcode | TFNNo          | MedSupTFN      | isMultutiCounty | county         | pscCode | maUrl                     | pdpUrl                       | snpUrl                                                                                                                                                                                                                                                                                                                      | medSuppUrl                                                                | medicareUrl             | site   | zipcode | plantype | isMultutiCounty | planyear | dceUrl                                                     | Precedence2PSC | PDPplantype | MAplantype | TFNxpath                          | MedsuppTFNxpath                                    | DCETFNxpath                                                                                | MSplantype | EnrollTFNxpath                    | userName        | password      | planyear |
      | Scenario 1 - UMS | UHC  |   90210 | 1-877-596-3258 | 1-888-378-0254 | NO              | Baldwin County |  880180 | enroll/ma-enrollment.html | shop/estimate/pdp-costs.html | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | medicare-education.html | Ulayer |   90210 | MA       | No              | future   | health-plans/estimate-drug-costs.html#/drug-cost-estimator |        8009508 | PDP         | MA         | (//a[contains(@class, 'tel')])[3] | //*[contains(@class, 'invoca_swap text-bold tel')] | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] | MS4.0      | (//a[contains(@class, 'tel')])[3] | TiggerOptumID39 | TiggerTigger1 | future   |

  ###################Script 6: External Link########################################
  @Scenario_6_External_Link_UHC_UAT_PROD @UATRegression
  Scenario Outline: <scenario>  Verify TFN through External Links
    #Given the user Starts WebDriver
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    #Given the user is on UHC medicare solutions acquisition site from Campaign Traffic
    Given the user is on UHC acquisition site from Campaign Traffic
      | Campaign URL | <campaignUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    #And the user clicks on the shopping cart icon in AARP site
    And the user clicks on the shopping cart icon
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |

    @Scenario_6_External_Link_UHC_UAT_PROD_Medsup3.0 @campaignTFNProd
    Examples: 
      | scenario                      | site   | state   | pscCode | campaignUrl                                                                                                                                                                                                                           | medEdURL1               | medEdTFN                           | shoppagesUrl                        | userName        | password      | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      |
      | Scenerio 6-ExternalLink - UMS | blayer | Alabama | 8002977 | health-plans/medicare-advantage-plans/available-plans.html?zipcode=10001&WT.mc_id=8002977&county=420&state=36&coveragePerson=M&originatingSite=https%253A%252F%252Fwww.myuhcplans.com%252Fmorganstanley&subdomain=group#/plan-summary | /medicare-articles.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | TiggerOptumID39 | TiggerTigger1 | 1-877-755-5345 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[2] |

    @Scenario_6_External_Link_UHC_UAT_PROD_Medsup4.0 @campaignTFNProd
    Examples: 
      | scenario                      | site   | state   | pscCode | campaignUrl                                                                                                                                                                                                                           | medEdURL1               | medEdTFN                           | shoppagesUrl                        | userName        | password      | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      |
      | Scenerio 6-ExternalLink - UMS | blayer | Alabama | 8002977 | health-plans/medicare-advantage-plans/available-plans.html?zipcode=90210&WT.mc_id=8002977&county=420&state=36&coveragePerson=M&originatingSite=https%253A%252F%252Fwww.myuhcplans.com%252Fmorganstanley&subdomain=group#/plan-summary | /medicare-articles.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | TiggerOptumID39 | TiggerTigger1 | 1-877-755-5345 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[2] |
