@campaignTFNStageMS
Feature: UAT Scripts-To test Campaign TFN for IS Medsup flows

  @Scenario_1_MS
  Scenario Outline: <scenario> <zipcode>1.0 Verify TFN in MS Plan Details, MS Summary, MS Visitor profie, and MS OLE pages
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user enter zipcode in homepage
      | Zip Code  | <zipcode>    |
      | Plan Type | <MSplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And user click on View Plan Details in MS plan
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    And user click on Back to Plan in MS Plan Details
      | Zip Code | <zipcode> |
    And user clicks on Edit Your Information link and navigate back to micro form
    And user updates Medsup form for user details
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    When user selects medsup plans to compare
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    And user click on Start Application in MS plan compare page
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then user click on Cancel Application in MS plan
      | Zip Code | <zipcode> |
    And the user clicks on the shopping cart icon
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |

    @MSScenario @campaignTFNStageMS @regressionAARP
    Examples: 
      | scenario                       | site | dob        | zipcode | FedTFNNo       | MedSupTFNNo    | memberTFNNo    | memberSignIn                  | memberSignInstage               | memberSignInOffline               | pscCode | maUrl                     | pdpUrl                       | snpUrl                                                                                                                                                                                                                                                                                                                      | medSuppUrl                                                                | medicareUrl             | site   | zipcode | MSplantype | isMultutiCounty | planyear | dceUrl                                                     | Precedence2PSC | PDPplantype | MAplantype | TFNxpath                          | MedsuppTFNxpath                                    | DCETFNxpath                                                               | MSplantype | userName          | password        | TFNxpath1                         | planyear | FedTFNNo       | MedSupTFNNo    | sourceCode | plantype | MSplantype | MS_Plan | MedSupStaticTFNNo | MedsuppTFNxpath                          | MedsuppStaticTFNxpath                                   |
      | Scenario 1 -IS- AMP Medsup 4.0 | AARP | 11/11/1950 |   90210 | 1-877-699-5710 | 1-866-408-5545 | 1-855-349-3447 | https://www.medicare.uhc.com/ | https://stage-medicare.uhc.com/ | https://offline.medicare.uhc.com/ |  810027 | enroll/ma-enrollment.html | shop/estimate/pdp-costs.html | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | medicare-education.html | Ulayer |   80001 | MS4.0      | No              | future   | health-plans/estimate-drug-costs.html#/drug-cost-estimator |        8009508 | PDP         | MS4.0      | (//a[contains(@class, 'tel')])[3] | //*[contains(@class, 'invoca_swap text-bold tel')] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | MS4.0      | TiggerOptumID3331 | FebruarY##123$! | (//a[contains(@class, 'tel')])[1] | future   | 1-877-699-5710 | 1-866-408-5545 | AEP        | MA       | MS4.0      | Plan G  | 1-866-603-3424    | //span[contains(@class,'text-bold tel')] | //*[@class='insured-member']//a[@class='tfn-call']/span |

  @Scenario_1_MS
  Scenario Outline: <scenario> <zipcode>1.0 Verify TFN in MS Plan Details, MS Summary, MS Visitor profie, and MS OLE pages
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user enter zipcode in homepage
      | Zip Code  | <zipcode>    |
      | Plan Type | <MSplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user fills all the details in MedsuppPage for TFN
      | DOB      | <dob>     |
      | Zip Code | <zipcode> |
    And user click on View Plan Details in MS plan
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    And user click on Back to Plan in MS Plan Details
      | Zip Code | <zipcode> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    When user selects medsup plans to compare
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    And user click on Start Application in MS plan compare page
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then user click on Cancel Application in MS plan
      | Zip Code | <zipcode> |
    And the user clicks on the shopping cart icon
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |

    @MSScenario @campaignTFNStageMS @regressionAARP
    Examples: 
      | scenario                       | site | dob        | zipcode | FedTFNNo       | MedSupTFNNo    | memberTFNNo    | memberSignIn                  | memberSignInstage               | memberSignInOffline               | pscCode | maUrl                     | pdpUrl                       | snpUrl                                                                                                                                                                                                                                                                                                                      | medSuppUrl                                                                | medicareUrl             | site   | zipcode | MSplantype | isMultutiCounty | planyear | dceUrl                                                     | Precedence2PSC | PDPplantype | MAplantype | TFNxpath                          | MedsuppTFNxpath                               | DCETFNxpath                                                               | MSplantype | userName          | password        | TFNxpath1                         | planyear | FedTFNNo       | MedSupTFNNo    | sourceCode | plantype | MSplantype | MS_Plan | MedSupStaticTFNNo | MedsuppTFNxpath                          |
      | Scenario 1 -IS- AMP Medsup 3.0 | AARP | 11/11/1950 |   23666 | 1-877-699-5710 | 1-866-408-5545 | 1-855-349-3447 | https://www.medicare.uhc.com/ | https://stage-medicare.uhc.com/ | https://offline.medicare.uhc.com/ |  810027 | enroll/ma-enrollment.html | shop/estimate/pdp-costs.html | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | medicare-education.html | Ulayer |   80001 | MS4.0      | No              | future   | health-plans/estimate-drug-costs.html#/drug-cost-estimator |        8009508 | PDP         | MS4.0      | (//a[contains(@class, 'tel')])[3] | (//*[contains(@class, 'invoca_swap tel')])[1] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | MS4.0      | TiggerOptumID3331 | FebruarY##123$! | (//a[contains(@class, 'tel')])[1] | future   | 1-877-699-5710 | 1-866-408-5545 | AEP        | MA       | MS4.0      | Plan G  | 1-866-603-3424    | //span[contains(@class,'text-bold tel')] |

  #######################IS_Script 2: AMS referral traffic ########################################
  @IS_TFN_E2E_Scenario_2 @UATRegression
  Scenario Outline: <scenario> <zipcode>1.0  Verify TFN  show correctly from AMS Referral Traffic
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>        |
      | Campaign URL | <campaignUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user enter zipcode in plan search page
      | Zip Code  | <zipcode>    |
      | Plan Type | <MSPlantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN on VPP
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    And user click on View Plan Details in MS plan
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    And user click on Back to Plan in MS Plan Details
      | Zip Code | <zipcode> |
    And user clicks on Edit Your Information link and navigate back to micro form
    And user updates Medsup form for user details
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    When user selects medsup plans to compare
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    And user click on Start Application in MS plan compare page
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then user click on Cancel Application in MS plan
      | Zip Code | <zipcode> |
    And the user clicks on the shopping cart icon
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>        |
      | TFN Xpath | <MedsuppTFNxpath1> |

    @IS_TFN_E2E_Scenario_2 @campaignTFNStageMS @campaignTFNProdMS @regressionAARP
    Examples: 
      | scenario                               | site   | zipcode | MAplantype | MSPlantype | pscCode | state   | campaignUrl                                                                                                                                                                                                                                                                                                                                               | medEdURL1                                        | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName          | password        | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | FedTFNNo       | MedSupTFNNo    | sourceCode | MedSupStaticTFNNo | MedsuppTFNxpath                          | MedsuppStaticTFNxpath                                   | MedsuppTFNxpath1                                                           |
      | IS_TFN_E2E_Scenario_2 - AMP-Medsup 4.0 | ULayer |   90210 | MA         | MS4.0      | 8003077 | Alabama | health-plans.html?WT.mc_id=8KH&product=medsup&intref=AARPMedicareSupplement.com&EBRC=https%3A%2F%2Fwww.aarpmedicaresupplement.com%2Fmedicare-information-guide.html&state=TX&HASHID=2475451813&mrcid=email_is_p&adobe_mc=MCMID%3D44598998069175401371739591939441775859%7CMCORGID%3D92E102BE5330583D0A490D4C%2540AdobeOrg%7CTS%3D1645783090#/plan-summary | medicare-education/medicare-advantage-plans.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID3331 | FebruarY##123$! | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | 1-855-322-3404 | 1-866-897-0688 | 8KH        | 1-866-603-3424    | //span[contains(@class,'text-bold tel')] | //*[@class='insured-member']//a[@class='tfn-call']/span | //div[contains(@class,'tfnClass')]//a[contains(@class,'toll-free-number')] |

  @IS_TFN_E2E_Scenario_2 @UATRegression
  Scenario Outline: <scenario> <zipcode>1.0  Verify TFN  show correctly from AMS Referral Traffic
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>        |
      | Campaign URL | <campaignUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    And user click on View Plan Details in MS plan
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    And user click on Back to Plan in MS Plan Details
      | Zip Code | <zipcode> |
    And user clicks on Edit Your Information link and navigate back to micro form
    And user updates Medsup form for user details
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    When user selects medsup plans to compare
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    And user click on Start Application in MS plan compare page
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then user click on Cancel Application in MS plan
      | Zip Code | <zipcode> |
    When Navigate to Visitor Profile page
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>        |
      | TFN Xpath | <MedsuppTFNxpath1> |

    @Scenario_IS_TFN_E2E_Scenario_2_Medsup4.0_23W @campaignTFNProdMS @campaignTFNStageMS @regressionAARP
    Examples: 
      | scenario                                            | site   | zipcode | MS_Plan | MAplantype | MSPlantype | pscCode | state   | campaignUrl                                                                                                                                                                              | medEdURL1                                        | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName          | password        | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | FedTFNNo       | MedSupTFNNo    | sourceCode | MedSupStaticTFNNo | MedsuppTFNxpath                          | MedsuppStaticTFNxpath                                   | MedsuppTFNxpath1                                                           |
      | Scenerio IS_TFN_E2E_Scenario_2 - AMP Medsup 4.0_23W | ULayer |   90210 | Plan G  | MA         | MS4.0      | 8003093 | Alabama | health-plans.html?product=medsup&EBRC=https://www.aarpmedicaresupplement.com/medicare-information-guide.html&intref=AARPMedicareSupplement.com&zipcode=90210&WT.mc_id=23W&#/plan-summary | medicare-education/medicare-advantage-plans.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID3331 | FebruarY##123$! | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | 1-855-888-1640 | 1-866-242-0247 | 23W        | 1-866-603-3424    | //span[contains(@class,'text-bold tel')] | //*[@class='insured-member']//a[@class='tfn-call']/span | //div[contains(@class,'tfnClass')]//a[contains(@class,'toll-free-number')] |

  Scenario Outline: <scenario> <zipcode>1.0  Verify TFN  show correctly from AMS Referral Traffic
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>        |
      | Campaign URL | <campaignUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user enter zipcode in plan search page
      | Zip Code  | <zipcode>    |
      | Plan Type | <MSPlantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN on VPP
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user fills all the details in MedsuppPage for TFN
      | DOB      | <dob>     |
      | Zip Code | <zipcode> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    And user click on View Plan Details in MS plan
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    And user click on Back to Plan in MS Plan Details
      | Zip Code | <zipcode> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    When user selects medsup plans to compare
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>        |
      | TFN Xpath | <MedsuppTFNxpath2> |
    And user click on Start Application in MS plan compare page
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then user click on Cancel Application in MS plan
      | Zip Code | <zipcode> |
    When Navigate to Visitor Profile page
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>        |
      | TFN Xpath | <MedsuppTFNxpath1> |

    @IS_TFN_E2E_Scenario_2 @campaignTFNStageMS @campaignTFNProdMS @regressionAARP
    Examples: 
      | scenario                               | site   | zipcode | dob        | MAplantype | MSPlantype | pscCode | state   | campaignUrl                                                                                                                                                                                                                                                                                                                                               | medEdURL1                                        | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName          | password        | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | FedTFNNo       | MedSupTFNNo    | sourceCode | MedSupStaticTFNNo | MedsuppTFNxpath                             | MedsuppStaticTFNxpath | MedsuppTFNxpath1                                                           | MedsuppTFNxpath2                                                             |
      | IS_TFN_E2E_Scenario_2 - AMP-Medsup 3.0 | ULayer |   23666 | 11/11/1950 | MA         | MS4.0      | 8003077 | Alabama | health-plans.html?WT.mc_id=8KH&product=medsup&intref=AARPMedicareSupplement.com&EBRC=https%3A%2F%2Fwww.aarpmedicaresupplement.com%2Fmedicare-information-guide.html&state=TX&HASHID=2475451813&mrcid=email_is_p&adobe_mc=MCMID%3D44598998069175401371739591939441775859%7CMCORGID%3D92E102BE5330583D0A490D4C%2540AdobeOrg%7CTS%3D1645783090#/plan-summary | medicare-education/medicare-advantage-plans.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID3331 | FebruarY##123$! | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | 1-855-322-3404 | 1-866-897-0688 | 8KH        | 1-866-603-3424    | //span[contains(@class,'tel rightRailDTM')] | //span[@class='tel']  | //div[contains(@class,'tfnClass')]//a[contains(@class,'toll-free-number')] | //*[contains(@class,'callForQuestionsHeader')]//span[contains(@class,'tel')] |

  ####################### Script IS_ Scenario 4: UHC Referral TrafficL ########################################
  @Scenario_IS_Scenario4_UHCReferralTraffic_UAT @UATRegression
  Scenario Outline: <scenario> <zipcode>1.0 Verify TFN show correctly from UHC Referral Traffic
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>        |
      | Campaign URL | <campaignUrl> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <MSPlantype> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    And user clicks on Edit Your Information link and navigate back to micro form
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    And user updates Medsup form for user details
    And user click on View Plan Details in MS plan
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    And user click on Start Application from MS plan details
      | Zip Code | <zipcode> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>        |
      | TFN Xpath | <MedsuppTFNxpath2> |
    Then user click on Cancel Application in MS plan
      | Zip Code | <zipcode> |
    When Navigate to Visitor Profile page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>        |
      | TFN Xpath | <MedsuppTFNxpath1> |

    @Scenario_IS-4_UHCReferralTraffic_UAT_Medsup4.0 @campaignTFNStageMS @IS_TFN_E2E_Scenario_4 @campaignTFNProdMS @regressionUHC
    Examples: 
      | scenario                                          | site   | zipcode | MAplantype | MSPlantype | pscCode | state   | campaignUrl                                                                    | medEdURL1                                        | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName          | password        | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | FedTFNNo       | MedSupTFNNo    | sourceCode | MedSupStaticTFNNo | MedsuppStaticTFNxpath                                   | MedsuppTFNxpath2                                              | MedsuppTFNxpath                          | MedsuppTFNxpath1                                                           |
      | Scenerio IS-4-UHCReferralTraffic - UMS Medsup 4.0 | BLayer |   90210 | MA         | MS4.0      |  832935 | Alabama | health-plans.html?WT.mc_id=832935&test_version=UMS&zipcode=90210#/plan-summary | medicare-education/medicare-advantage-plans.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID3331 | FebruarY##123$! | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | 1-855-259-8119 | 1-866-462-4046 | 2RZ        | 1-866-603-3424    | //*[@class='insured-member']//a[@class='tfn-call']/span | //*[contains(@class,'content')]//span[contains(@class,'tel')] | //span[contains(@class,'text-bold tel')] | //div[contains(@class,'tfnClass')]//a[contains(@class,'toll-free-number')] |

  @Scenario_IS_Scenario4_UHCReferralTraffic_UAT @UATRegression
  Scenario Outline: <scenario> <zipcode>1.0 Verify TFN show correctly from UHC Referral Traffic
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>        |
      | Campaign URL | <campaignUrl> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <MSPlantype> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user fills all the details in MedsuppPage for TFN
      | DOB      | <dob>     |
      | Zip Code | <zipcode> |
    And user click on View Plan Details in MS plan
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    And user click on Start Application from MS plan details
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then user click on Cancel Application in MS plan
      | Zip Code | <zipcode> |
    When Navigate to Visitor Profile page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |

    @Scenario_IS-4_UHCReferralTraffic_UAT_Medsup3.0 @campaignTFNStageMS123 @IS_TFN_E2E_Scenario_4 @campaignTFNProdMS @regressionUHC
    Examples: 
      | scenario                                          | site   | zipcode | dob        | MAplantype | MSPlantype | pscCode | state   | campaignUrl                                                                    | medEdURL1                                        | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName          | password        | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | FedTFNNo       | MedSupTFNNo    | sourceCode | MedSupStaticTFNNo | MedsuppStaticTFNxpath |
      | Scenerio IS-4-UHCReferralTraffic - UMS Medsup 3.0 | BLayer |   23666 | 11/11/1950 | MA         | MS         |  832935 | Alabama | health-plans.html?WT.mc_id=832935&test_version=UMS&zipcode=23666#/plan-summary | medicare-education/medicare-advantage-plans.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID3331 | FebruarY##123$! | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | 1-855-259-8119 | 1-866-462-4046 | 2RZ        | 1-866-603-3424    | //span[@class='tel']  |

  #######################Script 5: Source Code in URL ########################################
  @Scenario_5_SourceCodeInURL_UAT @UATRegression
  Scenario Outline: <scenario> <zipcode>1.0 Verify TFN and source code from URL
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>        |
      | Campaign URL | <campaignUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user enter zipcode in homepage
      | Zip Code  | <zipcode>    |
      | Plan Type | <MSPlantype> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN on VPP
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    When Navigate to Visitor Profile page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL | <medEdURL1> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    When user click on "Contact" link under more
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |

    @Scenario_5_SourceCodeInURL_UAT_Medsup3.0 @IS_TFN_E2E_Scenario_5 @campaignTFNStageMS @regressionAARP
    Examples: 
      | scenario                                    | site   | zipcode | MAplantype | MSPlantype | pscCode | state   | campaignUrl   | medEdURL1                                        | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName          | password        | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | FedTFNNo       | MedSupTFNNo    | sourceCode |
      | Scenerio 5-SourceCodeInURL - AMP-Medsup 3.0 | ULayer |   23666 | MA         | MS         |  810106 | Alabama | ?WT.mc_id=5T9 | medicare-education/medicare-advantage-plans.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID3331 | FebruarY##123$! | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | 1-800-850-6807 | 1-866-327-1593 | 5T9        |

    @Scenario_5_SourceCodeInURL_UAT_Medsup4.0 @campaignTFNStageMS @regressionAARP
    Examples: 
      | scenario                                   | site   | zipcode | MAplantype | MSPlantype | pscCode | state   | campaignUrl   | medEdURL1                                        | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName          | password        | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | FedTFNNo       | MedSupTFNNo    | sourceCode |
      | Scenerio 5-SourceCodeInURL - AMP-Medsup4.0 | ULayer |   90210 | MA         | MS4.0      |  810106 | Alabama | ?WT.mc_id=5T9 | medicare-education/medicare-advantage-plans.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID3331 | FebruarY##123$! | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | 1-800-850-6807 | 1-866-327-1593 | 5T9        |

  @Scenario_6_MS
  Scenario Outline: <scenario> <zipcode>1.0 Verify TFN show correctly from UMS direct traffic
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user enter zipcode in homepage
      | Zip Code  | <zipcode>    |
      | Plan Type | <MSplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And user click on View Plan Details in MS plan
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    And user click on Back to Plan in MS Plan Details
      | Zip Code | <zipcode> |
    And user clicks on Edit Your Information link and navigate back to micro form
    #And user updates Medsup form for user details
    Then user click to close MS application Modal
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    When user selects medsup plans to compare
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    And user click on Start Application in MS plan compare page
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    And the user clicks on the shopping cart icon
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |

    @Scenario_6_DirectTraffic__UHC_UAT_medsup4.0 @campaignTFNStageMS @IS_TFN_Scenario_6 @campaignTFNProdMS @regressionUHC
    Examples: 
      | scenario                    | site | zipcode | FedTFNNo       | MedSupTFNNo    | isMultutiCounty | county             | pscCode | maUrl                     | pdpUrl                       | snpUrl                                                                                                                                                                                                                                                                                                                      | medSuppUrl                                                                | medicareUrl             | site   | zipcode | plantype | isMultutiCounty | planyear | dceUrl                                                     | Precedence2PSC | PDPplantype | MAplantype | TFNxpath                          | MedsuppTFNxpath                                                           | DCETFNxpath                                                               | MSplantype | EnrollTFNxpath                    | userName          | password        | FedTFNNo       | MedSupTFNNo    | sourceCode | decisionGuideTFN                            | MedsuppFormTFNxpath                         | dob        | agentXpath                          | MedSupStaticTFNNo | MedsuppStaticTFNxpath                                   |
      | Scenario 6 - UMS Medsup 4.0 | UHC  |   90210 | 1-877-596-3258 | 1-888-378-0254 | NO              | Los Angeles County |  880180 | enroll/ma-enrollment.html | shop/estimate/pdp-costs.html | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | medicare-education.html | Ulayer |   90210 | MA       | No              | current  | health-plans/estimate-drug-costs.html#/drug-cost-estimator |        8009508 | PDP         | MA         | (//a[contains(@class, 'tel')])[3] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | MS4.0      | (//a[contains(@class, 'tel')])[3] | TiggerOptumID3331 | FebruarY##123$! | 1-877-596-3258 | 1-888-378-0254 | AEP        | //span[contains(@class, 'invoca_swap_sam')] | //span[contains(@class, 'invoca_swap_sam')] | 01/01/1950 | //*[contains(@class,'headline')]//a | 1-866-603-3424    | //*[@class='insured-member']//a[@class='tfn-call']/span |

  @Scenario_6_MS
  Scenario Outline: <scenario> <zipcode>1.0 Verify TFN show correctly from UMS direct traffic
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user enter zipcode in homepage
      | Zip Code  | <zipcode>    |
      | Plan Type | <MSplantype> |
    Then the user fills all the details in MedsuppPage for TFN
      | DOB      | <dob>     |
      | Zip Code | <zipcode> |
    And user click on View Plan Details in MS plan
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    And user click on Back to Plan in MS Plan Details
      | Zip Code | <zipcode> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    When user selects medsup plans to compare
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    And user click on Start Application in MS plan compare page
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then user click on Cancel Application in MS plan
      | Zip Code | <zipcode> |
    And the user clicks on the shopping cart icon
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |

    @Scenario_6_DirectTraffic__UHC_UAT_medsup3.0 @campaignTFNStageMS @IS_TFN_Scenario_6 @campaignTFNProdMS @regressionUHC
    Examples: 
      | scenario                    | site | zipcode | dob        | FedTFNNo       | MedSupTFNNo    | isMultutiCounty | county             | pscCode | maUrl                     | pdpUrl                       | snpUrl                                                                                                                                                                                                                                                                                                                      | medSuppUrl                                                                | medicareUrl             | site   | plantype | isMultutiCounty | planyear | dceUrl                                                     | Precedence2PSC | PDPplantype | MAplantype | TFNxpath                          | MedsuppTFNxpath                                                           | DCETFNxpath                                                               | MSplantype | EnrollTFNxpath                    | userName          | password        | FedTFNNo       | MedSupTFNNo    | sourceCode | decisionGuideTFN                            | MedsuppFormTFNxpath                         | dob        | agentXpath                          | MedSupStaticTFNNo | MedsuppStaticTFNxpath |
      | Scenario 6 - UMS Medsup 3.0 | UHC  |   23666 | 11/11/1950 | 1-877-596-3258 | 1-888-378-0254 | NO              | Los Angeles County |  880180 | enroll/ma-enrollment.html | shop/estimate/pdp-costs.html | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=23666&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | medicare-education.html | Ulayer | MA       | No              | current  | health-plans/estimate-drug-costs.html#/drug-cost-estimator |        8009508 | PDP         | MA         | (//a[contains(@class, 'tel')])[3] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | MS4.0      | (//a[contains(@class, 'tel')])[3] | TiggerOptumID3331 | FebruarY##123$! | 1-877-596-3258 | 1-888-378-0254 | AEP        | //span[contains(@class, 'invoca_swap_sam')] | //span[contains(@class, 'invoca_swap_sam')] | 01/01/1950 | //*[contains(@class,'headline')]//a | 1-866-603-3424    | //span[@class='tel']  |

  #######################IS_TFN_E2E Scenario 8 & 9: VPP (eInquiry) ########################################
  @Scenario_IS_TFN_E2E_Scenario_8_and_9_UAT @UATRegression
  Scenario Outline: <scenario> <zipcode>1.0 Verify TFN showing correctly through VPP eInquiry
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>        |
      | Campaign URL | <campaignUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN on VPP
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    And user click on View Plan Details in MS plan
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    And user click on Back to Plan in MS Plan Details
      | Zip Code | <zipcode> |
    And user clicks on Edit Your Information link and navigate back to micro form
    And user updates Medsup form for user details
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    When user selects medsup plans to compare
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    And user click on Start Application in MS plan compare page
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |

    @Scenario_IS_TFN_E2E_Scenario_8_Medsup4.0 @campaignTFNStageMS @regressionAARP
    Examples: 
      | scenario                                        | site   | zipcode | MS_Plan | MAplantype | MSPlantype | pscCode | state   | campaignUrl                                                                                                                       | medEdURL1                                        | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName          | password        | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | FedTFNNo       | MedSupTFNNo    | sourceCode | MedSupStaticTFNNo | MedsuppTFNxpath                          | MedsuppStaticTFNxpath                                   |
      | Scenerio IS_TFN_E2E_Scenario_8 - AMP Medsup 4.0 | ULayer |   90210 | Plan G  | MA         | MS4.0      | 8003076 | Alabama | health-plans.html?product=medsup&WT.mc_id=2YP&HASHID=2475451813&zipcode=90210&DOB=1952-03-18&EBRC=&mrcid=email_is_p#/plan-summary | medicare-education/medicare-advantage-plans.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID3331 | FebruarY##123$! | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | 1-855-322-3402 | 1-844-230-1339 | 2YP        | 1-866-603-3424    | //span[contains(@class,'text-bold tel')] | //*[@class='insured-member']//a[@class='tfn-call']/span |

    @Scenario_IS_TFN_E2E_Scenario_9_Medsup4.0 @campaignTFNStageMS @regressionAARP
    Examples: 
      | scenario                                        | site   | zipcode | MS_Plan | MAplantype | MSPlantype | pscCode | state   | campaignUrl                                                                                                                                                                                                                                                                                                                                                     | medEdURL1                                        | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName          | password        | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | FedTFNNo       | MedSupTFNNo    | sourceCode | MedSupStaticTFNNo | MedsuppTFNxpath                          | MedsuppStaticTFNxpath                                   |
      | Scenerio IS_TFN_E2E_Scenario_9 - AMP Medsup 4.0 | ULayer |   90210 | Plan G  | MA         | MS4.0      | 8003077 | Alabama | health-plans.html?product=medsup&EBRC=https://www.aarpmedicaresupplement.com/medicare-information-guide.html&intref=AARPMedicareSupplement.com&adobe_mc=MCMID%3D44598998069175401371739591939441775859%7CMCORGID%3D92E102BE5330583D0A490D4C%2540AdobeOrg%7CTS%3D1645778514&zipcode=90210&WT.mc_id=8KH&state=TX&HASHID=2475451813&mrcid=email_is_p#/plan-summary | medicare-education/medicare-advantage-plans.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID3331 | FebruarY##123$! | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | 1-855-322-3404 | 1-866-897-0688 | 8KH        | 1-866-603-3424    | //span[contains(@class,'text-bold tel')] | //*[@class='insured-member']//a[@class='tfn-call']/span |

  @Scenario_IS_TFN_E2E_Scenario_8_and_9_UAT @UATRegression
  Scenario Outline: <scenario> <zipcode>1.0 Verify TFN showing correctly through VPP eInquiry
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>        |
      | Campaign URL | <campaignUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user fills all the details in MedsuppPage for TFN
      | DOB      | <dob>     |
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN on VPP
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    And user click on View Plan Details in MS plan
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    And user click on Back to Plan in MS Plan Details
      | Zip Code | <zipcode> |
    Then the user validates TFN in Already an insured section
      | TFN No    | <MedSupStaticTFNNo>     |
      | TFN Xpath | <MedsuppStaticTFNxpath> |
    When user selects medsup plans to compare
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
    And user click on Start Application in MS plan compare page
      | Zip Code | <zipcode> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |

    @Scenario_IS_TFN_E2E_Scenario_8_Medsup3.0 @campaignTFNStageMS @regressionAARP
    Examples: 
      | scenario                                        | site   | zipcode | MS_Plan | MAplantype | MSPlantype | pscCode | state   | campaignUrl                                                                                                                       | medEdURL1                                        | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName          | password        | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | FedTFNNo       | MedSupTFNNo    | sourceCode | MedSupStaticTFNNo | MedsuppTFNxpath                             | MedsuppStaticTFNxpath |
      | Scenerio IS_TFN_E2E_Scenario_8 - AMP Medsup 3.0 | ULayer |   23666 | Plan G  | MA         | MS         | 8003076 | Alabama | health-plans.html?product=medsup&WT.mc_id=2YP&HASHID=2475451813&zipcode=23666&DOB=1952-03-18&EBRC=&mrcid=email_is_p#/plan-summary | medicare-education/medicare-advantage-plans.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID3331 | FebruarY##123$! | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | 1-855-322-3402 | 1-844-230-1339 | 2YP        | 1-866-603-3424    | //span[contains(@class,'tel rightRailDTM')] | //span[@class='tel']  |

    @Scenario_IS_TFN_E2E_Scenario_9_Medsup3.0 @campaignTFNStageMS @regressionAARP
    Examples: 
      | scenario                                        | site   | zipcode | dob        | MS_Plan | MAplantype | MSPlantype | pscCode | state   | campaignUrl                                                                                                                                                                                                                                                                                                                                                     | medEdURL1                                        | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName          | password        | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | FedTFNNo       | MedSupTFNNo    | sourceCode | MedSupStaticTFNNo | MedsuppTFNxpath                             | MedsuppStaticTFNxpath |
      | Scenerio IS_TFN_E2E_Scenario_9 - AMP Medsup 3.0 | ULayer |   23666 | 11/11/1950 | Plan G  | MA         | MS         | 8003077 | Alabama | health-plans.html?product=medsup&EBRC=https://www.aarpmedicaresupplement.com/medicare-information-guide.html&intref=AARPMedicareSupplement.com&adobe_mc=MCMID%3D44598998069175401371739591939441775859%7CMCORGID%3D92E102BE5330583D0A490D4C%2540AdobeOrg%7CTS%3D1645778514&zipcode=23666&WT.mc_id=8KH&state=TX&HASHID=2475451813&mrcid=email_is_p#/plan-summary | medicare-education/medicare-advantage-plans.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID3331 | FebruarY##123$! | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | 1-855-322-3404 | 1-866-897-0688 | 8KH        | 1-866-603-3424    | //span[contains(@class,'tel rightRailDTM')] | //span[@class='tel']  |
