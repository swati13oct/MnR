Feature: 2.13 ACQ UHC- To test SAM Icons in UHC site

@samChatCall
Scenario Outline: 1.19.1.1 To test the SAM icons on UHC site on <pagename> Homepage
 Given the user is on medicare acquisition site landing page
    	|Site| <site>|
And user opens the page to validate M&R Sites
 | pagename | <pagename> |
Then the user validates whether call icon is visible  
#Then the user validates whether chat icon is visible on UHC
Then the user validates whether chat icon is visible
		Examples: 
			| pagename |site|
			|/|AARP|
			|/|UHC|
			
			
@samChatVPULayer
Scenario Outline: 1.19.1.2 To test the SAM icons on Visitor Profile Page to intiate a chat
	 Given the user is on medicare acquisition site landing page
    	|Site| <site>|
 	And user clicks on Sign in link on home page on site
  And user clicks on register link on home page site
  Then user validates visitor profile on home page site
	Then the user validates whether call icon is visible  
	Then the user validates whether chat icon is visible
		Examples: 
			| pagename |site|
			|/|AARP|
			|/|UHC|
			
@samChat
Scenario Outline: 1.19.1.3 To test the SAM icons on UHC site on <pagename> chat agent not available hours
 Given the user is on medicare acquisition site landing page
    	|Site| <site>|
And user opens the page to validate M&R Sites
 | pagename | <pagename> |
Then the user validates whether call icon is visible 
Then user validates whether chat Agent is not Available
		Examples: 
			| pagename |site|
			|/| AARP|
			| medicare-education/medicare-eligibility.html             |AARP|
      | medicare-education/medicare-parts-and-medigap-plans.html |AARP| 
      | medicare-education/medicare-benefits.html                |AARP|
      | medicare-education/medicare-advantage-plans.html  |AARP|
      | medicare-education/medicare-supplement-plans.html |AARP|
      | medicare-education/medicare-part-d.html           | AARP|
      | medicare-education/medicare-costs.html                | AARP|
      | medicare-education/enrollment-and-changing-plans.html | AARP|
      | medicare-education/medicare-faq.html                  | AARP|
      | shop.html          | AARP|
      | shop/connect       | AARP|
      | shop/compare.html  | AARP|
      | shop/estimate.html | AARP|
      | shop/switch.html   |  AARP|
      | shop/medicare-advantage-plans.html  | AARP|
      | shop/medicare-supplement-plans.html | AARP|
      | shop/prescription-drug-plans.html   |AARP| 
      | shop/dual-special-needs-plans.html  |AARP|
      | shop/compare/compare-pdp.html | AARP|
      | shop/compare/compare-ma.html  |AARP|
      | shop/estimate/ma-costs.html   | AARP|
      | shop/estimate/pdp-costs.html  | AARP|
      | shop/medicare-advantage-plans/wellness-discounts.html     | AARP|
      | shop/medicare-advantage-plans/health-care-management.html | AARP|
      | shop/medicare-advantage-plans/ma-plan-benefits.html       | AARP|
      | shop/renew-active.html                                    | AARP|
      | enroll.html                | AARP|
      | enroll/ma-enrollment.html  |AARP|
      | enroll/pdp-enrollment.html | AARP|
      | resources.html                                       |AARP|
      | resources/medication-therapy-management-program.html |AARP| 
      | resources/how-to-appoint-a-representative.html       | AARP|
      | resources/prescription-drug-costs-help.html          | AARP|
      | resources/healthcare-fraud.html                      | AARP|
      | resources/how-to-pay-your-premium.html               |  AARP|
      | resources/pdp-resources-materials.html                                            | AARP|
      | resources/pdp-resources-materials/pdp-information-forms.html                      | AARP|
      | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html |  AARP|        
      | resources/mail-order-pharmacy.html                                                | AARP|
      | resources/prescription-drug-appeals.html                                          | AARP|
      | resources/prescription-drug-transition.html                                       |AARP|
      | resources/ma-resources-materials.html                                               | AARP|
      | resources/ma-resources-materials/ma-information-forms.html                          | AARP|
      | resources/ma-resources-materials/ma-information-forms/member-rights.html            |AARP|
      | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html          |AARP|
      #| health-plans/resources/pdp-resources-materials/pdp-information-forms/medicare-disenrollment.html | 
      | resources/disenrollment-information.html                                            | 
      | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details |   AARP|                           
      | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | AARP|
      | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | AARP|
      | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | AARP|
      | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    |AARP|
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | AARP|
      #| health-plans/estimate-drug-costs.html!/drug-cost-estimator |AARP|
      #| health-plans/aarp-pharmacy.html!/Pharmacy-Search-English   | AARP|
      #| medicare-plans.html                                        | AARP|
      | profile/guest                                              | AARP|
      | about-us.html                 |AARP|
      | sitemap.html                  | AARP|
      | terms-of-use.html             | AARP|
      | disclaimer.html               | AARP|
     # | health-insurance-brokers.html |
      | contact-us.html               | AARP|
      | privacy-policy.html           |AARP|
			
			Examples: 		
			| pagename |site|
			|/| UHC|
			| medicare-education/medicare-eligibility.html             |UHC|
      | medicare-education/medicare-parts-and-medigap-plans.html |UHC| 
      | medicare-education/medicare-benefits.html                |UHC|
      | medicare-education/medicare-advantage-plans.html  |UHC|
      | medicare-education/medicare-supplement-plans.html |UHC|
      | medicare-education/medicare-part-d.html           | UHC|
      | medicare-education/medicare-costs.html                | UHC|
      | medicare-education/enrollment-and-changing-plans.html | UHC|
      | medicare-education/medicare-faq.html                  | UHC|
      | shop.html          | UHC|
      | shop/connect       | UHC|
      | shop/compare.html  | UHC|
      | shop/estimate.html | UHC|
      | shop/switch.html   |  UHC|
      | shop/medicare-advantage-plans.html  | UHC|
      | shop/medicare-supplement-plans.html | UHC|
      | shop/prescription-drug-plans.html   |UHC| 
      | shop/dual-special-needs-plans.html  |UHC|
      | shop/compare/compare-pdp.html | UHC|
      | shop/compare/compare-ma.html  |UHC|
      | shop/estimate/ma-costs.html   | UHC|
      | shop/estimate/pdp-costs.html  | UHC|
      | shop/medicare-advantage-plans/wellness-discounts.html     | UHC|
      | shop/medicare-advantage-plans/health-care-management.html | UHC|
      | shop/medicare-advantage-plans/ma-plan-benefits.html       | UHC|
      | shop/renew-active.html                                    | UHC|
      | enroll.html                | UHC|
      | enroll/ma-enrollment.html  |UHC|
      | enroll/pdp-enrollment.html | UHC|
      | resources.html                                       |UHC|
      | resources/medication-therapy-management-program.html |UHC| 
      | resources/how-to-appoint-a-representative.html       | UHC|
      | resources/prescription-drug-costs-help.html          | UHC|
      | resources/healthcare-fraud.html                      | UHC|
      | resources/how-to-pay-your-premium.html               |  UHC|
      | resources/pdp-resources-materials.html                                            | UHC|
      | resources/pdp-resources-materials/pdp-information-forms.html                      | UHC|
      | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html |  UHC|        
      | resources/mail-order-pharmacy.html                                                | UHC|
      | resources/prescription-drug-appeals.html                                          | UHC|
      | resources/prescription-drug-transition.html                                       |UHC|
      | resources/ma-resources-materials.html                                               | UHC|
      | resources/ma-resources-materials/ma-information-forms.html                          | UHC|
      | resources/ma-resources-materials/ma-information-forms/member-rights.html            |UHC|
      | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html          |UHC|
      #| health-plans/resources/pdp-resources-materials/pdp-information-forms/medicare-disenrollment.html | 
      | resources/disenrollment-information.html                                            | 
      | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details |   UHC|                           
      | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | UHC|
      | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | UHC|
      | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | UHC|
      | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    |UHC|
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | UHC|
      #| health-plans/estimate-drug-costs.html!/drug-cost-estimator |UHC|
      #| health-plans/UHC-pharmacy.html!/Pharmacy-Search-English   | UHC|
      #| medicare-plans.html                                        | UHC|
      | profile/guest                                              | UHC|
      | about-us.html                 |UHC|
      | sitemap.html                  | UHC|
      | terms-of-use.html             | UHC|
      | disclaimer.html               | UHC|
     # | health-insurance-brokers.html |
      | contact-us.html               | UHC|
      | privacy-policy.html           |UHC|


Scenario Outline: 1.19.1.4 To test the SAM icons on UHC site on <pagename>
 Given the user is on medicare acquisition site landing page
    	|Site| <site>|
And user opens the page to validate M&R Sites
 | pagename | <pagename> |
Then the user validates whether call icon is visible   
#Then the user validates whether chat icon is visible on UHC
Then the user validates whether chat icon is visible

@samChatCallRegressionAARP @samChatRegressionAARP1
Examples: 
			| pagename |site|
			|/| 
    #  | medicare-education.html                                  |
    | medicare-education/medicare-eligibility.html             |AARP|
      | medicare-education/medicare-parts-and-medigap-plans.html | AARP|
      | medicare-education/medicare-benefits.html                |AARP|
      | medicare-education/medicare-advantage-plans.html  |AARP|
      | medicare-education/medicare-supplement-plans.html |AARP|
      | medicare-education/medicare-part-d.html           | AARP|
      | medicare-education/medicare-costs.html                | AARP|
      | medicare-education/enrollment-and-changing-plans.html | AARP|
      | medicare-education/medicare-faq.html                  | AARP|
     
       @samChatCallRegressionAARP @samChatRegressionAARP2
			Examples:
			| pagename |site|
      | shop.html          | AARP|
      | shop/connect       | AARP|
      | shop/compare.html  | AARP|
      | shop/estimate.html | AARP|
      | shop/switch.html   |  AARP|
      | shop/medicare-advantage-plans.html  | AARP|
      | shop/medicare-supplement-plans.html | AARP|
      | shop/prescription-drug-plans.html   | AARP|
      | shop/dual-special-needs-plans.html  |AARP|
      | shop/compare/compare-pdp.html | AARP|
      | shop/compare/compare-ma.html  |AARP|
      | shop/estimate/ma-costs.html   | AARP|
      | shop/estimate/pdp-costs.html  | AARP|
      | shop/medicare-advantage-plans/wellness-discounts.html     | AARP|
      | shop/medicare-advantage-plans/health-care-management.html | AARP|
      | shop/medicare-advantage-plans/ma-plan-benefits.html       | AARP|
      | shop/renew-active.html                                    | AARP|
      | enroll.html                | AARP|
      | enroll/ma-enrollment.html  |AARP|
      | enroll/pdp-enrollment.html | AARP|
      
      @samChatCallRegressionAARP @samChatRegressionAARP3
			Examples:
			| pagename |site|
      | resources.html                                       |AARP|
      | resources/medication-therapy-management-program.html | AARP|
      | resources/how-to-appoint-a-representative.html       | AARP|
      | resources/prescription-drug-costs-help.html          | AARP|
      | resources/healthcare-fraud.html                      | AARP|
      | resources/how-to-pay-your-premium.html               | AARP| 
      | resources/pdp-resources-materials.html                                            | AARP|
      | resources/pdp-resources-materials/pdp-information-forms.html                      | AARP|
      | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html | AARP|         
      | resources/mail-order-pharmacy.html                                                |AARP| 
      | resources/prescription-drug-appeals.html                                          | AARP|
      | resources/prescription-drug-transition.html                                       |AARP|
      | resources/ma-resources-materials.html                                               |AARP| 
      | resources/ma-resources-materials/ma-information-forms.html                          |AARP| 
      | resources/ma-resources-materials/ma-information-forms/member-rights.html            |AARP|
      | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html          |AARP|
      #| health-plans/resources/pdp-resources-materials/pdp-information-forms/medicare-disenrollment.html | 
      | resources/disenrollment-information.html                                            | AARP|
      
  @samChatCallRegressionAARP @samChatRegressionAARP4
			Examples:
			| pagename |site|
      | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details |  AARP|                            
      | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | AARP|
      | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | AARP|
      | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   |AARP| 
      | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    |AARP|
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | AARP|
      #| health-plans/estimate-drug-costs.html!/drug-cost-estimator |
      #| health-plans/aarp-pharmacy.html!/Pharmacy-Search-English   | 
      #| medicare-plans.html                                        | 
      | profile/guest                                              | AARP|
      | about-us.html                 |AARP|
      | sitemap.html                  | AARP|
      | terms-of-use.html             | AARP|
      | disclaimer.html               | AARP|
     # | health-insurance-brokers.html |
      | contact-us.html               | AARP|
      | privacy-policy.html           |AARP|

   ###-------------------------------------------------------UHC Site--------------------------------------
   
   @samChatCallRegressionUHC @samChatRegressionUHC1
		Examples: 
			| pagename |site|
			|/| 
    #  | medicare-education.html                                  |
    | medicare-education/medicare-eligibility.html             |UHC|
      | medicare-education/medicare-parts-and-medigap-plans.html | UHC|
      | medicare-education/medicare-benefits.html                |UHC|
      | medicare-education/medicare-advantage-plans.html  |UHC|
      | medicare-education/medicare-supplement-plans.html |UHC|
      | medicare-education/medicare-part-d.html           | UHC|
      | medicare-education/medicare-costs.html                | UHC|
      | medicare-education/enrollment-and-changing-plans.html | UHC|
      | medicare-education/medicare-faq.html                  | UHC|
     
      @samChatCallRegressionUHC @samChatRegressionUHC2
			Examples:
			| pagename |site|
      | shop.html          | UHC|
      | shop/connect       | UHC|
      | shop/compare.html  | UHC|
      | shop/estimate.html | UHC|
      | shop/switch.html   |  UHC|
      | shop/medicare-advantage-plans.html  | UHC|
      | shop/medicare-supplement-plans.html | UHC|
      | shop/prescription-drug-plans.html   | UHC|
      | shop/dual-special-needs-plans.html  |UHC|
      | shop/compare/compare-pdp.html | UHC|
      | shop/compare/compare-ma.html  |UHC|
      | shop/estimate/ma-costs.html   | UHC|
      | shop/estimate/pdp-costs.html  | UHC|
      | shop/medicare-advantage-plans/wellness-discounts.html     | UHC|
      | shop/medicare-advantage-plans/health-care-management.html | UHC|
      | shop/medicare-advantage-plans/ma-plan-benefits.html       | UHC|
      | shop/renew-active.html                                    | UHC|
      | enroll.html                | UHC|
      | enroll/ma-enrollment.html  |UHC|
      | enroll/pdp-enrollment.html | UHC|
      @samChatCallRegressionUHC @samChatRegressionUHC3
			Examples:
			| pagename |site|
      | resources.html                                       |UHC|
      | resources/medication-therapy-management-program.html | UHC|
      | resources/how-to-appoint-a-representative.html       | UHC|
      | resources/prescription-drug-costs-help.html          | UHC|
      | resources/healthcare-fraud.html                      | UHC|
      | resources/how-to-pay-your-premium.html               | UHC| 
      | resources/pdp-resources-materials.html                                            | UHC|
      | resources/pdp-resources-materials/pdp-information-forms.html                      | UHC|
      | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html | UHC|         
      | resources/mail-order-pharmacy.html                                                |UHC| 
      | resources/prescription-drug-appeals.html                                          | UHC|
      | resources/prescription-drug-transition.html                                       |UHC|
      | resources/ma-resources-materials.html                                               |UHC| 
      | resources/ma-resources-materials/ma-information-forms.html                          |UHC| 
      | resources/ma-resources-materials/ma-information-forms/member-rights.html            |UHC|
      | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html          |UHC|
      #| health-plans/resources/pdp-resources-materials/pdp-information-forms/medicare-disenrollment.html | 
      | resources/disenrollment-information.html                                            | UHC|
      
      @samChatCallRegressionUHC @samChatRegressionUHC4
			Examples:
			| pagename |site|
      | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details |  UHC|                            
      | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | UHC|
      | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | UHC|
      | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   |UHC| 
      | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    |UHC|
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | UHC|
      #| health-plans/estimate-drug-costs.html!/drug-cost-estimator |
      #| health-plans/UHC-pharmacy.html!/Pharmacy-Search-English   | 
      #| medicare-plans.html                                        | 
      | profile/guest                                              | UHC|
      | about-us.html                 |UHC|
      | sitemap.html                  | UHC|
      | terms-of-use.html             | UHC|
      | disclaimer.html               | UHC|
     # | health-insurance-brokers.html |
      | contact-us.html               | UHC|
      | privacy-policy.html           |UHC|

   