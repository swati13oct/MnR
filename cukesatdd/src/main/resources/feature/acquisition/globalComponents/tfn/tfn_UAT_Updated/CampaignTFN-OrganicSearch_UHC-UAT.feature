@campaignTFN @regressionUHC
Feature: UAT-Scripts-To test Organic Search Campaign TFN on UHC site

  ################################Script 3: Organic Search via Google and Bing######################################
  @Scenario3_1_GoogleBingSearch_UHC_UAT @UATRegression @prodRegression_UAT
  Scenario Outline: - <scenario> 3.1 Google search UHC Medicare Advantage Plan
    Given the user Starts WebDriver
    Given user is on Google and search UHC Medicare Advantage Plan to navigate to UHC page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath2> |
    When the user performs plan search using Shop Pages for campaign Links
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    #Then the user navigates to plan tab for any plan
    # | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigate to following MedED Pages URL and validate Federal TFN
      | MedEd URL | <medicareeduUrl> |
      | TFN Xpath | <medicareeduTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user navigate to following MedED Pages URL and validate Federal TFN
      | MedEd URL | <medicarearicleUrl> |
      | TFN Xpath | <medicarearicleTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath2> |
    Then the user navigate to following MedED Pages URL and validate Federal TFN
      | MedEd URL | <medicareMadeclearUrl> |
      | TFN Xpath | <medicareMadeclearTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath2> |
    Then the user navigate to following MedED Pages URL and validate Federal TFN
      | MedEd URL | <medicareEligibilityUrl> |
      | TFN Xpath | <medicareEligibilityTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>     |
      | TFN Xpath | <TFNxpath2> |
    #Given the user Starts WebDriver
    Given user is on Bing and search UHC Medicare Advantage Plan to navigate to navigate to UHC page
    Then the user navigates to refresh page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence1PSC> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo2>    |
      | TFN Xpath | <TFNxpath2> |
    #Then the user navigates to homepage validates Federal TFN
    #Then the user navigates to MA Plan Details Page and validates Federal TFN
    # | Zip Code    | <zipcode>    |
    #Then the user validates PSC code
    #| PSC Code | <Precedence1PSC> |
    When the user performs plan search using Shop Pages for campaign Links
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    #Then the user navigates to plan tab for any plan
    # | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo2>   |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <MSplantype> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>    |
      | TFN Xpath | <MedsuppTFNxpath> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <PDPplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo2>   |
      | TFN Xpath | <TFNxpath> |
    Then the user navigate to following MedED Pages URL and validate Federal TFN
      | MedEd URL | <medicareeduUrl> |
      | TFN Xpath | <medicareeduTFN> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo2>   |
      | TFN Xpath | <TFNxpath> |

    Examples: 
      | scenario       | pscCode | Precedence1PSC | zipcode | county          | isMultutiCounty | maUrl                              | medicareeduUrl                                    | shoppages        | medicarearicleUrl       | medicareMadeclearUrl                       | medicareEligibilityUrl                            | MAplantype | MSplantype | PDPplantype | TFNNo          | MedsuppTFNNo   | TFNNo2         | TFNxpath                          | MedsuppTFNxpath                   | TFNxpath2                           |
      | Sc. 3.08 - UMS |  880188 |         880187 |   90210 | New York County | NO              | shop/medicare-advantage-plans.html | /medicare-education/medicare-advantage-plans.html | /contact-us.html | /medicare-articles.html | medicare-articles/medicare-made-clear.html | medicare-articles/eligibility-and-enrollment.html | MA         | MS         | PDP         | 1-800-607-2877 | 1-888-378-0849 | 1-800-811-2341 | (//a[contains(@class, 'tel')])[1] | //*[contains(@class,'tel right')] | (//a[contains(@class, 'tel')])[1]/u |

  @Scenario_4_1to8_Precedence_1_UHC_UAT @UATRegression
  Scenario Outline: <scenario> Campaign Precedence Logic No 1 for UHC
    #------------------------**********---------------------------------
    #------------------------**********---------------------------------
    # Precedence 4.3.1 - Visit UHC using Campaign URL, PSC code 800085
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaign2Url> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence1PSC> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    Then the user enter zipcode in homepage
      | Zip Code  | <zipcode>    |
      | Plan Type | <MAplantype> |
    #Then the user navigates to MA Plan Details Page and validates Federal TFN
    Then the user validates TFN Number
      | TFN No    | <TFNNo>    |
      | TFN Xpath | <TFNxpath> |
    #Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
    Then the user navigates to plan tab for any plan
      | Plan Type | <MSplantype> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>    |
      | TFN Xpath | <MedsuppTFNxpath> |
    #------------------------**********---------------------------------
    # Precedence 4.3.3 - Visit UHC using Campaign URL, PSC code 800086
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaign3Url> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence2PSC> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo1>   |
      | TFN Xpath | <TFNxpath> |
    Then the user enter zipcode in homepage
      | Zip Code  | <zipcode>    |
      | Plan Type | <MAplantype> |
    #Then the user navigates to MA Plan Details Page and validates Federal TFN
    Then the user validates TFN Number
      | TFN No    | <TFNNo1>   |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <MSplantype> |
    #Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>    |
      | TFN Xpath | <MedsuppTFNxpath> |
    #-------------------------***********************
    # Precedence 4.3.5 - Visit site via UHC organic search from Google, PSC 880188
    # Campaign supercedes Organic search, so Expected PSC code - 800086
    #Given the user Starts WebDriver
    Given user is on Google and search UHC Medicare Advantage Plan to navigate to UHC page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence3PSC> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo1>   |
      | TFN Xpath | <TFNxpath> |
    #Then the user navigates to homepage validates Federal TFN
    #Then the user navigates to MA Plan Details Page and validates Federal TFN
    #Then the user enter zipcode in homepage
    Then the user enter zipcode in homepage for External Links
      | Zip Code  | <zipcode>    |
      | Plan Type | <MAplantype> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo1>   |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <MSplantype> |
    #Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo>    |
      | TFN Xpath | <MedsuppTFNxpath> |
    #------------------------------************----------------------------------------------
    # Precedence 4.3.7 - Visit UHC using Direct URL , PSC code 880180
    Given the user Starts WebDriver
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence4PSC> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo1> |
      | TFN Xpath | <TFNxpath>      |
    Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
      | Zip Code | <zipcode> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo1>   |
      | TFN Xpath | <MedsuppTFNxpath> |
    #----------------------------**************-------------------------------------
    # Precedence 4.3.9 - Visit site via UHC organic search from Google, PSC 880188
    # Campaign supercedes Organic search, so Expected PSC code - 880188
    Given the user Starts WebDriver
    Given user is on Google and search UHC Medicare Advantage Plan to navigate to UHC page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence5PSC> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo2>   |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to homepage validates Federal TFN
    #Then the user enter zipcode in homepage
    Then the user enter zipcode in homepage for External Links
      | Zip Code  | <zipcode>    |
      | Plan Type | <MAplantype> |
    # Then the user navigates to MA Plan Details Page and validates Federal TFN
    Then the user validates TFN Number
      | TFN No    | <TFNNo2>   |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to plan tab for any plan
      | Plan Type | <MSplantype> |
    #Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo2>   |
      | TFN Xpath | <MedsuppTFNxpath> |

    #------------------------**********---------------------------------
    Examples: 
      | scenario                              | site   | zipcode | MAplantype | MSplantype | Precedence1PSC | Precedence2PSC | Precedence3PSC | Precedence4PSC | Precedence5PSC | Precedence6PSC | campaign2Url      | campaign3Url      | campaign4Url                                                                                                   | MedsuppTFNxpath                   | TFNxpath                          | TFNNo          | MedsuppTFNNo   | TFNNo1         | MedsuppTFNNo1  | TFNNo2         | MedsuppTFNNo2  | TFNNo3         |
      | Scenario 4a: Campaign Precedence- UMS | blayer |   90210 | MA         | MS         |         800085 |         800086 |         800086 |         880180 |         880188 |         880189 | /?WT.mc_id=800085 | /?WT.mc_id=800086 | /health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8001533&county=053&state=27#/plan-summary | //*[contains(@class,'tel right')] | (//a[contains(@class, 'tel')])[1] | 1-888-262-3289 | 1-866-260-5005 | 1-888-581-8578 | 1-877-596-3258 | 1-800-607-2877 | 1-888-378-0849 | 1-800-850-8659 |

  @Scenario_4_1to8_Precedence_1_UHC_UAT @UATRegression
  Scenario Outline: <scenario>  Campaign Precedence Logic No 4b for UHC
    #----------****  Campaign supercedes Campaign  ***** --------------
    # Precedence 4.3.11 - Visit site via UHC organic search from Yahoo, PSC 880189
    # Campaign supercedes Organic search, so Expected PSC code - 880189
    Given the user Starts WebDriver
    Given user is on Yahoo and search UHC Medicare Advantage Plan to navigate to UHC page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence6PSC> |
    Then the user validates TFN Number
      | TFN No    | <TFNNo3>   |
      | TFN Xpath | <TFNxpath> |
    Then the user navigates to homepage validates Federal TFN
    Then the user enter zipcode in homepage
      | Zip Code  | <zipcode>    |
      | Plan Type | <MAplantype> |
    #Then the user navigates to MA Plan Details Page and validates Federal TFN
    Then the user validates TFN Number
      | TFN No    | <TFNNo3>   |
      | TFN Xpath | <TFNxpath> |
    #Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
    Then the user navigates to plan tab for any plan
      | Plan Type | <MSplantype> |
    Then the user validates TFN Number
      | TFN No    | <MedsuppTFNNo2>   |
      | TFN Xpath | <MedsuppTFNxpath> |

    Examples: 
      | scenario                              | site   | zipcode | MAplantype | MSplantype | Precedence1PSC | Precedence2PSC | Precedence3PSC | Precedence4PSC | Precedence5PSC | Precedence6PSC | campaign2Url      | campaign3Url      | campaign4Url                                                                                                   | MedsuppTFNxpath                   | TFNxpath                          | TFNNo          | MedsuppTFNNo   | TFNNo1         | MedsuppTFNNo1  | TFNNo2         | MedsuppTFNNo2  | TFNNo3         |
      | Scenario 4b: Campaign Precedence- UMS | blayer |   90210 | MA         | MS         |         800085 |         800086 |         800086 |         880180 |         880188 |         880189 | /?WT.mc_id=800085 | /?WT.mc_id=800086 | /health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8001533&county=053&state=27#/plan-summary | //*[contains(@class,'tel right')] | (//a[contains(@class, 'tel')])[1] | 1-888-262-3289 | 1-866-260-5005 | 1-888-581-8578 | 1-877-596-3258 | 1-800-607-2877 | 1-888-378-0849 | 1-800-850-8659 |
