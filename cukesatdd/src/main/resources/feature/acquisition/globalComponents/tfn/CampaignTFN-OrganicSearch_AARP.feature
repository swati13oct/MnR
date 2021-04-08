@organicSearchTFN
Feature: To test Organic SearchCampaign TFN on AARP site

  @Scenario3_1_GoogleSearch_AARP @organicSearchTFN_AARP
  Scenario Outline: - 3.1 Google search AARP Medicare Advantage Plan
    Given the user Starts WebDriver
    Given user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |

    Examples: 
      | pscCode | maUrl                     | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |
      #|  810106 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |
      |  810106 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |

  @Scenario3_2_BingSearch_AARP @organicSearchTFN_AARP
  Scenario Outline: - 3.2 Bing search AARP Medicare Advantage Plan
    Given the user Starts WebDriver
    Given user is on Bing and search AARP Medicare Advantage Plan to navigate to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |

    Examples: 
      | pscCode | maUrl                     | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |
      # |  810104 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |
      |  810104 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |

  @Scenario3_3_YahooSearch_AARP @organicSearchTFN_AARP
  Scenario Outline: - 3.3 Yahoo and search AARP Medicare Advantage Plan
    Given the user Starts WebDriver
    Given user is on Yahoo and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |

    Examples: 
      | pscCode | maUrl                     | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |
      # |  810105 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |
      |  810105 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |

  @Scenario_5_1to8_Precedence_1_AARP @tfn_Precedence_Campaign_Traffic
  Scenario Outline: 5.1 to 5.8 Campaign Precedence Logic No 1
    #------------------------**********---------------------------------
    # Precedence 5.1 - Visit AMP using Direct URL , PSC code 810027
    Given the user is on AARP medicare acquisition site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence1PSC> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
    #------------------------**********---------------------------------
    #----------****  Organic search supercedes Direct  ***** --------------
    # Precedence 5.2a - Visit site via organic search from Google, PSC 810106
    Given user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence2PSC> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
    #------------------------**********---------------------------------
    #----------****  Campaign Traffic supercedes Organic search  ***** --------------
    # Precedence 5.3 - Visit AMP using Campaign URL, PSC code 860002
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaign1Url> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence3PSC> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
    #------------------------**********---------------------------------
    # Precedence 5.5 - Visit AMP using Campaign URL, PSC code 8001533
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaign2Url> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence4PSC> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
    #------------------------**********---------------------------------
    # Precedence 5.7 - Visit site via organic search from Google, PSC 810106
    # Campaign supercedes Organic search, so Expected PSC code - 8001533
    Given user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence5PSC> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |

    Examples: 
      | site   | Precedence1PSC | Precedence2PSC | campaign1Url                                                 | Precedence3PSC | campaign2Url                                    | Precedence4PSC | Precedence5PSC | maUrl                     | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |
      #  | ulayer |         810027 |         810106 | /health-plans/shop/medicare-advantage-plans?WT.mc_id=860002&zipcode=90210 |         860002 | /health-plans/shop/medicare-advantage-plans?WT.mc_id=8001533 |        8001533 |        8001533 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |
      | ulayer |         810027 |         810106 | /shop/medicare-advantage-plans?WT.mc_id=860002&zipcode=90210 |         860002 | /shop/medicare-advantage-plans?WT.mc_id=8001533 |        8001533 |        8001533 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |

  @Scenario_5_9to15_Precedence_2_AARP @tfn_Precedence_Campaign_Traffic
  Scenario Outline: 5.9 to 5.15 Campaign Precedence Logic No 2 for AARP
    #------------------------**********---------------------------------
    # Precedence 5.9 - Visit AMP using Direct URL , PSC code 810027
    Given the user is on AARP medicare acquisition site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence1PSC> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
    #------------------------**********---------------------------------
    #----------****  Organic search supercedes Direct  ***** --------------
    # Precedence 5.11 - Visit site via organic search from Google, PSC 810106
    Given user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence2PSC> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
    #------------------------**********---------------------------------
    #----------****  Organic search supercedes Organic Search  ***** --------------
    # Precedence 5.13 - Visit site via organic search from Yahoo, PSC code 810105
    Given user is on Yahoo and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence3PSC> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
    #------------------------**********---------------------------------
    #----------****  Campaign Traffic supercedes Organic search  ***** --------------
    # Precedence 5.15 - Visit AMP using Campaign URL, PSC code 8001533
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaign2Url> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence4PSC> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |

    Examples: 
      | site   | Precedence1PSC | Precedence2PSC | Precedence3PSC | campaign2Url                                    | Precedence4PSC | maUrl                     | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |
      # | ulayer |         810027 |         810106 |         810105 | /health-plans/shop/medicare-advantage-plans?WT.mc_id=8001533 |        8001533 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |
      | ulayer |         810027 |         810106 |         810105 | /shop/medicare-advantage-plans?WT.mc_id=8001533 |        8001533 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |

  @Scenario4_7Campaign_Trafic_Member_AARP
  Scenario Outline: 4.7 Campaign traffic from Member page to Acquisition Portals for AARP
    Given the user is on AARP medicare acquisition site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence1PSC> |
    Then the user navigates to following memeber signin page and navigate to view medicare plans link AARP
      | Member Signin URL | <memberSignIn> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence2PSC> |
    Then the user validate the sam icons tfn with federal TFN on Acquistion page
      | TFN Xpath | <SAMiconTFN> |

    Examples: 
      | site   | Precedence1PSC | Precedence2PSC | memberSignIn                  | SAMiconTFN                                                 |
      | ulayer |         810027 |        8009508 | https://www.medicare.uhc.com/ | //*[contains(@class,'sam__button__text desktop-tfn-text')] |

  @Scenario4_7Campaign_Trafic_Member_AARP
  Scenario Outline: 4.7 Campaign traffic from Member page to Acquisition Portals for AARP
    Given the user is on AARP medicare acquisition site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode1> |
    Given user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode2> |
    Then the user validate the sam icons tfn with federal TFN on Acquistion page
      | TFN Xpath | <SAMiconTFN> |

    Examples: 
      | pscCode1 | pscCode2 | SAMiconTFN                                                                       |
      |   810027 |   810106 | //button[@id='sam-call-button']//*[contains(@class,'sam__button__text desktop')] |

  @Scenario4_7Campaign_Trafic_Member_AARP
  Scenario Outline: 4.7.2 landing Page referral for MedicareMadeclear url and navigate to AARP Portal
    Given the user is on AARP medicare acquisition site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode1> |
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaign2Url> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode2> |
    Then the user validate the sam icons tfn with federal TFN on Acquistion page
      | TFN Xpath | <SAMiconTFN> |

    Examples: 
      | pscCode1 | pscCode2 | SAMiconTFN                                                                       | site   | campaign2Url                                      |
      |   810027 |  8008553 | //button[@id='sam-call-button']//*[contains(@class,'sam__button__text desktop')] | ulayer | /health-plans.html?WT.mc_id=8008553#/plan-summary |

  @Scenario4_7Campaign_Trafic_Member_AARP1
  Scenario Outline: 4.7.1 Verify email referral plan functionalities on Plan Details page in UHC site
    Given the user is on AARP medicare acquisition site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode1> |
    Then the user validate the sam icons tfn with federal TFN on Acquistion page
      | TFN Xpath | <SAMiconTFN> |
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type on test site
      | Plan Type | <plantype> |
      | Site      | <site>     |
    And the user selects plan year for the AARP site
      | Plan Year | <planyear> |
    Then the user view plan details of the first plan in the given plan type and perform validation in test site
    Then the user validate the print link on the plan Details Page on test site
    Then the user validates the functionality of print button on the plan Details Page in test site
    Then the user validate the email link on the plan Details Page on test site
    Then the user validates the functionality of email button on the plan Details Page in test site
    Then user loads page using email deeplink and validate vpp detail page content on test site
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode2> |
    Then the user validate the sam icons tfn with federal TFN on Acquistion page
      | TFN Xpath | <SAMiconTFN> |

    Examples: 
      | TID   | site   | zipcode | plantype | isMultutiCounty | planyear | pscCode1 | pscCode2 | SAMiconTFN                                                                       |
      | 15531 | ulayer |   80001 | MA       | No              | future   |   810027 |  8013925 | //button[@id='sam-call-button']//*[contains(@class,'sam__button__text desktop')] |
      | 15531 | ulayer |   80001 | PDP      | No              | future   |   810027 |  8013925 | //button[@id='sam-call-button']//*[contains(@class,'sam__button__text desktop')] |
