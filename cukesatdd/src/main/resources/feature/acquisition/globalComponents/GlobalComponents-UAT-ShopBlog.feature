@UATRegression @F448210 @globalComponent
Feature: 1.13 UAT - Shop Blog Pages flows

  @GlobalComponentsAARPShopPages
  Scenario Outline: To verify Zip code and Agent link for the page mentioned of <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validate ZipCode Components on page using ZipCode "55410"
    When the user clicks on Agent link and validates the correct URL is loaded from article page
      | UHC Agent URL | <UHCUrl> |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                                | pageName                | UHCUrl                      |
      | E2E Scenario 3_AMP | AARP | shop/estimate/pdp-costs.html                        | Estimate PDP            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ms.html                        | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | safe-shopping.html                                  | ShopPlan: Shop          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | contact-us.html                                     | Request more help       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/estimate/ma-costs.html                         | Estimate  MA            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/renew-active.html                              | Renew Active            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                                | pageName                | UHCUrl                      |
      | E2E Scenario 3_UMS | UHC  | shop/estimate/pdp-costs.html                        | Estimate PDP            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | contact-us.html                                     | Request more help       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/renew-active.html                              | Renew Active            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/estimate/ma-costs.html                         | Estimate  MA            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ms.html                        | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | safe-shopping.html                                  | ShopPlan: Shop          | https://www.myuhcagent.com/ |

    @avengersRegressionAARP @regressionAARP
    Examples:
      | Scenario           | site | path                                      | pageName                | UHCUrl                      |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-ma.html              | Compare MA              | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-pdp.html             | Compare PDP             | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/ma-enrollment.html                 | MA Enrollment           | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/pdp-enrollment.html                | PDP Enrollment          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                         | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | https://www.myuhcagent.com/ |

    @avengersRegressionUHC @regressionUHC
    Examples:
      | Scenario           | site | path                                      | pageName                | UHCUrl                      |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-ma.html              | Compare MA              | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-pdp.html             | Compare PDP             | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/ma-enrollment.html                 | MA Enrollment           | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/pdp-enrollment.html                | PDP Enrollment          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                         | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | https://www.myuhcagent.com/ |


  Scenario Outline: To verify TFN on page for the page mentioned of <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates TFN on page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                                | pageName                | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 3_AMP | AARP | shop/estimate/pdp-costs.html                        | Estimate PDP            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ms.html                        | ShopPlan: Compare       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[2] | true    |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_AMP | AARP | safe-shopping.html                                  | ShopPlan: Shop          | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | contact-us.html                                     | Request more help       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | shop/estimate/ma-costs.html                         | Estimate  MA            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | shop/renew-active.html                              | Renew Active            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                                | pageName                | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 3_UMS | UHC  | shop/estimate/pdp-costs.html                        | Estimate PDP            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | contact-us.html                                     | Request more help       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/renew-active.html                              | Renew Active            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/estimate/ma-costs.html                         | Estimate  MA            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ms.html                        | ShopPlan: Compare       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[2] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_UMS | UHC  | safe-shopping.html                                  | ShopPlan: Shop          | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                      | pageName                | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-ma.html              | Compare MA              | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-pdp.html             | Compare PDP             | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | enroll/ma-enrollment.html                 | MA Enrollment           | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | enroll/pdp-enrollment.html                | PDP Enrollment          | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                         | ShopPlan: Compare       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | E2E Scenario 5_AMP | AARP | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[6] | true    |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                      | pageName                | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-ma.html              | Compare MA              | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-pdp.html             | Compare PDP             | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | enroll/ma-enrollment.html                 | MA Enrollment           | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | enroll/pdp-enrollment.html                | PDP Enrollment          | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                         | ShopPlan: Compare       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | E2E Scenario 5_UMS | UHC  | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[6] | true    |

    @avengersRegressionAARP
    Examples:
      | Scenario               | site | path                                | pageName                     | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_AMP     | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | E2E Scenario 5_AMP     | AARP | shop/compare.html                   | ShopPlan: Compare            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | E2E Scenario 4_AMP     | AARP | enroll.html                         | ShopPlan: Enroll             | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | UAT E2E Scenario 1_AMP | AARP | shop.html                           | ShopPlan: Shop Hub           | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | E2E Scenario 4_AMP     | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[6] | true    |
      | E2E Scenario 4_AMP     | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | E2E Scenario 4_AMP     | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | E2E Scenario 5_AMP     | AARP | shop/estimate.html                  | Estimate                     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | false   |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                | pageName                     | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_UMS     | UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | E2E Scenario 4_UMS     | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[6] | true    |
      | E2E Scenario 4_UMS     | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | E2E Scenario 4_UMS     | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | E2E Scenario 5_UMS     | UHC  | shop/compare.html                   | ShopPlan: Compare            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | E2E Scenario 4_UMS     | UHC  | enroll.html                         | ShopPlan: Enroll             | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | UAT E2E Scenario 1_UMS | UHC  | shop.html                           | ShopPlan: Shop Hub           | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | E2E Scenario 5_UMS     | UHC  | shop/estimate.html                  | Estimate                     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | false   |


  Scenario Outline: To verify proactive chat popup for the page mentioned of <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates proactive chat popup

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                                | pageName                | UHCUrl                      |
      | E2E Scenario 3_AMP | AARP | shop/estimate/pdp-costs.html                        | Estimate PDP            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ms.html                        | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | safe-shopping.html                                  | ShopPlan: Shop          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | contact-us.html                                     | Request more help       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/estimate/ma-costs.html                         | Estimate  MA            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/renew-active.html                              | Renew Active            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                                | pageName                | UHCUrl                      |
      | E2E Scenario 3_UMS | UHC  | shop/estimate/pdp-costs.html                        | Estimate PDP            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | contact-us.html                                     | Request more help       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/renew-active.html                              | Renew Active            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/estimate/ma-costs.html                         | Estimate  MA            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ms.html                        | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | safe-shopping.html                                  | ShopPlan: Shop          | https://www.myuhcagent.com/ |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                      | pageName                | UHCUrl                      |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-ma.html              | Compare MA              | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-pdp.html             | Compare PDP             | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/ma-enrollment.html                 | MA Enrollment           | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/pdp-enrollment.html                | PDP Enrollment          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                         | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                      | pageName                | UHCUrl                      |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-ma.html              | Compare MA              | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-pdp.html             | Compare PDP             | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/ma-enrollment.html                 | MA Enrollment           | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/pdp-enrollment.html                | PDP Enrollment          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                         | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | https://www.myuhcagent.com/ |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                | pageName                     | UHCUrl                      |
      | E2E Scenario 2_AMP | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                   | ShopPlan: Compare            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | enroll.html                         | ShopPlan: Enroll             | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop.html                           | ShopPlan: Shop Hub           | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/estimate.html                  | Estimate                     | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                | pageName                     | UHCUrl                      |
      | E2E Scenario 2_UMS | UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                   | ShopPlan: Compare            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | enroll.html                         | ShopPlan: Enroll             | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop.html                           | ShopPlan: Shop Hub           | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/estimate.html                  | Estimate                     | https://www.myuhcagent.com/ |


  Scenario Outline: To verify Global Components chat icon for the page mentioned of <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates whether chat icon is visible

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                                | pageName                | UHCUrl                      |
      | E2E Scenario 3_AMP | AARP | shop/estimate/pdp-costs.html                        | Estimate PDP            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ms.html                        | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | safe-shopping.html                                  | ShopPlan: Shop          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | contact-us.html                                     | Request more help       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/estimate/ma-costs.html                         | Estimate  MA            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/renew-active.html                              | Renew Active            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                                | pageName                | UHCUrl                      |
      | E2E Scenario 3_UMS | UHC  | shop/estimate/pdp-costs.html                        | Estimate PDP            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | contact-us.html                                     | Request more help       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/renew-active.html                              | Renew Active            | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/estimate/ma-costs.html                         | Estimate  MA            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ms.html                        | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | safe-shopping.html                                  | ShopPlan: Shop          | https://www.myuhcagent.com/ |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                      | pageName                | UHCUrl                      |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-ma.html              | Compare MA              | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-pdp.html             | Compare PDP             | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/ma-enrollment.html                 | MA Enrollment           | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/pdp-enrollment.html                | PDP Enrollment          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                         | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                      | pageName                | UHCUrl                      |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-ma.html              | Compare MA              | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-pdp.html             | Compare PDP             | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/ma-enrollment.html                 | MA Enrollment           | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/pdp-enrollment.html                | PDP Enrollment          | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                         | ShopPlan: Compare       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | https://www.myuhcagent.com/ |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                | pageName                     | UHCUrl                      |
      | E2E Scenario 2_AMP | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                   | ShopPlan: Compare            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | enroll.html                         | ShopPlan: Enroll             | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop.html                           | ShopPlan: Shop Hub           | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | shop/estimate.html                  | Estimate                     | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                | pageName                     | UHCUrl                      |
      | E2E Scenario 2_UMS | UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                   | ShopPlan: Compare            | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | enroll.html                         | ShopPlan: Enroll             | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | shop.html                           | ShopPlan: Shop Hub           | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | shop/estimate.html                  | Estimate                     | https://www.myuhcagent.com/ |


  Scenario Outline: To verify Global Components TFN on need help section for the page mentioned of <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates TFN on need help section of Shop pages
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                | pageName                     | UHCUrl                      | tfnXpath                                                           | tfnFlag | hoursxpath                                                                   | hoursFlag |
      | E2E Scenario 2_AMP | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                   | ShopPlan: Compare            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 4_AMP | AARP | enroll.html                         | ShopPlan: Enroll             | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 4_AMP | AARP | shop.html                           | ShopPlan: Shop Hub           | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 4_AMP | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[2] | true    | (//div[contains(@ng-show,'medSupTfn')])[1]//p                                | true      |
      | E2E Scenario 4_AMP | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 4_AMP | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |
      | E2E Scenario 5_AMP | AARP | shop/estimate.html                  | Estimate                     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | false   | (//div[contains(@ng-show,'fedTfn') or contains(@ng-show,'medSupTfn')])[1]//p | true      |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                | pageName                     | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_UMS | UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[2] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_UMS | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                   | ShopPlan: Compare            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_UMS | UHC  | enroll.html                         | ShopPlan: Enroll             | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 4_UMS | UHC  | shop.html                           | ShopPlan: Shop Hub           | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/estimate.html                  | Estimate                     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | false   |


  Scenario Outline: <Scenario>- To verify Zip code and agent link on medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Medicare Education Navigation link
    Then the user validate ZipCode Components on page using ZipCode "55424"
    When the user clicks on Agent link and validates the correct URL is loaded from article page
      | UHC Agent URL | <UHCUrl> |


    @avengersRegressionAARP
    Examples:
      | Scenario               | site | path                                              | pageName                                | UHCUrl                      |
      | UAT E2E Scenario 1_AMP | AARP | medicare-articles.html                            | Medicare Articles Home                  | https://www.myuhcagent.com/ |
      | UAT E2E Scenario 2_AMP | AARP | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page | https://www.myuhcagent.com/ |
      | UAT E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html        | MMC page                                | https://www.myuhcagent.com/ |

    #@BlogPages_GlobalCompsUHC
    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                              | pageName                                | UHCUrl                      |
      | UAT E2E Scenario 1_UMS | UHC  | medicare-articles.html                            | Medicare Articles Home                  | https://www.myuhcagent.com/ |
      | UAT E2E Scenario 2_UMS | UHC  | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page | https://www.myuhcagent.com/ |
      | UAT E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html        | MMC page                                | https://www.myuhcagent.com/ |

    #@BlogPages_GlobalCompsAARP
    @avengersRegressionAARP
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | UHCUrl                      |
      | UAT E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | https://www.myuhcagent.com/ |
      | UAT E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | https://www.myuhcagent.com/ |

    #@BlogPages_GlobalCompsUHC
    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | UHCUrl                      |
      | UAT E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | https://www.myuhcagent.com/ |
      | UAT E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | https://www.myuhcagent.com/ |

    #@BlogPages_GlobalCompsAARP
    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |

    #@BlogPages_GlobalCompsUHC
    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |


  Scenario Outline: <Scenario>- To verify TFN on medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Medicare Education Navigation link
    Then the user validates TFN on page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |

    @avengersRegressionAARP
    Examples:
      | Scenario               | site | path                                              | pageName                                | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 1_AMP | AARP | medicare-articles.html                            | Medicare Articles Home                  | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | UAT E2E Scenario 2_AMP | AARP | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | UAT E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html        | MMC page                                | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                              | pageName                                | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 1_UMS | UHC  | medicare-articles.html                            | Medicare Articles Home                  | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | UAT E2E Scenario 2_UMS | UHC  | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | UAT E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html        | MMC page                                | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @avengersRegressionAARP
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | UAT E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | UAT E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |


  Scenario Outline: <Scenario>- To verify proactive chat popup on medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Medicare Education Navigation link
    Then the user validates proactive chat popup

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                              | pageName                                | UHCUrl                      |
      | E2E Scenario 1_AMP | AARP | medicare-articles.html                            | Medicare Articles Home                  | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page | https://www.myuhcagent.com/ |
      | E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html        | MMC page                                | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                              | pageName                                | UHCUrl                      |
      | E2E Scenario 1_UMS | UHC  | medicare-articles.html                            | Medicare Articles Home                  | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html        | MMC page                                | https://www.myuhcagent.com/ |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                                                                    | pageName                | UHCUrl                      |
      | E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                                                                    | pageName                | UHCUrl                      |
      | E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | https://www.myuhcagent.com/ |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |


  Scenario Outline: <Scenario>- To verify chat icon on medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Medicare Education Navigation link
    Then the user validates whether chat icon is visible

    @avengersRegressionAARP
    Examples:
      | Scenario            | site | path                                              | pageName                                | UHCUrl                      |
      | E2E Scenario 1_AMP  | AARP | medicare-articles.html                            | Medicare Articles Home                  | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP  | AARP | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page | https://www.myuhcagent.com/ |
      | E2E hScenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html        | MMC page                                | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                              | pageName                                | UHCUrl                      |
      | E2E Scenario 1_UMS | UHC  | medicare-articles.html                            | Medicare Articles Home                  | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | UHC  | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page | https://www.myuhcagent.com/ |
      | E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html        | MMC page                                | https://www.myuhcagent.com/ |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                                                                    | pageName                | UHCUrl                      |
      | E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | https://www.myuhcagent.com/ |
      | E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                                                                    | pageName                | UHCUrl                      |
      | E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | https://www.myuhcagent.com/ |
      | E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | https://www.myuhcagent.com/ |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |


  Scenario Outline: <Scenario>- To verify call icon on medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Medicare Education Navigation link
    Then the user validates whether call icon is visible

    @avengersRegressionAARP
    Examples:
      | Scenario               | site | path                                              | pageName                                | UHCUrl                      |
      | UAT E2E Scenario 1_AMP | AARP | medicare-articles.html                            | Medicare Articles Home                  | https://www.myuhcagent.com/ |
      | UAT E2E Scenario 2_AMP | AARP | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page | https://www.myuhcagent.com/ |
      | UAT E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html        | MMC page                                | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                              | pageName                                | UHCUrl                      |
      | UAT E2E Scenario 1_UMS | UHC  | medicare-articles.html                            | Medicare Articles Home                  | https://www.myuhcagent.com/ |
      | UAT E2E Scenario 2_UMS | UHC  | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page | https://www.myuhcagent.com/ |
      | UAT E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html        | MMC page                                | https://www.myuhcagent.com/ |

    @avengersRegressionAARP
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | UHCUrl                      |
      | UAT E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | https://www.myuhcagent.com/ |
      | UAT E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | UHCUrl                      |
      | UAT E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | https://www.myuhcagent.com/ |
      | UAT E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | https://www.myuhcagent.com/ |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                                  | pageName      | UHCUrl                      |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-costs.html                 | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/shopping-for-medicare.html          | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page | https://www.myuhcagent.com/ |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page | https://www.myuhcagent.com/ |


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

    @avengersRegressionAARP
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | UAT E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |
      | UAT E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |


  Scenario Outline: <Scenario>- To verify email on medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Medicare Education Navigation link
    Then the user enters and validate the fields and clicks on submit

    @avengersRegressionAARP
    Examples:
      | Scenario               | site | path                                       | pageName               | UHCUrl                      |
      | UAT E2E Scenario 1_AMP | AARP | medicare-articles.html                     | Medicare Articles Home | https://www.myuhcagent.com/ |
      | UAT E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html | MMC page               | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                       | pageName               | UHCUrl                      |
      | UAT E2E Scenario 1_UMS | UHC  | medicare-articles.html                     | Medicare Articles Home | https://www.myuhcagent.com/ |
      | UAT E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html | MMC page               | https://www.myuhcagent.com/ |

    @avengersRegressionAARP
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | UHCUrl                      |
      | UAT E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | https://www.myuhcagent.com/ |
      | UAT E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | UHCUrl                      |
      | UAT E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | https://www.myuhcagent.com/ |
      | UAT E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | https://www.myuhcagent.com/ |


  Scenario Outline: <Scenario>- To verify PRE flow on medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user click on Get a Plan Recommendation Button and gets back to medicare articles page

    @avengersRegressionAARP @featurePass
    Examples:
      | Scenario               | site | path                                              | pageName                                |
      | UAT E2E Scenario 2_AMP | AARP | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page |
    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                              | pageName                                |
      | UAT E2E Scenario 2_AMP | UHC  | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page |


  Scenario Outline: <Scenario>- To verify 3 Pack CTA page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validate ZipCode Components on page using ZipCode "55424"
    When the user clicks on Agent link and validates the correct URL is loaded from article page
      | UHC Agent URL | <UHCUrl> |


    @avengersRegressionAARP
    Examples:
      | Scenario                           | site | path                                                | pageName                   | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | UAT E2E Regression Scenario 1_AARP | AARP | shop.html                                           | Shop Hub Page              | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | UAT E2E Regression Scenario 2_AARP | AARP | shop/medicare-advantage-plans.html                  | Shop MA Plans Page         | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | UAT E2E Regression Scenario 3_AARP | AARP | shop/dual-special-needs-plans.html                  | Shop DSNP Plans Page e     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | UAT E2E Regression Scenario 4_AARP | AARP | enroll.html                                         | Enroll Page                | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | Avengers AARP                      | AARP | /medicare-education/medicare-coverage-examples.html | Medicare Coverage Examples | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

    @avengersRegressionUHC
    Examples:
      | Scenario                           | site | path                                                | pageName                   | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | UAT E2E Regression Scenario 1_AARP | UHC  | shop.html                                           | Shop Hub Page              | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | UAT E2E Regression Scenario 2_AARP | UHC  | shop/medicare-advantage-plans.html                  | Shop MA Plans Page         | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | UAT E2E Regression Scenario 3_AARP | UHC  | shop/dual-special-needs-plans.html                  | Shop DSNP Plans Page e     | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | UAT E2E Regression Scenario 4_AARP | UHC  | enroll.html                                         | Enroll Page                | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | Avengers AARP                      | UHC  | /medicare-education/medicare-coverage-examples.html | Medicare Coverage Examples | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[1] | true    |

