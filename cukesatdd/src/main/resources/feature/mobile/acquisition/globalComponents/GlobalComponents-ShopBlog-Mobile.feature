Feature: Shop Blog Page Script

  Scenario Outline: To verify TFN on page for the page mentioned of <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validates whether call icon is visible

    @ShopBlog_TFN_AARP_1
    Examples: 
      | site | path                                | pageName                     | tfnXpath                                                            | tfnFlag |  |
      | AARP | shop.html                           | ShopPlan: Shop               | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    |  |
      | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1]  | true    |  |
      | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | (//*[contains(text(),'Find a Plan')]//following::a[2])              | true    |  |
      | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    |  |
      | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    |  |

    @ShopBlog_TFN_AARP_2
    Examples: 
      | site | path                            | pageName                   | tfnXpath                                                                                  | tfnFlag |  |
      | AARP | shop/compare.html               | ShopPlan: Compare          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | false   |  |
      | AARP | shop/compare/compare-pdp.html   | ShopPlan: Compare PDP Plan | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | true    |  |
      | AARP | shop/compare/compare-ma.html    | ShopPlan: Compare MA  Plan | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | true    |  |
      | AARP | shop/compare/compare-ms.html    | ShopPlan: Compare          | //*[contains(@class,'callus')]//div[@ng-show='medSupTfn']//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | shop/compare/compare-ma-ms.html | ShopPlan: Compare          | //*[contains(@class,'callus')]//div[@ng-show='fedTfn']//a[contains(@class, 'tel tfn')]    | true    |  |

    @ShopBlog_TFN_AARP_3
    Examples: 
      | site | path                         | pageName                    | tfnXpath                                                                                  | tfnFlag |  |
      | AARP | shop/estimate.html           | ShopPlan: Estimate          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | false   |  |
      | AARP | shop/estimate/ma-costs.html  | ShopPlan: Estimate MA Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | true    |  |
      | AARP | shop/estimate/pdp-costs.html | ShopPlan: Estimate PDP Plan | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | true    |  |
      | AARP | shop/estimate/ms-costs.html  | ShopPlan: Estimate          | //*[contains(@class,'callus')]//div[@ng-show='medSupTfn']//a[contains(@class, 'tel tfn')] | true    |  |

    @ShopBlog_TFN_AARP_4
    Examples: 
      | site | path                       | pageName                   | tfnXpath                                                       | tfnFlag |  |
      | AARP | enroll.html                | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | AARP | enroll/ma-enrollment.html  | ShopPlan: Enroll MA Plans  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | enroll/pdp-enrollment.html | ShopPlan: Enroll PDP Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | enroll/ms-apply.html       | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |

    @ShopBlog_TFN_AARP_5
    Examples: 
      | site | path                                                      | pageName                        | tfnXpath                                                                               | tfnFlag |  |
      | AARP | shop/medicare-advantage-plans/wellness-discounts.html     | ShopPlan: Welness Discount      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                         | true    |  |
      | AARP | shop/medicare-advantage-plans/health-care-management.html | ShopPlan: Healthcare management | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                         | true    |  |
      | AARP | safe-shopping.html                                        | ShopPlan: Shop                  | //*[contains(@class,'callus')]//div[@ng-show='fedTfn']//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | shop/switch.html                                          | ShopPlan: Switch                | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                         | false   |  |
      | AARP | shop/renew-active.html                                    | ShopPlan: Renew-Active          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                         | true    |  |

    @ShopBlog_TFN_AARP_6
    Examples: 
      | site | path                                                     | pageName                              | tfnXpath                                                       | tfnFlag |  |
      | AARP | medicare-education.html                                  | Understanding Medicare                | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | medicare-education/medicare-eligibility.html             | Medicare Eligibility                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | medicare-education/medicare-parts-and-medigap-plans.html | Medicare and Medigap Coverage Options | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | medicare-education/medicare-benefits.html                | Prescriptions, Providers & Benefits   | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | medicare-education/medicare-costs.html                   | Medicare Cost Basics                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |

    @ShopBlog_TFN_AARP_7
    Examples: 
      | site | path                                                  | pageName                              | tfnXpath                                                       | tfnFlag |  |
      | AARP | medicare-education/enrollment-and-changing-plans.html | Medicare Enrollment Basics            | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | medicare-education/medicare-advantage-plans.html      | Learn about Medicare Advantage Plans  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | medicare-education/medicare-supplement-plans.html     | Learn about Medicare Supplement Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | medicare-education/medicare-part-d.html               | Medicare Prescription Drug Plans      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | medicare-education/medicare-faq.html                  | Medicare FAQ                          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |

    @ShopBlog_TFN_AARP_8
    Examples: 
      | site | path                                                         | pageName                                | tfnXpath                                                       | tfnFlag |  |
      | AARP | resources.html                                               | ShopPlan: Resources                     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | AARP | resources/pdp-resources-materials.html                       | ShopPlan: Resources PDP Plans           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | AARP | resources/pdp-resources-materials/pdp-information-forms.html | ShopPlan: Resources PDP Plans Info      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | AARP | resources/mail-order-pharmacy.html                           | ShopPlan: Resources Mail Order Pharmacy | (//*[contains(@class,'tel')])[2]                               | false   |  |
      | AARP | resources/ma-resources-materials.html                        | ShopPlan: Resources MA Plans            | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |

    @ShopBlog_TFN_AARP_9
    Examples: 
      | site | path                                                       | pageName                             | tfnXpath                                                       | tfnFlag |  |
      | AARP | resources/ma-resources-materials/ma-information-forms.html | ShopPlan: Resources MA Plans Info    | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | AARP | resources/medication-therapy-management-program.html       | ShopPlan: Resources Therapy          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | AARP | resources/how-to-appoint-a-representative.html             | ShopPlan: Resources Appoint Rep      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | AARP | resources/prescription-drug-costs-help.html                | ShopPlan: Resources Rx cost Help     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | AARP | resources/healthcare-fraud.html                            | ShopPlan: Resources Healthcare Fraud | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |

    @ShopBlog_TFN_AARP_10
    Examples: 
      | site | path                                                                              | pageName                                         | tfnXpath                                                       | tfnFlag |  |
      | AARP | resources/how-to-pay-your-premium.html                                            | ShopPlan: Resources Pay Premium                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | AARP | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html | ShopPlan: Resources PDP EOB                      | //*[contains(@class,'tel')]                                    | false   |  |
      | AARP | resources/prescription-drug-appeals.html                                          | ShopPlan: Resources Prescription Drug Appeal     | //*[contains(@class,'tel')]                                    | false   |  |
      | AARP | resources/prescription-drug-transition.html                                       | ShopPlan: Resources Prescription Drug Transition | //*[contains(@class,'tel')]                                    | false   |  |

    @ShopBlog_TFN_AARP_11
    Examples: 
      | site | path                                                                       | pageName                              | tfnXpath                                                       | tfnFlag |  |
      | AARP | resources/ma-resources-materials/ma-information-forms/member-rights.html   | ShopPlan: Resources MA Member Rights  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | AARP | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html | ShopPlan: Resources MA Appeals        | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | AARP | resources/disenrollment-information.html                                   | ShopPlan: Resources PDP Disenrollment | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |

    @ShopBlog_TFN_AARP_12
    Examples: 
      | site | path                                                                                    | pageName               | tfnXpath                                                       | tfnFlag |  |
      | AARP | medicare-articles.html                                                                  | Medicare Articles Home | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | medicare-articles/eligibility-and-enrollment.html                                       | Sample Category Page   | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | medicare-articles/medicare-made-clear.html                                              | MMC page               | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1         | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2         | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |

    @ShopBlog_TFN_AARP_13
    Examples: 
      | site | path                                                  | pageName      | tfnXpath                                                       | tfnFlag |  |
      | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | medicare-articles/medicare-costs.html                 | Category page | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | medicare-articles/shopping-for-medicare.html          | Category page | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |

    @ShopBlog_TFN_AARP_14
    Examples: 
      | site | path                                                                      | pageName                | tfnXpath                                                       | tfnFlag |  |
      | AARP | health-plans/estimate-drug-costs.html!/drug-cost-estimator                | Drug Cost Estimator     | //a[contains(@class, 'tel')]                                   | false   |  |
      | AARP | health-plans/aarp-pharmacy.html!/Pharmacy-Search-English                  | Pharmacy Search         | //a[contains(@href ,'tel')]                                    | true    |  |
      | AARP | medicare-plans.html                                                       | ShopPlan: Plan Selector | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | AARP | profile/guest                                                             | Visitor Profile: Guest  | //*[contains(@class,'tel')]                                    | true    |  |
      | AARP | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | Decision Guide          | //*[@id='tfn']                                                 | true    |  |
      | AARP | health-plans/medicare-supplement-plans/agent-appointment.html             | Agent Appointment       | //*[@id='tfn']                                                 | true    |  |

    @ShopBlog_TFN_AARP_15
    Examples: 
      | site | path                          | pageName                   | tfnXpath                     | tfnFlag |  |
      | AARP | about-us.html                 | Footer: About Us           | //a[contains(@class, 'tel')] | false   |  |
      | AARP | sitemap.html                  | Footer: Site Map           | //a[contains(@href ,'tel')]  | false   |  |
      | AARP | terms-of-use.html             | Footer: Terms of Use       | //a[contains(@href ,'tel')]  | false   |  |
      | AARP | disclaimer.html               | Footer: Disclaimers        | //a[contains(@href ,'tel')]  | false   |  |
      | AARP | health-insurance-brokers.html | Footer: Agents and Brokers | //a[contains(@href ,'tel')]  | false   |  |
      | AARP | contact-us.html               | Footer: Contact Us         | //a[contains(@href ,'tel')]  | false   |  |
      | AARP | privacy-policy.html           | Footer: Privacy Policy     | //a[contains(@href ,'tel')]  | false   |  |

    @ShopBlog_TFN_UHC_1
    Examples: 
      | site | path                                | pageName                     | tfnXpath                                                            | tfnFlag |  |
      | UHC  | shop.html                           | ShopPlan: Shop               | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    |  |
      | UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1]  | true    |  |
      | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | (//*[contains(text(),'Find a Plan')]//following::a[2])              | true    |  |
      | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    |  |
      | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    |  |

    @ShopBlog_TFN_UHC_2
    Examples: 
      | site | path                            | pageName                   | tfnXpath                                                                                  | tfnFlag |  |
      | UHC  | shop/compare.html               | ShopPlan: Compare          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | false   |  |
      | UHC  | shop/compare/compare-pdp.html   | ShopPlan: Compare PDP Plan | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | true    |  |
      | UHC  | shop/compare/compare-ma.html    | ShopPlan: Compare MA  Plan | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | true    |  |
      | UHC  | shop/compare/compare-ms.html    | ShopPlan: Compare          | //*[contains(@class,'callus')]//div[@ng-show='medSupTfn']//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | shop/compare/compare-ma-ms.html | ShopPlan: Compare          | //*[contains(@class,'callus')]//div[@ng-show='fedTfn']//a[contains(@class, 'tel tfn')]    | true    |  |

    @ShopBlog_TFN_UHC_3
    Examples: 
      | site | path                         | pageName                    | tfnXpath                                                                                  | tfnFlag |  |
      | UHC  | shop/estimate.html           | ShopPlan: Estimate          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | false   |  |
      | UHC  | shop/estimate/ma-costs.html  | ShopPlan: Estimate MA Plan  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | true    |  |
      | UHC  | shop/estimate/pdp-costs.html | ShopPlan: Estimate PDP Plan | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                            | true    |  |
      | UHC  | shop/estimate/ms-costs.html  | ShopPlan: Estimate          | //*[contains(@class,'callus')]//div[@ng-show='medSupTfn']//a[contains(@class, 'tel tfn')] | true    |  |

    @ShopBlog_TFN_UHC_4
    Examples: 
      | site | path                       | pageName                   | tfnXpath                                                       | tfnFlag |  |
      | UHC  | enroll.html                | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | UHC  | enroll/ma-enrollment.html  | ShopPlan: Enroll MA Plans  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | enroll/pdp-enrollment.html | ShopPlan: Enroll PDP Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | enroll/ms-apply.html       | ShopPlan: Enroll           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |

    @ShopBlog_TFN_UHC_5
    Examples: 
      | site | path                                                      | pageName                        | tfnXpath                                                                               | tfnFlag |  |
      | UHC  | shop/medicare-advantage-plans/wellness-discounts.html     | ShopPlan: Welness Discount      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                         | true    |  |
      | UHC  | shop/medicare-advantage-plans/health-care-management.html | ShopPlan: Healthcare management | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                         | true    |  |
      | UHC  | safe-shopping.html                                        | ShopPlan: Shop                  | //*[contains(@class,'callus')]//div[@ng-show='fedTfn']//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | shop/switch.html                                          | ShopPlan: Switch                | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                         | false   |  |
      | UHC  | shop/renew-active.html                                    | ShopPlan: Renew-Active          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]                         | true    |  |

    @ShopBlog_TFN_UHC_6
    Examples: 
      | site | path                                                     | pageName                              | tfnXpath                                                       | tfnFlag |  |
      | UHC  | medicare-education.html                                  | Understanding Medicare                | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | medicare-education/medicare-eligibility.html             | Medicare Eligibility                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | medicare-education/medicare-parts-and-medigap-plans.html | Medicare and Medigap Coverage Options | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | medicare-education/medicare-benefits.html                | Prescriptions, Providers & Benefits   | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | medicare-education/medicare-costs.html                   | Medicare Cost Basics                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |

    @ShopBlog_TFN_UHC_7
    Examples: 
      | site | path                                                  | pageName                              | tfnXpath                                                       | tfnFlag |  |
      | UHC  | medicare-education/enrollment-and-changing-plans.html | Medicare Enrollment Basics            | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | medicare-education/medicare-advantage-plans.html      | Learn about Medicare Advantage Plans  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | medicare-education/medicare-supplement-plans.html     | Learn about Medicare Supplement Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | medicare-education/medicare-part-d.html               | Medicare Prescription Drug Plans      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | medicare-education/medicare-faq.html                  | Medicare FAQ                          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |

    @ShopBlog_TFN_UHC_8
    Examples: 
      | site | path                                                         | pageName                                | tfnXpath                                                       | tfnFlag |  |
      | UHC  | resources.html                                               | ShopPlan: Resources                     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | UHC  | resources/pdp-resources-materials.html                       | ShopPlan: Resources PDP Plans           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | UHC  | resources/pdp-resources-materials/pdp-information-forms.html | ShopPlan: Resources PDP Plans Info      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | UHC  | resources/mail-order-pharmacy.html                           | ShopPlan: Resources Mail Order Pharmacy | (//*[contains(@class,'tel')])[2]                               | false   |  |
      | UHC  | resources/ma-resources-materials.html                        | ShopPlan: Resources MA Plans            | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |

    @ShopBlog_TFN_UHC_9
    Examples: 
      | site | path                                                       | pageName                             | tfnXpath                                                       | tfnFlag |  |
      | UHC  | resources/ma-resources-materials/ma-information-forms.html | ShopPlan: Resources MA Plans Info    | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | UHC  | resources/medication-therapy-management-program.html       | ShopPlan: Resources Therapy          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | UHC  | resources/how-to-appoint-a-representative.html             | ShopPlan: Resources Appoint Rep      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | UHC  | resources/prescription-drug-costs-help.html                | ShopPlan: Resources Rx cost Help     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | UHC  | resources/healthcare-fraud.html                            | ShopPlan: Resources Healthcare Fraud | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |

    @ShopBlog_TFN_UHC_10
    Examples: 
      | site | path                                                                              | pageName                                         | tfnXpath                                                       | tfnFlag |  |
      | UHC  | resources/how-to-pay-your-premium.html                                            | ShopPlan: Resources Pay Premium                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | UHC  | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html | ShopPlan: Resources PDP EOB                      | //*[contains(@class,'tel')]                                    | false   |  |
      | UHC  | resources/prescription-drug-appeals.html                                          | ShopPlan: Resources Prescription Drug Appeal     | //*[contains(@class,'tel')]                                    | false   |  |
      | UHC  | resources/prescription-drug-transition.html                                       | ShopPlan: Resources Prescription Drug Transition | //*[contains(@class,'tel')]                                    | false   |  |

    @ShopBlog_TFN_UHC_11
    Examples: 
      | site | path                                                                       | pageName                              | tfnXpath                                                       | tfnFlag |  |
      | UHC  | resources/ma-resources-materials/ma-information-forms/member-rights.html   | ShopPlan: Resources MA Member Rights  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | UHC  | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html | ShopPlan: Resources MA Appeals        | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | UHC  | resources/disenrollment-information.html                                   | ShopPlan: Resources PDP Disenrollment | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |

    @ShopBlog_TFN_UHC_12
    Examples: 
      | site | path                                                                                    | pageName               | tfnXpath                                                       | tfnFlag |  |
      | UHC  | medicare-articles.html                                                                  | Medicare Articles Home | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | medicare-articles/eligibility-and-enrollment.html                                       | Sample Category Page   | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | medicare-articles/medicare-made-clear.html                                              | MMC page               | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1         | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2         | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |

    @ShopBlog_TFN_UHC_13
    Examples: 
      | site | path                                                  | pageName      | tfnXpath                                                       | tfnFlag |  |
      | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | medicare-articles/medicare-costs.html                 | Category page | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | medicare-articles/shopping-for-medicare.html          | Category page | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |
      | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | true    |  |

    @ShopBlog_TFN_UHC_14
    Examples: 
      | site | path                                                                      | pageName                | tfnXpath                                                       | tfnFlag |  |
      | UHC  | health-plans/estimate-drug-costs.html!/drug-cost-estimator                | Drug Cost Estimator     | //a[contains(@class, 'tel')]                                   | false   |  |
      | UHC  | health-plans/UHC-pharmacy.html!/Pharmacy-Search-English                   | Pharmacy Search         | //a[contains(@href ,'tel')]                                    | true    |  |
      | UHC  | medicare-plans.html                                                       | ShopPlan: Plan Selector | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | false   |  |
      | UHC  | profile/guest                                                             | Visitor Profile: Guest  | //*[contains(@class,'tel')]                                    | true    |  |
      | UHC  | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | Decision Guide          | //*[@id='tfn']                                                 | true    |  |
      | UHC  | health-plans/medicare-supplement-plans/agent-appointment.html             | Agent Appointment       | //*[@id='tfn']                                                 | true    |  |

    @ShopBlog_TFN_UHC_15
    Examples: 
      | site | path                          | pageName                   | tfnXpath                     | tfnFlag |  |
      | UHC  | about-us.html                 | Footer: About Us           | //a[contains(@class, 'tel')] | false   |  |
      | UHC  | sitemap.html                  | Footer: Site Map           | //a[contains(@href ,'tel')]  | false   |  |
      | UHC  | terms-of-use.html             | Footer: Terms of Use       | //a[contains(@href ,'tel')]  | false   |  |
      | UHC  | disclaimer.html               | Footer: Disclaimers        | //a[contains(@href ,'tel')]  | false   |  |
      | UHC  | health-insurance-brokers.html | Footer: Agents and Brokers | //a[contains(@href ,'tel')]  | false   |  |
      | UHC  | contact-us.html               | Footer: Contact Us         | //a[contains(@href ,'tel')]  | false   |  |
      | UHC  | privacy-policy.html           | Footer: Privacy Policy     | //a[contains(@href ,'tel')]  | false   |  |

  Scenario Outline: To verify Global Components for the page mentioned of AARP site <pageName> : <path> : <tfnXpath>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validate ZipCode Components on the page using ZipCode "10001"
    When the user clicks on Agent link and validates the correct URL is loaded from article page
      | UHC Agent URL | <UHCUrl> |

    @ShopBlog_AgentZip_AARP_1
    Examples: 
      | site | path                                | pageName                     | UHCUrl                      |
      | AARP | shop.html                           | ShopPlan: Shop               | https://www.myuhcagent.com/ |
      | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ |
      | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ |
      | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ |
      | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_AARP_2
    Examples: 
      | site | path                            | pageName                   | UHCUrl                      |
      | AARP | shop/compare.html               | ShopPlan: Compare          | https://www.myuhcagent.com/ |
      | AARP | shop/compare/compare-ms.html    | ShopPlan: Compare          | https://www.myuhcagent.com/ |
      | AARP | shop/compare/compare-ma-ms.html | ShopPlan: Compare          | https://www.myuhcagent.com/ |
      | AARP | shop/compare/compare-pdp.html   | ShopPlan: Compare PDP Plan | https://www.myuhcagent.com/ |
      | AARP | shop/compare/compare-ma.html    | ShopPlan: Compare MA  Plan | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_AARP_3
    Examples: 
      | site | path                         | pageName                    | UHCUrl                      |
      | AARP | shop/estimate/ma-costs.html  | ShopPlan: Estimate MA Plan  | https://www.myuhcagent.com/ |
      | AARP | shop/estimate/pdp-costs.html | ShopPlan: Estimate PDP Plan | https://www.myuhcagent.com/ |
      | AARP | shop/estimate/ms-costs.html  | ShopPlan: Estimate          | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_AARP_4
    Examples: 
      | site | path                       | pageName                   | UHCUrl                      |
      | AARP | enroll.html                | ShopPlan: Enroll           | https://www.myuhcagent.com/ |
      | AARP | enroll/ma-enrollment.html  | ShopPlan: Enroll MA Plans  | https://www.myuhcagent.com/ |
      | AARP | enroll/pdp-enrollment.html | ShopPlan: Enroll PDP Plans | https://www.myuhcagent.com/ |
      | AARP | enroll/ms-apply.html       | ShopPlan: Enroll           | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_AARP_5
    Examples: 
      | site | path                                                      | pageName                        | UHCUrl                      |
      | AARP | shop/medicare-advantage-plans/wellness-discounts.html     | ShopPlan: Welness Discount      | https://www.myuhcagent.com/ |
      | AARP | shop/medicare-advantage-plans/health-care-management.html | ShopPlan: Healthcare management | https://www.myuhcagent.com/ |
      | AARP | shop/renew-active.html                                    | ShopPlan: Renew-Active          | https://www.myuhcagent.com/ |
      | AARP | about-us.html                                             | Footer: About Us                | https://www.myuhcagent.com/ |
      | AARP | contact-us.html                                           | Footer: Contact Us              | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_AARP_6
    Examples: 
      | site | path                                                     | pageName                              | UHCUrl                      |
      | AARP | medicare-education.html                                  | Understanding Medicare                | https://www.myuhcagent.com/ |
      | AARP | medicare-education/medicare-eligibility.html             | Medicare Eligibility                  | https://www.myuhcagent.com/ |
      | AARP | medicare-education/medicare-parts-and-medigap-plans.html | Medicare and Medigap Coverage Options | https://www.myuhcagent.com/ |
      | AARP | medicare-education/medicare-benefits.html                | Prescriptions, Providers & Benefits   | https://www.myuhcagent.com/ |
      | AARP | medicare-education/medicare-costs.html                   | Medicare Cost Basics                  | https://www.myuhcagent.com/ |
      | AARP | medicare-education/enrollment-and-changing-plans.html    | Medicare Enrollment Basics            | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_AARP_7
    Examples: 
      | site | path                                             | pageName                             | UHCUrl                      |
      | AARP | medicare-education/medicare-advantage-plans.html | Learn about Medicare Advantage Plans | https://www.myuhcagent.com/ |
      #| AARP | medicare-education/medicare-supplement-plans.html | Learn about Medicare Supplement Plans | https://www.myuhcagent.com/ |
      | AARP | medicare-education/medicare-part-d.html          | Medicare Prescription Drug Plans     | https://www.myuhcagent.com/ |
      | AARP | medicare-education/medicare-faq.html             | Medicare FAQ                         | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_AARP_8
    Examples: 
      | site | path                                                                                    | pageName               | UHCUrl                      |
      | AARP | medicare-articles.html                                                                  | Medicare Articles Home | https://www.myuhcagent.com/ |
      | AARP | medicare-articles/eligibility-and-enrollment.html                                       | Sample Category Page   | https://www.myuhcagent.com/ |
      | AARP | medicare-articles/medicare-made-clear.html                                              | MMC page               | https://www.myuhcagent.com/ |
      | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1         | https://www.myuhcagent.com/ |
      | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2         | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_AARP_9
    Examples: 
      | site | path                                                  | pageName      | UHCUrl                      |
      | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | AARP | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | AARP | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_UHC_1
    Examples: 
      | site | path                                | pageName                     | UHCUrl                      |
      | UHC  | shop.html                           | ShopPlan: Shop               | https://www.myuhcagent.com/ |
      | UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ |
      | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ |
      | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ |
      | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_UHC_2
    Examples: 
      | site | path                            | pageName                   | UHCUrl                      |
      | UHC  | shop/compare.html               | ShopPlan: Compare          | https://www.myuhcagent.com/ |
      | UHC  | shop/compare/compare-ms.html    | ShopPlan: Compare          | https://www.myuhcagent.com/ |
      | UHC  | shop/compare/compare-ma-ms.html | ShopPlan: Compare          | https://www.myuhcagent.com/ |
      | UHC  | shop/compare/compare-pdp.html   | ShopPlan: Compare PDP Plan | https://www.myuhcagent.com/ |
      | UHC  | shop/compare/compare-ma.html    | ShopPlan: Compare MA  Plan | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_UHC_3
    Examples: 
      | site | path                         | pageName                    | UHCUrl                      |
      | UHC  | shop/estimate/ma-costs.html  | ShopPlan: Estimate MA Plan  | https://www.myuhcagent.com/ |
      | UHC  | shop/estimate/pdp-costs.html | ShopPlan: Estimate PDP Plan | https://www.myuhcagent.com/ |
      | UHC  | shop/estimate/ms-costs.html  | ShopPlan: Estimate          | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_UHC_4
    Examples: 
      | site | path                       | pageName                   | UHCUrl                      |
      | UHC  | enroll.html                | ShopPlan: Enroll           | https://www.myuhcagent.com/ |
      | UHC  | enroll/ma-enrollment.html  | ShopPlan: Enroll MA Plans  | https://www.myuhcagent.com/ |
      | UHC  | enroll/pdp-enrollment.html | ShopPlan: Enroll PDP Plans | https://www.myuhcagent.com/ |
      | UHC  | enroll/ms-apply.html       | ShopPlan: Enroll           | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_UHC_5
    Examples: 
      | site | path                                                      | pageName                        | UHCUrl                      |
      | UHC  | shop/medicare-advantage-plans/wellness-discounts.html     | ShopPlan: Welness Discount      | https://www.myuhcagent.com/ |
      | UHC  | shop/medicare-advantage-plans/health-care-management.html | ShopPlan: Healthcare management | https://www.myuhcagent.com/ |
      | UHC  | shop/renew-active.html                                    | ShopPlan: Renew-Active          | https://www.myuhcagent.com/ |
      | UHC  | about-us.html                                             | Footer: About Us                | https://www.myuhcagent.com/ |
      | UHC  | contact-us.html                                           | Footer: Contact Us              | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_UHC_6
    Examples: 
      | site | path                                                     | pageName                              | UHCUrl                      |
      | UHC  | medicare-education.html                                  | Understanding Medicare                | https://www.myuhcagent.com/ |
      | UHC  | medicare-education/medicare-eligibility.html             | Medicare Eligibility                  | https://www.myuhcagent.com/ |
      | UHC  | medicare-education/medicare-parts-and-medigap-plans.html | Medicare and Medigap Coverage Options | https://www.myuhcagent.com/ |
      | UHC  | medicare-education/medicare-benefits.html                | Prescriptions, Providers & Benefits   | https://www.myuhcagent.com/ |
      | UHC  | medicare-education/medicare-costs.html                   | Medicare Cost Basics                  | https://www.myuhcagent.com/ |
      | UHC  | medicare-education/enrollment-and-changing-plans.html    | Medicare Enrollment Basics            | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_UHC_7
    Examples: 
      | site | path                                             | pageName                             | UHCUrl                      |
      | UHC  | medicare-education/medicare-advantage-plans.html | Learn about Medicare Advantage Plans | https://www.myuhcagent.com/ |
      #| UHC  | medicare-education/medicare-supplement-plans.html | Learn about Medicare Supplement Plans | https://www.myuhcagent.com/ |
      | UHC  | medicare-education/medicare-part-d.html          | Medicare Prescription Drug Plans     | https://www.myuhcagent.com/ |
      | UHC  | medicare-education/medicare-faq.html             | Medicare FAQ                         | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_UHC_8
    Examples: 
      | site | path                                                                                    | pageName               | UHCUrl                      |
      | UHC  | medicare-articles.html                                                                  | Medicare Articles Home | https://www.myuhcagent.com/ |
      | UHC  | medicare-articles/eligibility-and-enrollment.html                                       | Sample Category Page   | https://www.myuhcagent.com/ |
      | UHC  | medicare-articles/medicare-made-clear.html                                              | MMC page               | https://www.myuhcagent.com/ |
      | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1         | https://www.myuhcagent.com/ |
      | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2         | https://www.myuhcagent.com/ |

    @ShopBlog_AgentZip_UHC_9
    Examples: 
      | site | path                                                  | pageName      | UHCUrl                      |
      | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | UHC  | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | UHC  | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |

  Scenario Outline: To verify Need Help Section TFN for the page mentioned of <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates TFN on need help section of Shop pages
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |

    @ShopBlog_NeedHelpTFN_AARP_1
    Examples: 
      | Scenario           | site | path                                | pageName                     | tfnXpath                                                           | tfnFlag | hoursxpath                                                                   | hoursFlag |
      | E2E Scenario 2_AMP | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                   | ShopPlan: Compare            | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 4_AMP | AARP | enroll.html                         | ShopPlan: Enroll             | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 4_AMP | AARP | shop.html                           | ShopPlan: Shop Hub           | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 4_AMP | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[2] | true    | (//div[contains(@ng-show,'medSupTfn')])[1]//p                                | true      |
      | E2E Scenario 4_AMP | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 4_AMP | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 5_AMP | AARP | shop/estimate.html                  | Estimate                     | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | false   | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |

    @ShopBlog_NeedHelpTFN_UHC_1
    Examples: 
      | Scenario           | site | path                                | pageName                     | tfnXpath                                                           | tfnFlag | hoursxpath                                                                   | hoursFlag |
      | E2E Scenario 2_AMP | UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 5_AMP | UHC  | shop/compare.html                   | ShopPlan: Compare            | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 4_AMP | UHC  | enroll.html                         | ShopPlan: Enroll             | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 4_AMP | UHC  | shop.html                           | ShopPlan: Shop Hub           | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 4_AMP | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[2] | true    | (//div[contains(@ng-show,'medSupTfn')])[1]//p                                | true      |
      | E2E Scenario 4_AMP | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 4_AMP | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 5_AMP | UHC  | shop/estimate.html                  | Estimate                     | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | false   | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |

  Scenario Outline: <Scenario>- To verify TFN on right rail of medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates TFN on right rail Medicare Article
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |

    @ShopBlog_RightRailTFN_AARP_1
    Examples: 
      | Scenario           | site | path                                                                                    | pageName       | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1 | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2 | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @ShopBlog_RightRailTFN_UHC_1
    Examples: 
      | Scenario           | site | path                                                                                    | pageName       | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1 | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2 | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

  Scenario Outline: <Scenario>- To verify email form on medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user enters and validate the fields and clicks on submit

    @ShopBlog_Email_AARP_1
    Examples: 
      | Scenario           | site | path                                                                                    | pageName               | UHCUrl                      |
      | E2E Scenario 1_AMP | AARP | medicare-articles.html                                                                  | Medicare Articles Home | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html                                              | MMC page               | https://www.myuhcagent.com/ |
      | E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1         | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2         | https://www.myuhcagent.com/ |

    @ShopBlog_Email_UHC_1
    Examples: 
      | Scenario           | site | path                                                                                    | pageName               | UHCUrl                      |
      | E2E Scenario 1_UMS | UHC  | medicare-articles.html                                                                  | Medicare Articles Home | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html                                              | MMC page               | https://www.myuhcagent.com/ |
      | E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Article page 1         | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Article page 2         | https://www.myuhcagent.com/ |
