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
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |

    @avengersRegressionAARP
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

    @avengersRegressionUHC
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

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                      | pageName                | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-ma.html              | Compare MA              | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-pdp.html             | Compare PDP             | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | enroll/ma-enrollment.html                 | MA Enrollment           | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | enroll/pdp-enrollment.html                | PDP Enrollment          | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                         | ShopPlan: Compare       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | E2E Scenario 5_AMP | AARP | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[6] | true    |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                      | pageName                | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-ma.html              | Compare MA              | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-pdp.html             | Compare PDP             | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | enroll/ma-enrollment.html                 | MA Enrollment           | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | enroll/pdp-enrollment.html                | PDP Enrollment          | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                         | ShopPlan: Compare       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | E2E Scenario 5_UMS | UHC  | enroll/ms-apply.html                      | ShopPlan: MS Enrollment | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[6] | true    |

    @avengersRegressionAARP
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

    @avengersRegressionUHC
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

  Scenario Outline: To verify proactive chat popup for the page mentioned of <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates proactive chat popup


    Examples:
      | Scenario           | site | path                                                | pageName                |
      | E2E Scenario 3_AMP | AARP | shop/estimate/pdp-costs.html                        | Estimate PDP            |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ms.html                        | ShopPlan: Compare       |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS |
      | E2E Scenario 4_AMP | AARP | safe-shopping.html                                  | ShopPlan: Shop          |
      | E2E Scenario 5_AMP | AARP | contact-us.html                                     | Request more help       |
      | E2E Scenario 5_AMP | AARP | shop/estimate/ma-costs.html                         | Estimate  MA            |
      | E2E Scenario 5_AMP | AARP | shop/renew-active.html                              | Renew Active            |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        |


    Examples:
      | Scenario           | site | path                                                | pageName                |
      | E2E Scenario 3_UMS | UHC  | shop/estimate/pdp-costs.html                        | Estimate PDP            |
      | E2E Scenario 5_UMS | UHC  | contact-us.html                                     | Request more help       |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        |
      | E2E Scenario 5_UMS | UHC  | shop/renew-active.html                              | Renew Active            |
      | E2E Scenario 5_UMS | UHC  | shop/estimate/ma-costs.html                         | Estimate  MA            |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ms.html                        | ShopPlan: Compare       |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS |
      | E2E Scenario 4_UMS | UHC  | safe-shopping.html                                  | ShopPlan: Shop          |


    Examples:
      | Scenario           | site | path                                      | pageName                |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-ma.html              | Compare MA              |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-pdp.html             | Compare PDP             |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         |
      | E2E Scenario 5_AMP | AARP | enroll/ma-enrollment.html                 | MA Enrollment           |
      | E2E Scenario 5_AMP | AARP | enroll/pdp-enrollment.html                | PDP Enrollment          |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                         | ShopPlan: Compare       |
      | E2E Scenario 5_AMP | AARP | enroll/ms-apply.html                      | ShopPlan: MS Enrollment |


    Examples:
      | Scenario           | site | path                                      | pageName                |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-ma.html              | Compare MA              |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-pdp.html             | Compare PDP             |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         |
      | E2E Scenario 5_UMS | UHC  | enroll/ma-enrollment.html                 | MA Enrollment           |
      | E2E Scenario 5_UMS | UHC  | enroll/pdp-enrollment.html                | PDP Enrollment          |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                         | ShopPlan: Compare       |
      | E2E Scenario 5_UMS | UHC  | enroll/ms-apply.html                      | ShopPlan: MS Enrollment |


    Examples:
      | Scenario           | site | path                                | pageName                     |
      | E2E Scenario 2_AMP | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                   | ShopPlan: Compare            |
      | E2E Scenario 4_AMP | AARP | enroll.html                         | ShopPlan: Enroll             |
      | E2E Scenario 4_AMP | AARP | shop.html                           | ShopPlan: Shop Hub           |
      | E2E Scenario 4_AMP | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan |
      | E2E Scenario 4_AMP | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      |
      | E2E Scenario 4_AMP | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     |
      | E2E Scenario 5_AMP | AARP | shop/estimate.html                  | Estimate                     |


    Examples:
      | Scenario           | site | path                                | pageName                     |
      | E2E Scenario 2_UMS | UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       |
      | E2E Scenario 4_UMS | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan |
      | E2E Scenario 4_UMS | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      |
      | E2E Scenario 4_UMS | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                   | ShopPlan: Compare            |
      | E2E Scenario 4_UMS | UHC  | enroll.html                         | ShopPlan: Enroll             |
      | E2E Scenario 4_UMS | UHC  | shop.html                           | ShopPlan: Shop Hub           |
      | E2E Scenario 5_UMS | UHC  | shop/estimate.html                  | Estimate                     |


  Scenario Outline: To verify Global Components chat icon for the page mentioned of <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates whether chat icon is visible

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                                | pageName                |
      | E2E Scenario 3_AMP | AARP | shop/estimate/pdp-costs.html                        | Estimate PDP            |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ms.html                        | ShopPlan: Compare       |
      | E2E Scenario 4_AMP | AARP | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS |
      | E2E Scenario 4_AMP | AARP | safe-shopping.html                                  | ShopPlan: Shop          |
      | E2E Scenario 5_AMP | AARP | contact-us.html                                     | Request more help       |
      | E2E Scenario 5_AMP | AARP | shop/estimate/ma-costs.html                         | Estimate  MA            |
      | E2E Scenario 5_AMP | AARP | shop/renew-active.html                              | Renew Active            |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                                | pageName                |
      | E2E Scenario 3_UMS | UHC  | shop/estimate/pdp-costs.html                        | Estimate PDP            |
      | E2E Scenario 5_UMS | UHC  | contact-us.html                                     | Request more help       |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-plans/ma-plan-benefits.html | MA Plan benefits        |
      | E2E Scenario 5_UMS | UHC  | shop/renew-active.html                              | Renew Active            |
      | E2E Scenario 5_UMS | UHC  | shop/estimate/ma-costs.html                         | Estimate  MA            |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ms.html                        | ShopPlan: Compare       |
      | E2E Scenario 4_UMS | UHC  | shop/compare/compare-ma-ms.html                     | ShopPlan: Compare MA MS |
      | E2E Scenario 4_UMS | UHC  | safe-shopping.html                                  | ShopPlan: Shop          |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                      | pageName                |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-ma.html              | Compare MA              |
      | E2E Scenario 5_AMP | AARP | shop/compare/compare-pdp.html             | Compare PDP             |
      | E2E Scenario 5_AMP | AARP | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         |
      | E2E Scenario 5_AMP | AARP | enroll/ma-enrollment.html                 | MA Enrollment           |
      | E2E Scenario 5_AMP | AARP | enroll/pdp-enrollment.html                | PDP Enrollment          |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                         | ShopPlan: Compare       |
      | E2E Scenario 5_AMP | AARP | enroll/ms-apply.html                      | ShopPlan: MS Enrollment |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                      | pageName                |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-ma.html              | Compare MA              |
      | E2E Scenario 5_UMS | UHC  | shop/compare/compare-pdp.html             | Compare PDP             |
      | E2E Scenario 5_UMS | UHC  | shop/medicare-advantage-veteran-plan.html | MA Veteran Plan         |
      | E2E Scenario 5_UMS | UHC  | enroll/ma-enrollment.html                 | MA Enrollment           |
      | E2E Scenario 5_UMS | UHC  | enroll/pdp-enrollment.html                | PDP Enrollment          |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                         | ShopPlan: Compare       |
      | E2E Scenario 5_UMS | UHC  | enroll/ms-apply.html                      | ShopPlan: MS Enrollment |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                | pageName                     |
      | E2E Scenario 2_AMP | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                   | ShopPlan: Compare            |
      | E2E Scenario 4_AMP | AARP | enroll.html                         | ShopPlan: Enroll             |
      | E2E Scenario 4_AMP | AARP | shop.html                           | ShopPlan: Shop Hub           |
      | E2E Scenario 4_AMP | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan |
      | E2E Scenario 4_AMP | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      |
      | E2E Scenario 4_AMP | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     |
      | E2E Scenario 5_AMP | AARP | shop/estimate.html                  | Estimate                     |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                | pageName                     |
      | E2E Scenario 2_UMS | UHC  | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       |
      | E2E Scenario 4_UMS | UHC  | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan |
      | E2E Scenario 4_UMS | UHC  | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      |
      | E2E Scenario 4_UMS | UHC  | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     |
      | E2E Scenario 5_UMS | UHC  | shop/compare.html                   | ShopPlan: Compare            |
      | E2E Scenario 4_UMS | UHC  | enroll.html                         | ShopPlan: Enroll             |
      | E2E Scenario 4_UMS | UHC  | shop.html                           | ShopPlan: Shop Hub           |
      | E2E Scenario 5_UMS | UHC  | shop/estimate.html                  | Estimate                     |


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
      | Scenario           | site | path                                | pageName                     | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_AMP | AARP | shop/medicare-advantage-plans.html  | ShopPlan: Shop MA Plan       | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | shop/compare.html                   | ShopPlan: Compare            | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP | AARP | enroll.html                         | ShopPlan: Enroll             | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP | AARP | shop.html                           | ShopPlan: Shop Hub           | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP | AARP | shop/medicare-supplement-plans.html | ShopPlan: Shop Med Supp Plan | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[4] | true    |
      | E2E Scenario 4_AMP | AARP | shop/prescription-drug-plans.html   | ShopPlan: Shop PDP Plan      | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 4_AMP | AARP | shop/dual-special-needs-plans.html  | ShopPlan: Shop DSNP Plan     | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 5_AMP | AARP | shop/estimate.html                  | Estimate                     | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | false   |

    @avengersRegressionUHC
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
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |

    @avengersRegressionAARP
    Examples:
      | Scenario               | site | path                                              | pageName                                | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 1_AMP | AARP | medicare-articles.html                            | Medicare Articles Home                  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 2_AMP | AARP | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html        | MMC page                                | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                              | pageName                                | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 1_UMS | UHC  | medicare-articles.html                            | Medicare Articles Home                  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 2_UMS | UHC  | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html        | MMC page                                | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

    @avengersRegressionAARP
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                                  | pageName      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-costs.html                 | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/shopping-for-medicare.html          | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                                  | pageName      | tfnXpath                                                           | tfnFlag |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-costs.html                 | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/shopping-for-medicare.html          | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |


  Scenario Outline: <Scenario>- To verify proactive chat popup on medicare article pages for the page mentioned on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Medicare Education Navigation link
    Then the user validates proactive chat popup


    Examples:
      | Scenario           | site | path                                              | pageName                                |
      | E2E Scenario 1_AMP | AARP | medicare-articles.html                            | Medicare Articles Home                  |
      | E2E Scenario 2_AMP | AARP | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page |
      | E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html        | MMC page                                |


    Examples:
      | Scenario           | site | path                                              | pageName                                |
      | E2E Scenario 1_UMS | UHC  | medicare-articles.html                            | Medicare Articles Home                  |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page |
      | E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html        | MMC page                                |


    Examples:
      | Scenario           | site | path                                                                                    | pageName                |
      | E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  |
      | E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage |


    Examples:
      | Scenario           | site | path                                                                                    | pageName                |
      | E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  |
      | E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage |


    Examples:
      | Scenario           | site | path                                                  | pageName      |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-costs.html                 | Category page |
      | E2E Scenario 2_AMP | AARP | medicare-articles/shopping-for-medicare.html          | Category page |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page |


    Examples:
      | Scenario           | site | path                                                  | pageName      |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-costs.html                 | Category page |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/shopping-for-medicare.html          | Category page |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page |


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
      | Scenario           | site | path                                              | pageName                                |
      | E2E Scenario 1_AMP | AARP | medicare-articles.html                            | Medicare Articles Home                  |
      | E2E Scenario 2_AMP | AARP | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page |
      | E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html        | MMC page                                |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                              | pageName                                |
      | E2E Scenario 1_UMS | UHC  | medicare-articles.html                            | Medicare Articles Home                  |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page |
      | E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html        | MMC page                                |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                                                                    | pageName                |
      | E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  |
      | E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                                                                    | pageName                |
      | E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  |
      | E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                                  | pageName      |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-costs.html                 | Category page |
      | E2E Scenario 2_AMP | AARP | medicare-articles/shopping-for-medicare.html          | Category page |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                                  | pageName      |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-costs.html                 | Category page |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/shopping-for-medicare.html          | Category page |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page |


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
      | Scenario               | site | path                                              | pageName                                |
      | UAT E2E Scenario 1_AMP | AARP | medicare-articles.html                            | Medicare Articles Home                  |
      | UAT E2E Scenario 2_AMP | AARP | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page |
      | UAT E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html        | MMC page                                |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                              | pageName                                |
      | UAT E2E Scenario 1_UMS | UHC  | medicare-articles.html                            | Medicare Articles Home                  |
      | UAT E2E Scenario 2_UMS | UHC  | medicare-articles/eligibility-and-enrollment.html | Eligibility and Enrollment Article page |
      | UAT E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html        | MMC page                                |

    @avengersRegressionAARP
    Examples:
      | Scenario               | site | path                                                                                    | pageName                |
      | UAT E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  |
      | UAT E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                                                                    | pageName                |
      | UAT E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  |
      | UAT E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage |

    @avengersRegressionAARP
    Examples:
      | Scenario           | site | path                                                  | pageName      |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-benefits-and-coverage.html | Category page |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-costs.html                 | Category page |
      | E2E Scenario 2_AMP | AARP | medicare-articles/shopping-for-medicare.html          | Category page |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-when-working-past-65.html  | Category page |
      | E2E Scenario 2_AMP | AARP | medicare-articles/medicare-tips-and-faqs.html         | Category page |

    @avengersRegressionUHC
    Examples:
      | Scenario           | site | path                                                  | pageName      |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-benefits-and-coverage.html | Category page |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-costs.html                 | Category page |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/shopping-for-medicare.html          | Category page |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-when-working-past-65.html  | Category page |
      | E2E Scenario 2_UMS | UHC  | medicare-articles/medicare-tips-and-faqs.html         | Category page |


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
      | Scenario               | site | path                                                                                    | pageName                | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                                                                    | pageName                | tfnXpath                                                           | tfnFlag |
      | UAT E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |


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
      | Scenario               | site | path                                       | pageName               |
      | UAT E2E Scenario 1_AMP | AARP | medicare-articles.html                     | Medicare Articles Home |
      | UAT E2E Scenario 5_AMP | AARP | medicare-articles/medicare-made-clear.html | MMC page               |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                       | pageName               |
      | UAT E2E Scenario 1_UMS | UHC  | medicare-articles.html                     | Medicare Articles Home |
      | UAT E2E Scenario 5_UMS | UHC  | medicare-articles/medicare-made-clear.html | MMC page               |

    @avengersRegressionAARP
    Examples:
      | Scenario               | site | path                                                                                    | pageName                |
      | UAT E2E Scenario 3_AMP | AARP | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  |
      | UAT E2E Scenario 4_AMP | AARP | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage |

    @avengersRegressionUHC
    Examples:
      | Scenario               | site | path                                                                                    | pageName                |
      | UAT E2E Scenario 3_UMS | UHC  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html | Enrolling After Age 65  |
      | UAT E2E Scenario 4_UMS | UHC  | medicare-articles/what-is-retiree-health-coverage.html                                  | Retiree Health Coverage |


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
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validate the state selected is correct
      | GeoState | <geoState> |
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validate ZipCode Components on page using ZipCode "55424"
    When the user clicks on Agent link and validates the correct URL is loaded from article page
      | UHC Agent URL | <UHCUrl> |


    @avengersRegressionAARP
    Examples:
      | Scenario                           | site | geoState | path                                               | pageName                      | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | UAT E2E Regression Scenario 1_AARP | AARP | Alabama  | shop.html                                          | Shop Hub Page                 | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Regression Scenario 2_AARP | AARP | Alabama  | shop/medicare-advantage-plans.html                 | Shop MA Plans Page            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Regression Scenario 2_AARP | AARP | Alabama  | shop/medicare-advantage-plans/california.html      | Shop MA Plans California Page | https://www.myuhcagent.com/ | //span[contains(text(),'Call')]//*[contains(@class,'tel tfn')]     | true    |
      | UAT E2E Regression Scenario 3_AARP | AARP | Alabama  | shop/dual-special-needs-plans.html                 | Shop DSNP Plans Page          | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Regression Scenario 4_AARP | AARP | Alabama  | enroll.html                                        | Enroll Page                   | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | Avengers AARP                      | AARP | Alabama  | medicare-education/medicare-coverage-examples.html | Medicare Coverage Examples    | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

    @avengersRegressionUHC
    Examples:
      | Scenario                          | site | geoState | path                                               | pageName                      | UHCUrl                      | tfnXpath                                                           | tfnFlag |
      | UAT E2E Regression Scenario 1_UMS | UHC  | Alabama  | shop.html                                          | Shop Hub Page                 | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Regression Scenario 2_UMS | UHC  | Alabama  | shop/medicare-advantage-plans.html                 | Shop MA Plans Page            | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Regression Scenario 2_UMS | UHC  | Alabama  | shop/medicare-advantage-plans/california.html      | Shop MA Plans California Page | https://www.myuhcagent.com/ | //span[contains(text(),'Call')]//*[contains(@class,'tel tfn')]     | true    |
      | UAT E2E Regression Scenario 3_UMS | UHC  | Alabama  | shop/dual-special-needs-plans.html                 | Shop DSNP Plans Page          | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |
      | UAT E2E Regression Scenario 4_UMS | UHC  | Alabama  | enroll.html                                        | Enroll Page                   | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[5] | true    |
      | Avengers UMS                      | UHC  | Alabama  | medicare-education/medicare-coverage-examples.html | Medicare Coverage Examples    | https://www.myuhcagent.com/ | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    |

    @avengersRegressionAARP
    Examples:
      | site | geoState    | path                                                                     | pageName                                      | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | AARP | Puerto Rico | medicare-education-classic.html                                          | Understanding Medicare Classic                | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Puerto Rico | medicare-education-classic/medicare-eligibility-classic.html             | Medicare Eligibility Classic                  | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Puerto Rico | medicare-education-classic/medicare-parts-and-medigap-plans-classic.html | Medicare and Medigap Coverage Options Classic | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Puerto Rico | medicare-education-classic/medicare-benefits-classic.html                | Prescriptions, Providers & Benefits Classic   | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Puerto Rico | medicare-education-classic/medicare-advantage-plans-classic.html         | Learn about Medicare Advantage Plans Classic  | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Puerto Rico | medicare-education-classic/medicare-supplement-plans-classic.html        | Learn about Medicare Supplement Plans Classic | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[4] | true    | https://www.myuhcagent.com/ |
      | AARP | Puerto Rico | medicare-education-classic/medicare-part-d-classic.html                  | Medicare Prescription Drug Plans Classic      | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Puerto Rico | medicare-education-classic/medicare-costs-classic.html                   | Medicare Cost Basics Classic                  | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | medicare-education/when-to-enroll.html                                   | When to Enroll                                | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Puerto Rico | medicare-education-classic/medicare-faq-classic.html                     | Medicare FAQ Classic                          | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/connect.html                                                        | ShopPlan: Request more Info                   | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/compare.html                                                        | ShopPlan: Compare                             | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[5] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/compare/compare-ms.html                                             | ShopPlan: Compare MS                          | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[4] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/estimate/ms-costs.html                                              | ShopPlan: Estimate MS                         | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[4] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/compare/compare-ma-ms.html                                          | ShopPlan: Compare MA-MS                       | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | safe-shopping.html                                                       | ShopPlan: Safe Shopping                       | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/medicare-advantage-plans.html                                       | ShopPlan: Shop MA Plan                        | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/medicare-supplement-plans.html                                      | ShopPlan: Shop Med Supp Plan                  | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[4] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/prescription-drug-plans.html                                        | ShopPlan: Shop PDP Plan                       | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/dual-special-needs-plans.html                                       | ShopPlan: Shop DSNP Plan                      | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/compare/compare-pdp.html                                            | ShopPlan: Compare PDP Plan                    | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/compare/compare-ma.html                                             | ShopPlan: Compare MA  Plan                    | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/estimate/ma-costs.html                                              | ShopPlan: Estimate MA Plan                    | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/estimate/pdp-costs.html                                             | ShopPlan: Estimate PDP Plan                   | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/medicare-advantage-plans/wellness-discounts.html                    | ShopPlan: Welness Discount                    | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/medicare-advantage-plans/health-care-management.html                | ShopPlan: Healthcare management               | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/medicare-advantage-plans/ma-dental-benefits.html                    | ShopPlan: MA Dental Benefits                  | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | shop/renew-active.html                                                   | ShopPlan: Renew-Active                        | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | enroll.html                                                              | ShopPlan: Enroll                              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[5] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | enroll/ma-enrollment.html                                                | ShopPlan: Enroll MA Plans                     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | enroll/pdp-enrollment.html                                               | ShopPlan: Enroll PDP Plans                    | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | enroll/ms-apply.html                                                     | ShopPlan: Enroll MS                           | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[6] | true    | https://www.myuhcagent.com/ |
      #| AARP | Alabama  | about-us.html                                                            | Footer: About Us                              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | contact-us.html                                                          | Footer: Contact Us                            | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama     | medicare-education/keep-or-change-coverage.html                          | Medicare Education- Medicare Coverage         | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |

    @avengersRegressionUHC
    Examples:
      | site | geoState    | path                                                                     | pageName                                      | tfnXpath                                                            | tfnFlag | UHCUrl                      |
      | UHC  | Puerto Rico | medicare-education-classic.html                                          | Understanding Medicare Classic                | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Puerto Rico | medicare-education-classic/medicare-eligibility-classic.html             | Medicare Eligibility Classic                  | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Puerto Rico | medicare-education-classic/medicare-parts-and-medigap-plans-classic.html | Medicare and Medigap Coverage Options Classic | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Puerto Rico | medicare-education-classic/medicare-benefits-classic.html                | Prescriptions, Providers & Benefits Classic   | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Puerto Rico | medicare-education-classic/medicare-advantage-plans-classic.html         | Learn about Medicare Advantage Plans Classic  | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Puerto Rico | medicare-education-classic/medicare-supplement-plans-classic.html        | Learn about Medicare Supplement Plans Classic | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[4] | true    | https://www.myuhcagent.com/ |
      | UHC  | Puerto Rico | medicare-education-classic/medicare-part-d-classic.html                  | Medicare Prescription Drug Plans Classic      | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Puerto Rico | medicare-education-classic/medicare-costs-classic.html                   | Medicare Cost Basics Classic                  | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | medicare-education/when-to-enroll.html                                   | When to Enroll                                | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Puerto Rico | medicare-education-classic/medicare-faq-classic.html                     | Medicare FAQ Classic                          | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/connect.html                                                        | ShopPlan: Request more Info                   | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/compare.html                                                        | ShopPlan: Compare                             | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[5] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/compare/compare-ms.html                                             | ShopPlan: Compare MS                          | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[4] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/estimate/ms-costs.html                                              | ShopPlan: Estimate MS                         | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[4] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/compare/compare-ma-ms.html                                          | ShopPlan: Compare MA-MS                       | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | safe-shopping.html                                                       | ShopPlan: Safe Shopping                       | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/medicare-advantage-plans.html                                       | ShopPlan: Shop MA Plan                        | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/medicare-supplement-plans.html                                      | ShopPlan: Shop Med Supp Plan                  | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[4] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/prescription-drug-plans.html                                        | ShopPlan: Shop PDP Plan                       | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/dual-special-needs-plans.html                                       | ShopPlan: Shop DSNP Plan                      | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/compare/compare-pdp.html                                            | ShopPlan: Compare PDP Plan                    | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/compare/compare-ma.html                                             | ShopPlan: Compare MA  Plan                    | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/estimate/ma-costs.html                                              | ShopPlan: Estimate MA Plan                    | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/estimate/pdp-costs.html                                             | ShopPlan: Estimate PDP Plan                   | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/medicare-advantage-plans/wellness-discounts.html                    | ShopPlan: Welness Discount                    | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/medicare-advantage-plans/health-care-management.html                | ShopPlan: Healthcare management               | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/medicare-advantage-plans/ma-dental-benefits.html                    | ShopPlan: MA Dental Benefits                  | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | shop/renew-active.html                                                   | ShopPlan: Renew-Active                        | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | enroll.html                                                              | ShopPlan: Enroll                              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[5] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | enroll/ma-enrollment.html                                                | ShopPlan: Enroll MA Plans                     | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | enroll/pdp-enrollment.html                                               | ShopPlan: Enroll PDP Plans                    | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | enroll/ms-apply.html                                                     | ShopPlan: Enroll MS                           | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[6] | true    | https://www.myuhcagent.com/ |
      #| UHC  | Alabama  | about-us.html                                                            | Footer: About Us                              | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | contact-us.html                                                          | Footer: Contact Us                            | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama     | medicare-education/keep-or-change-coverage.html                          | Medicare Education- Medicare Coverage         | (//*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |


  Scenario Outline: <Scenario>- To verify social share component on <site> site <pageName> : <path>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user select state for geotargeting from dropdown
      | GeoState | <geoState> |
    And the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validate the state selected is correct
      | GeoState | <geoState> |
    Then the user validate facebook button from social share
    Then the user validate twitter button from social share
    Then the user validate email button from social share
    Then the user validates TFN on the page
      | TFNxpath | <tfnXpath> |
      | TFNflag  | <tfnFlag>  |
    Then the user validate ZipCode Components on page using ZipCode "55424"
    When the user clicks on Agent link and validates the correct URL is loaded from article page
      | UHC Agent URL | <UHCUrl> |

    @validateSocialShareComponentAARP @avengersRegressionAARP @Validate3packCTA_Article_AARP
    Examples:
      | site | geoState | path                                                                                                                       | pageName          | tfnXpath                                                           | tfnFlag | UHCUrl                      |
      | AARP | Alabama  | medicare-articles/can-i-change-my-medicare-plan.html                                                                       | Article Page 1    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/how-to-get-ready-for-the-medicare-annual-enrollment-period.html                                          | Article Page 2    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-coverage-for-mammograms.html                                                                    | Article Page 3    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/try-to-avoid-medicare-late-enrollment-premium-penalties.html                                             | Article Page 4    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/is-medicare-mandatory.html                                                                               | Article Page 5    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/5-tips-for-enrolling-in-medicare-for-the-first-time.html                                                 | Article Page 6    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/do-i-need-medicare-with-spouses-employer-plan.html                                                       | Article Page 7    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-coverage-for-non-working-spouses.html                                                           | Article Page 8    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/5-ways-to-pay-your-medicare-part-b-premium.html                                                          | Article Page 9    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/decide-change-plan.html                                                                                  | Article Page 10   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-is-creditable-drug-coverage.html                                                                    | Article Page 11   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/when-can-you-start-getting-medicare.html                                                                 | Article Page 12   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/safe-medicare-enrollment-during-COVID.html                                                               | Article Page 13   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-is-the-difference-between-original-medicare-and-medicare-advantage.html                             | Article Page 14   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/caregiver-corner-helping-your-loved-one-prepare-for-the-medicare-annual-enrollment-period.html           | Article Page 15   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/6-tips-to-protect-yourself-from-medicare-fraud.html                                                      | Article Page 16   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/need-eyeglasses-or-eye-care-coverage-check-your-medicare-options.html                                    | Article Page 17   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/6-timely-medicare-tips-for-turning-65.html                                                               | Article Page 18   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/your-5-point-checklist-choosing-medicare-part-d-plan.html                                                | Article Page 19   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html                                    | Article Page 20   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-doesnt-cover-everything-what-you-need-know.html                                                 | Article Page 21   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/9-good-reasons-why-a-medicare-advantage-plan-might-be-right-for-you.html                                 | Article Page 22   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-is-retiree-health-coverage.html                                                                     | Article Page 23   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/5-medicare-myths-set-straight.html                                                                       | Article Page 24   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/have-diabetes-medicare-parts-b-and-d-have-you-covered.html                                               | Article Page 25   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-does-original-medicare-include.html                                                                 | Article Page 26   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/how-to-avoid-the-medicare-part-b-late-penalty.html                                                       | Article Page 27   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-increases-coverage-mental-health-care.html                                                      | Article Page 28   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/prescription-discount-cards-other-money-saving-medicare-tips.html                                        | Article Page 29   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/does-medicare-coverage-change-if-you-return-to-work.html                                                 | Article Page 30   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-enrollment-checklist-helping-you-prepare-for-an-important-decision.html                         | Article Page 31   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/how-to-transition-from-the-health-marketplace-to-medicare.html                                           | Article Page 32   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/wheres-my-original-medicare-card.html                                                                    | Article Page 33   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/outpatient-mental-health-care-services.html                                                              | Article Page 34   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/3-simple-ways-to-change-medicare-plans.html                                                              | Article Page 35   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-is-the-medicare-special-enrollment-period.html                                                      | Article Page 36   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/dos-and-donts-cancelling-a-marketplace-health-plan.html                                                  | Article Page 37   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/like-to-travel-it-may-affect-which-medicare-plan-you-choose.html                                         | Article Page 38   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/youre-65-working-medicare.html                                                                           | Article Page 39   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/is-your-medicare-plan-the-best-one-for-you-this-checklist-can-help-you-decide.html                       | Article Page 40   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/concrete-answers-10-common-medicare-questions.html                                                       | Article Page 41   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-happens-to-your-medicare-plan-if-you-move.html                                                      | Article Page 42   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/renew-medicare-plan-open-enrollment.html                                                                 | Article Page 43   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/pharmacists-answering-your-medicare-prescription-drug-questions.html                                     | Article Page 44   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/help-i-have-a-disability-and-i-want-to-enroll-in-medicare.html                                           | Article Page 45   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-enrollment-for-veterans.html                                                                    | Article Page 46   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/saving-on-medicare-when-self-employed.html                                                               | Article Page 47   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/how-to-get-dental-and-vision-care-coverage-when-you-have-medicare.html                                   | Article Page 48   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/why-you-and-your-spouse-might-need-different-medicare-plans.html                                         | Article Page 49   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/born-in-1955-or-later-you-may-have-to-work-until-youre-67.html                                           | Article Page 50   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/should-you-change-your-medicare-plan.html                                                                | Article Page 51   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/the-truth-your-medicare-part-b-premium.html                                                              | Article Page 52   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/how-do-tricare-and-medicare-work-together.html                                                           | Article Page 53   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-should-i-look-for-in-a-medicare-prescription-drug-plan.html                                         | Article Page 54   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/4-basic-questions-to-ask-about-medicare-part-d-coverage.html                                             | Article Page 55   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-and-durable-medical-equipment-dme.html                                                          | Article Page 56   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-is-the-medicare-annual-enrollment-period.html                                                       | Article Page 57   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-if-i-missed-my-initial-enrollment-period.html                                                       | Article Page 58   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/can-you-switch-between-original-medicare-and-medicare-advantage-during-the-annual-enrollment-period.html | Article Page 59   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-individuals-who-divorced-widowed.html                                                           | Article Page 60   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/2-ways-to-prescription-drug-coverage.html                                                                | Article Page 61   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/which-vaccines-does-medicare-cover.html                                                                  | Article Page 62   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-mistakes-that-could-be-costly.html                                                              | Article Page 63   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/5-savvy-shopper-tips-help-get-medicare.html                                                              | Article Page 64   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/good-reasons-to-shop-for-a-new-medicare-plan.html                                                        | Article Page 65   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/should-i-get-part-b-if-im-working-past-65.html                                                           | Article Page 66   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/turn-65-retire-sign-up-for-medicare-or-not.html                                                          | Article Page 67   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/aep-change-or-renew.html                                                                                 | Article Page 68   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/the-difference-between-medicare-hmo-and-ppo-plans.html                                                   | Article Page 69   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/7-inside-tips-to-help-you-make-a-smooth-move-to-medicare.html                                            | Article Page 70   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-plan-annual-notice-of-change-what-to-look-for.html                                              | Article Page 71   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/understanding-your-medicare-plan.html                                                                    | Article Page 72   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/heart-healthy-help-medicare.html                                                                         | Article Page 73   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-coverage-for-same-sex-couples.html                                                              | Article Page 74   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/7-popular-medicare-questions-asked-during-national-medicare-education-week.html                          | Article Page 75   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-s-the-difference-between-medicare-and-medicaid.html                                                 | Article Page 76   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/6-point-checklist-to-rate-your-new-medicare-advantage-plan.html                                          | Article Page 77   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/how-to-evaluate-medicare-plan-costs.html                                                                 | Article Page 78   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/whats-the-difference-between-a-skilled-nursing-facility-and-a-nursing-home.html                          | Article Page 79   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/how-avoid-paying-more-prescription-drug-coverage.html                                                    | Article Page 80   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-can-i-do-during-the-medicare-advantage-open-enrollment-period.html                                  | Article Page 81   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/how-to-appeal-a-medicare-decision.html                                                                   | Article Page 82   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/replacing-your-medicare-card-just-got-a-whole-lot-easier.html                                            | Article Page 83   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-is-a-tiered-formulary-and-what-does-it-mean-for-me.html                                             | Article Page 84   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/good-news-medicare-part-b-covers-cataract-surgery.html                                                   | Article Page 85   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/3-ways-to-dispose-of-your-old-unused-medications-safely.html                                             | Article Page 86   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-telehealth-services-does-medicare-offer.html                                                        | Article Page 87   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/10-tips-choosing-primary-care-doctor.html                                                                | Article Page 88   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/how-often-should-a-woman-over-65-have-a-pap-smear.html                                                   | Article Page 89   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-coverage-for-inpatient-rehabilitation.html                                                      | Article Page 90   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/home-health-care-those-medicare-who-cant-leave-home.html                                                 | Article Page 91   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/4-assistance-programs-could-help-pay-your-medicare-costs.html                                            | Article Page 92   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-transportation-services.html                                                                    | Article Page 93   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/does-medicare-cover-melanoma-screenings.html                                                             | Article Page 94   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/guia-paso-paso-para-inscribirse-en-medicare-los-65-anos.html                                             | Article Page 95   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/avoid-sticker-shock-medicare-billing.html                                                                | Article Page 96   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/how-to-become-a-medicare-authorized-representative.html                                                  | Article Page 97   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/reasons-you-should-schedule-an-annual-medicare-wellness-visit.html                                       | Article Page 98   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/does-medicare-cover-allergy-testing.html                                                                 | Article Page 99   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/copd-medicare.html                                                                                       | Article Page 100  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/does-medicare-cover-home-blood-pressure-monitors.html                                                    | Article Page 101  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/dual-special-needs-plans.html                                                                            | Article Page 102  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-part-b-may-not-cover-hearing-aid-part-c-might.html                                              | Article Page 103  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/does-medicare-part-a-cost-anything.html                                                                  | Article Page 104  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-does-medicare-cover-after-a-stroke.html                                                             | Article Page 105  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/parte-a-de-medicare-conceptos-basicos.html                                                               | Article Page 106  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/2-ways-save-on-blood-sugar-test-strips.html                                                              | Article Page 107  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-coverage-for-outpatient-rehabilitation-therapy.html                                             | Article Page 108  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/are-glaucoma-screenings-covered-by-medicare.html                                                         | Article Page 109  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-coverage-for-prostate-cancer-screening.html                                                     | Article Page  110 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-parte-c-conceptos-basicos.html                                                                  | Article Page  111 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/how-prepare-your-medicare-wellness-visit.html                                                            | Article Page  112 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-part-c-basics.html                                                                              | Article Page  113 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-memo-what-are-advance-directives.html                                                           | Article Page  114 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/does-medicare-cover-a-colonoscopy.html                                                                   | Article Page  115 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/4-types-of-medicare-savings-programs-and-what-they-cover.html                                            | Article Page  116 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-is-the-medicare-advantage-open-enrollment-period.html                                               | Article Page  117 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/parte-b-de-medicare-conceptos-basicos.html                                                               | Article Page  118 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/colon-cancer-screening-tests-without-the-ouch.html                                                       | Article Page  119 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/does-medicare-cover-diabetes-prevention-program.html                                                     | Article Page  120 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-is-co-insurance.html                                                                                | Article Page  121 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/does-medicare-cover-blood-tests-for-cholesterol.html                                                     | Article Page  122 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/how-to-save-on-prescription-drugs-with-medicare.html                                                     | Article Page  123 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/whats-the-difference-between-a-physical-exam-and-a-medicare-wellness-visit.html                          | Article Page  124 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/are-you-living-with-chronic-heart-failure.html                                                           | Article Page  125 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/will-medicare-cover-a-cpap-machine.html                                                                  | Article Page  126 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/how-much-does-medicare-part-b-cost.html                                                                  | Article Page  127 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/got-coverage-for-the-new-year.html                                                                       | Article Page  128 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-is-a-transition-refill.html                                                                         | Article Page  129 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/cual-es-la-diferencia-entre-medicare-y-medicaid.html                                                     | Article Page  130 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/parte-d-de-medicare-conceptos-basicos.html                                                               | Article Page  131 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/does-medicare-cover-emergency-room-visits.html                                                           | Article Page  132 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/getting-a-knee-replaced-with-Medicare.html                                                               | Article Page  133 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/cuatro-programas-de-asistencia-para-pagar-sus-costos-de-medicare.html                                    | Article Page  134 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/does-medicare-cover-a-chiropractor.html                                                                  | Article Page  135 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-is-the-medicare-part-d-coverage-gap.html                                                            | Article Page  136 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-is-a-pdp-prescription-drug-plan.html                                                                | Article Page  137 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-beneficiaries-needing-hospice-care-may-be-covered.html                                          | Article Page  138 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-part-b-basics.html                                                                              | Article Page  139 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/new-to-medicare-schedule-your-welcome-to-medicare-visit.html                                             | Article Page  140 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-part-benefit-periods-deductibles.html                                                           | Article Page  141 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-part-d-basics.html                                                                              | Article Page  142 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-and-your-private-medical-information.html                                                       | Article Page  143 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-part-a-the-basics.html                                                                          | Article Page  144 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-coverage-for-cancer-screenings-chemo-and-radiation.html                                         | Article Page  145 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/4surefire-tips-for-picking-a-medicare-plan-that-fits-your-health-needs-and-budget.html                   | Article Page  146 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-part-d-costs-you-may-not-know-about.html                                                        | Article Page  147 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/how-to-compare-medicare-advantage-plan-costs.html                                                        | Article Page  148 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/new-medicare-follow-checklist-successful-start.html                                                      | Article Page  149 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/decoding-medicare.html                                                                                   | Article Page  150 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-medicare-medical-savings-account-plan.html                                                          | Article Page  151 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/what-will-medicare-cost.html                                                                             | Article Page  152 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/retiring-what-to-know-about-medicare.html                                                                | Article Page  153 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/medicare-and-cobra.html                                                                                  | Article Page  154 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/special-enrollment-for-medicare-when-working-past-65.html                                                | Article Page  155 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
#      | AARP | Alabama  | medicare-articles/what-will-medicare-cost-in-2020.html                                                                     | Article Page  156 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/hsas-and-medicare.html                                                                                   | Article Page  157 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | AARP | Alabama  | medicare-articles/are-medicare-premiums-based-on-income.html                                                               | Article Page  158 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |



    @validateSocialShareComponentUHC @avengersRegressionUHC @Validate3packCTA_Article_UHC
    Examples:
      | site | geoState | path                                                                                                                       | pageName          | tfnXpath                                                           | tfnFlag | UHCUrl                      |
      | UHC  | Alabama  | medicare-articles/can-i-change-my-medicare-plan.html                                                                       | Article Page 1    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/how-to-get-ready-for-the-medicare-annual-enrollment-period.html                                          | Article Page 2    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-coverage-for-mammograms.html                                                                    | Article Page 3    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/try-to-avoid-medicare-late-enrollment-premium-penalties.html                                             | Article Page 4    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/is-medicare-mandatory.html                                                                               | Article Page 5    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/5-tips-for-enrolling-in-medicare-for-the-first-time.html                                                 | Article Page 6    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/do-i-need-medicare-with-spouses-employer-plan.html                                                       | Article Page 7    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-coverage-for-non-working-spouses.html                                                           | Article Page 8    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/5-ways-to-pay-your-medicare-part-b-premium.html                                                          | Article Page 9    | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/decide-change-plan.html                                                                                  | Article Page 10   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-is-creditable-drug-coverage.html                                                                    | Article Page 11   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/when-can-you-start-getting-medicare.html                                                                 | Article Page 12   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/safe-medicare-enrollment-during-COVID.html                                                               | Article Page 13   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-is-the-difference-between-original-medicare-and-medicare-advantage.html                             | Article Page 14   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/caregiver-corner-helping-your-loved-one-prepare-for-the-medicare-annual-enrollment-period.html           | Article Page 15   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/6-tips-to-protect-yourself-from-medicare-fraud.html                                                      | Article Page 16   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/need-eyeglasses-or-eye-care-coverage-check-your-medicare-options.html                                    | Article Page 17   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/6-timely-medicare-tips-for-turning-65.html                                                               | Article Page 18   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/your-5-point-checklist-choosing-medicare-part-d-plan.html                                                | Article Page 19   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/unintended-part-d-gotcha-could-getcha-if-you-enroll-after-age-65.html                                    | Article Page 20   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-doesnt-cover-everything-what-you-need-know.html                                                 | Article Page 21   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/9-good-reasons-why-a-medicare-advantage-plan-might-be-right-for-you.html                                 | Article Page 22   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-is-retiree-health-coverage.html                                                                     | Article Page 23   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/5-medicare-myths-set-straight.html                                                                       | Article Page 24   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/have-diabetes-medicare-parts-b-and-d-have-you-covered.html                                               | Article Page 25   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-does-original-medicare-include.html                                                                 | Article Page 26   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/how-to-avoid-the-medicare-part-b-late-penalty.html                                                       | Article Page 27   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-increases-coverage-mental-health-care.html                                                      | Article Page 28   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/prescription-discount-cards-other-money-saving-medicare-tips.html                                        | Article Page 29   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/does-medicare-coverage-change-if-you-return-to-work.html                                                 | Article Page 30   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-enrollment-checklist-helping-you-prepare-for-an-important-decision.html                         | Article Page 31   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/how-to-transition-from-the-health-marketplace-to-medicare.html                                           | Article Page 32   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/wheres-my-original-medicare-card.html                                                                    | Article Page 33   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/outpatient-mental-health-care-services.html                                                              | Article Page 34   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/3-simple-ways-to-change-medicare-plans.html                                                              | Article Page 35   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-is-the-medicare-special-enrollment-period.html                                                      | Article Page 36   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/dos-and-donts-cancelling-a-marketplace-health-plan.html                                                  | Article Page 37   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/like-to-travel-it-may-affect-which-medicare-plan-you-choose.html                                         | Article Page 38   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/youre-65-working-medicare.html                                                                           | Article Page 39   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/is-your-medicare-plan-the-best-one-for-you-this-checklist-can-help-you-decide.html                       | Article Page 40   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/concrete-answers-10-common-medicare-questions.html                                                       | Article Page 41   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-happens-to-your-medicare-plan-if-you-move.html                                                      | Article Page 42   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/renew-medicare-plan-open-enrollment.html                                                                 | Article Page 43   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/pharmacists-answering-your-medicare-prescription-drug-questions.html                                     | Article Page 44   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/help-i-have-a-disability-and-i-want-to-enroll-in-medicare.html                                           | Article Page 45   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-enrollment-for-veterans.html                                                                    | Article Page 46   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/saving-on-medicare-when-self-employed.html                                                               | Article Page 47   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/how-to-get-dental-and-vision-care-coverage-when-you-have-medicare.html                                   | Article Page 48   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/why-you-and-your-spouse-might-need-different-medicare-plans.html                                         | Article Page 49   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/born-in-1955-or-later-you-may-have-to-work-until-youre-67.html                                           | Article Page 50   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/should-you-change-your-medicare-plan.html                                                                | Article Page 51   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/the-truth-your-medicare-part-b-premium.html                                                              | Article Page 52   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/how-do-tricare-and-medicare-work-together.html                                                           | Article Page 53   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-should-i-look-for-in-a-medicare-prescription-drug-plan.html                                         | Article Page 54   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/4-basic-questions-to-ask-about-medicare-part-d-coverage.html                                             | Article Page 55   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-and-durable-medical-equipment-dme.html                                                          | Article Page 56   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-is-the-medicare-annual-enrollment-period.html                                                       | Article Page 57   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-if-i-missed-my-initial-enrollment-period.html                                                       | Article Page 58   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/can-you-switch-between-original-medicare-and-medicare-advantage-during-the-annual-enrollment-period.html | Article Page 59   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-individuals-who-divorced-widowed.html                                                           | Article Page 60   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/2-ways-to-prescription-drug-coverage.html                                                                | Article Page 61   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/which-vaccines-does-medicare-cover.html                                                                  | Article Page 62   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-mistakes-that-could-be-costly.html                                                              | Article Page 63   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/5-savvy-shopper-tips-help-get-medicare.html                                                              | Article Page 64   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/good-reasons-to-shop-for-a-new-medicare-plan.html                                                        | Article Page 65   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/should-i-get-part-b-if-im-working-past-65.html                                                           | Article Page 66   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/turn-65-retire-sign-up-for-medicare-or-not.html                                                          | Article Page 67   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/aep-change-or-renew.html                                                                                 | Article Page 68   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/the-difference-between-medicare-hmo-and-ppo-plans.html                                                   | Article Page 69   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/7-inside-tips-to-help-you-make-a-smooth-move-to-medicare.html                                            | Article Page 70   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-plan-annual-notice-of-change-what-to-look-for.html                                              | Article Page 71   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/understanding-your-medicare-plan.html                                                                    | Article Page 72   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/heart-healthy-help-medicare.html                                                                         | Article Page 73   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-coverage-for-same-sex-couples.html                                                              | Article Page 74   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/7-popular-medicare-questions-asked-during-national-medicare-education-week.html                          | Article Page 75   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-s-the-difference-between-medicare-and-medicaid.html                                                 | Article Page 76   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/6-point-checklist-to-rate-your-new-medicare-advantage-plan.html                                          | Article Page 77   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/how-to-evaluate-medicare-plan-costs.html                                                                 | Article Page 78   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/whats-the-difference-between-a-skilled-nursing-facility-and-a-nursing-home.html                          | Article Page 79   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/how-avoid-paying-more-prescription-drug-coverage.html                                                    | Article Page 80   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-can-i-do-during-the-medicare-advantage-open-enrollment-period.html                                  | Article Page 81   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/how-to-appeal-a-medicare-decision.html                                                                   | Article Page 82   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/replacing-your-medicare-card-just-got-a-whole-lot-easier.html                                            | Article Page 83   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-is-a-tiered-formulary-and-what-does-it-mean-for-me.html                                             | Article Page 84   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/good-news-medicare-part-b-covers-cataract-surgery.html                                                   | Article Page 85   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/3-ways-to-dispose-of-your-old-unused-medications-safely.html                                             | Article Page 86   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-telehealth-services-does-medicare-offer.html                                                        | Article Page 87   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/10-tips-choosing-primary-care-doctor.html                                                                | Article Page 88   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/how-often-should-a-woman-over-65-have-a-pap-smear.html                                                   | Article Page 89   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-coverage-for-inpatient-rehabilitation.html                                                      | Article Page 90   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/home-health-care-those-medicare-who-cant-leave-home.html                                                 | Article Page 91   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/4-assistance-programs-could-help-pay-your-medicare-costs.html                                            | Article Page 92   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-transportation-services.html                                                                    | Article Page 93   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/does-medicare-cover-melanoma-screenings.html                                                             | Article Page 94   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/guia-paso-paso-para-inscribirse-en-medicare-los-65-anos.html                                             | Article Page 95   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/avoid-sticker-shock-medicare-billing.html                                                                | Article Page 96   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/how-to-become-a-medicare-authorized-representative.html                                                  | Article Page 97   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/reasons-you-should-schedule-an-annual-medicare-wellness-visit.html                                       | Article Page 98   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/does-medicare-cover-allergy-testing.html                                                                 | Article Page 99   | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/copd-medicare.html                                                                                       | Article Page 100  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/does-medicare-cover-home-blood-pressure-monitors.html                                                    | Article Page 101  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/dual-special-needs-plans.html                                                                            | Article Page 102  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-part-b-may-not-cover-hearing-aid-part-c-might.html                                              | Article Page 103  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/does-medicare-part-a-cost-anything.html                                                                  | Article Page 104  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-does-medicare-cover-after-a-stroke.html                                                             | Article Page 105  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/parte-a-de-medicare-conceptos-basicos.html                                                               | Article Page 106  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/2-ways-save-on-blood-sugar-test-strips.html                                                              | Article Page 107  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-coverage-for-outpatient-rehabilitation-therapy.html                                             | Article Page 108  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/are-glaucoma-screenings-covered-by-medicare.html                                                         | Article Page 109  | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-coverage-for-prostate-cancer-screening.html                                                     | Article Page  110 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-parte-c-conceptos-basicos.html                                                                  | Article Page  111 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/how-prepare-your-medicare-wellness-visit.html                                                            | Article Page  112 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-part-c-basics.html                                                                              | Article Page  113 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-memo-what-are-advance-directives.html                                                           | Article Page  114 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/does-medicare-cover-a-colonoscopy.html                                                                   | Article Page  115 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/4-types-of-medicare-savings-programs-and-what-they-cover.html                                            | Article Page  116 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-is-the-medicare-advantage-open-enrollment-period.html                                               | Article Page  117 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/parte-b-de-medicare-conceptos-basicos.html                                                               | Article Page  118 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/colon-cancer-screening-tests-without-the-ouch.html                                                       | Article Page  119 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/does-medicare-cover-diabetes-prevention-program.html                                                     | Article Page  120 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-is-co-insurance.html                                                                                | Article Page  121 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/does-medicare-cover-blood-tests-for-cholesterol.html                                                     | Article Page  122 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/how-to-save-on-prescription-drugs-with-medicare.html                                                     | Article Page  123 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/whats-the-difference-between-a-physical-exam-and-a-medicare-wellness-visit.html                          | Article Page  124 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/are-you-living-with-chronic-heart-failure.html                                                           | Article Page  125 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/will-medicare-cover-a-cpap-machine.html                                                                  | Article Page  126 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/how-much-does-medicare-part-b-cost.html                                                                  | Article Page  127 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/got-coverage-for-the-new-year.html                                                                       | Article Page  128 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-is-a-transition-refill.html                                                                         | Article Page  129 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/cual-es-la-diferencia-entre-medicare-y-medicaid.html                                                     | Article Page  130 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/parte-d-de-medicare-conceptos-basicos.html                                                               | Article Page  131 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/does-medicare-cover-emergency-room-visits.html                                                           | Article Page  132 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/getting-a-knee-replaced-with-Medicare.html                                                               | Article Page  133 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/cuatro-programas-de-asistencia-para-pagar-sus-costos-de-medicare.html                                    | Article Page  134 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/does-medicare-cover-a-chiropractor.html                                                                  | Article Page  135 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-is-the-medicare-part-d-coverage-gap.html                                                            | Article Page  136 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-is-a-pdp-prescription-drug-plan.html                                                                | Article Page  137 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-beneficiaries-needing-hospice-care-may-be-covered.html                                          | Article Page  138 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-part-b-basics.html                                                                              | Article Page  139 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/new-to-medicare-schedule-your-welcome-to-medicare-visit.html                                             | Article Page  140 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-part-benefit-periods-deductibles.html                                                           | Article Page  141 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-part-d-basics.html                                                                              | Article Page  142 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-and-your-private-medical-information.html                                                       | Article Page  143 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-part-a-the-basics.html                                                                          | Article Page  144 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-coverage-for-cancer-screenings-chemo-and-radiation.html                                         | Article Page  145 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/4surefire-tips-for-picking-a-medicare-plan-that-fits-your-health-needs-and-budget.html                   | Article Page  146 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-part-d-costs-you-may-not-know-about.html                                                        | Article Page  147 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/how-to-compare-medicare-advantage-plan-costs.html                                                        | Article Page  148 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/new-medicare-follow-checklist-successful-start.html                                                      | Article Page  149 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/decoding-medicare.html                                                                                   | Article Page  150 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-medicare-medical-savings-account-plan.html                                                          | Article Page  151 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/what-will-medicare-cost.html                                                                             | Article Page  152 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/retiring-what-to-know-about-medicare.html                                                                | Article Page  153 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/medicare-and-cobra.html                                                                                  | Article Page  154 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/special-enrollment-for-medicare-when-working-past-65.html                                                | Article Page  155 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
#      | UHC  | Alabama  | medicare-articles/what-will-medicare-cost-in-2020.html                                                                     | Article Page  156 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/hsas-and-medicare.html                                                                                   | Article Page  157 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
      | UHC  | Alabama  | medicare-articles/are-medicare-premiums-based-on-income.html                                                               | Article Page  158 | (//*[contains(@class,'callus')]//*[contains(@class,'tel tfn')])[3] | true    | https://www.myuhcagent.com/ |
