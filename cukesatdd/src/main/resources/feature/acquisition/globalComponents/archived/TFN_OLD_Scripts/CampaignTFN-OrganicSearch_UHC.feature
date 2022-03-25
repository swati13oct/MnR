@organicSearchTFN
Feature: To test Organic Search Campaign TFN on UHC site

  @Scenario3_1_GoogleSearch_UHC @organicSearchTFN_UHC
  Scenario Outline: - 3.2 Google and search UHC Medicare Advantage Plan
    Given the user Starts WebDriver
    Given user is on Google and search UHC Medicare Advantage Plan to navigate to UHC page
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
      # |  880188 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |
      |  880188 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |

  @Scenario3_2_BingSearch_UHC @organicSearchTFN_UHC
  Scenario Outline: - 3.2 Bing  search UHC Medicare Advantage Plan
    Given the user Starts WebDriver
    Given user is on Bing and search UHC Medicare Advantage Plan to navigate to navigate to UHC page
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
      # |  880187 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |
      |  880187 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |

  @Scenario3_3_YahooSearch_UHC @organicSearchTFN_UHC
  Scenario Outline: - 3.3 Yahoo and search UHC Medicare Advantage Plan
    Given the user Starts WebDriver
    Given user is on Yahoo and search UHC Medicare Advantage Plan to navigate to UHC page
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
      #  |  880189 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |
      |  880189 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |

  @Scenario_4_1to8_Precedence_1_UHC
  Scenario Outline: 4.1 to 4.8 Campaign Precedence Logic No 1 for UHC
    #------------------------**********---------------------------------
    # Precedence 4.1 - Visit UHC using Direct URL , PSC code 880180
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
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
    #----------****  Campaign supercedes Direct  ***** --------------
    # Precedence 4.3 - Visit UHC using Campaign URL, PSC code 860002
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaign1Url> |
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
    #----------****  Campaign supercedes Campaign  ***** --------------
    # Precedence 4.5 - Visit UHC using Campaign URL, PSC code 800086
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaign2Url> |
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
    # Precedence 4.7 - Visit site via UHC organic search from Google, PSC 880188
    # Campaign supercedes Organic search, so Expected PSC code - 800086
    Given user is on Google and search UHC Medicare Advantage Plan to navigate to UHC page
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
      | site   | Precedence1PSC | Precedence2PSC | campaign1Url      | Precedence3PSC | campaign2Url      | Precedence4PSC | maUrl                     | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |
      # | blayer |         880180 |         800085 | /?WT.mc_id=800085 |         800086 | /?WT.mc_id=800086 |         800086 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |
      | blayer |         880180 |         800085 | /?WT.mc_id=800085 |         800086 | /?WT.mc_id=800086 |         800086 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |

  @Scenario_4_9to14_Precedence_2_UHC
  Scenario Outline: 4.9 to 4.14 Campaign Precedence Logic No 2 for UHC
    #------------------------**********---------------------------------
    # Precedence 4.9 - Visit UHC using Direct URL , PSC code 880180
    Given the user is on the uhcmedicaresolutions site landing page
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
    # Precedence 4.11 - Visit site via organic search from Google, PSC 880188
    Given user is on Google and search UHC Medicare Advantage Plan to navigate to UHC page
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
    # Precedence 4.13 - Visit site via organic search from Yahoo, PSC code 880189
    Given user is on Yahoo and search UHC Medicare Advantage Plan to navigate to UHC page
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
    # Precedence 4.15 - Visit AMP using Campaign URL, PSC code 800086
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
      | site   | Precedence1PSC | Precedence2PSC | Precedence3PSC | campaign2Url      | Precedence4PSC | maUrl                     | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |
      # | ulayer |         880180 |         880188 |         880189 | /?WT.mc_id=800086 |         800086 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |
      | ulayer |         880180 |         880188 |         880189 | /?WT.mc_id=800086 |         800086 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |

  @Scenario4_7Campaign_Trafic_Member_UHC1
  Scenario Outline: 4.7 Campaign traffic from Member page to Acquisition Portals for UHC
    Given the user is on the uhcmedicaresolutions site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence1PSC> |
    Then the user navigates to following memeber signin page and navigate to view medicare plans link UHC
      | Member Signin URL | <memberSignIn> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence2PSC> |
    Then the user validate the sam icons tfn with federal TFN on Acquistion page
      | TFN Xpath | <SAMiconTFN> |

    Examples: 
      | site   | Precedence1PSC | Precedence2PSC | memberSignIn                  | SAMiconTFN                                                                       |
      #| blayer |         880180 |         8009508 |https://www.medicare.uhc.com/  |//*[contains(@class,'sam__button__text desktop-tfn-text')]  |
      | blayer |         880180 |        8009508 | https://www.medicare.uhc.com/ | //button[@id='sam-call-button']//*[contains(@class,'sam__button__text desktop')] |

  @Scenario4_7Campaign_Trafic_Member_UHC
  Scenario Outline: 4.7.1 Direct traffic and then through Google & search UHC Medicare Advantage Plan
    Given the user is on the uhcmedicaresolutions site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode1> |
    Then the user validate the sam icons tfn with federal TFN on Acquistion page
      | TFN Xpath | <SAMiconTFN> |
    Given user is on Google and search UHC Medicare Advantage Plan to navigate to UHC page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode2> |
    Then the user validate the sam icons tfn with federal TFN on Acquistion page
      | TFN Xpath | <SAMiconTFN> |

    Examples: 
      | pscCode1 | pscCode2 | SAMiconTFN                                                                       |
      |   880180 |   880188 | //button[@id='sam-call-button']//*[contains(@class,'sam__button__text desktop')] |

  @Scenario3_4_GoogleSearch_UHC1
  Scenario Outline: 4.7.2 Google and search UHC Medicare Advantage Plan
    Given the user is on the uhcmedicaresolutions site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode1> |
    Then the user validate the sam icons tfn with federal TFN on Acquistion page
      | TFN Xpath | <SAMiconTFN> |

    Examples: 
      | pscCode1 | pscCode2 | SAMiconTFN                                                                       |
      |   880180 |   880180 | //button[@id='sam-call-button']//*[contains(@class,'sam__button__text desktop')] |

  @Scenario4_7Campaign_Trafic_Member_UHC1
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
      | 15531 | blayer |   80001 | MA       | No              | future   |   880180 |  8013925 | //button[@id='sam-call-button']//*[contains(@class,'sam__button__text desktop')] |
      | 15531 | blayer |   80001 | PDP      | No              | future   |   880180 |  8013925 | //button[@id='sam-call-button']//*[contains(@class,'sam__button__text desktop')] |
