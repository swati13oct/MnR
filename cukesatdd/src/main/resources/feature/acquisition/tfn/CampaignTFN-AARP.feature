@tfnulayer
Feature: To test Campaign TFN in all flows on AARP site

  @Scenario_1_DirectTraffic @tfn_Direct_Traffic
  Scenario Outline: 1.0 Verify TFN in VPP Tabs and PDP OLE
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
      |  810027 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/shop/estimate/pdp-costs.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] | 

   @Scenario_2_CampaignTraffic @tfn_Campaign_Traffic
  Scenario Outline: 1.0 Verify TFN in VPP Tabs and PDP OLE
    Given the user is on AARP medicare acquisition site from Campaign Traffic
      | Campaign URL | <campaignUrl>  |    
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
   # Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following PDP Plan Page URL and validate Federal TFN
      | PDP URL   | <pdpUrl> |
      | TFN Xpath | <pdpTFN> |
  #  Then the user navigate to following SNP Plan page URL and validate Federal TFN
  #    | SNP URL   | <snpUrl> |
  #    | TFN Xpath | <snpTFN> |
    Then the user navigate to following Agent Appointment Page URL and validate MedSupp TFN
      | Agent Appt URL | <agentApptUrl> |
      | TFN Xpath      | <agentApptTFN> |
    Then the user navigate to following Decision Guide Page URL and validate MedSupp TFN
      | Decision Guide URL | <decisionGuideUrl> |
      | TFN Xpath          | <decisionGuideTFN> |
   
    Examples: 
      | pscCode  | campaignUrl                                                                 | maTFN                                                          | pdpUrl                                  | pdpTFN                                                         | snpUrl                                                                                                                                                                                                                                                                                                                      | snpTFN                       | decisionGuideUrl                                                          | decisionGuideTFN     | agentApptUrl                                                     | agentApptTFN   |
      |  8001038 | /health-plans/shop/medicare-advantage-plans?zipcode=90210&WT.mc_id=8001038  | //*[contains(@class,'call-us')]//a[contains(@class,'tel')]     | health-plans/enroll/pdp-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details | //a[contains(@class, 'tel')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn']       | health-plans/medicare-supplement-plans/agent-appointment.html    | //*[@id='tfn'] |
   
   
  
   