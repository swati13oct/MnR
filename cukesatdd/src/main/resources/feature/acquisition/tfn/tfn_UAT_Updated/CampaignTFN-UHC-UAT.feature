Feature: UAT-SCripts To test Campaign TFN in all flows on UHC site

#######################Script 1: Direct traffic########################################
   @Scenario_1_2_DirectTraffic__UHC_UAT @UATRegression 
  Scenario Outline: <scenario>  Verify TFN in VPP Plan Details and OLE pages, DCE,
    #Given the user is on the uhcmedicaresolutions site landing page
    #And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Given the user is on medicare acquisition site landing page
   		|Site| <site>|
   #	Given the user is on the uhcmedicaresolutions site landing page
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
		When the user performs plan search using learn about medicare Pages
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then the user navigates to plan tab for any plan
        | Plan Type | <MAplantype> |
  Then the user navigates to Plan Details Page for any plan and validates Federal TFN 
      | Plan Type | <MAplantype> |
  Then the user validates TFN Number
       | TFN No | <TFNNo> |
        | TFN Xpath | <TFNxpath> |
   #Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
   	 # | Zip Code        | <zipcode>|
   	 Then the user navigates back to page
     Then the user navigates to plan tab for any plan
        | Plan Type | <MSplantype> |
  #Then the user navigates to Plan Details Page for any plan and validates Federal TFN 
      #| Plan Type | <MSplantype> |  
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
    Then the user navigates back to page
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

    Examples: 
      | scenario         | site |zipcode|TFNNo          |isMultutiCounty | county                |pscCode | maUrl                     | pdpUrl                        |  snpUrl                                                                                                                                                                                                                                                                                                                      | medSuppUrl                                                                |  medicareUrl             | site   | zipcode | plantype | isMultutiCounty | planyear | dceUrl                                                     | Precedence2PSC | PDPplantype|MAplantype|TFNxpath                         |MedsuppTFNxpath                  |DCETFNxpath|MSplantype|
 			| Scenario 1 - UMS | UHC  |90210  |1-877-596-3258 |NO              | Baldwin County        | 880180 | enroll/ma-enrollment.html |  shop/estimate/pdp-costs.html | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true  |  medicare-education.html | Ulayer |   80001 | MA       | No              | current  | health-plans/estimate-drug-costs.html#/drug-cost-estimator |        8009508 | PDP        |MA        |(//a[contains(@class, 'tel')])[1]|//*[contains(@class,'tel right')]|//button[contains(@id,'sam-call-button')]//*[contains(@class,'sam__button__text desktop')]|MS|
     
  
   #######################Script 2: Campaign traffic########################################
 
   @Scenario_2_CampaignTraffic_UHC_UAT  @UATRegression
  Scenario Outline: <scenario> Verify TFN for different plan types through Campaign Traffic
   	Given the user Starts WebDriver
      Given the user is on following acquisition site from Campaign Traffic
      | Site         | <site>         |
      | Campaign URL | <campaignUrl>  |    
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
      Then the user navigate to following MedED Pages URL and validate Federal TFN
      | MedEd URL | <connectUrl> |
      | TFN Xpath   | <connectTFN> | 
   Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
      Then the user navigates to MA OLE Page and validates Federal TFN in UHC
   Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
   Then the user navigates to PDP Plan Details Page and validates Federal TFN in UHC
   Then the user navigates to PDP OLE Page and validates Federal TFN in UHC
   Then the user navigates to SNP Plan Details Page and validates Federal TFN in UHC
   Then the user navigates to SNP OLE Page and validates Federal TFN in UHC
    Examples: 
     |scenario             | site    |pscCode  | campaignUrl                                                                 | maUrl                                    |   maTFN                                                       | pdpUrl                                  | pdpTFN                                                         | snpUrl                                                                                                                                                                                                                                                                                                                      | snpTFN                       | decisionGuideUrl                                                          | decisionGuideTFN     | agentApptUrl                                                     | agentApptTFN   |medSuppUrl|medSuppTFN|shoppages|shoppagesTFN|connectUrl|connectTFN|
     |Scenario 2 - UMS     | blayer | 8003728 | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8003728&county=053&state=27#/plan-summary  | enroll/ma-enrollment.html   |  (//*[contains(@class,'call')]//a[contains(@class,'tel')])[1]  | enroll/pdp-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn']       | health-plans/medicare-supplement-plans/agent-appointment.html    | //*[@id='tfn'] |shop/medicare-supplement-plans.html|(//*[contains(@class,'call')]//a[contains(@class,'tel')])[2]|/contact-us.html|(//*[contains(@class,'call')]//a[contains(@class,'tel')])[1]|/contact-us.html |  //button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')] |
   
   
   
   #######################Script 5: Email Validation########################################
   @Scenario_5_2_DirectTraffic_Email_UHC_UAT @UATRegression
  Scenario Outline: <scenario>  Verify TFN through Email validation
   Given the user is on the uhcmedicaresolutions site landing page
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
       |Scenario 5-Email - UMS 	|  880180 | 8014300|?WT.mc_id=8014300&mrcid=em:Acq:MR%7CNTM6501%7CEGEM3108%7C::8014300 |//a[contains(@class, 'tel') and contains(@href, 'tel')]|medicare-articles.html                         |//button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')]|  shop/medicare-supplement-plans.html                       |(//*[contains(@class,'call')]//a[contains(@class,'tel')])[2]|
       
           #######################Script 6: External Link########################################
   @Scenario_6_External_Link_UHC_UAT @UATRegression
  Scenario Outline: <scenario>  Verify TFN through External Links
    Given the user Starts WebDriver
   Given the user is on UHC medicare solutions acquisition site from Campaign Traffic
      | Campaign URL | <campaignUrl>  |    
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to homepage validates Federal TFN
		#And the user selects the state drop down value in home page
		And the user selects the state drop down value in UHC home page
      | State | <state> |
		#And the user clicks on the shopping cart icon
		And the user clicks on the shopping cart icon in UHC site
  	And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |  
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
       |scenario                         |site|state| pscCode | campaignUrl                                                                                      | medEdURL1                                  | medEdTFN                                                        | shoppagesUrl|      shoppagesTFN             |userName|password|
       |Scenerio 6-ExternalLink - UMS 	|blayer |Alabama  |8002977 | health-plans/medicare-advantage-plans/available-plans.html?zipcode=10001&WT.mc_id=8002977&county=420&state=36&coveragePerson=M&originatingSite=https%253A%252F%252Fwww.myuhcplans.com%252Fmorganstanley&subdomain=group#/plan-summary             |   medicare-articles/medicare-made-clear.html         |         (//span[@class='heading-6']//u)[1]              |  shop/medicare-supplement-plans.html                       |//button[@id='sam-call-button']//span[contains(@class,'sam__button__text desktop')]|mnrqavd11|Password@1|
       
        