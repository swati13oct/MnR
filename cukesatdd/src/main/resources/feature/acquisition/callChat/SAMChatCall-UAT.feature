Feature: UAT Scripts-2.13 ACQ M&R- To test SAM Icons 


Scenario Outline: <scenario> 1.19.1.1 To test the SAM icons on Acq site on <site> Homepage
 Given the user is on medicare acquisition site landing page
    	|Site| <site>|
And user opens the page to validate M&R Sites
 | pagename | <pagename> |
Then the user validates whether call icon is visible  
#Then the user validates whether chat icon is visible on UHC
Then the user validates whether chat icon is visible
 			@samChatCallulayer
		Examples: 
			| pagename |site| scenario               |
			|/|AARP|E2E Scenario 1_AMP|
			@samChatCallblayer
			Examples: 
			| pagename |site| scenario               |			
			|/|UHC|E2E Scenario 1_UMS|
			
			
@samChatVPULayer
Scenario Outline: <scenario> 1.19.1.2 To test the SAM icons on Visitor Profile Page to intiate a chat
	 Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    	  And the user clicks on the shopping cart icon
 	#And user clicks on Sign in link on home page on site
 # And user clicks on register link on home page site
  #Then user validates visitor profile on home page site
	Then the user validates whether call icon is visible  
	Then the user validates whether chat icon is visible
		@samChatCallulayer
		Examples: 
			| pagename |site| scenario               |
			|/|AARP|E2E Scenario 3_AMP|
			@samChatCallblayer
		Examples: 
			| pagename |site| scenario               |			
			|/|UHC|E2E Scenario 3_UMS|
			

Scenario Outline: <scenario> 1.19.1.3 To test the SAM icons on Acq site on <site> chat agent not available hours
 Given the user is on medicare acquisition site landing page
    	|Site| <site>|
And user opens the page to validate M&R Sites
 | pagename | <pagename> |
Then the user validates whether call icon is visible 
Then user validates whether chat Agent is not Available
		@samChatnonhoursulayer
		Examples: 
			| pagename |site| scenario               |
			|/| AARP|E2E Scenario 4_AMP|
			| medicare-education/medicare-eligibility.html             |AARP|E2E Scenario 4_AMP|
      | medicare-education/medicare-parts-and-medigap-plans.html |AARP| E2E Scenario 4_AMP|
      | medicare-education/medicare-benefits.html                |AARP|E2E Scenario 4_AMP|
      | medicare-education/medicare-advantage-plans.html  |AARP|E2E Scenario 4_AMP|
      | medicare-education/medicare-supplement-plans.html |AARP|E2E Scenario 4_AMP|
      | medicare-education/medicare-part-d.html           | AARP|E2E Scenario 4_AMP|
      | medicare-education/medicare-costs.html                | AARP|E2E Scenario 4_AMP|
      | medicare-education/enrollment-and-changing-plans.html | AARP|E2E Scenario 4_AMP|
      | medicare-education/medicare-faq.html                  | AARP|E2E Scenario 4_AMP|
      | shop.html          | AARP|E2E Scenario 4_AMP|
      | shop/connect       | AARP|E2E Scenario 4_AMP|
      | shop/compare.html  | AARP|E2E Scenario 4_AMP|
      | shop/estimate.html | AARP|E2E Scenario 4_AMP|
      | shop/switch.html   |  AARP|E2E Scenario 4_AMP|
      | shop/medicare-advantage-plans.html  | AARP|E2E Scenario 4_AMP|
      | shop/medicare-supplement-plans.html | AARP|E2E Scenario 4_AMP|
      | shop/prescription-drug-plans.html   |AARP| E2E Scenario 4_AMP|
      | shop/dual-special-needs-plans.html  |AARP|E2E Scenario 4_AMP|
      | shop/compare/compare-pdp.html | AARP|E2E Scenario 4_AMP|
      | shop/compare/compare-ma.html  |AARP|E2E Scenario 4_AMP|
      | shop/estimate/ma-costs.html   | AARP|E2E Scenario 4_AMP|
      | shop/estimate/pdp-costs.html  | AARP|E2E Scenario 4_AMP|
      | shop/medicare-advantage-plans/wellness-discounts.html     | AARP|E2E Scenario 4_AMP|
      | shop/medicare-advantage-plans/health-care-management.html | AARP|E2E Scenario 4_AMP|
      | shop/medicare-advantage-plans/ma-plan-benefits.html       | AARP|E2E Scenario 4_AMP|
      | shop/renew-active.html                                    | AARP|E2E Scenario 4_AMP|
      | enroll.html                | AARP|E2E Scenario 4_AMP|
      | enroll/ma-enrollment.html  |AARP|E2E Scenario 4_AMP|
      | enroll/pdp-enrollment.html | AARP|E2E Scenario 4_AMP|
      | resources.html                                       |AARP|E2E Scenario 4_AMP|
      | resources/medication-therapy-management-program.html |AARP| E2E Scenario 4_AMP|
      | resources/how-to-appoint-a-representative.html       | AARP|E2E Scenario 4_AMP|
      | resources/prescription-drug-costs-help.html          | AARP|E2E Scenario 4_AMP|
      | resources/healthcare-fraud.html                      | AARP|E2E Scenario 4_AMP|
      | resources/how-to-pay-your-premium.html               |  AARP|E2E Scenario 4_AMP|
      | resources/pdp-resources-materials.html                                            | AARP|E2E Scenario 4_AMP|
      | resources/pdp-resources-materials/pdp-information-forms.html                      | AARP|E2E Scenario 4_AMP|
      | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html |  AARP|  E2E Scenario 4_AMP|
      | resources/mail-order-pharmacy.html                                                | AARP|E2E Scenario 4_AMP|
      | resources/prescription-drug-appeals.html                                          | AARP|E2E Scenario 4_AMP|
      | resources/prescription-drug-transition.html                                       |AARP|E2E Scenario 4_AMP|
      | resources/ma-resources-materials.html                                               | AARP|E2E Scenario 4_AMP|
      | resources/ma-resources-materials/ma-information-forms.html                          | AARP|E2E Scenario 4_AMP|
      | resources/ma-resources-materials/ma-information-forms/member-rights.html            |AARP|E2E Scenario 4_AMP|
      | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html          |AARP|E2E Scenario 4_AMP|
     | resources/disenrollment-information.html                                            | AARP|E2E Scenario 4_AMP|
      | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details |   AARP|    E2E Scenario 4_AMP|
      | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | AARP|E2E Scenario 4_AMP|
      | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | AARP|E2E Scenario 4_AMP|
      | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | AARP|E2E Scenario 4_AMP|
      | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    |AARP|E2E Scenario 4_AMP|
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | AARP|E2E Scenario 4_AMP|
     | profile/guest                                              | AARP|E2E Scenario 4_AMP|
      | about-us.html                 |AARP|E2E Scenario 4_AMP|
      | sitemap.html                  | AARP|E2E Scenario 4_AMP|
      | terms-of-use.html             | AARP|E2E Scenario 4_AMP|
      | disclaimer.html               | AARP|E2E Scenario 4_AMP|
    | contact-us.html               | AARP|E2E Scenario 4_AMP||
      | privacy-policy.html           |AARP|E2E Scenario 4_AMP|
			
			@samChatnonhoursblayer
			Examples: 		
			| pagename |site| scenario               |
			|/| UHC|E2E Scenario 4_UMS|
			| medicare-education/medicare-eligibility.html             |UHC|E2E Scenario 4_UMS|
      | medicare-education/medicare-parts-and-medigap-plans.html |UHC| E2E Scenario 4_UMS|
      | medicare-education/medicare-benefits.html                |UHC|E2E Scenario 4_UMS|
      | medicare-education/medicare-advantage-plans.html  |UHC|E2E Scenario 4_UMS|
      | medicare-education/medicare-supplement-plans.html |UHC|E2E Scenario 4_UMS|
      | medicare-education/medicare-part-d.html           | UHC|E2E Scenario 4_UMS|
      | medicare-education/medicare-costs.html                | UHC|E2E Scenario 4_UMS|
      | medicare-education/enrollment-and-changing-plans.html | UHC|E2E Scenario 4_UMS|
      | medicare-education/medicare-faq.html                  | UHC|E2E Scenario 4_UMS|
      | shop.html          | UHC|E2E Scenario 4_UMS|
      | shop/connect       | UHC|E2E Scenario 4_UMS|
      | shop/compare.html  | UHC|E2E Scenario 4_UMS|
      | shop/estimate.html | UHC|E2E Scenario 4_UMS|
      | shop/switch.html   |  UHC|E2E Scenario 4_UMS|
      | shop/medicare-advantage-plans.html  | UHC|E2E Scenario 4_UMS|
      | shop/medicare-supplement-plans.html | UHC|E2E Scenario 4_UMS|
      | shop/prescription-drug-plans.html   |UHC| E2E Scenario 4_UMS|
      | shop/dual-special-needs-plans.html  |UHC|E2E Scenario 4_UMS|
      | shop/compare/compare-pdp.html | UHC|E2E Scenario 4_UMS|
      | shop/compare/compare-ma.html  |UHC|E2E Scenario 4_UMS|
      | shop/estimate/ma-costs.html   | UHC|E2E Scenario 4_UMS|
      | shop/estimate/pdp-costs.html  | UHC|E2E Scenario 4_UMS|
      | shop/medicare-advantage-plans/wellness-discounts.html     | UHC|E2E Scenario 4_UMS|
      | shop/medicare-advantage-plans/health-care-management.html | UHC|E2E Scenario 4_UMS|
      | shop/medicare-advantage-plans/ma-plan-benefits.html       | UHC|E2E Scenario 4_UMS|
      | shop/renew-active.html                                    | UHC|E2E Scenario 4_UMS|
      | enroll.html                | UHC|E2E Scenario 4_UMS|
      | enroll/ma-enrollment.html  |UHC|E2E Scenario 4_UMS|
      | enroll/pdp-enrollment.html | UHC|E2E Scenario 4_UMS||
      | resources.html                                       |UHC|E2E Scenario 4_UMS|
      | resources/medication-therapy-management-program.html |UHC| E2E Scenario 4_UMS|
      | resources/how-to-appoint-a-representative.html       | UHC|E2E Scenario 4_UMS|
      | resources/prescription-drug-costs-help.html          | UHC|E2E Scenario 4_UMS|
      | resources/healthcare-fraud.html                      | UHC|E2E Scenario 4_UMS|
      | resources/how-to-pay-your-premium.html               |  UHC|E2E Scenario 4_UMS|
      | resources/pdp-resources-materials.html                                            | UHC|E2E Scenario 4_UMS|
      | resources/pdp-resources-materials/pdp-information-forms.html                      | UHC|E2E Scenario 4_UMS|
      | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html |  UHC| E2E Scenario 4_UMS|
      | resources/mail-order-pharmacy.html                                                | UHC|E2E Scenario 4_UMS|
      | resources/prescription-drug-appeals.html                                          | UHC|E2E Scenario 4_UMS|
      | resources/prescription-drug-transition.html                                       |UHC|E2E Scenario 4_UMS|
      | resources/ma-resources-materials.html                                               | UHC|E2E Scenario 4_UMS|
      | resources/ma-resources-materials/ma-information-forms.html                          | UHC|E2E Scenario 4_UMS|
      | resources/ma-resources-materials/ma-information-forms/member-rights.html            |UHC|E2E Scenario 4_UMS|
      | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html          |UHC|E2E Scenario 4_UMS|
      | resources/disenrollment-information.html                                            |UHC| E2E Scenario 4_UMS|
      | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details |   UHC|    E2E Scenario 4_UMS|
      | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | UHC|E2E Scenario 4_UMS|
      | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | UHC|E2E Scenario 4_UMS|
      | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | UHC|E2E Scenario 4_UMS|
      | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    |UHC|E2E Scenario 4_UMS|
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | UHC|E2E Scenario 4_UMS|
      | profile/guest                                              | UHC|E2E Scenario 4_UMS|
      | about-us.html                 |UHC|E2E Scenario 4_UMS|
      | sitemap.html                  | UHC|E2E Scenario 4_UMS|
      | terms-of-use.html             | UHC|E2E Scenario 4_UMS|
      | disclaimer.html               | UHC|E2E Scenario 4_UMS|
      | contact-us.html               | UHC|E2E Scenario 4_UMS|
      | privacy-policy.html           |UHC|E2E Scenario 4_UMS|


   