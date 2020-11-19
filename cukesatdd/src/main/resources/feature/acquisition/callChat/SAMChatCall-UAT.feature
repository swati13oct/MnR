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
			|/|AARP|Scenario 1|
			@samChatCallblayer
			Examples: 
			| pagename |site| scenario               |			
			|/|UHC|Scenario 1|
			
			
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
			|/|AARP|Scenario 3|
			@samChatCallblayer
		Examples: 
			| pagename |site| scenario               |			
			|/|UHC|Scenario 3|
			

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
			|/| AARP|Scenario 4|
			| medicare-education/medicare-eligibility.html             |AARP|Scenario 4|
      | medicare-education/medicare-parts-and-medigap-plans.html |AARP| Scenario 4|
      | medicare-education/medicare-benefits.html                |AARP|Scenario 4|
      | medicare-education/medicare-advantage-plans.html  |AARP|Scenario 4|
      | medicare-education/medicare-supplement-plans.html |AARP|Scenario 4|
      | medicare-education/medicare-part-d.html           | AARP|Scenario 4|
      | medicare-education/medicare-costs.html                | AARP|Scenario 4|
      | medicare-education/enrollment-and-changing-plans.html | AARP|Scenario 4|
      | medicare-education/medicare-faq.html                  | AARP|Scenario 4|
      | shop.html          | AARP|Scenario 4|
      | shop/connect       | AARP|Scenario 4|
      | shop/compare.html  | AARP|Scenario 4|
      | shop/estimate.html | AARP|Scenario 4|
      | shop/switch.html   |  AARP|Scenario 4|
      | shop/medicare-advantage-plans.html  | AARP|Scenario 4|
      | shop/medicare-supplement-plans.html | AARP|Scenario 4|
      | shop/prescription-drug-plans.html   |AARP| Scenario 4|
      | shop/dual-special-needs-plans.html  |AARP|Scenario 4|
      | shop/compare/compare-pdp.html | AARP|Scenario 4|
      | shop/compare/compare-ma.html  |AARP|Scenario 4|
      | shop/estimate/ma-costs.html   | AARP|Scenario 4|
      | shop/estimate/pdp-costs.html  | AARP|Scenario 4|
      | shop/medicare-advantage-plans/wellness-discounts.html     | AARP|Scenario 4|
      | shop/medicare-advantage-plans/health-care-management.html | AARP|Scenario 4|
      | shop/medicare-advantage-plans/ma-plan-benefits.html       | AARP|Scenario 4|
      | shop/renew-active.html                                    | AARP|Scenario 4|
      | enroll.html                | AARP|Scenario 4|
      | enroll/ma-enrollment.html  |AARP|Scenario 4|
      | enroll/pdp-enrollment.html | AARP|Scenario 4|
      | resources.html                                       |AARP|Scenario 4|
      | resources/medication-therapy-management-program.html |AARP| Scenario 4|
      | resources/how-to-appoint-a-representative.html       | AARP|Scenario 4|
      | resources/prescription-drug-costs-help.html          | AARP|Scenario 4|
      | resources/healthcare-fraud.html                      | AARP|Scenario 4|
      | resources/how-to-pay-your-premium.html               |  AARP|Scenario 4|
      | resources/pdp-resources-materials.html                                            | AARP|Scenario 4|
      | resources/pdp-resources-materials/pdp-information-forms.html                      | AARP|Scenario 4|
      | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html |  AARP|  Scenario 4|      
      | resources/mail-order-pharmacy.html                                                | AARP|Scenario 4|
      | resources/prescription-drug-appeals.html                                          | AARP|Scenario 4|
      | resources/prescription-drug-transition.html                                       |AARP|Scenario 4|
      | resources/ma-resources-materials.html                                               | AARP|Scenario 4|
      | resources/ma-resources-materials/ma-information-forms.html                          | AARP|Scenario 4|
      | resources/ma-resources-materials/ma-information-forms/member-rights.html            |AARP|Scenario 4|
      | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html          |AARP|Scenario 4|
     | resources/disenrollment-information.html                                            | AARP|Scenario 4|
      | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details |   AARP|    Scenario 4|                       
      | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | AARP|Scenario 4|
      | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | AARP|Scenario 4|
      | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | AARP|Scenario 4|
      | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    |AARP|Scenario 4|
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | AARP|Scenario 4|
     | profile/guest                                              | AARP|Scenario 4|
      | about-us.html                 |AARP|Scenario 4|
      | sitemap.html                  | AARP|Scenario 4|
      | terms-of-use.html             | AARP|Scenario 4|
      | disclaimer.html               | AARP|Scenario 4|
    | contact-us.html               | AARP|Scenario 4||
      | privacy-policy.html           |AARP|Scenario 4|
			
			@samChatnonhoursblayer
			Examples: 		
			| pagename |site| scenario               |
			|/| UHC|Scenario 4|
			| medicare-education/medicare-eligibility.html             |UHC|Scenario 4|
      | medicare-education/medicare-parts-and-medigap-plans.html |UHC| Scenario 4|
      | medicare-education/medicare-benefits.html                |UHC|Scenario 4|
      | medicare-education/medicare-advantage-plans.html  |UHC|Scenario 4|
      | medicare-education/medicare-supplement-plans.html |UHC|Scenario 4|
      | medicare-education/medicare-part-d.html           | UHC|Scenario 4|
      | medicare-education/medicare-costs.html                | UHC|Scenario 4|
      | medicare-education/enrollment-and-changing-plans.html | UHC|Scenario 4|
      | medicare-education/medicare-faq.html                  | UHC|Scenario 4|
      | shop.html          | UHC|Scenario 4|
      | shop/connect       | UHC|Scenario 4|
      | shop/compare.html  | UHC|Scenario 4|
      | shop/estimate.html | UHC|Scenario 4|
      | shop/switch.html   |  UHC|Scenario 4|
      | shop/medicare-advantage-plans.html  | UHC|Scenario 4|
      | shop/medicare-supplement-plans.html | UHC|Scenario 4|
      | shop/prescription-drug-plans.html   |UHC| Scenario 4|
      | shop/dual-special-needs-plans.html  |UHC|Scenario 4|
      | shop/compare/compare-pdp.html | UHC|Scenario 4|
      | shop/compare/compare-ma.html  |UHC|Scenario 4|
      | shop/estimate/ma-costs.html   | UHC|Scenario 4|
      | shop/estimate/pdp-costs.html  | UHC|Scenario 4|
      | shop/medicare-advantage-plans/wellness-discounts.html     | UHC|Scenario 4|
      | shop/medicare-advantage-plans/health-care-management.html | UHC|Scenario 4|
      | shop/medicare-advantage-plans/ma-plan-benefits.html       | UHC|Scenario 4|
      | shop/renew-active.html                                    | UHC|Scenario 4|
      | enroll.html                | UHC|Scenario 4|
      | enroll/ma-enrollment.html  |UHC|Scenario 4|
      | enroll/pdp-enrollment.html | UHC|Scenario 4||
      | resources.html                                       |UHC|Scenario 4|
      | resources/medication-therapy-management-program.html |UHC| Scenario 4|
      | resources/how-to-appoint-a-representative.html       | UHC|Scenario 4|
      | resources/prescription-drug-costs-help.html          | UHC|Scenario 4|
      | resources/healthcare-fraud.html                      | UHC|Scenario 4|
      | resources/how-to-pay-your-premium.html               |  UHC|Scenario 4|
      | resources/pdp-resources-materials.html                                            | UHC|Scenario 4|
      | resources/pdp-resources-materials/pdp-information-forms.html                      | UHC|Scenario 4|
      | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html |  UHC| Scenario 4|       
      | resources/mail-order-pharmacy.html                                                | UHC|Scenario 4|
      | resources/prescription-drug-appeals.html                                          | UHC|Scenario 4|
      | resources/prescription-drug-transition.html                                       |UHC|Scenario 4|
      | resources/ma-resources-materials.html                                               | UHC|Scenario 4|
      | resources/ma-resources-materials/ma-information-forms.html                          | UHC|Scenario 4|
      | resources/ma-resources-materials/ma-information-forms/member-rights.html            |UHC|Scenario 4|
      | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html          |UHC|Scenario 4|
      | resources/disenrollment-information.html                                            |UHC| Scenario 4|
      | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details |   UHC|    Scenario 4|                       
      | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | UHC|Scenario 4|
      | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | UHC|Scenario 4|
      | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | UHC|Scenario 4|
      | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    |UHC|Scenario 4|
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | UHC|Scenario 4|
      | profile/guest                                              | UHC|Scenario 4|
      | about-us.html                 |UHC|Scenario 4|
      | sitemap.html                  | UHC|Scenario 4|
      | terms-of-use.html             | UHC|Scenario 4|
      | disclaimer.html               | UHC|Scenario 4|
      | contact-us.html               | UHC|Scenario 4|
      | privacy-policy.html           |UHC|Scenario 4|


   