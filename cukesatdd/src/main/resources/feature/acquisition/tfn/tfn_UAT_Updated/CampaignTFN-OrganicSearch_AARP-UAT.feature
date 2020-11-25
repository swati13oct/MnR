
Feature: UAT Scripts-To test Organic SearchCampaign TFN on AARP site

 #######################Script 3: Organic Search via Google and Bing##########################################
 
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
   And the user retrieves TFNSessionCookie and Federal and MedSupp TFN 
    Then the user validates PSC code
      | PSC Code | <pscCode> |  
    #Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
    #  | MedSupp URL | <medicareeduUrl> |
      #| TFN Xpath   | <medicareeduTFN> |
     # Then the user validates PSC code
    #  | PSC Code | <pscCode> | 
		Given user is on Bing and search AARP Medicare Advantage Plan to navigate to navigate to AARP page
		And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
   Then the user validates PSC code
      | PSC Code | <Precedence1PSC> | 
       Then the user navigates to homepage validates Federal TFN
   	Then the user navigates to MA Plan Details Page and validates Federal TFN
   	 And the user retrieves TFNSessionCookie and Federal and MedSupp TFN 
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
      And the user retrieves TFNSessionCookie and Federal and MedSupp TFN 
   	Then the user validates PSC code
      | PSC Code | <Precedence1PSC> | 
     Then the user navigate to following MedED Pages URL and validate Federal TFN
       | MedEd URL | <medicareeduUrl> |
      | TFN Xpath   | <medicareeduTFN> |
    Examples: 
   |scenario       | pscCode | Precedence1PSC|maUrl                                  | maTFN                                                               | medicareeduUrl                                                                | medicareeduTFN                        |decisionGuideUrl                                                          | decisionGuideTFN     | agentApptUrl                                                     | agentApptTFN   |shoppages       |shoppagesTFN                                                  |
   |Sc. 3.08 - AMP |  810106 |  810104 |shop/medicare-advantage-plans.html     | (//*[contains(@class,'call')]//a[contains(@class,'tel')])[2] | /medicare-education/medicare-advantage-plans.html                              | (//a[contains(@class, 'tel')])[1]|health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn']       | health-plans/medicare-supplement-plans/agent-appointment.html    | //*[@id='tfn'] |contact-us.html|(//*[contains(@class,'call')]//a[contains(@class,'tel')])[1]  |
   

  #######################Script 6: Campaign Precedence Logic#######################################
  @Scenario_6_Precedence_1_AARP_UAT
  Scenario Outline: <scenario> Campaign Precedence Logic No 1
    #------------------------**********---------------------------------
    # Precedence 6.1 - Visit AMP using google URL , PSC code 810106
    Given the user Starts WebDriver
     Given user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence1PSC> |
      Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> | 
     ################ # Precedence 6.3 - Visit AMP using Campign URL , PSC code 860002###############################
        Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaign2Url> |
        And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence2PSC> |
      Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> | 
    ############# # Precedence 6.5 - Visit AMP using Campign URL , PSC code 8001533###########################
     Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaign3Url> |
     And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence3PSC> |
      Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
    ####################### # Precedence 6.7 - Visit AMP using organic traffic from Google search URL , PSC code 8001533#####################
    Given user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence4PSC> |
      Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> | 
      ################# Precedence 6.9 - Visit AMP using direct URL , PSC code 810027########################
        Given the user is on AARP medicare acquisition site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence5PSC> |
     Then the user navigates to PDP Plan Details Page and validates Federal TFN
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |
 ######## Precedence 6.11 - Visit AMP using organic traffic from Google search URL , PSC code 810106##############
    Given user is on Google and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence6PSC> |
      Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> | 
    ################ # Precedence 6.13 - Visit AMP using Campign URL , PSC code 8001533################
        Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaign4Url> |
        And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence7PSC> |
      Then the user navigates to homepage validates Federal TFN
      Then the user navigates to MA Plan Details Page and validates Federal TFN 
      Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |    
    ################## Precedence 6.15 - Visit site via organic search from Yahoo, PSC code 810105######################
    Given user is on Yahoo and search AARP Medicare Advantage Plan to navigate to AARP page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence8PSC> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |

    Examples: 
   | scenario                             | site   | Precedence1PSC | Precedence2PSC |  Precedence3PSC |  Precedence4PSC | Precedence5PSC |Precedence6PSC |Precedence7PSC |Precedence8PSC       | medSuppUrl                          |medSuppTFN                                                      | campaign2Url                                                   |campaign3Url                                        |campaign4Url                                                                                                  |
   |Scenario 6: Campaign Precedence- AMP  | ulayer |        810106  |         860002 | 8001533          |  8001533        |        810027 | 810106          |  8001533        |        810105 | shop/medicare-supplement-plans.html | (//*[contains(@class,'call')]//a[contains(@class,'tel')])[2]   | /shop/medicare-advantage-plans.html?WT.mc_id=860002&zipcode=90210|/shop/medicare-advantage-plans.html?WT.mc_id=8001533|/health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8001533&county=053&state=27#/plan-summary|
  
   
     
     ############################ Script 4: AMS Referral Traffic & Referral Visit###########################################
      @Scenario4_1_ExternalLink_AARP_UAT
       Scenario Outline: <scenario> 4.7.1 Verify Externals referral plan functionalities 
    Given the user Starts WebDriver
      Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <MedsuppUrl>  |    
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
      #Then the user validate the sam icons tfn with federal TFN on Acquistion page
      Then the user navigates to PDP Plan Details Page and validates Federal TFN
      Then the user navigates to shop pages Page and validates Federal TFN
     | SHOPPAGES URL   | <shoppages> |
      | TFN Xpath | <shoppagesTFN> | 
       And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
     Then the user navigates to shop pages Page and validates Federal TFN
     | SHOPPAGES URL   | <shoppages> |
      | TFN Xpath | <shoppagesTFN> | 
       And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
      Then the user navigates to shop pages Page and validates Federal TFN
     | SHOPPAGES URL   | <shoppagescompare> |
      | TFN Xpath | <shoppagescompareTFN> | 
       And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
      Then the user navigates to shop pages Page and validates Federal TFN
     | SHOPPAGES URL   | <shoppagesdsnp> |
      | TFN Xpath | <shoppagesdsnpTFN> | 
       And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
       Then the user navigates to shop pages Page and validates Federal TFN
     | SHOPPAGES URL   | <connect> |
      | TFN Xpath | <connectTFN> | 
      And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
      Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
      Given the user is on AARP medicare acquisition site landing page
     Then the user navigates to MA Plan Details Page and validates Federal TFN
    #And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    #Then the user validates PSC code
     # | PSC Code | <pscCode> |
    Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN

     Examples:
   | scenario            | site|pscCode  | shoppages       |     shoppagesTFN                                                                 |shoppagescompare                   |             shoppagescompareTFN                                                     |shoppagesdsnp                                    |   shoppagesdsnpTFN                                 |connect                   |    connectTFN                                                       |    maUrl                                          |maTFN                                                             |         MedsuppUrl      |                                                                                                                                                                                                                                                          
   | Sc. 04.01 - 4.02    |  ulayer|8003093 |   shop.html | (//a[contains(@class, 'tel')])[1]              | shop/compare.html               |(//a[contains(@class, 'tel')])[1] |shop/dual-special-needs-plans.html  | (//a[contains(@class, 'tel')])[1] |  contact-us.html      |(//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1]  |enroll/ma-enrollment.html                          |(//a[contains(@class, 'tel')])[2]                                 |health-plans.html?product=medsup&EBRC=https://www.aarpmedicaresupplement.com/medicare-information-guide.html&intref=AARPMedicareSupplement.com&zipcode=90210&WT.mc_id=23W&#/plan-summary|
    
	