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
    Then the user navigate to following MedED Pages URL and validate Federal TFN
      | MedSupp URL | <medicareeduUrl> |
      | TFN Xpath   | <medicareeduTFN> |
      Then the user validates PSC code
      | PSC Code | <pscCode> | 
      Then the user navigate to following MedED Pages URL and validate Federal TFN
      | MedSupp URL | <medicarearicleUrl> |
      | TFN Xpath   | <medicarearicleTFN> |
       Then the user navigate to following MedED Pages URL and validate Federal TFN
      | MedSupp URL | <medicareMadeclearUrl> |
      | TFN Xpath   | <medicareMadeclearTFN> |
       Then the user navigate to following MedED Pages URL and validate Federal TFN
      | MedSupp URL | <medicareEligibilityUrl> |
      | TFN Xpath   | <medicareEligibilityTFN> |
      Given the user Starts WebDriver
    Given user is on Bing and search UHC Medicare Advantage Plan to navigate to navigate to UHC page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
   Then the user validates PSC code
      | PSC Code | <Precedence1PSC> | 
     Then the user navigates to homepage validates Federal TFN
   	Then the user navigates to MA Plan Details Page and validates Federal TFN
   	#Then the user validates PSC code
      #| PSC Code | <Precedence1PSC> | 
   	Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
      Then the user navigates to PDP Plan Details Page and validates Federal TFN
     Then the user navigate to following MedED Pages URL and validate Federal TFN
       | MedSupp URL | <medicareeduUrl> |
      | TFN Xpath   | <medicareeduTFN> |
    Examples: 
   |scenario       | pscCode | Precedence1PSC|maUrl                                  | maTFN                                                               | medicareeduUrl                                                                | medicareeduTFN                        |decisionGuideUrl                                                          | decisionGuideTFN     | agentApptUrl                                                     | agentApptTFN   |shoppages       |shoppagesTFN                                                  |medicarearicleUrl|medicarearicleTFN|medicareMadeclearUrl|medicareMadeclearTFN|medicareEligibilityUrl|medicareEligibilityTFN|
   |Sc. 3.08 - AMP |  880188 |  880187       |shop/medicare-advantage-plans.html     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] | /medicare-education/medicare-advantage-plans.html                              | (//a[contains(@class, 'tel')])[1]     |health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn']       | health-plans/medicare-supplement-plans/agent-appointment.html    | //*[@id='tfn'] |/contact-us.html|(//*[contains(@class,'call')]//a[contains(@class,'tel')])[1]      | /medicare-articles.html                 |  (//a[contains(@class, 'tel')])[1]               |   medicare-articles/medicare-made-clear.html                 |     (//a[contains(@class, 'tel')])[1]              |    medicare-articles/eligibility-and-enrollment.html                 |        (//a[contains(@class, 'tel')])[1]                |
   
  @Scenario_4_1to8_Precedence_1_UHC_UAT
  Scenario Outline: 4.1 to 4.8 Campaign Precedence Logic No 1 for UHC
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
    Then the user navigates to MA Plan Details Page and validates Federal TFN 
  Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN 
    #------------------------**********---------------------------------
     # Precedence 4.3.3 - Visit UHC using Campaign URL, PSC code 800086
     Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaign3Url> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence2PSC> |
    Then the user navigates to MA Plan Details Page and validates Federal TFN 
  Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
    #-------------------------***********************
       # Precedence 4.3.5 - Visit site via UHC organic search from Google, PSC 880188
    # Campaign supercedes Organic search, so Expected PSC code - 800086
      Given the user Starts WebDriver
    Given user is on Google and search UHC Medicare Advantage Plan to navigate to UHC page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence3PSC> |
    Then the user navigates to homepage validates Federal TFN   
   Then the user navigates to MA Plan Details Page and validates Federal TFN 
  Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
    #------------------------------************----------------------------------------------
     # Precedence 4.3.7 - Visit UHC using Direct URL , PSC code 880180
      Given the user Starts WebDriver
    Given the user is on the uhcmedicaresolutions site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence4PSC> |
   Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
   #----------------------------**************-------------------------------------
   # Precedence 4.3.9 - Visit site via UHC organic search from Google, PSC 880188
    # Campaign supercedes Organic search, so Expected PSC code - 880188
     Given the user Starts WebDriver
    Given user is on Google and search UHC Medicare Advantage Plan to navigate to UHC page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence5PSC> |
     Then the user navigates to homepage validates Federal TFN   
   Then the user navigates to MA Plan Details Page and validates Federal TFN 
  Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
    #----------****  Campaign supercedes Campaign  ***** --------------
     # Precedence 4.3.11 - Visit site via UHC organic search from Yahoo, PSC 880189
       # Campaign supercedes Organic search, so Expected PSC code - 880189
    Given the user Starts WebDriver
    Given user is on Yahoo and search UHC Medicare Advantage Plan to navigate to UHC page
     And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence6PSC> |
     Then the user navigates to homepage validates Federal TFN   
   Then the user navigates to MA Plan Details Page and validates Federal TFN 
  Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
    #------------------------**********---------------------------------
    

    Examples: 
    | scenario                             | site   | Precedence1PSC | Precedence2PSC |  Precedence3PSC |  Precedence4PSC | Precedence5PSC |Precedence6PSC |campaign2Url    |campaign3Url      |campaign4Url                                                                                                  |
    |Scenario 4: Campaign Precedence- UMS  | blayer |        800085 |          800086|  800086         |  880180        |        880188 | 880189         | /?WT.mc_id=800085 |/?WT.mc_id=800086|/health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8001533&county=053&state=27#/plan-summary|
    
        