@campaignTFN @regressionAARP @campaignTFNStage
Feature: 1.19.1 UAT Scripts-To test Campaign TFN in all flows on AARP site

  #######################Script 1: Direct traffic########################################
  @Scenario_1_2_DirectTraffic_UAT @UATRegression
  Scenario Outline: <scenario> <zipcode>1.0 Verify TFN in VPP Plan Details and OLE pages, DCE,
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
      | Plan Type | <MAplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then user validates TFN in header
    Then the user validates TFN Number in header and SAM icon
    Then the user navigate to following MedED Pages URL and validate Federal TFN
      | MedEd URL | <medicareUrl> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number in header and SAM icon
    Then the user navigates back to page
    Then the user navigates to plan tab for any plan
      | Plan Type | <MSplantype> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
    #Then the user validates TFN Number in header and SAM icon
    Then the user navigates to plan tab for any plan
      | Plan Type | <PDPplantype> |
    #Then the user validates TFN Number in header and SAM icon
    Then the user navigates to Plan Details Page for any plan and validates Federal TFN
      | Plan Type | <PDPplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates TFN Number in header and SAM icon
    Then the user navigates to Plan Details Page for any plan for Enroll and validates Federal TFN
      | Plan Type | <PDPplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to homepage validates Federal TFN
    #And the user clicks on the shopping cart icon in AARP site
    And the user clicks on the shopping cart icon
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then user validates TFN in header
    #---------------commenting the lines from 1.08 to 1.11 in production as mentioned by UAT related to Authenticated user -----------------#
    And the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    #And the user clicks on the add plans button in the profile
    And the user clicks on the add plans button in the profile in agent mode
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number in header and SAM icon
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <MAplantype> |
    #Then the user validates TFN Number in header and SAM icon
    Then the user navigates to Plan Details Page for any plan and validates Federal TFN
      | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    #Then the user validates TFN Number in header and SAM icon
    Then the user navigates to following  DCE Page URL and validate Federal TFN
      | DCE URL | <dceUrl> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>       |
      | TFN Xpath | <DCETFNxpath> |
    Then the user validates TFN Number in header and SAM icon
    #---------------Removing the above lines in production from 1.08 to 1.11-----------------#
    Then the user navigates to following memeber signin page and navigate to view medicare plans link AARP
      | Member Signin URL         | <memberSignIn>        |
      | Member Signin URL STG     | <memberSignInstage>   |
      | Member Signin URL Offline | <memberSignInOffline> |
    Then the user navigates to refresh page
    Then the user validates TFN Number
      # | TFN No    | <memberTFNNo> |
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath1> |

    #Then the user validates PSC code
    #| PSC Code | <Precedence2PSC> |
    @Scenario_1_2_DirectTraffic_UAT_Medsup3.0
    Examples: 
      | scenario         | site | zipcode | TFNNo          | MedSupTFN      | memberTFNNo    | memberSignIn                  | memberSignInstage               | memberSignInOffline               | pscCode | maUrl                     | pdpUrl                       | snpUrl                                                                                                                                                                                                                                                                                                                      | medSuppUrl                                                                | medicareUrl             | site   | zipcode | plantype | isMultutiCounty | planyear | dceUrl                                                     | Precedence2PSC | PDPplantype | MAplantype | TFNxpath                          | MedsuppTFNxpath                   | DCETFNxpath                                                               | MSplantype | userName        | password      | TFNxpath1                         | planyear | FedTFNNo       | MedSupTFNNo    | sourceCode |
      | Scenario 1 - AMP | AARP |   10001 | 1-877-699-5710 | 1-866-408-5545 | 1-855-349-3447 | https://www.medicare.uhc.com/ | https://stage-medicare.uhc.com/ | https://offline.medicare.uhc.com/ |  810027 | enroll/ma-enrollment.html | shop/estimate/pdp-costs.html | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | medicare-education.html | Ulayer |   80001 | MA       | No              | current  | health-plans/estimate-drug-costs.html#/drug-cost-estimator |        8009508 | PDP         | MA         | (//a[contains(@class, 'tel')])[3] | //*[contains(@class,'tel right')] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | MS         | TiggerOptumID39 | TiggerTigger7 | (//a[contains(@class, 'tel')])[1] | future   | 1-877-699-5710 | 1-866-408-5545 | AEP        |

    @Scenario_1_2_DirectTraffic_UAT_Medsup4.0
    Examples: 
      | scenario         | site | zipcode | TFNNo          | MedSupTFN      | memberTFNNo    | memberSignIn                  | memberSignInstage               | memberSignInOffline               | pscCode | maUrl                     | pdpUrl                       | snpUrl                                                                                                                                                                                                                                                                                                                      | medSuppUrl                                                                | medicareUrl             | site   | zipcode | plantype | isMultutiCounty | planyear | dceUrl                                                     | Precedence2PSC | PDPplantype | MAplantype | TFNxpath                          | MedsuppTFNxpath                                    | DCETFNxpath                                                               | MSplantype | userName        | password      | TFNxpath1                         | planyear | FedTFNNo       | MedSupTFNNo    | sourceCode |
      | Scenario 1 - AMP | AARP |   90210 | 1-877-699-5710 | 1-866-408-5545 | 1-855-349-3447 | https://www.medicare.uhc.com/ | https://stage-medicare.uhc.com/ | https://offline.medicare.uhc.com/ |  810027 | enroll/ma-enrollment.html | shop/estimate/pdp-costs.html | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | medicare-education.html | Ulayer |   80001 | MA       | No              | current  | health-plans/estimate-drug-costs.html#/drug-cost-estimator |        8009508 | PDP         | MA         | (//a[contains(@class, 'tel')])[3] | //*[contains(@class, 'invoca_swap text-bold tel')] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | MS4.0      | TiggerOptumID39 | TiggerTigger7 | (//a[contains(@class, 'tel')])[1] | future   | 1-877-699-5710 | 1-866-408-5545 | AEP        |

  #######################Script 2: Campaign traffic########################################
  @Scenario_2_CampaignTraffic_UAT @UATRegression @prodRegression_UAT
  Scenario Outline: <scenario> <zipcode>Verify TFN for different plan types through Campaign Traffic
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaignUrl2> |
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
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user enter zipcode in homepage
      | Zip Code  | <zipcode>    |
      | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    ###------STEP 2.02--------#
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>        |
      | Campaign URL | <campaignUrl> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to shop pages Page and validates Federal TFN
      | SHOPPAGES URL | <medSuppUrl> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo> |
      | TFN Xpath | <ShopTFNxpath> |
    # Then the user navigates back to page
    #When the user performs plan search using Shop Pages for campaign Links
    When the user performs plan search using Shop Pages for Medsupp Page
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <MAplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to Plan Details Page for any plan and validates Federal TFN
      | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to Plan Details Page for any plan for Enroll and validates Federal TFN
      | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>          |
      | TFN Xpath | <EnrollTFNxpath> |
    Then the user navigates to homepage validates Federal TFN
    Then the user enter zipcode in homepage
      | Zip Code  | <zipcode>    |
      | Plan Type | <MAplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <MSplantype> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>     |
      | TFN Xpath | <MedsuppTFNxpath1> |
    #Then the site user fills all the details in MedsuppPage for TFN
    # | DOB | <dob> |
    Then the user fills all the details in MedsuppPage for TFN
      | DOB      | <dob>     |
      | Zip Code | <zipcode> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>        |
      | TFN Xpath | <MedsuppFormTFNxpath> |
    #When the user clicks on Agent link for MedsuppPage
    # | TFN No    | <agentTFN>   |
    #| TFN Xpath | <agentXpath> |
    Then the user clicks on decision guide for MedsuppPge
      | Zip Code | <zipcode> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>     |
      | TFN Xpath | <decisionGuideTFN> |
   # Then the user navigates back to page
   Then the user click on back to previous page on Request a Free Decision Guide
    | Zip Code | <zipcode> |
    When the user clicks on Agent link for MedsuppPage
      | TFN No    | <agentTFN>   |
      | TFN Xpath | <agentXpath> |
      | Zip Code  | <zipcode>    |
    #Then the user clicks on decision guide for MedsuppPge
    #Then the user clicks on Request a Free Decision Guide
    # | TFN No    | <MedsuppTFNNo> |
    #| TFN Xpath | <TFNxpath>     |
    Then the user navigates to plan tab for any plan
      | Plan Type | <PDPplantype> |
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
    Then the user navigates to shop pages Page and validates Federal TFN
      | SHOPPAGES URL | <shoppages>    |
      | TFN Xpath     | <shoppagesTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |

    @Scenario_2_CampaignTraffic_UAT_Medsup3.0 @campaignTFNProd
    Examples: 
      | scenario         | planyear | zipcode | MSplantype | dob        | UHCUrl                      | planName                            | MAplantype | PDPplantype | isMultutiCounty | county         | pscCode | site   | campaignUrl                                                   | maUrl                     | maTFN                                                   | pdpUrl                     | pdpTFN                                                         | snpUrl                                                                                                                                                                                                                                                                                                                      | snpTFN                       | decisionGuideUrl                                                          | decisionGuideTFN | agentApptUrl                                                  | agentApptTFN   | medSuppUrl                          | shoppages        | campaignUrl2       | TFNNo          | TFNxpath                          | MedsuppTFNNo   | MedsuppTFNxpath1                  | MedsuppTFNxpath                   | EnrollTFNxpath                    | MedsuppShopTFNxpath               | ShopTFNxpath                                                              | agentTFN       | agentXpath                          | planyear | FedTFNNo       | MedSupTFNNo    | sourceCode | MedsuppFormTFNxpath               |
      | Scenario 2 - AMP | current  |   10001 | MS         | 01/01/1950 | https://www.myuhcagent.com/ | AARP Medicare Advantage Prime (HMO) | MA         | PDP         | NO              | Baldwin County | 8001038 | ulayer | /shop/medicare-advantage-plans?zipcode=10001&WT.mc_id=8001038 | enroll/ma-enrollment.html | //*[contains(@class,'call')]//a[contains(@class,'tel')] | enroll/pdp-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn']   | health-plans/medicare-supplement-plans/agent-appointment.html | //*[@id='tfn'] | shop/medicare-supplement-plans.html | /contact-us.html | /?wt.mc_id=8001038 | 1-877-541-7755 | (//a[contains(@class, 'tel')])[3] | 1-844-887-2813 | //*[contains(@class,'tel right')] | (//a[contains(@class, 'tel')])[2] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[2] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | 1-877-596-3258 | //*[contains(@class,'headline')]//a | current  | 1-877-541-7755 | 1-844-887-2813 | 9C9        | //*[contains(@class,'tel right')] |

    @Scenario_2_CampaignTraffic_UAT_Medsup4.0 @campaignTFNProd
    Examples: 
      | scenario         | planyear | zipcode | MSplantype | dob        | UHCUrl                      | planName                            | MAplantype | PDPplantype | isMultutiCounty | county         | pscCode | site   | campaignUrl                                                   | maUrl                     | maTFN                                                   | pdpUrl                     | pdpTFN                                                         | snpUrl                                                                                                                                                                                                                                                                                                                      | snpTFN                       | decisionGuideUrl                                                          | decisionGuideTFN | agentApptUrl                                                  | agentApptTFN   | medSuppUrl                          | shoppages        | campaignUrl2       | TFNNo          | TFNxpath                          | MedsuppTFNNo   | MedsuppTFNxpath1                                   | MedsuppTFNxpath                   | EnrollTFNxpath                    | MedsuppShopTFNxpath               | ShopTFNxpath                                                              | agentTFN       | agentXpath                          | planyear | FedTFNNo       | MedSupTFNNo    | sourceCode | MedsuppFormTFNxpath                         |
      | Scenario 2 - AMP | current  |   90210 | MS4.0      | 01/01/1950 | https://www.myuhcagent.com/ | AARP Medicare Advantage Prime (HMO) | MA         | PDP         | NO              | Baldwin County | 8001038 | ulayer | /shop/medicare-advantage-plans?zipcode=90210&WT.mc_id=8001038 | enroll/ma-enrollment.html | //*[contains(@class,'call')]//a[contains(@class,'tel')] | enroll/pdp-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //span[contains(@class, 'invoca_swap_sam')] | health-plans/medicare-supplement-plans/agent-appointment.html | //*[@id='tfn'] | shop/medicare-supplement-plans.html | /contact-us.html | /?wt.mc_id=8001038 | 1-877-541-7755 | (//a[contains(@class, 'tel')])[3] | 1-844-887-2813 | //*[contains(@class, 'invoca_swap text-bold tel')] | (//a[contains(@class, 'tel')])[2] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[2] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | 1-877-596-3258 | //*[contains(@class,'headline')]//a | current  | 1-877-541-7755 | 1-844-887-2813 | 9C9        | //span[contains(@class, 'invoca_swap_sam')] |

  ############################ Script 4: AMS Referral Traffic & Referral Visit###########################################
  @Scenario4_1_ExternalLink_AARP_UAT @UATRegression
  Scenario Outline: <scenario> <zipcode>4.7.1 Verify Externals referral plan functionalities
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>       |
      | Campaign URL | <MedsuppUrl> |
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
      | TFN No    | <MedsuppTFNNo>    |
      | TFN Xpath | <MedsuppTFNxpath> |
    #Then the site user fills all the details in MedsuppPage
    Then the site user fills all the details in MedsuppPage for TFN
      | DOB | <DOB> |
    #Then user validate the plandetails on medsupp plans
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>    |
      | TFN Xpath | <MedsuppTFNxpath> |
    #Then the site user clicks on Start Application Button and proceed Next
    Then the site user clicks on Start Application Button and proceed few Pages
      | DOB       | <DOB>                |
      | Firstname | <Firstname>          |
      | Lastname  | <Lastname>           |
      | TFN No    | <MedsuppTFNNo>       |
      | TFN Xpath | <MedsuppOLETFNxpath> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>    |
      | TFN Xpath | <MedsuppTFNxpath> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <PDPplantype> |
    #Then the user navigates to PDP Plan Details Page and validates Federal TFN
    #| Zip Code        | <zipcode>|
    Then the user navigates to Plan Details Page for any plan and validates Federal TFN
      | Plan Type | <PDPplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to shop pages Page and validates Federal TFN
      | SHOPPAGES URL | <shoppages>    |
      | TFN Xpath     | <shoppagesTFN> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>  |
      | TFN Xpath | <ShopTFNxpath1> |
    # Then the user navigates to shop pages Page and validates Federal TFN
    # | SHOPPAGES URL   | <shoppages> |
    # | TFN Xpath | <shoppagesTFN> |
    #  Then the user validates TFN Number
    #  | TFN No | <MedsuppTFNNo> |
    #  | TFN Xpath | <ShopTFNxpath2> |
    Then the user navigates to shop pages Page and validates Federal TFN
      | SHOPPAGES URL | <shoppagescompare>    |
      | TFN Xpath     | <shoppagescompareTFN> |
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>  |
      | TFN Xpath | <ShopTFNxpath3> |
    Then the user navigates to shop pages Page and validates Federal TFN
      | SHOPPAGES URL | <shoppagesdsnp>    |
      | TFN Xpath     | <shoppagesdsnpTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to shop pages Page and validates Federal TFN
      | SHOPPAGES URL | <connect>    |
      | TFN Xpath     | <connectTFN> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>    |
      | TFN Xpath | <connectTFNxpath> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user close and reopen the broswer
    #	Given the user is on AARP medicare acquisition site landing page
    #Then the user validates TFN Number
    # | TFN No | <TFNNo> |
    # | TFN Xpath | <TFNxpath> |
    #Then the user enter zipcode in homepage
    #| Zip Code        | <zipcode>         |
    # | Plan Type | <MAplantype> |
    #Then the user validates TFN Number
    #| TFN No | <TFNNo> |
    #| TFN Xpath | <TFNxpath> |
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user navigates to MA Plan Details Page and validates Federal TFN
      | Zip Code | <zipcode> |
    Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
      | Zip Code | <zipcode> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>    |
      | TFN Xpath | <MedsuppTFNxpath> |

    Examples: 
      | scenario         | site   | zipcode | pscCode | shoppages | shoppagesTFN                      | shoppagescompare             | shoppagescompareTFN               | shoppagesdsnp                      | shoppagesdsnpTFN                  | connect         | connectTFN                                                          | maUrl                     | maTFN                             | MedsuppUrl                                                                                                                                                                               | DOB        | Firstname | Lastname | MedsuppTFNNo   | TFNNo          | MedsuppTFNxpath                                                           | ShopTFNxpath1                     | ShopTFNxpath2                     | ShopTFNxpath3                     | TFNxpath                          | connectTFNxpath                   | MedsuppOLETFNxpath                        | PDPplantype | MAplantype | MedSupplantype | planyear | FedTFNNo       | MedSupTFNNo    | sourceCode |
      | Sc. 04.01 - 4.02 | ulayer |   10001 | 8003093 | shop.html | (//a[contains(@class, 'tel')])[1] | shop/compare/compare-ms.html | (//a[contains(@class, 'tel')])[1] | shop/dual-special-needs-plans.html | (//a[contains(@class, 'tel')])[1] | contact-us.html | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] | enroll/ma-enrollment.html | (//a[contains(@class, 'tel')])[2] | health-plans.html?product=medsup&EBRC=https://www.aarpmedicaresupplement.com/medicare-information-guide.html&intref=AARPMedicareSupplement.com&zipcode=10001&WT.mc_id=23W&#/plan-summary | 11/13/1940 | John      | Carry    | 1-866-242-0247 | 1-855-888-1640 | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | (//a[contains(@class, 'tel')])[4] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | (//span[contains(@class,'telephone')])[1] | PDP         | MA         | MS             | next     | 1-855-888-1640 | 1-866-242-0247 | 23W        |

  #######################Script 5: Portfolio Campaign Traffic to Med Ed########################################
  @Scenario_5_Portfolio_CampaignTraffic_MedEd1_UAT @UATRegression @prodRegression_UAT
  Scenario Outline: <scenario> <zipcode>1.0 Verify TFN in MedEd Pages and VPP
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
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL | <medEdURL> |
      | TFN Xpath | <medEdTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL | <medEdURL1> |
      | TFN Xpath | <medEdTFN>  |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL | <medEdURL2> |
      | TFN Xpath | <medEdTFN>  |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user performs plan search using Medicare articles pages for campaign Links
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the user navigates to homepage validates Federal TFN
    #Then the user navigates to plan tab for any plan
    #| Plan Type | <MAplantype> |
    #And the user views the plans of the below plan type
    #| Plan Type | <MAplantype> |
    #And the user selects plan year
    # | Plan Year | <planyear> |
    Then the user navigates to MA Plan Details Page and validates Federal TFN
      | Zip Code | <zipCode> |
    # Then the user navigates to Plan Details Page for any plan and validates Federal TFN
    #  | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates back to page
    #Then the user navigates to plan tab for any plan
    # | Plan Type | <SNPplantype> |
    And the user views the plans of the below plan type
      | Plan Type | <SNPplantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to Plan Details Page for any plan and validates Federal TFN
      | Plan Type | <SNPplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    # Then the user navigates to plan tab for any plan
    #  | Plan Type | <SNPplantype> |
    Then the user navigates to Plan Details Page for any SNP plan for Enroll and validates Federal TFN
      | Plan Type | <SNPplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>       |
      | TFN Xpath | <SNPTFNxpath> |

    @Scenario_5_Portfolio_CampaignTraffic_MedEd1_UAT_Medsup3.0
    Examples: 
      | scenario                  | MAplantype | SNPplantype | zipcode | county       | isMultutiCounty | site   | pscCode | campaignUrl                               | medEdURL               | medEdTFN                           | medEdURL1                                  | medEdURL2                                         | TFNNo          | TFNxpath                          | SNPTFNxpath                       | planyear | zipCode | FedTFNNo       | MedSupTFNNo    | sourceCode |
      | Scenerio 5-Portfolio- AMP | MA         | SNP         |   24010 | Roanoke City | NO              | ulayer | 8001277 | /medicare-education.html?WT.mc_id=8001277 | medicare-articles.html | (//span[@class='heading-6']//u)[1] | medicare-articles/medicare-made-clear.html | medicare-articles/eligibility-and-enrollment.html | 1-877-495-2415 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | next     |   10001 | 1-877-495-2415 | 1-877-495-2415 | 2MN        |

    @Scenario_5_Portfolio_CampaignTraffic_MedEd1_UAT_Medsup4.0
    Examples: 
      | scenario                  | MAplantype | SNPplantype | zipcode | county             | isMultutiCounty | site   | pscCode | campaignUrl                               | medEdURL               | medEdTFN                           | medEdURL1                                  | medEdURL2                                         | TFNNo          | TFNxpath                          | SNPTFNxpath                       | planyear | zipCode | FedTFNNo       | MedSupTFNNo    | sourceCode |
      | Scenerio 5-Portfolio- AMP | MA         | SNP         |   90210 | Los Angeles County | NO              | ulayer | 8001277 | /medicare-education.html?WT.mc_id=8001277 | medicare-articles.html | (//span[@class='heading-6']//u)[1] | medicare-articles/medicare-made-clear.html | medicare-articles/eligibility-and-enrollment.html | 1-877-495-2415 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | next     |   90210 | 1-877-495-2415 | 1-877-495-2415 | 2MN        |

  #######################Script 7: Email Validation########################################
  @Scenario_7_DirectTraffic_Email_UAT @UATRegression
  Scenario Outline: <scenario> <zipcode> 1.0 Verify TFN through Email Validation
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
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
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to following External Email Links
      | Email URL | <emailLinkUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode1> |
    Then the user validates source code
      | sourceCode | <sourceCode1> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo1> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo1> |
    Then the user validates TFN Number
      | TFN No    | <EmailTFNNo>    |
      | TFN Xpath | <EmailTFNxpath> |
    Then the user navigates to following  Medicare Education Page URL and validate Federal TFN
      | MEDICARE URL | <medicareUrl> |
      | TFN Xpath    | <medicareTFN> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode1> |
    Then the user validates source code
      | sourceCode | <sourceCode1> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo1> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo1> |
    Then the user validates TFN Number
      | TFN No    | <EmailTFNNo> |
      | TFN Xpath | <TFNxpath>   |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode1> |
    Then the user navigates to shop pages Page and validates Federal TFN
      | SHOPPAGES URL | <shoppagesUrl> |
      | TFN Xpath     | <shoppagesTFN> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode1> |
    Then the user validates TFN Number
      | TFN No    | <MedicareSupplementTFNNo>    |
      | TFN Xpath | <MedicareSupplementTFNxpath> |

    Examples: 
      | scenario               | site | pscCode | zipcode | pscCode1 | emailLinkUrl                                                      | emailLinkTFN                      | medicareUrl            | medicareTFN                                                                         | shoppagesUrl                        | shoppagesTFN                                                              | TFNNo          | TFNxpath                          | EmailTFNNo     | MedicareSupplementTFNNo | MedicareSupplementTFNxpath                                                | EmailTFNxpath                                                             | FedTFNNo1      | MedSupTFNNo1   | FedTFNNo       | MedSupTFNNo    | sourceCode1 | sourceCode |
      | Scenario 7-Email - AMP | AARP |  810027 |   90210 |  8013925 | /?WT.mc_id=8013925&mrcid=em:Acq:MR%7CNTM65%7CEGEM3107%7C::8013925 | (//a[contains(@class, 'tel')])[1] | medicare-articles.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | shop/medicare-supplement-plans.html | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | 1-877-699-5710 | (//a[contains(@class, 'tel')])[3] | 1-855-593-6479 | 1-866-324-0819          | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | 1-855-593-6479 | 1-866-324-0819 | 1-877-699-5710 | 1-866-408-5545 | 5RV         | AEP        |

  #######################Script 8: External Link PDP########################################
  @Scenario_8_External_Link_PDP_UAT @UATRegression
  Scenario Outline: <scenario> <zipcode> Verify TFN through External Links PDP
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
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user enter zipcode in homepage for External Links
      | Zip Code  | <zipcode>     |
      | Plan Type | <PDPplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    #Then the user navigates to Plan Details Page for any plan and validates Federal TFN
    # | Plan Type | <PDPplantype> |
    #Then the user validates TFN Number
    # | TFN No | <TFNNo> |
    # | TFN Xpath | <TFNxpath> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <MAplantype> |
    #Then the user navigates to Plan Details Page for any plan and validates Federal TFN
    #  | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <MSplantype> |
    #Then the user navigates to Plan Details Page for any plan and validates Federal TFN
    # | Plan Type | <MSplantype> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>    |
      | TFN Xpath | <MedsuppTFNxpath> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <SNPplantype> |
    Then the user navigates to Plan Details Page for any plan and validates Federal TFN
      | Plan Type | <SNPplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to Plan Details Page for any SNP plan for Enroll and validates Federal TFN
      | Plan Type | <SNPplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>          |
      | TFN Xpath | <EnrollTFNxpath> |
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaignUrl1> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>       |
      | TFN Xpath | <DCETFNxpath> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    #Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    Then the user clicks on Review Drug Costs button to Land on Drug Summary Page
    Then the user validates TFN Number
      | TFN No    | <TFNNo>       |
      | TFN Xpath | <DCETFNxpath> |
    #When user enters valid zipcode and county
    # | ZipCode | <zipCode> |
    # And user clicks on continue button in Zip Entry Page
    #Then the user validates TFN Number
    # | TFN No | <TFNNo> |
    # | TFN Xpath | <DCETFNxpath> |
    Then the user navigates to Plan Details Page for DCE Flow
      | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>       |
      | TFN Xpath | <DCETFNxpath> |
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaignUrl2> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigate to Pharmacy page
      | Zip Code    | <zipcode>     |
      | Distance    | <distance>    |
      | County Name | <countyName>  |
      | Plan Name   | <ny_planName> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>       |
      | TFN Xpath | <DCETFNxpath> |
    #-##########-----------------------------------------------------------------------###########
    Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL | <medEdURL1> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to shop pages Page and validates Federal TFN
      | SHOPPAGES URL | <shoppagesUrl> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo> |
      | TFN Xpath | <shopTFNxpath> |

    @Scenario_8_External_Link_PDP_UAT_Medsup3.0
    Examples: 
      | scenario                      | site   | zipcode | pscCode | campaignUrl                                                                                                  | campaignUrl1                                                                           | drug1   | zipCode | planType | planName                            | campaignUrl2                                                                                  | medEdURL1                                         | shoppagesUrl                        | estimateUrl                                        | TFNNo          | TFNxpath                          | MedsuppTFNNo   | MedsuppTFNxpath                   | EnrollTFNxpath                    | DCETFNxpath                                                               | shopTFNxpath                      | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan | PDPplantype | MAplantype | MSplantype | SNPplantype | FedTFNNo       | MedSupTFNNo    | sourceCode |
      | Scenerio 8-ExternalLink - AMP | ulayer |   10001 | 8001024 | health-plans/prescription-drug-plans/available-plans.html?WT.mc_id=8001024&county=053&state=27#/plan-summary | health-plans/estimate-drug-costs.html?WT.mc_id=8001024&county=053&state=27#/getstarted | Lipitor |   10001 | MAPD     | AARP Medicare Advantage Prime (HMO) | health-plans/aarp-pharmacy.html?WT.mc_id=8001024&county=053&state=27#/Pharmacy-Search-English | medicare-articles/eligibility-and-enrollment.html | shop/medicare-supplement-plans.html | /health-plans/estimate-drug-costs.html#/getstarted | 1-866-308-8818 | (//a[contains(@class, 'tel')])[3] | 1-844-895-7228 | //*[contains(@class,'tel right')] | (//a[contains(@class, 'tel')])[3] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | (//a[contains(@class, 'tel')])[4] |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 | PDP         | MA         | MS         | SNP         | 1-866-308-8818 | 1-844-895-7228 | 9F4        |

    @Scenario_8_External_Link_PDP_UAT_Medsup4.0
    Examples: 
      | scenario                      | site   | zipcode | pscCode | campaignUrl                                                                                                  | campaignUrl1                                                                           | drug1   | zipCode | planType | planName                            | campaignUrl2                                                                                  | medEdURL1                                         | shoppagesUrl                        | estimateUrl                                        | TFNNo          | TFNxpath                          | MedsuppTFNNo   | MedsuppTFNxpath                                    | EnrollTFNxpath                    | DCETFNxpath                                                               | shopTFNxpath                      | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan | PDPplantype | MAplantype | MSplantype | SNPplantype | FedTFNNo       | MedSupTFNNo    | sourceCode |
      | Scenerio 8-ExternalLink - AMP | ulayer |   90210 | 8001024 | health-plans/prescription-drug-plans/available-plans.html?WT.mc_id=8001024&county=053&state=27#/plan-summary | health-plans/estimate-drug-costs.html?WT.mc_id=8001024&county=053&state=27#/getstarted | Lipitor |   10001 | MAPD     | AARP Medicare Advantage Prime (HMO) | health-plans/aarp-pharmacy.html?WT.mc_id=8001024&county=053&state=27#/Pharmacy-Search-English | medicare-articles/eligibility-and-enrollment.html | shop/medicare-supplement-plans.html | /health-plans/estimate-drug-costs.html#/getstarted | 1-866-308-8818 | (//a[contains(@class, 'tel')])[3] | 1-844-895-7228 | //*[contains(@class, 'invoca_swap text-bold tel')] | (//a[contains(@class, 'tel')])[3] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | (//a[contains(@class, 'tel')])[4] |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 | PDP         | MA         | MS4.0      | SNP         | 1-866-308-8818 | 1-844-895-7228 | 9F4        |

  #######################Script 9: External Link Plan 11########################################
  @Scenario_9_External_Link_UAT @UATRegression
  Scenario Outline: <scenario> <zipcode> 1.0 Verify TFN through External Links
    #Given the user Starts WebDriver
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user is on AARP External Link and Land on MA Plans
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
    Then the user navigates to refresh page
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
    #And the user clicks on the add plans button in the profile in AARP site
    #---------------commenting the lines from 1.09 to 1.12 as mentioned by UAT related to Authenticated user -----------------#
    Then the user signs in with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And the user clicks on the add plans button in the profile in agent mode
    #And the user clicks on the add plans button in the profile
    #Then user validates plan count for all plan types on plan summary page
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    #And the user views the plans of the below plan type
    #| Plan Type | <plantype> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <MAplantype> |
    Then the user navigates to Plan Details Page for any plan and validates Federal TFN
      | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates back to page
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user Enroll for any plan on plan summary page
      | Plan Type | <MAplantype> |
    # Then the user navigates to Plan Details Page for any plan for Enroll and validates Federal TFN
    # | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>          |
      | TFN Xpath | <EnrollTFNxpath> |
    Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL | <medEdURL1> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to shop pages Page and validates Federal TFN
      | SHOPPAGES URL | <shoppagesUrl> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>        |
      | TFN Xpath | <ShopTFNxpath> |
    Then the user validates PSC code
      | PSC Code | <pscCode> |

    @Scenario_9_External_Link_UAT_Medsup3.0
    Examples: 
      | scenario                      | site | zipcode | MAplantype | pscCode | state   | campaignUrl                                                                        | medEdURL1                                  | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName        | password      | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | FedTFNNo       | MedSupTFNNo    | sourceCode |
      | Scenerio 9-ExternalLink - AMP | AARP |   10001 | MA         | 8000158 | Alabama | health-plans.html?zipcode=10001&WT.mc_id=8000158&county=420&state=36#/plan-summary | medicare-articles/medicare-made-clear.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID39 | TiggerTigger7 | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | 1-844-850-6592 | 1-844-850-6592 | RRZ        |

    @Scenario_9_External_Link_UAT_Medsup4.0
    Examples: 
      | scenario                      | site | zipcode | MAplantype | pscCode | state   | campaignUrl                                                                        | medEdURL1                                  | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName        | password      | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | FedTFNNo       | MedSupTFNNo    | sourceCode |
      | Scenerio 9-ExternalLink - AMP | AARP |   90210 | MA         | 8000158 | Alabama | health-plans.html?zipcode=90210&WT.mc_id=8000158&county=420&state=36#/plan-summary | medicare-articles/medicare-made-clear.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID39 | TiggerTigger7 | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | 1-844-850-6592 | 1-844-850-6592 | RRZ        |

  @Scenario_2_CampaignTrafficdummy
  Scenario Outline: <scenario> Verify TFN for different plan types through Campaign Traffic
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaignUrl2> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigate to Pharmacy page
      | Zip Code    | <zipcode>     |
      | Distance    | <distance>    |
      | County Name | <countyName>  |
      | Plan Name   | <ny_planName> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>       |
      | TFN Xpath | <DCETFNxpath> |
    #-##########-----------------------------------------------------------------------###########
    Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL | <medEdURL1> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to shop pages Page and validates Federal TFN
      | SHOPPAGES URL | <shoppagesUrl> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo> |
      | TFN Xpath | <shopTFNxpath> |

    Examples: 
      | scenario                      | site   | zipcode | pscCode | campaignUrl                                                                                                  | campaignUrl1                                                                           | drug1   | zipCode | planType | planName                            | campaignUrl2                                                                                  | medEdURL1                                         | shoppagesUrl                        | estimateUrl                                        | TFNNo          | TFNxpath                          | MedsuppTFNNo   | MedsuppTFNxpath                   | EnrollTFNxpath                    | DCETFNxpath                                                           | shopTFNxpath                      | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan | PDPplantype | MAplantype | MSplantype | SNPplantype | planyear |
      | Scenerio 8-ExternalLink - AMP | ulayer |   10001 | 8001024 | health-plans/prescription-drug-plans/available-plans.html?WT.mc_id=8001024&county=053&state=27#/plan-summary | health-plans/estimate-drug-costs.html?WT.mc_id=8001024&county=053&state=27#/getstarted | Lipitor |   10001 | MAPD     | AARP Medicare Advantage Prime (HMO) | health-plans/aarp-pharmacy.html?WT.mc_id=8001024&county=053&state=27#/Pharmacy-Search-English | medicare-articles/eligibility-and-enrollment.html | shop/medicare-supplement-plans.html | /health-plans/estimate-drug-costs.html#/getstarted | 1-866-308-8818 | (//a[contains(@class, 'tel')])[1] | 1-844-895-7228 | //*[contains(@class,'tel right')] | (//a[contains(@class, 'tel')])[3] | //button[@id='sam-call-button']//span[contains(@class,'invoca_swap')] | (//a[contains(@class, 'tel')])[2] |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 | PDP         | MA         | MS         | SNP         | future   |
