@campapaignTFN @regressionUHC @campaignTFNStage
Feature: UAT-SCripts To test Campaign TFN in all flows on UHC site

  #######################Script 1: Direct traffic########################################
  @Scenario_1_2_DirectTraffic__UHC_UAT @UATRegression
  Scenario Outline: <scenario>  Verify TFN in VPP Plan Details and OLE pages, DCE,
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
    Then the user navigates to Plan Details Page for any plan and validates Federal TFN
      | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates back to page
    Then the user navigates to plan tab for any plan
      | Plan Type | <MSplantype> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>           |
      | TFN Xpath | <MedsuppTFNxpath> |
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
    Then the user navigates back to page
    Then the user navigates to homepage validates Federal TFN
    #And the user clicks on the shopping cart icon in UHC site
    And the user clicks on the shopping cart icon
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then user validates TFN in header
    #---------------commenting the lines from 1.09 to 1.12 as mentioned by UAT related to Authenticated user -----------------#
    Then the user signs in with optum Id credentials
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
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <MAplantype> |
    Then the user navigates to Plan Details Page for any plan and validates Federal TFN
      | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to following  DCE Page URL and validate Federal TFN
      | DCE URL | <dceUrl> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>       |
      | TFN Xpath | <DCETFNxpath> |

    #---------------Removing the above lines from 1.09 to 1.12-----------------#
    Examples: 
      | scenario         | site | zipcode | TFNNo          |MedSupTFN| isMultutiCounty | county         | pscCode | maUrl                     | pdpUrl                       | snpUrl                                                                                                                                                                                                                                                                                                                      | medSuppUrl                                                                | medicareUrl             | site   | zipcode | plantype | isMultutiCounty | planyear | dceUrl                                                     | Precedence2PSC | PDPplantype | MAplantype | TFNxpath                          | MedsuppTFNxpath                   | DCETFNxpath                                                                                | MSplantype | EnrollTFNxpath                    | userName        | password      |
      | Scenario 1 - UMS | UHC  |   10001 | 1-877-596-3258 | 1-888-378-0254|NO              | Baldwin County |  880180 | enroll/ma-enrollment.html | shop/estimate/pdp-costs.html | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | medicare-education.html | Ulayer |   80001 | MA       | No              | current  | health-plans/estimate-drug-costs.html#/drug-cost-estimator |        8009508 | PDP         | MA         | (//a[contains(@class, 'tel')])[3] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | MS         | (//a[contains(@class, 'tel')])[3] | TiggerOptumID39 | TiggerTigger7 |

  #######################Script 2: Campaign traffic########################################
  @Scenario_2_CampaignTraffic_UHC_UAT @UATRegression
  Scenario Outline: <scenario> Verify TFN for different plan types through Campaign Traffic
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>        |
      | Campaign URL | <campaignUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user enter zipcode in homepage for External Links
      | Zip Code  | <zipcode>    |
      | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigate to following MedED Pages URL and validate Federal TFN
      | MedEd URL | <connectUrl> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>           |
      | TFN Xpath | <ConnectTFNxpath> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user enter zipcode in homepage for External Links
      | Zip Code  | <zipcode>    |
      | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
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
    #Then the user validates PSC code
    # | PSC Code | <pscCode> |
    #Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
    #| Zip Code        | <zipcode>|
    Then the user navigates back to page
    Then the user navigates back to page
    Then the user navigates to plan tab for any plan
      | Plan Type | <MSplantype> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>    |
      | TFN Xpath | <MedsuppTFNxpath> |
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
    Then the user navigates back to page
    Then the user navigates back to page
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

    Examples: 
      | scenario         | site   | pscCode | zipcode | campaignUrl                                                                                                   | maUrl                     | connectUrl       | TFNNo          | MedsuppTFNNo   | TFNxpath                          | MedsuppTFNxpath                   | EnrollTFNxpath                    | ConnectTFNxpath                     | MAplantype | MSplantype | PDPplantype | SNPplantype |
      | Scenario 2 - UMS | blayer | 8003728 |   10001 | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8003728&county=053&state=27#/plan-summary | enroll/ma-enrollment.html | /contact-us.html | 1-855-448-4586 | 1-866-271-0607 | (//a[contains(@class, 'tel')])[3] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | MA         | MS         | PDP         | SNP         |

  #######################Script 5: Email Validation########################################
  @Scenario_5_2_DirectTraffic_Email_UHC_UAT @UATRegression @prodRegression_UAT
  Scenario Outline: <scenario>  Verify TFN through Email validation
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to following External Email Links
      | Email URL | <emailLinkUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode1> |
    Then the user validates TFN Number
      | TFN No    | <EmailTFNNo>    |
      | TFN Xpath | <EmailTFNxpath> |
    Then the user navigates to following  Medicare Education Page URL and validate Federal TFN
      | MEDICARE URL | <medicareUrl> |
      | TFN Xpath    | <medicareTFN> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode1> |
    Then the user validates TFN Number
      | TFN No    | <EmailTFNNo> |
      | TFN Xpath | <TFNxpath>   |
    Then the user navigates to shop pages Page and validates Federal TFN
      | SHOPPAGES URL | <shoppagesUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode1> |
    Then the user validates TFN Number
      | TFN No    | <MedicareSupplementTFNNo>    |
      | TFN Xpath | <MedicareSupplementTFNxpath> |

    Examples: 
      | scenario               | site | pscCode | pscCode1 | emailLinkUrl                                                       | medicareUrl            | shoppagesUrl                        | TFNNo          | TFNxpath                          | EmailTFNNo     | MedicareSupplementTFNNo | MedicareSupplementTFNxpath        | EmailTFNxpath                                                                              |
      | Scenario 5-Email - UMS | UHC  |  880180 |  8014300 | ?WT.mc_id=8014300&mrcid=em:Acq:MR%7CNTM6501%7CEGEM3108%7C::8014300 | medicare-articles.html | shop/medicare-supplement-plans.html | 1-877-596-3258 | (//a[contains(@class, 'tel')])[3] | 1-855-569-9796 | 1-866-253-1495          | (//a[contains(@class, 'tel')])[4] | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] |

  #######################Script 6: External Link########################################
  @Scenario_6_External_Link_UHC_UAT @UATRegression
  Scenario Outline: <scenario>  Verify TFN through External Links
   # Given the user Starts WebDriver
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user is on AARP External Link and Land on MA Plans
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
    #And the user clicks on the add plans button in the profile
    Then the user signs in with optum Id credentials
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
    Then the user validates PSC code
      | PSC Code | <pscCode> |
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
    #Then the user navigates to Plan Details Page for any plan for Enroll and validates Federal TFN
    #| Plan Type | <MAplantype> |
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

    Examples: 
      | scenario                      | site   | state   | pscCode | campaignUrl                                                                                                                                                                                                                           | medEdURL1               | medEdTFN                           | shoppagesUrl                        | userName        | password      | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | MAplantype |
      | Scenerio 6-ExternalLink - UMS | blayer | Alabama | 8002977 | health-plans/medicare-advantage-plans/available-plans.html?zipcode=10001&WT.mc_id=8002977&county=420&state=36&coveragePerson=M&originatingSite=https%253A%252F%252Fwww.myuhcplans.com%252Fmorganstanley&subdomain=group#/plan-summary | /medicare-articles.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | TiggerOptumID39 | TiggerTigger7 | 1-877-755-5345 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | MA         |
