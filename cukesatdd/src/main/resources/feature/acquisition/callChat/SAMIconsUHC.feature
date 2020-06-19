Feature: 2.13 ACQ UHC- To test SAM Icons in UHC site

@samChatCall
Scenario Outline: 1.19.1.1 To test the SAM icons on UHC site on <pagename>
Given user is on blue layer landing page
And user opens the page to validate on UHC
 | pagename | <pagename> |
Then the user validates whether call icon is visible on UHC   
Then the user validates whether chat icon is visible on UHC
Then the user validates whether chat Agent is Available on UHC
		Examples: 
			| pagename |
			|/|
			
			
@samChatVPULayer
Scenario Outline: 1.19.1.1 To test the SAM icons on UHC site on <pagename>
Given user is on blue layer landing page
And user opens the page to validate on UHC
 | pagename | <pagename> |
Then the user validates whether call icon is visible on UHC   
Then the user validates whether chat Agent is Available on UHC
		Examples: 
			| pagename |
			|/|

@samChat
Scenario Outline: 1.19.1.1 To test the SAM icons on UHC site on <pagename>
Given user is on blue layer landing page
And user opens the page to validate on UHC
 | pagename | <pagename> |
Then the user validates whether call icon is visible on UHC  
		Examples: 
			| pagename |
			|/| 

	@samChatCallRegression @samChatRegression
Scenario Outline: 1.19.1.1 To test the SAM icons on UHC site on <pagename>
Given user is on blue layer landing page
And user opens the page to validate on UHC
 | pagename | <pagename> |
Then the user validates whether call icon is visible on UHC   
Then the user validates whether chat icon is visible on UHC

Examples: 
			| pagename |
			|/|
      | medicare-education.html                                  |
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
      | health-plans/resources/pdp-resources-materials/pdp-information-forms/medicare-disenrollment.html | 
      | health-plans/resources/disenrollment-information.html                                            | 
      | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details |                              
      | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | 
      | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | 
      | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | 
      | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    |
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | 
      | health-plans/estimate-drug-costs.html!/drug-cost-estimator |
      | health-plans/aarp-pharmacy.html!/Pharmacy-Search-English   | 
      | medicare-plans.html                                        | 
      | profile/guest                                              | 
      | about-us.html                 |
      | sitemap.html                  | 
      | terms-of-use.html             | 
      | disclaimer.html               | 
      | health-insurance-brokers.html |
      | contact-us.html               | 
      | privacy-policy.html           |



####Old Scenarios
@headerUHC_1 @samChatCall_1 @samChatRegression
Examples: 
| pagename |
|/|
|plan-recommendation-engine.html|
|health-plans/estimate-drug-costs.html|

@headerUHC_2 @samChatCall_1 
Examples: 
| pagename |
|health-plans/aarp-pharmacy.html|
|terms-of-use.html|
|profile.html|
|browser-update-page.html|

@healthplansUHC_1 @samChatCall_1 @samChatRegression
Examples:
| pagename |
|health-plans.html| 
|health-plans/shop.html|

@healthplansUHC_2 @samChatCall_1 
Examples:
| pagename |
|health-plans/shop/renew-active.html|
|health-plans/shop/medicare-advantage-plans.html|

@healthplansmaUHC_1 @samChatCall_1 @samChatRegression
Examples:
| pagename |
|health-plans/shop/medicare-advantage-plans/ma-plan-benefits.html|
|health-plans/shop/estimate/ma-costs.html|
|health-plans/shop/compare/compare-ma.html|

@healthplansmaUHC_2 @samChatCall_2 @samChatRegression
Examples:
| pagename |
|health-plans/enroll/ma-enrollment.html|
|health-plans/resources/ma-resources-materials.html|
|health-plans/resources/ma-resources-materials/ma-information-forms.html|

@healthplansmaUHC_3 @samChatCall_2 @samChatRegression
Examples:
| pagename |
|health-plans/resources/ma-resources-materials/ma-information-forms/medicare-appeal.html|
|health-plans/resources/ma-resources-materials/ma-information-forms/member-rights.html|
|health-plans/shop/medicare-advantage-plans/wellness-discounts.html|
|health-plans/shop/medicare-advantage-plans|health-care-management.html|

@healthplanspdpUHC_1 @samChatCall_2 @samChatRegression
Examples:
| pagename |
|health-plans/shop/prescription-drug-plans.html|
|health-plans/shop/compare/compare-pdp.html|
|health-plans/shop/estimate/pdp-costs.html|

@healthplanspdpUHC_2 @samChatCall_2
Examples:
| pagename |
|health-plans/enroll/pdp-enrollment.html|
|health-plans/resources/pdp-resources-materials.html|
|health-plans/resources/pdp-resources-materials/pdp-information-forms.html|
|health-plans/resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html|

@healthplanspdpUHC_3 @samChatCall_2
Examples:
| pagename |
|health-plans/resources/pdp-resources-materials/pdp-information-forms/medicare-disenrollment.html|
|health-plans/resources/prescription-drug-transition.html|
|health-plans/resources/prescription-drug-costs-help.html|
|health-plans/resources/prescription_drug_appeals.html|

@healthplanssuppUHC @samChatCall_2
Examples:
| pagename |
|health-plans/medicare-supplement-plans.html|
#|health-plans/medicare-supplement-plans/agent-appointment.html|

@healthplansothersUHC_1 @samChatCall_3
Examples:
| pagename |
|health-plans/shop/connect.html|
|health-plans/shop/compare.html|
|health-plans/shop/estimate.html|

@healthplansothersUHC_2 @samChatCall_3
Examples:
| pagename |
|health-plans/shop/switch.html|
|health-plans/enroll.html|
|health-plans/resources.html|
|health-plans/resources/mail-order-pharmacy.html|

@healthplansothersUHC_3 @samChatCall_3
Examples:
| pagename |
|health-plans/resources/how_to_pay_your_premium.html|
|health-plans/resources/how_to_appoint_a_representative.html|
|health-plans/resources/medication_therapy_management_program.html|| 
|health-plans/resources|healthcare-fraud.html| 

@medicareeducationUHC_1 @samChatCall_3
Examples:
| pagename |
|medicare-education.html|
|medicare-education/medicare-eligibility.html|
|medicare-education/medicare-faq.html|

@medicareeducationUHC_2 @samChatCall_3
Examples:
| pagename |
|medicare-education/medicare-benefits.html|
|medicare-education/medicare-costs.html|
|medicare-education/medicare-medicaid-dual-eligibility.html|
|medicare-education/extra-help-program.html|

@medicareeducationplansUHC_1 @samChatCall_4
Examples:
| pagename |
|medicare-education/medicare-parts-and-medigap-plans.html|
|medicare-education/medicare-advantage-plans.html|
|medicare-education/medicare-supplement-plans.html|

@medicareeducationplansUHC_2 @samChatCall_4
Examples:
| pagename |
|medicare-education/medicare-part-d.html|
|medicare-education/enrollment-and-changing-plans.html|

@footerUHC_1 @samChatCall_4
Examples:
| pagename |
|about-us.html|
|contact-us.html|
|sitemap.html|

@footerUHC_2 @samChatCall_4
Examples:
| pagename |
|privacy_policy.html|
|disclaimer.html|
|health-insurance-brokers.html|

@footerUHC_3 @samChatCall_4
Examples:
| pagename |
|shop-medicare-coverage.html|
|about-our-plans.html| 
|sitesearch.html|