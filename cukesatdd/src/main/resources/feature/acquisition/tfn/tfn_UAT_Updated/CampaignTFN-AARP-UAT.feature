Feature: UAT Scripts-To test Campaign TFN in all flows on AARP site

 
 #######################Script 1: Direct traffic########################################
   @Scenario_1_2_DirectTraffic_UAT @UATRegression
  Scenario Outline: <scenario> 1.0 Verify TFN in VPP Plan Details and OLE pages, DCE,
   Given the user is on AARP medicare acquisition site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates TFN Number
       | TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to MA Plan Details Page and validates Federal TFN
    	  | Zip Code        | <zipcode>|
 		Then the user validates TFN Number
       | TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
    Then the user navigate to following MedED Pages URL and validate Federal TFN
       | MedEd URL | <medicareUrl> |
    Then the user validates TFN Number
       | TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
   Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
   	  | Zip Code        | <zipcode>|
   	Then the user validates TFN Number
       | TFN No | <TFNNo> |
       | TFN Xpath | <MedsuppTFNxpath> |
    Then the user navigates to plan tab for any plan
        | Plan Type | <PDPplantype> |
  Then the user navigates to Plan Details Page for any plan and validates Federal TFN 
      | Plan Type | <PDPplantype> |
  Then the user validates TFN Number
       | TFN No | <TFNNo> |
        | TFN Xpath | <TFNxpath> |
  Then the user navigates to Plan Details Page for any plan for Enroll and validates Federal TFN
    | Plan Type | <PDPplantype> |
   Then the user validates TFN Number
       | TFN No | <TFNNo> |
        | TFN Xpath | <TFNxpath> |
 #Then the user navigates to PDP Plan Details Page and validates Federal TFN
 	#| Zip Code        | <zipcode>|
 #Then the user navigates to PDP OLE Page and validates Federal TFN
 #	| Zip Code        | <zipcode>|
 Then the user navigates to homepage validates Federal TFN
  #And the user selects the state drop down value in AARP home page
    # | State | <state> |
     And the user clicks on the shopping cart icon in AARP site
  	#And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
 		Then the user validates TFN Number
        | TFN No | <TFNNo> |
        | TFN Xpath | <TFNxpath> |
	And the user clicks on the add plans button in the profile in AARP site
	  Then the user validates TFN Number
        | TFN No | <TFNNo> |
        | TFN Xpath | <TFNxpath> |
   # And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> | 
     Then the user navigates to plan tab for any plan
        | Plan Type | <MAplantype> |  
    Then the user navigates to Plan Details Page for any plan and validates Federal TFN 
      | Plan Type | <MAplantype> |
     Then the user validates TFN Number
        | TFN No | <TFNNo> |
        | TFN Xpath | <TFNxpath> |
    Then the user navigates to following  DCE Page URL and validate Federal TFN
      | DCE URL | <dceUrl> |
    Then the user validates TFN Number
        | TFN No | <TFNNo> |
        | TFN Xpath | <DCETFNxpath> |
    #Then the user navigates to homepage validates Federal TFN
    Then the user navigates to following memeber signin page and navigate to view medicare plans link AARP
      | Member Signin URL | <memberSignIn>               |
      | Member Signin URL STG | <memberSignInstage>      |
      | Member Signin URL Offline| <memberSignInOffline> |
 		 Then the user validates TFN Number
        | TFN No | <memberTFNNo> |
        | TFN Xpath | <TFNxpath> |
   # And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <Precedence2PSC> |
    #Then the user validate the sam icons tfn with federal TFN on Acquistion page

    Examples: 
      | scenario         | site |zipcode|TFNNo          |memberTFNNo   |memberSignIn                  |memberSignInstage               |memberSignInOffline              | pscCode | maUrl                     | pdpUrl                        |  snpUrl                                                                                                                                                                                                                                                                                                                      | medSuppUrl                                                                |  medicareUrl             | site   | zipcode | plantype | isMultutiCounty | planyear | dceUrl                                                     | Precedence2PSC | PDPplantype|MAplantype|TFNxpath                         |MedsuppTFNxpath                  |DCETFNxpath|
 			| Scenario 1 - AMP | AARP |90210  |1-877-699-5710 |1-855-349-3447|https://www.medicare.uhc.com/ | https://stage-medicare.uhc.com/|https://offline.medicare.uhc.com/| 810027  | enroll/ma-enrollment.html |  shop/estimate/pdp-costs.html | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true  |  medicare-education.html | Ulayer |   80001 | MA       | No              | current  | health-plans/estimate-drug-costs.html#/drug-cost-estimator |        8009508 | PDP        |MA        |(//a[contains(@class, 'tel')])[1]|//*[contains(@class,'tel right')]|//button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')]|
     
  #######################Script 2: Campaign traffic########################################
  @Scenario_2_CampaignTraffic_UAT @UATRegression
  Scenario Outline: <scenario> Verify TFN for different plan types through Campaign Traffic
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>        |
      | Campaign URL | <campaignUrl2> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to plan tab on VPP and validates Federal TFN
       | Plan Type | <MAplantype> |
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>        |
      | Campaign URL | <campaignUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    #Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
     # | MedSupp URL | <medSuppUrl> |
     # | TFN Xpath   | <medSuppTFN> |
     Then the user navigates to shop pages Page and validates Federal TFN
      | SHOPPAGES URL |<medSuppUrl> |
     | TFN Xpath   | <medSuppTFN> |
   # Then the user navigates to homepage validates Federal TFN
    #Then the user navigates to MA Plan Details Page and validates Federal TFN
    #  Then the user navigate to following SNP Plan page URL and validate Federal TFN
    #    | SNP URL   | <snpUrl> |
    #    | TFN Xpath | <snpTFN> |
    #And the user hovers screen over the shop for a plan
   # And click on Enroll Plan on shoppages for plans
    #And click on how to enroll shop pages
     #	| Plan Type | <MAplantype> |
     # | Plan Name | <planName> |
     #  |Plan Year	| <planyear>|
   When the user performs plan search using Shop Pages for campaign Links
     | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |   
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
     Then the user navigates to Plan Details Page for any plan and validates Federal TFN 
       | Plan Type | <MAplantype> |
     Then the user navigates to Plan Details Page for any plan for Enroll and validates Federal TFN
    | Plan Type | <MAplantype> |
    #Then the user navigates to following MA Plan Page URL and validate Federal TFN
     # | MA URL    | <maUrl> |
     # | TFN Xpath | <maTFN> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
    	| Zip Code        | <zipcode>|
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <agentApptUrl> |
      | TFN Xpath   | <agentApptTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <decisionGuideUrl> |
      | TFN Xpath   | <decisionGuideTFN> |
    Then the user navigate to following PDP Plan Page URL and validate Federal TFN
      | PDP URL   | <pdpUrl> |
      | TFN Xpath | <pdpTFN> |
     Then the user navigates to Plan Details Page for any plan for Enroll and validates Federal TFN
    | Plan Type | <PDPplantype> |
    Then the user navigates to shop pages Page and validates Federal TFN
      | SHOPPAGES URL | <shoppages>    |
      | TFN Xpath     | <shoppagesTFN> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |

    Examples: 
    |scenario             |planyear|zipcode| planName                                         |MAplantype|PDPplantype|isMultutiCounty | county            | pscCode  | site  |campaignUrl                                                                 | maUrl                       |   maTFN                                                       | pdpUrl                                  | pdpTFN                                                         | snpUrl                                                                                                                                                                                                                                                                                                                      | snpTFN                       | decisionGuideUrl                                                          | decisionGuideTFN     | agentApptUrl                                                     | agentApptTFN   |medSuppUrl                         |medSuppTFN                                                  |shoppages         |shoppagesTFN|campaignUrl2|
    |Scenario 2 - AMP 	  | future  |90210|AARP Medicare Advantage Freedom Plus (HMO-POS)   |MA      |PDP|NO              | Baldwin County | 8001038 | ulayer|/shop/medicare-advantage-plans?zipcode=90210&WT.mc_id=8001038               | enroll/ma-enrollment.html   |  //*[contains(@class,'call')]//a[contains(@class,'tel')]      | enroll/pdp-enrollment.html              | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn']       | health-plans/medicare-supplement-plans/agent-appointment.html    | //*[@id='tfn'] |shop/medicare-advantage-plans.html|(//*[contains(@class,'call')]//a[contains(@class,'tel')])[2]|/contact-us.html|(//*[contains(@class,'call')]//a[contains(@class,'tel')])[1]|/?wt.mc_id=8001038|
   
   
    ############################ Script 4: AMS Referral Traffic & Referral Visit###########################################
      @Scenario4_1_ExternalLink_AARP_UAT @UATRegression
       Scenario Outline: <scenario> 4.7.1 Verify Externals referral plan functionalities 
    Given the user Starts WebDriver
      Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <MedsuppUrl>  |    
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
     Then the site user fills all the details in MedsuppPage
   		| DOB           | <DOB>         | 
   		Then user validate the plandetails on medsupp plans
  Then the site user clicks on Start Application Button and proceed Next 
      | DOB           | <DOB>         |
      | Firstname     | <Firstname>   |
      | Lastname      | <Lastname>    | 		
      #Then the user validate the sam icons tfn with federal TFN on Acquistion page
      Then the user navigates to PDP Plan Details Page and validates Federal TFN
      	| Zip Code        | <zipcode>|
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
     # Then the user navigates to homepage validates Federal TFN
     Given the user is on AARP medicare acquisition site landing page
     Then the user navigates to MA Plan Details Page and validates Federal TFN
     	| Zip Code        | <zipcode>|
    #And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    #Then the user validates PSC code
     # | PSC Code | <pscCode> |
    Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
    		| Zip Code        | <zipcode>|

     Examples:
   | scenario            | site|zipcode|pscCode  | shoppages       |     shoppagesTFN                                                                 |shoppagescompare                   |             shoppagescompareTFN                                                     |shoppagesdsnp                                    |   shoppagesdsnpTFN                                 |connect                   |    connectTFN                                                       |    maUrl                                          |maTFN                                                             |         MedsuppUrl      |     DOB      | Firstname | Lastname|                                                                                                                                                                                                                                                     
   | Sc. 04.01 - 4.02    |  ulayer|90210|8003093 |   shop.html | (//a[contains(@class, 'tel')])[1]              | shop/compare.html               |(//a[contains(@class, 'tel')])[1] |shop/dual-special-needs-plans.html  | (//a[contains(@class, 'tel')])[1] |  contact-us.html      |(//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1]  |enroll/ma-enrollment.html                          |(//a[contains(@class, 'tel')])[2]                                 |health-plans.html?product=medsup&EBRC=https://www.aarpmedicaresupplement.com/medicare-information-guide.html&intref=AARPMedicareSupplement.com&zipcode=90210&WT.mc_id=23W&#/plan-summary|11/13/1940 | John      | Carry   |
    
	
    #######################Script 5: Portfolio Campaign Traffic to Med Ed########################################
     
     @Scenario_5_Portfolio_CampaignTraffic_MedEd1_UAT @UATRegression
  Scenario Outline: <scenario>1.0 Verify TFN in MedEd Pages and VPP
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>        |
      | Campaign URL | <campaignUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL | <medEdURL> |
      | TFN Xpath | <medEdTFN> |
    Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL | <medEdURL1> |
      | TFN Xpath | <medEdTFN>  |
    Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL | <medEdURL2> |
      | TFN Xpath | <medEdTFN>  |
    Then the user performs plan search using Medicare articles pages for campaign Links
       | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |   
   # Then the user navigates to homepage validates Federal TFN
     Then the user navigates to Plan Details Page for any plan and validates Federal TFN 
       | Plan Type | <MAplantype> |
   # Then the user navigates to MA Plan Details Page and validates Federal TFN
    #Then the user navigates to SNP Plan Details Page and validates Federal TFN
   # Then the user navigates to SNP OLE Page and validates Federal TFN
   Then the user navigates to Plan Details Page for any plan and validates Federal TFN 
       | Plan Type | <SNPplantype> |
     Then the user navigates to Plan Details Page for any plan for Enroll and validates Federal TFN
    | Plan Type | <SNPplantype> |

    Examples: 
      | scenario                  |MAplantype|SNPplantype|zipcode| county|isMultutiCounty|site   | pscCode | campaignUrl                               | medEdURL               | medEdTFN                           | medEdURL1                                  | medEdURL2                                         |
      | Scenerio 5-Portfolio- AMP |MA        | SNP       |10001|New York County |NO      |ulayer |  8001277 | /medicare-education.html?WT.mc_id=8001277 | medicare-articles.html | (//span[@class='heading-6']//u)[1] | medicare-articles/medicare-made-clear.html | medicare-articles/eligibility-and-enrollment.html |

  #######################Script 7: Email Validation########################################
  @Scenario_7_DirectTraffic_Email_UAT @UATRegression
  Scenario Outline: <scenario> 1.0 Verify TFN through Email Validation
    Given the user is on AARP medicare acquisition site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
		Then the user validates TFN Number
       | TFN No | <TFNNo> |
       | TFN Xpath | <TFNxpath> |
    Then the user navigates to following  Medicare Education Page URL and validate Federal TFN
      | MEDICARE URL | <emailLinkUrl> |
      | TFN Xpath    | <emailLinkTFN> |
    #And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode1> |
    Then the user validates TFN Number
       | TFN No | <EmailTFNNo> |
       | TFN Xpath | <TFNxpath> |
    Then the user navigates to following  Medicare Education Page URL and validate Federal TFN
      | MEDICARE URL | <medicareUrl> |
      | TFN Xpath    | <medicareTFN> |
    Then the user validates TFN Number
       | TFN No | <EmailTFNNo> |
       | TFN Xpath | <TFNxpath> |
    #And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode1> |
    Then the user navigates to shop pages Page and validates Federal TFN
      | SHOPPAGES URL | <shoppagesUrl> |
      | TFN Xpath     | <shoppagesTFN> |
    #And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode1> |
		Then the user validates TFN Number
       | TFN No | <MedicareSupplementTFNNo> |
       | TFN Xpath | <MedicareSupplementTFNxpath> |
    Examples: 
      | scenario               | pscCode | zipcode|pscCode1 | emailLinkUrl                                                      | emailLinkTFN                      | medicareUrl            | medicareTFN                                                                         | shoppagesUrl                        | shoppagesTFN                                                                      |TFNNo         |TFNxpath                         |EmailTFNNo    |MedicareSupplementTFNNo|MedicareSupplementTFNxpath         |
 			| Scenario 7-Email - AMP |  810027 | 90210  | 8013925 | /?WT.mc_id=8013925&mrcid=em:Acq:MR%7CNTM65%7CEGEM3107%7C::8013925 | (//a[contains(@class, 'tel')])[1] | medicare-articles.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] | shop/medicare-supplement-plans.html | //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] |1-877-699-5710|(//a[contains(@class, 'tel')])[1]|1-855-593-6479|1-866-324-0819         | (//a[contains(@class, 'tel')])[2] |
   
  #######################Script 8: External Link PDP########################################
  @Scenario_8_External_Link_PDP_UAT @UATRegression
  Scenario Outline: <scenario> 1.0  Verify TFN through External Links PDP
    Given the user Starts WebDriver
    Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>        |
      | Campaign URL | <campaignUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to PDP Plan Details Page and validates Federal TFN
    	| Zip Code        | <zipcode>|
    Then the user navigates to homepage validates Federal TFN
    Then the user navigates to MA Plan Details Page and validates Federal TFN
    	| Zip Code        | <zipcode>|
    Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
    	| Zip Code        | <zipcode>|
    Then the user navigates to SNP Plan Details Page and validates Federal TFN
    	| Zip Code        | <zipcode>|
    Then the user navigates to SNP OLE Page and validates Federal TFN
    	| Zip Code        | <zipcode>|
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
    #Then the user clicks on Review Drug Costs to Land on Zip Entry Page
   # When user enters valid zipcode and county
    #  | ZipCode | <zipCode> |
    #And user clicks on continue button in Zip Entry Page
    #Then the user selects View plan details for following plantype and PlanName for DCE Page
     # | Plan Type | <planType> |
     # | Plan Name | <planName> |
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
      | MedEd URL | <estimateUrl>  |
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
       |scenario                         | site  |zipcode|pscCode | campaignUrl                                                                                                  | campaignUrl1                                                                                 |drug1   |zipCode|planType | planName                                                                          | campaignUrl2                                                                                                |distance|countyName |ny_planYear | ny_planName                     |pharmacyType                |medEdURL1                                                        | medEdTFN|shoppagesUrl                                              |      shoppagesTFN             |estimateUrl|
       |Scenerio 8-ExternalLink - AMP 	| ulayer |90210|8001024 | health-plans/prescription-drug-plans/available-plans.html?WT.mc_id=8001024&county=053&state=27#/plan-summary |  health-plans/estimate-drug-costs.html?WT.mc_id=8001024&county=053&state=27#/getstarted      | Lipitor|10001| MAPD     |AARP Medicare Advantage Prime (HMO)                                                 | health-plans/aarp-pharmacy.html?WT.mc_id=8001024&county=053&state=27#/Pharmacy-Search-English               |    15 | None       | 2020 | AARP MedicareRx Preferred (PDP) | Preferred Retail Pharmacy Network|  medicare-articles/eligibility-and-enrollment.html             | (//span[@class='heading-6']//u)[1] |shop/medicare-supplement-plans.html                       |//button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')]|/health-plans/estimate-drug-costs.html#/getstarted|
       
      
        #######################Script 9: External Link Plan 11########################################
   
   @Scenario_9_External_Link_UAT @UATRegression
  Scenario Outline: <scenario> 1.0 Verify TFN through External Links
    Given the user Starts WebDriver
    Given the user is on AARP medicare acquisition site from External Link and Land on MA Plans
      | Campaign URL | <campaignUrl> |
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
      Then the user navigates to Plan Details Page for any plan and validates Federal TFN 
       | Plan Type | <MAplantype> |
    #Then the user navigates to homepage validates Federal TFN  
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
   		| Zip Code        | <zipcode>|
   	 #Then the user navigates to MA OLE Page and validates Federal TFN
   	 Then the user navigates to Plan Details Page for any plan for Enroll and validates Federal TFN
    | Plan Type | <MAplantype> |
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
       |scenario                         |zipcode|MAplantype| pscCode |state| campaignUrl                                                                                      | medEdURL1                                  | medEdTFN                                                        | shoppagesUrl|      shoppagesTFN             |userName|password|
       |Scenerio 9-ExternalLink - AMP 	 | 90210 |MA       | 8000158 |Alabama| health-plans.html?zipcode=10001&WT.mc_id=8000158&county=420&state=36#/plan-summary               |   medicare-articles/medicare-made-clear.html         |         (//span[@class='heading-6']//u)[1]              |  shop/medicare-supplement-plans.html                       |//button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')]|mnrqavd11|Password@1|
       
       
     