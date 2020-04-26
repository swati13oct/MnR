@acq_CALLCHAT_AARP
Feature: 1.19.1 ACQ AARP- To test Home Page in AARP site
@samChatCall
Scenario Outline: 1.19.1.1 To test the SAM icons on AARP site on <pagename>
Given the user is on the AARP medicare site landing page
And user opens the page to validate on AARP
 | pagename | <pagename> |
Then the user validates whether call icon is visible on AARP 
Then the user validates whether chat icon is visible on AARP

@header_1
Examples: 
| pagename |
|/|
|medicare-plans.html|
|health-plans/estimate-drug-costs.html|
|health-plans/aarp-pharmacy.html|

@header_2
Examples: 
| pagename |
|terms-of-use.html|
|profile.html|
|browser-update-page.html|

@healthplans_1
Examples:
| pagename |
|health-plans.html| 
|health-plans/shop.html|

@healthplans_2
Examples:
| pagename |
|health-plans/shop/renew-active.html|
|health-plans/shop/medicare-advantage-plans.html|

@healthplansma_1
Examples:
| pagename |
|health-plans/shop/medicare-advantage-plans/ma-plan-benefits.html|
|health-plans/shop/estimate/ma-costs.html|
|health-plans/shop/compare/compare-ma.html|
|health-plans/enroll/ma-enrollment.html|


@healthplansma_2
Examples:
| pagename |
|health-plans/resources/ma-resources-materials.html|
|health-plans/resources/ma-resources-materials/ma-information-forms.html|
|health-plans/resources/ma-resources-materials/ma-information-forms/medicare-appeal.html|

@healthplansma_3
Examples:
| pagename |
|health-plans/resources/ma-resources-materials/ma-information-forms/member-rights.html|
|health-plans/shop/medicare-advantage-plans/wellness-discounts.html|
|health-plans/shop/medicare-advantage-plans|health-care-management.html|

@healthplanspdp_1
Examples:
| pagename |
|health-plans/shop/prescription-drug-plans.html|
|health-plans/shop/compare/compare-pdp.html|
|health-plans/shop/estimate/pdp-costs.html|


@healthplanspdp_2
Examples:
| pagename |
|health-plans/enroll/pdp-enrollment.html|
|health-plans/resources/pdp-resources-materials.html|
|health-plans/resources/pdp-resources-materials/pdp-information-forms.html|
|health-plans/resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html|

@healthplanspdp_3
Examples:
| pagename |
|health-plans/resources/pdp-resources-materials/pdp-information-forms/medicare-disenrollment.html|
|health-plans/resources/prescription-drug-transition.html|
|health-plans/resources/prescription-drug-costs-help.html|
|health-plans/resources/prescription_drug_appeals.html|

@healthplanssupp
Examples:
| pagename |
|health-plans/medicare-supplement-plans.html|
|health-plans/medicare-supplement-plans/agent-appointment.html|

@healthplansothers_1
Examples:
| pagename |
|health-plans/shop/connect.html|
|health-plans/shop/compare.html|
|health-plans/shop/estimate.html|

@healthplansothers_2
Examples:
| pagename |
|health-plans/shop/switch.html|
|health-plans/enroll.html|
|health-plans/resources.html|
|health-plans/resources/mail-order-pharmacy.html|

@healthplansothers_3
Examples:
| pagename |
|health-plans/resources/how_to_pay_your_premium.html|
|health-plans/resources/how_to_appoint_a_representative.html|
|health-plans/resources/medication_therapy_management_program.html|| 
|health-plans/resources|healthcare-fraud.html| 

@medicareeducation_1
Examples:
| pagename |
|medicare-education.html|
|medicare-education/medicare-eligibility.html|
|medicare-education/medicare-faq.html|
|medicare-education/medicare-benefits.html|

@medicareeducation_2
Examples:
| pagename |
|medicare-education/medicare-costs.html|
|medicare-education/medicare-medicaid-dual-eligibility.html|
|medicare-education/extra-help-program.html|

@medicareeducationplans_1
Examples:
| pagename |
|medicare-education/medicare-parts-and-medigap-plans.html|
|medicare-education/medicare-advantage-plans.html|

@medicareeducationplans_2
Examples:
| pagename |
|medicare-education/medicare-supplement-plans.html|
|medicare-education/medicare-part-d.html|
|medicare-education/enrollment-and-changing-plans.html|

@footer_1
Examples:
| pagename |
|about-us.html|
|contact-us.html|
|sitemap.html|

@footer_2
Examples:
| pagename |
|privacy_policy.html|
|disclaimer.html|
|health-insurance-brokers.html|

@footer_3
Examples:
| pagename |
|shop-medicare-coverage.html|
|about-our-plans.html| 
|sitesearch.html|