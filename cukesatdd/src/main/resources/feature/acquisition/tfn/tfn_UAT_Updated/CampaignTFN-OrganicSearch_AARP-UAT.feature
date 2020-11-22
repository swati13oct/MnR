
Feature: UAT Scripts-To test Organic SearchCampaign TFN on AARP site

 #######################Script 3: Organic Search via Google and Bing#######################################
 
  @Scenario3_1_GoogleBingSearch_AARP_UAT
  Scenario Outline: - <scenario> 3.1 Google search AARP Medicare Advantage Plan
    Given the user Starts WebDriver
    Given user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user validates PSC code
      | PSC Code | <pscCode> |  
    #Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
    #  | MedSupp URL | <medicareeduUrl> |
      #| TFN Xpath   | <medicareeduTFN> |
     # Then the user validates PSC code
    #  | PSC Code | <pscCode> | 
     Given the user Starts WebDriver
		Given user is on Bing and search AARP Medicare Advantage Plan to navigate to navigate to AARP page
   Then the user validates PSC code
      | PSC Code | <Precedence1PSC> | 
   	Then the user navigates to MA Plan Details Page and validates Federal TFN
   	Then the user validates PSC code
      | PSC Code | <Precedence1PSC> | 
   	Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
   	Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <agentApptUrl> |
      | TFN Xpath   | <agentApptTFN> |
   	Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <decisionGuideUrl> |
      | TFN Xpath   | <decisionGuideTFN> |
      Then the user navigates to PDP Plan Details Page and validates Federal TFN
     Then the user navigates to shop pages Page and validates Federal TFN
     | SHOPPAGES URL   | <shoppages> |
      | TFN Xpath | <shoppagesTFN> |
     Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
       | MedSupp URL | <medicareeduUrl> |
      | TFN Xpath   | <medicareeduTFN> |
    Examples: 
   |scenario       | pscCode | Precedence1PSC|maUrl                                  | maTFN                                                               | medicareeduUrl                                                                | medicareeduTFN                        |decisionGuideUrl                                                          | decisionGuideTFN     | agentApptUrl                                                     | agentApptTFN   |shoppages       |shoppagesTFN                                                  |
   |Sc. 3.08 - AMP |  810106 |  810104 |shop/medicare-advantage-plans.html     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] | /medicare-education/medicare-advantage-plans.html                              | (//a[contains(@class, 'tel')])[1]|health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn']       | health-plans/medicare-supplement-plans/agent-appointment.html    | //*[@id='tfn'] |/contact-us.html|(//*[contains(@class,'call')]//a[contains(@class,'tel')])[1]  |
   

  #######################Script 6: Campaign Precedence Logic#######################################
  @Scenario_5_1to8_Precedence_1_AARP_UAT 
  Scenario Outline: 5.1 to 5.8 Campaign Precedence Logic No 1
    #------------------------**********---------------------------------
    # Precedence 5.1 - Visit AMP using Direct URL , PSC code 810106
        Given the user Starts WebDriver
    Given user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
      
      
      
      
      
      
      
      
      
      
    
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
      | site   | Precedence1PSC | Precedence2PSC | campaign1Url                                                              | Precedence3PSC | campaign2Url                                                 | Precedence4PSC | Precedence5PSC | maUrl                                  | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |
      | ulayer |        810106 |         810106 | /shop/medicare-advantage-plans?WT.mc_id=860002&zipcode=90210 |         860002 | /shop/medicare-advantage-plans?WT.mc_id=8001533 |        8001533 |        8001533 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |

  @Scenario_5_9to15_Precedence_2_AARP1 @tfn_Precedence_Campaign_Traffic1
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
      | site   | Precedence1PSC | Precedence2PSC | Precedence3PSC | campaign2Url                                                 | Precedence4PSC | maUrl                                  | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |
     # | ulayer |         810027 |         810106 |         810105 | /health-plans/shop/medicare-advantage-plans?WT.mc_id=8001533 |        8001533 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |
   | ulayer |         810027 |         810106 |         810105 | /shop/medicare-advantage-plans?WT.mc_id=8001533 |        8001533 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] |
         
     
     ############################ Script 4: AMS Referral Traffic & Referral Visit###########################################
      @Scenario4_1_ExternalLink_AARP_UAT
       Scenario Outline: <scenario> 4.7.1 Verify email referral plan functionalities on Plan Details page in UHC site
    Given the user Starts WebDriver
      Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
     # | Campaign URL | <campaignUrl>  |  
      | Campaign URL | <MedsuppUrl>  |    
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
      #Then the user validate the sam icons tfn with federal TFN on Acquistion page
      Then the user navigates to PDP Plan Details Page and validates Federal TFN
      Then the user navigates to shop pages Page and validates Federal TFN
     | SHOPPAGES URL   | <shoppages> |
      | TFN Xpath | <shoppagesTFN> | 
     Then the user navigates to shop pages Page and validates Federal TFN
     | SHOPPAGES URL   | <shoppages> |
      | TFN Xpath | <shoppagesTFN> | 
      Then the user navigates to shop pages Page and validates Federal TFN
     | SHOPPAGES URL   | <shoppagescompare> |
      | TFN Xpath | <shoppagescompareTFN> | 
      Then the user navigates to shop pages Page and validates Federal TFN
     | SHOPPAGES URL   | <shoppagesdsnp> |
      | TFN Xpath | <shoppagesdsnpTFN> | 
       Then the user navigates to shop pages Page and validates Federal TFN
     | SHOPPAGES URL   | <connect> |
      | TFN Xpath | <connectTFN> | 
      Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
       Given the user Starts WebDriver
      Given the user is on AARP medicare acquisition site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN

     Examples:
   | scenario            | site|pscCode  | shoppages    |     shoppagesTFN                                                                 |shoppagescompare|shoppagescompareTFN |shoppagesdsnp                                    |   shoppagesdsnpTFN                                                       |connect |    connectTFN|    maUrl                                          |maTFN                                                             |         MedsuppUrl      |                                                                                                                                                                                                                                                          
   | Sc. 04.01 - 4.02    |  ulayer|8003093 |   /shop.html | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1]| /shop/compare.html               |//button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] |shop/dual-special-needs-plans.html  | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] |  /contact-us.html      |(//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1]  |enroll/ma-enrollment.html|(//a[contains(@class, 'tel')])[2]||/health-plans.html?product=medsup&EBRC=https://www.aarpmedicaresupplement.com/medicare-information-guide.html&intref=AARPMedicareSupplement.com&zipcode=90210&WT.mc_id=23W&#/plan-summary|
    
	