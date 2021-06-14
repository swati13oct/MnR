@globalComponent @samIcons
Feature: 1.15 ACQ M&R- To test SAM Icons

  Scenario Outline: 1.19.1.4 To test the SAM icons on Acq site on <site> <pagename>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And user opens the page to validate M&R Sites
      | pagename | <pagename> |
    Then the user validates whether call icon is visible
    #Then the user validates whether chat icon is visible on UHC
    Then the user validates whether chat icon is visible

    @samChatRegressionAARP1
    Examples: 
      | pagename                                                   | site |
      | /                                                          | AARP |
      | medicare-education/medicare-eligibility.html               | AARP |
      | medicare-education/medicare-parts-and-medigap-plans.html   | AARP |
      | medicare-education/medicare-benefits.html                  | AARP |
      | medicare-education/medicare-advantage-plans.html           | AARP |
      | medicare-education/medicare-supplement-plans.html          | AARP |
      | medicare-education/medicare-part-d.html                    | AARP |
      | medicare-education/medicare-costs.html                     | AARP |
      | medicare-education/when-to-enroll.html                     | AARP |
      | medicare-education/medicare-faq.html                       | AARP |
      | medicare-education.html                                    | AARP |
      | medicare-education/medicare-medicaid-dual-eligibility.html | AARP |
      | medicare-education/extra-help-program.html                 | AARP |

    @samChatRegressionAARP2
    Examples: 
      | pagename                                                  | site |
      | shop.html                                                 | AARP |
      | shop/connect                                              | AARP |
      | shop/compare.html                                         | AARP |
      | shop/estimate.html                                        | AARP |
      | shop/switch.html                                          | AARP |
      | shop/medicare-advantage-plans.html                        | AARP |
      | shop/medicare-supplement-plans.html                       | AARP |
      | shop/prescription-drug-plans.html                         | AARP |
      | shop/dual-special-needs-plans.html                        | AARP |
      | safe-shopping.html                                        | AARP |
      | shop/compare/compare-pdp.html                             | AARP |
      | shop/compare/compare-ma.html                              | AARP |
      | shop/estimate/ma-costs.html                               | AARP |
      | shop/estimate/pdp-costs.html                              | AARP |
      | shop/medicare-advantage-plans/wellness-discounts.html     | AARP |
      | shop/medicare-advantage-plans/health-care-management.html | AARP |
      | shop/medicare-advantage-plans/ma-plan-benefits.html       | AARP |
      | shop/renew-active.html                                    | AARP |
      | shop/medicare-advantage-veteran-plan.html                 | AARP |
      | shop/estimate/ms-costs.html                               | AARP |
      | shop/compare/compare-ma-ms.html                           | AARP |
      | shop/compare/compare-ms.html                              | AARP |
      | enroll.html                                               | AARP |
      | enroll/ma-enrollment.html                                 | AARP |
      | enroll/pdp-enrollment.html                                | AARP |
      | enroll/ms-apply.html                                      | AARP |

    @samChatRegressionAARP3
    Examples: 
      | pagename                                                     | site |
      | resources.html                                               | AARP |
      | resources/medication-therapy-management-program.html         | AARP |
      | resources/how-to-appoint-a-representative.html               | AARP |
      | resources/prescription-drug-costs-help.html                  | AARP |
      | resources/healthcare-fraud.html                              | AARP |
      | resources/how-to-pay-your-premium.html                       | AARP |
      | resources/mail-order-pharmacy.html                           | AARP |
      | resources/prescription-drug-appeals.html                     | AARP |
      | resources/prescription-drug-transition.html                  | AARP |
      | resources/disenrollment-information.html                     | AARP |
      | resources/ma-pdp-information-forms.html                      | AARP |
      | resources/ma-pdp-information-forms/member-rights.html        | AARP |
      | resources/ma-pdp-information-forms/medicare-appeal.html      | AARP |
      | resources/ma-pdp-information-forms/explanation-benefits.html | AARP |

    @samChatRegressionAARP4
    Examples: 
      | pagename                                                                                                                                                                                                                                                                                                                      | site |
      | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | AARP |
      | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | AARP |
      | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | AARP |
      | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | AARP |
      | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    | AARP |
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | AARP |
      | profile/guest                                                                                                                                                                                                                                                                                                                 | AARP |
      | about-us.html                                                                                                                                                                                                                                                                                                                 | AARP |
      | sitemap.html                                                                                                                                                                                                                                                                                                                  | AARP |
      | terms-of-use.html                                                                                                                                                                                                                                                                                                             | AARP |
      | disclaimer.html                                                                                                                                                                                                                                                                                                               | AARP |
      | contact-us.html                                                                                                                                                                                                                                                                                                               | AARP |
      | privacy-policy.html                                                                                                                                                                                                                                                                                                           | AARP |

    @samChatRegressionUHC1
    Examples: 
      | pagename                                                   | site |
      | /                                                          | UHC  |
      | medicare-education/medicare-eligibility.html               | UHC  |
      | medicare-education/medicare-parts-and-medigap-plans.html   | UHC  |
      | medicare-education/medicare-benefits.html                  | UHC  |
      | medicare-education/medicare-advantage-plans.html           | UHC  |
      | medicare-education/medicare-supplement-plans.html          | UHC  |
      | medicare-education/medicare-part-d.html                    | UHC  |
      | medicare-education/medicare-costs.html                     | UHC  |
      | medicare-education/when-to-enroll.html                     | UHC  |
      | medicare-education/medicare-faq.html                       | UHC  |
      | medicare-education.html                                    | UHC  |
      | medicare-education/medicare-medicaid-dual-eligibility.html | UHC  |
      | medicare-education/extra-help-program.html                 | UHC  |

    @samChatRegressionUHC2
    Examples: 
      | pagename                                                  | site |
      | shop.html                                                 | UHC  |
      | shop/connect                                              | UHC  |
      | shop/compare.html                                         | UHC  |
      | shop/estimate.html                                        | UHC  |
      | shop/switch.html                                          | UHC  |
      | shop/medicare-advantage-plans.html                        | UHC  |
      | shop/medicare-supplement-plans.html                       | UHC  |
      | shop/prescription-drug-plans.html                         | UHC  |
      | shop/dual-special-needs-plans.html                        | UHC  |
      | safe-shopping.html                                        | UHC  |
      | shop/compare/compare-pdp.html                             | UHC  |
      | shop/compare/compare-ma.html                              | UHC  |
      | shop/estimate/ma-costs.html                               | UHC  |
      | shop/estimate/pdp-costs.html                              | UHC  |
      | shop/medicare-advantage-plans/wellness-discounts.html     | UHC  |
      | shop/medicare-advantage-plans/health-care-management.html | UHC  |
      | shop/medicare-advantage-plans/ma-plan-benefits.html       | UHC  |
      | shop/renew-active.html                                    | UHC  |
      | shop/medicare-advantage-veteran-plan.html                 | UHC  |
      | shop/estimate/ms-costs.html                               | UHC  |
      | shop/compare/compare-ma-ms.html                           | UHC  |
      | shop/compare/compare-ms.html                              | UHC  |
      | enroll.html                                               | UHC  |
      | enroll/ma-enrollment.html                                 | UHC  |
      | enroll/pdp-enrollment.html                                | UHC  |
      | enroll/ms-apply.html                                      | UHC  |

    @samChatRegressionUHC3
    Examples: 
      | pagename                                                     | site |
      | resources.html                                               | UHC  |
      | resources/medication-therapy-management-program.html         | UHC  |
      | resources/how-to-appoint-a-representative.html               | UHC  |
      | resources/prescription-drug-costs-help.html                  | UHC  |
      | resources/healthcare-fraud.html                              | UHC  |
      | resources/how-to-pay-your-premium.html                       | UHC  |
      | resources/mail-order-pharmacy.html                           | UHC  |
      | resources/prescription-drug-appeals.html                     | UHC  |
      | resources/prescription-drug-transition.html                  | UHC  |
      | resources/disenrollment-information.html                     | UHC  |
      | resources/ma-pdp-information-forms/member-rights.html        | UHC  |
      | resources/ma-pdp-information-forms/medicare-appeal.html      | UHC  |
      | resources/ma-pdp-information-forms/explanation-benefits.html | UHC  |
      | resources/ma-pdp-information-forms.html                      | UHC  |

    @samChatRegressionUHC4
    Examples: 
      | pagename                                                                                                                                                                                                                                                                                                                      | site |
      | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | UHC  |
      | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | UHC  |
      | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | UHC  |
      | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | UHC  |
      | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    | UHC  |
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | UHC  |
      | profile/guest                                                                                                                                                                                                                                                                                                                 | UHC  |
      | about-us.html                                                                                                                                                                                                                                                                                                                 | UHC  |
      | sitemap.html                                                                                                                                                                                                                                                                                                                  | UHC  |
      | terms-of-use.html                                                                                                                                                                                                                                                                                                             | UHC  |
      | disclaimer.html                                                                                                                                                                                                                                                                                                               | UHC  |
      | contact-us.html                                                                                                                                                                                                                                                                                                               | UHC  |
      | privacy-policy.html                                                                                                                                                                                                                                                                                                           | UHC  |

    #############Updated for Regression Suite Team  #################################
    @samChatRegressionAARP7
    Examples: 
      | pagename                                                 | site |
      | /                                                        | AARP |
      | medicare-education/medicare-eligibility.html             | AARP |
      | medicare-education/medicare-parts-and-medigap-plans.html | AARP |
      | medicare-education/medicare-benefits.html                | AARP |
      | medicare-education/medicare-advantage-plans.html         | AARP |
      | medicare-education/medicare-supplement-plans.html        | AARP |
      | medicare-education/medicare-part-d.html                  | AARP |
      | medicare-education/medicare-costs.html                   | AARP |
      | medicare-education/when-to-enroll.html                   | AARP |
      | medicare-education/medicare-faq.html                     | AARP |

    @samChatRegressionAARP8
    Examples: 
      | pagename                            | site |
      | shop.html                           | AARP |
      | shop/connect                        | AARP |
      #   | shop/compare.html  | AARP|
      | shop/estimate.html                  | AARP |
      | shop/switch.html                    | AARP |
      | shop/medicare-advantage-plans.html  | AARP |
      | shop/medicare-supplement-plans.html | AARP |
      | shop/prescription-drug-plans.html   | AARP |
      | shop/dual-special-needs-plans.html  | AARP |

    @samChatRegressionAARP9
    Examples: 
      | pagename                                             | site |
      | enroll.html                                          | AARP |
      | enroll/ma-enrollment.html                            | AARP |
      | enroll/pdp-enrollment.html                           | AARP |
      #  | resources.html                                       |AARP|
      | resources/medication-therapy-management-program.html | AARP |
      | resources/how-to-appoint-a-representative.html       | AARP |
      | resources/prescription-drug-costs-help.html          | AARP |
      | resources/healthcare-fraud.html                      | AARP |
      | resources/how-to-pay-your-premium.html               | AARP |
      | resources/disenrollment-information.html             | AARP |

    @samChatRegressionAARP10
    Examples: 
      | pagename                                                                                                                                                                                                                                                                                                                      | site |
      | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | AARP |
      | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | AARP |
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | AARP |

    @samChatRegressionAARP11
    Examples: 
      | pagename            | site |
      | profile/guest       | AARP |
      | about-us.html       | AARP |
      | sitemap.html        | AARP |
      | terms-of-use.html   | AARP |
      | disclaimer.html     | AARP |
      | contact-us.html     | AARP |
      | privacy-policy.html | AARP |

    @samChatRegressionAARP12
    Examples: 
      | pagename                                          | site |
      | medicare-articles.html                            | AARP |
      | medicare-articles/medicare-made-clear.html        | AARP |
      | medicare-articles/eligibility-and-enrollment.html | AARP |
      # |medicare-articles/medicare-benefits-and-coverage.html  |AARP|
      | medicare-articles/medicare-costs.html             | AARP |

    #  |medicare-articles/shopping-for-medicare.html           |AARP|
    #  |medicare-articles/medicare-when-working-past-65.html   |AARP|
    @samChatRegressionUHC7
    Examples: 
      | pagename                                                 | site |
      | /                                                        | UHC  |
      | medicare-education/medicare-eligibility.html             | UHC  |
      | medicare-education/medicare-parts-and-medigap-plans.html | UHC  |
      | medicare-education/medicare-benefits.html                | UHC  |
      | medicare-education/medicare-advantage-plans.html         | UHC  |
      | medicare-education/medicare-supplement-plans.html        | UHC  |
      | medicare-education/medicare-part-d.html                  | UHC  |
      | medicare-education/medicare-costs.html                   | UHC  |
      | medicare-education/when-to-enroll.html                   | UHC  |
      | medicare-education/medicare-faq.html                     | UHC  |

    @samChatRegressionUHC8
    Examples: 
      | pagename                            | site |
      | shop.html                           | UHC  |
      | shop/connect                        | UHC  |
      # | shop/compare.html  | UHC|
      | shop/estimate.html                  | UHC  |
      #  | shop/switch.html   |  UHC|
      | shop/medicare-advantage-plans.html  | UHC  |
      | shop/medicare-supplement-plans.html | UHC  |
      | shop/prescription-drug-plans.html   | UHC  |
      | shop/dual-special-needs-plans.html  | UHC  |

    @samChatRegressionUHC9
    Examples: 
      | pagename                                             | site |
      | enroll.html                                          | UHC  |
      | enroll/ma-enrollment.html                            | UHC  |
      | enroll/pdp-enrollment.html                           | UHC  |
      #  | resources.html                                       |UHC|
      | resources/medication-therapy-management-program.html | UHC  |
      | resources/how-to-appoint-a-representative.html       | UHC  |
      | resources/prescription-drug-costs-help.html          | UHC  |
      | resources/healthcare-fraud.html                      | UHC  |
      | resources/how-to-pay-your-premium.html               | UHC  |
      | resources/disenrollment-information.html             | UHC  |

    @samChatRegressionUHC10
    Examples: 
      | pagename                                                                                                                                                                                                                                                                                                                      | site |
      | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | UHC  |
      | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | UHC  |
      | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | UHC  |

    @samChatRegressionUHC11
    Examples: 
      | pagename            | site |
      | profile/guest       | UHC  |
      | about-us.html       | UHC  |
      | sitemap.html        | UHC  |
      | terms-of-use.html   | UHC  |
      | disclaimer.html     | UHC  |
      | contact-us.html     | UHC  |
      | privacy-policy.html | UHC  |

    @samChatRegressionUHC12
    Examples: 
      | pagename                                          | site |
      | medicare-articles.html                            | UHC  |
      | medicare-articles/medicare-made-clear.html        | UHC  |
      | medicare-articles/eligibility-and-enrollment.html | UHC  |
      #  |medicare-articles/medicare-benefits-and-coverage.html  |UHC|
      | medicare-articles/medicare-costs.html             | UHC  |
