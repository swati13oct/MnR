@UATRegression @F513647 @globalComponent @headerfooter @GlobalHeaderFooter
Feature: 1.12 UAT - Header and Footer flows

   @UATRegression
  Scenario Outline: <Scenario> : To verify links displayed in the global header and footer on home page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When user accesses global footer of the Medicare Plans All page
    And user clicks on View all disclaimer information link on the home page
    And user clicks on Aboutus link from footer of the Medicare Plans home page
    And the user clicks on browser back button
    And user clicks on contactus link on aboutus page
    And the user clicks on browser back button
    And user clicks on sitemap link on contactus page
    And the user clicks on browser back button
    And user clicks on privacypolicy link on sitemap page
    And the user clicks on browser back button
    And user clicks on termsOfuse link on privacypolicy page
    And the user clicks on browser back button
    And user clicks on disclaimers link on terms&conditions page
    And the user clicks on browser back button
    And user clicks on agents&brokers link on disclaimers page
    And the user clicks on browser back button
    #And user verifies home link of agents&brokers page
    And user clicks on agents&brokers link on disclaimers page
    And the user clicks on browser back button
    And user select state for geotargeting from global footer on homepage
    And the user clicks on View all disclaimer information link in footer
    And the user validate links in disclaimer information section
    And the user clicks on Complaint Form link in footer
    And the user clicks on Hide all disclaimer information link in footer
    #And the user validates Language assistance links
    When user accesses global header of the Medicare Plans home page
    And user verifies the logo
    And user hover over for plan member to click to go to member site
    Then user validates visitor profile
    And the user clicks on browser back button
    #And user clicks on visit aarp.org link in the header
    And the user clicks on browser back button
    And the user clicks on Accessibility Link
    #And the user clicks on browser back button
    And the user clicks on Medicare Advantage Plans Link
    And the user clicks on browser back button
    And the user clicks on Dual Special Needs Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Supplement Insurance Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Prescription Drug Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Education Link
    And the user clicks on browser back button
    #And the user clicks on Back to top Link
    And user clicks on visit aarp.org link in the footer

    @globalfooter_AARP @regressionAARP @featureGate
    Examples: 
      | Scenario           | site |
      | E2E Scenario_1 AMP | AARP |

    @globalfooter_UHC @regressionUHC @sanity @uhcmedicare
    Examples: 
      | Scenario           | site |
      | E2E Scenario_1 UMS | UHC  |

   @UATRegression
  Scenario Outline: <Scenario> : To verify links displayed in the global header and footer on VPP page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    When user accesses global footer of the Medicare Plans All page
    And user clicks on Aboutus link from footer of the Medicare Plans home page
    And the user clicks on browser back button
    And user clicks on contactus link on aboutus page
    And the user clicks on browser back button
    And user clicks on sitemap link on contactus page
    And the user clicks on browser back button
    And user clicks on privacypolicy link on sitemap page
    And the user clicks on browser back button
    And user clicks on termsOfuse link on privacypolicy page
    And the user clicks on browser back button
    And user clicks on disclaimers link on terms&conditions page
    And the user clicks on browser back button
    And user clicks on agents&brokers link on disclaimers page
    And the user clicks on browser back button
    #And user verifies home link of agents&brokers page
    #And the user clicks on browser back button
    And the user clicks on Accessibility Link
    #And the user clicks on browser back button
    And the user clicks on Medicare Advantage Plans Link
    And the user clicks on browser back button
    And the user clicks on Dual Special Needs Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Supplement Insurance Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Prescription Drug Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Education Link
    And the user clicks on browser back button
    #And the user clicks on Back to top Link
    When user accesses global header of the Medicare Plans home page
    And user verifies the logo
    #And user clicks on Sign in link
    #And the user clicks on browser back button
    #And user clicks on register link
    #And the user clicks on browser back button
    And user hover over for plan member to click to go to member site
    Then user validates visitor profile
    And the user clicks on browser back button
    #And user clicks on visit aarp.org link in the header
    #And the user clicks on browser back button
    And user clicks on visit aarp.org link in the footer

    @globalfooter_AARP @regressionAARP
    Examples: 
      | Scenario           | site | zipcode | isMultutiCounty | county    |
      | E2E Scenario_3 AMP | AARP |   80001 | No              | Jefferson |

    @globalfooter_UHC @regressionUHC @featureGate @uhcmedicare
    Examples: 
      | Scenario           | site | zipcode | isMultutiCounty | county    |
      | E2E Scenario_3 UMS | UHC  |   80001 | No              | Jefferson |

   @UATRegression
  Scenario Outline: <Scenario> : To verify links displayed in the global header and footer on DCE page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I click on DCE Redesign link from Shop for a plan hover over
    When user accesses global footer of the Medicare Plans All page
    And user clicks on Aboutus link from footer of the Medicare Plans home page
    And the user clicks on browser back button
    And user clicks on contactus link on aboutus page
    And the user clicks on browser back button
    And user clicks on sitemap link on contactus page
    And the user clicks on browser back button
    And user clicks on privacypolicy link on sitemap page
    And the user clicks on browser back button
    And user clicks on termsOfuse link on privacypolicy page
    And the user clicks on browser back button
    And user clicks on disclaimers link on terms&conditions page
    And the user clicks on browser back button
    And user clicks on agents&brokers link on disclaimers page
    And the user clicks on browser back button
    #And user verifies home link of agents&brokers page
    #And the user clicks on browser back button
    And the user clicks on Accessibility Link
    #And the user clicks on browser back button
    And the user clicks on Medicare Advantage Plans Link
    And the user clicks on browser back button
    And the user clicks on Dual Special Needs Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Supplement Insurance Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Prescription Drug Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Education Link
    And the user clicks on browser back button
    #And the user clicks on Back to top Link
    When user accesses global header of the Medicare Plans home page
    And user verifies the logo
    And user hover over for plan member to click to go to member site
    #And user clicks on Sign in link
    #And the user clicks on browser back button
    #And user clicks on register link
    #And the user clicks on browser back button
    Then user validates visitor profile
    And the user clicks on browser back button
    #And user clicks on visit aarp.org link in the header
    #And the user clicks on browser back button
    And user clicks on visit aarp.org link in the footer

    @globalfooter_AARP @regressionAARP 
    Examples: 
      | Scenario           | site |
      | E2E Scenario_4 AMP | AARP |

    @globalfooter_UHC @regressionUHC @featureGate @uhcmedicare
    Examples: 
      | Scenario           | site |
      | E2E Scenario_4 UMS | UHC  |

   @UATRegression
  Scenario Outline: <Scenario> : To verify links displayed in the global header and footer on Pharmacy page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigate to pharmacy search page from the navigation bar
    When user accesses global footer of the Medicare Plans All page
    And user clicks on Aboutus link from footer of the Medicare Plans home page
    And the user clicks on browser back button
    And user clicks on contactus link on aboutus page
    And the user clicks on browser back button
    And user clicks on sitemap link on contactus page
    And the user clicks on browser back button
    And user clicks on privacypolicy link on sitemap page
    And the user clicks on browser back button
    And user clicks on termsOfuse link on privacypolicy page
    And the user clicks on browser back button
    And user clicks on disclaimers link on terms&conditions page
    And the user clicks on browser back button
    And user clicks on agents&brokers link on disclaimers page
    And the user clicks on browser back button
    #And user verifies home link of agents&brokers page
    #And the user clicks on browser back button
    And the user clicks on Accessibility Link
    #And the user clicks on browser back button
    And the user clicks on Medicare Advantage Plans Link
    And the user clicks on browser back button
    And the user clicks on Dual Special Needs Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Supplement Insurance Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Prescription Drug Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Education Link
    And the user clicks on browser back button
    #And the user clicks on Back to top Link
    When user accesses global header of the Medicare Plans home page
    And user verifies the logo
    And user hover over for plan member to click to go to member site
    #And user clicks on Sign in link
    #And the user clicks on browser back button
    #And user clicks on register link
    #And the user clicks on browser back button
    Then user validates visitor profile
    And the user clicks on browser back button
    #And user clicks on visit aarp.org link in the header
    #And the user clicks on browser back button
    And user clicks on visit aarp.org link in the footer

    @globalfooter_AARP @regressionAARP @featureGate
    Examples: 
      | Scenario           | site |
      | E2E Scenario_5 AMP | AARP |

    @globalfooter_UHC @regressionUHC @uhcmedicare
    Examples: 
      | Scenario           | site |
      | E2E Scenario_5 UMS | UHC  |

 @UATRegression
  Scenario Outline: <Scenario> : To verify links displayed in the global header and footer on static pages : <pagename> page on site <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following medicare acquisition site page
      | PageName | <pagename> |
      | PagePath | <path>     |
    When user accesses global footer of the Medicare Plans All page
    And user clicks on Aboutus link from footer of the Medicare Plans home page
    And the user clicks on browser back button
    And user clicks on contactus link on aboutus page
    And the user clicks on browser back button
    And user clicks on sitemap link on contactus page
    And the user clicks on browser back button
    And user clicks on privacypolicy link on sitemap page
    And the user clicks on browser back button
    And user clicks on termsOfuse link on privacypolicy page
    And the user clicks on browser back button
    And user clicks on disclaimers link on terms&conditions page
    And the user clicks on browser back button
    And user clicks on agents&brokers link on disclaimers page
    And the user clicks on browser back button
    And the user clicks on Accessibility Link
    And the user clicks on Medicare Advantage Plans Link
    And the user clicks on browser back button
    And the user clicks on Dual Special Needs Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Supplement Insurance Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Prescription Drug Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Education Link
    And the user clicks on browser back button
    When user click on "Plan Recommendation" link under Tools & Resources
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user click on "Estimate Drug Costs" link under Tools & Resources
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user click on "Search for a Pharmacy" link under Tools & Resources
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user click on "Search Doctors" link under Tools & Resources
    Then user should be navigated to respective footer links page
    When user click on "Search Dentists" link under Tools & Resources
    Then user should be navigated to respective footer links page
    #Then the user clicks on browser back button
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
    When user click on "Language Assistance" link under more
    Then user should be navigated to respective footer links page
    When user click on "AARP.org" link under more
    Then user should be navigated to respective footer links page
    Then the user clicks on browser back button
    When user accesses global header of the Medicare Plans home page
    And user verifies the logo
    And user hover over for plan member to click to go to member site
    Then user validates visitor profile
    And the user clicks on browser back button

    @globalheader_AARP @regressionAARP @featureGate
    Examples: 
      | Scenario           | site | path                                                      | pagename                                                    |
      | E2E Scenario_2 AMP | AARP | health-plans.html#/zipcode                                | Shop for a Plan                                             |
      | E2E Scenario_2 AMP | AARP | shop.html                                                 | Shop Hub                                                    |
      | E2E Scenario_2 AMP | AARP | shop/medicare-advantage-plans.html                        | Shop Medicare Advantage Plans                               |
      | E2E Scenario_2 AMP | AARP | shop/medicare-advantage-plans/wellness-discounts.html     | Wellness Resources and Services                             |
      | E2E Scenario_2 AMP | AARP | shop/medicare-advantage-plans/health-care-management.html | Clinical Programs: Condition Management and Care Management |
      | E2E Scenario_2 AMP | AARP | shop/medicare-advantage-plans/ma-plan-benefits.html       | Medicare Advantage Plan Benefits                            |
      | E2E Scenario_2 AMP | AARP | shop/prescription-drug-plans.html | Shop Medicare Prescription Drug Plans                |
      | E2E Scenario_2 AMP | AARP | shop/compare.html                 | Shop: Compare Plans                                  |
      | E2E Scenario_2 AMP | AARP | shop/estimate.html                  | Shop: Estimate Costs                                   |
      | E2E Scenario_2 AMP | AARP | shop/switch.html                    | Shop: Switching Plans                                  |
      | E2E Scenario_2 AMP | AARP | shop/medicare-supplement-plans.html | Shop Medicare Supplement Insurance Plans               |
      | E2E Scenario_2 AMP | AARP | enroll.html                         | Enroll Hub                                             |
      | E2E Scenario_2 AMP | AARP | enroll/ma-enrollment.html           | Medicare Advantage Enrollment Information              |
      | E2E Scenario_2 AMP | AARP | enroll/pdp-enrollment.html          | Medicare Prescription Drug Plan Enrollment Information |
      | E2E Scenario_2 AMP | AARP | resources.html                                                                    | Resources Hub                                   |
      | E2E Scenario_2 AMP | AARP | resources/ma-resources-materials.html                                             | Medicare Advantage Resources and Plan Materials |
      | E2E Scenario_2 AMP | AARP | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html        | Plan Information and Forms                      |
      | E2E Scenario_2 AMP | AARP | resources/ma-resources-materials/ma-information-forms/member-rights.html          | Medicare Rights and Responsibilities            |
       | E2E Scenario_2 AMP | AARP | resources/pdp-resources-materials.html                                            | Medicare Part D Plan Resources and Plan Materials |
       | E2E Scenario_2 AMP | AARP | resources/pdp-resources-materials/pdp-information-forms.html                      | Prescription Drug Plan Information and Forms      |
      | E2E Scenario_2 AMP | AARP | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html | Explanation of Benefits                         |
      | E2E Scenario_2 AMP | AARP | resources/disenrollment-information.html                                          | Disenrollment Rights and Responsibilities       |
      | E2E Scenario_2 AMP | AARP | resources/mail-order-pharmacy.html                   | Preferred Mail Home Delivery          |
      | E2E Scenario_2 AMP | AARP | resources/prescription-drug-transition.html          | Prescription Drug Transition Process  |
      | E2E Scenario_2 AMP | AARP | resources/prescription-drug-costs-help.html          | Get Help with Prescription Drug Costs |
      | E2E Scenario_2 AMP | AARP | resources/how-to-pay-your-premium.html               | How to Pay Your Premium               |
      | E2E Scenario_2 AMP | AARP | resources/how-to-appoint-a-representative.html       | How to Appoint a Representative       |
      | E2E Scenario_2 AMP | AARP | resources/medication-therapy-management-program.html | Medication Therapy Management Program |
      | E2E Scenario_2 AMP | AARP | resources/prescription-drug-appeals.html                      | Prescription Drug Coverage Determinations, Appeals and Grievances |
      | E2E Scenario_2 AMP | AARP | resources/healthcare-fraud.html                               | Preventing Medicare Fraud                                         |
      | E2E Scenario_2 AMP | AARP | health-plans/medicare-supplement-plans.html                   | Medicare Supplement Insurance Plans                               |
      | E2E Scenario_2 AMP | AARP | medicare-education.html                                       | Understanding Medicare                                            |
      | E2E Scenario_2 AMP | AARP | medicare-education/medicare-eligibility.html               | Medicare Eligibility                           |
      | E2E Scenario_2 AMP | AARP | medicare-education/medicare-parts-and-medigap-plans.html   | Coverage Choices                               |
      | E2E Scenario_2 AMP | AARP | medicare-education/medicare-benefits.html                  | Prescriptions, Providers & Benefits            |
      | E2E Scenario_2 AMP | AARP | medicare-education/medicare-costs.html                     | Medicare Cost Basics                           |
      | E2E Scenario_2 AMP | AARP | medicare-education/medicare-medicaid-dual-eligibility.html | Medicare, Medicaid and Dual Eligibility        |
      | E2E Scenario_2 AMP | AARP | medicare-education/extra-help-program.html                 | Get Help with Medicare Prescription Drug Costs |
      | E2E Scenario_2 AMP | AARP | medicare-education/medicare-advantage-plans.html      | Medicare Advantage (Part C) Plans         |
      | E2E Scenario_2 AMP | AARP | medicare-education/medicare-supplement-plans.html     | Medicare Supplement Insurance Plans       |
      | E2E Scenario_2 AMP | AARP | medicare-education/medicare-part-d.html               | Medicare Prescription Drug (Part D) Plans |
      | E2E Scenario_2 AMP | AARP | medicare-education/enrollment-and-changing-plans.html | Enrollment & Changing Plans               |
      | E2E Scenario_2 AMP | AARP | site-search.html/?q1=medicare&searchloc=header        | Site search page                          |
      | E2E Scenario_2 AMP | AARP | medicare-articles.html                                | Blog Homepage                             |
      | E2E Scenario_2 AMP | AARP | medicare-articles/eligibility-and-enrollment.html                                       | Category Page     |
      | E2E Scenario_2 AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article Page 1    |
      | E2E Scenario_2 AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Article Page 2    |
      | E2E Scenario_2 AMP | AARP | medicare-articles/medicare-made-clear.html                                              | MMC page          |
      | E2E Scenario_2 AMP | AARP | shop-medicare-coverage.html                                                             | Visit a UHC Store |
      | E2E Scenario_2 AMP | AARP | about-our-plans.html                                                                    | Why Choose UHC?   |
      | E2E Scenario_2 AMP | AARP | profile/guest                                                                           | Your Profile      |
      | E2E Scenario_2 AMP | AARP | plan-recommendation-engine.html                                                                                                                                                                                            | Plan Recommendation Engine  |
      | E2E Scenario_2 AMP | AARP | health-plans/estimate-drug-costs.html/drug-cost-estimator                                                                                                                                                                  | Drug Cost Estimator         |
      | E2E Scenario_2 AMP | AARP | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary | VPP: Plan Summary           |
      | E2E Scenario_2 AMP | AARP | health-plans/aarp-pharmacy.html/Pharmacy-Search-English                                                                                                                                                                    | Pharmacy Search             |
			| E2E Scenario_2 AMP| AARP | safe-shopping.html                                                                      | ShopPlan: Safe Shopping         |  
      | E2E Scenario_2 AMP| AARP | shop/compare/compare-ma-ms.html                                                         | ShopPlan: Compare MA-MS         |  
      | E2E Scenario_2 AMP| AARP | shop/compare/compare-ms.html                                                            | ShopPlan: Compare MS            | 
      | E2E Scenario_2 AMP| AARP | enroll/ms-apply.html                                                                    | ShopPlan: MS Enrollment         | 
      | E2E Scenario_2 AMP| AARP | enroll/ma-enrollment.html                                                               | ShopPlan: MA Enrollment         | 
      | E2E Scenario_2 AMP| AARP | shop/compare/compare-ma.html                                                            | ShopPlan: Compare MA            | 
      | E2E Scenario_2 AMP| AARP | shop/compare/compare-pdp.html                                                           | ShopPlan: Compare PDP           | 
     | E2E Scenario_2 AMP| AARP | shop/estimate/ms-costs.html                                                             | ShopPlan: Estimate MS           | 
      | E2E Scenario_2 AMP| AARP | shop/estimate/ma-costs.html                                                             | ShopPlan: Estimate  MA          | 
      | E2E Scenario_2 AMP| AARP | shop/estimate/pdp-costs.html                                                            | ShopPlan: Estimate  PDP         | 
			 | E2E Scenario_2 AMP| AARP | contact-us.html                                                                         | Contact us                      | 
      | E2E Scenario_2 AMP| AARP | shop/renew-active.html                                                                  | ShopPlan: Renew Active          | 
      | E2E Scenario_2 AMP| AARP | shop/medicare-advantage-veteran-plan.html                                               | ShopPlan: MA Veteran Plan       | 
      
    @globalheader_UHC @regressionUHC @uhcmedicare
    Examples: 
      | Scenario           | site | path                                                      | pagename                                                    |
      | E2E Scenario_2 UMS | UHC  | health-plans.html#/zipcode                                | Shop for a Plan                                             |
      | E2E Scenario_2 UMS | UHC  | shop.html                                                 | Shop Hub                                                    |
      | E2E Scenario_2 UMS | UHC  | shop/medicare-advantage-plans.html                        | Shop Medicare Advantage Plans                               |
      | E2E Scenario_2 UMS | UHC  | shop/medicare-advantage-plans/wellness-discounts.html     | Wellness Resources and Services                             |
      | E2E Scenario_2 UMS | UHC  | shop/medicare-advantage-plans/health-care-management.html | Clinical Programs: Condition Management and Care Management |
      | E2E Scenario_2 UMS | UHC  | shop/medicare-advantage-plans/ma-plan-benefits.html       | Medicare Advantage Plan Benefits                            |
      | E2E Scenario_2 UMS | UHC  | shop/prescription-drug-plans.html | Shop Medicare Prescription Drug Plans                |
      | E2E Scenario_2 UMS | UHC  | shop/compare.html                 | Shop: Compare Plans                                  |
			| E2E Scenario_2 UMS | UHC  | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html        | Appeals and Grievances                                 |
      | E2E Scenario_2 UMS | UHC  | shop/estimate.html                  | Shop: Estimate Costs                                   |
      | E2E Scenario_2 UMS | UHC  | shop/switch.html                    | Shop: Switching Plans                                  |
      | E2E Scenario_2 UMS | UHC  | shop/medicare-supplement-plans.html | Shop Medicare Supplement Insurance Plans               |
      | E2E Scenario_2 UMS | UHC  | enroll.html                         | Enroll Hub                                             |
      | E2E Scenario_2 UMS | UHC  | enroll/ma-enrollment.html           | Medicare Advantage Enrollment Information              |
      | E2E Scenario_2 UMS | UHC  | enroll/pdp-enrollment.html          | Medicare Prescription Drug Plan Enrollment Information |
      | E2E Scenario_2 UMS | UHC  | resources.html                                                                    | Resources Hub                                   |
      | E2E Scenario_2 UMS | UHC  | resources/ma-resources-materials.html                                             | Medicare Advantage Resources and Plan Materials |
      | E2E Scenario_2 UMS | UHC  | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html        | Plan Information and Forms                      |
      | E2E Scenario_2 UMS | UHC  | resources/ma-resources-materials/ma-information-forms/member-rights.html          | Medicare Rights and Responsibilities            |
      | E2E Scenario_2 UMS | UHC  | resources/pdp-resources-materials.html                                            | Medicare Part D Plan Resources and Plan Materials      |
      | E2E Scenario_2 UMS | UHC  | resources/pdp-resources-materials/pdp-information-forms.html                      | Prescription Drug Plan Information and Forms           |
      | E2E Scenario_2 UMS | UHC  | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html | Explanation of Benefits                         |
      | E2E Scenario_2 UMS | UHC  | resources/disenrollment-information.html                                          | Disenrollment Rights and Responsibilities       |
      | E2E Scenario_2 UMS | UHC  | resources/mail-order-pharmacy.html                   | Preferred Mail Home Delivery          |
      | E2E Scenario_2 UMS | UHC  | resources/prescription-drug-transition.html          | Prescription Drug Transition Process  |
      | E2E Scenario_2 UMS | UHC  | resources/prescription-drug-costs-help.html          | Get Help with Prescription Drug Costs |
      | E2E Scenario_2 UMS | UHC  | resources/how-to-pay-your-premium.html               | How to Pay Your Premium               |
      | E2E Scenario_2 UMS | UHC  | resources/how-to-appoint-a-representative.html       | How to Appoint a Representative       |
      | E2E Scenario_2 UMS | UHC  | resources/medication-therapy-management-program.html | Medication Therapy Management Program |
      | E2E Scenario_2 UMS | UHC  | resources/prescription-drug-appeals.html                      | Prescription Drug Coverage Determinations, Appeals and Grievances |
      | E2E Scenario_2 UMS | UHC  | resources/healthcare-fraud.html                               | Preventing Medicare Fraud                                         |
      | E2E Scenario_2 UMS | UHC  | health-plans/medicare-supplement-plans.html                   | Medicare Supplement Insurance Plans                               |
      | E2E Scenario_2 UMS | UHC  | medicare-education.html                                       | Understanding Medicare                                            |
      | E2E Scenario_2 UMS | UHC  | medicare-education/medicare-eligibility.html               | Medicare Eligibility                           |
      | E2E Scenario_2 UMS | UHC  | medicare-education/medicare-parts-and-medigap-plans.html   | Coverage Choices                               |
      | E2E Scenario_2 UMS | UHC  | medicare-education/medicare-benefits.html                  | Prescriptions, Providers & Benefits            |
      | E2E Scenario_2 UMS | UHC  | medicare-education/medicare-costs.html                     | Medicare Cost Basics                           |
      | E2E Scenario_2 UMS | UHC  | medicare-education/medicare-medicaid-dual-eligibility.html | Medicare, Medicaid and Dual Eligibility        |
      | E2E Scenario_2 UMS | UHC  | medicare-education/extra-help-program.html                 | Get Help with Medicare Prescription Drug Costs |
      | E2E Scenario_2 UMS | UHC  | medicare-education/medicare-advantage-plans.html      | Medicare Advantage (Part C) Plans         |
      | E2E Scenario_2 UMS | UHC  | medicare-education/medicare-supplement-plans.html     | Medicare Supplement Insurance Plans       |
      | E2E Scenario_2 UMS | UHC  | medicare-education/medicare-part-d.html               | Medicare Prescription Drug (Part D) Plans |
      | E2E Scenario_2 UMS | UHC  | medicare-education/enrollment-and-changing-plans.html | Enrollment & Changing Plans               |
      | E2E Scenario_2 UMS | UHC  | site-search.html/?q1=medicare&searchloc=header        | Site search page                          |
      | E2E Scenario_2 UMS | UHC  | medicare-articles.html                                                                  | Blog Homepage     |
      | E2E Scenario_2 UMS | UHC  | medicare-articles/eligibility-and-enrollment.html                                       | Category Page     |
      | E2E Scenario_2 UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article Page 1    |
      | E2E Scenario_2 UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Article Page 2    |
      | E2E Scenario_2 UMS | UHC  | medicare-articles/medicare-made-clear.html                                              | MMC page          |
      | E2E Scenario_2 UMS | UHC  | shop-medicare-coverage.html                                                             | Visit a UHC Store |
      | E2E Scenario_2 UMS | UHC  | about-our-plans.html                                                                    | Why Choose UHC?   |
      | E2E Scenario_2 UMS | UHC  | profile/guest                                                                           | Your Profile      |
			| E2E Scenario_2 UMS | UHC  | plan-recommendation-engine.html                                                                                                                                                                                            | Plan Recommendation Engine  |
      | E2E Scenario_2 UMS | UHC  | health-plans/estimate-drug-costs.html/drug-cost-estimator                                                                                                                                                                  | Drug Cost Estimator         |
      | E2E Scenario_2 UMS | UHC  | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary | VPP: Plan Summary           |
      | E2E Scenario_2 UMS | UHC  | health-plans/aarp-pharmacy.html/Pharmacy-Search-English                                                                                                                                                                    | Pharmacy Search             |
			| E2E Scenario_2 UMS| UHC | safe-shopping.html                                                                      | ShopPlan: Safe Shopping         |  
      | E2E Scenario_2 UMS| UHC | shop/compare/compare-ma-ms.html                                                         | ShopPlan: Compare MA-MS         |  
      | E2E Scenario_2 UMS| UHC | shop/compare/compare-ms.html                                                            | ShopPlan: Compare MS            | 
      | E2E Scenario_2 UMS| UHC | enroll/ms-apply.html                                                                    | ShopPlan: MS Enrollment         | 
      | E2E Scenario_2 UMS| UHC | enroll/ma-enrollment.html                                                               | ShopPlan: MA Enrollment         | 
      | E2E Scenario_2 UMS| UHC | shop/compare/compare-ma.html                                                            | ShopPlan: Compare MA            | 
      | E2E Scenario_2 UMS| UHC | shop/compare/compare-pdp.html                                                           | ShopPlan: Compare PDP           | 
     | E2E Scenario_2 UMS| UHC | shop/estimate/ms-costs.html                                                             | ShopPlan: Estimate MS           | 
      | E2E Scenario_2 UMS| UHC | shop/estimate/ma-costs.html                                                             | ShopPlan: Estimate  MA          | 
      | E2E Scenario_2 UMS| UHC | shop/estimate/pdp-costs.html                                                            | ShopPlan: Estimate  PDP         | 
			 | E2E Scenario_2 UMS| UHC | contact-us.html                                                                         | Contact us                      | 
      | E2E Scenario_2 UMS| UHC | shop/renew-active.html                                                                  | ShopPlan: Renew Active          | 
      | E2E Scenario_2 UMS| UHC | shop/medicare-advantage-veteran-plan.html                                               | ShopPlan: MA Veteran Plan       | 
 @UATRegression
  Scenario Outline: <Scenario> : To verify links displayed in the global header and footer on static pages : <pagename> page on site <site>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following medicare acquisition site page
      | PageName | <pagename> |
      | PagePath | <path>     |
    When user accesses global footer of the Medicare Plans All page
    And user clicks on Aboutus link from footer of the Medicare Plans home page
    And the user clicks on browser back button
    And user clicks on contactus link on aboutus page
    And the user clicks on browser back button
    And user clicks on sitemap link on contactus page
    And the user clicks on browser back button
    And user clicks on privacypolicy link on sitemap page
    And the user clicks on browser back button
    And user clicks on termsOfuse link on privacypolicy page
    And the user clicks on browser back button
    And user clicks on disclaimers link on terms&conditions page
    And the user clicks on browser back button
    And user clicks on agents&brokers link on disclaimers page
    And the user clicks on browser back button
    #And user verifies home link of agents&brokers page
    #And the user clicks on browser back button
    And the user clicks on Accessibility Link
    #And the user clicks on browser back button
    And the user clicks on Medicare Advantage Plans Link
    And the user clicks on browser back button
    And the user clicks on Dual Special Needs Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Supplement Insurance Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Prescription Drug Plans Link
    And the user clicks on browser back button
    And the user clicks on Medicare Education Link
    And the user clicks on browser back button
    #And the user clicks on Back to top Link
    When user accesses global header of the Medicare Plans home page
    And user verifies the logo
    And user hover over for plan member to click to go to member site
    #And user clicks on Sign in link
    #And the user clicks on browser back button
    #And user clicks on register link
    #And the user clicks on browser back button
    Then user validates visitor profile
    And the user clicks on browser back button
    #And user clicks on visit aarp.org link in the header
    #And the user clicks on browser back button
    And user clicks on visit aarp.org link in the footer

    @globalheader_AARP_9 @regressionAARP
    Examples: 
      | Scenario           | site | path                          | pagename         |
      | E2E Scenario_2 AMP | AARP | contact-us.html               | Contact Us       |
      | E2E Scenario_2 AMP | AARP | sitemap.html                  | Site Map         |
      | E2E Scenario_2 AMP | AARP | privacy_policy.html           | Privacy Policy   |
      | E2E Scenario_2 AMP | AARP | terms_and_conditions.html     | Terms of Use     |
      | E2E Scenario_2 AMP | AARP | disclaimer.html               | Disclaimers      |
      | E2E Scenario_2 AMP | AARP | health-insurance-brokers.html | Agents & Brokers |
      #| E2E Scenario_2 AMP | AARP | about-us.html                 | About Us         |

    @globalheader_UHC_9 @regressionUHC @uhcmedicare
    Examples: 
      | Scenario           | site | path                          | pagename         |
      | E2E Scenario_2 UMS | UHC  | contact-us.html               | Contact Us       |
      | E2E Scenario_2 UMS | UHC  | sitemap.html                  | Site Map         |
      | E2E Scenario_2 UMS | UHC  | privacy_policy.html           | Privacy Policy   |
      | E2E Scenario_2 UMS | UHC  | terms_and_conditions.html     | Terms of Use     |
      | E2E Scenario_2 UMS | UHC  | disclaimer.html               | Disclaimers      |
      | E2E Scenario_2 UMS | UHC  | health-insurance-brokers.html | Agents & Brokers |
      #| E2E Scenario_2 UMS | UHC  | about-us.html                 | About Us         |
