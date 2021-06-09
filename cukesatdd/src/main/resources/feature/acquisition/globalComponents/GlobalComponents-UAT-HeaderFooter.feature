@UATRegression @F513647 @globalComponent @headerfooter @GlobalHeaderFooter
Feature: 1.12 UAT - Header and Footer flows

  @globalfooterULayer @UATRegression
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
    And the user validates Language assistance links
    When user accesses global header of the Medicare Plans home page
    And user verifies the logo
    And user clicks on Sign in link
    And the user clicks on browser back button
    And user clicks on register link
    And the user clicks on browser back button
    Then user validates visitor profile
    And the user clicks on browser back button
    And user clicks on visit aarp.org link in the header
    And the user clicks on browser back button
    And the user clicks on Accessibility Link
    And the user clicks on browser back button
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

    @globalfooter_AARP @regressionAARP 
    Examples: 
      | Scenario           | site |
      | E2E Scenario_1 AMP | AARP |

    @globalfooter_UHC @regressionUHC @sanity
    Examples: 
      | Scenario           | site |
      | E2E Scenario_1 UMS | UHC  |

  @globalfooterULayer @UATRegression
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
    And user verifies home link of agents&brokers page
    And the user clicks on browser back button
    And the user clicks on Accessibility Link
    And the user clicks on browser back button
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
    And user clicks on Sign in link
    #And the user clicks on browser back button
    And user clicks on register link
    And the user clicks on browser back button
    Then user validates visitor profile
    And the user clicks on browser back button
    And user clicks on visit aarp.org link in the header
    And the user clicks on browser back button
    And user clicks on visit aarp.org link in the footer

    @globalfooter_AARP @regressionAARP
    Examples: 
      | Scenario           | site | zipcode | isMultutiCounty | county    |
      | E2E Scenario_3 AMP | AARP |   80001 | No              | Jefferson |

    @globalfooter_UHC @regressionUHC 
    Examples: 
      | Scenario           | site | zipcode | isMultutiCounty | county    |
      | E2E Scenario_3 UMS | UHC  |   80001 | No              | Jefferson |

  @globalfooterULayer @UATRegression
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
    And the user clicks on browser back button
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
    And user clicks on Sign in link
    #And the user clicks on browser back button
    And user clicks on register link
    And the user clicks on browser back button
    Then user validates visitor profile
    And the user clicks on browser back button
    And user clicks on visit aarp.org link in the header
    And the user clicks on browser back button
    And user clicks on visit aarp.org link in the footer

    @globalfooter_AARP @regressionAARP 
    Examples: 
      | Scenario           | site |
      | E2E Scenario_4 AMP | AARP |

    @globalfooter_UHC @regressionUHC
    Examples: 
      | Scenario           | site |
      | E2E Scenario_4 UMS | UHC  |

  @globalfooterULayer @UATRegression
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
    And the user clicks on browser back button
    And the user clicks on Accessibility Link
    And the user clicks on browser back button
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
    And user clicks on Sign in link
    #And the user clicks on browser back button
    And user clicks on register link
    And the user clicks on browser back button
    Then user validates visitor profile
    And the user clicks on browser back button
    And user clicks on visit aarp.org link in the header
    And the user clicks on browser back button
    And user clicks on visit aarp.org link in the footer

    @globalfooter_AARP @regressionAARP
    Examples: 
      | Scenario           | site |
      | E2E Scenario_5 AMP | AARP |

    @globalfooter_UHC @regressionUHC
    Examples: 
      | Scenario           | site |
      | E2E Scenario_5 UMS | UHC  |

  @globalheaderULayer @UATRegression
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
    And the user clicks on browser back button
    And the user clicks on Accessibility Link
    And the user clicks on browser back button
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
    And user clicks on Sign in link
    #And the user clicks on browser back button
    And user clicks on register link
    And the user clicks on browser back button
    Then user validates visitor profile
    And the user clicks on browser back button
    And user clicks on visit aarp.org link in the header
    And the user clicks on browser back button
    And user clicks on visit aarp.org link in the footer

    @globalheader_AARP @regressionAARP
    Examples: 
      | Scenario           | site | path                                                      | pagename                                                    |
      | E2E Scenario_2 AMP | AARP | health-plans.html#/zipcode                                | Shop for a Plan                                             |
      | E2E Scenario_2 AMP | AARP | shop.html                                                 | Shop Hub                                                    |
      | E2E Scenario_2 AMP | AARP | shop/medicare-advantage-plans.html                        | Shop Medicare Advantage Plans                               |
      | E2E Scenario_2 AMP | AARP | shop/medicare-advantage-plans/wellness-discounts.html     | Wellness Resources and Services                             |
      | E2E Scenario_2 AMP | AARP | shop/medicare-advantage-plans/health-care-management.html | Clinical Programs: Condition Management and Care Management |
      | E2E Scenario_2 AMP | AARP | shop/medicare-advantage-plans/ma-plan-benefits.html       | Medicare Advantage Plan Benefits                            |

    @globalheader_AARP_1 @regressionAARP
    Examples: 
      | Scenario           | site | path                              | pagename                                             |
      | E2E Scenario_2 AMP | AARP | shop/prescription-drug-plans.html | Shop Medicare Prescription Drug Plans                |
      #| E2E Scenario_2 AMP | AARP | shop/connect.html                 | Connect with UnitedHealthcare                        |
      | E2E Scenario_2 AMP | AARP | shop/connect/agentebrc.html       | Request an Appointment with a Health Insurance Agent |
      #| E2E Scenario_2 AMP | AARP | shop/connect/inquirykit.html      | Order Medicare Part D Enrollment Materials           |
      | E2E Scenario_2 AMP | AARP | shop/connect/attend.html          | Find UnitedHealthcare in Your Community              |
      | E2E Scenario_2 AMP | AARP | shop/compare.html                 | Shop: Compare Plans                                  |

    #|E2E Scenario_2 AMP|AARP|resources/ma-resources-materials/ma-information-forms/medicare-appeal.html |Appeals and Grievances|
    @globalheader_AARP_2 @regressionAARP
    Examples: 
      | Scenario           | site | path                                | pagename                                               |
      | E2E Scenario_2 AMP | AARP | shop/estimate.html                  | Shop: Estimate Costs                                   |
      | E2E Scenario_2 AMP | AARP | shop/switch.html                    | Shop: Switching Plans                                  |
      | E2E Scenario_2 AMP | AARP | shop/medicare-supplement-plans.html | Shop Medicare Supplement Insurance Plans               |
      | E2E Scenario_2 AMP | AARP | enroll.html                         | Enroll Hub                                             |
      | E2E Scenario_2 AMP | AARP | enroll/ma-enrollment.html           | Medicare Advantage Enrollment Information              |
      | E2E Scenario_2 AMP | AARP | enroll/pdp-enrollment.html          | Medicare Prescription Drug Plan Enrollment Information |

    @globalheader_AARP_3 @regressionAARP
    Examples: 
      | Scenario           | site | path                                                                              | pagename                                        |
      | E2E Scenario_2 AMP | AARP | resources.html                                                                    | Resources Hub                                   |
      | E2E Scenario_2 AMP | AARP | resources/ma-resources-materials.html                                             | Medicare Advantage Resources and Plan Materials |
      | E2E Scenario_2 AMP | AARP | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html        | Plan Information and Forms                      |
      | E2E Scenario_2 AMP | AARP | resources/ma-resources-materials/ma-information-forms/member-rights.html          | Medicare Rights and Responsibilities            |
      # | E2E Scenario_2 AMP | AARP | resources/pdp-resources-materials.html                                            | Medicare Part D Plan Resources and Plan Materials |
      # | E2E Scenario_2 AMP | AARP | resources/pdp-resources-materials/pdp-information-forms.html                      | Prescription Drug Plan Information and Forms      |
      | E2E Scenario_2 AMP | AARP | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html | Explanation of Benefits                         |
      | E2E Scenario_2 AMP | AARP | resources/disenrollment-information.html                                          | Disenrollment Rights and Responsibilities       |

    @globalheader_AARP_4 @regressionAARP
    Examples: 
      | Scenario           | site | path                                                 | pagename                              |
      | E2E Scenario_2 AMP | AARP | resources/mail-order-pharmacy.html                   | Preferred Mail Home Delivery          |
      | E2E Scenario_2 AMP | AARP | resources/prescription-drug-transition.html          | Prescription Drug Transition Process  |
      | E2E Scenario_2 AMP | AARP | resources/prescription-drug-costs-help.html          | Get Help with Prescription Drug Costs |
      | E2E Scenario_2 AMP | AARP | resources/how-to-pay-your-premium.html               | How to Pay Your Premium               |
      | E2E Scenario_2 AMP | AARP | resources/how-to-appoint-a-representative.html       | How to Appoint a Representative       |
      | E2E Scenario_2 AMP | AARP | resources/medication-therapy-management-program.html | Medication Therapy Management Program |

    @globalheader_AARP_5 @regressionAARP
    Examples: 
      | Scenario           | site | path                                                          | pagename                                                          |
      | E2E Scenario_2 AMP | AARP | resources/prescription-drug-appeals.html                      | Prescription Drug Coverage Determinations, Appeals and Grievances |
      | E2E Scenario_2 AMP | AARP | resources/healthcare-fraud.html                               | Preventing Medicare Fraud                                         |
      | E2E Scenario_2 AMP | AARP | health-plans/medicare-supplement-plans.html                   | Medicare Supplement Insurance Plans                               |
      | E2E Scenario_2 AMP | AARP | health-plans/medicare-supplement-plans/selectdirectory.html   | Medicare Select Hospital Directory                                |
      | E2E Scenario_2 AMP | AARP | health-plans/medicare-supplement-plans/agent-appointment.html | Health Insurance Free Agent Appointment                           |
      | E2E Scenario_2 AMP | AARP | medicare-education.html                                       | Understanding Medicare                                            |

    @globalheader_AARP_6 @regressionAARP
    Examples: 
      | Scenario           | site | path                                                       | pagename                                       |
      | E2E Scenario_2 AMP | AARP | medicare-education/medicare-eligibility.html               | Medicare Eligibility                           |
      | E2E Scenario_2 AMP | AARP | medicare-education/medicare-parts-and-medigap-plans.html   | Coverage Choices                               |
      | E2E Scenario_2 AMP | AARP | medicare-education/medicare-benefits.html                  | Prescriptions, Providers & Benefits            |
      | E2E Scenario_2 AMP | AARP | medicare-education/medicare-costs.html                     | Medicare Cost Basics                           |
      | E2E Scenario_2 AMP | AARP | medicare-education/medicare-medicaid-dual-eligibility.html | Medicare, Medicaid and Dual Eligibility        |
      | E2E Scenario_2 AMP | AARP | medicare-education/extra-help-program.html                 | Get Help with Medicare Prescription Drug Costs |

    @globalheader_AARP_7 @regressionAARP
    Examples: 
      | Scenario           | site | path                                                  | pagename                                  |
      | E2E Scenario_2 AMP | AARP | medicare-education/medicare-advantage-plans.html      | Medicare Advantage (Part C) Plans         |
      | E2E Scenario_2 AMP | AARP | medicare-education/medicare-supplement-plans.html     | Medicare Supplement Insurance Plans       |
      | E2E Scenario_2 AMP | AARP | medicare-education/medicare-part-d.html               | Medicare Prescription Drug (Part D) Plans |
      | E2E Scenario_2 AMP | AARP | medicare-education/enrollment-and-changing-plans.html | Enrollment & Changing Plans               |
      | E2E Scenario_2 AMP | AARP | site-search.html/?q1=medicare&searchloc=header        | Site search page                          |
      | E2E Scenario_2 AMP | AARP | medicare-articles.html                                | Blog Homepage                             |

    @globalheader_AARP_8 @regressionAARP
    Examples: 
      | Scenario           | site | path                                                                                    | pagename          |
      | E2E Scenario_2 AMP | AARP | medicare-articles/eligibility-and-enrollment.html                                       | Category Page     |
      | E2E Scenario_2 AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article Page 1    |
      | E2E Scenario_2 AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Article Page 2    |
      | E2E Scenario_2 AMP | AARP | medicare-articles/medicare-made-clear.html                                              | MMC page          |
      | E2E Scenario_2 AMP | AARP | shop-medicare-coverage.html                                                             | Visit a UHC Store |
      | E2E Scenario_2 AMP | AARP | about-our-plans.html                                                                    | Why Choose UHC?   |
      | E2E Scenario_2 AMP | AARP | profile/guest                                                                           | Your Profile      |

    @globalheader_UHC @regressionUHC
    Examples: 
      | Scenario           | site | path                                                      | pagename                                                    |
      | E2E Scenario_2 UMS | UHC  | health-plans.html#/zipcode                                | Shop for a Plan                                             |
      | E2E Scenario_2 UMS | UHC  | shop.html                                                 | Shop Hub                                                    |
      | E2E Scenario_2 UMS | UHC  | shop/medicare-advantage-plans.html                        | Shop Medicare Advantage Plans                               |
      | E2E Scenario_2 UMS | UHC  | shop/medicare-advantage-plans/wellness-discounts.html     | Wellness Resources and Services                             |
      | E2E Scenario_2 UMS | UHC  | shop/medicare-advantage-plans/health-care-management.html | Clinical Programs: Condition Management and Care Management |
      | E2E Scenario_2 UMS | UHC  | shop/medicare-advantage-plans/ma-plan-benefits.html       | Medicare Advantage Plan Benefits                            |

    @globalheader_UHC_1 @regressionUHC
    Examples: 
      | Scenario           | site | path                              | pagename                                             |
      | E2E Scenario_2 UMS | UHC  | shop/prescription-drug-plans.html | Shop Medicare Prescription Drug Plans                |
      # | E2E Scenario_2 UMS | UHC  | shop/connect.html                 | Connect with UnitedHealthcare                        |
      | E2E Scenario_2 UMS | UHC  | shop/connect/agentebrc.html       | Request an Appointment with a Health Insurance Agent |
      # | E2E Scenario_2 UMS | UHC  | shop/connect/inquirykit.html      | Order Medicare Part D Enrollment Materials           |
      | E2E Scenario_2 UMS | UHC  | shop/connect/attend.html          | Find UnitedHealthcare in Your Community              |
      | E2E Scenario_2 UMS | UHC  | shop/compare.html                 | Shop: Compare Plans                                  |

    #| E2E Scenario_2 UMS | UHC  | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html        | Appeals and Grievances                                 |
    @globalheader_UHC_2 @regressionUHC
    Examples: 
      | Scenario           | site | path                                | pagename                                               |
      | E2E Scenario_2 UMS | UHC  | shop/estimate.html                  | Shop: Estimate Costs                                   |
      | E2E Scenario_2 UMS | UHC  | shop/switch.html                    | Shop: Switching Plans                                  |
      | E2E Scenario_2 UMS | UHC  | shop/medicare-supplement-plans.html | Shop Medicare Supplement Insurance Plans               |
      | E2E Scenario_2 UMS | UHC  | enroll.html                         | Enroll Hub                                             |
      | E2E Scenario_2 UMS | UHC  | enroll/ma-enrollment.html           | Medicare Advantage Enrollment Information              |
      | E2E Scenario_2 UMS | UHC  | enroll/pdp-enrollment.html          | Medicare Prescription Drug Plan Enrollment Information |

    @globalheader_UHC_3 @regressionUHC
    Examples: 
      | Scenario           | site | path                                                                              | pagename                                        |
      | E2E Scenario_2 UMS | UHC  | resources.html                                                                    | Resources Hub                                   |
      | E2E Scenario_2 UMS | UHC  | resources/ma-resources-materials.html                                             | Medicare Advantage Resources and Plan Materials |
      | E2E Scenario_2 UMS | UHC  | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html        | Plan Information and Forms                      |
      | E2E Scenario_2 UMS | UHC  | resources/ma-resources-materials/ma-information-forms/member-rights.html          | Medicare Rights and Responsibilities            |
      #| E2E Scenario_2 UMS | UHC  | resources/pdp-resources-materials.html                                            | Medicare Part D Plan Resources and Plan Materials      |
      #| E2E Scenario_2 UMS | UHC  | resources/pdp-resources-materials/pdp-information-forms.html                      | Prescription Drug Plan Information and Forms           |
      | E2E Scenario_2 UMS | UHC  | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html | Explanation of Benefits                         |
      | E2E Scenario_2 UMS | UHC  | resources/disenrollment-information.html                                          | Disenrollment Rights and Responsibilities       |

    @globalheader_UHC_4 @regressionUHC
    Examples: 
      | Scenario           | site | path                                                 | pagename                              |
      | E2E Scenario_2 UMS | UHC  | resources/mail-order-pharmacy.html                   | Preferred Mail Home Delivery          |
      | E2E Scenario_2 UMS | UHC  | resources/prescription-drug-transition.html          | Prescription Drug Transition Process  |
      | E2E Scenario_2 UMS | UHC  | resources/prescription-drug-costs-help.html          | Get Help with Prescription Drug Costs |
      | E2E Scenario_2 UMS | UHC  | resources/how-to-pay-your-premium.html               | How to Pay Your Premium               |
      | E2E Scenario_2 UMS | UHC  | resources/how-to-appoint-a-representative.html       | How to Appoint a Representative       |
      | E2E Scenario_2 UMS | UHC  | resources/medication-therapy-management-program.html | Medication Therapy Management Program |

    @globalheader_UHC_5 @regressionUHC
    Examples: 
      | Scenario           | site | path                                                          | pagename                                                          |
      | E2E Scenario_2 UMS | UHC  | resources/prescription-drug-appeals.html                      | Prescription Drug Coverage Determinations, Appeals and Grievances |
      | E2E Scenario_2 UMS | UHC  | resources/healthcare-fraud.html                               | Preventing Medicare Fraud                                         |
      | E2E Scenario_2 UMS | UHC  | health-plans/medicare-supplement-plans.html                   | Medicare Supplement Insurance Plans                               |
      | E2E Scenario_2 UMS | UHC  | health-plans/medicare-supplement-plans/selectdirectory.html   | Medicare Select Hospital Directory                                |
      | E2E Scenario_2 UMS | UHC  | health-plans/medicare-supplement-plans/agent-appointment.html | Health Insurance Free Agent Appointment                           |
      | E2E Scenario_2 UMS | UHC  | medicare-education.html                                       | Understanding Medicare                                            |

    @globalheader_UHC_6 @regressionUHC
    Examples: 
      | Scenario           | site | path                                                       | pagename                                       |
      | E2E Scenario_2 UMS | UHC  | medicare-education/medicare-eligibility.html               | Medicare Eligibility                           |
      | E2E Scenario_2 UMS | UHC  | medicare-education/medicare-parts-and-medigap-plans.html   | Coverage Choices                               |
      | E2E Scenario_2 UMS | UHC  | medicare-education/medicare-benefits.html                  | Prescriptions, Providers & Benefits            |
      | E2E Scenario_2 UMS | UHC  | medicare-education/medicare-costs.html                     | Medicare Cost Basics                           |
      | E2E Scenario_2 UMS | UHC  | medicare-education/medicare-medicaid-dual-eligibility.html | Medicare, Medicaid and Dual Eligibility        |
      | E2E Scenario_2 UMS | UHC  | medicare-education/extra-help-program.html                 | Get Help with Medicare Prescription Drug Costs |

    @globalheader_UHC_7 @regressionUHC
    Examples: 
      | Scenario           | site | path                                                  | pagename                                  |
      | E2E Scenario_2 UMS | UHC  | medicare-education/medicare-advantage-plans.html      | Medicare Advantage (Part C) Plans         |
      | E2E Scenario_2 UMS | UHC  | medicare-education/medicare-supplement-plans.html     | Medicare Supplement Insurance Plans       |
      | E2E Scenario_2 UMS | UHC  | medicare-education/medicare-part-d.html               | Medicare Prescription Drug (Part D) Plans |
      | E2E Scenario_2 UMS | UHC  | medicare-education/enrollment-and-changing-plans.html | Enrollment & Changing Plans               |
      | E2E Scenario_2 UMS | UHC  | site-search.html/?q1=medicare&searchloc=header        | Site search page                          |

    @globalheader_UHC_8 @regressionUHC
    Examples: 
      | Scenario           | site | path                                                                                    | pagename          |
      | E2E Scenario_2 UMS | UHC  | medicare-articles.html                                                                  | Blog Homepage     |
      | E2E Scenario_2 UMS | UHC  | medicare-articles/eligibility-and-enrollment.html                                       | Category Page     |
      | E2E Scenario_2 UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article Page 1    |
      | E2E Scenario_2 UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Article Page 2    |
      | E2E Scenario_2 UMS | UHC  | medicare-articles/medicare-made-clear.html                                              | MMC page          |
      | E2E Scenario_2 UMS | UHC  | shop-medicare-coverage.html                                                             | Visit a UHC Store |
      | E2E Scenario_2 UMS | UHC  | about-our-plans.html                                                                    | Why Choose UHC?   |
      | E2E Scenario_2 UMS | UHC  | profile/guest                                                                           | Your Profile      |

  @globalheaderULayer @UATRegression
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
    And user verifies home link of agents&brokers page
    #And the user clicks on browser back button
    And the user clicks on Accessibility Link
    And the user clicks on browser back button
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
    And user clicks on Sign in link
    #And the user clicks on browser back button
    And user clicks on register link
    And the user clicks on browser back button
    Then user validates visitor profile
    And the user clicks on browser back button
    And user clicks on visit aarp.org link in the header
    And the user clicks on browser back button
    And user clicks on visit aarp.org link in the footer

    @globalheader_AARP_9 @regressionAARP
    Examples: 
      | Scenario           | site | path                          | pagename         |
      | E2E Scenario_2 AMP | AARP | about-us.html                 | About Us         |
      | E2E Scenario_2 AMP | AARP | contact-us.html               | Contact Us       |
      | E2E Scenario_2 AMP | AARP | sitemap.html                  | Site Map         |
      | E2E Scenario_2 AMP | AARP | privacy_policy.html           | Privacy Policy   |
      | E2E Scenario_2 AMP | AARP | terms_and_conditions.html     | Terms of Use     |
      | E2E Scenario_2 AMP | AARP | disclaimer.html               | Disclaimers      |
      | E2E Scenario_2 AMP | AARP | health-insurance-brokers.html | Agents & Brokers |

    @globalheader_UHC_9 @regressionUHC
    Examples: 
      | Scenario           | site | path                          | pagename         |
      | E2E Scenario_2 UMS | UHC  | about-us.html                 | About Us         |
      | E2E Scenario_2 UMS | UHC  | contact-us.html               | Contact Us       |
      | E2E Scenario_2 UMS | UHC  | sitemap.html                  | Site Map         |
      | E2E Scenario_2 UMS | UHC  | privacy_policy.html           | Privacy Policy   |
      | E2E Scenario_2 UMS | UHC  | terms_and_conditions.html     | Terms of Use     |
      | E2E Scenario_2 UMS | UHC  | disclaimer.html               | Disclaimers      |
      | E2E Scenario_2 UMS | UHC  | health-insurance-brokers.html | Agents & Brokers |
