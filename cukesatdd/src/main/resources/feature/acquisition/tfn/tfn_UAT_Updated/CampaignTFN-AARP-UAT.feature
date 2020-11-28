
Feature: UAT Scripts-To test Campaign TFN in all flows on AARP site

 
 #######################Script 1: Direct traffic########################################
   @Scenario_1_2_DirectTraffic_UAT1 
  Scenario Outline: <scenario> 1.0 Verify TFN in VPP Plan Details and OLE pages, DCE,
    Given the user is on medicare acquisition site landing page
      | Site | <site> | 
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> | 
    Then the user navigates to MA Plan Details Page and validates Federal TFN
   # Then the user navigates to following MA Plan Page URL and validate Federal TFN
     # | MA URL    | <maUrl> |
     # | TFN Xpath | <maTFN> |
    Then the user navigate to following MedED Pages URL and validate Federal TFN  
      | MedEd URL    | <medicareUrl> |
      | TFN Xpath | <medicareTFN> |
   Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
 Then the user navigates to PDP Plan Details Page and validates Federal TFN
 Then the user navigates to PDP OLE Page and validates Federal TFN
 Then the user navigates to homepage validates Federal TFN
  And the user selects the state drop down value in AARP home page
     | State | <state> |
     And the user clicks on the shopping cart icon in AARP site
  	And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
And the user clicks on the add plans button in the profile in AARP site
When the user enters zipcode on health plans page
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
   And the user views the plans of the below plan type
      | Plan Type | <plantype> |
      | Site      | <site>     |
   And the user selects plan year
      | Plan Year | <planyear> |
      | Plan Type | <plantype> |
   	And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> | 
   #Then the user view plan details of the first plan in the given plan type and perform validation in test site
    #And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    #Then the user validates PSC code
     # | PSC Code | <pscCode> |   
    Then the user navigates to following  DCE Page URL and validate Federal TFN 
      | DCE URL    | <dceUrl> |
    Then the user validate the sam icons tfn with federal TFN on Acquistion page 
    Then the user navigates to following memeber signin page and navigate to view medicare plans link AARP
     | Member Signin URL |<memberSignIn>     |
     And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
     Then the user validates PSC code
      | PSC Code | <Precedence2PSC> |
      Then the user validate the sam icons tfn with federal TFN on Acquistion page
  Examples: 
  |scenario           | site	|pscCode | maUrl                                  | maTFN                                                          | pdpUrl                                    | pdpTFN                                                         | snpUrl                                                                                                                                                                                                                                                                                                                      | snpTFN                       | medSuppUrl                                                                | medSuppTFN     | medicareUrl                |medicareTFN                        | site   | zipcode | plantype | isMultutiCounty |planyear |userName|password| dceUrl|Precedence2PSC |memberSignIn|
  |Scenario 1 - AMP 	| AARP | 810027 | enroll/ma-enrollment.html              | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | shop/estimate/pdp-costs.html              | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] | medicare-education.html     |(//a[contains(@class, 'tel')])[1]|Ulayer | 80001   | MA       | No              |current  |mnrqavd11|Password@1|health-plans/estimate-drug-costs.html#/drug-cost-estimator|8009508 |https://www.medicare.uhc.com/  |
  
  #######################Script 2: Campaign traffic########################################
 
   @Scenario_2_CampaignTraffic_UAT1 
  Scenario Outline: <scenario> Verify TFN for different plan types through Campaign Traffic
   Given the user Starts WebDriver
 Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaignUrl>  |    
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
      Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> | 
    Then the user navigates to homepage validates Federal TFN
    Then the user navigates to MA Plan Details Page and validates Federal TFN
  #  Then the user navigate to following SNP Plan page URL and validate Federal TFN
  #    | SNP URL   | <snpUrl> |
  #    | TFN Xpath | <snpTFN> |
   Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
   Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
     Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <agentApptUrl> |
      | TFN Xpath   | <agentApptTFN> |
     Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <decisionGuideUrl> |
      | TFN Xpath   | <decisionGuideTFN> |
      Then the user navigate to following PDP Plan Page URL and validate Federal TFN
      | PDP URL   | <pdpUrl> |
      | TFN Xpath | <pdpTFN> |
    Then the user navigates to shop pages Page and validates Federal TFN
     | SHOPPAGES URL   | <shoppages> |
      | TFN Xpath | <shoppagesTFN> |
          And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Examples: 
    |scenario            | pscCode  | site  |campaignUrl                                                                 | maUrl                                    |   maTFN                                                       | pdpUrl                                  | pdpTFN                                                         | snpUrl                                                                                                                                                                                                                                                                                                                      | snpTFN                       | decisionGuideUrl                                                          | decisionGuideTFN     | agentApptUrl                                                     | agentApptTFN   |medSuppUrl|medSuppTFN|shoppages|shoppagesTFN|
    |Scenario 2 - AMP 	  |  8001038 | ulayer|/shop/medicare-advantage-plans?zipcode=90210&WT.mc_id=8001038  | enroll/ma-enrollment.html   |  //*[contains(@class,'call')]//a[contains(@class,'tel')]  | enroll/pdp-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn']       | health-plans/medicare-supplement-plans/agent-appointment.html    | //*[@id='tfn'] |shop/medicare-supplement-plans.html|(//*[contains(@class,'call')]//a[contains(@class,'tel')])[2]|/contact-us.html|(//*[contains(@class,'call')]//a[contains(@class,'tel')])[1]|
   
   
    ############################ Script 4: AMS Referral Traffic & Referral Visit###########################################
      @Scenario4_1_ExternalLink_AARP_UAT1
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
      Then the user navigates to homepage validates Federal TFN
     Then the user navigates to MA Plan Details Page and validates Federal TFN
    #And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    #Then the user validates PSC code
     # | PSC Code | <pscCode> |
    Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN

     Examples:
   | scenario            | site|pscCode  | shoppages       |     shoppagesTFN                                                                 |shoppagescompare                   |             shoppagescompareTFN                                                     |shoppagesdsnp                                    |   shoppagesdsnpTFN                                 |connect                   |    connectTFN                                                       |    maUrl                                          |maTFN                                                             |         MedsuppUrl      |                                                                                                                                                                                                                                                          
   | Sc. 04.01 - 4.02    |  ulayer|8003093 |   shop.html | (//a[contains(@class, 'tel')])[1]              | shop/compare.html               |(//a[contains(@class, 'tel')])[1] |shop/dual-special-needs-plans.html  | (//a[contains(@class, 'tel')])[1] |  contact-us.html      |(//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1]  |enroll/ma-enrollment.html                          |(//a[contains(@class, 'tel')])[2]                                 |health-plans.html?product=medsup&EBRC=https://www.aarpmedicaresupplement.com/medicare-information-guide.html&intref=AARPMedicareSupplement.com&zipcode=90210&WT.mc_id=23W&#/plan-summary|
    
	
    #######################Script 5: Portfolio Campaign Traffic to Med Ed########################################
     
     @Scenario_5_Portfolio_CampaignTraffic_MedEd1_UAT1 
  Scenario Outline: <scenario>1.0 Verify TFN in MedEd Pages and VPP
   Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaignUrl>  |  
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL    | <medEdURL> |
      | TFN Xpath | <medEdTFN> |
      Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL    | <medEdURL1> |
      | TFN Xpath | <medEdTFN> |
      Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL    | <medEdURL2> |
      | TFN Xpath | <medEdTFN> |
      Then the user navigates to homepage validates Federal TFN
   	Then the user navigates to MA Plan Details Page and validates Federal TFN
   	 Then the user navigates to SNP Plan Details Page and validates Federal TFN
   	 Then the user navigates to SNP OLE Page and validates Federal TFN
    Examples: 
     |scenario                        | site|pscCode  | campaignUrl                                | medEdURL                                     |     medEdTFN                                           |    medEdURL1                                                          |medEdURL2                                     |                                                                                                                                                                                                  
     | Scenerio 5-Portfolio- AMP      | ulayer| 8001277 | /medicare-education.html?WT.mc_id=8001277  | medicare-articles.html                       | (//span[@class='heading-6']//u)[1]   |  medicare-articles/medicare-made-clear.html                          | medicare-articles/eligibility-and-enrollment.html  |
    
    
   #######################Script 7: Email Validation########################################
   @Scenario_7_DirectTraffic_Email_UAT1
  Scenario Outline: <scenario> 1.0 Verify TFN through Email Validation
    Given the user is on AARP medicare acquisition site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> | 
     Then the user navigates to following  Medicare Education Page URL and validate Federal TFN  
      | MEDICARE URL    | <emailLinkUrl> |
      | TFN Xpath | <emailLinkTFN> |
        And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
      Then the user validates PSC code
      | PSC Code | <pscCode1> | 
	   Then the user navigates to following  Medicare Education Page URL and validate Federal TFN  
      | MEDICARE URL    | <medicareUrl> |
      | TFN Xpath | <medicareTFN> |
        And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
      Then the user validates PSC code
      | PSC Code | <pscCode1> | 
      Then the user navigates to shop pages Page and validates Federal TFN
     | SHOPPAGES URL   | <shoppagesUrl> |
      | TFN Xpath | <shoppagesTFN> |
        And the user retrieves TFNSessionCookie and Federal and MedSupp TFN 
      Then the user validates PSC code
      | PSC Code | <pscCode1> | 
      
    Examples:  
       |scenario                  | pscCode |pscCode1| emailLinkUrl                                                                                      | emailLinkTFN                                                                      | medicareUrl                                   | medicareTFN                                                         | shoppagesUrl|      shoppagesTFN             |
       |Scenario 7-Email - AMP 	|  810027 | 8013925|/?WT.mc_id=8013925&mrcid=em:Acq:MR%7CNTM65%7CEGEM3107%7C::8013925 |(//a[contains(@class, 'tel')])[1]|medicare-articles.html                         |//button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')]|  shop/medicare-supplement-plans.html                       |//button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')]|
       
       #######################Script 8: External Link PDP########################################
   @Scenario_8_External_Link_PDP_UAT1
  Scenario Outline: <scenario> 1.0  Verify TFN through External Links PDP
    Given the user Starts WebDriver
      Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaignUrl>  | 
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
     Then the user navigates to PDP Plan Details Page and validates Federal TFN
      Then the user navigates to homepage validates Federal TFN
   	Then the user navigates to MA Plan Details Page and validates Federal TFN
     Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN  
     Then the user navigates to SNP Plan Details Page and validates Federal TFN 
     Then the user navigates to SNP OLE Page and validates Federal TFN 
      Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaignUrl1> |
       And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
     Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> | 
      And user clicks on continue button in Zip Entry Page 
     Then the user selects View plan details for following plantype and PlanName for DCE Page
      | Plan Type | <planType> |
      | Plan Name | <planName> |
     Given the user is on following acquisition site from Campaign Traffic
      		| Site         | <site>         |
         | Campaign URL | <campaignUrl2> |
     And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
       #And the user enters following details for the pharmacy search
      #| Zip Code    | <zipCode>    |
     # | Distance    | <distance>   |
     # | County Name | <countyName> |
    #And the user chooses a plan from dropdown list
    # | Next Year Plan Name    | <ny_planName> |
     # | Next Year Plan Year    | <ny_planYear> | 
    ###May be need to add  step 8.10 ########## Added the line 8.10 ############## 
     Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL    | <estimateUrl> |
      | TFN Xpath | <shoppagesTFN> |
      And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
   	  Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL    | <medEdURL1> |
      | TFN Xpath | <medEdTFN> |
      Then the user navigates to shop pages Page and validates Federal TFN
     | SHOPPAGES URL   | <shoppagesUrl> |
      | TFN Xpath | <shoppagesTFN> | 
      And the user retrieves TFNSessionCookie and Federal and MedSupp TFN 
      Then the user validates PSC code
      | PSC Code | <pscCode> | 
    Examples:  
       |scenario                         | site  |pscCode | campaignUrl                                                                                                  | campaignUrl1                                                                                 |drug1   |zipCode|planType | planName                                                                          | campaignUrl2                                                                                                |distance|countyName |ny_planYear | ny_planName                     |pharmacyType                |medEdURL1                                                        | medEdTFN|shoppagesUrl                                              |      shoppagesTFN             |estimateUrl|
       |Scenerio 8-ExternalLink - AMP 	| ulayer |8001024 | health-plans/prescription-drug-plans/available-plans.html?WT.mc_id=8001024&county=053&state=27#/plan-summary |  health-plans/estimate-drug-costs.html?WT.mc_id=8001024&county=053&state=27#/getstarted      | Lipitor|10001| MAPD     |AARP Medicare Advantage Prime (HMO)                                                 | health-plans/aarp-pharmacy.html?WT.mc_id=8001024&county=053&state=27#/Pharmacy-Search-English               |    15 | None       | 2020 | AARP MedicareRx Preferred (PDP) | Preferred Retail Pharmacy Network|  medicare-articles/eligibility-and-enrollment.html             | (//span[@class='heading-6']//u)[1] |shop/medicare-supplement-plans.html                       |//button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')]|/health-plans/estimate-drug-costs.html#/getstarted|
       
      
        #######################Script 9: External Link Plan 11########################################
   @Scenario_9_External_Link_UAT
  Scenario Outline: <scenario> 1.0 Verify TFN through External Links
    Given the user Starts WebDriver
    Given the user is on AARP medicare acquisition site from External Link and Land on MA Plans
      | Campaign URL | <campaignUrl>  |    
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
      Then the user navigates to homepage validates Federal TFN  
    #And the user selects the state drop down value in AARP home page
    And the user selects the state drop down value in home page
       | State | <state> |
    And the user clicks on the shopping cart icon   
    #And the user clicks on the shopping cart icon in AARP site
  	And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
     #And the user clicks on the shopping cart icon in AARP site for campaign TFN
    #Then the user signs in with optum Id credentials for campaign TFN
     # | User Name | <userName> |
     # | Password  | <password> |  
      Then the user navigates to homepage validates Federal TFN
   	Then the user navigates to MA Plan Details Page and validates Federal TFN
   	 Then the user navigates to MA OLE Page and validates Federal TFN
   	  Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL    | <medEdURL1> |
      | TFN Xpath | <medEdTFN> |
      Then the user navigates to shop pages Page and validates Federal TFN
     | SHOPPAGES URL   | <shoppagesUrl> |
      | TFN Xpath | <shoppagesTFN> | 
        And the user retrieves TFNSessionCookie and Federal and MedSupp TFN 
      Then the user validates PSC code
      | PSC Code | <pscCode> | 
    Examples:  
       |scenario                         | pscCode |state| campaignUrl                                                                                      | medEdURL1                                  | medEdTFN                                                        | shoppagesUrl|      shoppagesTFN             |userName|password|
       |Scenerio 9-ExternalLink - AMP 	|  8000158 |Alabama| health-plans.html?zipcode=10001&WT.mc_id=8000158&county=420&state=36#/plan-summary               |   medicare-articles/medicare-made-clear.html         |         (//span[@class='heading-6']//u)[1]              |  shop/medicare-supplement-plans.html                       |//button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')]|mnrqavd11|Password@1|
       
       
     