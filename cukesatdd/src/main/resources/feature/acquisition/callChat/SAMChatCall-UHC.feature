Feature: 2.13 ACQ UHC- To test SAM Icons in UHC site

@samChatCall1
Scenario Outline: 1.19.1.1 To test the SAM icons on UHC site on <pagename> Homepage
Given user is on blue layer landing page
And user opens the page to validate on UHC
 | pagename | <pagename> |
Then the user validates whether call icon is visible on UHC   
#Then the user validates whether chat icon is visible on UHC
Then the user validates whether chat Agent is Available on UHC
		Examples: 
			| pagename |
			|/|
			
			
@samChatVPULayer1
Scenario Outline: 1.19.1.2 To test the SAM icons on Visitor Profile Page to intiate a chat
	Given user is on blue layer landing page
 	And user clicks on Sign in link on home page on UHC site
  And user clicks on register link on home page on UHC site
  Then user validates visitor profile on home page on UHC site
	Then the user validates whether call icon is visible on UHC   
	Then the user validates whether chat Agent is Available on UHC
		Examples: 
			| pagename |
			|/|

@samChat1
Scenario Outline: 1.19.1.3 To test the SAM icons on UHC site on <pagename> chat agent not available hours
Given user is on blue layer landing page
And user opens the page to validate on UHC
 | pagename | <pagename> |
Then the user validates whether call icon is visible on UHC  
Then the user validates whether chat Agent is not Available on UHC
		Examples: 
			| pagename |
			|/| 
			| medicare-education/medicare-eligibility.html             |
      | medicare-education/medicare-parts-and-medigap-plans.html | 
      | medicare-education/medicare-benefits.html                |
      | medicare-education/medicare-advantage-plans.html  |
      | medicare-education/medicare-supplement-plans.html |
      | medicare-education/medicare-part-d.html           | 
      | medicare-education/medicare-costs.html                | 
      | medicare-education/enrollment-and-changing-plans.html | 
      | medicare-education/medicare-faq.html                  | 
      | shop.html          | 
      | shop/connect       | 
      | shop/compare.html  | 
      | shop/estimate.html | 
      | shop/switch.html   |  
      | shop/medicare-advantage-plans.html  | 
      | shop/medicare-supplement-plans.html | 
      | shop/prescription-drug-plans.html   | 
      | shop/dual-special-needs-plans.html  |
      | shop/compare/compare-pdp.html | 
      | shop/compare/compare-ma.html  |
      | shop/estimate/ma-costs.html   | 
      | shop/estimate/pdp-costs.html  | 
      | shop/medicare-advantage-plans/wellness-discounts.html     | 
      | shop/medicare-advantage-plans/health-care-management.html | 
      | shop/medicare-advantage-plans/ma-plan-benefits.html       | 
      | shop/renew-active.html                                    | 
      | enroll.html                | 
      | enroll/ma-enrollment.html  |
      | enroll/pdp-enrollment.html | 
      | resources.html                                       |
      | resources/medication-therapy-management-program.html | 
      | resources/how-to-appoint-a-representative.html       | 
      | resources/prescription-drug-costs-help.html          | 
      | resources/healthcare-fraud.html                      | 
      | resources/how-to-pay-your-premium.html               |  
      | resources/pdp-resources-materials.html                                            | 
      | resources/pdp-resources-materials/pdp-information-forms.html                      | 
      | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html |          
      | resources/mail-order-pharmacy.html                                                | 
      | resources/prescription-drug-appeals.html                                          | 
      | resources/prescription-drug-transition.html                                       |
      | resources/ma-resources-materials.html                                               | 
      | resources/ma-resources-materials/ma-information-forms.html                          | 
      | resources/ma-resources-materials/ma-information-forms/member-rights.html            |
      | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html          |
      #| health-plans/resources/pdp-resources-materials/pdp-information-forms/medicare-disenrollment.html | 
      | resources/disenrollment-information.html                                            | 
      | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details |                              
      | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | 
      | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | 
      | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | 
      | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    |
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | 
      #| health-plans/estimate-drug-costs.html!/drug-cost-estimator |
      #| health-plans/aarp-pharmacy.html!/Pharmacy-Search-English   | 
      #| medicare-plans.html                                        | 
      | profile/guest                                              | 
      | about-us.html                 |
      | sitemap.html                  | 
      | terms-of-use.html             | 
      | disclaimer.html               | 
     # | health-insurance-brokers.html |
      | contact-us.html               | 
      | privacy-policy.html           |
			


Scenario Outline: 1.19.1.4 To test the SAM icons on UHC site on <pagename>
Given user is on blue layer landing page
And user opens the page to validate on UHC
 | pagename | <pagename> |
Then the user validates whether call icon is visible on UHC   
#Then the user validates whether chat icon is visible on UHC
Then the user validates whether chat Agent is Available on UHC

@samChatCallRegressionUHC11 @samChatRegressionUHC11
Examples: 
			| pagename |
			|/| 
    #  | medicare-education.html                                  |
    | medicare-education/medicare-eligibility.html             |
      | medicare-education/medicare-parts-and-medigap-plans.html | 
      | medicare-education/medicare-benefits.html                |
      | medicare-education/medicare-advantage-plans.html  |
      | medicare-education/medicare-supplement-plans.html |
      | medicare-education/medicare-part-d.html           | 
      | medicare-education/medicare-costs.html                | 
      | medicare-education/enrollment-and-changing-plans.html | 
      | medicare-education/medicare-faq.html                  | 
      
      @samChatCallRegressionUHC11 @samChatRegressionUHC21
			Examples:
			| pagename |
      | shop.html          | 
      | shop/connect       | 
      | shop/compare.html  | 
      | shop/estimate.html | 
      | shop/switch.html   |  
      | shop/medicare-advantage-plans.html  | 
      | shop/medicare-supplement-plans.html | 
      | shop/prescription-drug-plans.html   | 
      | shop/dual-special-needs-plans.html  |
      | shop/compare/compare-pdp.html | 
      | shop/compare/compare-ma.html  |
      | shop/estimate/ma-costs.html   | 
      | shop/estimate/pdp-costs.html  | 
      | shop/medicare-advantage-plans/wellness-discounts.html     | 
      | shop/medicare-advantage-plans/health-care-management.html | 
      | shop/medicare-advantage-plans/ma-plan-benefits.html       | 
      | shop/renew-active.html                                    | 
      | enroll.html                | 
      | enroll/ma-enrollment.html  |
      | enroll/pdp-enrollment.html | 
      
      @samChatCallRegressionUHC11 @samChatRegressionUHC31
			Examples:
			| pagename |
      | resources.html                                       |
      | resources/medication-therapy-management-program.html | 
      | resources/how-to-appoint-a-representative.html       | 
      | resources/prescription-drug-costs-help.html          | 
      | resources/healthcare-fraud.html                      | 
      | resources/how-to-pay-your-premium.html               |  
      | resources/pdp-resources-materials.html                                            | 
      | resources/pdp-resources-materials/pdp-information-forms.html                      | 
      | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html |          
      | resources/mail-order-pharmacy.html                                                | 
      | resources/prescription-drug-appeals.html                                          | 
      | resources/prescription-drug-transition.html                                       |
      | resources/ma-resources-materials.html                                               | 
      | resources/ma-resources-materials/ma-information-forms.html                          | 
      | resources/ma-resources-materials/ma-information-forms/member-rights.html            |
      | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html          |
      #| health-plans/resources/pdp-resources-materials/pdp-information-forms/medicare-disenrollment.html | 
      | resources/disenrollment-information.html                                            | 
      
      @samChatCallRegressionUHC11 @samChatRegressionUHC411
			Examples:
			| pagename |
      | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details |                              
      | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | 
      | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | 
      | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | 
      | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    |
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | 
      #| health-plans/estimate-drug-costs.html!/drug-cost-estimator |
      #| health-plans/aarp-pharmacy.html!/Pharmacy-Search-English   | 
      #| medicare-plans.html                                        | 
      | profile/guest                                              | 
      | about-us.html                 |
      | sitemap.html                  | 
      | terms-of-use.html             | 
      | disclaimer.html               | 
     # | health-insurance-brokers.html |
      | contact-us.html               | 
      | privacy-policy.html           |

   