@campaignTFN @regressionAARP @campaignTFNStage
Feature: 1.19.1 UAT Scripts-To test Campaign TFN in all flows on AARP site


    Scenario Outline: <Scenario> : To verify TFN on page for the page mentioned of <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |

    @avengersRegressionAARP @featureGate @regressionAARP
    Examples:
      | Scenario           | site | path                                                | pageName                | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 3_AMP | AARP | shop/estimate/pdp-costs.html                        | Estimate PDP            | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ms.html                        | ShopPlan: Compare MS    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | true    |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP | AARP | safe-shopping.html                                  | ShopPlan: Shop          | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | contact-us.html                                     | Request more help       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | shop/estimate/ma-costs.html                         | Estimate  MA            | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | shop/renew-active.html                              | Renew Active            | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

    @avengersRegressionUHC @regressionUHC
    Examples:
      | Scenario           | site | path                                                | pageName                | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 3_UMS | UHC  | shop/estimate/pdp-costs.html                        | Estimate PDP            | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ms.html                        | ShopPlan: Compare MS    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_UMS | UHC  | safe-shopping.html                                  | ShopPlan: Shop          | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | contact-us.html                                     | Request more help       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/estimate/ma-costs.html                         | Estimate  MA            | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/renew-active.html                              | Renew Active            | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

    @avengersRegressionAARP @regressionAARP
    Examples:
      | Scenario           | site | path                                      | pageName                | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-ma.html              | Compare MA              | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-pdp.html             | Compare PDP             | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | enroll/ma-enrollment.html                 | MA Enrollment           | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | enroll/pdp-enrollment.html                | PDP Enrollment          | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                         | ShopPlan: Compare       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | E2E Scenario 5_AMP | AARP | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[6] | true    |

    @avengersRegressionUHC @regressionUHC
    Examples:
      | Scenario           | site | path                                      | pageName                | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-ma.html              | Compare MA              | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-pdp.html             | Compare PDP             | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | enroll/ma-enrollment.html                 | MA Enrollment           | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | enroll/pdp-enrollment.html                | PDP Enrollment          | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                         | ShopPlan: Compare       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | E2E Scenario 5_UMS | UHC  | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[6] | true    |

    @avengersRegressionAARP @regressionAARP
    Examples:
      | Scenario               | site | path                                | pageName                     | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_AMP     | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP     | AARP | shop/compare.html                   | ShopPlan: Compare            | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP     | AARP | enroll.html                         | ShopPlan: Enroll             | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 1_AMP | AARP | shop.html                           | ShopPlan: Shop Hub           | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP     | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | true    |
      | E2E Scenario 4_AMP     | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP     | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP     | AARP | shop/estimate.html                  | Estimate                     | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | false   |

    @avengersRegressionUHC @regressionUHC
    Examples:
      | Scenario               | site | path                                | pageName                     | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_UMS     | UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS     | UHC  | shop/compare.html                   | ShopPlan: Compare            | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_UMS     | UHC  | enroll.html                         | ShopPlan: Enroll             | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 1_UMS | UHC  | shop.html                           | ShopPlan: Shop Hub           | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_UMS     | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | true    |
      | E2E Scenario 4_UMS     | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_UMS     | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS     | UHC  | shop/estimate.html                  | Estimate                     | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | false   |


  Scenario Outline: <Scenario> To verify Global Components TFN on need help section for the page mentioned of <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates TFN on need help section of Shop pages
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |

    @avengersRegressionAARP @regressionAARP
    Examples:
      | Scenario           | site | path                                | pageName                     | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_AMP | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                   | ShopPlan: Compare            | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP | AARP | enroll.html                         | ShopPlan: Enroll             | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP | AARP | shop.html                           | ShopPlan: Shop Hub           | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | true    |
      | E2E Scenario 4_AMP | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | shop/estimate.html                  | Estimate                     | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | false   |

    @avengersRegressionUHC @regressionUHC
    Examples:
      | Scenario           | site | path                                | pageName                     | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_UMS | UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                   | ShopPlan: Compare            | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_UMS | UHC  | enroll.html                         | ShopPlan: Enroll             | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_UMS | UHC  | shop.html                           | ShopPlan: Shop Hub           | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/estimate.html                  | Estimate                     | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | false   |
  
   Scenario Outline: <Scenario>- To verify TFN on medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Medicare Education Navigation link
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |

    @avengersRegressionAARP @regressionAARP
    Examples:
      | Scenario               | site | path                                              | pageName                                | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 1_AMP | AARP | medicare-articles.html                            | Medicare Articles Home                  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 2_AMP | AARP | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html        | MMC page                                | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

    @avengersRegressionUHC @regressionUHC
    Examples:
      | Scenario               | site | path                                              | pageName                                | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 1_UMS | UHC  | medicare-articles.html                            | Medicare Articles Home                  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 2_UMS | UHC  | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html        | MMC page                                | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

    @avengersRegressionAARP @regressionAARP
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

    @avengersRegressionUHC @regressionUHC
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

    @avengersRegressionAARP @regressionAARP
    Examples:
      | Scenario           | site | path                                                  | pageName      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-costs.html                 | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/shopping-for-medicare.html          | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

    @avengersRegressionUHC @regressionUHC
    Examples:
      | Scenario           | site | path                                                  | pageName      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-costs.html                 | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/shopping-for-medicare.html          | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

Scenario Outline: <Scenario>- To verify TFN on right rail of medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Medicare Education Navigation link
    Then the user validates TFN on right rail Medicare Article
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |

    @avengersRegressionAARP @regressionAARP
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

    @avengersRegressionUHC @regressionUHC
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
  
  