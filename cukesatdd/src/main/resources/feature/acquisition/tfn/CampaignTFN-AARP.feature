@tfnulayer
Feature: To test Campaign TFN in all flows on AARP site

  @Scenario_1_DirectTraffic @tfn_Direct_Traffic
  Scenario Outline: 1.0 Verify TFN for different plan types through Direct Traffic
    Given the user is on AARP medicare acquisition site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> | 
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following PDP Plan Page URL and validate Federal TFN
      | PDP URL   | <pdpUrl> |
      | TFN Xpath | <pdpTFN> |
  #  Then the user navigate to following SNP Plan page URL and validate Federal TFN
  #    | SNP URL   | <snpUrl> |
  #    | TFN Xpath | <snpTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |

    Examples: 
      | pscCode | maUrl                                  | maTFN                                                          | pdpUrl                                    | pdpTFN                                                         | snpUrl                                                                                                                                                                                                                                                                                                                      | snpTFN                       | medSuppUrl                                                                | medSuppTFN     |  
     # |  810027 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/shop/estimate/pdp-costs.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] | 
 |  810027 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | shop/estimate/pdp-costs.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] | 

   @Scenario_2_CampaignTraffic @tfn_Campaign_Traffic
  Scenario Outline: 1.0 Verify TFN for different plan types through Campaign Traffic
   Given the user Starts WebDriver
    Given the user is on AARP medicare acquisition site from Campaign Traffic
      | Campaign URL | <campaignUrl>  |    
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following PDP Plan Page URL and validate Federal TFN
      | PDP URL   | <pdpUrl> |
      | TFN Xpath | <pdpTFN> |
  #  Then the user navigate to following SNP Plan page URL and validate Federal TFN
  #    | SNP URL   | <snpUrl> |
  #    | TFN Xpath | <snpTFN> |
     Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <agentApptUrl> |
      | TFN Xpath   | <agentApptTFN> |
     Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <decisionGuideUrl> |
      | TFN Xpath   | <decisionGuideTFN> |
   
    Examples: 
      | pscCode  | campaignUrl                                                                 | maUrl                                    |   maTFN                                                       | pdpUrl                                  | pdpTFN                                                         | snpUrl                                                                                                                                                                                                                                                                                                                      | snpTFN                       | decisionGuideUrl                                                          | decisionGuideTFN     | agentApptUrl                                                     | agentApptTFN   |
     # |  8001038 | /health-plans/shop/medicare-advantage-plans?zipcode=90210&WT.mc_id=8001038  | health-plans/enroll/ma-enrollment.html   |  //*[contains(@class,'call-us')]//a[contains(@class,'tel')]   | health-plans/enroll/pdp-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn']       | health-plans/medicare-supplement-plans/agent-appointment.html    | //*[@id='tfn'] |
   
     @Scenario_5_Portfolio_CampaignTraffic_MedEd @tfn_Campaign_Traffic_MedEd
  Scenario Outline: 1.0 Verify TFN in MedEd Pages and VPP
   Given the user Starts WebDriver
    Given the user is on AARP medicare acquisition site from Campaign Traffic
      | Campaign URL | <campaignUrl>  |    
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MedEd Plan Page URL and validate Federal TFN
      | MedEd URL    | <medEdURL> |
      | TFN Xpath | <medEdTFN> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
   
    Examples: 
      | pscCode  | campaignUrl                                | medEdURL                                     |     medEdTFN                                           | maUrl                                    |   maTFN                                                       |                                                                                                                                                                                                      
     # |  8001277 | /medicare-education.html?WT.mc_id=8001277  | medicare-education/medicare-eligibility.html | //*[contains(@class,'amp')]//a[contains(@class,'tel')] | health-plans/enroll/ma-enrollment.html   |  //*[contains(@class,'call-us')]//a[contains(@class,'tel')]   |
      |  8001277 | /medicare-education.html?WT.mc_id=8001277  | medicare-education/medicare-eligibility.html | //*[contains(@class,'amp')]//a[contains(@class,'tel')] | enroll/ma-enrollment.html   |  //*[contains(@class,'call-us')]//a[contains(@class,'tel')]   |
    
      @Scenario_4_ReferralTraffic @tfn_Referral_Traffic
  Scenario Outline: 1.0 Verify TFN in VPP Tabs through Referral Traffic
   	Given the user Starts WebDriver
   	#Given the user Starts WebDriver
    Given the user is on AARP medicare acquisition site from Campaign Traffic
      | Campaign URL | <campaignUrl>  |    
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates TFN on the particular deeplink URL page
       | TFN Xpath | <campaignTFN> |
     Then the user validates Federal TFN for PDP Plan Summary Page
      | TFN Xpath | <pdpTFN> |
     Then the user opens MA Plan Page URL and validates federal TFN
        | Site      | <site>  | 
        | MA URL    | <maUrl> |
        | TFN Xpath | <maTFN> |
     Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <agentApptUrl> |
      | TFN Xpath   | <agentApptTFN> |
   
    Examples: 
  | site    | pscCode  | campaignUrl                                                                                                                                                                               | campaignTFN                       |  maUrl                                    |   maTFN                                                       | pdpTFN                      | agentApptUrl                                                     | agentApptTFN   |
 # | ulayer  |  8003093 | /health-plans.html?product=medsup&EBRC=https://www.aarpmedicaresupplement.com/medicare-information-guide.html&intref=AARPMedicareSupplement.com&zipcode=90210&WT.mc_id=5K5#/plan-summary  | //*[contains(@class,'tel right')] | /health-plans/enroll/ma-enrollment.html   |  //*[contains(@class,'call-us')]//a[contains(@class,'tel')]   | //a[contains(@class,'tel')] | health-plans/medicare-supplement-plans/agent-appointment.html    | //*[@id='tfn'] |
 	| ulayer  |  8003093 | /health-plans.html?product=medsup&EBRC=https://www.aarpmedicaresupplement.com/medicare-information-guide.html&intref=AARPMedicareSupplement.com&zipcode=90210&WT.mc_id=5K5#/plan-summary  | //*[contains(@class,'tel right')] | enroll/ma-enrollment.html   |  //*[contains(@class,'call-us')]//a[contains(@class,'tel')]   | //a[contains(@class,'tel')] | health-plans/medicare-supplement-plans/agent-appointment.html    | //*[@id='tfn'] |
 
 
   @Scenario_1_2_DirectTraffic @tfn_Direct_Traffic
  Scenario Outline: 1.0 Verify TFN in VPP Plan Details and OLE pages for Federal Plans
    Given the user is on AARP medicare acquisition site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> | 
 Then the user navigates to MA Plan Details Page and validates Federal TFN
 Then the user navigates to PDP Plan Details Page and validates Federal TFN
 Then the user navigates to SNP Plan Details Page and validates Federal TFN
 Then the user navigates to MA OLE Page and validates Federal TFN
 Then the user navigates to PDP OLE Page and validates Federal TFN
 Then the user navigates to SNP OLE Page and validates Federal TFN
 Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN
  
      Examples: 
      | pscCode | maUrl                                  | maTFN                                                          | pdpUrl                                    | pdpTFN                                                         | snpUrl                                                                                                                                                                                                                                                                                                                      | snpTFN                       | medSuppUrl                                                                | medSuppTFN     |  
    #  |  810027 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/shop/estimate/pdp-costs.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] | 
   	|  810027 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | shop/estimate/pdp-costs.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] | 
   