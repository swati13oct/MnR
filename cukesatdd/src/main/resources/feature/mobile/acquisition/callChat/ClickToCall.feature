@acq_CALLCHAT
Feature: Verify Click to Call functionality

  @clickToCall
  Scenario Outline: To test the click to call feature on mobile
    Given the user is on <site> medicare acquisition site landing page in mobile
    Given the user navigates to following medicare acquisition site page on mobile
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user clicks on the TFN and validates the popup
      | TFNXpath | <tfnXpath> |

  @AARP_MedEd
    Examples:
      | site | path                                                     | pageName                                   | tfnXpath                                      |
      | AARP | medicare-education.html                                  | MedEd: Landing                             | //*[@class='amp']//a[contains(@class, 'tel')] |
      | AARP | medicare-education/medicare-eligibility.html             | MedEd: Eligibility                         | //*[@class='amp']//a[contains(@class, 'tel')] |
      | AARP | medicare-education/medicare-parts-and-medigap-plans.html | MedEd: Coverage Choices                    | //*[@class='amp']//a[contains(@class, 'tel')] |
      | AARP | medicare-education/medicare-benefits.html                | MedEd: Prescriptions, Providers & Benefits | //*[@class='amp']//a[contains(@class, 'tel')] |
      | AARP | medicare-education/medicare-advantage-plans.html         | MedEd: MA Plans                            | //*[@class='amp']//a[contains(@class, 'tel')] |
      | AARP | medicare-education/medicare-supplement-plans.html        | MedEd: Med Supp plans                      | //*[@class='amp']//a[contains(@class, 'tel')] |
      | AARP | medicare-education/medicare-part-d.html                  | MedEd: PDP Plans                           | //*[@class='amp']//a[contains(@class, 'tel')] |
      | AARP | medicare-education/medicare-costs.html                   | MedEd: Medicare Cost Basics                | //*[@class='amp']//a[contains(@class, 'tel')] |
      | AARP | medicare-education/enrollment-and-changing-plans.html    | MedEd: Enrollment                          | //*[@class='amp']//a[contains(@class, 'tel')] |
      | AARP | medicare-education/medicare-faq.html                     | MedEd: FAQ                                 | //*[@class='amp']//a[contains(@class, 'tel')] |

  @AARP_ShopPlan_Enroll
    Examples:
      | site | path                       | pageName                   | tfnXpath                                                       |
      | AARP | enroll/ma-enrollment.html  | ShopPlan: Enroll MA Plans  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | enroll/pdp-enrollment.html | ShopPlan: Enroll PDP Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | enroll/ms-apply.html       | ShopPlan: Enroll           | //*[contains(@class,'callus')]//div[2]//a                      |

  @AARP_deeplinks
    Examples:
      | site | path                                                                                                                                                                                                                                                                                                                          | pageName               | tfnXpath                                               |
      | AARP | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD | //a[contains(@class, 'tel')]                           |
      | AARP | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details DSNP | //a[contains(@class, 'tel')]                           |
      | AARP | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details PDP  | //a[contains(@class, 'tel')]                           |
      | AARP | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details MA   | //a[contains(@class, 'tel')]                           |
      | AARP | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    | VPP: Plan Summary      | //a[contains(@class, 'tel')]                           |
      | AARP | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | Connector Modal        | //a[contains(@href ,'tel') and contains(@class,'tel')] |
      | AARP | profile/guest                                                                                                                                                                                                                                                                                                                 | Visitor Profile: Guest | //*[contains(@class,'tel')]                            |
      | AARP | contact-us.html                                                                                                                                                                                                                                                                                                               | Footer: Contact Us     | //a[contains(@href ,'tel')]                            |

  @AARP_MedArticles
    Examples:
      | site | path                                                  | pageName                           | tfnXpath                                                       |
      | AARP | medicare-articles/medicare-costs.html                 | MedArticles: Cost                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | medicare-articles/eligibility-and-enrollment.html     | MedArticles: Eligib andEnroll      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | medicare-articles/medicare-benefits-and-coverage.html | MedArticles: Benefits and Coverage | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | medicare-articles/shopping-for-medicare.html          | MedArticles: Shop                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | medicare-articles/medicare-when-working-past-65.html  | MedArticles: Work Past 65          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | medicare-articles/medicare-tips-and-faqs.html         | MedArticles: Tips and FAQs         | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |

  @AARP_ShopPlan
    Examples:
      | site | path                                                      | pageName                        | tfnXpath                                                            |
      | AARP | shop.html                                                 | ShopPlan: Shop                  | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] |
      | AARP | shop.html                                                 | ShopPlan: Shop                  | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] |
      | AARP | shop/medicare-advantage-plans.html                        | ShopPlan: Shop MA Plan          | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1]  |
      | AARP | shop/prescription-drug-plans.html                         | ShopPlan: Shop PDP Plan         | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] |
      | AARP | shop/prescription-drug-plans.html                         | ShopPlan: Shop PDP Plan         | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])    |
      | AARP | shop/dual-special-needs-plans.html                        | ShopPlan: Shop DSNP Plan        | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] |
      | AARP | shop/dual-special-needs-plans.html                        | ShopPlan: Shop DSNP Plan        | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] |
      | AARP | shop/medicare-supplement-plans.html                       | ShopPlan: Shop Med Supp Plan    | //*[contains(@class,'callus')]//div[2]//a                           |
      | AARP | shop/medicare-supplement-plans.html                       | ShopPlan: Shop Med Supp Plan    | (//*[contains(text(),'Find a Plan')]//following::a[2])              |
      | AARP | shop/compare/compare-ms.html                              | ShopPlan: Compare               | //*[contains(@class,'callus')]//div[2]//a                           |
      | AARP | shop/estimate/ms-costs.html                               | ShopPlan: Estimate              | //*[contains(@class,'callus')]//div[2]//a                           |
      | AARP | shop/compare/compare-ma-ms.html                           | ShopPlan: Compare               | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]      |
      | AARP | safe-shopping.html                                        | ShopPlan: Shop                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]      |
      | AARP | shop/medicare-advantage-plans/wellness-discounts.html     | ShopPlan: Welness Discount      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]      |
      | AARP | shop/medicare-advantage-plans/health-care-management.html | ShopPlan: Healthcare management | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]      |
      | AARP | shop/renew-active.html                                    | ShopPlan: Renew-Active          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]      |

  @AARP_ShopPlan_Resources
    Examples:
      | site | path                                                                              | pageName                                         | tfnXpath                                                       |
      | AARP | resources/medication-therapy-management-program.html                              | ShopPlan: Resources Therapy                      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | resources/how-to-appoint-a-representative.html                                    | ShopPlan: Resources Appoint Rep                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | resources/prescription-drug-costs-help.html                                       | ShopPlan: Resources Rx cost Help                 | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | resources/healthcare-fraud.html                                                   | ShopPlan: Resources Healthcare Fraud             | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | resources/how-to-pay-your-premium.html                                            | ShopPlan: Resources Pay Premium                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | resources/pdp-resources-materials.html                                            | ShopPlan: Resources PDP Plans                    | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | resources/pdp-resources-materials/pdp-information-forms.html                      | ShopPlan: Resources PDP Plans Info               | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html | ShopPlan: Resources PDP EOB                      | //*[contains(@class,'tel')]                                    |
      | AARP | resources/prescription-drug-appeals.html                                          | ShopPlan: Resources Prescription Drug Appeal     | //*[contains(@class,'tel')]                                    |
      | AARP | resources/prescription-drug-transition.html                                       | ShopPlan: Resources Prescription Drug Transition | //*[contains(@class,'tel')]                                    |
      | AARP | resources/ma-resources-materials.html                                             | ShopPlan: Resources MA Plans                     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | resources/ma-resources-materials/ma-information-forms.html                        | ShopPlan: Resources MA Plans Info                | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | resources/ma-resources-materials/ma-information-forms/member-rights.html          | ShopPlan: Resources MA Member Rights             | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html        | ShopPlan: Resources MA Appeals                   | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | AARP | resources/disenrollment-information.html                                          | ShopPlan: Resources Disenrollment Page           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |



    #------------------------------------UHC------------------------------------------#
  @UHC_MedEd
    Examples:
      | site | path                                                     | pageName                                   | tfnXpath                                      |
      | UHC  | medicare-education.html                                  | MedEd: Landing                             | //*[@class='ums']//a[contains(@class, 'tel')] |
      | UHC  | medicare-education/medicare-eligibility.html             | MedEd: Eligibility                         | //*[@class='ums']//a[contains(@class, 'tel')] |
      | UHC  | medicare-education/medicare-parts-and-medigap-plans.html | MedEd: Coverage Choices                    | //*[@class='ums']//a[contains(@class, 'tel')] |
      | UHC  | medicare-education/medicare-benefits.html                | MedEd: Prescriptions, Providers & Benefits | //*[@class='ums']//a[contains(@class, 'tel')] |
      | UHC  | medicare-education/medicare-advantage-plans.html         | MedEd: MA Plans                            | //*[@class='ums']//a[contains(@class, 'tel')] |
      | UHC  | medicare-education/medicare-supplement-plans.html        | MedEd: Med Supp plans                      | //*[@class='ums']//a[contains(@class, 'tel')] |
      | UHC  | medicare-education/medicare-part-d.html                  | MedEd: PDP Plans                           | //*[@class='ums']//a[contains(@class, 'tel')] |
      | UHC  | medicare-education/medicare-costs.html                   | MedEd: Medicare Cost Basics                | //*[@class='ums']//a[contains(@class, 'tel')] |
      | UHC  | medicare-education/enrollment-and-changing-plans.html    | MedEd: Enrollment                          | //*[@class='ums']//a[contains(@class, 'tel')] |
      | UHC  | medicare-education/medicare-faq.html                     | MedEd: FAQ                                 | //*[@class='ums']//a[contains(@class, 'tel')] |

  @UHC_ShopPlan_Enroll
    Examples:
      | site | path                       | pageName                   | tfnXpath                                                       |
      | UHC  | enroll/ma-enrollment.html  | ShopPlan: Enroll MA Plans  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | enroll/pdp-enrollment.html | ShopPlan: Enroll PDP Plans | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | enroll/ms-apply.html       | ShopPlan: Enroll           | //*[contains(@class,'callus')]//div[2]//a                      |

  @UHC_deeplinks
    Examples:
      | site | path                                                                                                                                                                                                                                                                                                                          | pageName               | tfnXpath                                               |
      | UHC  | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H0543168000&planYear=2020&systemYear=2020&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD | //a[contains(@class, 'tel')]                           |
      | UHC  | health-plans.html?zipcode=28035&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H5253041000&planYear=2020&systemYear=2020&zipcode=28035&fipsCode=119&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details DSNP | //a[contains(@class, 'tel')]                           |
      | UHC  | health-plans.html?zipcode=55344&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=S5921370000&planYear=2020&systemYear=2020&zipcode=55344&fipsCode=053&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details PDP  | //a[contains(@class, 'tel')]                           |
      | UHC  | health-plans.html?zipcode=10011&deepLink=favPlansDeepLink&plantype=MA&year=2020&planId=H3307018000&planYear=2020&systemYear=2020&zipcode=10011&fipsCode=061&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=897749&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::897749!/details   | VPP: Plan Details MA   | //a[contains(@class, 'tel')]                           |
      | UHC  | health-plans.html?gclid=EAIaIQobChMI3PKJmZKJ3QIVBqZpCh2ROgj7EAAYAiAAEgKDjPD_BwE&mrcid=ps%253Agoogle%253Aportfolio+ma+ma%257CCofund%257CBrand%253AUHC%253A07.26.18%253A8004731&zipcode=63043&WT.mc_id=8004731!/plan-summary                                                                                                    | VPP: Plan Summary      | //a[contains(@class, 'tel')]                           |
      | UHC  | health-plans/medicare-advantage-plans/available-plans.html?WT.mc_id=897506&zipcode=96795&county=020&state=12&originatingSite=https%3A%2F%2Fwww.myuhcplans.com%2Featon&subdomain=eaton!/plan-summary                                                                                                                           | Connector Modal        | //a[contains(@href ,'tel') and contains(@class,'tel')] |
      | UHC  | profile/guest                                                                                                                                                                                                                                                                                                                 | Visitor Profile: Guest | //*[contains(@class,'tel')]                            |
      | UHC  | contact-us.html                                                                                                                                                                                                                                                                                                               | Footer: Contact Us     | //a[contains(@href ,'tel')]                            |

  @UHC_MedArticles
    Examples:
      | site | path                                                  | pageName                           | tfnXpath                                                       |
      | UHC  | medicare-articles/medicare-costs.html                 | MedArticles: Cost                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | medicare-articles/eligibility-and-enrollment.html     | MedArticles: Eligib andEnroll      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | medicare-articles/medicare-benefits-and-coverage.html | MedArticles: Benefits and Coverage | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | medicare-articles/shopping-for-medicare.html          | MedArticles: Shop                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | medicare-articles/medicare-when-working-past-65.html  | MedArticles: Work Past 65          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | medicare-articles/medicare-tips-and-faqs.html         | MedArticles: Tips and FAQs         | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |

  @UHC_ShopPlan
    Examples:
      | site | path                                                      | pageName                        | tfnXpath                                                            |
      | UHC  | shop.html                                                 | ShopPlan: Shop                  | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] |
      | UHC  | shop.html                                                 | ShopPlan: Shop                  | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] |
      | UHC  | shop/medicare-advantage-plans.html                        | ShopPlan: Shop MA Plan          | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1]  |
      | UHC  | shop/prescription-drug-plans.html                         | ShopPlan: Shop PDP Plan         | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] |
      | UHC  | shop/prescription-drug-plans.html                         | ShopPlan: Shop PDP Plan         | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])    |
      | UHC  | shop/dual-special-needs-plans.html                        | ShopPlan: Shop DSNP Plan        | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[1] |
      | UHC  | shop/dual-special-needs-plans.html                        | ShopPlan: Shop DSNP Plan        | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] |
      | UHC  | shop/medicare-supplement-plans.html                       | ShopPlan: Shop Med Supp Plan    | //*[contains(@class,'callus')]//div[2]//a                           |
      | UHC  | shop/medicare-supplement-plans.html                       | ShopPlan: Shop Med Supp Plan    | (//*[contains(text(),'Find a Plan')]//following::a[2])              |
      | UHC  | shop/compare/compare-ms.html                              | ShopPlan: Compare               | //*[contains(@class,'callus')]//div[2]//a                           |
      | UHC  | shop/estimate/ms-costs.html                               | ShopPlan: Estimate              | //*[contains(@class,'callus')]//div[2]//a                           |
      | UHC  | shop/compare/compare-ma-ms.html                           | ShopPlan: Compare               | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]      |
      | UHC  | safe-shopping.html                                        | ShopPlan: Shop                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]      |
      | UHC  | shop/medicare-advantage-plans/wellness-discounts.html     | ShopPlan: Welness Discount      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]      |
      | UHC  | shop/medicare-advantage-plans/health-care-management.html | ShopPlan: Healthcare management | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]      |
      | UHC  | shop/renew-active.html                                    | ShopPlan: Renew-Active          | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')]      |

  @UHC_ShopPlan_Resources
    Examples:
      | site | path                                                                              | pageName                                         | tfnXpath                                                       |
      | UHC  | resources/medication-therapy-management-program.html                              | ShopPlan: Resources Therapy                      | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | resources/how-to-appoint-a-representative.html                                    | ShopPlan: Resources Appoint Rep                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | resources/prescription-drug-costs-help.html                                       | ShopPlan: Resources Rx cost Help                 | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | resources/healthcare-fraud.html                                                   | ShopPlan: Resources Healthcare Fraud             | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | resources/how-to-pay-your-premium.html                                            | ShopPlan: Resources Pay Premium                  | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | resources/pdp-resources-materials.html                                            | ShopPlan: Resources PDP Plans                    | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | resources/pdp-resources-materials/pdp-information-forms.html                      | ShopPlan: Resources PDP Plans Info               | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | resources/pdp-resources-materials/pdp-information-forms/explanation-benefits.html | ShopPlan: Resources PDP EOB                      | //*[contains(@class,'tel')]                                    |
      | UHC  | resources/prescription-drug-appeals.html                                          | ShopPlan: Resources Prescription Drug Appeal     | //*[contains(@class,'tel')]                                    |
      | UHC  | resources/prescription-drug-transition.html                                       | ShopPlan: Resources Prescription Drug Transition | //*[contains(@class,'tel')]                                    |
      | UHC  | resources/ma-resources-materials.html                                             | ShopPlan: Resources MA Plans                     | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | resources/ma-resources-materials/ma-information-forms.html                        | ShopPlan: Resources MA Plans Info                | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | resources/ma-resources-materials/ma-information-forms/member-rights.html          | ShopPlan: Resources MA Member Rights             | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | resources/ma-resources-materials/ma-information-forms/medicare-appeal.html        | ShopPlan: Resources MA Appeals                   | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
      | UHC  | resources/disenrollment-information.html                                          | ShopPlan: Resources Disenrollment Page           | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] |
