Feature: UAT-Scripts-To test Organic Search Campaign TFN on UHC site

  ################################Script 3: Organic Search via Google and Bing######################################
  @Scenario3_1_GoogleBingSearch_UHC_UAT
  Scenario Outline: - <scenario> 3.1 Google search UHC Medicare Advantage Plan
    Given the user Starts WebDriver
    Given user is on Google and search UHC Medicare Advantage Plan to navigate to UHC page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user validates PSC code
      | PSC Code | <pscCode> |  
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medicareeduUrl> |
      | TFN Xpath   | <medicareeduTFN> |
      Then the user validates PSC code
      | PSC Code | <pscCode> | 
      Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medicarearicleUrl> |
      | TFN Xpath   | <medicarearicleTFN> |
       Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medicareMadeclearUrl> |
      | TFN Xpath   | <medicareMadeclearTFN> |
       Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medicareEligibilityUrl> |
      | TFN Xpath   | <medicareEligibilityTFN> |
      Given the user Starts WebDriver
    Given user is on Bing and search UHC Medicare Advantage Plan to navigate to navigate to UHC page
   Then the user validates PSC code
      | PSC Code | <Precedence1PSC> | 
   	Then the user navigates to MA Plan Details Page and validates Federal TFN
   	Then the user validates PSC code
      | PSC Code | <Precedence1PSC> | 
   	Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
      Then the user navigates to PDP Plan Details Page and validates Federal TFN
     Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
       | MedSupp URL | <medicareeduUrl> |
      | TFN Xpath   | <medicareeduTFN> |
    Examples: 
   |scenario       | pscCode | Precedence1PSC|maUrl                                  | maTFN                                                               | medicareeduUrl                                                                | medicareeduTFN                        |decisionGuideUrl                                                          | decisionGuideTFN     | agentApptUrl                                                     | agentApptTFN   |shoppages       |shoppagesTFN                                                  |medicarearicleUrl|medicarearicleTFN|medicareMadeclearUrl|medicareMadeclearTFN|medicareEligibilityUrl|medicareEligibilityTFN|
   |Sc. 3.08 - AMP |  880188 |  880187       |shop/medicare-advantage-plans.html     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] | /medicare-education/medicare-advantage-plans.html                              | (//a[contains(@class, 'tel')])[1]|health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn']       | health-plans/medicare-supplement-plans/agent-appointment.html    | //*[@id='tfn'] |/contact-us.html|(//*[contains(@class,'call')]//a[contains(@class,'tel')])[1]      | /medicare-articles.html                 |  (//a[contains(@class, 'tel')])[1]               |   medicare-articles/medicare-made-clear.html                 |     (//a[contains(@class, 'tel')])[1]              |    medicare-articles/eligibility-and-enrollment.html                 |        (//a[contains(@class, 'tel')])[1]                |
   
  @Scenario_4_1to8_Precedence_1_UHC_UAT
  Scenario Outline: 4.1 to 4.8 Campaign Precedence Logic No 1 for UHC
    #------------------------**********---------------------------------
    # Precedence 4.1 - Visit UHC using Direct URL , PSC code 880180
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
      | site   | Precedence1PSC | Precedence2PSC | campaign1Url      | Precedence3PSC | campaign2Url      | Precedence4PSC | maUrl                                  | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |
     # | blayer |         880180 |         800085 | /?WT.mc_id=800085 |         800086 | /?WT.mc_id=800086 |         800086 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |
	| blayer |         880180 |         800085 | /?WT.mc_id=800085 |         800086 | /?WT.mc_id=800086 |         800086 |enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |

  @Scenario_4_9to14_Precedence_2_UHC_UAT
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
      | site   | Precedence1PSC | Precedence2PSC | Precedence3PSC | campaign2Url      | Precedence4PSC | maUrl                                  | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |
     # | ulayer |         880180 |         880188 |         880189 | /?WT.mc_id=800086 |         800086 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |
| ulayer |         880180 |         880188 |         880189 | /?WT.mc_id=800086 |         800086 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |
      
          
     