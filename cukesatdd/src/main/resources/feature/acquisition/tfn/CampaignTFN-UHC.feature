@tfnbluelayer
Feature: To test Campaign TFN in all flows on UHC site

  @Scenario_1_DirectTraffic_UHC @tfn_Direct_Traffic_UHC
  Scenario Outline: 1.0 Verify TFN for different plan types through Direct Traffic
    Given the user is on the uhcmedicaresolutions site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN in UHC
    Then the user validates PSC code in UHC
      | PSC Code | <pscCode> | 
    Then the user navigates to following MA Plan Page URL and validate Federal TFN in UHC
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following PDP Plan Page URL and validate Federal TFN in UHC
      | PDP URL   | <pdpUrl> |
      | TFN Xpath | <pdpTFN> |
  #  Then the user navigate to following SNP Plan page URL and validate Federal TFN in UHC
  #    | SNP URL   | <snpUrl> |
  #    | TFN Xpath | <snpTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN in UHC
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |

    Examples: 
      | pscCode | maUrl                                  | maTFN                                                          | pdpUrl                                    | pdpTFN                                                         | snpUrl                                                                                                                                                                                                                                                                                                                      | snpTFN                       | medSuppUrl                                                                | medSuppTFN     |  
     # |  880180 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/shop/estimate/pdp-costs.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] | 
  	|  880180 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | shop/estimate/pdp-costs.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] | 

   @Scenario_2_CampaignTraffic_UHC @tfn_Campaign_Traffic_UHC
  Scenario Outline: 1.0 Verify TFN for different plan types through Campaign Traffic
    Given the user is on UHC medicare solutions acquisition site from Campaign Traffic
      | Campaign URL | <campaignUrl>  |    
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN in UHC
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user validates TFN on the particular deeplink URL page in UHC
       | TFN Xpath | <campaignTFN> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN in UHC
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following PDP Plan Page URL and validate Federal TFN in UHC
      | PDP URL   | <pdpUrl> |
      | TFN Xpath | <pdpTFN> |
  #  Then the user navigate to following SNP Plan page URL and validate Federal TFN in UHC
  #    | SNP URL   | <snpUrl> |
  #    | TFN Xpath | <snpTFN> |
     Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN in UHC
      | MedSupp URL | <agentApptUrl> |
      | TFN Xpath   | <agentApptTFN> |
     Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN in UHC
      | MedSupp URL | <decisionGuideUrl> |
      | TFN Xpath   | <decisionGuideTFN> |
   
    Examples: 
      | pscCode  | campaignUrl                                                                                 | campaignTFN                    |  maUrl                                    |   maTFN                                                       | pdpUrl                                  | pdpTFN                                                         | snpUrl                                                                                                                                                                                                                                                                                                                      | snpTFN                       | decisionGuideUrl                                                          | decisionGuideTFN     | agentApptUrl                                                     | agentApptTFN   |
      #| 8003728  | /health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8003728&zipcode=90210  | //a[contains(@class , 'tel')]  |  health-plans/enroll/ma-enrollment.html   |  //*[contains(@class,'call-us')]//a[contains(@class,'tel')]   | health-plans/enroll/pdp-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn']       | health-plans/medicare-supplement-plans/agent-appointment.html    | //*[@id='tfn'] |
    | 8003728  | /health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=8003728&zipcode=90210  | //a[contains(@class , 'tel')]  |  enroll/ma-enrollment.html   |  //*[contains(@class,'call-us')]//a[contains(@class,'tel')]   | enroll/pdp-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn']       | health-plans/medicare-supplement-plans/agent-appointment.html    | //*[@id='tfn'] |
   
 
   @Scenario_1_2_DirectTraffic_UHC @tfn_Direct_Traffic_UHC
  Scenario Outline: 1.0 Verify TFN in VPP Plan Details and OLE pages for Federal Plans
    Given the user is on the uhcmedicaresolutions site landing page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN in UHC
    Then the user validates PSC code
      | PSC Code | <pscCode> | 
   Then the user navigates to MA Plan Details Page and validates Federal TFN in UHC
   Then the user navigates to PDP Plan Details Page and validates Federal TFN in UHC
   Then the user navigates to SNP Plan Details Page and validates Federal TFN in UHC
   Then the user navigates to MA OLE Page and validates Federal TFN in UHC
   Then the user navigates to PDP OLE Page and validates Federal TFN in UHC
   Then the user navigates to SNP OLE Page and validates Federal TFN in UHC
   Then the user navigates to Medsupp Plans in VPP and validates Medsupp TFN in UHC

 
      Examples: 
      | pscCode | maUrl                                  | maTFN                                                          | pdpUrl                                    | pdpTFN                                                         | snpUrl                                                                                                                                                                                                                                                                                                                      | snpTFN                       | medSuppUrl                                                                | medSuppTFN     |  
     # |  880180 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/shop/estimate/pdp-costs.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] | 
   	 |  880180 | enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | shop/estimate/pdp-costs.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] | 
   