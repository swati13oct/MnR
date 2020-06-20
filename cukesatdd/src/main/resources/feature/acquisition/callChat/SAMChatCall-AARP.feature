Feature: 1.13 ACQ AARP- To test SAM Icons in AARP site

@samChatCall
	Scenario Outline: 1.19.1.1 To test the SAM chat Call icons on AARP site Homepage
	Given the user is on the AARP medicare site landing page
	And user opens the page to validate on AARP
 		| pagename | <pagename> |
	Then the user validates whether call icon is visible on AARP 
	Then the user validates whether chat Agent is Available on AARP	
		Examples: 
			| pagename |
			|/|

@samChatVPULayer
 Scenario Outline: 1.19.1.2 To test the SAM chat Call icons on AARP site on Visitor Profile Page to intiate a chat
    Given the user is on AARP medicare acquisition site landing page
    And user clicks on Sign in link on home page in aarp
    And user clicks on register link on home page in aarp
    Then user validates visitor profile on home page in aarp
    Then the user validates whether call icon is visible on AARP 
		Then the user validates whether chat Agent is Available on AARP
		Examples: 
			| pagename |
			|/|

@samChat
Scenario Outline: 1.19.1.3 To test the SAM  Call icons on AARP site on <pagename> chat agent not available hours
    Given the user is on the AARP medicare site landing page
	And user opens the page to validate on AARP
 	| pagename | <pagename> |
	Then the user validates whether call icon is visible on AARP 	
		Examples: 
			| pagename |
			|/|
	
	@samChatCallRegression @samChatRegression
	Scenario Outline: 1.19.1.4 To test the SAM icons on AARP site on <pagename>
	Given the user is on the AARP medicare site landing page
	And user opens the page to validate on AARP
	 | pagename | <pagename> |
	Then the user validates whether call icon is visible on AARP 
	Then the user validates whether chat icon is visible on AARP	
	Examples: 
			| pagename |
			|/|
     # | medicare-education.html                                  |
      | medicare-education/medicare-eligibility.html             |
      | medicare-education/medicare-parts-and-medigap-plans.html | 
      | medicare-education/medicare-benefits.html                |
      | medicare-education/medicare-advantage-plans.html  |
      | medicare-education/medicare-supplement-plans.html |
      | medicare-education/medicare-part-d.html           | 
      | medicare-education/medicare-costs.html                | 
      | medicare-education/enrollment-and-changing-plans.html | 
      | medicare-education/medicare-faq.html                  | 
      | health-plans/shop.html          | 
      | health-plans/shop/connect       | 
      | health-plans/shop/compare.html  | 
      | health-plans/shop/estimate.html | 
      | health-plans/shop/switch.html   |  
      | health-plans/shop/medicare-advantage-plans.html  | 
      | health-plans/shop/medicare-supplement-plans.html | 
      | health-plans/shop/prescription-drug-plans.html   | 
      | health-plans/shop/dual-special-needs-plans.html  |
      | health-plans/shop/compare/compare-pdp.html | 
      | health-plans/shop/compare/compare-ma.html  |
      | health-plans/shop/estimate/ma-costs.html   | 
      | health-plans/shop/estimate/pdp-costs.html  | 
      | health-plans/shop/medicare-advantage-plans/wellness-discounts.html     | 
      | health-plans/shop/medicare-advantage-plans/health-care-management.html | 
      | health-plans/shop/medicare-advantage-plans/ma-plan-benefits.html       | 
      | health-plans/shop/renew-active.html                                    | 
      | health-plans/enroll.html                | 
      | health-plans/enroll/ma-enrollment.html  |
      | health-plans/enroll/pdp-enrollment.html | 
      | health-plans/resources.html                                       |
      | health-plans/resources/medication-therapy-management-program.html | 
      | health-plans/resources/how-to-appoint-a-representative.html       | 
      | health-plans/resources/prescription-drug-costs-help.html          | 
      | health-plans/resources/healthcare-fraud.html                      | 
      | health-plans/resources/how-to-pay-your-premium.html               |  
      | health-plans/resources/pdp-resources-materials.html                                            | 
      | health-plans/resources/pdp-resources-materials/pdp-information-forms.html                      | 
      | health-plans/resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html |          
      | health-plans/resources/mail-order-pharmacy.html                                                | 
      | health-plans/resources/prescription-drug-appeals.html                                          | 
      | health-plans/resources/prescription-drug-transition.html                                       |
      | health-plans/resources/ma-resources-materials.html                                               | 
      | health-plans/resources/ma-resources-materials/ma-information-forms.html                          | 
      | health-plans/resources/ma-resources-materials/ma-information-forms/member-rights.html            |
      | health-plans/resources/ma-resources-materials/ma-information-forms/medicare-appeal.html          |
      #| health-plans/resources/pdp-resources-materials/pdp-information-forms/medicare-disenrollment.html | 
      | health-plans/resources/disenrollment-information.html                                            | 
      | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details |                              
      | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | 
      | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | 
      | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | 
      | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    |
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | 
      #| health-plans/estimate-drug-costs.html!/drug-cost-estimator |
      #| health-plans/aarp-pharmacy.html!/Pharmacy-Search-English   | 
      | medicare-plans.html                                        | 
      | profile/guest                                              | 
      | about-us.html                 |
      | sitemap.html                  | 
      | terms-of-use.html             | 
      | disclaimer.html               | 
      | health-insurance-brokers.html |
      | contact-us.html               | 
      | privacy-policy.html           |

