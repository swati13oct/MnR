@campapaignTFN @regressionUHC @campaignTFNStage
Feature: UAT-SCripts To test Campaign TFN in all flows on UHC site

  #######################Script 1: Direct traffic########################################
  @Scenario_1_2_DirectTraffic__UHC_UAT @UATRegression
  Scenario Outline: <scenario> <zipcode> Verify TFN in VPP Plan Details and OLE pages, DCE,
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
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>       |
      | TFN Xpath | <MedsuppTFNxpath> |
   Then the user fills all the details in MedsuppPage for TFN
      | DOB      | <dob>     |
      | Zip Code | <zipcode> |
    Then the user validates TFN Number
      | TFN No    | <MedSupTFN>        |
      | TFN Xpath | <MedsuppFormTFNxpath> |
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
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
   And user click on Start Application in MS plan
      | Zip Code | <zipcode> |
   Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
      Then user click on Cancel Application in MS plan
      | Zip Code | <zipcode> |
    And user click on View Plan Details in MS plan
      | Zip Code | <zipcode> |
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates source code
      | sourceCode | <sourceCode> |
    And user click on Back to Plan in MS Plan Details
      | Zip Code | <zipcode> |
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
    Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
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

    @Scenario_1_2_DirectTraffic__UHC_UAT_medsup3.0 @campaignTFNStageMS
    Examples: 
      | scenario         | site | zipcode | TFNNo          | MedSupTFN      | isMultutiCounty | county         | pscCode | maUrl                     | pdpUrl                       | snpUrl                                                                                                                                                                                                                                                                                                                      | medSuppUrl                                                                | medicareUrl             | site   | zipcode | plantype | isMultutiCounty | planyear | dceUrl                                                     | Precedence2PSC | PDPplantype | MAplantype | TFNxpath                          | MedsuppTFNxpath                                                           | DCETFNxpath                                                               | MSplantype | EnrollTFNxpath                    | userName        | password      | FedTFNNo       | MedSupTFNNo    | sourceCode |decisionGuideTFN|MedsuppFormTFNxpath|dob|agentXpath|
      | Scenario 1 - UMS | UHC  |   24010 | 1-877-596-3258 | 1-888-378-0254 | NO              | Baldwin County |  880180 | enroll/ma-enrollment.html | shop/estimate/pdp-costs.html | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | medicare-education.html | Ulayer |   80001 | MA       | No              | current  | health-plans/estimate-drug-costs.html#/drug-cost-estimator |        8009508 | PDP         | MA         | (//a[contains(@class, 'tel')])[3] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | MS         | (//a[contains(@class, 'tel')])[3] | TiggerOptumID3331 | FebruarY##123$! | 1-877-596-3258 | 1-888-378-0254 | AEP        |//*[@id='tfn']|//*[contains(@class,'tel right')]|01/01/1950|//*[contains(@class,'headline')]//a|

    @Scenario_1_2_DirectTraffic__UHC_UAT_medsup4.0 @campaignTFNStageMS
    Examples: 
      | scenario         | site | zipcode | TFNNo          | MedSupTFN      | isMultutiCounty | county             | pscCode | maUrl                     | pdpUrl                       | snpUrl                                                                                                                                                                                                                                                                                                                      | medSuppUrl                                                                | medicareUrl             | site   | zipcode | plantype | isMultutiCounty | planyear | dceUrl                                                     | Precedence2PSC | PDPplantype | MAplantype | TFNxpath                          | MedsuppTFNxpath                                                           | DCETFNxpath                                                               | MSplantype | EnrollTFNxpath                    | userName        | password      | FedTFNNo       | MedSupTFNNo    | sourceCode |decisionGuideTFN|MedsuppFormTFNxpath|dob|agentXpath|
      | Scenario 1 - UMS | UHC  |   90210 | 1-877-596-3258 | 1-888-378-0254 | NO              | Los Angeles County |  880180 | enroll/ma-enrollment.html | shop/estimate/pdp-costs.html | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | medicare-education.html | Ulayer |   80001 | MA       | No              | current  | health-plans/estimate-drug-costs.html#/drug-cost-estimator |        8009508 | PDP         | MA         | (//a[contains(@class, 'tel')])[3] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | MS4.0      | (//a[contains(@class, 'tel')])[3] | TiggerOptumID3331 | FebruarY##123$! | 1-877-596-3258 | 1-888-378-0254 | AEP        |//span[contains(@class, 'invoca_swap_sam')]|//span[contains(@class, 'invoca_swap_sam')]|01/01/1950|//*[contains(@class,'headline')]//a|

  #######################Script 2: Campaign traffic########################################
  @Scenario_2_CampaignTraffic_UHC_UAT @UATRegression
  Scenario Outline: <scenario> <zipcode> Verify TFN for different plan types through Campaign Traffic
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
    #Then the user navigates back to page
    Then the user navigates back to page
    Then the user navigates to homepage validates Federal TFN
    Then the user enter zipcode in homepage for External Links
      | Zip Code  | <zipcode>    |
      | Plan Type | <MAplantype> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <MSplantype> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>    |
      | TFN Xpath | <MedsuppTFNxpath> |
    Then the user fills all the details in MedsuppPage for TFN
      | DOB      | <dob>     |
      | Zip Code | <zipcode> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>        |
      | TFN Xpath | <MedsuppFormTFNxpath> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
      Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user clicks on decision guide for MedsuppPge
      | Zip Code | <zipcode> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>     |
      | TFN Xpath | <decisionGuideTFN> |
    Then the user click on back to previous page on Request a Free Decision Guide
      | Zip Code | <zipcode> |
    When the user clicks on Agent link for MedsuppPage
      | TFN No    | <agentTFN>   |
      | TFN Xpath | <agentXpath> |
      | Zip Code  | <zipcode>    |
    And user click on Start Application in MS plan
      | Zip Code | <zipcode> |
    Then the user validates PSC code
      | PSC Code | <pscCode> |
      Then the user validates source code
      | sourceCode | <sourceCode> |
    Then user click on Cancel Application in MS plan
      | Zip Code | <zipcode> |
    And user click on View Plan Details in MS plan
      | Zip Code | <zipcode> |
   Then the user validates PSC code
      | PSC Code | <pscCode> |
      Then the user validates source code
      | sourceCode | <sourceCode> |
   And user click on Back to Plan in MS Plan Details
      | Zip Code | <zipcode> |
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

    @Scenario_2_CampaignTraffic_UHC_UAT_medsup3.0 @campaignTFNProdMS @campaignTFNStageMS
    Examples: 
      | scenario         | site   | pscCode | zipcode | campaignUrl                                                                                                   | maUrl                     | connectUrl       | TFNNo          | MedsuppTFNNo   | TFNxpath                          | MedsuppTFNxpath                                                           | EnrollTFNxpath                    | ConnectTFNxpath                   | MAplantype | MSplantype | PDPplantype | SNPplantype |FedTFNNo       | MedSupTFNNo    | sourceCode |MedsuppFormTFNxpath|dob|decisionGuideTFN|agentXpath|
      | Scenario 2 - UMS | blayer | 8003728 |   24010 | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8003728&county=053&state=27#/plan-summary | enroll/ma-enrollment.html | /contact-us.html | 1-855-448-4586 | 1-866-271-0607 | (//a[contains(@class, 'tel')])[3] | //*[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | MA         | MS         | PDP         | SNP         |1-855-448-4586|1-866-271-0607|G3Y|//*[contains(@class,'tel right')]|01/01/1950 |//*[@id='tfn']|//*[contains(@class,'headline')]//a |

    @Scenario_2_CampaignTraffic_UHC_UAT_medsup4.0 @campaignTFNProdMS @campaignTFNStageMS
    Examples: 
      | scenario         | site   | pscCode | zipcode | campaignUrl                                                                                                   | maUrl                     | connectUrl       | TFNNo          | MedsuppTFNNo   | TFNxpath                          | MedsuppTFNxpath                                    | EnrollTFNxpath                    | ConnectTFNxpath                   | MAplantype | MSplantype | PDPplantype | SNPplantype |FedTFNNo       | MedSupTFNNo    | sourceCode |MedsuppFormTFNxpath|dob|decisionGuideTFN|agentXpath|
      | Scenario 2 - UMS | blayer | 8003728 |   90210 | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8003728&county=053&state=27#/plan-summary | enroll/ma-enrollment.html | /contact-us.html | 1-855-448-4586 | 1-866-271-0607 | (//a[contains(@class, 'tel')])[3] | //*[contains(@class, 'invoca_swap text-bold tel')] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | MA         | MS4.0         | PDP         | SNP         |1-855-448-4586|1-866-271-0607|G3Y|//span[contains(@class, 'invoca_swap_sam')] |01/01/1950 |//span[contains(@class, 'invoca_swap_sam')]|//*[contains(@class,'headline')]//a |

  #######################Script 5: Email Validation########################################
 
  @Scenario_5_2_DirectTraffic_Email_UHC_UAT @UATRegression @prodRegression_UAT @campaignTFNProdMS @campaignTFNStageMS
  Scenario Outline: <scenario> <zipcode> Verify TFN through Email validation
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
      | scenario               | site | pscCode | pscCode1 | emailLinkUrl                                                       | medicareUrl            | shoppagesUrl                        | TFNNo          | TFNxpath                          | EmailTFNNo     | MedicareSupplementTFNNo | MedicareSupplementTFNxpath        | EmailTFNxpath                                                                  |FedTFNNo1       | MedSupTFNNo1    | sourceCode1 |FedTFNNo       | MedSupTFNNo    | sourceCode |
      | Scenario 5-Email - UMS | UHC  |  880180 |  8014300 | ?WT.mc_id=8014300&mrcid=em:Acq:MR%7CNTM6501%7CEGEM3108%7C::8014300 | medicare-articles.html | shop/medicare-supplement-plans.html | 1-877-596-3258 | (//a[contains(@class, 'tel')])[3] | 1-855-569-9796 | 1-866-253-1495          | (//a[contains(@class, 'tel')])[4] | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text')][2] |1-855-569-9796|1-866-253-1495|94L|1-877-596-3258 | 1-888-378-0254 | AEP        |

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
      Then the user validates source code
      | sourceCode | <sourceCode> |
    Then the user validates Fed TFN
      | TFN No | <FedTFNNo> |
    Then the user validates MedSup TFN
      | TFN No | <MedSupTFNNo> |
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
    #Then the user navigates to plan tab for any plan
     # | Plan Type | <MAplantype> |
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

    @Scenario_6_External_Link_UHC_UAT_Medsup3.0 @campaignTFNStageMS
    Examples: 
      | scenario                      | site   | state   | pscCode | campaignUrl                                                                                                                                                                                                                           | medEdURL1               | medEdTFN                           | shoppagesUrl                        | userName        | password      | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | MAplantype |FedTFNNo       | MedSupTFNNo    | sourceCode |
      | Scenerio 6-ExternalLink - UMS1 | blayer | Alabama | 8002977 | health-plans/medicare-advantage-plans/available-plans.html?zipcode=24010&WT.mc_id=8002977&county=420&state=36&coveragePerson=M&originatingSite=https%253A%252F%252Fwww.myuhcplans.com%252Fmorganstanley&subdomain=group#/plan-summary | /medicare-articles.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | TiggerOptumID3331 | FebruarY##123$! | 1-877-755-5345 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | MA         |1-877-755-5345|1-877-755-5345|MOR|

    @Scenario_6_External_Link_UHC_UAT_Medsup4.0 @campaignTFNStageMS
    Examples: 
      | scenario                      | site   | state   | pscCode | campaignUrl                                                                                                                                                                                                                           | medEdURL1               | medEdTFN                           | shoppagesUrl                        | userName        | password      | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | MAplantype |FedTFNNo       | MedSupTFNNo    | sourceCode |
      | Scenerio 6-ExternalLink - UMS2 | blayer | Alabama | 8002977 | health-plans/medicare-advantage-plans/available-plans.html?zipcode=90210&WT.mc_id=8002977&county=420&state=36&coveragePerson=M&originatingSite=https%253A%252F%252Fwww.myuhcplans.com%252Fmorganstanley&subdomain=group#/plan-summary | /medicare-articles.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | TiggerOptumID3331 | FebruarY##123$! | 1-877-755-5345 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | MA         |1-877-755-5345|1-877-755-5345|MOR|

      
      #######################Script 7: Source Code in URL ########################################
  @Scenario_7_SourceCodeInURL_UAT @UATRegression
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
      
   @Scenario_7_SourceCodeInURL_UAT_Medsup3.0 @campaignTFNStageMS
    Examples: 
      | scenario                      | site | zipcode | MAplantype |MSPlantype| pscCode | state   | campaignUrl                                                                        | medEdURL1                                  | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName        | password      | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | FedTFNNo       | MedSupTFNNo    | sourceCode |
      | Scenerio 7-SourceCodeInURL - UMS | BLayer |   24010 | MA         |MS| 810106 | Alabama | ?WT.mc_id=5T9 | medicare-education/medicare-advantage-plans.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID3331 | FebruarY##123$!  | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | 1-800-850-6807 | 1-866-327-1593 | 5T9        |
      
      
      @Scenario_7_SourceCodeInURL_UAT_Medsup4.0 @campaignTFNStageMS
    Examples: 
      | scenario                      | site | zipcode | MAplantype |MSPlantype| pscCode | state   | campaignUrl                                                                        | medEdURL1                                  | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName        | password      | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | FedTFNNo       | MedSupTFNNo    | sourceCode |
      | Scenerio 7-SourceCodeInURL - UMS | BLayer |   90210 | MA         |MS4.0| 810106 | Alabama | ?WT.mc_id=5T9 | medicare-education/medicare-advantage-plans.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID3331 | FebruarY##123$!  | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | 1-800-850-6807 | 1-866-327-1593 | 5T9        |
      
      
      ####################### Script IS_ Scenario 4: Source Code in URL ########################################
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
    	| TFN No | <MedSupStaticTFNNo> |
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
    	| TFN No | <MedSupStaticTFNNo> |
   And user click on Start Application from MS plan details
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
      
      @Scenario_IS-4_UHCReferralTraffic_UAT_Medsup4.0 @campaignTFNStageMS @test123
    Examples: 
      | scenario                      | site | zipcode | MAplantype |MSPlantype| pscCode | state   | campaignUrl                                                                        | medEdURL1                                  | medEdTFN                           | shoppagesUrl                        | shoppagesTFN                                                                        | userName        | password      | TFNNo          | TFNxpath                          | EnrollTFNxpath                    | ShopTFNxpath                      | FedTFNNo       | MedSupTFNNo    | sourceCode |MedSupStaticTFNNo|
      | Scenerio IS-4-UHCReferralTraffic - UMS | BLayer |   90210 | MA         |MS4.0| 832935 | Alabama | health-plans.html?WT.mc_id=832935&test_version=UMS&zipcode=90210#/plan-summary | medicare-education/medicare-advantage-plans.html | (//span[@class='heading-6']//u)[1] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | TiggerOptumID3331 | FebruarY##123$!  | 1-844-850-6592 | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[3] | (//a[contains(@class, 'tel')])[4] | 1-855-259-8119 | 1-866-462-4046 | 2RZ        |1-866-603-3424|
      