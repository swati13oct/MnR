@GlobalComponentsAARP @GlobalHeaderFooter @globalComponent
Feature: 1.12 ACQ - Global Components Validation

  
  Scenario Outline: To verify links displayed in the global footer of <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When user accesses global footer of the Medicare Plans All page
    When user updates the state drop down value on the home page
      | State | <state> |
    And user clicks on View all disclaimer information link on the home page
    And user verifies visit aarp.org link on home page
    And user clicks on Aboutus link from footer of the Medicare Plans home page
    And the user clicks on browser back button
    And user clicks on contactus link on aboutus page
    And user clicks on sitemap link on contactus page
    And user clicks on privacypolicy link on sitemap page
    And user clicks on termsOfuse link on privacypolicy page
    And user clicks on disclaimers link on terms&conditions page
    And user clicks on agents&brokers link on disclaimers page

    #And user verifies home link of agents&brokers page
    #Then user clicks on back to top link of home page
    @globalfooter 
    Examples: 
      | site | state  |
      | AARP | Alaska |

    @globalfooter @uhcmedicare
    Examples: 
      | site | state  | code |
      | UHC  | Alaska | AK   |

 
  Scenario Outline: To verify links displayed in the global header of <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When user accesses global header of the Medicare Plans home page
    When user verifies the logo
    Then user validates TFN in header
    And user hover over for plan member to click to go to member site
    #And user clicks on Sign in link
    #And user clicks on register link
    #Then the user clicks on browser back button
    Then user validates visitor profile
    And the user clicks on browser back button

    #And user clicks on visit aarp.org link in the header
    #And user clicks on visit aarp.org link in the header for cancel
    @globalheader
    Examples: 
      | site |
      | AARP |

    @globalheader @uhcmedicare
    Examples: 
      | site |
      | UHC  |

  Scenario Outline: To verify Global Components for the page mentioned of <site> site <pageName> : <path> 
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    When user accesses global header of the Medicare Plans home page
    When user accesses global footer of the Medicare Plans All page
    Then the User validates Shop for a Plan Navigation link
    Then the user validates Medicare Education Navigation link
    Then the user validates whether call icon is visible
    And the user validates whether chat icon is visible
	Then the user validates the proactive chat
                
    @regressionAARP
    Examples: 
      | site | path                                         | pageName                          | 
      | AARP | medicare-education.html                                  | Understanding Medicare                |  
     | AARP | medicare-education/medicare-eligibility.html             | Medicare Eligibility                  |  
      | AARP | medicare-education/medicare-parts-and-medigap-plans.html | Medicare and Medigap Coverage Options |  
      | AARP | medicare-education/medicare-benefits.html                | Prescriptions, Providers & Benefits   |  
      | AARP | shop.html                       | ShopPlan: Shop              |  
      | AARP | shop/connect                    | ShopPlan: Request more Info |  
      | AARP | shop/compare.html               | ShopPlan: Compare           |  
      | AARP | shop/estimate.html              | ShopPlan: Estimate          |  
      | AARP | shop/switch.html                | ShopPlan: Switch            |  
      | AARP | shop/compare/compare-ms.html    | ShopPlan: Compare           |  
      | AARP | shop/estimate/ms-costs.html     | ShopPlan: Estimate          |  
      | AARP | shop/compare/compare-ma-ms.html | ShopPlan: Compare           |  
      | AARP | safe-shopping.html              | ShopPlan: Shop              |  
      | AARP | medicare-education/medicare-costs.html | Medicare Cost Basics |  
      | AARP | medicare-education/when-to-enroll.html | When to Enroll       |  
      | AARP | medicare-education/medicare-faq.html   | Medicare FAQ         |   
       | AARP | shop/compare/compare-pdp.html | ShopPlan: Compare PDP Plan  |  
      | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       |   
      | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan |   
      | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan |               
      | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      |  
      | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     |        
      | AARP | shop/compare/compare-ma.html  | ShopPlan: Compare MA  Plan  |  
      | AARP | shop/estimate/ma-costs.html   | ShopPlan: Estimate MA Plan  |  
      | AARP | shop/estimate/pdp-costs.html  | ShopPlan: Estimate PDP Plan |  
      | AARP | shop/medicare-advantage-plans/wellness-discounts.html     | ShopPlan: Welness Discount      |  
      | AARP | shop/medicare-advantage-plans/health-care-management.html | ShopPlan: Healthcare management |  
      | AARP | shop/renew-active.html                                    | ShopPlan: Renew-Active          | 
      | AARP | enroll.html                | ShopPlan: Enroll           |       
      | AARP | enroll/ma-enrollment.html  | ShopPlan: Enroll MA Plans  |  
      | AARP | enroll/pdp-enrollment.html | ShopPlan: Enroll PDP Plans |  
      | AARP | enroll/ms-apply.html       | ShopPlan: Enroll           | 
      | AARP | resources/pdp-resources-materials.html                       | ShopPlan: Resources PDP Plans           | 
      | AARP | resources/pdp-resources-materials/pdp-information-forms.html | ShopPlan: Resources PDP Plans Info      | 
      | AARP | resources/mail-order-pharmacy.html                           | ShopPlan: Resources Mail Order Pharmacy |  
      | AARP | medicare-education/medicare-advantage-plans.html  | Learn about Medicare Advantage Plans  |  
      | AARP | medicare-education/medicare-supplement-plans.html | Learn about Medicare Supplement Plans |  
      | AARP | medicare-education/medicare-part-d.html           | Medicare Prescription Drug Plans      |                                                     
      | AARP | resources/ma-resources-materials.html                      | ShopPlan: Resources MA Plans      | 
      | AARP | resources/ma-resources-materials/ma-information-forms.html | ShopPlan: Resources MA Plans Info | 
      | AARP| medicare-articles.html                                   | AARP |
      | AARP    | resources/medication-therapy-management-program.html     | AARP |
      | AARP| resources/how-to-appoint-a-representative.html           | AARP |
      | AARP   | medicare-education/medicare-medicaid-dual-eligibility.html| AARP |
       | AARP| medicare-education/extra-help-program.html| AARP |
       | AARP     | safe-shopping.html| AARP |
       | AARP     | shop/medicare-advantage-plans/ma-plan-benefits.html| AARP |
       | AARP     | shop/medicare-advantage-veteran-plan.html| AARP |
       | AARP     | resources/prescription-drug-costs-help.html| AARP |
       | AARP| resources/healthcare-fraud.html| AARP |
       | AARP| resources/how-to-pay-your-premium.html| AARP |
       | AARP     | resources/prescription-drug-appeals.html| AARP |
      | AARP | resources/prescription-drug-transition.html| AARP |
       | AARP| resources/disenrollment-information.html| AARP |
       | AARP| resources/ma-pdp-information-forms.html| AARP |
       | AARP| resources/ma-pdp-information-forms/member-rights.html| AARP |
      | AARP | resources/ma-pdp-information-forms/medicare-appeal.html| AARP |
       | AARP| resources/ma-pdp-information-forms/explanation-benefits.html| AARP |
       | AARP| health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | AARP |
       | AARP| health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | AARP |
       | AARP| health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | AARP |
      | AARP | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | AARP |
       | AARP| health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    | AARP |
       | AARP| health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | AARP |
       | AARP| medicare-articles/medicare-made-clear.html| AARP |
       | AARP| medicare-articles/eligibility-and-enrollment.html| AARP |
       | AARP| medicare-articles/medicare-benefits-and-coverage.html| AARP |
       | AARP| medicare-articles/medicare-costs.html| AARP |
       | AARP| about-our-plans.html| AARP |
       | AARP| shop-medicare-coverage.html| AARP |
      | AARP | health-insurance-brokers.html| AARP |
      | AARP|health-plans/medicare-advantage-plans/resources-plan-material.html|AARP|
      | AARP | shop/medicare-advantage-plans/california.html| AARP |
      | AARP| shop/medicare-advantage-plans/florida.html| AARP |
      | AARP| shop/medicare-advantage-plans/massachusetts.html| AARP |
      | AARP| shop/medicare-advantage-plans/northcarolina.html| AARP |
      | AARP| shop/medicare-advantage-plans/arizona.html| AARP |
       | AARP| shop/connect/agentebrc.html| AARP |
       | AARP| medicare-education/how-to-enroll-in-medicare.html| AARP |
       | AARP| medicare-education/changing-plans.html| AARP |
       | AARP| medicare-education/medicare-initial-enrollment-period.html| AARP |
       | AARP| medicare-education/medicare-while-working.html| AARP |
      | AARP | medicare-education/medicare-coverage-examples.html| AARP |
       | AARP| medicare-education/medicare-glossary.html| AARP |
       | AARP| medicare-education/wp65-guide.html| AARP |
       | AARP| medicare-education/iep-guide.html| AARP |
       | AARP| medicare-education/medicare-videos/working-past-65-when-you-may-be-able-to-delay-medicare.html| AARP |
       | AARP| medicare-education/medicare-videos/working-past-65-when-you-have-to-enroll-at-65.html| AARP |
       | AARP| medicare-education/medicare-videos/what-to-know-about-medicare-part-d-when-still-working.html| AARP |
       | AARP| medicare-education/medicare-videos/learn-what-happens-to-your-hsa-with-medicare.html| AARP |
       | AARP| medicare-education/medicare-videos/cobra-and-medicare.html| AARP |
       | AARP| medicare-education/medicare-videos/medicare-enrollment-when-retiring-at-65.html| AARP |
       | AARP| plan-documents.html| AARP |
       | AARP| medicare-articles/medicare-benefits-and-coverage.html| AARP |
       | AARP| medicare-articles/medicare-costs.html| AARP |
      | AARP | medicare-articles.html| AARP |
       | AARP| medicare-articles/medicare-made-clear.html| AARP |
       | AARP| medicare-articles/eligibility-and-enrollment.html| AARP |
       | AARP| medicare-articles/medicare-costs.html| AARP |
       | AARP| medicare-articles/shopping-for-medicare.html| AARP |
       | AARP| medicare-articles/medicare-when-working-past-65.html| AARP |
       | AARP| medicare-articles/medicare-tips-and-faqs.html| AARP |
       | AARP| medicare-articles/how-to-avoid-the-medicare-part-b-late-penalty| AARP |
       | AARP| medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65| AARP |
       | AARP| medicare-articles/9-good-reasons-why-a-medicare-advantage-plan-might-be-right-for-you| AARP |
       | AARP| medicare-articles/caregiver-corner-helping-your-loved-one-prepare-for-the-medicare-annual-enrollment-period| AARP |
       | AARP| medicare-articles/your-5-point-checklist-choosing-medicare-part-d-plan| AARP |
       | AARP| medicare-articles/6-tips-to-protect-yourself-from-medicare-fraud| AARP |
       | AARP| medicare-articles/what-will-medicare-cost-in-2020| AARP |
       | AARP| medicare-articles/what-is-retiree-health-coverage| AARP |
       | AARP| medicare-articles/medicare-plan-annual-notice-of-change-what-to-look-for| AARP |
       | AARP| medicare-articles/need-eyeglasses-or-eye-care-coverage-check-your-medicare-options| AARP |
       | AARP| medicare-articles/medicare-doesnt-cover-everything-what-you-need-know| AARP |
       | AARP| medicare-articles/6-timely-medicare-tips-for-turning-65| AARP |
       | AARP| medicare-articles/should-i-get-part-b-if-im-working-past-65| AARP |
       | AARP| medicare-articles/try-to-avoid-medicare-late-enrollment-premium-penalties| AARP |
       | AARP| medicare-articles/what-is-the-difference-between-original-medicare-and-medicare-advantage| AARP |
       | AARP| medicare-articles/do-i-need-medicare-with-spouses-employer-plan| AARP |
       | AARP| medicare-articles/5-ways-to-pay-your-medicare-part-b-premium| AARP |
       | AARP| medicare-articles/5-medicare-myths-set-straight| AARP |
       | AARP| medicare-articles/when-can-you-start-getting-medicare| AARP |
       | AARP| medicare-articles/is-medicare-mandatory| AARP |
       | AARP| medicare-articles/can-i-change-my-medicare-plan| AARP |
       | AARP| medicare-articles/medicare-coverage-for-non-working-spouses| AARP |
       | AARP| medicare-articles/5-tips-for-enrolling-in-medicare-for-the-first-time| AARP |
       | AARP| medicare-articles/decide-change-plan| AARP |
       | AARP| medicare-articles/medicare-coverage-for-mammograms| AARP |
       | AARP| medicare-articles/have-diabetes-medicare-parts-b-and-d-have-you-covered| AARP |
       | AARP| medicare-articles/how-to-get-ready-for-the-medicare-annual-enrollment-period| AARP |
       | AARP| medicare-articles/what-does-original-medicare-include| AARP |
       | AARP| medicare-articles/what-is-creditable-drug-coverage| AARP |
       | AARP| medicare-articles/safe-medicare-enrollment-during-COVID| AARP |
       | AARP| medicare-articles/what-is-the-medicare-annual-enrollment-period| AARP |
       | AARP| medicare-articles/aep-change-or-renew| AARP |
       | AARP| medicare-articles/can-you-switch-between-original-medicare-and-medicare-advantage-during-the-annual-enrollment-period| AARP |
      | AARP | medicare-articles/2-ways-to-prescription-drug-coverage| AARP |
       | AARP| medicare-articles/good-reasons-to-shop-for-a-new-medicare-plan| AARP |
      | AARP| medicare-articles/the-difference-between-medicare-hmo-and-ppo-plans| AARP |
       | AARP| medicare-articles/medicare-mistakes-that-could-be-costly| AARP |
       | AARP| medicare-articles/5-savvy-shopper-tips-help-get-medicare| AARP |
       | AARP| medicare-articles/which-vaccines-does-medicare-cover| AARP |
       | AARP| medicare-articles/what-if-i-missed-my-initial-enrollment-period| AARP |
       | AARP| medicare-articles/4-basic-questions-to-ask-about-medicare-part-d-coverage| AARP |
      | AARP | medicare-articles/turn-65-retire-sign-up-for-medicare-or-not| AARP |
       | AARP| medicare-articles/7-inside-tips-to-help-you-make-a-smooth-move-to-medicare| AARP |
       | AARP| medicare-articles/medicare-individuals-who-divorced-widowed| AARP |
       | AARP| medicare-articles/medicare-and-durable-medical-equipment-dme| AARP |
       | AARP| medicare-articles/3-simple-ways-to-change-medicare-plans| AARP |
       | AARP| medicare-articles/prescription-discount-cards-other-money-saving-medicare-tips| AARP |
       | AARP| medicare-articles/does-medicare-coverage-change-if-you-return-to-work| AARP |
       | AARP| medicare-articles/medicare-enrollment-for-veterans| AARP |
       | AARP| medicare-articles/retiring-in-2020-what-to-know-about-medicare| AARP |
       | AARP| medicare-articles/like-to-travel-it-may-affect-which-medicare-plan-you-choose| AARP |
       | AARP| medicare-articles/how-do-tricare-and-medicare-work-together| AARP |
       | AARP| medicare-articles/youre-65-working-medicare| AARP |
       | AARP| medicare-articles/how-to-get-dental-and-vision-care-coverage-when-you-have-medicare| AARP |
       | AARP| medicare-articles/pharmacists-answering-your-medicare-prescription-drug-questions| AARP |
      | AARP| medicare-articles/why-you-and-your-spouse-might-need-different-medicare-plans| AARP |
       | AARP| medicare-articles/born-in-1955-or-later-you-may-have-to-work-until-youre-67| AARP |
       | AARP| medicare-articles/renew-medicare-plan-open-enrollment| AARP |
       | AARP| medicare-articles/medicare-enrollment-checklist-helping-you-prepare-for-an-important-decision| AARP |
       | AARP| medicare-articles/should-you-change-your-medicare-plan| AARP |
       | AARP| medicare-articles/what-happens-to-your-medicare-plan-if-you-move| AARP |
       | AARP| medicare-articles/help-i-have-a-disability-and-i-want-to-enroll-in-medicare| AARP |
       | AARP| medicare-articles/what-is-the-medicare-special-enrollment-period| AARP |
       | AARP| medicare-articles/wheres-my-original-medicare-card| AARP |
       | AARP| medicare-articles/the-truth-your-medicare-part-b-premium| AARP |
       | AARP| medicare-articles/dos-and-donts-cancelling-a-marketplace-health-plan| AARP |
       | AARP| medicare-articles/outpatient-mental-health-care-services| AARP |
       | AARP| medicare-articles/medicare-increases-coverage-mental-health-care| AARP |
       | AARP| medicare-articles/how-to-transition-from-the-health-marketplace-to-medicare| AARP |
       | AARP| medicare-articles/what-should-i-look-for-in-a-medicare-prescription-drug-plan| AARP |
       | AARP| medicare-articles/saving-on-medicare-when-self-employed| AARP |
       | AARP| medicare-articles/concrete-answers-10-common-medicare-questions| AARP |
       | AARP| medicare-articles/is-your-medicare-plan-the-best-one-for-you-this-checklist-can-help-you-decide| AARP |
       | AARP| medicare-articles/what-telehealth-services-does-medicare-offer| AARP |
       | AARP| medicare-articles/7-popular-medicare-questions-asked-during-national-medicare-education-week| AARP |
       | AARP| medicare-articles/whats-the-difference-between-a-skilled-nursing-facility-and-a-nursing-home| AARP |
       | AARP| medicare-articles/what-s-the-difference-between-medicare-and-medicaid| AARP |
       | AARP| medicare-articles/how-to-appeal-a-medicare-decision| AARP |
       | AARP| medicare-articles/how-avoid-paying-more-prescription-drug-coverage| AARP |
       | AARP| medicare-articles/3-ways-to-dispose-of-your-old-unused-medications-safely| AARP |
       | AARP| medicare-articles/what-is-a-tiered-formulary-and-what-does-it-mean-for-me| AARP |
       | AARP| medicare-articles/good-news-medicare-part-b-covers-cataract-surgery| AARP |
       | AARP| medicare-articles/heart-healthy-help-medicare| AARP |
       | AARP| medicare-articles/what-can-i-do-during-the-medicare-advantage-open-enrollment-period| AARP |
       | AARP| medicare-articles/medicare-coverage-for-same-sex-couples| AARP |
       | AARP| medicare-articles/how-to-evaluate-medicare-plan-costs| AARP |
       | AARP| medicare-articles/6-point-checklist-to-rate-your-new-medicare-advantage-plan| AARP |
       | AARP| medicare-articles/replacing-your-medicare-card-just-got-a-whole-lot-easier| AARP |
       | AARP| medicare-articles/understanding-your-medicare-plan| AARP |
       | AARP| medicare-articles/how-to-save-on-prescription-drugs-with-medicare| AARP |
       | AARP| medicare-articles/10-tips-choosing-primary-care-doctor| AARP |
 		| AARP| medicare-articles/avoid-sticker-shock-medicare-billing| AARP |
       | AARP| medicare-articles/does-medicare-part-a-cost-anything| AARP |
      | AARP | medicare-articles/how-much-does-medicare-part-b-cost| AARP |
       | AARP| medicare-articles/what-is-co-insurance| AARP |
       | AARP| medicare-articles/what-is-the-medicare-advantage-open-enrollment-period| AARP |
       | AARP| medicare-articles/whats-the-difference-between-a-physical-exam-and-a-medicare-wellness-visit| AARP |
       | AARP| medicare-articles/what-medicare-medical-savings-account-plan| AARP |
       | AARP| medicare-articles/copd-medicare| AARP |
       | AARP| medicare-articles/decoding-medicare| AARP |
       | AARP| medicare-articles/does-medicare-cover-a-colonoscopy| AARP |
       | AARP| medicare-articles/does-medicare-cover-blood-tests-for-cholesterol| AARP |
       | AARP| medicare-articles/does-medicare-cover-diabetes-prevention-program| AARP |
       | AARP| medicare-articles/does-medicare-cover-emergency-room-visits| AARP |
       | AARP| medicare-articles/does-medicare-cover-home-blood-pressure-monitors| AARP |
       | AARP| medicare-articles/does-medicare-cover-melanoma-screenings| AARP |
       | AARP| medicare-articles/home-health-care-those-medicare-who-cant-leave-home| AARP |
       | AARP| medicare-articles/how-often-should-a-woman-over-65-have-a-pap-smear| AARP |
       | AARP| medicare-articles/medicare-transportation-services| AARP |
       | AARP| medicare-articles/are-you-living-with-chronic-heart-failure| AARP |
 		| AARP| medicare-articles/how-prepare-your-medicare-wellness-visit| AARP |
       | AARP| medicare-articles/will-medicare-cover-a-cpap-machine| AARP |
       | AARP| medicare-articles/new-to-medicare-schedule-your-welcome-to-medicare-visit| AARP |
       | AARP| medicare-articles/how-to-become-a-medicare-authorized-representative| AARP |
       | AARP| medicare-articles/what-is-a-transition-refill| AARP |
      | AARP| medicare-articles/got-coverage-for-the-new-year| AARP |
       | AARP| medicare-articles/medicare-and-your-private-medical-information| AARP |
       | AARP| medicare-articles/medicare-memo-what-are-advance-directives| AARP |
       | AARP| medicare-articles/getting-a-knee-replaced-with-Medicare| AARP |
       | AARP| medicare-articles/2-ways-save-on-blood-sugar-test-strips| AARP |
       | AARP| medicare-articles/are-glaucoma-screenings-covered-by-medicare| AARP |
       | AARP| medicare-articles/colon-cancer-screening-tests-without-the-ouch| AARP |
       | AARP| medicare-articles/medicare-beneficiaries-needing-hospice-care-may-be-covered| AARP |
       | AARP| medicare-articles/medicare-coverage-for-inpatient-rehabilitation| AARP |
       | AARP| medicare-articles/medicare-coverage-for-outpatient-rehabilitation-therapy| AARP |
       | AARP| medicare-articles/medicare-coverage-for-prostate-cancer-screening| AARP |
       | AARP| medicare-articles/medicare-part-benefit-periods-deductibles| AARP |
       | AARP| medicare-articles/reasons-you-should-schedule-an-annual-medicare-wellness-visit| AARP |
       | AARP| medicare-articles/does-medicare-cover-allergy-testing| AARP |
       | AARP| medicare-articles/medicare-part-b-may-not-cover-hearing-aid-part-c-might| AARP |
       | AARP| medicare-articles/medicare-part-b-basics| AARP |
       | AARP| medicare-articles/medicare-part-d-basics| AARP |
       | AARP| medicare-articles/medicare-part-a-the-basics| AARP |
       | AARP| medicare-articles/medicare-part-c-basics| AARP |
      | AARP | medicare-articles/does-medicare-cover-a-chiropractor| AARP |
       | AARP| medicare-articles/what-does-medicare-cover-after-a-stroke| AARP |
      | AARP | medicare-articles/dual-special-needs-plans| AARP |
       | AARP| medicare-articles/cual-es-la-diferencia-entre-medicare-y-medicaid| AARP |
       | AARP| medicare-articles/cuatro-programas-de-asistencia-para-pagar-sus-costos-de-medicare| AARP |
       | AARP| medicare-articles/guia-paso-paso-para-inscribirse-en-medicare-los-65-anos| AARP |
       | AARP| medicare-articles/medicare-parte-c-conceptos-basicos| AARP |
       | AARP| medicare-articles/parte-a-de-medicare-conceptos-basicos| AARP |
       | AARP| medicare-articles/parte-b-de-medicare-conceptos-basicos| AARP |
       | AARP| medicare-articles/parte-d-de-medicare-conceptos-basicos| AARP |
      | AARP | medicare-articles/what-is-a-pdp-prescription-drug-plan| AARP |
       | AARP| medicare-articles/4-assistance-programs-could-help-pay-your-medicare-costs| AARP |
      | AARP | medicare-articles/4-types-of-medicare-savings-programs-and-what-they-cover| AARP |
      | AARP | medicare-articles/what-is-the-medicare-part-d-coverage-gap| AARP |
       | AARP| medicare-articles/4surefire-tips-for-picking-a-medicare-plan-that-fits-your-health-needs-and-budget| AARP |
       | AARP| medicare-articles/medicare-part-d-costs-you-may-not-know-about| AARP |
       | AARP| medicare-articles/new-medicare-follow-checklist-successful-start| AARP |
      | AARP | medicare-articles/medicare-coverage-for-cancer-screenings-chemo-and-radiation| AARP |
       | AARP| medicare-articles/how-to-compare-medicare-advantage-plan-costs| AARP |
      | AARP | medicare-education/getting-started.html| AARP |
       | AARP| medicare-education/keep-or-change-coverage.html| AARP |
       | AARP| resources/ma-pdp-information-forms.html| AARP |
       | AARP| ?WT.mc_id=8027650&mrcid=em:Acq:MR%7CWelcome%7CEGEM3543%7C::8027650 | AARP |
       | AARP| ?WT.mc_id=8027651&mrcid=em:Acq:MR%7CWelcome%7CEGEM3543%7C::8027651 | AARP |
       | AARP| ?WT.mc_id=8027652&mrcid=em:Acq:MR%7CWelcome%7CEGEM3543%7C::8027652 | AARP |
       | AARP| ?WT.mc_id=8027677&mrcid=em:Acq:MR%7CAEP2%7CEGEM3545%7C::8027677    | AARP |
       | AARP| ?WT.mc_id=8027678&mrcid=em:Acq:MR%7CAEP2%7CEGEM3545%7C::8027678    | AARP |
       | AARP| ?WT.mc_id=8027679&mrcid=em:Acq:MR%7CAEP2%7CEGEM3545%7C::8027679    |AARP|
       | AARP| ?WT.mc_id=8027682&mrcid=em:Acq:MR%7CAEP2%7CEGEM3545%7C::8027682    |AARP|
 		| AARP| ?WT.mc_id=8027588&mrcid=em:Acq:MR%7CAEP1%7CEGEM3544%7C::8027588      |AARP|
      | AARP | ?WT.mc_id=8027590&mrcid=em:Acq:MR%7CAEP1%7CEGEM3544%7C::8027590      |AARP|
       | AARP| ?WT.mc_id=8027591&mrcid=em:Acq:MR%7CAEP1%7CEGEM3544%7C::8027591      |AARP|
       | AARP| ?WT.mc_id=8027592&mrcid=em:Acq:MR%7CAEP1%7CEGEM3544%7C::8027592      |AARP|
       | AARP| ?WT.mc_id=8027589&mrcid=em:Acq:MR%7CAEP1%7CEGEM3544%7C::8027589      |AARP|
       | AARP| ?WT.mc_id=8027593&mrcid=em:Acq:MR%7CAEP1%7CEGEM3544%7C::8027593      |AARP|
       | AARP| /?WT.mc_id=8027581&mrcid=em:Acq:MR%7CPrewarm3%7CEGEM3542%7C::8027581 |AARP|
       | AARP| /?WT.mc_id=8027582&mrcid=em:Acq:MR%7CPrewarm3%7CEGEM3542%7C::8027582 |AARP|
       | AARP| /?WT.mc_id=8027583&mrcid=em:Acq:MR%7CPrewarm3%7CEGEM3542%7C::8027583 |AARP|
      | AARP | /?WT.mc_id=8027586&mrcid=em:Acq:MR%7CPrewarm3%7CEGEM3542%7C::8027586 |AARP|
       | AARP| /?WT.mc_id=8027492&mrcid=em:Acq:MR%7CPrewarm1%7CEGEM3540%7C::8027492 |AARP|
       | AARP| /?WT.mc_id=8027494&mrcid=em:Acq:MR%7CPrewarm1%7CEGEM3540%7C::8027494 |AARP|
       | AARP| /?WT.mc_id=8027495&mrcid=em:Acq:MR%7CPrewarm1%7CEGEM3540%7C::8027495 |AARP|
       | AARP| /?WT.mc_id=8027496&mrcid=em:Acq:MR%7CPrewarm1%7CEGEM3540%7C::8027496 |AARP|
       | AARP| /?WT.mc_id=8027571&mrcid=em:Acq:MR%7CPrewarm2%7CEGEM3541%7C::8027571 |AARP|
       | AARP| /?WT.mc_id=8027572&mrcid=em:Acq:MR%7CPrewarm2%7CEGEM3541%7C::8027572 |AARP|
       | AARP| /?WT.mc_id=8027573&mrcid=em:Acq:MR%7CPrewarm2%7CEGEM3541%7C::8027573 |AARP|                                                                                               
      | AARP | sitemap.html                  | Footer: Site Map           | 
      | AARP | terms-of-use.html             | Footer: Terms of Use       | 
      | AARP | disclaimer.html               | Footer: Disclaimers        | 
      | AARP | health-insurance-brokers.html | Footer: Agents and Brokers | 
      | AARP | contact-us.html               | Footer: Contact Us         | 
      | AARP | privacy-policy.html           | Footer: Privacy Policy     | 
	 	 | AARP | about-us.html                 | Footer: About Us           | 

	  
    @prodRegression @regressionAARP
    Examples: 
      | site | path                                                      | pageName                |
      | AARP | health-plans/estimate-drug-costs.html/drug-cost-estimator | Drug Cost Estimator     | 
      | AARP | health-plans/aarp-pharmacy.html/Pharmacy-Search-English   | Pharmacy Search         | 
      | AARP | medicare-plans.html                                       | ShopPlan: Plan Selector | 
      | AARP | profile/guest                                             | Visitor Profile: Guest  |


  @GlobalComponentsAARP_ISonlyPages
  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    When user accesses global header of the Medicare Plans home page
    When user accesses global footer of the Medicare Plans All page
    Then the User validates Shop for a Plan Navigation link
    Then the user validates Medicare Education Navigation link
    Then the user validate ZipCode Components on the page using ZipCode "90210"
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible

    @MedSuppOnlyPages_GlobalCompsAARP
    Examples: 
      | site | path                                                                      | pageName       | tfnXpath       | tfnFlag |
      | AARP | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | Decision Guide | //*[@id='tfn'] | true    |

    #| AARP | health-plans/medicare-supplement-plans/agent-appointment.html             | Agent Appointment | //*[@id='tfn'] | true    |
    @MedSuppOnlyPages_GlobalCompsUHC @uhcmedicare
    Examples: 
      | site | path                                                                      | pageName       | tfnXpath       | tfnFlag |
      | UHC  | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | Decision Guide | //*[@id='tfn'] | true    |

  #| UHC  | health-plans/medicare-supplement-plans/agent-appointment.html             | Agent Appointment | //*[@id='tfn'] | true    |
 

  Scenario Outline: To verify the Geo Targeting Link for Medicare Supplement Plans on the <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When user updates the state drop down value on the home page
      | State | <state> |
      | Code  | <code>  |
    Then the user clicks on medicare supplement plans from shop for a plan
    Then user validates the url for Medicare Supplement Insurance Plans
      | State      | <state>      |
      | Code       | <code>       |
      | ClassicUrl | <classicurl> |
      | GenericUrl | <url>        |
    Then the user clicks on browser back button
    When user updates the state drop down value on the home page
      | State | <state1> |
      | Code  | <code1>  |
    Then the user clicks on medicare supplement plans from shop for a plan
    Then user validates the url for Medicare Supplement Insurance Plans
      | State      | <state1>     |
      | Code       | <code1>      |
      | ClassicUrl | <classicurl> |
      | GenericUrl | <url>        |
    Then the user clicks on browser back button
    When user updates the state drop down value on the home page
      | State | <state2> |
      | Code  | <code2>  |
    Then the user clicks on medicare supplement plans from shop for a plan
    Then user validates the url for Medicare Supplement Insurance Plans
      | State      | <state2>     |
      | Code       | <code2>      |
      | ClassicUrl | <classicurl> |
      | GenericUrl | <url>        |

    @GeoTarget_MedSup_GlobalCompsAARP @regressionAARP
    Examples: 
      | site | state               | code | state1 | code1 | state2 | code2 | classicurl                                   | url                                  |
      | AARP | U.S. Virgin Islands | VI   | Oregon | OR    | Alaska | AK    | /shop/medicare-supplement-plans-classic.html | /shop/medicare-supplement-plans.html |

    @GeoTarget_MedSup_GlobalCompsUHC @regressionUHC @featureGate @uhcmedicare
    Examples: 
      | site | state               | code | state1 | code1 | state2 | code2 | classicurl                                   | url                                  |
      | UHC  | U.S. Virgin Islands | VI   | Oregon | OR    | Alaska | AK    | /shop/medicare-supplement-plans-classic.html | /shop/medicare-supplement-plans.html |

  Scenario Outline: To verify the links under Learn About Medicare from the navigation bar on the <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user hovers over the learn about medicare
    When user click on "Introduction" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Eligibility" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Coverage Options" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Prescriptions, Providers & Benefits" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Medicare Cost Basics" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Medicare Advantage Plans" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Medicare Supplement Insurance" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Medicare Prescription Drug Plans" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "When to Enroll" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "How to Enroll" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Changing Plans" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Working Past 65" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Overview of Plans" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Special Needs Plans" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Medicare FAQ" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Glossary" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Articles and Special Topics" link under learn about medicare
    Then user should be navigated to respective medicare education page
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user enter email and submit in email section
    Then the message "Thank You!Your guide will arrive in your inbox shortly." should be displayed in email section

#    @learnAboutMedicareNav_AARP  @GCdebug
    Examples: 
      | site |
      | AARP |

#    @learnAboutMedicareNav_UHC  @featureGate @uhcmedicare
    Examples: 
      | site |
      | UHC  |

  @footerLinks
  Scenario Outline: To verify the links under Shop Plans, Tools & Resources, Learn About Medicare and More  on Home page on the <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When user click on "Medicare Advantage Plans" link under shop plans
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user click on "Dual Special Needs Plans" link under shop plans
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user click on "Medicare Supplement Insurance Plans" link under shop plans
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user click on "Medicare Prescription Drug Plans" link under shop plans
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user click on "Plan Recommendation" link under Tools & Resources
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user click on "Estimate Drug Cost" link under Tools & Resources
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user click on "Search for a Pharmacy" link under Tools & Resources
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user click on "Search Doctors" link under Tools & Resources
    Then user should be navigated to respective footer links page
    When user click on "Search Dentists" link under Tools & Resources
    Then user should be navigated to respective footer links page
    When user click on "Introduction to Medicare" link under Learn About Medicare
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user click on "Eligibility" link under Learn About Medicare
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user click on "Coverage Choices" link under Learn About Medicare
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user click on "Medicare FAQ" link under Learn About Medicare
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user click on "About" link under more
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user click on "Contact" link under more
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user click on "Language Assistance" link under more
    #Then user should be navigated to respective footer links page
    When user click on "AARP.org" link under more
    #Then user should be navigated to respective footer links page
    When user updates the state drop down value on the home page
      | State | <state> |
    And user clicks on View all disclaimer information link on the home page

    @footerLinksAARP @vbfGate
    Examples: 
      | site | state  |
      | AARP | Alaska |

    @footerLinksUHC @uhcmedicare
    Examples: 
      | site | state  |
      | UHC  | Alaska |

  @medsupHeaderAARPMembership
  Scenario Outline: To verify Medsup AARP membership header links for the page mentioned on site - <site> -  <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    When user verifies the logo
    Then user validates TFN in header
    And user validates AARP membership links in medsup header "Join AARP,Renew AARP Membership,AARP Member Benefits"
    And user clicks on AARP Membership links in the Medsup header for cancel "Join AARP,Renew AARP Membership,AARP Member Benefits"
    And the user clicks on browser back button
    Then Verify AARP Membership links in header not present on home page

    @Header_Medsup_AARP_Membership @regressionAARP
    Examples: 
      | site | path                                                              | pageName                                   |
    | AARP | shop/medicare-supplement-plans.html                               | MedsupShop:Medsup Shop Page                |
     | AARP | enroll/ms-apply.html                                              | MedsupEnroll:Medsup Enroll Page            |
      | AARP | medicare-education-classic/medicare-supplement-plans-classic.html | MedsupClassic:Medsup Classic Page          |
      | AARP | medicare-education/medicare-supplement-plans.html                 | Medsupeducation:Medsup Education Page      |
      | AARP | shop/compare/compare-ms.html                                      | MedsupShopCompare:Medsup Shop Compare Page |
      | AARP | shop/estimate/ms-costs.html                                       | MedsupShopCost:Medsup Shop Cost Page       |

    @Header_Medsup_UHC_Membership @uhcmedicare @regressionUHC
    Examples: 
      | site | path                                                              | pageName                                   |
     | UHC  | shop/medicare-supplement-plans.html                               | MedsupShop:Medsup Shop Page                |
      | UHC  | enroll/ms-apply.html                                              | MedsupEnroll:Medsup Enroll Page            |
      | UHC  | medicare-education-classic/medicare-supplement-plans-classic.html | MedsupClassic:Medsup Classic Page          |
      | UHC  | medicare-education/medicare-supplement-plans.html                 | Medsupeducation:Medsup Education Page      |
      | UHC  | shop/compare/compare-ms.html                                      | MedsupShopCompare:Medsup Shop Compare Page |
      | UHC  | shop/estimate/ms-costs.html                                       | MedsupShopCost:Medsup Shop Cost Page       |

  @F722580
  Scenario Outline: To verify the affiliate link on header for Geo Targeting state <Texas>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When user updates the state drop down value on the home page
      | State | <state1> |
      | Code  | <code1>  |
    Then user validate affiliate link on header for geo target state
    Then user updates the state drop down value on the home page
      | State | <state> |
      | Code  | <code>  |
    Then user validate affiliate for non-geo target states
    Then the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And user validate affiliate link on header for geo target state
    Then user clicks on Change Zip code link
    Then user clicks on Select by Address and Enter fileds
      | Address | <address> |
      | City    | <city>    |
      | State   | <state1>  |
    When the user clicks on Find plans on vpp using following information
      | County Name2     | <county2>        |
      | Is Multi County2 | <isMultiCounty2> |
    Then user validate affiliate for non-geo target states

    @GeoTarget_Affiliate
    Examples: 
      | site | state               | code | state1 | code1 | zipcode | isMultutiCounty | county           | address              | city      | state1      | isMultiCounty2 | county2          |
      | AARP | U.S. Virgin Islands | VI   | Texas  | TX    |   77083 | yes             | Fort Bend County | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | NO             | Fairfield County |

    @GeoTarget_Affiliate @uhcmedicare
    Examples: 
      | site | state               | code | state1 | code1 | zipcode | isMultutiCounty | county           | address              | city      | state1      | isMultiCounty2 | county2          |
      | UHC  | U.S. Virgin Islands | VI   | Texas  | TX    |   77083 | yes             | Fort Bend County | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | NO             | Fairfield County |

  @F722580
  Scenario Outline: To verify the affiliate link on header for Geo Targeting state <Texas> - <site> -  <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When user updates the state drop down value on the home page
      | State | <state1> |
      | Code  | <code1>  |
    Then the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then user validate affiliate link on header for geo target state
    And the user clicks on browser back button
    Then user click on "Medicare Advantage Plans" link under shop plans
    Then user validate affiliate link on header for geo target state
    Then the user clicks on browser back button
    When user click on "Dual Special Needs Plans" link under shop plans
    Then user validate affiliate link on header for geo target state
    Then the user clicks on browser back button
    When user click on "Medicare Supplement Insurance Plans" link under shop plans
    Then user validate affiliate link on header for geo target state
    Then the user clicks on browser back button
    When user click on "Search Doctors" link under Tools & Resources
    When user click on "Medicare FAQ" link under Learn About Medicare
    Then user validate affiliate link on header for geo target state
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "When to Enroll" link under learn about medicare
    Then user validate affiliate link on header for geo target state
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "How to Enroll" link under learn about medicare
    Then user validate affiliate link on header for geo target state
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Changing Plans" link under learn about medicare
    Then user validate affiliate link on header for geo target state
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Working Past 65" link under learn about medicare
    Then user validate affiliate link on header for geo target state
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Overview of Plans" link under learn about medicare
    Then user validate affiliate link on header for geo target state
    Then the user clicks on browser back button
    Then the user hovers over the learn about medicare
    When user click on "Special Needs Plans" link under learn about medicare
    Then user validate affiliate link on header for geo target state
    Then the user clicks on browser back button
    Then user validate affiliate link on header for geo target state

    @GeoTarget_Affiliate @regressionAARP
    Examples: 
      | site | path                                                      | state1 | code1 | zipcode | isMultutiCounty | county           | address              | city      | state1      | isMultiCounty2 | county2          |
      | AARP | profile                                                   | Texas  | TX    |   77083 | yes             | Fort Bend County | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | NO             | Fairfield County |
      | AARP | shop/switch.html                                          | Texas  | TX    |   77083 | yes             | Fort Bend County | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | NO             | Fairfield County |
      | AARP | health-plans/estimate-drug-costs.html/drug-cost-estimator | Texas  | TX    |   77083 | yes             | Fort Bend County | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | NO             | Fairfield County |
      | AARP | plan-recommendation-engine.html                           | Texas  | TX    |   77083 | yes             | Fort Bend County | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | NO             | Fairfield County |
      | AARP  | health-plans/aarp-pharmacy.html/Pharmacy-Search-English   | Texas  | TX    |   77083 | yes             | Fort Bend County | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | NO             | Fairfield County |

    @GeoTarget_Affiliate @uhcmedicare @regressionUHC
    Examples: 
      | site | path                                                      | state1 | code1 | zipcode | isMultutiCounty | county           | address              | city      | state1      | isMultiCounty2 | county2          |
      | UHC  | profile                                                   | Texas  | TX    |   77083 | yes             | Fort Bend County | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | NO             | Fairfield County |
      | UHC  | shop/switch.html                                          | Texas  | TX    |   77083 | yes             | Fort Bend County | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | NO             | Fairfield County |
      | UHC  | health-plans/estimate-drug-costs.html/drug-cost-estimator | Texas  | TX    |   77083 | yes             | Fort Bend County | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | NO             | Fairfield County |
      | UHC  | plan-recommendation-engine.html                           | Texas  | TX    |   77083 | yes             | Fort Bend County | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | NO             | Fairfield County |
      | UHC  | health-plans/aarp-pharmacy.html/Pharmacy-Search-English   | Texas  | TX    |   77083 | yes             | Fort Bend County | 584 MAIN AVE NORWALK | FAIRFIELD | CONNECTICUT | NO             | Fairfield County |
