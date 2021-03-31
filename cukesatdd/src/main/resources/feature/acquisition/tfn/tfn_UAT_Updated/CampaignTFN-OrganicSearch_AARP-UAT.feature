Feature: UAT Scripts-To test Organic SearchCampaign TFN on AARP site

  #######################Script 3: Organic Search via Google and Bing##########################################
  @Scenario3_1_GoogleBingSearch_AARP_UAT @UATRegression
  Scenario Outline: - <scenario> 3.1 Google search AARP Medicare Advantage Plan
    Given the user Starts WebDriver
    Given user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL | <medicareeduUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Given user is on Bing and search AARP Medicare Advantage Plan to navigate to navigate to AARP page
    Then the user navigates to refresh page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence1PSC> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo1>   |
      | TFN Xpath | <TFNxpath> |
    #Then the user enter zipcode in homepage
    # | Zip Code  | <zipcode>    |
    #| Plan Type | <MAplantype> |
    Then the user navigates to MA Plan Details Page and validates Federal TFN
      | Zip Code | <zipcode> |
    #Then the user navigates to plan tab for any plan
    #| Plan Type | <MAplantype> |
    #Then the user navigates to Plan Details Page for any plan and validates Federal TFN
    #| Plan Type | <MAplantype> |
    # Then the user navigates to MA Plan Details Page and validates Federal TFN
    #	| Zip Code        | <zipcode>|
    Then the user validates TFN Number
      | TFN No    | <TFNNo1>   |
      | TFN Xpath | <TFNxpath> |
    #Then the user navigates to plan tab for any plan
    #  | Plan Type | <MSplantype> |
    # Then the user navigates to Plan Details Page for any plan and validates Federal TFN
    #| Plan Type | <MSplantype> |
    Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
      | Zip Code | <zipcode> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>    |
      | TFN Xpath | <MedsuppTFNxpath> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence1PSC> |
    #Then the user enters and  saves the entered information in Pre-entry page for validation on IS form
    Then the site user fills all the details in MedsuppPage for TFN
      | DOB | <dob> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>    |
      | TFN Xpath | <MedsuppTFNxpath> |
    When the user clicks on Agent link for MedsuppPage
      | UHC Agent URL | <UHCUrl> |
    Then the user clicks on Request a Free Decision Guide
      | TFN No    | <MedsuppTFNNo> |
      | TFN Xpath | <TFNxpath>     |
    Then the user navigates to plan tab for any plan
      | Plan Type | <PDPplantype> |
    Then the user navigates to Plan Details Page for any plan and validates Federal TFN
      | Plan Type | <PDPplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo1>   |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to shop pages Page and validates Federal TFN
      | SHOPPAGES URL | <shoppages> |
    Then the user validates PSC code
      | PSC Code | <Precedence1PSC> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo1>   |
      | TFN Xpath | <TFNxpath> |
    Then the user navigate to following MedED Pages URL and validate Federal TFN
      | MedEd URL | <medicareeduUrl> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo1>   |
      | TFN Xpath | <TFNxpath> |

    Examples: 
      | scenario       | pscCode | Precedence1PSC | zipcode | dob        | maUrl                              | maTFN                                                        | medicareeduUrl                                    | medicareeduTFN                    | decisionGuideUrl                                                          | decisionGuideTFN | agentApptUrl                                                  | agentApptTFN   | shoppages       | shoppagesTFN                                                 | TFNNo          | TFNxpath                          | TFNNo1         | MedsuppTFNNo   | MedsuppTFNxpath                   | UHCUrl                      | MAplantype | PDPplantype | MSplantype | url                     | ampTFN         |
      | Sc. 3.08 - AMP |  810106 |         810104 |   90210 | 11/01/1951 | shop/medicare-advantage-plans.html | (//*[contains(@class,'call')]//a[contains(@class,'tel')])[2] | /medicare-education/medicare-advantage-plans.html | (//a[contains(@class, 'tel')])[1] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn']   | health-plans/medicare-supplement-plans/agent-appointment.html | //*[@id='tfn'] | contact-us.html | (//*[contains(@class,'call')]//a[contains(@class,'tel')])[1] | 1-800-850-6807 | (//a[contains(@class, 'tel')])[1] | 1-877-608-5598 | 1-866-327-1593 | //*[contains(@class,'tel right')] | https://www.myuhcagent.com/ | MA         | PDP         | MS         | https://www.google.com/ | 1-800-850-6807 |

  #######################Script 6a: Campaign Precedence Logic#######################################
  @Scenario_6_Precedence_1_AARP_UAT @UATRegression
  Scenario Outline: <scenario> Campaign Precedence Logic No 1
    #------------------------**********---------------------------------
    # Precedence 6.1 - Visit AMP using google URL , PSC code 810106
    Given the user Starts WebDriver
    Given user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence1PSC> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo1>          |
      | TFN Xpath | <MedSuppTFNxpath> |
    ################ # Precedence 6.3 - Visit AMP using Campign URL , PSC code 860002###############################
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaign2Url> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence2PSC> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo3>    |
      | TFN Xpath | <TFNxpath2> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo4>          |
      | TFN Xpath | <MedSuppTFNxpath> |
    ############# # Precedence 6.5 - Visit AMP using Campign URL , PSC code 8001533###########################
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaign3Url> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence3PSC> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo5>    |
      | TFN Xpath | <TFNxpath2> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo6>          |
      | TFN Xpath | <MedSuppTFNxpath> |
    ####################### # Precedence 6.7 - Visit AMP using organic traffic from Google search URL , PSC code 8001533#####################
    Given user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence4PSC> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo5>   |
      | TFN Xpath | <TFNxpath> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo6>          |
      | TFN Xpath | <MedSuppTFNxpath> |
    ################# Precedence 6.9 - Visit AMP using direct URL , PSC code 810027########################
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence5PSC> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo7>   |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to PDP Plan Details Page and validates Federal TFN
      | Zip Code | <zipcode> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo7>          |
      | TFN Xpath | <MedSuppTFNxpath> |
    Then the user close and reopen the broswer
    ######## Precedence 6.11 - Visit AMP using organic traffic from Google search URL , PSC code 810106##############
    Given the user Starts WebDriver
    Given user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence6PSC> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo1>          |
      | TFN Xpath | <MedSuppTFNxpath> |
    ################ # Precedence 6.13 - Visit AMP using Campign URL , PSC code 8001533################
    #Then the user close and reopen the broswer
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaign4Url> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo5>   |
      | TFN Xpath | <TFNxpath> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence7PSC> |
    #Then the user navigates to MA Plan Details Page and validates Federal TFN
    #| Zip Code        | <zipcode>|
    #Then the user validates TFN Number
    # | TFN No    | <TFNNo5> |
    #| TFN Xpath | <TFNxpath> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo6>          |
      | TFN Xpath | <MedSuppTFNxpath> |

    Examples: 
      | scenario                              | site   | zipcode | Precedence1PSC | Precedence2PSC | Precedence3PSC | Precedence4PSC | Precedence5PSC | Precedence6PSC | Precedence7PSC | Precedence8PSC | medSuppUrl                          | medSuppTFN                                                   | campaign2Url                                                      | campaign3Url                                         | campaign4Url                                                                                                   | connect                             | connectTFN                                                   | TFNxpath                          | MedSuppTFNxpath                   | TFNNo          | TFNNo1         | TFNNo2         | TFNNo3         | TFNNo4         | TFNNo5         | TFNNo6         | TFNNo7         | TFNNo8         | TFNxpath2                                                                                  |
      | Scenario 6a: Campaign Precedence- AMP | ulayer |   90210 |         810106 |         860002 |        8001533 |        8001533 |         810027 |         810106 |        8001533 |         810105 | shop/medicare-supplement-plans.html | (//*[contains(@class,'call')]//a[contains(@class,'tel')])[2] | /shop/medicare-advantage-plans.html?WT.mc_id=860002&zipcode=90210 | /shop/medicare-advantage-plans.html?WT.mc_id=8001533 | /health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8001533&county=053&state=27#/plan-summary | /shop/medicare-advantage-plans.html | (//*[contains(@class,'call')]//a[contains(@class,'tel')])[1] | (//a[contains(@class, 'tel')])[1] | (//a[contains(@class, 'tel')])[2] | 1-800-850-6807 | 1-866-327-1593 | 1-866-327-1593 | 1-877-610-2672 | 1-888-708-8922 | 1-877-656-8358 | 1-844-891-4867 | 1-877-699-5710 | 1-800-850-8230 | //button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')] |

  #######################Script 6b: Campaign Precedence Logic#######################################
  @Scenario_6_Precedence_1_AARP_UAT @UATRegression
  Scenario Outline: <scenario> Campaign Precedence Logic No 1
    ################## Precedence 6.15 - Visit site via organic search from Yahoo, PSC code 810105######################
    Given the user Starts WebDriver
    Given user is on Yahoo and search AARP Medicare Advantage Plan to navigate to AARP page
    Then the user navigates to shop pages Page and validates Federal TFN
      | SHOPPAGES URL | <connect> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence8PSC> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo8>   |
      | TFN Xpath | <TFNxpath> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo1>          |
      | TFN Xpath | <MedSuppTFNxpath> |

    Examples: 
      | scenario                              | site   | zipcode | Precedence1PSC | Precedence2PSC | Precedence3PSC | Precedence4PSC | Precedence5PSC | Precedence6PSC | Precedence7PSC | Precedence8PSC | medSuppUrl                          | medSuppTFN                                                   | campaign2Url                                                      | campaign3Url                                         | campaign4Url                                                                                                   | connect                             | connectTFN                                                   | TFNxpath                          | MedSuppTFNxpath                   | TFNNo          | TFNNo1         | TFNNo2         | TFNNo3         | TFNNo4         | TFNNo5         | TFNNo6         | TFNNo7         | TFNNo8         | TFNxpath2                         |
      | Scenario 6b: Campaign Precedence- AMP | ulayer |   10001 |         810106 |         860002 |        8001533 |        8001533 |         810027 |         810106 |        8001533 |         810105 | shop/medicare-supplement-plans.html | (//*[contains(@class,'call')]//a[contains(@class,'tel')])[2] | /shop/medicare-advantage-plans.html?WT.mc_id=860002&zipcode=90210 | /shop/medicare-advantage-plans.html?WT.mc_id=8001533 | /health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8001533&county=053&state=27#/plan-summary | /shop/medicare-advantage-plans.html | (//*[contains(@class,'call')]//a[contains(@class,'tel')])[1] | (//a[contains(@class, 'tel')])[1] | (//a[contains(@class, 'tel')])[2] | 1-800-850-6807 | 1-866-327-1593 | 1-866-327-1593 | 1-877-610-2672 | 1-888-708-8922 | 1-877-656-8358 | 1-844-891-4867 | 1-877-699-5710 | 1-800-850-8230 | (//a[contains(@class, 'tel')])[3] |
