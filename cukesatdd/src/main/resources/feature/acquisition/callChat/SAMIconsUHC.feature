@acq_CHATCALL_UHC
Feature: 2.13 ACQ UHC- To test SAM Icons in UHC site

@samChatCall
Scenario Outline: 1.19.1.1 To test the SAM icons on UHC site on <pagename>
Given the user is on medicare acquisition site landing page
  | Site | <site>	|
And user opens the page to validate
 | pagename | <pagename> |
Then the user validates whether call icon is visible  
Then the user validates whether chat icon is visible

@headerUHC_1 @samChatCall_1 @samChatRegression
Examples: 
|	site	| pagename 															|
|	UHC		|	/				 															|
|	UHC		|	plan-recommendation-engine.html				|
#|medicare-plans.html|
|	UHC		|	health-plans/estimate-drug-costs.html	|

@headerUHC_2 @samChatCall_1
Examples: 
| pagename |
|health-plans/aarp-pharmacy.html|
|terms-of-use.html|
|profile.html|
|browser-update-page.html|

@healthplansUHC_1 @samChatCall_1
Examples:
| pagename |
|health-plans.html| 
|health-plans/shop.html|

@healthplansUHC_2 @samChatCall_1
Examples:
| pagename |
|health-plans/shop/renew-active.html|
|health-plans/shop/medicare-advantage-plans.html|

@healthplansmaUHC_1 @samChatCall_1
Examples:
| pagename |
|health-plans/shop/medicare-advantage-plans/ma-plan-benefits.html|
|health-plans/shop/estimate/ma-costs.html|
|health-plans/shop/compare/compare-ma.html|

@healthplansmaUHC_2 @samChatCall_2
Examples:
| pagename |
|health-plans/enroll/ma-enrollment.html|
|health-plans/resources/ma-resources-materials.html|
|health-plans/resources/ma-resources-materials/ma-information-forms.html|

@healthplansmaUHC_3 @samChatCall_2
Examples:
| pagename |
|health-plans/resources/ma-resources-materials/ma-information-forms/medicare-appeal.html|
|health-plans/resources/ma-resources-materials/ma-information-forms/member-rights.html|
|health-plans/shop/medicare-advantage-plans/wellness-discounts.html|
|health-plans/shop/medicare-advantage-plans|health-care-management.html|

@healthplanspdpUHC_1 @samChatCall_2
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